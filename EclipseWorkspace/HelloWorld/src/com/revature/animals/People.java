package com.revature.animals;

public class People extends Omnivore implements LiveBirth{

	public static void homo() {
		People jon = new People();
		jon.liveBirth();
		jon.produceMilk();
		jon.hasHair();
		jon.eatWhat();
		jon.moveHow();
		jon.hunt();
		jon.throwThing();
	}
	
	public void throwThing() {
		System.out.println("Trunks, People throw good. Fight me.");
	}
	

	public People() {
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
		System.out.println("Ambulates.");
	}

	@Override
	public void hunt() {
		System.out.println("I watching you groceries.");
	}

}
