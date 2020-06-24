package com.shoppingcart.services;

import com.shoppingcart.BaseTest;
import com.shoppingcart.dtos.Order;
import com.shoppingcart.dtos.Product;
import com.shoppingcart.services.builders.CardPaymentBuilder;
import com.shoppingcart.services.builders.OrderBuilder;
import com.shoppingcart.services.builders.ProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void testProductListOfNewOrder() {
        Product product1 = new ProductBuilder().withId(1).withName("Apple").withPrice(100).withQuantity(1).build();
        Product product2 = new ProductBuilder().withId(1).withName("Orange").withPrice(70).withQuantity(2).build();

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        OrderProcessingService processingService = new OrderProcessingService();

        OrderService orderService = new OrderServiceImpl(processingService);
        Order order = new OrderBuilder().withId(1).build();
        Order result = orderService.addProducts(order, products);

        Assertions.assertEquals(2, result.getProducts().size());
        Assertions.assertEquals(3, result.getQuantity());
        Assertions.assertEquals(170, result.getTotalPrice());
    }

    @Test
    void testProductListOfExistingOrder() {
        Product product1 = new ProductBuilder().withId(1).withName("Apple").withPrice(100).withQuantity(1).build();
        Product product2 = new ProductBuilder().withId(1).withName("Orange").withPrice(70).withQuantity(2).build();

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        OrderProcessingService processingService = new OrderProcessingService();

        OrderService orderService = new OrderServiceImpl(processingService);
        Order order = createOrderWithDetails(10, 1000, null, false, null);
        Order result = orderService.addProducts(order, products);

        Assertions.assertEquals(2, result.products.size());
        Assertions.assertEquals(13, result.getQuantity());
        Assertions.assertEquals(1170, result.getTotalPrice());
    }

}
