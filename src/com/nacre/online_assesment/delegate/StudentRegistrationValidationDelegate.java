/**
 * 
 */
package com.nacre.online_assesment.delegate;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.online_assesment.dto.CollegeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.dto.UniversityDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei;
import com.nacre.online_assesment.service_i.service_impl.StudentRegistrationValidationServiceimpl;
import com.nacre.online_assesment.vo.StudentEducationDetailsToVerifyBean;
import com.nacre.online_assesment.vo.StudentPersonalDetailsToVerifyBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StudentRegistrationValidationDelegate {
	
	
	StudentRegistrationValidationServicei studentregistrationservice = new StudentRegistrationValidationServiceimpl();
	
	
	/**
	 * @author Srikanth and Krunal  b35
	 * @return List of UserDto containing all un aproved student details
	 * @throws DatabaseException 
	 */
	public List getUnaprovedStudentDetails() throws DatabaseException{
		return studentregistrationservice.getUnaprovedStudentDetails();
	}
	
	
	/**
	 * @author Srikanth and Krunal  b35
	 * @param userId Accepts IntegerValue to get particular student details based on userId
	 * @return List contains StudentPersonalDetailsBean obj , sub List which contains student  educational details
	 * @throws DataNotFoundException occurs when no Countries Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List getStudentDetailsToVerify(Integer userId) throws DatabaseException{
		return studentregistrationservice.getStudentDetailsToVerify(userId);
	}
	
	
	
	/**
	 * @author Srikanth and Krunal b35
	 * @return List contains all education stream details
	 * @throws DatabaseException 
	 */
	public List getEduStreams() throws DatabaseException {
		// TODO Auto-generated method stub
			return studentregistrationservice.getEduStreams();
	}
	
	
	
	/**
	 * @author Srikanth and Krunal  B35
	 * @param bean accepts StudentPersonalDetailsToVerifyBean object
	 * @throws DatabaseException 
	 */
	public void updateStudentPersonalDetails(StudentPersonalDetailsToVerifyBean bean) throws DatabaseException{
		studentregistrationservice.updateStudentPersonalDetails(bean);
	}
	
	
	/**
	 * @author Srikanth and Krunal   B35
	 * @param isNewPg Accepts Boolean
	 *@param List accepts java.util.List<StudentEducationDetailsToVerifyBean>
	 * @throws DatabaseException 
	 
	 */
	public void updateStudentEduDetails(List<StudentEducationDetailsToVerifyBean> list, Boolean isNewPg) throws DatabaseException{
		studentregistrationservice.updateStudentEduDetails(list,isNewPg);
	}
	
	
	/**
	 * @author Srikanth and Krunal  B35
	 * @return List contain all univercityes details
	 * @throws DatabaseException 
	 */
	public List<UniversityDTO> getunivercityes() throws DatabaseException {
		// TODO Auto-generated method stub
		return studentregistrationservice.getUnivercityes();
	}

	
	
	/**
	 * @author Srikanth and Krunal  B35
	 * @param techId Accepts Integer
	 *@return List contains all courses based on technology
	 * @throws DatabaseException 
	 */
	public List<CourseDTO> getCourses(Integer techId) throws DatabaseException {
		// TODO Auto-generated method stub
		return studentregistrationservice.getCourse(techId);
	}
	
	
	/**
	 * @author Srikanth and Krunal B35
	 * @param userId Accepts Integer 
	 *@return Integetr contains how many rows effected while changing status
	 * @throws DatabaseException 
	 */
	public Integer updateCourses(List<CourseDTO> list, Integer userId) throws DatabaseException {
		return studentregistrationservice.updateCourses(list,userId);
	}
	
	
	/**
	 * @author Srikanth and Krunal   B35
	 * @param mailId accepts String
	 * @param password accepts String type 
	 *@return Integetr contains how many rows effected while changing status
	 */
	public Boolean sendSuccessMailToStudent(String mailId, String password,Integer userId) {
		// TODO Auto-generated method stub
		
		return studentregistrationservice.sendSuccessMailToStudent(mailId,password,userId);
	}


	/**
	 * this method is used for retrieving universities
	 * @throws SQLException 
	 * @throws DatabaseException
	 */
	
	public List<UniversityDTO> getUniversities() throws SQLException,DatabaseException{
		
		StudentRegistrationValidationServicei srvs=new StudentRegistrationValidationServiceimpl();
		
		List<UniversityDTO> list=srvs.getUniversities();
		
		return list;
	}
	
	/**
	 * this method is used for retrieving colleges
	 * @throws SQLException 
	 * @throws DatabaseException 
	 *
	 */
	
	public List<CollegeDTO> getColleges(Integer universityId) throws DatabaseException, SQLException {

		
       StudentRegistrationValidationServicei srvs=new StudentRegistrationValidationServiceimpl();
		
		List<CollegeDTO> list=srvs.getColleges(universityId);
		
		return list;
	}
	
	/**
	 * @author Sunil Kumar Maharana
	 * @return List contains all Universities
	 * @throws DataNotFoundException occurs when no Universities Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	
	public List<UniversityDTO> getUniversityList() throws DataNotFoundException, DatabaseException {
		StudentRegistrationValidationServicei studentRegistrationValidationServicei=new StudentRegistrationValidationServiceimpl();
		return studentRegistrationValidationServicei.getUniversityList();
	}
	/**
	 * @author Sunil Kumar Maharana
	 * @param universityId 
	 * @return List contains all colleges w.r.t entered University
	 * @throws DataNotFoundException occurs when no  colleges Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<CollegeDTO> getCollegeList(Integer universityId) throws DataNotFoundException, DatabaseException{
		StudentRegistrationValidationServicei studentRegistrationValidationServicei=new StudentRegistrationValidationServiceimpl();
		return studentRegistrationValidationServicei.getCollegeList(universityId);	
	}
	/**
	 * @author Sunil kumar Maharana
	 * @return List contains all streams
	 * @throws DataNotFoundException occurs when no  stream Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<StreamDTO> getStreamList()throws DataNotFoundException, DatabaseException{
		StudentRegistrationValidationServicei studentRegistrationValidationServicei=new StudentRegistrationValidationServiceimpl();
		return studentRegistrationValidationServicei.getStreamList();	
	}
	/**
	 * @author sunil kumar maharana
	 * param String email
	 * @throws DataNotFoundException occurs when no userId Available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database 
	 */
		public int getUserId(String email)throws DatabaseException,DataNotFoundException{
		StudentRegistrationValidationServicei studentRegistrationValidationServicei=new StudentRegistrationValidationServiceimpl();
		return studentRegistrationValidationServicei.getUserId(email);
		
		}
	/**
	 * @author sunil
	  * @param studentRegistrationMap
	 * @return int value to know success or failure
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public int studentRegistration(Map studentRegistrationMap)throws DatabaseException{
		StudentRegistrationValidationServicei studentRegistrationValidationServicei=new StudentRegistrationValidationServiceimpl();
		return studentRegistrationValidationServicei.studentRegistration(studentRegistrationMap);
		
	}

	
	
}
