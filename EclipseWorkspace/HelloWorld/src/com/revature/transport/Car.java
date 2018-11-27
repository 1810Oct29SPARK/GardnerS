package com.revature.transport;

public class Car extends Vehicle implements Steerable{
	
	public static final double recommendedMilesBetweenOilChange = 5000.00;

	public Car(int yearManufactured, String make, String model, double milesSinceOilChange) {
		super();
		this.yearManufactured = yearManufactured;
		this.make = make;
		this.model = model;
		this.milesSinceOilChange = milesSinceOilChange;
	}

	public Car() {
		//super means public Vehicle(){super();} this constructs from the Object class.
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Car [yearManufactured=" + yearManufactured + ", make=" + make + ", model=" + model
				+ ", milesSinceOilChange=" + milesSinceOilChange + "]";
	}

	private int yearManufactured;
	private String make;
	private String model;
	private double milesSinceOilChange;
	
	@Override
	public void move() {
		System.out.println("Moving");
	}

	public int getYearManufactured() {
		return yearManufactured;
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getMilesSinceOilChange() {
		return milesSinceOilChange;
	}

	public void setMilesSinceOilChange(int milesSinceOilChange) {
		this.milesSinceOilChange = milesSinceOilChange;
	}

	@Override
	public void turnLeft() {
		System.out.println("turned Left");
		
	}

	@Override
	public void turnRight() {
		System.out.println("turned Right");
		
	}
}
