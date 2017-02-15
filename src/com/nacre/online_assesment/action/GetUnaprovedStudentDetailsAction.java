package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.URLConstants;


/**
 * @authors Srikanth and krunal B35. This Action Is To get All un_approved student details to validate
 */
@WebServlet("/GetUnaprovedStudentDetailsAction.admin")
public class GetUnaprovedStudentDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetUnaprovedStudentDetailsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		StudentRegistrationValidationDelegate studentRegistrationDeligate = new StudentRegistrationValidationDelegate();
		
		List unaprovedStudentList;
		try {
			unaprovedStudentList = studentRegistrationDeligate.getUnaprovedStudentDetails();
		
		
		request.setAttribute("unaprovedList", unaprovedStudentList);
		} catch (DatabaseException e) {
			RequestDispatcher rd = request.getRequestDispatcher(URLConstants._ERROR_MSG_JSP_ADMIN);
			rd.include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
