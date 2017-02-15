/**

 * 
 */
package com.nacre.online_assesment.util;

/**
 * @author Vijay Kumar Reddy K
 * @version 1.0.0 2016
 * @author Nacre Batch 35 Java
 */
public class URLConstants {
	
	public static final String _EDIT_PROFILE = "jsp/student/EditProfile.jsp";
	public static final String _CHANGE_PWD_URL = "jsp/ChangePassword.jsp";

	public static final String _REGISTER_STUDENT = "jsp/student/PersonalDetailsRegistration.jsp";

	public static final String _GET_USER_DETAILS_FOR_SESSION = "InformationRetreivalAction";
	/**
	 *TO Avoid creation of object from out side 
	 */
	private URLConstants() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @author Vijay Kumar Reddy K
	 * @LOGIN_PAGE_URL contains login page url
	 */
	public static final  String LOGIN_PAGE_URL ="jsp/Login.jsp";
	public static final  String ADMIN_HOME_PAGE_URL ="jsp/admin/SpecialAdminHomePage.jsp";

	public static final  String LOGOUT_URL="LogoutAction";

	public static final  String HRADMIN_HOME_PAGE_URL="jsp/hr/hr_home.jsp";
	
	public static final  String CORPORATEADMIN_HOME_PAGE_URL="jsp/corporate_relation/corporate_home.jsp";
	
	
	public static final  String SYSTEMADMIN_HOME_PAGE_URL="jsp/system_admin/systemAdminHome.jsp";
	
	public static final  String STUDENT_HOME_PAGE_URL="jsp/student/student_home.jsp";//"jsp/student/Student.jsp";
	
	
	public static final  String STUDENT_REQUESTS_URL="jsp/admin/userRequest.jsp";
	/**
	 * @author KRISHNA PRAKASH
	 * @TECHNICALADMIN_HOME_PAGE_URL contains TechnicalAdminHome  page url
	 */
	public static final  String TECHNICALADMIN_HOME_PAGE_URL="jsp/technical_team/TechnicalAdminHomePage.jsp";
	/**
	 * @author KRISHNA PRAKASH
	 * QUESTIONEDIT_URL contains QuestionEdit  page url
	 */
	public static final  String QUESTIONEDIT_URL="/jsp/technical_team/QuestionEdit.jsp";
	/**
	 * @author KRISHNA PRAKASH
	 * DELETE_ASS_PAPER_URL contains delete_ass_paper  page url
	 */
	public static final  String DELETE_ASS_PAPER_URL="/jsp/technical_team/delete_ass_paper.jsp";
	/**
	 * @author KRISHNA PRAKASH
	 * UPLOAD_ASSESSMENT_PAPER_URL contains upload_assessment_paper  page url
	 */
	public static final  String UPLOAD_ASSESSMENT_PAPER_URL="/jsp/technical_team/upload_assessment_paper.jsp";
	/**
	 * @author KRISHNA PRAKASH
	 * ASSESSMENT_PAPER_UPLOAD_ACTION_URL contains AssessmentPaperUploadAction  page url
	 */
	public static final  String ASSESSMENT_PAPER_UPLOAD_ACTION_URL="/AssessmentPaperUploadAction.technical";
	/**
	 * @author KRISHNA PRAKASH
	 * EDIT_QUESTION_PAPER_ACTION_URL contains EditedQuestionPaperAction  page url
	 */
	public static final  String EDIT_QUESTION_PAPER_ACTION_URL="/EditedQuestionPaperAction.technical";
	/**
	 * @author KRISHNA PRAKASH
	 * DELETE_ASSESSMENT_QUESTION_ACTION_URL contains DeletePaperAction  page url
	 */
	public static final  String DELETE_ASSESSMENT_QUESTION_ACTION_URL="/DeletePaperAction.technical";
	/**
	 * @author KRISHNA PRAKASH
	 * GET_ASSESSMENT_PAPER_ACTION_URL contains GetAssessmentPaper  page url
	 */
	public static final  String GET_ASSESSMENT_PAPER_ACTION_URL="/GetAssessmentPaper.technical";

	//@vijaykumar
	public static final String ADMIN_DIRECT_SEND_JOB_OPPERTUNITY="jsp/admin/shareJobOpportunities.jsp";
	

	
	
	/**
	 * @author Swapnil
	 * @GET_COURSES TO OBTAIN ALL COURSES
	 */
	public static final  String GET_COURSES ="jsp/system_admin/Course.jsp";
	/**
	 * @author Swapnil
	 * @GET_TECHNOLOGIES TO OBTAIN ALL TECHNOLOGIES
	 */
    public static final String GET_TECHNOLOGIES="jsp/system_admin/technology.jsp";
    /**
     * @author Swapnil
     * @ADD_COURSE TO OBTAIN ADDED COURSES
     */
    public static final String ADD_COURSE="jsp/system_admin/Course.jsp";
    /**
     * @author Swapnil
     * @ADD_TECHNOLOGY TO OBTAIN ADDED TECHNOLOGY
     */	
     public static final String ADD_TECHNOLOGY="jsp/system_admin/technology.jsp"; 
     /**
 	 * @author Swapnil
 	 * @GET_COURSES TO OBTAIN ALL COURSES
 	 */
 	public static final  String DELETE_COURSE="jsp/system_admin/Course.jsp";
 	/**
     * @author Swapnil
     * @ADD_TECHNOLOGY TO OBTAIN ADDED TECHNOLOGY
     */
     public static final String DELETE_TECHNOLOGY="jsp/system_admin/technology.jsp"; 
     
     
     /**
      * @author Kiran And Pavan
      * This is for Add Assesment Details By System Admin
      */

     public static final String ADD_ASSESMENT_DETAILS="jsp/assesment/AddAssesment.jsp";
     
     
     /**
      * Student URL COnstants
      */
     /**
      * @author Rohit Kumar
      * This is For Book A Slot
      */
     public static final String BOOK_A_SLOT="jsp/student/slotbook.jsp";
     
     /**
      * @author Amarender
      * This is for give Feedback by Student
      */
     public static final String GIVE_FEEDBACK="jsp/student/SendFeedback.jsp";
     
     /**
      * @author Ashish
      * This is for Take Assesment for Student
      */
     public static final String TAKE_ASSESMENT="jsp/assesment/TakeAssesment.jsp";
     
     /**
      * @author Chithranshu
      * This is for Get Score of the Student Take Assesment
      */
     public static final String GET_SCORE="jsp/assesment/getScores.jsp";
     
     /**
      * @author sagar
      */
     public static final String VIEW_JOBOPPRTUNITIES_POSTS="jsp/student/viewJobPost.jsp";
     
     
     /**
      * @author krishna Prakash
      * This is for Uploading and Add Assesment Paper By Technical Team
      */
     public static final String ADD_ASSESMENT_PAPER="jsp/technical_team/upload_assessment_paper.jsp";
     
     /**
      * @author krishna Prakash	
      * This is for Edit Assesment Paper By Technical Team
      */
     public static final String EDIT_ASSESMENT_PAPER="jsp/technical_team/QuestionEdit.jsp";
     
     /**
      * @author Mounika
      * Notification Regarding to Assesment Details to Tech Team
      */
     public static final String NOTIFICATION_ASSESMENTDETAILS_TECHTEAM="jsp/technical_team/assesmentNotiTechTeam.jsp";
          
     /**
      * @author Saurabh And Sonali 
      * this is for View Client Details By Corporate Team 
      */
     public static final String CLIENT_DETAILS="jsp/corporate_relation/ClientManagement.jsp";
     
     /**
      * @author Saurabh And Sonali 
      * this is for Add Client Details By Corporate Team 
      */
     public static final String ADD_CLIENT_DETAILS="jsp/corporate_relation/ClientManagement.jsp";
     
     /**
      * @author Srinivas
      * This is for View Client Details And Add job posting 
      */
     public static final String JOB_POSTING="jsp/corporate_relation/Display_client_details_for_add_job_posting.jsp";
     
     /**
      * @author Srinivas
      * This is for Edit job posting Details
      */
     public static final String EDIT_JOB_POSTING="jsp/corporate_relation/Edit_job_posting.jsp";
     
     /**
      * Admin
      * @author Srikanth And Krunal
      * This for Serach and Verification For Student Details
      */
     public static final String ADMIN="jsp/admin/SearchStudent.jsp";
     
     /**
      * @author Srikanth And Krunal
      * This is for Verification Of Student
      */
     public static final String VERIFY_STUDENT="jsp/admin/VerifyStudent.jsp";
     
     /**
      * @author Sagar
      * This is for View Job Posting By Student
      */
     public static final String VIEW_JOBPOSTING_STUDENT="jsp/student/viewJobPost.jsp";
     
     /**
      * HR Department
      * @author
      */
     public static final String HR_DEPARTMENT="";
     
     /**
      * @author Rajanish
      * This is for Notification Regarding to Jobp Posting To HR
      */
     public static final String NOTIFICATION_JOBPOSTING_HR="jsp/corporate_relation/JobNotificaton.jsp";
     
     /**
      * @author Manish Kumar
      * This is for Notification Regarding to Assesment details to students
      */
     public static final String NOTIFICATION_ASSESMENTDETAILS_STUDENTS="jsp/student/CheckNotification.jsp";
     
     /**
      * @author Vijay
      * This is for Share job opprtunities For Student By HR
      */
     public static final String VIEW_JOBOPPRTUNITIES="jsp/admin/shareJobOpportunities.jsp";
     
     /**
      * @author Sharan Alloli
      * This is for Round Information By HR Department and System Admin
      */
     public static final String ROUND_INFO="jsp/hr/rounddetails.jsp";
     /**
      * @author Nagendra Babu
      * This is for Placement Information By HR Department and System Admin
      */
     public static final String PLACEMENT_INFO="jsp/hr/showplacements.jsp";
     /**
      * System Admin
      * @author Arvind Kumar
      * This is for Adding New Admin
      */
     public static final String ADD_EDIT_DELETE_ADMIN="jsp/system_admin/SystemAdmin.jsp";
     
     /**
      * @author Swapnil
      * This is for Adding New Courses
      */
     public static final String ADD_EDIT_DELETE_COURSES="jsp/system_admin/addCourse.jsp";
     
     /**
      * @author Swapnil
      * This is for Adding New Technologies
      */
     public static final String ADD_EDIT_DELETE_TECHNOLOGIES="jsp/system_admin/addTechnology.jsp";
     
     

     
     /**
      * @author Ahmed
      * This is for view feedback by system admin
      */
     public static final String VIEW_FEEDBACK="jsp/system_admin/ViewFeedback.jsp";
     
     /**
      * @author jaySingh
      * This is for view job Opprtunity Requestes By System Admin
      */
     public static final String VIEW_OPPRTUNITY_REQUESTS="jsp/admin/userRequest.jsp";
    
     /**
      * @author sagar
      * This is for view job Opprtunity Requestes By System Admin
      */
     public static final String VIEW_JOB_POST_ACTION="ViewJobPostAction.student";
     /**
      * @author sagar
      * This is for view job Opprtunity Requestes By System Admin
      */
     public static final String GET_JOB_POST_COMPANY_NAME_ACTION="GetJobPostCompanyNameAction.student";
     /**
      * @author sagar
      * This is for view job Opprtunity Requestes By System Admin
      */
     public static final String GET_JOB_POST_CITY_ACTION= "GetJobPostCityAction.student";
     
     /**
      * @author sagar
      * This is for view job Opprtunity Requestes By System Admin
      */
     public static final String FIND_JOB_ACTION= "FindJobAction.student";
     /**
      * @author sagar
      * This is for view job Opprtunity Requestes By System Admin
      */
     public static final String GET_JOB_POST_TECHNOOGY_ACTION= "GetJobPostTechnologyAction.student";
     /**
      * @author sagar
      * This is for view job Opprtunity Requestes By System Admin
      */
     public static final String JOB_POST_DESCRIPTION= "JobPostDescription.student";
     /**
      * @author sagar
      * This is for view job Opprtunity Requestes By System Admin
      */
     public static final String APPLY_FOR_OPPORTUNITY_POSTING_ACTION= "ApplyForOpportunityPostingAction.student";     
     /**
      * @author sagar
      * This is for view job Opprtunity Requestes By System Admin
      */
 	public static final String REQUEST_FOR_JOB = "RequestForJob.student";
    /**
     * @author sagar
     * This is for view job Opprtunity Requestes By System Admin
     */
	public static final String APPLY_FOR_JOB = "ApplyForJob.student";

	
	 /**
     * @author Ahmad
     * This is  By System Admin
     */
	public static final String GET_ALL_FEEDBACKS = "GetAllFeebacksAction.systemAdmin";
	
	 /**
     * @author srikanth and krunal
     * This is to get unaproved student details
     */
	public static final String _GET_UNAPROVED_STUDENTDETAILS_ACTION ="GetUnaprovedStudentDetailsAction.admin";
	
	
	
	 /**
     * @author srikanth and krunal
     * This is for get student all details to verify
     */
	public static final String _GET_STUDENT_DETAILS_TO_VERIFY_ADMIN ="GetStudentDetailsToVerify.admin";
	
	
	
	 /**
     * @author srikanth and krunal
     * This is To get countries
     */
	public static final String _GET_COUNTRY_JAVA_ACTION_ADMIN ="GetCountryJavaAction.admin";
	
	
	
	/**
     * @author srikanth and krunal
     * This is To Update student personal details
     */
	public static final String _UPDATE_STUDENT_PERSONAL_DETAILS_ACTION_ADMIN ="UpdateStudentPersonalDetailsAction.admin";
	
	
	/**
	 * admin
     * @author srikanth and krunal
     * This is To GET all education streams
     */
	public static final String _GET_EDUCATION_STREAMS_ACTION_ADMIN ="GetEduStreamAction.admin";
	
	
	/**
	 * admin
     * @author srikanth and krunal
     * This is To GET all univercities
     */
	public static final String _GET_UNIVERCITIES_ACTION_ADMIN ="GetUnivercitysAction.admin";
	



	/**
     * @author Mounika
     * This is To get Assessment details
     */
	public static final String _GET_ASSESSMENT_DETAILS_TO_TECH_TEAM="GetAssessmentDetailsToTechTeam.techTeam";

	/**
     * @author Mounika
     * This is To get Assessment notifications
     */
	public static final String _GET_ASSESSMENT_DETAILS_NOTI="assets/js/MounikaAssmentNotiTechTeam.js";


	/**
     * @author PRAVEEN GUGGILLA
     * This url is used for editing profile of student
     */
    public static final String EDIT_PROFILE="jsp/student/EditProfile.jsp";
   
    
    /**
      * @author PRAVEEN GUGGILLA
      * This url is used for updating Student personal details like address and name
      */
     public static final String UPDATE_STUDENT_DETAILS_ACTION="UpdateStudentDetailsAction.student";
    
   
     /**
      * @author PRAVEEN GUGGILLA
      * This url is used for updating Student courses
      */
     public static final String UPDATE_STUDENT_COURSES_ACTION="UpdateStudentCoursesAction.student";
    
  
     /**
      * @author PRAVEEN GUGGILLA
      * This url is used for updating post graduation details
      */
     public static final String UPDATE_STUDENT_POST_GRADUATION_DETAILS_ACTION="UpdateStudentPostgraduationDetailsAction.student";
    
     
     /** 
      * @author PRAVEEN GUGGILLA
      * This url is used for retrieving student courses on the basis of user_id
      */
     public static final String GET_COURSES_ACTION="GetCoursesAction.student";
   
     /**  
      * @author PRAVEEN GUGGILLA
      * This url is used for retrieving streams list
      */
     public static final String GET_STREAM_ACTION="GetStreamAction.student";
   
     
     /**
      * @author PRAVEEN GUGGILLA
      * This url is used for retrieving all the universities
      */
     public static final String GET_UNIVERSITIES_ACTION="GetUniversitiesAction.student";
    
     
     /**
      * @author PRAVEEN GUGGILLA
      * This url is used for retrieving student personal details, educational details and student courses
      */
     public static final String PERSONAL_DETAILS_ACTION="PersonalDetailsAction.student";
     
     /**
      * @author PRAVEEN GUGGILLA
      * This url is used for retrieving Countries list
      */
     public static final String GET_COUNTRY_DETAILS_ACTION="GetCountryDetailsAction.student";
    
    
     /**
      * @author PRAVEEN GUGGILLA
      * This url is used for retrieving States list
      */
     public static final String GET_STATE_ACTION="GetStateAction";
    
     
     /**
      * @author PRAVEEN GUGGILLA
      * This url is used for retrieving Cities list
      */
     public static final String GET_CITY_ACTION="GetCityAction";
    
     

	/**
	 * admin
     * @author srikanth and krunal
     * This is for update student education details
     */
	public static final String _UPDATE_STUDENT_EDUCATION_DETAILS_ACTION_ADMIN ="UpdateStudentEducationDetailsAction.admin";
	
	
	/**
	 * admin
     * @author srikanth and krunal
     * This is for get courses of particular technology
     */
	public static final String _GET_COURSES_OF_TECHNOLOGY_ACTION_ADMIN ="GetCoursesOfTechnologyAction.admin";
	
	
	/**
	 * admin
     * @author srikanth and krunal
     * This is for update student course information and change status
     */
	public static final String _UPDATE_STUDENT_COURSES_ACTION_ADMIN ="UpdateStudentCourseSrkAction.admin";
	
	
	/**
	 * admin
     * @author srikanth and krunal
     * This is To show verification success message
     */
	public static final String _VERIFICATION_SUCCESS_MSG_JSP_ADMIN ="jsp/admin/VerificationSuccess.jsp";
	
	
	
	/**
	 * admin
     * @author srikanth and krunal
     * This is To show Error  message
     */
	public static final String _ERROR_MSG_JSP_ADMIN ="jsp/admin/ErrorPage.jsp";
	
	

	/**
     * @author Ahmad
     * This is  By System Admin
     */
	public static final String GET_FEEDBACK = "GetFeedBack.ajax";

	/**
     * @author Ahmad
     * This is  By System Admin
     */
	public static final String GET_COMPANY = "GetCompany.ajax";
	
	
	/**
     * @author Ahmad
     * This is  By System Admin
     */
	public static final String GET_COMPANY_ADDRESS = "GetCompanyAddress.ajax";
	
	

	/**
     * @author Ahmad
     * This is  By System Admin
     */
	public static final String GET_ORGANIZATON_FEEDBACKS = "GetOrganisationFeedbacksAction.systemAdmin";
	
	

	/**
     * @author Ahmad
     * This is  By System Admin
     */
	public static final String GET_COMPANIES_FEEDBACKS = "GetCompaniesFeedbacksAction.systemAdmin";
	/**
     * @author Ahmad
     * This is  By Student
     */
	public static final String GET_COMPANIES_LOCATIONS = "GetCompanyLocality.student";
	

/**
     * @author Mounika
     * This is To get technical team notifications regarding Assessment
     */
	public static final String _GET_TECH_TEAM_NOTIFICATIONS="jsp/technical_team/techTeamNotifications.jsp";

}	