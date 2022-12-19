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

	public Order() {
	}

	public Order(int cost, LocalDate createdDate, Set<Product> products) {
		super();
		this.cost = cost;
		this.createdDate = createdDate;
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
