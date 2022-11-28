package com.CaridadMichael.ClothingStore.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.CaridadMichael.ClothingStore.model.user.UserAccount;
import com.CaridadMichael.ClothingStore.service.user.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@MutationMapping
	public String createUserAccount(@Argument String email, @Argument String password) {	 
	  return userService.createUser(email, password);
	}
	
	@QueryMapping
	public UserAccount getUserAccount(@Argument String email) {	 
	  return userService.getUser(email);
	}

}