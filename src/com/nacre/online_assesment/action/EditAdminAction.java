package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.AdminDelegate;
import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author ARVIND KUMAR Batch35 This Action is used to editAdmin
 * 			Response Servlet implementation class EditAdminAction
 */
@MultipartConfig
@WebServlet("/EditAdminAction")
public class EditAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String image = request.getParameter("img");
		Integer userId=Integer.parseInt(request.getParameter("user_Id"));
		String f_Name=request.getParameter("first_Name");
		String l_Name=request.getParameter("last_Name");
		String email_id=request.getParameter("email_Id");
		String mobile=request.getParameter("mobile");
		Integer edit_Gender=Integer.parseInt(request.getParameter("editGender"));
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		RoleDTO roleDto=new RoleDTO();
		roleDto.setRoleId(roleId);
		
		try {

			UserDTO userDTO=new UserDTO();
			userDTO.setUserid(userId);
			userDTO.setFirstname(f_Name);
			userDTO.setLastname(l_Name);
			userDTO.setEmail(email_id);
			userDTO.setMobileNo(mobile);
			userDTO.setGender(edit_Gender);
			userDTO.setImage(image);
			userDTO.setRole(roleDto);
			AdminDelegate adminDelegate=new AdminDelegate();
			int count=adminDelegate.editAdmin(userDTO);
			if (count>=1) {
				System.out.println(count+" Records are Successfully updated in Tbl_User");
				response.getWriter().print("SUCCESS");
			} else {
				System.out.println(count+" Records are not Successfully updated in Tbl_User");
				response.getWriter().println("Error During Update");
			}
		} catch (DatabaseException dbe) {
			// TODO: handle exception
			dbe.printStackTrace();
			response.getWriter().print("PLEASE TRY LATER");
		} catch (DataNotFoundException dnfe) {
			// TODO: handle exception
			dnfe.printStackTrace();
			response.getWriter().print("PLEASE TRY LATER");
		}catch (SQLException sqle) {
			// TODO: handle exception
			sqle.printStackTrace();
			response.getWriter().print("PLEASE TRY LATER");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.getWriter().print("PLEASE TRY LATER");
		}
	}
}