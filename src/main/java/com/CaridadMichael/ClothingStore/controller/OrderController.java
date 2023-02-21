package com.CaridadMichael.ClothingStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CaridadMichael.ClothingStore.model.UserOrder;
import com.CaridadMichael.ClothingStore.service.OrderService;

@RestController
public class OrderController {
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	

	public UserOrder createOrder(@Argument int userID, @Argument int productID , @Argument UserOrder userOrder) {
		return orderService.createOrder(userID, productID ,userOrder);
		
	}
//	
//	public void updateOrder(@Argument int userID , @Argument int orderID , @Argument int productID) {
//		orderService.updateOrder(userID,orderID,productID);
//	}

}
