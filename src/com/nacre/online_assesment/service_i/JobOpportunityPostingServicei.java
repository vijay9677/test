package com.nacre.online_assesment.service_i;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.form_bean.SelectingAllstudentDetailsBean;
import com.nacre.online_assesment.form_bean.SelectingYopOrPercentageBean;
import com.nacre.online_assesment.form_bean.ShareJobOppertunityFormBean;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;

import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean;
import com.nacre.online_assesment.form_bean.ShowJobDetailsBean;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;

import com.nacre.online_assesment.vo.FindJobPostingVO;

import com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;
import com.nacre.online_assesment.vo.GetClientDetailForEditingVo;
import com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo;

/**
 * @author Vijay Kumar Reddy K
 * 
 */
public interface JobOpportunityPostingServicei {
	
	
	
	
	/**
	 * @author Rajnish
	 * @return java.util.List Contains job post ClientAddressDetailvo Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 *//*
	public List<ClientAddressDetailVo> getClientDetail(Integer clientId) throws DatabaseException, SQLException;
	
	*/

	/**
	 * @author Rajnish
	 * @return java.util.List Contains joPostingDto  Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no jobPostingId  are available
	 */
	public List<ShowJobDetailsBean> getjobPostingIdNotification() throws DatabaseException, SQLException;

	/**
	 * @author Rajnish
	 * @return showJobdetailBean Contains job post Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no Detail are Availabel are available
	 */
	public ShowJobDetailsBean getjobPostingIdNotificationDetail(int jobposting_id) throws DatabaseException, SQLException;
	
	


	

	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains job post Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	public List<Object> getjobPostDetails() throws SQLException, DatabaseException;
	
	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains job post Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	public List<Object> getjobPostDescription(Integer jobpostid) throws SQLException, DatabaseException;
	
	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains job post Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	public List<Object> findJobPost(FindJobPostingVO jobpostvo) throws SQLException, DatabaseException;

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
	public ArrayList<String> shareJobOppertunity(ShareJobOppertunityFormBean shareJobOppertunityFormBean)
			throws DatabaseException, SQLException, AddressException, MessagingException;

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
	public ViewJobNotificationBean viewJobOpportunity(String str) throws DatabaseException, SQLException;

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
	public ArrayList<SelectingAllstudentDetailsBean> getAllStudEmailsDetails(Integer jobPostingId)
			throws DatabaseException, SQLException;

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
	public ArrayList<SelectingYopOrPercentageBean> selectYearOrPer(String percentage, String year, Integer jobPostingId)
			throws SQLException, DatabaseException;

	/**
	 * This method will gets all company details form data base
	 * 
	 * @author Srinivas N B-35
	 * @return java.util.List<ClientDTO>
	 * @throws java.sql.SQLException
	 *             ,DatabaseException
	 * 
	 */
	public List<ClientDTO> getClientDetails() throws DatabaseException,
			SQLException;

	/**
	 * insert new Job posting in to database or adds new record in to
	 * tbl_job_posting
	 * 
	 * @author Srinivas N B-35
	 * @param data
	 *            accepts com.nacre.online_assesment.form_bean.
	 *            JobPostingInsertionFormBean
	 * @return Boolean
	 * @throws java.sql.SQLException
	 *             ,DatabaseException
	 */
	public Boolean addJobPosting(
			JobPostingInsertionFormBean jobPostingInsertionFormBean)
			throws DatabaseException, SQLException;

	/**
	 * retrieving all all technology details
	 * 
	 * @author Srinivas N B-35
	 * @return java.util.List<TechnologyDTO>
	 * @throws java.sql.SQLException
	 *             ,DatabaseException
	 */
	public List<TechnologyDTO> getTechnologyDetail() throws DatabaseException,
			SQLException;

	/**
	 * this method will return particular client address details based on the
	 * address id
	 * 
	 * @author Srinivas N B-35
	 * @param accepts
	 *            java.lang.Integer
	 * @return java.util.List<ClientAddressDetailVo>
	 * @throws java.sql.SQLException
	 *             ,DatabaseException
	 */
	public List<ClientAddressDetailVo> getClientAddressDeatail(Integer clientId)
			throws DatabaseException, SQLException;

	/**
	 * based on the address id it will gives the city, State, Country, Pin Code
	 * details
	 * 
	 * @author Srinivas N B-35
	 * @param accepts
	 *            java.lang.Integer
	 * @return 
	 *         com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo
	 * @throws java.sql.SQLException
	 *             ,DatabaseException
	 */
	public GettingLocationCurespondingDetailsvo getLocationRelatedAddres(
			Integer addressId) throws SQLException, DatabaseException;

	/**
	 * This method will gives the all the details related to job posting which
	 * are used for editing the job posting
	 * @author Srinivas N B-35
	 * @return List<GetClientDetailForEditingVo>
	 * @throws java.sql.SQLException
	 *             ,DatabaseException
	 */
	public List<GetClientDetailForEditingVo> getClientDetailsForEditing()
			throws DatabaseException, SQLException;

	/**
	 * @author Srinivas N B-35
	 * @return List<ClientAddressDetailVo>
	 * @throws java.sql.SQLException
	 *             ,DatabaseException
	 */

	public List<ClientAddressDetailVo> getCilentAddressForAjax()
			throws SQLException, DatabaseException;

	/**
	 * @author Srinivas N B-35
	 * @param com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean
	 * @return  Boolean
	 * @throws  java.sql.SQLException,DatabaseException
	 */
	public Boolean editJobPosting(JobPostingInsertionFormBean bean)
			throws SQLException, DatabaseException;

	/*
	 * Delete the job Posting client Detail public Boolean
	 * deleteJobPosting(Integer jobPostingId) throws DatabaseException,
	 * SQLException;
	 */

}
