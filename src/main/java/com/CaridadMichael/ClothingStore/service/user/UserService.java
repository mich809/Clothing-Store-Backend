 package com.CaridadMichael.ClothingStore.service.user;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.CaridadMichael.ClothingStore.model.user.UserAccount;
import com.CaridadMichael.ClothingStore.repository.user.UserAccountRepo;

@Service
public class UserService {
	
		@Autowired
		private UserAccountRepo userAccountRepo;
	
	

	    public String createUser(String email , String password) {
	    	if(userExists(email)) {
	    		return "User" + email+ " already  exist";
	    		
	    	}
	        UserAccount user = new UserAccount(email, password);	
	        userAccountRepo.save(user);
	        return "User " + email + " created";
	       
	    }

	    public UserAccount getUser(String email){	       
			return userAccountRepo.findByEmail(email);
	    }

	    private boolean userExists(String email) {	        
	        return userAccountRepo.existsByEmail(email);
	    }
	
	
	

}
