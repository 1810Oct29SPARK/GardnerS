package com.revature.animals;

public class GrizzlyBear extends Omnivore implements LiveBirth{

	public static void bear(){
		GrizzlyBear pooh = new GrizzlyBear();
		pooh.liveBirth();
		pooh.produceMilk();
		pooh.hasHair();
		pooh.eatWhat();
		pooh.moveHow();
		pooh.hunt();
	}
	

	public GrizzlyBear() {
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
		System.out.println("Like a Bear.");
	}

}
