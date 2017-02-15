package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * /**
 * @author Srinivas N
 * This action will give technology list in the form of json
 * Servlet implementation class EditJobpostingTechnologyAjaxAction
 */
@WebServlet("/EditJobpostingTechnologyAjaxAction")
public class EditJobpostingTechnologyAjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
		
		JobOpportunityPostingDelegate jobopportunityPostingdelegate=new JobOpportunityPostingDelegate();
		try {
			List<TechnologyDTO> technologyDTOslist =jobopportunityPostingdelegate.getTechnologyDetail();
			Gson gson=new Gson();
			String tecnologyJson=gson.toJson(technologyDTOslist);
			response.getWriter().print(tecnologyJson);
			System.out.println("EditJobpostingTechnologyAjaxAction json--"+tecnologyJson);
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
