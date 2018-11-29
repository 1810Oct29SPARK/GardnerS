package com.revature.example;

import java.util.Arrays;
import com.revature.transport.*;

public class StringsAndArrays {

	public static void main(String[] args) {
		funWithStrings();
		funWithArrays();
	}
	static void funWithArrays() {
		String[] arr1 = {"this","is","an","array"};
		String[] arr2 = new String[4];
		arr2 = new String[]{"el1","el2","el3","el4"};
		
		int[][] arr3 = new int[4][3];
		arr3[0][0] = 7;
		arr3[1][1] = 8;
		arr3[3][2] = 9;
		
		for(int[] a : arr3) {
			System.out.println(Arrays.toString(a));
		}
		
		Vehicle[] vehicles = new Vehicle[4];//{new Tornado(),new Car(),new Kayak(),new Boat()};
		//System.out.println(Arrays.toString(vehicles));
		//vehicles[2].move(); //complies fine but an exception is thrown
		//syntax issues throw compile time errors.
		//other errors are exceptions.
		
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
		//they point to same string literal in the string pool
		//but they are two different objects.
		
		//string methods from API
		//substring,concat,toUpperCase,toLowerCase,replace,indexOf,split,trim
	}
}
