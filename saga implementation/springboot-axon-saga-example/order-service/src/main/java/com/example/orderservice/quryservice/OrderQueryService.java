package com.example.orderservice.quryservice;

import java.util.List;

import com.example.orderservice.entities.Order;

public interface OrderQueryService {
	public List<Object> listEventsForOrder(Integer orderId);
	public Order getOrder(Integer orderId);
}
