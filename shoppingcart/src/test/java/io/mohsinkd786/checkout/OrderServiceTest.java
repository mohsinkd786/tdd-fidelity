package io.mohsinkd786.checkout;
import static org.junit.jupiter.api.Assertions.*;

import io.mohsinkd786.products.Product;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    void testAddCartItems(){
        OrderService orderService = new OrderService();
        Product p1=new Product(1,"Beer",2,12.30);
        assertTrue(orderService.addCartItems(p1));

    }
}
