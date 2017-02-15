/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dao_i.StudentRequestFeedbackDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.StudentRequestFeedbackDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.FeedbackTypeDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ClientAddressBean;
import com.nacre.online_assesment.service_i.StudentRequestFeedbackServicei;
import com.nacre.online_assesment.vo.GetCompanyFeebacksVo;
import com.nacre.online_assesment.vo.GetOrganisationFeedbacksVo;
import com.nacre.online_assesment.vo.ViewAllFeedbacksVo;


/**
 * StudentRequestFeedbackServiceimpl.java
 * class that has the following methods with implementations 
 * @author Amarendar Guthuru
 * @since 30-08-2016
 */
public class StudentRequestFeedbackServiceimpl implements StudentRequestFeedbackServicei {
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return FeedbackTypeDTO
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if feedback type data not found in the DB
	 * Getting connection object from DbUtil class through getConnection method
    */
	
	
	
	@Override
	public List<FeedbackTypeDTO> getFeedbackType() throws DatabaseException, SQLException, DataNotFoundException {
		Connection con;
		con=DbUtil.getConnection();
		StudentRequestFeedbackDaoi daoi=new StudentRequestFeedbackDaoimpl();
		
		return daoi.getFeedbackType(con);
	}
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return ClientDTO
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if Company data not found in the DB
	 * Getting connection object from DbUtil class through getConnection method
    */

	@Override
	public List<ClientDTO> getCompany() throws DatabaseException, SQLException, DataNotFoundException {
		// TODO Auto-generated method stub
		Connection con;
		con=DbUtil.getConnection();
		StudentRequestFeedbackDaoi daoi=new StudentRequestFeedbackDaoimpl();
		return daoi.getCompany(con);
	}
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return ClientAddressBean
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if CompanyAddress data not found in the DB
	 * Getting connection object from DbUtil class through getConnection method
    */
	@Override
	public List<ClientAddressBean> getCompanyAddress(Integer clientId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con;
		con=DbUtil.getConnection();
		StudentRequestFeedbackDaoi daoi=new StudentRequestFeedbackDaoimpl();
		return daoi.getCompanyAddress(con, clientId);
	}
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return ClientAddressBean
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if locality is not available  in the DB
	 * Getting connection object from DbUtil class through getConnection method
    */

	@Override
	public List<ClientAddressBean> getClientLocality(Integer cityId,Integer clientId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con;
		con=DbUtil.getConnection();
		StudentRequestFeedbackDaoi daoi=new StudentRequestFeedbackDaoimpl();
		return daoi.getClientLocality(con, cityId,clientId);
	}
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return clientaddressId 
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if clientaddressId data not found in the DB
	 * Getting connection object from DbUtil class through getConnection method
    */
	@Override
	public int getClientAddressId(Integer clientid, Integer addressid) throws DatabaseException, SQLException, DataNotFoundException {
		// TODO Auto-generated method stub
		Connection con;
		con=DbUtil.getConnection();
		StudentRequestFeedbackDaoi daoi=new StudentRequestFeedbackDaoimpl();
		
		return daoi.getClientAddressId(con,clientid,addressid);
	}
	
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return 1 if feedback inserted successfully else it returns 0
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * Getting connection object from DbUtil class through getConnection method
    */

	@Override
	public int saveFeedBackTable(String message, Integer feedbacktypeid, Integer userid, Integer clientaddreesid) throws DatabaseException, SQLException {
		Connection con;
		con=DbUtil.getConnection();
		StudentRequestFeedbackDaoi daoi=new StudentRequestFeedbackDaoimpl();
		
		 return daoi.saveFeedBackTable(con,message,feedbacktypeid,userid,clientaddreesid);
		 
		
	}
	

	
	
	
	/**@throws DatabaseException 
	 * @throws SQLException 
	 * @ Amarendar Guthuru
	 * (non-Javadoc)
	 * @see com.nacre.online_assesment.service_i.StudentRequestFeedbackServicei#getAllFeedbacks()
	 */
	
	@Override
	public List<ViewAllFeedbacksVo> getAllFeedbacks() throws DatabaseException, SQLException {
		
		
		Connection con=DbUtil.getConnection();
		StudentRequestFeedbackDaoi daoi=new StudentRequestFeedbackDaoimpl();
		
		// TODO Auto-generated method stub
		return daoi.getAllFeedbacks(con);
	}
	@Override
	public List<GetOrganisationFeedbacksVo> getAllOrganisationFeedbacks(Integer organisationId) throws DatabaseException, SQLException {
		Connection con=DbUtil.getConnection();
		StudentRequestFeedbackDaoi daoi=new StudentRequestFeedbackDaoimpl();
		// TODO Auto-generated method stub
		return daoi.getAllOrganisationFeedbacks(con,organisationId);
	}
	@Override
	public List<GetCompanyFeebacksVo> getAllCompanyFeedbacks(Integer feedbackTypeId,Integer clientId,Integer addressId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		StudentRequestFeedbackDaoi daoi=new StudentRequestFeedbackDaoimpl();
		
		return daoi.getAllCompanyFeedbacks(con,feedbackTypeId,clientId,addressId);
	}
	
	
}
