package com.nacre.online_assesment.db_util;

import java.sql.SQLException;
import com.nacre.online_assesment.util.StringConstants;

/**
 * @author Manish kumar deo
 * @version 1.0.0 2016
 * @author Nacre Batch 35 Java This class contains declaration of all the sql
 *         query constants , which are going to be used in Data Access Object
 *         classes.
 * 
 * 
 */
public class SQLQueryConstants {
	


	private SQLQueryConstants(){
		
	}
	
/**
* @author Arvind Kumar
* INSERT_ADD_ADMIN_SQL_QUERY IS USED TO INSERT DATA IN DATABASE.
*/	
public static final String INSERT_ADD_ADMIN_SQL_QUERY ="insert into tbl_user(first_name,last_name,email,password,mobile_no,gender,image,d_o_b,role_id,status_id) values(?,?,?,?,?,?,?,?,?,"+StringConstants._ACTIVE_STATUS_ID+")";

/**
* @author Arvind Kumar
* DELETE_ADMIN_SQL_QUERY IS USED TO INSERT DATA IN DATABASE.
*/
public static final String DELETE_ADMIN_SQL_QUERY ="DELETE FROM tbl_user WHERE user_id=?";

/**
* @author Arvind Kumar
* EDIT_ADMIN_SQL_QUERY IS USED TO INSERT DATA IN DATABASE.
*/
public static final String EDIT_ADMIN_SQL_QUERY = "Update tbl_user set first_name=?, last_name=?, email=?, mobile_no=?, gender=?, image=?, role_id= ?,status_id=? where user_id=?";

/**
* @author Arvind Kumar
* GET_ADMIN_RECORDS_SQL_QUERY IS USED TO GET ADMIN RECORDS FROM DATABASE.
*/
public static final String GET_ADMIN_RECORDS_SQL_QUERY="SELECT tbl_user.user_id, tbl_user.first_name, tbl_user.last_name, tbl_user.email, tbl_user.mobile_no, tbl_user.gender, tbl_role.role from tbl_user,tbl_role where tbl_user.role_id=tbl_role.role_id and tbl_user.user_id <> ? and tbl_role.role_id <> "+StringConstants._STUDENT_ROLE_ID;
/**
* @author Arvind Kumar
* GET_GROUP_BY_ADMIN_RECORDS_SQL_QUERY IS USED TO GET Group By ADMIN RECORDS FROM DATABASE.
*/
public static final String GET_GROUP_BY_ADMIN_RECORDS_SQL_QUERY="SELECT tbl_user.user_id, tbl_user.first_name, tbl_user.last_name, tbl_user.email, tbl_user.mobile_no, tbl_user.gender, tbl_role.role from tbl_user,tbl_role where tbl_user.role_id=tbl_role.role_id and tbl_user.role_id=?";
/**
* @author Arvind Kumar
* VIEW_ADMIN_RECORDS_SQL_QUERY IS USED TO GET ADMIN RECORDS FROM DATABASE.
*/
public static final String VIEW_ADMIN_RECORDS_SQL_QUERY="SELECT * from tbl_user,tbl_role where tbl_user.role_id=tbl_role.role_id and tbl_user.user_id=?";
/**
* @author Arvind Kumar
* GET_PERTICULAR_ADMIN_RECORDS_SQL_QUERY IS USED TO GET ADMIN RECORDS FROM DATABASE.
*/
public static final String GET_PERTICULAR_ADMIN_RECORDS_SQL_QUERY="Select * from tbl_user where user_id=?";

	/**
	 * @author Chitranshu Gupta B-35
	 * INSERT_SCORES IS USED TO INSERTING ASSESSMENT RESULT SCORES 
	 */
	public static final String INSERT_SCORES = "insert into tbl_student_course_attempt (tech_courses_id, attempt_no, total_marks, user_id) values(?,?,?,?)";

	/** 
	 * @author NagaRaj and Jahid Rehman QRY_LOGIN is query to get userDto Object
	 * @author Manish kumar deo Student notification query to get
	 *         AssessmentNotification object
	/**
	 * @author Krishna Prakash
	 * INSERT_QUESTION is query to insert question into tbl_question
	 */
	
	public static final String INSERT_QUESTION="insert into tbl_question(question,level_id) values(?,?)";
	/**
	 * @author Krishna Prakash
	 * INSERT_OPTIONS is query to insert question into tbl_question_option
	 */
	public static final String INSERT_OPTIONS="INSERT INTO tbl_question_option (`option`, `is_answer`, `question_id`) VALUES (?,?,?)";
	/**
	 * @author Krishna Prakash
	 * INSERT_QUESTION is query to insert question into tbl_question
	 */
	public static final String INSERT_ASSESSMENT_QUESTION="insert into tbl_assment_question(assessment_id,question_id) values(?,?)";
	/**
	 * @author Krishna Prakash
	 * DELETE_ASS_PAPER_QUESTIONS is query to delete question into tbl_question
	 */
	public static final String DELETE_ASS_PAPER_QUESTIONS="delete from  tbl_question where question_id in (select question_id from tbl_assment_question where assessment_id=?)";
	public static final String SELECT_ASS_PAPER="select question_id from tbl_assment_question where assessment_id =?";
	/**
	 * @author Krishna Prakash
	 * GET_ASSESSMENT_PAPER is query to get assessment
	 */
	public static final String GET_ASSESSMENT_PAPER="select assessment_id,assessment_name from tbl_assessment where assessment_id in(select assessment_id from tbl_assment_question) ";
	
	
	
	
	/**
	 * @author JAY SINGH
	 * QRY_LOGIN  is query to get userDto Object 
	 */
	public static final String TRAINEE_QRY_LOGIN = "select user_id ,first_name,last_name,status_id,role_id,image,gender,technology_id from tbl_user where email_id=? and password=? and status_id <>"+StringConstants._IN_ACTIVE_STATUS_ID;
	/**
	 * @author Manish kumar deo GET_ASSESMENT_NOTI_STUDENT IS USED TO GET ALL
	 *         ASSESSMENT NOTIFICATION BASED ON USERID
	 */
	public static final String GET_ASSESMENT_NOTI_STUDENT = "select a.assessment_id,a.assessment_name,a.total_marks,a.duration_in_min,a.date,c.course,n.assessment_type_name "
			+ " from tbl_assessment a "
			+ " left join tbl_course c on c.course_id=a.course_id "
			+ " left join tbl_tbl_tech_courses cs on cs.course_id=c.course_id "
			+ " inner join tbl_user u on u.technology_id=cs.technology_id "
			+ " and u.user_id=?"

			+ " left join tbl_assessment_type n on n.assessment_type_id=a.assessment_type_id "
			+ " where a.date > now()";
	/**
	 * @author Sagar Suryawanshi B-35 Java VIEW_JOB_POST_DETAILS IS QUERY TO GET
	 *         JOBPOSTINGDTO OBJECT
	 */
	// public static final String VIEW_JOB_POST_DETAILS ="select
	// job_posting_id,description from tbl_job_posting";
	public static final String VIEW_JOB_POST_DETAILS = "SELECT clients.client_name,addrs.location,jobposting.description,jobposting.posted_date,jobposting.job_posting_id,statuses.status_id,clients.image,clients.description ,city.city,state.state,technology.technology FROM tbl_job_posting jobposting LEFT OUTER JOIN tbl_technology technology ON jobposting.tbl_technology_technology_id=technology.technology_id LEFT OUTER JOIN tbl_interview_round rounds ON jobposting.job_posting_id=rounds.job_posting_id LEFT OUTER JOIN tbl_status statuses ON rounds.status_id=statuses.status_id LEFT OUTER JOIN tbl_client_address address ON jobposting.client_address_id=address.client_address_id LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.city_Id where jobposting.posted_date>=sysdate()";

	/**
	 * @author Sagar Suryawanshi B-35 Java VIEW_JOB_POST_DESCRIPTION IS QUERY TO
	 *         GET JOBPOSTINGDTO OBJECT
	 */
	public static final String VIEW_JOB_POST_DESCRIPTION = "SELECT clients.client_name,addrs.location,jobposting.description,jobposting.posted_date,statuses.status_id,clients.image,clients.description,city.city,state.state,technology.technology FROM tbl_job_posting jobposting LEFT OUTER JOIN tbl_technology technology ON jobposting.tbl_technology_technology_id=technology.technology_id LEFT OUTER JOIN tbl_interview_round rounds ON jobposting.job_posting_id=rounds.job_posting_id LEFT OUTER JOIN tbl_status statuses ON rounds.status_id=statuses.status_id LEFT OUTER JOIN tbl_client_address address ON jobposting.client_address_id=address.client_address_id LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.city_Id where jobposting.job_posting_id=?";

	/**
	 * @author Sagar Suryawanshi B-35 Java GET_JOB_POST_CITY IS USED TO GET ALL
	 *         CITY RELATED TO ALL JOB POST
	 */
	public static final String GET_JOB_POST_CITY = "select tbl_city.city_id,tbl_city.city from tbl_city";

	/**
	 * @author Sagar Suryawanshi B-35 Java GET_JOB_POST_COMPANY IS USED TO GET
	 *         ALL COMPANY RELATED TO ALL JOB POST
	 */
	public static final String GET_JOB_POST_COMPANY = "select tbl_client.client_id,tbl_client.client_name from tbl_client;";

	/**
	 * @author Sagar Suryawanshi B-35 Java FIND_JOB_POST IS USED TO FIND JOB
	 *         RELATED TO COMPANY ,CITY,TECHNOLOGY
	 */
	public static final String FIND_JOB_POST = "SELECT clients.client_name,addrs.location,jobposting.description,jobposting.posted_date,jobposting.job_posting_id,statuses.status_id,clients.image,clients.description,city.city,state.state,technology.technology FROM tbl_job_posting jobposting LEFT OUTER JOIN tbl_technology technology ON jobposting.tbl_technology_technology_id=technology.technology_id LEFT OUTER JOIN tbl_interview_round rounds ON jobposting.job_posting_id=rounds.job_posting_id LEFT OUTER JOIN tbl_status statuses ON rounds.status_id=statuses.status_id LEFT OUTER JOIN tbl_client_address address ON jobposting.client_address_id=address.client_address_id LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.city_Id where clients.client_id=? and city.city_Id=? and technology.technology_id=? and jobposting.posted_date>=sysdate()";

	/**
	 * @author Sagar Suryawanshi B-35 Java FIND_JOB_POST_BY_CITY_TECHNOLOGY IS
	 *         USED TO FIND JOB RELATED TO CITY,TECHNOLOGY
	 */
	public static final String FIND_JOB_POST_BY_CITY_TECHNOLOGY = "SELECT clients.client_name,addrs.location,jobposting.description,jobposting.posted_date,jobposting.job_posting_id,statuses.status_id,clients.image,clients.description,city.city,state.state,technology.technology FROM tbl_job_posting jobposting LEFT OUTER JOIN tbl_technology technology ON jobposting.tbl_technology_technology_id=technology.technology_id LEFT OUTER JOIN tbl_interview_round rounds ON jobposting.job_posting_id=rounds.job_posting_id LEFT OUTER JOIN tbl_status statuses ON rounds.status_id=statuses.status_id LEFT OUTER JOIN tbl_client_address address ON jobposting.client_address_id=address.client_address_id LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.city_Id where  city.city_Id=? and technology.technology_id=?  and jobposting.posted_date>=sysdate()";

	/**
	 * @author Sagar Suryawanshi B-35 Java FIND_JOB_POST_BY_COMPANY_CITY IS USED
	 *         TO FIND JOB RELATED TO COMPANY ,CITY
	 */
	public static final String FIND_JOB_POST_BY_COMPANY_CITY = "SELECT clients.client_name,addrs.location,jobposting.description,jobposting.posted_date,jobposting.job_posting_id,statuses.status_id,clients.image,clients.description,city.city,state.state,technology.technology FROM tbl_job_posting jobposting LEFT OUTER JOIN tbl_technology technology ON jobposting.tbl_technology_technology_id=technology.technology_id LEFT OUTER JOIN tbl_interview_round rounds ON jobposting.job_posting_id=rounds.job_posting_id LEFT OUTER JOIN tbl_status statuses ON rounds.status_id=statuses.status_id LEFT OUTER JOIN tbl_client_address address ON jobposting.client_address_id=address.client_address_id LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.city_Id where clients.client_id=? and city.city_Id=?  and jobposting.posted_date>=sysdate()";

	/**
	 * @author Sagar Suryawanshi B-35 Java FIND_JOB_POST_BY_COMPANY_TECHNOLOGY
	 *         IS USED TO FIND JOB RELATED TO COMPANY ,TECHNOLOGY
	 */
	public static final String FIND_JOB_POST_BY_COMPANY_TECHNOLOGY = "SELECT clients.client_name,addrs.location,jobposting.description,jobposting.posted_date,jobposting.job_posting_id,statuses.status_id,clients.image,clients.description,city.city,state.state,technology.technology FROM tbl_job_posting jobposting LEFT OUTER JOIN tbl_technology technology ON jobposting.tbl_technology_technology_id=technology.technology_id LEFT OUTER JOIN tbl_interview_round rounds ON jobposting.job_posting_id=rounds.job_posting_id LEFT OUTER JOIN tbl_status statuses ON rounds.status_id=statuses.status_id LEFT OUTER JOIN tbl_client_address address ON jobposting.client_address_id=address.client_address_id LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.city_Id where clients.client_id=? and technology.technology_id=?  and jobposting.posted_date>=sysdate()";

	/**
	 * @author Sagar Suryawanshi B-35 Java FIND_JOB_POST_BY_TECHNOLOGY IS USED
	 *         TO FIND JOB RELATED TO COMPANY ,TECHNOLOGY
	 */
	public static final String FIND_JOB_POST_BY_TECHNOLOGY = "SELECT clients.client_name,addrs.location,jobposting.description,jobposting.posted_date,jobposting.job_posting_id,statuses.status_id,clients.image,clients.description,city.city,state.state,technology.technology FROM tbl_job_posting jobposting LEFT OUTER JOIN tbl_technology technology ON jobposting.tbl_technology_technology_id=technology.technology_id LEFT OUTER JOIN tbl_interview_round rounds ON jobposting.job_posting_id=rounds.job_posting_id LEFT OUTER JOIN tbl_status statuses ON rounds.status_id=statuses.status_id LEFT OUTER JOIN tbl_client_address address ON jobposting.client_address_id=address.client_address_id LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.city_Id where ( clients.client_id=? or city.city_Id=? or technology.technology_id=? )and jobposting.posted_date>=sysdate()";

	/**
	 * @author Sagar Suryawanshi B-35 Java GET_JOB_POST_Technology IS USED TO
	 *         GET ALL TECHNOLOGY RELATED TO ALL JOB POST
	 */
	public static final String GET_JOB_POST_Technology = "select tbl_technology.technology_id,tbl_technology.technology from tbl_technology;";

	/**
	 * @author B.Rakesh kumar
	 * @used for login and getting data from the database depend on email and
	 *       password
	 * @DATA_RETREIVAL_QRY_Login is used in such a way that depending on the
	 *                           email and password which is entered by user. If
	 *                           the given email and password are exist in the
	 *                           database then data is taken from tbl_user(all
	 *                           columns) and tbl_role(role column)by using equi
	 *                           join as role_id is foreign key in tbl_user
	 *                           which is primary key in tbl_role

	 * 
	 */
    public static final String DATA_RETREIVAL_QRY_LOGIN="select tbl_user.*,tbl_role.role  from tbl_user join tbl_role on tbl_user.role_id=tbl_role.role_id where email=? and password=? and status_id <>"+StringConstants._IN_ACTIVE_STATUS_ID;
    public static final String DATA_RETREIVAL_QRY_LOGIN_USING_MOBILE="select tbl_user.*,tbl_role.role  from tbl_user join tbl_role on tbl_user.role_id=tbl_role.role_id where mobile_no=? and password=?";
	

	/**
	 * @author Mounika ASSESSMENT_DETAILS_NOTIFICATION_QRY is query to get the
	 *         Assessment Details
	 */
	public static final String ASSESSMENT_DETAILS_NOTIFICATION_QRY = "select a.assessment_id,a.assessment_name,a.total_marks,a.duration_in_min,a.date,c.course,n.assessment_type_name,l.level "
			+ " from tbl_assessment a left join tbl_assment_question q " + " on a.assessment_id=q.assessment_id "
			+ " left join tbl_course c on c.course_id=a.course_id "
			+ " left join tbl_assessment_type n on n.assessment_type_id=a.assessment_type_id "
			+ " left join tbl_level l on l.level_id=a.level_id " + " where q.assessment_id is null";

	/**
	 * @author Vijay Kumar Reddy K GET_COUNTRY IS USED TO GET ALL COUNTRYS
	 */
	public static final String GET_COUNTRY = "select tbl_country.country_id,tbl_country.country from tbl_country";

	/**
	 * @author Vijay Kumar Reddy K GET_STATE IS USED TO GET ALL STATES OF GIVEN
	 *         COUNTRY
	 */
	public static final String GET_STATE = "select tbl_state.state_id,tbl_state.state from tbl_state where tbl_state.country_id=?";

	
	/**
	 * @author B.Rakesh kumar
	 * @used for retreiving firstname and password
	 * @QRY_TO_RETREIVE_FIRSTNAME__PASSWORD is in such a way that depending on
	 *                                      the email given by the user we can
	 *                                      get firstname and password from the
	 *                                      database
	 */
	public static final String QRY_TO_RETREIVE_FIRSTNAME__PASSWORD = "select first_name,password from tbl_user where email=?";
/**
 * @author B.Rakesh kumar
 * @used for updating the password
 * @QRY_TO_UPDATE_PASSWORD is used in such a way that depending on the email and password given by the user we can update 
 * the password of the user
 */
			
public static final String QRY_TO_UPDATE_PASSWORD="update tbl_user set password=? where email=? and password=?";
public static final String QRY_TO_UPDATE_PASSWORD_USING_MOBILE="update tbl_user set password=? where mobile_no=? and password=?";
	/**
	 * @author Rohit Kumar Singh b35
	 * Query to fetch AssesmentTypeName(s) from Table tbl_assessment_type
	 */
	
	public final static String _SELECT_ASSESMENT_TYPE_NAME="select assessment_type_id,assessment_type_name from tbl_assessment_type";
	
	/**
	 * @author Rohit Kumar Singh b35
	 * query to fetch AssesmentNames records from table tbl_assessment
	 */
	
	public final static	String _SELECT_ASSESSMENT_NAME="select assessment_id,assessment_name,date,course_id from tbl_assessment where assessment_type_id=? "+ 
" and tbl_assessment.course_id in (select tbl_tbl_tech_courses.course_id "+
" from tbl_tbl_tech_courses where tbl_tbl_tech_courses.technology_id in ( "+
" select tbl_user.technology_id from tbl_user where tbl_user.user_id =?))";
	
	/**
	 * @author Rohit Kumar Singh b35
	 * Query to fetch assesment StartTime,EndTime,TimeDuration from tbl_assessment
	 */
	
	public final static String _CREATE_TIME_SLOTS="select duration_in_min,start_time_of_slots,end_time_slots from tbl_assessment where assessment_id=? ";
	
	/**
	 * @author Rohit Kumar Singh b35
	 * Query to insert the record(s) or SelectedTimeSlots into database table tbl_booked_slots
	 */
	
	public final static String _BOOK_SELECTED_SLOT="insert into tbl_booked_slots(slot_time,assessment_id,tbl_user_user_id,attempt_status_id) value(?,?,?,?)";
	
	/**
	 * @author Rohit Kumar Singh b35
	 * Query to retrieve the record(s) from database tables 
	 */
	
	public final static String _SELECT_NO_OF_ATTEMPTS=  " select max(tbl_student_course_attempt.attempt_no),tbl_totalallowed_attempts.no_of_attempts from tbl_student_course_attempt "+ 
			" inner join tbl_user on tbl_user.user_id = tbl_student_course_attempt.user_id "+
		        " inner join tbl_technology on tbl_technology.technology_id = tbl_user.technology_id "+
		        " inner join tbl_tbl_tech_courses on tbl_tbl_tech_courses.technology_id = tbl_technology.technology_id "+
		        " inner join tbl_course on tbl_course.course_id = tbl_tbl_tech_courses.course_id "+
		        " inner join tbl_assessment on tbl_assessment.course_id = tbl_course.course_id "+
		        " right outer JOIN tbl_totalallowed_attempts on "+ 
		        " tbl_totalallowed_attempts.tech_courses_id = tbl_tbl_tech_courses.tech_courses_id "+
		        " and tbl_student_course_attempt.user_id=?  and tbl_assessment.assessment_id=?"; 
	
	/**
	 * @author Rohit Kumar Singh b35
	 *  Query to retrieve data(slot_time) from database table tbl_booked_slots
	 */
	
	public final static	String _SELECT_BOOKED_SLOT="select slot_time from tbl_booked_slots where tbl_user_user_id=? and assessment_id=?";
	
	/**
	 * @author RROCK Rohit Kumar Singh b35
	 * Retrieve booked slot details of a user with assessment
	 */
	
	public final static String _SELECT_BOOKED_SLOT_DETAILS ="select tbl_assessment.assessment_name,tbl_booked_slots.booked_slots,tbl_booked_slots.slot_time,"+
			"tbl_status.status from tbl_booked_slots "+
			"inner join tbl_status on tbl_status.status_id=tbl_booked_slots.attempt_status_id "+
			"inner join tbl_assessment on tbl_assessment.assessment_id=tbl_booked_slots.assessment_id "+
			"where tbl_booked_slots.tbl_user_user_id=? and tbl_booked_slots.assessment_id=?"; 
	
	/**
	 * @author Rohit Kumar Singh b35
	 * Query to delete records(questions) from database table tbl_assessment_question on basis of assessment_id
	 */
	
	public final static String _DELETE_RECORDED_QUESTION= "DELETE FROM tbl_assment_question where assessment_id=? and question_id=?";

			
/**
 * @author Ashish Kumar
 * GET_USER_SCORES IS USED TO GET THE NAME, 
 * MOBILE NO,TECHNOLOGY, EMAIL AND 
 * THE ASSESSMENT MARKS
 */
public static final String GET_USER_SCORES="select tbl_student_course_attempt.attempt_no, tbl_user.first_name, tbl_user.last_name, tbl_user.email, tbl_user.mobile_no, tbl_user.image, tbl_student_course_attempt.total_marks, tbl_technology.technology,tbl_course.course, tbl_assessment.assessment_name, tbl_assessment.total_marks from tbl_user join tbl_student_course_attempt on tbl_student_course_attempt.user_id=tbl_user.user_id and tbl_user.user_id=? left join tbl_tbl_tech_courses on tbl_tbl_tech_courses.tech_courses_id=tbl_student_course_attempt.tech_courses_id left join tbl_technology on tbl_technology.technology_id = tbl_tbl_tech_courses.technology_id left join tbl_course on tbl_course.course_id=tbl_tbl_tech_courses.course_id left join tbl_assessment on tbl_assessment.course_id=tbl_course.course_id";

	/**
	 * @author B.Rakesh kumar
	 * @used for updating the password
	 * @QRY_TO_UPDATE_PASSWORD is used in such a way that depending on the email
	 *                         and password given by the user we can update the
	 *                         password of the user
	 */
	/**
	 * @author JAY SINGH
	 * GET_JOB_OPPORTUNITY_REQUEST_DETAILS 
	 */
    public static final String GET_JOB_OPPORTUNITY_REQUEST_DETAILS="select u.first_name,u.last_name, u.image,clt.client_name,clt.image,jpt.description,jpt.posted_date,jpt.job_posting_id,sts.status from tbl_user u inner join tbl_elegible_student est on est.user_id = u.user_id inner join tbl_interview_round ir on ir.interview_round_id=est.interview_round_id inner join tbl_job_posting jpt on jpt.job_posting_id=ir.job_posting_id inner join tbl_client_address ca on ca.client_address_id = jpt.client_address_id inner join tbl_client clt on clt.client_id = ca.client_id inner join tbl_status sts on sts.status_id=est.status_id where u.user_id=? and est.status_id=?";    
    /**
	 * @author JAY SINGH
	 * GET_NOTIFICATION details
	 */
    public static final String GET_NOTIFICATION="select tbl_user.first_name,tbl_user.last_name,tbl_user.image,tbl_job_posting.description,tbl_user.user_id from tbl_user INNER Join  tbl_elegible_student on tbl_elegible_student.user_id=tbl_user.user_id INNER Join  tbl_interview_round on tbl_interview_round.interview_round_id=tbl_elegible_student.interview_round_id INNER Join  tbl_job_posting on tbl_job_posting.job_posting_id=tbl_interview_round.job_posting_id Inner Join tbl_client_address on tbl_client_address.client_address_id=tbl_job_posting.client_address_id  Inner Join tbl_client on tbl_client.client_id=tbl_client_address.client_id where tbl_elegible_student.status_id=?";
    /**
	 * @author JAY SINGH
	 * APPROVE_REQUEST_BY_ADMIN 
	 */
    public static final String APPROVE_REQUEST_BY_ADMIN="update tbl_elegible_student set status_id="+StringConstants.REQUEST_APPROVED_ID+" where tbl_elegible_student.elegible_student_id=?;";
    /**
	 * @author JAY SINGH
	 * REJECT_REQUEST_BY_ADMIN 
	 */
    public static final String REJECT_REQUEST_BY_ADMIN="update tbl_elegible_student set status_id="+StringConstants.REQUEST_REJECT_ID+" where tbl_elegible_student.elegible_student_id=?;";
/**
 * @author Ashish Kumar
 * 
 */
//public static final String GET_RIGHT_OPTIONS ="select tbl_assment_question.question_id, tbl_question_option.option_id from tbl_question_option join tbl_question on tbl_question.question_id=tbl_question_option.question_id join tbl_assment_question on tbl_question.question_id=tbl_assment_question.question_id where tbl_question_option.is_answer=? and tbl_assment_question.assessment_id=?";

	//public static final String QRY_TO_UPDATE_PASSWORD = "update tbl_user set password=? where email=? and password=?";
	/**
	 * @author Ashish Kumar 
	 * GET_USER_SCORES IS USED TO GET THE NAME, MOBILE NO,TECHNOLOGY, EMAIL AND THE ASSESSMENT MARKS
	 */
/*	public static final String GET_USER_SCORES = "select tbl_student_course_attempt.attempt_no, tbl_user.first_name,tbl_user.email, tbl_user.mobile_no,tbl_student_course_attempt.total_marks , "
			+ " tbl_technology.technology,tbl_course.course " + " from tbl_user " + " left join  "
			+ " tbl_student_course_attempt   "
			+ " on tbl_user.user_id=tbl_student_course_attempt.user_id and tbl_student_course_attempt.user_id=? "
			+ " left join tbl_tbl_tech_courses  on tbl_tbl_tech_courses.tech_courses_id=tbl_student_course_attempt.tech_courses_id "
			+ " left join tbl_technology on tbl_technology.technology_id = tbl_tbl_tech_courses.technology_id "
			+ " left join tbl_course on tbl_course.course_id=tbl_tbl_tech_courses.course_id";

*/	
    /**
	 * @author Chitranshu Gupta 
	 * GET_ASSESSMENT_TYPE IS USED TO GET ALL ASSESSMENT TYPES
	 */

	public static final String GET_ASSESSMENT_TYPE = "select tbl_assessment_type.assessment_type_id, tbl_assessment_type.assessment_type_name from tbl_assessment_type";

	/**
	 * @author Chitranshu Gupta 
	 * GET_EXAM_STATUS IS USED TO GET EXAM_STATUS LIKE EXAM ALREADY ATTENDED AND NOT ATTENDED BASED ON ASSESSMENT_ID AND USER_ID
	 */
	public static final String GET_EXAM_STATUS="select tbl_status.`status` from tbl_status join tbl_booked_slots on tbl_booked_slots.attempt_status_id=tbl_status.status_id where tbl_booked_slots.assessment_id=? and tbl_booked_slots.tbl_user_user_id=?";
	/**
	 * @author Chitranshu Gupta B-35 
	 * GET_ASSESSMENTS IS USED TO GET ASSESSMENTS NAMES OF GIVEN ASSESSMENT_TYPE_ID AND SLOT_TIME AND CURRENT_DATE
	 */

	public static final String GET_ASSESSMENTS = "select tbl_assessment.assessment_id, tbl_assessment.assessment_name from tbl_assessment join tbl_booked_slots on tbl_booked_slots.assessment_id = tbl_assessment.assessment_id where tbl_assessment.assessment_type_id=? and tbl_booked_slots.slot_time >= tbl_assessment.start_time_of_slots and  tbl_booked_slots.slot_time <= tbl_assessment.end_time_slots and tbl_assessment.date= CURDATE();";

	/**
	 * @author Chitranshu Gupta B-35 
	 * GET_ASSESSMENT_DETAILS IS USED TO GET ASSESSMENT DETAILS OF GIVEN ASSESSMENT_ID
	 */

	public static final String GET_ASSESSMENT_DETAILS = "select tbl_assessment.assessment_id, tbl_assessment.assessment_name, tbl_assessment.total_marks, tbl_assessment.duration_in_min, tbl_assessment.date, tbl_assessment.description, count(*) no_of_questions from tbl_assessment join tbl_assment_question on tbl_assessment.assessment_id=tbl_assment_question.assessment_id where tbl_assessment.assessment_id=?";

	/**
	 * @author Chitranshu Gupta B-35 
	 * GET_ASSESSMENT_QUESTIONS_ID IS USED TO GET ALL QUESTIONS_ID AND ASSESSMENT_QUESTION_ID OF GIVEN ASSESSMENT_ID
	 */
	public static final String GET_ASSESSMENT_QUESTIONS_ID = "select tbl_assment_question.question_id, tbl_assment_question.assment_question_id from tbl_assment_question where tbl_assment_question.assessment_id=?";

	/**
	 * @author Chitranshu Gupta B-35 
	 * GET_ASSESSMENT_QUESTIONS IS USED TO GET ALL QUESTIONS OF GIVEN QUESTION_ID
	 */
	public static final String GET_ASSESSMENT_QUESTIONS = "select tbl_question.question_id, tbl_question.question from tbl_question where tbl_question.question_id=?";

	/**
	 * @author Chitranshu Gupta B-35 
	 * GET_ASSESSMENT_QUESTION_OPTIONS IS USED TO GET ALL OPTIONS OF GIVEN RESPECTIVE QUESTION_ID
	 */
	public static final String GET_ASSESSMENT_QUESTION_OPTIONS = "select tbl_question_option.option_id, tbl_question_option.`option` from tbl_question_option where tbl_question_option.question_id=?";

	/**
	 * @author Chitranshu Gupta B-35 
	 * INSERT_STUDENT_ANSWERS IS USED TO SAVE SELECTED ANSWERS
	 */
	public static final String INSERT_STUDENT_ANSWERS = "insert into tbl_student_answer (tbl_student_answer.assment_question_id, tbl_student_answer.selected_option_id, tbl_student_answer.user_id) values(?,?,?)";

	/**
	 * @author Chitranshu Gupta B-35 
	 * INSERT_REMAINING_TIME IS USED TO SAVE ASSESSMENT REMAINING TIME
	 */
	public static final String INSERT_REMAINING_TIME = "insert into tbl_student_remaining_time_for_assesment (tbl_student_remaining_time_for_assesment.remaining_time_in_min, tbl_student_remaining_time_for_assesment.user_id, tbl_student_remaining_time_for_assesment.assessment_id) values(?,?,?)";

	/**
	 * @author Chitranshu Gupta B-35 
	 * GET_STUDENT_ANSWERS IS USED TO GET STUDENT ANSWERS IDs OF GIVEN ASSESSMENT_QUESTION_ID AND SELECTED_OPTION_ID AND USER_ID
	 */
	public static final String GET_STUDENT_ANSWERS = "select tbl_student_answer.student_answer_id from tbl_student_answer where tbl_student_answer.assment_question_id=? and tbl_student_answer.user_id=?";

	/**
	 * @author Chitranshu Gupta B-35 
	 * DELETE_ANSWERS IS USED TO DELETE OLD ANSWERS OF GIVEN ASSESSMENT_QUESTION_ID AND USER_ID
	 */
	public static final String DELETE_ANSWERS = "delete from tbl_student_answer where tbl_student_answer.assment_question_id=? and tbl_student_answer.user_id=?";

	/**
	 * @author Chitranshu Gupta B-35 
	 * GET_REMAINING_TIME IS USED TO GET REMAINING TIME OF GIVEN ASSESSMENT_QUESTION_ID AND USER_ID
	 */
	public static final String GET_REMAINING_TIME = "select tbl_student_remaining_time_for_assesment.remaining_time_in_min from tbl_student_remaining_time_for_assesment where tbl_student_remaining_time_for_assesment.user_id=? and tbl_student_remaining_time_for_assesment.assessment_id=?";

	/**
	 * @author Chitranshu Gupta B-35 
	 * DELETE_REMAINING_TIME IS USED TO DELETE REMAINING TIME OF GIVEN ASSESSMENT_QUESTION_ID AND USER_ID
	 */
	public static final String DELETE_REMAINING_TIME = "delete from tbl_student_remaining_time_for_assesment where tbl_student_remaining_time_for_assesment.user_id=? and tbl_student_remaining_time_for_assesment.assessment_id=?";

	/**
	 * @author Chitranshu Gupta B-35 
	 * GET_SELECTED_OPTIONS IS USED TO GET SELECTED OPTIONS AND THEIR ASSESSMENT_QUESTION_ID OF GIVEN ASSESSMENT_QUESTION_ID AND USER_ID
	 */
	public static final String GET_SELECTED_OPTIONS = "select tbl_student_answer.assment_question_id, tbl_student_answer.selected_option_id from tbl_student_answer join tbl_assment_question on tbl_student_answer.assment_question_id = tbl_assment_question.assment_question_id where tbl_student_answer.user_id=? and tbl_assment_question.assessment_id=?";

	/**
	 * @author Chitranshu Gupta B-35 
	 * GET_SELECTED_ANSWERS IS USED TO GET SELECTED OPTIONS AND THEIR QUESTION_ID OF GIVEN ASSESSMENT_QUESTION_ID AND USER_ID
	 */
	public static final String GET_SELECTED_ANSWERS = "select tbl_assment_question.question_id, tbl_student_answer.selected_option_id from tbl_student_answer join tbl_assment_question on tbl_student_answer.assment_question_id = tbl_assment_question.assment_question_id where tbl_student_answer.user_id=? and tbl_assment_question.assessment_id=?";

	/**
	 * @author Chitranshu Gupta B-35
	 * GET_RIGHT_OPTIONS IS USED TO GET ALL CORRECT ANSWERS OF ASSESSMENT QUESTIONS BASED ON IS_ANSWER AND ASSESSMENT_ID
	 */
	public static final String GET_RIGHT_OPTIONS = "select tbl_assment_question.question_id, tbl_question_option.option_id from tbl_question_option join tbl_question on tbl_question.question_id=tbl_question_option.question_id join tbl_assment_question on tbl_question.question_id=tbl_assment_question.question_id where tbl_question_option.is_answer=? and tbl_assment_question.assessment_id=?";

	/**
	 * @author Chitranshu Gupta B-35
	 * GET_TECH_COURSE_ID IS USED TO GET TECH_COURSE_ID BASED ON USER_ID AND ASSESSMENT_ID
	 */
	public static final String GET_TECH_COURSE_ID = "select tbl_tbl_tech_courses.tech_courses_id from tbl_tbl_tech_courses where tbl_tbl_tech_courses.technology_id =(select tbl_user.technology_id from tbl_user where tbl_user.user_id=?) AND tbl_tbl_tech_courses.course_id=(select tbl_assessment.course_id from tbl_assessment where tbl_assessment.assessment_id=?)";

	/**
	 * @author Chitranshu Gupta B-35
	 * GET_COUNT_ATTEMPT_NO IS USED TO COUNT NO. OF ATTEMPTS OF ASSESSMENT BASED ON USER_ID AND TECH_COURSES_ID 
	 */
	public static final String GET_COUNT_ATTEMPT_NO = "select count(*)+1 attempt_no from tbl_student_course_attempt where tbl_student_course_attempt.user_id=? AND tbl_student_course_attempt.tech_courses_id=?";

	/**
	 * @author Chitranshu Gupta B-35
	 * INSERT_SCORES IS USED TO INSERTING ASSESSMENT RESULT SCORES 
	 */
   // public static final String INSERT_SCORES = "insert into tbl_student_course_attempt (tech_courses_id, attempt_no, total_marks, user_id) values(?,?,?,?)";
/**
 * @author pavan pratap singh batch-35
 * Elegible_query query for get ElgibleDto object getting user are elgible_student_is,interview_round_id,user_id,status_id
 */
	/*
	public static final String Elegible_query="select tbl_interview_round.interview_round_id,tbl_user.user_id,tbl_elegible_student.elegible_student_id,tbl_elegible_student.status_id  from  tbl_interview_round  left outer join tbl_job_posting on tbl_job_posting.job_posting_id = tbl_interview_round.job_posting_id left outer join tbl_elegible_student on tbl_elegible_student.interview_round_id = tbl_interview_round.interview_round_id left OUTer join tbl_user on tbl_elegible_student.user_id = tbl_user.user_id where tbl_job_posting.job_posting_id=? and tbl_user.user_id=?";
	
*/
    /**
	 * @author Chitranshu Gupta B-35
	 * UPDATE_EXAM_STATUS IS USED TO UPDATE ASSESSMENT STATUS LIKE EXAM ATTEMPED OR NOT ATTEMPTED 
	 */
	
	public static final String UPDATE_EXAM_STATUS="update tbl_booked_slots set attempt_status_id=(select tbl_status.status_id from tbl_status where status=?) where tbl_booked_slots.assessment_id=? and tbl_booked_slots.tbl_user_user_id=?";
	
	/**
	 * @author Chitranshu Gupta B-35 GET_QUESTIONS_ANSWERS IS USED TO GET ALL
	 *         QUESTIONS AND THEIR OPTIONS OF GIVEN ASSESSMENT_ID
	 *//*
	// public static final String GET_QUESTIONS_ANSWERS="select
	// tbl_question.question_id, tbl_question.question,
	// tbl_question_option.option_id, tbl_question_option.`option` from
	// tbl_question_option join tbl_question on tbl_question_option.question_id=
	// tbl_question.question_id join tbl_assment_question on
	// tbl_assment_question.question_id=tbl_question.question_id join
	// tbl_assessment on
	// tbl_assessment.assessment_id=tbl_assment_question.assessment_id where
	// tbl_assessment.assessment_id=?";
*/

	/*/**
	 * @author pavan pratap singh batch-35
	 * Elegible_query query for get ElgibleDto object getting user are elgible_student_is,interview_round_id,user_id,status_id
	 *//*
		public static final String Elegible_query="select tbl_interview_round.interview_round_id,tbl_user.user_id,tbl_elegible_student.elegible_student_id,tbl_elegible_student.status_id  from  tbl_interview_round  left outer join tbl_job_posting on tbl_job_posting.job_posting_id = tbl_interview_round.job_posting_id left outer join tbl_elegible_student on tbl_elegible_student.interview_round_id = tbl_interview_round.interview_round_id left OUTer join tbl_user on tbl_elegible_student.user_id = tbl_user.user_id where tbl_job_posting.job_posting_id=? and tbl_user.user_id=?";
		
	*/
	
	/**
	 * @author pavan pratap singh batch-35 Elegible_query query for get
	 *         ElgibleDto object getting user are
	 *         elgible_student_is,interview_round_id,user_id,status_id
	*/ 
	public static final String Elegible_query = "select tbl_interview_round.interview_round_id,tbl_user.user_id,tbl_elegible_student.elegible_student_id,tbl_elegible_student.status_id  from  tbl_interview_round  left outer join tbl_job_posting on tbl_job_posting.job_posting_id = tbl_interview_round.job_posting_id left outer join tbl_elegible_student on tbl_elegible_student.interview_round_id = tbl_interview_round.interview_round_id left OUTer join tbl_user on tbl_elegible_student.user_id = tbl_user.user_id where tbl_job_posting.job_posting_id=? and tbl_user.user_id=?";

	/**
	 * @author pavan pratap singh batch-35 Apply_job_query query for get
	 *         ElgibleDto object update the status_id
	 */
	public static final String Apply_job_query = "UPDATE tbl_elegible_student set status_id="+StringConstants._ALREADY_APPLIED_FOR_JOB_POST_ID+" where elegible_student_id=?";

	/**
	 * @author pavan pratap singh batch-35 Request_job_query query for get
	 *         ElgibleDto object inserting the
	 *         interview_round_id,user_id,status_id
	 */
	public static final String Request_job_query = "insert into tbl_elegible_student(interview_round_id,user_id,status_id) values((select interview_round_id from tbl_interview_round where  job_posting_id=? and round_no="+StringConstants.FIRST_ROUND_NO+"),?,"+StringConstants._ALREADY_REQUESTED_FOR_JOB_POST_ID+");";


  /**
 * @author pavan pratap singh batch-35
 * Elegible_query query for get ElgibleDto object getting user are elgible_student_is,interview_round_id,user_id,status_id
 */
	/*public static final String Elegible_query="select tbl_interview_round.interview_round_id,tbl_user.user_id,tbl_elegible_student.elegible_student_id,tbl_elegible_student.status_id  from  tbl_interview_round  left outer join tbl_job_posting on tbl_job_posting.job_posting_id = tbl_interview_round.job_posting_id left outer join tbl_elegible_student on tbl_elegible_student.interview_round_id = tbl_interview_round.interview_round_id left OUTer join tbl_user on tbl_elegible_student.user_id = tbl_user.user_id where tbl_job_posting.job_posting_id=? and tbl_user.user_id=?";
	
	*//**
	 * @author pavan pratap singh batch-35
	 * Apply_job_query query for get ElgibleDto object update the status_id
	 *//*
	public static final String Apply_job_query="UPDATE tbl_elegible_student set status_id=1  where elegible_student_id=?";
	
	*//**
	 * @author pavan pratap singh batch-35
	 * Request_job_query query for get ElgibleDto object inserting  the interview_round_id,user_id,status_id
	 *//*
	public static final String Request_job_query="insert into tbl_elegible_student(interview_round_id,user_id,status_id) values((select interview_round_id from tbl_interview_round where  job_posting_id=?),?,2);";
*/
	/**
	 * @author pavan pratap singh batch-35
	 * Query for getting level from tbl_level
	 */
	public static final String Get_level_Query="select * from tbl_level;";

	/**
	 * @author pavan pratap singh batch-35
	 * Query for getting level from tbl_level
	 */
	public static final String Get_Course_Query="select * from tbl_course;";

	/**
	 * @author pavan pratap singh batch-35
	 * Query for getting AssesssmentTypeId from tbl_assessment_type
	 */
	public static final String Get_AssessmentType_Query="select * from tbl_assessment_type;";
	/**@author pavan pratap singh batch-35 
	 * Query for getting all Asessments  tbl_assessment_type
	 * 
	 */
	//public static final String GET_ASSESSMENT_DETAILS_For_Edit="select tbl_assessment.assessment_id, tbl_assessment.assessment_name, tbl_assessment.total_marks, tbl_assessment.duration_in_min, tbl_assessment.date, tbl_assessment.description, tbl_assessment.assessment_type_id,tbl_assessment.course_id,tbl_assessment.level_id,tbl_assessment.no_of_students_for_a_slot,tbl_assessment.start_time_of_slots,tbl_assessment.end_time_slots from tbl_assessment;";
	
	public static final String GET_ASSESSMENT_DETAILS_For_Edit=	"select tbl_assessment.assessment_id, tbl_assessment.assessment_name, tbl_assessment.total_marks, tbl_assessment.duration_in_min, tbl_assessment.date, tbl_assessment.description, tbl_assessment.no_of_students_for_a_slot, tbl_assessment.start_time_of_slots, tbl_assessment.end_time_slots,tbl_assessment_type.assessment_type_name, tbl_course.course,tbl_level.`level`  from tbl_assessment LEFT OUTER JOIN tbl_assessment_type on  tbl_assessment.assessment_type_id=tbl_assessment_type.assessment_type_id LEFT OUTER JOIN tbl_course on  tbl_assessment.course_id=tbl_course.course_id LEFT OUTER JOIN tbl_level on  tbl_assessment.level_id=tbl_level.level_id;";
	
	public static final String GET_ASSESSMENT_INDIVIDUAL_DETAILS_For_Edit=	"select tbl_assessment.assessment_id, tbl_assessment.assessment_name, tbl_assessment.total_marks, tbl_assessment.duration_in_min, tbl_assessment.date, tbl_assessment.description, tbl_assessment.no_of_students_for_a_slot, tbl_assessment.start_time_of_slots, tbl_assessment.end_time_slots,tbl_assessment_type.assessment_type_name, tbl_course.course,tbl_level.`level`  from tbl_assessment LEFT OUTER JOIN tbl_assessment_type on  tbl_assessment.assessment_type_id=tbl_assessment_type.assessment_type_id LEFT OUTER JOIN tbl_course on  tbl_assessment.course_id=tbl_course.course_id LEFT OUTER JOIN tbl_level on  tbl_assessment.level_id=tbl_level.level_id where tbl_assessment.assessment_id=?;";
	
	
	
	/**
	 * @author pavan pratap singh b-35
	 * QUERY for insert data into Tbl_Assessment
	 */
	public static final String Add_ASSESSMENT_QUERY="insert into tbl_assessment(assessment_name,total_marks,duration_in_min,date,description,assessment_type_id,course_id,level_id,no_of_students_for_a_slot,start_time_of_slots,end_time_slots) values(?,?,?,?,?,?,?,?,?,?,?);";
	/**
	 * @author pavan pratap singh b-35
	 * Query for Update data into tbl_ASSESSMENT
	 */
	public static final String EDIT_ASSESSMENT_DETAILS=  "update tbl_assessment set assessment_name=?,total_marks=? ,duration_in_min=? ,date=?,description=?,assessment_type_id=?,course_id=?,level_id=?,no_of_students_for_a_slot=?,start_time_of_slots=?,end_time_slots=? where  assessment_id=?; ";
	/**
	 * @author pavan pratap singh b-35
	 * Delete row into tbl_ASSESSMENT
	 */
	public static final String DELETE_ASSESSMENT="delete from tbl_assessment where assessment_id=?;";
	
	
	
	/**
	 * @author Saurabh Suman & Sonali Chavan
	 * Insert client related details in only one table tbl_client at the time of "Add Client".
	 */
	public static final String INSERT_CLIENT_DETAILS ="insert into tbl_client(client_name ,image,description,company_level_id) values(?,?,?,?)";

	
	/**
	 * @author Saurabh Suman & Sonali Chavan
	 * Insert clients contact details in only one table tbl_client_address at the time of "Add Client".
	 */
     public static final String INSERT_CLIENT_CONTACT_DETAILS ="insert into tbl_client_address(client_id,address_id,contact_person_name,contact_person_mobile_no,contact_person_mail) values(?,?,?,?,?)";
	
     
     /**
 	 * @author Saurabh Suman & Sonali Chavan
 	 * Insert clients location in only one table tbl_address at the time of "Add Client or Add More Address".
 	 */
     public static final String INSERT_CLIENT_ADDRESS_DETAILS="insert into tbl_address(location, pincode, city_Id ) values(?,?,?)";

    
     /**
 	 * @author Saurabh Suman & Sonali Chavan
 	 * Insert clients contact details in only one table tbl_client_address at the time of "Add More Address".
 	 */
      public static final String INSERT_CLIENTS_MORE_CONTACT_DETAILS="INSERT INTO tbl_client_address (client_id,address_id,contact_person_name,contact_person_mobile_no,contact_person_mail) SELECT ? As client_id, ? As address_id, ? As contact_person_name, ? As contact_person_mobile_no,? As contact_person_mail FROM (SELECT Count(*) As  ExistsCount FROM tbl_client_address WHERE contact_person_mobile_no = ? or contact_person_mail=?)  AS  e WHERE e.ExistsCount=0";
		
	 
    /**
	 * @author Saurabh Suman & Sonali Chavan
	 * GET_LEVEL OF CLIENT
	 */
	  public static final String GET_LEVEL = "select tbl_level.level_id,tbl_level.level from tbl_level";
	
	
	/**
	 * @author Saurabh Suman & Sonali Chavan
	 * Request for get official and personal details of all client as well as Contact Person during first page loading
	 */
     public static final String GET_CLIENT_DETAILS = "SELECT clients.client_name,clients.image,clients.description ,city.city,state.state, levels.`level`,country.country ,clients.client_id FROM tbl_client_address address LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_level levels ON clients.company_level_id=levels.level_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.state_id LEFT OUTER JOIN tbl_country country ON state.country_id=country.country_id group by clients.client_id";

	
     /**
	 * @author Saurabh Suman & Sonali Chavan
	 * Request for get official and personal details of particular client as well as Contact Person from database for view or edit button is clicked
	 */
	 public static final String GET_CLIENT = "SELECT clients.client_name,address.contact_person_name,address.contact_person_mobile_no,address.contact_person_mail ,addrs.location,addrs.pincode,clients.image,clients.description ,city.city,state.state,levels.`level`,country.country,country.country_id,levels.level_id,state.state_id,city.city_Id,clients.client_id, address.address_id FROM tbl_client_address address LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_level levels ON clients.company_level_id=levels.level_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.state_id LEFT OUTER JOIN tbl_country country ON state.country_id=country.country_id where clients.client_id=?";

	
	 /**
	 * @author Saurabh Suman & Sonali Chavan
	 * Edit or update client details only in table tbl_client .
	 */
	 public static final String EDIT_CLIENT ="update tbl_client set client_name=? ,image=?,description=?,company_level_id=? where client_id=?";

	
	 
	/**
	 * @author Saurabh Suman  & Sonali Chavan
	 * Edit or update clients contact details in table tbl_client and tbl_address 
	 */
	 public static final String EDIT_CLIENT_CONTACT ="update tbl_client_address,tbl_address set tbl_address.location=?,tbl_address.pincode=?,tbl_address.city_Id=?,tbl_client_address.contact_person_mobile_no=?,tbl_client_address.contact_person_mail=?, tbl_client_address.contact_person_name=? where tbl_client_address.address_id=tbl_address.address_id and tbl_client_address.address_id=?";
	 
	 
		
	 /**
	  * @author Saurabh Suman  & Sonali Chavan
	  * Edit or update clients contact details in table tbl_client and tbl_address 
	  */
	public static final String GET_CLIENT_CONTACT_ADDRESS="SELECT address.contact_person_name,address.contact_person_mobile_no,address.contact_person_mail ,addrs.location,addrs.pincode,city.city,state.state,country.country,country.country_id,state.state_id,city.city_Id, address.address_id FROM tbl_client_address address LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state ON state.state_id=city.state_id LEFT OUTER JOIN tbl_country country ON state.country_id=country.country_id where address.address_id=?";
	
	
	
	/**
	 * @author Saurabh Suman  & Sonali Chavan
	 * For checking existing client on the basis of client_name in tbl_client to restrict duplication entry 
	 */
	public static final String CHECK_CLIENT ="select count(*),client_id from tbl_client where client_name =? group by client_name";


	/**
	 * @author rajnish b-35
	 * Query for retriving job posting id and all detail from the tbl_job posting and show the notification in notification box
	 */

public static final String GET_JOB_POSTING_NOTIFICATIOND_DETAIL ="SELECT jobposting.expected_date,jobposting.assesment_start_date,jobposting.assesment_end_date,clients.client_name,addrs.location,jobposting.description,jobposting.posted_date, jobposting.no_of_vacancies,clients.description,city.city,state.state,technology.technology ,address.contact_person_mobile_no,address.contact_person_mail,clients.image FROM tbl_job_posting jobposting LEFT OUTER JOIN tbl_technology technology ON jobposting.tbl_technology_technology_id=technology.technology_id LEFT OUTER JOIN tbl_interview_round rounds ON jobposting.job_posting_id=rounds.job_posting_id LEFT OUTER JOIN tbl_status statuses ON rounds.status_id=statuses.status_id LEFT OUTER JOIN tbl_client_address address ON jobposting.client_address_id=address.client_address_id LEFT OUTER JOIN tbl_client clients ON clients.client_id=address.client_id LEFT OUTER JOIN tbl_address addrs ON addrs.address_id=address.address_id LEFT OUTER JOIN tbl_city city ON addrs.city_Id=city.city_Id LEFT OUTER JOIN tbl_state state  ON state.state_id=city.state_id where jobposting.job_posting_id=?";
/**
 * @author rajnish b-35
 * Query for retriving job posting id and all detail from the 
*/
public static final String GET_JOB_POSTING_NOTIFICATION = "select  tbl_client.image,tbl_client.client_name, tbl_job_posting.* from tbl_job_posting "+ 
" inner join tbl_client_address ca on ca.client_address_id = tbl_job_posting.client_address_id "+ 
" inner join tbl_client on  tbl_client.client_id= ca.client_id "+
" where  tbl_job_posting.expected_date >= curdate()";

//"select  tbl_client.image,tbl_client.client_name, tbl_job_posting.* from tbl_job_posting inner join tbl_client_address ca on ca.client_address_id = tbl_job_posting.client_address_id inner join tbl_client on  tbl_client.client_id= ca.client_id left OUTER JOIN tbl_interview_round on tbl_job_posting.job_posting_id =tbl_interview_round.job_posting_id  where  tbl_interview_round.job_posting_id is null ";

/** 
 * @author Gajanan Debadwar
 * GET_NOTIFICATION_DETAILS_BY_EMAIL IS USED TO GET JOB DETAILS TO SHOW NOTIFICATION BY USING EMAIL
 * */

public static final String GET_NOTIFICATION_DETAILS_BY_EMAIL="select ir.job_posting_id,c.client_name,jp.description,c.image,ct.city,t.technology from tbl_user u, tbl_job_posting jp,tbl_client_address ca,tbl_client c,tbl_elegible_student es,tbl_interview_round ir,tbl_city ct,tbl_address ad,tbl_technology t where  u.user_id=es.user_id and es.interview_round_id=ir.interview_round_id and ir.job_posting_id=jp.job_posting_id and jp.client_address_id=ca.client_address_id and jp.client_address_id=ad.address_id and ad.address_id=ct.city_Id and ca.client_id=c.client_id and jp.tbl_technology_technology_id=t.technology_id and es.status_id=? and jp.assesment_start_date>curdate() and email=?";


/** 
 * @author Gajanan Debadwar
 * GET_NOTIFICATION_DETAILS_BY_EMAIL IS USED TO GET JOB DETAILS TO SHOW NOTIFICATION BY USING EMAIL
 * */

public static final String GET_NOTIFICATION_DETAILS_BY_MOBILENO="select ir.job_posting_id,c.client_name,jp.description,c.image,ct.city,t.technology from tbl_user u, tbl_job_posting jp,tbl_client_address ca,tbl_client c,tbl_elegible_student es,tbl_interview_round ir,tbl_city ct,tbl_address ad,tbl_technology t where  u.user_id=es.user_id and es.interview_round_id=ir.interview_round_id and ir.job_posting_id=jp.job_posting_id and jp.client_address_id=ca.client_address_id and jp.client_address_id=ad.address_id and ad.address_id=ct.city_Id and ca.client_id=c.client_id and jp.tbl_technology_technology_id=t.technology_id and es.status_id=? and jp.assesment_start_date>curdate() and mobile_no=?";

//public static final String CHECK_CLIENT ="select count(*),client_id from tbl_client where client_name =? group by client_name";

/** 
 * @author Srikanth and krunal
 * Query for retriving un aproved(status inactve) students list
 * */
public static final String GET_UNAPPROVED_STUDENT_DETAILS = "select user_id,first_name,last_name,email,mobile_no,image from tbl_user where status_id="+StringConstants._IN_ACTIVE_STATUS_ID+" and tbl_user.role_id="+StringConstants._STUDENT_ROLE_ID;



/** 
 * @author Srikanth and krunal
 * Query for retriving student personal details based on user_id
 * */
public static final String GET_STUDENT_PERSONAL_DETAILS_TO_VERIFY ="select tbl_user.user_id,tbl_user.first_name,tbl_user.last_name,tbl_user.email,"
		+ "tbl_user.mobile_no, tbl_user.gender,tbl_user.image,"
		+ "tbl_user.d_o_b,tbl_status.`status`,tbl_address.location, tbl_address.pincode,"
		+ "tbl_city.city,tbl_city.city_Id,tbl_state.state,tbl_country.country,tbl_role.role,tbl_country.country_id,tbl_state.state_id from tbl_user "
		+ "inner join tbl_role on tbl_role.role_id=tbl_user.role_id "
		+ "inner join  tbl_address on tbl_address.address_id = tbl_user.address_id "
		+ "inner join tbl_city on tbl_address.city_Id = tbl_city.city_Id"
		+ " inner join tbl_state on tbl_state.state_id= tbl_city.state_id"
		+ " inner join tbl_country on tbl_country.country_id=tbl_state.country_id"
		+ " inner join tbl_status on tbl_status.status_id=tbl_user.status_id"
		+ " where tbl_user.user_id=?";


/** 
 * @author Srikanth and krunal
 * Query for retriving student ALL education details based on user_id
 * */
public static final String GET_STUDENT_EDUCATION_DETAILS_TO_VERIFY ="select tbl_edu_type.edu_type,tbl_edu_details.percent_grade,"
		+ " tbl_edu_details.yop,tbl_stream.stream,tbl_college.college, tbl_univ.university,"
		+ " tbl_address.location,tbl_address.pincode,tbl_city.city,tbl_state.state,"
		+ " tbl_country.country,tbl_city.city_Id,tbl_stream.stream_id,tbl_univ.univ_id,tbl_edu_details.edu_type_id,tbl_country.country_id,tbl_state.state_id"
		+ " from tbl_edu_details "
		+ " inner join tbl_edu_type on tbl_edu_type.edu_type_id=tbl_edu_details.edu_type_id"
		+ " left outer join tbl_stream on tbl_stream.stream_id=tbl_edu_details.stream_id "
		+ " left outer join  tbl_college on tbl_college.college_id=tbl_edu_details.college_id "
		+ " left outer join  tbl_univ on tbl_univ.univ_id=tbl_college.univ_id"
		+ " left outer join  tbl_address on tbl_address.address_id=tbl_edu_details.address_id"
		+ " left outer join  tbl_city on tbl_city.city_Id=tbl_address.city_Id"
		+ " left outer join  tbl_state on tbl_state.state_id=tbl_city.state_id "
		+ " left outer join tbl_country on tbl_country.country_id=tbl_state.country_id "
		+ " where tbl_edu_details.user_id=?";




/** 
 * @author Srikanth and krunal
 * Query for retriving student courses based on user_id
 * */
public static final String GET_STUDENT_COURSES_TO_VERIFY = "select  c.course,tech.technology,u.technology_id from tbl_student_course sc"
		+ " left join tbl_user u on u.user_id=sc.user_id"
		+ " left join tbl_course c on c.course_id=sc.course_id"
		+ " left join tbl_technology tech on tech.technology_id=u.technology_id"
		+ " where u.user_id=?";


/** 
 * @author Srikanth and krunal
 * Query for retriving All education streams from database
 * */
public static final String GET_ALL_STREAMS = "select * from tbl_stream";



/** 
 * @author Srikanth and krunal
 * Query for retriving All Adress details which are already there in database to compare with new adress
 * */
public static final String GET_ALL_ADDRESSES = "select address_id,location,pincode,city_id from tbl_address where tbl_address.location=? and tbl_address.pincode=? and tbl_address.city_Id=?";


/** 
 * @author Srikanth and krunal
 * Query for Updating student personal details based on user_id
 * */
public static final String UPDATE_STUDENT_PERSONAL_DETAILS = "update tbl_user set first_name=?,last_name=?,email=?,"
		+ " mobile_no=?,gender=?,image=?,d_o_b=?,address_id=?,password=? where user_id=?";



/** 
 * @author Srikanth and krunal
 * Query for inserting student adress details
 * */
public static final String INSERT_STUDENT_NEW_ADDRESS = "insert into tbl_address (location,pincode,city_Id) values(?,?,?)";



/** 
 * @author Srikanth and krunal
 * Query for retriving all colleges details that are already availble in database to compare with new college
 * */
public static final String GET_ALL_COLLEGES_DETAILS = "select * from tbl_college where tbl_college.college=? and tbl_college.univ_id=?";


/** 
 * @author Srikanth and krunal
 * Query for inserting student new college details
 * */
public static final  String INSERT_NEW_COLLEGE_DETAILS = "insert into tbl_college (college,univ_id) values(?,?)";



/** 
 * @author Srikanth and krunal
 * Query for updating student HSC and SSC education details
 * */
public static final String UPDATE_STUDENT_SSC_HSC_DETAILS = "update tbl_edu_details set percent_grade=?,yop=? where user_id=? and edu_type_id=?";


/** 
 * @author Srikanth and krunal
 * Query for updating student Graduation and PG details
 * */
public static final String UPDATE_STUDENT_GRADUATION_PG_EDUCATION_DETAILS = "update tbl_edu_details set percent_grade=?,yop=?,stream_id=?,"
		+ " college_id=?,address_id=? where user_id=? and edu_type_id=?";


/** 
 * @author Srikanth and krunal
 * Query for INSERTING student PG details at the time of validation
 * */
public static final String INSERT_STUDENT_PG_EDUCATION_DETAILS ="insert into tbl_edu_details (percent_grade,yop,stream_id,college_id,address_id,edu_type_id,user_id) "
		+ "values(?,?,?,?,?,?,?)";



/** 
 * @author Srikanth and krunal
 * Query for retriving all universityes
 * */
public static final String GET_ALL_UNIVERSITYES = "select * from tbl_univ";


/** 
 * @author Srikanth and krunal
 * Query for retriving all courses based on technology
 * */
public static final String GET_COURSES_ON_TECHNOLOGY ="select  sc.course_id,c.course from tbl_tbl_tech_courses sc "
		+ "left join tbl_course c on c.course_id=sc.course_id "
		+ "left join tbl_technology tech on tech.technology_id=sc.technology_id where tech.technology_id=?";

/** 
 * @author Srikanth and krunal
 * Query for deleting courses of student
 * */
public static final String DELETE_COURSES ="delete from tbl_student_course where tbl_student_course.user_id=?";



/** 
 * @author Srikanth and krunal
 * Query for retriv course_id
 * */
public static final String GET_COURSE_ID = "select course_id from tbl_course where course=?";


/** 
 * @author Srikanth and krunal
 * Query for inserting student courses
 * */

public static final String INSERT_STUDENT_COURSES="insert into tbl_student_course(course_id,user_id) values(?,?)";


/** 
 * @author Srikanth and krunal
 * Query for updating student status
 * */

public static final String UPDATE_STUDENT_STATUS = "update tbl_user set tbl_user.status_id=2 where user_id=?";


	
	public static final String INFORMATION_RETREIVAL="select * from tbl_user where user_id=?;";

/**
* @author Amarendar Guthuru B-35 Java
*  GET_FEEDBACK_TYPE QUERY IS USED TO GETTING ALL TYPE OF FEEDBCAKS FOR STUDENTS
*/
public static final String GET_FEEDBACK_TYPE="select tbl_feedback_type.feedback_type_id,tbl_feedback_type.feedback_type from tbl_feedback_type";
/**
* @author Amarendar Guthuru B-35 Java
*  GET_COMPANY_NAMES QUERY IS USED TO GETTING ALL TYPE OF COMPNANY 
*/
public static final String GET_COMPANY_NAMES="select client_id,client_name from tbl_client";
/**
* @author Amarendar Guthuru B-35 Java
*  GET_CLIENT_ADDRESS_ON_CLIENT_NAME QUERY IS USED TO GETTING ALL TYPE OF CITIES BASED CLIENT NAMES 
*/

public static final String GET_CLIENT_ADDRESS_ON_CLIENT_NAME="SELECT distinct TC.CITY_ID,TC.CITY FROM TBL_CLIENT_ADDRESS TLA,TBL_ADDRESS TA,TBL_CITY TC WHERE TLA.CLIENT_ID=? AND TLA.ADDRESS_ID=TA.ADDRESS_ID AND TA.CITY_ID=TC.CITY_ID";
/**
* @author Amarendar Guthuru B-35 Java
*  GET_CLIENT_ADDRESS_ON_CLIENT_NAME QUERY IS USED TO GETTING ALL TYPE OF CITIES BASED CLIENT NAMES 
*/
//public static final String GET_CLIENT_LOCATION_ON_CITY_NAME="select * from tbl_address where city_id=?";

public static final String GET_CLIENT_LOCATION_ON_CITY_NAME="select distinct a.location,a.address_id from tbl_client_address ca left join tbl_client c on c.client_id=ca.client_id left join tbl_address a on a.address_id=ca.address_id where c.client_id=? and a.city_id=?"; 

/**
* @author Amarendar Guthuru B-35 Java
*  GET_CLIENTADDRESSID_ON_CLIENTID_AND_ADDRESSID QUERY IS USED TO GETTING  ADDRESS_ID ON CLIENT_ID AND CITY_ID
*/
public static final String GET_CLIENTADDRESSID_ON_CLIENTID_AND_ADDRESSID="SELECT client_address_id FROM TBL_CLIENT_aDDRESS where client_id=? and address_id=?";

/**
* @author Amarendar Guthuru B-35 Java
*  SAVE_FEEDBACK QUERY IS USED TO INSERT STUDENT FEEDBACK INTO DB
*/
public static final String SAVE_FEEDBACK="INSERT INTO tbl_feedback (feedback_msg,feedback_type_id,user_id,client_address_id,date) values (?,?,?,?,sysdate())";


/**
 * @author Amarendar Guthuru
 * GET ALL TYPE OF FEEDBACKS
 */

public static final String GET_ALL_FEEDBACKS="select c.client_id,c.client_name,c.image,ct.city_Id,ct.city,f.feedback_id,"
		+ "f.feedback_type_id,f.feedback_msg,f.date,u.user_id,u.first_name,u.last_name,u.email,"
		+ "u.batch_id,b.batch,t.technology_id,t.technology,ca.client_address_id,"
		+ "ad.address_id ,ad.location from tbl_client c,tbl_feedback f,tbl_user u,tbl_technology t,"
		+ "tbl_client_address ca,tbl_city ct,tbl_address ad,tbl_batch b where "
		+ " f.user_id=u.user_id and f.client_address_id=ca.client_address_id and "
		+ " ca.address_id=ad.address_id and ad.city_Id=ct.city_Id and ca.client_id=c.client_id and "
		+ " t.technology_id=u.technology_id and u.batch_id=b.batch_id ";






/**
 * @author Amarendar Guthuru
 * FILTER FEEDBACKS BASED ON THE ORGANISATION
 */



public static final String FILTER_ORAGANISATION_FEEDBACKS="select c.client_id,c.client_name,c.image,ct.city_Id,ct.city,f.feedback_id,"
		+ "f.feedback_type_id,f.feedback_msg,f.date,u.user_id,u.first_name,u.last_name,u.email,"
		+ "u.batch_id,b.batch,t.technology_id,t.technology,ca.client_address_id,"
		+ "ad.address_id ,ad.location from tbl_client c,tbl_feedback f,tbl_user u,tbl_technology t,"
		+ "tbl_client_address ca,tbl_city ct,tbl_address ad,tbl_batch b where "
		+ " f.user_id=u.user_id and f.client_address_id=ca.client_address_id and "
		+ " ca.address_id=ad.address_id and ad.city_Id=ct.city_Id and ca.client_id=c.client_id and "
		+ " t.technology_id=u.technology_id and u.batch_id=b.batch_id and f.feedback_type_id=? ";

/**
 * @author Amarendar Guthuru
 * FILTER FEEDBACKS BASED ON THE COMPANIES 
 */
public static final String FILTER_COMPANIES_FEEDBACKS="select c.client_id,c.client_name,c.image,ct.city_Id,ct.city,f.feedback_id,"
		+ "f.feedback_type_id,f.feedback_msg,f.date,u.user_id,u.first_name,u.last_name,u.email,"
		+ "u.batch_id,b.batch,t.technology_id,t.technology,ca.client_address_id,"
		+ "ad.address_id ,ad.location from tbl_client c,tbl_feedback f,tbl_user u,tbl_technology t,"
		+ "tbl_client_address ca,tbl_city ct,tbl_address ad,tbl_batch b where "
		+ " f.user_id=u.user_id and f.client_address_id=ca.client_address_id and "
		+ " ca.address_id=ad.address_id and ad.city_Id=ct.city_Id and ca.client_id=c.client_id and "
	    + " t.technology_id=u.technology_id and u.batch_id=b.batch_id and (f.feedback_type_id=? and c.client_id=?  and ad.city_Id=? )";
/**
 * @author Amarendar Guthuru
 * Filter feedbacks based on clinet name and feedback type
 */

public static final String FILTER_COMPANIES_FEEDBACKS_CLIENT = "select c.client_id,c.client_name,c.image,ct.city_Id,ct.city,f.feedback_id,"
		+ "f.feedback_type_id,f.feedback_msg,f.date,u.user_id,u.first_name,u.last_name,u.email,"
		+ "u.batch_id,b.batch,t.technology_id,t.technology,ca.client_address_id,"
		+ "ad.address_id ,ad.location from tbl_client c,tbl_feedback f,tbl_user u,tbl_technology t,"
		+ "tbl_client_address ca,tbl_city ct,tbl_address ad,tbl_batch b where "
		+ " f.user_id=u.user_id and f.client_address_id=ca.client_address_id and "
		+ " ca.address_id=ad.address_id and ad.city_Id=ct.city_Id and ca.client_id=c.client_id and "
		+ " t.technology_id=u.technology_id and u.batch_id=b.batch_id and (f.feedback_type_id=? and c.client_id=?  )";

/**
 * @author Amarendar Guthuru
 * Filter feedback based on the  feedback type
 */
public static final String FILTER_COMPANIES_FEEDBACKS_TYPE = "select c.client_id,c.client_name,c.image,ct.city_Id,ct.city,f.feedback_id,"
		+ "f.feedback_type_id,f.feedback_msg,f.date,u.user_id,u.first_name,u.last_name,u.email,"
		+ "u.batch_id,b.batch,t.technology_id,t.technology,ca.client_address_id,"
		+ "ad.address_id ,ad.location from tbl_client c,tbl_feedback f,tbl_user u,tbl_technology t,"
		+ "tbl_client_address ca,tbl_city ct,tbl_address ad,tbl_batch b where "
		+ " f.user_id=u.user_id and f.client_address_id=ca.client_address_id and "
		+ " ca.address_id=ad.address_id and ad.city_Id=ct.city_Id and ca.client_id=c.client_id and "
		+ " t.technology_id=u.technology_id and u.batch_id=b.batch_id and (f.feedback_type_id=?  )";
/**
 * @author Amarendar Guthuru
 * Filter all companies
 */
public static final String FILTER_COMPANIES_FEEDBACKS_ALL_TYPE = "select c.client_id,c.client_name,c.image,ct.city_Id,ct.city,f.feedback_id,"
		+ "f.feedback_type_id,f.feedback_msg,f.date,u.user_id,u.first_name,u.last_name,u.email,"
		+ "u.batch_id,b.batch,t.technology_id,t.technology,ca.client_address_id,"
		+ "ad.address_id ,ad.location from tbl_client c,tbl_feedback f,tbl_user u,tbl_technology t,"
		+ "tbl_client_address ca,tbl_city ct,tbl_address ad,tbl_batch b where "
		+ " f.user_id=u.user_id and f.client_address_id=ca.client_address_id and "
		+ " ca.address_id=ad.address_id and ad.city_Id=ct.city_Id and ca.client_id=c.client_id and "
		+ " t.technology_id=u.technology_id and u.batch_id=b.batch_id ";





	


/**
 * @author Srinivas N
 * GET_CLIENT_ALL_DETAILS IS USED TO GET  ALL COMPANY DETAILS
 */
	
public static final String GET_CLIENT_ALL_DETAILS = "select c.client_id,c.client_name,c.image,c.description,c.company_level_id,l.level " +
        "  from tbl_client c,tbl_level l where c.company_level_id=l.level_id  " +
        "  ORDER BY c.client_name";

/**
 * @author Srinivas N
 * ADD_NEW_JOB_POSTING IS USED TO ADD NEW JOBPOSTING
 */

public static final String ADD_NEW_JOB_POSTING= "insert into tbl_job_posting(description,expected_date,assesment_start_date,assesment_end_date," +
        "posted_date,no_of_vacancies,client_address_id,tbl_technology_technology_id)values (?,?,?,?,?,?,?,?)";


/**
 * @author Srinivas N
 * GET_ALL_TCHNOLOGIES IS USED TO GET ALL TECHNOLOGYS 
 */
public static final String GET_ALL_TCHNOLOGIES = "select technology_id, technology from tbl_technology";

/**
 * @author Srinivas N
 * GET_CLIENT_DETAILS IS USED TO GET ALL THE DETAILS 
 */
public final static String GET_CLIENT_DETAILS_FOR_JOB_POSTING = "select c.client_name,a.address_id,cl.client_address_id," +
        "a.location,a.pincode,cc.city,s.state,cou.country " +
        " from tbl_client_address cl,tbl_client c,tbl_city cc," +
        "tbl_state s,tbl_country cou,tbl_address a where  " +
        "a.city_Id=cc.city_Id and cc.state_id=s.state_id and  " +
        "s.country_id=cou.country_id and c.client_id=? and " +
        "c.client_id=cl.client_id and cl.address_id=a.address_id";

/**
 * @author Srinivas N
 * GET_lOCATION_RELATED_ADDRESS IS USED TO GET ALL THE LOCATION RELATED ADDRESS 
 */

public final static String GET_lOCATION_RELATED_ADDRESS = "select c.city,s.state,cou.country,a.pincode from tbl_city c,tbl_state s," +
        "tbl_country cou,tbl_address a where a.address_id=? and a.city_Id=c.city_Id and " +
        " c.state_id=s.state_id and s.country_id=cou.country_id";

/**
 * @author Srinivas N
 * GET_CLIENT_DETAILS_FOR_EDITING  
 */
public final static String GET_CLIENT_DETAILS_FOR_EDITING = "select  j.job_posting_id,j.description,j.expected_date,"
		+ "j.assesment_start_date,j.assesment_end_date,j.posted_date,"
		+ "j.no_of_vacancies,a.location,a.pincode,c.city,s.state,"
		+ "cou.country,t.technology,cl.client_name,cl.image,"
		+ "a.address_id,t.technology_id,cl.client_id "
		+ "from tbl_job_posting j inner join tbl_client_address ca "
		+ "on j.client_address_id=ca.client_address_id inner join tbl_address a "
		+ "on a.address_id=ca.address_id inner join tbl_city c on  "
		+ "c.city_Id =a.city_Id inner join tbl_state s on "
		+ "s.state_id=c.state_id inner join tbl_country cou on "
		+ "cou.country_id = s.country_id INNER JOIN tbl_client cl on "
		+ "cl.client_id = ca.client_id inner join tbl_technology t  "
		+ "on t.technology_id = j.tbl_technology_technology_id "
		+ "where j.expected_date>now()";

/**
 * @author Srinivas N
 * GET_ALL_CLIENT_ADDRESESS 
 */
public final static String GET_ALL_CLIENT_ADDRESESS = "select c.city,s.state,cou.country,a.pincode,a.location,"
		+ "a.address_id from tbl_city c,tbl_state s,tbl_country cou,"
		+ "tbl_address a where  a.city_Id=c.city_Id and c.state_id=s.state_id "
		+ "and s.country_id=cou.country_id";

/**
 * @author Srinivas N
 * GET_CLIENT_ADDRESS_ID FOR GIVEN ADDRSSS ID 
 */
public final static String GET_CLIENT_ADDRESS_ID="SELECT CLIENT_ADDRESS_ID FROM tbl_client_address WHERE ADDRESS_ID=?";
/**
 * @author Srinivas N
 * EDIT_JOB_POSTING FOR GIVEN ADDRSSS ID 
 */

public final static String EDIT_JOB_POSTING="UPDATE tbl_job_posting   SET description=?,expected_date=?," +
        "assesment_start_date=?,assesment_end_date=?," +
        "no_of_vacancies=?,client_address_id=?,tbl_technology_technology_id=?" +
        "  WHERE job_posting_id=?";

/**
 * @author rajnish b-35
 * Query for retriving Email_id from the tbl_user and send to   mail all the HR address
 */

public static final String GET_HR_ADMIN_EMAIL="select email from tbl_user where role_id=?";

public static final String GET_CITY = "select tbl_city.city_id,tbl_city.city from tbl_city where tbl_city.state_id=?";
	

/**
 * @author Praveen Guggilla
 * GET_UNIVERITIES IS USED TO GET ALL UNIVERISTIES
 */
public static final String GET_UNIVERITIES = "select * from tbl_univ";

/**
 * @author Praveen Guggilla
 * GET_COLLEGES IS USED TO GET ALL COLLEGES OF GIVEN UNIVERSITY_ID
 */
public static final String GET_COLLEGES = "select * from tbl_college where univ_id=?";

/**
 * @author Praveen Guggilla
 * 
 * THIS QUERY IS USED TO GET_STUDENT_PERSONAL_DETAILS_QUERY BASED ON USER_ID
 */
public static final String GET_STUDENT_PERSONAL_DETAILS="select tbl_user.user_id,tbl_user.first_name,tbl_user.last_name,tbl_user.email,	"
		+ " tbl_user.mobile_no, tbl_user.gender,tbl_user.image,"
		+ " tbl_user.d_o_b,tbl_status.`status`,tbl_address.location, tbl_address.pincode,"
		+ " tbl_city.city,tbl_city.city_Id,tbl_state.state,tbl_state.state_Id,tbl_country.country,tbl_country.country_id,tbl_technology.technology,tbl_role.role from tbl_user "
		+ " inner join tbl_role on tbl_role.role_id=tbl_user.role_id "
		+ " inner join  tbl_address on tbl_address.address_id = tbl_user.address_id "
		+ " inner join tbl_city on tbl_address.city_Id = tbl_city.city_Id"
		+ " inner join tbl_state on tbl_state.state_id= tbl_city.state_id"
		+ " inner join tbl_country on tbl_country.country_id=tbl_state.country_id"
		+ " inner join tbl_technology on tbl_technology.technology_id=tbl_user.technology_id "
		+ " inner join tbl_status on tbl_status.status_id=tbl_user.status_id"
		+ " where tbl_user.user_id=?";


/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET_STUDENT_EDUCATIONAL_DETAILS_QUERY BASED ON USER_ID
 */
public static final	String GET_STUDENT_EDUCATIONAL_DETAILS ="select tbl_edu_type.edu_type,tbl_edu_details.percent_grade,"
		+ " tbl_edu_details.yop,tbl_stream.stream,tbl_college.college, tbl_univ.university,"
		+ " tbl_address.location,tbl_address.pincode,tbl_city.city,tbl_state.state,"
		+ " tbl_country.country,tbl_city.city_Id,tbl_stream.stream_id,tbl_univ.univ_id,tbl_edu_details.edu_type_id,tbl_country.country_id,tbl_state.state_id"
		+ " from tbl_edu_details "
		+ " inner join tbl_edu_type on tbl_edu_type.edu_type_id=tbl_edu_details.edu_type_id"
		+ " left outer join tbl_stream on tbl_stream.stream_id=tbl_edu_details.stream_id "
		+ " left outer join  tbl_college on tbl_college.college_id=tbl_edu_details.college_id "
		+ " left outer join  tbl_univ on tbl_univ.univ_id=tbl_college.univ_id"
		+ " left outer join  tbl_address on tbl_address.address_id=tbl_edu_details.address_id"
		+ " left outer join  tbl_city on tbl_city.city_Id=tbl_address.city_Id"
		+ " left outer join  tbl_state on tbl_state.state_id=tbl_city.state_id "
		+ " left outer join tbl_country on tbl_country.country_id=tbl_state.country_id "
		+ " where tbl_edu_details.user_id=?";


/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET_STUDENT_COURSES BASED ON USER_ID
 */
public static final String GET_STUDENT_COURSES="select  c.course,tech.technology,u.technology_id from tbl_student_course sc"
		+ " left join tbl_user u on u.user_id=sc.user_id"
		+ " left join tbl_course c on c.course_id=sc.course_id"
		+ " left join tbl_technology tech on tech.technology_id=u.technology_id"
		+ " where u.user_id=?";

/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET_TECHNOLOGY_IDBASED ON USER_ID
 */
public static final String GET_TECHNOLOGY_ID="select technology_id from tbl_technology where technology=?";

/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET_THE_ADDRESS 
 */
public static final String GET_ADDRESS = "select address_id,location,pincode,city_id from tbl_address where tbl_address.location=? and tbl_address.pincode=? and tbl_address.city_Id=?";

/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO INSERT THE ADDRESS
 * 
 *  
 */
public static final String INSERT_ADDRESS = "insert into tbl_address (location,pincode,city_Id) values(?,?,?)";
/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO UPDATE STUDENT DETAILS BASED ON USER_ID
 * 
 *  
 */
public static final String UPDATE_STUDENT_DETAILS = "update tbl_user set email=?, mobile_no=?,address_id=?,technology_id=? where user_id=?";



//POST GRADUATION DETAILS


/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET COLLEGE_ID BASED ON UNIVERSITY_ID
 * 
 *  
 */
public static final String GET_COLLEGE_ID="select college_id from tbl_college where univ_id=?";



/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET EDUCATION_TYPE_ID BASED ON EDUCATION_TYPE
 * 
 *  
 */
public static final String GET_EDUCATION_TYPE_ID="select edu_type_id from tbl_edu_type where edu_type=?";
/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO INSERT COLLEGE AND UNIVERSITY_ID
 * 
 *  
 */
public static final String INSERT_COLLEGE_AND_UNIVERSITY_ID = "insert into tbl_college (college,univ_id) values(?,?)";
/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO INSERT LOCATION AND CITY_ID
 * 
 *  
 */
public static final String INSERT_LOCATION_AND_CITY_ID = "insert into tbl_address (location,city_Id) values(?,?)";

/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO INSERT STUDENT POST GRADUATION DETAILS
 * 
 *  
 */
public static final String INSERT_STUDENT_POST_GRADUATION_DETAILS = "insert into tbl_edu_details (percent_grade, yop, stream_id, college_id, edu_type_id,address_id,user_id) VALUES (?,?,?,?,?,?,?)";

/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET STREAMS LIKE ECE,CSE,IT
 * 
 *  
 */
public static final String GET_STREAMS="select stream_id,stream from tbl_stream";



/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET TECHNOLOGY_ID OF USER
 * 
 *  
 */
public static final String GET_STUDENT_TECHNOLOGY_ID="select technology_id from tbl_user where user_id=?";
/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET COURSES BASED ON THE TECHNOLOGY_ID
 * 
 *   
 */

public static final String GET_COURSES_ON_TECHNOLOGY_ID="select course ,course_id from tbl_course where course_id in (select course_id from tbl_tbl_tech_courses where technology_id=?)";
/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO DELETE STUDENT COURSES BEFORE INSERTING INTO THE TABLE
 * 
 *   
 */

public static final String DELETE_STUDENT_COURSES ="delete from tbl_student_course where tbl_student_course.user_id=?";

/**
 * @author Praveen Guggilla
 * THIS QUERY IS USED TO GET COURSE_ID ON THE BASIS OF COURSE OF THE STUDENT
 * 
 *   
 */

public static final String GET_STUDENT_COURSE_ID = "select course_id from tbl_course where course=?";








/**
 * @author Swapnil 
 * ADD_TECHNOLOGY IS USED TO ADD ALL TECHNOLOGY IN TABLE
 */
public 	static final String	ADD_TECHNOLOGY = "INSERT INTO tbl_technology (technology) SELECT ? As technology FROM (SELECT Count(*) As  ExistsCount FROM tbl_technology WHERE technology = ?)  AS  e WHERE e.ExistsCount=0";

/**
 * @author Swapnil 
 * ADD_COURSE IS USED TO ADD ALL COURSES IN TABLE
 */
public 	static final String	ADD_COURSE = "INSERT INTO tbl_course (course) SELECT ? As course FROM (SELECT Count(*) As  ExistsCount FROM tbl_course WHERE course = ?) AS  e WHERE e.ExistsCount=0";

/**
 * @author Swapnil 
 * EDIT_TECHNOLOGY IS USED TO EDIT ALL TECHNOLOGY IN TABLE
 */
public static final String EDIT_TECHNOLOGY = "UPDATE tbl_technology set technology=? where technology_id=?";

/**
 * @author Swapnil 
 * EDIT_COURSE IS USED TO EDIT ALL COURSES IN TABLE
 */
public static final String EDIT_COURSE = "Update tbl_course set course=? where course_id=?";

/**
 * @author Swapnil 
 * GET_TECHNOLOGIES IS USED TO GET ALL TECHNOLOGY IN TABLE
 */
public static final String GET_TECHNOLOGIES = "select technology_id,technology FROM tbl_technology";

/**
 * @author Swapnil 
 * GET_COURSES  IS USED TO GET ALL COURSES IN TABLE
 */
public static final String GET_COURSES = "select course_id,course FROM tbl_course";

/**
 * @author Swapnil 
 * GET_COURSE_DETAILS  IS USED TO GET ALL COURSES DETAILS IN TABLE
 */
public static final String GET_COURSE_DETAILS="select * from tbl_course;";
/**
 * @author Swapnil 
 * GET_NOT_ASSIGNED_COURSE IS USED TO GET ALL TECHNOLOGY IN TABLE
 */
public static final String GET_NOT_ASSIGNED_COURSE="select * from tbl_course where course_id NOT IN (select course_id from tbl_tbl_tech_courses where  technology_id=?)";

/**
 * @author Swapnil 
 * GET_technology_DETAILS  IS USED TO GET ALL TECHNOLOGY DETAILS IN TABLE
 */
public static final String GET_technology_DETAILS ="select * from tbl_technology;";

/**
 * @author Swapnil 
 * ADD_TECH_COURSE  IS USED TO ADD ALL TECHNOLOGY_COURSES DETAILS IN TABLE
 */
public static final String ADD_TECH_COURSE = "insert into tbl_tbl_tech_courses(technology_id,course_id)values(?,?)";




public static final String GET_ROLE_BY_ADMIN ="select role_id,role from tbl_role";


/**
 * @author Sunil kumar Maharana
 * GET_TECHNOLOGY IS USED TO GET ALL TECHNOLOGY
 */
public static final String GET_TECHNOLOGY ="select tbl_technology.technology_id,tbl_technology.technology from tbl_technology";

/**
 * @author Sunil kumar Maharana
 * GET_COURSE IS USED TO GET ALL COURSES  W.R.T SELECTED TECHNOLOGY
 */
public static final String GET_COURSE="select tbl_course.course_id,tbl_course.course from tbl_course join tbl_tbl_tech_courses on tbl_tbl_tech_courses.course_id=tbl_course.course_id where tbl_tbl_tech_courses.technology_id=?";

/**
 * @author Sunil kumar Maharana
 * GET_UNIVERSITIES IS USED TO GET ALL UNIVERSITY 
 * */
public static final String GET_UNIVERSITIES = "select tbl_univ.univ_id,tbl_univ.university from tbl_univ";

/**
 * @author Sunil kumar Maharana
  * GET_COLLEGES IS USED TO GET ALL COLLEGES OF GIVEN UNIVERSITY_ID
 */
public static final String GET_COLLEGES_SUNIL = "select tbl_college.college_id,tbl_college.college from tbl_college where univ_id=?";

/**
 * @author sunil kumar maharana
 * INSERT_ADDRESS IS UESD TO INSERT AN ADDRESS INTO TBL_ADDRESS TABLE
 */
public static final String INSERT_STUDENT_ADDRESS="insert into tbl_address(location,pincode,city_Id) values(?,?,?)";
/**
 * @author sunil kumar maharana
 * GET_ADDRESSID IS UESD TO GET ADDRESSID FROM TBL_ADDESS TABLE BASED ON LOCATION,PINCODE,CITYID
 */
public static final String GET_STUDENT_ADDRESS_ID="select tbl_address.address_id from tbl_address where tbl_address.location=? and tbl_address.pincode=? and tbl_address.city_Id=?;";
/**
 * @author sunil kumar maharan
 * INSERT_USER IS USED TO INSERT A USER INTO TBL_USER
 */
public static final String INSERT_STUDENT="insert into tbl_user(first_name,last_name,email,password,mobile_no,gender,image,d_o_b,role_id,address_id,status_id,technology_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
/**
 * @author sunil kumar maharana
 * GET_USERID IS USED TO GET USERID FROM TBL_USER BASED ON EMAILID.
 */
public static final String GET_STUDENT_USE_ID="select tbl_user.user_id from tbl_user where tbl_user.email=?";

/**
 *@author sunil kumar maharana
 *GET_UNIVERSITY_ID is used to get uniersirtId by taking university name
 */
public static final String GET_UNIVERSITY_ID="select tbl_univ.univ_id from tbl_univ where tbl_univ.university=?";
/**
 *@author sunil kumar maharana
 *INSERT_UNIVERSITY IS USED TO INSERT AN UNIVERSITY INTO TBL_UNIV
 */
public static final String INSERT_UNIVERSITY="insert into tbl_univ(university) values(?)";
/**
 * @author sunil kumar maharana
 * GET_COLLEGE_ID is used to get collegeId by taking universityId and college name
 */
public static final String GET_COLLEGE_ID_SUNIL="select tbl_college.college_id from tbl_college where college=? and univ_id=?";

/**
 *@author sunil kumar maharana
 *INSERT_COLLEGE IS USED TO INSERT AN COLLEGE INTO TBL_COLLEGE 
 */

public static final String INSERT_COLLEGE="insert into tbl_college(college,univ_id) values(?,?)";
/**
 *@author sunil kumar maharana
 *INSERT_EDUCATIONAL_DETAILS is used to insert educational details into tbl_edu_details
 */
public static final String INSERT_EDUCATIONAL_DETAILS="insert into tbl_edu_details(percent_grade,yop,stream_id,college_id,edu_type_id,address_id,user_id) values(?,?,?,?,?,?,?)";

public static final String INSERT_SSC_INTER_EDUCATIONAL_DETAILS="insert into tbl_edu_details(percent_grade,yop,edu_type_id,user_id) values(?,?,?,?)";










/*-------------------------------vijay----------------------------------------------*/


/**
 * Query for getting all notifications about admin
 * @author Vijay kumar.p
 * used in NotifiacationDaoImpl class
 */
public static final String GETTING_ALL_ADMIN_NOTIFICATION="select job_posting_id,client_name,job.description,c.image from tbl_job_posting job,"
		+ "tbl_client_address ca,tbl_client c,tbl_user u where  job.client_address_id=ca.client_address_id "
		+ "and u.address_id=ca.address_id and ca.client_address_id=c.client_id and u.user_id= ? "
		+ " and job.assesment_start_date>curdate()";

/**
 * query for admin sending notification to student (inserting query for interview round)
 * 
 * @author Vijay kumar.p
 * 
 * used in NotifiacationDaoImpl class
*/
public static final String QRY_INSERTING_STUDENT_INTERVIEW_ROUND="INSERT INTO tbl_interview_round (`round_no`, `job_posting_id`, "
		+ "`description`, `date`, `status_id`, `address_id`)	VALUES (?, ?,?,?,?,"
		+ " (select a.address_id from tbl_job_posting j "
		+ "left join tbl_client_address ca on ca.client_address_id=j.client_address_id "
		+ "left join tbl_address a on a.address_id=ca.address_id where j.job_posting_id=?))";
/**
 * query for eligible student for assessment test
 * 
 * @author Vijay kumar.p
 * 
 * used in NotifiacationDaoImpl class
 */

public static final String QRY_ELEGIBLE_STUDENT="INSERT INTO tbl_elegible_student (`interview_round_id`, `user_id`, `status_id`) VALUES (?,?,?)";

/**
 * query for for eligible student emailId's retrieving
 * @author Vijay kumar.p
 * 
 * used in NotifiacationDaoImpl class
 */

public static final String QRY_ELEGIBLE_STUDENT_EMAILS="select u.email from tbl_user u, tbl_elegible_student es where es.user_id=u.user_id and es.elegible_student_id=?";


/**
 * query for sending job oppertunity for selected student directly
 * 
 * @author Vijay kumar.p
 * 
 * this query used in JobOpportunityPostingDaoimpl
 */

public static final String QRY_SENDING_NOTIFICATIONS_DIRECTLY="select email from tbl_user u,tbl_edu_details e where u.status_id not in(?) and u.role_id=? and u.user_id=e.user_id and e.yop=? and e.percent_grade>=?";


/**
 * query for viewing job opportunity  view by admin
 * 
 * @author Vijay kumar.p
 * this query used in JobOpportunityPostingDaoimpl
 * 
 */

public static final String QRY_VIEW_JOBOPPORTUNITY="select client_name,image,location,city,state,country,pincode,contact_person_name,"
		+ "contact_person_mobile_no,contact_person_mail,c.description,j.description,expected_date,assesment_start_date,"
		+ "assesment_end_date,posted_date,no_of_vacancies,technology from tbl_client c,tbl_client_address ca,"
		+ "tbl_job_posting j,tbl_state st,tbl_country co,tbl_technology t,tbl_address ad,tbl_city ct  "
		+ "where c.client_id=ca.client_id and ca.client_address_id=j.client_address_id and "
		+ "j.client_address_id=ad.address_id and ad.address_id=ct.city_Id and ct.state_id=st.state_id "
		+ "and st.country_id=co.country_id and j.tbl_technology_technology_id=t.technology_id and "
		+ "j.job_posting_id=? and j.assesment_start_date>curdate()";

/**
 * query for selecting students for short listing
 * @author Vijay kumar.p
 * 
 * this query used in JobOpportunityPostingDaoimpl
 * 
 */

public static final String QRY_SELECT_STUDENTS_SHORT_LIST=" select u.user_id,u.email, u.first_name, u.last_name, ed.percent_grade, ed.yop from tbl_user u "
        +"left join tbl_role r on r.role_id=u.role_id left join tbl_edu_details ed on ed.user_id=u.user_id "
        +"left outer join tbl_elegible_student es on es.user_id = u.user_id "
        +"Left outer join tbl_interview_round ir on ir.interview_round_id = es.interview_round_id "
        +"and ir.job_posting_id=?  where r.role_id=? and u.user_id not in(select tbl_user.user_id from " 
        +"tbl_edu_details join tbl_user on tbl_edu_details.user_id=tbl_user.user_id  "
        +"join tbl_elegible_student on tbl_elegible_student.user_id= tbl_user.user_id join tbl_interview_round "
        +"on tbl_interview_round.interview_round_id=tbl_elegible_student.interview_round_id  "
        +"where tbl_interview_round.job_posting_id=?)    ";

/**
 * query for selecting students by tHeir year of passed out
 * @author Vijay kumar.p
 * 
 * this query used in JobOpportunityPostingDaoimpl
 * 
 */
/* public static final String QRY_SELECT_YOP="select u.user_id,u.email, u.first_name, u.last_name, ed.percent_grade, ed.yop from tbl_user u  "
        +"left join tbl_role r on r.role_id=u.role_id left join tbl_edu_details ed on ed.user_id=u.user_id "
        +"left outer join tbl_elegible_student es on es.user_id = u.user_id "
        +"Left outer join tbl_interview_round ir on ir.interview_round_id = es.interview_round_id "
        +"and ir.job_posting_id=? where r.role_id=? and u.user_id not in(select tbl_user.user_id from  "
        +"tbl_edu_details join tbl_user on tbl_edu_details.user_id=tbl_user.user_id  "
        +"join tbl_elegible_student on tbl_elegible_student.user_id= tbl_user.user_id join tbl_interview_round "
        +"on tbl_interview_round.interview_round_id=tbl_elegible_student.interview_round_id  "
        +" where tbl_interview_round.job_posting_id=? ) and ed.yop in ( "
		+ "?" + ")";*/

/**
	 * query for selecting students by tHeir percentage
	 * @author Vijay kumar.p
	 * 
	 * this query used in JobOpportunityPostingDaoimpl
	 * 
	 */

public static final String QRY_SELECT_STUDENT_PERCENTAGE="select u.user_id,u.email, u.first_name, u.last_name, ed.percent_grade, ed.yop from tbl_user u  "
        +"left join tbl_role r on r.role_id=u.role_id left join tbl_edu_details ed on ed.user_id=u.user_id  "
        +"left outer join tbl_elegible_student es on es.user_id = u.user_id  "
        +"Left outer join tbl_interview_round ir on ir.interview_round_id = es.interview_round_id  "
        +"and ir.job_posting_id=? where r.role_id=? and u.user_id not in(select tbl_user.user_id from  "
        +"tbl_edu_details join tbl_user on tbl_edu_details.user_id=tbl_user.user_id   "
        +"join tbl_elegible_student on tbl_elegible_student.user_id= tbl_user.user_id join tbl_interview_round  "
        +"on tbl_interview_round.interview_round_id=tbl_elegible_student.interview_round_id   "
        +" where tbl_interview_round.job_posting_id=? ) and ed.percent_grade >= ?  ";



/**
	 * query for selecting students by tHeir percentage yop
	 * @author Vijay kumar.p
	 * 
	 * this query used in JobOpportunityPostingDaoimpl
	 * 
	 */

/*public static final String QRY_SELECT_YOP_PER="select u.user_id,u.email, u.first_name, u.last_name, ed.percent_grade, ed.yop from tbl_user u "
        +"left join tbl_role r on r.role_id=u.role_id left join tbl_edu_details ed on ed.user_id=u.user_id "
        +"left outer join tbl_elegible_student es on es.user_id = u.user_id "
        +"Left outer join tbl_interview_round ir on ir.interview_round_id = es.interview_round_id "
        +"and ir.job_posting_id=? where r.role_id=? and u.user_id not in(select tbl_user.user_id from  "
        +"tbl_edu_details join tbl_user on tbl_edu_details.user_id=tbl_user.user_id  "
        +"join tbl_elegible_student on tbl_elegible_student.user_id= tbl_user.user_id join tbl_interview_round  "
        +"on tbl_interview_round.interview_round_id=tbl_elegible_student.interview_round_id  "
        +" where tbl_interview_round.job_posting_id=? ) and ed.yop in ( "
		+ "?" + ") and ed.percent_grade >= ? ";*/

/*-----------------------------------------------vijay------end queries-------------*/


/**
 * @author Vijay Kumar Reddy K
 * QRY_ADDPLACEMENTDETAILS IS USED TO INSERT ALL PLACEMENT DETAILS
 */				
public static final String QRY_ADDPLACEMENTDETAILS ="insert into tbl_placement(placement_id,selected_date,joining_date,package_per_anum,bond_aggrement_details,job_type_id,user_id,client_id) values(?,?,?,?,?,?,?,?)";

/**
 * @author Vijay Kumar Reddy K
 * QRY_PLACEMENT IS USED TO GET ALL PLACEMENT DETAILS
 */		
	public static final String QRY_PLACEMENT ="select u.first_name,u.last_name,u.email,u.image, p.bond_aggrement_details,p.package_per_anum,c.client_name from tbl_user u join tbl_placement p on u.user_id=p.user_id join tbl_client c on c.client_id=p.client_id join tbl_client_address ca on  ca.client_id=c.client_id join tbl_job_posting j on j.client_address_id=ca.client_address_id where j.job_posting_id=?";  
	
	/**
	 * @author Vijay Kumar Reddy K
	 * QRY_JOBPOST IS USED TO GET ALL JOBPOSTS
	 */		
	public static final String QRY_JOBPOST ="select job_posting_id,description from tbl_job_posting";
	
	/**
	 * @author Vijay Kumar Reddy K
	 * QRY_ROUNDDETAILS IS USED TO GET ALL ROUND DETAILS
	 */
	public static final String QRY_ROUNDDETAILS="select interview_round_id,description from tbl_interview_round where job_posting_id=?";
	
	/**
	 * @author Vijay Kumar Reddy K
	 * QRY_FIRSTROUNDDETAILS IS USED TO GET ALL FIRST ROUND DETAILS
	 */
	public static final String QRY_FIRSTROUNDDETAILS="select user.user_id,user.first_name,user.last_name,user.email,user.image,status.`status` from tbl_user user join tbl_elegible_student eligible on user.user_id = eligible.user_id and eligible.interview_round_id =? join tbl_status status on status.status_id = eligible.status_id";
	

	/**
	 * @author Vijay Kumar Reddy K
	 * QRY_USERDETAILS IS USED TO GET ALL USER DETAILS
	 */
	public static final String QRY_USERDETAILS="select user.user_id,user.first_name,user.last_name,user.email,user.image from tbl_user user join tbl_elegible_student eligible on user.user_id = eligible.user_id and eligible.status_id='3' join tbl_interview_round rounds on eligible.interview_round_id = rounds.interview_round_id and rounds.interview_round_id = ?";
	
	/**
	 * @author Vijay Kumar Reddy K
	 * QRY_INSERTSHORTLISTDETAILS1 IS USED TO INSERT ALL SHORT LIST  USER DETAILS
	 */
	public static final String QRY_INSERTSHORTLISTDETAILS1="insert into tbl_elegible_student(interview_round_id,user_id,status_id) values(?,?,?)";
	
	/**
	 * @author Vijay Kumar Reddy K
	 * QRY_INSERTSHORTLISTDETAILS2 IS USED TO INSERT ALL SHORT LIST  USER DETAILS
	 */
	public static final String QRY_INSERTSHORTLISTDETAILS2="insert into tbl_interview_round(round_no,job_posting_id,description,date,status_id,address_id) values(?,?,?,?,?,?)";
	

	/**
	 * @author Vijay Kumar Reddy K
	 * QRY_INSERTSHORTLISTDETAILS3 IS USED TO INSERT ALL SHORT LIST  USER DETAILS
	 */
	public static final String QRY_INSERTSHORTLISTDETAILS3="insert into tbl_elegible_student(interview_round_id,user_id,status_id) values(?,?,?)";
	
/*	*//**
	 * @author Vijay Kumar Reddy K
	 * GET_COUNTRY IS USED TO GET ALL COUNTRYS
	 *//*
	
	public static final String GET_COUNTRY="select tbl_country.country_id,tbl_country.country from tbl_country";	

*//**
 * @author Vijay Kumar Reddy K
 * GET_STATE IS USED TO GET ALL STATES OF GIVEN COUNTRY
 *//*
	public static final String GET_STATE="select tbl_state.state_id,tbl_state.state from tbl_state where tbl_state.country_id=?";

*//**
 * @author Vijay Kumar Reddy K
 * GET_CITY IS USED TO GET ALL CITY OF GIVEN STATE
 *//*
public static final String GET_CITY = "select tbl_city.city_id,tbl_city.city from tbl_city where tbl_city.state_id=?";

*//**
 * @author Chitranshu Gupta
 * GET_ASSESSMENT_TYPE IS USED TO GET ALL ASSESSMENT TYPES
 *//*

public static final String GET_ASSESSMENT_TYPE="select tbl_assessment_type.assessment_type_id, tbl_assessment_type.assessment_type_name from tbl_assessment_type";

*//**
 * @author Chitranshu Gupta
 * GET_ASSESSMENTS IS USED TO GET ALL ASSESSMENTS NAMES OF GIVEN ASSESSMENT_TYPE_ID
 *//*

public static final String GET_ASSESSMENTS="select tbl_assessment.assessment_id, tbl_assessment.assessment_name from tbl_assessment where tbl_assessment.assessment_type_id=?";

*//**
 * @author Chitranshu Gupta
 * GET_ASSESSMENT_DETAILS IS USED TO GET ASSESSMENT DETAILS OF GIVEN ASSESSMENT_ID
 *//*

public static final String GET_ASSESSMENT_DETAILS="select tbl_assessment.assessment_id, tbl_assessment.assessment_name, tbl_assessment.total_marks, tbl_assessment.duration_in_min, tbl_assessment.date, tbl_assessment.description from tbl_assessment where tbl_assessment.assessment_id=?";*/

/**
 * @author Chitranshu Gupta
 * GET_QUESTIONS_ANSWERS IS USED TO GET ALL QUESTIONS AND THEIR OPTIONS OF GIVEN ASSESSMENT_ID
 */
public static final String GET_QUESTIONS_ANSWERS="select tbl_question.question_id, tbl_question.question, tbl_question_option.option_id, tbl_question_option.`option` from tbl_question_option join tbl_question on tbl_question_option.question_id= tbl_question.question_id join tbl_assment_question on tbl_assment_question.question_id=tbl_question.question_id join tbl_assessment on tbl_assessment.assessment_id=tbl_assment_question.assessment_id where tbl_assessment.assessment_id=?";
}