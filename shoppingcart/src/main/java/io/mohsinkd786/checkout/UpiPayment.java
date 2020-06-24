package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

public class UpiPayment implements Payment {

    public boolean makePayment(Order order) {
        order.setPaymentMode("UPI");
        return true;
    }
}
