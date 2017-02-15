/**
 * @author Rohit Kumar Singh b35
 */
package com.nacre.online_assesment.delegate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;


import java.sql.Time;
import java.util.ArrayList;

import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.BookedSlotsBean;
import com.nacre.online_assesment.service_i.AssesmentServicei;
import com.nacre.online_assesment.service_i.service_impl.AssesmentsServiceimpl;

import com.nacre.online_assesment.form_bean.CurrentQuestionDetailsBean;
import com.nacre.online_assesment.form_bean.ScoreBean;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.AssesmentTypeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.CurrentQuestionDetailsBean;
import com.nacre.online_assesment.service_i.AssesmentServicei;
import com.nacre.online_assesment.service_i.service_impl.AssesmentsServiceimpl;

/**
 * @author Ashish Kumar
 *
 */
public class AssesmentsDelegate {
 
	/**
	 * @author Chitranshu Gupta
	 * @return List 
	 * @throws DatabaseException 
	 *
	 */
	public List<Object> getAssessmentType() throws DatabaseException
	{
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.getAssessmentType();
	}
	
	/**
	 * @author Chitranshu Gupta
	 * @param assessmentTypeId
	 * @return List
	 * @throws DatabaseException 
	 */
	public List<Object> getAssessments(Integer assessmentTypeId) throws DatabaseException{
		
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.getAssessments(assessmentTypeId);
	}
	

	/**
	 * @author Chitranshu Gupta
	 * @param assessmentId
	 * @return List
	 * @throws DatabaseException 
	 */
	public List<Object> getAssessmentDetails(Integer assessmentId) throws DatabaseException {
		// TODO Auto-generated method stub
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.getAssessmentDetails(assessmentId);
	}

	/**
	 * @author Chitranshu Gupta
	 * @param currentQuestionDetailsBean
	 * @return NavigableMap
	 * @throws DatabaseException 
	 */
	public NavigableMap getQuestionsAndTheirOption(CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException {
		
		// TODO Auto-generated method stub
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.getQuestionsAndTheirOption(currentQuestionDetailsBean);
	}

	/**
	 * @author Chitranshu Gupta
	 * @param currentQuestionDetailsBean
	 * @return Integer
	 * @throws DatabaseException 
	 */
	public Integer calculateScore(CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException {
		AssesmentServicei interface1 =new AssesmentsServiceimpl();
		return interface1.calculateScore(currentQuestionDetailsBean);
		
	}


	/**
	 * @author pavan pratap singh b-35
	 * @param AssesmentDTO ad
	 * @return 
	 * @throws DatabaseException 
	 */

	public Boolean addAssessment(AssesmentDTO ad) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		 return assesmentServicei.addAssessment(ad);
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param AssesmentDTO ad
	 * @return 
	 * @throws DatabaseException 
	 */
	public Boolean editAssessment(AssesmentDTO ad) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.editAssessment(ad);
		
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param assesmentId
	 * @return 
	 * @throws DatabaseException 
	 */

	public Boolean deleteAssessment(Integer assessmentId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.deleteAssessment(assessmentId);
		
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List<AssesmentDTO> 
	 * @throws DatabaseException 
	 */

	public List<AssesmentTypeDTO> getAssesmentType() throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.getAssesmentType();
		
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List<AssesmentDTO> 
	 * @throws DatabaseException 
	 */

	public List<LevelDTO> getLevel() throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.getLevel();
		
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List<AssesmentDTO> 
	 * @throws DatabaseException 
	 */

	public List<CourseDTO> getCourses() throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.getCourses();
		
		
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List<AssesmentDTO> 
	 * @throws DatabaseException 
	 */

	public List<AssesmentDTO> getAssessmentDetailsForEditAction() throws DatabaseException {
		// TODO Auto-generated method stub
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.getAssessmentDetailsForEditAction();
		
	}

	
	
	/**
	 * @author Chitranshu Gupta
	 * @param assessmentId
	 * @param userId
	 * @return String
	 * @throws DatabaseException 
	 */
	public String getExamStatus(Integer assessmentId, Integer userId) throws DatabaseException {
		// TODO Auto-generated method stub
		AssesmentServicei interface1 =new AssesmentsServiceimpl();
		return interface1.getExamStatus(assessmentId, userId);
	}

	public List getScores(Integer userId) throws DatabaseException {
		AssesmentServicei interface1 =new AssesmentsServiceimpl();
		return interface1.getScores(userId);
		
	}
	/**
	 * @author  Krishna prakash
	 *
	 */
    public Integer uploadAssessmentPaper(List li,Integer assId) throws DatabaseException
    {
    	AssesmentServicei as=new AssesmentsServiceimpl();
    	Integer count=as.uploadAssessmentPaper(li,assId);
		return count;
    	
    }
	/**
	 * @author  Krishna prakash
	 *
	 */
    public List<LevelDTO> getQuestionLevel() throws DatabaseException{
    	AssesmentServicei as=new AssesmentsServiceimpl();
           
		return as.getQuestionLevel();
    	
    }
	    /**
	 * @author  Krishna prakash
	 *
	 */
    public Boolean deleteAssessmentPaper(Integer assessmentId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
		return assesmentServicei.deleteAssessmentPaper(assessmentId);
		
	}
    /**
   	 * @author  Krishna prakash
   	 *
   	 */
       public List getAssessmentPaper() throws DatabaseException, SQLException {
   		// TODO Auto-generated method stub
   		AssesmentServicei assesmentServicei=new AssesmentsServiceimpl();
   		return assesmentServicei.getAssessmentPaper() ;
   		
   	}



		
	 public AssesmentsDelegate() {
		// System.out.println("in deligate");
		 }
	
	 	/**
		 * @author Rohit Kumar Singh b35
		 * @param assmentBean
		 * @return ArrayList
		 * @throws DatabaseException
		 * method implementation for accessing assessmentTypeName from table
		 */
		
	public ArrayList<Object> getAssessmentTypeName() throws DatabaseException{
		
		//-----------------get ServiceI object--------------------------
		AssesmentServicei assServiceI=new AssesmentsServiceimpl();
		
		//-----------------call method from Servicei-------------------------------
		return assServiceI.getAssessmentTypeName();
		
	}//method

	
	/**
	 * @author Rohit Kumar Singh b35
	 * @param assesmentTypeId
	 * @return List
	 * @throws DatabaseException
	 * method implementation for accessing assessmentName from table
	 */
	
	public ArrayList<Object> getAssessmentName(Integer assesmentTypeId,Integer userId) throws DatabaseException {
		// TODO Auto-generated method stub
	//	System.out.println("in delegate : getAssmentName");
	
		//-----------------------create AssessmentServicei object-------------------
		AssesmentServicei asssService=new AssesmentsServiceimpl();
		
		return asssService.getAssessmentName(assesmentTypeId,userId);
		
	}//getAssessmentName(assmentBean) method
	
	
	/**
	 * @author Rohit Kumar Singh b35
	 * @param assesmentId
	 * @return ArrayList
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> getTimeSlots(Integer assesmentId) throws DatabaseException{
			
		//------------------create AssessmentServiceI object---------------------------
		AssesmentServicei assServicei=new AssesmentsServiceimpl();
		
		return assServicei.getTimeSlots(assesmentId);
		
	}//getTimeSlots()
	
	
	/**
	 * @author Rohit Kumar Singh b35
	 * @param bukBean
	 * @return ArrayList
	 * @throws DatabaseException 
	 */
	public ArrayList<Object> bookedSelectedSlots(BookedSlotsBean bukBean) throws DatabaseException {
	//	System.out.println("in deligate : bookedselectedslot");
		
		//----------------------create ServiceI Object---------------------------------
		AssesmentServicei assmentServicei=new AssesmentsServiceimpl();
		
		return assmentServicei.bookedSelectedSlots(bukBean);
		
	}//bookedSelectedSlots(BookedSlotsBean bukBean) 
	
	
	/**
	 * @author Rohit Kumar Singh b35
	 * @param userId
	 * @param assmentId
	 * @return Time
	 * @throws DatabaseException
	 */
	
	public Time validationForBookedSlots(Integer userId,Integer assmentId) throws DatabaseException{
	//	System.out.println("in deligate : validation");
		
		//---------------------get AssesmentServicei object-----------------------------
		AssesmentServicei assServicei = new AssesmentsServiceimpl();
		
		//-------------------call servicei method--------------------------------------
		Time bookedSlot = assServicei.validationForBookedSlots(userId, assmentId);
		
		return bookedSlot;
		
	}//validationForBookedSlots(Integer userId,Integer assmentId)
	
	/**
	 * @author Rohit Kumar Singh b35
	 * @param assessmentId
	 * @param userID
	 * @return ArrayList/Collection
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> getBookedSlotDetails(Integer assessmentId,Integer userID) throws DatabaseException{
		
		//------------------------getAssessmentServiceI object-------------------------
		AssesmentServicei assmentServicei = new AssesmentsServiceimpl();
		
		//----------------------calling Servicei method
		ArrayList<Object> bkdSlotDetails = assmentServicei.getBookedSlotDetails(assessmentId, userID);
		
		return bkdSlotDetails;
		
	}//getBookedDetails()
	/**
	 * @author pavan pratap singh b-35
	 * @param assessmentId
	 * @return
	 * @throws DatabaseException
	 */
	public AssesmentDTO getAssessmentDetailsForEdit(Integer assessmentId) throws DatabaseException {
		
        AssesmentServicei assmentServicei = new AssesmentsServiceimpl();
		return assmentServicei.getAssessmentDetailsForEdit(assessmentId);
		
	}
	
	
}//class
