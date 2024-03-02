package com.maxnguyen.fooddelivery.controller;

import com.maxnguyen.fooddelivery.service.imp.LoginServiceImp;
import com.maxnguyen.fooddelivery.payload.ResponseData;
import com.maxnguyen.fooddelivery.payload.request.LoginRequest;
import com.maxnguyen.fooddelivery.payload.request.SignUpRequest;
import com.maxnguyen.fooddelivery.utils.JwtUtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/client")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;

    @PostMapping("/login")
    public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest){
        ResponseData responseData = new ResponseData();

        if (loginServiceImp.checkLogin(loginRequest.getUsername(), loginRequest.getPassword())){
            String token = jwtUtilsHelper.generateToken(loginRequest.getUsername());

            responseData.setData(token);
        } else {
            responseData.setData("");
            responseData.setSuccessful(false);
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
