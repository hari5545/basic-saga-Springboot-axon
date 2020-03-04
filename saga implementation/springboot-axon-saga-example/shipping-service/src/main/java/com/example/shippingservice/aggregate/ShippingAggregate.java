package com.example.shippingservice.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.coreapi.commands.CreateShippingCommand;
import com.example.coreapi.events.OrderShippedEvent;
import com.example.shippingservice.entity.Shipping;
import com.example.shippingservice.service.ShippingService;

@Aggregate
public class ShippingAggregate {

	@AggregateIdentifier
	protected String shippingId;

	protected String orderId;

	protected String paymentId;

	public ShippingAggregate() {
	}

	protected ShippingService shippingService;

	@CommandHandler
	public ShippingAggregate(CreateShippingCommand createShippingCommand,ShippingService shippingService){
		this.shippingService=shippingService;
		System.out.println("starting shipping service.............");
		Shipping shipping=shippingService.saveShipping(new Shipping(createShippingCommand.shippingId, "banglore", createShippingCommand.paymentId, createShippingCommand.orderId));
		System.out.println(shipping);
		AggregateLifecycle.apply(new OrderShippedEvent(shipping.getShippingId(), shipping.getOrderId(), shipping.getPaymentId()));
		System.out.println("Shippingservice CreateShippingCommand"+createShippingCommand.toString());
	}

	@EventSourcingHandler
	protected void on(OrderShippedEvent orderShippedEvent){
		this.shippingId = orderShippedEvent.shippingId;
		this.orderId = orderShippedEvent.orderId;
		System.out.println("Shippingservice CreateShippingEvent"+orderShippedEvent.toString());
	}
}
