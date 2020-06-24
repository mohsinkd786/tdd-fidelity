package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

public class OrderServiceImpl implements OrderService {

    private ProcessingService processingService;

    // Constructor Injection
    public OrderServiceImpl(ProcessingService processingService) {
        this.processingService = processingService;
    }

    public Order createOrder(Order order) {
        return processingService.processOrder(order);
    }
}
