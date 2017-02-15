package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.CommonDelegate;
import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.dto.UniversityDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;


/**
 * @author praveen guggilla batch 35
 * 
 * This Action is to get All university list
 */

@WebServlet("/GetUniversitiesAction.student")
public class GetUniversitiesAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentRegistrationValidationDelegate srdeligate=new StudentRegistrationValidationDelegate();
		
		try {
			System.out.println("url===/GetUniversitiesAction.student");
			List<UniversityDTO> universityList=srdeligate.getUniversities();
			//System.out.println("from action"+universityList);
			Gson gson = new Gson();
			String universityJson = gson.toJson(universityList);
			response.setContentType("text/json");
			response.getWriter().write(universityJson);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setContentType("text/json");
			response.getWriter().write("[\"" + e.getMessage()+ "\"]");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
