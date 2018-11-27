package com.revature.animals;

public class Platypus extends Carnivore {

	public static void plat() {
		Platypus perry = new Platypus();
		perry.eggLay();
		perry.produceMilk();
		perry.hasHair();
		perry.eatWhat();
		perry.moveHow();
		perry.hunt();
	}
	

	public Platypus() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void eggLay() {
		System.out.println("Ouch, That was fun. I laid an egg. It's gross.");
		
	}

	@Override
	public void hasHair() {
		System.out.println("Touch my hair or cut it I guess. I have poison.");
	}

	@Override
	public void moveHow() {
		System.out.println("I'm a weirdo, I got a beaver tail.");
	}

	@Override
	public void eatWhat() {
		System.out.println("I am eating bugs.");
	}

}
