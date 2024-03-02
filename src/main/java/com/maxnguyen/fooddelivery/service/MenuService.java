package com.maxnguyen.fooddelivery.service;

import com.maxnguyen.fooddelivery.entity.Category;
import com.maxnguyen.fooddelivery.entity.Food;
import com.maxnguyen.fooddelivery.repository.FoodRepository;
import com.maxnguyen.fooddelivery.service.imp.FileServiceImp;
import com.maxnguyen.fooddelivery.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MenuService implements MenuServiceImp {

    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    FoodRepository foodRepository;

    @Override
    public boolean createMenu(MultipartFile file, String title, boolean isFreeShip, String timeShip, double price, int cate_Id) {
        boolean isCreateSuccessful = false;
        try{
            boolean isSaveFileSuccessful = fileServiceImp.saveFile(file);
            String filename = file.getOriginalFilename();
            if (isSaveFileSuccessful){
                Food food = new Food();
                food.setTitle(title);
                food.setImage(filename);
                food.setTimeShip(timeShip);
                food.setPrice(price);
                food.setFreeShip(isFreeShip);

                Category category = new Category();
                category.setId(cate_Id);

                food.setCategory(category);
                foodRepository.save(food);
                isCreateSuccessful = true;
            }
        }catch (Exception e){
            System.out.println("Fail to create restaurant: " + e.getMessage());
        }

        return isCreateSuccessful;
    }
}
