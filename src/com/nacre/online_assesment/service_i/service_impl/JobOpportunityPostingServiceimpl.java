/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.nacre.online_assesment.dao_i.JobOpportunityPostingDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.JobOpportunityPostingDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean;
import com.nacre.online_assesment.form_bean.SelectingAllstudentDetailsBean;
import com.nacre.online_assesment.form_bean.SelectingYopOrPercentageBean;
import com.nacre.online_assesment.form_bean.ShareJobOppertunityFormBean;
import com.nacre.online_assesment.form_bean.ShowJobDetailsBean;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;
import com.nacre.online_assesment.service_i.JobOpportunityPostingServicei;
import com.nacre.online_assesment.util.SendMailUtil;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;
import com.nacre.online_assesment.vo.FindJobPostingVO;
import com.nacre.online_assesment.vo.GetClientDetailForEditingVo;
import com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo;
import com.nacre.online_assesment.vo.MailApi;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class JobOpportunityPostingServiceimpl implements JobOpportunityPostingServicei {
	public JobOpportunityPostingServiceimpl() {
		System.out.println("in job posting service");
	}

	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains job post Objects
	 * @throws DatabaseException
	 *             occurs when you are getting problem to connect to database
	 * @throws SQLException
	 *             occurs if no countries are available
	 */
	@Override
	public List<Object> getjobPostDetails() throws SQLException, DatabaseException {
		JobOpportunityPostingDaoi dao = new JobOpportunityPostingDaoimpl();
		Connection con = DbUtil.getConnection();
		return dao.getjobPostDetails(con);
	}

	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains job post Objects
	 * @throws DatabaseException
	 *             occurs when you are getting problem to connect to database
	 * @throws SQLException
	 *             occurs if no countries are available
	 */
	@Override
	public List<Object> getjobPostDescription(Integer jobpostid) throws SQLException, DatabaseException {
		JobOpportunityPostingDaoi dao = new JobOpportunityPostingDaoimpl();
		Connection con = DbUtil.getConnection();
		return dao.getjobPostDescription(jobpostid, con);
	}

	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains job post Objects
	 * @throws DatabaseException
	 *             occurs when you are getting problem to connect to database
	 * @throws SQLException
	 *             occurs if no countries are available
	 */
	@Override
	public List<Object> findJobPost(FindJobPostingVO jobpostvo) throws SQLException, DatabaseException {
		JobOpportunityPostingDaoi dao = new JobOpportunityPostingDaoimpl();
		Connection con = DbUtil.getConnection();
		return dao.findJobPost(jobpostvo, con);
	}

/*	*//**
	 * @author Rajnish
	 * @return Boolean Contains jobPostingInsertionFormBean  Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no any field is blank are available
	 *//*
	  @Override
	public Boolean addJobPosting(JobPostingInsertionFormBean fb) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub

		System.out.println("service");
		JobOpportunityPostingDaoi jobposting = new JobOpportunityPostingDaoimpl();
		Connection con = DbUtil.getConnection();
		Boolean result = jobposting.addJobPosting(con, fb);
		List<UserDTO> list = jobposting.emailAccess(con);
		UserDTO userDTO = new UserDTO();
		String textmail = "Description of The job Posting     :" + fb.getDescription() + "\n"
				+ "Expected Assesment date          :" + fb.getExpectedDate() + "\n"
				+ "assessment start date            :" + fb.getAssStartDate() + "\n"
				+ "Assessment End  date             :" + fb.getAssEndDate() + "\n"
				+ "Posted Date                      :" + fb.getPostDate() + "\n" + "No Of Vacancies                  :"
				+ fb.getVacancies() + "\n" + "Client Address                 :" + fb.getClientaddressId() + "\n"
				+ "Technology Id                  :" + fb.getTechnologyId();

		
		if (result == true ) {

			for(int i=0; i<list.size();i++)
			{
		        userDTO = list.get(i);
				SendMailUtil sendMailUtil = new SendMailUtil();
				System.out.println("Mail is sending");
				sendMailUtil.sendGmail(userDTO.getEmail(), "hiiii", textmail);
		    }

		}		
		return result;
	}*/
	 
	 
	
	
	/**
	 * @author Rajnish
	 * @return java.util.Li Contain ClientAddressDetailvo Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 *//*

	@Override
	public List<ClientAddressDetailVo> getClientDetail(Integer clientId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub

		JobOpportunityPostingDaoi jobOpportunityPostingDaoi = new JobOpportunityPostingDaoimpl();
		Connection con = DbUtil.getConnection();

		return jobOpportunityPostingDaoi.getClientAddressDeatail(con, clientId);
	}*/
	/**
	 * @author Rajnish
	 * @return java.util.List Contains jobPostingIdNotification Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	@Override
	public List<ShowJobDetailsBean> getjobPostingIdNotification() throws DatabaseException, SQLException {
		JobOpportunityPostingDaoi jobOpportunityPostingDaoi = new JobOpportunityPostingDaoimpl();
		Connection con = DbUtil.getConnection();
		return jobOpportunityPostingDaoi.getjobPostingIdNotification(con);

	}

	/**
	 * @author Rajnish
	 * @return All the deail ofjob posting detail Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	@Override
	public ShowJobDetailsBean getjobPostingIdNotificationDetail(int jobposting_id)
			throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		JobOpportunityPostingDaoi jobOpportunityPostingDaoi = new JobOpportunityPostingDaoimpl();
		Connection con = DbUtil.getConnection();
		return jobOpportunityPostingDaoi.getjobPostingIdNotificationDetail(con, jobposting_id);

	}

	public void sendMail() {

	}

	/**
	 * @author vijay kumar p
	 * @param shareJobOppertunityFormBean
	 *            class object carrying details description about job and
	 *            student details
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws AddressException
	 *             occurs when problem occurs while get any invalid mail address
	 * @throws SQLException
	 *             occurs when inputs not giving properly
	 * @throws MessagingException
	 * 
	 */
	@Override
	public ArrayList<String> shareJobOppertunity(ShareJobOppertunityFormBean shareJobOppertunityFormBean)
			throws DatabaseException, SQLException, AddressException, MessagingException {
		Connection conn = null;
		JobOpportunityPostingDaoi jobOpportunityPostingDao = null;
		MailApi api = null;
		String str = null;

		// storing job details in String format
		str = shareJobOppertunityFormBean.getDetails();
		// getting connection
		conn = DbUtil.getConnection();
		// creating JobOpportunityPostingDaoimpl class object
		jobOpportunityPostingDao = new JobOpportunityPostingDaoimpl();
		// method calling
		ArrayList<String> list = jobOpportunityPostingDao.shareJobOppotunity(conn, shareJobOppertunityFormBean);
		
		api = new MailApi();
		// method calling for sending emails
		api.sendMail(list, str);
		return list;
	}

	/**
	 * @author vijaykumar P
	 * @param conn
	 *            which carries DB connection from database
	 * @param str
	 *            which carries jobpostid
	 * @return ViewJobNotificationBean object which carries job details
	 * @throws SQLException
	 * @throws DataBaseException
	 *             occurs when DB connection Issues are occurred
	 */
	@Override
	public ViewJobNotificationBean viewJobOpportunity(String str) throws DatabaseException, SQLException {
		Connection conn = null;
		JobOpportunityPostingDaoi jobOpportunityPostingDao = null;
		ViewJobNotificationBean viewJobNotificationBean = null;
		// getting connection from dbutil
		conn = DbUtil.getConnection();
		// creating dao class object
		jobOpportunityPostingDao = new JobOpportunityPostingDaoimpl();

		// calling view JobOpportunity(-,-) method
		viewJobNotificationBean = jobOpportunityPostingDao.viewJobOpportunity(conn, str);
		// return viewJobOpportunityBean
		return viewJobNotificationBean;
	}

	/**
	 * @author vijaykkumr P
	 * @param conn
	 *            which Carries DB connection
	 * @param jobPostingId
	 * @return ArraList which carries student details
	 * @throws SQLException
	 * @throws DataBaseException
	 *             occurs when DB connection Issues are occurred
	 */

	@Override
	public ArrayList<SelectingAllstudentDetailsBean> getAllStudEmailsDetails(Integer jobPostingId)
			throws DatabaseException, SQLException {
		Connection conn = null;
		JobOpportunityPostingDaoi jobOpportunityPostingDao = null;
		ArrayList<SelectingAllstudentDetailsBean> list = null;

		// creating or getting connection from DbUtilClass
		conn = DbUtil.getConnection();

		// creating JobOpportunityPostingDaoimpl class object
		jobOpportunityPostingDao = new JobOpportunityPostingDaoimpl();

		// calling getAllStudEmailsDetails(-,-)method
		list = jobOpportunityPostingDao.getAllStudEmailsDetails(conn, jobPostingId);
		// returning ArrayList
		return list;
	}

	/**
	 * @author vijaykumar P
	 * @param percentage
	 *            which Carries student academic percentage
	 * @param year
	 *            which carries student graduation year of passed out
	 * @param jobPostingId
	 * @return ArrayList returns student details
	 * @throws SQLException
	 * @throws DataBaseException
	 *             occurs when DB connection Issues are occurred
	 */
	@Override
	public ArrayList<SelectingYopOrPercentageBean> selectYearOrPer(String percentage, String year, Integer jobPostingId)
			throws SQLException, DatabaseException {
		Connection conn = null;
		JobOpportunityPostingDaoi jobOpportunityPostingDao = null;
		ArrayList<SelectingYopOrPercentageBean> list = null;
		// getting DBConnection from DbUtilCalss
		conn = DbUtil.getConnection();
		// creating JobOpportunityPostingDao Class object
		jobOpportunityPostingDao = new JobOpportunityPostingDaoimpl();
		// calling selectYearOrPer(-,-,-) method
		list = jobOpportunityPostingDao.selectYearOrPer(percentage, year, conn, jobPostingId);
		// return arrayList
		return list;
	}

	
	
	/**
	 * This method will gets all company details form data base 
	 * @author Srinivas N B-35
	 * @return  java.util.List<ClientDTO>
	 * @throws  java.sql.SQLException,DatabaseException
	 * 
	 */
	@Override
	public List<ClientDTO> getClientDetails() throws DatabaseException, SQLException {
		
		JobOpportunityPostingDaoi jobOpportunityPostingDaoi=new JobOpportunityPostingDaoimpl();
		Connection con=DbUtil.getConnection();
		List<ClientDTO> clientDTOsList=jobOpportunityPostingDaoi.getClientDetails(con);
		
		return clientDTOsList;
	}
	
	/**
	 * insert new Job posting in to database or adds new record in to tbl_job_posting
	 * @author Srinivas N B-35
	 * @param data accepts com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean
	 * @return  Boolean
	 * @throws  java.sql.SQLException,DatabaseException
	 */
	@Override
	public Boolean addJobPosting( JobPostingInsertionFormBean fb) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("service");
		JobOpportunityPostingDaoi jobposting=new JobOpportunityPostingDaoimpl();
		Connection con=DbUtil.getConnection();
		Boolean result=jobposting.addJobPosting(con, fb);
		
		
		List<UserDTO> list = jobposting.emailAccess(con);
		UserDTO userDTO = new UserDTO();
        Date postedDate=new Date();
		String textmail = "Description of The job Posting     :" + fb.getDescription() + "\n"
				+ "Expected Assesment date          :" + fb.getExpectedDate() + "\n"
				+ "assessment start date            :" + fb.getAssStartDate() + "\n"
				+ "Assessment End  date             :" + fb.getAssEndDate() + "\n"
				+ "Posted Date                      :" + postedDate + "\n" + "No Of Vacancies                  :"
				+ fb.getVacancies() + "\n" + "Client Address                 :" + fb.getClientaddressId() + "\n"
				+ "Technology Id                  :" + fb.getTechnologyId();

		if(list!=null){
		if (result == true ) {

			for(int i=0; i<list.size();i++)
			{
		        userDTO = list.get(i);
				SendMailUtil sendMailUtil = new SendMailUtil();
				System.out.println("Mail is sending");
				sendMailUtil.sendGmail(userDTO.getEmail(), "hiiii", textmail);
		    }

		}	}

		return result;
	}

	/**
	 * retrieving all all technology details 
	 * @author Srinivas N B-35
	 * @return  java.util.List<TechnologyDTO>
	 * @throws  java.sql.SQLException,DatabaseException
	 */
	@Override
	public List<TechnologyDTO> getTechnologyDetail() throws DatabaseException, SQLException {
		
JobOpportunityPostingDaoi jobOpportunityPostingDaoi=new JobOpportunityPostingDaoimpl();
Connection con=DbUtil.getConnection();


		return jobOpportunityPostingDaoi.getTechnologyDetail(con);
	}

	/**
	 * this method will return particular client address details based on the address id
	 * @author Srinivas N B-35
	 * @param accepts java.lang.Integer
	 * @return  java.util.List<ClientAddressDetailVo>
	 * @throws  java.sql.SQLException,DatabaseException
	 */
	@Override
	public List<ClientAddressDetailVo> getClientAddressDeatail(Integer clientId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		
		JobOpportunityPostingDaoi jobOpportunityPostingDaoi=new JobOpportunityPostingDaoimpl();
		Connection con=DbUtil.getConnection();
		
		
		return jobOpportunityPostingDaoi.getClientAddressDeatail(con, clientId);
	}


	/*@Override
	public Boolean deleteJobPosting(Integer jobPostingId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		JobOpportunityPostingDaoi jobOpportunityPostingDaoi=new JobOpportunityPostingDaoimpl();
		Connection con=DbUtil.getConnection();
		return jobOpportunityPostingDaoi.deleteJobPosting(con, jobPostingId);
		
		
	}*/
	/**
	 * based on the address id it will gives the city, State, Country, Pin Code details
	 * @author Srinivas N B-35
	 * @param accepts java.lang.Integer
	 * @return  com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo
	 * @throws  java.sql.SQLException,DatabaseException
	 */
	@Override
	public GettingLocationCurespondingDetailsvo getLocationRelatedAddres(
			Integer addressId) throws SQLException, DatabaseException {
		
		JobOpportunityPostingDaoi jobOpportunityPostingDaoi=new JobOpportunityPostingDaoimpl();
		Connection con=DbUtil.getConnection();
		
		return jobOpportunityPostingDaoi.getLocationRelatedAddres(addressId, con);
	}

	/**
	 * This method will gives the all the details related to job posting which are used 
	 * for editing the job posting
	 * @author Srinivas N B-35
	 * @return  List<GetClientDetailForEditingVo>
	 * @throws  java.sql.SQLException,DatabaseException
	 */
	@Override
	public List<GetClientDetailForEditingVo> getClientDetailsForEditing() throws DatabaseException, SQLException {
		JobOpportunityPostingDaoi jobOpportunityPostingDaoi=new JobOpportunityPostingDaoimpl();
		Connection con=DbUtil.getConnection();
		return jobOpportunityPostingDaoi.geClientDetailsForEditing(con);
	}

	/**
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @return  List<ClientAddressDetailVo>
	 * @throws  java.sql.SQLException,DatabaseException
	 */
	@Override
	public List<ClientAddressDetailVo> getCilentAddressForAjax()
			throws SQLException, DatabaseException {
		JobOpportunityPostingDaoi jobOpportunityPostingDaoi=new JobOpportunityPostingDaoimpl();
		Connection con=DbUtil.getConnection();
		return jobOpportunityPostingDaoi.getCilentAddressForAjax(con);
		
		
	}
	/**
	 * @author Srinivas N B-35
	 * @param com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean
	 * @return  Boolean
	 * @throws  java.sql.SQLException,DatabaseException
	 */
	@Override
	public Boolean editJobPosting(JobPostingInsertionFormBean bean)
			throws SQLException, DatabaseException {

		JobOpportunityPostingDaoi jobOpportunityPostingDaoi=new JobOpportunityPostingDaoimpl();
		Connection con=DbUtil.getConnection();
		
		return jobOpportunityPostingDaoi.editJobPosting(con, bean);
	}

  
}
