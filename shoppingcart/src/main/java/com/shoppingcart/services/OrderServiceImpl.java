package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;

public class OrderServiceImpl implements  OrderService{

    private  ProcessingService processingService;

    public OrderServiceImpl(ProcessingService processingService) {
        this.processingService = processingService;
    }

    @Override
    public Order createOrder(Order order) {
        return processingService.processOrder(order);
    }
}
