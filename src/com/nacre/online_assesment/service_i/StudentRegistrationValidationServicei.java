/**
 * 
 */
package com.nacre.online_assesment.service_i;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.online_assesment.dto.CollegeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.dto.UniversityDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.StudentPersonalDetailsToVerifyBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface StudentRegistrationValidationServicei {
	
	/**
	 * this method is used to retrieve universities
	 *
	 */
	public List<UniversityDTO> getUniversities() throws DatabaseException,SQLException;
	
	/**
	 * this method is used to retrieve colleges
	 *
	 */
	public List<CollegeDTO> getColleges(Integer universityId) throws DatabaseException,SQLException;
	
	
	/**
	 * @author Srikanth and Krunal  b35
	 * @return List of UserDto containing all un aproved student details
	 * @throws DatabaseException 
	 */
	public List getUnaprovedStudentDetails() throws DatabaseException;
	
	
	/**
	 * @author Srikanth and Krunal  b35
	 * @param userId Accepts IntegerValue to get particular student details based on userId
	 * @return List contains StudentPersonalDetailsBean obj , sub List which contains student  educational details
	 * @throws DatabaseException 
	 */
	public List getStudentDetailsToVerify(Integer userId) throws DatabaseException;
	
	
	/**
	 * @author Srikanth and Krunal b35
	 * @return List contains all education stream details
	 * @throws DatabaseException 
	 */
	public List getEduStreams() throws DatabaseException;
	
	
	/**
	 * @author Srikanth and Krunal  B35
	 * @param bean accepts StudentPersonalDetailsToVerifyBean object
	 * @throws DatabaseException 
	 */
	public void updateStudentPersonalDetails(StudentPersonalDetailsToVerifyBean bean) throws DatabaseException;
	
	
	/**
	 * @author Srikanth and Krunal   B35
	 * @param isNewPg Accepts Boolean
	 *@param List accepts java.util.List<StudentEducationDetailsToVerifyBean>
	 * @throws DatabaseException 
	 
	 */
	public void updateStudentEduDetails(List list, Boolean isNewPg) throws DatabaseException;
	
	

	/**
	 * @author Srikanth and Krunal  B35
	 * @return List contain all univercityes details
	 * @throws DatabaseException 
	 */
	public List<UniversityDTO> getUnivercityes() throws DatabaseException;
	
	
	/**
	 * @author Srikanth and Krunal  B35
	 * @param techId Accepts Integer
	 *@return List contains all courses based on technology
	 * @throws DatabaseException 
	 */
	public List<CourseDTO> getCourse(Integer techId) throws DatabaseException;
	
	
	/**
	 * @author Srikanth and Krunal B35
	 * @param userId Accepts Integer 
	 *@return Integetr contains how many rows effected while changing status
	 * @throws DatabaseException 
	 */
	public Integer updateCourses(List<CourseDTO> list, Integer userId) throws DatabaseException;
	
	
	/**
	 * @author Srikanth and Krunal   B35
	 * @param mailId accepts String
	 * @param password accepts String type 
	 * @param userId accepts Integet
	 *@return boolean value tells that mail sended succesfully or not
	 */
	public boolean sendSuccessMailToStudent(String mailId, String password,Integer userId);
	

	/**
	 * @author Sunil Kumar Maharana
	 * @return List contains all Universities
	 * @throws DataNotFoundException occurs when no Universities Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	
	public List<UniversityDTO> getUniversityList() throws DataNotFoundException, DatabaseException;
	/**
	 * @author Sunil Kumar Maharana
	 * @param universityId 
	 * @return List contains all colleges w.r.t entered University
	 * @throws DataNotFoundException occurs when no  colleges Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<CollegeDTO> getCollegeList(Integer universityId) throws DataNotFoundException, DatabaseException; 
	/**
	 * @author Sunil kumar Maharana
	 * @return List contains all streams
	 * @throws DataNotFoundException occurs when no streams Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<StreamDTO> getStreamList()throws DataNotFoundException, DatabaseException;
	/**
	 * @author sunil kumar maharana
	 * param String email
	 * @throws DataNotFoundException occurs when no userid Available
	 * @throws DatabaseException occurs when problem  occurs while interacting with  database 
	 */
		public int getUserId(String email)throws DatabaseException,DataNotFoundException;
	/**
	 * @author sunil
	 * @param studentRegistrationMap
	 * @return int value to know success or failure
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public int studentRegistration(Map studentRegistrationMap)throws DatabaseException;

}
