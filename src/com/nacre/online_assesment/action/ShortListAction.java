package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.delegate.PlacementsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;



/**
 * Servlet implementation class ShortListAction
 */
@WebServlet("/ShortListAction")
public class ShortListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Integer roundId = Integer.parseInt(request.getParameter("roundId"));
		//System.out.println(roundId);
		//System.out.println(request.getParameter("roundId"));
		
		/*JobRoundBean jrb = new JobRoundBean();
		Integer roundId=jrb.getInterview_round_id();
		System.out.println(roundId);*/
		HttpSession session = request.getSession();
		Integer roundID = Integer.parseInt((String) session.getAttribute("roundId"));
		System.out.println(session.getAttribute("roundId"));
		
		
		
		response.setContentType("text/html");
		PrintWriter pw  = response.getWriter();
		String[] shortList = request.getParameterValues("applicable");
		
		for(int i=0;i<=shortList.length-1;i++){
			
			System.out.println(Integer.parseInt(shortList[i]));
		}
		String status;
		
		PlacementsDelegate postingdeligate = new PlacementsDelegate();
		try {
			status = postingdeligate.insertShortlistDetails(roundID, shortList);
			System.out.println(status);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
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
