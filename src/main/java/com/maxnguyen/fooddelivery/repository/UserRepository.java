package com.maxnguyen.fooddelivery.repository;

import com.maxnguyen.fooddelivery.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findByUserNameAndPassword(String username, String password);
}
