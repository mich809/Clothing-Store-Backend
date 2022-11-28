package com.CaridadMichael.ClothingStore.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CaridadMichael.ClothingStore.model.user.UserAccount;
import com.CaridadMichael.ClothingStore.model.user.UserAddress;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {
	boolean existsByEmail(String email);

	public UserAccount findByEmail(String email);

	@Modifying
	@Query("update UserAccount u set u.UserAddress = :UserAddress  where u.email = :email")
	void updateAddress(@Param(value = "email") String email, @Param(value = "UserAddress") UserAddress userAddress);

}
