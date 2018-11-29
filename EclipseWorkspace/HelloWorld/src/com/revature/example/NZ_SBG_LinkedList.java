package com.revature.example;

import java.util.LinkedList;
import java.util.Spliterator;

public class NZ_SBG_LinkedList {

	public static void main(String[] args) {
		LinkedList<String> veggies = new LinkedList<String>();
		veggies.add("Blumenkohl");
		veggies.add("Kartoffel");
		veggies.pop();
		veggies.add("Karrotten");
		veggies.add(1,"Spargel");
		veggies.add("Gurke");
		veggies.push("Zwiebel");
		Spliterator<String> veggiesSplit = veggies.spliterator();
		veggiesSplit.forEachRemaining((v)->System.out.println("I like to eat "+v));
	}
}
/*
 *General Description
 *	Linked Lists are real similar to the arrays in Javascript.
 *	You have similar methods, you can have duplicates and empty values.
 *  It's Indexed, kinda, more like ordered, and not synchronized. 
 * 
*/
