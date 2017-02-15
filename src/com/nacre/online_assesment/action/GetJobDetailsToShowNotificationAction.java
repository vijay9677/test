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
import com.nacre.online_assesment.form_bean.JobDetailsBean;
import com.nacre.online_assesment.util.StringConstants;



/**
 * @author Gajanan Debadwar  This Action to get List of Notifications
 */

/**
 * Servlet implementation class GetJobDetailsToShowNotification
 */
@WebServlet("/getJobDetailsToShowNotification")
public class GetJobDetailsToShowNotificationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetJobDetailsToShowNotificationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/json");
		
		PrintWriter pw = response.getWriter();
		List<JobDetailsBean> list = null;
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute(StringConstants._SESSION_EMAIL);
		//email = "gajanandebadwar3@gmail.com";
		NotificationDelegate deligate = new NotificationDelegate();
		list = deligate.getJobDetailsToShowNotification(email);
		//pw.println(list);
		
		Gson gson = new Gson();
	    String json = gson.toJson(list);
		pw.println(json);
	}

}
