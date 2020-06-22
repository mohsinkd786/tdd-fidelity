package test.services;

import main.java.enums.Operands;
import main.java.services.CalculatorApiService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    @Test
    public void testCalculatorSum() {

        CalculatorApiService calculatorApiService = new CalculatorApiService();
        double result = calculatorApiService.execute(Operands.SUM, 12, 3);

        assertEquals(result, 12 + 3);

    }
}
