package com.CaridadMichael.ClothingStore.model.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserPayment {
	@Id
	private long id;
	
	private String paymentType;
	private String provider;
	private String expireDate;
	private String cardNumber;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	@MapsId
    private UserAccount userAccount;

}
