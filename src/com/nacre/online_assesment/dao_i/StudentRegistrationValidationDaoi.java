package com.nacre.online_assesment.dao_i;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.nacre.online_assesment.dto.CollegeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.dto.UniversityDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.vo.StudentEducationDetailsToVerifyBean;
import com.nacre.online_assesment.vo.StudentPersonalDetailsToVerifyBean;


public interface StudentRegistrationValidationDaoi {
	
	/** this method is used to retrieve universities  
	 * returns list of universities
	 * */
	
	public List<UniversityDTO> getUniversities(Connection con) throws DatabaseException;
	
	/** this method is used to retrieve colleges 
	 * returns list of colleges  
	 * */
	
	public List<CollegeDTO> getColleges(Integer universityId, Connection con) throws DatabaseException; 
	
	
	/**
	 * @author Srikanth and Krunal
	 * @param con Accepts java.sql.Connection
	 * @return List contains all un aproved student details
	 * @throws DataNotFoundException occurs when no Countries Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List getUnaprovedStudentDetails(Connection con) throws DatabaseException;
	
	/**
	 * @author Srikanth and Krunal
	 * @param con Accepts java.sql.Connection
	 * @param userId Accepts IntegerValue to get particular student details based on userId
	 * @return List contains StudentPersonalDetailsBean obj , sub List which contains student  educational details
	 * @throws DataNotFoundException occurs when no Countries Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List getStudentDetailsToVerify(Integer userId , Connection con)throws DatabaseException;
	
	/**
	 * @author Srikanth and Krunal
	 * @param con Accepts java.sql.Connection
	 * @return List contains all education stream details
	 * @throws DataNotFoundException occurs when no Countries Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List getEduStreams(Connection con)throws DatabaseException;
	
	
	
	/**
	 * @author Srikanth and Krunal
	 * @param con Accepts java.sql.Connection
	 * @param bean accepts StudentPersonalDetailsToVerifyBean object
	
	 */
	public void updateStudentPersonalDetails(StudentPersonalDetailsToVerifyBean bean,Connection con)throws DatabaseException;
	
	
	/**
	 * @author Srikanth and Krunal
	 * @param con Accepts java.sql.Connection
	 * @param isNewPg 
	 *@param List accepts java.util.List<StudentEducationDetailsToVerifyBean>
	 
	 */
	public void updateStudentEducDetails(List<StudentEducationDetailsToVerifyBean> eduList,Connection con, Boolean isNewPg)throws DatabaseException;

	

	/**
	 * @author Srikanth and Krunal
	 * @param con Accepts java.sql.Connection
	 * @return List contain all univercityes details
	 
	 */
	public List<UniversityDTO> getUnivercityes(Connection con)throws DatabaseException;


	/**
	 * @author Srikanth and Krunal
	 * @param con Accepts java.sql.Connection
	 * @param techId Accepts Integer
	 *@return List contains all courses based on technology
	 
	 */
	public List<CourseDTO> getCourses(Integer techId, Connection con)throws DatabaseException;
	

	/**
	 * @author Srikanth and Krunal
	 * @param con Accepts java.sql.Connection
	 * @param userId Accepts Integer 
	 *@return Integetr contains how many rows effected while changing status
	 
	 */
	public Integer updateCourses(List list,Connection con, Integer userId)throws DatabaseException;
	
	
	/**
	 * @author Sunil Kumar Maharana
	 * @param con Accepts java.sql.Connection
	 * @return List contains all Universities
	 * @throws DataNotFoundException occurs when no Universities Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<UniversityDTO> getUniversityList(Connection con) throws DataNotFoundException, DatabaseException; 
	/**
	 * @author Sunil Kumar Maharana
	 * @param universityId 
	 * @param con Accepts java.sql.Connection
	 * @return List contains all colleges w.r.t entered University
	 * @throws DataNotFoundException occurs when no  colleges Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<CollegeDTO> getCollegeList(Integer universityId, Connection con) throws DataNotFoundException, DatabaseException;
	/**
	 * @author Sunil kumar Maharana
	 * @param con Accepts java.sql.Connection
	 * @return List contains all courses
	 * @throws DataNotFoundException occurs when no streams Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<StreamDTO> getStreamList(Connection con)throws DataNotFoundException, DatabaseException;
	/**
	 * @author sunil kumar mahara
	 * @param connection
	 * @param String email
	 * @return int value
	 * @throws DataNotFoundException occurs when no userid Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public int getUserId(String email,Connection con)throws DatabaseException, DataNotFoundException;
	/**
	 * @author sunil
	 * @param studentRegistrationMap
	 * @param connection
	 * @return int value to know success or failure
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public int studentRegistration(Map studentRegistrationMap,Connection con)throws DatabaseException;
	
	
	

	public void changeStudenStatusId(Integer userId,Connection con);

	
}
