/**
 * 
 */
package com.nacre.online_assesment.service_i;

import java.sql.SQLException;
import java.util.List;


import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.FeedbackTypeDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ClientAddressBean;
import com.nacre.online_assesment.vo.GetCompanyFeebacksVo;
import com.nacre.online_assesment.vo.GetOrganisationFeedbacksVo;
import com.nacre.online_assesment.vo.ViewAllFeedbacksVo;

/**
 * 
 * StudentRequestFeedbackServicei.java
 * Interface class that has the following methods.
 * 
 * @author Amarendar Guthuru
 * @since 30-08-2016
 */



public interface StudentRequestFeedbackServicei {
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return FeedbackTypeDTO
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if feedback type data not found in the DB
	 * 
    */
	List<FeedbackTypeDTO> getFeedbackType() throws DatabaseException, SQLException, DataNotFoundException;
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return ClientDTO
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if Company data not found in the DB
	 * 
    */
	List<ClientDTO> getCompany() throws DatabaseException, SQLException, DataNotFoundException;
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return ClientAddressBean
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if CompanyAddress data not found in the DB
	 * 
    */
	List<ClientAddressBean> getCompanyAddress(Integer clientId) throws DatabaseException, SQLException;
	/**
	 * @author Amarendar Guthuru
	 * @param clientId 
     * @since 30-08-2016
	 * @return ClientAddressBean
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if locality is not available  in the DB
	 * 
    */
	List<ClientAddressBean> getClientLocality(Integer cityId, Integer clientId) throws DatabaseException, SQLException;
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return clientaddressId 
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * @throws DataNotFoundException if clientaddressId data not found in the DB
	 * 
    */
	int getClientAddressId(Integer clientid, Integer addressid) throws DatabaseException, SQLException, DataNotFoundException;
	/**
	 * @author Amarendar Guthuru
     * @since 30-08-2016
	 * @return 1 if feedback inserted successfully else it returns 0
	 * @throws DatabaseException if problem occurs while connecting to the database
	 * @throws SQLException if problem occurs with driver or database
	 * 
    */
	public int saveFeedBackTable(String message, Integer feedbacktypeid, Integer userid, Integer clientaddreesid) throws DatabaseException, SQLException;
	
	/**
	 * @ Amarendar Guthuru
	 * @return List
	 * @throws DatabaseException 
	 * @throws SQLException 
	 */
	public List<ViewAllFeedbacksVo> getAllFeedbacks() throws DatabaseException, SQLException;
	/**
	 * @author Amarendar Guthuru
	 * @param organisationId
	 * @return
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	
	public List<GetOrganisationFeedbacksVo> getAllOrganisationFeedbacks(Integer organisationId) throws DatabaseException, SQLException;
	
	/**
	 * @author Amarendar Guthuru
	 * @param companyId
	 * @param clientId 
	 * @param addressId 
	 * @return
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public List<GetCompanyFeebacksVo> getAllCompanyFeedbacks(Integer feedbackTypeId, Integer clientId, Integer addressId) throws DatabaseException, SQLException;

	 
	
	


}
