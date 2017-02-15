package com.nacre.online_assesment.action;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AdminAnalyticsDelegate;
import com.nacre.online_assesment.delegate.ApplyRequestOpportunityPostingDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
/**
 * @author JAY SINGH 
 *
 */


@WebServlet("/JobPostingNotificationAction") 
public class JobPostingNotificationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public JobPostingNotificationAction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doPost(request, response);
	System.out.println("hi jay you are in doget()");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplyRequestOpportunityPostingDelegate del=new ApplyRequestOpportunityPostingDelegate();
		PrintWriter pw=response.getWriter();
		List l=null;
		 try {
			l=del.getNotifications();
			System.out.println("l="+l);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hi jay you are in doget()");
		System.out.println(" list"+l);
	
		
		
			Gson gson = new Gson();
			response.setContentType("text/json");
			System.out.println(gson.toJson(l));
			String jobPostDetails = gson.toJson(l);
			pw.println(jobPostDetails);
			
			
		
	}


	

}
