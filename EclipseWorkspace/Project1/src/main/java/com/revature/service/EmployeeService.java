package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class EmployeeService {
	
	private ObjectMapper om = new ObjectMapper();

	//this method grabs the JSON of the employee for display
	public String getEmployeeJSON(String username, String password){
		List<Employee> employeeList = new ArrayList<Employee>();
		EmployeeDAO ed = new EmployeeDAOImpl();
		String[] results = ed.getUserInfo(username,password);
//		System.out.println(results[0]);
//		System.out.println(results[1]);
//		System.out.println(results[2]);
//		System.out.println(results[3]);
		//how to get these results passed into the constructor?
		//thank you Jake.
		//i needed to move my connection properties file
		Employee emp = new Employee(results[0],results[1],results[2],results[3],results[4]);
		employeeList.add(emp);
		String employeeString = "";
		//String check = "";
		try {
			employeeString = om.writeValueAsString(employeeList);
			//check = "Shucks! from EmployeeService";
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return employeeString;//+check;
	}
	
	//this method grabs all the reimbursements associated with the current user
	public String getEmployeeReimbursement(int employeeId) {
		EmployeeDAO ed = new EmployeeDAOImpl();
		List<Reimbursement> reimbursementList = ed.getUserReimbursements(employeeId);
		String reimbursementString = "";
		try {
			reimbursementString = om.writeValueAsString(reimbursementList);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return reimbursementString;
	}
	
	//this method changes a value of a field in the database based on user input
	public void setEmployeeInfo(String fieldToSet, String valToSet, int employeeId) {
		EmployeeDAO ed = new EmployeeDAOImpl();
		ed.setUserInfo(fieldToSet, valToSet, employeeId);
	}
	
	public void setEmployeeReimbursement(int employeeId, String description, double amount) {
		EmployeeDAO ed = new EmployeeDAOImpl();
		ed.setUserReimbursement(employeeId, description, amount);
		
	}

}