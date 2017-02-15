/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.nacre.online_assesment.dao_i.ApplyRequesrOpprtunityPostingDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.ApplyRequestOpportunityPostingDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.EligibleDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dao_i.AdminAnalyticsDaoi;
import com.nacre.online_assesment.dao_i.ApplyRequesrOpprtunityPostingDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.AdminAnalyticsDaoimpl;
import com.nacre.online_assesment.dao_i.dao_impl.ApplyRequestOpportunityPostingDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;

import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.ApplyRequestOpportunityPostingsServicei;

/**
 * @author JAY SINGH
 *
 */
public class ApplyRequestOpportunityPostingServiceimpl implements ApplyRequestOpportunityPostingsServicei {
	


	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto
	 * @return Integer eligible_student_Id or null
	 * @throws DatabaseException
	 * @throws SQLException
	 */

	@Override
	public EligibleDTO checkEligibilty(EligibleDTO eDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("hi pavan this in serviceImp");
		Connection con=DbUtil.getConnection();
		ApplyRequesrOpprtunityPostingDaoi applyDao=new  ApplyRequestOpportunityPostingDaoimpl();
		return applyDao.checkEligibilty(eDto, con);
		
		
	}
	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto
	 * @return  if successfully Request sent true return else false return
	 * @throws DatabaseException
	 * @throws SQLException
	 */

	@Override
	public Boolean requestForJob(EligibleDTO eDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("hi pavan this in serviceImp");
		Connection con=DbUtil.getConnection();
		ApplyRequesrOpprtunityPostingDaoi applyDao=new  ApplyRequestOpportunityPostingDaoimpl();
		return applyDao.requestForJob(eDto, con);
	}
	
	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto
	 * @return  if elgible_student successfully apply true return else false return
	 * @throws DatabaseException
	 * @throws SQLException
	 */

	@Override
	public Boolean applyForJob(EligibleDTO eDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("hi pavan this in serviceImp");
		Connection con=DbUtil.getConnection();
		ApplyRequesrOpprtunityPostingDaoi applyDao=new  ApplyRequestOpportunityPostingDaoimpl();
		return applyDao.applyForJob(eDto, con);
	}

	/**
	 * @author JAY SINGH
	 * 
	 * 
	 */

	public List getNotifications() throws DatabaseException {
		//System.out.println("hi Jay Singh this in serviceImp");
		Connection con=DbUtil.getConnection();
		ApplyRequesrOpprtunityPostingDaoi dao=new ApplyRequestOpportunityPostingDaoimpl();
	List l =	dao.getNotifiactions(con);
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return l;
	}
	/**
	 * @author JAY SINGH
	 * @param userId 
	 * @return list
	 */


	public List<Object> getUserDetails(int user_id) throws SQLException,DatabaseException {
		
		//System.out.println("hi Jay Singh this in serviceImp");
		Connection con=DbUtil.getConnection();
		ApplyRequesrOpprtunityPostingDaoi dao=new ApplyRequestOpportunityPostingDaoimpl();
		
		List l =dao.getUserDetails(con,user_id);
		con.close();
		return l;
		
		
	}


}
