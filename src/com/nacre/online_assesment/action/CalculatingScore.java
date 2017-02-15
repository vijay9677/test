package com.nacre.online_assesment.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.CurrentQuestionDetailsBean;

/**
 * @author Chitranshu Gupta  This Action used to Calculate Score of Assessment
 */

@WebServlet("/CalculatingScore")
public class CalculatingScore extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Integer  userId = Integer.parseInt(request.getParameter("userId"));
		Integer assessmentId= Integer.parseInt(request.getParameter("assessmentId"));
		String selectedOptions = request.getParameter("selectedOptions");
		Integer assessmentQuesId = Integer.parseInt(request.getParameter("assessmentQuesId"));
		
		
		CurrentQuestionDetailsBean detailsBean=new CurrentQuestionDetailsBean();
		
		detailsBean.setAssessmentQuesId(assessmentQuesId);
		detailsBean.setSelectedOptions(selectedOptions);
		detailsBean.setUserId(userId);
		detailsBean.setAssessmentId(assessmentId);
		
		AssesmentsDelegate assesmentsDelegate=new AssesmentsDelegate();
		try {
			assesmentsDelegate.calculateScore(detailsBean);
	
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
