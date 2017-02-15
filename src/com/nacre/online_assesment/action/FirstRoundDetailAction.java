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
import com.google.gson.GsonBuilder;
import com.nacre.online_assesment.delegate.PlacementsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobRoundBean;


/**
 * Servlet implementation class FirstRoundDetailAction
 */
@WebServlet("/FirstRoundDetailAction")
public class FirstRoundDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Integer roundDetailId = Integer.parseInt(request.getParameter("roundId"));
		System.out.println("round id "+request.getParameter("roundId"));
		JobRoundBean roundBean = new JobRoundBean();
		roundBean.setInterview_round_id(roundDetailId);
		HttpSession session = request.getSession();
		session.setAttribute("roundId", request.getParameter("roundId"));
		PlacementsDelegate deligate = new PlacementsDelegate();
		ArrayList<ArrayList> firstRoundlist;
		
			firstRoundlist = deligate.getFirstRoundDetail(roundBean);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//Gson gson = new Gson();
		response.setContentType("text/json");
		String firstRounddetailJson = gson.toJson(firstRoundlist);
		System.out.println(firstRounddetailJson);
		PrintWriter pw = response.getWriter();
		pw.write(firstRounddetailJson);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
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
