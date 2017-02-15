package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.delegate.PlacementsDelegate;
import com.nacre.online_assesment.dto.JobTypeDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.DateUtil;

/**
 * Servlet implementation class PlacementAction
 */
@WebServlet("/PlacementAction")
public class PlacementAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		System.out.println("in action");
		try {
		String hiddnFeilds = request.getParameter("values");
		String[] output = hiddnFeilds.split(",");
		Integer userId[] = new Integer[output.length];
		for(int i=0;i<output.length;i++){
			
			//System.out.println(Integer.parseInt(output[i]));
			userId[i]=Integer.parseInt(output[i]);
			System.out.println(userId[i]);
		}
		HttpSession session = request.getSession();
		Integer jobpostID = Integer.parseInt((String) session.getAttribute("jobPostID"));
		System.out.println(jobpostID);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String selecteddate = request.getParameter("date2");
		System.out.println(selecteddate);
		java.sql.Date sd=DateUtil.stringToSqlDate(selecteddate,"MM/dd/yyyy");
		
		String joiningdate=request.getParameter("date1");
		System.out.println("joining Date "+joiningdate);
		java.sql.Date jd=DateUtil.stringToSqlDate(joiningdate,"MM/dd/yyyy");
		
		//Integer salpack = Integer.parseInt(request.getParameter("pack")); 
		Float salpack = Float.parseFloat(request.getParameter("pack")); 
		System.out.println("salPackage"+salpack);
		String bonddetails= request.getParameter("bond"); 
		System.out.println("Bond "+bonddetails);
		Integer jobtypeid=Integer.parseInt(request.getParameter("jobtypeid"));
		System.out.println("jobtypeid "+jobtypeid);
				

		PlacementsDelegate deligate = new PlacementsDelegate();
		Integer clientId;
		
			clientId = deligate.getClient(jobpostID);
			
			System.out.println(clientId);
			
			PlacementDTO pldto=new PlacementDTO();
			
			pldto.setSelectedDate(sd);
			pldto.setJoiningDate(jd);
			pldto.setPackage(salpack);
			pldto.setBond(bonddetails);
			JobTypeDTO  jobTypeDTO = new JobTypeDTO();
			jobTypeDTO.setJobTypeId(jobtypeid);
			pldto.setJobType(jobTypeDTO);
			boolean status = deligate.insertPlacementDetail(pldto,userId,clientId);
			System.out.println(status);
			
			if(status==true){
			//Change staus for placaed students
			Integer interviewRoundId =Integer.parseInt((String) session.getAttribute("roundId"));
			System.out.println("Interview RoundID "+ interviewRoundId);
			boolean updateStatus = deligate.UpdatUserStatus(interviewRoundId,userId);
			
			if(updateStatus == true){
				boolean userStatusUpdate =deligate.UpdateUserTableUserStatus(userId);
				System.out.println(userStatusUpdate);
				
				if(userStatusUpdate==true){
					request.getSession().setAttribute("successMsg", "Users successfully Saved");
					response.sendRedirect(request.getContextPath()+"/jsp/hr/rounddetails.jsp");
				}else{
					request.getSession().setAttribute("errMsg", "FAILED TO SAVE RECORDS");
					response.sendRedirect(request.getContextPath()+"/jsp/hr/rounddetails.jsp");
					
				}
					
				
				}else{
						request.getSession().setAttribute("errMsg", "FAILED TO SAVE RECORDS");
						response.sendRedirect(request.getContextPath()+"/jsp/hr/rounddetails.jsp");
				
			}
			}else{
				
				request.getSession().setAttribute("errMsg", "FAILED TO SAVE RECORDS");
				response.sendRedirect(request.getContextPath()+"/jsp/hr/rounddetails.jsp");
		
			}
			
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/hr/ErrorPage.jsp");
			dispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
