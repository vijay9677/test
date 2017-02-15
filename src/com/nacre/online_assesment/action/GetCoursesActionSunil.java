package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.CommonDelegate;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StateDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.ErrorMessages;

/**
 * Servlet implementation class GetCoursesAction
 */
@WebServlet("/GetCoursesActionSunil.ajax")
public class GetCoursesActionSunil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCoursesActionSunil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tid = request.getParameter("technologyId");
		
		response.setContentType("text/json");
		
		if(tid!=null){
			Integer technologyId = Integer.parseInt(tid);
			CommonDelegate commonDelegate = new CommonDelegate();
			try {
				List<CourseDTO> courseList = commonDelegate.getCourse(technologyId);
			   
				Gson gson= new Gson();
			String courseJson =	gson.toJson(courseList);
			
			response.getWriter().write(courseJson);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				response.getWriter().write("[\""+e.getMessage()+"\"]");
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				response.getWriter().write("[\""+e.getMessage()+"\"]");
			}
			
		}else{
			

			response.getWriter().write("[\""+ErrorMessages._ERR_COUNTRY_ID+"\"]");
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
