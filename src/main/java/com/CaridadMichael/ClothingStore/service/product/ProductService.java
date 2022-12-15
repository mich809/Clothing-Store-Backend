package com.CaridadMichael.ClothingStore.service.product;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.CaridadMichael.ClothingStore.model.product.Product;
import com.CaridadMichael.ClothingStore.repository.product.ProductRepo;

@Service
public class ProductService {
	
	private ProductRepo productRepo;
	
	@Autowired
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
		
	}

	public Product createProduct(Product product) {
		Product newProduct = new Product();
		newProduct.setName(product.getName());
		newProduct.setDescription(product.getDescription());
		newProduct.setImage(product.getImage());
		newProduct.setPrice(product.getPrice());
		newProduct.setQuantity(product.getQuantity());
		newProduct.setLocalDate(LocalDate.now());

		productRepo.save(newProduct);
		return newProduct;
	}

	public void deleteProduct(Long id) {
		if (productRepo.existsById(id)) {
			productRepo.deleteById(id);
		}

	}
	
	public Optional<Product> getProduct(Long id) {
		if (productRepo.existsById(id)) {
			return productRepo.findById(id);
		}
		
		return null;
	}

	public Iterable<Product> getAllProducts() {
		return productRepo.findAll();

	}
	
	public Page<Product> getAllProductsPaged (int page , int size){
		PageRequest pageRequest = PageRequest.of(page, size);
		return productRepo.findAll(pageRequest);
		
	}
	
	public Page<Product> getAllProductsByAscendingPrice (int page , int size){
		PageRequest pageRequest = PageRequest.of(page, size);
		return productRepo.findAllByOrderByPriceAsc(pageRequest);
		
	}
	
	public Page<Product> getAllProductsByDescendingPrice (int page , int size){
		PageRequest pageRequest = PageRequest.of(page, size);
		return productRepo.findAllByOrderByPriceDesc(pageRequest);
		
	}

	public Page<Product> getAllProductsByNewest (int page , int size){
		PageRequest pageRequest = PageRequest.of(page, size);
		return productRepo.findAllByOrderByCreatedDateDesc(pageRequest);
		
	}
}
