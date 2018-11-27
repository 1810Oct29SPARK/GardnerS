package com.revature.animals;

public class Orca extends Carnivore implements LiveBirth{

	public static void orc() {
		Orca willy = new Orca();
		willy.liveBirth();
		willy.produceMilk();
		willy.hasHair();
		willy.eatWhat();
		willy.moveHow();
		willy.hunt();
	}
	
	public Orca() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void hasHair() {
		System.out.println("I ain't got much hair.");
	}

	@Override
	public void moveHow() {
		System.out.println("I swim. But like Good.");
	}

	@Override
	public void eatWhat() {
		System.out.println("I am eating anything. I'm evil. Like the worst.");
	}
	@Override
	public void liveBirth() {
		System.out.println("Baby.");
		
	}

}
