package com.maxnguyen.fooddelivery.service;

import com.maxnguyen.fooddelivery.entity.*;
import com.maxnguyen.fooddelivery.entity.keys.KeyOrderItem;
import com.maxnguyen.fooddelivery.payload.request.OrderRequest;
import com.maxnguyen.fooddelivery.repository.OrderItemRepository;
import com.maxnguyen.fooddelivery.repository.OrderRepository;
import com.maxnguyen.fooddelivery.service.imp.OrderServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService implements OrderServiceImp {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public boolean insertOrder(OrderRequest orderRequest) {
        try{
            Users users = new Users();
            users.setId(orderRequest.getUserId());

            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getRestId());

            Orders orders = new Orders();
            orders.setUsers(users);
            orders.setRestaurant(restaurant);

            orderRepository.save(orders);

            List<OrderItem> items = new ArrayList<>();

            for (int idFood : orderRequest.getFoodIds()){
                Food food = new Food();
                food.setId(idFood);

                OrderItem orderItem = new OrderItem();
                KeyOrderItem keyOrderItem = new KeyOrderItem(orders.getId(), idFood);
                orderItem.setKeyOrderItem(keyOrderItem);

                items.add(orderItem);
            }

            orderItemRepository.saveAll(items);
            return true;

        }catch (Exception e){
            System.out.println("Error insert oder "+ e.getMessage());
            return false;
        }
    }
}
