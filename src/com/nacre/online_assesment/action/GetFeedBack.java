package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.StudentRequestFeedBackDelegate;
import com.nacre.online_assesment.dto.FeedbackTypeDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;




/**
 * @ Amarendar Guthuru
 * This class is created for getting feedbacktype 
 * Servlet implementation class GetFeedBack
 */
@WebServlet("/GetFeedBack.ajax")
public class GetFeedBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFeedBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @Amarendar Guthuru
	 * @param request,response accepts javax.servlet.HttpServletRequest,javax.HttpServletResponse
	 * @throws ServletException.IoException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		StudentRequestFeedBackDelegate studentRequestFeedBackDelegate=new StudentRequestFeedBackDelegate();
		   try {
			List<FeedbackTypeDTO> l=studentRequestFeedBackDelegate.getFeedbackType();
		    Gson g=new Gson();
		    String json=g.toJson(l);
		    
		    res.setContentType("text/json");
			res.getWriter().write(json);
			
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}

	

	/**
	 * /**
	 * @ Amarendar Guthuru
	 * @ params request,response accepts javax.servlet.HttpServletRequest,javax.HttpServletResponse
	 * @ throws ServletException,IoException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
