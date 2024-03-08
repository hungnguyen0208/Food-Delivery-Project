package com.maxnguyen.fooddelivery.service;

import com.maxnguyen.fooddelivery.dto.UserDto;
import com.maxnguyen.fooddelivery.entity.Roles;
import com.maxnguyen.fooddelivery.entity.Users;
import com.maxnguyen.fooddelivery.repository.RoleRepository;
import com.maxnguyen.fooddelivery.repository.UserRepository;
import com.maxnguyen.fooddelivery.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUser() {
        List<Users> usersList = userRepository.findAll();

        List<UserDto> userDtoList = new ArrayList<>();

        for (Users users : usersList){
            UserDto userDto = new UserDto();
            userDto.setId(users.getId());
            userDto.setUserName(users.getUserName());
            userDto.setFullname(users.getFullname());
            userDto.setPassword(users.getPassword());
            userDto.setRole(users.getRoles().getRoleName());
            userDto.setCreateDate(users.getCreateDate());
            userDtoList.add(userDto);
        }

        return userDtoList;
    }
}
