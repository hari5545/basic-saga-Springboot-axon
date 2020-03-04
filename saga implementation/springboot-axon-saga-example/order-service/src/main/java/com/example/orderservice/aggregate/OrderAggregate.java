package com.example.orderservice.aggregate;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.coreapi.commands.CreateOrderCommand;
import com.example.coreapi.commands.UpdateOrderStatusCommand;
import com.example.coreapi.events.OrderCreatedEvent;
import com.example.coreapi.events.OrderUpdatedEvent;
import com.example.orderservice.commandservice.OrderCommandService;
import com.sun.istack.logging.Logger;

@Aggregate
public class OrderAggregate {

	Logger logger = Logger.getLogger(OrderAggregate.class);
	@AggregateIdentifier
	protected String orderId;

	protected ItemType itemType;

	protected BigDecimal price;

	protected String currency;

	protected OrderStatus orderStatus;

	public OrderAggregate() {
	}

	@Inject
	protected OrderCommandService orderCommandService;
	
	@CommandHandler
	public OrderAggregate(CreateOrderCommand createOrderCommand){
		AggregateLifecycle.apply(new OrderCreatedEvent(createOrderCommand.orderId, createOrderCommand.itemType,
				createOrderCommand.price, createOrderCommand.currency, createOrderCommand.orderStatus));
		logger.info("OrderService CreateOrderCommand");
	}

	@EventSourcingHandler
	protected void on(OrderCreatedEvent orderCreatedEvent){
		this.orderId = orderCreatedEvent.orderId;
		this.itemType = ItemType.valueOf(orderCreatedEvent.itemType);
		this.price = orderCreatedEvent.price;
		this.currency = orderCreatedEvent.currency;
		this.orderStatus = OrderStatus.valueOf(orderCreatedEvent.orderStatus);
		logger.info("OrderService OrderCreatedEvent \t");
	}

	@CommandHandler
	protected void on(UpdateOrderStatusCommand updateOrderStatusCommand){
		AggregateLifecycle.apply(new OrderUpdatedEvent(updateOrderStatusCommand.orderId, updateOrderStatusCommand.orderStatus));
		logger.info("OrderService UpdateOrderStatusCommand \t");
	}

	@EventSourcingHandler
	protected void on(OrderUpdatedEvent orderUpdatedEvent){
		this.orderId =orderUpdatedEvent.orderId;
		this.orderStatus = OrderStatus.valueOf(orderUpdatedEvent.orderStatus);
		logger.info("OrderService UpdateOrderStatusEvent\t");
	}
}
