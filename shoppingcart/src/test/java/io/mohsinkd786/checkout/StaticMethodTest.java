package io.mohsinkd786.checkout;


//import org.junit.Assert;
//import org.junit.Ignore;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

//@ExtendWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "io.mohsinkd786.checkout.*")
public class StaticMethodTest {


    @Test
    public void testStaticMethods() {

        mockStatic(OrderProcessingService.class); // only incase of static methods

        PowerMockito.when(OrderProcessingService.defaultPayment()).thenReturn("CASH");

        String response = OrderProcessingService.defaultPayment();

        assertEquals(response, "CASH");

    }

    @Test
    public void testFinalMethod() {

        OrderProcessingService orderProcessingService = PowerMockito.mock(OrderProcessingService.class);

        PowerMockito.when(orderProcessingService.readyToShip()).thenReturn(true);

        boolean isReady = orderProcessingService.readyToShip();

        assertTrue(isReady);
    }
}
