package com.revature.transport;

public class Tornado extends Vehicle{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	public Tornado() {
		super();
	}
	
	private boolean isInSuperCell;
	
	public boolean isInSuperCell() {
		return isInSuperCell;
	}
	public void setInSuperCell(boolean isInSuperCell) {
		this.isInSuperCell = isInSuperCell;
	}
	@Override
	public void move() throws MaintenanceException{
		if(!this.isInSuperCell) {
			throw new MaintenanceException("Weather machine is broke.");
		}
		System.out.println("Scream.");
	}

}
