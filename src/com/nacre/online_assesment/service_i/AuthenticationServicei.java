/**
 * 
 */
package com.nacre.online_assesment.service_i;

import java.sql.SQLException;

import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.exception.InvalidException;
import com.nacre.online_assesment.form_bean.ChangeBean;
import com.nacre.online_assesment.form_bean.LoginBean;

/**
 * @author B.Rakesh Kumar
 * @AuthenticationServicei is the interface whose implementation is provided in the class AuthenticationServiceimpl
 * which is used to write the business logic
 *
 */
public interface AuthenticationServicei {
	/**
	 * @author B.Rakesh kumar
	 * @param lb Accepts com.nacre.online_assesment.LoginBean
	 * @return UserDTO contains all columns data retreived from database
	 * @throws InvalidException occurs when user enters invalid data
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws SQLException  occurs when problem occurs in connecting with database 
	 */

	public UserDTO login(LoginBean lb) throws DatabaseException, SQLException, InvalidException;
	
	/**
	 * @author B.Rakesh kumar
	 * @param fbean Accepts com.nacre.online_assesment.ForgetBean
	 * @return UserDTO contains all columns data retreived from database
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws SQLException  occurs when problem occurs in connecting with database 
	 * @throws DataNotFoundException 
	 */
	public Boolean forgetData(String email) throws DatabaseException, SQLException, DataNotFoundException;
    
	/**
	 * @author B.Rakesh kumar
	 * @param cb Accepts com.nacre.online_assesment.ChangeBean
	 * @return int to know no of rows effected in database
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws SQLException  occurs when problem occurs in connecting with database 
	 */
	public int changeData(ChangeBean cb) throws DatabaseException, SQLException;

	public UserDTO informationRetreival(Integer ibean) throws DatabaseException, SQLException, InvalidException;


}
