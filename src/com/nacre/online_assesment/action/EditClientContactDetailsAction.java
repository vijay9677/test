package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
import com.nacre.online_assesment.form_bean.ClientManagementEditContactBean;

/**
 * Servlet implementation class EditClientContactDetailsAction
 */
@MultipartConfig
@WebServlet("/EditClientContactDetailsAction")
public class EditClientContactDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClientContactDetailsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		int addressId=Integer.parseInt(request.getParameter("addressId"));
		Integer pincode = Integer.parseInt(request.getParameter("pincode"));
        String conatact_person_name=request.getParameter("contact_person_name");
        String contact_person_mobile_no=request.getParameter("contact_person_mobile_no");
        String contact_person_Email=request.getParameter("contact_person_mail");
        Integer cityId = Integer.parseInt(request.getParameter("cityId"));
        String location=request.getParameter("location");
        
        
        ClientManagementEditContactBean editContactBean= new ClientManagementEditContactBean();
		  
          editContactBean.setAddressId(addressId);
		  editContactBean.setCityId(cityId);
		  editContactBean.setConatact_person_name(conatact_person_name);
		  editContactBean.setContact_person_Email(contact_person_Email);
		  editContactBean.setContact_person_mobile_no(contact_person_mobile_no);
		  editContactBean.setLocation(location);
		  editContactBean.setPincode(pincode);
		  String msg=null;
		  ClientManagementDelegate deligate = new ClientManagementDelegate();
		  try {
				int count = deligate.editContactDetails(editContactBean);
				if (count >= 1) {
					msg="Address updated successfully...";
					System.out.println("Address updated successfully..."
							+ count);

				} else{
					System.out.println("Address is already exist");
					msg="Address is already exist";
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
	 * @see HttpServlet#doPost(Htt
	 * pServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
