package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentDetailsUpdationDelegate;
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

/**@author praveen guggilla
 * 
 * Servlet implementation class GetCoursesAction
 */
@WebServlet("/GetCoursesAction.student")
public class GetCoursesAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		System.out.println("/GetCoursesAction.student ====url");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			 Integer userId=(Integer)request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
			
			 StudentDetailsUpdationDelegate deligate=new StudentDetailsUpdationDelegate();
			
			response.setContentType("text/json");
			
			if((userId!=null) || (userId!=0)){
				List<CourseDTO> coursesList=deligate.getCourseList(userId);
				Gson gson = new Gson();
				String coursesJson = gson.toJson(coursesList);
				response.getWriter().write(coursesJson);
				}
	 } catch (DataNotFoundException e) {
	     
		 response.sendRedirect(request.getContextPath()+"/"+URLConstants.EDIT_PROFILE+"?errormsg=courses not available");

	}catch (NullPointerException e) {
		
		response.sendRedirect(request.getContextPath()+"/"+URLConstants.STUDENT_HOME_PAGE_URL);
		
	}catch (Exception e) {
		
		response.sendRedirect(request.getContextPath()+"/"+URLConstants.STUDENT_HOME_PAGE_URL);
	}
		
	}
}
