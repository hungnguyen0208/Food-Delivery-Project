package com.maxnguyen.fooddelivery.repository;

import com.maxnguyen.fooddelivery.entity.OrderItem;
import com.maxnguyen.fooddelivery.entity.keys.KeyOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, KeyOrderItem> {
}
