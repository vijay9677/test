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
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AssessmentPaperFormBean;
import com.nacre.online_assesment.form_bean.OptionsFromBean;
import com.nacre.online_assesment.form_bean.QuestionsFormBean;

/**
 * Servlet implementation class DeleteAssessmentQuestionAction
 */
@WebServlet("/DeletePaperAction.technical")
public class DeleteAssessmentQuestionAction extends HttpServlet 
{
	private static final long serialVersionUID = 12L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
           PrintWriter pw=response.getWriter();
		    
           response.setContentType("text/json");
		try {
			Integer assId= Integer.parseInt(request.getParameter("assId"));
			AssesmentsDelegate ad= new AssesmentsDelegate();
			Boolean i=ad.deleteAssessmentPaper(assId);
			if(i==true)
			{
				pw.print("{\"success\":\"Paper Is Successfully Deleted\"}");
			}
			else
			{
				pw.print("{\"fail\":\"paper is not deleted please try later!\"}");
			}
		    } 
		catch (DatabaseException | SQLException e) 
		{
			String s=e.getMessage();
			System.out.println(s);
			// TODO Auto-generated catch block
			pw.print("{\"fail\":\""+s+"\"}");
			e.printStackTrace();
			//error page
		}
		catch(java.lang.IllegalStateException e)
		{

		}
            
	}

}
