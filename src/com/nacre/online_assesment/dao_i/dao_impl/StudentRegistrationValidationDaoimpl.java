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
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nacre.online_assesment.dao_i.StudentRegistrationValidationDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.CollegeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.dto.UniversityDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.EducationlDetilasBean;
import com.nacre.online_assesment.form_bean.PersonalDetailsBeanSunil;
import com.nacre.online_assesment.form_bean.TechnologyCoursesDetailsBean;
import com.nacre.online_assesment.util.ErrorMessages;
import com.nacre.online_assesment.util.StringConstants;
import com.nacre.online_assesment.vo.StudentCourseDetailsBean;
import com.nacre.online_assesment.vo.StudentEducationDetailsToVerifyBean;
import com.nacre.online_assesment.vo.StudentPersonalDetailsToVerifyBean;


/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StudentRegistrationValidationDaoimpl implements StudentRegistrationValidationDaoi {
	
	
	/** (non-Javadoc)
	 * @author Srikanth and Krunal
	 * @see com.nacre.online_assesment.dao_i.StudentRegistationValidationDaoi.getUnaprovedStudentDetails(Connection con)
	 */
	@Override
	public List getUnaprovedStudentDetails(Connection con) throws DatabaseException {
		// TODO Auto-generated method stub
		
		
		List unaprovedStudentsList = new ArrayList();
		
		
		
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants. GET_UNAPPROVED_STUDENT_DETAILS);
			System.out.println(SQLQueryConstants. GET_UNAPPROVED_STUDENT_DETAILS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				UserDTO userDto = new UserDTO();
				userDto.setUserid(rs.getInt(1));
				userDto.setFirstname(rs.getString(2));
				userDto.setLastname(rs.getString(3));
				userDto.setEmail(rs.getString(4));
				userDto.setMobileNo(rs.getString(5));
				userDto.setImage(rs.getString(6));
				
				unaprovedStudentsList.add(userDto);
			}
			System.out.println(unaprovedStudentsList+">>>>>>>>>>>>>>>>>>>>>>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("Record Is not There plz try again later");
		}
		return unaprovedStudentsList;
	}
	
	/** (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.StudentRegistationValidationDaoi.getStudentDetailsToVerify(Integer,Connection)
	 */
	@Override
	public List getStudentDetailsToVerify(Integer userId , Connection con) throws DatabaseException{
		
		List studentDetailsList = new  ArrayList();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_STUDENT_PERSONAL_DETAILS_TO_VERIFY);
			ps.setObject(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				StudentPersonalDetailsToVerifyBean studentPersonalDetails = new StudentPersonalDetailsToVerifyBean();
				
				studentPersonalDetails.setUserId(rs.getInt(1));
				studentPersonalDetails.setFname(rs.getString(2));
				studentPersonalDetails.setLname(rs.getString(3));
				studentPersonalDetails.setMail(rs.getString(4));
				studentPersonalDetails.setMobileNo(rs.getString(5));
				studentPersonalDetails.setGender(rs.getInt(6));
				studentPersonalDetails.setImage(rs.getString(7));
				
				studentPersonalDetails.setDob(rs.getDate(8));
				studentPersonalDetails.setStatus(rs.getString(9));
				studentPersonalDetails.setLocation(rs.getString(10));
				studentPersonalDetails.setPincode(rs.getString(11));
				studentPersonalDetails.setCity(rs.getString(12));
				studentPersonalDetails.setCity_id(rs.getInt(13));
				studentPersonalDetails.setState(rs.getString(14));
				studentPersonalDetails.setCountry(rs.getString(15));
				studentPersonalDetails.setCountryId(rs.getInt(17));
				studentPersonalDetails.setStateId(rs.getInt(18));
				
				studentDetailsList.add(studentPersonalDetails);
				
			}
			
			List<StudentEducationDetailsToVerifyBean> eduList = new ArrayList<StudentEducationDetailsToVerifyBean>();
			StudentEducationDetailsToVerifyBean sscEduBean = new StudentEducationDetailsToVerifyBean();
			StudentEducationDetailsToVerifyBean interEduBean = new StudentEducationDetailsToVerifyBean();
			StudentEducationDetailsToVerifyBean graduationEduBean = new StudentEducationDetailsToVerifyBean();
			StudentEducationDetailsToVerifyBean PGEduBean = new StudentEducationDetailsToVerifyBean();
			
			PreparedStatement ps2 = con.prepareStatement(SQLQueryConstants.GET_STUDENT_EDUCATION_DETAILS_TO_VERIFY);
			ps2.setObject(1, userId);
			
			ResultSet rs2 = ps2.executeQuery();
			SimpleDateFormat yp = new SimpleDateFormat("yyyy");
			while(rs2.next()){
				
				/*
				StudentEducationDetailsToVerifyBean se= new StudentEducationDetailsToVerifyBean();
				
				se.setEdu_type(rs2.getString(1));
				se.setPercent_grade(rs2.getString(2));
				Date date = rs2.getDate(3);
				String yop = yp.format(date);
				se.setYear_of_pass(yop);
				se.setStream(rs2.getString(4));
				se.setCollege(rs2.getString(5));
				se.setUnivercity(rs2.getString(6));
				se.setLocation(rs2.getString(7));
				se.setPincode(rs2.getString(8));
				se.setCity(rs2.getString(9));
				se.setState(rs2.getString(10));
				se.setCountry(rs2.getString(11));
				se.setCityId(rs2.getInt(12));
				se.setStreamId(rs2.getInt(13));
				se.setUnivercityId(rs2.getInt(14));
				se.setEdu_type_Id(rs2.getInt(15));
				se.setCountryId(rs2.getInt(16));
				se.setStateId(rs2.getInt(17));*/
				
				if(rs2.getString(1).equals(StringConstants.SSC_EDUCATION_TYPE)){
					sscEduBean.setEdu_type(rs2.getString(1));
					sscEduBean.setPercent_grade(rs2.getString(2));
					Date date1 = rs2.getDate(3);
					String yop1 = yp.format(date1);
					sscEduBean.setYear_of_pass(yop1);
					sscEduBean.setEdu_type_Id(rs2.getInt(15));
					
				}
				if(rs2.getString(1).equals(StringConstants.HSC_EDUCATION_TYPE)){
					interEduBean.setEdu_type(rs2.getString(1));
					interEduBean.setPercent_grade(rs2.getString(2));
					Date date2 = rs2.getDate(3);
					String yop2 = yp.format(date2);
					interEduBean.setYear_of_pass(yop2);
					interEduBean.setEdu_type_Id(rs2.getInt(15));
					
				}
				if(rs2.getString(1).equals(StringConstants.GRADUATION_EDUCATION_TYPE)){
					graduationEduBean.setEdu_type(rs2.getString(1));
					graduationEduBean.setPercent_grade(rs2.getString(2));
					Date date3 = rs2.getDate(3);
					String yop3 = yp.format(date3);
					graduationEduBean.setYear_of_pass(yop3);
					graduationEduBean.setStream(rs2.getString(4));
					graduationEduBean.setCollege(rs2.getString(5));
					graduationEduBean.setUnivercity(rs2.getString(6));
					graduationEduBean.setLocation(rs2.getString(7));
					graduationEduBean.setPincode(rs2.getString(8));
					graduationEduBean.setCity(rs2.getString(9));
					graduationEduBean.setState(rs2.getString(10));
					graduationEduBean.setCountry(rs2.getString(11));
					graduationEduBean.setCityId(rs2.getInt(12));
					graduationEduBean.setStreamId(rs2.getInt(13));
					graduationEduBean.setUnivercityId(rs2.getInt(14));
					graduationEduBean.setEdu_type_Id(rs2.getInt(15));
					graduationEduBean.setCountryId(rs2.getInt(16));
					graduationEduBean.setStateId(rs2.getInt(17));
				}
				if(rs2.getString(1).equals(StringConstants.PG_EDUCATION_TYPE)){
					PGEduBean.setEdu_type(rs2.getString(1));
					PGEduBean.setPercent_grade(rs2.getString(2));
					Date date4 = rs2.getDate(3);
					String yop4 = yp.format(date4);
					PGEduBean.setYear_of_pass(yop4);
					PGEduBean.setStream(rs2.getString(4));
					PGEduBean.setCollege(rs2.getString(5));
					PGEduBean.setUnivercity(rs2.getString(6));
					PGEduBean.setLocation(rs2.getString(7));
					PGEduBean.setPincode(rs2.getString(8));
					PGEduBean.setCity(rs2.getString(9));
					PGEduBean.setState(rs2.getString(10));
					PGEduBean.setCountry(rs2.getString(11));
					PGEduBean.setCityId(rs2.getInt(12));
					PGEduBean.setStreamId(rs2.getInt(13));
					PGEduBean.setUnivercityId(rs2.getInt(14));
					PGEduBean.setEdu_type_Id(rs2.getInt(15));
					PGEduBean.setCountryId(rs2.getInt(16));
					PGEduBean.setStateId(rs2.getInt(17));
				}
				
			//eduList.add(se);
					
			}
			
			
			eduList.add(sscEduBean);
			eduList.add(interEduBean);
			eduList.add(graduationEduBean);
			if(PGEduBean.getEdu_type()!=null){
				eduList.add(PGEduBean);
			}
			studentDetailsList.add(eduList);
			
			System.out.println(">>>>"+eduList);
						
			PreparedStatement coursePS = con.prepareStatement(SQLQueryConstants.GET_STUDENT_COURSES_TO_VERIFY);
			coursePS.setObject(1, userId);
			ResultSet courseRS = coursePS.executeQuery();
			List<StudentCourseDetailsBean> courseList = new ArrayList<StudentCourseDetailsBean>();
			while(courseRS.next()){
				StudentCourseDetailsBean bean = new StudentCourseDetailsBean();
				
				bean.setCourse(courseRS.getString(1));
				bean.setTechnology(courseRS.getString(2));
				bean.setTechnologyId(courseRS.getInt(3));
				
				courseList.add(bean);
				
				
			}
			
			
			
			studentDetailsList.add(courseList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("Record Is not Found in DataBase plz try again later");
			
		}
		
		System.out.println(">>>>>>DAOI REG"+studentDetailsList);
		return studentDetailsList;
		
	}

	
	/** (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.StudentRegistationValidationDaoi.getEduStreams(Connection)
	 */
	@Override
	public List getEduStreams(Connection con) throws DatabaseException {
		// TODO Auto-generated method stub
		
		List stremList = new ArrayList();
		Statement st;
		try {
			st = con.createStatement();
			 ResultSet rs = st.executeQuery(SQLQueryConstants.GET_ALL_STREAMS);
			 while(rs.next()){
				 StreamDTO dto = new StreamDTO();
				 
				 dto.setStreamId(rs.getInt(1));
				 dto.setStream(rs.getString(2));
				 
				 stremList.add(dto);
				 	 
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("Record Is not Found in DataBase plz try again later");
		}
		return stremList;
	}

	
	
	
	/** (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.StudentRegistationValidationDaoi.updateStudentPersonalDetails(StudentPersonalDetailsToVerifyBean Connection con)
	 */
	@Override
	public void updateStudentPersonalDetails(StudentPersonalDetailsToVerifyBean bean,
			Connection con) throws DatabaseException {
		// TODO Auto-generated method stub
		System.out.println("In Dao");
		
	
		Integer adressId = null;
		
		try {
			

			PreparedStatement getAdresPS = con.prepareStatement(SQLQueryConstants.GET_ALL_ADDRESSES);
			getAdresPS.setObject(1,bean.getLocation());
			getAdresPS.setObject(2, bean.getPincode());
			getAdresPS.setObject(3,bean.getCity_id());
			ResultSet adresResult = getAdresPS.executeQuery();
			
			if(adresResult.next()){
									
					adressId=adresResult.getInt(1);
				
			}
			
			if(adressId==null){
				
				PreparedStatement adresInsertPS = con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_NEW_ADDRESS,Statement.RETURN_GENERATED_KEYS);
				adresInsertPS.setObject(1, bean.getLocation());
				adresInsertPS.setObject(2,bean.getPincode());
				adresInsertPS.setObject(3, bean.getCity_id());
				adresInsertPS.executeUpdate();
				ResultSet rsg = adresInsertPS.getGeneratedKeys();
				System.out.println(rsg);
				if(rsg.next()){
				adressId = rsg.getInt(1);
				System.out.println(adressId);
				}
			}

			
			
			
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.UPDATE_STUDENT_PERSONAL_DETAILS);
			
			ps.setObject(1, bean.getFname());
			ps.setObject(2, bean.getLname());
			ps.setObject(3, bean.getMail());
			ps.setObject(4, bean.getMobileNo());
			ps.setObject(5, bean.getGender());
			ps.setObject(6, bean.getImage());
			ps.setObject(7, bean.getDob());
			ps.setObject(8, adressId);
			ps.setObject(9, bean.getMobileNo());
			ps.setObject(10, bean.getUserId());
		
			int count =	ps.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new DatabaseException("Record Is not Found in DataBase plz try again later");
		}
		
	}

	/** (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.StudentRegistationValidationDaoi.updateStudentEducDetails(List,Connection,Boolean)
	 */
	@Override
	public void updateStudentEducDetails(List<StudentEducationDetailsToVerifyBean> eduList, Connection con,Boolean isNewPg) throws DatabaseException {
		// TODO Auto-generated method stub
		System.out.println("In Dao");
		
		
		try{
		for(Object o :eduList){
			Integer collegeID=null;
			Integer addressId = null;
			
			StudentEducationDetailsToVerifyBean bean = (StudentEducationDetailsToVerifyBean) o;
			
			
			if(bean.getEdu_type().equals(StringConstants.HSC_EDUCATION_TYPE)||bean.getEdu_type().equals(StringConstants.SSC_EDUCATION_TYPE)){
				
				PreparedStatement ps = con.prepareStatement( SQLQueryConstants.UPDATE_STUDENT_SSC_HSC_DETAILS);
				ps.setObject(1, bean.getPercent_grade());
				ps.setObject(2, bean.getYear_of_pass());
				ps.setObject(3, bean.getUserId());
				ps.setObject(4, bean.getEdu_type_Id());
				
				System.out.println(bean.getEdu_type());
				System.out.println(bean.getEdu_type_Id());
				
				ps.executeUpdate();
				
			}
			
			else{
				
				PreparedStatement getColPS = con.prepareStatement(SQLQueryConstants.GET_ALL_COLLEGES_DETAILS);
				getColPS.setObject(1,bean.getCollege());
				getColPS.setObject(2, bean.getUnivercityId());
				ResultSet colRS = getColPS.executeQuery();
				if(colRS.next()){
					
							collegeID=colRS.getInt(1);
					
				}//if end
				if(collegeID==null){
					//insert new college
					PreparedStatement insertCOlPS = con.prepareStatement(SQLQueryConstants.INSERT_NEW_COLLEGE_DETAILS,Statement.RETURN_GENERATED_KEYS);
					insertCOlPS.setObject(1, bean.getCollege());
					insertCOlPS.setObject(2, bean.getUnivercityId());
					
					insertCOlPS.executeUpdate();
					ResultSet rsg = insertCOlPS.getGeneratedKeys();
					System.out.println(rsg);
					if(rsg.next()){
						
					collegeID = rsg.getInt(1);
					
					}
					
					
				}// if(inside elseblock) block end
				
				//Address Details updation
				
				PreparedStatement getAdresPS = con.prepareStatement(SQLQueryConstants.GET_ALL_ADDRESSES);
				getAdresPS.setObject(1,bean.getLocation());
				getAdresPS.setObject(2, bean.getPincode());
				getAdresPS.setObject(3,bean.getCityId());
				ResultSet adresResult = getAdresPS.executeQuery();
				
				if(adresResult.next()){
						
						addressId=adresResult.getInt(1);
					
				}
				
				if(addressId==null){
					
					PreparedStatement adresInsertPS = con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_NEW_ADDRESS,Statement.RETURN_GENERATED_KEYS);
					adresInsertPS.setObject(1, bean.getLocation());
					adresInsertPS.setObject(2, bean.getPincode());
					adresInsertPS.setObject(3, bean.getCityId());
					adresInsertPS.executeUpdate();
					ResultSet rsg = adresInsertPS.getGeneratedKeys();
					System.out.println(rsg);
					if(rsg.next()){
						addressId = rsg.getInt(1);
					System.out.println(addressId);
					}
				}
				
				
				
				//code to update all education details
			
				if(bean.getEdu_type_Id()==StringConstants.GRADUATION_EDUCATION_TYPE_ID){
				PreparedStatement insertEduPs = con.prepareStatement(SQLQueryConstants.UPDATE_STUDENT_GRADUATION_PG_EDUCATION_DETAILS);
				
				insertEduPs.setObject(1, bean.getPercent_grade());
				insertEduPs.setObject(2, bean.getYear_of_pass());
				insertEduPs.setObject(3, bean.getStreamId());
				insertEduPs.setObject(4, collegeID);
				insertEduPs.setObject(5, addressId);
				insertEduPs.setObject(6, bean.getUserId());
				insertEduPs.setObject(7, bean.getEdu_type_Id());
				
				
				insertEduPs.executeUpdate();
				}
				else if(bean.getEdu_type_Id()==StringConstants.PG_EDUCATION_TYPE_ID){
					
					//coming  pg details are new or old 
					//if pg details are new, newly entered details  are inserted
					if(isNewPg){

						PreparedStatement insertPgPS = con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_PG_EDUCATION_DETAILS);
						
						insertPgPS.setObject(1, bean.getPercent_grade());
						insertPgPS.setObject(2, bean.getYear_of_pass());
						insertPgPS.setObject(3, bean.getStreamId());
						insertPgPS.setObject(4, collegeID);
						insertPgPS.setObject(5, addressId);
						insertPgPS.setObject(6, bean.getEdu_type_Id());
						insertPgPS.setObject(7, bean.getUserId());
						
						insertPgPS.executeUpdate();
						
					}
					// if coming pg details are old pg details will update
					else{
						PreparedStatement insertEduPs = con.prepareStatement(SQLQueryConstants.UPDATE_STUDENT_GRADUATION_PG_EDUCATION_DETAILS);
						
						insertEduPs.setObject(1, bean.getPercent_grade());
						insertEduPs.setObject(2, bean.getYear_of_pass());
						insertEduPs.setObject(3, bean.getStreamId());
						insertEduPs.setObject(4, collegeID);
						insertEduPs.setObject(5, addressId);
						insertEduPs.setObject(6, bean.getUserId());
						insertEduPs.setObject(7, bean.getEdu_type_Id());
						
						
						insertEduPs.executeUpdate();
						
					}
					//insert new pg details
				}		
				
				
				
				
			}//outer else block end
		}//for loop end
		
		}catch(SQLException e){
		
			throw new DatabaseException("Record Is not Found in DataBase plz try again later");
		}
		
	}

	
	/** (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.StudentRegistationValidationDaoi.getUnivercityes(Connection)
	 */
	@Override
	public List<UniversityDTO> getUnivercityes(Connection con) throws DatabaseException {
		// TODO Auto-generated method stub
		
		List<UniversityDTO> univList = new ArrayList<UniversityDTO>();
		try {
			Statement univStmt = con.createStatement();
			
		 ResultSet univRS = univStmt.executeQuery(SQLQueryConstants.GET_ALL_UNIVERSITYES);
		 while(univRS.next()){
			 UniversityDTO univercity = new UniversityDTO();
			 univercity.setUniv_Id(univRS.getInt(1));
			 univercity.setUnivercity(univRS.getString(2));
			 
			 univList.add(univercity);
		 }
		 
		} catch (SQLException e) {
			throw new DatabaseException("Record Is not Found in DataBase plz try again later");
		}
		
		return univList;
	}
	
	
	/** (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.StudentRegistationValidationDaoi.getCourses(Connection)
	 */
	@Override
	public List<CourseDTO> getCourses(Integer techId, Connection con) throws DatabaseException {
		// TODO Auto-generated method stub
		List<CourseDTO> courseList = new ArrayList<>();
		
		try {
			PreparedStatement coursePs = con.prepareStatement(SQLQueryConstants.GET_COURSES_ON_TECHNOLOGY);
			coursePs.setObject(1, techId);
			ResultSet rs = coursePs.executeQuery();
			while(rs.next()){
				CourseDTO dto = new CourseDTO();
				dto.setCourseId(rs.getInt(1));
				dto.setCourse(rs.getString(2));
				courseList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseException("Record Is not Found in DataBase plz try again later");
		}
		
		return courseList;
	}
	
	
	/** (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.StudentRegistationValidationDaoi.updateCourses(List,Connection,Integer)
	 */
	@Override
	public Integer updateCourses(List list, Connection con,Integer userId) throws DatabaseException {
		// TODO Auto-generated method stub
		Integer count=null;
		
			try {
				
				PreparedStatement deleteCoursePs= con.prepareStatement(SQLQueryConstants.DELETE_COURSES);
				deleteCoursePs.setObject(1, userId);
				deleteCoursePs.executeUpdate();
		
		
		for(Object o : list){
			CourseDTO dto = (CourseDTO) o;
			Integer courseId =null;
			
				PreparedStatement getCIdPS = con.prepareStatement(SQLQueryConstants.GET_COURSE_ID);
				getCIdPS.setObject(1,dto.getCourse());
				ResultSet getCidRS = getCIdPS.executeQuery();
				if(getCidRS.next()){
					courseId=getCidRS.getInt(1);
				}
				PreparedStatement insertCoursePs = con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_COURSES);
				insertCoursePs.setObject(1,courseId);
				insertCoursePs.setObject(2,userId);
				
				 count = insertCoursePs.executeUpdate();
				
				
				
			} 
		
		
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Record Is not Found in DataBase plz try again later");
		}
			
			return count;
		
	}
	
	@Override
	public void changeStudenStatusId(Integer userId,Connection con) {
		// TODO Auto-generated method stub
		
		PreparedStatement changeStatusPS;
		try {
			System.out.println(SQLQueryConstants.UPDATE_STUDENT_STATUS);
			
			System.out.println("connection "+con);
			changeStatusPS = con.prepareStatement(SQLQueryConstants.UPDATE_STUDENT_STATUS);
			changeStatusPS.setObject(1, userId);
			changeStatusPS.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println("effected "+count);
		
	}



	


	@Override
	public List<UniversityDTO> getUniversities(Connection con)
			throws DatabaseException {
		// TODO Auto-generated method stub
		try {
			
						List<UniversityDTO> list=new ArrayList<UniversityDTO>();
			
			PreparedStatement ps=con.prepareStatement(SQLQueryConstants.GET_UNIVERITIES);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UniversityDTO udto =new UniversityDTO();

				int uid=rs.getInt(1);
				String univ=rs.getString(2);
				udto.setUniversityId(uid);
				udto.setUniversityName(univ);
				list.add(udto);
				
			  }
			//System.out.println(list);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException();
		}
		
	}

	@Override
	public List<CollegeDTO> getColleges(Integer countryId, Connection con)
			throws DatabaseException {
		try {
			
			List<CollegeDTO> collegeList=new ArrayList<CollegeDTO>();

          PreparedStatement ps=con.prepareStatement(SQLQueryConstants.GET_COLLEGES);
           
          Integer id=countryId;
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
               while(rs.next()){
	              
            	   CollegeDTO collegedto =new CollegeDTO();
	               int collegeId=rs.getInt(1);
	               String collegeName=rs.getString(2);
	               collegedto.setCollegeId(collegeId);
	               collegedto.setCollege(collegeName);
	               
	               collegeList.add(collegedto);
                }
               return collegeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException();
		}
		
}
	
	
	/**
	 * @author SUNIL
	 */

	@Override
	public List<UniversityDTO> getUniversityList(Connection con) throws DataNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_UNIVERSITIES);
			
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		
		
		if(isRecordsAvailable){
			List<UniversityDTO> universityDTOs = new ArrayList<UniversityDTO>(); 
			
			while (isRecordsAvailable) {
				
				UniversityDTO universityDTO=new UniversityDTO();
				universityDTO.setUniversityId(rs.getInt(1));
				universityDTO.setUniversityName(rs.getString(2));
				
				isRecordsAvailable= rs.next();
				universityDTOs.add(universityDTO);
				
			}
			
			

			return universityDTOs;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_COUNTRIES_NOT_FOUND);
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
		
	}

	@Override
	public List<CollegeDTO> getCollegeList(Integer universityId,Connection con) throws DataNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_COLLEGES);
			ps.setInt(1,universityId);
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		
		
		if(isRecordsAvailable){
			List<CollegeDTO> collegeDTOs = new ArrayList<CollegeDTO>(); 
			
			while (isRecordsAvailable) {
				
				CollegeDTO collegeDTO=new CollegeDTO();
				collegeDTO.setCollegeId(rs.getInt(1));
				collegeDTO.setCollege(rs.getString(2));
				
				isRecordsAvailable= rs.next();
				collegeDTOs.add(collegeDTO);
				
			}
			
			

			return collegeDTOs;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_COUNTRIES_NOT_FOUND);
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
	}

	@Override
	public List<StreamDTO> getStreamList(Connection con) throws DataNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_STREAMS);
			
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		
		
		if(isRecordsAvailable){
			List<StreamDTO> streamDTOs = new ArrayList<StreamDTO>(); 
			
			while (isRecordsAvailable) {
				
				StreamDTO streamDTO=new StreamDTO();
				streamDTO.setStreamId(rs.getInt(1));
				streamDTO.setStream(rs.getString(2));
				
				isRecordsAvailable= rs.next();
				streamDTOs.add(streamDTO);
				
			}
			
			

			return streamDTOs;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_COUNTRIES_NOT_FOUND);
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}	
	}

	@Override
	public int getUserId(String email, Connection con) throws DatabaseException, DataNotFoundException {
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_STUDENT_USE_ID);
			ps.setString(1,email);
			
		ResultSet rs = 	ps.executeQuery();
		
		Boolean isRecordsAvailable = rs.next();
		if(isRecordsAvailable){
		
		return 1;
		}
else{
			
			return 0;
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
			
		
	}
	/**
	 * @author sunil kumar maharana
	 * this method is used for getting addrssID by taking input as Location,pincode,cityId
	 * @param con
	 * @param location
	 * @param pin
	 * @param cityId
	 * @return int 
	 * @throws DatabaseException
	 */

	public int getAddressId(Connection con,String location,Integer pin,Integer cityId) throws DatabaseException{
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.GET_STUDENT_ADDRESS_ID);
			pstmt.setString(1,location);
			pstmt.setInt(2,pin);
			pstmt.setInt(3,cityId);
			ResultSet rs1=pstmt.executeQuery();
			Boolean isRecordsAvailable = rs1.next();
			if(isRecordsAvailable==true){
			
				return rs1.getInt(1);
			}else{
				
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
		
	}
	/**
	 * this method is used for inserting address into address table
	 * @param con
	 * @param location
	 * @param pin
	 * @param cityId
	 * @return int insertAddressSucess status
	 * @throws DatabaseException
	 * @throws DataNotFoundException 
	 */
	public int insertAddress(Connection con,String location,Integer pin,Integer cityId)throws  DataNotFoundException, DatabaseException{
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_ADDRESS,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,location);
			pstmt.setInt(2,pin);
			pstmt.setInt(3,cityId);
			pstmt.executeUpdate();
		
		ResultSet rs =	pstmt.getGeneratedKeys();
		if(rs.next()){
	return rs.getInt(1);
			
		}else{
			 throw new DataNotFoundException(ErrorMessages._ERR_COUNTRIES_NOT_FOUND);
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
		
		
	}
	/**
	 * @author sunilkumar maharana
	 * @param Connection
	 * @param universityName
	 * @return int value
	 * This method is used for getting universityId by taking input as University name
	 * @throws DatabaseException
	 */
	public int getUniversityId(Connection con,String UniversityName)throws DatabaseException{
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.GET_UNIVERSITY_ID);
			pstmt.setString(1,UniversityName);
			ResultSet rs=pstmt.executeQuery();
			boolean isRecordsAvailable=rs.next();
			if(isRecordsAvailable==true){
				return rs.getInt(1);
			}
			else{
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
		
		
	}
	/**
	 * @author sunilkumar maharana
	 * @param Connection
	 * @param universityName
	 * @return int (universityId)
	 * This method is used for inserting  university into university table  by taking input as University name
	 * @throws DatabaseException
	 */
	public int insertUniversity(Connection con,String universityName)throws DatabaseException,DataNotFoundException{
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.INSERT_UNIVERSITY,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, universityName);
			pstmt.executeUpdate();
			ResultSet rs=pstmt.getGeneratedKeys();
			if(rs.next()){
				return rs.getInt(1);
			}
			else{
			 throw new DataNotFoundException(ErrorMessages._ERR_COUNTRIES_NOT_FOUND);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
		
		
	}
	/**
	 * 
	 * @param con
	 * @param CollegeName
	 * @param universityId
	 * @return int value(collegeId)
	 * @throws DatabaseException
	 */
	public int getCollegeId(Connection con,String CollegeName,int universityId) throws DatabaseException{
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.GET_COLLEGE_ID_SUNIL);
			pstmt.setString(1,CollegeName);
			pstmt.setInt(2,universityId);
			ResultSet rs=pstmt.executeQuery();
			boolean isRecordsAvailable=rs.next();
			if(isRecordsAvailable==true){
				return rs.getInt(1);
			}
			else{
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
	
		
	}
	/**
	 * 
	 * @param con
	 * @param CollegeName
	 * @param universityId
	 * @return int value (collegeId)
	 * @throws DatabaseException
	 * @throws DataNotFoundException
	 */
	public int insertCollege(Connection con,String CollegeName,int universityId)throws DatabaseException,DataNotFoundException{
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants.INSERT_COLLEGE,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, CollegeName);
			pstmt.setInt(2,universityId);
			pstmt.executeUpdate();
			ResultSet rs=pstmt.getGeneratedKeys();
			if(rs.next()){
				return rs.getInt(1);
			}
			else{
			 throw new DataNotFoundException(ErrorMessages._ERR_COUNTRIES_NOT_FOUND);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}	
		
	}
	@Override
	public int studentRegistration(Map studentRegistrationMap, Connection con) throws DatabaseException{
		boolean transactionStatus=false;
		int transactionStatusValue=0;
		List<EducationlDetilasBean> educationalDetailsList=new ArrayList<EducationlDetilasBean>();
		PersonalDetailsBeanSunil PersonalDetailsBeanSunil=(PersonalDetailsBeanSunil) studentRegistrationMap.get("personalDetailsBean");
		EducationlDetilasBean  sccDetailsBean=(EducationlDetilasBean) studentRegistrationMap.get("sccDetailsBean");
		EducationlDetilasBean intermediateDetailsBean=(EducationlDetilasBean) studentRegistrationMap.get("intermediateDetailsBean");
		EducationlDetilasBean graduationDetailsBean=(EducationlDetilasBean)studentRegistrationMap.get("graduationDetailsBean");
		TechnologyCoursesDetailsBean  technologyCoursesDetailsBean=(TechnologyCoursesDetailsBean)studentRegistrationMap.get("technologyCoursesDetailsBean");
		EducationlDetilasBean postGraduationDetailsBean =null;
		boolean postGraduationDetailsStatus=false;
		if(studentRegistrationMap.containsKey("postGraduationDetailsBean")==true){
			postGraduationDetailsBean=(EducationlDetilasBean) studentRegistrationMap.get("postGraduationDetailsBean");
			postGraduationDetailsStatus=true;
		}

		System.out.println("DAOPD>>>"+postGraduationDetailsBean);
		System.out.println("DAO:SSC>>>"+sccDetailsBean);
		System.out.println("DAO:HSC>>>"+intermediateDetailsBean);
		System.out.println("DAO:GRAD>>>"+graduationDetailsBean);
		System.out.println("DAO:PG>>>"+PersonalDetailsBeanSunil);
		System.out.println("DAO:COURSES>>>");
		
		//check whether addressId is exit or not ,if exit get it from database ,if not exit insert address into database and then get addessId from databse
		int addressId;

		 addressId=getAddressId(con,PersonalDetailsBeanSunil.getLocation(),PersonalDetailsBeanSunil.getPin(),PersonalDetailsBeanSunil.getCity()); 
		if(addressId==0){
			
			try {
				addressId = insertAddress(con,PersonalDetailsBeanSunil.getLocation(),PersonalDetailsBeanSunil.getPin(),PersonalDetailsBeanSunil.getCity());
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		int userId=0;
		PreparedStatement pstmt=null;
		try {
	      
			pstmt=con.prepareStatement(SQLQueryConstants.INSERT_STUDENT,PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1,PersonalDetailsBeanSunil.getFirstname() );
			pstmt.setString(2,PersonalDetailsBeanSunil.getLastname());
			pstmt.setString(3,PersonalDetailsBeanSunil.getEmail());
			pstmt.setString(4,PersonalDetailsBeanSunil.getPassword());
			pstmt.setString(5,PersonalDetailsBeanSunil.getMobileNo());
			pstmt.setInt(6,PersonalDetailsBeanSunil.getGender());
			pstmt.setString(7,PersonalDetailsBeanSunil.getImage());
			pstmt.setDate(8,PersonalDetailsBeanSunil.getDob());
			pstmt.setInt(9,StringConstants._STUDENT_ROLE_ID);
			pstmt.setInt(10,addressId);
			pstmt.setInt(11,StringConstants._IN_ACTIVE_STATUS_ID);
			pstmt.setInt(12,technologyCoursesDetailsBean.getTechnologyId());
			pstmt.executeUpdate();
			ResultSet rs =	pstmt.getGeneratedKeys();
			if(rs.next()){
				 userId=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
		
		//to store graduation details
		int graduationUniversityId;
		int graduationCollegeId;
		int graduationCollegeAddressId;
		if(null==graduationDetailsBean.getUnivetsityId()){
			String graduationUniversity=graduationDetailsBean.getAddUniversityName();
			String graduationCollege=graduationDetailsBean.getAddCollegeName();
			graduationUniversityId=getUniversityId(con,graduationUniversity );
			if(graduationUniversityId==0){
				try {
					graduationUniversityId=insertUniversity(con,graduationUniversity);
				} catch (DataNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//for graduation college 
			graduationCollegeId=getCollegeId(con,graduationCollege ,graduationUniversityId);
			if(graduationCollegeId==0){
				try {
					graduationCollegeId=insertCollege(con,graduationCollege,graduationUniversityId);
				} catch (DataNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		else if(null!=graduationDetailsBean.getUnivetsityId() && null==graduationDetailsBean.getCollegeId()){
			graduationUniversityId=graduationDetailsBean.getUnivetsityId();
			String graduationCollege=graduationDetailsBean.getAddCollegeName();
			graduationCollegeId=getCollegeId(con,graduationCollege ,graduationUniversityId);
			if(graduationCollegeId==0){
				try {
					graduationCollegeId=insertCollege(con,graduationCollege,graduationUniversityId);
				} catch (DataNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		else{
		 graduationCollegeId=graduationDetailsBean.getCollegeId();
		}
		//for graduation college address
		graduationCollegeAddressId=getAddressId(con,graduationDetailsBean.getLocation(),graduationDetailsBean.getPin(),graduationDetailsBean.getCityId());
		 
		if(graduationCollegeAddressId==0){
			
			try {
				graduationCollegeAddressId = insertAddress(con,graduationDetailsBean.getLocation(),graduationDetailsBean.getPin(),graduationDetailsBean.getCityId());
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		graduationDetailsBean.setCollegeId(graduationCollegeId);
		System.out.println("GRAD addrId: "+graduationCollegeAddressId);
		graduationDetailsBean.setAddressId(graduationCollegeAddressId);
		educationalDetailsList.add(graduationDetailsBean);
		//post graduation details
		int pgCollegeId;
		int pgCollegeAddressId;
		if(postGraduationDetailsStatus==true){
			int pgUniversityId;
			
			if(null==postGraduationDetailsBean.getUnivetsityId()){
				String pgUniversity=postGraduationDetailsBean.getAddUniversityName();
				String pgCollege=postGraduationDetailsBean.getAddCollegeName();
				pgUniversityId=getUniversityId(con,pgUniversity );
				if(pgUniversityId==0){
					try {
					pgUniversityId=insertUniversity(con,pgUniversity);
					} catch (DataNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//for post graduation college 
				pgCollegeId=getCollegeId(con,pgCollege ,pgUniversityId);
				if(pgCollegeId==0){
					try {
						pgCollegeId=insertCollege(con,pgCollege,pgUniversityId);
					} catch (DataNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
			else if(null!=postGraduationDetailsBean.getUnivetsityId()&& null==postGraduationDetailsBean.getCollegeId()){
				pgUniversityId=postGraduationDetailsBean.getUnivetsityId();
				String pgCollege=postGraduationDetailsBean.getAddCollegeName();
				pgCollegeId=getCollegeId(con,pgCollege ,pgUniversityId);
				if(pgCollegeId==0){
					try {
						pgCollegeId=insertCollege(con,pgCollege,pgUniversityId);
					} catch (DataNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
			else{
			 pgCollegeId=postGraduationDetailsBean.getCollegeId();
			}
			//post graduation address 
			pgCollegeAddressId=getAddressId(con,postGraduationDetailsBean.getLocation(),postGraduationDetailsBean.getPin(),postGraduationDetailsBean.getCityId());
			 
			if(graduationCollegeAddressId==0){
				
				try {
					pgCollegeAddressId = insertAddress(con,postGraduationDetailsBean.getLocation(),postGraduationDetailsBean.getPin(),postGraduationDetailsBean.getCityId());
				} catch (DataNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			postGraduationDetailsBean.setCollegeId(pgCollegeId);
			postGraduationDetailsBean.setAddressId(pgCollegeAddressId);
			System.out.println("Postgrad ADDRID"+pgCollegeAddressId);
			educationalDetailsList.add(postGraduationDetailsBean);
		}
		PreparedStatement pstmt1=null;
		
			try {
				pstmt1=con.prepareStatement(SQLQueryConstants.INSERT_SSC_INTER_EDUCATIONAL_DETAILS);
				pstmt1.setString(1,sccDetailsBean.getPercentage());
				pstmt1.setInt(2,sccDetailsBean.getYearOfPass());
				pstmt1.setInt(3,sccDetailsBean.getEducationType());
				pstmt1.setInt(4,userId);
				pstmt1.addBatch();
				pstmt1.setString(1,intermediateDetailsBean.getPercentage());
				pstmt1.setInt(2,intermediateDetailsBean.getYearOfPass());
				pstmt1.setInt(3,intermediateDetailsBean.getEducationType());
				pstmt1.setInt(4,userId);
				pstmt1.addBatch();
				pstmt1.executeBatch();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("listRecotds>>"+educationalDetailsList);
		PreparedStatement pstmt2=null;
		try {
			pstmt2=con.prepareStatement(SQLQueryConstants.INSERT_EDUCATIONAL_DETAILS);
			for(EducationlDetilasBean educationlDetilasBean:educationalDetailsList){
				pstmt2.setString(1,educationlDetilasBean.getPercentage());
				pstmt2.setInt(2,educationlDetilasBean.getYearOfPass());
				pstmt2.setInt(3,educationlDetilasBean.getStreamId());
				pstmt2.setInt(4,educationlDetilasBean.getCollegeId());
				pstmt2.setInt(5,educationlDetilasBean.getEducationType());
				pstmt2.setInt(6,educationlDetilasBean.getAddressId());
				pstmt2.setInt(7,userId);
				//pstmt2.addBatch();
				pstmt2.executeUpdate();
				
			}
			//pstmt2.executeBatch();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//add courses into  student
				List<Integer> coursesId=technologyCoursesDetailsBean.getCoursesIdList();
				System.out.println(coursesId);
				PreparedStatement pstmt3=null;
				try {
					pstmt3=con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_COURSES);
					for(Integer i:coursesId){
						pstmt3.setInt(1,i);
						pstmt3.setInt(2,userId);
						pstmt3.addBatch();
					}
					pstmt3.executeBatch();
					transactionStatus=true;
					if(transactionStatus==true){
						con.commit();	
						transactionStatusValue=1;
					}
					else{
						con.rollback();
						transactionStatusValue=0;
					}
				      
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
		return transactionStatusValue;
		
	}

	
	
}
