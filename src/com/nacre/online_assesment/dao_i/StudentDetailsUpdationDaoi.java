package com.nacre.online_assesment.dao_i;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.PersonalDetailsBean;
import com.nacre.online_assesment.form_bean.StudentCoursesBean;
import com.nacre.online_assesment.form_bean.StudentEducationBean;

public interface StudentDetailsUpdationDaoi {


	/**
	 * this method is used to get student profile
	 *
	 * @param  It requires user_id and connection object 
	 * 
	 * @return stream list that contains personal details , educational details and courses details 
	 */
	public List getStudentProfile(Integer userId, Connection con) throws DatabaseException,SQLException;
	
	
	/**
	 * this method is used to update student personal profile
	 * 
	 * @param  It requires student personal details, educational details
	 *
	 */
	public Integer updateStudentProfile(PersonalDetailsBean pdb,Connection con) throws DatabaseException,SQLException;
	
	/**
	 * this method is used to update student post graduation details
	 *
	 */
	public Integer updateStudentPostGradDetails(StudentEducationBean eduBean,Connection con) throws DatabaseException,SQLException;
	
	/**
	 * this method is used to get streams
	 *@return stream list that contains streams
	 *
	 */
	public List<StreamDTO> getStreamList(Connection con)throws DataNotFoundException, DatabaseException;
	
	/**
	 * this method is used to get all the courses
	 * 
	 *@param  It requires user_id to get the courses of user and connection object
	 *
	 * @return stream list that contains all the courses of user
	 */
	public List<CourseDTO> getCourses(Integer userId,Connection con)throws DataNotFoundException, DatabaseException;


	/**
	 * this method is used to update courses
	 * 
	 *@param  It requires user_id , connection object and courses list
	 */
	public void updateStudentCourses(List<CourseDTO> list,Integer userId, Connection con)throws DatabaseException,SQLException;;


}
