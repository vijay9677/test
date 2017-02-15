package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.SelectingYopOrPercentageBean;

/**
 * 
 * @author VijayKumar P
 * @Description this Servlet using for filtering students by their criteria i,e
 *              Year of passed outs and percentage
 *
 */

@WebServlet("/selectingYearOrPercetageAction")
public class SelectingYearOrPercetageAction extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		RequestDispatcher rd=null;

		HttpSession session = req.getSession(false);

		try {
		String jobP = (String) session.getAttribute("jobId");
		Integer jobPostingId = Integer.parseInt(jobP);

		String percentage = req.getParameter("percentage");

		String years = req.getParameter("year");

		String selectedYears[] = null;
		if (years != null) {
			selectedYears = years.split(",");
			System.out.println(selectedYears + "");
		} else {
			years = " ";
		}

		// int year=0;
		JobOpportunityPostingDelegate jobOpportunityPostingDelegate = new JobOpportunityPostingDelegate();

		

			ArrayList<SelectingYopOrPercentageBean > yopperList = jobOpportunityPostingDelegate
					.selectYearOrPer(percentage, years, jobPostingId);

			Gson yoppergson = new Gson();
			String yopperlist = yoppergson.toJson(yopperList);

			out.println(yopperlist);
		} catch (SQLException | DatabaseException e) {
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(req, resp);
			
			e.printStackTrace();
		}
		catch(Exception e){
			String sharejsp = "/jsp/admin/adminErrorPage.jsp";
			rd = getServletContext().getRequestDispatcher(sharejsp);

			rd.forward(req, resp);
			
			e.printStackTrace();
		}

	}

}
