package com.CaridadMichael.ClothingStore.model.user;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique=true)
	private String email;
	
	private String password;	
	
	@OneToOne(mappedBy="userAccount", fetch = FetchType.LAZY)
    private UserAddress userAddress;	

	public UserAccount() {}
	
	public UserAccount(String email , String password) {
		super();
		this.setEmail(email);
		this.password = password;
		
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
	
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	
	public UserAddress getUserAddress() {
		return this.userAddress;
	}
	

}
