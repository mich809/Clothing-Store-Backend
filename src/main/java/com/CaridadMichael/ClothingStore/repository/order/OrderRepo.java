package com.CaridadMichael.ClothingStore.repository.order;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.CaridadMichael.ClothingStore.model.order.UserOrder;

public interface OrderRepo extends PagingAndSortingRepository<UserOrder, Long> {

}
