package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentRequestFeedBackDelegate;
import com.nacre.online_assesment.dto.FeedbackTypeDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class GetFeedbackType
 */
@WebServlet("/GetFeedbackType")
public class GetFeedbackType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse resp dc=onse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentRequestFeedBackDelegate deligate=new StudentRequestFeedBackDelegate();

		try{
			System.out.println("i am in action");
			List<FeedbackTypeDTO> list;
			try {
				list = deligate.getFeedbackType();
				System.out.println();
				if(list!=null)
				{
					Gson gson=new Gson();
					String s=gson.toJson(list);
					response.setContentType("text/json");
				    PrintWriter pw=response.getWriter();
					pw.println(s);
					//pw.print(gson.toJson(list));
				}
				else{
					throw new DatabaseException("feedback types not found");
				}
				
				
			}catch(DatabaseException ne)
			{
				ne.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}