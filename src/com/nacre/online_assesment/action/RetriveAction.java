package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
import com.nacre.online_assesment.form_bean.SelectingAllstudentDetailsBean;
/**
 * 
 * @author VijayKumar P
 * @Description this servlet using for retrieving students who are elgible for jobs
 *
 */
@WebServlet("/retriveAction")
public class RetriveAction extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
JobOpportunityPostingDelegate jobOpportunityPostingDelegate=new JobOpportunityPostingDelegate();
		
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/json");
		
		RequestDispatcher rd=null;
		
       HttpSession session=req.getSession(false);  
       try { 
		
		String jobPid=(String)session.getAttribute("jobId");
		Integer jobPostingId=Integer.parseInt(jobPid);
		
		
		
			ArrayList<SelectingAllstudentDetailsBean> emailList=jobOpportunityPostingDelegate.getAllStudEmailsDetails(jobPostingId);
			
			
		    Gson jsonObj = new Gson();
			String jsonDataObj = jsonObj.toJson(emailList);
			out.println(jsonDataObj);
			
		} catch (DatabaseException | SQLException e) {
	
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(req, resp);
			
			e.printStackTrace();
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
		doGet(req,resp);
	}

}
