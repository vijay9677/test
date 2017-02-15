package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.mail.Session;
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
import com.sun.javafx.binding.StringConstant;

/**
 * @author Rohit Kumar Singh b35
 * Servlet implementation class BookSelectedSlot
 */
@WebServlet("/BookSelectedSlot")
public class BookSelectedSlot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSelectedSlot() {
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
		
		//------------------getting ArrayList Object-----------------------
		ArrayList<Object> arList=new ArrayList<Object>();
		
		//---------------getting Parameters from jsp-------------------
		String aId = request.getParameter("assId");
	
		Integer assesmentId = Integer.parseInt(aId);
		String selectedSlot=request.getParameter("slotTime");
	
		//----------------accessing userId from session-----------------
		Integer uId=(Integer) request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
						
		//---------------create BookedSlotBean class object-------------
		BookedSlotsBean bukBean=new BookedSlotsBean();
		
		//--------------setting values to BookedSlotsBean class object--------
		bukBean.setUserId(uId);
		bukBean.setAssesmentId(assesmentId);
		
		//----------------conversion of String time into java.sql.Time-------------
		SimpleDateFormat dtformat=new SimpleDateFormat("HH:mm:ss");
		
		try {
			
			SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm:ss a");

		    SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm:ss");
		    String strSelectedSlot =date24Format.format(date12Format.parse(selectedSlot));

		    long ms = dtformat.parse(strSelectedSlot).getTime();
		    Time tt = new Time(ms);
		
			bukBean.setSlotTime(tt);
		}//try
		catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		//	System.out.println("Parsing Fails");
		}//catch
		
		//-----------------------create bookSelectedSlotDelegate Object-------------------------
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
				
		/*	if(arList!=null){
				out.write("You have booked your slot successfully....");
								
			}//if
			else{
				out.write("Sorry...Your slot booking is not done..");
			
			}//else
*/		}//try
		catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.write(e.getMessage());
		}//catch
				
	}//doPost(request, response)

}//class
