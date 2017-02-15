package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.nacre.online_assesment.util.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AssessmentPaperFormBean;
import com.nacre.online_assesment.form_bean.OptionsFromBean;
import com.nacre.online_assesment.form_bean.QuestionsFormBean;

/**
 * @author Krishna prakash
 * Action to save edited assessment paper data to database 
 * @throws ServletException, IOException 
 */
@WebServlet("/EditedQuestionPaperAction.technical")
public class EditedQuestionPaperAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doPost(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
        List<AssessmentPaperFormBean> assmentPaper=(List<AssessmentPaperFormBean>)session.getAttribute("assessmentPaper");
        System.out.println( assmentPaper);
        System.out.println(">>.............."+ request.getParameter("questJsonObj"));
        String jsonArrayString= request.getParameter("questJsonObj");
        
        try 
        {
        	Gson g = new Gson();
			JSONArray jsonArray = new JSONArray(jsonArrayString);
			//JsonParser parser = new JsonParser();
			List<AssessmentPaperFormBean> finalList= new ArrayList<AssessmentPaperFormBean>();
			for (int i=0; i<jsonArray.length(); i++) 
			{
				
			   AssessmentPaperFormBean apb=new AssessmentPaperFormBean();
			   List<OptionsFromBean> listOp=new ArrayList<OptionsFromBean>();
			   QuestionsFormBean qfb=new QuestionsFormBean();
			   JSONObject obj = jsonArray.getJSONObject(i);
			   //getting question
			   String quest=obj.getString("question");
			   //getting level 
			   String level=obj.getString("level");
			   //setting question into questFormBean
			   qfb.setQuestion(quest);
			   System.out.println("after delete "+qfb.getQuestion());
			   //setting level into questFormBean
			   qfb.setLevel(level);
			   JSONArray optArr=obj.getJSONArray("options");
			   for(int j=0;j<optArr.length();j++)
			   {
				   OptionsFromBean ofb=new OptionsFromBean();
				   JSONObject opObj=optArr.getJSONObject(j);
				   //getting option
				   String opt=opObj.getString("option");
				   //getting answer
				   boolean optAns= opObj.getBoolean("isAnswer");
				   //setting option into OptionsFormBean class
				   ofb.setOption(opt);
				   ofb.setIsAnswer(optAns);
				   //
				   /*System.out.println(optArr.getJSONObject(j));
				   System.out.println(ofb.getOption()+" javaOp");*/
                   //adding to List
				   listOp.add(ofb);

			   }
			   System.out.println(listOp+ " every opt");
			   apb.setOptionsFormBean(listOp);
			   apb.setQuestionsFormBean(qfb);
			   finalList.add(apb);

			}
			System.out.println(finalList);
			
			//Integer assId=(Integer)session.getAttribute("assessmentId");
	        AssesmentsDelegate ad=new AssesmentsDelegate();
	        Integer assId=(Integer) session.getAttribute("assessmentId");
	    	Integer count=ad.uploadAssessmentPaper(finalList,assId);
			  if(count==0)
			  {
				    System.out.println("record is not updated");
					pw.print("{\"fail\":\"failed to insert paper\"}");
			  }
			  else if(count==-3){
				    System.out.println("records already exists");
					pw.print("{\"fail\":\"paper is already exists\"}");
			  }
			  else
			  {
				System.out.println("records are successfully updated");
				pw.print("{\"success\":\"Paper Is Successfully Uploaded\"}");
				session.removeAttribute("assessmentPaper");
				session.removeAttribute("assmentId");  
			   }
	
		} catch (JSONException e) 
        {
			e.printStackTrace();

			pw.print("{\"error\":\"JSON DATA EXCEPTION\"}");
		} catch (DatabaseException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.print("{\"error\":\"Database is under maintainance Plese try later\"}");
		}
        catch(java.lang.IllegalStateException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/common/my_error_page.jsp");
			rd.include(request, response);
			e.printStackTrace();
		}
        
        
     
	}

}
