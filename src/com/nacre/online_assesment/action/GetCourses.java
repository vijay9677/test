package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itextpdf.text.List;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class GetCourses
 */
@WebServlet("/GetCourses")
public class GetCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @author pavan pratap singh b-35
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @author pavan pratap singh b-35
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		java.util.List<CourseDTO> l=new ArrayList();
		AssesmentsDelegate asdelegate=new AssesmentsDelegate();
		try {
			l=asdelegate.getCourses();
			System.out.println(l);
			
			Gson gson = new Gson();
			response.setContentType("text/json");
			System.out.println(gson.toJson(l));
			String jobPostDetails = gson.toJson(l);
			//pw.println(jobPostDetails);
			response.getWriter().print(jobPostDetails);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
