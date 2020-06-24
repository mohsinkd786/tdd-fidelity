package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

public interface Payment {

    boolean makePayment(Order order);
}
