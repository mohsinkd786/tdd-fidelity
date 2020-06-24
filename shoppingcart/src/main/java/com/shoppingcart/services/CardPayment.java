package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;

public class CardPayment implements Payment {

    @Override
    public boolean makePayment(Order order) {
        return true;
    }
}
