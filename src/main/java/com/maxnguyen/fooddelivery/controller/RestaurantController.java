package com.maxnguyen.fooddelivery.controller;

import com.maxnguyen.fooddelivery.payload.ResponseData;
import com.maxnguyen.fooddelivery.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    FileServiceImp fileServiceImp;

    @PostMapping()
    public ResponseEntity<?> createRestaurant(@RequestParam MultipartFile file){
        ResponseData responseData = new ResponseData();
        boolean isSuccessful = fileServiceImp.saveFile(file);
        responseData.setData(isSuccessful);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getRestaurantFile(@PathVariable String filename){

        Resource resource = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }
}
