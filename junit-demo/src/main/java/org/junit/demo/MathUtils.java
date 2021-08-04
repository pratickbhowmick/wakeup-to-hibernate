package org.junit.demo;

import org.junit.demo.client.CalculatorService;

public class MathUtils {
	CalculatorService calculatorService;
	
	
	
	public MathUtils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MathUtils(CalculatorService calculatorService) {
		super();
		this.calculatorService = calculatorService;
	}

	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		return a/b;
	}
	
	public double computeCircleArea(double radius) {
		return Math.PI * radius * radius;
	}
	
	public int perform(int a, int b) {
		return calculatorService.add(a, b)*a; // calculatorService.add(a, b) has to be mocked while testing as this is an external service
	}

}
