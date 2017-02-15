package com.nacre.online_assesment.action;
/**
chitransu
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
 * @author Chitranshu Gupta  This Action to get Assessment Types
 */
/**
 * Servlet implementation class SelectAssessmentType
 */
@WebServlet("/SelectAssessmentTypes")
public class SelectAssessmentTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAssessmentTypes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    AssesmentsDelegate assesmentsDelegate=new AssesmentsDelegate(); 
		try {
			List<Object> assessmentTypeList=assesmentsDelegate.getAssessmentType();
			
			System.out.println(assessmentTypeList);
			Gson gson = new Gson();
			response.setContentType("text/json");
			PrintWriter pw = response.getWriter();
			pw.print(gson.toJson(assessmentTypeList));
			
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
