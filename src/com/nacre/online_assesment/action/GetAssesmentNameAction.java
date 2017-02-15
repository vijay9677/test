package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;


/**
 * @author Rohit Kumar Singh b35
 * Servlet implementation class getAssesmentAction
 */
@WebServlet("/GetAssesmentNameAction")
public class GetAssesmentNameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAssesmentNameAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//----------------calling doPost(request,response)---------------------
		doPost(request, response);
	}//doGet(request,response)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			/**
			 * get PrintWriter object	
			 */
			PrintWriter out=response.getWriter();
													
			//---------------------get Delegate object--------------------------
			AssesmentsDelegate assdelegate=new AssesmentsDelegate();
			
			//-------creating ArrayList object of DTO type with 'null' value-----------
			ArrayList<Object> listdto=null;
			
			//------------------------getting parameters------------------------
			String tId=request.getParameter("assesmentTypeId");
		
		if(tId!=null){			
		
			try {
			Integer userId=(Integer) request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
				//-----------------calling delegate method----------------------
				listdto=assdelegate.getAssessmentName(Integer.parseInt(tId),userId);
		
				//--------------------dealing with Gson object-----------------------
				Gson gson=new Gson();
				String asstyName=gson.toJson(listdto);
			
				/**
				 * set response content type
				 */
						
				response.setContentType("text/json");
								
				out.println(asstyName);
				
			/*	if(listdto!=null){
					listdto.add("");
				}*/
			
			}//try
			catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.write(e.getMessage());
			}//catch
		}//if
		else{
			
			out.println("ERROR NEEDS ASSESMENT TYPE ID");
		}//else
		
	}//doPost(request,response)

}//class
