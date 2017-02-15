package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentRequestFeedBackDelegate;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @ Amarendar Guthuru
 * This class is created for getting companies from DB based on FeedbackType
 * Servlet implementation class GetCompany
 */
@WebServlet("/GetCompany.ajax")
public class GetCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Amarendar Guthuru
	 * @param request,response accepts javax.servlet.HttpServletRequest,javax.servlet.HttpServletResponse
	 * @throws ServletException,IoException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		StudentRequestFeedBackDelegate studentRequestFeedBackDelegate=new StudentRequestFeedBackDelegate();
		try {
			List<ClientDTO> list=studentRequestFeedBackDelegate.getCompany();
			Gson gson=new Gson();
			String json=gson.toJson(list);
			res.setContentType("text/json");
			res.getWriter().write(json);
			
			
			
		} catch (DatabaseException | SQLException | DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @author Amarendar Guthuru
	 * @param request,response accepts javax.servlet.HttpServletRequest,javax.servlet.HttpServletResponse
	 * @throws ServletException,IoException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
