package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.ClientManagementDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.GetExistingClientAddress;



/**
 * Servlet implementation class ViewClientContactAddress
 */
@WebServlet("/ViewClientContactAddress")
public class ViewClientContactAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClientContactAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
	 Integer addressId= Integer.parseInt(request.getParameter("addressId"));
	 
	 ClientManagementDelegate delegate=new ClientManagementDelegate();
	 try {
		GetExistingClientAddress existingClientAddress= delegate.getClientContactAddress(addressId);
		
		
		Gson gson=new Gson(); 
		response.setContentType("text/json");
		
		pw.println(gson.toJson(existingClientAddress));
		System.out.println(existingClientAddress);
	} catch (DatabaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
		
	}

}
