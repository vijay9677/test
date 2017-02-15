package com.nacre.online_assesment.service_i;

import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;

import com.nacre.online_assesment.dto.TechnologyDTO;

public interface AdminServicei<TechCourseDTO> {
	/**
	 * @author Arvind Kumar.
	 * @return int type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	public int addAdmin(UserDTO userDTO) throws DatabaseException, SQLException;
	/**
	 * @author Arvind Kumar.
	 * @return int type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	public int deleteAdmin(UserDTO userDto) throws DatabaseException, SQLException;
	/**
	 * @author Arvind Kumar.
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	public List<String> getAdminRecords(Integer userId) throws DatabaseException, SQLException;
	/**
	 * @author Arvind Kumar.
	 * @return int type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws DataNotFoundException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	public int editAdmin(UserDTO userDTO) throws DatabaseException, DataNotFoundException, SQLException;
	/**
	 * @author Arvind Kumar.
	 * @param  userId 
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	public List<String> getParticularAdminRecord(Integer userId) throws DatabaseException, SQLException;
	/**
	 * @author Arvind Kumar.
	 * @param  userId 
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	public List<String> viewParticularAdminRecord(Integer userId) throws DatabaseException, SQLException;
	/**
	 * @author Arvind Kumar.
	 * @param  roleId 
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	public List<String> getGroupByAdminRecords(Integer roleId) throws DatabaseException, SQLException;
	/**
	 * @author Arvind Kumar.
	 * @param  roleId 
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	public List<RoleDTO> getRoleByAdmin() throws DatabaseException , DataNotFoundException;
	
	/**
	 * @author JAY SINGH
	 * @param userId for approve
	 */

	List<CourseDTO> getCourseDetailsForEditAction() throws DatabaseException, SQLException;


	void approveStatus(Integer userId) throws DatabaseException, SQLException;
	/**
	 * @author JAY SINGH
	 * @param userId for reject
	 */


	void rejectRequest(Integer userId) throws DatabaseException, SQLException;

	/**
	 * @author Swapnil
     * @return List
	 * @throws SQLException,DatabaseException
	 */
	List<CourseDTO> getCourse() throws DatabaseException, SQLException;
	/**
	 * @author Swapnil
     * @return Boolean
     * @param courseDto
	 * @throws SQLException,DatabaseException
	 */
	Boolean editCourse(CourseDTO courseDto) throws DatabaseException, SQLException;
	/**
	 * @author Swapnil
     * @return Integer
     * @param courseDto
	 * @throws SQLException,DatabaseException
	 */
	Integer addCourse(CourseDTO courseDto) throws DatabaseException, SQLException;
	
	/**
	 * @author Swapnil
     * @return List
	 * @throws SQLException,DatabaseException
	 */
	List<TechnologyDTO> getTechnology() throws DatabaseException, SQLException;
	/**
	 * @author Swapnil
     * @return Boolean
     * @param technologyDTO
	 * @throws SQLException,DatabaseException
	 */
	Integer editTechnology(TechnologyDTO technologyDTO)throws DatabaseException,SQLException;
	/**
	 * @author Swapnil
     * @return Integer
     * @param technologyDTO
	 * @throws SQLException,DatabaseException
	 */
	Integer addTechnology(TechnologyDTO technologyDTO) throws DatabaseException, SQLException;
	/**
	 * @author Swapnil
     * @return Boolean
     * @param technologyDTO,courseDto
	 * @throws SQLException,DatabaseException
	 */
	Boolean addTechnologyCourse(CourseDTO courseDto, TechnologyDTO technologyDTO)throws DatabaseException,SQLException;
	List<CourseDTO> getNotAssignCourse(Integer technologyId) throws DatabaseException;
}
