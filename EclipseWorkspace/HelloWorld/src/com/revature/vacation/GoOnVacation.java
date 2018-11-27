package com.revature.vacation;

import com.revature.transport.*; //all classes in the package are imported.
	//to get a specific class, use import packagePath.classname;

	//static imports within a class
import static com.revature.transport.Car.*;

public class GoOnVacation {

	public static void main(String[] args) {
		System.out.println("Let's Go!");
		System.out.println("We need a car!");
		//using fully qualified class name.
		//com.revature.transport.Car c = new com.revature.transport.Car();
		//could use import statements instead.
		Car c = new Car(1997,"Nissan","Pathfinder",3000.00);
		System.out.println(c.toString());
		//how did this print out something else for Emily?
		//is it becuase of the difference between Eclipse and STS?
		//I don't think we overrode toString().
		//huh. Ask about it at break.
		//Solution, in Car press Source then Generate toString();
		System.out.println(recommendedMilesBetweenOilChange-c.getMilesSinceOilChange());
		if (c.getMilesSinceOilChange()>=Car.recommendedMilesBetweenOilChange) {
			System.out.println("Change your oil.");
		}
		else {
			System.out.println("You good.");
		}
		System.out.println("Let's go Sea Kayaking.");
		Kayak k = new Kayak();
		k.setColor("blue");
		System.out.println(k.getColor());
		System.out.println(k);
		System.out.println(chooseAVehicle());
	}
	static Vehicle chooseAVehicle() {
		Vehicle chosenVehicle = null;
		Vehicle[] vehicles = {new Tornado(),new Car(),new Kayak(),new Boat()};
		//check for steerable vehicles that are not boats.
		for (int i=0;i<vehicles.length;i++) {
			if (vehicles[i] instanceof Steerable && !(vehicles[i] instanceof Boat)) {
				chosenVehicle = vehicles[i];
				System.out.println(chosenVehicle);
				return chosenVehicle;
			}
		}
		return chosenVehicle;
	}

}
