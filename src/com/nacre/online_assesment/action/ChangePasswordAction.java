package com.nacre.online_assesment.action;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.delegate.AuthenticationDelegate;
import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ChangeBean;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

/**
 * @author B.Rakesh kumar
 * @ChangePasswordAction This Servlet class is used to capture the email id and password which is comming from the ModifyPassword.jsp page
 * and sends to AuthenticationDeligate,  also gets the response from the AuthenticationDeligate after getting data from the database . 
 */
/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePasswordAction")
public class ChangePasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**@author B.Rakesh kumar 
	  * @params request,response Accepts javax.servlet.HttpServletRequest,javax.servlet.HttpServletResponse
	  * @throws ServletException occurs when problem occurs with servlet  
	  * @throws IOException occurs when dealing with the writing data or reading data. 
	  * */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
    
	/**@author B.Rakesh kumar 
	  * @params request,response Accepts javax.servlet.HttpServletRequest,javax.servlet.HttpServletResponse
	  ** @throws ServletException occurs when problem occurs with servlet  
	  * @throws IOException occurs when dealing with the writing data or reading data. 
	  * */
	
	/**
	 *@see  HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute(StringConstants.SESSION_USERE_MAI);
		out.println(email);
		
//		email="rakeshkumarsakshi@gmail.com";
		
		String oldPassword = request.getParameter("oldpwd");
		String newPassword = request.getParameter("newpwd");
		String conPassword = request.getParameter("confirmpwd");
		
	//	oldPassword="87654321";
		//newPassword="12345678";

		//conPassword="12345678";
		out.println(oldPassword);
		out.println(newPassword);
		out.println(conPassword);
		ChangeBean cb=new ChangeBean();
		cb.setEmail(email);
		UserDTO udt=new UserDTO();
		
		
		cb.setOldPassword(oldPassword);
		cb.setNewPassword(newPassword);
		cb.setConPassword(conPassword);
		
		
		 AuthenticationDelegate ad=new AuthenticationDelegate();
		 
		 
		 try {
			int effectedRow;
			effectedRow = ad.changeData(cb);
			if(effectedRow==1)
			{
				HttpSession httpSession = request.getSession();
				Object role=httpSession.getAttribute(StringConstants.SESSION_USERE_ROLE);
				System.out.println(role);
				
				if (role == StringConstants._ADMIN_ROLE_ID) {
					request.getSession().setAttribute("pwd_msg", StringConstants.PASSWORD_CHANGE);
					response.sendRedirect(request.getContextPath() + "/" + URLConstants.ADMIN_HOME_PAGE_URL);
				} else if (role == StringConstants._HR_ROLE_ID) {
					request.getSession().setAttribute("pwd_msg",StringConstants.PASSWORD_CHANGE );
					response.sendRedirect(request.getContextPath() + "/" + URLConstants.HRADMIN_HOME_PAGE_URL);

				} else if (role== StringConstants._CORPORATE_ROLE_ID) {
					request.getSession().setAttribute("pwd_msg",StringConstants.PASSWORD_CHANGE);

					response.sendRedirect(request.getContextPath() + "/" + URLConstants.CORPORATEADMIN_HOME_PAGE_URL);

				} else if (role == StringConstants._SYSTEM_ROLE_ID) {
					request.getSession().setAttribute("pwd_msg", StringConstants.PASSWORD_CHANGE);

					response.sendRedirect(request.getContextPath() + "/" + URLConstants.SYSTEMADMIN_HOME_PAGE_URL);

				} else if (role == StringConstants._TECHINICAL_ROLE_ID) {
					request.getSession().setAttribute("pwd_msg",StringConstants.PASSWORD_CHANGE);

					response.sendRedirect(request.getContextPath() + "/" + URLConstants.TECHNICALADMIN_HOME_PAGE_URL);

				} else if (role == StringConstants._STUDENT_ROLE_ID) {
					request.getSession().setAttribute("pwd_msg", StringConstants.PASSWORD_CHANGE);

					response.sendRedirect(request.getContextPath() + "/" + URLConstants.STUDENT_HOME_PAGE_URL);

				}
			} 
			else
			{
				request.getSession().setAttribute("changepwd-message3","please enter the correct password");
				response.sendRedirect(request.getContextPath()+"/jsp/ChangePassword.jsp");
			}
		} 
		 catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		
		
	}

}
}
