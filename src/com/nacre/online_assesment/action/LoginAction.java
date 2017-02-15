package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.delegate.AuthenticationDelegate;
import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.exception.InvalidException;
import com.nacre.online_assesment.form_bean.LoginBean;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

/**
 * @author B.Rakesh kumar
 * @LoginAction This Servlet class is used to capture the email id and password which is comming from the Login.jsp page
 * and sends to AuthenticationDeligate  also gets the response from the AuthenticationDeligate . 
 */

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author B.Rakesh kumar
	 * @params request,response Accepts
	 *         javax.servlet.HttpServletRequest,javax.servlet.
	 *         HttpServletResponse
	 * @throws ServletException
	 *             occurs when problem occurs with servlet
	 * @throws IOException
	 *             occurs when dealing with the writing data or reading data.
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @author B.Rakesh kumar
	 * @params request,response Accepts
	 *         javax.servlet.HttpServletRequest,javax.servlet.
	 *         HttpServletResponse
	 * @throws ServletException
	 *             occurs
	 * @throws IOException
	 */

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("firstname", email);

		/*
		 * /creating loginbean object and setting the username and password in
		 * the loginbean class which are comming from the html page
		 */

		LoginBean  lbean = new LoginBean();
		lbean.setEmail(email);
		lbean.setPassword(password);

		AuthenticationDelegate ad = new AuthenticationDelegate();
		try {
			UserDTO rd = ad.login(lbean);

			System.out.println(rd.getPassword());
			RoleDTO role = rd.getRole();
			System.out.println(role);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute(StringConstants._SESSION_USER_ID, rd.getUserid());
			httpSession.setAttribute(StringConstants._SESSION_USER_ROLE_ID, role.getRoleId());
			httpSession.setAttribute(StringConstants._SESSION_EMAIL, rd.getEmail());
			httpSession.setAttribute(StringConstants._SESSION_USER_NAME, rd.getFirstname()+" "+rd.getLastname());
			httpSession.setAttribute(StringConstants._SESSION_USER_IMG, rd.getImage());
			//	httpSession.setAttribute("techId", rd.getTechnology().getTechnologyId());
			Cookie uId = new Cookie(StringConstants._SESSION_USER_ID, rd.getUserid() + "");
			Cookie roleId = new Cookie(StringConstants._SESSION_USER_ROLE_ID, role.getRoleId() + "");
			Cookie cUserEmail = new Cookie(StringConstants._SESSION_EMAIL, email);
			Cookie cUserName = new Cookie(StringConstants._SESSION_USER_NAME, rd.getFirstname()+" "+rd.getLastname());
			
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+rd.getImage());
			Cookie c = new Cookie("jSessionId", httpSession.getId());
			System.out.println(email + ":" + password);
			if (request.getParameter("remember") != null) {
				String remember = request.getParameter("remember");
				System.out.println("remember : " + remember);
				cUserName.setMaxAge(60 * 60 * 24 * 15);// 15 days

				cUserEmail.setMaxAge(60 * 60 * 24 * 15);// 15 days
				roleId.setMaxAge(60 * 60 * 24 * 15);
				uId.setMaxAge(60 * 60 * 24 * 15);
			}
			response.addCookie(roleId);
			response.addCookie(cUserName);
			response.addCookie(uId);
			response.addCookie(c);
			response.addCookie(cUserEmail);

			if (role.getRoleId() == StringConstants._ADMIN_ROLE_ID) {
				response.sendRedirect(request.getContextPath() + "/" + URLConstants.ADMIN_HOME_PAGE_URL);
			} else if (role.getRoleId() == StringConstants._HR_ROLE_ID) {
				response.sendRedirect(request.getContextPath() + "/" + URLConstants.HRADMIN_HOME_PAGE_URL);
			} else if (role.getRoleId() == StringConstants._CORPORATE_ROLE_ID) {

				response.sendRedirect(request.getContextPath() + "/" + URLConstants.CORPORATEADMIN_HOME_PAGE_URL);

			} else if (role.getRoleId() == StringConstants._SYSTEM_ROLE_ID) {

				response.sendRedirect(request.getContextPath() + "/" + URLConstants.SYSTEMADMIN_HOME_PAGE_URL);

			} else if (role.getRoleId() == StringConstants._TECHINICAL_ROLE_ID) {

				response.sendRedirect(request.getContextPath() + "/" + URLConstants.TECHNICALADMIN_HOME_PAGE_URL);

			} else if (role.getRoleId() == StringConstants._STUDENT_ROLE_ID) {

				response.sendRedirect(request.getContextPath() + "/" + URLConstants.STUDENT_HOME_PAGE_URL);

			} else {

				response.sendRedirect(request.getContextPath() + "/" + URLConstants.LOGIN_PAGE_URL);
			}

		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/errpage");
		} catch (SQLException e) {

			e.printStackTrace();

			response.sendRedirect(request.getContextPath() + "/errPage");

		} catch (InvalidException e) {
			e.printStackTrace();
			
			request.getSession().setAttribute("login-msg", e.getMessage());
			response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");

		}

	}

}
