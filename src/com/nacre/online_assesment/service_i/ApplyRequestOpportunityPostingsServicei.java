/**
 * 
 */
package com.nacre.online_assesment.service_i;

import java.sql.SQLException;

import com.nacre.online_assesment.dto.EligibleDTO;
import com.nacre.online_assesment.exception.DatabaseException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import com.nacre.online_assesment.exception.DatabaseException;

/**
 * @author JAY SINGH
 *
 */
public interface ApplyRequestOpportunityPostingsServicei {
   
	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto
	 * @return Integer eligible_student_Id or null
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	EligibleDTO checkEligibilty(EligibleDTO eDto) throws DatabaseException, SQLException;
	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto
	 * @return  if successfully Request sent true return else false return
	 * @throws DatabaseException
	 * @throws SQLException
	 */

	Boolean requestForJob(EligibleDTO eDto) throws DatabaseException, SQLException;
	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto
	 * @return  if elgible_student successfully apply true return else false return
	 * @throws DatabaseException
	 * @throws SQLException
	 */

	Boolean applyForJob(EligibleDTO eDto) throws DatabaseException, SQLException;

	/**
	 * @author JAY SINGH
	 * @param 
	 * @return list
	 */
	public List getNotifications() throws DatabaseException;
	/**
	 * @author JAY SINGH
	 *@param userid
	 *@return list
	 */

	public List<Object> getUserDetails(int user_id) throws DatabaseException, SQLException; 
	

}
