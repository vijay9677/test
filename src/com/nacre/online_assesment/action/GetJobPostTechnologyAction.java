package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.CommonDelegate;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author Sagar Suryawanshi b 35 This Action Is To All Technology Gives Json
 *         Response Servlet implementation class GetJobPostTechnologyAction
 */
@WebServlet("/GetJobPostTechnologyAction.student")
public class GetJobPostTechnologyAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetJobPostTechnologyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
			CommonDelegate commonDelegate = new CommonDelegate();
			try {
				List<TechnologyDTO> technologyList = commonDelegate.getJobPostTechnology();
				Gson gson= new Gson();
			String technologyJson =	gson.toJson(technologyList);
			
			response.getWriter().write(technologyJson);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				response.getWriter().write("[\""+e.getMessage()+"\"]");
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				response.getWriter().write("[\""+e.getMessage()+"\"]");
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
