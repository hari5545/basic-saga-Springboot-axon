package com.example.orderservice.commandservice;

import java.util.concurrent.CompletableFuture;

import com.example.orderservice.dto.OrderCreateDTO;
import com.example.orderservice.entities.Order;

public interface OrderCommandService {

    public CompletableFuture<Object> createOrder(OrderCreateDTO orderCreateDTO);
   public CompletableFuture<Object> updateOrder(Order order);
}
