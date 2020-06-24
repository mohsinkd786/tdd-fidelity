package com.shoppingcart.services;

import com.shoppingcart.BaseTest;
import com.shoppingcart.dtos.Order;
import com.shoppingcart.services.builders.CardPaymentBuilder;
import com.shoppingcart.services.builders.OrderBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest extends BaseTest {

    @Test
    void testCreateOrder() {
        Payment payment = new CardPaymentBuilder()
                .withNameOnCard("Anna")
                .withPaymentStatus(true)
                .withAccountNumber("12345678")
                .withBankName("CITI BANK").build();
        OrderProcessingService processingService = new OrderProcessingService();
        processingService.setPayment(payment);

        OrderService orderService = new OrderServiceImpl(processingService);

        Order order = new OrderBuilder().withQuantity(20).withTotalPrice(1000.00).build();
        Order result = orderService.createOrder(order);

        Assertions.assertTrue(result.getStatus());
        Assertions.assertEquals("CARD", result.getPaymentMode());
    }
}
