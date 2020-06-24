package io.mohsinkd786.checkout;

import io.mohsinkd786.BaseTest;
import io.mohsinkd786.dtos.Order;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

public class OrderServiceTest extends BaseTest {

    @Test
    public void testCreateOrder() {
        Payment payment = new CardPayment();

        OrderProcessingService processingService = new OrderProcessingService();

        processingService.setPayment(payment);

        OrderService orderService = new OrderServiceImpl(processingService);

        Order order = createOrderStub(1); // create object via Builder

        Order savedOrder = orderService.createOrder(order);

        Assert.assertTrue(savedOrder.isStatus());

    }
}
