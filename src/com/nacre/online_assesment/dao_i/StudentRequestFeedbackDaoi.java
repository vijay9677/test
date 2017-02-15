/**
 * 
 */
package com.nacre.online_assesment.dao_i;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nacre.online_assesment.dto.CityDTO;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.FeedbackTypeDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ClientAddressBean;
import com.nacre.online_assesment.vo.GetCompanyFeebacksVo;
import com.nacre.online_assesment.vo.GetOrganisationFeedbacksVo;
import com.nacre.online_assesment.vo.ViewAllFeedbacksVo;



public interface StudentRequestFeedbackDaoi {
	/**
	 * @author Amarendar Guthuru
	 * @since 30-08-2016
	 * @param con Accepts java.sql.Connection
	 * @return List contains  type of feedbacks
	 * @throws DataNotFoundException occurs when no feedbacks are Available
	 * @throws SQLExcpetion occurs when problem occurs while interacting with  database
	 */
    List<FeedbackTypeDTO> getFeedbackType(Connection con) throws SQLException, DataNotFoundException;
    /**
	 * @author Amarendar Guthuru
	 * @since 30-08-2016
	 * @param con Accepts java.sql.Connection
	 * @return List contains  type of companies based on feedbackId
	 * @throws DataNotFoundException occurs when no companies are Available
	 * @throws SQLExcpetion occurs when problem occurs while interacting with  database
	 */
	List<ClientDTO> getCompany(Connection con) throws SQLException, DataNotFoundException;
	/**
	 * @author Amarendar Guthuru
	 * @since 30-08-2016
	 * @param con Accepts java.sql.Connection
	 * @return List contains  type of cities based on clientId
	 * @throws DataNotFoundException occurs when no cities  are Available
	 * @throws SQLExcpetion occurs when problem occurs while interacting with  database
	 */
	List<ClientAddressBean> getCompanyAddress(Connection con, Integer clientId) throws SQLException;
	/**
	 * @author Amarendar Guthuru
	 * @since 30-08-2016
	 * @param con Accepts java.sql.Connection
	 * @param clientId 
	 * @return List contains  type of locations based on ctyId
	 * @throws DataNotFoundException occurs when no localities are Available
	 * @throws SQLExcpetion occurs when problem occurs while interacting with  database
	 */
	List<ClientAddressBean> getClientLocality(Connection con, Integer cityId, Integer clientId) throws SQLException;
	/**
	 * @author Amarendar Guthuru
	 * @since 30-08-2016
	 * @param con Accepts java.sql.Connection
	 * @return  contains clinet_Address_Id 
	 * @throws DataNotFoundException occurs when no client_Address_Id is Available
	 * @throws DatabaseExcption occurs when problem occurs while interacting with  database
	 */
	int getClientAddressId(Connection con, Integer clientid, Integer addressid) throws SQLException, DataNotFoundException, DatabaseException;
	/**
	 * @author Amarendar Guthuru
	 * @param con Accepts java.sql.Connection
	 * @return true if feedback message saved successfully
	 * @throws SQLExcpetion occurs when problem occurs while interacting with  database
	 */
	
	
	public int saveFeedBackTable(Connection con, String message, Integer feedbacktypeid, Integer userid,
			Integer clientaddreesid) throws SQLException;
	
	
	public List<ViewAllFeedbacksVo> getAllFeedbacks(Connection con) throws DatabaseException, SQLException;
	
	
	
	
	public List<GetOrganisationFeedbacksVo> getAllOrganisationFeedbacks(Connection con, Integer organisationId) throws SQLException;
	
	public List<GetCompanyFeebacksVo> getAllCompanyFeedbacks(Connection con, Integer feedbackTypeId, Integer clientId, Integer addressId) throws SQLException;

	
	
}
