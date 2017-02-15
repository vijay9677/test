package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.CommonDelegate;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author Saurabh Suman This Action Is To Take Level of the Company from
 *         tbl_level.
 */
@WebServlet("/GetCompanyLevelAction")
public class GetCompanyLevelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCompanyLevelAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		CommonDelegate commonDelegate = new CommonDelegate();
		try {
			List<LevelDTO> levelList = commonDelegate.getLevel();
			request.setAttribute("levelList", levelList);
			
			
			Gson gson = new Gson();
			String levelListJson = gson.toJson(levelList);
			response.setContentType("text/json");
			response.getWriter().write(levelListJson);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setContentType("text/json");
			response.getWriter().write("[\"" + e.getMessage()+ "\"]");
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			response.setContentType("text/json");
			response.getWriter().write("[\"" + e.getMessage()+ "\"]");
		}

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
