package com.example.coreapi.events;

import java.math.BigDecimal;

public class PaymentSucessEvent {
	
	public final String paymentId;
	
	public final BigDecimal price;
	
	public final String orderId;
	
	
	public final String status;

	public PaymentSucessEvent(String paymentId, BigDecimal price, String orderId, String status) {
		super();
		this.paymentId = paymentId;
		this.price = price;
		this.orderId = orderId;
		this.status = status;
	}
	
}
