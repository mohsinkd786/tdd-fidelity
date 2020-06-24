package io.mohsinkd786.checkout;

import io.mohsinkd786.dtos.Order;

public interface OrderService {
	/**
	 * @param order
	 * @return Order
	 */
    Order createOrder(Order order);

}
