package com.maxnguyen.fooddelivery.service.imp;

import com.maxnguyen.fooddelivery.dto.RestaurantDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantServiceImp {
    boolean createRestaurant(MultipartFile file,
                             String title,
                             String subtitle,
                             String description,
                             boolean isFreeShip,
                             String address,
                             String openDate);
    List<RestaurantDto> getRestaurantList();
}
