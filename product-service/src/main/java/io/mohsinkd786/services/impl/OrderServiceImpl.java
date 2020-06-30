package io.mohsinkd786.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    private ProcessOrderServiceImpl processOrderService;

    @Autowired
    public OrderServiceImpl(ProcessOrderServiceImpl processOrderService) {
        this.processOrderService = processOrderService;
    }

    public double processOrder(int quantity) {
        //double finalPrice = processOrderService.calculateOrderCost(quantity);
        //double totalPrice = finalPrice * quantity;
        return calculateCost(quantity);
    }

    private double calculateCost(int quantity) {
        if (isItemInStock("SAMPLE")) {
            return processOrderService.calculateOrderCost(quantity) * quantity;
        }
        return 0;
    }

    private boolean isItemInStock(String itemCode) {
        return true;
    }
}
