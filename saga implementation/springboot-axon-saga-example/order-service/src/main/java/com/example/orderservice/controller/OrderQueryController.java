package com.example.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entities.Order;
import com.example.orderservice.quryservice.OrderQueryService;

@RestController
public class OrderQueryController {
	@Autowired
	private OrderQueryService orderQueryservice;
	
    @GetMapping(path = "/getOrder/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable Integer orderId) {
    	return orderQueryservice.getOrder(orderId);
    }
    
    @GetMapping(path = "/getOrderEvents/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> listOrderEvents(@PathVariable Integer orderId){
		return orderQueryservice.listEventsForOrder(orderId);
    	
    }
}
