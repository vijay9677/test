package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.ApplyRequestOpportunityPostingDelegate;
import com.nacre.online_assesment.dto.EligibleDTO;
import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class RequestForJob sagar
 */
@WebServlet("/RequestForJob.student")
public class RequestForJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
       
	/**
	 * @author pavan pratap singh batch-35
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Integer userid=1;
		//Integer jobPostId=4;
		Integer userid=Integer.parseInt(request.getParameter("userId"));
		Integer jobPostId= Integer.parseInt(request.getParameter("JobpostId"));
		UserDTO user=new UserDTO();
		user.setUserid(userid);
		JobPostingDTO jobPost=new JobPostingDTO();
		jobPost.setJobPostId(jobPostId);
		InterviewRoundDTO interDto=new InterviewRoundDTO();
		interDto.setJobPost(jobPost);
		EligibleDTO eDto=new EligibleDTO();
		eDto.setUser(user);
		eDto.setRound(interDto);
		//------------------------
		System.out.println("hi pavan in RequestJob **************************Action");
		System.out.println(eDto.getUser().getUserid());
		System.out.println(eDto.getRound().getJobPost().getJobPostId());
		ApplyRequestOpportunityPostingDelegate applyDelegate=new ApplyRequestOpportunityPostingDelegate();
		try {
		
		    
			Boolean requestForJob=applyDelegate.requestForJob(eDto);
            System.out.println(requestForJob);
    		response.getWriter().print(requestForJob);
    		
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().print(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			response.getWriter().print(e.getMessage());
		}
	}



}
