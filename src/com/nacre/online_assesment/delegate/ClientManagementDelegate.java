/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AddClientManagementBean;
import com.nacre.online_assesment.form_bean.ClientManagementEditBean;
import com.nacre.online_assesment.form_bean.ClientManagementEditContactBean;
import com.nacre.online_assesment.service_i.ClientManagementServicei;
import com.nacre.online_assesment.service_i.service_impl.ClientManagementServiceimpl;
import com.nacre.online_assesment.vo.GetExistingClientAddress;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class ClientManagementDelegate {

	/**
	 * @author  Sonali Chavan b 35
	 * @return List of all clients details Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */
	public List<Object> getClientDetails() throws SQLException,DatabaseException{

		ClientManagementServicei service= new ClientManagementServiceimpl();
		return service.getClientDetails();

	}

	/**
	 * @author Saurabh Suman b 35
	 * @return List of  particular client details Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */
	public List<Object> getClient(Integer clientId) throws SQLException,DatabaseException{
		ClientManagementServicei service= new ClientManagementServiceimpl();
		return service.getClient(clientId);
	}

	/**
	 * @author  Saurabh Suman b 35
	 * @return integer type of count of affected row 
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */
	public int editDetails(ClientManagementEditBean editBean) throws SQLException,DatabaseException {
		ClientManagementServicei service= new ClientManagementServiceimpl();
		return service.editDetails(editBean);
	}

	ClientManagementServicei clientManagementServicei=null;
	int count=0;
	
	/**
	 * @author Sonali Chavan b 35
	 * @return integer no of row affected
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	public int addClient(AddClientManagementBean addClientManagementBean) throws DatabaseException{
		
		clientManagementServicei=new ClientManagementServiceimpl();
		
			count = clientManagementServicei.addClient(addClientManagementBean);

		return count;
		
		
	}

	public List<Object> checkClient(String clientName) throws DatabaseException, SQLException {
		ClientManagementServicei service= new ClientManagementServiceimpl();
		return service.checkClient(clientName);
	}

	public int addMoreClientAddress(AddClientManagementBean addClientManagementBean) throws DatabaseException {
		clientManagementServicei=new ClientManagementServiceimpl();
		
		count = clientManagementServicei.addMoreClientAddress(addClientManagementBean);

	return count;
	}

	public GetExistingClientAddress getClientContactAddress(Integer addressId) throws DatabaseException {
		// TODO Auto-generated method stub
    
		clientManagementServicei=new ClientManagementServiceimpl();
		return clientManagementServicei.getClientContactAddress(addressId);
	}
	
	public int editContactDetails(ClientManagementEditContactBean editContactBean)throws DatabaseException, SQLException {
		clientManagementServicei=new ClientManagementServiceimpl();
		count = clientManagementServicei.editContactDetails(editContactBean);
        return count;
	}
}
