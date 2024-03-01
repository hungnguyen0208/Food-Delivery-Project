package com.maxnguyen.fooddelivery.service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface RestaurantServiceImp {
    boolean createRestaurant(MultipartFile file,
                             String title,
                             String subtitle,
                             String description,
                             boolean isFreeShip,
                             String address,
                             String openDate);
}
