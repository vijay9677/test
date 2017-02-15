package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.ClientManagementDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ClientManagementEditBean;

/**
 * @author Saurabh Suman b 35 This Action Is To edit client details Gives Json
 *         Response Servlet implementation class EditClientDetailsAction
 */
@MultipartConfig
@WebServlet("/EditClientDetailsAction")
public class EditClientDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClientDetailsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

        String clientName=request.getParameter("ClientName");
        String clientImage=request.getParameter("imgforedit");
        String clientDescription=request.getParameter("Description");
        String CompanyLevel=request.getParameter("Company_Level_Id");
		Integer level = Integer.parseInt(CompanyLevel);
	    String sid = request.getParameter("clientId");
		Integer clientId = Integer.parseInt(sid);

		
		
		ClientManagementEditBean editBean= new ClientManagementEditBean();
		editBean.setClientId(clientId);
		editBean.setClientName(clientName);
		editBean.setClientImage(clientImage);
		editBean.setDescription(clientDescription);
		editBean.setCompanyLevel(level);
		
		String msg=null;
		ClientManagementDelegate deligate = new ClientManagementDelegate();
		try {
			int count = deligate.editDetails(editBean);
			if (count >= 1) {
				msg="Record is updated successfully...";
				System.out.println("Record is updated successfully..."
						+ count);

			} else{
				System.out.println("Record is already exist");
				msg="Record is already exist";
			}
		
			Gson gson = new Gson();
			response.setContentType("text/json");
			System.out.println(gson.toJson(msg));
			
			out.println(gson.toJson(msg));
		} catch (SQLException | DatabaseException e) {
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
