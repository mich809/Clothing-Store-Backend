package com.CaridadMichael.ClothingStore.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CaridadMichael.ClothingStore.model.user.UserAccount;

public interface UserAccountRepo extends JpaRepository<UserAccount,Long> {

}
