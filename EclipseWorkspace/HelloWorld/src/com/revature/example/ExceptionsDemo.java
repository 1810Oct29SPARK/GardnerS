package com.revature.example;

import com.revature.transport.*;

public class ExceptionsDemo {

	public static void main(String[] args) {
		//create new Car object
		Tornado t = new Tornado();
		try {
			t.move();
		}
		catch (MaintenanceException m) {
			m.printStackTrace();
			//get into SuperCell
			t.setInSuperCell(true);
		}
		//in car change overridden move() from vehicle so that.
		//MaintenanceException is thrown if oil is down.
		
		
	}

}
