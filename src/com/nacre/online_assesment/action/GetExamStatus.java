package com.nacre.online_assesment.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author Chitranshu Gupta  This Action to get Exam Status isAttempted or not
 */
/**
 * Servlet implementation class GetExamStatus
 */
@WebServlet("/GetExamStatus")
public class GetExamStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetExamStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Integer assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
			Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		AssesmentsDelegate delegate=new AssesmentsDelegate();
		try {
			String status = delegate.getExamStatus(assessmentId, userId);
			
			System.out.println(status);
			
			Gson gson=new Gson();
			response.setContentType("text/json");
			response.getWriter().println(gson.toJson(status));
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
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
