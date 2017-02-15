/**
 * 
 */
package com.nacre.online_assesment.service_i;

import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AddClientManagementBean;
import com.nacre.online_assesment.form_bean.ClientManagementEditBean;
import com.nacre.online_assesment.form_bean.ClientManagementEditContactBean;
import com.nacre.online_assesment.vo.GetExistingClientAddress;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface ClientManagementServicei {
	
	/**
	 * @author  Sonali Chavan b 35
	 * @return List of all clients details Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */

	List<Object> getClientDetails() throws SQLException,DatabaseException;
	
	/**
	 * @author  Saurabh Suman b 35
	 * @return List of particular client details Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */

	List<Object> getClient(Integer clientId)throws SQLException,DatabaseException;
	 
	/**
	 * @author  Saurabh Suman b 35
	 * @return integer type of count of affected row
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */


	int editDetails(ClientManagementEditBean editBean)throws SQLException,DatabaseException;

	/**
	 * @author Sonali Chavan b 35
	 * @return integer no of row affected
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	
	int addClient(AddClientManagementBean addClientManagementBean) throws DatabaseException;

	List<Object> checkClient(String clientName)throws DatabaseException, SQLException;

	int addMoreClientAddress(AddClientManagementBean addClientManagementBean) throws DatabaseException;

	GetExistingClientAddress getClientContactAddress(Integer addressId) throws DatabaseException;
	int editContactDetails(ClientManagementEditContactBean editContactBean)throws DatabaseException, SQLException;
}
