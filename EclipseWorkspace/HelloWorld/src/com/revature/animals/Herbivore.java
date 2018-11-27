package com.revature.animals;

public abstract class Herbivore extends Mammals {
	public Herbivore() {
		super();
	}
	@Override
	public void eatWhat(){
		System.out.println("I eat Plants and Such");
	}
	public void graze() {
		System.out.println("I'm eating stuff right now.");
	}
}
