package com.revature.example;

class Bird {
	{
		System.out.println("instance block in bird");
	}

	Bird() {
		super();
		System.out.println("bird constructor");
	}

	static {
		System.out.println("static block in bird");
	}
}

class Raptor extends Bird {

	static {
		System.out.println("static block in raptor");
	}

	public Raptor() {
		super();
		System.out.println("raptor constructor");
	}

	{
		System.out.println("instance block in raptor");
	}
	static {
		System.out.println("second static block in raptor");
	}
}

public class Owl extends Raptor {

	public static void main(String[] args) {
		System.out.println("init");
		new Owl();
		System.out.println("owl");
	}

}



