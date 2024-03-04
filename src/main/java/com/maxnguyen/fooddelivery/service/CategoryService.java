package com.maxnguyen.fooddelivery.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maxnguyen.fooddelivery.dto.CategoryDto;
import com.maxnguyen.fooddelivery.dto.MenuDto;
import com.maxnguyen.fooddelivery.entity.Category;
import com.maxnguyen.fooddelivery.entity.Food;
import com.maxnguyen.fooddelivery.repository.CategoryRepository;
import com.maxnguyen.fooddelivery.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RedisTemplate redisTemplate;

    private Gson gson = new Gson();
    @Override
    public List<CategoryDto> getCategoryHomepage() {

        String dataRedis = (String) redisTemplate.opsForValue().get("category");
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        if(dataRedis == null){

            PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("id"));
            Page<Category> categoryList = categoryRepository.findAll(pageRequest);

            for (Category data : categoryList){
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(data.getId());
                categoryDto.setName(data.getCategoryName());

                List<MenuDto> menuDtos = new ArrayList<>();
                for (Food dataFood : data.getFoodList()){
                    MenuDto menuDto = new MenuDto();
                    menuDto.setId(dataFood.getId());
                    menuDto.setTitle(dataFood.getTitle());
                    menuDto.setFreeShip(dataFood.isFreeShip());
                    menuDto.setImage(dataFood.getImage());

                    menuDtos.add(menuDto);
                }

                categoryDto.setMenus(menuDtos);

                categoryDtoList.add(categoryDto);
            }
            String dataJson = gson.toJson(categoryDtoList);
            redisTemplate.opsForValue().set("category", dataJson);
        }else {
            Type listType = new TypeToken<List<CategoryDto>>(){}.getType();
            categoryDtoList = gson.fromJson(dataRedis,listType);

        }

        return categoryDtoList;
    }
}
