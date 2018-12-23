package com.revature.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.ManagerService;

public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerService managerService = new ManagerService();
	
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	    Enumeration<String> headerNames = request.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	    	String key = (String) headerNames.nextElement();
	    	System.out.println(key);
	    	if (key.equals("status")) {
	    		managerService.setReimbursementStatus(request.getParameter("status"), Integer.parseInt(request.getParameter("reimbursementId")));
	    	}
	    	else if (key.equals("total")) {
	    		String json = managerService.getUnderReimbursementsJSON(1);//i got to switch this to the session data
	    		response.getWriter().write("["+json+"]");
	    	}
	    	else if (key.equals("single")) {
	    		String otherJSON = managerService.getUnderTargetReimbursementsJSON(1, Integer.parseInt(request.getParameter("target")));//i got to switch this to the session data
	    		response.getWriter().write("["+otherJSON+"]");
	    	}
	    	else if (key.equals("people")) {
	    		String employeeJSON = managerService.getUnderlingsJSON(1);//i got to switch this to the session data
	    		response.getWriter().write("["+employeeJSON+"]");
	    	}
	    	else if (key.equals("hired")) {
	    		managerService.setNewUser(1, request.getParameter("username"), request.getParameter("password"));
	    	}
	    }
	    
				
		
//		String json = managerService.getUnderReimbursementsJSON(1);
//		response.getWriter().write("["+json+"]");
//		String otherJSON = managerService.getUnderTargetReimbursementsJSON(1, 2);
//		response.getWriter().write("["+otherJSON+"]");
//		String employeeJSON = managerService.getUnderlingsJSON(1);
//		response.getWriter().write("["+employeeJSON+"]");
		//managerService.setNewUser(1, "paul", "boyo");
		//managerService.setReimbursementStatus("Approved", 5);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
