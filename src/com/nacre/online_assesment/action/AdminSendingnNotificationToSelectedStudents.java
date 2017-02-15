package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.delegate.NotificationDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.SendingUserNumsAndExamDetails;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;

/**
 * 
 * @author vijaykumar p
 * @description this servlet using for sending notifications to students by
 *              admin and also sending mails
 * 
 *
 */

@WebServlet("/adminSendingnNotificationToSelectedStudents")
public class AdminSendingnNotificationToSelectedStudents extends HttpServlet {

	/**
	 * @author vijaykumar P
	 * @param req
	 * @param resp
	 * 
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		RequestDispatcher rd = null;

		try {
		// creating ArrayList object
		List<String> listemails = new ArrayList<String>();
		// creating SendingUserNumsAndExamDetails class Object
		SendingUserNumsAndExamDetails userAndExamDetails = new SendingUserNumsAndExamDetails();
		// getting Session Object
		HttpSession session2 = req.getSession(false);
		// getting jobDetails from session
		ViewJobNotificationBean viewJobNotificationBean = (ViewJobNotificationBean) session2
				.getAttribute("jobDetailsBean");

		System.out.println("view notification bean in servlet  " + viewJobNotificationBean);

		// Getting Session
		HttpSession session = req.getSession(false);

		// Storing JobPostingId in String from seesion obj
		String jobPostingId = (String) session.getAttribute("jobId");
		// converting string value to integer value
		int jobpostid = Integer.parseInt(jobPostingId);

		System.out.println("jobpostin id is     " + jobPostingId);

		// out.println("getting servlet");
		// reading userno from jsp
		String str = req.getParameter("selectedUserId");
		// reading date value from jsp
		String string = req.getParameter("dateval");
		/*
		 * SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
		 * 
		 * Date date=null; try { date = sdf.parse(string); } catch
		 * (ParseException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		// reading exam name from jsp
		String examname = req.getParameter("exam");
		System.out.println(string + "   asdf  " + examname);
		// Creating ArrayList Object
		List<Integer> userList = new ArrayList<Integer>();
		System.out.println("checkbox vales" + str);
		// iterating for each loop for getting userno in the form of string
		// numbers
		for (String retval : str.split(",")) {
			// getting user number inthe form of string
			String val = retval;
			// converting the string value into integer value
			int i = Integer.parseInt(retval);
			// adding the integer values to list
			userList.add(i);
			System.out.println(retval);
		}
		System.out.println(userList);
		// Assignining the getten results from jsp storing in
		// SendingUserNumsAndExamDetailsBean Object
		userAndExamDetails.setJobPostId(jobpostid);
		userAndExamDetails.setDate(string);
		userAndExamDetails.setExamName(examname);
		userAndExamDetails.setUserNo(userList);

		// creating NotificationDelegate Class object
		NotificationDelegate notificationDelegate = new NotificationDelegate();

			// calling the sendingNotificationToSelectStudent() method
			listemails = notificationDelegate.sendingNotificationToSelectedStudent(userAndExamDetails,
					viewJobNotificationBean);

			if (listemails != null) {

				// creating the session for request scope
				// req.setAttribute("message", "mails and notifications are
				// sended to students");

				out.write("mails and notifications are sended to students");
			} else {
				// Creating session for request scope
				req.setAttribute("message", "notifications are not sended");

				out.write("notifications are not sended");

			}
			// String sharejsp="/jsp/admin/retrievingJobNotification.jsp";

			// rd=getServletContext().getRequestDispatcher(sharejsp);
			// call forwarding to retrievingJobNotification.jsp
			// rd.forward(req, resp);

		} catch (DatabaseException | SQLException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.write("PLEASE TRY LATER");
		}
		catch(Exception e){
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(req, resp);
			
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
