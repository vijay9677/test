/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.sql.SQLException;
import java.sql.ResultSet;

import com.nacre.online_assesment.dto.EligibleDTO;
import java.util.List;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.ApplyRequestOpportunityPostingsServicei;
import com.nacre.online_assesment.service_i.service_impl.ApplyRequestOpportunityPostingServiceimpl;

/**
 * @author JAY SINGH
 *
 */
public class ApplyRequestOpportunityPostingDelegate {
	/**
	 * @author JAY SINGH
	 * 
	 * @return List
	 */
	public List getNotifications() throws DatabaseException {
		ApplyRequestOpportunityPostingsServicei service=new ApplyRequestOpportunityPostingServiceimpl();
		return service.getNotifications();
	}

	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto
	 * @return  @return Integer eligible_student_Id or null
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public EligibleDTO checkEligibilty(EligibleDTO eDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("hi pavan this checkEligibilty in Delegate");
		ApplyRequestOpportunityPostingsServicei applyOrRequest=new ApplyRequestOpportunityPostingServiceimpl();
		return applyOrRequest.checkEligibilty(eDto);
		
	}
	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto
	 * @return if successfully Request sent true return else false return
	 * @throws DatabaseException
	 * @throws SQLException
	 */

	public Boolean requestForJob(EligibleDTO eDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("hi pavan this requestForJob in Delegate");
		ApplyRequestOpportunityPostingsServicei applyOrRequest=new ApplyRequestOpportunityPostingServiceimpl();
		return applyOrRequest.requestForJob(eDto);
	}
	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto
	 * @return @return if elgible_student succesffuly apply true retun else false return
	 * @throws DatabaseException
	 * @throws SQLException
	 */

	public Boolean applyForJob(EligibleDTO eDto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("hi pavan this applyForJob in Delegate");
		ApplyRequestOpportunityPostingsServicei applyOrRequest=new ApplyRequestOpportunityPostingServiceimpl();
		return applyOrRequest.applyForJob(eDto);
		
	}

	/**
	 * @author JAY SINGH
	 * @param userid
	 * @return list
	 */

	public List<Object> getUserDetails(int user_id) throws  SQLException,DatabaseException {
		// TODO Auto-generated method stub
		ApplyRequestOpportunityPostingsServicei service=new ApplyRequestOpportunityPostingServiceimpl();
		return service.getUserDetails(user_id);
		
	}
	
	
	


}
