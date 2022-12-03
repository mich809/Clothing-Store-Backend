package com.CaridadMichael.ClothingStore.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.CaridadMichael.ClothingStore.model.user.UserAccount;
import com.CaridadMichael.ClothingStore.model.user.UserAddress;
import com.CaridadMichael.ClothingStore.repository.user.UserAccountRepo;
import com.CaridadMichael.ClothingStore.repository.user.UserAddressRepo;

@Service
public class UserService {

	@Autowired
	private UserAccountRepo userAccountRepo;
	
	@Autowired
	private UserAddressRepo userAddressRepo;

	

	public String createUser(String email, String password) {
		if (userAccountExists(email)) {
			return "User" + email + " already  exist";

		}
		UserAccount user = new UserAccount(email, password);
		userAccountRepo.save(user);
		return "User " + email + " created";

	}

	public UserAccount getUserAccount(String email) {
		return userAccountRepo.findByEmail(email);
	}

	private boolean userAccountExists(String email) {
		return userAccountRepo.existsByEmail(email);
	}

	public void addUserAddress(String email, UserAddress userAddress) {
		
		UserAccount userAccount = getUserAccount(email);
		userAccount.setAddress(userAddress);
		userAddress.setUserAccount(userAccount);
		userAccountRepo.save(userAccount);
		
		
	}

	public Optional<UserAddress> getUserAddress(Long id) {
		
		return userAddressRepo.findById(id);
	}

}
