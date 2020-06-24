package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;

public interface  Payment {
    boolean makePayment(Order order);
}