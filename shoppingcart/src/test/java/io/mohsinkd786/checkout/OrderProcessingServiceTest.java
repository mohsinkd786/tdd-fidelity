package io.mohsinkd786.checkout;

import io.mohsinkd786.BaseTest;
import io.mohsinkd786.checkout.builders.OrderBuilder;
import io.mohsinkd786.dtos.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class OrderProcessingServiceTest extends BaseTest {

    @Test
    void testProcessOrder1(){
        OrderProcessingService processingService = new OrderProcessingService();

        //Payment payment = new CardPayment(); // actual instance

        Payment payment = Mockito.mock(Payment.class); // mocked instance

        Mockito.when(payment.makePayment(any(Order.class))).thenReturn(true); // return custom expectation

        processingService.setPayment(payment);

        Order order = createOrderStub(1);
        Order result = processingService.processOrder(order);
        Assertions.assertEquals(2,result.getItems().size());
        Assertions.assertTrue(result.isStatus());
        Assertions.assertEquals(item1().toString(),result.getItems().get(0).toString());
        Assertions.assertEquals(item2().toString(), result.getItems().get(1).toString());

    }

    @Test
    public void testProcessOrder2(){
        OrderProcessingService processingService = new OrderProcessingService();
        Payment payment = Mockito.mock(Payment.class); // mocked instance

        Mockito.when(payment.makePayment(any(Order.class))).thenReturn(true); // return custom expectation

        processingService.setPayment(payment);

        Order order = createOrderStub(1);
        order.removeItem(item1());
        Order newOrder = processingService.processOrder(order);
        Assertions.assertEquals(1, newOrder.getItems().size());
        Assertions.assertEquals(item2().toString(), newOrder.getItems().get(0).toString());
    }

    @Test
    void testProcessOrderWithCOD(){
        OrderProcessingService processingService = new OrderProcessingService();
        Order order = new OrderBuilder()
                .withId(1)
                .withQuantity(10)
                .withTotalPrice(100)
                .build();
        order.addItem(item1());
        Order result = processingService.processOrder(order);
        Assertions.assertEquals("COD", result.getPaymentMode());
        Assertions.assertEquals(1,result.getItems().size());
        Assertions.assertTrue(result.isStatus());
        Assertions.assertEquals(item1().toString(),result.getItems().get(0).toString());
    }
}
