package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;

public interface ProcessingService {
    Order processOrder(Order order);
}
