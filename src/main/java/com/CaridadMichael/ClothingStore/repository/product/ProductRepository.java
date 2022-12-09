package com.CaridadMichael.ClothingStore.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CaridadMichael.ClothingStore.model.product.Product;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}
