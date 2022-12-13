package com.CaridadMichael.ClothingStore.repository.product;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.CaridadMichael.ClothingStore.model.product.Product;

public interface ProductRepo  extends PagingAndSortingRepository<Product, Long> {

}
