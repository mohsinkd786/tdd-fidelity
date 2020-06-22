package main.java.apis;

import main.java.enums.Operands;
import main.java.services.CalculatorApiService;

public class CalculatorApi {

    public double calculate(Operands operand, double first, double next) {
        CalculatorApiService calculatorApiService = new CalculatorApiService();
        double result = calculatorApiService.execute(operand, first, next);
        return result;
    }
}
