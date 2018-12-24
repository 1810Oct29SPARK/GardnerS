package com.revature.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

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
	    		System.out.println("status works");
	    		managerService.setReimbursementStatus(request.getParameter("status"), Integer.parseInt(request.getParameter("reimbursementId")));
	    		break;
	    	}
	    	else if (key.equals("total")) {
	    		//HttpSession session = request.getSession(false);
	    		String json = managerService.getUnderReimbursementsJSON(Integer.parseInt(request.getParameter("id")));
	    		//String json = managerService.getUnderReimbursementsJSON((int) session.getAttribute("ID"));//i got to switch this to the session data
	    		response.getWriter().write("["+json+"]");
	    		break;
	    	}
	    	else if (key.equals("single")) {
	    		//HttpSession session = request.getSession(false);
	    		String otherJSON = managerService.getUnderTargetReimbursementsJSON(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("target")));
	    		//String otherJSON = managerService.getUnderTargetReimbursementsJSON((int) session.getAttribute("ID"), Integer.parseInt(request.getParameter("target")));//i got to switch this to the session data
	    		response.getWriter().write("["+otherJSON+"]");
	    		break;
	    	}
	    	else if (key.equals("people")) {
	    		//HttpSession session = request.getSession(false);
	    		String employeeJSON = managerService.getUnderlingsJSON(Integer.parseInt(request.getParameter("id")));
	    		//String employeeJSON = managerService.getUnderlingsJSON((int) session.getAttribute("ID"));//i got to switch this to the session data
	    		response.getWriter().write("["+employeeJSON+"]");
	    		break;
	    	}
	    	else if (key.equals("hired")) {
	    		//HttpSession session = request.getSession(false);
	    		System.out.println("hired works");
	    		managerService.setNewUser(Integer.parseInt(request.getParameter("id")), request.getParameter("username"), request.getParameter("password"));
	    		//managerService.setNewUser((int) session.getAttribute("ID"), request.getParameter("username"), request.getParameter("password"));
	    		break;
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
