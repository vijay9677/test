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
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author ARVIND KUMAR Batch35 This Action is used to getGroupByAdminData Gives Json
 * 			Response Servlet implementation class GetGroupByAdminDataAction
 */
@WebServlet("/GetGroupByAdminDataAction")
public class GetGroupByAdminDataAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGroupByAdminDataAction() {
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
		String roleid=request.getParameter("RoleId");
		Integer roleId =Integer.parseInt(roleid);
		List<String> groupList=new ArrayList<String>();
        String json=null;
        AdminDelegate adminDelegate=new AdminDelegate();
        try {
        	groupList=adminDelegate.getGroupByAdminRecords(roleId);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         Gson gson=new Gson();
         json=gson.toJson(groupList);
         response.setContentType("application/json");
         response.getWriter().write(json);
        // pw=response.getWriter();
        //pw.println(response);
	}
}