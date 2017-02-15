package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.BookedSlotsBean;
import com.nacre.online_assesment.util.StringConstants;

/**
 * Servlet implementation class getNoOfAttempts
 */
@WebServlet("/GetNoOfAttempts")
public class GetNoOfAttempts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNoOfAttempts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//-----------------calling doPost(req,res)----------------
				doPost(request, response);
				
	}//doGet(request, response)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	System.out.println("hii.....in book selected slot action");
		
		//---------------getting PrintWriter object--------------------
		PrintWriter out=response.getWriter();
		
		//getting ArrayList Object
		ArrayList<Object> arList=new ArrayList<Object>();
		
		//---------------getting Parameters from jsp-------------------
		String aId = request.getParameter("assId");
		
	
		Integer assesmentId = Integer.parseInt(aId);
		//assesmentId=1;
		//----------------accessing userId from session-----------------
		Integer uId=(Integer) request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
						
		//---------------create BookedSlotBean class object-------------
		BookedSlotsBean bukBean=new BookedSlotsBean();
		
		//--------------setting values to BookedSlotsBean class object--------
		bukBean.setUserId(uId);
		bukBean.setAssesmentId(assesmentId);
		
		//create bookSelectedSlotDelegate Object
		AssesmentsDelegate assDelegate=new AssesmentsDelegate();
		
		try {
			 arList=assDelegate.bookedSelectedSlots(bukBean);
			
			//--------------------dealing with Gson object-----------------------
				Gson gson=new Gson();
				String attempts=gson.toJson(arList);
			
				/**
				 * set response content type
				 */
						
				response.setContentType("text/json");
				/**
				 * get PrintWriter object	
				 */
								
				out.println(attempts);
			}//try
		catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println(e.getMessage());
		}//catch
				
	}//doPost(request, response)


}
