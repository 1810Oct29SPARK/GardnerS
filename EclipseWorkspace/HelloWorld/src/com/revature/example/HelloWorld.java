package com.revature.example;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		//how to create an object instance of the calculator class.
		Calculator calc = new Calculator();
		System.out.println(calc.add(1, 2));
		System.out.println(calc.toString());
		
		//example thing
		String s ="5";
		Double d = Double.parseDouble(s);
		//check type of d, should be parsed as the wrapper class Double
		//not the primitive double(which is why .getClass() works.)
		System.out.println(d.getClass());
		
	}
}
