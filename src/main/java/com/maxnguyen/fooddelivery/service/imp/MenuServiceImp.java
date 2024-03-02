package com.maxnguyen.fooddelivery.service.imp;

import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {
    boolean createMenu(MultipartFile file, String title, boolean isFreeShip, String timeShip, double price, int cate_Id);
}
