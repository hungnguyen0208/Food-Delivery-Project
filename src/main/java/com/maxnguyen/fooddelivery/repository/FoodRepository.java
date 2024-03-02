package com.maxnguyen.fooddelivery.repository;

import com.maxnguyen.fooddelivery.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
