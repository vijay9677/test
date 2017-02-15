package com.nacre.online_assesment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.nacre.online_assesment.delegate.AssesmentsDelegate;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AssessmentFormBean;
import com.nacre.online_assesment.util.DateUtil;

/**
 * Servlet implementation class AssesmentDetailsForEditAction
 */
@WebServlet("/AssesmentDetailsForEditAction")
public class AssesmentDetailsForEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssesmentDetailsForEditAction() {
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
		System.out.println("in curd opertaion controller");
		// TODO Auto-generated method stub
		
		   /* Integer assessmentId=null;
			String assessmentName = null;
			Integer assessmentMarks = null;
			Integer assessmentDuration = null;
			Date assessmentDate = null;
			String assessmentDescription = null;
			*//**@author  pavan pratap singh*//*
			Integer assesmentTypeId=null;
			Integer courseId=null;
			Integer levelId=null;
			Integer no_of_students_for_a_slot=null;
			Time start_time_of_slots=null;
			Time end_time_slots=null;*/
		List<Object> l=new ArrayList<Object>();
					PrintWriter pw=response.getWriter();
					AssesmentsDelegate adel=new AssesmentsDelegate();
					List<AssesmentDTO> list=null;
					try {
						list = adel.getAssessmentDetailsForEditAction();
						
						for(int i=0;i<list.size();i++){
							System.out.println(list.get(i).getAssesmentId());
							   Integer assessmentId=list.get(i).getAssesmentId();
								String assessmentName =list.get(i).getAssesment();
								Integer assessmentMarks =list.get(i).getTotalMarks();
								Integer assessmentDuration =list.get(i).getDurationInMin();
								//Date assessmentDate = list.get(i).getDate();
								String stringDate=list.get(i).getDate().toString();
								//DateUtil.sqlDateToString( list.get(i).getDate());
								System.out.println(stringDate);
								
								String assessmentDescription =list.get(i).getDescription();
								/**@author  pavan pratap singh*/
							//	Integer assesmentTypeId=list.get(i).getAssesmentType().getAssesmentTypeId();
								String assesmentTypeName=list.get(i).getAssesmentType().getAssesmentTypeName();
							//	Integer courseId=list.get(i).getCourse().getCourseId();
								String courseName=list.get(i).getCourse().getCourse();
							//	Integer levelId=list.get(i).getLevel().getLevelId();
								String levelName=list.get(i).getLevel().getLevel();
								Integer no_of_students_for_a_slot=list.get(i).getNoOfStudentsForaSlot();
								Time start_time_of_slots=list.get(i).getStartTime();
								Time end_time_slots=list.get(i).getEndTime();
								
								AssessmentFormBean asb=new AssessmentFormBean();
								asb.setAssessmentId(assessmentId);
								asb.setAssessmentName(assessmentName);
								asb.setAssessmentMarks(assessmentMarks);
								asb.setAssessmentDuration(assessmentDuration);
								asb.setAssessmentDate(stringDate);
								asb.setAssessmentDescription(assessmentDescription);
								//asb.setAssesmentTypeId(assesmentTypeId);
								asb.setAssessmentTypeName(assesmentTypeName);
								//asb.setCourseId(courseId);
								asb.setCourseName(courseName);
								//asb.setLevelId(levelId);
								asb.setLevelName(levelName);
								
								asb.setNo_of_students_for_a_slot(no_of_students_for_a_slot);
								asb.setStart_time_of_slots(start_time_of_slots);
								asb.setEnd_time_slots(end_time_slots);
								
								l.add(asb);
						}
						Gson gson = new Gson();
						response.setContentType("text/json");
						System.out.println(gson.toJson(l));
						String viewAssesmentdetails = gson.toJson(l);
						pw.println(viewAssesmentdetails);
						System.out.println(l);
					} catch (DatabaseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(list);
				
					
					
				
				}				
			}
	    
		
		 
	


