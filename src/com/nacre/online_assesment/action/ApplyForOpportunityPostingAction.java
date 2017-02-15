package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.ApplyRequestOpportunityPostingDelegate;
import com.nacre.online_assesment.dto.EligibleDTO;
import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;

/**
 * @author sagar
 * Servlet implementation class ApplyForOpportunityPostingAction
 */
@WebServlet("/ApplyForOpportunityPostingAction.student")
public class ApplyForOpportunityPostingAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @author pavan pratap singh batch-35
     * @see HttpServlet#HttpServlet()
     */
    public ApplyForOpportunityPostingAction() {
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
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Integer userid=1;
		//Integer jobPostId=4;
		PrintWriter pw = response.getWriter();

		Integer userid=(Integer)request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
		Integer jobPostId= Integer.parseInt(request.getParameter("JobpostId"));
		//userid=2;
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
		System.out.println("hi pavan in checkEligibilty Action");
		System.out.println(eDto.getUser().getUserid());
		System.out.println(eDto.getRound().getJobPost().getJobPostId());
		ApplyRequestOpportunityPostingDelegate applyDelegate=new ApplyRequestOpportunityPostingDelegate();
		try {
			
			EligibleDTO elegible_Student_id=applyDelegate.checkEligibilty(eDto);
			
			System.out.println(elegible_Student_id);
			/**
			 * @author pavan
			 * @param-rd
			 */
			
		List l = new ArrayList();
	
		if(elegible_Student_id!=null){
			l.add("elegible");
			l.add(elegible_Student_id.getEligibleStudId());
			l.add(elegible_Student_id.getStatus().getStatusId());
			
			
		}
		else{

			l.add("request");
			
			
		}
			Gson gson = new Gson();
			response.setContentType("text/json");
			System.out.println(gson.toJson(l));
			String jobPostDetails = gson.toJson(l);
			pw.println(jobPostDetails);
			
			
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
