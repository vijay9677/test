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
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author ARVIND KUMAR Batch35 This Action is used to deleteAdmin
 * 			Response Servlet implementation class DeleteAdminAction
 */
@WebServlet("/DeleteAdminAction")
public class DeleteAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		UserDTO userDto=new UserDTO();
		Integer userId=Integer.parseInt(request.getParameter("UserId"));
		userDto.setUserid(userId);
		AdminDelegate adminDelegate=new AdminDelegate();
		
		try {
			int count = adminDelegate.deleteAdmin(userDto);
			if (count>=1) {
				System.out.println("This UserId records are Deleted Successfully from the Database... "+count);
				out.println("<font color=green>"+userDto+" user Data deleted successfully");
			} else {
				System.out.println("This UserId records are Deleted Successfully from the Database... "+count);
				out.println("<font color=red>Sorry "+userDto+" user data is Not Available");
			}
		} catch (DatabaseException dbe) {
			// TODO Auto-generated catch block
			dbe.printStackTrace();
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
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