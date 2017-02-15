package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;
import com.nacre.online_assesment.vo.GettingLocationCurespondingVO;

/**
 * @author Srinivas N
 * @version 1.0 This Action Is To give particular address details like
 *          city,sate,country,pine code of a given location Gives Json Response
 *          to add_jobposting.jsp
 */
@WebServlet("/GettingLocationCurespondingAddres")
public class GettingLocationCurespondingAddresAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/json");
		System.out.println("Ajax call is made");
		List<ClientAddressDetailVo> clientAddressList = (List<ClientAddressDetailVo>) request
				.getSession().getAttribute("ClientAddressDetailVo");

		Integer addressId = Integer.parseInt(request.getParameter("aId"));
		
		// i have to store location based on addresId related
		// city,sate,country,pine code of an particular client
		
		GettingLocationCurespondingVO gettingLocationCurespondingVO=new GettingLocationCurespondingVO();
		
		for (int i = 0; i < clientAddressList.size(); i++) {

			if (addressId == clientAddressList.get(i).getAddress_id()) {
                
				gettingLocationCurespondingVO.setCity(clientAddressList.get(i).getCity());
				
				gettingLocationCurespondingVO.setCountry(clientAddressList.get(i).getCountry());
				gettingLocationCurespondingVO.setState(clientAddressList.get(i).getState());
				gettingLocationCurespondingVO.setPincode(clientAddressList.get(i).getPincode());
				gettingLocationCurespondingVO.setCity(clientAddressList.get(i).getCity());
			}// if
		}// for
		Gson gson=new Gson();
		String jsonData=gson.toJson(gettingLocationCurespondingVO);
		response.getWriter().write(jsonData);
		System.out.println("clientAddressList"+clientAddressList);
		System.out.println("jsonDAta"+jsonData);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

	}

}
