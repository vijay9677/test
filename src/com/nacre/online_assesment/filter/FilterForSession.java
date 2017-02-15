package com.nacre.online_assesment.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/*import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

*/
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;


/**
 * This class contains Filter Logic to provide access to  valid user 
 * @version 1.0.0 2016
 * @author Nacre Batch 35 Java
 * 
 */
//@WebFilter("/*")
public class FilterForSession implements Filter {

	
    public FilterForSession() {
       System.out.println("IN SESSIONFILTER");
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("in filter");
		
		 HttpServletRequest request=(HttpServletRequest)req;
		 HttpSession session=request.getSession(false);
		 HttpServletResponse response=(HttpServletResponse)res;
		  Cookie[] cookies=request.getCookies();
		  String contextPath = request.getServletContext().getContextPath();
		  String path = request.getServletPath();
		 //    session.setMaxInactiveInterval(40*50*60);
		  String email=null;
		    String uid=null;
		    Integer roleId=null;
		    String gender = null;
		    Integer cstatus = null;
		    String image = null;
	
		    
		    
		    
		    
		    
		    
		    

	   	  	System.out.println(">>>>>>>>>>>>CHECKING SESSION:"+path);	
	if(path.contains("/ForgetAction")||path.contains("/ForgotPassword.jsp")||path.contains("/assets")||path.contains("/common")||path.contains("/Login.jsp") || path.contains(URLConstants._GET_USER_DETAILS_FOR_SESSION )|| path.contains("LoginAction")||path.contains("PersonalDetailsRegistration.jsp")
		    		||path.contains("SSC&IntermediateRegistration.jsp")||path.contains("PostGraduationRegistration.jsp")||path.contains("GraduationDetailsRegistration.jsp")||path.contains("CourseInfoRegistration.jsp")||path.contains("StudentRegistrationAction")
		    		||path.contains("GetCityAction")||path.contains("GetCourses")
		    		||path.contains("GetCountryAction")
		    		||path.contains("GetCountryDetailsAction")
		    		||path.contains("GetCountryJavaAction")
		    		||path.contains("GetCoursesAction")
		    		||path.contains("GetCourses")
		    		||path.contains("GetCourseAction")
		    		||path.contains("GetStateAction")
		    		||path.contains("GetStateCouPinCodeAjaxAction")
		    		||path.contains("StudentRegistrationAction")
		    		||path.contains("GetUnivercitySunilAction")
		    		||path.contains("GetTechnologyAction")
		    		||path.contains("GetStreamAction")
		    		||path.contains("GetStateAction")
		    		||path.contains("GetCollegeAction")
		    		||path.contains("js")
		    		||path.contains("css")
		    		||path.contains("images")
		    		){
		   	System.out.println("ASSETS || COMMON ALLOWED :"+path);	
		   		chain.doFilter(request, response);
		   	
		   	}else{
		   		
		   	  	System.out.println("CHECKING SESSION:"+path);	
				   		
		   		if(session!=null){
		   		  	System.out.println("SESSION EXISTS CHECKING USER :"+path);	
		   		 
		   			//SESSION USER DATA
		   		Integer userId = (Integer) session.getAttribute(StringConstants._SESSION_USER_ID);
		   			if(userId!=null){
		   				//check role 
		   			 	System.out.println("USER EXISTS CHECKING ROLE :"+userId);	
				   		 
		   				roleId = (Integer)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID);
		   				if(roleId!=null){
		   					//redirect to respective role home page
		   					System.out.println("role EXISTS trying to Redirect :"+roleId);	
		   					
		   					chain.doFilter(request, response);
		   					
		   					
		   					
		   					
					   		 		
		   				}else{
		   					//loginPage
		   					System.out.println("ROLE NOT EXISTS redirect To login:"+roleId);	
		   					response.sendRedirect(contextPath+"/jsp/Login.jsp");
		   					 
		   				}
		   				
		   			}else{
		   				// check Cookies 
		   				
		   				System.out.println("USER NOT EXISTS CHECKING COOKIES LOGIN :"+cookies.length+"----"+cookies[0].getName()+":"+cookies[0].getValue());	
				   		
		   				Boolean isUserExists = false;
		   				for(Cookie cook : cookies){
		   					
		   					if(cook.getName().equals(StringConstants._SESSION_USER_ID)){
		   						isUserExists=true;
		   						uid=cook.getValue();
		   						System.out.println(cook.getName()+":"+cook.getValue());
		   					}
		   				}
		   				
		   				if(isUserExists){
		   					
		   					//checking role
		   					RequestDispatcher rd = request.getRequestDispatcher(URLConstants._GET_USER_DETAILS_FOR_SESSION+"?userId="+uid);
		   					rd.include(request, response);
		   			
		   					
		   					chain.doFilter(request, response);
		   					
		   				}else{
		   					response.sendRedirect(contextPath+"/jsp/Login.jsp");
		   					
		   				}
		   				//LOGIN
		   			}
		   			
		   			
		   			
		   		}else{
		   			System.out.println("SESSION NOT AVAILABLE CHECKING COOKIES :"+cookies);	
	   				
		   			if(cookies != null && cookies.length>0){
		   				
		   				System.out.println("COOKIES EXISTS CHECKING ROLE :"+cookies);	
				   		 
		   				for (Cookie cookie : cookies) {
							if(cookie.getName().equals(StringConstants._SESSION_USER_ID)){
								uid =cookie.getValue();
								
							}
						}
		   				
		   				if(uid != null){
		   					
		   					RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/"+URLConstants._GET_USER_DETAILS_FOR_SESSION+"?userId="+uid);
		   					rd.include(request, response);
		   				}else{
		   					response .sendRedirect(request.getContextPath()+"/jsp/Login.jsp");
		   				   					
		   				}
		   				
		   				//REMEMBER ME
		   			
		   			}else{
		   				System.out.println("COOKIES NOT AVAILABLE LOGIN :"+cookies);	
				   		
		   				if(path.contains("Login.jsp")){
		   					
		   					chain.doFilter(request, response);
		   				}else{
		   				
		   				response.sendRedirect(request.getContextPath()+"/jsp/Login.jsp");
		   				
		   				}///LOGIN PAGE
		   			}
		   			
		   		}
		   		
		   	}			 
	
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
