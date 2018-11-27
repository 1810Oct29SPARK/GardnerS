package com.revature.transport;

public class Kayak extends Boat{

	private int numSeats;
	private double paddleLength;



	public Kayak(String color, double hullLength, int numSeats, double paddleLength) {
		super(color, hullLength);
		this.numSeats = numSeats;
		this.paddleLength = paddleLength;
		System.out.println("Stuff got called");
	}

	public Kayak(int numSeats, double paddleLength) {
		super();
		this.numSeats = numSeats;
		this.paddleLength = paddleLength;
	}

	@Override
	public String toString() {
		return "Kayak [numSeats=" + numSeats + ", paddleLength=" + paddleLength + ", color=" + color + ", hullLength="
				+ hullLength + "]";
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public double getPaddleLength() {
		return paddleLength;
	}

	public void setPaddleLength(double paddleLength) {
		this.paddleLength = paddleLength;
	}

	public Kayak() {
		super();
		System.out.println("Kayak noArgs Constructot Called");
	}

	public Kayak(String color, double hullLength) {
		super(color, hullLength);
	}
	

}
