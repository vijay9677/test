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
import com.nacre.online_assesment.dto.AddressDTO;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.StatusDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author Sagar Suryawanshi b 35 This Action Is To Particular  Job Post Description Gives Json
 *         Response Servlet implementation class JobPostDescription
 */
@WebServlet("/JobPostDescription.student")
public class JobPostDescription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JobPostDescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		System.out.println("job post id"+request.getParameter("JobpostId"));
		Integer jobpostid=Integer.parseInt(request.getParameter("JobpostId"));
		//Integer jobpostid=5;
		JobOpportunityPostingDelegate deligate = new JobOpportunityPostingDelegate();
		try {
			List<Object> list = deligate.getjobPostDescription(jobpostid);
		     Gson gson = new Gson();
			response.setContentType("text/json");
			System.out.println(gson.toJson(list));
			String jobPostDetails = gson.toJson(list);
			pw.println(jobPostDetails);
		} catch (SQLException | DatabaseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
