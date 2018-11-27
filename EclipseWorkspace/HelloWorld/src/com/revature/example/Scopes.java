package com.revature.example;

public class Scopes {

	public static String variable1 = "V1";
	//static variable class-member
	//in the class/static scope
	
	public String variable2;
	//if it is not static it needs to be made in an object
	//this is a variable that all instances will have
	//instance scope
	//not defined outside of an object of type Scope
	
	//shadowing is something you can do to have multiple variables with the same name
	//phenomenon same name variables with different scopes.
	//confusing, check out GeeksForGeeks
	
	//constructor is shadowing the instance variable of the same name.
	//this prepended to the variable name references the
	//instance variable instead of the local scoped variable
	public Scopes(String variable2) {
		this.variable2 = variable2;
	}
	
	public static void main(String[] args) {
		System.out.println(variable1);
		Scopes s = new Scopes("V2"); //making an instance of variable2;
		System.out.println(s.variable2); //variable2 is defined for an instance of the class.
		s.myMethod("variable3AsAString");
	}
	
	//variable3 only exists here, no access anywhere else.
	public void myMethod(String variable3) {
		System.out.println(variable3);
		//block scope below
		//i is only defined for the for loop
		for (int i=0;i<10;i++) {
			System.out.println("value of i is: "+i);
		}
		if (variable3.equals("V3")) {
			System.out.println("V3Sucka");
		}
		else {
			System.out.println(variable3);
		}
	}

}
