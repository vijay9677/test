package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.NotificationDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.exception.InvalidUserException;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.vo.AssessmentNotification;
import com.sun.javafx.binding.StringConstant;

/**
 * @author Manish kumar deo This Action Is To All AssessmentNotifacation Gives
 *         Json Response Servlet implementation class StudentNotificationAction
 */
@WebServlet("/StudentNotificationAction")
public class StudentNotificationAction extends HttpServlet {
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse res)
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// get printwriter object
		PrintWriter pw = res.getWriter();
		HttpSession session=req.getSession();
		 // session.setAttribute("userId", userId);
	
		Integer userId = (Integer)session.getAttribute(StringConstants._SESSION_USER_ID);
		// create AssessmentNotification object
		AssessmentNotification assessmentNotification = new AssessmentNotification();
		assessmentNotification.setUserId(userId);

		// create NotificationDelegate object
		NotificationDelegate notificationDelegate = new NotificationDelegate();
		try {
			List<AssessmentNotification> notifications = notificationDelegate
					.studentNotification(userId);
			session.setAttribute("assesmentnotifications", notifications);
			

			// System.out.println("Hi at action");

			Gson gson = new Gson();
			String assesmentNotijson = gson.toJson(notifications);
			// set content type
			res.setContentType("text/json");
			pw.println(assesmentNotijson);

		} catch (InvalidUserException e) {
			e.printStackTrace();

		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse res)
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
