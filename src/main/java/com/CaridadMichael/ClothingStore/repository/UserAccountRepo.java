package com.CaridadMichael.ClothingStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CaridadMichael.ClothingStore.model.UserAccount;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {
	boolean existsByEmail(String email);

	public UserAccount findByEmail(String email);

	void deleteByEmail(String email);

}
