package com.CaridadMichael.ClothingStore.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.CaridadMichael.ClothingStore.service.order.OrderService;

@RestController
public class OrderController {
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

}
