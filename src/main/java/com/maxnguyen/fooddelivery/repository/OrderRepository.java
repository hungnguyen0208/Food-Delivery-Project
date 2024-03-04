package com.maxnguyen.fooddelivery.repository;

import com.maxnguyen.fooddelivery.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
