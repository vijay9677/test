package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.SystemOutLogger;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AdminDelegate;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class AddCourseAction
 */
@WebServlet("/AddCourseAction")

public class AddCourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub;
		PrintWriter pw=response.getWriter();
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Start Add Action Class");
		
		String course=request.getParameter("course_Name").toUpperCase();
		
		CourseDTO courseDto = new CourseDTO();
		
		courseDto.setCourse(course);
		//for checking purpose
		System.out.println(courseDto.getCourse());
		
		
		String msg=null;
		AdminDelegate ado = new AdminDelegate();
		try {
			Integer count =ado.addCourse(courseDto);
			System.out.println("count "+count);
			if (count>=1) {
				msg="You Successfully Added Course...";
			} else {
				msg="Course is already present please add new Course...";
			}
			
			Gson gson = new Gson();
			response.setContentType("text/json");
			System.out.println(gson.toJson(msg));
			String message = gson.toJson(msg);
			pw.println(message);
		
		}
		catch(DatabaseException e){
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("End Add Action Class");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
