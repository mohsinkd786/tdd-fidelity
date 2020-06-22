package services;

import enums.Operands;

public class CalculatorApiService {

	public double excute(Operands operand, double first, double next) {
		
		// TODO Auto-generated method stub
		if(operand.equals(Operands.SUM))
		return first + next;
		else if(operand.equals(Operands.DIF)) {
			return first - next;
		}else {
			return first * next;
		}
	}
}
