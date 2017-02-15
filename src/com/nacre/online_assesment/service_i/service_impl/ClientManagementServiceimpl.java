/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dao_i.ClientManagementDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.ClientManagementDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AddClientManagementBean;
import com.nacre.online_assesment.form_bean.ClientManagementEditBean;
import com.nacre.online_assesment.form_bean.ClientManagementEditContactBean;
import com.nacre.online_assesment.service_i.ClientManagementServicei;
import com.nacre.online_assesment.vo.GetExistingClientAddress;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ClientManagementServiceimpl implements ClientManagementServicei {
	
	
	/**
	 * @author  Sonali Chavan b 35
	 * @return List of all clients details Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */

	@Override
	public List<Object> getClientDetails() throws SQLException, DatabaseException {

		ClientManagementDaoi dao=new ClientManagementDaoimpl();
		Connection con=DbUtil.getConnection();
		return dao.getClientDetails(con);
		 
	}
	
	
	/**
	 * @author  Saurabh Suman b 35
	 * @return List of particular clients details Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */

	@Override
	public List<Object> getClient(Integer clientId) throws SQLException,
			DatabaseException {
		ClientManagementDaoi dao=new ClientManagementDaoimpl();
		Connection con=DbUtil.getConnection();
		return dao.getClient(clientId,con);
		 
	}
	
	/**
	 * @author  Saurabh Suman b 35
	 * @return Integer type of count of affected row
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */

	@Override
	public int editDetails(ClientManagementEditBean editBean) throws SQLException,
			DatabaseException {
		ClientManagementDaoi dao=new ClientManagementDaoimpl();
		Connection con=DbUtil.getConnection();
		return dao.editDetails(editBean,con);
	}
	
	
	ClientManagementDaoi clientManagement=null;
	Connection connection=null;
	
	/**
	 * @author Sonali Chavan b 35
	 * @return integer no of row affected
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	@Override
	public int addClient(AddClientManagementBean addClientManagementBean) throws DatabaseException{
		connection=DbUtil.getConnection();
		clientManagement=new ClientManagementDaoimpl();
		int count=clientManagement.addClient(connection,addClientManagementBean);
		return count ;

	}


	@Override
	public List<Object> checkClient(String clientName) throws DatabaseException, SQLException {
		ClientManagementDaoi dao=new ClientManagementDaoimpl();
		Connection con=DbUtil.getConnection();
		return dao.checkClient(clientName,con);
	}


	@Override
	public int addMoreClientAddress(AddClientManagementBean addClientManagementBean)  throws DatabaseException{
		connection=DbUtil.getConnection();
		clientManagement=new ClientManagementDaoimpl();
		int count=clientManagement.addMoreClientAddress(connection,addClientManagementBean);
		return count ;
	}


	@Override
	public GetExistingClientAddress getClientContactAddress(Integer addressId) throws DatabaseException {
		// TODO Auto-generated method stub
		connection=DbUtil.getConnection();
		clientManagement=new ClientManagementDaoimpl();
		return clientManagement.getClientContactAddress(connection,addressId);
	}
	
	@Override
	public int editContactDetails(ClientManagementEditContactBean editContactBean)
			throws DatabaseException, SQLException {
		connection=DbUtil.getConnection();
		clientManagement=new ClientManagementDaoimpl();
		int count=clientManagement.editContactDetails(connection,editContactBean);
		return count ;
	}

}
