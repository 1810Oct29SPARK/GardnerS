package com.revature.example;

public class ControlFlow {

	public static void main(String[] args) {
		ifStatements(5.6,5.4);
		forLoops();
		whileLoops();
		switchCases();

	}
	static void ifStatements(double a, double b) {
		//can have as many else ifs as you need but it gets more complicated
		if (a > b) {
			System.out.println("a is bigger than b");
		}
		else if (a == b) {
			System.out.println("a is b");
		}
		else {
			System.out.println("a is smaller than b");
		}
	}
	static void forLoops() {
		for (int i=0;i<10;i++) {
			System.out.println(i);
		}
		/*
			break and continue
			break exists the structure
				it terminates the loop or whatever
			continue goes to the next iteration
		*/
		for (int j=0;;j++) {
			System.out.println(j);
			if (j==10) {break;}
		}
	}
	static void whileLoops() {
		//this is infinite without the break;
		while (true) {
			System.out.println("Thanks for the break.");
			break;
		}
		do {
			System.out.println("do stuff");
		} while (false);
	}
	static void switchCases() {
		//a switch statement allows different behaviors based on different expressions
		//can be byte,short,char,int,Enum,String,Wrapper class.
		String dayOfWeek = "Wednesday";
		switch (dayOfWeek) {
			case "Monday":System.out.println("Today is Monday");break;
			case "Wednesday":System.out.println("It is Wednesday, my dudes");break;
			case "Thursday":System.out.println("What Up?");break;
			default: System.out.println("It is the end of Days");
		}
	}

}
