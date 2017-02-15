package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.PlacementsDelegate;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.exception.DatabaseException;


/**
 * Servlet implementation class JobSelectAction
 */
@WebServlet("/JobSelectAction")
public class JobSelectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlacementsDelegate deligate = new PlacementsDelegate();
		ArrayList<JobPostingDTO> joblist;
		try {
			joblist = deligate.getJobDetails();
		
		Gson json = new Gson();
		response.setContentType("text/json");
		String JobdetailJson = json.toJson(joblist);
		System.out.println(JobdetailJson);
		PrintWriter pw = response.getWriter();
		pw.write(JobdetailJson);
		
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/ErrorPage.jsp");
			dispatcher.include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
