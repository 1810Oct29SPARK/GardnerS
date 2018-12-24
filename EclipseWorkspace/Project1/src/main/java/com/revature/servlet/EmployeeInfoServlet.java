package com.revature.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

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
	    	if (key.equals("info")) {
	    		System.out.println("talking");
	    		String json = employeeService.getEmployeeJSON(request.getParameter("username"),request.getParameter("password"));
	    		response.getWriter().write(json);
	    		break;
	    	}
	    	else if (key.equals("all")) {
	    		//HttpSession session = request.getSession(false);
	    		System.out.println("commune");
	    		String reimbursements = employeeService.getEmployeeReimbursement(Integer.parseInt(request.getParameter("id")));
	    		//String reimbursements = employeeService.getEmployeeReimbursement((int) session.getAttribute("ID"));//switch this 2 to the session stored userid.
	    		response.getWriter().write("["+reimbursements+"]");
	    		break;
	    	}
	    	else if (key.equals("reimbursement")) {
	    		//HttpSession session = request.getSession(false);
	    		System.out.println("bulloney");
	    		employeeService.setEmployeeReimbursement(Integer.parseInt(request.getParameter("id")), request.getParameter("description"), Double.parseDouble(request.getParameter("amount")));
	    		//employeeService.setEmployeeReimbursement((int) session.getAttribute("ID"), request.getParameter("description"), 2.9);//Double.parseDouble(request.getParameter("amount")));//change the 6 to the session id
	    		break;
	    	}
	    	else if (key.equals("change")) {
	    		//HttpSession session = request.getSession(false);
	    		System.out.println("stuff");
	    		employeeService.setEmployeeInfo(request.getParameter("field"), request.getParameter("value"), Integer.parseInt(request.getParameter("id")));
	    		//employeeService.setEmployeeInfo(request.getParameter("field"), request.getParameter("value"), (int) session.getAttribute("ID"));//change the 1 to the session stored userid.
	    		break;
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