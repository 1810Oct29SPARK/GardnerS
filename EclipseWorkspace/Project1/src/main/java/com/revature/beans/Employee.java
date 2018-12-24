package com.revature.beans;

public class Employee {

	public String firstName;
	public String lastName;
	public String email;
	public String phone;
	public String id;
	public String isManager;
	
	public Employee(String firstName, String lastName, String email, String phone, String id, String isManager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.id = id;
		this.isManager = isManager;
	}
	
}
