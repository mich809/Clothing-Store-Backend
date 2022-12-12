package com.CaridadMichael.ClothingStore.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CaridadMichael.ClothingStore.model.user.UserAccount;
import com.CaridadMichael.ClothingStore.service.product.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	

	@MutationMapping
	public String createCategory(@Argument String category) {
		return productService.createCategory(category);
		
	}
	
	@QueryMapping
	public String getProductCategory(@Argument String category) {
		return productService.getProductCategory();
	}
	
	@QueryMapping
	public String getAllProductCategories() {
		return productService.getAllProductCategories();
	}

}
