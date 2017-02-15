package com.nacre.online_assesment.action;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.AssesmentTypeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.DateUtil;

/**
 * Servlet implementation class AddAssessment
 */
@WebServlet("/AddAssessment")
public class AddAssessment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAssessment() {
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
		System.out.println("hi pavan you are in AddAssement Action");
		
		
		
	//---------------------------------------------------------	
		
		// Integer assesmentId=Integer.parseInt(request.getParameter("assesment_Id"));
		// System.out.println(assesmentId);
		 System.out.println("hi Assessment");
		 String assesment=request.getParameter("assesment_Name");;
		 Integer totalMarks=Integer.parseInt(request.getParameter("total_Marks"));
		 Integer durationInMin=Integer.parseInt(request.getParameter("Duration_in_Min"));
			
		// Date date=request.getParameter("dob");
		 String date=request.getParameter("dob");
		 System.out.println(date);
		 
		 Date assesmentDate=null;
		 if(date.contains("/")){

				assesmentDate = DateUtil.stringToSqlDate(date,"MM/dd/yyyy");
		 }else{
		assesmentDate = DateUtil.stringToSqlDate(date,"yyyy-MM-dd");	 
		 }
		 
//		 String format=("mm:dd:yy"); 
//		 Date assesmentDate=DateUtil.stringToSqlDate(date, format);
		 
		 String description=request.getParameter("descrition");
		 
		 //----set the assesmentid into the AssesmentTypeDTO
		 Integer assesmentTypeId=Integer.parseInt(request.getParameter("assessmentType"));
		 AssesmentTypeDTO assesmentType= new AssesmentTypeDTO();
		 assesmentType.setAssesmentTypeId(assesmentTypeId);
		 
		// ----set the courseid into the CourseDTO
		 Integer courseId=Integer.parseInt(request.getParameter("course"));
		  CourseDTO course=new CourseDTO();
		  course.setCourseId(courseId);
		  
        // ----set the levelId into the LevelDto
		  Integer levelId=Integer.parseInt(request.getParameter("course"));
		  LevelDTO level=new LevelDTO();
		  level.setLevelId(levelId);
		  
		  
		  request.getParameter("Level");
		 Integer noOfStudentsForaSlot=Integer.parseInt(request.getParameter("no_of_Slot"));
		 String start_time=request.getParameter("start_Time");
		
		 // Time StartTime=request.getParameter("start_Time");
		
		 
		// SimpleDateFormat format_start_Time= new SimpleDateFormat("HH:mm:ss"); // 12 hour format
		 	System.out.println(">>>>"+start_time);
		 
		    java.util.Date d1_start_Time=null;
				d1_start_Time = new Date(DateUtil.stringToSqlDate(start_time,"HH:mm:ss").getTime());
			

		    java.sql.Time ppstime_start_Time= new java.sql.Time(d1_start_Time.getTime());
		    System.out.println(ppstime_start_Time);
		// Time EndTime=request.getParameter("end_Time");
		    String endTime=request.getParameter("end_Time");
		    //SimpleDateFormat format_endTime= new SimpleDateFormat("HH:mm:ss"); // 12 hour format

		    java.util.Date d1_endTime=null;
				d1_endTime = new Date(DateUtil.stringToSqlDate(endTime,"HH:mm:ss").getTime());;

		    java.sql.Time ppstime_endTime = new java.sql.Time(d1_endTime.getTime());
		    System.out.println(ppstime_endTime);
		//create object of Assesmentdto and set values
		    AssesmentDTO ad=new AssesmentDTO();
		  //  ad.setAssesmentId(assesmentId);
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
			/*String assesment_Name=request.getParameter("assesment_Name");
			Integer total_Marks=Integer.parseInt(request.getParameter("total_Marks"));
			Integer duration_in_Min=Integer.parseInt(request.getParameter("Duration_in_Min"));
		System.out.println(request.getParameter("assesment_Name")+"   assesment_Name");
		System.out.println(request.getParameter("total_Marks")+"        total_Marks");
		System.out.println(request.getParameter("Duration_in_Min")+"     duration_in_Min");
		System.out.println(request.getParameter("descrition")+"      descrition");
		//change this one is id
		System.out.println(request.getParameter("assessmentType")+"    assessmentType");
		//change this one is id
		System.out.println(request.getParameter("course")+"       course");
		
		System.out.println(request.getParameter("dob")+"     dob");
	//change this one is id
		System.out.println(request.getParameter("Level")+"      level");
		
		System.out.println(request.getParameter("no_of_Slot")+"       no_of_Slot");
		
		System.out.println(request.getParameter("start_Time")+"     start_Time");
		System.out.println(request.getParameter("end_Time")+"    end_Time");
		
		System.out.println(Integer.parseInt(request.getParameter("contact_person_addressid"))+"addressid");
		*/
		
		
	
		
		AssesmentsDelegate add=new AssesmentsDelegate();
		try {
			add.addAssessment(ad);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
