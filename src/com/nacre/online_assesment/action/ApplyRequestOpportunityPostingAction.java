package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.ApplyRequestOpportunityPostingDelegate;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;


/**
 * @author JAY SINGH 
 *
 */

@WebServlet("/ApplyRequestOpportunityPostingAction")
public class ApplyRequestOpportunityPostingAction extends HttpServlet {
	/**
	 * @author JAY SINGH
	 */
    
    /**
	 * @author JAY Singh
	 */
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	ApplyRequestOpportunityPostingDelegate del=new ApplyRequestOpportunityPostingDelegate();
        
    	PrintWriter pw=resp.getWriter();
    	
    Enumeration<String>	 s = req.getParameterNames();
    	while (s.hasMoreElements()) {
			System.out.println(s.nextElement());
		}

		int user_id=Integer.parseInt(req.getParameter("user_id"));
		//System.out.println("user id="+user_id);    	
		//System.out.println("user id "+user_id);
    	 List<Object> list=null;
		try {
			list = del.getUserDetails(user_id);

			System.out.println(list.get(0));
			
				 req.setAttribute("jobOpp",list);
			
	    

			
			RequestDispatcher rd=req.getRequestDispatcher("/jsp/admin/user_details.jsp");
			rd.forward(req, resp); 
	
	} catch (SQLException | DatabaseException e) {
		e.printStackTrace();
	}	
		
	
	}
}
