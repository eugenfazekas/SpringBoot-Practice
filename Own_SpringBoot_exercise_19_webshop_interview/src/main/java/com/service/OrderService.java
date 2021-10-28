package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Order;
import com.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private UserService userService;	
	public OrderService(OrderRepository orderRepository, UserService userService) {
		this.orderRepository = orderRepository;
		this.userService = userService;
	}

	public String createOrder(Order order) {
		userService.updateUsesOrdersCount(order.getUserid());
		return orderRepository.createOrder(order);
	}
	
	public List<Order> findOrders() {
		return orderRepository.findOrders();
	}
	
}
