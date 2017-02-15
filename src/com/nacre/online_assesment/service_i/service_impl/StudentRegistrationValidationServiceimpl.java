/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.online_assesment.dao_i.StudentRegistrationValidationDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.StudentRegistrationValidationDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.CollegeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.dto.UniversityDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei;
import com.nacre.online_assesment.util.EmailUtilty;
import com.nacre.online_assesment.vo.StudentPersonalDetailsToVerifyBean;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class StudentRegistrationValidationServiceimpl implements StudentRegistrationValidationServicei {
	
	
	StudentRegistrationValidationDaoi studentregistrationdao = new StudentRegistrationValidationDaoimpl();
	
	
	/** (non-Javadoc)
	 * @throws DatabaseException 
	 * @authors Srikanth and Krunal  B35
	 * @see com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei.getUnaprovedStudentDetails()
	 */
	@Override
	public List getUnaprovedStudentDetails() throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = null;
		
			con = DbUtil.getConnection();
		
		
		return studentregistrationdao.getUnaprovedStudentDetails(con);
		 
	}

	
	/** (non-Javadoc)
	 * @throws DatabaseException 
	 * @see com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei.getStudentDetailsToVerify(Integer)
	 */
	@Override
	public List getStudentDetailsToVerify(Integer userId) throws DatabaseException {
		
		// TODO Auto-generated method stub
		Connection con = null;
		
			con = DbUtil.getConnection();
		
		return studentregistrationdao.getStudentDetailsToVerify(userId, con);
	}

	
	/** (non-Javadoc)
	 * @throws DatabaseException 
	 * @see com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei.getStreams()
	 */
	@Override
	public List getEduStreams() throws DatabaseException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		
			con = DbUtil.getConnection();
		
		return studentregistrationdao.getEduStreams(con);
	}

	
	
	/** (non-Javadoc)
	 * @throws DatabaseException 
	 * @see com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei.updateStudentPersonalDetails(
			StudentPersonalDetailsToVerifyBean)
	 */
	@Override
	public void updateStudentPersonalDetails(
			StudentPersonalDetailsToVerifyBean bean) throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = null;
		
			con = DbUtil.getConnection();
		
		studentregistrationdao.updateStudentPersonalDetails(bean, con);
	}

	
	
	/** (non-Javadoc)
	 * @throws DatabaseException 
	 * @see com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei.updateStudentEduDetails(List,Boolean)
	 */
	@Override
	public void updateStudentEduDetails(List list,Boolean isNewPg) throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = null;
	
			con = DbUtil.getConnection();
			studentregistrationdao.updateStudentEducDetails(list, con,isNewPg);
		
	}

	
	/** (non-Javadoc)
	 * @throws DatabaseException 
	 * @see com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei.getUnivercityes()
	 */
	@Override
	public List<UniversityDTO> getUnivercityes() throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = null;
		
			con = DbUtil.getConnection();
		
	
		return studentregistrationdao.getUnivercityes(con);
	}

	
	/** (non-Javadoc)
	 * @throws DatabaseException 
	 * @see com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei.getCourse(Integer)
	 */
	@Override
	public List<CourseDTO> getCourse(Integer techId) throws DatabaseException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		
			con = DbUtil.getConnection();
		
		return studentregistrationdao.getCourses(techId,con);
	}

	
	/** (non-Javadoc)
	 * @throws DatabaseException 
	 * @see com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei.updateCourses(List<CourseDTO>,Integer)
	 */
	@Override
	public Integer updateCourses(List<CourseDTO> list,Integer userId) throws DatabaseException {
		Connection con = null;
		
			con = DbUtil.getConnection();
		
			Integer i = studentregistrationdao.updateCourses(list,con,userId);
			System.out.println(i);
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return i;
	}

	
	
	/** (non-Javadoc)
	 * @see com.nacre.online_assesment.service_i.StudentRegistrationValidationServicei.sendSuccessMailToStudent(String,String)
	 */
	@Override
	public boolean sendSuccessMailToStudent(String mailId, String password,Integer userId) {
		// TODO Auto-generated method stub
		Boolean mailStatus=false;
		
		
		String subject = "login details of your nacre Account";
		
		String messageContent = "Your Verification is Successfull  "
				+ "here is your Account Details(userId & password)\n"
				+ "UserId : "+mailId+"\n "
				+ "Password : "+password+".";
		
		Boolean sendStatus = EmailUtilty.sendEmail(mailId, subject, messageContent);
		
		//System.out.println("mail status "+ status);
		if(sendStatus){
			Connection con=null;
			try {
				con = DbUtil.getConnection();
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			studentregistrationdao.changeStudenStatusId(userId,con);
			mailStatus=true;
		}else{
			//what to do if mail not send
			mailStatus=false;
		}
		return mailStatus;
		
		
	}
	




	
	Connection con=null;
	StudentRegistrationValidationDaoi srdao=null;
	
	@Override
	public List<UniversityDTO> getUniversities() throws DatabaseException {
		// TODO Auto-generated method stub
		
		 con =DbUtil.getConnection();
		
		 srdao=new StudentRegistrationValidationDaoimpl();
		
		List<UniversityDTO> list=srdao.getUniversities(con);
		return list;
	}

	
	@Override
	public List<CollegeDTO> getColleges(Integer universityId) throws DatabaseException{
	con =DbUtil.getConnection();
	
	 srdao=new StudentRegistrationValidationDaoimpl();
	
	List<CollegeDTO> list=srdao.getColleges(universityId,con);
	
	return list;
	}
/**
 * sunil
 */
	@Override
	public List<UniversityDTO> getUniversityList() throws DataNotFoundException, DatabaseException {
		Connection con = DbUtil.getConnection();
		StudentRegistrationValidationDaoi studentRegistrationValidationDaoi=new StudentRegistrationValidationDaoimpl();
		List<UniversityDTO> universityDTOs=studentRegistrationValidationDaoi.getUniversityList(con);
		DbUtil.closeConnection(con);
		return universityDTOs;
		
	}

	@Override
	public List<CollegeDTO> getCollegeList(Integer universityId) throws DataNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		StudentRegistrationValidationDaoi studentRegistrationValidationDaoi=new StudentRegistrationValidationDaoimpl();
		List<CollegeDTO> collegeDTOs=studentRegistrationValidationDaoi.getCollegeList(universityId,con);
		DbUtil.closeConnection(con);
		return collegeDTOs;
	}

	@Override
	public List<StreamDTO> getStreamList() throws DataNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		StudentRegistrationValidationDaoi studentRegistrationValidationDaoi=new StudentRegistrationValidationDaoimpl();
		List<StreamDTO> sttreamDTOs=studentRegistrationValidationDaoi.getStreamList(con);
		DbUtil.closeConnection(con);
		return sttreamDTOs;
	}

	@Override
	public int getUserId(String email) throws DatabaseException, DataNotFoundException  {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		StudentRegistrationValidationDaoi studentRegistrationValidationDaoi=new StudentRegistrationValidationDaoimpl();
		int value=studentRegistrationValidationDaoi.getUserId(email, con);
		DbUtil.closeConnection(con);
		return value;
	}

	@Override
	public int studentRegistration(Map studentRegistrationMap) throws DatabaseException {
		Connection con = DbUtil.getConnection();
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StudentRegistrationValidationDaoi studentRegistrationValidationDaoi=new StudentRegistrationValidationDaoimpl();
		int value=studentRegistrationValidationDaoi.studentRegistration(studentRegistrationMap, con);
		DbUtil.closeConnection(con);
		return value;
	}

}
