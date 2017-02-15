/**
 * 
 */
package com.nacre.online_assesment.dao_i;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean;
import com.nacre.online_assesment.form_bean.SelectingAllstudentDetailsBean;
import com.nacre.online_assesment.form_bean.SelectingYopOrPercentageBean;
import com.nacre.online_assesment.form_bean.ShareJobOppertunityFormBean;
import com.nacre.online_assesment.form_bean.ShowJobDetailsBean;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;
import com.nacre.online_assesment.vo.FindJobPostingVO;
import com.nacre.online_assesment.vo.GetClientDetailForEditingVo;
import com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface JobOpportunityPostingDaoi {
	/**
	 * @author vijaykumar P
	 * @return ArrayList carries emailId's
	 * @param conn Carries DB connection
	 * @param shareJobOppertunityFormBean which carries student info for selecting students email
	 * @throws SQLException
	 */
public	ArrayList<String> shareJobOppotunity(Connection conn, ShareJobOppertunityFormBean shareJobOppertunityFormBean) throws SQLException;

	/**
	 * @author Sagar Suryawanshi b 35
	 * @param con Accepts java.sql.Connection
	 * @return List contains all Job post object
	 * @throws DataNotFoundException occurs when no object is available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	
	public List<Object> getjobPostDetails(Connection con) throws SQLException;

	/**
	 * @author Sagar Suryawanshi b 35
	 * @param con Accepts java.sql.Connection
	 * @return List contains all Job post object
	 * @throws DataNotFoundException occurs when no object is available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<Object> getjobPostDescription(Integer jobpostid, Connection con) throws SQLException;

	/**
	 * @author Sagar Suryawanshi b 35
	 * @param con Accepts java.sql.Connection
	 * @return List contains all Job post object
	 * @throws DataNotFoundException occurs when no object is available
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	public List<Object> findJobPost( FindJobPostingVO jobpostvo,Connection con) throws SQLException;

	/*
	
	public boolean addJobPosting(Connection con,JobPostingInsertionFormBean fb) throws SQLException;
	public List<TechnologyDTO> getTechnologyDetail(Connection con) throws SQLException;
	public List<ClientAddressDetailVo> getClientAddressDeatail(Connection con,Integer clientId) throws SQLException;
	*/
	/*public Boolean deleteJobPosting(Connection con,Integer jobPostingId) throws SQLException;*/
	
	
	
	/** THIS METHOD RETURN ALLNOTIFICATION 
	 * @author Rajnish
	 * @return List  
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public List<ShowJobDetailsBean> getjobPostingIdNotification(Connection con) throws DatabaseException, SQLException;
	
	/**
	 * THIS METHOD RETURN ALL JOB POSTING DETAIL
	 * @author Rajnish
	 * @param java.sql.Connection
	 * @param Integer
	 * @return ShowJobDetailsBean 
	 * @throws SQLException
	 */
	public ShowJobDetailsBean getjobPostingIdNotificationDetail(Connection con,Integer jobposting_id) throws SQLException;
/**
 * @author vijaykumar P
 * @param conn which carries DB connection from database
 * @param str which carries jobpostid
 * @return ViewJobNotificationBean object which carries job details
 * @throws SQLException
 */
public ViewJobNotificationBean viewJobOpportunity(Connection conn, String str) throws SQLException;

/**
 * @author vijaykkumr P
 * @param conn which Carries DB connection
 * @param jobPostingId
 * @return ArraList which carries student details
 * @throws SQLException
 */
public ArrayList<SelectingAllstudentDetailsBean> getAllStudEmailsDetails(Connection conn, Integer jobPostingId) throws SQLException;


/**
 * @author vijaykumar P
 * @param percentage which Carries student academic percentage 
 * @param year which carries student graduation year of passed out
 * @param conn which carries Database connection
 * @param jobPostingId
 * @return ArrayList returns student details
 * @throws SQLException
 */
public ArrayList<SelectingYopOrPercentageBean> selectYearOrPer(String percentage, String year,Connection conn, Integer jobPostingId) throws SQLException;
	
	
	/**
	 * This method will gets all company details form data base 
	 * @author Srinivas N B-35
	 * @param date accepts java.sql.Connection object
	 * @return  java.util.List<ClientDTO>
	 * @throws  java.sql.SQLException
	 */
	public List<ClientDTO> getClientDetails(Connection con) throws SQLException;
	


	/**
	 * insert new Job posting in to database or adds new record in to tbl_job_posting
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @param data accepts com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean
	 * @return  Boolean
	 * @throws  java.sql.SQLException
	 */
	public Boolean addJobPosting(Connection con,JobPostingInsertionFormBean fb) throws SQLException;
	
	/**
	 * retrieving all all technology details 
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @return  java.util.List<TechnologyDTO>
	 * @throws  java.sql.SQLException
	 */
	public List<TechnologyDTO> getTechnologyDetail(Connection con) throws SQLException;
	
	/**
	 * this method will return particular client address details based on the address id
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @param accepts java.lang.Integer
	 * @return  java.util.List<ClientAddressDetailVo>
	 * @throws  java.sql.SQLException
	 */
	public List<ClientAddressDetailVo> getClientAddressDeatail(Connection con,Integer clientId) throws SQLException;
	
	/**
	 * based on the address id it will gives the city, State, Country, Pin Code details
	 * @author Srinivas N B-35
	 * @param accepts java.lang.Integer
	 * @param data accepts java.sql.Connection object
	 * @return  com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo
	 * @throws  java.sql.SQLException
	 */
	public GettingLocationCurespondingDetailsvo getLocationRelatedAddres(Integer addressId,Connection con) throws SQLException;
	
	/**
	 * This method will gives the all the details related to job posting which are used 
	 * for editing the job posting
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @return  List<GetClientDetailForEditingVo>
	 * @throws  java.sql.SQLException
	 */
	public List<GetClientDetailForEditingVo> geClientDetailsForEditing(Connection con) throws SQLException;
	
	/**
	 * 
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @return  List<ClientAddressDetailVo>
	 * @throws  java.sql.SQLException
	 */
	public List<ClientAddressDetailVo> getCilentAddressForAjax(Connection con)throws SQLException;
	
	/**
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @param com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean
	 * @return  Boolean
	 * @throws  java.sql.SQLException
	 */
	
	public Boolean editJobPosting(Connection con,JobPostingInsertionFormBean bean)throws SQLException;
	
	/**
	 * @author Rajnish 
	 * @param Connection
	 * @return UserDTO
	 * @throws SQLException
	 */
	public List<UserDTO> emailAccess(Connection con) throws SQLException ;
	//not required this functionality
		//public Boolean deleteJobPosting(Connection con,Integer jobPostingId) throws SQLException;
		
	
}

