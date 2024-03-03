package com.maxnguyen.fooddelivery.controller;

import com.maxnguyen.fooddelivery.payload.ResponseData;
import com.maxnguyen.fooddelivery.service.imp.FileServiceImp;
import com.maxnguyen.fooddelivery.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuServiceImp menuServiceImp;
    @Autowired
    FileServiceImp fileServiceImp;
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

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getMenuFile(@PathVariable String filename){

        Resource resource = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }
}
