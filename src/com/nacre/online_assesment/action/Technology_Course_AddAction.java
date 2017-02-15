package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AdminDelegate;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class Technology_Course_AddAction
 */
@WebServlet("/Technology_Course_AddAction")
public class Technology_Course_AddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Technology_Course_AddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Integer technologyId=1;
		//Integer courseId=3;
System.out.println("hi ypu are in tech_course");
		String courseId = request.getParameter("courseName");
		Integer cId=Integer.parseInt(courseId);
		System.out.println(cId);
		String techId = request.getParameter("techName");
		Integer tId=Integer.parseInt(techId);
		System.out.println(tId);
	//	Integer technologyId = request.getParameter(technology);
	//	Integer courseId = request.getParameter(courseId);
	//	Integer courseId = request.getParameter(courseId);
		CourseDTO courseDto=new CourseDTO();
		courseDto.setCourseId(cId);
		TechnologyDTO technologyDTO=new TechnologyDTO();
		technologyDTO.setTechnologyId(tId);
		AdminDelegate adminDelegate=new AdminDelegate();
		try {
			Boolean success=adminDelegate.addTechnologyCourse( courseDto,technologyDTO);
			System.out.println("====================="+success);
			Gson gson = new Gson();
			response.setContentType("text/json");
			response.getWriter().write(gson.toJson(success));
			
		} catch (DatabaseException | SQLException e) {
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
