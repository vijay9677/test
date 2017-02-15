/**
 * 
 */
package com.nacre.online_assesment.dao_i;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobDetailsBean;
import com.nacre.online_assesment.form_bean.SendingUserNumsAndExamDetails;
import com.nacre.online_assesment.vo.AssessmentNotification;

/**
 * @author Manish kumar deo
 * @author Mounika
 *
 */
public interface NotificationsDaoi {
	/**
	 * @author Manish kumar deo
	 * @param con Accepts java.sql.Connection
	 * @return List contains all assessment Notification
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws Exception for unreported exception Exception that must be caught 
	 */
public List<AssessmentNotification> studentNotification(Integer userId,Connection con) throws DatabaseException,Exception;
	
	/**
	 * @author Mounika
	 * @param con Accepts java.sql.Connection
	 * @return List contains Details of assessment
	 * @throws SQLException when connection and DB Query related problem occurs
	 */
	public List notificatioRegardingAssessmentToTechAdminDao(Connection connection) throws SQLException;
	//public void accepetedOrRejected(Connection con, String email,int jobPostingID) ;
	
	/**
	 * @author Gajanan Debadwar
	 * @param email
	 * @param con
	 * @return List
	*/
	public List<JobDetailsBean> getJobDetailsToShowNotification(Connection con,String email) throws DatabaseException;
	
//	public JobDetailsBean showJobDetails(Connection con,int jobPostingID);

	
	/**
	 * @author vijaykumar P
	 * @param Connection,JobpostingId
	 * @param conn getting from DBUtils class which is using to connect the database 
	 * @return List<String> which returns roundDescrition and date
	 * @throws SQLException 
	 * @throws SQLExceptio 
	 */
  public List<String> getDateAndRoundDescriptionInAjaxCall(Connection con,Integer jobPostingId) throws SQLException;
	
	/**
	 * @author vijaykumar P
	 * @param userAndExamDetails
	 *            which carrying Userid and examd date and jobposting id details
	 * @param conn
	 *            getting from DBUtils class which is using to connect the
	 *            database
	 * @return List<String> which returns list of emails
	 * @throws SQLException
	 */
	public List<String> sendingNotificationToSelectedStudent(SendingUserNumsAndExamDetails userAndExamDetails,
			Connection conn) throws SQLException;

	/**
	 * @author vijaykumar P
	 * @param userNo
	 * @param userAndExamDetails
	 *            which carrying Userid and examd date and jobposting id details
	 * @param conn
	 *            getting from DBUtils class which is using to connect the
	 *            database
	 * @return List<String> which returns list of emails
	 * @throws SQLException
	 */
	public List getJobDetailsToShowNotification(Connection con, int userNo) throws SQLException;

}
