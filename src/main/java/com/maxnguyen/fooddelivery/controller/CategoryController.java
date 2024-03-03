package com.maxnguyen.fooddelivery.controller;

import com.maxnguyen.fooddelivery.payload.ResponseData;
import com.maxnguyen.fooddelivery.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryServiceImp categoryServiceImp;
    @GetMapping("")
    public ResponseEntity<?> getCategoryHomepage(){
        ResponseData responseData = new ResponseData();

        responseData.setData(categoryServiceImp.getCategoryHomepage());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
