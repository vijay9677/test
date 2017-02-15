package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.CommonDelegate;
import com.nacre.online_assesment.dto.CityDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.ErrorMessages;

/**
 * Servlet implementation class GetCityId
 */
@WebServlet("/GetCityAction")
public class GetCityAction extends HttpServlet implements Servlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("stateId");
		System.out.println("state id"+sid);
		response.setContentType("text/json");
		
		if(sid!=null){
			Integer stateId = Integer.parseInt(sid);
			CommonDelegate commonDelegate = new CommonDelegate();
			try {
				List<CityDTO> cityList = commonDelegate.getcity(stateId);
				System.out.println(cityList);
				Gson gson= new Gson();
			String cityJson =	gson.toJson(cityList);
			
			response.getWriter().write(cityJson);
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
			

			response.getWriter().write("[\""+ErrorMessages._ERR_STATE_ID+"\"]");
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
