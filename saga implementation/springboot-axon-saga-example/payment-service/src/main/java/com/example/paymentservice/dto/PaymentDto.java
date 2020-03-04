package com.example.paymentservice.dto;

import java.math.BigDecimal;

public class PaymentDto {
	protected String paymentId;


	protected String paymentType;

	protected BigDecimal price;


	protected String orderId;

	public PaymentDto(String paymentId, String paymentType, BigDecimal price, String orderId) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.price = price;
		this.orderId = orderId;
	}


	public PaymentDto( String paymentType, BigDecimal price, String orderId) {
		super();
		this.paymentType = paymentType;
		this.price = price;
		this.orderId = orderId;
	}


	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentType=" + paymentType + ", price=" + price + ", orderId="
				+ orderId + "]";
	}
}
