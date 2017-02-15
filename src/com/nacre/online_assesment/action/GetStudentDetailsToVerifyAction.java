package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @authors Srikanth and krunal B35. This Action Is To get All un_approved students list
 */
@WebServlet("/GetStudentDetailsToVerify.admin")
public class GetStudentDetailsToVerifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetStudentDetailsToVerifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
		Integer userId= Integer.parseInt(request.getParameter("user_id"));
		
		StudentRegistrationValidationDelegate studentRegistrationDeligate = new StudentRegistrationValidationDelegate();
		
		List studentDetailsToVerify;
		
			
				studentDetailsToVerify = studentRegistrationDeligate.getStudentDetailsToVerify(userId);
			
		ServletContext application=getServletContext();  

		request.setAttribute("studentDetailsList", studentDetailsToVerify);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/admin/VerifyStudent.jsp");
		rd.forward(request, response);
		} catch (DatabaseException e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/admin/ErrorPage.jsp");
			rd.include(request, response);
		}
		catch (Exception EX){
			EX.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/admin/ErrorPage.jsp");
			rd.include(request, response);
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
