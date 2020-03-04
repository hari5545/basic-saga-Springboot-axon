package com.example.paymentservice.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.coreapi.commands.CreateInvoiceCommand;
import com.example.coreapi.events.InvoiceCreatedEvent;
import com.example.paymentservice.entities.Payment;
import com.example.paymentservice.service.PaymentServices;
import com.sun.istack.logging.Logger;

@Aggregate
public class InvoiceAggregate {
	Logger logger = Logger.getLogger(InvoiceAggregate.class);
	@AggregateIdentifier
	protected String paymentId;

	protected String orderId;

	protected InvoiceStatus invoiceStatus;

	public InvoiceAggregate() {

	}

	protected PaymentServices paymentServices;

		
	@CommandHandler
	public InvoiceAggregate(CreateInvoiceCommand createInvoiceCommand,PaymentServices paymentServices) {
		this.paymentServices=paymentServices;
		System.out.println("starting payment service.............");
		Payment payment=paymentServices.createPayment(new Payment(createInvoiceCommand.paymentId,"UPI",createInvoiceCommand.price,createInvoiceCommand.orderId)); 
		AggregateLifecycle.apply(new InvoiceCreatedEvent(payment.getPaymentId(),payment.getOrderId(),payment.getPrice()));
		logger.info("paymentservice InvoiceCreatedcommand ");
	}
	@EventSourcingHandler
	protected void on(InvoiceCreatedEvent invoiceCreatedEvent){
		this.paymentId = invoiceCreatedEvent.paymentId;
		this.orderId =invoiceCreatedEvent.orderId;
		this.invoiceStatus =InvoiceStatus.PAID;
		logger.info("paymentservice InvoiceCreatedEvent ");
	}

}
