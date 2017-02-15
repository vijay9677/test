package com.nacre.online_assesment.action;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.exception.ImageStreamToByteException;
import com.nacre.online_assesment.form_bean.EducationlDetilasBean;
import com.nacre.online_assesment.form_bean.PersonalDetailsBean;
import com.nacre.online_assesment.form_bean.PersonalDetailsBeanSunil;
import com.nacre.online_assesment.form_bean.TechnologyCoursesDetailsBean;
import com.nacre.online_assesment.util.DateUtil;
import com.nacre.online_assesment.util.ImageUtil;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;

/**
 * Servlet implementation class StudentRegistrationAction
 */
@MultipartConfig
@WebServlet("/StudentRegistrationAction")
public class StudentRegistrationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean formSubmitionStatus=false;
		
		//----get identity value from jsp page to identify the caller-----
	// identity variable is used for identify the jsp page 
		Integer identity=Integer.parseInt(request.getParameter("identity"));
		StudentRegistrationValidationDelegate studentRegistrationValidationDelegate=new StudentRegistrationValidationDelegate();
		HttpSession session=request.getSession();
		//-----------for personalInfo Registration page------------------- 
		if(identity==1){
		PersonalDetailsBeanSunil personalDetailsBean=new PersonalDetailsBeanSunil();
		//read parameter from personalDetailsRegistration.jsp page and assign to PersonalDetailsBean
		
		String email=request.getParameter("email").toLowerCase().trim();
		//we have check this email exit in data base or not
		boolean emailExitanceStatus=false;
		try {
			int value=studentRegistrationValidationDelegate.getUserId(email);
			if(value==1){
				emailExitanceStatus=true;
			response.sendRedirect("jsp/student/PersonalDetailsRegistration.jsp?emailStatus=email-Id was alraedy registered&msg=Enetr another email-Id");
			
				
			}
		
		} catch (DatabaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DataNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(emailExitanceStatus==false){
		personalDetailsBean.setEmail(email);
		personalDetailsBean.setFirstname(request.getParameter("fname").toUpperCase().trim());
		personalDetailsBean.setLastname(request.getParameter("lname").toUpperCase().trim());
		
		personalDetailsBean.setPassword(request.getParameter("pwd"));
		personalDetailsBean.setMobileNo(request.getParameter("mobileno").trim());
		//read dob and convert to date format of java
		String dob=request.getParameter("dob").trim();
		
		Date dobInSQL=DateUtil.stringToSqlDate(dob,"MM/dd/yyyy" );
		
		//create calander instance and get required params
		Calendar cal = Calendar.getInstance();
		cal.setTime(dobInSQL);
		int dobYear = cal.get(Calendar.YEAR);
		session.setAttribute("dobYear",dobYear);
		personalDetailsBean.setDob(dobInSQL);
		personalDetailsBean.setGender(Integer.parseInt(request.getParameter("gender")));
		//read image and convert to string format 
		Part p = request.getPart("image");
		InputStream is= p.getInputStream();
		String image=null;
		try {
			 image=ImageUtil.encodeImage(is);
		} catch (ImageStreamToByteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personalDetailsBean.setImage(image);
		personalDetailsBean.setCountry(Integer.parseInt(request.getParameter("country")));
		personalDetailsBean.setState(Integer.parseInt(request.getParameter("state")));
		personalDetailsBean.setCity(Integer.parseInt(request.getParameter("city")));
		personalDetailsBean.setLocation(request.getParameter("location").toUpperCase().trim());
		personalDetailsBean.setPin(Integer.parseInt(request.getParameter("pin").trim()));
		//add personalDetailsBean to session object
		session.setAttribute("personalDetailsBean",personalDetailsBean);
		System.out.println("PD>>>"+personalDetailsBean);
		//forword to next page i.e ssc&intermediate education details page(SSC&IntermediateRegistration.jsp)
		response.sendRedirect("jsp/student/SSC&IntermediateRegistration.jsp");
		}
		}
		//-----------------for ssc & intermediate Registration page-----------------------
		else if(identity==2){
			EducationlDetilasBean sccDetailsBean=new EducationlDetilasBean();
			sccDetailsBean.setYearOfPass(Integer.parseInt(request.getParameter("sPassing")));
			sccDetailsBean.setPercentage(request.getParameter("schoolPercentage"));
			sccDetailsBean.setEducationType(StringConstants._STUDENT_SSC_TYPE_ID);
			EducationlDetilasBean intermediateDetailsBean=new EducationlDetilasBean();
	Integer interPassing=Integer.parseInt(request.getParameter("interPassing"));
	intermediateDetailsBean.setYearOfPass(interPassing);
	intermediateDetailsBean.setPercentage(request.getParameter("interPercentage"));
	intermediateDetailsBean.setEducationType(StringConstants._STUDENT_INTERMEDIATE_TYPE_ID);
	//add intermediateDetailsBean  to session object
	session.setAttribute("sccDetailsBean",sccDetailsBean);
	session.setAttribute("intermediateDetailsBean",intermediateDetailsBean);
	
	System.out.println("SSC>>"+sccDetailsBean);
	
	System.out.println("IN>>"+intermediateDetailsBean);
	////forword to next page i.e graduation details page(GraduationDetailsRegistration.jsp)
	response.sendRedirect("jsp/student/GraduationDetailsRegistration.jsp");

		}
		//--------------------for graduation Registration page------------------------------------
		else if(identity==3){
			EducationlDetilasBean graduationDetailsBean=new EducationlDetilasBean();
			graduationDetailsBean.setStreamId(Integer.parseInt(request.getParameter("graduationStrem")));
			Integer graduationPassing=Integer.parseInt(request.getParameter("graduationPassing"));
			
			graduationDetailsBean.setYearOfPass(graduationPassing);
			graduationDetailsBean.setPercentage(request.getParameter("graduationPercentage"));
			Integer graduationUnivetsityId=Integer.parseInt(request.getParameter("graduationUniv"));
			//if graduationUnivetsityId==0 then we have to read both university and college from text field
			System.out.println(graduationUnivetsityId);
			if(graduationUnivetsityId==0){
			graduationDetailsBean.setAddUniversityName(request.getParameter("gaddUniv").toUpperCase().trim());	
			graduationDetailsBean.setAddCollegeName(request.getParameter("gaddCollege").toUpperCase().trim());
			}
			else if(graduationUnivetsityId!=0){
				Integer graduationCollegeId=Integer.parseInt(request.getParameter("graduationCollege"));
				 if(graduationUnivetsityId!=0 && graduationCollegeId==0){
						graduationDetailsBean.setUnivetsityId(graduationUnivetsityId);
						graduationDetailsBean.setAddCollegeName(request.getParameter("gaddCollege").toUpperCase().trim());	
					}
				 else if(graduationUnivetsityId!=0 && graduationCollegeId!=0){
						graduationDetailsBean.setUnivetsityId(graduationUnivetsityId);
						graduationDetailsBean.setCollegeId(graduationCollegeId);
					}
				}
			
			graduationDetailsBean.setCityId(Integer.parseInt(request.getParameter("gCity")));
			graduationDetailsBean.setLocation(request.getParameter("gLocation").toUpperCase().trim());
			graduationDetailsBean.setPin(Integer.parseInt(request.getParameter("gPin").trim()));
			graduationDetailsBean.setEducationType(StringConstants._STUDENT_GRADUATION_TYPE_ID);
			//add graduationDetailsBean to session object
			session.setAttribute("graduationDetailsBean",graduationDetailsBean);
			System.out.println(graduationDetailsBean);
			//get current year
			Calendar cal=Calendar.getInstance();
			int year=cal.get(Calendar.YEAR);
			if(graduationPassing<=year-2){
			//request.setAttribute("graduationPassing", graduationPassing);
		              //forword to next page i.e post graduation details page(PostGraduationDetailsRegistration.jsp)
			
			response.sendRedirect("jsp/student/PostGraduationRegistration.jsp");
			}
			else{
				//forword to next page i.e courses details page(CourseInfoRegistration.jsp)
				response.sendRedirect("jsp/student/CourseInfoRegistration.jsp");
				
			
			}
		}
		//for postGraduation Registration page
		else if(identity==4){
			EducationlDetilasBean postGraduationDetailsBean=new EducationlDetilasBean();
		postGraduationDetailsBean.setStreamId(Integer.parseInt(request.getParameter("pgStrem")));
		postGraduationDetailsBean.setYearOfPass(Integer.parseInt(request.getParameter("pgPassing")));
		postGraduationDetailsBean.setPercentage(request.getParameter("pgPercentage"));
		Integer pgUnivetsityId=Integer.parseInt(request.getParameter("pgUniv"));
		
		//if pgUnivetsityId==0 then we have to read both university and college from text field
		if(pgUnivetsityId==0){
		postGraduationDetailsBean.setAddUniversityName(request.getParameter("pgaddUniv").toUpperCase().trim());	
		postGraduationDetailsBean.setAddCollegeName(request.getParameter("pgaddCollege").toUpperCase().trim());
		}
		else if(pgUnivetsityId!=0){
			Integer pgCollegeId=Integer.parseInt(request.getParameter("pgCollege"));
		 if(pgUnivetsityId!=0 && pgCollegeId==0){
			postGraduationDetailsBean.setUnivetsityId(pgUnivetsityId);
			postGraduationDetailsBean.setAddCollegeName(request.getParameter("pgaddCollege").toUpperCase().trim());	
		}
		else if(pgUnivetsityId!=0 && pgCollegeId!=0){
			postGraduationDetailsBean.setUnivetsityId(pgUnivetsityId);
			postGraduationDetailsBean.setCollegeId(pgCollegeId);
		}
		}
		postGraduationDetailsBean.setCityId(Integer.parseInt(request.getParameter("pgCity")));
		postGraduationDetailsBean.setLocation(request.getParameter("pgLocation").toUpperCase().trim());
		postGraduationDetailsBean.setPin(Integer.parseInt(request.getParameter("pgPin").trim()));
		postGraduationDetailsBean.setEducationType(StringConstants._STUDENT_POSTGRADUATION_TYPE_ID);
		//add graduationDetailsBean to session object
		session.setAttribute("postGraduationDetailsBean",postGraduationDetailsBean);
		System.out.println(postGraduationDetailsBean);
		//forword to next page i.e courses details page(CourseInfoRegistration.jsp)
		response.sendRedirect("jsp/student/CourseInfoRegistration.jsp");
		}
		//for course Registration Page
		else if(identity==5){
				
		TechnologyCoursesDetailsBean  technologyCoursesDetailsBean=new TechnologyCoursesDetailsBean();
		technologyCoursesDetailsBean.setTechnologyId(Integer.parseInt(request.getParameter("technology")));
		String courses[]=request.getParameterValues("courses");
		List<Integer> coursesIdList=new ArrayList<Integer>();
		for(int i=0;i<courses.length;i++){
			Integer courseId=Integer.parseInt(courses[i]);
			coursesIdList.add(courseId);
		}
		technologyCoursesDetailsBean.setCoursesIdList(coursesIdList);
		session.setAttribute("technologyCoursesDetailsBean",technologyCoursesDetailsBean);
		System.out.println(technologyCoursesDetailsBean);
		formSubmitionStatus=true;
		}
	//retrive all objects from session and store in List
		if(formSubmitionStatus==true){
		Map studentRegistrationMap = new HashMap();
		PersonalDetailsBeanSunil personalDetailsBean=(PersonalDetailsBeanSunil )session.getAttribute("personalDetailsBean");
		studentRegistrationMap.put("personalDetailsBean",personalDetailsBean);
		EducationlDetilasBean sccDetailsBean=(EducationlDetilasBean) session.getAttribute("sccDetailsBean");
		studentRegistrationMap.put("sccDetailsBean",sccDetailsBean);
		EducationlDetilasBean intermediateDetailsBean=(EducationlDetilasBean)session.getAttribute("intermediateDetailsBean");
		studentRegistrationMap.put("intermediateDetailsBean",intermediateDetailsBean);
		EducationlDetilasBean graduationDetailsBean=(EducationlDetilasBean)session.getAttribute("graduationDetailsBean");
		studentRegistrationMap.put("graduationDetailsBean", graduationDetailsBean);
		EducationlDetilasBean postGraduationDetailsBean=(EducationlDetilasBean)session.getAttribute("postGraduationDetailsBean");
		if(postGraduationDetailsBean!=null){
			studentRegistrationMap.put("postGraduationDetailsBean", postGraduationDetailsBean);	
		}
		TechnologyCoursesDetailsBean  technologyCoursesDetailsBean=(TechnologyCoursesDetailsBean)session.getAttribute("technologyCoursesDetailsBean");
		studentRegistrationMap.put("technologyCoursesDetailsBean", technologyCoursesDetailsBean);
		//pass the studentRegistrationMap to delidate for storing in database
		
		try {
			
			System.out.println("PD>>"+studentRegistrationMap.get("personalDetailsBean"));

			System.out.println("grad>>"+studentRegistrationMap.get("graduationDetailsBean"));
			System.out.println("SSC>>"+studentRegistrationMap.get("sccDetailsBean"));
			System.out.println("IM>>"+studentRegistrationMap.get("intermediateDetailsBean"));
			System.out.println("PDB>>"+studentRegistrationMap.get("personalDetailsBean"));
			System.out.println("PGDB>>"+studentRegistrationMap.get("postGraduationDetailsBean"));
			int value=studentRegistrationValidationDelegate.studentRegistration(studentRegistrationMap);
	if(value==1){
		session.invalidate();
		System.out.println("registration success");
		response.sendRedirect(request.getContextPath()+"/"+URLConstants.LOGIN_PAGE_URL+"?regSucc=REGISTERED SUCCESSFULLY CONTACT ADMIN AND VERIFY YOUR ACCOUNT");
	}
	else if(value==0){
		session.invalidate();
		System.out.println("registration failed,  try again");
		response.sendRedirect(request.getContextPath()+"/"+URLConstants.LOGIN_PAGE_URL+"?regFail=REGISTERED FAILED TRY AGAIN");

	}
		
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/jsp/"+URLConstants.LOGIN_PAGE_URL+"?regFail=PLEASE TRY LATER");

		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request,response);
	}

}
