package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

import java.util.List;

public interface ProcessingService {

    Order processOrder(Order order);

    Order addOrder(Order order1);

    Boolean deleteOrder(Order orderToDelete);

    List<Order> getOrders();
}
