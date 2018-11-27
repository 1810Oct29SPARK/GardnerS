package com.revature.animals;

public abstract class Carnivore extends Mammals {
	public Carnivore() {
		super();
	}
	@Override
	public void eatWhat(){
		System.out.println("I eat animals.");
	}
	public void hunt() {
		System.out.println("I'm watching you while salivating.");
	}
}
