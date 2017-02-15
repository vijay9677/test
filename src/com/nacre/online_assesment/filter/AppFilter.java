/**
 * 
 */
package com.nacre.online_assesment.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

/**
 * @author Vijay Kumar Reddy K
 *
 */

//@WebFilter("/*")
public class AppFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		 HttpServletRequest request=(HttpServletRequest)req;
		 HttpSession session=request.getSession(false);
		 HttpServletResponse response=(HttpServletResponse)res;
		  Cookie[] cookies=request.getCookies();
		  String contextPath = request.getServletContext().getContextPath();
		  String path = request.getServletPath();
		  
		
		  
		  String cookieUserId = null;
		  String cookieRoleId = null;


			
		  
		  if(
			path.contains("assets") ||
			path.contains("css")||
			path.contains("images")||
			path.contains("js")||
			path.contains("jsp/common")||
			path.contains("InformationRetreivalAction")||
			path.contains("LogoutAction")||
			path.contains(".ajax")||
			path.contains("/ForgetAction")||
			path.contains("/ForgotPassword.jsp")||
		 path.contains("LoginAction")||
		 path.contains("PersonalDetailsRegistration.jsp")
    		||path.contains("SSC&IntermediateRegistration.jsp")
    		||path.contains("PostGraduationRegistration.jsp")
    		||path.contains("GraduationDetailsRegistration.jsp")
    		||path.contains("CourseInfoRegistration.jsp")
    		||path.contains("StudentRegistrationAction")
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
    		||path.contains("/EditAssessment")
    		||path.contains("/AddAssessment")
    				||path.contains("/EditAssessment")
    		||path.contains("/GetLevelAction")
    		||path.contains("/GetAssessmentType")
    		||path.contains("/GetCourses")
    		||path.contains("/AssesmentDetailsForEditAction")
    		||path.contains("/ViewAssessmentdetailsForEdit")
    		||path.contains("UpdateStudentCoursesAction.student")
    		||path.contains("UpdateStudentDetailsAction.student")
    		||path.contains("GetCoursesAction.student")
    		||path.contains("GetStreamAction.student")
    		||path.contains("GetUniversitiesAction.student")
    		||path.contains("GetCountryDetailsAction.student")
    		||path.contains("/GetAssesmentTypeAction")
    		||path.contains("/AddTechnologyAction")
    		||path.contains("/JobPostingNotificatonActionRajnish")
    		||path.contains("/GetTechnologyAction")
||path.contains("/GetCourseAction")

||path.contains("/AddCourseAction")

	||	path.contains("/EditCourseAction")

		||		path.contains("/GetTechnologyAction")
			||			path.contains("/GetNotAssignCourseAction")

				||				path.contains("/Technology_Course_AddAction")
    				||path.contains("EditTechnologyAction")

    		||path.contains("/GetAssesmentNameAction")

    		||path.contains("EditedQuestionPaperAction.technical")
    		||path.contains("DeletePaperAction.technical")
    
    		||path.contains("/GetNoOfAttempts")

    		||path.contains("/GetBookedDetailsAction")

    		||path.contains("/ValidationForBookedSlotsAction")

    				||path.contains("/GetTimeSlots")
||path.contains("/Availability")
    						||path.contains("/BookSelectedSlot")

    								||path.contains("/GetBookedDetailsAction")
    		||path.contains("/StudentNotificationAction")
||path.contains("/SendFeedbackAction")
||path.contains("/GetFeedBack.ajax")
		||path.contains("/GetCompany.ajax")
				||path.contains("/GetCompanyLocality.student")
						||path.contains("/GetCompanyAddress.ajax")
								||path.contains("/GetAllFeebacksAction.systemAdmin")
										||path.contains("/GetOrganisationFeedbacksAction.systemAdmin")
												||path.contains("/GetCompaniesFeedbacksAction.systemAdmin")
														||path.contains("/GetAllFeebacksAction.systemAdmin")
														||path.contains("/getJobDetailsToShowNotification")
														||path.contains("/addJobPostingAction")
														||path.contains("/CheckDuplicateClientAction")
																||path.contains("/GetCompanyLevelAction")
																		||path.contains("/GetCountryAction")
																				||path.contains("/GetStateAction")
																						||path.contains("/GetCityAction")
																								||path.contains("/ViewClientsDetailsAction")
																										||path.contains("/ViewClientAction")
||path.contains("/RequestRejectByAdmin")
||path.contains("/RequestApprovedByAdmin")
    				){

				System.out.println("no check");
				chain.doFilter(request, response);
			}else{
		  
		for (int index = 0; index < cookies.length; index++) {
			if(cookies[index].getName().equals(StringConstants._SESSION_USER_ID)){
				cookieUserId=cookies[index].getValue();
			}else if(cookies[index].getName().equals(StringConstants._SESSION_USER_ROLE_ID)){
			cookieRoleId=cookies[index].getValue();	
			}
		}
		
		/**
		 * validate session
		 */
		if(session!= null){
			//session.setMaxInactiveInterval(10*60*60);
			
			System.out.println("session exists");
			Integer  userId =  (Integer)session.getAttribute(StringConstants._SESSION_USER_ID);
			Integer  roleId =  (Integer)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID);
	
			System.out.println("USER ID :"+userId);

			System.out.println("ROLE ID :"+roleId);
			if(userId!=null && roleId!=null){
				/**
				 * Validate Role 
				 */
				
				System.out.println("session exists role");
				  if(path.contains("/jsp/Login.jsp")|| path.contains("/LoginAction") ){
						System.out.println("checking status active login actionsrv");    
						if(roleId == StringConstants._ADMIN_ROLE_ID ){
							 System.out.println("For Admin");
		      			response.sendRedirect(request.getContextPath() + "/" + URLConstants.ADMIN_HOME_PAGE_URL);
					} else if (roleId == StringConstants._HR_ROLE_ID) {
						response.sendRedirect(request.getContextPath() + "/" + URLConstants.HRADMIN_HOME_PAGE_URL);
					} else if (roleId == StringConstants._CORPORATE_ROLE_ID) {

						response.sendRedirect(request.getContextPath() + "/" + URLConstants.CORPORATEADMIN_HOME_PAGE_URL);

					} else if (roleId == StringConstants._SYSTEM_ROLE_ID) {

						response.sendRedirect(request.getContextPath() + "/" + URLConstants.SYSTEMADMIN_HOME_PAGE_URL);

					} else if (roleId == StringConstants._TECHINICAL_ROLE_ID) {

						response.sendRedirect(request.getContextPath() + "/" + URLConstants.TECHNICALADMIN_HOME_PAGE_URL);

					} else if (roleId == StringConstants._STUDENT_ROLE_ID) {

						response.sendRedirect(request.getContextPath() + "/" + URLConstants.STUDENT_HOME_PAGE_URL);

					} else {
						System.err.println("login");
					chain.doFilter(request, response);
					}
				  }else{
					  
					  //>>>>
					  
					  //---
					  	System.out.println("Path : "+path);
						Boolean valid = validateRole(userId, roleId, path);  
						System.out.println("!filter"+valid);
				  if(valid!=null && valid == true){
					  chain.doFilter(request, response);
					  
				  }else if(valid!=null && valid!=true){
					  response.sendRedirect(contextPath+"/"+URLConstants._GET_USER_DETAILS_FOR_SESSION+"?userId="+userId);	
								  
				  }else{
						response.sendRedirect(contextPath+"/"+URLConstants.LOGIN_PAGE_URL);	
						
				  }
				  
				  }

				
			}else{
				/**
				 * validate Cookie
				 */
				
				  if(path.contains("/jsp/Login.jsp")|| path.contains("/LoginAction") ){
						System.out.println("checking status active login actionsrv");    
						
					
				
				if(cookieUserId!=null){
			response.sendRedirect(contextPath+"/"+URLConstants._GET_USER_DETAILS_FOR_SESSION+"?userId="+cookieUserId);	
				}else{
					chain.doFilter(request, response);
				}
				
				
			}else{
				
				if(cookieUserId!=null){
					response.sendRedirect(contextPath+"/"+URLConstants._GET_USER_DETAILS_FOR_SESSION+"?userId="+cookieUserId);	
						}else{

							response.sendRedirect(contextPath+"/"+URLConstants.LOGIN_PAGE_URL);	
							
						}
				
			}
				  }
			
		}else{
			/**
			 * validating cookies
			 */
			if(cookieUserId!=null){
				response.sendRedirect(contextPath+"/"+URLConstants._GET_USER_DETAILS_FOR_SESSION+"?userId="+cookieUserId);	
					}else{
						response.sendRedirect(contextPath+"/"+URLConstants.LOGIN_PAGE_URL);	
						
					}
		}
			}//path
		
		
		
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	public Boolean validateRole(Integer userId, Integer roleId , String path ){
		Boolean b = null;
		//	return
		if(StringConstants.STUD_ROLE_ID==roleId){
			 b  = checkStudentTeamUrl(path);
			
		}else if (StringConstants._ADMIN_ROLE_ID == roleId){
			 b  = checkAdminTeamUrl(path);
			
		}else if (StringConstants._CORPORATE_ROLE_ID == roleId){
			 b  = checkCorpTeamUrl(path);
			
		}else if(StringConstants._SYSTEM_ROLE_ID == roleId){
			 b  = checkSystemTeamUrl(path);
			
		}else if(StringConstants._HR_ROLE_ID == roleId){
			 b  = checkHrTeamUrl(path);
			
		}else if(StringConstants._TECHINICAL_ROLE_ID == roleId){
			
			 b  = checkTeckTeamUrl(path);
			
		}
		
		return b;
		
		}

	private Boolean checkHrTeamUrl(String path) {
		// TODO Auto-generated method stub
		if(path.contains("jsp/hr")||
				path.contains(".hr")||
				path.contains("/JobPostingNotificatonActionRajnish")||
				path.contains("/JobPostingNotificationDetailAction")||
				path.contains("/JobPostingNotificationAction")||
				path.contains("/getDateAndRoundDescriptionInAjaxCallAction")||
				path.contains("/retriveAction")||
				path.contains("/selectingYearOrPercetageAction")||
				path.contains("/adminSendingnNotificationToSelectedStudents")||
				path.contains("/admin/shareJobOpportunities.jsp")||
				path.contains("/JobTypeSelectAction")||
				path.contains("/JobSelectAction")||
				path.contains("/RoundSelectAction")||
				path.contains("/FirstRoundDetailAction")||
				path.contains("/AssignRoundNoAction")||
				path.contains("/NextRoundPopupAction")||
				path.contains("/PlacementAction")||
				path.contains("/JobSelectAction")||
				path.contains("/ShowPlacementAction")
					
				){
			return true;
		}else{
			return false;
		}	
	
	}

	private Boolean checkSystemTeamUrl(String path) {
		// TODO Auto-generated method stub
		if(path.contains("jsp/system_admin")||
				path.contains(".sa")||
				path.contains(".systemAdmin")||
				path.contains("/JobPostingNotificationAction")||
				path.contains("/getJobDetailsToShowNotificationstudentAction")||
				path.contains("/getJobDetailsToShowNotification")||
				path.contains("/GetRoleByAdminAction")||
				path.contains("/GetAllAdminDataAction")||
				path.contains("/GetParticularDataAdminAction")||
				path.contains("/ViewPerticularAdminAction")||
				path.contains("/EditAdminAction")||
				path.contains("/DeleteAdminAction")||
				path.contains("/AddAdminAction")||
				path.contains("/GetTechnologyAction")||
				path.contains("/GetCourseAction")||
				path.contains("/EditCourseAction")||
				path.contains("/GetLevelAction")||
				path.contains("/AddCourseAction")||
				path.contains("/GetNotAssignCourseAction")||
				path.contains("/Technology_Course_AddAction")||
				path.contains("/AddTechnologyAction")||
				path.contains("/GetAssessmentType")||
				path.contains("/AssesmentDetailsForEditAction")||
				path.contains("/GetCourses")||
				path.contains("AddAssessment")||
				path.contains("/shareJobOpportunities")||
				path.contains("/GetAssessmentType")||
				path.contains("/EditTechnologyAction")||
				path.contains("/ViewAssessmentdetailsForEdit")
				
				){
			return true;
		}else{
			return false;
		}	
		
	}

	private Boolean checkCorpTeamUrl(String path) {
		// TODO Auto-generated method stub
		if(path.contains("jsp/corporate_relation")||
				path.contains(".cr")||
				path.contains("/ViewClientsDetailsAction")||
				path.contains("/GetCompanyLevelAction")||
				path.contains("/GetCountryAction")||
				path.contains("/ViewClientsDetailsAction")||
				path.contains("/ViewClientAction")||
				path.contains("/CheckDuplicateClientAction")||
				path.contains("/GetCountryAction")||
				path.contains("/GetCityAction")||
				path.contains("/GetStateAction")||
				path.contains("/ViewClientContactAddress")||
				path.contains("/EditClientContactDetailsAction")||
				path.contains("/GetStateAction")||
				path.contains("/AddMoreClientAddressAction")||
				path.contains("/ViewClientAction")||
				path.contains("/JobPostingClientAddress")||
				path.contains("/JobPostingClientAddress")||
				path.contains("/GettingLocationCurespondingAddres")||
				path.contains("/addJobPostingAction")||
				path.contains("/EditJobPostingForAjaxAction")||
				path.contains("/GetLocationNamesOfClientAjaxAction")||
				path.contains("/EditJobpostingTechnologyAjaxAction")||
				path.contains("/EditJobPostingAction")
					
				){
			return true;
		}else{
			return false;
		}
	}

	private Boolean checkAdminTeamUrl(String path) {
		// TODO Auto-generated method stub
		if(path.contains("jsp/admin")||
				path.contains(".admin")||
				path.contains("/getJobDetailsToShowNotification")||
				path.contains("/VerifyStudent.jsp")||
				path.contains("/GetStudentDetailsToVerify")
					
				){
			return true;
		}else{
			return false;
		}
}

	private Boolean checkStudentTeamUrl(String path) {
		// TODO Auto-generated method stub
		if(path.contains("jsp/student")||
				path.contains(".student")
					||path.contains("/getJobDetailsToShowNotification")
					||path.contains("/StudentNotificationAction")
					||path.contains("/GetAssesmentTypeAction")
					||path.contains("/GetAssesmentNameAction")
					||path.contains("/GetNoOfAttempts")
					||path.contains("/GetBookedDetailsAction")
					||path.contains("/ValidationForBookedSlotsAction")
					||path.contains("/GetTimeSlots")
					||path.contains("/SendFeedbackAction")
					||path.contains("/assesment")
					||path.contains("/SelectAssessmentTypes")
					||path.contains("/GetScoreAction")
					||path.contains("/GetAllAssessments")||
					path.contains("/GetAssessmentDetailschange")||
					path.contains("/GetExamStatus")||
					path.contains("/GetAssessmentDetailschange")||
					path.contains("/GetQuestions")||
					path.contains("/CalculatingScore")||
					path.contains("/assesment/")
				){
			return true;
		}else{
			return false;
		}	
	}

	private Boolean checkTeckTeamUrl(String path) {
		// TODO Auto-generated method stub
		if(path.contains("jsp/technical_team")||
				path.contains(".technical")||
				path.contains(".techTeam")||
				path.contains("/GetAssessmentDetailsToTechTeam.techTeam")||
				path.contains("/DeletePaperAction.technical")
					
				){
			return true;
		}else{
			return false;
		}	
		
	}

}
