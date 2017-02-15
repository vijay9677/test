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
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;

/**
 * @author Srinivas N
 * Based on the city id it will gives client address
 * Servlet implementation class GetLocationNamesOfCloentAjaxAction
 */
@WebServlet("/GetLocationNamesOfClientAjaxAction")
public class GetLocationNamesOfClientAjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
		Integer clientId=Integer.parseInt(request.getParameter("clientId"));
		System.out.println("ClientId----"+clientId);
		JobOpportunityPostingDelegate jobOpportunityPostingDelegate=new JobOpportunityPostingDelegate();
		try {
			List<ClientAddressDetailVo> list = jobOpportunityPostingDelegate.getClientAddressDetail(clientId);
		
		Gson g = new Gson();
		String s= g.toJson(list);
		response.getWriter().print(s);
		System.out.println("list..."+list);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			response.getWriter().print("[]");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			response.getWriter().print("[]");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
