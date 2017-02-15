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
import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ShowJobDetailsBean;
import com.nacre.online_assesment.util.URLConstants;

/**
 /**
 * @author Rajnish 35 This Action Is To jobPostingId  Gives Json
 *         Response Servlet implementation class JobPostTechnologyAction
 */
 

@WebServlet("/JobPostingNotificationDetailAction")
public class JobPostingNotificationDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   PrintWriter pw=response.getWriter();
        response.setContentType("text/html");
       String jpID = request.getParameter("jobPostingID");
   int jobPostingID = Integer.valueOf(jpID);
      

        
		ShowJobDetailsBean bean = null;
		JobOpportunityPostingDelegate JobOpportunityPostingDelegate = new JobOpportunityPostingDelegate();
		try {
			bean = new ShowJobDetailsBean();
		
			 bean = JobOpportunityPostingDelegate.getjobPostingIdNotificationDetail(jobPostingID);
		   //pw.println(bean);
			request.setAttribute("bean", bean);
			RequestDispatcher rd = request.getRequestDispatcher("/viewAndForwardingJobOpportunitiesAction?jobPostingID="+jpID);
			rd.forward(request, response);
			
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
