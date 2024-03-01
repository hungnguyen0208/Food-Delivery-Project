package com.maxnguyen.fooddelivery.security;

import com.maxnguyen.fooddelivery.entity.Users;
import com.maxnguyen.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUserName(username);
        if (users == null) {
            throw new UsernameNotFoundException("Username does not exist");
        }
        return new User(username, users.getPassword(), new ArrayList<>());
    }
}
