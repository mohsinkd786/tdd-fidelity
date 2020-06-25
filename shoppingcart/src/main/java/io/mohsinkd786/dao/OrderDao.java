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
        return listOfOrder.removeIf(e -> e.getId() == order.getId());
    }

    public List<Order> getOrders() {
        return listOfOrder;
    }
}
