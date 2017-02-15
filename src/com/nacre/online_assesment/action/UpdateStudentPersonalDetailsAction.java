package com.nacre.online_assesment.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.DateUtil;
import com.nacre.online_assesment.util.ImageUtil;
import com.nacre.online_assesment.util.URLConstants;
import com.nacre.online_assesment.vo.StudentPersonalDetailsToVerifyBean;


/**
 * @authors Srikanth and krunal B35. This Action Is To update student personal details
 */
@WebServlet("/UpdateStudentPersonalDetailsAction.admin")
public class UpdateStudentPersonalDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentPersonalDetailsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		StudentPersonalDetailsToVerifyBean bean = new StudentPersonalDetailsToVerifyBean();
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		String fname = (String) request.getParameter("fname");
		String lname = (String) request.getParameter("lname");
		String mail = (String) request.getParameter("mail");
		String mobile = (String) request.getParameter("mobile");
		Integer gender =  Integer.parseInt(request.getParameter("gender"));
		String location = (String) request.getParameter("location");
		String pincode = request.getParameter("pincode");
		Integer cityID =  Integer.parseInt(request.getParameter("cityId"));
		String dob = request.getParameter("dob");
		String image = request.getParameter("image");
		
		
		
		bean.setUserId(userId);
		bean.setFname(fname);
		bean.setLname(lname);
		bean.setMail(mail);
		bean.setMobileNo(mobile);
		bean.setGender(gender);
		bean.setImage(image);
		
		System.out.println("dob in action "+dob);
		if(dob.contains("/")){
		Date d =DateUtil.stringToSqlDate(dob, "yyyy/MM/dd");
		System.out.println("date  formate"+d);
		bean.setDob(new java.sql.Date(d.getTime()));
		}else{
			Date d =DateUtil.stringToSqlDate(dob, "yyyy-MM-dd");
			System.out.println("date  formate"+d);
			bean.setDob(new java.sql.Date(d.getTime()));
		}
		bean.setLocation(location);
		bean.setPincode(pincode);
		bean.setCity_id(cityID);
		
		
				
		StudentRegistrationValidationDelegate deligate = new StudentRegistrationValidationDelegate();
		try {
			deligate.updateStudentPersonalDetails(bean);
		} catch (DatabaseException e) {
			RequestDispatcher rd = request.getRequestDispatcher(URLConstants._ERROR_MSG_JSP_ADMIN);
			rd.include(request, response);
		}
		
		
		
		System.out.println("from servlet fname "+fname);
		System.out.println("from servlet lname "+lname);
		System.out.println("mail "+mail);
		System.out.println("mobile no "+mobile);
		System.out.println("genderId "+gender);
		System.out.println("location "+location);
		System.out.println("cityID "+cityID);
		System.out.println("dob "+dob);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
