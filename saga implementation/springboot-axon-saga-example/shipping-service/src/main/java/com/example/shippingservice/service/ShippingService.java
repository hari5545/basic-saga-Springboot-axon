package com.example.shippingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shippingservice.entity.Shipping;
import com.example.shippingservice.repositery.ShippingRespositery;

@Service
public class ShippingService {
	
    @Autowired
	private ShippingRespositery shippingRespositery;
    
    public Shipping saveShipping(Shipping shipping) {
		return shippingRespositery.save(shipping);
    }
}
