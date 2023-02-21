package com.CaridadMichael.ClothingStore.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CaridadMichael.ClothingStore.model.UserOrder;
import com.CaridadMichael.ClothingStore.repository.OrderRepo;
import com.CaridadMichael.ClothingStore.repository.UserAccountRepo;

@Service
public class OrderService {

	private OrderRepo orderRepo;
	
	private UserAccountRepo userAccountRepo;

	@Autowired
	public OrderService(OrderRepo orderRepo , UserAccountRepo userAccountRepo) {
		this.orderRepo = orderRepo;
		this.userAccountRepo = userAccountRepo;
	}

	public UserOrder createOrder(int userID, int productID ,UserOrder order) {
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
