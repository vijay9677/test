/**
 * 
 */
package com.nacre.online_assesment.service_i;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.AssesmentTypeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.CurrentQuestionDetailsBean;
import com.nacre.online_assesment.form_bean.ScoreBean;





import java.sql.Time;
import java.util.ArrayList;

import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.BookedSlotsBean;


/**
 * @author RROCK
 * @author Rohit Kumar Singh b35
 * @author Vijay Kumar Reddy K
 *
 */
public interface AssesmentServicei 

{
	/**
	 * @author Krishna prakash
	 * @return Integer
	 * @throws DatabaseException 
	 *
	 */
	 public List<LevelDTO> getQuestionLevel() throws DatabaseException;
	/**
	 * @author Krishna prakash
	 * @return Integer
	 * @throws DatabaseException 
	 *
	 */
    public Integer uploadAssessmentPaper(List li,Integer assId) throws DatabaseException;
      /**
	 * @author Krishna prakash
	 * @return Boolean,SQLException
	 * @throws DatabaseException 
	 *
	 */
    
    public Boolean deleteAssessmentPaper(Integer assessmentId) throws DatabaseException, SQLException;
    /**
   	 * @author Krishna prakash
   	 * @return List,SQLException
   	 * @throws DatabaseException 
   	 *
   	 */
    public List getAssessmentPaper() throws DatabaseException, SQLException;
	/**
	 * @author Chitranshu Gupta
	 * @return List
	 * @throws DatabaseException 
	 *
	 */
	List<Object> getAssessmentType() throws DatabaseException;
	
	/**
	 * @author Chitranshu Gupta
	 * @param assessmentTypeId
	 * @return List
	 * @throws DatabaseException 
	 */
	List<Object> getAssessments(Integer assessmentTypeId) throws DatabaseException;

	/**
	 * @author Chitranshu Gupta
	 * @param assessmentId
	 * @return List
	 * @throws DatabaseException 
	 */
	List<Object> getAssessmentDetails(Integer assessmentId) throws DatabaseException;
	
	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con, AssesmentDTO ad
	 * @return Boolean 
	 * @throws DatabaseException,SQLException
	 */
	Boolean addAssessment(AssesmentDTO ad) throws DatabaseException, SQLException;
	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con, AssesmentDTO ad
	 * @return Boolean 
	 * @throws DatabaseException,SQLException
	 */

	
	/**
	 * @author Chitranshu Gupta
	 * @param currentQuestionDetailsBean
	 * @return NavigableMap
	 * @throws DatabaseException 
	 */
	NavigableMap<Integer,Object> getQuestionsAndTheirOption(CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException;
	

	Boolean editAssessment(AssesmentDTO ad) throws DatabaseException, SQLException;
	/**
	 * @author pavan pratap singh b-35
	 * @param assessmentId
	 * @return Boolean 
	 * @throws DatabaseException,SQLException
	 */

	Boolean deleteAssessment(Integer assessmentId) throws DatabaseException, SQLException;
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List 
	 * @throws DatabaseException,SQLException
	 */

	List<AssesmentTypeDTO> getAssesmentType() throws DatabaseException, SQLException;
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List 
	 * @throws DatabaseException,SQLException
	 */
	List<LevelDTO> getLevel() throws DatabaseException, SQLException;
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List 
	 * @throws DatabaseException,SQLException
	 */

	List<CourseDTO> getCourses() throws DatabaseException, SQLException;
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List 
	 * @throws DatabaseException,SQLException
	 */

	List<AssesmentDTO> getAssessmentDetailsForEditAction() throws DatabaseException;

	/**
	 * @author Chitranshu Gupta
	 * @param currentQuestionDetailsBean
	 * @return Integer
	 * @throws DatabaseException 
	 */
	public Integer calculateScore(CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException;

	/**
	 * @author Chitranshu Gupta
	 * @param assessmentId
	 * @param userId
	 * @return String
	 * @throws DatabaseException 
	 */
	String getExamStatus(Integer assessmentId, Integer userId) throws DatabaseException;
/**
 * @author ashish
 * @param userId
 * @return
 * @throws DatabaseException 
 */
	List getScores(Integer userId) throws DatabaseException;



	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to get all AssesmentTypeName from database table tbl_assessment_type
	 * @return ArrayList DTO type
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> getAssessmentTypeName() throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to get all AssesmentName from database table tbl_assessment on basis of assessment_type_id
	 * @param assesmentTypeId
	 * @return ArrayList DTO type
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> getAssessmentName(Integer assesmentTypeId,Integer userId) throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to get assessment start time,end time,duration from database table tbl_assessment on basis of assesment_id
	 * and divide a number of time slots on basis of duration
	 * @param assesmentId
	 * @return ArrayList Object type
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> getTimeSlots(Integer assesmentId) throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to select time slot(s) from available time slots according to assessment and store it into database table tbl_booked_slots
	 * @param bukBean
	 * @return Integer
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> bookedSelectedSlots(BookedSlotsBean bukBean) throws DatabaseException ;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method for booking one slot per assessment and not same time for another assessment  
	 * @param userId
	 * @param assmentId
	 * @return java.sql.Time(bookedTimeSlot on basis of assessment Id/Name)
	 * @throws DatabaseException
	 */
	
	public Time validationForBookedSlots(Integer userId,Integer assmentId) throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to get all booked slot details on basis of assessment_id & user_id from database table tbl_assessment & tbl_booked_slots
	 * @param assessmentId
	 * @param userId
	 * @return ArrayList 
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> getBookedSlotDetails(Integer assessmentId, Integer userID) throws DatabaseException;
	/**
	 * @author pavan pratap singh b-35
	 * @param assessmentId
	 * @return
	 * @throws DatabaseException
	 */
	public AssesmentDTO getAssessmentDetailsForEdit(Integer assessmentId)
			throws DatabaseException;
	
}//AssessmentServicei
