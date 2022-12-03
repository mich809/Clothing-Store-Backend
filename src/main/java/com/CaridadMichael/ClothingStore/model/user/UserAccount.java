package com.CaridadMichael.ClothingStore.model.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String email;

	private String password;

	@OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL , orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private UserAddress address;

	@OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL , orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private UserPayment userPayment;

	public UserAccount() {
	}

	public UserAccount(String email, String password) {
		super();
		this.setEmail(email);
		this.password = password;

	}

	public UserPayment getUserPayment() {
		return userPayment;
	}

	public void setUserPayment(UserPayment userPayment) {
		this.userPayment = userPayment;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public void setUserAddress(UserAddress userAddress) {
//		this.userAddress = userAddress;
//	}
//	
//	public UserAddress getUserAddress() {
//		return this.userAddress;
//	}

}
