package com.revature.animals;

public class Cow extends Herbivore implements LiveBirth{

	public static void torro() {
		Cow bessy = new Cow();
		bessy.liveBirth();
		bessy.produceMilk();
		bessy.hasHair();
		bessy.moo();
		bessy.moveHow();
	}
	

	public Cow() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void liveBirth() {
		System.out.println("Ouch, That was fun.");
		
	}

	@Override
	public void produceMilk() {
		System.out.println("I'm full of milk.");
		
	}

	@Override
	public void hasHair() {
		System.out.println("Touch my hair or cut it I guess.");
	}

	@Override
	public void moveHow() {
		System.out.println("Like a Cow.");
	}
	public void moo() {
		System.out.println("MOOOOOOOO!");
	}

}
