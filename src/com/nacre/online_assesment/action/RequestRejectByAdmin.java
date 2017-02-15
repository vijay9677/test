package com.nacre.online_assesment.action;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.AdminDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
/**
 * @author JAY SINGH 
 *
 */


/**
 * Servlet implementation class RequestRejectByAdmin
 */
@WebServlet("/RequestRejectByAdmin")
public class RequestRejectByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestRejectByAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @author jay singh
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Integer userId=2;
		Integer userId=Integer.parseInt(request.getParameter("apply_Student_Id"));
		//System.out.println(userId);
		AdminDelegate ad=new AdminDelegate();
		try {
			//System.out.println("hi jay u are in service");
			ad.rejectRequest(userId);
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
