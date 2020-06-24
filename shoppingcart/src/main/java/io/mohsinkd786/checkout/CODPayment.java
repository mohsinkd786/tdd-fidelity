package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

public class CODPayment implements Payment{
    @Override
    public boolean makePayment(Order order) {
        order.setPaymentMode("COD");
        return true;
    }
}
