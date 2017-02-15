/**
 * 
 */
package com.nacre.online_assesment.dao_i;

import java.sql.Connection;
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
public interface ClientManagementDaoi {

	List<Object> getClientDetails(Connection con) throws SQLException, DatabaseException;

	List<Object> getClient(Integer clientId, Connection con)throws SQLException, DatabaseException;

	int editDetails(ClientManagementEditBean editBean, Connection con)throws SQLException, DatabaseException;
	

	/**
	 * @author Sonali Chavan b 35
	 * @param con Accepts java.sql.Connection
	 * @return integer of affected row
	 * @throws DataNotFoundException occurs when no object is available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
int addClient(Connection connection, AddClientManagementBean addClientManagementBean) throws DatabaseException;

	List<Object> checkClient(String clientName, Connection con)throws DatabaseException, SQLException;

	int addMoreClientAddress(Connection connection,AddClientManagementBean addClientManagementBean)throws DatabaseException;

	GetExistingClientAddress getClientContactAddress(Connection connection, Integer addressId) throws DatabaseException;
	int editContactDetails(Connection connection, ClientManagementEditContactBean editContactBean)throws DatabaseException, SQLException;
}
