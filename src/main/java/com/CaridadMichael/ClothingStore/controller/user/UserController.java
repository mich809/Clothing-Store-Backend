package com.CaridadMichael.ClothingStore.controller.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CaridadMichael.ClothingStore.model.user.UserAccount;
import com.CaridadMichael.ClothingStore.model.user.UserAddress;
import com.CaridadMichael.ClothingStore.model.user.UserPayment;
import com.CaridadMichael.ClothingStore.service.user.UserService;

@RestController
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;

	}

	@MutationMapping
	public String createUserAccount(@Argument String email, @Argument String password) {
		return userService.createUserAccount(email, password);
	}

	@MutationMapping
	public String deleteUserAccount(@Argument String email) {
		return userService.deleteUserAccount(email);
	}

	@MutationMapping
	public void addUserAddress(@Argument String email, @Argument UserAddress userAddress) {
		userService.addUserAddress(email, userAddress);

	}

	@MutationMapping
	public String deleteUserAddress(@Argument Long id) {
		return userService.deleteUserAddress(id);

	}

	@MutationMapping
	public void addUserPayment(@Argument String email, @Argument UserPayment userPayment) {
		userService.addUserPayment(email, userPayment);

	}

	@MutationMapping
	public String deleteUserPayment(@Argument Long id) {
		return userService.deleteUserPayment(id);

	}

	@QueryMapping
	public UserAccount getUserAccount(@Argument String email) {
		return userService.getUserAccount(email);
	}

	@QueryMapping
	public Optional<UserAddress> getUserAddress(@Argument Long id) {
		return userService.getUserAddress(id);
	}

	@QueryMapping
	public Optional<UserPayment> getUserPayment(@Argument Long id) {
		return userService.getUserPayment(id);
	}

}
