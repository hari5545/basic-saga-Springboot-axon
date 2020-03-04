package com.example.shippingservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shipping {

	@Id
	@Column(name = "shipping_id")
	protected String shippingId;
	protected String address;
	@Column(name = "payment_id")
	protected String paymentId;
	@Column(name = "order_id")
	protected String orderId;
	
	
	public Shipping() {}


	public Shipping(String shippingId, String address, String paymentId, String orderId) {
		super();
		this.shippingId = shippingId;
		this.address = address;
		this.paymentId = paymentId;
		this.orderId = orderId;
	}


	public String getShippingId() {
		return shippingId;
	}


	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	@Override
	public String toString() {
		return "Shipping [shippingId=" + shippingId + ", address=" + address + ", paymentId=" + paymentId + ", orderId="
				+ orderId + "]";
	}
	
	
}
