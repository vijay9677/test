/**
 * 
 */
package com.nacre.online_assesment.dao_i.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nacre.online_assesment.dao_i.JobOpportunityPostingDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.AddressDTO;
import com.nacre.online_assesment.dto.CityDTO;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.dto.StateDTO;
import com.nacre.online_assesment.dto.StatusDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean;
import com.nacre.online_assesment.form_bean.SelectingAllstudentDetailsBean;
import com.nacre.online_assesment.form_bean.SelectingYopOrPercentageBean;
import com.nacre.online_assesment.form_bean.ShareJobOppertunityFormBean;
import com.nacre.online_assesment.form_bean.ShowJobDetailsBean;
import com.nacre.online_assesment.form_bean.ViewJobNotificationBean;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.vo.ClientAddressDetailVo;
import com.nacre.online_assesment.vo.FindJobPostingVO;
import com.nacre.online_assesment.vo.GetClientDetailForEditingVo;
import com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo;

/**
 * @author Sagar suryawanshi b 35
 * 
 */
public class JobOpportunityPostingDaoimpl implements JobOpportunityPostingDaoi {

	/**
	 * @author vijaykumar P
	 * @return ArrayList carries emailId's
	 * @param conn
	 *            Carries DB connection
	 * @param shareJobOppertunityFormBean
	 *            which carries student info for selecting students email
	 * @throws SQLException
	 */
	@Override
	public ArrayList<String> shareJobOppotunity(Connection conn,
			ShareJobOppertunityFormBean shareJobOppertunityFormBean) throws SQLException {
		PreparedStatement ps = null;
		ArrayList<String> list = null;

		// preparing Query
		//String query = "select email from tbl_user u,tbl_edu_details e where u.status_id=? and u.user_id=e.user_id and e.yop=? and e.percent_grade>=?";

		// creating prepareStatement
		ps = conn.prepareStatement(SQLQueryConstants.QRY_SENDING_NOTIFICATIONS_DIRECTLY);
		// assigning values to the query
		ps.setInt(1, StringConstants.STUD_STATUS_ID);
		ps.setInt(2, StringConstants.STUD_ROLE_ID);
		ps.setInt(3, shareJobOppertunityFormBean.getYop());
		ps.setString(4, shareJobOppertunityFormBean.getPercentage());

		// executing query
		ResultSet rs = ps.executeQuery();
		// creating arraylist
		list = new ArrayList<String>();

		// iterating resultSet for resulted values
		while (rs.next()) {

			System.out.println(rs.getString(1));
			// Adding result(email's) values to ArrayList
			list.add(rs.getString(1));

		} // while
System.out.println("email list...."+list);
		// returning Arraylist
		return list;
	}// end of the method

	/**
	 * @author vijaykumar P
	 * @param conn
	 *            which carries DB connection from database
	 * @param str
	 *            which carries jobpostid
	 * @return ViewJobNotificationBean object which carries job details
	 * @throws SQLException
	 */
	@Override
	public ViewJobNotificationBean viewJobOpportunity(Connection conn, String str) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> list = null;
		ViewJobNotificationBean viewJobNotificationBean = null;

		// preparing Query
		/*String query = "select client_name,image,location,city,state,country,pincode,contact_person_name,"
				+ "contact_person_mobile_no,contact_person_mail,c.description,j.description,expected_date,assesment_start_date,"
				+ "assesment_end_date,posted_date,no_of_vacancies,technology from tbl_client c,tbl_client_address ca,"
				+ "tbl_job_posting j,tbl_state st,tbl_country co,tbl_technology t,tbl_address ad,tbl_city ct  "
				+ "where c.client_id=ca.client_id and ca.client_address_id=j.client_address_id and "
				+ "j.client_address_id=ad.address_id and ad.address_id=ct.city_Id and ct.state_id=st.state_id "
				+ "and st.country_id=co.country_id and j.tbl_technology_technology_id=t.technology_id and "
				+ "j.job_posting_id=? and j.assesment_start_date>curdate()";*/

		// creating prepareStatement
		ps = conn.prepareStatement(SQLQueryConstants.QRY_VIEW_JOBOPPORTUNITY);

		// assigning values to the query
		ps.setString(1, str);

		// executing query
		rs = ps.executeQuery();

		// creating ViewJobOpportunitiesBean class object
		viewJobNotificationBean = new ViewJobNotificationBean();
		// iterating resultset object
		while (rs.next()) {

			// assigning resultSet values to the viewJobNotificationBean object

			viewJobNotificationBean.setCompanyName(rs.getString(1));
			viewJobNotificationBean.setClientLogo(rs.getString(2));
			viewJobNotificationBean.setLocation(rs.getString(3));
			viewJobNotificationBean.setCity(rs.getString(4));
			viewJobNotificationBean.setState(rs.getString(5));
			viewJobNotificationBean.setCountry(rs.getString(6));

			viewJobNotificationBean.setPincode(rs.getString(7));
			viewJobNotificationBean.setContatPersonName(rs.getString(8));
			viewJobNotificationBean.setContactPersonMobileNo(rs.getString(9));
			viewJobNotificationBean.setContactPersonEmail(rs.getString(10));
			viewJobNotificationBean.setCompanyDescription(rs.getString(11));
			viewJobNotificationBean.setJobDescription(rs.getString(12));
			viewJobNotificationBean.setExpecteddate(rs.getString(13));
			viewJobNotificationBean.setAssesmentStartDate(rs.getString(14));
			viewJobNotificationBean.setAssesmentEndDate(rs.getString(15));
			viewJobNotificationBean.setPostedDate(rs.getString(16));
			viewJobNotificationBean.setNoofvacancies(rs.getInt(17));
			viewJobNotificationBean.setTechnology(rs.getString(18));

		}

		// returning viewNotificationBean Object
		return viewJobNotificationBean;
	}

	/**
	 * @author vijaykkumr P
	 * @param conn
	 *            which Carries DB connection
	 * @param jobPostingId
	 * @return ArraList which carries student details
	 * @throws SQLException
	 */
	public ArrayList<SelectingAllstudentDetailsBean> getAllStudEmailsDetails(Connection conn, Integer jobPostingId)
			throws SQLException {
		ArrayList<SelectingAllstudentDetailsBean> list = new ArrayList<SelectingAllstudentDetailsBean>();

		
		// preparing query
		

		/*String query=" select u.user_id,u.email, u.first_name, u.last_name, ed.percent_grade, ed.yop from tbl_user u "
                     +"left join tbl_role r on r.role_id=u.role_id left join tbl_edu_details ed on ed.user_id=u.user_id "
                     +"left outer join tbl_elegible_student es on es.user_id = u.user_id "
                     +"Left outer join tbl_interview_round ir on ir.interview_round_id = es.interview_round_id "
                     +"and ir.job_posting_id=?  where r.role_id=? and u.user_id not in(select tbl_user.user_id from " 
                     +"tbl_edu_details join tbl_user on tbl_edu_details.user_id=tbl_user.user_id  "
                     +"join tbl_elegible_student on tbl_elegible_student.user_id= tbl_user.user_id join tbl_interview_round "
                     +"on tbl_interview_round.interview_round_id=tbl_elegible_student.interview_round_id  "
                     +"where tbl_interview_round.job_posting_id=?)    ";*/
		// Creating PrepareStatement
		PreparedStatement ps = conn.prepareStatement(SQLQueryConstants.QRY_SELECT_STUDENTS_SHORT_LIST);
		// Assigning values to the query
		ps.setInt(1, jobPostingId);
		ps.setInt(2, StringConstants._STUDENT_ROLE_ID);
		ps.setInt(3,jobPostingId);
		// executing the query
		ResultSet rs = ps.executeQuery();

		// iterating the resultSet
		while (rs.next()) {
			// Creating SelectingAllStudentBean class object
			SelectingAllstudentDetailsBean selectingAllstudentDetailsBean = new SelectingAllstudentDetailsBean();
			// assigning values to the SelectingAllStudentDetailsBean object

			selectingAllstudentDetailsBean.setUserNo(rs.getInt(1));
			selectingAllstudentDetailsBean.setEmailId(rs.getString(2));
			selectingAllstudentDetailsBean.setFirstName(rs.getString(3));
			selectingAllstudentDetailsBean.setLastNmae(rs.getString(4));
			selectingAllstudentDetailsBean.setPercetage(rs.getString(5));
			selectingAllstudentDetailsBean.setYop(rs.getInt(6));
			// adding SelectingAllStudentDetailsBean Object to ArrayList
			list.add(selectingAllstudentDetailsBean);
		}
		// returning ArrayList
		return list;

	}

	// selecting year or passedouts and percetage for filtering data

	/**
	 * @author vijaykumar P
	 * @param percentage
	 *            which Carries student academic percentage
	 * @param year
	 *            which carries student graduation year of passed out
	 * @param conn
	 *            which carries Database connection
	 * @param jobPostingId
	 * @return ArrayList returns student details
	 * @throws SQLException
	 */
	public ArrayList<SelectingYopOrPercentageBean> selectYearOrPer(String percentage, String year, Connection conn,
			Integer jobPostingId) throws SQLException {
		// creating ArrayList object
		ArrayList<SelectingYopOrPercentageBean> list = new ArrayList<SelectingYopOrPercentageBean>();
		String query = null;
		PreparedStatement ps = null;
		
		System.out.println("years................."+year);
		
		if (year != null) {
			year = year.substring(0, year.length() - 1);
		}
		// checking details for which query is going to be execute
		if (percentage == null) {
			
			// preparing query
						
			query="select u.user_id,u.email, u.first_name, u.last_name, ed.percent_grade, ed.yop from tbl_user u  "
                    +"left join tbl_role r on r.role_id=u.role_id left join tbl_edu_details ed on ed.user_id=u.user_id "
                    +"left outer join tbl_elegible_student es on es.user_id = u.user_id "
                    +"Left outer join tbl_interview_round ir on ir.interview_round_id = es.interview_round_id "
                    +"and ir.job_posting_id=? where r.role_id=? and u.user_id not in(select tbl_user.user_id from  "
                    +"tbl_edu_details join tbl_user on tbl_edu_details.user_id=tbl_user.user_id  "
                    +"join tbl_elegible_student on tbl_elegible_student.user_id= tbl_user.user_id join tbl_interview_round "
                    +"on tbl_interview_round.interview_round_id=tbl_elegible_student.interview_round_id  "
                    +" where tbl_interview_round.job_posting_id=? ) and ed.yop in ( "
					+ year+ ")";
			ps=conn.prepareStatement(query);
			// creating prepareStatement
			//ps = conn.prepareStatement(StringConstants.QRY_SELECT_YOP);
			// Assigning values to the query
			ps.setInt(1, jobPostingId);
			System.out.println("daoimpl  asaaaaaaaaa  " + jobPostingId);
			ps.setInt(2, StringConstants._STUDENT_ROLE_ID);
			ps.setInt(3, jobPostingId);
			//ps.setString(4, year);

			
		} else if (year != null && !year.trim().equalsIgnoreCase("") && percentage != null
				&& !percentage.trim().equalsIgnoreCase("")) {
						
			query="select u.user_id,u.email, u.first_name, u.last_name, ed.percent_grade, ed.yop from tbl_user u "
                    +" left join tbl_role r on r.role_id=u.role_id left join tbl_edu_details ed on ed.user_id=u.user_id "
                    +" left outer join tbl_elegible_student es on es.user_id = u.user_id "
                    +" Left outer join tbl_interview_round ir on ir.interview_round_id = es.interview_round_id "
                    +" and ir.job_posting_id=? where r.role_id=? and u.user_id not in(select tbl_user.user_id from  "
                    +" tbl_edu_details join tbl_user on tbl_edu_details.user_id=tbl_user.user_id  "
                    +" join tbl_elegible_student on tbl_elegible_student.user_id= tbl_user.user_id join tbl_interview_round  "
                    +" on tbl_interview_round.interview_round_id=tbl_elegible_student.interview_round_id  "
                    +" where tbl_interview_round.job_posting_id=? ) and ed.yop in ( "
					+ year + ") and ed.percent_grade >= ? ";

			ps = conn.prepareStatement(query);
			//ps = conn.prepareStatement(StringConstants.QRY_SELECT_YOP_PER);
			// assigning values to the query
			ps.setInt(1, jobPostingId);
			ps.setInt(2, StringConstants._STUDENT_ROLE_ID);
			ps.setInt(3, jobPostingId);
			//ps.setString(4, year);
			ps.setString(4, percentage);

		} else {
			// preparing query
						
			/*query="select u.user_id,u.email, u.first_name, u.last_name, ed.percent_grade, ed.yop from tbl_user u  "
                    +"left join tbl_role r on r.role_id=u.role_id left join tbl_edu_details ed on ed.user_id=u.user_id  "
                    +"left outer join tbl_elegible_student es on es.user_id = u.user_id  "
                    +"Left outer join tbl_interview_round ir on ir.interview_round_id = es.interview_round_id  "
                    +"and ir.job_posting_id=? where r.role_id=? and u.user_id not in(select tbl_user.user_id from  "
                    +"tbl_edu_details join tbl_user on tbl_edu_details.user_id=tbl_user.user_id   "
                    +"join tbl_elegible_student on tbl_elegible_student.user_id= tbl_user.user_id join tbl_interview_round  "
                    +"on tbl_interview_round.interview_round_id=tbl_elegible_student.interview_round_id   "
                    +" where tbl_interview_round.job_posting_id=? ) and ed.percent_grade >= ?  ";*/
			// creating prepareStatement
			ps = conn.prepareStatement(SQLQueryConstants.QRY_SELECT_STUDENT_PERCENTAGE);
			// assigning values to the query
			ps.setInt(1, jobPostingId);
			ps.setInt(2, StringConstants._STUDENT_ROLE_ID);
			ps.setInt(3, jobPostingId);
			ps.setString(4, percentage);

		}
		
		// executing query
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// creating SelectingYopOrPercentageBean object
			SelectingYopOrPercentageBean selectingYopOrPercentageBean = new SelectingYopOrPercentageBean();
			// assigning or setting values to the SelectingYopOrPercentafgeBean
			// class object
			selectingYopOrPercentageBean.setUserNo(rs.getInt(1));
			selectingYopOrPercentageBean.setEmailId(rs.getString(2));
			selectingYopOrPercentageBean.setFirstName(rs.getString(3));
			selectingYopOrPercentageBean.setLastNmae(rs.getString(4));
			selectingYopOrPercentageBean.setPercetage(rs.getString(5));
			selectingYopOrPercentageBean.setYop(rs.getInt(6));
			// adding SelectingYopOrPercentageBean object to the ArrayList
			list.add(selectingYopOrPercentageBean);
		}

		// returning ArrayList
		return list;
	}


	public JobOpportunityPostingDaoimpl() {
		System.out.println("in job posting Dao impl");
	}

	/**
	 * @author sagar Suryawanshi b 35
	 * @return List of JobPosting Objects
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	@Override
	public List<Object> getjobPostDetails(Connection con) throws SQLException {

		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.VIEW_JOB_POST_DETAILS);

		ResultSet rs = ps.executeQuery();
		List<Object> list = new ArrayList<Object>();
		while (rs.next()) {
			// System.out.println("client
			// name"+rs.getString(1)+"location"+rs.getString(2)+"description"+rs.getString(3)+"posted
			// date"+rs.getString(4)+"job post id"+rs.getInt(5)+"
			// status"+rs.getInt(6)+"client image"+rs.getString(7)+"client
			// description"+rs.getString(8));
			List list1 = new ArrayList();

			ClientDTO clientdto = new ClientDTO();
			clientdto.setClientName(rs.getString(1));
			clientdto.setClientImage(rs.getString(7));
			clientdto.setClientDescription(rs.getString(8));

			AddressDTO addressdto = new AddressDTO();
			addressdto.setLocation(rs.getString(2));

			JobPostingDTO jobpostdto = new JobPostingDTO();
			jobpostdto.setDescription(rs.getString(3));
			jobpostdto.setPostDate(rs.getDate(4));
			jobpostdto.setJobPostId(rs.getInt(5));

			StatusDTO statusdto = new StatusDTO();
			statusdto.setStatusId(rs.getInt(6));

			CityDTO city = new CityDTO();
			city.setCity(rs.getString(9));

			StateDTO state = new StateDTO();
			state.setState(rs.getString(10));

			TechnologyDTO technology = new TechnologyDTO();
			technology.setTechnology(rs.getString(11));

			list1.add(jobpostdto);
			list1.add(clientdto);
			list1.add(addressdto);
			list1.add(statusdto);
			list1.add(city);
			list1.add(state);
			list1.add(technology);

			list.add(list1);
		}
		return list;
	}

	/**
	 * @author sagar Suryawanshi b 35
	 * @return List of JobPosting Objects
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	@Override
	public List<Object> getjobPostDescription(Integer jobpostid, Connection con) throws SQLException {
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.VIEW_JOB_POST_DESCRIPTION);
		ps.setInt(1, jobpostid);

		ResultSet rs = ps.executeQuery();
		List<Object> list = new ArrayList<Object>();
		while (rs.next()) {
			System.out.println("client name" + rs.getString(1) + "location" + rs.getString(2) + "description"
					+ rs.getString(3) + "posted date" + rs.getString(4) + "status" + rs.getInt(5) + "client image"
					+ rs.getString(6) + "client description" + rs.getString(7));
			List list1 = new ArrayList();

			ClientDTO clientdto = new ClientDTO();
			clientdto.setClientName(rs.getString(1));
			clientdto.setClientImage(rs.getString(6));
			clientdto.setClientDescription(rs.getString(7));

			AddressDTO addressdto = new AddressDTO();
			addressdto.setLocation(rs.getString(2));

			JobPostingDTO jobpostdto = new JobPostingDTO();
			jobpostdto.setDescription(rs.getString(3));
			jobpostdto.setPostDate(rs.getDate(4));

			StatusDTO statusdto = new StatusDTO();
			statusdto.setStatusId(rs.getInt(5));

			CityDTO city = new CityDTO();
			city.setCity(rs.getString(8));

			StateDTO state = new StateDTO();
			state.setState(rs.getString(9));

			TechnologyDTO technology = new TechnologyDTO();
			technology.setTechnology(rs.getString(10));

			list1.add(jobpostdto);
			list1.add(clientdto);
			list1.add(addressdto);
			list1.add(statusdto);
			list1.add(city);
			list1.add(state);
			list1.add(technology);
			System.out.println(list1.size());
			list.add(list1);
		}
		return list;

	}

	/**
	 * @author sagar Suryawanshi b 35
	 * @return List of JobPosting Objects
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	@Override
	public List<Object> findJobPost(FindJobPostingVO jobpostvo, Connection con) throws SQLException {

		Integer company = jobpostvo.getCompanyName();
		System.out.println("in dao impl" + company);
		Integer city = jobpostvo.getCity();
		System.out.println("in dao impl" + city);

		Integer technologys = jobpostvo.getTechnology();
		System.out.println("in dao impl" + technologys);

		PreparedStatement ps = null;

		/*
		 * if(technologys==null){ ps =
		 * con.prepareStatement(SQLQueryConstants.FIND_JOB_POST_BY_COMPANY_CITY)
		 * ; if(company==null){ ps.setString(1,null);} else{
		 * ps.setInt(1,company);}
		 * 
		 * if(city==null){ ps.setString(2,null);} else{ ps.setInt(2,city);}
		 * 
		 * if(technologys==null){ ps.setString(3,null);} else{
		 * ps.setInt(3,technologys);} }
		 */

		/*
		 * if(company==null){ System.out.println(
		 * "if company is null find by city and technology"); ps =
		 * con.prepareStatement(SQLQueryConstants.
		 * FIND_JOB_POST_BY_CITY_TECHNOLOGY); if(company==null){
		 * System.out.println("company is null"); ps.setString(3,null);} else{
		 * ps.setInt(3,company);}
		 * 
		 * if(city==null){ System.out.println("city is null");
		 * ps.setString(1,null);} else{ ps.setInt(1,city);}
		 * 
		 * if(technologys==null){ System.out.println("technologys is null");
		 * ps.setString(2,null);} else{ ps.setInt(2,technologys);} }
		 */
		if (company == null && city == null && technologys == null) {
			System.out.println("all data be display");
			ps = con.prepareStatement(SQLQueryConstants.VIEW_JOB_POST_DETAILS);
		} else if (technologys == null && city == null || city == null && company == null
				|| company == null && technologys == null) {
			ps = con.prepareStatement(SQLQueryConstants.FIND_JOB_POST_BY_TECHNOLOGY);
			if (company == null) {
				ps.setString(1, null);
			} else {
				ps.setInt(1, company);
			}

			if (city == null) {
				ps.setString(2, null);
			} else {
				ps.setInt(2, city);
			}

			if (technologys == null) {
				ps.setString(3, null);
			} else {
				ps.setInt(3, technologys);
			}
		} else if (technologys == null) {
			ps = con.prepareStatement(SQLQueryConstants.FIND_JOB_POST_BY_COMPANY_CITY);
			ps.setInt(1, company);
			ps.setInt(2, city);
		}

		else if (company == null) {
			System.out.println("if company is null find by city and technology");
			ps = con.prepareStatement(SQLQueryConstants.FIND_JOB_POST_BY_CITY_TECHNOLOGY);
			ps.setInt(1, city);
			System.out.println("city in query " + city);
			ps.setInt(2, technologys);
			System.out.println("technologys in query " + technologys);
		} else if (city == null) {
			System.out.println("if city null find by company and technology");
			ps = con.prepareStatement(SQLQueryConstants.FIND_JOB_POST_BY_COMPANY_TECHNOLOGY);
			ps.setInt(1, company);
			ps.setInt(2, technologys);
		}

		else {
			ps = con.prepareStatement(SQLQueryConstants.FIND_JOB_POST);
			ps.setInt(1, company);
			ps.setInt(2, city);
			ps.setInt(3, technologys);
		}

		/*
		 * if(city==null){ System.out.println(
		 * "if city null find by company and technology"); ps =
		 * con.prepareStatement(SQLQueryConstants.
		 * FIND_JOB_POST_BY_COMPANY_TECHNOLOGY); if(company==null){
		 * System.out.println("company is null"); ps.setString(1,null);} else{
		 * ps.setInt(1,company);}
		 * 
		 * if(city==null){ System.out.println("city is null in query");
		 * ps.setString(3,null);} else{ ps.setInt(3,city);}
		 * 
		 * if(technologys==null){ System.out.println(
		 * "technology is null in query"); ps.setString(2,null);} else{
		 * System.out.println(" technology id "+technologys);
		 * ps.setInt(2,technologys);} }
		 * 
		 * else { ps = con.prepareStatement(SQLQueryConstants.FIND_JOB_POST);
		 * if(company==null){ ps.setString(1,null);} else{
		 * ps.setInt(1,company);}
		 * 
		 * if(city==null){ ps.setString(2,null);} else{ ps.setInt(2,city);}
		 * 
		 * if(technologys==null){ ps.setString(3,null);} else{
		 * ps.setInt(3,technologys);} }
		 */

		ResultSet rs = ps.executeQuery();
		List<Object> list = new ArrayList<Object>();
		while (rs.next()) {
			// System.out.println("client
			// name"+rs.getString(1)+"location"+rs.getString(2)+"description"+rs.getString(3)+"posted
			// date"+rs.getString(4)+"status"+rs.getInt(5)+"client
			// image"+rs.getString(6)+"client description"+rs.getString(7));
			List list1 = new ArrayList();

			ClientDTO clientdto = new ClientDTO();
			clientdto.setClientName(rs.getString(1));
			clientdto.setClientImage(rs.getString(7));
			clientdto.setClientDescription(rs.getString(8));

			AddressDTO addressdto = new AddressDTO();
			addressdto.setLocation(rs.getString(2));

			JobPostingDTO jobpostdto = new JobPostingDTO();
			jobpostdto.setDescription(rs.getString(3));
			jobpostdto.setPostDate(rs.getDate(4));
			jobpostdto.setJobPostId(rs.getInt(5));

			StatusDTO statusdto = new StatusDTO();
			statusdto.setStatusId(rs.getInt(6));

			CityDTO citudto = new CityDTO();
			citudto.setCity(rs.getString(9));

			StateDTO state = new StateDTO();
			state.setState(rs.getString(10));

			TechnologyDTO technology = new TechnologyDTO();
			technology.setTechnology(rs.getString(11));
			System.out.println("technology" + rs.getString(11));

			list1.add(jobpostdto);
			list1.add(clientdto);
			list1.add(addressdto);
			list1.add(statusdto);
			list1.add(citudto);
			list1.add(state);
			list1.add(technology);

			list.add(list1);
		}
		return list;
	}

	/*// private static final int Integer jobposting = 0;
	*//**
	 * @author Rajnish
	 * @return boolean if return is false data will not inserted and mail will
	 *         not send Contains JobPostingInsertionFormBean Objects
	 * @throws DatabaseException
	 *             occurs when you are getting problem to connect to database
	 * @throws SQLException
	 *             occurs if no are available
	 *//*

	@Override
	public boolean addJobPosting(Connection con, JobPostingInsertionFormBean fb) throws SQLException {
		// TODO Auto-generated method stub
		boolean message = false;
		String query = "insert into tbl_job_posting(description,expected_date,assesment_start_date,assesment_end_date,posted_date,no_of_vacancies,client_address_id,tbl_technology_technology_id)values (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ps = con.prepareStatement(query);

		ps.setString(1, fb.getDescription());
		ps.setDate(2, fb.getExpectedDate());
		ps.setDate(3, fb.getAssStartDate());
		ps.setDate(4, fb.getAssEndDate());
		ps.setDate(5, fb.getPostDate());
		ps.setInt(6, fb.getVacancies());
		ps.setInt(7, fb.getClientaddressId());
		ps.setInt(8, fb.getTechnologyId());

		System.out.println("AddJobPosting is successfully");

		// Executing the query
		int result = ps.executeUpdate();

		if (result == 0) {
			System.out.println("Data insertion uncessfully please try again");
			message = false;
		} else {
			System.out.println("AddJobPosting is successfully");
			message = true;
		}

		// it will return to the service implemented class

		return message;
	}*/

/*	
	
*/

	/** THIS METHOD RETURN ALLNOTIFICATION 
	 * @author Rajnish
	 * @return List  
	 * @throws DatabaseException
	 * @throws SQLException
	 */

	@Override
	public List<ShowJobDetailsBean> getjobPostingIdNotification(Connection con) throws DatabaseException, SQLException {

		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_JOB_POSTING_NOTIFICATION);
		System.out.println("in dao impl ");
		ResultSet rs = ps.executeQuery();
		
		List<ShowJobDetailsBean> list = new ArrayList<ShowJobDetailsBean>();
		ShowJobDetailsBean detailsBean =null;
		

		

		while (rs.next()) {
			
			detailsBean=new ShowJobDetailsBean();
			detailsBean.setImages(rs.getString(1));
  
			detailsBean.setJobPostId(rs.getInt(3));
			//detailsBean.setCompanyDescription(rs.getString(4));
			detailsBean.setExpectedDate(rs.getDate(5));
			detailsBean.setAssStartDate(rs.getDate(6));
			detailsBean.setAssEndDate(rs.getDate(7));
			detailsBean.setPostDate(rs.getDate(8));
			detailsBean.setVacancies(rs.getInt(9));
			detailsBean.setJobDescription(rs.getString(4));
			
			list.add(detailsBean);
			
			
		}
		
		
		

		return list;
	}

	/**
	 * THIS METHOD RETURN ALL JOB POSTING DETAIL
	 * @author Rajnish
	 * @param java.sql.Connection
	 * @param Integer
	 * @return ShowJobDetailsBean 
	 * @throws SQLException
	 */
	@Override
	public ShowJobDetailsBean getjobPostingIdNotificationDetail(Connection con, Integer jobposting_id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_JOB_POSTING_NOTIFICATIOND_DETAIL);
		ps.setInt(1, jobposting_id);

		ResultSet rs = ps.executeQuery();
		List<ShowJobDetailsBean> list = new ArrayList<ShowJobDetailsBean>();
		ShowJobDetailsBean bean = null;
		while (rs.next()) {
			bean = new ShowJobDetailsBean();

			bean.setExpectedDate(rs.getDate(1));
			bean.setAssStartDate(rs.getDate(2));
			bean.setAssEndDate(rs.getDate(3));

			bean.setClientName(rs.getString(4));
			bean.setLocation(rs.getString(5));
			bean.setCompanyDescription(rs.getString(6));
			bean.setPostDate(rs.getDate(7));
			bean.setVacancies(rs.getInt(8));
			bean.setJobDescription(rs.getString(9));
			bean.setCity(rs.getString(10));

			bean.setState(rs.getString(11));

			bean.setTechnology(rs.getString(12));

			bean.setClientMobNO(rs.getString(13));
			bean.setClientEmail(rs.getString(14));
			bean.setImages(rs.getString(15));
			bean.setJobPostId(jobposting_id);

		}

		return bean;

	}

	/**
	 * This method will gets all company details form data base 
	 * @author Srinivas N B-35
	 * @param date accepts java.sql.Connection object
	 * @return  java.util.List<ClientDTO>
	 * @throws  java.sql.SQLException
	 */
	@Override
	public List<ClientDTO> getClientDetails(Connection con) throws SQLException {

		/*String GET_CLIENT_ALL_DETAILS = "select c.client_id,c.client_name,c.image,c.description,c.company_level_id,l.level " +
				                    "  from tbl_client c,tbl_level l where c.company_level_id=l.level_id  " +
				                    "  ORDER BY c.client_name";
*/
		PreparedStatement preparedStatement = con
				.prepareStatement(SQLQueryConstants.GET_CLIENT_ALL_DETAILS);

		ResultSet rs = preparedStatement.executeQuery();
		ClientDTO clientDTO = null;
		LevelDTO levelDTO = null;
		List<ClientDTO> clientDTOsList = new ArrayList<ClientDTO>();

		// retrieving client information from tbl_client and tbl_level tables
		while (rs.next()) {

			clientDTO = new ClientDTO();
			levelDTO = new LevelDTO();
			clientDTO.setClientId(rs.getInt(1));
			clientDTO.setClientName(rs.getString(2));
			clientDTO.setClientImage(rs.getString(3));
			clientDTO.setClientDescription(rs.getString(4));

			clientDTO.setCompanyLevel(levelDTO);
			clientDTO.getCompanyLevel().setLevelId(rs.getInt(5));

			clientDTO.getCompanyLevel().setLevel(rs.getString(6));

			clientDTOsList.add(clientDTO);

		}
		return clientDTOsList;
	}

	/**
	 * insert new Job posting in to database or adds new record in to tbl_job_posting
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @param data accepts com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean
	 * @return  Boolean
	 * @throws  java.sql.SQLException
	 */
	@Override
	public Boolean addJobPosting(Connection con, JobPostingInsertionFormBean fb)
			throws SQLException {
		

		
		/*String ADD_NEW_JOB_POSTING= "insert into tbl_job_posting(description,expected_date,assesment_start_date,assesment_end_date," +
				                            "posted_date,no_of_vacancies,client_address_id,tbl_technology_technology_id)values (?,?,?,?,?,?,?,?)";
	*/
	
		
		PreparedStatement ps1=con.prepareStatement(SQLQueryConstants.GET_CLIENT_ADDRESS_ID);
		ps1.setInt(1, fb.getAddressId());
		ResultSet rs1=ps1.executeQuery();
		
		Integer clientAddressId=null;
		if(rs1.next()){
			clientAddressId=rs1.getInt(1);
		}
		System.out.println("editJobPosting bean:--"+fb);
	
		
		
		
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.ADD_NEW_JOB_POSTING);

		ps.setString(1, fb.getDescription());
		ps.setDate(2, fb.getExpectedDate());
		ps.setDate(3, fb.getAssStartDate());
		ps.setDate(4, fb.getAssEndDate());
		java.util.Date d = new Date();
        
		java.sql.Date sd = new java.sql.Date(d.getTime());
		ps.setDate(5, sd);
		ps.setInt(6, fb.getVacancies());
		ps.setInt(7, clientAddressId);
		ps.setInt(8, fb.getTechnologyId());

		System.out.println("Dao implemention");

		// Executing the query
		int result = ps.executeUpdate();
        Boolean b=true;
		if (result == 0) {
			System.out.println("value is not inserted");
			b=false;
		} else {
			System.out.println("value is  inserted");
			
		}

		return b;
	}

	/**
	 * retrieving all all technology details 
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @return  java.util.List<TechnologyDTO>
	 * @throws  java.sql.SQLException
	 */
	@Override
	public List<TechnologyDTO> getTechnologyDetail(Connection con)
			throws SQLException {
	

		//final String GET_ALL_TCHNOLOGIES = "select technology_id, technology from tbl_technology";
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_ALL_TCHNOLOGIES);
		ResultSet rs = ps.executeQuery();

		List<TechnologyDTO> technologyDTOsList = new ArrayList<TechnologyDTO>();
		TechnologyDTO technologyDTO = null;
		while (rs.next()) {

			technologyDTO = new TechnologyDTO();
			technologyDTO.setTechnologyId(rs.getInt(1));
			technologyDTO.setTechnology(rs.getString(2));

			technologyDTOsList.add(technologyDTO);
		}

		return technologyDTOsList;
	}

	/**
	 * this method will return particular client address details based on the address id
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @param accepts java.lang.Integer
	 * @return  java.util.List<ClientAddressDetailVo>
	 * @throws  java.sql.SQLException
	 */
	@Override
	public List<ClientAddressDetailVo> getClientAddressDeatail(Connection con,
			Integer clientId) throws SQLException {
		
		/* String GET_CLIENT_DETAILS = "select c.client_name,a.address_id,cl.client_address_id," +
				                        "a.location,a.pincode,cc.city,s.state,cou.country " +
				                        " from tbl_client_address cl,tbl_client c,tbl_city cc," +
				                        "tbl_state s,tbl_country cou,tbl_address a where  " +
				                        "a.city_Id=cc.city_Id and cc.state_id=s.state_id and  " +
				                        "s.country_id=cou.country_id and c.client_id=? and " +
				                        "c.client_id=cl.client_id and cl.address_id=a.address_id";
	*/
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_CLIENT_DETAILS_FOR_JOB_POSTING);
		ps.setInt(1, clientId);

		ResultSet rs = ps.executeQuery();

		List<ClientAddressDetailVo> clientAddressDetailVoList = new ArrayList<ClientAddressDetailVo>();

		ClientAddressDetailVo clientAddressDetailVo2 = null;
		
		while (rs.next()) {
			
			clientAddressDetailVo2 = new ClientAddressDetailVo();
			clientAddressDetailVo2.setClient_name(rs.getString(1));
			clientAddressDetailVo2.setAddress_id(rs.getInt(2));
			clientAddressDetailVo2.setClientAddressId(3);
			clientAddressDetailVo2.setLocation(rs.getString(4));
			clientAddressDetailVo2.setPincode(rs.getString(5));
			clientAddressDetailVo2.setCity(rs.getString(6));
			clientAddressDetailVo2.setState(rs.getString(7));
			clientAddressDetailVo2.setCountry(rs.getString(8));

			clientAddressDetailVoList.add(clientAddressDetailVo2);
		}

		return clientAddressDetailVoList;
	}
	
	/**
	 * Delete  the job posting 
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @param accepts java.lang.Integer
	 * @return  Boolean
	 * @throws  java.sql.SQLException
	 */
//Not required this functionality
	/*@Override
	public Boolean deleteJobPosting(Connection con, Integer jobPostingId)
			throws SQLException {
		// TODO Auto-generated method stub

		final String DELETE_JOB_POSTING = "DELETE FROM tbl_job_posting WHERE  job_posting_id=?";
		PreparedStatement ps = con.prepareStatement(DELETE_JOB_POSTING);
		ps.setInt(1, jobPostingId);
		int result = ps.executeUpdate();
		if (result == 0) {
			System.out.println("Record is not deleted");
			return false;
		} else {
			System.out.println("Record is deleted");
			return true;
		}

	}*/
	/**
	 * based on the address id it will gives the city, State, Country, Pin Code details
	 * @author Srinivas N B-35
	 * @param accepts java.lang.Integer
	 * @param data accepts java.sql.Connection object
	 * @return  com.nacre.online_assesment.vo.GettingLocationCurespondingDetailsvo
	 * @throws  java.sql.SQLException
	 */
	public GettingLocationCurespondingDetailsvo getLocationRelatedAddres(
			Integer addressId, Connection con) throws SQLException {

		/*String GET_lOCATION_RELATED_ADDRESS = "select c.city,s.state,cou.country,a.pincode from tbl_city c,tbl_state s," +
				                              "tbl_country cou,tbl_address a where a.address_id=? and a.city_Id=c.city_Id and " +
				                              " c.state_id=s.state_id and s.country_id=cou.country_id";
*/
		PreparedStatement ps = con
				.prepareStatement(SQLQueryConstants.GET_lOCATION_RELATED_ADDRESS);
		ps.setInt(1, addressId);
		ResultSet rs = ps.executeQuery();

		GettingLocationCurespondingDetailsvo gettingLocationCurespondingDetailsvo = new GettingLocationCurespondingDetailsvo();
		if (rs.next()) {

			gettingLocationCurespondingDetailsvo.setCity(rs.getString(1));
			gettingLocationCurespondingDetailsvo.setState(rs.getString(2));
			gettingLocationCurespondingDetailsvo.setCountry(rs.getString(3));
			gettingLocationCurespondingDetailsvo.setPincode(rs.getString(4));

		}

		return gettingLocationCurespondingDetailsvo;
	}

	/**
	 * This method will gives the all the details related to job posting which are used 
	 * for editing the job posting
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @return  List<GetClientDetailForEditingVo>
	 * @throws  java.sql.SQLException
	 */
	@Override
	public List<GetClientDetailForEditingVo> geClientDetailsForEditing(
			Connection con) throws SQLException {

		String GET_CLIENT_DETAILS_FOR_EDITING = "select  j.job_posting_id,j.description,j.expected_date,"
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
		
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_CLIENT_DETAILS_FOR_EDITING);
		ResultSet rs = ps.executeQuery();

		List<GetClientDetailForEditingVo> getClientDetailForEditingVosList = new ArrayList<GetClientDetailForEditingVo>();
		GetClientDetailForEditingVo getClientDetailForEditingVo = null;
		while (rs.next()) {
			getClientDetailForEditingVo = new GetClientDetailForEditingVo();
			getClientDetailForEditingVo.setJobPostingId(rs.getString(1));
			getClientDetailForEditingVo.setDescripition(rs.getString(2));
			getClientDetailForEditingVo.setExpetedDate(rs.getString(3));
			getClientDetailForEditingVo.setAssessmentStartDate(rs.getString(4));
			getClientDetailForEditingVo.setAssessmentEndDare(rs.getString(5));
			getClientDetailForEditingVo.setPostedDate(rs.getString(6));
			getClientDetailForEditingVo.setNoOfVacancies(rs.getString(7));
			getClientDetailForEditingVo.setLocation(rs.getString(8));
			getClientDetailForEditingVo.setPinCode(rs.getString(9));
			getClientDetailForEditingVo.setCity(rs.getString(10));
			getClientDetailForEditingVo.setState(rs.getString(11));
			getClientDetailForEditingVo.setCountry(rs.getString(12));
			getClientDetailForEditingVo.setTechnology(rs.getString(13));
			getClientDetailForEditingVo.setClientName(rs.getString(14));
			getClientDetailForEditingVo.setImage(rs.getString(15));
			getClientDetailForEditingVo.setClientAddressId(rs.getString(16));
			getClientDetailForEditingVo.setClientTechnologyId(rs.getString(17));
			getClientDetailForEditingVo.setClientId(rs.getString(18));

			// storing in to list
			getClientDetailForEditingVosList.add(getClientDetailForEditingVo);

		}
		return getClientDetailForEditingVosList;
	}
	/**
	 * 
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @return  List<ClientAddressDetailVo>
	 * @throws  java.sql.SQLException
	 */
	@Override
	public List<ClientAddressDetailVo> getCilentAddressForAjax(Connection con)
			throws SQLException {

		/*String GET_ALL_CLIENT_ADDRESESS = "select c.city,s.state,cou.country,a.pincode,a.location,"
				+ "a.address_id from tbl_city c,tbl_state s,tbl_country cou,"
				+ "tbl_address a where  a.city_Id=c.city_Id and c.state_id=s.state_id "
				+ "and s.country_id=cou.country_id";
*/		
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_ALL_CLIENT_ADDRESESS);

		ResultSet rs = ps.executeQuery();
		List<ClientAddressDetailVo> clientAddressDetailVoList = new ArrayList<ClientAddressDetailVo>();

		ClientAddressDetailVo clientAddressDetailVo = null;
		while (rs.next()) {
			clientAddressDetailVo = new ClientAddressDetailVo();
			clientAddressDetailVo.setCity(rs.getString(1));
			clientAddressDetailVo.setState(rs.getString(2));
			clientAddressDetailVo.setCountry(rs.getString(3));
			clientAddressDetailVo.setPincode(rs.getString(4));
			clientAddressDetailVo.setLocation(rs.getString(5));
			clientAddressDetailVo.setAddress_id(6);

			clientAddressDetailVoList.add(clientAddressDetailVo);
		}

		return clientAddressDetailVoList;

	}
	/**
	 * This method will updates job posting details we have addressId only 
	 * by using this Id we are getting clientAddressId 
	 * @author Srinivas N B-35
	 * @param data accepts java.sql.Connection object
	 * @param com.nacre.online_assesment.form_bean.JobPostingInsertionFormBean
	 * @return  Boolean
	 * @throws  java.sql.SQLException
	 */
	@Override
	public Boolean editJobPosting(Connection con,
			JobPostingInsertionFormBean bean) throws SQLException {

		
		String GET_CLIENT_ADDRESS_ID="SELECT CLIENT_ADDRESS_ID FROM tbl_client_address WHERE ADDRESS_ID=?";
		PreparedStatement ps1=con.prepareStatement(SQLQueryConstants.GET_CLIENT_ADDRESS_ID);
		ps1.setInt(1, bean.getAddressId());
		ResultSet rs1=ps1.executeQuery();
		
		Integer clientAddressId=null;
		if(rs1.next()){
			clientAddressId=rs1.getInt(1);
		}
		System.out.println("editJobPosting bean:--"+bean);
		/*String EDIT_JOB_POSTING="UPDATE tbl_job_posting   SET description=?,expected_date=?," +
				                 "assesment_start_date=?,assesment_end_date=?," +
				                 "no_of_vacancies=?,client_address_id=?,tbl_technology_technology_id=?" +
				                 "  WHERE job_posting_id=?";*/
		
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.EDIT_JOB_POSTING);
		//System.out.println("Query--"+EDIT_JOB_POSTING);
		ps.setString(1, bean.getDescription());
		ps.setDate(2, bean.getExpectedDate());
		ps.setDate(3, bean.getAssStartDate());
		ps.setDate(4, bean.getAssEndDate());
		ps.setInt(5, bean.getVacancies());
		
		ps.setInt(6,clientAddressId);
		ps.setInt(7, bean.getTechnologyId());
		ps.setInt(8, bean.getJobPostingId());
		
		int result=ps.executeUpdate();
		if(result==0){
			return false;
		}else{
		return true;
		}
	}
	/**
	 * @author Rajnish 
	 * @param Connection
	 * @return UserDTO
	 * @throws SQLException
	 */

	@Override
	public List<UserDTO> emailAccess(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
			PreparedStatement ps=con.prepareStatement(SQLQueryConstants.GET_HR_ADMIN_EMAIL);
	ps.setInt(1, StringConstants._HR_ROLE_ID);
		ResultSet rs=ps.executeQuery();
		List<UserDTO> list = null;
		UserDTO userDTO=null;
		while(rs.next())
		{
			userDTO = new UserDTO();
			list = new ArrayList<UserDTO>();
			userDTO.setEmail(rs.getString(1));
			list.add(userDTO);
			
		}
		
		return list;
	}

}
