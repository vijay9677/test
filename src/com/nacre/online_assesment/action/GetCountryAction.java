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
 * @author Vijay Kumar Reddy K This Action Is To All Countries Gives Json
 *         Response Servlet implementation class GetCountryAction
 */
@WebServlet("/GetCountryAction")
public class GetCountryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCountryAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CommonDelegate commonDelegate = new CommonDelegate();
		try {
			List<CountryDTO> countryList = commonDelegate.getCountry();
		
			request.setAttribute("countryList", countryList);
			
			Gson gson = new Gson();
			String countriesJson = gson.toJson(countryList);
			response.setContentType("text/json");
			response.getWriter().write(countriesJson);
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
