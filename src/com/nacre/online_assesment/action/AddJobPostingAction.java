package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean;
import com.nacre.online_assesment.util.DateUtil;

/**
 * @author Srinivas N
 * This action will store job posting details 
 */
@WebServlet("/addJobPostingAction")
public class AddJobPostingAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");
        JobPostingInsertionFormBean jobPostingInsertionFormBean=new JobPostingInsertionFormBean();
        try{
		
		jobPostingInsertionFormBean.setDescription(request.getParameter("description"));
		jobPostingInsertionFormBean.setAddressId(Integer.parseInt(request.getParameter("addId")));
		jobPostingInsertionFormBean.setVacancies(Integer.parseInt(request.getParameter("noOfVacancies")));
		jobPostingInsertionFormBean.setTechnologyId(Integer.parseInt(request.getParameter("technologyId")));
		
		jobPostingInsertionFormBean.setExpectedDate(DateUtil.getSqlFromStringDate(request.getParameter("Expected_Date")));
		jobPostingInsertionFormBean.setAssStartDate(DateUtil.getSqlFromStringDate(request.getParameter("assessmentStartDate")));
		jobPostingInsertionFormBean.setAssEndDate(DateUtil.getSqlFromStringDate(request.getParameter("assessmentEndDate")));
		System.out.println("jobPostingInsertionFormBean---"+jobPostingInsertionFormBean);
		
        }catch(NumberFormatException n){
        	n.printStackTrace();
        	response.sendRedirect("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp");	
        }catch(NullPointerException n){
        	
        	n.printStackTrace();
        	response.sendRedirect("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp");
        }catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp");
		}
		
		
		JobOpportunityPostingDelegate jobOpportunityPostingDelegate=new JobOpportunityPostingDelegate();
		try {
			Boolean jobPosting=jobOpportunityPostingDelegate.addJobPosting(jobPostingInsertionFormBean);
			request.getSession().setAttribute("result",jobPosting);
			System.out.println("Reault..>>>>>>>>>>>>>>"+jobPosting);
			response.sendRedirect("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp");
		//	 request.getRequestDispatcher("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp").forward(request, response);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
