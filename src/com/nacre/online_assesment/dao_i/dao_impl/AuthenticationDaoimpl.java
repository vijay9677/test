/**
 * 
 */
package com.nacre.online_assesment.dao_i.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nacre.online_assesment.dao_i.AuthenticationDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.AddressDTO;
import com.nacre.online_assesment.dto.BatchDTO;
import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.StatusDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.exception.InvalidException;
import com.nacre.online_assesment.form_bean.ChangeBean;
import com.nacre.online_assesment.form_bean.LoginBean;
import com.nacre.online_assesment.test.MyEmailValidate;
import com.nacre.online_assesment.util.ErrorMessages;

/**
 * @author B.Rakesh kumar
 * @AuthenticationDaoimpl is a class  used to connect with the database and retreive the values from the database. 
 *
 */
public class AuthenticationDaoimpl implements AuthenticationDaoi {

	/**
	 * @author B.Rakesh kumar
	 * @param con,lb Accepts java.sql.connection,com.nacre.online_assesment.LoginBean
	 * @return userDTO object to get the column's data from the db
	 * @throws InvalidException  occurs when user enters invalid data
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws SQLException occurs when problems when connecting with database
	 */
	@Override
	public UserDTO login(Connection con, LoginBean lb) throws SQLException, DatabaseException, InvalidException {
		// TODO Auto-generated method stub
		
		PreparedStatement pst =null; 
		boolean isEmail= MyEmailValidate.validateEmailAddress(lb.getEmail());
			if(isEmail==true){
				pst= con.prepareStatement(SQLQueryConstants.DATA_RETREIVAL_QRY_LOGIN);
			}else{
				pst=con.prepareStatement(SQLQueryConstants.DATA_RETREIVAL_QRY_LOGIN_USING_MOBILE);
				
			}
		
		pst.setString(1, lb.getEmail());
		pst.setString(2, lb.getPassword());
		ResultSet rs=pst.executeQuery();
		if (rs != null) 
		{
			if (rs.next()) 
			{
				UserDTO rd=new UserDTO();
				
				rd.setUserid(rs.getInt(1));
				rd.setFirstname(rs.getString(2));
				rd.setLastname(rs.getString(3));
				rd.setEmail(rs.getString(4));
				rd.setPassword(rs.getString(5));
				rd.setMobileNo(rs.getString(6));
				rd.setGender(rs.getInt(7));
				rd.setImage(rs.getString(8));
				rd.setDate(rs.getDate(9));
				rd.setIsNacre(rs.getInt(10));
				RoleDTO rd1=new RoleDTO();
				System.out.println(rs.getString(11));
				rd1.setRoleId(rs.getInt(11));
				rd1.setRole(rs.getString(16));
				System.out.println(rd1);
				rd.setRole(rd1);
				
				
				return rd;
			}else
			{
				throw new InvalidException(ErrorMessages._ERR_INVALID_LOGIN);
				
			}
		} else
		    {
				throw new DatabaseException(ErrorMessages._ERR_DB_CON);
				
			}
		
		

}
	 /**
		 * @author B.Rakesh kumar
		 * @param con,fbean Accepts java.sql.connection,com.nacre.online_assesment.ForgetBean
		 * @return userDTO object to get the column's data from the db
		 * @throws SQLException  occurs when problem occurs while connecting with the database
		 * @throws DatabaseException occurs when problem occurs while interacting with  database
		 */
	@Override
	public String forgetdata(Connection con,String email) throws SQLException, DatabaseException,DataNotFoundException {
		
		PreparedStatement pst=con.prepareStatement(SQLQueryConstants.QRY_TO_RETREIVE_FIRSTNAME__PASSWORD);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		
		if (rs != null) {
			if (rs.next()) {
			
				return 	rs.getString(2);
			}else{
				
				throw new DataNotFoundException();
			}
		} else {
			System.out.println("ResultSet have No records");
			throw new DatabaseException("Record not Found");
		}


	}
	/**
	 * @author B.Rakesh kumar
	 * @param con,cb Accepts java.sql.connection,com.nacre.online_assesment.ChangeBean
	 * @return int to know how many columns effected in database
	 * @throws SQLException  occurs when problem occurs while connecting with the database
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	@Override
	public int changedata(Connection con, ChangeBean cb) throws SQLException {
		// TODO Auto-generated method stub
		String sql=null;
		boolean isEmail= MyEmailValidate.validateEmailAddress(cb.getEmail());
		if(isEmail==true){
		 sql=SQLQueryConstants.QRY_TO_UPDATE_PASSWORD;
		}else
		{
			sql=SQLQueryConstants.QRY_TO_UPDATE_PASSWORD_USING_MOBILE;
		}
		String email= cb.getEmail();
		String oldpassword=cb.getOldPassword();
		String newpassword=cb.getNewPassword();
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,newpassword);
		pst.setString(2,email);
		pst.setString(3,oldpassword);
		int rs=pst.executeUpdate();
		return rs;
		
	}
	@Override
	public UserDTO informationRetreival(Connection con, Integer id) throws SQLException, InvalidException, DatabaseException {
		System.out.println("in dao method");
		PreparedStatement pst=con.prepareStatement(SQLQueryConstants.INFORMATION_RETREIVAL);
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		if (rs != null) 
		{
			if (rs.next()) 
			{
				UserDTO rd=new UserDTO();
				
				rd.setUserid(rs.getInt(1));
				rd.setFirstname(rs.getString(2));
				rd.setLastname(rs.getString(3));
				rd.setEmail(rs.getString(4));
				rd.setPassword(rs.getString(5));
				rd.setMobileNo(rs.getString(6));
				rd.setGender(rs.getInt(7));
				rd.setImage(rs.getString(8));
				rd.setDate(rs.getDate(9));
				rd.setIsNacre(rs.getInt(10));
				RoleDTO rd1=new RoleDTO();
				System.out.println(rs.getInt(11));
				rd1.setRoleId(rs.getInt(11));
				rd.setRole(rd1);
				AddressDTO ado=new AddressDTO();
				System.out.println(rs.getInt(12));
				ado.setAddressId(rs.getInt(12));
				rd.setAddress(ado);
				StatusDTO sdo=new StatusDTO();
				System.out.println(rs.getInt(13));
				sdo.setStatusId(rs.getInt(13));
				rd.setStatus(sdo);
				 BatchDTO bd=new BatchDTO();
				 System.out.println(rs.getInt(14));
				 bd.setBatchId(rs.getInt(14));
				 rd.setBatch(bd);
				 TechnologyDTO tdo=new TechnologyDTO();
				 System.out.println(rs.getInt(15));
				 tdo.setTechnologyId(rs.getInt(15));
				 rd.setTechnology(tdo);
				 return rd;
			}else
			{
				throw new InvalidException("some thing went wrong ");
			}
		}else
		{
			throw new DatabaseException("Exception occured while connecting with the database");
		}
				 
				
		
		
		
	}
}
