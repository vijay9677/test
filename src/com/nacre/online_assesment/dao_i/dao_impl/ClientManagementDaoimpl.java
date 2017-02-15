/**
 * 
 */
package com.nacre.online_assesment.dao_i.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.nacre.online_assesment.dao_i.ClientManagementDaoi;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.AddressDTO;
import com.nacre.online_assesment.dto.CityDTO;
import com.nacre.online_assesment.dto.ClientAddressDTO;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.dto.StateDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AddClientManagementBean;
import com.nacre.online_assesment.form_bean.ClientManagementEditBean;
import com.nacre.online_assesment.form_bean.ClientManagementEditContactBean;
import com.nacre.online_assesment.vo.GetExistingClientAddress;

/**
 * @author Vijay Kumar Reddy K
 *
 */

public class ClientManagementDaoimpl implements ClientManagementDaoi {
public ClientManagementDaoimpl() {
System.out.println("in dao");
}



/**
 * @author  Sonali Chavan b 35
 * @return List of all clients details Objects
 * @throws DatabaseException
 *             occurs when problem occurs while connecting with database
 * @throws SQLException
 *             occurs when occurs when Countries are not available
 */
	
	@Override
	public List<Object> getClientDetails(Connection con) throws SQLException, DatabaseException {
		 PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_CLIENT_DETAILS);

		 ResultSet rs = ps.executeQuery();
		 List<Object> list=new ArrayList<Object> ();
		while(rs.next()){
			//System.out.println("client name"+rs.getString(1)+"location"+rs.getString(2)+"description"+rs.getString(3)+"posted date"+rs.getString(4)+"job post id"+rs.getInt(5)+" status"+rs.getInt(6)+"client image"+rs.getString(7)+"client description"+rs.getString(8));
			List list1=new ArrayList();
			
			ClientDTO clientdto=new ClientDTO();
			clientdto.setClientName(rs.getString(1));
			clientdto.setClientId(rs.getInt(8));
			//System.out.println("in dao"+rs.getString(1));
			clientdto.setClientImage(rs.getString(2));
			clientdto.setClientDescription(rs.getString(3));
			/*
			ClientAddressDTO clientAddress=new ClientAddressDTO();
			clientAddress.setContactPresonName(rs.getString(2));
			clientAddress.setContactPresonMobileNO(rs.getString(3));
			clientAddress.setContactPresonNameEmail(rs.getString(4));
		*/
		/*			
			AddressDTO addressdto=new AddressDTO();
			addressdto.setLocation(rs.getString(5));
			addressdto.setPincode(rs.getString(6));*/

			CountryDTO country=new CountryDTO();
			country.setCountry(rs.getString(7));
			
			LevelDTO level=new LevelDTO();
			level.setLevel(rs.getString(6));
			
			CityDTO city=new CityDTO();
			city.setCity(rs.getString(4));
			
			StateDTO state=new StateDTO();
			state.setState(rs.getString(5));
			
			
			list1.add(clientdto);
		/*	list1.add(clientAddress);
			list1.add(addressdto);*/
			list1.add(level);
			list1.add(city);
			list1.add(state);
			list1.add(country);


			
			list.add(list1);
		}
	 return list;

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
	public List<Object> getClient(Integer clientId, Connection con)
			throws SQLException, DatabaseException {
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_CLIENT);
		ps.setInt(1, clientId);
		 ResultSet rs = ps.executeQuery();
		 List<Object> list=new ArrayList<Object> ();
		while(rs.next()){
			//System.out.println("client name"+rs.getString(1)+"location"+rs.getString(2)+"description"+rs.getString(3)+"posted date"+rs.getString(4)+"job post id"+rs.getInt(5)+" status"+rs.getInt(6)+"client image"+rs.getString(7)+"client description"+rs.getString(8));
			List list1=new ArrayList();
			
			ClientDTO clientdto=new ClientDTO();
			clientdto.setClientName(rs.getString(1));
			clientdto.setClientImage(rs.getString(7));
			clientdto.setClientDescription(rs.getString(8));
			
			ClientAddressDTO clientAddress=new ClientAddressDTO();
			clientAddress.setContactPresonName(rs.getString(2));
			clientAddress.setContactPresonMobileNO(rs.getString(3));
			clientAddress.setContactPresonNameEmail(rs.getString(4));
		
					
			AddressDTO addressdto=new AddressDTO();
			addressdto.setLocation(rs.getString(5));
			addressdto.setPincode(rs.getString(6));

			CountryDTO country=new CountryDTO();
			country.setCountry(rs.getString(12));
			country.setCountryId(rs.getInt(13));
			
			LevelDTO level=new LevelDTO();
			level.setLevel(rs.getString(11));
			level.setLevelId(rs.getInt(14));
			
			CityDTO city=new CityDTO();
			city.setCity(rs.getString(9));
			city.setCityId(rs.getInt(16));
			
			StateDTO state=new StateDTO();
			state.setState(rs.getString(10));
			state.setStateId(rs.getInt(14));
			
			
			list1.add(clientdto);
			list1.add(clientAddress);
			list1.add(addressdto);
			list1.add(level);
			list1.add(city);
			list1.add(state);
			list1.add(country);


			
			list.add(list1);
		}
	 return list;
	}
	/**
	 * @author  Saurabh Suman b 35
	 * @return Integer Type of count of affected row 
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */

	@Override
	public int editDetails(ClientManagementEditBean editBean, Connection con)
			throws SQLException, DatabaseException {
		String msg=null;
		
		Integer clientId=editBean.getClientId();
	    String clientName=editBean.getClientName();
		String clientImage=editBean.getClientImage();
		String description=editBean.getDescription();
		Integer levelId=editBean.getCompanyLevel();
	



		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.EDIT_CLIENT);
	
		ps.setString(1, clientName);
		ps.setString(2, clientImage);
		ps.setString(3, description);
		ps.setInt(4, levelId);
		ps.setInt(5, clientId);
        
		int count = ps.executeUpdate();
        return  count;
	}
	
	
	PreparedStatement preparedstatement=null;
	ResultSet resultSet=null;
	boolean insertFlag=false;
	boolean deleteFlag=false;
	int clientId=0;
	int count=0;
	int addressId=0;
	 
	/**
	 * @author Sonali Chavan b 35
	 * @return no of inserted row
	 * @throws DatabaseException 
	 * @throws SQLException 
	 */
	
	
		@Override
	public int addClient(Connection conn,AddClientManagementBean addClientManagementBean) throws DatabaseException {
		
		String clientName=addClientManagementBean.getClientName();
		String image=addClientManagementBean.getCompanyImage();
		String description=addClientManagementBean.getDescription();
		int companyLevelId=addClientManagementBean.getCompanyLevelId();
		String contactPersonName=addClientManagementBean.getContactPersonName();
		String contactPersonMobileNo=addClientManagementBean.getContactPersonMobileNo();
		String contactPersonMail=addClientManagementBean.getContactPersonMail();
		String location=addClientManagementBean.getLocation();
		String pincode=addClientManagementBean.getPincode();
		int cityId=addClientManagementBean.getCityId();
	
		try{
					
			conn.setAutoCommit(false);
			preparedstatement=conn.prepareStatement(SQLQueryConstants.INSERT_CLIENT_DETAILS,Statement.RETURN_GENERATED_KEYS);

			preparedstatement.setString(1, clientName);
			preparedstatement.setString(2, image);
			preparedstatement.setString(3, description);
			preparedstatement.setInt(4, companyLevelId);
			preparedstatement.executeUpdate();
			resultSet =	preparedstatement.getGeneratedKeys();

			if(resultSet.next()){

				clientId=resultSet.getInt(1);
			}
			
			preparedstatement=conn.prepareStatement(SQLQueryConstants.INSERT_CLIENT_ADDRESS_DETAILS,Statement.RETURN_GENERATED_KEYS);
			
			preparedstatement.setString(1, location);
			preparedstatement.setString(2,pincode);
			preparedstatement.setInt(3, cityId);
			preparedstatement.executeUpdate();
			resultSet =	preparedstatement.getGeneratedKeys();
			
			if(resultSet.next()){

				addressId=resultSet.getInt(1);
			}

			preparedstatement=conn.prepareStatement(SQLQueryConstants.INSERT_CLIENT_CONTACT_DETAILS);


			preparedstatement.setInt(1, clientId);
			preparedstatement.setInt(2, addressId);
			preparedstatement.setString(3, contactPersonName);
			preparedstatement.setString(4, contactPersonMobileNo);
			preparedstatement.setString(5, contactPersonMail);
			count=preparedstatement.executeUpdate();
			insertFlag = true;
			return count;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Data Is Not Inserted Successfully");
		}finally{
			if(conn != null){
				if(insertFlag == true){
					try {
						conn.commit();
					} catch (SQLException e) {
						throw  new DatabaseException("Inserted Data Is not Commited Successfully");
					}
				}else{
					try {
						conn.rollback();
					} catch (SQLException e) {

						throw new DatabaseException("Inserted Data is Not SUccessfully RollBack");

					}
				}
			}
			DbUtil.closeConnection(conn);
		}


	}
		/**
		 * @author  Sonali Chavan and Saurabh Suman b 35
		 * @return List of duplicate clients address details Objects
		 * @throws DatabaseException
		 *             occurs when problem occurs while connecting with database
		 * @throws SQLException
		 *             occurs when occurs when Countries are not available
		 */


	@Override
	public List<Object> checkClient(String clientName, Connection con)
			throws DatabaseException, SQLException {
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.CHECK_CLIENT);
		ps.setString(1, clientName);
		 List<Object> list=new ArrayList<Object> ();
		 List<Object> list1=new ArrayList<Object> ();
		int count=0;
		int clientId=0;
		 ResultSet rs1 = ps.executeQuery();
		 while(rs1.next()){
		        count=rs1.getInt(1);
		        clientId=rs1.getInt(2);

		}
		 System.out.println(count);
		 if(count==0){
			 list1.add(count);
		 }
		 else{
			   System.out.println(" in else block");
				PreparedStatement ps1 = con.prepareStatement(SQLQueryConstants.GET_CLIENT);
				ps1.setInt(1, clientId);
				 ResultSet rs = ps1.executeQuery();
				 while(rs.next()){
						//System.out.println("client name"+rs.getString(1)+"location"+rs.getString(2)+"description"+rs.getString(3)+"posted date"+rs.getString(4)+"job post id"+rs.getInt(5)+" status"+rs.getInt(6)+"client image"+rs.getString(7)+"client description"+rs.getString(8));
						
						
						GetExistingClientAddress  client= new GetExistingClientAddress();
						client.setClientId(rs.getInt("client_id"));
						client.setClientName(rs.getString(1));
						client.setContactPresonName(rs.getString(2));
						client.setContactPresonMobileNO(rs.getString(3));
						client.setContactPresonNameEmail(rs.getString(4));
						client.setLocation(rs.getString(5));
						client.setPincode(rs.getString(6));
						client.setCountry(rs.getString(12));		
						client.setCity(rs.getString(9));
						client.setState(rs.getString(10));	
						client.setAddressId(rs.getInt("address_id"));
						
										
						list.add(client);
					}
					list1.add(count);
					list1.add(list);
		 }
		 return list1;
	}
	/**
	 * @author  Sonali Chavan  & Saurabh Suman b 35
	 * @return int type of affected row during inserting more address 
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */


	@Override
	public int addMoreClientAddress(Connection conn,AddClientManagementBean addClientManagementBean)
			throws DatabaseException {
  System.out.println("in dao in method add more client ");	
  String contactPersonName=addClientManagementBean.getContactPersonName();
	String contactPersonMobileNo=addClientManagementBean.getContactPersonMobileNo();
	String contactPersonMail=addClientManagementBean.getContactPersonMail();
	String location=addClientManagementBean.getLocation();
	String pincode=addClientManagementBean.getPincode();
	int cityId=addClientManagementBean.getCityId();
    int clientId=addClientManagementBean.getClientId();
 /* String contactPersonName="mahi1";
 	String contactPersonMobileNo="7875698798";
 	String contactPersonMail="asd@gmail1.com";
 	String location="rtr";
 	String pincode="42410";
 	int cityId=2;
 	int addressId=4;
 	int clientId=1001;
*/
	try{
		
		conn.setAutoCommit(false);
	
		preparedstatement=conn.prepareStatement(SQLQueryConstants.INSERT_CLIENT_ADDRESS_DETAILS,Statement.RETURN_GENERATED_KEYS);
		
		preparedstatement.setString(1, location);
		preparedstatement.setString(2,pincode);
		preparedstatement.setInt(3, cityId);
		preparedstatement.executeUpdate();
		resultSet =	preparedstatement.getGeneratedKeys();
		
		if(resultSet.next()){

			addressId=resultSet.getInt(1);
		}

		preparedstatement=conn.prepareStatement(SQLQueryConstants.INSERT_CLIENTS_MORE_CONTACT_DETAILS);


		preparedstatement.setInt(1, clientId);
		preparedstatement.setInt(2, addressId);
		preparedstatement.setString(3, contactPersonName);
		preparedstatement.setString(4, contactPersonMobileNo);
		preparedstatement.setString(5, contactPersonMail);
		preparedstatement.setString(6, contactPersonMobileNo);
		preparedstatement.setString(7, contactPersonMail);
		count=preparedstatement.executeUpdate();
		insertFlag = true;
		return count;
	} 
	catch (SQLException e) {
		e.printStackTrace();
		throw new DatabaseException("Data Is Not Inserted Successfully");
	}finally{
		if(conn != null){
			if(insertFlag == true){
				try {
					conn.commit();
				} catch (SQLException e) {
					throw  new DatabaseException("Inserted Data Is not Commited Successfully");
				}
			}else{
				try {
					conn.rollback();
				} catch (SQLException e) {

					throw new DatabaseException("Inserted Data is Not SUccessfully RollBack");

				}
			}
		}
		DbUtil.closeConnection(conn);
	}
	}
	/**
	 * @author  Sonali Chavan and Saurabh Suman b 35
	 * @return List of clients address details Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */


	@Override
	public GetExistingClientAddress getClientContactAddress(Connection connection, Integer addressId) throws DatabaseException {
		
		PreparedStatement ps;
		
		GetExistingClientAddress address=new GetExistingClientAddress();
		try {
			ps = connection.prepareStatement(SQLQueryConstants.GET_CLIENT_CONTACT_ADDRESS);
		     ps.setInt(1, addressId);
		     ResultSet rs = ps.executeQuery();
		 
		if(rs.next()){
			
		
			address.setAddressId(rs.getInt("address_id"));
			address.setContactPresonName(rs.getString(1));
			address.setContactPresonMobileNO(rs.getString(2));
			address.setContactPresonNameEmail(rs.getString(3));
			address.setLocation(rs.getString(4));
			address.setPincode(rs.getString(5));
			address.setCity(rs.getString(6));
			address.setState(rs.getString(7));
			address.setCountry(rs.getString(8));
			address.setCountryId(rs.getInt(9));
			address.setStateId(rs.getInt(10));
			address.setCityId(rs.getInt(11));
			
			return address;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseException();
		}
		return address;
		
	}
	/**
	 * @author  Sonali Chavan and Saurabh Suman b 35
	 * @return affected row during Editing contact detail
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */
	@Override
	public int editContactDetails(Connection connection, ClientManagementEditContactBean editContactBean)
			throws DatabaseException, SQLException {
		
		
		Integer addressId=editContactBean.getAddressId();
		Integer pincode=editContactBean.getPincode();
	    String person_name=editContactBean.getConatact_person_name();
		String person_email=editContactBean.getContact_person_Email();
		String person_mobno=editContactBean.getContact_person_mobile_no();
		String location=editContactBean.getLocation();
		Integer cityId=editContactBean.getCityId();



		PreparedStatement ps = connection.prepareStatement(SQLQueryConstants.EDIT_CLIENT_CONTACT);
		ps.setString(1, location);
		ps.setInt(2, pincode);
		ps.setInt(3, cityId);
		ps.setString(4, person_mobno);
		ps.setString(5, person_email);
		ps.setString(6, person_name);
        ps.setInt(7, addressId);



		 int count = ps.executeUpdate();
	     return  count;
	}


}
