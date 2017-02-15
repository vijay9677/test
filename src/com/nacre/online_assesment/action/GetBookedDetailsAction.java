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
import com.nacre.online_assesment.util.StringConstants;

/**
 * Servlet implementation class GetBookedDetailsAction
 */
@WebServlet("/GetBookedDetailsAction")
public class GetBookedDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookedDetailsAction() {
        super();
        // TODO Auto-generated constructor stub
     //   System.out.println("in get booked details action.........");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//--------------calling doPost(request, response)------------------
		doPost(request, response);
	}//doGet(request, response)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			//---------------getting PrintWriter object--------------------
				PrintWriter out=response.getWriter();
				
				//getting ArrayList Object
				ArrayList<Object> arList=new ArrayList<Object>();
				
				//---------------getting Parameters from jsp-------------------
				String aId = request.getParameter("assId");
				
		//		String aId = "2";
				Integer assesmentId = Integer.parseInt(aId);
							
				//	System.out.println("asssssid ..... "+assesmentId);
				
				//----------------accessing userId from session-----------------
				Integer userID=(Integer) request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
				
				//-----------------getting AssesmentsDelegate object
				AssesmentsDelegate assDelegate = new AssesmentsDelegate();
				
				//----------------------calling method---------------------
				try {
					arList = assDelegate.getBookedSlotDetails(assesmentId, userID);
					
					//-------------------dealing with Gson object------------------
					
					Gson gson=new Gson();
					String bkdSlotDetails=gson.toJson(arList);
				
					/**
					 * set response content type
					 */
							
					response.setContentType("text/json");
					/**
					 * get PrintWriter object	
					 */
									
					out.println(bkdSlotDetails);
					
				}//try
				catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					out.write(e.getMessage()); 
				}//catch

		
	}//doPost(req,res)

}//class
