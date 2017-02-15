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
 * Servlet implementation class ApplyForJob sagar
 */
@WebServlet("/ApplyForJob.student")
public class ApplyForJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @author pavan pratap singh batch-35
     * @see HttpServlet#HttpServlet()
     */
    public ApplyForJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @author pavan pratap singh batch-35
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	
	}
	/**
	 * @author pavan pratap singh batch-35
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*//Integer userid=1;
		//Integer jobPostId=5;
		Integer userid=Integer.parseInt(request.getParameter("userId"));
		Integer jobPostId= Integer.parseInt(request.getParameter("JobpostId"));
		Integer interviewRoundId= Integer.parseInt(request.getParameter("interviewRoundId"));
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
		System.out.println("hi pavan in apply Action");
		System.out.println(eDto.getUser().getUserid());
		System.out.println(eDto.getRound().getJobPost().getJobPostId());*/
		//Integer eligibleStudId=2;
		Integer eligibleStudId=Integer.parseInt(request.getParameter("elegible_Student_Id"));
		
		
		//*************************************
		EligibleDTO eDto=new EligibleDTO();
		eDto.setEligibleStudId(eligibleStudId);
		  System.out.println("hi pavan you are in Apply ");
		ApplyRequestOpportunityPostingDelegate applyDelegate=new ApplyRequestOpportunityPostingDelegate();
		try {
			
			  System.out.println(eDto.getEligibleStudId());
     		 Boolean   applyForJob=applyDelegate.applyForJob(eDto);
	         
	          System.out.println(applyForJob);
			
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


