package com.maxnguyen.fooddelivery.repository;

import com.maxnguyen.fooddelivery.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
