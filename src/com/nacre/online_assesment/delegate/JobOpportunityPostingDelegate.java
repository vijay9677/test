/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.form_bean.SelectingAllstudentDetailsBean;
import com.nacre.online_assesment.form_bean.SelectingYopOrPercentageBean;
import com.nacre.online_assesment.form_bean.ShareJobOppertunityFormBean;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;
import com.nacre.online_assesment.service_i.JobOpportunityPostingServicei;
import com.nacre.online_assesment.service_i.service_impl.JobOpportunityPostingServiceimpl;

import com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean;
import com.nacre.online_assesment.form_bean.ShowJobDetailsBean;
import com.nacre.online_assesment.service_i.JobOpportunityPostingServicei;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;

import com.nacre.online_assesment.service_i.JobOpportunityPostingServicei;
import com.nacre.online_assesment.service_i.service_impl.JobOpportunityPostingServiceimpl;
import com.nacre.online_assesment.vo.FindJobPostingVO;

import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean;
import com.nacre.online_assesment.service_i.JobOpportunityPostingServicei;
import com.nacre.online_assesment.service_i.service_impl.JobOpportunityPostingServiceimpl;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;
import com.nacre.online_assesment.vo.GetClientDetailForEditingVo;
import com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo;

/**
 * @author Sagar Suryawanshi b 35
 * 
 * 
 */
public class JobOpportunityPostingDelegate {
	public JobOpportunityPostingDelegate() {
		System.out.println("in job posting deligate");
	}

	/**
	 * @author Sagar Suryawanshi b 35
	 * @return List of JobPosting Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */
	public List<Object> getjobPostDetails() throws SQLException,
			DatabaseException {

		JobOpportunityPostingServicei service = new JobOpportunityPostingServiceimpl();
		return service.getjobPostDetails();
	}

	/**
	 * @author Sagar Suryawanshi b 35
	 * @return List of JobPosting Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */

	public List<Object> getjobPostDescription(Integer jobpostid)
			throws SQLException, DatabaseException {

		JobOpportunityPostingServicei service = new JobOpportunityPostingServiceimpl();
		return service.getjobPostDescription(jobpostid);
	}

	/**
	 * @author Sagar Suryawanshi b 35
	 * @return List of JobPosting Objects
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when occurs when Countries are not available
	 */
	public List<Object> findJobPost(FindJobPostingVO jobpostvo)
			throws SQLException, DatabaseException {
		JobOpportunityPostingServicei service = new JobOpportunityPostingServiceimpl();
		return service.findJobPost(jobpostvo);
	}



/**
 * @author Rajnish
 * @return List<ShowJobDetailsBean>
 * @throws DatabaseException
 * @throws SQLException
 */
	
	
	
	public List<ShowJobDetailsBean> getjobPostingIdNotification() throws DatabaseException, SQLException {
		
		JobOpportunityPostingServicei  jbOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
		return jbOpportunityPostingServicei.getjobPostingIdNotification();
	}

/**
 * @author Rajnish
 * @return ShowJobDetailsBean
 * @throws DatabaseException
 * @throws SQLException
 */
	public ShowJobDetailsBean getjobPostingIdNotificationDetail(Integer jobposting_id) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		JobOpportunityPostingServicei  jbOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
		return jbOpportunityPostingServicei.getjobPostingIdNotificationDetail(jobposting_id);
		
	}
	
	
	


	/**
	 * @author vijay kumar p
	 * @param shareJobOppertunityFormBean
	 *            class object carrying details description about job and
	 *            student details
	 * @return ArrayList returns list of emails
	 * @throws DatabaseException
	 *             occurs when problem occurs while connecting with database
	 * @throws SQLException
	 *             occurs when inputs not giving properly
	 * @throws AddressException
	 *             occurs when problem occurs while get any invalid mail address
	 * @throws MessagingException
	 */

	public ArrayList<String> shareJobOppertunity(ShareJobOppertunityFormBean shareJobOppertunityFormBean)
			throws DatabaseException, SQLException, AddressException, MessagingException {
		JobOpportunityPostingServicei jobOpportunityPostingService = null;

		// creating JobOpportunityPostingService class object
		jobOpportunityPostingService = new JobOpportunityPostingServiceimpl();
		// calling service class sharejoboppertunity(-) method
		ArrayList<String> list = jobOpportunityPostingService.shareJobOppertunity(shareJobOppertunityFormBean);
		// returning getting result
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
	public ViewJobNotificationBean viewJobOpportunity(String str) throws DatabaseException, SQLException {
		JobOpportunityPostingServicei jobOpportunityPostingService = null;
		ViewJobNotificationBean viewJobNotificationBean = null;

		// creating service class object
		jobOpportunityPostingService = new JobOpportunityPostingServiceimpl();
		// calling method viewJobOpportunity()
		viewJobNotificationBean = jobOpportunityPostingService.viewJobOpportunity(str);

		// returning viewJobNotificationBean
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
	public ArrayList<SelectingAllstudentDetailsBean> getAllStudEmailsDetails(Integer jobPostingId)
			throws DatabaseException, SQLException {
		JobOpportunityPostingServicei jobOpportunityPostingService = null;
		ArrayList<SelectingAllstudentDetailsBean> list = null;
		// creating JobOpportunityPostingService object
		jobOpportunityPostingService = new JobOpportunityPostingServiceimpl();
		// calling getAllStudentDetails() method
		list = jobOpportunityPostingService.getAllStudEmailsDetails(jobPostingId);
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
	public ArrayList<SelectingYopOrPercentageBean> selectYearOrPer(String percentage, String year, Integer jobPostingId)
			throws SQLException, DatabaseException {
		JobOpportunityPostingServicei jobOpportunityPostingService = null;
		ArrayList<SelectingYopOrPercentageBean> list = null;
		// creating JobOpportunityPostingService class object
		jobOpportunityPostingService = new JobOpportunityPostingServiceimpl();

		// calling selectYearOrPer() methosd
		list = jobOpportunityPostingService.selectYearOrPer(percentage, year, jobPostingId);
		// returning ArrayList which having SelectingyopOrPercetageBean
		return list;
	}


	
	/**
	 * This method will gets all company details form data base
	 * 
	 * @author Srinivas N B-35
	 * @return java.util.List<ClientDTO>
	 * @throws java.sql.SQLException
	 *             ,DatabaseException
	 * 
	 */
public List<ClientDTO> getClientDetails() throws DatabaseException, SQLException{
		
		JobOpportunityPostingServicei jobOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
			
		List<ClientDTO> clientDTOsList=jobOpportunityPostingServicei.getClientDetails();
	   		
		return clientDTOsList;
		
		
		}
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
public Boolean addJobPosting(JobPostingInsertionFormBean fb) throws DatabaseException, SQLException
{
	JobOpportunityPostingServicei  jbOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
	
	Boolean result=jbOpportunityPostingServicei.addJobPosting(fb);
	return result;
	
}

/**
 * retrieving all all technology details
 * 
 * @author Srinivas N B-35
 * @return java.util.List<TechnologyDTO>
 * @throws java.sql.SQLException
 *             ,DatabaseException
 */
public List<TechnologyDTO> getTechnologyDetail() throws DatabaseException, SQLException
{
	
	JobOpportunityPostingServicei  jbOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
	
	List<TechnologyDTO> list=jbOpportunityPostingServicei.getTechnologyDetail();
	
			
	return list;
}

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
public List<ClientAddressDetailVo> getClientAddressDetail( Integer clientId) throws DatabaseException, SQLException
{

	JobOpportunityPostingServicei  jbOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
	List<ClientAddressDetailVo> list=jbOpportunityPostingServicei.getClientAddressDeatail( clientId);
	
	return list;
	
}


/*public Boolean deleteJobPosting()
{
	JobOpportunityPostingServicei  jbOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
	return null;
	
}*/
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
public GettingLocationCurespondingDetailsvo getLocationRelatedAddres(Integer addressId) throws SQLException, DatabaseException{
	
	         JobOpportunityPostingServicei jobOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
	         
	
	return jobOpportunityPostingServicei.getLocationRelatedAddres(addressId);
}

/**
 * This method will gives the all the details related to job posting which
 * are used for editing the job posting
 * @author Srinivas N B-35
 * @return List<GetClientDetailForEditingVo>
 * @throws java.sql.SQLException
 *             ,DatabaseException
 */
public List<GetClientDetailForEditingVo> getClientDetailsForEditing() throws DatabaseException, SQLException{
	
	JobOpportunityPostingServicei jobOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
	
	return jobOpportunityPostingServicei.getClientDetailsForEditing();
}
/*public Boolean deleteJobPosting(Integer jobPostingId) throws DatabaseException, SQLException{
	JobOpportunityPostingServicei jobOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
	Boolean result=jobOpportunityPostingServicei.deleteJobPosting(jobPostingId);
	
	return result;
	
	
}*/

/**
 * @author Srinivas N B-35
 * @param data accepts java.sql.Connection object
 * @param com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean
 * @return  Boolean
 * @throws  java.sql.SQLException
 */
public Boolean editJobPosting(JobPostingInsertionFormBean bean) throws SQLException, DatabaseException{
	
	JobOpportunityPostingServicei jobOpportunityPostingServicei=new JobOpportunityPostingServiceimpl();
	return jobOpportunityPostingServicei.editJobPosting(bean);
}
}
