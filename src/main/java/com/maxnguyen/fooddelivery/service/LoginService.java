package com.maxnguyen.fooddelivery.service;

import com.maxnguyen.fooddelivery.dto.UserDto;
import com.maxnguyen.fooddelivery.entity.Users;
import com.maxnguyen.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    public List<UserDto> getAllUser(){
        List<Users> listUser = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (Users users: listUser){

            UserDto userDto = new UserDto();
            userDto.setId(users.getId());
            userDto.setUserName(users.getUserName());
            userDto.setFullname(users.getFullname());
            userDto.setPassword(users.getPassword());

            userDtoList.add(userDto);
        }
        return userDtoList;
    }

}
