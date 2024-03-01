package com.maxnguyen.fooddelivery.service;

import com.maxnguyen.fooddelivery.entity.Restaurant;
import com.maxnguyen.fooddelivery.repository.RestaurantRepository;
import com.maxnguyen.fooddelivery.service.imp.FileServiceImp;
import com.maxnguyen.fooddelivery.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean createRestaurant(MultipartFile file, String title, String subtitle, String description, boolean isFreeShip, String address, String openDate) {
        boolean isCreateSuccessful = false;
        try{
            boolean isSaveFileSuccessful = fileServiceImp.saveFile(file);
            if (isSaveFileSuccessful){
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDescription(description);
                restaurant.setIamge(file.getOriginalFilename());
                restaurant.setFreeShip(isFreeShip);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date opendate = simpleDateFormat.parse(openDate);
                restaurant.setOpenDate(opendate);
                restaurant.setAddress(address);

                restaurantRepository.save(restaurant);
                isCreateSuccessful = true;
            }
        }catch (Exception e){
            System.out.println("Fail to create restaurant: " + e.getMessage());
        }

        return isCreateSuccessful;
    }
}
