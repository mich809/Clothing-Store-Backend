package com.CaridadMichael.ClothingStore.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CaridadMichael.ClothingStore.model.product.Product;
import com.CaridadMichael.ClothingStore.model.user.UserAccount;
import com.CaridadMichael.ClothingStore.service.product.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@MutationMapping
	public Product createProduct(@Argument Product product) {
		return productService.createProduct(product);
		
	}
	
	@MutationMapping
	public void deleteProduct(@Argument Long id) {
		productService.deleteProduct(id);
		
	}

	@QueryMapping
	public Iterable <Product> getAllProducts() {
		return productService.getAllProducts();
		
	}
	
	

}
