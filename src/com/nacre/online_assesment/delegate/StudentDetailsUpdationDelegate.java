/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.PersonalDetailsBean;
import com.nacre.online_assesment.form_bean.StudentCoursesBean;
import com.nacre.online_assesment.form_bean.StudentEducationBean;
import com.nacre.online_assesment.service_i.StudentDetailsUpdationServicei;
import com.nacre.online_assesment.service_i.service_impl.StudentDetailsUpdationServiceimpl;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StudentDetailsUpdationDelegate {

	/**
	 * this method is used to get student profile
	 *
	 */
	
	public List getStudentProfile(Integer uid) throws DatabaseException ,SQLException{

		StudentDetailsUpdationServicei sdu=new StudentDetailsUpdationServiceimpl();
		
		List studentDetails=sdu.getStudentProfile(uid);
		
		return studentDetails;
	}
	
	
	/**
	 * this method is used to update student profile
	 *
	 */
	public Integer updateStudentProfile(PersonalDetailsBean pdb)throws DatabaseException ,SQLException{

		StudentDetailsUpdationServicei sdu=new StudentDetailsUpdationServiceimpl();
		Integer result=sdu.updateStudentProfile(pdb);
		return result;
	}
	
	
	/**
	 * this method is used to update student courses
	 *  
	 *
	 */
	public void updateStudentCourses(List<CourseDTO> list,Integer userId)throws DatabaseException ,SQLException{

		StudentDetailsUpdationServicei sdu=new StudentDetailsUpdationServiceimpl();
		sdu.updateStudentCourses(list, userId);
	}
	
	
	/**
	 * this method is used to update student post graduation details
	 *
	 */

	public Integer updateStudentPostGradDetails(StudentEducationBean eduBean)throws DatabaseException ,SQLException{

		StudentDetailsUpdationServicei sdu=new StudentDetailsUpdationServiceimpl();
		Integer resultFinal=sdu.updateStudentPostGradDetails(eduBean);
		
		return resultFinal;
	}
	
	/**
	 * this method is used for retrieving streams in database
	 * @throws DataNotFoundException 
	 * @throws DatabaseException 
	 *
	 */
	public List<StreamDTO> getStreamList()throws DataNotFoundException, DatabaseException{
		
		StudentDetailsUpdationServicei streamList=new StudentDetailsUpdationServiceimpl();
		
		return streamList.getStreamList();	
	}
	
	/**
	 * this method is used for retrieving courses
	 * @throws DataNotFoundException 
	 * @throws DatabaseException 
	 *
	 */
	public List<CourseDTO> getCourseList(Integer userId) throws  DataNotFoundException, DatabaseException{
		
		StudentDetailsUpdationServicei courseList=new StudentDetailsUpdationServiceimpl();
		List<CourseDTO> coursesList=courseList.getCourses(userId);
		return coursesList;
		
	}
}

	 


