package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nacre.online_assesment.delegate.StudentRequestFeedBackDelegate;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;




/**
 * @ author Amarendar Guthuru
 *This class is Created for Sending user feedback to DB
 * Servlet implementation class SendFeedbackAction
 */
@WebServlet("/SendFeedbackAction")
public class SendFeedbackAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String message = null;
	Integer feedbacktypeid = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public SendFeedbackAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Amarendar Guthuru
	 * @param request,response accepts javax.servlet.HttpServletException,javax.servlet.HttpServletResponse
	 * @throws ServletException,IoException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		feedbacktypeid = Integer.parseInt(request.getParameter("feedback"));
		message = request.getParameter("feedback-text");
		Integer userid = 1;
		Integer clientaddreesid = null;
		int savedSucessfullyorNot=0;
		StudentRequestFeedBackDelegate studentRequestFeedBackDelegate = new StudentRequestFeedBackDelegate();
		if (feedbacktypeid == 2) {
		
			Integer clientid = Integer.parseInt(request.getParameter("company"));
			//String id=request.getParameter("company");
			Integer addressid = Integer.parseInt(request.getParameter("clientlocation"));
			/*System.out.println(clientid);
			System.out.println(id);*/
			
			System.out.println(clientid);
			System.out.println(addressid);
			System.out.println(message);
			StudentRequestFeedBackDelegate backDelegate = new StudentRequestFeedBackDelegate();
			try {
				clientaddreesid = backDelegate.getClientAddressId(clientid, addressid);
				System.out.println(clientaddreesid);

			} catch (DatabaseException | SQLException | DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			clientaddreesid = StringConstants.ORGANIZATION_ADDR_ID;
		}
		try {
			savedSucessfullyorNot = studentRequestFeedBackDelegate.saveFeedBackTable(message, feedbacktypeid, userid,
					clientaddreesid);
			request.getSession().setAttribute("value",savedSucessfullyorNot);
			response.sendRedirect(request.getContextPath()+"/jsp/student/SendFeedback.jsp");
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/jsp/student/SendFeedback.jsp");

			
		}
		//request.setAttribute("value", savedSucessfullyorNot);
        //request.getRequestDispatcher("jsp/student/success.jsp").forward(request, response);
		//request.getRequestDispatcher("jsp/student/SendFeedback.jsp").forward(request, response);

		
	}

	/**
	 * @author Amarendar Guthuru
	 * @param request,response accepts javax.servlet.HttpServletException,javax.servlet.HttpServletResponse
	 * @throws ServletException,IoException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
