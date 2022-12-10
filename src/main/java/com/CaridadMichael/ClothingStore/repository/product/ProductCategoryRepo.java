package com.CaridadMichael.ClothingStore.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CaridadMichael.ClothingStore.model.product.ProductCategory;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long>{
	

}
