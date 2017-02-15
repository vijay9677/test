package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.NotificationDelegate;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 *  @author Mounika
 * Servlet implementation class GetAssessmentDetailsToTechTeamAction
 */
@WebServlet("/GetAssessmentDetailsToTechTeam.techTeam")
public class GetAssessmentDetailsToTechTeamAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAssessmentDetailsToTechTeamAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creating PrintWriter Object
		PrintWriter out=response.getWriter();
		//setting Content type
		response.setContentType("text/json");
		//Creating NotificationDelegate object
		NotificationDelegate notificationDelegate=new NotificationDelegate();
		try {
			List<AssesmentDTO> assessmentDetails=notificationDelegate.notificatioRegardingAssessmentToTechAdminDelegate();
			
			
			//out.println("Count= "+assessmentDetails.size());
			//storing the detaills list in to request Scope
			HttpSession session=request.getSession();
			session.setAttribute("AssesmentDetailsList",assessmentDetails);
			System.out.println("hieee @Action");
			//creating json object
			Gson gson = new Gson();
			//converting received list into json format
			String json=gson.toJson(assessmentDetails);
				out.print(json);
		
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
