package com.revature.transport;

public class Boat extends Vehicle implements Steerable{
	
	protected String color;
	protected double hullLength;
	
	public Boat() {
		super();
		System.out.println("no arg Boat");
	}

	@Override
	public String toString() {
		return "Boat [color=" + color + ", hullLength=" + hullLength + "]";
	}

	public Boat(String color, double hullLength) {
		super();
		System.out.println("Boat Super Called");
		this.color = color;
		this.hullLength = hullLength;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getHullLength() {
		return hullLength;
	}

	public void setHullLength(double hullLength) {
		this.hullLength = hullLength;
	}

	@Override
	public void move() {
		System.out.println("Boat");
	}

	@Override
	public void turnLeft() {
		System.out.println("turned");
		
	}

	@Override
	public void turnRight() {
		System.out.println("turned else");
		
	}
}
