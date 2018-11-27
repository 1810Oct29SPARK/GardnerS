package com.revature.animals;

public class Goat extends Herbivore implements LiveBirth{

	public static void baal() {
		Goat billy = new Goat();
		billy.liveBirth();
		billy.produceMilk();
		billy.hasHair();
		billy.moveHow();
		billy.eatWhat();
		billy.graze();
	}
	

	public Goat() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void liveBirth() {
		System.out.println("Ouch, That was fun.");
		
	}

	@Override
	public void hasHair() {
		System.out.println("Touch my hair or cut it I guess.");
	}

	@Override
	public void moveHow() {
		System.out.println("Like a Goat.");
	}

	@Override
	public void graze() {
		System.out.println("I am grazing on grass.");
	}

}
