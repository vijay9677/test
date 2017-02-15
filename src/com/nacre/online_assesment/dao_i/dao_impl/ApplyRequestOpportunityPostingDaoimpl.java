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

import com.nacre.online_assesment.dao_i.ApplyRequesrOpprtunityPostingDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.EligibleDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.StatusDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;

/**
 * @author JAY SINGH
 * 
 *
 */
public class ApplyRequestOpportunityPostingDaoimpl implements ApplyRequesrOpprtunityPostingDaoi {
	
	
	
	/**
	 * @author JAY SINGH
	 * @param Connection con,int user_id
	 * @return List<Object>
	 *
	 */
	@Override
	public List<Object> getUserDetails(Connection con,int user_id) throws SQLException, DatabaseException {
    //System.out.println(user_id);
		
		
		
			PreparedStatement ps=con.prepareStatement(SQLQueryConstants.GET_JOB_OPPORTUNITY_REQUEST_DETAILS);
			ps.setInt(1, user_id);
			ps.setInt(2, StringConstants._ALREADY_REQUESTED_FOR_JOB_POST_ID);
			ResultSet rs=ps.executeQuery();
			List list=new ArrayList();
			 
			 List<UserDTO> userList=new ArrayList<UserDTO> ();
			 List<ClientDTO> clientList=new ArrayList<ClientDTO> ();
			 List<JobPostingDTO> jobPostList = new ArrayList<JobPostingDTO>();
				while(rs.next()){
					//System.out.println("client name"+rs.getString(1)+"location"+rs.getString(2)+"description"+rs.getString(3)+"posted date"+rs.getString(4)+"job post id"+rs.getInt(5)+" status"+rs.getInt(6)+"client image"+rs.getString(7)+"client description"+rs.getString(8));
					 
					
					UserDTO userdto=new UserDTO();
					userdto.setFirstname(rs.getString(1));
					userdto.setLastname(rs.getString(2));
					userdto.setImage(rs.getString(3));
					
					ClientDTO clientdto=new ClientDTO();
					clientdto.setClientName(rs.getString(4));
					clientdto.setClientImage(rs.getString(5));
					
					JobPostingDTO jobpostdto=new JobPostingDTO();
					jobpostdto.setDescription(rs.getString(6));
					jobpostdto.setPostDate(rs.getDate(7));
					
					StatusDTO statusdto=new StatusDTO();
					statusdto.setStatus(rs.getString(8));
					
					
					userList.add(userdto);
					jobPostList.add(jobpostdto);
					clientList.add(clientdto);
				//	list1.add(statusdto);
					//System.out.println(userList);
						}
list.add(userList);
	
list.add(jobPostList);
list.add(clientList);
				//System.out.println(">>>"+list);
				return list;
			}

	@Override
	/**
	 * @author JAY SINGH
	 * @param Connection con
	 * @return List
	 *
	 */
	public List getNotifiactions(Connection con) {
		// TODO Auto-generated method stub
		List list=new ArrayList<>();
		List l=new ArrayList<>();
		List jp=new ArrayList<>();
		
		try{
		
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.GET_NOTIFICATION);
	ps.setInt(1, StringConstants._JOB_REQUEST_ID);
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
		String	firstname=rs.getString(1);
		String  lastname=rs.getString(2);
		String  image=rs.getString(3);
		String description=rs.getString(4);
		Integer userid=rs.getInt(5);
			//System.out.println(rs.getString(1));
			//System.out.println(rs.getString(2));
			//System.out.println(rs.getString(3));
			//System.out.println(rs.getString(4));
			
			
			UserDTO u=new UserDTO();
			u.setUserid(userid);
			u.setFirstname(firstname);
			u.setLastname(lastname);
			u.setImage(image);;
			JobPostingDTO job=new JobPostingDTO();
			job.setDescription(description);
			
			l.add(u);
			jp.add(job);
			
		}
		list.add(l);

		list.add(jp);
		//System.out.println(list);
		}
		catch(Exception e){
			//System.out.println(e);
		}
		
		//System.out.println(list);
		return list;
			}

	

	
	



	PreparedStatement psmt;
	Integer interview_round_id=null;


	/**
	 * @author pavan pratap singh batch-35
	 * @param eDto EligibleDTO Object 
	 * @param con  Connection object
	 * @return true or false if Request is send  else Request is not send
	 */
			
	@Override
	public EligibleDTO checkEligibilty(EligibleDTO eDto, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		/**
		 * @author pavan pratap singh batch-35
		 * @param eDto EligibleDTO Object 
		 * @param con  Connection object
		 * @return true or false if Request is send  else Request is not send
		 */
 /**
 * @author pavan pratap singh batch-35
 * useId for getting the value of userId from EligibleDTO eDto
 * jobPostId for getting the value of userId from EligibleDTO eDto
 */
		

		Integer userId=eDto.getUser().getUserid();
		Integer jobPostId=eDto.getRound().getJobPost().getJobPostId();
		System.out.println("hi pavan are checking  in ApplyDaoIMp");
		
		Integer elegibilty=0;
		Integer elegible_studentId=null;
		Integer status_id=null;
		String elible_SqlQuery=SQLQueryConstants.Elegible_query;
		
			psmt=con.prepareStatement(elible_SqlQuery);
			psmt.setInt(1,jobPostId);
			psmt.setInt(2,userId);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				
			System.out.println(rs.getInt(1));
			System.out.println(rs.getInt(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getInt(4));
			elegible_studentId=rs.getInt(3);
			status_id=rs.getInt(4);
			elegibilty=rs.getInt(1);
			interview_round_id=rs.getInt(1);
			
			
			
			EligibleDTO elegible_student_id=new EligibleDTO();
			elegible_student_id.setEligibleStudId(elegible_studentId);
			StatusDTO status=new StatusDTO();
			status.setStatusId(status_id);
			elegible_student_id.setStatus(status);
			System.out.println(elegible_student_id.getEligibleStudId());
			System.out.println(elegible_student_id.getStatus().getStatusId());
			return elegible_student_id;
			}else{
				return null;
				
			}
			
			
			
			
	}
 
	
/**
 * @author pavan
 * @param eDto EligibleDTO Object 
 * @param con  Connection object
 * @return true or false if Request is send  else Request is not send
 */


	@Override
	public Boolean requestForJob(EligibleDTO eDto, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		//System.out.println("hi pavan are not elegible for this job");
		
		/**
		 * @author pavan
		 * 
		 * @ requestForJob_SqlQuery for holding the sql Request_job_query Query
		 */
		String requestForJob_SqlQuery=SQLQueryConstants.Request_job_query;
		
		Integer userId=eDto.getUser().getUserid();
		Integer jobPostId=eDto.getRound().getJobPost().getJobPostId();
		psmt=con.prepareStatement(requestForJob_SqlQuery);
		psmt.setInt(1,jobPostId);
		psmt.setInt(2,userId);
		
		/**
		 * @author pavan
		 * 
		 * @requestResult checking  any update is doing or not
		 */
		int requestResult=psmt.executeUpdate();
	
		if(requestResult==1){
			//System.out.println("record inserted");
			return true;
		}
		else{
			//System.out.println("record not inserted");
			return false;
		}
	
		
	}
	
/**
 * @author pavan
 * @param eDto EligibleDTO Object 
 * @param con  Connection object
 * @return true or false if Updated or not updated
 */
@Override
	public Boolean applyForJob(EligibleDTO eDto, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		/**
		 * @author pavan
		 * applyJob_SqlQuery for holding the sql Query
		 * 
		 */
		String applyJob_SqlQuery=SQLQueryConstants.Apply_job_query;
		//System.out.println("hi pavan are elegible for this job");
		/**
		 * @author pavan
		 * 
		 */
		//Boolean checkStatus=checkAvailabeForApply();
		
		/**
		 * @author pavan 
		 * @variavle get the eleigble studentId 
		 */
		Integer elegibleStdId=eDto.getEligibleStudId();
	
	    psmt=con.prepareStatement(applyJob_SqlQuery);
		psmt.setInt(1,elegibleStdId);
		
		/**
		 * @author pavan
		 * result is variable for checking result is updating or not
		 */
		int result=psmt.executeUpdate();
		//System.out.println("hi pavan now you are elegible for this job");
		if(result==1){
			//System.out.println("record inserted");
			
			return true;
		}
		else{
			//System.out.println("record not inserted");
			
			
			return false;
		}
	}

	
		
	}

	

	


