package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentRequestFeedBackDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.GetCompanyFeebacksVo;

/**
 * @author Amarendar Guthuru
 * Servlet implementation class GetCompaniesFeebacksAction
 */
@WebServlet("/GetCompaniesFeedbacksAction.systemAdmin")
public class GetCompaniesFeebacksAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCompaniesFeebacksAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		    //Integer companyId=2;
		Integer feedbackTypeId=0;
		Integer clientId=0;
		Integer addressId=0;
		if(request.getParameter("feedbackId")!=""){
		   feedbackTypeId=Integer.parseInt(request.getParameter("feedbackId"));}
		if(request.getParameter("clientId")!=""){
			
			if(request.getParameter("addressId")!=""){
		       addressId=Integer.parseInt(request.getParameter("addressId"));
		   }
			clientId=Integer.parseInt(request.getParameter("clientId"));
		}
		   StudentRequestFeedBackDelegate backDelegate=new StudentRequestFeedBackDelegate();
		   
		   List<GetCompanyFeebacksVo> list;
		try {
			System.out.println(">>>>>>>>"+clientId+"="+feedbackTypeId+"="+addressId);
			list = backDelegate.getAllCompanyFeedbacks(feedbackTypeId,clientId,addressId);
			 response.setContentType("application/json");
			
			   Gson g=new Gson();
			   
			   
			   String companyDetails=g.toJson(list);
			  
			   System.out.println(companyDetails);
			   response.getWriter().write("{\"data\":"+companyDetails+"}");
			
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
