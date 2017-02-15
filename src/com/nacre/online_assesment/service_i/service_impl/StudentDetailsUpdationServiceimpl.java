/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dao_i.StudentDetailsUpdationDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.StudentDetailsUpdationDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.PersonalDetailsBean;
import com.nacre.online_assesment.form_bean.StudentCoursesBean;
import com.nacre.online_assesment.form_bean.StudentEducationBean;
import com.nacre.online_assesment.service_i.StudentDetailsUpdationServicei;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StudentDetailsUpdationServiceimpl implements StudentDetailsUpdationServicei {

	
	@Override
	public List getStudentProfile(Integer uid) throws DatabaseException,SQLException {
		
		Connection con=DbUtil.getConnection();
		StudentDetailsUpdationDaoi sdu=new StudentDetailsUpdationDaoimpl();
        List list=sdu.getStudentProfile(uid,con);
		return list;
	}

	@Override
	public Integer updateStudentProfile(PersonalDetailsBean pdb)
			throws DatabaseException, SQLException {
		
		Connection con=DbUtil.getConnection();
		StudentDetailsUpdationDaoi sdu1=new StudentDetailsUpdationDaoimpl();
		Integer result=sdu1.updateStudentProfile(pdb, con);
		return result; 
	}

	@Override
	public Integer updateStudentPostGradDetails(StudentEducationBean eduBean)
			throws DatabaseException, SQLException {
		
		Connection con=DbUtil.getConnection();
		StudentDetailsUpdationDaoi studentEduPost=new StudentDetailsUpdationDaoimpl();
		Integer resultFinal=studentEduPost.updateStudentPostGradDetails(eduBean, con);
		return resultFinal;
	}

	@Override
	public List<StreamDTO> getStreamList() throws DataNotFoundException,
			DatabaseException {
         
		Connection con=DbUtil.getConnection();
		StudentDetailsUpdationDaoi sdu=new StudentDetailsUpdationDaoimpl();
        List list=sdu.getStreamList(con);
        return list;
	}

	@Override
	public List<CourseDTO> getCourses(Integer userId)
			throws DataNotFoundException, DatabaseException {

		Connection con=DbUtil.getConnection();
		StudentDetailsUpdationDaoi sdu=new StudentDetailsUpdationDaoimpl();
		List<CourseDTO> coursesList=sdu.getCourses(userId,con);
        return coursesList;
	}

	@Override
	public void updateStudentCourses(List<CourseDTO> list, Integer userId)
			throws SQLException, DatabaseException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		StudentDetailsUpdationDaoi sdu=new StudentDetailsUpdationDaoimpl();
		sdu.updateStudentCourses(list,userId, con);
	}
}
