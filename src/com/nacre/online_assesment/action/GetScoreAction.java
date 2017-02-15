package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;


@WebServlet("/GetScoreAction")
public class GetScoreAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer  userId = Integer.parseInt(request.getParameter("userId"));
	
		AssesmentsDelegate assesmentsDelegate=new AssesmentsDelegate();
		try {
			List list=assesmentsDelegate.getScores(userId);
			System.out.println(list);
			
			Gson gson = new Gson();
			response.setContentType("text/json");
			PrintWriter pw = response.getWriter();
			pw.print(gson.toJson(list));
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
