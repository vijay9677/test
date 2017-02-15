package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.JobOpportunityPostingDelegate;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;
/**
 * 
 * @author Srinivas N
 *
 */
@WebServlet("/JobPostingClientAddress")
public class JobPostingClientAddressaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        RequestDispatcher rd=null;
		JobOpportunityPostingDelegate jobopportunityPostingdelegate = new JobOpportunityPostingDelegate();
		List<ClientAddressDetailVo> list=null;
		try {
			System.out.println("JobPostingClientAddress");
           
			//reading client id from requested URL
			Integer clientId=null;
//			Integer.parseInt(request.getParameter("clientId"));
			String temp=request.getParameter("clientId");
			String temp1=(String)request.getAttribute("clientId");
			if(temp!=null){
				clientId=Integer.parseInt(temp);	
			}
			if(temp1!=null){
				clientId=Integer.parseInt(temp1);	
			}
			System.out.println(">>>>>>>>>>>>>>>>>>CID"+clientId);
			/*System.out.println("ClientId"+request.getParameter("clientId"));*/
			if(clientId!=null){
			list = jobopportunityPostingdelegate.getClientAddressDetail(clientId);
			request.getSession().setAttribute("ClientAddressDetailVo", list);
			
			response.sendRedirect(request.getContextPath()+"/jsp/corporate_relation/add_jobposting.jsp");
			
			
			}else{ 
				throw new NullPointerException();
			}
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException n){
		System.out.println("null");
			// request.getRequestDispatcher("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp").include(request, response);
			String path="jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp";
			response.sendRedirect(request.getContextPath()+"/jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp");
			
			
			//getServletContext().getRequestDispatcher(path);
		//	rd.forward(request, response);
		   n.printStackTrace();
		}catch(NumberFormatException  nul){
			 //request.getRequestDispatcher("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp").include(request, response);
			response.sendRedirect("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp");
			nul.printStackTrace();
		}catch (Exception e) {
//			 request.getRequestDispatcher("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp").include(request, response);
			response.sendRedirect("jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp");
			e.printStackTrace();
		}
		

	}

}
