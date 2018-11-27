package com.revature.transport;

//abstract classes cannot be instantiated.
//useful when you want it to be a reference type but nothing more
//if there are any abstract methods, the class must be abstract.
//I want each child to have move. 
//I will have to implement this method in the first concrete subclass.
//there is no concrete keyword.

public abstract class Vehicle {
	public Vehicle() {
		super();
		System.out.println("Vehicle Constructor Called");
	}

	public abstract void move();
}
