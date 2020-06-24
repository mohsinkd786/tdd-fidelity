package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;

public class OrderProcessingService implements ProcessingService {

    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public Order processOrder(Order order) {
        makePayment(order);

        if (makePayment(order)) {
            order.setStatus(true);
        }
        return order;
    }

    public boolean makePayment(Order order) {
        return payment.makePayment(order);
    }

    public static String defaultPayment(){
        return "COD";
    }

    public final boolean readyToShip(){
        return false;
    }
}
