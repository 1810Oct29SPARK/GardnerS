package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ManagerDAO;
import com.revature.dao.ManagerDAOImpl;

public class ManagerService {
	
	private ObjectMapper om = new ObjectMapper();
	
	//this method displays all the reimbursements that a manager can see
	public String getUnderReimbursementsJSON(int employeeId) {
		ManagerDAO md = new ManagerDAOImpl();
		List<Reimbursement> underlingReimbursementList = md.getAllReimbursementsOfMyUnderlings(employeeId);
		String reimbursementString = "";
		try {
			reimbursementString = om.writeValueAsString(underlingReimbursementList);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(underlingReimbursementList);
		return reimbursementString;
	}
	
	//this method grabs all the reimbursements by a particular employee that works under a manager
	public String getUnderTargetReimbursementsJSON(int employeeId, int underId) {
		ManagerDAO md = new ManagerDAOImpl();
		List<Reimbursement> underlingReimbursementList = md.getAllReimbursementsByUser(employeeId, underId);
		String reimbursementTargetString = "";
		try {
			reimbursementTargetString = om.writeValueAsString(underlingReimbursementList);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(underlingReimbursementList);
		return reimbursementTargetString;
	}
	
	//this method grabs all the employees that the manager can see
	public String getUnderlingsJSON(int employeeId) {
		ManagerDAO md = new ManagerDAOImpl();
		List<Employee> underlingList = md.getEmployees(employeeId);
		String employeesString = "";
		try {
			employeesString = om.writeValueAsString(underlingList);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(underlingList);
		return employeesString;
	}
	
	//this method adds a new user without any info to the table excpet that they report to the current user
	public void setNewUser(int employeeId, String user, String pass) {
		ManagerDAO md = new ManagerDAOImpl();
		md.setOtherUserAndPass(user, pass, employeeId);
	}
	
	//this method will change the status of a reimbursement
	public void setReimbursementStatus(String status, int rId) {
		ManagerDAO md = new ManagerDAOImpl();
		md.setUserReimbursementStatus(status, rId);
	}
	
	public void check() {
		System.out.println("Success");
	}
}
