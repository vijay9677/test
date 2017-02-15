/**
 * @author Rohit Kumar Singh b35
 */

package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.nacre.online_assesment.dao_i.AssesmentsDaoi;
import java.util.NavigableMap;

import com.nacre.online_assesment.dao_i.AssesmentsDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.AssesmentsDaoimpl;
import com.nacre.online_assesment.form_bean.CurrentQuestionDetailsBean;
import com.nacre.online_assesment.form_bean.ScoreBean;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.AssesmentTypeDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.CurrentQuestionDetailsBean;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.nacre.online_assesment.dao_i.AssesmentsDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.AssesmentsDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.BookedSlotsBean;
import com.nacre.online_assesment.service_i.AssesmentServicei;


/**
 * @author Vijay Kumar Reddy K
 *
 */

public class AssesmentsServiceimpl implements AssesmentServicei {
	
	public AssesmentsServiceimpl() {
		// TODO Auto-generated constructor stub
	//	System.out.println("In ServiceImpl....");
	}

	/**
	 * @author Chitranshu Gupta
	 * @return List
	 * @throws DatabaseException 
	 *
	 */
	@Override
	public List<Object> getAssessmentType() throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();

		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.getAssessmentType(con);
	}

	/**
	 * @author Chitranshu Gupta
	 * @param assessmentTypeId
	 * @return List
	 * @throws DatabaseException 
	 */
	@Override
	public List<Object> getAssessments(Integer assessmentTypeId) throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();

		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.getAssessments(con, assessmentTypeId);
	}

	/**
	 * @author Chitranshu Gupta
	 * @param assessmentId
	 * @return List
	 * @throws DatabaseException 
	 */
	@Override
	public List<Object> getAssessmentDetails(Integer assessmentId) throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();

		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.getAssessmentDetails(con, assessmentId);
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param AssesmentDTO ad
	 * @return Boolean 
	 * @throws DatabaseException ,SQLException
	 */
	

	/**
	 * @author Chitranshu Gupta
	 * @param currentQuestionDetailsBean
	 * @return NavigableMap
	 * @throws DatabaseException 
	 */
	@Override
	public NavigableMap<Integer, Object> getQuestionsAndTheirOption(CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();

		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.getQuestionsAndTheirOption(con, currentQuestionDetailsBean);
	}

	/**
	 * @author Chitranshu Gupta
	 * @param currentQuestionDetailsBean
	 * @return Integer
	 * @throws DatabaseException 
	 */
	@Override
	public Integer calculateScore(CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException {
		Connection con = DbUtil.getConnection();
		AssesmentsDaoi interface2 = new AssesmentsDaoimpl();
		return interface2.calculateScore(con, currentQuestionDetailsBean);
	}

	/**
	 * @author Chitranshu Gupta
	 * @param assessmentId
	 * @param userId
	 * @return String
	 * @throws DatabaseException 
	 */
	@Override
	public String getExamStatus(Integer assessmentId, Integer userId) throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		AssesmentsDaoi interface2 = new AssesmentsDaoimpl();
		return interface2.getExamStatus(con, assessmentId, userId);
		
	}
	@Override
	public Boolean addAssessment(AssesmentDTO ad) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();

		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.addAssessment(con,ad);
		
	}
	
	/**
	 * @author pavan pratap singh b-35
	 * @param AssesmentDTO ad
	 * @return Boolean 
	 * @throws DatabaseException ,SQLException
	 */

	@Override
	public Boolean editAssessment(AssesmentDTO ad) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();

		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.editAssessment(con, ad);
		
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param assessmentId
	 * @return Boolean 
	 * @throws DatabaseException ,SQLException
	 */

	@Override
	public Boolean deleteAssessment(Integer assessmentId) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();

		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.deleteAssessment(con, assessmentId);
	}

	@Override
	public List<AssesmentTypeDTO> getAssesmentType() throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.getAssesmentType(con);
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List<AssesmentDTO> 
	 * @throws DatabaseException 
	 */

	@Override
	public List<LevelDTO> getLevel() throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.getLevel(con);
		
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List<AssesmentDTO> 
	 * @throws DatabaseException 
	 */

	@Override
	public List<CourseDTO> getCourses() throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.getCourses(con);
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param 
	 * @return List<AssesmentDTO> 
	 * @throws DatabaseException 
	 */

	@Override
	public List<AssesmentDTO> getAssessmentDetailsForEditAction() throws DatabaseException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.getAssessmentDetailsForEditAction(con);
	}

	@Override
	public List getScores(Integer userId) throws DatabaseException {
		// TODO Auto-generated method stub

		Connection con = DbUtil.getConnection();
		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.getScores(con, userId);
	}

	/**
	 * @author Krishna prakash
	 * @throws DatabaseException 
	 *
	 */
	@Override
	public List<LevelDTO> getQuestionLevel() throws DatabaseException 
	{
		// TODO Auto-generated method stub
		Connection	con=DbUtil.getConnection();

		AssesmentsDaoi adao=new AssesmentsDaoimpl();
		return adao.getQuestionLevel(con);
	}

	/**
	 * @author Krishna prakash
	 * @throws DatabaseException 
	 *
	 */

	@Override
	public Integer uploadAssessmentPaper(List li,Integer assId) throws DatabaseException 
	{
	Connection	con=DbUtil.getConnection();
	AssesmentsDaoi adao=new AssesmentsDaoimpl();
	Integer count=adao.uploadAssessmentPaper(li,assId, con);
	return count;
	
	}
    /**
	 * @author Krishna prakash
	 * @throws DatabaseException 
	 *
	 */
	@Override
    public Boolean deleteAssessmentPaper(Integer assessmentId) throws DatabaseException, SQLException
    {
	
		Connection con = DbUtil.getConnection();

		AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
		return assesmentdao.deleteAssessmentPaper(con, assessmentId);
	
		
    }
	/**
	 * @author Krishna prakash
	 * @throws DatabaseException,SQLException
	 *
	 */
	 public List getAssessmentPaper() throws DatabaseException, SQLException
	 {
			AssesmentsDaoi assesmentdao = new AssesmentsDaoimpl();
			Connection con = DbUtil.getConnection();
		    return assesmentdao.getAssessmentPaper(con);
	    	
	    }



	/**
	 * @author Rohit Kumar Singh b35
	 */
	
	@Override
	public ArrayList<Object> getAssessmentTypeName() throws DatabaseException {
		// TODO Auto-generated method stub
	//	System.out.println("in Service getAssessmentTypeName() method");
		
		//--------------------get Connection------------------------- 
		Connection con=DbUtil.getConnection();
		
		//----------------create ArrayList with initialization-------------------
		ArrayList<Object> list=null;
		
		//----------------checking connection object--------------------
		if(con!=null){
			
		//----------------get AssesmentsDaoi object--------------------
		AssesmentsDaoi assmentdaoi=new AssesmentsDaoimpl();

		//----------------call Daoi method----------------------
		list=assmentdaoi.getAssessmentTypeName(con);
	//	System.out.println("service"+list);
		}//if
		else{
			throw new DatabaseException("connection is not established");
		}//else
		
		//-----------------close Objects-------------------
		try {
			if(con!=null)
			  con.close();
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("Assessment Type Names are not available");
		}//catch
		
		return list;
		
	}//getAssessmentTypeName(-) method

	/**
	 * @author Rohit Kumar Singh b35
	 */
	
	@Override
	public ArrayList<Object> getAssessmentName(Integer assesmentTypeId,Integer userId) throws DatabaseException {
		// TODO Auto-generated method stub
				
		//------------------------get Connection----------------------------
		Connection con=DbUtil.getConnection();
		
		//----------------create ArrayList with initialization---------------
		ArrayList<Object> list=null;
		
		//----------------check connection object nullability----------------
		if(con!=null){
			
		//-----------------create AssessmentDaoi object----------------------
		AssesmentsDaoi assmentdaoi=new AssesmentsDaoimpl();
		
		//-------------------calling of Daoi methods-------------------------
		list=assmentdaoi.getAssessmentName(con,assesmentTypeId,userId);
		
	//	SimpleDateFormat dtformat=new SimpleDateFormat("dd-mm-yyyy");
				
		}//if
		else{
			throw new DatabaseException("connection not established");
		}//else
		
		//------------------------close objects-----------------------------
		try {
			if(con!=null)
			  con.close();
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}//catch
		
		return list;
		
	}//getAssessmentName(assesmenttypeid)
	
	
	/**
	 * @author Rohit Kumar Singh b35
	 */
	
	@Override
	public ArrayList<Object> getTimeSlots(Integer assesmentId) throws DatabaseException{
		
	//	System.out.println("in serviceimpl : gettime");
		
		//---------------------get Connection-----------------------
		Connection con=DbUtil.getConnection();
	
		//-------------------create object of list------------------
		ArrayList<Object> timedto=null;
	
		//------------check connection object nullability-----------		
		if(con!=null){
			
			//-----------create AssessmentDaoi object---------------
			AssesmentsDaoi assdaoi=new AssesmentsDaoimpl();
			
			//-----------call daoi method and accessing objects--------
			timedto=assdaoi.getTimeSlots(con,assesmentId);
			Object timeDurationobj=timedto.get(0);
			Object strtTime=timedto.get(1);
			Object endTime=timedto.get(2);
			
			
		//	System.out.println("ob1--"+timeDurationobj+"--2--"+strtTime+"--3--"+endTime);
			
			//-----------Logic to convert into Time and generating TimeSlots--------------
			String duration=timeDurationobj.toString();
			int timeDuration=Integer.parseInt(duration);
			
			//-------------------converting start time into minutes-------------------- 
			String timestampStrt =strtTime.toString();
			String[] tokenstrt = timestampStrt.split(":");
			int strthours = Integer.parseInt(tokenstrt[0]);
			int strtminutes = Integer.parseInt(tokenstrt[1]);
			int strtseconds = Integer.parseInt(tokenstrt[2]);
			int strtduration = 60 * strthours + strtminutes + strtseconds/60;
		//	System.out.println("hh--"+strthours+"---mm--"+strtminutes+"--ss--"+strtseconds+"--dur--"+strtduration);
			
			//-------------------converting end time into minutes--------------------
			String timestampend =endTime.toString();
			String[] endtokens = timestampend.split(":");
			int endhours = Integer.parseInt(endtokens[0]);
			int endminutes = Integer.parseInt(endtokens[1]);
			int endseconds = Integer.parseInt(endtokens[2]);
			int endduration = 60 * endhours + endminutes + endseconds/60;
		//	System.out.println("hh--"+endhours+"---mm--"+endminutes+"--ss--"+endseconds+"--dur--"+endduration);
			
			//-----------------declaring & initializing local variable--------------------
			int nextSlot=0;
		//	System.out.println("strtSlot--"+strtTime);
			
			//-----------removing previously added all objects from ArrayList--------------
			timedto.removeAll(timedto);
			
			//-------------adding new objects to ArrayList and swapping--------------------
			timedto.add(strtTime);
			nextSlot=strtduration+timeDuration;
			
			strtduration=nextSlot;
			
			//----------------getting hrs  and remainig minutes from total minutes----------
			int newHrs=nextSlot/60;
			int newMin=nextSlot%60;
			int newSec=0;
			String slot=String.format("%02d:%02d:%02d",newHrs,newMin,newSec);
		
			//----------------------creating SimpleDateFormat object--------------------------
			SimpleDateFormat dtform=new SimpleDateFormat("HH:mm:ss");
				
			while(strtduration<=endduration){
			 	
				//-----------------converting String time into java.sql.Time------------------
				try {
					java.sql.Date d= new java.sql.Date(dtform.parse(slot).getTime());
					Time tt=new Time(d.getTime()) ;
					timedto.add(tt);
				//	System.out.println(timedto);
					nextSlot=strtduration+timeDuration;
					
					strtduration=nextSlot;
					
					newHrs=nextSlot/60;
					newMin=nextSlot%60;
					newSec=0;
					slot=String.format("%02d:%02d:%02d",newHrs,newMin,newSec);
					
				}//try
				catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}//catch
				
			}//while
			
		}//if
		else{
			throw new DatabaseException("ServiceImpl :in getTimeSlot-connection not established");
		}//else
		
		//--------------------------close objects------------------------------
		try {
			if(con!=null)
			  con.close();
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		
		return timedto;
		
	}//getTimeSlots()

		
	/**
	 * @author Rohit Kumar Singh b35
	 */
	
	@Override
	public ArrayList<Object> bookedSelectedSlots(BookedSlotsBean bukBean) throws DatabaseException {
		// TODO Auto-generated method stub
	//	System.out.println("In ServiceImpl : bookedSlots");
		
		//-----------------get Connection object----------------------------
		Connection con=DbUtil.getConnection();
		
		ArrayList<Object> arrlist=new ArrayList<Object>();
		
		//-------------------create AssmentDAOi object----------------------
		AssesmentsDaoi assdaoi=new AssesmentsDaoimpl();
		
		//-------------------create ArrayList object-----------------------
		arrlist= assdaoi.bookSelectedSlot(con, bukBean);
		
		//--------------------close object---------------------------------
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrlist;
		
	}//bookedSeletecSlots(bukBean)
	
		
	/**
	 * @author Rohit Kumar Singh b35
	 * @return Object
	 * @throws DatabaseException
	 */
	
	@Override
	public Time validationForBookedSlots(Integer userId, Integer assmentId) throws DatabaseException {
		// TODO Auto-generated method stub
	//	System.out.println("in validation serviceImpl");
	
		//----------------get Connection from Dbutil-------------------------
		Connection con = DbUtil.getConnection();
		
		//-----------------get AssesmentDaoi object-------------------------
		AssesmentsDaoi assDaoi=new AssesmentsDaoimpl();
		
		//-----------------------call Daoi method---------------------------
		Time bookedSlot = assDaoi.validationForBookedSlots(con, userId, assmentId);
		
		//--------------------close object---------------------------------
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		//slot time is returning for particular assid & userid
		
		return bookedSlot;
		
	}//validationForBookedSlots(Integer userId,Integer assmentId)
	
	
	@Override
	public ArrayList<Object> getBookedSlotDetails(Integer assessmentId, Integer userID) throws DatabaseException {
		// TODO Auto-generated method stub
		
		//-----------------------------getting Connection object----------------------------
		Connection con = DbUtil.getConnection();
		
		//-----------------------------getting AssessmentDaoI object
		AssesmentsDaoi assmentDaoi = new AssesmentsDaoimpl();
		
		//-----------------------call Daoi method
		 ArrayList<Object> bkdslotdetails = assmentDaoi.getBookedSlotDetails(con, assessmentId, userID);
			
		//--------------------close object---------------------------------
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bkdslotdetails;
	
	}//getBookedDetails()
	/**
	 * @author pavan pratap singh b-35
	 * @param assessmentId
	 * @return
	 * @throws DatabaseException
	 */
	

	@Override
	public AssesmentDTO getAssessmentDetailsForEdit(Integer assessmentId) throws DatabaseException {
		// TODO Auto-generated method stub
		
        Connection con = DbUtil.getConnection();
		AssesmentsDaoi assmentDaoi = new AssesmentsDaoimpl();
		return assmentDaoi.getAssessmentDetailsForEdit(con, assessmentId);
	}
	 
	
}//class
