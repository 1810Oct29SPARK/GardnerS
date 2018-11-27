package com.revature.animals;

public class Panda extends Herbivore implements LiveBirth{

	public static void atlanta() {
		Panda lee = new Panda();
		lee.liveBirth();
		lee.produceMilk();
		lee.hasHair();
		lee.moveHow();
		lee.eatWhat();
		lee.graze();
	}
	public Panda() {
		super();
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
		System.out.println("Climp tree and fall.");
	}
	@Override
	public void graze() {
		System.out.println("I am eating leaves.");
	}
}