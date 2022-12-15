package com.CaridadMichael.ClothingStore.model.order;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.CaridadMichael.ClothingStore.model.product.Product;

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int cost;
	@Column(name = "date_created")
	private LocalDate createdDate;
	@OneToMany
	private Set<Product> products;

}
