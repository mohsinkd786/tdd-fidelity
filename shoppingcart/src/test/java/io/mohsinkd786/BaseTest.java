package io.mohsinkd786;

import io.mohsinkd786.checkout.builders.OrderBuilder;
import io.mohsinkd786.dtos.Item;
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
        requestedOrder.addItem(item1());
        requestedOrder.addItem(item2());
        return requestedOrder;
    }

    protected Item item1(){
        Item item1=new Item();
        item1.setId(1);
        item1.setName("Soap");
        item1.setDescription("This is soap");
        return item1;
    }

    protected Item item2(){
        Item item2=new Item();
        item2.setId(2);
        item2.setName("Biscuit");
        item2.setDescription("This is biscuit");
        return item2;
    }
}
