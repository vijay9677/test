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
import com.nacre.online_assesment.form_bean.PersonalDetailsBean;
import com.nacre.online_assesment.form_bean.StudentCoursesBean;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

/**
 * @author praveen guggilla batch 35
 * 
 * this action is used for updating student personal details
 * 
 * Servlet implementation class UpdateStudentDetailsAction
 */
@WebServlet("/UpdateStudentDetailsAction.student")
public class UpdateStudentDetailsAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		System.out.println("url===/UpdateStudentDetailsAction.student");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		Integer userId=(Integer)request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
		
		
		System.out.println("from update student details action........");
		
		String mobilenum=request.getParameter("mobileno");
		String location=request.getParameter("location");
		String email=request.getParameter("email");
		
		String pc=request.getParameter("pincode");
		Integer pincode=0;
		if(pc!=null){
		pincode=Integer.parseInt(pc);
		}
		String technology=request.getParameter("technology");
		
		String cid=request.getParameter("cityid");
		System.out.println("city id=="+cid);
		Integer cityId=0;
		if(cid!=null){
		cityId=Integer.parseInt(cid);
		}
		
		System.out.println("from action="+technology);
		System.out.println("city id from action==="+cityId);
		
		PersonalDetailsBean pdb=new PersonalDetailsBean();
		pdb.setMail(email);
		pdb.setMobile(mobilenum);
		pdb.setLocation(location);
		pdb.setPincode(pincode);
		pdb.setTechnology(technology);
		pdb.setCityId(cityId);
		if((userId!=null) || (userId!=0)){
			pdb.setUserId(userId);
		}
		System.out.println("from student personaldetails action====="+pdb);
		
		StudentDetailsUpdationDelegate deligate=new StudentDetailsUpdationDelegate();
		Integer result=deligate.updateStudentProfile(pdb);
		
	System.out.println("result=="+result);
		if(result!=0){
			
			  System.out.println("succcess Msg");
			response.setContentType("text/json");
			response.getWriter().print("{\"successMsg\":\"you have successfully updated your profile\"}");
			
		}else{
		System.out.println("fMsg");
		response.setContentType("text/json");
		response.getWriter().print("{\fMsg\":\"Failed to update your profile\"}");
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
 