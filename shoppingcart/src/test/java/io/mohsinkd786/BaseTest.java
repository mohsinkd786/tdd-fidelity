package io.mohsinkd786;

import io.mohsinkd786.checkout.builders.OrderBuilder;
import io.mohsinkd786.checkout.builders.ProductBuilder;
import io.mohsinkd786.dtos.Order;
import io.mohsinkd786.dtos.Product;
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

    protected Product createProductStub(int seed,String name) {
        Product requestedProduct = ProductBuilder.withSeed(seed,name);
        return requestedProduct;
    }
}
