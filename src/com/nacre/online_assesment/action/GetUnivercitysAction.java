package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.dto.UniversityDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.URLConstants;


/**
 * @authors Srikanth and krunal B35. This Action Is To get All university list
 */
@WebServlet("/GetUnivercitysAction.admin")
public class GetUnivercitysAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUnivercitysAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/json");
		
		StudentRegistrationValidationDelegate deligate = new StudentRegistrationValidationDelegate();
		 List<UniversityDTO> univercityList;
		try {
			univercityList = deligate.getunivercityes();
		
		 Gson gson= new Gson();
			String univJson =	gson.toJson(univercityList);
			
			response.getWriter().write(univJson);
		} catch (DatabaseException e) {
			RequestDispatcher rd = request.getRequestDispatcher(URLConstants._ERROR_MSG_JSP_ADMIN);
			rd.include(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
