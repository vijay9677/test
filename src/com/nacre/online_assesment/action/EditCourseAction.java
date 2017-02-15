package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.AdminDelegate;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class EditCourseAction
 */
@WebServlet("/EditCourseAction")
public class EditCourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourseAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>>>>>>Start Action>>>>>>>>>>>>>>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
       response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		//CourseDTO courseDto = new CourseDTO();
		
		//hard coaded data for checking 
		String courseIdString=request.getParameter("course_edit_Id");
		Integer courseId=Integer.parseInt(courseIdString);
		String course=request.getParameter("course_edit_Name").toUpperCase();
		System.out.println("this is Edit course"+course);
		//String course="PureAdvJava";
System.out.println("this is Edit course id"+courseId);
		CourseDTO courseDto=new CourseDTO();
		courseDto.setCourseId(courseId);
		courseDto.setCourse(course);
		System.out.println("courseDto Object Data ::::: "+courseDto);
		AdminDelegate ado = new AdminDelegate();
		
			try {		
				ado.editCourse(courseDto);
		
		}		catch (DatabaseException db) {			// TODO Auto-generated catch block
			db.printStackTrace();			
			response.getWriter().print("PLEASE TRY LATER");
			
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
