package io.mohsinkd786;

import io.mohsinkd786.checkout.builders.OrderBuilder;
import io.mohsinkd786.dtos.Order;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseTest {

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this); // enable annotations
    }

    protected Order createOrderStub(int seed) {
        Order requestedOrder = OrderBuilder.withSeed(1);
        return requestedOrder;
    }
}
