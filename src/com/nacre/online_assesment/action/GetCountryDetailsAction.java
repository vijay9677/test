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
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.ErrorMessages;

/**
 * @author praveen guggilla This Action Is To get All Countries 
 *  
 *  Gives country list as response
 *         
 */
@WebServlet("/GetCountryDetailsAction.student")
public class GetCountryDetailsAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("url===/GetCountryDetailsAction.student");

		CommonDelegate commonDelegate = new CommonDelegate();
		try {
			
			List<CountryDTO> countryList = commonDelegate.getCountry();
			request.setAttribute("countryList", countryList);
			//storing countryList in request scope
			
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
