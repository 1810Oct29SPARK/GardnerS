package com.revature.animals;

public abstract class Omnivore extends Mammals {
	public Omnivore() {
		super();
	}
	@Override
	public void eatWhat(){
		System.out.println("I eat everything.");
	}
	public void hunt() {
		System.out.println("I'm watching you.");
	}
}
