package com.CaridadMichael.ClothingStore.service.product;

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

		productRepo.save(newProduct);
		return newProduct;
	}

	public void deleteProduct(Long id) {
		if (productRepo.existsById(id)) {
			productRepo.deleteById(id);
		}

	}

	public Iterable<Product> getAllProducts() {
		return productRepo.findAll();

	}
	
	public Page<Product> getAllProductsPaged (int page , int size){
		PageRequest pageRequest = PageRequest.of(page, size);
		return productRepo.findAll(pageRequest);
		
	}

}
