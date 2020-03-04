package com.example.paymentservice.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paymentservice.entities.Payment;

@Repository
public interface PaymentRepositery extends JpaRepository<Payment, String>{

}
