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
import com.google.gson.GsonBuilder;
import com.nacre.online_assesment.delegate.PlacementsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostBean;

/**
 * Servlet implementation class ShowPlacementAction
 */
@WebServlet("/ShowPlacementAction")
public class ShowPlacementAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Integer jobPostId = Integer.parseInt(request.getParameter("jobPostId"));
		System.out.println(jobPostId);
		
		JobPostBean jpb = new JobPostBean();
		jpb.setJob_Post_Id(jobPostId);
		PlacementsDelegate deligate = new PlacementsDelegate();
		ArrayList<ArrayList> placementList;
		
			placementList=deligate.getPlacementDetail(jpb);

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			//Gson gson = new Gson();
			response.setContentType("text/json");
			String placementdetailJson = gson.toJson(placementList);
			System.out.println(placementdetailJson);
			PrintWriter pw = response.getWriter();
			pw.write(placementdetailJson);
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/ErrorForPlacement.jsp");
			dispatcher.include(request, response);
		}catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/ErrorForPlacement.jsp");
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
