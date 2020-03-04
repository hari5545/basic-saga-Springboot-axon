package com.example.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentservice.entities.Payment;
import com.example.paymentservice.service.PaymentServices;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentServices paymentServices;

	@GetMapping(path ="/getPayment",produces = MediaType.APPLICATION_JSON_VALUE )
	public Payment savePayment(@PathVariable String paymentId) {
		return paymentServices.getPayment(paymentId);
	}
}
