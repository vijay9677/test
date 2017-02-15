package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;

/**
 * 
 * @author VijayKumar P
 * @description this servlet is using fo view job opportunities
 *
 *
 */
@WebServlet("/viewAndForwardingJobOpportunitiesAction")
public class ViewAndForwardingJobOpportunitiesAction extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = null;
		String str = null;
		ViewJobNotificationBean viewJobNotificationBean = null;
		JobOpportunityPostingDelegate jobOpportunityPostingDelegate = null;
		RequestDispatcher rd = null;
		// HttpSession session=req.getSession();
		out = res.getWriter();
		res.setContentType("text/html");

		try {
		str = req.getParameter("jobPostingID");
		HttpSession jobPId = req.getSession();
		jobPId.setAttribute("jobId", str);

		// creating delegate class object
		jobOpportunityPostingDelegate = new JobOpportunityPostingDelegate();

		
			viewJobNotificationBean = jobOpportunityPostingDelegate.viewJobOpportunity(str);

			/*
			 * 
			 * 
			 * Gson gson=new Gson(); res.setContentType("text/json");
			 * out.println(gson.toJson(viewJobNotificationBean));
			 * 
			 */
			System.out.println("in action  "+viewJobNotificationBean);
			if(viewJobNotificationBean.getCompanyName()==null || viewJobNotificationBean.getJobDescription()==null||viewJobNotificationBean.getCompanyDescription()==null){
				String sharejsp = "/jsp/admin/adminErrorPage.jsp";
				rd = getServletContext().getRequestDispatcher(sharejsp);
				rd.forward(req, res);
			}
			else{
			System.out.println("======================= view job");
			req.setAttribute("jobdetails", viewJobNotificationBean);
			String sharejsp = "/jsp/admin/retrievingJobNotification.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);
			rd.forward(req, res);
			}
		} catch (DatabaseException | SQLException e) {
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(req, res);
			

			e.printStackTrace();
		}
		catch (Exception e) {
			
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(req, res);
			
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
