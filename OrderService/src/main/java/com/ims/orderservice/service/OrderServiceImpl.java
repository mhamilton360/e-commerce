package com.ims.orderservice.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.ims.orderservice.entity.Order;
import com.ims.orderservice.external.client.ProductService;
import com.ims.orderservice.model.OrderRequest;
import com.ims.orderservice.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	private ProductService productService;
	
	public OrderServiceImpl(
			OrderRepository orderRepository,
			ProductService productService) {
		
		this.orderRepository = orderRepository;
		this.productService = productService;
	}
	
	@Override
	public long placeOrder(OrderRequest orderRequest) {
		// Order Entity - Save the data with Status Order Created
		// Product Service - Block Products (Reduce the Quantity)
		// Payment Service - Payments -> Success -> COMPLETE, Else CANCELLED
		
		log.info("Placing Order Request: {}", orderRequest);
		
		productService.reduceQuantity(
				orderRequest.getProductId(), 
				orderRequest.getQuantity());
		
		log.info("Creating Order with Status CREATED");
		
		Order order = Order.builder()
				.amount(orderRequest.getTotalAmount())
				.orderStatus("CREATED")
				.productId(orderRequest.getProductId())
				.orderDate(Instant.now())
				.quantity(orderRequest.getQuantity())
				.build();
		
		order = orderRepository.save(order);
		
		log.info("Order placed successfully with Order Id: {}", order.getId());
		
		return order.getId();
	}

}
