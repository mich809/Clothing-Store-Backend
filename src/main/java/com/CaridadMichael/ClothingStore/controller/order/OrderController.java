package com.CaridadMichael.ClothingStore.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.RestController;

import com.CaridadMichael.ClothingStore.model.order.UserOrder;
import com.CaridadMichael.ClothingStore.service.order.OrderService;

@RestController
public class OrderController {
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public UserOrder createOrder(@Argument UserOrder userOrder) {
		return orderService.createOrder(userOrder);
		
	}
//	
//	public void updateOrder(@Argument int userID , @Argument int orderID , @Argument int productID) {
//		orderService.updateOrder(userID,orderID,productID);
//	}

}
