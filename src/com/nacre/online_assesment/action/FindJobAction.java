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
import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.dto.AddressDTO;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.StatusDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.FindJobPostingVO;

/**
 * @author Sagar Suryawanshi b 35 This Action Is To All Job Post Related to city, company,technology Gives Json
 *         Response Servlet implementation class FindJobAction
 */
@WebServlet("/FindJobAction.student")
public class FindJobAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindJobAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer company=null;
		Integer city=null;
		Integer technology=null;
		String companys = request.getParameter("company");
		System.out.println("company"+companys);
		if(companys==""){
			System.out.println("company null");
			 company=null;
		}
		else{
		 company=Integer.parseInt(companys);
		}

		//String company ="acent";
		String citys = request.getParameter("city");
		System.out.println("citys"+citys);
        if(citys==""){
    		 city=null;
        }
        else{
		 city=Integer.parseInt(citys);
        }

		//String city="";
		String technologys = request.getParameter("technology");
		System.out.println("technologys"+technologys);

		if(technologys==""){
		 technology=null;
		}
		else{
		 technology=Integer.parseInt(technologys);
		}
		//String technology =".net";

		FindJobPostingVO jobpostvo=new FindJobPostingVO();
		jobpostvo.setCompanyName(company);
		//jobpostvo.setCompanyName(1002);

		jobpostvo.setCity(city);
		//jobpostvo.setCity(5);

		jobpostvo.setTechnology(technology);
		//jobpostvo.setTechnology(2);

		
		PrintWriter pw = response.getWriter();
		JobOpportunityPostingDelegate deligate = new JobOpportunityPostingDelegate();
		try {
			List<Object> list = deligate.findJobPost(jobpostvo);
			
			
			Gson gson = new Gson();
			response.setContentType("text/json");
			System.out.println(gson.toJson(list));
			String jobPostDetails = gson.toJson(list);
			pw.println(jobPostDetails);
		} catch (SQLException | DatabaseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
