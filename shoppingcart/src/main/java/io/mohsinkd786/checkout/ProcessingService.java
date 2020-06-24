package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

public interface ProcessingService {

    Order processOrder(Order order);
}
