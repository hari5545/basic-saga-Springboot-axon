package com.example.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderservice.entities.Order;

@Repository
public interface OrderRepositery extends JpaRepository<Order, Integer>{

}