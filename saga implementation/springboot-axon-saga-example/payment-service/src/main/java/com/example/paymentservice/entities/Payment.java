package com.example.paymentservice.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	@Column(name ="payment_id" )
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected String paymentId;

	@Column(name ="payment_type" )
	protected String paymentType;

	protected BigDecimal price;

	@Column(name="order_id")
	protected String orderId;

	public Payment() {}


	public Payment(String paymentId, String paymentType, BigDecimal price, String orderId) {
		super();
		this.paymentId = paymentId;
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
