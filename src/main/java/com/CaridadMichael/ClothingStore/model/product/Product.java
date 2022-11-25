package com.CaridadMichael.ClothingStore.model.product;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private long id;
	
	private String name;
	private String description;
	private String sku;
	private float price;
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private LocalDateTime deletedAt;
	
	
	

}
