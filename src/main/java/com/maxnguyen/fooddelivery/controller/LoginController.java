package com.maxnguyen.fooddelivery.controller;

import com.maxnguyen.fooddelivery.imp.LoginServiceImp;
import com.maxnguyen.fooddelivery.payload.ResponseData;
import com.maxnguyen.fooddelivery.payload.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password){
        ResponseData responseData = new ResponseData();

        if (loginServiceImp.checkLogin(username, password)){
            responseData.setData(true);
        } else {
            responseData.setData(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        ResponseData responseData = new ResponseData();

        responseData.setData(loginServiceImp.addUser(signUpRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
