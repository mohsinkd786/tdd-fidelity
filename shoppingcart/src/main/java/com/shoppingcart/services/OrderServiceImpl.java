package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;
import com.shoppingcart.dtos.Product;

import java.util.List;

public class OrderServiceImpl implements  OrderService{

    private  ProcessingService processingService;

    public OrderServiceImpl(ProcessingService processingService) {
        this.processingService = processingService;
    }

    @Override
    public Order createOrder(Order order) {
        return processingService.processOrder(order);
    }

    @Override
    public Order addProducts(Order order, List<Product> products) {
        order.addProducts(products);
        int quantity = order.getQuantity();
        double totalPrice = order.getTotalPrice();
        for (Product product: products) {
            quantity += product.getQuantity();
            totalPrice += product.getPrice();
        }
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);
        return order;
    }
}
