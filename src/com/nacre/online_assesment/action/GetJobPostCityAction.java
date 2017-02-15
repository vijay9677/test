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
 * @author Sagar Suryawanshi b 35 This Action Is To All Citys Gives Json
 *         Response Servlet implementation class GetJobPostCityAction
 */
@WebServlet("/GetJobPostCityAction.student")
public class GetJobPostCityAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetJobPostCityAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
			CommonDelegate commonDelegate = new CommonDelegate();
			try {
				List<CityDTO> cityList = commonDelegate.getJobPostcity();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
