/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import com.nacre.online_assesment.dao_i.dao_impl.AdminDaoimpl;
import java.util.List;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobDetailsBean;

import com.nacre.online_assesment.dao_i.AdminDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.AdminDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.AdminServicei;

/**
 * @author JAY SINGH
 *
 */
public class AdminServiceimpl implements AdminServicei {

	/**
	 * @author Arvind Kumar
	 * @return int type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constant
	 */
	@Override
	public int addAdmin(UserDTO userDTO) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminDaoi adminDaoi=new AdminDaoimpl();
		Connection connection=DbUtil.getConnection();
		int count=adminDaoi.addAdmin(userDTO,connection);
		DbUtil.closeConnection(connection);
		return count;
	}
	/**
	 * @author Arvind Kumar
	 * @return int type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constant
	 * 
	 */
	@Override
	public int editAdmin(UserDTO userDTO) throws DatabaseException, DataNotFoundException, SQLException {
		// TODO Auto-generated method stub
		AdminDaoi adminDaoi=new AdminDaoimpl();
		Connection connection=DbUtil.getConnection();
		int count=adminDaoi.editAdmin(userDTO,connection);
		DbUtil.closeConnection(connection);
		return count;
	}
	/**
	 * @author Arvind Kumar
	 * @return int type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	
	@Override
	public int deleteAdmin(UserDTO userDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminDaoi adminDaoi=new AdminDaoimpl();
		Connection connection=DbUtil.getConnection();
		int count=adminDaoi.deleteAdmin(userDto,connection);
		DbUtil.closeConnection(connection);
		return count;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	@Override
	public List<String> getAdminRecords(Integer userId) throws DatabaseException,	SQLException {
		// TODO Auto-generated method stub
		AdminDaoi adminDaoi=new AdminDaoimpl();
		Connection connection=DbUtil.getConnection();
		List<String> getList=adminDaoi.getAdminRecords(connection,userId);
		DbUtil.closeConnection(connection);
		return getList;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	@Override
	public List<String> getParticularAdminRecord(Integer userId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminDaoi adminDaoi=new AdminDaoimpl();
		Connection connection=DbUtil.getConnection();
		List<String> getList=adminDaoi.getParticularAdminRecord(userId,connection);
		DbUtil.closeConnection(connection);
		return getList;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	@Override
	public List<String> viewParticularAdminRecord(Integer userId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminDaoi adminDaoi=new AdminDaoimpl();
		Connection connection=DbUtil.getConnection();
		List<String> viewList=adminDaoi.viewParticularAdminRecord(userId,connection);
		DbUtil.closeConnection(connection);
		return viewList;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	@Override
	public List<String> getGroupByAdminRecords(Integer roleId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminDaoi adminDaoi=new AdminDaoimpl();
		Connection connection=DbUtil.getConnection();
		List<String> groupList=adminDaoi.getGroupByAdminRecords(roleId, connection);
		DbUtil.closeConnection(connection);
		return groupList;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	@Override
	public List<RoleDTO> getRoleByAdmin() throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		AdminDaoi adminDaoi=new AdminDaoimpl();
		Connection connection=DbUtil.getConnection();
		List<RoleDTO> getRole=adminDaoi.getRoleByAdmin(connection);
		DbUtil.closeConnection(connection);
		return getRole;
	}

	/**
	 * @author JAY SINGH
	 * @param userId
	 * @return void
	 */
	
	@Override
	public void approveStatus(Integer userId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adao=new AdminDaoimpl();
		adao.approveStatus(userId,con);
		
	}
	/**
	 * @author JAY SINGH
	 * @param userId
	 * @return void
	 */
	
	@Override
	public void rejectRequest(Integer userId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adao=new AdminDaoimpl();
		adao.rejectRequest(userId,con);
		
	}

	@Override
	public List<CourseDTO> getCourseDetailsForEditAction() throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adminDao=new AdminDaoimpl();
		return adminDao.getCourseDetailsForEditAction(con);
		
	}
	/**
	 * @author Swapnil
	 * @return list
	 * @throws DatabaseException SQLException
	 */
	@Override
	public List<CourseDTO> getCourse() throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adminDao=new AdminDaoimpl();
		return adminDao.getCourse(con);
		
	}

	/**
	 * @author Swapnil
	 * @return Boolean
	 * @param courseDto
	 * @throws DatabaseException SQLException
	 */
	@Override
	public Boolean editCourse(CourseDTO courseDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adminDao=new AdminDaoimpl();
		return adminDao.editCourse(con,courseDto);
	}
	/**
	 * @author Swapnil
	 * @return Integer
	 * @param courseDto
	 * @throws DatabaseException SQLException
	 */
	@Override
	public Integer addCourse(CourseDTO courseDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adminDao=new AdminDaoimpl();
		return adminDao.addCourse(con,courseDto);
	}
	/**
	 * @author Swapnil
	 * @return List
	 * @throws DatabaseException SQLException
	 */
	@Override
	public List<TechnologyDTO> getTechnology() throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adminDao=new AdminDaoimpl();
		return adminDao.getTechnologies(con);
	}
	/**
	 * @author Swapnil
	 * @return  Boolean
	 * @param technologyDTO
	 * @throws DatabaseException SQLException
	 */
	@Override
	public Integer editTechnology(TechnologyDTO technologyDTO) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adminDao=new AdminDaoimpl();
		return adminDao.editTechnology(con,technologyDTO);
	}
	/**
	 * @author Swapnil
	 * @return   Integer
	 * @param technologyDTO
	 * @throws DatabaseException SQLException
	 */
	@Override
	public Integer addTechnology(TechnologyDTO technologyDTO) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adminDao=new AdminDaoimpl();
		return adminDao.addTechnology(con, technologyDTO);
	}
	/**
	 * @author Swapnil
	 * @return   Boolean
	 * @param courseDto technologyDTO
	 * @throws DatabaseException SQLException
	 */
	@Override
	public Boolean addTechnologyCourse(CourseDTO courseDto, TechnologyDTO technologyDTO)
			throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AdminDaoi adminDao=new AdminDaoimpl();
		return adminDao.addTechnologyCourse(con,courseDto,technologyDTO);
	}
	/**
	 * @author Swapnil
	 * @return List
	 * @param technologyDTO
	 * @throws DatabaseException
	 */
	@Override
	public List getNotAssignCourse(Integer technologyId) throws DatabaseException {
		Connection con=DbUtil.getConnection();
		AdminDaoi adminDao=new AdminDaoimpl();
		return adminDao.getNotAssignCourse(con,technologyId);
	}

}
