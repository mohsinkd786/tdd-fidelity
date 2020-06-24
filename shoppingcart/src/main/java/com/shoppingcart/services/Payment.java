package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;

public abstract class Payment {
    private  boolean paymentStatus;

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    abstract Order makePayment(Order order);
}