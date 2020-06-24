package io.mohsinkd786.checkout;

import io.mohsinkd786.BaseTest;
import io.mohsinkd786.dtos.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class OrderProcessingServiceTest extends BaseTest {

    @Test
    void testProcessOrder(){
        OrderProcessingService processingService = new OrderProcessingService();

        //Payment payment = new CardPayment(); // actual instance

        Payment payment = Mockito.mock(Payment.class); // mocked instance

        Mockito.when(payment.makePayment(any(Order.class))).thenReturn(true); // return custom expectation

        processingService.setPayment(payment);

        Order order = createOrderStub(1);
        Order result = processingService.processOrder(order);

        Assertions.assertTrue(result.isStatus());

    }
}
