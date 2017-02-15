package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentRequestFeedBackDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.GetOrganisationFeedbacksVo;

/**
 * @author Amarendar Guthuru
 * Servlet implementation class GetOrganisationFeedbacksAction
 */
@WebServlet("/GetOrganisationFeedbacksAction.systemAdmin")
public class GetOrganisationFeedbacksAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrganisationFeedbacksAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Integer organisationId=1;
		Integer organisationId=Integer.parseInt(request.getParameter("feedbackId"));
		
		StudentRequestFeedBackDelegate backDelegate=new StudentRequestFeedBackDelegate();
	   try {
		List<GetOrganisationFeedbacksVo> list=backDelegate.getAllOrganisationFeedbacks(organisationId);
		response.setContentType("application/json");
		Gson g=new Gson();
		String organisationDetails=g.toJson(list);
		
		System.out.println(organisationDetails);
		 response.getWriter().write("{\"data\":"+organisationDetails+"}");
		
	} catch (DatabaseException | SQLException e) {
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
