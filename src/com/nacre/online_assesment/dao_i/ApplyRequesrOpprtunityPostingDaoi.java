/**
 * 
 */
package com.nacre.online_assesment.dao_i;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.nacre.online_assesment.dto.EligibleDTO;
import java.util.List;

import com.nacre.online_assesment.exception.DatabaseException;



/**
 * @author JAY SINGH 
 *
 */
public interface ApplyRequesrOpprtunityPostingDaoi {

/**
 * @author pavan pratap singh batch-35
 * @param eDto
 * @param con
 * @return Integer eligible_student_Id or null
 * @throws SQLException
 */

	EligibleDTO checkEligibilty(EligibleDTO eDto, Connection con) throws SQLException;
/**
 * @author pavan pratap singh batch-35
 * @param eDto
 * @param con
 * @return if successfully Request sent true return else false return
 * @throws SQLException
 */

	Boolean requestForJob(EligibleDTO eDto, Connection con) throws SQLException;
	/**
	 *@author pavan pratap singh batch-35
	 * @param eDto
	 * @param con
	 * @return if elgible_student successfully apply true return else false return
	 * @throws SQLException
	 */

	Boolean applyForJob(EligibleDTO eDto, Connection con) throws SQLException;

	/**
	 * @author JAY SINGH 
	 * @return List of an Object
	 */
	public List getNotifiactions(Connection con);

	/**
	 * @author jay
	 * @param con
	 * @param user_id
	 * @return
	 * @throws SQLException
	 * @throws DatabaseException
	 */
	List<Object> getUserDetails(Connection con,int user_id) throws SQLException, DatabaseException;

}
