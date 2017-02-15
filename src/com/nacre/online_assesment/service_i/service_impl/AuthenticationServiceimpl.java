/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.nacre.online_assesment.dao_i.AuthenticationDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.AuthenticationDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.exception.InvalidException;
import com.nacre.online_assesment.form_bean.ChangeBean;
import com.nacre.online_assesment.form_bean.LoginBean;
import com.nacre.online_assesment.service_i.AuthenticationServicei;
import com.nacre.online_assesment.util.EmailUtilty;
import com.nacre.online_assesment.util.StringConstants;

/**
 * @author B.Rakesh kumar 
 * @AuthenticationServiseimpl is a class which is providing implementation for the AuthenticationServicei and this 
 * class sends connection and bean object to AuthenticationDaoi for performing operations on the database
 *
 */
public class AuthenticationServiceimpl implements AuthenticationServicei {

	/**
	 * @author B.Rakesh kumar
	 * @param lb Accepts com.nacre.online_assesment.LoginBean
	 * @return userDTO object to get the column's data from the db
	 * @throws InvalidException  occurs when user enters invalid data
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws SQLException occurs when problems when connecting with database
	 */
	@Override
	public UserDTO login(LoginBean lb) throws DatabaseException, SQLException, InvalidException {
		Connection con=DbUtil.getConnection();
		AuthenticationDaoi ado=new AuthenticationDaoimpl();
		return ado.login(con, lb);
		
		
	}
	/**
	 * @author B.Rakesh kumar
	 * @param ForgetBean Accepts com.nacre.online_assesment.ForgetBean
	 * @return userDTO object to get the column's data from the db
	 * @throws SQLException  occurs when problem occurs while connecting with the database
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws DataNotFoundException 
	 */
	@Override
	public Boolean forgetData(String email) throws DatabaseException, SQLException, DataNotFoundException {
		Connection con=DbUtil.getConnection();
		AuthenticationDaoi dao=new AuthenticationDaoimpl();
		String password=dao.forgetdata(con,email);
		con.close();
		
		
		return EmailUtilty.sendEmail(email,StringConstants._FORGOT_PWD_SUBJECT, StringConstants._FORGOT_PWD_MSG+password);
		
	}
	
	/**
	 * @author B.Rakesh kumar
	 * @param ChangeBean Accepts com.nacre.online_assesment.ChangeBean
	 * @return int to know how many columns effected in database
	 * @throws SQLException  occurs when problem occurs while connecting with the database
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	@Override
	public int changeData(ChangeBean cb) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		AuthenticationDaoi dao=new AuthenticationDaoimpl();
		return dao.changedata(con, cb);
	}
	@Override
	public UserDTO informationRetreival(Integer ibean) throws DatabaseException, SQLException, InvalidException {
		Connection con=DbUtil.getConnection();
		AuthenticationDaoi ado=new AuthenticationDaoimpl();
		return ado.informationRetreival(con, ibean);
	}

}
