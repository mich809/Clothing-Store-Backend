package com.CaridadMichael.ClothingStore.model.product;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.CaridadMichael.ClothingStore.model.user.UserAddress;

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
