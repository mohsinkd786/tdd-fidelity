package io.mohsinkd786.checkout;

import io.mohsinkd786.BaseTest;
import io.mohsinkd786.checkout.builders.OrderBuilder;
import io.mohsinkd786.dtos.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class OrderProcessingServiceTest extends BaseTest {

    private Payment payment;

    private OrderProcessingService orderProcessingService;

    @BeforeEach
    public void init() {

        payment = Mockito.mock(Payment.class); // mocked instance

        Order order = createOrderStub(0);
        orderProcessingService = new OrderProcessingService();
        orderProcessingService.addOrder(order);
    }

    @Test
    void testProcessOrder(){
        OrderProcessingService processingService = new OrderProcessingService();

        //Payment payment = new CardPayment(); // actual instance

//        Payment payment = Mockito.mock(Payment.class); // mocked instance

        Mockito.when(payment.makePayment(any(Order.class))).thenReturn(true); // return custom expectation

        processingService.setPayment(payment);

        Order order = createOrderStub(1);
        Order result = processingService.processOrder(order);

        Assertions.assertTrue(result.isStatus());

    }

    @Test
    public void testProcessOrderWithDefaultPaymentMode() {

        OrderProcessingService orderProcessingService = new OrderProcessingService();

        Order order = new Order();
        order.setId(1);
        order.setQuantity(2);
        order.setTotalPrice(1000);
        order.setStatus(true);
        Mockito.when(payment.makePayment(any(Order.class))).thenReturn(true);

        Order orderReturned = orderProcessingService.processOrder(order);
        Assertions.assertEquals("COD", order.getPaymentMode());

    }

    @Test
    public void testAddOrder() {

        Order order1 = createOrderStub(2);
        orderProcessingService.addOrder(order1);
        Order orderProcessed = orderProcessingService.processOrder(order1);
        List<Order> listOfOrder = orderProcessingService.getOrders();
        Assertions.assertEquals(2, listOfOrder.size());
        Assertions.assertTrue(orderProcessed.isStatus());
    }

    @Test
    public void testDeleteOrder() {

        Order orderToDelete = new OrderBuilder().withId(0).build();
        Boolean isDeleted = orderProcessingService.deleteOrder(orderToDelete);
        Assertions.assertTrue(isDeleted);
    }
}
