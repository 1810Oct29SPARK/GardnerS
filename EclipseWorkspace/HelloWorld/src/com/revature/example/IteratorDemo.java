package com.revature.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class IteratorDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> exampleList=new ArrayList<Integer>();
		exampleList.add(6);
		exampleList.add(15);
		exampleList.add(49);
		exampleList.add(61);
		exampleList.add(72);
		exampleList.add(90);
		System.out.println(exampleList);
		//get the iterator
		Iterator<Integer> iterator1 = exampleList.iterator();
//		while (iterator1.hasNext()) {
//			if (iterator1.next()%2 !=0) {
//				iterator1.remove(); //remove odd numbers in-place
//				//should not be done during a for loop
//			}
//		}
		System.out.println(exampleList);
		
		//step through two collections at once
		
		Vector<String> v = new Vector<String>(3, 2);
		//(3, 2) "3" is the initial capacity, "2" is how much it will grow by when surpassing initial capacity
		
		v.addElement("red");
		v.addElement("green");
		v.addElement("blue");
		v.addElement("orange");
		
		//get Vector's iterator
		Iterator<String> iterator2 = v.iterator();
		
		while (iterator1.hasNext() && iterator2.hasNext()){
			System.out.println("next value in ArrayList i: "+iterator1.next());
			System.out.println("next value in Vector v: "+iterator2.next());
		}	
		//side note && vs &, | vs ||
		//the doubles are short circuit operators - second operand is not checked
		//if...
		//for &&, if first operand is false
		//for ||, if first operand is true
		//singles are 'bitwise' operators
		//preference is short-circuit (&& ||)
	
	}

}
