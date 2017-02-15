/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.sql.SQLException;

import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.exception.InvalidException;
import com.nacre.online_assesment.form_bean.ChangeBean;
import com.nacre.online_assesment.form_bean.LoginBean;
import com.nacre.online_assesment.service_i.AuthenticationServicei;
import com.nacre.online_assesment.service_i.service_impl.AuthenticationServiceimpl;

/**
 * @author B.Rakesh kumar
 * @AuthenticationDeligate is a class which is used to deligate the request to Service and takes the response 
 * from Service and deligates to the Action.
 *
 */
public class AuthenticationDelegate {
	
	public AuthenticationDelegate() {
System.out.println("in delegate");	
}
        
	/**
	 * @author B.Rakesh kumar
	 * @param lb Accepts com.nacre.online_assesment.LoginBean
	 * @return userDTO object to get the column's data from the db
	 * @throws InvalidException  occurs when user enters invalid data
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws SQLException occurs when problems when connecting with database
	 */
	public UserDTO login(LoginBean lb) throws DatabaseException, SQLException, InvalidException
	{
		System.out.println("service email"+lb.getEmail());
		System.out.println("service password"+lb.getPassword());
		 AuthenticationServicei asi=new  AuthenticationServiceimpl();
		 return asi.login(lb);
	}


	/**
	 * @author B.Rakesh kumar
	 * @param fbean Accepts com.nacre.online_assesment.ForgetBean
	 * @return userDTO object to get the column's data from the db
	 * @throws SQLException  occurs when problem occurs while connecting with the database
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws DataNotFoundException 
	 */
	public Boolean forgetData(String email) throws DatabaseException, SQLException, DataNotFoundException {
		// TODO Auto-generated method stub
		AuthenticationServicei asi=new AuthenticationServiceimpl();
		
		return asi.forgetData(email);
	}
	
	
	/**
	 * @author B.Rakesh kumar
	 * @param cb Accepts com.nacre.online_assesment.ChangeBean
	 * @return int to know how many columns effected in database
	 * @throws SQLException  occurs when problem occurs while connecting with the database
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public int changeData(ChangeBean cb) throws SQLException, DatabaseException
	{
	AuthenticationServicei asi=new AuthenticationServiceimpl();
			return asi.changeData(cb);
			
	
	}
	public UserDTO informationRetreival(Integer ibean) throws DatabaseException, SQLException, InvalidException
	{
		 AuthenticationServicei asi=new  AuthenticationServiceimpl();
		 return asi.informationRetreival(ibean);
		
		
	}


}
