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
@WebServlet("/AddMoreClientAddressAction")
public class AddMoreClientAddressAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddMoreClientAddressAction() {
		super();
		System.out.println("in AddMoreClientAddressAction");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/json");
		PrintWriter out=response.getWriter();
	
	

			AddClientManagementBean addClientManagementBean = new AddClientManagementBean();
			addClientManagementBean.setClientId(Integer.parseInt(request.getParameter("clientId")));
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
						.addMoreClientAddress(addClientManagementBean);
				if (count >= 1) {
				msg="Record is inserted successfully...";
					System.out.println("Record is inserted successfully..."
							+ count);

				} else{
					System.out.println("Record is not inserted sucessfully..."
							+ count);
				msg="Record is  not inserted Pls try with another Mobile No or EmailId ...";
				}
			  
				Gson gson = new Gson();
				response.setContentType("text/json");
			    out.println(gson.toJson(msg));

			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
