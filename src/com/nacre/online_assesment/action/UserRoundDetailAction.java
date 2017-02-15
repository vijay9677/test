package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.PlacementsDelegate;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobRoundBean;


/**
 * Servlet implementation class UserRoundDetailAction
 */
@WebServlet("/UserRoundDetailAction")
public class UserRoundDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer roundDetailId = Integer.parseInt(request.getParameter("roundId"));
		System.out.println("round id "+request.getParameter("roundId"));
		//Integer roundDetailId = 401;
		JobRoundBean jrb = new JobRoundBean();
		System.out.println(roundDetailId);
		jrb.setInterview_round_id(roundDetailId);
		
		PlacementsDelegate deligate = new PlacementsDelegate();
		ArrayList<UserDTO> Roundlist;
		try {
			Roundlist = deligate.getUserDetail(jrb);
		
		Gson json = new Gson();
		response.setContentType("text/json");
		String userRounddetail = json.toJson(Roundlist);
		System.out.println(userRounddetail);
		PrintWriter pw = response.getWriter();
		pw.write(userRounddetail);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
