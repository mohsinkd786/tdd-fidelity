package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;
import com.shoppingcart.dtos.Product;

import java.util.List;

public interface OrderService {

    public Order createOrder(Order order);

    Order addProducts(Order order, List<Product> products);
}
