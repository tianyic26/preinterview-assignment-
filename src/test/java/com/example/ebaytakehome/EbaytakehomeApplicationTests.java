package com.example.ebaytakehome;

import com.example.ebaytakehome.component.Operation;
import com.example.ebaytakehome.controller.CalculateController;
import com.example.ebaytakehome.model.CalculatorRequest;
import com.example.ebaytakehome.model.ChainCalculateRequest;
import com.example.ebaytakehome.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculatorTest {

	@Autowired
	private CalculateService calculatorService;

	@Test
	void testAddOperations() throws Exception {
		assertEquals(5, calculatorService.calculate(new CalculatorRequest("add", 2, 3)));
		assertEquals(5, calculatorService.calculate(new CalculatorRequest("add", 7, -2)));
		assertEquals(4.1, calculatorService.calculate(new CalculatorRequest("add", 3.6, 0.5)));


	}

	@Test
	void testSubtractOperations() throws Exception {
		assertEquals(-1, calculatorService.calculate(new CalculatorRequest("subtract", 2, 3)));
		assertEquals(14, calculatorService.calculate(new CalculatorRequest("subtract", 4, -10)));
		assertEquals(6, calculatorService.calculate(new CalculatorRequest("subtract", -4, -10)));
		assertEquals(3.1, calculatorService.calculate(new CalculatorRequest("subtract", 3.6, 0.5)));


	}

	@Test
	void testDivideOperations() throws Exception {
		assertEquals(2, calculatorService.calculate(new CalculatorRequest("divide", 6, 3)));
		assertEquals(4, calculatorService.calculate(new CalculatorRequest("divide", -1, -0.25)));
		assertEquals(0.6666666666666666, calculatorService.calculate(new CalculatorRequest("divide", 2, 3)));
	}

	@Test
	void testMultiplyOperations() throws Exception {
		assertEquals(8, calculatorService.calculate(new CalculatorRequest("multiply", -2, -4)));
		assertEquals(6, calculatorService.calculate(new CalculatorRequest("multiply", 2, 3)));
		assertEquals(0, calculatorService.calculate(new CalculatorRequest("multiply", 2, 0)));
		assertEquals(2.52, calculatorService.calculate(new CalculatorRequest("multiply", 3.6, 0.7)));	}




	@Test
	void testDivisionByZero() {
		assertThrows(ArithmeticException.class, () -> calculatorService.calculate(new CalculatorRequest("divide", 5, 0)));
	}

	@Test
	void testUnsupportedOperation() {
		assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(new CalculatorRequest("unknown", 1, 7)));
	}

	@Test
	void testChainCalculate() {
		List<Double> nums= Arrays.asList(3.0, 2.0, 1.0,4.0);
		List<String> ops= Arrays.asList("add", "multiply", "subtract","divide");
		double result = calculatorService.chainCalculate(new ChainCalculateRequest(5,
				ops,
				nums));
		assertEquals(3.75, result);
	}

	@Test
	void testChainCalculateInvalidInput() {
		List<Double> nums= Arrays.asList(3.0 );
		List<String> ops= Arrays.asList("add", "multiply", "subtract");
		assertThrows(IllegalArgumentException.class, () ->  calculatorService
				.chainCalculate(new ChainCalculateRequest(5, ops, nums)));
	}

	@Test
	void testChainCalculateUnsupprotedOperatioons() {
		List<Double> nums= Arrays.asList(3.0,1.0,3.0);
		List<String> ops= Arrays.asList("add", "unknown", "subtract");
		assertThrows(IllegalArgumentException.class, () ->  calculatorService
				.chainCalculate(new ChainCalculateRequest(5, ops, nums)));
	}

	@Test
	void testChainCalculateZeroDivide() {
		List<Double> nums= Arrays.asList(3.0,0.0,3.0 );
		List<String> ops= Arrays.asList("add", "divide", "subtract");
		assertThrows(ArithmeticException.class, () ->  calculatorService
				.chainCalculate(new ChainCalculateRequest(5, ops, nums)));
	}
}