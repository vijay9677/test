package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.delegate.StudentDetailsUpdationDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.StudentEducationBean;
import com.nacre.online_assesment.util.DateUtil;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

/**
* @author praveen guggilla batch 35
* 
* this action is used for updating student post graduation details
*/

@WebServlet("/UpdateStudentPostgraduationDetailsAction.student")
public class UpdateStudentPostgraduationDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
		System.out.println("url====/UpdateStudentPostgraduationDetailsAction.student");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {	
			
		System.out.println("im from p.g action======");
		System.out.println("url====/UpdateStudentPostgraduationDetailsAction.student");

		Integer userId=(Integer)request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
		
		String ui=request.getParameter("univpg");
		Integer univId=0;
		
		if(ui!=null){
		univId=Integer.parseInt(ui);
		System.out.println("univ id"+univId);
		}
		
		String college=request.getParameter("collegepg");
		System.out.println("college id"+college);
		
		String stre=request.getParameter("streampg");
		Integer streamId=0;
		
		if(stre!=null){
		streamId=Integer.parseInt(stre);
		System.out.println("stream id"+streamId);
		}
		

		//converting date
		String yop=request.getParameter("yoppg");
		Date sql=DateUtil.stringToSqlDate(yop, "yyyy");
		SimpleDateFormat formater = new SimpleDateFormat("yyyy");
		java.util.Date utilDate;
		java.sql.Date sqlDate = null;
		try 
		{
			utilDate = formater.parse(yop);
			sqlDate = new java.sql.Date(utilDate.getTime());
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("yop"+yop);
		
		String perc=request.getParameter("percentagepg");
		
		System.out.println("per   "+perc);

		String ct=request.getParameter("citypg");
		Integer cityId=0;
		if(ct!=null){
		cityId=Integer.parseInt(ct);
		System.out.println("cityId"+cityId);
		}
		String location=request.getParameter("locationpg");
		System.out.println("location"+location);
		
		StudentEducationBean studentEducationBean=new StudentEducationBean();
		studentEducationBean.setYear_of_pass(sqlDate);
		studentEducationBean.setPercent_grade(perc);
		studentEducationBean.setStreamId(streamId);
		
		studentEducationBean.setCollege(college);
		if(univId!=null){
		studentEducationBean.setUniversityId(univId);
		}
		
		studentEducationBean.setCityId(cityId);
		studentEducationBean.setLocation(location);
		
		if((userId!=null) || (userId!=0)){
			studentEducationBean.setUser_id(userId);
		}
		
		//----------------------------retrieve this education type from form or database
		
		studentEducationBean.setEdu_type(StringConstants.EDUCATION_TYPE_PG);
		
		StudentDetailsUpdationDelegate studentUpdateDeligate=new StudentDetailsUpdationDelegate();
		
			
			Integer resultFinal=studentUpdateDeligate.updateStudentPostGradDetails(studentEducationBean);
			System.out.println("resultFinal=="+resultFinal);
		    
		if(resultFinal!=0){
			
			     response.sendRedirect(request.getContextPath()+"/"+URLConstants.EDIT_PROFILE+"?successmsg=you have successfully updated your post graduation details");
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
