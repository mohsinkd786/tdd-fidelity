package io.mohsinkd786.dao;

import io.mohsinkd786.dtos.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    List<Order> listOfOrder = new ArrayList<Order>();

    public Order addOrder(Order order) {
        listOfOrder.add(order);
        return order;
    }

    public Boolean deleteOrder(Order order) {
        return listOfOrder.removeIf(order1 -> order1.getOrderId() == order.getOrderId());
    }

    public List<Order> getOrders() {
        return listOfOrder;
    }
}
