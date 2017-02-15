package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.CommonDelegate;
import com.nacre.online_assesment.delegate.StudentDashboardDelegate;
import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.dto.UniversityDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class GetUniversityAction
 */
@WebServlet("/GetUniversityAction")
public class GetUniversityAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUniversityAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentRegistrationValidationDelegate studentRegistrationValidationDelegate=new StudentRegistrationValidationDelegate();
		try {
			List<UniversityDTO> universityList = studentRegistrationValidationDelegate.getUniversityList();
			Gson gson = new Gson();
			String universitiesJson = gson.toJson(universityList);
			response.setContentType("text/json");
			response.getWriter().write(universitiesJson);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setContentType("text/json");
			response.getWriter().write("[\"" + e.getMessage()+ "\"]");
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			response.setContentType("text/json");
			response.getWriter().write("[\"" + e.getMessage()+ "\"]");
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
