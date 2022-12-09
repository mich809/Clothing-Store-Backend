package com.CaridadMichael.ClothingStore.model.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.CaridadMichael.ClothingStore.model.user.UserAddress;

@Entity
public class ProductCategory {
	@Id
	private long id;
	private String name;
	private String description;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_category_id")
	private Set<Product> comments = new HashSet<>();

	public ProductCategory() {

	}

	public ProductCategory(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getComments() {
		return comments;
	}

	public void setComments(Set<Product> comments) {
		this.comments = comments;
	}

}
