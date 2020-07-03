package io.mohsinkd786.products;

import io.mohsinkd786.BaseTest;
import io.mohsinkd786.dtos.Product;
//import org.junit.Assert;
//import org.junit.Test;

import io.mohsinkd786.checkout.CardPayment;
import io.mohsinkd786.checkout.OrderProcessingService;
import io.mohsinkd786.checkout.OrderService;
import io.mohsinkd786.checkout.OrderServiceImpl;
import io.mohsinkd786.checkout.Payment;
import io.mohsinkd786.dtos.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductServiceTest extends BaseTest {
	
	@Test
    void testaddproduct() {

	    ProductSerivce productSerivce=new ProductServiceImpl();
        Product product = createProductStub(1,"beer");
        boolean isAdded= productSerivce.addproduct(product);
        assertTrue(isAdded);

    }

    @Test
    void testremoveproduct() {

        ProductSerivce productSerivce=new ProductServiceImpl();
        Product product = createProductStub(1,"beer");
        boolean isAdded= productSerivce.removeproduct(product);
        assertTrue(isAdded);

    }

}