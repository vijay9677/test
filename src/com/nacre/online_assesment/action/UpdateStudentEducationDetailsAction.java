package com.nacre.online_assesment.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.util.URLConstants;
import com.nacre.online_assesment.vo.StudentEducationDetailsToVerifyBean;

/**
 * @authors Srikanth and Krunal  This Action Is To update student education details
 *       
 */
@WebServlet("/UpdateStudentEducationDetailsAction.admin")
public class UpdateStudentEducationDetailsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentEducationDetailsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* var sscGrade; var sscYop; var hscGrade; var hscYop;
		var gradGrade; var gradYop; var gradStreamId; var gradCol; var gradUnivId; var gradLocation; var gradCityId;
		var pgGrade; var pgYop; var pgStreamId; var pgCol; var pgUnivId; var pgLocation; var pgCityId;
	     */
		response.setContentType("text/html");
		
		
		Integer pgeduTypeId2 = null;
		
		String pgEduTypeId = request.getParameter("pgEdu_Id");
		
		if(pgEduTypeId!=null){
			
			 pgeduTypeId2=Integer.parseInt(pgEduTypeId);
		}
		
			
		
		Boolean isNewPg = Boolean.parseBoolean(request.getParameter("isNewPg"));
		
		
		
		List<StudentEducationDetailsToVerifyBean> eduList = new ArrayList<>();
		
		
		StudentEducationDetailsToVerifyBean edu_beanHsc = new StudentEducationDetailsToVerifyBean();
		
		edu_beanHsc.setEdu_type(StringConstants.HSC_EDUCATION_TYPE);
		edu_beanHsc.setEdu_type_Id(Integer.parseInt(request.getParameter("hscEdu_Id")));
		edu_beanHsc.setPercent_grade(request.getParameter("hscGrade"));
		edu_beanHsc.setYear_of_pass(request.getParameter("hscYop"));	
		edu_beanHsc.setUserId(Integer.parseInt(request.getParameter("userId")));
		
		
		eduList.add(edu_beanHsc);//adding Hsc details to list
		
		
		StudentEducationDetailsToVerifyBean edu_beanSsc = new StudentEducationDetailsToVerifyBean();
		
		edu_beanSsc.setEdu_type(StringConstants.SSC_EDUCATION_TYPE);
		edu_beanSsc.setEdu_type_Id(Integer.parseInt(request.getParameter("sscEdu_Id")));
		edu_beanSsc.setPercent_grade(request.getParameter("sscGrade"));
		System.out.println(request.getParameter("sscYop"));
		edu_beanSsc.setYear_of_pass(request.getParameter("sscYop"));	
	
		edu_beanSsc.setUserId(Integer.parseInt(request.getParameter("userId")));
		
		eduList.add(edu_beanSsc);//adding ssc details to list
		
		
		
		
		StudentEducationDetailsToVerifyBean edu_beanGrad = new StudentEducationDetailsToVerifyBean();
		
		edu_beanGrad.setEdu_type(StringConstants.GRADUATION_EDUCATION_TYPE);
		edu_beanGrad.setEdu_type_Id(Integer.parseInt(request.getParameter("gradEdu_Id")));
		edu_beanGrad.setPercent_grade(request.getParameter("gradGrade"));
		edu_beanGrad.setStreamId(Integer.parseInt(request.getParameter("gradStreamId")));
		edu_beanGrad.setYear_of_pass(request.getParameter("gradYop"));	
		edu_beanGrad.setCollege(request.getParameter("gradCol"));
		edu_beanGrad.setUnivercityId(Integer.parseInt(request.getParameter("gradUnivId")));
		edu_beanGrad.setLocation(request.getParameter("gradLocation"));
		edu_beanGrad.setPincode(request.getParameter("gradPincode"));
		edu_beanGrad.setCityId(Integer.parseInt(request.getParameter("gradCityId")));
		edu_beanGrad.setUserId(Integer.parseInt(request.getParameter("userId")));
		
		eduList.add(edu_beanGrad);//adding graduation details to list
		
		
		if(pgeduTypeId2!=null){
		StudentEducationDetailsToVerifyBean edu_beanPg = new StudentEducationDetailsToVerifyBean();
		
		edu_beanPg.setEdu_type(StringConstants.PG_EDUCATION_TYPE);
		edu_beanPg.setEdu_type_Id(Integer.parseInt(request.getParameter("pgEdu_Id")));
		edu_beanPg.setPercent_grade(request.getParameter("pgGrade"));
		edu_beanPg.setStreamId(Integer.parseInt(request.getParameter("pgStreamId")));
		edu_beanPg.setYear_of_pass(request.getParameter("pgYop"));	
		edu_beanPg.setCollege(request.getParameter("pgCol"));
		edu_beanPg.setUnivercityId(Integer.parseInt(request.getParameter("pgUnivId")));
		edu_beanPg.setLocation(request.getParameter("pgLocation"));
		edu_beanPg.setPincode(request.getParameter("pgPincode"));
		edu_beanPg.setCityId(Integer.parseInt(request.getParameter("pgCityId")));
		edu_beanPg.setUserId(Integer.parseInt(request.getParameter("userId")));
		
		eduList.add(edu_beanPg);//adding post graduation details to list
		}
		
		StudentRegistrationValidationDelegate deligate = new StudentRegistrationValidationDelegate();
		
		/*sending student education details upto dao by callin updateStudentEduDetails 
		@params eduList type java.uil.List contains student education list and isNewPg type boolean*/
		
		try {
			deligate.updateStudentEduDetails(eduList,isNewPg);
		}  catch (DatabaseException e) {
			RequestDispatcher rd = request.getRequestDispatcher(URLConstants._ERROR_MSG_JSP_ADMIN);
			rd.include(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
