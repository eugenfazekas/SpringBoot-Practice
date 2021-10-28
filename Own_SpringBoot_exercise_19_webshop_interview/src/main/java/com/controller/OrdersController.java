package com.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Order;
import com.service.OrderService;

@RestController
public class OrdersController {

	
	private OrderService orderService;

	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(value = "/findAllOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> findOrders() {
		return orderService.findOrders();
	}
}
