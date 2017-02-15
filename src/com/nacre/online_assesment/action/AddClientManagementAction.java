package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.nacre.online_assesment.delegate.ClientManagementDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.exception.ImageStreamToByteException;
import com.nacre.online_assesment.form_bean.AddClientManagementBean;
import com.nacre.online_assesment.util.ImageUtil;

/**
 * @author Sonali Chavan Action for adding client in tbl_client,tbl_client_address,tbl_address 
 * return integer type of inserted row
 */

@MultipartConfig
@WebServlet("/AddClientManagementAction")
public class AddClientManagementAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddClientManagementAction() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Part part = request.getPart("img");
		InputStream is = part.getInputStream();
		try {
			String s = ImageUtil.encodeImage(is);

			AddClientManagementBean addClientManagementBean = new AddClientManagementBean();

			addClientManagementBean.setClientName(request
					.getParameter("ClientName"));
			addClientManagementBean.setCompanyImage(s);
			addClientManagementBean.setDescription(request
					.getParameter("Description"));
			addClientManagementBean.setCompanyLevelId(Integer.parseInt(request
					.getParameter("Company_Level_Id")));
			addClientManagementBean.setContactPersonName(request
					.getParameter("contact_person_name"));
			addClientManagementBean.setContactPersonMobileNo(request
					.getParameter("contact_person_mobile_no"));
			addClientManagementBean.setContactPersonMail(request
					.getParameter("contact_person_mail"));
			addClientManagementBean.setCityId(Integer.parseInt(request
					.getParameter("cityId")));
			addClientManagementBean.setLocation(request
					.getParameter("location"));
			addClientManagementBean.setPincode(request.getParameter("pincode"));
			String msg=null;
			ClientManagementDelegate clientManagementDelegate = new ClientManagementDelegate();
			try {
				int count = clientManagementDelegate
						.addClient(addClientManagementBean);
				if (count >= 1) {
				msg="Record is inserted successfully...";
					System.out.println("Record is inserted successfully..."
							+ count);

				} else{
					System.out.println("Record is not inserted sucessfully..."
							+ count);
				msg="Record is  not inserted ...";
				}
			   
				RequestDispatcher rd = request.getRequestDispatcher("./jsp/corporate_relation/ClientManagement.jsp");
				request.setAttribute("msg",msg);
				rd.forward(request, response);
				
				
			/*	Gson gson = new Gson();
				response.setContentType("text/json");
				System.out.println(gson.toJson(msg));
				
				out.println(gson.toJson(msg));*/

			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ImageStreamToByteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
