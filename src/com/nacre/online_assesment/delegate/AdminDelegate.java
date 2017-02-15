/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.AdminServicei;
import com.nacre.online_assesment.service_i.AssesmentServicei;
import com.nacre.online_assesment.service_i.CommonServicei;
import com.nacre.online_assesment.service_i.service_impl.AdminServiceimpl;
import com.nacre.online_assesment.service_i.service_impl.AssesmentsServiceimpl;
import com.nacre.online_assesment.service_i.service_impl.CommonServiceimpl;

import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.AdminServicei;
import com.nacre.online_assesment.service_i.service_impl.AdminServiceimpl;



/**
 * @author JAY SINGH
 * This class is to provide admin operations
 */
public class AdminDelegate{
	/**
	 * @author Arvind Kumar
	 * @return int type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public int addAdmin(UserDTO userDTO) throws DatabaseException, SQLException{
		// TODO Auto-generated method stub
		AdminServicei adminServicei=new AdminServiceimpl();
		int count=adminServicei.addAdmin(userDTO);
		return count;
	}
	/**
	 * @author Arvind Kumar
	 * @return int type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public int deleteAdmin(UserDTO userDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei adminServicei=new AdminServiceimpl();
		int count=adminServicei.deleteAdmin(userDto);
		return count;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<String> getAdminRecords(Integer userId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei adminServicei=new AdminServiceimpl();
		List<String> getList=adminServicei.getAdminRecords(userId);
		return getList;
	}
	/**
	 * @author Arvind Kumar
	 * @return int type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public int editAdmin(UserDTO userDTO) throws DatabaseException, DataNotFoundException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei adminServicei=new AdminServiceimpl();
		int count=adminServicei.editAdmin(userDTO);
		return count;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<String> getParticularAdminRecord(Integer userId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei adminServicei=new AdminServiceimpl();
		List<String> getList=adminServicei.getParticularAdminRecord(userId);
		return getList;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<String> viewParticularAdminRecord(Integer userId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei adminServicei=new AdminServiceimpl();
		List<String> viewList=adminServicei.viewParticularAdminRecord(userId);
		return viewList;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<String> getGroupByAdminRecords(Integer roleId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei adminServicei=new AdminServiceimpl();
		List<String> groupList=adminServicei.getGroupByAdminRecords(roleId);
		return groupList;
	}
	/**
	 * @author Arvind Kumar
	 * @return List type variable
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQlException occurs when problem occurs while connecting Query Constants
	 */
	public List<RoleDTO> getRoleByAdmin() throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		AdminServicei adminServicei=new AdminServiceimpl();
		List<RoleDTO> getRole=adminServicei.getRoleByAdmin();
		return getRole;
	}

	public List<CourseDTO> getCourseDetailsForEditAction() throws DatabaseException, SQLException{
		// TODO Auto-generated method stub
		AdminServicei assesmentServicei=new AdminServiceimpl();
		return assesmentServicei.getCourseDetailsForEditAction();
	}

	/**
	 * @author JAY SINGH
	 * @param userid
	 * @return void
	 */

	public void approveStatus(Integer userId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei as=new AdminServiceimpl();
		as.approveStatus( userId);
		
	}
	/**
	 * @author JAY SINGH
	 * @param userid
	 * @return void
	 */

	public void rejectRequest(Integer userId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei as=new AdminServiceimpl();
		as.rejectRequest( userId);
		
	}
	
	/**
	 * @author Swapnil
	 * @return List
	 * @throws SQLException,DatabaseException
	 */
	public List<CourseDTO> getCourse() throws DatabaseException, SQLException{
		// TODO Auto-generated method stub
		AdminServicei assesmentServicei=new AdminServiceimpl();
		return assesmentServicei.getCourse();
	}
	
	/**
	 * @author Swapnil
	 * @param courseDto
     * @return Boolean
	 * @throws SQLException,DatabaseException
	 */
	public Boolean editCourse(CourseDTO courseDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei assesmentServicei=new AdminServiceimpl();
		return assesmentServicei.editCourse(courseDto);
		}
	
	/**
	 * @author Swapnil
	 * @param courseDto
     * @return Integer
	 * @throws SQLException,DatabaseException
	 */
	
	public Integer addCourse(CourseDTO courseDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Start Delegate");
		
		AdminServicei assesmentServicei=new AdminServiceimpl();
		System.out.println("End Delegate Class");
		return assesmentServicei.addCourse(courseDto);
	}
	/**
	 * @author Swapnil
     * @return List
	 * @throws SQLException,DatabaseException
	 */
	public List<TechnologyDTO> getTechnology() throws DatabaseException,SQLException{
	AdminServicei assesmentServicei=new AdminServiceimpl();
	return assesmentServicei.getTechnology();
    }

	/**
	 * @author Swapnil
	 * @param technologyDTO
     * @return Boolean
	 * @throws SQLException,DatabaseException
	 */
	public Integer editTechnology(TechnologyDTO technologyDTO) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei assesmentServicei=new AdminServiceimpl();
		return assesmentServicei.editTechnology(technologyDTO);
	}
	/**
	 * @author Swapnil
	 * @param technologyDTO
     * @return Integer
	 * @throws SQLException,DatabaseException
	 */
	public  Integer addTechnology(TechnologyDTO technologyDTO)throws DatabaseException,SQLException{
		AdminServicei assesmentServicei=new AdminServiceimpl();
		return assesmentServicei.addTechnology(technologyDTO);
	}
	/**
	 * @author Swapnil
	 * @param technologyDTO,courseDto
     * @return Boolean
	 * @throws SQLException,DatabaseException
	 */
	public Boolean addTechnologyCourse(CourseDTO courseDto, TechnologyDTO technologyDTO) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		AdminServicei assesmentServicei=new AdminServiceimpl();
		return assesmentServicei.addTechnologyCourse(courseDto,technologyDTO);
		
	}

	/**
	 * @author Swapnil
	 * @return List
	 * @param technologyId
	 * @throws DatabaseException
	 */
	public List<CourseDTO> getNotAssignCourse(Integer technologyId) throws DatabaseException {
		AdminServicei assesmentServicei=new AdminServiceimpl();
		return assesmentServicei.getNotAssignCourse(technologyId);
	}
			
}
	

