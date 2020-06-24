package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;

public class CashPayment extends Payment {
    @Override
    Order makePayment(Order order) {
        setPaymentStatus(true);
        order.setPaymentMode("CASH");
        order.setPaymentDetail(this);
        return order;
    }
}
