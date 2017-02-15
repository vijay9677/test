/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobDetailsBean;
import com.nacre.online_assesment.form_bean.SendingUserNumsAndExamDetails;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;
import com.nacre.online_assesment.service_i.NotificationsServicei;
import com.nacre.online_assesment.service_i.service_impl.NotificationsServiceimpl;
import com.nacre.online_assesment.vo.AssessmentNotification;

/**
 * @author Manish kumar deo
 * @author Mounika
 */
public class NotificationDelegate {
	/**
	 * @author Manish kumar deo
	 * @return List of AssessmentNotification CONTAINS Assessment NOTIFICATION
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 */
	public List<AssessmentNotification> studentNotification(Integer userId) throws DatabaseException,Exception{
		
		NotificationsServicei notificationsServicei=new NotificationsServiceimpl();
		return notificationsServicei.studentNotification(userId);
		
	}
	
	/**
	 * @author Mounika
	 * @return List of AssesmentDTO CONTAINS Assessment INFORMATION
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 */
	
	public List notificatioRegardingAssessmentToTechAdminDelegate() throws DatabaseException{
		
	 //creating notificationService class object and calling notificatioRegardingAssessmentToTechAdminService(),
		NotificationsServicei notificationService=new NotificationsServiceimpl();
	List<AssesmentDTO> list= notificationService.notificatioRegardingAssessmentToTechAdminService();
	return list;
	 
 }
	
	
	/*public void acceptedOrRejected(String email,int jobPostingID)  {
		
		
		NotificationsServiceimpl service = new NotificationsServiceimpl();
		 service.acceptedOrRejected(email, jobPostingID);
     }
	*/
	
	
	/**
	 * @author Gajanan Debadwar
	 * @param email
	 * @return List
	*/
	public List<JobDetailsBean> getJobDetailsToShowNotification(String email) {
		
		List<JobDetailsBean> list = null;
		NotificationsServiceimpl service = new NotificationsServiceimpl();
		list = service.getJobDetailsToShowNotification(email);
		System.out.println("In deligate: "+list);
		return list;
		
	}
	
	
	
	/*public JobDetailsBean showJobDetails(int jobPostingID){
	
		
		JobDetailsBean jdBean = new JobDetailsBean();
	    NotificationsServicei notificationService = new NotificationsServiceimpl();
	    jdBean = notificationService.showJobDetails(jobPostingID);
		System.out.println("deigate:"+jdBean);
	    return jdBean;
	}

*/
	/**
	 * @author vijaykumar P
	 * @param Connection,JobpostingId
	 * @param conn getting from DBUtils class which is using to connect the database 
	 * @return List<String> which returns roundDescrition and date
	 * @throws SQLException 
	 * @throws DatabaseException 
	 * @throws SQLExceptio 
	 */
  public List<String> getDateAndRoundDescriptionInAjaxCall(Integer jobPostingId) throws SQLException, DatabaseException{
	  
	  NotificationsServicei notificationsServicei = null;
		List<String> dateandDescription = null;
		// creating service class object
		notificationsServicei = new NotificationsServiceimpl();
		// calling service class method which is
		// sendingNotificationToSelectedStudent
		dateandDescription = notificationsServicei.getDateAndRoundDescriptionInAjaxCall(jobPostingId);

		// returning list
		return dateandDescription;
	  
	  
  }
	
	
	/**
	 * @author vijaykumar P
	 * @param userAndExamDetails
	 *            which carries userid, jobPostingId, examdate and exam name
	 * @param viewJobNotificationBean
	 *            which carries job details
	 * @return list returns list of email's
	 * @throws DatabaseException
	 *             occurs when database connection issues occurred
	 * @throws SQLException
	 * @throws AddressException
	 *             occurs when when invalid mail occurred
	 * @throws MessagingException
	 */
	public List<String> sendingNotificationToSelectedStudent(SendingUserNumsAndExamDetails userAndExamDetails,
			ViewJobNotificationBean viewJobNotificationBean)
			throws DatabaseException, SQLException, AddressException, MessagingException {
		NotificationsServicei notificationsServicei = null;
		List<String> result = null;
		// creating service class object
		notificationsServicei = new NotificationsServiceimpl();
		// calling service class method which is
		// sendingNotificationToSelectedStudent
		result = notificationsServicei.sendingNotificationToSelectedStudent(userAndExamDetails,
				viewJobNotificationBean);

		// returning list
		return result;

	}

	/**
	 * @author vijaykumar P
	 * @param userNo
	 * @return list of job details
	 * @throws SQLException
	 *             occurs when query input problems occurred
	 * @throws DatabaseException
	 *             occurs when DBconnection issues occurred
	 */
	public List getJobDetailsToShowNotification(int userNo) throws SQLException, DatabaseException {

		// creating NotificationService class object
		NotificationsServicei service = new NotificationsServiceimpl();
		// calling service class method which is
		// getJobDetailsToShowNotification() method
		return service.getJobDetailsToShowNotification(userNo);

	}

}
