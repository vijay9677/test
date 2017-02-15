package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.dto.AssesmentTypeDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AssesmentTypeBean;

/**
 * @author RROCK Rohit Kumar Singh b35
 * Servlet implementation class bookSlotsAction
 */
@WebServlet("/GetAssesmentTypeAction")
public class GetAssesmentTypeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//calling doPost(request,response)
		doPost(request, response);
		
	}//doGet(request, response)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	System.out.println("in getAssesmentTypeAction");
		
		/**
		 * set response content type
		 */
			//response.setContentType("text/html");
		
		/**
		 * get PrintWriter object	
		 */
		PrintWriter out=response.getWriter();
			
									
			//get Delegate object
			AssesmentsDelegate assdelegate=new AssesmentsDelegate();
			ArrayList<Object> listdto=null;
			
			try {
				listdto=assdelegate.getAssessmentTypeName();
		
				Gson gson=new Gson();
				String asstyName=gson.toJson(listdto);
			//	System.out.println(">>>>>>>>>>>>>"+asstyName);
	
				response.setContentType("text/json");
				
				out.println(asstyName);
			
				
			}//try
			catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.write(e.getMessage());
			}//catch
		
		
	}//doPost(request, response)

}//class
