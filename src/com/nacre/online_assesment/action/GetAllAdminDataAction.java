package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.AdminDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;

/**
 * @author ARVIND KUMAR Batch35 This Action is used to getAllAdminData Gives Json
 * 			Response Servlet implementation class GetAllAdminDataAction
 */
@WebServlet("/GetAllAdminDataAction")
public class GetAllAdminDataAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllAdminDataAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=null;
        List<String> getList=new ArrayList<String>();
        String json=null;
        AdminDelegate adminDelegate=new AdminDelegate();
        HttpSession httpSession=request.getSession(true);
        Integer userId=(Integer)httpSession.getAttribute(StringConstants._SESSION_USER_ID);
        try {
			getList=adminDelegate.getAdminRecords(userId);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println(getList);
         Gson gson=new Gson();
         json=gson.toJson(getList);
         response.setContentType("application/json");
         response.getWriter().write(json);
        // pw=response.getWriter();
        //pw.println(response);
	}

}
