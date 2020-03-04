package com.example.orderservice.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="saga_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="order_id" )
	protected String orderId;

	@Column(name ="item_type" )
	protected String itemType;

	protected BigDecimal price;

	protected String currency;

	@Column(name ="order_status" )
	protected String orderStatus;
    @Column(name="payment_id")
	protected String paymentId;
	
	public Order( String itemType, BigDecimal price, String currency, String orderStatus) {
		super();
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
	}

	

	public Order(String orderId, String itemType, BigDecimal price, String currency, String orderStatus,
			String paymentId) {
		super();
		this.orderId = orderId;
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
		this.paymentId = paymentId;
	}



	public Order() {}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentId() {
		return paymentId;
	}



	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", itemType=" + itemType + ", price=" + price + ", currency=" + currency
				+ ", orderStatus=" + orderStatus + ", paymentId=" + paymentId + "]";
	}



	
	
}


