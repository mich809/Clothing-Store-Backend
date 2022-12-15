package com.CaridadMichael.ClothingStore.controller.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CaridadMichael.ClothingStore.model.product.Product;
import com.CaridadMichael.ClothingStore.service.product.ProductService;

@RestController
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
		
	}
	
	@MutationMapping
	public Product createProduct(@Argument Product product) {
		return productService.createProduct(product);

	}

	@MutationMapping
	public void deleteProduct(@Argument Long id) {
		productService.deleteProduct(id);

	}

	@QueryMapping
	public Iterable<Product> getAllProducts() {
		return productService.getAllProducts();

	}
	
	@QueryMapping
	public Optional<Product> getProduct(@Argument Long id){
		return productService.getProduct(id);
	}

	@QueryMapping
	public Page<Product> getAllProductsPaged(@Argument int page, @Argument int size) {
		return productService.getAllProductsPaged(page, size);

	}
	
	@QueryMapping
	public Page<Product> getAllProductsByAscendingPrice(@Argument int page, @Argument int size) {
		return productService.getAllProductsByAscendingPrice(page, size);

	}
	
	@QueryMapping
	public Page<Product> getAllProductsByDescendingPrice(@Argument int page, @Argument int size) {
		return productService.getAllProductsByDescendingPrice(page, size);

	}
	
	@QueryMapping
	public Page<Product> getAllProductsByNewest(@Argument int page, @Argument int size) {
		return productService.getAllProductsByNewest(page, size);

	}

}
