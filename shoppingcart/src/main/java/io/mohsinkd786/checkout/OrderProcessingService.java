package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

public class OrderProcessingService implements ProcessingService {

    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    // Setter Injection
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order processOrder(Order order) {
        if (makePayment(order)) {
            order.setStatus(true);
            return order;
        }
        return order;
    }

    private boolean makePayment(Order order) {
        return payment.makePayment(order);
    }

    public static String defaultPayment(){
        return "COD";
    }

    public final boolean readyToShip(){
        return false;
    }
}
