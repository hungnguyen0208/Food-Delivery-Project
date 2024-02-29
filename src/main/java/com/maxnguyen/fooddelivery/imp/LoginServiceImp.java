package com.maxnguyen.fooddelivery.imp;

import com.maxnguyen.fooddelivery.dto.UserDto;
import com.maxnguyen.fooddelivery.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {
    List<UserDto> getAllUser();
    boolean checkLogin(String username, String password);
    boolean addUser(SignUpRequest signUpRequest);

}
