package com.CaridadMichael.ClothingStore.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CaridadMichael.ClothingStore.repository.product.ProductCategoryRepo;
import com.CaridadMichael.ClothingStore.repository.product.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductCategoryRepo productCategoryRepo;

	public String createCategory() {
		return "create";
	}

	public String getProductCategory() {
		return "get category";
	}

	public String getAllProductCategories() {
		return "get all product category";

	}

	public String deleteCategory() {
		return "deleted";
	}

}
