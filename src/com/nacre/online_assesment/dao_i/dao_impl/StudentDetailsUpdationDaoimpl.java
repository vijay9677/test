
package com.nacre.online_assesment.dao_i.dao_impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nacre.online_assesment.dao_i.StudentDetailsUpdationDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.StreamDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.PersonalDetailsBean;
import com.nacre.online_assesment.form_bean.StudentCoursesBean;
import com.nacre.online_assesment.form_bean.StudentEducationBean;
import com.nacre.online_assesment.util.StringConstants;

/**
 * @author PRAVEEN GUGGILLA
 *
 */
public class StudentDetailsUpdationDaoimpl implements StudentDetailsUpdationDaoi {

	
	//-------------------retrieving all the student details-----------------------
	
	@Override
	public List getStudentProfile(Integer userId , Connection con) throws DatabaseException{
		
		List studentDetailsList = new  ArrayList();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_STUDENT_PERSONAL_DETAILS);
			ps.setObject(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
	// -----------retrieving personal details----------		
			while(rs.next()){
				
				PersonalDetailsBean studentPersonalDetails = new PersonalDetailsBean();
				
				studentPersonalDetails.setUserId(rs.getInt(1));
				studentPersonalDetails.setFname(rs.getString(2));
				studentPersonalDetails.setLname(rs.getString(3));
				studentPersonalDetails.setMail(rs.getString(4));
				studentPersonalDetails.setMobile(rs.getString(5));
				
				if(rs.getInt(6)==0){
					studentPersonalDetails.setGender("female");
				}
				else{
					studentPersonalDetails.setGender("male");
				}
				studentPersonalDetails.setImage(rs.getString(7));
				studentPersonalDetails.setDob(rs.getDate(8));
				//studentPersonalDetails.setTechnology(rs.getString(9));
				studentPersonalDetails.setStatus(rs.getString(9));
				studentPersonalDetails.setLocation(rs.getString(10));
				studentPersonalDetails.setPincode(rs.getInt(11));
				studentPersonalDetails.setCity(rs.getString(12));
				studentPersonalDetails.setCityId(rs.getInt(13));
				studentPersonalDetails.setState(rs.getString(14));
				studentPersonalDetails.setStateId(rs.getInt(15));
				studentPersonalDetails.setCountry(rs.getString(16));
				studentPersonalDetails.setCountryId(rs.getInt(17));
				studentPersonalDetails.setTechnology(rs.getString(18));

				System.out.println("stateid=="+rs.getInt(15));
				System.out.println("countryId=="+rs.getInt(17));
				
				studentDetailsList.add(studentPersonalDetails);
				
			}
			
	  // -----------retrieving educational details and seperating all education details based on the education type----------		

			List<StudentEducationBean> eduList = new ArrayList<StudentEducationBean>();
			PreparedStatement psTechId = con.prepareStatement(SQLQueryConstants.GET_STUDENT_EDUCATIONAL_DETAILS);
			psTechId.setObject(1, userId);
			
			ResultSet rs2 = psTechId.executeQuery();
			
			StudentEducationBean se= new StudentEducationBean();
			StudentEducationBean interBean= new StudentEducationBean();
			StudentEducationBean gradBean= new StudentEducationBean();
			StudentEducationBean postGradBean= new StudentEducationBean();
 
	while(rs2.next()){
				
		if(rs2.getString(1).equals(StringConstants.EDUCATION_TYPE_SSC))	{
				
				se.setEdu_type(rs2.getString(1));
				
				se.setPercent_grade(rs2.getString(2));
				
				se.setYear_of_pass(rs2.getDate(3));
			
		}
		
		if(rs2.getString(1).equals(StringConstants.EDUCATION_TYPE_INTER)){
				
	            interBean.setEdu_type(rs2.getString(1));
				
	            interBean.setPercent_grade(rs2.getString(2));
				
	            interBean.setYear_of_pass(rs2.getDate(3));
			
		}
		
		if(rs2.getString(1).equals(StringConstants.EDUCATION_TYPE_DEGREE)){
			
	
				gradBean.setEdu_type(rs2.getString(1));
				
				gradBean.setPercent_grade(rs2.getString(2));
				
				gradBean.setYear_of_pass(rs2.getDate(3));
				
				String stream=rs2.getString(4);
				
				gradBean.setStream(stream);
				
				gradBean.setCollege(rs2.getString(5));
				gradBean.setUnivercity(rs2.getString(6));
				gradBean.setLocation(rs2.getString(7));
				gradBean.setPincode(rs2.getInt(8));
				gradBean.setCity(rs2.getString(9));
				gradBean.setState(rs2.getString(10));
				gradBean.setCountry(rs2.getString(11));
		
		       }
		
		if(rs2.getString(1).equals(StringConstants.EDUCATION_TYPE_PG)){
			
			
			postGradBean.setEdu_type(rs2.getString(1));
			
			postGradBean.setPercent_grade(rs2.getString(2));
			
			postGradBean.setYear_of_pass(rs2.getDate(3));
			
			String stream=rs2.getString(4);
			
			postGradBean.setStream(stream);
			
			postGradBean.setCollege(rs2.getString(5));
			postGradBean.setUnivercity(rs2.getString(6));
			postGradBean.setLocation(rs2.getString(7));
			postGradBean.setPincode(rs2.getInt(8));
			postGradBean.setCity(rs2.getString(9));
			postGradBean.setState(rs2.getString(10));
			postGradBean.setCountry(rs2.getString(11));
	
	          }
			}
	
	// adding ssc,inter,graduation and post graduation details in eduList
	        
	        eduList.add(se);
	        eduList.add(interBean);
	        eduList.add(gradBean);
	        
            if(postGradBean.getEdu_type()!=null){
            eduList.add(postGradBean);
            }
    	
            studentDetailsList.add(eduList);
			
	//-------------------- retrieving courses---------------
			
			List<StudentCoursesBean> courses = new ArrayList<>();
			PreparedStatement ps3=con.prepareStatement(SQLQueryConstants.GET_STUDENT_COURSES);
			ps3.setObject(1,userId);
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next()){
				
				StudentCoursesBean courseBean =new StudentCoursesBean();
				courseBean.setCourses(rs3.getString(1));
				courses.add(courseBean);
			}
			
			studentDetailsList.add(courses);
		} 
		catch (SQLException e) {
			
			System.out.println("sql error:"+e.getMessage());
			
			throw new DatabaseException("records not available");

		}
		
		return studentDetailsList;
	}

	
	
	// --------------updating student details in tbl_user-------------------
	
	@Override
	public Integer updateStudentProfile(PersonalDetailsBean bean, Connection con)
			throws DatabaseException, SQLException {
		
	
		Integer result=0;
		Integer userId=bean.getUserId();
		Integer city_id=bean.getCityId();
		System.out.println("city id from daoimpl    ="+city_id);
		 
		 String technology=bean.getTechnology();
		 System.out.println("technology from daoimpl"+technology);

			int adressId = 0;
			
			try {
				
				PreparedStatement adressPs = con.prepareStatement(SQLQueryConstants.GET_ADDRESS);
				//ResultSet adresResult = st.executeQuery(SQLQueryConstants.GET_ADDRESS);
				adressPs.setObject(1, bean.getLocation());
				adressPs.setObject(2,bean.getPincode());
				adressPs.setObject(3, bean.getCityId());
				
				ResultSet adresResult =adressPs.executeQuery();
				if(adresResult.next()){
					  
						  adressId=adresResult.getInt(1);
						    System.out.println("addrs id from daoimpl=========="+adressId);
					     
					}
					
			   else{
					
				if(adressId==0){
					
					PreparedStatement adresInsertPS = con.prepareStatement(SQLQueryConstants.INSERT_ADDRESS,Statement.RETURN_GENERATED_KEYS);
					adresInsertPS.setObject(1, bean.getLocation());
					adresInsertPS.setObject(2, bean.getPincode());
					adresInsertPS.setObject(3, city_id);
					
					adresInsertPS.executeUpdate();
					ResultSet rsg = adresInsertPS.getGeneratedKeys();
					System.out.println("address id from daoimlp=="+rsg);
					if(rsg.next()){
					adressId = rsg.getInt(1);
					System.out.println("address id from daoimlp===="+adressId);
					}
				
				}
			}

				
				PreparedStatement psTechId=con.prepareStatement(SQLQueryConstants.GET_TECHNOLOGY_ID);
				psTechId.setObject(1,technology);
				ResultSet rs2=psTechId.executeQuery();
				int technology_id=0;
				
				while(rs2.next()){
					technology_id=rs2.getInt(1);
					System.out.println("technology_id===="+technology_id);
				}
				
	
				PreparedStatement ps = con.prepareStatement(SQLQueryConstants.UPDATE_STUDENT_DETAILS);

				ps.setObject(1,bean.getMail());
				ps.setObject(2, bean.getMobile());
				ps.setObject(3, adressId);
				ps.setObject(4,technology_id);
				ps.setObject(5,userId);
			
				result =ps.executeUpdate();
				
				if(result!=0){
					System.out.println("successfully updated records in tbl_user");
				}else{
					throw new DatabaseException("records not updated in tbl_user");
				}
						
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("sql error"+e.getMessage());
				throw new DatabaseException("problem occured while updating data in database");
			}
			return result;
		}


// -------------updating student post graduation details----------------
	
	@Override
	public Integer updateStudentPostGradDetails(StudentEducationBean eduBean,
			Connection con) throws DatabaseException, SQLException {
		
		Integer collegeID=null;
		Integer edu_type_id=null;
		Integer addressId=null;
		Integer resultFinal=0;

   try{

		if(addressId==null){
			
			PreparedStatement adresInsertPS = con.prepareStatement(SQLQueryConstants.INSERT_LOCATION_AND_CITY_ID,Statement.RETURN_GENERATED_KEYS);
			
			adresInsertPS.setObject(1,eduBean.getLocation());
			adresInsertPS.setObject(2,eduBean.getCityId());
			
			adresInsertPS.executeUpdate();
			ResultSet rsg = adresInsertPS.getGeneratedKeys();
			System.out.println(rsg);
			if(rsg.next()){
				addressId = rsg.getInt(1);
			System.out.println("address id from daoimpl=="+addressId);
			}else{
				throw new DatabaseException("records not inserted in tbl_address");
			}
		}
		
		//---------retrieving education type id
		
		PreparedStatement psGetEduTypeId =con.prepareStatement(SQLQueryConstants.GET_EDUCATION_TYPE_ID);
		
		   psGetEduTypeId.setObject(1,eduBean.getEdu_type());
		   ResultSet eduTypeId1=psGetEduTypeId.executeQuery();
		   
		   while(eduTypeId1.next()){
			  edu_type_id=eduTypeId1.getInt(1);
			  System.out.println("edutypeid=="+edu_type_id);
		   }
		   
			PreparedStatement insertCOlPS = con.prepareStatement(SQLQueryConstants.INSERT_COLLEGE_AND_UNIVERSITY_ID,Statement.RETURN_GENERATED_KEYS);
			
			insertCOlPS.setObject(1,eduBean.getCollege());
			insertCOlPS.setObject(2,eduBean.getUniversityId());
			
			insertCOlPS.executeUpdate();
			ResultSet rsg = insertCOlPS.getGeneratedKeys();
			System.out.println(rsg);
			if(rsg.next()){
			collegeID = rsg.getInt(1);
			System.out.println("college id=="+collegeID);
			}else{
				throw new DatabaseException("records not inserted in tbl_college");
			}
		
			
		PreparedStatement insertEduPs = con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_POST_GRADUATION_DETAILS);
		
		insertEduPs.setObject(1,eduBean.getPercent_grade());// %
		
		Date yopass=(Date) eduBean.getYear_of_pass();
		
		insertEduPs.setObject(2,yopass.getYear()+1900);//yop
		insertEduPs.setObject(3,eduBean.getStreamId());//stream id
		insertEduPs.setObject(4, collegeID);
		insertEduPs.setObject(5, edu_type_id);
		insertEduPs.setObject(6,addressId);//address id
		insertEduPs.setInt(7,eduBean.getUser_id());//user id
		
		 resultFinal=insertEduPs.executeUpdate();
		
		if(resultFinal!=0){
			System.out.println("successfully inserted into tbl_edu_details");
		         }else{
		        	 throw new DatabaseException("records not inserted in tbl_edu_details");
		         }
	}catch (SQLException e) {
		
		e.printStackTrace();
		System.out.println("sql error"+e.getMessage());
		throw new DatabaseException("problem occured while updating data in database");
	   }//end of catch

      return resultFinal;
      
	}


 //-------------- retrieving all the streams--------------
	
	@Override
	public List<StreamDTO> getStreamList(Connection con)
			throws DataNotFoundException, DatabaseException {
		
		List<StreamDTO> streamsList = new ArrayList<>();

		try {
			PreparedStatement psStreams=con.prepareStatement(SQLQueryConstants.GET_STREAMS);
			ResultSet rsStreams=psStreams.executeQuery();
			while(rsStreams.next()){
				
				StreamDTO sdto=new StreamDTO();
				sdto.setStreamId(rsStreams.getInt(1));
				sdto.setStream(rsStreams.getString(2));
				streamsList.add(sdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("streams are not available");
		}
		return streamsList;
	}


//---------------retrieving all courses ---------------------
	@Override
	public List<CourseDTO> getCourses(Integer userId, Connection con)
			throws DataNotFoundException, DatabaseException {
		  
		List<CourseDTO> courseList=new ArrayList<>();
		  
		try {
			
			PreparedStatement psTechId=con.prepareStatement(SQLQueryConstants.GET_STUDENT_TECHNOLOGY_ID);
			psTechId.setObject(1,userId);
			ResultSet rs=psTechId.executeQuery();
			Integer technologyId=0;
			
			while(rs.next()){
				
				technologyId=rs.getInt(1);
			}
			
			PreparedStatement psGetCourses=con.prepareStatement(SQLQueryConstants.GET_COURSES_ON_TECHNOLOGY_ID);
			psGetCourses.setObject(1,technologyId);
			ResultSet rs1=psGetCourses.executeQuery();
			
			while(rs1.next()){
				
				CourseDTO coursesDTO=new CourseDTO();
				
				String course=rs1.getString(1);
				coursesDTO.setCourse(course);
				
				Integer courseId=rs1.getInt(2);
				coursesDTO.setCourseId(courseId);
				
				courseList.add(coursesDTO);
			}
			System.out.println(courseList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql error.."+e.getMessage());
			throw new DatabaseException("courses not available");
		}
		return courseList;
	}


//-------------- updating student courses-----------
	
	@Override
	public void updateStudentCourses(List<CourseDTO> list,Integer userId, Connection con)
			throws DatabaseException, SQLException {

				try {
					
					PreparedStatement deleteCoursePs= con.prepareStatement(SQLQueryConstants.DELETE_STUDENT_COURSES);
					deleteCoursePs.setObject(1, userId);
					deleteCoursePs.executeUpdate();
					
					System.out.println("from daoimpl courses list is==="+list);
			
			for(Object o : list){
				
				CourseDTO dto = (CourseDTO) o;
				
				int courseId =0;
				
					PreparedStatement getCIdPS = con.prepareStatement(SQLQueryConstants.GET_STUDENT_COURSE_ID);
					
					getCIdPS.setObject(1,dto.getCourse());
					
					System.out.println("course from daoimlp=="+dto.getCourse());
					
					ResultSet getCidRS = getCIdPS.executeQuery();
					
					if(getCidRS.next()){
						
						if(getCidRS.getString(1)!=null){
							
						courseId=getCidRS.getInt(1);
						
						}
					}
					System.out.println("courseid==="+courseId);
					PreparedStatement insertCoursePs = con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_COURSES);
					insertCoursePs.setObject(1,courseId);
					insertCoursePs.setObject(2,userId);
					
					int count=insertCoursePs.executeUpdate();
					if(count!=0){
						System.out.println("successfully inserted into tbl_student_course");
					}
					
				} 
			}catch (SQLException e) {
				System.out.println("sql error"+e.getMessage());
				throw new DatabaseException("problem occured while inserting data in database");
			}
			
		}
		
	}


