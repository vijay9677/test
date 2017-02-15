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
 * Servlet implementation class EditJobPostingAction(Job posting update)
 */
@WebServlet("/EditJobPostingAction")
public class EditJobPostingAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
			JobPostingInsertionFormBean jobPostingInsertionFormBean=new JobPostingInsertionFormBean();
			try{
				String description=request.getParameter("description");
				if(description==null){
					description="N/A";
				}
			jobPostingInsertionFormBean.setDescription(description);
			jobPostingInsertionFormBean.setAddressId((Integer.parseInt(request.getParameter("addId"))));
			jobPostingInsertionFormBean.setVacancies(Integer.parseInt(request.getParameter("noOfVacancies")));
			jobPostingInsertionFormBean.setTechnologyId(Integer.parseInt(request.getParameter("technologyId")));
			jobPostingInsertionFormBean.setJobPostingId(Integer.parseInt(request.getParameter("jobPostingId")));
			
			
			
			String expectedDate=request.getParameter("Expected_Date");
			String assMentStartDate=request.getParameter("assessmentStartDate");
			String assEndDate=request.getParameter("assessmentEndDate");
			if(expectedDate.contains("-")){
				
				jobPostingInsertionFormBean.setExpectedDate(DateUtil.stringToSqlDate(expectedDate,"yyyy-MM-dd"));
				
			}else {
				jobPostingInsertionFormBean.setExpectedDate(DateUtil.getSqlFromStringDate(request.getParameter("Expected_Date")));
				
			}
           if(assMentStartDate.contains("-")){
				
				jobPostingInsertionFormBean.setAssStartDate(DateUtil.stringToSqlDate(assMentStartDate,"yyyy-MM-dd"));
				
			}else {
				jobPostingInsertionFormBean.setAssStartDate(DateUtil.getSqlFromStringDate(assMentStartDate));
				
			}
           if(assEndDate.contains("-")){
				
				jobPostingInsertionFormBean.setAssEndDate(DateUtil.stringToSqlDate(assEndDate,"yyyy-MM-dd"));
				
			}else {
				jobPostingInsertionFormBean.setAssEndDate(DateUtil.getSqlFromStringDate(assEndDate));
				
			}
			}catch(Exception e){
				response.sendRedirect("jsp/corporate_relation/Edit_job_posting.jsp");
				e.printStackTrace();
			}
			
			
		 JobOpportunityPostingDelegate jobOpportunityPostingDelegate=new JobOpportunityPostingDelegate();
		 try {
			Boolean editJobPosting=jobOpportunityPostingDelegate.editJobPosting(jobPostingInsertionFormBean);
			request.getSession().setAttribute("editJobPostResult",editJobPosting);
			response.sendRedirect("jsp/corporate_relation/Edit_job_posting.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		 
//		 jobOpportunityPostingDelegate.
		/* response.getWriter().print("Successfully inserted"+jobPostingInsertionFormBean);
		 System.out.println("EditJobpotingAction--"+jobPostingInsertionFormBean);
		*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
