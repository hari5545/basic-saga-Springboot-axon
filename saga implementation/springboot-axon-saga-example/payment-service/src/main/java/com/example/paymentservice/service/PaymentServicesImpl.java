package com.example.paymentservice.service;

import org.axonframework.modelling.command.AggregateLifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.coreapi.events.InvoiceCreatedEvent;
import com.example.paymentservice.entities.Payment;
import com.example.paymentservice.repositery.PaymentRepositery;

@Service
public class PaymentServicesImpl implements PaymentServices{
  
	@Autowired
	private PaymentRepositery paymentRepositery;
	
	@Override
	@Transactional
	public Payment createPayment(Payment payment) {
		Payment payment1=paymentRepositery.save(payment);
		AggregateLifecycle.apply(new InvoiceCreatedEvent(payment1.getPaymentId(), payment1.getOrderId(),
				payment1.getPrice()));
		return payment1;
	}

	@Override
	public Payment getPayment(String paymentId) {
		return paymentRepositery.findById(paymentId).get();
	}
}
