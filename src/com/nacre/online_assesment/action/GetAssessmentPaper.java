
/**
 * @author krishna prakash
 */
package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * Servlet implementation class GetAssessmentPaper
 */
@WebServlet("/GetAssessmentPaper.technical")
public class GetAssessmentPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AssesmentsDelegate ad=new AssesmentsDelegate();
		List<AssesmentDTO> li;
		try {
			li = ad.getAssessmentPaper();
			HttpSession session=request.getSession();
			session.setAttribute("assessmentPaper", li);
		   } 
		   catch (DatabaseException | SQLException e) 
		   {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		
	}

}
