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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.PlacementsDelegate;
import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostBean;



/**
 * Servlet implementation class RoundSelectAction
 */
@WebServlet("/RoundSelectAction")
public class RoundSelectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer job_post_id=null;
		try {
		if(request.getParameter("job_post_id")!=null){
		job_post_id = Integer.parseInt(request.getParameter("job_post_id"));
		}
		//Integer job_post_id = 303;
		System.out.println(job_post_id);
		HttpSession session = request.getSession();
		session.setAttribute("jobPostID", request.getParameter("job_post_id"));
		JobPostBean jpb = new JobPostBean();
		jpb.setJob_Post_Id(job_post_id);
		
		PlacementsDelegate deligate = new PlacementsDelegate();
		ArrayList<InterviewRoundDTO> Roundlist;
		
			Roundlist = deligate.getRoundDetails(jpb);
		
		Gson json = new Gson();
		response.setContentType("text/json");
		String rounddetailJson = json.toJson(Roundlist);
		System.out.println(rounddetailJson);
		PrintWriter pw = response.getWriter();
		pw.write(rounddetailJson);
		} catch (DatabaseException e) {
			//e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/ErrorPage.jsp");
			dispatcher.include(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/ErrorPage.jsp");
			dispatcher.include(request, response);
			
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
