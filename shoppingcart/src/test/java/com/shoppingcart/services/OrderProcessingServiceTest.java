package com.shoppingcart.services;

import com.shoppingcart.BaseTest;
import com.shoppingcart.dtos.Order;
import com.shoppingcart.services.builders.OrderBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderProcessingServiceTest extends BaseTest {

    @Mock
    Payment payment;

    @Test
    void testProcessingOrder() {
        OrderProcessingService processingService = new OrderProcessingService();
//        Payment payment = mock(Payment.class);
        when(payment.makePayment(any(Order.class))).thenReturn(true);
        processingService.setPayment(payment);

        Order order = createOrderStub(1);
        Order result = processingService.processOrder(order);

        Assertions.assertTrue(result.getStatus());
    }

    @Test
    void testProcessingOrderWhenCardPayment() {
        OrderProcessingService processingService = new OrderProcessingService();
        Payment cardPayment = new CardPayment("Anna", "12345678", "CITI BANK");
        when(payment.makePayment(any(Order.class))).thenReturn(createOrderWithDetails(10, 1000.00, cardPayment, true));
        processingService.setPayment(payment);

        Order order = createOrderWithDetails(10, 1000, null, false);
        Order result = processingService.processOrder(order);

        Assertions.assertTrue(result.getStatus());
        Assertions.assertEquals("CARD", order.getPaymentMode());
        Assertions.assertTrue(result.getPaymentDetail().getPaymentStatus());
    }

    @Test
    void testProcessingOrderWhenCashPayment() {
        OrderProcessingService processingService = new OrderProcessingService();
        Payment cashPayment = new CashPayment();
        when(payment.makePayment(any(Order.class))).thenReturn(createOrderWithDetails(10, 1000.00, cashPayment, true));
        processingService.setPayment(payment);

        Order order = createOrderWithDetails(10, 1000, null, false);
        Order result = processingService.processOrder(order);

        Assertions.assertTrue(result.getStatus());
        Assertions.assertEquals("CASH", order.getPaymentMode());
        Assertions.assertTrue(result.getPaymentDetail().getPaymentStatus());
    }

}
