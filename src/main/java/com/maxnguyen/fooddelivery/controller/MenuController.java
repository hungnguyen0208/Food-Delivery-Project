package com.maxnguyen.fooddelivery.controller;

import com.maxnguyen.fooddelivery.payload.ResponseData;
import com.maxnguyen.fooddelivery.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuServiceImp menuServiceImp;
    @PostMapping("")
    public ResponseEntity<?> createMenu(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam boolean isFreeShip,
            @RequestParam String timeShip,
            @RequestParam double price,
            @RequestParam int cate_Id
    ){
        ResponseData responseData = new ResponseData();
        boolean isSuccessful = menuServiceImp.createMenu(file, title, isFreeShip, timeShip, price, cate_Id);
        responseData.setData(isSuccessful);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
