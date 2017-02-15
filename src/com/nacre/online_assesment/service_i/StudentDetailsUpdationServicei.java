/**
 * 
 */
package com.nacre.online_assesment.service_i;

import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.PersonalDetailsBean;
import com.nacre.online_assesment.form_bean.StudentCoursesBean;
import com.nacre.online_assesment.form_bean.StudentEducationBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface StudentDetailsUpdationServicei {

	
	/**
	 * this method is used to get student profile
	 * @param  It requires user_id to get the details of user
	 * @return stream list that contains personal details, educational details and courses details
	 *
	 */
	public List getStudentProfile(Integer uid) throws DatabaseException,SQLException;

	
	
	/**
	 * this method is used to update student profile
	 * @param  It requires personal details and educational details
	 *
	 */
	public Integer updateStudentProfile(PersonalDetailsBean pdb) throws DatabaseException,SQLException;
	
	

	/**
	 * this method is used to update student post graduation details
	 * @param  It requires student post graduation details
	 *
	 */
	public Integer updateStudentPostGradDetails(StudentEducationBean eduBean) throws DatabaseException,SQLException;
	
	/**
	 * this method is used to get steams
	 * @return stream list
	 *
	 */
	public List<StreamDTO> getStreamList()throws DataNotFoundException, DatabaseException;
	
	/**
	 * this method is used to get all the courses 
	 *@return courses list
	 *
	 */
	public List<CourseDTO> getCourses(Integer userId)throws DataNotFoundException, DatabaseException;


	/**
	 * this method is used to update student courses 
	 * @param it requires courses list and user_id
	 *
	 */

	public void updateStudentCourses(List<CourseDTO> list,Integer userId)throws SQLException, DatabaseException;;
	
}
