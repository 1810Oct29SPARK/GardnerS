package com.revature.example;

public class StringsAndArrays {

	public static void main(String[] args) {
		funWithStrings();
	}
//this is to make sure the method belongs to the class not the method
	static void funWithStrings() {
		//string literal
		String a = "hello";
		String b = new String("hello");
		//.equals() is inheirited from Object.
		//most referencetypes override to define equality (by the fields).
		//string has been overridden to check the string literal
		System.out.println("string a is equal to sting b " +a.equals(b));
		//== compares primitives, as well as chekcing wether two objects are the same object.
		//compares the reference.
		System.out.println(a==b);
		
	}
}
