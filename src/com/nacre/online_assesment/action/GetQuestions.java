package com.nacre.online_assesment.action;
/**
chitransu
*/
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.CurrentQuestionDetailsBean;

/**
 * @author Chitranshu Gupta  This Action to get Assessment Questions

 */
/**
 * Servlet implementation class GetQuestions
 */
@WebServlet("/GetQuestions")
public class GetQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 CurrentQuestionDetailsBean detailsBean=new CurrentQuestionDetailsBean();
		
		if(request.getParameter("assessmentId")!=null)
		{
			if(request.getParameter("assessmentQuesId")!="")
			{
			String selectedOptions = request.getParameter("selectedOptions");
			Integer assessmentQuesId = Integer.parseInt(request.getParameter("assessmentQuesId"));
		
			detailsBean.setAssessmentQuesId(assessmentQuesId);
			detailsBean.setSelectedOptions(selectedOptions);
			
			}
			
			Integer userId = Integer.parseInt(request.getParameter("userId"));
			//System.out.println(userId);
			Integer assessmentId  = Integer.parseInt(request.getParameter("assessmentId")); 
			 
			String remainingTime = request.getParameter("remainingTime");
			//System.out.println("########"+remainingTime);
			
			detailsBean.setUserId(userId);
			detailsBean.setRemainingTime(remainingTime);
			detailsBean.setAssessmentId(assessmentId);		
		}
	  
		//Integer assessmentId=1;
	  AssesmentsDelegate assesmentsDelegate=new AssesmentsDelegate();
	 
	  NavigableMap quesSet = null;
	try {
		
		quesSet = assesmentsDelegate.getQuestionsAndTheirOption(detailsBean);
		//System.out.println(quesSet);
		
	} catch (DatabaseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  
	    Object ques = quesSet.firstEntry();
	    Integer key = null;
	    try{
	    	if(request.getParameter("key")!=null)
	    	{
		 key = Integer.parseInt(request.getParameter("key"));
	    	}
	    }
	    catch(NumberFormatException e)
	    {
	    	e.printStackTrace();
	    }
		//System.out.println(key);
		String iteration = request.getParameter("itr");
		//System.out.println(iteration);
		
		
		if (key !=null && iteration.equals("next")) {
			ques = quesSet.higherEntry(key);
			//System.out.println(ques);
		} else if (key !=null  && iteration.equals("pre")) {
			ques = quesSet.lowerEntry(key);
			//System.out.println(ques);
		}
		else if (key !=null  && iteration.equals("absolute")) {
			
			ques = quesSet.get(key);
			//System.out.println(ques);
			
		}
		
		List<Object> list=new ArrayList<Object>();
		
		list.add(ques);
		list.add(quesSet.get(quesSet.size()-3));
		list.add(quesSet.get(quesSet.size()-2));
		list.add(quesSet.get(quesSet.size()-1));
		list.add(quesSet.get(quesSet.size()));
		/*System.out.println("**********"+quesSet.get(quesSet.size()-2));
		System.out.println("**********"+quesSet.get(quesSet.size()-1));
		System.out.println("**********"+quesSet.get(quesSet.size()));*/
		
		Gson gson = new Gson();
		response.setContentType("text/json");
		PrintWriter pw = response.getWriter();
		System.out.println(list);
		//System.out.println(gson.toJson(list));
		pw.print(gson.toJson(list));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
