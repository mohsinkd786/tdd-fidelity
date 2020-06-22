package apis;

import enums.Operands;
import services.CalculatorApiService;

public class CalculatorApi {

	public double calculate(Operands operand, double first, double next) {
	
		CalculatorApiService apiService = new CalculatorApiService();
		return apiService.excute(operand, first, next);
	}

}
