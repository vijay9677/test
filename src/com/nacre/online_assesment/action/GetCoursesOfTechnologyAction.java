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
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.URLConstants;


/**
 * @authors Srikanth and krunal B35. This Action Is To get All courses based on technology
 */
@WebServlet("/GetCoursesOfTechnologyAction.admin")
public class GetCoursesOfTechnologyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCoursesOfTechnologyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/json");
		Integer techId = Integer.parseInt(request.getParameter("techId"));
		//System.out.println("tech id "+techId);
		 
		 StudentRegistrationValidationDelegate deligate = new StudentRegistrationValidationDelegate();
		 
		 List<CourseDTO> courseList;
		try {
			courseList = deligate.getCourses(techId);
		
		 
		 Gson gson= new Gson();
			String courseJson =	gson.toJson(courseList);
			
			response.getWriter().write(courseJson);
		} catch (DatabaseException e) {
			RequestDispatcher rd = request.getRequestDispatcher(URLConstants._ERROR_MSG_JSP_ADMIN);
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
