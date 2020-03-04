package com.example.paymentservice.service;

import com.example.paymentservice.entities.Payment;

public interface PaymentServices {
  Payment createPayment(Payment payment);
  Payment getPayment(String paymentId);
}
