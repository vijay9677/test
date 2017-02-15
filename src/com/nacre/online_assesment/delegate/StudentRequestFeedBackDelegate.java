/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.FeedbackTypeDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ClientAddressBean;
import com.nacre.online_assesment.service_i.StudentRequestFeedbackServicei;
import com.nacre.online_assesment.service_i.service_impl.StudentRequestFeedbackServiceimpl;
import com.nacre.online_assesment.vo.GetCompanyFeebacksVo;
import com.nacre.online_assesment.vo.GetOrganisationFeedbacksVo;
import com.nacre.online_assesment.vo.ViewAllFeedbacksVo;


/**
 * @author Amarendar Guthuru
 * @return List of FeedbackTypeDTO CONTAINS Feedback information
 * @throws DatabaseException occurs when problem occurs while connecting with database
 * @throws DataNotFoundException occurs when feebacktype is not available
 * @throws SQLExcpetion occurs when the problems occur with the database
 */
public class StudentRequestFeedBackDelegate {
	public List<FeedbackTypeDTO> getFeedbackType() throws DatabaseException, SQLException, DataNotFoundException{
		StudentRequestFeedbackServicei studentRequestFeedbackServicei=new StudentRequestFeedbackServiceimpl();
		return studentRequestFeedbackServicei.getFeedbackType();
		
		
	}
	
	/**
	 * @author Amarendar Guthuru
	 * @return List of ClientDTO CONTAINS client information
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when companies are not available
	 * @throws SQLExcpetion occurs when the problems occur with the database
	 */
	
	
	public List<ClientDTO> getCompany() throws DatabaseException, SQLException, DataNotFoundException{
		StudentRequestFeedbackServicei studentRequestFeedbackServicei=new StudentRequestFeedbackServiceimpl();
		return studentRequestFeedbackServicei.getCompany();
		
	}
	/**
	 * @author Amarendar Guthuru
	 * @return List ofClientAddressBean  CONTAINS clientaddress information
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when ClientAddress is not available
	 * @throws SQLExcpetion occurs when the problems occur with the database
	 */

	public List<ClientAddressBean> getCompanyAddress(Integer clientId) throws DatabaseException, SQLException{
		StudentRequestFeedbackServicei studentRequestFeedbackServicei=new StudentRequestFeedbackServiceimpl();
		return studentRequestFeedbackServicei.getCompanyAddress(clientId);
		
		
	}
	/**
	 * @author Amarendar Guthuru
	 * @param clientId 
	 * @return List ofClientAddressBean  CONTAINS clientlocality information
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Clientlocality is not available
	 * @throws SQLExcpetion occurs when the problems occur with the database
	 */

	public List<ClientAddressBean> getClientLocality(Integer cityId, Integer clientId) throws DatabaseException, SQLException{
		StudentRequestFeedbackServicei studentRequestFeedbackServicei=new StudentRequestFeedbackServiceimpl();
		return studentRequestFeedbackServicei.getClientLocality(cityId,clientId);
		
		
		/**
		 * @author Amarendar Guthuru
		 * @return getClientAddressId based on by passing clinetId and addressId
		 * @throws DatabaseException occurs when problem occurs while connecting with database
		 * @throws DataNotFoundException occurs when clientAddressId is not available
		 * @throws SQLExcpetion occurs when the problems occur with the database
		 */

		
	}
	public int getClientAddressId(Integer clientid,Integer addressid) throws DatabaseException, SQLException, DataNotFoundException{
		StudentRequestFeedbackServicei studentRequestFeedbackServicei=new StudentRequestFeedbackServiceimpl();
		return studentRequestFeedbackServicei.getClientAddressId(clientid,addressid);
		
	}
	/**
	 * @author Amarendar Guthuru
	 * @return feedback savedFeedback into the database or not
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws SQLExcpetion occurs when the problems occur with the database
	 */

	
		public int saveFeedBackTable(String message, Integer feedbacktypeid, Integer userid, Integer clientaddreesid) throws DatabaseException, SQLException{
			StudentRequestFeedbackServicei studentRequestFeedbackServicei=new StudentRequestFeedbackServiceimpl();
			 return studentRequestFeedbackServicei.saveFeedBackTable(message,feedbacktypeid,userid,clientaddreesid);
		}
		
      /**
       * @author Amarendar Guthuru
     * @throws SQLException 
     * @throws DatabaseException 
       */
		public List<ViewAllFeedbacksVo> getAllFeedbacks() throws DatabaseException, SQLException{
			
			StudentRequestFeedbackServicei feedbackServicei=new StudentRequestFeedbackServiceimpl();
			
			return feedbackServicei.getAllFeedbacks();
		}
		/**
		 * @author Amarendar Guthuru
		 * @param organisationId 
		 * @return
		 * @throws DatabaseException
		 * @throws SQLException
		 */
	
		public List<GetOrganisationFeedbacksVo> getAllOrganisationFeedbacks(Integer organisationId) throws DatabaseException, SQLException{
			
			StudentRequestFeedbackServicei feedbackServicei=new StudentRequestFeedbackServiceimpl();
			
			return feedbackServicei.getAllOrganisationFeedbacks(organisationId);
			
		}
	  public List<GetCompanyFeebacksVo> getAllCompanyFeedbacks(Integer feedbackTypeId, Integer clientId, Integer addressId) throws DatabaseException, SQLException{
		  
		   StudentRequestFeedbackServicei feedbackServicei=new StudentRequestFeedbackServiceimpl();
		   
		    return feedbackServicei.getAllCompanyFeedbacks(feedbackTypeId,clientId,addressId);
		  
	  }
		
}
