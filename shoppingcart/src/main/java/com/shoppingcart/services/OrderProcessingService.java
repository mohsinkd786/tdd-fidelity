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
        Order updatedOrder = makePayment(order);

        if (updatedOrder.getPaymentDetail() != null && updatedOrder.getPaymentDetail().isPaymentStatus()) {
            updatedOrder.setStatus(true);
        }
        return updatedOrder;
    }

    public Order makePayment(Order order) {
        return payment.makePayment(order);
    }

    public static String defaultPayment(){
        return "COD";
    }

    public final boolean readyToShip(){
        return false;
    }
}
