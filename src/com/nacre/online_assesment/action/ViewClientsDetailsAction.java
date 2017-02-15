package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.ClientManagementDelegate;
import com.nacre.online_assesment.exception.DatabaseException;




/**
 * @author Sonali Chavan Action for viewing clients details at the time of page loading
 * return List of client Details object
 */

/**
 * Servlet implementation class ViewClientsDetailsAction
 */
@WebServlet("/ViewClientsDetailsAction")
public class ViewClientsDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClientsDetailsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		ClientManagementDelegate deligate = new ClientManagementDelegate();
		try {
			List<Object> list = deligate.getClientDetails();
			
			
			Gson gson = new Gson();
			response.setContentType("text/json");
			System.out.println(gson.toJson(list));
			String jobPostDetails = gson.toJson(list);
			pw.println(jobPostDetails);
		} catch (SQLException | DatabaseException e) {
			e.printStackTrace();
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
