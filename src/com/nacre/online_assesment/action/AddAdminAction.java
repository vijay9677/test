package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.DateUtil;
/**
 * @author ARVIND KUMAR Batch35 This Action is used to addAdmin
 * 			Response Servlet implementation class AddAdminAction
 */
@MultipartConfig
@WebServlet("/AddAdminAction")
public class AddAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
				String fName=request.getParameter("fname");
				String lName=request.getParameter("lname");
				String email=request.getParameter("email");
				String password=request.getParameter("pwd");
				String confirmPwd=request.getParameter("rpwd");
				String moNo=request.getParameter("mno");
				Integer gender=Integer.parseInt(request.getParameter("gen"));
				String image=request.getParameter("img");
				String date=request.getParameter("dob");
				Date dateOfBirth=DateUtil.stringToSqlDate(date, "yyyy-MM-dd");
				Integer roleId = Integer.parseInt(request.getParameter("roleId"));
				RoleDTO roleDto=new RoleDTO();
				roleDto.setRoleId(roleId);
				if (password.equals(confirmPwd)) {
					try {
						UserDTO userDTO=new UserDTO();
						
						userDTO.setFirstname(fName);
						userDTO.setLastname(lName);
						userDTO.setEmail(email);
						userDTO.setPassword(password);
						userDTO.setMobileNo(moNo);
						userDTO.setGender(gender);
						userDTO.setImage(image);
						userDTO.setDate(dateOfBirth);
						userDTO.setRole(roleDto);
						AdminDelegate adminDelegate=new AdminDelegate();
						
						try {
							int count=adminDelegate.addAdmin(userDTO);
							if(count>=1)
							{
								System.out.println(count+" Record is inserted successfully... ");
								response.getWriter().write("SUCCESS");
							}
							else
								System.out.println(count+" Record is not inserted sucessfully... ");
						} catch (DatabaseException dbe) {
							// TODO Auto-generated catch block
							dbe.printStackTrace();
						} catch (SQLException sqle) {
							// TODO Auto-generated catch block
							sqle.printStackTrace();
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				} else {
					System.out.println("Sorry... Password didn't Matched. So, Please must be Enter Same Password.");
					out.println("Sorry... Password didn't Matched. So, Please must be Enter Same Password.");
				}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);
	}
}