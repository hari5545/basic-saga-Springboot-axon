package com.example.orderservice.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.commandservice.OrderCommandService;
import com.example.orderservice.dto.OrderCreateDTO;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/orders")
@Api(value = "Order Commands", description = "Order Commands Related Endpoints", tags = "Order Commands")
public class OrderCommandController {

	@Autowired
    private OrderCommandService orderCommandService;

    @PostMapping
    public CompletableFuture<Object> createOrder(@RequestBody OrderCreateDTO orderCreateDTO){
        return orderCommandService.createOrder(orderCreateDTO);
    }
}
