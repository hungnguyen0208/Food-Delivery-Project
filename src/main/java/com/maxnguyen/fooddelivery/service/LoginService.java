package com.maxnguyen.fooddelivery.service;

import com.maxnguyen.fooddelivery.dto.UserDto;
import com.maxnguyen.fooddelivery.entity.Roles;
import com.maxnguyen.fooddelivery.entity.Users;
import com.maxnguyen.fooddelivery.service.imp.LoginServiceImp;
import com.maxnguyen.fooddelivery.payload.request.SignUpRequest;
import com.maxnguyen.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
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

    @Override
    public boolean checkLogin(String username, String password) {
        Users users = userRepository.findByUserName(username);

        return passwordEncoder.matches(password, users.getPassword());
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {

        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());

        Users users = new Users();
        users.setFullname(signUpRequest.getFullname());
        users.setUserName(signUpRequest.getEmail());

        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        users.setPassword(encodedPassword);
        users.setRoles(roles);

        try {
            userRepository.save(users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
