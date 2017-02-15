package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.PlacementsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class AssignRoundNoAction
 */
@WebServlet("/AssignRoundNoAction")
public class AssignRoundNoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer roundNo = Integer.parseInt((String) session.getAttribute("jobPostID"));
		//Integer roundNo =301;
		System.out.println("RoundNo is "+roundNo);
		
		PlacementsDelegate delegate = new PlacementsDelegate();
		try {
			Integer rno = delegate.getRoundNo(roundNo);
			Gson json = new Gson();
			response.setContentType("text/json");
			String roundNoJson = json.toJson(rno);
			System.out.println(roundNoJson);
			PrintWriter pw = response.getWriter();
			pw.write(roundNoJson);
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
