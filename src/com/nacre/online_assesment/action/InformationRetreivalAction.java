package com.nacre.online_assesment.action;

import java.io.IOException;
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
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

/**
 * Servlet implementation class InformationRetreivalAction
 */
@WebServlet("/InformationRetreivalAction")
public class InformationRetreivalAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationRetreivalAction() {
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
		//HttpSession httpSession = request.getSession();
		String s =request.getParameter("userId");
		if(s==null){
		s=(String)	request.getSession().getAttribute(StringConstants._SESSION_USER_ID);
			
		}
		Integer userId=Integer.parseInt(s);
	//userId=108;
		//Integer userid=108;
		/*InformationRetreivalBean ibean=new InformationRetreivalBean();
		ibean.setUserId(userid);
		*/AuthenticationDelegate ad = new AuthenticationDelegate();
		
		try {
			
				//System.out.println("before calling");
				UserDTO rd=ad.informationRetreival(userId);
				//System.out.println(rd);
			//	System.out.println(rd.getPassword());
				RoleDTO role = rd.getRole();
			//	System.out.println(role);
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute(StringConstants._SESSION_USER_ID, rd.getUserid());
				httpSession.setAttribute(StringConstants._SESSION_USER_ROLE_ID, role.getRoleId());
				httpSession.setAttribute(StringConstants._SESSION_EMAIL, rd.getEmail());
				httpSession.setAttribute(StringConstants._SESSION_USER_NAME, rd.getFirstname()+" "+rd.getLastname());
				httpSession.setAttribute(StringConstants._SESSION_USER_IMG, rd.getImage());
				//	httpSession.setAttribute("techId", rd.getTechnology().getTechnologyId());
				Cookie uId = new Cookie(StringConstants._SESSION_USER_ID, rd.getUserid() + "");
				Cookie roleId = new Cookie(StringConstants._SESSION_USER_ROLE_ID, role.getRoleId() + "");
				Cookie cUserEmail = new Cookie(StringConstants._SESSION_EMAIL, rd.getEmail());
				Cookie cUserName = new Cookie(StringConstants._SESSION_USER_NAME, rd.getFirstname()+" "+rd.getLastname());
				
				
		/*		Cookie c = new Cookie("jSessionId", httpSession.getId());
		*/	//	System.out.println(rd.getEmail() + ":" +rd.getPassword());
/*				if (request.getParameter("remember") != null) {
					String remember = request.getParameter("remember");
					System.out.println("remember : " + remember);
					cUserName.setMaxAge(60 * 60 * 24 * 15);// 15 days

					cUserEmail.setMaxAge(60 * 60 * 24 * 15);// 15 days
					roleId.setMaxAge(60 * 60 * 24 * 15);
					uId.setMaxAge(60 * 60 * 24 * 15);
				}*/
				response.addCookie(roleId);
				response.addCookie(cUserName);
				response.addCookie(uId);
		/*		response.addCookie(c);
		*/		response.addCookie(cUserEmail);

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


		
		} 
		catch (SQLException | InvalidException  | DatabaseException e) {
			e.printStackTrace();
			
			response.sendRedirect(request.getContextPath()+URLConstants.LOGIN_PAGE_URL);
		} 
		
	}

}
