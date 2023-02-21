package com.CaridadMichael.ClothingStore.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.CaridadMichael.ClothingStore.model.UserOrder;

public interface OrderRepo extends PagingAndSortingRepository<UserOrder, Long> {

}
