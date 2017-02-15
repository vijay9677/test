package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.StudentRegistrationValidationDelegate;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.URLConstants;

/**
 * Servlet implementation class UpdateStudentCourseSrk
 */
@WebServlet("/UpdateStudentCourseSrkAction.admin")
public class UpdateStudentCourseSrk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentCourseSrk() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/json");
	
		//storing multiple courses in List which are coming through ajax call from jsp
		
		List<CourseDTO> course =  new ArrayList<>();
		String [] st=request.getParameterValues("courses[]");
		for (String string : st) {
			CourseDTO dto = new CourseDTO();
			dto.setCourse(string);
			//System.out.println(string);
		course.add(dto);	
		}
		Integer  userId = Integer.parseInt(request.getParameter("userId"));	
		
		String mailId = request.getParameter("email");
		String password = request.getParameter("mobile_no");
		
		
		
		StudentRegistrationValidationDelegate studentCourse=new StudentRegistrationValidationDelegate();
		
		/*calling updateCourses method which is in StudentRegistrationValidationDeligate
			@parameters course accepts List<CourseDto> and userId accepts Integer
			@returns count which represents rows effected while inserting courses.
		*/
		Integer count;
		try {
			count = studentCourse.updateCourses(course,userId);
		
		System.out.println("count in servlet "+count);
	if(count==1){
	 Boolean studentStatus	= studentCourse.sendSuccessMailToStudent(mailId,password,userId);
	 System.out.println("In servlet >>>>>>>>. "+studentStatus);
	 response.getWriter().print(studentStatus);
		
	}
		} catch (DatabaseException e) {
			e.printStackTrace();
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
