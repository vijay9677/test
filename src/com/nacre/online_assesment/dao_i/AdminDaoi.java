package com.nacre.online_assesment.dao_i;

import java.sql.Connection;
import java.sql.SQLException;
import com.nacre.online_assesment.form_bean.JobDetailsBean;
import java.util.List;

import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.UserDTO;


public interface AdminDaoi {
		/**
	 * @author Arvind Kumar
	 * @return int type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public int addAdmin(UserDTO userDTO, Connection connection) throws DatabaseException, SQLException;
	
	/**
	 * @author Arvind Kumar
	 * @param  userDto & connection 
	 * @return int type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public int editAdmin(UserDTO userDTO, Connection connection) throws DatabaseException, DataNotFoundException, SQLException;

	/**
	 * @author Arvind Kumar
	 * @return int type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public int deleteAdmin(UserDTO userDto, Connection connection) throws DatabaseException, SQLException;

	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<String> getAdminRecords(Connection connection,Integer userId) throws DatabaseException, SQLException;

	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<String> getParticularAdminRecord(Integer userId, Connection connection) throws DatabaseException, SQLException;

	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<String> viewParticularAdminRecord(Integer userId, Connection connection) throws DatabaseException, SQLException;

	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<String> getGroupByAdminRecords(Integer roleId, Connection connection) throws DatabaseException, SQLException;

	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<RoleDTO> getRoleByAdmin(Connection connection) throws DataNotFoundException,DatabaseException;
/**
 * @author JAY SINGH
 *
 */
	public List<CourseDTO> getCourseDetailsForEditAction(Connection con) throws SQLException;
	
		
	/**
	 * @author JAY SINGH
	 * @param userId
	 * @return void
	 */

	void approveStatus(Integer userId, Connection con) throws SQLException;
	/**
	 * @author JAY SINGH
	 * @param userid
	 * @return void
	 */

	void rejectRequest(Integer userId, Connection con)throws SQLException;
	
   
/**
 * @author Swapnil
 * @param con
 * @return List
 * @throws SQLException
 */
	public List<CourseDTO> getCourse(Connection con) throws SQLException;
	/**
	 * @author Swapnil
	 * @param con,courseDto
	 * @return Integer
	 * @throws SQLException
	 */
	
    public Integer addCourse(Connection con, CourseDTO courseDto) throws SQLException;
/**
 * @author Swapnil
 * @param con,courseDto
 * @return Boolean
 * @throws SQLException
 */

	public Boolean editCourse(Connection con, CourseDTO courseDto) throws SQLException;
	/**
	 * @author Swapnil
	 * @param con
	 * @return List
	 * @throws SQLEXCEPTION
	 */
	public List<TechnologyDTO>getTechnologies(Connection con)throws SQLException;
	/**
	 * @author Swapnil
	 * @param con,technologyDTO
	 * @return Integer
	 * @throws SQLEXCEPTION
	 */
	public Integer addTechnology(Connection con,TechnologyDTO technologyDTO)throws SQLException;
		/**
		 * @author Swapnil
		 * @param con technologyDTO
		 * @return Boolean
		 * @throws SQLEXCEPTION
		 */
		public Integer editTechnology(Connection con,TechnologyDTO technologyDTO)throws SQLException;
		/**
		 * @author Swapnil
		 * @param con ,courseDto,technoloyDto
		 * @return Boolean
		 * @throws SQLException 
		 */
	
	
		public Boolean addTechnologyCourse(Connection con, CourseDTO courseDto,
				TechnologyDTO technologyDTO) throws SQLException;
		//Boolean addTechnologyCourse(Connection con, TechCourseDTO techCOurseDTO) throws SQLException;
		/**
		 * @author Swapnil
		 * @param con,technologyId
		 * @return List
		 * @throws DatabaseException
		 */
		public List getNotAssignCourse(Connection con, Integer technologyId) throws DatabaseException;
		
		 
	}
	



