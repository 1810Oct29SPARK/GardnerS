package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;

public interface ManagerDAO {

	//this method will change the status of pending reimbursements
	public void setUserReimbursementStatus(String status, int rId);
	
	//this method will grab all reimbursements by all the employees that report directly to this manager
	public List<Reimbursement> getAllReimbursementsOfMyUnderlings(int employeeId);
	
	//this method will get all reimbursements submitted by a particular employee
	public List<Reimbursement> getAllReimbursementsByUser(int userId, int underlingId);
	
	//this method gets all the employees working in the company
	public List<Employee> getEmployees(int userId);
	
	//this method sets a new user's username and password
	public void setOtherUserAndPass(String user, String pass, int boss);
	

}
