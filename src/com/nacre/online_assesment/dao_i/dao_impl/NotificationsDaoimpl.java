/**
 * 
 */
package com.nacre.online_assesment.dao_i.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.ListenerNotFoundException;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.mysql.jdbc.Statement;
import com.nacre.online_assesment.dao_i.NotificationsDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.form_bean.JobDetailsBean;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.test.MyEmailValidate;
import com.nacre.online_assesment.vo.AssessmentNotification;
import com.sun.org.apache.regexp.internal.recompile;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.AssesmentTypeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.form_bean.JobDetailsToShowNotificationBean;
import com.nacre.online_assesment.form_bean.SendingUserNumsAndExamDetails;
import com.nacre.online_assesment.util.StringConstants;


/**
 * @author Manish kumar deo
 * @author Mounika
 *
 */
public class NotificationsDaoimpl implements NotificationsDaoi {
	/* (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.NotificationsDaoi #getnotificatioRegardingAssessmentToTechAdminDao(java.sql.Connection)
	 */
	/* (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.NotificationsDaoi#getAssessmentNotification_stud(java.sql.Connection)
	 */
      
	@Override
	public List<AssessmentNotification> studentNotification(Integer userId, Connection con) throws DatabaseException,Exception {
		// TODO Auto-generated method stub
		java.sql.PreparedStatement ps = null;
		
		List list=null;
		try{
			ps= con.prepareStatement(SQLQueryConstants.GET_ASSESMENT_NOTI_STUDENT);
			ps.setInt(1, userId);
			//execute the resultset
			 ResultSet rs =ps.executeQuery();
			 //create object of arraylist
			list=new ArrayList<AssessmentNotification>();
			 if(rs!=null){
				//iterate the resultset
				 while(rs.next()){
					 AssessmentNotification notificationVo=new AssessmentNotification();
					 System.out.println("Records are available");
					//set the data in AssessmentNotification 
					 notificationVo.setAssessment_id(rs.getInt(1));
					 notificationVo.setAssessment_name(rs.getString(2));
					 notificationVo.setTotal_marks(rs.getInt(3));
					 notificationVo.setDuration_in_min(rs.getInt(4));
					 notificationVo.setDate(rs.getDate(5));
					 notificationVo.setCourse(rs.getString(6));
					 notificationVo.setAssessment_type_name(rs.getString(7));
					//set into list
					 list.add(notificationVo);
				 }
				 
			 }
			
			 
			 
		}
		//if database access error or other errors.
		catch(SQLException se){
			se.printStackTrace();
			throw new DatabaseException(se.getMessage());
		}
		//return as list
		return list;
	}

	@Override
	// method to get the all details regarding assessment for tech team
	public List notificatioRegardingAssessmentToTechAdminDao(Connection connection) throws SQLException {
		// creating prepare statement object
		PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstants.ASSESSMENT_DETAILS_NOTIFICATION_QRY);
		// creating resultSet object to execute query
		ResultSet resultSet = preparedStatement.executeQuery();
		// creating List object to hold dto objects and send to action
		List list = new ArrayList<AssesmentDTO>();
		// creating Dto objects to hold the Assessment Details
		AssesmentDTO assessmentDto = null;
		AssesmentTypeDTO assessmentTypeDto = null;
		CourseDTO courseDto = null;
		LevelDTO levelDto = null;
		// checking records existed or not
		if (resultSet != null) {
			// Iterating ResultSet and storing values into DTO object
			while (resultSet.next()) {
				assessmentDto = new AssesmentDTO();
				assessmentTypeDto = new AssesmentTypeDTO();
				levelDto = new LevelDTO();
				courseDto = new CourseDTO();
				
				assessmentDto.setAssesmentId(resultSet.getInt(1));
				assessmentDto.setAssesment(resultSet.getString(2));
				assessmentDto.setTotalMarks(resultSet.getInt(3));
				assessmentDto.setDurationInMin(resultSet.getInt(4));
				assessmentDto.setDate(resultSet.getDate(5));
				// first setting single parameter and then passing that obj reference
				courseDto.setCourse(resultSet.getString(6));
				assessmentDto.setCourse(courseDto);
				assessmentTypeDto.setAssesmentTypeName(resultSet.getString(7));
				assessmentDto.setAssesmentType(assessmentTypeDto);
				levelDto.setLevel(resultSet.getString(8));
				assessmentDto.setLevel(levelDto);
				// adding above dto object to th list
				list.add(assessmentDto);
			} // while
		} // if
		else {
			System.out.println("no new Assessment is Available");
		}
		// returning list obj to caller method
		return list;

	}
	/*@Override
	 * 
	*//**
	 * @author Gajanan
	 * 
	 *//*
	public void accepetedOrRejected(Connection con, String email,int jobPostingID) {
		// TODO Auto-generated method stub
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int userID = 0, interviewRoundID = 0;
		
		String query = null;
		try {
			
			ps = con.prepareStatement("select u.user_id,ir.interview_round_id from tbl_user u,tbl_interview_round ir where ir.round_no=1 and ir.job_posting_id=? and u.email='gajanandebadwar3@gmail.com'",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			//ps.setInt(1,1);
			ps.setInt(1,jobPostingID);
			//ps.setString(3,email);
			rs = ps.executeQuery();
			if(rs.next())
			{
				userID   		 = rs.getInt(1);
				interviewRoundID = rs.getInt(2);
			}
			
			
					 query="update tbl_elegible_student set status_id=5 where user_id=?  and interview_round_id=? ";
						
						ps = con.prepareStatement(query,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
						ps.setInt(1,userID);
						ps.setInt(2, interviewRoundID);
					   											
						int n = ps.executeUpdate();
						System.out.println("records updated:"+n);
				   
						
				  
			
			    
	
		
			
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	*/
	
	@Override
	/**
	 * @author Gajanan
	 * 
	 */
	public List<JobDetailsBean> getJobDetailsToShowNotification(Connection con, String email)  {
		// TODO Auto-generated method stub
		
		List<JobDetailsBean> list = new ArrayList<JobDetailsBean>();
		
		boolean flag = MyEmailValidate.validateEmailAddress(email);
		String query = null;
		
		if(flag==true) 
		{
			query = SQLQueryConstants.GET_NOTIFICATION_DETAILS_BY_EMAIL;
		}
		else{
			
			query = SQLQueryConstants.GET_NOTIFICATION_DETAILS_BY_MOBILENO;
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		JobDetailsBean bean = null;
		
		
		try {
			
				ps = con.prepareStatement(query);
				ps.setInt(1, StringConstants._ELIGIBLE_FOR_JOB_POST);
				ps.setString(2, email);
				rs = ps.executeQuery();
				
				System.out.println(rs);
				
					
			
				while(rs.next())
				{
					bean = new JobDetailsBean();
					bean.setJobPostingID(rs.getInt(1));
					bean.setCompanyName(rs.getString(2));
					bean.setJobDescription(rs.getString(3));
					bean.setCompanyLogo(rs.getString(4));
					bean.setCity(rs.getString(5));
					bean.setTechnology(rs.getString(6));
					
					
					list.add(bean);
					
				}
				
			  
				
				
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	/**
	*
*	@Override
*	public JobDetailsBean showJobDetails(Connection con, int jobPostingID) {
		// TODO Auto-generated method stub
*		String query="select client_name,image,location,city,state,country,contact_person_name,client_description,description,contact_person_mobile_no,contact_person_mail,expected_date,assesment_start_date,assesment_end_date,posted_date,no_of_vacancies,technology from tbl_client c,tbl_client_address ca,tbl_job_posting j,tbl_state st,tbl_country co,tbl_technology t,tbl_address ad,tbl_city ct  where c.client_id=ca.client_id and ca.client_address_id=j.client_address_id and j.client_address_id=ad.address_id and ad.address_id=ct.city_Id and ct.state_id=st.state_id and st.country_id=co.country_id and j.tbl_technology_technology_id=t.technology_id and j.job_posting_id=? and j.assesment_start_date>curdate();";
*		PreparedStatement ps = null;
		ResultSet rs = null;
		JobDetailsBean jdBean = null;
		
		try {
			
			ps = con.prepareStatement(query);
			ps.setInt(1,jobPostingID );
			rs = ps.executeQuery();
			jdBean = new JobDetailsBean();
			while(rs.next())
			{
				jdBean.setCompanyName(rs.getString(1));
				jdBean.setCompanyLogo(rs.getString(2));
				jdBean.setLocation(rs.getString(3));
				jdBean.setCity(rs.getString(4));
				jdBean.setState(rs.getString(5));
				jdBean.setCountry(rs.getString(6));
				jdBean.setContactPersonName(rs.getString(7));
				jdBean.setCompanyDescription(rs.getString(8));
				jdBean.setJobDescription(rs.getString(9));
				jdBean.setContactPersonMobno(rs.getString(10));
				jdBean.setContactPersonMail(rs.getString(11));
				jdBean.setExpectedDate(rs.getDate(12));
				jdBean.setAssesmentStartDate(rs.getDate(13));
				jdBean.setAssesmentEndDate(rs.getDate(14));
				jdBean.setPostedOn(rs.getDate(15));
				jdBean.setVacancy(rs.getInt(16));
				jdBean.setTechnology(rs.getString(17));
					
				}
				
				System.out.println("dao:"+jdBean);
			
			
		}
		catch (SQLException e) {
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
	 * @throws SQLExceptio 
	 */
	public List<String> getDateAndRoundDescriptionInAjaxCall(Connection con,Integer jobPostingId) throws SQLException{
		String query="select ir.description,ir.date from tbl_interview_round ir where ir.job_posting_id=? and ir.round_no=1";
	PreparedStatement	ps=con.prepareStatement(query);
	ps.setInt(1, jobPostingId);
    ResultSet rs=ps.executeQuery();
    List<String> dateDescriptionList=null;
    if(rs.next()){
    	dateDescriptionList=new ArrayList<String>();
    	dateDescriptionList.add(rs.getString(1));
    	dateDescriptionList.add(rs.getString(2));
    	
    }
    return dateDescriptionList;
	}//method
	
	/**
	 * @author vijaykumar P
	 * @param userAndExamDetails which carrying Userid and examd date and jobposting id details
	 * @param conn getting from DBUtils class which is using to connect the database 
	 * @return List<String> which returns list of emails
	 * @throws SQLException
	 */
	
	@Override
	public List<String> sendingNotificationToSelectedStudent(SendingUserNumsAndExamDetails userAndExamDetails, Connection conn) throws SQLException{
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		
		//creating list object
		List<String> emails= new ArrayList<String>();
		//Integer []autoGeneratedKeys=null;
		//preparing query for inserting job details in tbl_interview_round for students
		/*String qury="INSERT INTO tbl_interview_round (`round_no`, `job_posting_id`, "
				+ "`description`, `date`, `status_id`, `address_id`)	VALUES (?, ?,?,?,"
				+ " (select status_id from tbl_user u where u.user_id=?),"
				+ " (select a.address_id from tbl_job_posting j "
				+ "left join tbl_client_address ca on ca.client_address_id=j.client_address_id "
				+ "left join tbl_address a on a.address_id=ca.address_id where j.job_posting_id=?))";*/
		//preparing query for inserting eligible student details in tbl_elegible_student
		
		//String qry_elgible="INSERT INTO tbl_elegible_student (`interview_round_id`, `user_id`, `status_id`) VALUES (?,?,?)";
		
		//preparing query for retrieving eligible student emails from tbl_user
		//String selectingEmail="select u.email from tbl_user u, tbl_elegible_student es where es.user_id=u.user_id and es.elegible_student_id=?";
		
		//creating prepareStatement for inserting job details in tbl_interview_round for students
		ps=conn.prepareStatement(SQLQueryConstants.QRY_INSERTING_STUDENT_INTERVIEW_ROUND, Statement.RETURN_GENERATED_KEYS);
		//creating prepareStatement for inserting job details in tbl_elegible_student for students
		ps1=conn.prepareStatement(SQLQueryConstants.QRY_ELEGIBLE_STUDENT, Statement.RETURN_GENERATED_KEYS);
		//creating prepareStatement for retrieving student emails from tbl_user 
		ps2=conn.prepareStatement(SQLQueryConstants.QRY_ELEGIBLE_STUDENT_EMAILS);
		
		//storing userId in list
		List<Integer> usernoList=userAndExamDetails.getUserNo();
		
		
		System.out.println("daoimpl userno list"+ usernoList);
		//getting userids from list iterating through for each loop
				
		//System.out.println("daoimpl  "+str);
		//setting values to prepare statement
		ps.setInt(1, 1);
		ps.setInt(2,userAndExamDetails.getJobPostId());
		ps.setString(3, userAndExamDetails.getExamName());
		ps.setDate(4,java.sql.Date.valueOf(userAndExamDetails.getDate()));
		ps.setInt(5, StringConstants._INTERVIEW_STSTUS);
		ps.setInt(6,userAndExamDetails.getJobPostId());
		// executing query
		ps.executeUpdate();
		//getting auto generated key values
		//rs = ps.getGeneratedKeys();
		for(Integer str:usernoList){
			rs = ps.getGeneratedKeys();
		if(rs != null && rs.next()){
			//setting values to prepare statement
			ps1.setInt(1, rs.getInt(1));
			ps1.setInt(2,str);
			ps1.setInt(3,StringConstants.ELEGIBLE_STUDENT_STATUS_ID);
			//executing prepareStatement
			ps1.executeUpdate();
			//getting auto generated values
			rs1=ps1.getGeneratedKeys();
			
			if(rs1!=null&& rs1.next()){
				System.out.println("emails list ......");
				System.out.println("daoimpl  "+rs1.getInt(1));
				//setting values to prepared Statement
				ps2.setInt(1, rs1.getInt(1));
				//executing query
				rs2=ps2.executeQuery();
				while(rs2.next()){
					System.out.println("email address "+rs2.getString(1));
					//storing or adding emailid's to list object
					emails.add(rs2.getString("email"));
					
				}
			}
		}
		
		
				}
		
	
		
		
				//returning list of emailid's
		return emails;
			
		}
	
		
		
		
	
	/**
	 * @author vijaykumar P
	 * @param con getting connection from dbutil
	 * @return List which returns job postingid, client name,job Description,company image in the form of JobDetaislsToShowNptificationBean object format
	 * @throws SQLException
	 */
	
	@Override
	public List getJobDetailsToShowNotification(Connection con,int userNo) throws SQLException {
		
		//creating a list object which can stores JobDetailsToShowNotificationBean objects
		List list = new ArrayList();
		//preparing a sql query for retrieving job details
		/*String query="select job_posting_id,client_name,job.description,c.image from tbl_job_posting job,"
				+ "tbl_client_address ca,tbl_client c,tbl_user u where  job.client_address_id=ca.client_address_id "
				+ "and u.address_id=ca.address_id and ca.client_address_id=c.client_id and u.user_id= ? "
				+ " and job.assesment_start_date>curdate()";*/
		PreparedStatement ps = null;
		ResultSet rs = null;
		JobDetailsToShowNotificationBean bean = null;
		
	
		//creating prepareStatement	
				ps = con.prepareStatement(SQLQueryConstants.GETTING_ALL_ADMIN_NOTIFICATION);
				//executing query
				ps.setInt(1, userNo);
				
				rs = ps.executeQuery();
				
				//iterating the which which we are getting result
				while(rs.next())
				{
					//creating JobDetailsToShowNotificationBean Object
					bean = new JobDetailsToShowNotificationBean();
					//storing values in jobDetailsTOShowBean object
					bean.setJobPostingID(rs.getInt(1));
					bean.setCompanyName(rs.getString(2));
					bean.setJobDescription(rs.getString(3));
					bean.setCompanyLogo(rs.getString(4));
					//adding jobDetailsToShowShowNotification Object to List
					list.add(bean);
					
				}
				
			
		
		//returning the List
		return list;
	}
	
	
	
}
