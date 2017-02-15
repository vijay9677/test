package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author Srinivas N 
 * It gives all technologies for the coller 
 * Servlet implementation class JobPostingTechnology
 */
@WebServlet("/JobPostingTechnology")
public class JobPostingTechnologyaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JobOpportunityPostingDelegate jobopportunityPostingdelegate = new JobOpportunityPostingDelegate();
		
		try {
			List<TechnologyDTO> technologyDTOslist =jobopportunityPostingdelegate.getTechnologyDetail();
			System.out.println("technologyDTOslist"+technologyDTOslist);
			request.setAttribute("technologyDTOslist",technologyDTOslist);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
		
	}

}
