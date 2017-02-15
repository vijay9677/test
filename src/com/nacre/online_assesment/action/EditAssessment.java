package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.AssesmentTypeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.DateUtil;

/**
 * Servlet implementation class EditAssessment
 */
@WebServlet("/EditAssessment")
public class EditAssessment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAssessment() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @author pavan pratap singh b-35
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	/**
	 * @author pavan pratap singh b-35
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		
		response.setContentType("text/html");
		System.out.println("hi pavan you are in EditAssement");
		
		
		
	//---------------------------------------------------------	
		
		Integer assesmentId=Integer.parseInt(request.getParameter("assesment_edit_Id"));
		 String assesment=request.getParameter("assesment_edit_Name");;
		 Integer totalMarks=Integer.parseInt(request.getParameter("total_edit_Mark"));
		 Integer durationInMin=Integer.parseInt(request.getParameter("duration_edit_in_Min"));
			
		// Date date=request.getParameter("dob");
		 String date=request.getParameter("dob_edit");
		 System.out.println(date);
		 Date assesmentDate;
		 if(date.contains("-")){
		  assesmentDate= DateUtil.stringToSqlDate(date,"yyyy-MM-dd");
		 }else if(date.contains("/")){
			  assesmentDate= DateUtil.stringToSqlDate(date,"MM/dd/yyyy");
			 	 
			 
		 }else{
			  assesmentDate= DateUtil.stringToSqlDate(date,"MMM dd, yyyy");
				
		 }
//		 String format=("mm:dd:yy"); 
//		 Date assesmentDate=DateUtil.stringToSqlDate(date, format);
		 
		 String description=request.getParameter("descrition_edit");
		 
		 //----set the assesmentid into the AssesmentTypeDTO
		 Integer assesmentTypeId=Integer.parseInt(request.getParameter("assessmentType_edit"));
		 AssesmentTypeDTO assesmentType= new AssesmentTypeDTO();
		 assesmentType.setAssesmentTypeId(assesmentTypeId);
		 
		// ----set the courseid into the CourseDTO
		 Integer courseId=Integer.parseInt(request.getParameter("course_edit"));
		  CourseDTO course=new CourseDTO();
		  course.setCourseId(courseId);
		  
        // ----set the levelId into the LevelDto
		  Integer levelId=Integer.parseInt(request.getParameter("level_edit"));
		  LevelDTO level=new LevelDTO();
		  level.setLevelId(levelId);
		  
		  
		//for no of student for a slot
		 Integer noOfStudentsForaSlot=Integer.parseInt(request.getParameter("no_of_Slot_edit"));
		 
		 // Time StartTime=request.getParameter("start_Time");
		 String start_time=request.getParameter("start_Time_edit");
		
		 // SimpleDateFormat format_start_Time= new SimpleDateFormat("HH:mm:ss"); // 12 hour format
            java.util.Date d1_start_Time=null;
			d1_start_Time = new Date(DateUtil.stringToSqlDate(start_time,"HH:mm:ss").getTime());
		    java.sql.Time ppstime_start_Time= new java.sql.Time(d1_start_Time.getTime());
		    System.out.println(ppstime_start_Time);
		    
		// Time EndTime=request.getParameter("end_Time");
		    String endTime=request.getParameter("end_Time_edit");
		    //SimpleDateFormat format_endTime= new SimpleDateFormat("HH:mm:ss"); // 12 hour format

		    java.util.Date d1_endTime=null;
				d1_endTime = new Date(DateUtil.stringToSqlDate(endTime,"HH:mm:ss").getTime());;

		    java.sql.Time ppstime_endTime = new java.sql.Time(d1_endTime.getTime());
		    System.out.println(ppstime_endTime);
		//create object of Assesmentdto and set values
		    AssesmentDTO ad=new AssesmentDTO();
		    ad.setAssesmentId(assesmentId);
			ad.setAssesment(assesment);
			ad.setTotalMarks(totalMarks);
			ad.setDurationInMin(durationInMin);
			ad.setDate(assesmentDate);
			ad.setDescription(description);
			ad.setAssesmentType(assesmentType);
			ad.setCourse(course);
			ad.setLevel(level);
			ad.setNoOfStudentsForaSlot(noOfStudentsForaSlot);
			ad.setStartTime(ppstime_start_Time);
			ad.setEndTime(ppstime_endTime);
		
		
		
		
		//-------------------------------------------------------------
	
		
	
		AssesmentsDelegate editAssessment=new AssesmentsDelegate();
	
	try {
		      editAssessment.editAssessment(ad);
	} catch (DatabaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
