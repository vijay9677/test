package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.delegate.StudentDetailsUpdationDelegate;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.StudentCoursesBean;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

/**
 * @author praveen guggilla
 * 
 * this action is used to update student courses
 * 
 * Servlet implementation class TestAction
 */
@WebServlet("/UpdateStudentCoursesAction.student")
public class UpdateStudentCoursesAction extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        
		
		try {
			
			Integer userId=(Integer)request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
		  
			    List<CourseDTO> list =  new ArrayList<>();
			    
			       String []courses= request.getParameterValues("courses[]");
			       
			       for(String coursesList:courses){
			    	   
			    	   CourseDTO dto = new CourseDTO();
			    	    
			    	    dto.setCourse(coursesList);
			    	    
			    	    list.add(dto);
			       }
			       System.out.println("from courses action==="+list);
			       
				StudentDetailsUpdationDelegate deligate=new StudentDetailsUpdationDelegate();
				
				if((userId!=null) || (userId!=0)){
					deligate.updateStudentCourses(list, userId);
				}
				
				}catch (DatabaseException | SQLException e) {
					e.printStackTrace();
				     response.sendRedirect(request.getContextPath()+"/"+URLConstants.EDIT_PROFILE+"?errormsg=please check the details that you have entered");

				}catch (NullPointerException e) {
					e.printStackTrace();
					
					response.sendRedirect(request.getContextPath()+"/"+URLConstants.STUDENT_HOME_PAGE_URL);
					
				}catch (Exception e) {
					e.printStackTrace();
				     response.sendRedirect(request.getContextPath()+"/"+URLConstants.EDIT_PROFILE+"?errormsg=sorry, please re-enter your data");
				}
	}
	}
