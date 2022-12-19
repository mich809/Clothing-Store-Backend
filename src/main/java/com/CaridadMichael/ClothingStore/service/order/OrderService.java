package com.CaridadMichael.ClothingStore.service.order;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CaridadMichael.ClothingStore.model.order.UserOrder;
import com.CaridadMichael.ClothingStore.repository.order.OrderRepo;

@Service
public class OrderService {

	private OrderRepo orderRepo;

	@Autowired
	public OrderService(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;
	}

	public UserOrder createOrder(UserOrder order) {
		UserOrder newOrder = new UserOrder();
		newOrder.setTotalCost(order.getTotalCost());
		newOrder.setCreatedDate(LocalDate.now());
		newOrder.setProducts(order.getProducts());
		
		return newOrder;

	}
//
//	public void updateOrder(int userID, int orderID, int productID) {
//		// TODO Auto-generated method stub
//
//	}

}
