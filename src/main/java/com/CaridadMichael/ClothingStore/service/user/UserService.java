package com.CaridadMichael.ClothingStore.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CaridadMichael.ClothingStore.model.user.UserAccount;
import com.CaridadMichael.ClothingStore.model.user.UserAddress;
import com.CaridadMichael.ClothingStore.model.user.UserPayment;
import com.CaridadMichael.ClothingStore.repository.user.UserAccountRepo;
import com.CaridadMichael.ClothingStore.repository.user.UserAddressRepo;
import com.CaridadMichael.ClothingStore.repository.user.UserPaymentRepo;

@Service
public class UserService {

	private UserAccountRepo userAccountRepo;

	private UserAddressRepo userAddressRepo;

	private UserPaymentRepo userPaymentRepo;

	@Autowired
	public UserService(UserAccountRepo userAccountRepo, UserAddressRepo userAddressRepo,
			UserPaymentRepo userPaymentRepo) {

	}

	public String createUserAccount(String email, String password) {
		if (userAccountExists(email)) {
			return "User" + email + " already  exist";

		}
		UserAccount user = new UserAccount(email, password);
		userAccountRepo.save(user);
		return "User " + email + " created";

	}

	@Transactional
	public String deleteUserAccount(String email) {
		if (userAccountRepo.existsByEmail(email)) {
			userAccountRepo.deleteByEmail(email);
			return "User " + email + " deleted";

		}
		return "user " + email + " not found";

	}

	public UserAccount getUserAccount(String email) {
		return userAccountRepo.findByEmail(email);
	}

	public void addUserAddress(String email, UserAddress userAddress) {
		UserAccount userAccount = getUserAccount(email);
		userAccount.setUserAddress(userAddress);
		userAddress.setUserAccount(userAccount);
		userAccountRepo.save(userAccount);

	}

	public String deleteUserAddress(Long id) {
		if (userAddressRepo.existsById(id)) {
			userAddressRepo.deleteById(id);
			Optional<UserAccount> user = userAccountRepo.findById(id);
			if (user.isPresent()) {
				user.get().setUserAddress(null);
				userAccountRepo.save(user.get());
			}
			return "User address deleted";
		}

		return "User address not found";

	}

	public Optional<UserAddress> getUserAddress(Long id) {
		if (userAddressRepo.existsById(id)) {
			return userAddressRepo.findById(id);
		}

		return Optional.ofNullable(null);
	}

	public Optional<UserPayment> getUserPayment(Long id) {

		if (userPaymentRepo.existsById(id)) {
			return userPaymentRepo.findById(id);
		}

		return Optional.ofNullable(null);
	}

	public void addUserPayment(String email, UserPayment userPayment) {
		UserAccount userAccount = getUserAccount(email);
		userAccount.setUserPayment(userPayment);
		userPayment.setUserAccount(userAccount);
		userAccountRepo.save(userAccount);

	}

	public String deleteUserPayment(Long id) {
		if (userPaymentRepo.existsById(id)) {
			userPaymentRepo.deleteById(id);
			Optional<UserAccount> user = userAccountRepo.findById(id);
			if (user.isPresent()) {
				user.get().setUserPayment(null);
				userAccountRepo.save(user.get());
			}
			return "User payment deleted";
		}

		return "User payment not found";

	}

	private boolean userAccountExists(String email) {
		return userAccountRepo.existsByEmail(email);
	}

}
