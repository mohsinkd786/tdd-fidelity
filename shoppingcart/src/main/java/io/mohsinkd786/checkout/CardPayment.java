package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

public class CardPayment implements Payment {

    public boolean makePayment(Order order) {
        return true;
    }
}
