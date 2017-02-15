/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.nacre.online_assesment.dao_i.NotificationsDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.NotificationsDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobDetailsBean;
import com.nacre.online_assesment.form_bean.SendingUserNumsAndExamDetails;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;
import com.nacre.online_assesment.service_i.NotificationsServicei;
import com.nacre.online_assesment.vo.AssessmentNotification;
import com.nacre.online_assesment.vo.MailApi;

/**
 * @author Manish kumar deo
 * @author Mounika
 *
 */
public class NotificationsServiceimpl implements NotificationsServicei {
	/* (non-Javadoc)
	 * @see com.nacre.online_assesment.service_i.NotificationsServicei#getAssessmentNotification_stud(java.sql.Connection)
	 */

	
	 
	 /* (non-Javadoc)
		 * @see com.nacre.online_assesment.service_i.NotificationsServicei#notificatioRegardingAssessmentToTechAdminService()
		 */	

	@Override
	public List notificatioRegardingAssessmentToTechAdminService() throws DatabaseException {
	
		//creating daoimpl object.
		 NotificationsDaoi  notificationsDao=new  NotificationsDaoimpl();
		// calling getConnection method  
		 Connection connection=DbUtil.getConnection();
		//calling notificationtotechnicalteam dao method
		List<AssesmentDTO> list=null;
		try {
			list=notificationsDao.notificatioRegardingAssessmentToTechAdminDao(connection);
			DbUtil.closeConnection(connection);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException();
		}
		
	
	}

	

	@Override
	public List<AssessmentNotification> studentNotification(Integer userId)
			throws DatabaseException, Exception {
		// TODO Auto-generated method stub
		Connection con=DbUtil.getConnection();
		NotificationsDaoi notificationsDaoi=new NotificationsDaoimpl();
		return notificationsDaoi.studentNotification(userId, con);
	}

	/*@Override
	public void acceptedOrRejected(String email,int jobPostingID) {
		// TODO Auto-generated method stub
		
		
		Connection con = null;
		try {
			con = DbUtil.getConnection();
			NotificationsDaoimpl dao = new NotificationsDaoimpl();
			 dao.accepetedOrRejected(con, email, jobPostingID); 
			
			
		} 
		catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
*/	
	/**
	 * @author Gajanan Debadwar
	 * @param email
	 * @param jobPostingID
	 * @return List
	*/

	@Override
	public List<JobDetailsBean> getJobDetailsToShowNotification(String email)  {
		// TODO Auto-generated method stub
		Connection con = null;
		List<JobDetailsBean> list = null;
		try {
			con = DbUtil.getConnection();
			NotificationsDaoimpl dao = new NotificationsDaoimpl();
			list = dao.getJobDetailsToShowNotification(con,email); 
			System.out.println("In service: "+list);
			
			
		} 
		catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

/*	@Override
	public JobDetailsBean showJobDetails(int jobPostingID) {
		// TODO Auto-generated method stub
		Connection con = null;
		JobDetailsBean jdBean = null;
		try {
			jdBean = new JobDetailsBean();
			con = DbUtil.getConnection();
			
			NotificationsDaoi notificationDao = new NotificationsDaoimpl();
			jdBean  = notificationDao.showJobDetails(con,jobPostingID);
			
			System.out.println("service:"+jdBean);
			
		} 
		catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	  
	  
	// TODO Auto-generated method stub
			Connection con = null;
			List<String> dateAndDescription = null;

			// creating connection or getting connection from DButil class
			con = DbUtil.getConnection();
			// creating NotificationDaoi class object
			NotificationsDaoi dao = new NotificationsDaoimpl();
			// calling getJobDetailsToShowNotification daoi class method
			dateAndDescription= dao.getDateAndRoundDescriptionInAjaxCall(con, jobPostingId);

			// returning the job details
			return dateAndDescription;
	  
  }
	/**
	 * @author vijaykumar P
	 * @param userAndExamDetails
	 *            which carrying Userid and examd date and jobposting id details
	 * @return List<String> which returns list of emails
	 * @throws SQLException
	 */
	@Override
	public List<String> sendingNotificationToSelectedStudent(SendingUserNumsAndExamDetails userAndExamDetails,
			ViewJobNotificationBean viewJobNotificationBean)
			throws DatabaseException, SQLException, AddressException, MessagingException {
		Connection conn = null;
		List<String> listofEmails = null;
		NotificationsDaoi notificationsDaoi = null;
		MailApi api = null;
		String str = "these following details are sended to your account verify \n\n "
				+ "Company Name                   :   " + viewJobNotificationBean.getCompanyName() + "\n\n "
				+ "CompanyLocation                :   " + viewJobNotificationBean.getLocation() + "\n\n"
				+ "city name                      :   " + viewJobNotificationBean.getCity() + "\n\n"
				+ "Country name                   :   " + viewJobNotificationBean.getCountry() + "\n\n"
				+ "pincode                        :   " + viewJobNotificationBean.getPincode() + " \n\n"
				+ "Contact person name            :   " + viewJobNotificationBean.getContatPersonName() + "\n\n"
				+ "Contact person mobile number   :   " + viewJobNotificationBean.getContactPersonMobileNo() + "\n\n"
				+ "Contact Person Email           :   " + viewJobNotificationBean.getContactPersonEmail() + "\n\n"
				+ "CompanyDescription             :   " + viewJobNotificationBean.getCompanyDescription() + "\n\n"
				+ "Job description                :   " + viewJobNotificationBean.getJobDescription() + "\n\n"
				+ "Assessment expected date       :   " + viewJobNotificationBean.getExpecteddate() + "\n\n"
				+ "Assessment start date          :   " + viewJobNotificationBean.getAssesmentStartDate() + "\n\n"
				+ "Assessment End Date 			  :   " + viewJobNotificationBean.getAssesmentEndDate() + "\n\n"
				+ "Job Posted date 		          :   " + viewJobNotificationBean.getPostedDate() + "\n\n"
				+ "noof vacancies				  :   " + viewJobNotificationBean.getNoofvacancies() + "\n\n"
				+ "Technology                     :   " + viewJobNotificationBean.getTechnology() + "\n\n"
				+ "NOTE :  If you interested Accept the notification in your account  \n\n"
				+ "NOTE :  If you Already attended ignore the email";
		

		
		// creating DB connection
		conn = DbUtil.getConnection();
		// creating notificationDai class object
		notificationsDaoi = new NotificationsDaoimpl();
		// calling method
		listofEmails = notificationsDaoi.sendingNotificationToSelectedStudent(userAndExamDetails, conn);
		System.out.println("Service  " + listofEmails);
		// creating mailApi class object
		api = new MailApi();
		// calling mail api class method
		api.sendMail(listofEmails, str);
		// returning list of emails
		return listofEmails;
	}

	/**
	 * @author vijaykumar P
	 * @param userNo
	 * @return List which returns job postingid, client name,job
	 *         Description,company image in the form of
	 *         JobDetaislsToShowNptificationBean object format
	 * @throws SQLException
	 * @throws DatabaseException
	 *             occurs when connection issues occurred
	 */

	@Override
	public List getJobDetailsToShowNotification(int userNo) throws SQLException, DatabaseException {
		// TODO Auto-generated method stub
		Connection con = null;
		List list = null;

		// creating connection or getting connection from DButil class
		con = DbUtil.getConnection();
		// creating NotificationDaoi class object
		NotificationsDaoi dao = new NotificationsDaoimpl();
		// calling getJobDetailsToShowNotification daoi class method
		list = dao.getJobDetailsToShowNotification(con, userNo);

		// returning the job details
		return list;

	}
}
