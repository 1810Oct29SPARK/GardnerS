package com.revature.example;

import java.util.Arrays;

public class ArraysExamples {
	static String[] stupid = {"2","5","12","544444","7"};
	static boolean bullShit = Arrays.asList(stupid).contains("7");
	public static void main(String[] args) {
		System.out.println(bullShit);
	}
}

