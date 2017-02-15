package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ShowJobDetailsBean;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;

/**
 * @author Rajnish b 35 This Action Is To All jobposting id with all data in the notification  Gives Json
 *         Response Servlet implementation class JobPostingNotificatonAction
 */
@WebServlet("/JobPostingNotificatonActionRajnish")
public class JobPostingNotificatonActionRajnish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/json");
		List<ShowJobDetailsBean> list =null;
		JobOpportunityPostingDelegate JobOpportunityPostingDelegate = new JobOpportunityPostingDelegate();
		try {
			
			 list = JobOpportunityPostingDelegate.getjobPostingIdNotification();
			
			Gson gson= new Gson();
			String jobpostingid =	gson.toJson(list);
			pw.println(jobpostingid);
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
