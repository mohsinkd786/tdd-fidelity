package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessingService implements ProcessingService {

    private Payment payment;

    private List<Order> listOfOrders = new ArrayList<Order>();

    public OrderProcessingService() {
        this.payment = new CODPayment();
    }

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


    @Override
    public void addOrder(Order order) {
        listOfOrders.add(order);
    }

    @Override
    public Boolean deleteOrder(Order orderToDelete) {

        return listOfOrders.removeIf(e -> e.getId() == orderToDelete.getId());
    }

    @Override
    public List<Order> getOrders() {
        return listOfOrders;
    }
}
