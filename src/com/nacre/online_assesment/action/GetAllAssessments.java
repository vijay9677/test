package com.nacre.online_assesment.action;
/**
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author Chitranshu Gupta  This Action to get all assessmentNames and thier assessmentId
 */

/**
 * Servlet implementation class GetAssessmentDetails
 */
@WebServlet("/GetAllAssessments")
public class GetAllAssessments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllAssessments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer assessmentTypeId=1;//Integer.parseInt(request.getParameter("assessmentTypeId"));
		System.out.println(assessmentTypeId);
		
		AssesmentsDelegate assesmentsDelegate=new AssesmentsDelegate();
		try {
			List<Object> assessmentList = assesmentsDelegate.getAssessments(assessmentTypeId);
			
			System.out.println(assessmentList);
			Gson gson = new Gson();
			response.setContentType("text/json");
			PrintWriter pw = response.getWriter();
			pw.print(gson.toJson(assessmentList));
			
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
