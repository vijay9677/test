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

import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author Rohit Kumar Singh b35
 * Servlet implementation class getTimeSlots
 */
@WebServlet("/GetTimeSlots")
public class GetTimeSlots extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTimeSlots() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//-------------------calling doPost(-,-) method-------------
		doPost(request, response);
	}//doPost(request, response)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	System.out.println("in action : gettime");
		
		/**
		 * get PrintWriter object	
		 */
		
		PrintWriter out=response.getWriter();
		
		//-------------get AssessmentDelegate object------------------
		AssesmentsDelegate assDelegate=new AssesmentsDelegate();
		
		//----------------create ArrayList object of Object type with 'null' value---------------
		ArrayList<Object> timedto=null;
		
		//------------------getting parameters from form/jsp----------------------------
		String assmentId=request.getParameter("assId");
		Integer assesmentId=Integer.parseInt(assmentId);
	//	Integer assesmentId=1;
	//	System.out.println("getTimeSrvlt "+assesmentId);
	
		try {
			timedto=assDelegate.getTimeSlots(assesmentId);
					
			//---------------dealing with Gson----------------
			Gson gson=new Gson();
			String timeslot=gson.toJson(timedto);
			 
		//	System.out.println(">>>>>>>>>>"	+ ">>>"+timeslot);
			/**
			 * 
			 * set response content type
			 */
					
			response.setContentType("text/json");
			
			out.println(timeslot);
			
		}//try
		catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.write(e.getMessage());
		}//catch
				
	}//doGet(request, response)

}//class
