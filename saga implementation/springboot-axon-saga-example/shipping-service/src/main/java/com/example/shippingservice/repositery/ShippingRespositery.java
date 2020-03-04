package com.example.shippingservice.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shippingservice.entity.Shipping;

@Repository
public interface ShippingRespositery extends JpaRepository<Shipping, String>{

}
