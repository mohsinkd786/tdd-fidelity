package com.shoppingcart;

import com.shoppingcart.dtos.Order;
import com.shoppingcart.services.Payment;
import com.shoppingcart.services.builders.OrderBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseTest {

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    public Order createOrderStub(int seed) {
        Order requestOrder = OrderBuilder.withSeed(1);
        return requestOrder;
    }

    public Order createOrderWithDetails(int quantity, double price, Payment paymentDetail, boolean status) {
        return  new OrderBuilder()
                .withQuantity(quantity)
                .withTotalPrice(price)
                .withId(1)
                .withStatus(status)
                .withPaymentDetail(paymentDetail)
                .build();
    }
}
