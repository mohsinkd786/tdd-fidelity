package test.apis;

import main.java.apis.CalculatorApi;
import main.java.enums.Operands;
import main.java.services.CalculatorApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorApiTest {

    double first;
    double next;

    CalculatorApiService calculatorApiService;

    @BeforeEach
    public void startUp() {

        calculatorApiService = new CalculatorApiService();
        first = 10;
        next = 12;
    }

    @Test
    public void testCalculatorSum() {

        CalculatorApi calculatorApi = new CalculatorApi();
        double sum = calculatorApi.calculate(Operands.SUM, first, next);
        assertEquals(sum, calculatorApiService.execute(Operands.SUM, first, next));

    }

    @Test
    public void testCalculatorDiff() {

        CalculatorApi calculatorApi = new CalculatorApi();
        double diff = calculatorApi.calculate(Operands.DIFF, first, next);
        assertEquals(diff, first - next);
    }

    @Test
    public void testCalculatorDiv() {

        CalculatorApi calculatorApi = new CalculatorApi();
        double div = calculatorApi.calculate(Operands.DIV, first, next);
        assertEquals(div, first / next);

    }

    @Test
    public void testCalculatorMul() {

        CalculatorApi calculatorApi = new CalculatorApi();
        double mul = calculatorApi.calculate(Operands.MUL, first, next);
        assertEquals(mul, first * next);

    }
}
