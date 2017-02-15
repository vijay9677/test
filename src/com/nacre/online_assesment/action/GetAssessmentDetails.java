package com.nacre.online_assesment.action;
/**
chitransu
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author Chitranshu Gupta  This Action to get Assessment Details
 */
/**
 * Servlet implementation class GetAssessmentDetails
 */
@WebServlet("/GetAssessmentDetailschange")
public class GetAssessmentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAssessmentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer assessmentId=Integer.parseInt(request.getParameter("assessmentId"));
		System.out.println(assessmentId);
		
		AssesmentsDelegate assesmentsDelegate=new AssesmentsDelegate();
		 
		try {
			List<Object> assessmentList = assesmentsDelegate.getAssessmentDetails(assessmentId);
			
			System.out.println(assessmentList);
			
			request.setAttribute("assessmentDetails", assessmentList);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("./jsp/assesment/home.jsp");
			requestDispatcher.forward(request, response);
			
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
