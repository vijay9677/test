package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.CommonDelegate;
import com.nacre.online_assesment.dto.StateDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.ErrorMessages;

/**
 * Servlet implementation class GetStateAction
 */
@WebServlet("/GetStateAction")
public class GetStateAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = request.getParameter("countryId");
		System.out.println("country id"+ cid);
		response.setContentType("text/json");
		
		if(cid!=null){
			Integer countryId = Integer.parseInt(cid);
			CommonDelegate commonDelegate = new CommonDelegate();
			try {
				List<StateDTO> stateList = commonDelegate.getState(countryId);
				Gson gson= new Gson();
			     String stateJson =	gson.toJson(stateList);
			
			response.getWriter().write(stateJson);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				response.getWriter().write("[\""+e.getMessage()+"\"]");
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				response.getWriter().write("[\""+e.getMessage()+"\"]");
			}
			
		}else{
			

			response.getWriter().write("[\""+ErrorMessages._ERR_COUNTRY_ID+"\"]");
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
