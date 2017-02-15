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
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ClientAddressBean;

/**
 * @author Amarendar Guthuru
 * This class is created for getting compnay locality based on city from DB
 * Servlet implementation class GetCompanyAddress
 */
@WebServlet("/GetCompanyLocality.student")
public class GetCompanyLocality extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCompanyLocality() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @author Amarendar Guthuru
	 * @param request,response accepts javax.servlet.HttpServletRequest,javax.servlet.HttpServletResponse
	 * @throws ServletException,IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		// TODO Auto-generated method stub
		Integer clientId=Integer.parseInt(request.getParameter("clientId"));
		Integer cityId=Integer.parseInt(request.getParameter("cityId"));
	
		System.out.println(clientId);
		System.out.println(cityId);
		StudentRequestFeedBackDelegate backDelegate=new StudentRequestFeedBackDelegate();
		try {
			List<ClientAddressBean> companyAddressList=backDelegate.getClientLocality(cityId,clientId);
			response.setContentType("text/json");
			Gson gson=new Gson();
			response.getWriter().print(gson.toJson(companyAddressList));
			
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	/**
	 * @author Amarendar Guthuru
	 * @param request,response accepts javax.servlet.HttpServletRequest,javax.servlet.HttpServletResponse
	 * @throws ServletException,IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
