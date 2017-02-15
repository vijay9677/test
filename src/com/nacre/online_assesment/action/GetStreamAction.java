package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentDetailsUpdationDelegate;
import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class GetStreamAction
 */
@WebServlet("/GetStreamAction.student")
public class GetStreamAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentDetailsUpdationDelegate studentDeliagte=new StudentDetailsUpdationDelegate();
		try {
			List<StreamDTO> streamList = studentDeliagte.getStreamList();
			System.out.println("url=====/GetStreamAction.student");
			Gson gson = new Gson();
			String streamsJson = gson.toJson(streamList);
			response.setContentType("text/json");
			response.getWriter().write(streamsJson);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setContentType("text/json");
			response.getWriter().write("[\"" + e.getMessage()+ "\"]");
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			response.setContentType("text/json");
			response.getWriter().write("[\"" + e.getMessage()+ "\"]");
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
