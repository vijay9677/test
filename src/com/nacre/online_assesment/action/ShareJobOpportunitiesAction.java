package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ShareJobOppertunityFormBean;

/**
 * 
 * @author VijayKumar P
 * @description this servlet using for sharing job opportunities to students who
 *              are eligible
 *
 */
@WebServlet("/shareJobOpportunities")
public class ShareJobOpportunitiesAction extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = null;
		ShareJobOppertunityFormBean shareJobOppertunityFormBean = null;
		JobOpportunityPostingDelegate jobOpportunityPostingDelegate = null;
		RequestDispatcher rd = null;
		out = res.getWriter();
		res.setContentType("text/html");
		try {
		shareJobOppertunityFormBean = new ShareJobOppertunityFormBean();
		shareJobOppertunityFormBean.setDetails(req.getParameter("details"));
		shareJobOppertunityFormBean.setPercentage(req.getParameter("percentage"));
		shareJobOppertunityFormBean.setYop(Integer.parseInt(req.getParameter("yop")));
		

		System.out.println("share      "+shareJobOppertunityFormBean);
		jobOpportunityPostingDelegate = new JobOpportunityPostingDelegate();

	
			jobOpportunityPostingDelegate.shareJobOppertunity(shareJobOppertunityFormBean);

			req.setAttribute("successmsg", "job opportunities sended to student");
			String sharejsp = "/jsp/admin/shareJobOpportunities.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(req, res);

		} catch (DatabaseException | SQLException | MessagingException e) {
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(req, res);
			
			e.printStackTrace();
		}
		catch(Exception e){
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(req, res);
			
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);

	}
}
