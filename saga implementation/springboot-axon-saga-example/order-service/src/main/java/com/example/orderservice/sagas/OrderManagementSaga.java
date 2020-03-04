package com.example.orderservice.sagas;

import java.util.UUID;

import javax.inject.Inject;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import com.example.coreapi.commands.CreateInvoiceCommand;
import com.example.coreapi.commands.CreateShippingCommand;
import com.example.coreapi.commands.UpdateOrderStatusCommand;
import com.example.coreapi.events.InvoiceCreatedEvent;
import com.example.coreapi.events.OrderCreatedEvent;
import com.example.coreapi.events.OrderShippedEvent;
import com.example.coreapi.events.OrderUpdatedEvent;
import com.example.orderservice.aggregate.OrderStatus;

@Saga
public class OrderManagementSaga {

	@Inject
	private transient CommandGateway commandGateway;

	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderCreatedEvent orderCreatedEvent){
		String paymentId = UUID.randomUUID().toString();
		System.out.println("Saga invoked");

		//associate Saga
		SagaLifecycle.associateWith("paymentId", paymentId);

		System.out.println("order id" + orderCreatedEvent.orderId);

		//send the commands
		commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.orderId,orderCreatedEvent.price));
	}

	@SagaEventHandler(associationProperty = "paymentId")
	public void handle(InvoiceCreatedEvent invoiceCreatedEvent){

		String shippingId = UUID.randomUUID().toString();

		System.out.println("Saga continued");

		//associate Saga with shipping 
		SagaLifecycle.associateWith("shipping",shippingId);
		System.out.println("payment Id \t "+invoiceCreatedEvent.paymentId); 
		//send the create shipping command 
		commandGateway.send(new	CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId,
				invoiceCreatedEvent.paymentId));


	}



	@SagaEventHandler(associationProperty = "orderId") 
	public void  handle(OrderShippedEvent orderShippedEvent){

		commandGateway.send(new UpdateOrderStatusCommand(orderShippedEvent.orderId,
				String.valueOf(OrderStatus.SHIPPED)));
		System.out.println("saga upadte command ");
	}



	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderUpdatedEvent orderUpdatedEvent){
		SagaLifecycle.end();
		System.out.println("saga ends");
	}
}