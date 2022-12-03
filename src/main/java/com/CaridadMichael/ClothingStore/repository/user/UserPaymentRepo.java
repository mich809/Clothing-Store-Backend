package com.CaridadMichael.ClothingStore.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CaridadMichael.ClothingStore.model.user.UserPayment;

@Repository
public interface UserPaymentRepo extends JpaRepository<UserPayment, Long> {

}
