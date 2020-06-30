package io.mohsinkd786.checkout;

import io.mohsinkd786.BaseTest;
import io.mohsinkd786.checkout.builders.OrderBuilder;
import io.mohsinkd786.dao.OrderDao;
import io.mohsinkd786.dtos.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class OrderProcessingServiceTest extends BaseTest {

    private Payment payment;

    private OrderProcessingService orderProcessingService;

//    @Mock
    private OrderDao orderDao;

    @BeforeEach
    public void init() {

        payment = Mockito.mock(Payment.class); // mocked instance
        orderDao = Mockito.mock(OrderDao.class);
        orderProcessingService = new OrderProcessingService();
        orderProcessingService.setDao(orderDao);

        Order order = createOrderStub(0);
        Mockito.when(orderDao.addOrder(any(Order.class))).thenReturn(order);

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
        order.setOrderId(1);
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
        List<Order> listOfOrder = Arrays.asList(order1);

        Mockito.when(orderDao.addOrder(any(Order.class))).thenReturn(order1);
        Mockito.when(orderDao.getOrders()).thenReturn(listOfOrder);

        Order order = orderProcessingService.addOrder(order1);
        List<Order> listOfOrderReturned = orderProcessingService.getOrders();
        Assertions.assertNotNull(listOfOrderReturned);
        Assertions.assertNotNull(order);
        Assertions.assertEquals(2, order.getOrderId());
        Assertions.assertEquals(1, listOfOrderReturned.size());
    }

    @Test
    public void testDeleteOrder() {

        Order orderToDelete = new OrderBuilder().withId(0).build();
        Mockito.when(orderDao.deleteOrder(orderToDelete)).thenReturn(true);
        Boolean isDeleted = orderProcessingService.deleteOrder(orderToDelete);
        Assertions.assertTrue(isDeleted);
    }
}
