package com.CaridadMichael.ClothingStore.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CaridadMichael.ClothingStore.model.product.Product;
import com.CaridadMichael.ClothingStore.repository.product.ProductCategoryRepo;
import com.CaridadMichael.ClothingStore.repository.product.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductCategoryRepo productCategoryRepo;

	public String createCategory(String category) {
		return category;
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
		if(productRepo.existsById(id)) {
			productRepo.deleteById(id);
		}
		
	}

	public Iterable<Product> getAllProducts() {
		 return productRepo.findAll();
		
	}

}
