package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 *@author Srinivas N
 * Getting all client details 
 * Servlet implementation class GetClientDetailsAction
 */
@WebServlet("/getClientDetailsAction")
public class GetClientDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobOpportunityPostingDelegate jobOpportunityPostingDelegate=new JobOpportunityPostingDelegate();
		try {
			List<ClientDTO> clientDTOsList=jobOpportunityPostingDelegate.getClientDetails();
			System.out.println("List"+clientDTOsList);
			
			request.getSession().setAttribute("ClientDTO", clientDTOsList);
			
			
			
	
		} catch (DatabaseException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
