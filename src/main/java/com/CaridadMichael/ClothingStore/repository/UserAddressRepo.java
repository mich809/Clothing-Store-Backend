package com.CaridadMichael.ClothingStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CaridadMichael.ClothingStore.model.UserAddress;

@Repository
public interface UserAddressRepo extends JpaRepository<UserAddress, Long> {

}
