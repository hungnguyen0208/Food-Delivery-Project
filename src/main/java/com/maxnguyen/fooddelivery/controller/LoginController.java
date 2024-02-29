package com.maxnguyen.fooddelivery.controller;

import com.maxnguyen.fooddelivery.entity.Users;
import com.maxnguyen.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/signin")
    public ResponseEntity<?> signin(){

        List<Users> listUser = userRepository.findAll();

        for (Users users: listUser){
            System.out.println(users.getFullname());
        }

        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }
}
