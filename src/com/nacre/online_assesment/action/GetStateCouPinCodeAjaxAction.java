package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo;
import com.nacre.online_assesment.vo.GettingLocationCurespondingVO;

/**
 * @author Srinivas N
 * based on the address id it will gives related city, state, country and pin code to the caller
 * Servlet implementation class GetStateCouPinCodeAjaxAction
 */
@WebServlet("/GetStateCouPinCodeAjaxAction")
public class GetStateCouPinCodeAjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
		
Integer addressId = Integer.parseInt(request.getParameter("aId"));
		
		// i have to store location based on addresId related
		// city,sate,country,pine code of an particular client
     JobOpportunityPostingDelegate j=new JobOpportunityPostingDelegate();
     try {
    	 GettingLocationCurespondingDetailsvo  gettingLocationCurespondingVO=j.getLocationRelatedAddres(addressId);
    	 Gson g=new Gson();
    	 String json=g.toJson(gettingLocationCurespondingVO);
    	 response.getWriter().write(json);
    	 System.out.println("json-----------"+json);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DatabaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
