package io.mohsinkd786.products;

import org.junit.Assert;
import org.junit.Test;

import io.mohsinkd786.checkout.CardPayment;
import io.mohsinkd786.checkout.OrderProcessingService;
import io.mohsinkd786.checkout.OrderService;
import io.mohsinkd786.checkout.OrderServiceImpl;
import io.mohsinkd786.checkout.Payment;
import io.mohsinkd786.dtos.Order;

public class ProductServiceTest {
	
	@Test
    void testCreateOrder() {
        Payment payment = new CardPayment();

        OrderProcessingService processingService = new OrderProcessingService();

        processingService.setPayment(payment);

        OrderService orderService = new OrderServiceImpl(processingService);

        Order order = createOrderStub(1); // create object via Builder

        Order savedOrder = orderService.createOrder(order);

        Assert.assertTrue(savedOrder.isStatus());

    }

}
