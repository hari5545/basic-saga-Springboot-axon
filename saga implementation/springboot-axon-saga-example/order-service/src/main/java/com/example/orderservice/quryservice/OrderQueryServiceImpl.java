package com.example.orderservice.quryservice;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.dao.OrderRepositery;
import com.example.orderservice.entities.Order;

@Service
public class OrderQueryServiceImpl implements OrderQueryService{

	@Autowired
	private  EventStore eventStore;

	@Autowired
	private  OrderRepositery accountRepository;

	@Override
	public List<Object> listEventsForOrder(Integer orderId) {
     String value=String.valueOf(orderId);
		return eventStore.readEvents(value).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
	}

	@Override
	public Order getOrder(Integer orderId) {
		return accountRepository.findById(orderId).get();
	}
}
