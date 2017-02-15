
/**
 * @author praveen guggilla

 * 
 * this action is used for retrieving student personal,educational & courses details
 * to display  
 */

package com.nacre.online_assesment.action;

import java.io.IOException;




import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentDetailsUpdationDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

@WebServlet("/PersonalDetailsAction.student")
public class PersonalDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	System.out.println("url===/PersonalDetailsAction.student");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentDetailsUpdationDelegate srdeligate=new StudentDetailsUpdationDelegate();
		
		try {
			
			Integer userId=(Integer)request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
			
			if((userId!=null) || (userId!=0)){
				
				List studentDetails=srdeligate.getStudentProfile(userId);
				
				request.setAttribute("studentDetails", studentDetails);
				System.out.println("from action>>>>>>>>>>>>>>>."+studentDetails);
				
				Gson gson = new Gson();
				String studentDetails1 = gson.toJson(studentDetails);
				response.setContentType("text/json");
			}
		} catch (DatabaseException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/"+URLConstants.STUDENT_HOME_PAGE_URL);
			
		}catch (NullPointerException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/"+URLConstants.STUDENT_HOME_PAGE_URL);
			
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/"+URLConstants.STUDENT_HOME_PAGE_URL);

		}
	
	}
}
