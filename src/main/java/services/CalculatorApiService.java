package main.java.services;

import main.java.enums.Operands;

public class CalculatorApiService {

    public double execute(Operands operand, double first, double next) {
        double result;
        switch (operand) {
            case SUM:
                result = sum(first, next);
                break;
            case DIFF:
                result = diff(first, next);
                break;
            case DIV:
                result = div(first, next);
                break;
            case MUL:
                result = mul(first, next);
                break;
            default:
                result = 0;
        }
        return result;
    }

    private double sum(double first, double next) {
        return first + next;
    }

    private double diff(double first, double next) {
        return first - next;
    }

    private double div(double first, double next) {
        return first / next;
    }

    private double mul(double first, double next) {
        return first * next;
    }
}
