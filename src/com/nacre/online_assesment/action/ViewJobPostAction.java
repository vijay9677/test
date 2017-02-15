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
 * @author Sagar Suryawanshi b 35 This Action Is To All Job Post Gives Json
 *         Response Servlet implementation class ViewJobPostAction
 */
//@WebServlet("/ViewJobPostAction")
@WebServlet("/ViewJobPostAction.student")
public class ViewJobPostAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewJobPostAction() {
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
		JobOpportunityPostingDelegate deligate = new JobOpportunityPostingDelegate();
		try {
			List<Object> list = deligate.getjobPostDetails();
		/*	for (Object object : list) {
				if (object instanceof JobPostingDTO) {
					JobPostingDTO jobpostdto = (JobPostingDTO) object;
					// System.out.println("I found a JobPostingDTO class");
					System.out.println(jobpostdto.getJobPostId());
					System.out.println(jobpostdto.getDescription());
					System.out.println(jobpostdto.getPostDate());
				}

				if (object instanceof ClientDTO) {
					ClientDTO clientdto = (ClientDTO) object;
					System.out.println(clientdto.getClientName());

					// System.out.println("I found a ClientDTO class");
				}
				if (object instanceof AddressDTO) {
					AddressDTO addressdto = (AddressDTO) object;
					System.out.println(addressdto.getLocation());

					// System.out.println("I found a AddressDTO class");

				}
				if (object instanceof StatusDTO) {
					StatusDTO statusdto = (StatusDTO) object;
					System.out.println(statusdto.getStatusId());

					// System.out.println("I found a StatusDTO class");

				}
			}
*/
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
