package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.GetClientDetailForEditingVo;

/**
 * @author Ssrinivas N
 * gets all client details form the database
 * Servlet implementation class GetClientDetailsForEditingAction
 */
@WebServlet("/getClientDetailsForEditingAction")
public class GetClientDetailsForEditingAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobOpportunityPostingDelegate jobOpportunityPostingDelegate=new JobOpportunityPostingDelegate();
		try {
			List<GetClientDetailForEditingVo> getClientDetailForEditingVosList=jobOpportunityPostingDelegate.getClientDetailsForEditing();
			System.out.println("getClientDetailForEditingVosList"+getClientDetailForEditingVosList);
			request.getSession().setAttribute("getClientDetailForEditingVosList", getClientDetailForEditingVosList);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
