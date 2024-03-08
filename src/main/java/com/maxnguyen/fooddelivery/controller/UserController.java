package com.maxnguyen.fooddelivery.controller;

import com.maxnguyen.fooddelivery.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;
    @GetMapping("")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userServiceImp.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
