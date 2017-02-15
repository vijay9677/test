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
import com.nacre.online_assesment.dto.JobTypeDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class JobTypeSelectAction
 */
@WebServlet("/JobTypeSelectAction")
public class JobTypeSelectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobTypeSelectAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlacementsDelegate deligate = new PlacementsDelegate();
		ArrayList<JobTypeDTO> jobtypelist;
		try {
			jobtypelist = deligate.getJobTypeDetails();
		
		Gson json = new Gson();
		response.setContentType("text/json");
		String JobTypedetailJson = json.toJson(jobtypelist);
		System.out.println(JobTypedetailJson);
		PrintWriter pw = response.getWriter();
		pw.write(JobTypedetailJson);
		
		} catch (DatabaseException e) {
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
