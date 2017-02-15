package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet("/getDateAndRoundDescriptionInAjaxCallAction")
public class GetDateAndRoundDescriptionInAjaxCallAction extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/json");
		List<String> dateAndDescription=null;
		  HttpSession session=req.getSession(false);  
		//Integer jobPostingId=2;
		String jobPid=(String)session.getAttribute("jobId");
		Integer jobPostingId=Integer.parseInt(jobPid);
		NotificationDelegate notificationDelegate=new NotificationDelegate();
		 try {
			 dateAndDescription=notificationDelegate.getDateAndRoundDescriptionInAjaxCall(jobPostingId);
		
			 Gson gson = new Gson();

				String json = gson.toJson(dateAndDescription);
				out.println(json);
		 } catch (SQLException | DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
