package com.ims.orderservice.service;

import com.ims.orderservice.model.OrderRequest;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);
}
