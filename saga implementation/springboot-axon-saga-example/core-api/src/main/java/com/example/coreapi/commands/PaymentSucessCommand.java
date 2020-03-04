package com.example.coreapi.commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class PaymentSucessCommand {

	@TargetAggregateIdentifier
	public final String paymentId;
	public final BigDecimal price;
	public final String orderId;
	public final String status;

	public PaymentSucessCommand(String paymentId, BigDecimal price, String orderId, String status) {
		super();
		this.paymentId = paymentId;
		this.price = price;
		this.orderId = orderId;
		this.status = status;
	}


}
