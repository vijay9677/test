package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.delegate.PlacementsDelegate;
import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.DateUtil;



/**
 * Servlet implementation class NextRoundPopupAction
 */
@WebServlet("/NextRoundPopupAction")
public class NextRoundPopupAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in action");
		try {
		String hiddnFeilds = request.getParameter("values");
		String[] output = hiddnFeilds.split(",");
		Integer userId[] = new Integer[output.length];
		for(int i=0;i<output.length;i++){
			
			//System.out.println(Integer.parseInt(output[i]));
			userId[i]=Integer.parseInt(output[i]);
			//System.out.println(userId[i]);
		}
		for(int i=0;i<userId.length;i++){
			
			System.out.println(userId[i]);
		}
	
		
		//System.out.println(hiddnFeilds);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		Integer jobpostID = Integer.parseInt((String) session.getAttribute("jobPostID"));
		System.out.println("jpid"+jobpostID);
		String date = request.getParameter("date");
		System.out.println(date);
		
		Integer roundno = Integer.parseInt(request.getParameter("roundno")); System.out.println("rno"+roundno);
		String roundDescription = request.getParameter("rdescription");  System.out.println("descr"+roundDescription);
		java.sql.Date d=DateUtil.stringToSqlDate(date,"MM/dd/yyyy");
		Date dateObj =new Date(d.getTime());
		System.out.println("Action Page Date :"+dateObj);
		
		InterviewRoundDTO interviewRoundDTO = new InterviewRoundDTO();
		interviewRoundDTO.setRoundNo(roundno);
		interviewRoundDTO.setDescription(roundDescription);
		interviewRoundDTO.setDate(dateObj);
		interviewRoundDTO.setJobPostId(jobpostID);
		
		PlacementsDelegate deligate = new PlacementsDelegate();
		Integer roundId;
		
			roundId = deligate.insertNextRound(interviewRoundDTO);
		//System.out.println(roundId);
		
		if(roundId!=null){
			
			//HttpSession session = request.getSession();
			//Integer roundID = Integer.parseInt((String) session.getAttribute("roundId"));
			//System.out.println(session.getAttribute("roundId"));
			
			boolean status = deligate.insertShortlist(roundId, userId);
			//System.out.println(status);
			
			
			if(status == true){
				System.out.println("Inserted <<<<<<<<<<<<<<<<<<<<<<<");
				
				//pw.print("Users successfully shortlisted for Next Round");  
				request.getSession().setAttribute("successMsg", "Users successfully shortlisted for Next Round");
				response.sendRedirect(request.getContextPath()+"/jsp/hr/rounddetails.jsp");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/rounddetails.jsp");
				//dispatcher.include(request, response);
			}else{
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Inserted ");
				
				/*request.setAttribute("errMsg", "FAILED TO SAVE RECORDS");
				*/
				request.getSession().setAttribute("errMsg", "FAILED TO SAVE RECORDS");
				response.sendRedirect(request.getContextPath()+"/jsp/hr/rounddetails.jsp");
				/*
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/rounddetails.jsp");
				dispatcher.forward(request, response);
				*/
			}
			
			
			
		}else{
			System.out.println("Not Inserted");

			request.setAttribute("errMsg", "FAILED TO SAVE RECORDS");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/rounddetails.jsp");
			dispatcher.forward(request, response);
			
		}
		
		} catch (DatabaseException e) {
			//e.printStackTrace();
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/ErrorPage.jsp");
			dispatcher.include(request, response);
			
		}catch(Exception ex){
			ex.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/ErrorPage.jsp");
			dispatcher.include(request, response);
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
