package com.example.orderservice.dto;

import java.math.BigDecimal;

public class OrderCreateDTO {

    private String itemType;

    private BigDecimal price;

    private String currency;

    
    public OrderCreateDTO(String itemType, BigDecimal price, String currency) {
		super();
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
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
}
