package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.NotificationDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;

/**
 * @author vijaykumar P
 * @description Servlet implementation class GetJobDetailsToShowNotification
 */
@WebServlet("/getJobDetailsToShowNotificationstudentAction")
public class GetJobDetailsToShowNotificationStudentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd=null;
	
		response.setContentType("text/json");
		PrintWriter pw = response.getWriter();
		List list = null;
		try {
		// Storing userNo in String from seesion obj
		// String userId=(String)session.getAttribute("userId");
		// converting string value to integer value
		// int userNo=Integer.parseInt(userId);
			System.out.println("hello vijay ----------------------");
		int userNo = (Integer)request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
//int userNo=6;
		System.out.println("action================="+userNo);
		// Creating NotificationDeligate class On=bject
		NotificationDelegate deligate = new NotificationDelegate();
		
			// calling getJobDetailsToShowNotification() method
			list = deligate.getJobDetailsToShowNotification(userNo);

		} catch (SQLException | DatabaseException e ) {
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(request, response);
			//e.printStackTrace();
		}
		catch(Exception e){
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(request, response);
			e.printStackTrace();
		}
		// pw.println(list);

		Gson gson = new Gson();

		String json = gson.toJson(list);
		pw.println(json);
	}

}
