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
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class EditTechnologyAction
 */
@WebServlet("/EditTechnologyAction")
public class EditTechnologyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTechnologyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/json");
		
        PrintWriter out = response.getWriter();
		
		TechnologyDTO technologyDTO = new TechnologyDTO();
		
		//hard coaded data for checking 
		String technologyIdString=request.getParameter("technology_edit_Id").toUpperCase();
		Integer technologyId=Integer.parseInt(technologyIdString);
		String technology =request.getParameter("technology_edit_Name").toUpperCase();
		System.out.println("this is Edit technology"+technology);
		//String course="PureAdvJava";
System.out.println("this is Edit technology id"+technologyId);
		TechnologyDTO technologyDto = new TechnologyDTO();
		 technologyDto.setTechnologyId(technologyId);
		 technologyDto.setTechnology(technology);
		System.out.println(" technologyDto Object Data ::::: "+ technologyDto);
		AdminDelegate ado = new AdminDelegate();
		String msg=null;
			try {		
				Integer count = ado.editTechnology(technologyDto);
				System.out.println("count "+count);
				if (count==1) {
					response.setContentType("text/json");
					out.println("{\"sMsg\":\"You Successfull Updated Technology...\"}");
					
				} else {
					//msg="Technology is already present please add new Technology...";
				
					response.setContentType("text/json");
					out.println("{\"fMsg\":\"Technology is already present please add new Technology...\"}");
					
				}
				
				
		}		catch (DatabaseException db) {
			
			db.printStackTrace();			
			out.println("{\"fMsg\":\"PLEASE TRY LATER\"}");
			
			//response.getWriter().print("PLEASE TRY LATER");
			
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("{\"fMsg\":\"Technology already exists or Please try later\"}");
			
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
