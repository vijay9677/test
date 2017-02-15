package com.nacre.online_assesment.action;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;


/**
 * @author Rohit Kumar Singh b35
 * Servlet implementation class validationForBookedSlots
 */
@WebServlet("/ValidationForBookedSlotsAction")
public class ValidationForBookedSlots extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationForBookedSlots() {
        super();
        // TODO Auto-generated constructor stub
    //    System.out.println("in validation For Booked Slots Action.......");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//call doPost(request, response) method
		doPost(request, response); 
	}//doPost(request, response)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//---------------get AssessmentId and USerID for validation--------------
		String aId = request.getParameter("assId");
		Integer assesmentId = Integer.parseInt(aId);
	//	Integer assesmentId=1;
		Integer uId=(Integer) request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
		
		//-------------------get delegate object-------------------------
		AssesmentsDelegate assDelegate=new AssesmentsDelegate();
		
		Object obj;
		try {
			
			obj = assDelegate.validationForBookedSlots(uId, assesmentId);
					//	System.out.println("valid obj "+obj);
				
					/*	HttpSession session=request.getSession();
					session.setAttribute("timeSlot",obj);*/
		 if(obj!=null){
			 
			 //-------------dealing with Gson object-------------------
			Gson gson=new Gson();
			String timeslot=gson.toJson(obj);
			 
	//		System.out.println(">>>>>>>>>>"	+ ">>>"+timeslot);
			/**
			 * 
			 * set response content type
			 */
					
			response.setContentType("text/json");
			/**
			 * get PrintWriter object	
			 */
			PrintWriter out=response.getWriter();
			
			out.println(timeslot);
			
		  }//if
		}//try
		catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}//catch
		
	}//doPost(request, response);

}//class
