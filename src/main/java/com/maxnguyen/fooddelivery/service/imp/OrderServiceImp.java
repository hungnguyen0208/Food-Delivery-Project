package com.maxnguyen.fooddelivery.service.imp;

import com.maxnguyen.fooddelivery.payload.request.OrderRequest;

public interface OrderServiceImp {
    boolean insertOrder(OrderRequest orderRequest);
}
