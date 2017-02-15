package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddTechnologyAction
 */
@WebServlet("/AddTechnologyAction")
public class AddTechnologyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTechnologyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	     
		String technology = request.getParameter("technology_Name").toUpperCase();              
		
		System.out.println("technology Name in Action  "+technology);
		
		TechnologyDTO technologyDto	= new TechnologyDTO();
		
		technologyDto.setTechnology(technology);
		//for checking purpose
		System.out.println(technologyDto.getTechnology());
		
		String msg=null;
		AdminDelegate ado = new AdminDelegate();
		try {
			Integer count = ado.addTechnology(technologyDto);
			System.out.println("count "+count);
			if (count>=1) {
				//msg="You Successfull Added Technology...";
				response.setContentType("text/json");
				pw.println("{\"sMsg\":\"You Successfull Added Technology...\"}");
				
			} else {
				//msg="Technology is already present please add new Technology...";
			
				response.setContentType("text/json");
				pw.println("{\"fMsg\":\"Technology is already present please add new Technology...\"}");
				
			}
			
			//Gson gson = new Gson();
			
		}
		catch(DatabaseException e){
			e.printStackTrace();
			response.setContentType("text/json");
			pw.println("{\"ERR\":\"Database is not reachable Please try later\"}");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			response.setContentType("text/json");
			pw.println("{\"ERR\":\"Database Problem Please try later\"}");
			
		}
		System.out.println("End Add Action Class technology");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
