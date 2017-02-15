/**
 * 
 */
package com.nacre.online_assesment.service_i;

import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobDetailsBean;
import com.nacre.online_assesment.form_bean.SendingUserNumsAndExamDetails;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;
import com.nacre.online_assesment.vo.AssessmentNotification;

/**
 * @author Mounika
 * @author Manish kumar deo
 *
 */
public interface NotificationsServicei {
	/**
	 * @author Manish kumar deo
	 * @return List contains all assessment Notification
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws Exception for unreported exception Exception that must be caught 
	 */
	public List<AssessmentNotification> studentNotification(Integer userId) throws DatabaseException,Exception;
 
	
	/**
	 * @author Mounika
	 * @return java.util.List Contains AssesmentDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 */
	public List notificatioRegardingAssessmentToTechAdminService() throws DatabaseException;

	
	//public void acceptedOrRejected(String email,int jobPostingID) ;
	
	
	/**
	 * @author Gajanan Debadwar
	 * @param email
	 * @return List
	*/
	public List<JobDetailsBean> getJobDetailsToShowNotification(String email);
	
	
	//public JobDetailsBean showJobDetails(int jobPostingID);
	
	
	
	/**
	 * @author vijaykumar P
	 * @param Connection,JobpostingId
	 * @param conn getting from DBUtils class which is using to connect the database 
	 * @return List<String> which returns roundDescrition and date
	 * @throws SQLException 
	 * @throws DatabaseException 
	 * @throws SQLExceptio 
	 */
  public List<String> getDateAndRoundDescriptionInAjaxCall(Integer jobPostingId) throws SQLException, DatabaseException;
	/**
	 * @author vijaykumar P
	 * @param userAndExamDetails
	 *            which carrying Userid and examd date and jobposting id details
	 * @return List returning list of emailId's
	 * @throws DatabaseException
	 *             occurs when connection problems occurred
	 * @throws SQLException
	 * @throws AddressException
	 *             occures when invalid email's got
	 * @throws MessagingException
	 */
	public List<String> sendingNotificationToSelectedStudent(SendingUserNumsAndExamDetails userAndExamDetails,
			ViewJobNotificationBean viewJobNotificationBean)
			throws DatabaseException, SQLException, AddressException, MessagingException;

	/**
	 * @author vijaykumar P
	 * @param userNo
	 * @return list returnd job details company name, company logo,description
	 *         of the job
	 * @throws SQLException
	 * @throws DatabaseException
	 *             occurs when connecting database issues occured
	 */
	public List getJobDetailsToShowNotification(int userNo) throws SQLException, DatabaseException;
}
