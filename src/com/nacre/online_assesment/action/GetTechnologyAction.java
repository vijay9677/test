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
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class AddTechnology
 */
@WebServlet("/GetTechnologyAction")
public class GetTechnologyAction extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTechnologyAction() 
    {
        super(); 
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("controll in get operation");
		
/*	List<Object> l=new ArrayList<Object>();*/
	PrintWriter pw=response.getWriter();
	
    AdminDelegate adel=new AdminDelegate();
	
    List<TechnologyDTO> list=null;
	try {
		list = adel.getTechnology();
		Gson gson = new Gson();
		response.setContentType("text/json");
		System.out.println(gson.toJson(list));
		String viewAssesmentdetails = gson.toJson(list);
		pw.println(viewAssesmentdetails);
		System.out.println(list);
	} catch (DatabaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(list);
	}
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(request, response);
		}
	

			
}

