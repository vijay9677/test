/**
 * 
 */
package com.nacre.online_assesment.dao_i;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.sql.Connection;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.AssesmentTypeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AssessmentPaperFormBean;
import com.nacre.online_assesment.form_bean.BookedSlotsBean;
import com.nacre.online_assesment.form_bean.CurrentQuestionDetailsBean;
import com.nacre.online_assesment.form_bean.ScoreBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface AssesmentsDaoi 
{
	/**
	 * @author krishna Prakash
	 * @param con,List
	 * @return Integer
	 * @throws DatabaseException 
	 *
	 */
	public Integer uploadAssessmentPaper(List<AssessmentPaperFormBean> li,Integer assId,Connection con) throws DatabaseException;
	
/**
 * @author 	krishna Prakash
 * @param con
 * @return
 */
	public List<LevelDTO> getQuestionLevel(Connection con);
  /**
	 * @author 	krishna Prakash
	 * @param con
	 * @return Boolean
	 */

	public Boolean deleteAssessmentPaper(Connection con, Integer assessmentId) throws DatabaseException, SQLException;

	/**
	 * @author 	krishna Prakash
	 * @param con
	 * @return List
	 */
	 public List getAssessmentPaper(Connection con) throws DatabaseException, SQLException;

	
	/**
	 * @author Chitranshu Gupta
	 * @param con
	 * @return List
	 * @throws DatabaseException 
	 *
	 */
	List<Object> getAssessmentType(Connection con) throws DatabaseException;
	
	/**
	 * @author Chitranshu Gupta 
	 * @param con 
	 * @param assessmentTypeId
	 * @return List
	 * @throws DatabaseException 
	*/
	List<Object> getAssessments(Connection con, Integer assessmentTypeId) throws DatabaseException;

	/**
	 * @author Chitranshu Gupta 
	 * @param con 
	 * @param assessmentId
	 * @return List
	 * @throws DatabaseException 
	*/
	List<Object> getAssessmentDetails(Connection con, Integer assessmentId) throws DatabaseException;

	/**
	 * @author Chitranshu Gupta
	 * @param con 
	 * @param currentQuestionDetailsBean
	 * @return NavigableMap
	 * @throws DatabaseException 
	*/
	NavigableMap<Integer, Object> getQuestionsAndTheirOption(Connection con, CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException;


	/**
	 * @author Chitranshu Gupta
	 * @param con
	 * @param currentQuestionDetailsBean
	 * @return Integer
	 * @throws DatabaseException 
	*/
	
	Integer calculateScore(Connection con, CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException;

	/**
	 * @author Chitranshu Gupta
	 * @param con
	 * @param assessmentId
	 * @param userId
	 * @return String
	 * @throws DatabaseException 
	*/
	String getExamStatus(Connection con, Integer assessmentId, Integer userId) throws DatabaseException;
	

	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con, AssesmentDTO ad
	 * @return Boolean 
	 * @throws SQLException
	 */
	Boolean addAssessment(Connection con, AssesmentDTO ad) throws SQLException;


	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con, AssesmentDTO ad
	 * @return Boolean 
	 * @throws SQLException
	 */
	
	Boolean editAssessment(Connection con, AssesmentDTO ad) throws SQLException, DatabaseException;


	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con, AssesmentDTO ad
	 * @return Boolean 
	 * @throws SQLException
	 */
	Boolean deleteAssessment(Connection con, Integer assessmentId) throws SQLException;


	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con
	 * @return List 
	 * @throws SQLException
	 */
	List<AssesmentTypeDTO> getAssesmentType(Connection con) throws SQLException;


	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con
	 * @return List 
	 * @throws SQLException
	 */
	List<LevelDTO> getLevel(Connection con) throws SQLException;


	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con
	 * @return List 
	 * @throws SQLException
	 */
	List<CourseDTO> getCourses(Connection con) throws SQLException;


	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con
	 * @return List 
	 * @throws SQLException
	 */
	List<AssesmentDTO> getAssessmentDetailsForEditAction(Connection con)
			throws DatabaseException;
	
	/**
	 * @author Ashish Kumar B-35
	 * @return List 
	 * @throws SQLException
	 */

	List<ScoreBean> getScores(Connection con, Integer userId) throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to get all AssesmentTypeNames from DataBase table tbl_assessment_type
	 * @param con
	 * @return ArrayList of DTO type
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> getAssessmentTypeName(Connection con) throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to get all AssesmentNames from DataBase table tbl_assessment on basis of assessment_type_name or id
	 * @param con
	 * @param assesmentTypeId
	 * @return ArrayList of DTO type
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> getAssessmentName(Connection con,Integer assesmentTypeId,Integer userId) throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to divide Time into slots on basis of assessment startTime,endTime and time duration (all are taken from DataBase)
	 * @param con
	 * @param assesmentId
	 * @return ArrayList of Object type
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> getTimeSlots(Connection con,Integer assesmentId) throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to select one time slot per Assessment not same for another 
	 * @param con
	 * @param bukBean
	 * @return Integer
	 * @throws DatabaseException
	 */
	
	public ArrayList<Object> bookSelectedSlot(Connection con,BookedSlotsBean bukBean) throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to provide info about selected and non-selected time slot for each user on basis of assessment 
	 * @param con
	 * @param userId
	 * @param assmentId
	 * @return java.sql.Time(booked Time slots)
	 * @throws DatabaseException
	 */
	
	public Time validationForBookedSlots(Connection con,Integer userId,Integer assmentId) throws DatabaseException;
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to get all booked slot details from database table tbl_assessment and tbl_booked_slot on basis of assessment_id and user_id
	 * (only from that particular assessment not database)
	 * @return ArrayList
	 * @throws DatabaseException 
	 */
	
	
	public ArrayList<Object> getBookedSlotDetails(Connection con,Integer assessmentId,Integer userID) throws DatabaseException;

	public AssesmentDTO getAssessmentDetailsForEdit(Connection con, Integer assessmentId) throws DatabaseException;

}
