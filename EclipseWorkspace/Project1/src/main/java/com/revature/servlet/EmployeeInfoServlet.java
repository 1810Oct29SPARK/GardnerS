package com.revature.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.EmployeeService;

public class EmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService = new EmployeeService();
    
    public EmployeeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	    Enumeration<String> headerNames = request.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	    	String key = (String) headerNames.nextElement();
	    	System.out.println(key);
	    	if (key.equals("change")) {
	    		String json = employeeService.getEmployeeJSON(request.getParameter("username"),request.getParameter("password"));
	    		response.getWriter().write(json);
	    	}
	    	else if (key.equals("all")) {
	    		String reimbursements = employeeService.getEmployeeReimbursement(2);//switch this 2 to the session stored userid.
	    		response.getWriter().write("["+reimbursements+"]");
	    	}
	    	else if (key.equals("reimbursement")) {
	    		employeeService.setEmployeeReimbursement(6, request.getParameter("description"), Double.parseDouble(request.getParameter("amount")));//change the 6 to the session id
	    	}
	    	else if (key.equals("info")) {
	    		employeeService.setEmployeeInfo(request.getParameter("field"), request.getParameter("value"), 1);//change the 1 to the session stored userid.
	    	}
	    }
		
		
		// TODO Auto-generated method stub
		//execute the below only if the request had these paramenters
		//String json = employeeService.getEmployeeJSON(request.getParameter("username"),request.getParameter("password"));
		//String reimbursements = employeeService.getEmployeeReimbursement(2);//switch this 2 to the session stored userid.
		//response.getWriter().write(json);
		//response.getWriter().write("["+reimbursements+"]");
		//employeeService.setEmployeeInfo(request.getParameter("field"), request.getParameter("value"), 1);//change the 1 to the session stored userid.
		//employeeService.setEmployeeReimbursement(6, "Ooops! I accidently stole the ambergris from a whale.", 500.99);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}