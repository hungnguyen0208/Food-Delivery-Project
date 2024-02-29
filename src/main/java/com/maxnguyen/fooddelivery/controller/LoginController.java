package com.maxnguyen.fooddelivery.controller;

import com.maxnguyen.fooddelivery.dto.UserDto;
import com.maxnguyen.fooddelivery.entity.Users;
import com.maxnguyen.fooddelivery.repository.UserRepository;
import com.maxnguyen.fooddelivery.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/signin")
    public ResponseEntity<?> signin(){
        return new ResponseEntity<>(loginService.getAllUser(), HttpStatus.OK);
    }
}
