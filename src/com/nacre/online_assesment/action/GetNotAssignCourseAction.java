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
import com.nacre.online_assesment.delegate.AdminDelegate;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.exception.DatabaseException;


/**
 * Servlet implementation class CourseDetailsForEditAction
 */
@WebServlet("/GetNotAssignCourseAction")
public class GetNotAssignCourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNotAssignCourseAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @author Swapnil
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in curd opertaion controller");
		// TODO Auto-generated method stub
		Integer technologyId=Integer.parseInt(request.getParameter("technologyId"));
		  
		List<Object> l=new ArrayList<Object>();
					PrintWriter pw=response.getWriter();
					//AssesmentsDelegate adel=new AssesmentsDelegate();
				    AdminDelegate adel=new AdminDelegate();
					List<CourseDTO> list=null;
					try {
						list = adel.getNotAssignCourse(technologyId);
						Gson gson = new Gson();
						response.setContentType("text/json");
						System.out.println(gson.toJson(list));
						String viewAssesmentdetails = gson.toJson(list);
						pw.println(viewAssesmentdetails);
						System.out.println(l);
					} catch (DatabaseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(list);
				
					
					
				
				}				
			}
	    
		
		 