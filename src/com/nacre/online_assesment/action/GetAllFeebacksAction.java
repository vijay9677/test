package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentRequestFeedBackDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.ViewAllFeedbacksVo;


/**
 * @author Amarendar Guthuru
 */

/**
 * Servlet implementation class GetAllFeebacksAction
 */
//@WebServlet("/GetAllFeebacksAction")
@WebServlet("/GetAllFeebacksAction.systemAdmin")

public class GetAllFeebacksAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllFeebacksAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		StudentRequestFeedBackDelegate delegate=new StudentRequestFeedBackDelegate();
		try {
		List<ViewAllFeedbacksVo> list=delegate.getAllFeedbacks();
		
	
		Gson g=new Gson();
		String feedbackDetails=g.toJson(list);
		response.setContentType("application/json");
		System.out.println(feedbackDetails);
		response.getWriter().write("{\"data\":"+feedbackDetails+"}");
		//response.getWriter().write(feedbackDetails);

			
		
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
