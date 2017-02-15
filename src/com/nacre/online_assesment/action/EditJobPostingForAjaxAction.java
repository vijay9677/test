package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.online_assesment.vo.GetClientDetailForEditingVo;
/**
 * @author Srinivas N
 * This action will give json object
 */
@WebServlet("/EditJobPostingForAjaxAction")
public class EditJobPostingForAjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/json");
		List<GetClientDetailForEditingVo> Vo = (List<GetClientDetailForEditingVo>) request
				.getSession().getAttribute("getClientDetailForEditingVosList");
		Integer jobPostingId = Integer.parseInt(request
				.getParameter("jobPostingId"));

		GetClientDetailForEditingVo gcl=null;
		for (int i = 0; i < Vo.size(); i++) {
			Integer temp = Integer.parseInt(Vo.get(i).getJobPostingId());
			if (jobPostingId == temp) {
				gcl=Vo.get(i);
			}
		}
		Gson gson=new Gson();
		String jsonData1=gson.toJson(gcl);
		response.getWriter().write(jsonData1);
		System.out.println("jsonData1-----"+jsonData1);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
