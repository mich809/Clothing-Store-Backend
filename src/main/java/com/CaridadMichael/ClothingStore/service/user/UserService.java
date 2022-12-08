package com.CaridadMichael.ClothingStore.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.CaridadMichael.ClothingStore.model.user.UserAccount;
import com.CaridadMichael.ClothingStore.model.user.UserAddress;
import com.CaridadMichael.ClothingStore.model.user.UserPayment;
import com.CaridadMichael.ClothingStore.repository.user.UserAccountRepo;
import com.CaridadMichael.ClothingStore.repository.user.UserAddressRepo;
import com.CaridadMichael.ClothingStore.repository.user.UserPaymentRepo;

@Service
public class UserService {

	@Autowired
	private UserAccountRepo userAccountRepo;

	@Autowired
	private UserAddressRepo userAddressRepo;

	@Autowired
	private UserPaymentRepo userPaymentRepo;

	public String createUserAccount(String email, String password) {
		if (userAccountExists(email)) {
			return "User" + email + " already  exist";

		}
		UserAccount user = new UserAccount(email, password);
		userAccountRepo.save(user);
		return "User " + email + " created";

	}

	public String deleteUserAccount(String email) {
		userAccountRepo.deleteByEmail(email);
		return "User " + email + " deleted";

	}

	public UserAccount getUserAccount(String email) {
		return userAccountRepo.findByEmail(email);
	}

	public void addUserAddress(String email, UserAddress userAddress) {

		UserAccount userAccount = getUserAccount(email);
		userAccount.setAddress(userAddress);
		userAddress.setUserAccount(userAccount);
		userAccountRepo.save(userAccount);

	}

	public void deleteUserAddress(Long id) {
		userAddressRepo.deleteById(id);
		

	}
	public Optional<UserAddress> getUserAddress(Long id) {

		return Optional.ofNullable(userAddressRepo.findById(id).orElseThrow(null));
	}

	public Optional<UserPayment> getUserPayment(Long id) {

		return Optional.ofNullable(userPaymentRepo.findById(id).orElseThrow(null));
	}

	private boolean userAccountExists(String email) {
		return userAccountRepo.existsByEmail(email);
	}

	public void addUserPayment(String email, UserPayment userPayment) {
		UserAccount userAccount = getUserAccount(email);
		userAccount.setUserPayment(userPayment);
		userPayment.setUserAccount(userAccount);
		userAccountRepo.save(userAccount);
		
	}

	public void deleteUserPayment(Long id) {
		userPaymentRepo.deleteById(id);
	}
}
