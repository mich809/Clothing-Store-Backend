package com.CaridadMichael.ClothingStore.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CaridadMichael.ClothingStore.model.product.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
	

}
