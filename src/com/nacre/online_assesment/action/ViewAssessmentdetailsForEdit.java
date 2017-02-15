package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class ViewAssessmentdetailsForEdit
 */
@WebServlet("/ViewAssessmentdetailsForEdit")
public class ViewAssessmentdetailsForEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAssessmentdetailsForEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @author pavan pratap singh b-35
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer assessmentId=Integer.parseInt(request.getParameter("assessmentId"));
		
		AssesmentsDelegate delegate=new AssesmentsDelegate();
		try {
			AssesmentDTO data= delegate.getAssessmentDetailsForEdit(assessmentId);
			
			PrintWriter pw=response.getWriter();
			
			Gson gson = new Gson();
			response.setContentType("text/json");
		
			//System.out.println(data);
			pw.print(gson.toJson(data));
			
			
			
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
