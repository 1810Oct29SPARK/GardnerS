package com.revature.dao;

import java.io.File;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface EmployeeDAO {

	//public String[] getUserPass();
	//I think the above can be done with the below so I cut it.
	
	//this one will log the user in if everything if they exist
	public String[] getUserInfo(String username, String password);
	
	//this one will allow the user that is loged in to change the value of one of their fields
	public void setUserInfo(String fieldToSet, String valToSet, int employeeId);
	
	//this will display a list of reimbursements to the user
	public List<Reimbursement> getUserReimbursements(int employeeId);
	
	//this will allow the user to build a new reimbursement
	public void setUserReimbursement(int employeeId, String description, double amount);//, File pic);
	
	
	
}
