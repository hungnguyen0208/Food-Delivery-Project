package com.maxnguyen.fooddelivery.repository;

import com.maxnguyen.fooddelivery.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
}
