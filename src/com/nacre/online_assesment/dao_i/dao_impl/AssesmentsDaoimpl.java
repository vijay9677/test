/**
 * 
 */
package com.nacre.online_assesment.dao_i.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import com.nacre.online_assesment.dao_i.AssesmentsDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.AssesmentDTO;
import com.nacre.online_assesment.dto.AssesmentTypeDTO;
import com.nacre.online_assesment.dto.BookedSlotsDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.AssessmentDetailsBean;
import com.nacre.online_assesment.form_bean.AssessmentPaperFormBean;
import com.nacre.online_assesment.form_bean.BookedSlotsBean;
//import com.nacre.online_assesment.form_bean.AssessmentDetailsBean;
import com.nacre.online_assesment.form_bean.CurrentQuestionDetailsBean;
import com.nacre.online_assesment.form_bean.OptionsFromBean;
import com.nacre.online_assesment.form_bean.QuestionsFormBean;
import com.nacre.online_assesment.form_bean.ScoreBean;
import com.nacre.online_assesment.form_bean.SelectedAnswersBean;
import com.nacre.online_assesment.util.StringConstants;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class AssesmentsDaoimpl implements AssesmentsDaoi {

	/**
	 * @author krishna Prakash
	 * @param  con,List
	 * @return Integer
	 * @throws DatabaseException 
	 *
	 */
	
	@Override
	public Integer uploadAssessmentPaper(List<AssessmentPaperFormBean> li,Integer assId, Connection con) throws DatabaseException 
	{
		System.out.println("at dao");
		int count=0;
		String questions=SQLQueryConstants.INSERT_QUESTION;
		String assessmentQuestions=SQLQueryConstants.INSERT_ASSESSMENT_QUESTION;
        String optionsTbl=SQLQueryConstants.INSERT_OPTIONS;
        try 
        {
        con.setAutoCommit(false);
        PreparedStatement assQuestionTbl=con.prepareStatement(assessmentQuestions);
        PreparedStatement questionInsert=con.prepareStatement(questions);
		PreparedStatement optionsTable=con.prepareStatement(optionsTbl);
		for (AssessmentPaperFormBean assessmentPaperFormBean : li)
		{
		QuestionsFormBean questionsForm=assessmentPaperFormBean.getQuestionsFormBean();
		System.out.println(questionsForm.getQuestion());
		//assId=2;
		List<LevelDTO> levelList=getQuestionLevel( con);
		if(levelList!=null)
		{
		//default level
	    Integer levelId=1;
	    for(LevelDTO l:levelList)
	    {
		String level=questionsForm.getLevel();
		/*if(level.equalsIgnoreCase(l.getLevel()))
		{*/
			System.out.println(".........");
			//levelId=l.getLevelId();
			if(questionsForm.getLevel().equalsIgnoreCase(l.getLevel()))
			{
				levelId=l.getLevelId();
			}
			
		}
	    
	    questionInsert.setObject(1,questionsForm.getQuestion());
		questionInsert.setObject(2,levelId);
		//executing query to insert question and its level
		count=questionInsert.executeUpdate();
		ResultSet questIdRS=questionInsert.getGeneratedKeys();
        if(questIdRS.next())
        {
        	assQuestionTbl.setInt(1,assId);
			assQuestionTbl.setInt(2,questIdRS.getInt(1));
			Integer i=assQuestionTbl.executeUpdate();
        }
	    //options list 
		List options=assessmentPaperFormBean.getOptionsFormBean();
		
		if(options!=null){
		Integer optCount=5;
		for (Object object : options) 
		               {
			            Integer isAns=0;
			            OptionsFromBean optionsFormBean=(OptionsFromBean)object;
			            if(optionsFormBean.getIsAnswer()==true)
						{
							isAns=1;
						}
					    //setting values
						optionsTable.setString(1,optionsFormBean.getOption());
						optionsTable.setInt(2,isAns);
						optionsTable.setInt(3,questIdRS.getInt(1));
						optCount=optionsTable.executeUpdate();
		                }
		if(optCount==1)
		{
			count=1;
			con.commit();
		}
		else
		{
		 count=0; 
		 con.rollback();
       	 throw new DatabaseException(" options not inserted options");

		}
		             }else
		             {
		            	 throw new DatabaseException("No options");
                         
		             }
		                
		             }
		              else
		             {
		            	 throw new DatabaseException("level does not exists");
		             }
		             //level reading completed
               }//AssessmentPaperFormBean reading completed
		    }
				
			catch (SQLException e) 
			   {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DatabaseException("Fails to connect with database");

			   }
		return count;
			 
			
		
		
		}
		
	/**
	 * @author krishna Prakash
	 * @return LevelDTO
	 * @throws DatabaseException 
	 *
	 */
	@Override
	public List<LevelDTO> getQuestionLevel(Connection con)

	{
		List<LevelDTO> list=new ArrayList<LevelDTO>();
		try {
			Statement stm=con.createStatement();
			ResultSet rs = stm.executeQuery("select level_id,level from tbl_level");
			while(rs.next())
			{
				LevelDTO ldto=new LevelDTO();
				ldto.setLevelId(rs.getInt(1));
				ldto.setLevel(rs.getString(2));
				list.add(ldto);
			}

		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return list;
	}
/**
	 * @author krishna Prakash
	 * @return Boolean
	 * @throws DatabaseException 
	 *
	 */
	public Boolean deleteAssessmentPaper(Connection con, Integer assessmentId) throws DatabaseException, SQLException
	{
		Boolean out=false;
		try{
		Integer assId=assessmentId;
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.SELECT_ASS_PAPER);
		ps.setObject(1, assId);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
		PreparedStatement ps2=con.prepareStatement(SQLQueryConstants.DELETE_ASS_PAPER_QUESTIONS);
		ps2.setObject(1,assId);
        Integer i2=ps2.executeUpdate();
		System.out.println(i2+"delete");
		if(i2!=0)
		{
			out=true;
		}
		}
		else
		{
            System.out.println("no paper");
            throw new DatabaseException("Question paper not exists for this assessment");

		}
		}catch(SQLException e)
		{
			e.printStackTrace();
            throw new DatabaseException("Problem in database please try later");

		}
		return out;
		
	}
	

	/**
	 * @author krishna Prakash
	 * @return List
	 * @throws DatabaseException 
	 *
	 */
	@Override
	 public List getAssessmentPaper(Connection con) throws DatabaseException, SQLException{
		PreparedStatement ps2=con.prepareStatement(SQLQueryConstants.GET_ASSESSMENT_PAPER);
		ResultSet rs=ps2.executeQuery();
		List<AssesmentDTO> li=new ArrayList<AssesmentDTO>();
		while(rs.next())
		{
			AssesmentDTO assDto=new AssesmentDTO();
			assDto.setAssesmentId(rs.getInt(1));
			assDto.setAssesment(rs.getString(2));
			li.add(assDto);
		}
		 System.out.println("dfsdsfd");

		return li;
	 }
	

	/**
	 * @author Chitranshu Gupta
	 * @param con
	 * @return List
	 * @throws DatabaseException
	 *
	 */
	@Override
	public List<Object> getAssessmentType(Connection con) throws DatabaseException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			ps = con.prepareStatement(SQLQueryConstants.GET_ASSESSMENT_TYPE);

			rs = ps.executeQuery();

			Integer assessmentTypeId = null;
			String assessmentType = null;
			if (rs != null) {
				while (rs.next()) {
					assessmentTypeId = rs.getInt(1);
					assessmentType = rs.getString(2);

					AssesmentTypeDTO dto = new AssesmentTypeDTO();
					dto.setAssesmentTypeId(assessmentTypeId);
					dto.setAssesmentTypeName(assessmentType);

					list.add(dto);
				}

			} else {

				throw new DatabaseException("Result Set Not available");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return list;

	}

	/**
	 * @author Chitranshu Gupta
	 * @param con
	 * @param assessmentTypeId
	 * @return List
	 * @throws DatabaseException
	 */
	@Override
	public List<Object> getAssessments(Connection con, Integer assessmentTypeId) throws DatabaseException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			ps = con.prepareStatement(SQLQueryConstants.GET_ASSESSMENTS);

			ps.setInt(1, assessmentTypeId);
			rs = ps.executeQuery();

			Integer assessmentId = null;
			String assessmentName = null;

			if (rs != null) {
				while (rs.next()) {
					assessmentId = rs.getInt(1);
					assessmentName = rs.getString(2);

					AssesmentDTO dto = new AssesmentDTO();
					dto.setAssesmentId(assessmentId);
					dto.setAssesment(assessmentName);

					list.add(dto);
				}

			} else {

				throw new DatabaseException("Result Set Not available");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return list;

	}

	/**
	 * @author Chitranshu Gupta
	 * @param con
	 * @param assessmentId
	 * @return List
	 * @throws DatabaseException
	 */
	@Override
	public List<Object> getAssessmentDetails(Connection con, Integer assessmentId) throws DatabaseException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			ps = con.prepareStatement(SQLQueryConstants.GET_ASSESSMENT_DETAILS);

			ps.setInt(1, assessmentId);
			rs = ps.executeQuery();

			String assessmentName = null;
			Integer assessmentMarks = null;
			Integer assessmentDuration = null;
			Date assessmentDate = null;
			String assessmentDescription = null;
			Integer assessmentTotalQuestions = null;

			if (rs != null) {
				if (rs.next()) {
					assessmentId = rs.getInt(1);
					assessmentName = rs.getString(2);
					assessmentMarks = rs.getInt(3);
					assessmentDuration = rs.getInt(4);
					assessmentDate = rs.getDate(5);
					assessmentDescription = rs.getString(6);
					assessmentTotalQuestions = rs.getInt(7);

					AssessmentDetailsBean detailsBean = new AssessmentDetailsBean();

					detailsBean.setAssessmentId(assessmentId);
					detailsBean.setAssessmentName(assessmentName);
					detailsBean.setAssessmentTotalMarks(assessmentMarks);
					detailsBean.setAssessmentDuration(assessmentDuration);
					detailsBean.setAssessmentDate(assessmentDate);
					detailsBean.setAssessmentDesc(assessmentDescription);
					detailsBean.setAssessmentTotalQuestions(assessmentTotalQuestions);

					//System.out.println(detailsBean);

					list.add(detailsBean);
				}

			} else {

				throw new DatabaseException("Result Set Not available");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return list;
	}

	/**
	 * @author Chitranshu Gupta
	 * @param con
	 * @param currentQuestionDetailsBean
	 * @return NavigableMap
	 * @throws DatabaseException
	 */
	@Override
	public NavigableMap<Integer, Object> getQuestionsAndTheirOption(Connection con,
			CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;

		PreparedStatement ps6 = null;
		ResultSet rs6 = null;
		PreparedStatement ps7 = null;
		PreparedStatement ps8 = null;

		PreparedStatement ps3 = null;
		ResultSet rs3 = null;
		PreparedStatement ps4 = null;
		PreparedStatement ps5 = null;

		NavigableMap<Integer, Object> questionSet = new TreeMap<Integer, Object>();

		String selectedOptions = currentQuestionDetailsBean.getSelectedOptions();
		Integer assessmentQuesId = currentQuestionDetailsBean.getAssessmentQuesId();
		Integer userId = currentQuestionDetailsBean.getUserId();
		String remainingTime = currentQuestionDetailsBean.getRemainingTime();
		Integer assessmentId = currentQuestionDetailsBean.getAssessmentId();

		
		String arr[]=new String[2];
		int ind=0;
		
		for (String retTime : remainingTime.split(":")) {
			
			if(ind<2)
			{
				arr[ind]=retTime;
				ind++;
			}
		}
		
		Boolean isStart=false;
		
		Integer sec=null;
		Integer secNo=null;
		Integer secdecimal=null;
		Float secInMin=null;
		Integer min=null;
		String time1=null;
		Float time=null;
		
		if(arr[1]!=null)
		{
		sec=Integer.parseInt(arr[1]);
		
		secNo= (100/60);
		secdecimal= (100%60);
		secInMin=Float.parseFloat(secNo+"."+secdecimal);
		min= Math.round(secInMin*sec);
		
		time1 = arr[0]+"."+min;
		time= Float.parseFloat(time1);
		}
	
		try {
			
			con.setAutoCommit(false);
			if(assessmentQuesId!=null)
			{

			// Savepoint spt1 = con.setSavepoint("svpt1");

			if (selectedOptions != "") {
				ps6 = con.prepareStatement(SQLQueryConstants.GET_STUDENT_ANSWERS);
				ps6.setInt(1, assessmentQuesId);
				ps6.setInt(2, userId);
				
				rs6 = ps6.executeQuery();
			
				if (rs6 != null) {
					if(rs6.next()){
					ps7 = con.prepareStatement(SQLQueryConstants.DELETE_ANSWERS);
					ps7.setInt(1, assessmentQuesId);
					ps7.setInt(2, userId);

					ps7.executeUpdate();
					}
				}
				
				for (String retval : selectedOptions.split(",")) {
				
					ps8 = con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_ANSWERS);
					ps8.setInt(1, assessmentQuesId);
					ps8.setInt(2, Integer.parseInt(retval));
					ps8.setInt(3, userId);

					int i =ps8.executeUpdate();
					
				}

			}
			else{
			
					ps7 = con.prepareStatement(SQLQueryConstants.DELETE_ANSWERS);
					ps7.setInt(1, assessmentQuesId);
					ps7.setInt(2, userId);

					ps7.executeUpdate();
				}
			
			}

			if(time!=null)
			{
			ps3 = con.prepareStatement(SQLQueryConstants.GET_REMAINING_TIME);
			ps3.setInt(1, userId);
			ps3.setInt(2, assessmentId);

		    rs3 = ps3.executeQuery();
		    
			boolean temp=false;
			
			if (rs3 != null) {
				if(rs3.next())
				{
					isStart=true;	
					
				temp=true;
				
					if(assessmentQuesId!=null)
					{
						temp=false;
					ps4 = con.prepareStatement(SQLQueryConstants.DELETE_REMAINING_TIME);
					ps4.setInt(1, assessmentId);
					ps4.setInt(2, userId);
	
					int i =ps4.executeUpdate();
					}
				}				
			}
			
			if(temp==false){
			ps5 = con.prepareStatement(SQLQueryConstants.INSERT_REMAINING_TIME);
			ps5.setFloat(1, time);
			ps5.setInt(2, userId);
			ps5.setInt(3, assessmentId);

			int i =ps5.executeUpdate();
			}
			}
			// con.rollback(spt1);
			con.commit();
			
			ps = con.prepareStatement(SQLQueryConstants.GET_ASSESSMENT_QUESTIONS_ID);

			ps.setInt(1, currentQuestionDetailsBean.getAssessmentId());
			rs = ps.executeQuery();

			Integer questionId = null;
			Integer assessmentQuestionsId = null;
			Integer questionNo = 1;

			if (rs != null) {
				while (rs.next()) {

					List questionList = new ArrayList();

					questionId = rs.getInt(1);
					assessmentQuestionsId = rs.getInt(2);

					ps1 = con.prepareStatement(SQLQueryConstants.GET_ASSESSMENT_QUESTIONS);

					ps1.setInt(1, questionId);
					rs1 = ps1.executeQuery();

					if (rs1 != null) {
						if (rs1.next()) {

							Integer quesId = rs1.getInt(1);
							String question = rs1.getString(2);

							questionList.add(assessmentQuestionsId);
							questionList.add(question);

							ps2 = con.prepareStatement(SQLQueryConstants.GET_ASSESSMENT_QUESTION_OPTIONS);

							ps2.setInt(1, quesId);
							rs2 = ps2.executeQuery();

							if (rs2 != null) {
								while (rs2.next()) {

									NavigableMap<Integer, Object> optionSet = new TreeMap<Integer, Object>();

									Integer optionId = rs2.getInt(1);
									String option = rs2.getString(2);

									optionSet.put(1, optionId);
									optionSet.put(2, option);
									questionList.add(optionSet);
								}
							}
						}

						questionSet.put(questionNo, questionList);
						questionNo++;
					}	
				}
				
			} else {

				throw new DatabaseException("Result Set Not available");
			}
			
			
			PreparedStatement ps9 = null;
			ResultSet rs9 = null;
			PreparedStatement ps10 = null;
			ResultSet rs10 = null;
			
			ps9 = con.prepareStatement(SQLQueryConstants.GET_REMAINING_TIME);
			ps9.setInt(1, userId);
			ps9.setInt(2, assessmentId);
			rs9=ps9.executeQuery();
			
			if(rs9!=null)
			{
				if(rs9.next())
				{
					
					Float remainTime = rs9.getFloat(1);
					//System.out.println(remainTime);
					
					questionSet.put(questionNo,remainTime);
					questionNo++;
					
				}
			}
			
			
			ps10 = con.prepareStatement(SQLQueryConstants.GET_SELECTED_OPTIONS);
			ps10.setInt(1, userId);
			ps10.setInt(2, assessmentId);
			rs10 = ps10.executeQuery();
			
			List<Object> selectedQuestionsAnswer = new ArrayList<Object>();
			
			if(rs10!=null)
			{
				while(rs10.next())
				{
					SelectedAnswersBean  answersBean=new SelectedAnswersBean();
					
					Integer assessmentQuestionsIds = rs10.getInt(1);
					Integer selAnswers = rs10.getInt(2);
										
				    answersBean.setAssessmentQuestionId(assessmentQuestionsIds);
				    answersBean.setSelectedOption(selAnswers);
				    
				    selectedQuestionsAnswer.add(answersBean);
				    
				}
			}
			
			questionSet.put(questionNo, selectedQuestionsAnswer);
			questionNo++;
			
			questionSet.put(questionNo, isStart);
			questionNo++;
			
			PreparedStatement ps11 = null;
			ResultSet rs11 = null;
			
			String examStatus=null;
			
			ps11 = con.prepareStatement(SQLQueryConstants.GET_EXAM_STATUS);

			ps11.setInt(1, assessmentId);
			ps11.setInt(2, userId);
			rs11 = ps11.executeQuery();

			if (rs11 != null) {
			   if (rs11.next()) {
			
				   examStatus = rs11.getString(1);
				}
			   questionSet.put(questionNo, examStatus);
			   questionNo++;
			   System.out.println("=========================--------------------"+examStatus);

			} else {

				throw new DatabaseException("Result Set Not available");
			}
			

		} catch (SQLException e) {

			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}

		return questionSet;

	}

	/**
	 * @author Chitranshu Gupta
	 * @param con
	 * @param currentQuestionDetailsBean
	 * @return Integer
	 * @throws DatabaseException
	 */
	@Override
	public Integer calculateScore(Connection con, CurrentQuestionDetailsBean currentQuestionDetailsBean) throws DatabaseException {
	Integer insertRow = null;
		
		try {
			PreparedStatement ps =null;
			ResultSet rs =null;
			
			PreparedStatement ps1 =null;
			ResultSet rs1 =null;
			
			PreparedStatement ps2 =null;
			ResultSet rs2 =null;

			PreparedStatement ps3 =null;
			ResultSet rs3 =null;			
			
			PreparedStatement ps6 =null;
			ResultSet rs6 =null;
			
			PreparedStatement ps7 =null;
			//ResultSet rs7 =null;
			
			PreparedStatement ps8 =null;
			//ResultSet rs8 =null;
			
			String selectedOptions = currentQuestionDetailsBean.getSelectedOptions();
			Integer assessmentQuesId = currentQuestionDetailsBean.getAssessmentQuesId();
			Integer userId = currentQuestionDetailsBean.getUserId();
			Integer assessmentId = currentQuestionDetailsBean.getAssessmentId();
			
			
			if (selectedOptions != "") {
				ps6 = con.prepareStatement(SQLQueryConstants.GET_STUDENT_ANSWERS);
				ps6.setInt(1, assessmentQuesId);
				ps6.setInt(2, userId);
				
				rs6 = ps6.executeQuery();
			
				if (rs6 != null) {
					if(rs6.next()){
					ps7 = con.prepareStatement(SQLQueryConstants.DELETE_ANSWERS);
					ps7.setInt(1, assessmentQuesId);
					ps7.setInt(2, userId);

					ps7.executeUpdate();
					}
				}
				
				for (String retval : selectedOptions.split(",")) {
					
					ps8 = con.prepareStatement(SQLQueryConstants.INSERT_STUDENT_ANSWERS);
					ps8.setInt(1, assessmentQuesId);
					ps8.setInt(2, Integer.parseInt(retval));
					ps8.setInt(3, userId);

					int i =ps8.executeUpdate();
					
				}

			}
			else{
			
					ps7 = con.prepareStatement(SQLQueryConstants.DELETE_ANSWERS);
					ps7.setInt(1, assessmentQuesId);
					ps7.setInt(2, userId);

					ps7.executeUpdate();
				}

			con.setAutoCommit(false);
			
			ps = con.prepareStatement(SQLQueryConstants.GET_SELECTED_ANSWERS);
			
			
			Set selectedOptionsKeySet=new HashSet();
			List selectedOptionsList=new ArrayList();
			
			ps.setInt(1, userId);
			ps.setInt(2, assessmentId);
			rs = ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next()){
					
					Map map=new HashMap();
					
					map.put(rs.getInt(1), rs.getInt(2));
					selectedOptionsKeySet.add(rs.getInt(1));
					
					selectedOptionsList.add(map);
					
				}
			}
		
			String val="";
			
			Set selectedSet = new HashSet();
		
			for (Object keyObject : selectedOptionsKeySet) {
				val=keyObject.toString();
				for (Object object : selectedOptionsList) {
					Map map=(Map) object;
					if(map.get(keyObject)!=null){
					System.out.println(map.get(keyObject));
					val+=map.get(keyObject);
					}	
				}
				selectedSet.add(val);
			}
						
			Set rightOptionsKeySet=new HashSet();
			List rightOptionsList=new ArrayList();
			ps1=con.prepareStatement(SQLQueryConstants.GET_RIGHT_OPTIONS);
			ps1.setInt(1, 1);
			ps1.setInt(2, assessmentId);
			rs1=ps1.executeQuery();
			if(rs1!=null)
			{
				while(rs1.next()){
					
                    Map map=new HashMap();
					
					map.put(rs1.getInt(1), rs1.getInt(2));
					rightOptionsKeySet.add(rs1.getInt(1));
					rightOptionsList.add(map);
					
				}
			}
					
			Set correctSet = new HashSet();
			
			for (Object keyObject : rightOptionsKeySet) {
				val=keyObject.toString();
				for (Object object : rightOptionsList) {
					Map map=(Map) object;
					if(map.get(keyObject)!=null){
					System.out.println(map.get(keyObject));
					val+=map.get(keyObject);
					}	
				}
				
				correctSet.add(val);
			}
		
			
			int countScore=0;
			for (Object object : selectedSet) 
			{
				for(Object object1 : correctSet)
				{
					if(object.equals(object1))
					{
						countScore++;
					}
				}
			}
			
			
			ps2=con.prepareStatement(SQLQueryConstants.GET_TECH_COURSE_ID);
			ps2.setInt(1, userId);
			ps2.setInt(2, assessmentId);
			rs2=ps2.executeQuery();
			Integer techCourseId=null;
			if(rs2!=null){
				while(rs2.next())
				{
					techCourseId=rs2.getInt(1);
				}
			}
			
			Integer attemptNo=null;
			ps3=con.prepareStatement(SQLQueryConstants.GET_COUNT_ATTEMPT_NO);
			ps3.setInt(1,userId);
			ps3.setInt(2, techCourseId);
			rs3=ps3.executeQuery();
			if(rs3!=null){
				while(rs3.next())
				{
					attemptNo=rs3.getInt(1);
				}
			}
			
			
			PreparedStatement ps4=null;
			
			ps4=con.prepareStatement(SQLQueryConstants.INSERT_SCORES);
			ps4.setInt(1, techCourseId);
			ps4.setInt(2, attemptNo);
			ps4.setInt(3, countScore);
			ps4.setInt(4, userId);
			
			insertRow = ps4.executeUpdate();
			
			
			PreparedStatement ps5=null;
			
			ps5=con.prepareStatement(SQLQueryConstants.DELETE_REMAINING_TIME);
			ps5.setInt(1, userId);
			ps5.setInt(2, assessmentId);
			ps5.executeUpdate();
			
			
            PreparedStatement ps9=null;
			
			ps9=con.prepareStatement(SQLQueryConstants.UPDATE_EXAM_STATUS);
			ps9.setString(1, StringConstants._EXAM_STATUS);
			ps9.setInt(2, assessmentId);
			ps9.setInt(3, userId);
			ps9.executeUpdate();
			
			con.commit();
		
			}catch (SQLException e) {
			// TODO Auto-generated catch block
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
		return insertRow;
	}	
	/**
	 * @author Chitranshu Gupta
	 * @param con
	 * @param assessmentId
	 * @param userId
	 * @return String
	 * @throws DatabaseException
	 */
	@Override
	public String getExamStatus(Connection con, Integer assessmentId, Integer userId) throws DatabaseException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String status = null;
		try {
			ps = con.prepareStatement(SQLQueryConstants.GET_EXAM_STATUS);

			ps.setInt(1, assessmentId);
			ps.setInt(2, userId);
			rs = ps.executeQuery();

			if (rs != null) {
			   if (rs.next()) {
			
				   status = rs.getString(1);
				}

			} else {

				throw new DatabaseException("Result Set Not available");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return status;
	}

	/*
	@Override
	public Object calculateScore(Connection con, Integer userId, Integer assessmentId) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}
*/
	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con, AssesmentDTO ad
	 * @return Boolean 
	 * @throws SQLException
	 */


	@Override
	public Boolean addAssessment(Connection con, AssesmentDTO ad) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(ad);
		
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.Add_ASSESSMENT_QUERY);
		//ps.setInt(1,ad.getAssesmentId());
		ps.setString(1, ad.getAssesment());
		ps.setInt(2,ad.getTotalMarks());
		ps.setInt(3,ad.getDurationInMin());
		ps.setDate(4,(java.sql.Date) ad.getDate());
		//not this is long text type
		ps.setString(5,ad.getDescription());
		ps.setInt(6,ad.getAssesmentType().getAssesmentTypeId());
		ps.setInt(7,ad.getCourse().getCourseId());
		ps.setInt(8,ad.getLevel().getLevelId());
		ps.setInt(9,ad.getNoOfStudentsForaSlot());
		ps.setTime(10,ad.getStartTime());
		ps.setTime(11,ad.getEndTime());
		int rs=ps.executeUpdate();
		
		System.out.println("hi dao");
		if(rs==11){
			return true;
		}
		else{
		return false;
		}
	}

	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con, AssesmentDTO ad
	 * @return Boolean 
	 * @throws SQLException
	 */

	@Override
	public Boolean editAssessment(Connection con, AssesmentDTO ad) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
         System.out.println(ad);
		
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.EDIT_ASSESSMENT_DETAILS);
		
		ps.setString(1, ad.getAssesment());
		ps.setInt(2,ad.getTotalMarks());
		ps.setInt(3,ad.getDurationInMin());
		ps.setDate(4,(java.sql.Date) ad.getDate());
		//not this is long text type
		ps.setString(5,ad.getDescription());
		ps.setInt(6,ad.getAssesmentType().getAssesmentTypeId());
		ps.setInt(7,ad.getCourse().getCourseId());
		ps.setInt(8,ad.getLevel().getLevelId());
		ps.setInt(9,ad.getNoOfStudentsForaSlot());
		ps.setTime(10,ad.getStartTime());
		ps.setTime(11,ad.getEndTime());
		ps.setInt(12,ad.getAssesmentId());
		int rs=ps.executeUpdate();
		
		System.out.println("hi dao");
		if(rs==11){
			return true;
		}
		else{
		return false;
		}
	
	}
	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con, assessmentId
	 * @return Boolean 
	 * @throws SQLException
	 */


	@Override
	public Boolean deleteAssessment(Connection con, Integer assessmentId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.DELETE_ASSESSMENT);
		ps.setInt(1,assessmentId);
		int rs=ps.executeUpdate();
		
		System.out.println("hi dao");
		if(rs==1){
			return true;
		}
		else{
		return false;
		}
		
	}

	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con
	 * @return List 
	 * @throws SQLException
	 */

	@Override
	public List<AssesmentTypeDTO> getAssesmentType(Connection con) throws SQLException {
		// TODO Auto-generated method stub
List<AssesmentTypeDTO> list=new ArrayList<AssesmentTypeDTO>();
		
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_ASSESSMENT_TYPE);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			AssesmentTypeDTO ass=new AssesmentTypeDTO();
			Integer assesmentTypeId=rs.getInt(1);
			String assesmentTypeName=rs.getString(2);
			ass.setAssesmentTypeId(assesmentTypeId);
			ass.setAssesmentTypeName(assesmentTypeName);
			list.add(ass);
		}
		
		System.out.println(list);
		return list;
	}

	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con
	 * @return List 
	 * @throws SQLException
	 */
	@Override
	public List<LevelDTO> getLevel(Connection con) throws SQLException {
		// TODO Auto-generated method stub
List<LevelDTO> list=new ArrayList<LevelDTO>();
		
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.Get_level_Query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			LevelDTO lev=new LevelDTO();
			Integer levelId=rs.getInt(1);
			String level=rs.getString(2);
			lev.setLevelId(levelId);
			lev.setLevel(level);
			list.add(lev);
		}
		
		System.out.println(list);
		return list;
	}

	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con
	 * @return List 
	 * @throws SQLException
	 */

	@Override
	public List<CourseDTO> getCourses(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		List<CourseDTO> list=new ArrayList<CourseDTO>();
		
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.Get_Course_Query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			CourseDTO couse=new CourseDTO();
			Integer courseId=rs.getInt(1);
			String course=rs.getString(2);
			couse.setCourseId(courseId);
			couse.setCourse(course);
			list.add(couse);
		}
		
		System.out.println(list);
		return list;
	}

	/**
	 * @author pavan pratap singh b-35
	 * @param Connection con
	 * @return List 
	 * @throws SQLException
	 */
	@Override
	public List<AssesmentDTO> getAssessmentDetailsForEditAction(Connection con) throws DatabaseException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AssesmentDTO> list = new ArrayList<AssesmentDTO>();
		try {
			ps = con.prepareStatement(SQLQueryConstants.GET_ASSESSMENT_DETAILS_For_Edit);
			
			rs = ps.executeQuery();
            Integer assessmentId=null;
			String assessmentName = null;
			Integer assessmentMarks = null;
			Integer assessmentDuration = null;
			Date assessmentDate = null;
			String assessmentDescription = null;
			/**@author  pavan pratap singh*/
			//Integer assesmentTypeId=null;
			String assessmentTypeName=null;
			//Integer courseId=null;
			String courseName=null;
			//Integer levelId=null;
			String levelName=null;
			
			Integer no_of_students_for_a_slot=null;
			Time start_time_of_slots=null;
			Time end_time_slots=null;
			
			String dateSql=null;
			if (rs != null) {
				while (rs.next()) {
					assessmentId = rs.getInt(1);
					assessmentName = rs.getString(2);
					assessmentMarks = rs.getInt(3);
					assessmentDuration = rs.getInt(4);
					assessmentDate = rs.getDate(5);
					/*String stringDate=DateUtil.sqlDateToString( assessmentDate);
					System.out.println(stringDate);*/
					assessmentDescription = rs.getString(6);
					/*assesmentTypeId=rs.getInt(7);
					courseId=rs.getInt(8);
					levelId=rs.getInt(9);*/
					no_of_students_for_a_slot=rs.getInt(7);
					start_time_of_slots=rs.getTime(8);
					end_time_slots=rs.getTime(9);
					assessmentTypeName=rs.getString(10);
					courseName=rs.getString(11);
					levelName=rs.getString(12);
					
                    
					AssesmentDTO dto = new AssesmentDTO();
					dto.setAssesmentId(assessmentId);
					dto.setAssesment(assessmentName);
					dto.setTotalMarks(assessmentMarks);
					dto.setDurationInMin(assessmentDuration);
					dto.setDate(assessmentDate);
					dto.setDescription(assessmentDescription);
					//set the assesment Type
					AssesmentTypeDTO ast=new AssesmentTypeDTO();
					//ast.setAssesmentTypeId(assesmentTypeId);
					ast.setAssesmentTypeName(assessmentTypeName);
					dto.setAssesmentType(ast);
					//set the course
					CourseDTO co=new CourseDTO();
					//co.setCourseId(courseId);
					co.setCourse(courseName);
					dto.setCourse(co);
					//set the level
					LevelDTO le=new LevelDTO();
					//le.setLevelId(levelId);
					le.setLevel(levelName);
					dto.setLevel(le);
					dto.setNoOfStudentsForaSlot(no_of_students_for_a_slot);
					dto.setStartTime(start_time_of_slots);
					dto.setEndTime(end_time_slots);
					

					list.add(dto);
				}
				
				System.out.println(list);
				
			} else {

				throw new DatabaseException("Result Set Not available");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return list;
	}

	/**
	 * @author Ashish Kumar
	 * **/
	@Override
	public List<ScoreBean> getScores(Connection con, Integer userId) throws DatabaseException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ScoreBean> list = new ArrayList<ScoreBean>();
		try {
			ps = con.prepareStatement(SQLQueryConstants.GET_USER_SCORES);
			ps.setInt(1, userId);
			//ps.setInt(2, userId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ScoreBean scoreBean = new ScoreBean();
				scoreBean.setAttemptno(rs.getInt(1));
				scoreBean.setFirstName(rs.getString(2));
				scoreBean.setLastName(rs.getString(3));
				scoreBean.setEmail(rs.getString(4));
				scoreBean.setMobileNo(rs.getString(5));
				scoreBean.setImage(rs.getString(6));
				scoreBean.setMarks(rs.getInt(7));
				scoreBean.setTechnology(rs.getString(8));
				scoreBean.setCourse(rs.getString(9));
				scoreBean.setAssessmentName(rs.getString(10));
				scoreBean.setTotalMarks(rs.getInt(11));
				list.add(scoreBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	/**
	 * @author Rohit Kumar Singh b35
	 * method to get all AssesmentTypeNames from DataBase table tbl_assessment_type
	 * @param con
	 * @return ArrayList of DTO type
	 * @throws DatabaseException
	 */
	
	@Override
	public ArrayList<Object> getAssessmentTypeName(Connection con) throws DatabaseException {
		// TODO Auto-generated method stub
			
		//-------------get ArrayList Object of DTO type---------------------
		ArrayList<Object> list=new ArrayList<Object>();
		
		//--------------getting PreparedStatement object--------------------
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants._SELECT_ASSESMENT_TYPE_NAME);
			
			//---------------------get ResultSet------------------------
			ResultSet result = pstmt.executeQuery();
			
			//------------------AssesmentTypeBean assmentBean--------------------
			while(result.next()){
			//	System.out.println("from DAO "+result.getInt(1)+"-----"+result.getString(2));
			
				//---------------create AssessmentTypeDto class object----------------
				AssesmentTypeDTO asstypedto=new AssesmentTypeDTO();
				
				//-------------setting values into assessmentTypeDto object------------ 
				asstypedto.setAssesmentTypeId(result.getInt(1));
				
				asstypedto.setAssesmentTypeName(result.getString(2));
				 
				//--------------adding each dto object to ArrayList--------------------
				list.add(asstypedto);
												
			}//while
			
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("ERROR NEEDS ASSESSMENT TYPE ID OR ASSESSMENT NAMES ARE NOT AVAILABLE");
		}//catch
		
		return list;
	}//getAssessmentTypeName(con,assmentBean) method
	
	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to get all AssesmentNames from DataBase table tbl_assessment on basis of assessment_type_name or id
	 * @param con
	 * @param assesmentTypeId
	 * @return ArrayList of DTO type
	 * @throws DatabaseException
	 */

	@Override
	public ArrayList<Object> getAssessmentName(Connection con,Integer assesmentTypeId,Integer userId) throws DatabaseException {
		// TODO Auto-generated method stub
				
		//----------------create ArrayList Object of DTO type-----------------------
		ArrayList<Object> listDto=new ArrayList<Object>();
	//	CourseDTO courseDto=new CourseDTO();
		
		//------------creating AssessmentDto object-------------
		//AssesmentDTO assmentDto=new AssesmentDTO();
		
		//------------------define class object local variables--------------------
		Integer assId=null;
		String assmentName=null;
		Date assdate=null;
		Integer courseId=null;
		
		//---------------------create PreparedStatement object--------------------
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants._SELECT_ASSESSMENT_NAME);		//fetching assessmentNames
		
			//----------------------set parameter value----------------------
			pstmt.setInt(1,assesmentTypeId);
			pstmt.setInt(2,userId);
			
			//---------------execute query and get ResultSet object-----------
			ResultSet result=pstmt.executeQuery();
						
			while(result.next()){
			
				
				//-------------getting values from database------------------
				assId=result.getInt(1);
				assmentName=result.getString(2);
				assdate=result.getDate(3);
				courseId=result.getInt(4);
				
				SimpleDateFormat adf = new SimpleDateFormat("yyyy");
				String assYear =adf.format(assdate);
				int assmYear=Integer.parseInt(assYear);

				adf = new SimpleDateFormat("MM");
				String assMon =adf.format(assdate);
				int assmMon=Integer.parseInt(assMon);

				adf = new SimpleDateFormat("dd");
				String assDate =adf.format(assdate);
				int assmDate=Integer.parseInt(assDate);
				
				long dt=System.currentTimeMillis();
				Date aa=new Date(dt);
				SimpleDateFormat cf = new SimpleDateFormat("yyyy");
				String curentYear =cf.format(aa);
				int curYear=Integer.parseInt(curentYear);

				cf = new SimpleDateFormat("MM");
				String curentMon =cf.format(aa);
				int curMon=Integer.parseInt(curentMon);

				cf = new SimpleDateFormat("dd");
				String curentDate =cf.format(aa);
				int curDate =Integer.parseInt(curentDate);
			
				
				if(aa.before(assdate)){
					
					//------------creating AssessmentDto object and setting values-------------
					AssesmentDTO assmentDto=new AssesmentDTO();	
					CourseDTO courseDto=new CourseDTO();
					
					assmentDto.setAssesmentId(assId);
					assmentDto.setAssesment(assmentName);
					
					//converting Integer courseId into CourseDto Type
					courseDto.setCourseId(courseId);
					assmentDto.setCourse(courseDto);
					
					//----------------add objects to List---------------------
				//	listDto.add(courseId);
					listDto.add(assmentDto);
					
				}//if
				else{
				//	System.out.println("Assessment has expired");
				}//else
				
				
				//----------------add objects to List---------------------
			//	listDto.add(assmentDto);
				
			}//while
			
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("ERROR NEEDS ASSESSMENT ID or SOME THING WENT WRONG");
		}//catch
	//	System.out.println("listdto...."+listDto);
		return listDto;
	}//getAssessmentName(con) method

	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to divide Time into slots on basis of assessment startTime,endTime and time duration (all are taken from DataBase)
	 * @param con
	 * @param assesmentId
	 * @return ArrayList of Object type
	 * @throws DatabaseException
	 */

	@Override
	public ArrayList<Object> getTimeSlots(Connection con,Integer assesmentId) throws DatabaseException {
		// TODO Auto-generated method stub
	
		
		//------------creating ArrayList object-----------------
		ArrayList<Object> timeDto=new ArrayList<Object>();
					
		//-----------create PreparedStatement object------------- 
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants._CREATE_TIME_SLOTS);		//select query to fetch records
			
			//---------------set parameter value-----------------
			pstmt.setInt(1,assesmentId);
			
			//-----executing query and getting ResultSet object-----
			ResultSet result=pstmt.executeQuery();
			
			//------------declaring and initializing variables-----
			Integer timeDuration=null;
			Time strtTime=null;
			Time endTime=null;
						
			while(result.next()){
			
				//---------getting objects from database--------------
				 timeDuration=result.getInt(1);
				 strtTime=result.getTime(2);
				 endTime=result.getTime(3);
				 
				//----------------setting values to dto object
				 timeDto.add(timeDuration);
				 timeDto.add(strtTime);
				 timeDto.add(endTime);
				 
			}//while
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("ERROR NEEDS ASSESSMENT ID or SOME THING WENT WRONG");
		}
		
		return timeDto;
	}//getTimeSlots(con,assmentid)

	
	/**
	 * @author Rohit Kumar Singh b35
	 * method to select one time slot per Assessment not same for another
	 * @return ArrayList
	 * @throws DatabaseException
	 */

	@Override
	public ArrayList<Object> bookSelectedSlot(Connection con,BookedSlotsBean bukBean) throws DatabaseException {
		// TODO Auto-generated method stub
	//	System.out.println("in method");
				 
		
		//creating ArrayList object
		ArrayList<Object> arrIntObj=new ArrayList<Object>();
		
		//create PreparedStatement object
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		
		
		Integer maxNoOfAttempts =0;
		Integer studentAttemptsDone =0;
		
		//------------create PreparedStatement Object and getting auto GeneratedKeys----------------
		try {
				
			
			pstmt1=con.prepareStatement(SQLQueryConstants._SELECT_NO_OF_ATTEMPTS);
			pstmt1.setInt(1, bukBean.getUserId());
			pstmt1.setInt(2, bukBean.getAssesmentId());
			
			ResultSet rs=pstmt1.executeQuery();
			
			while (rs.next()) {				
				studentAttemptsDone = rs.getInt(1);
				maxNoOfAttempts=rs.getInt(2);
				
				//adding object to ArrayList
				arrIntObj.add(studentAttemptsDone);
				arrIntObj.add(maxNoOfAttempts);
		
			}//while
			
			Time userTime = bukBean.getSlotTime();
			
		if(studentAttemptsDone<maxNoOfAttempts){
			if(userTime!=null){
				
				Time tblTime=validationForBookedSlots(con,bukBean.getUserId(),bukBean.getAssesmentId());
			if(userTime==tblTime || tblTime!=null){
			
			}//if
			else{
			pstmt=con.prepareStatement(SQLQueryConstants._BOOK_SELECTED_SLOT,PreparedStatement.RETURN_GENERATED_KEYS);
			
			//---------------setting query related parameter values----------------------
			pstmt.setTime(1,userTime);
			pstmt.setInt(2,bukBean.getAssesmentId());
			pstmt.setInt(3,bukBean.getUserId());
			pstmt.setInt(4,StringConstants._SLOT_INIT_STATUS);
			
			//-----------------executing query to get Response----------------------
			Integer result=pstmt.executeUpdate();
	//		System.out.println("Resultset pstmt.."+result);
		if(result!=null){
				
			//-------------getting DTO class Object-------------------
			BookedSlotsDTO bukDto=new BookedSlotsDTO();
			
			//------------getting GeneratedKeys-----------------------
		//	ResultSet bukedSlot=pstmt.getGeneratedKeys(); 
				
				//access slots and set to dto object
			/*	if(bukedSlot.next()){
					
					bukDto.setBookslotsId(bukedSlot.getInt(1));
					
				}//if
				else{
					System.out.println("SORRY.... NO SLOTS ARE SELECTED");
				}//else
*/				
				bukDto.setSlotTime(userTime);
			}//if
			}//else
	/*	}//if
		else{
			
			throw new DatabaseException("You have already Booked this");
		}//else
		}//while
*/
			}
		}//if
			else{
				throw new DatabaseException("You have attempted max time.");
			}//else
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("SORRY.... NO SLOTS ARE SELECTED");
		}//catch
		
	//	return bukDto.getBookslotsId();
	//	return studentAttemptsDone;
		return arrIntObj;
	}//bookSelectedSlot(Connection,Bean obj)	

	/**
	 * @author Rohit Kumar Singh b35
	 * method to provide info about selected and non-selected time slot for each user on basis of assessment
	 * @param Connection,userID,assmentID
	 * @return java.sql.Time
	 * @throws DatabaseException 
	 */
	@Override
	public Time validationForBookedSlots(Connection con,Integer userId,Integer assmentId) throws DatabaseException {
		// TODO Auto-generated method stub
	//	System.out.println("in AssmentDaoImpl : validation");
		
		
		//---------------declare & initialize java.sql.Time variable--------------------
		Time bookedSlot=null;
				 
		try {
			//-------------create PreparedStatement object-----------------------
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants._SELECT_BOOKED_SLOT);
			
			//------------------set parameter values-----------------------
			pstmt.setInt(1,userId);
			pstmt.setInt(2,assmentId);
			
			//--------------------execute query--------------------------
			ResultSet result = pstmt.executeQuery();
			
			//-------------------retrieve object/data from table--------------------
			while(result.next()){
				
				 bookedSlot = result.getTime(1);
				 
			//	 System.out.println("bookedslot is >>> "+bookedSlot);
				 
			}//while			
			
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(" FROM VALIDATIONFORBOOKEDSLOTS : SOME DATABASE EXCEPTION IS ARISED ");
		}//catch
				
		return bookedSlot;
		
	}//validationForBookedSlots(Connection con,Integer userId,Integer assmentId)
	
	
	/**
	 * @author Rohit Kumar Singh b35
	 */
	
	@Override
	public ArrayList<Object> getBookedSlotDetails(Connection con, Integer assessmentId, Integer userID) throws DatabaseException {
		// TODO Auto-generated method stub
		
		//-----------------------------getting ArrayList object---------------------------------------
		ArrayList<Object> arrListObj = new ArrayList<Object>();
		Boolean bkdStatus;
		//--------------------------create PreparedStatement object -----------------------------------
		try {
			PreparedStatement pstmt=con.prepareStatement(SQLQueryConstants._SELECT_BOOKED_SLOT_DETAILS);
			
			//------------------------set parameter values--------------------------------------------
			pstmt.setInt(1,userID);
			pstmt.setInt(2,assessmentId);
			
			//--------------------------execute query---------------------------------------------------
			ResultSet rs=pstmt.executeQuery();
		//	System.out.println("result set booked details...... "+rs);
			
			if(rs.next()){
				
				bkdStatus=true;
				//-----------------getting values from database table tbl_booked_slots-----------------
				
				String assmentName = rs.getString(1);
				Integer boodedSlotId = rs.getInt(2);
				Time bookedSlotTime = rs.getTime(3);
				String attemptStatusId = rs.getString(4);
				
				String strbookedSlotTime = bookedSlotTime.toString();
			//	System.out.println("=====>assname "+assmentName+"--------bkd slot "+boodedSlotId+".........bkd time "+bookedSlotTime+"............atmpt "+attemptStatusId);
				
				//----------------conversion of String time into java.sql.Time-------------
				SimpleDateFormat dtformat=new SimpleDateFormat("HH:mm:ss");
				
				try {
					java.sql.Date d= new java.sql.Date(dtformat.parse(strbookedSlotTime).getTime());
					Time tt=new Time(d.getTime()) ;
					arrListObj.add(tt);
				//	System.out.println("-------------"+tt);				
				}//try
				catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				//	System.out.println("Parsing Fails");
				}//catch

				
				//------------------------------add all to ArrayList object----------------------------
				arrListObj.add(boodedSlotId);
				arrListObj.add(bkdStatus);
				arrListObj.add(assmentName);			
				arrListObj.add(attemptStatusId);
				
			}//if
			else{
				bkdStatus=false;
				arrListObj.add(bkdStatus);
			}//else
			
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("DATA NOT FOUND IN DATA BASE");
		}//catch
		
		return arrListObj;
		
	}//getBookedDetails()
	/**
	 * @author pavan pratap singh b-35
	 * @param assessmentId
	 * @return
	 * @throws DatabaseException
	 */

	@Override
	public AssesmentDTO getAssessmentDetailsForEdit(Connection con, Integer assessmentId) throws DatabaseException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AssesmentDTO> list = new ArrayList<AssesmentDTO>();
		try {
			ps = con.prepareStatement(SQLQueryConstants.GET_ASSESSMENT_INDIVIDUAL_DETAILS_For_Edit);
			ps.setInt(1, assessmentId);
			rs = ps.executeQuery();
            
			String assessmentName = null;
			Integer assessmentMarks = null;
			Integer assessmentDuration = null;
			Date assessmentDate = null;
			String assessmentDescription = null;
			/**@author  pavan pratap singh*/
			//Integer assesmentTypeId=null;
			String assessmentTypeName=null;
			//Integer courseId=null;
			String courseName=null;
			//Integer levelId=null;
			String levelName=null;
			
			Integer no_of_students_for_a_slot=null;
			Time start_time_of_slots=null;
			Time end_time_slots=null;
			
			String dateSql=null;
			
			AssesmentDTO dto = new AssesmentDTO();
			
			if (rs != null) {
				if (rs.next()) {
					assessmentId = rs.getInt(1);
					assessmentName = rs.getString(2);
					assessmentMarks = rs.getInt(3);
					assessmentDuration = rs.getInt(4);
					assessmentDate = rs.getDate(5);
					/*String stringDate=DateUtil.sqlDateToString( assessmentDate);
					System.out.println(stringDate);*/
					assessmentDescription = rs.getString(6);
					/*assesmentTypeId=rs.getInt(7);
					courseId=rs.getInt(8);
					levelId=rs.getInt(9);*/
					no_of_students_for_a_slot=rs.getInt(7);
					start_time_of_slots=rs.getTime(8);
					end_time_slots=rs.getTime(9);
					assessmentTypeName=rs.getString(10);
					courseName=rs.getString(11);
					levelName=rs.getString(12);
					
					dto.setAssesmentId(assessmentId);
					dto.setAssesment(assessmentName);
					dto.setTotalMarks(assessmentMarks);
					dto.setDurationInMin(assessmentDuration);
					dto.setDate(assessmentDate);
					dto.setDescription(assessmentDescription);
					//set the assesment Type
					AssesmentTypeDTO ast=new AssesmentTypeDTO();
					//ast.setAssesmentTypeId(assesmentTypeId);
					ast.setAssesmentTypeName(assessmentTypeName);
					dto.setAssesmentType(ast);
					//set the course
					CourseDTO co=new CourseDTO();
					//co.setCourseId(courseId);
					co.setCourse(courseName);
					dto.setCourse(co);
					//set the level
					LevelDTO le=new LevelDTO();
					//le.setLevelId(levelId);
					le.setLevel(levelName);
					dto.setLevel(le);
					dto.setNoOfStudentsForaSlot(no_of_students_for_a_slot);
					dto.setStartTime(start_time_of_slots);
					dto.setEndTime(end_time_slots);
					

				}
				
				return dto;
				
			} else {

				throw new DatabaseException("Result Set Not available");
			}

		} catch (SQLException e) {
			
			throw new DatabaseException(e.getMessage());
		}
	}
	
}
