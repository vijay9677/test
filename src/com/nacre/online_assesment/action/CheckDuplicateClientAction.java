package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.ClientManagementDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.exception.ImageStreamToByteException;

/**
 * Servlet implementation class CheckDuplicateClientAction
 */
@WebServlet("/CheckDuplicateClientAction")
public class CheckDuplicateClientAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDuplicateClientAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		String clientName=request.getParameter("clientName");
		ClientManagementDelegate clientManagementDelegate = new ClientManagementDelegate();
		
		try{
			List<Object> list = clientManagementDelegate.checkClient(clientName);
		    
		    
			Gson gson = new Gson();
			response.setContentType("text/json");
			
			pw.println(gson.toJson(list));
		}
		catch (DatabaseException | SQLException e) {
			e.printStackTrace();
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
