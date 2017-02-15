/**
 * 
 */
package com.nacre.online_assesment.dao_i.dao_impl;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import java.sql.Statement;
//import java.util.ArrayList;


import com.nacre.online_assesment.dao_i.PlacementsDaoi;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.JobTypeDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.dto.StatusDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.form_bean.JobPostBean;
import com.nacre.online_assesment.form_bean.JobRoundBean;
import com.nacre.online_assesment.dao_i.PlacementsDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.StringConstants;

/**PlacementsDaoimpl
 * @author Vijay Kumar Reddy K
 *
 */
public class PlacementsDaoimpl implements PlacementsDaoi{

	String query1 ="select job_posting_id,description from tbl_job_posting;";
	JobPostingDTO postdto;
	InterviewRoundDTO rounddto;
	Integer roundId;
	
	
	
		@Override
	public ArrayList<JobPostingDTO> getJobPostDetail(java.sql.Connection con) {
			ArrayList<JobPostingDTO> list = new ArrayList<JobPostingDTO>();
			 try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query1);
					
					while(rs.next()){
						 postdto = new JobPostingDTO();
						
						postdto.setJobPostId(rs.getInt("job_posting_id"));
						postdto.setDescription(rs.getString("description"));
						list.add(postdto);
						
					}
					
				} catch (SQLException e) {

					e.printStackTrace();
				}
			
			return list;
		
	}

	@Override
	public ArrayList<InterviewRoundDTO> getRoundDetails(JobPostBean jpb, java.sql.Connection con) {
		String query="select interview_round_id,description from tbl_interview_round where job_posting_id=?;";
		//String query="select * from tbl_interview_round;";
		
		ArrayList<InterviewRoundDTO> roundlist = new ArrayList<InterviewRoundDTO>();
		 try {
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1,jpb.getJob_Post_Id());
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()){
					InterviewRoundDTO rounddto = new InterviewRoundDTO();
					rounddto.setRoundId(rs.getInt("interview_round_id"));
					rounddto.setDescription(rs.getString("description"));
					
					roundlist.add(rounddto);
				}
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
		
		return roundlist;
	}

	@Override
	public ArrayList<UserDTO> getUserDetail(JobRoundBean jrb, java.sql.Connection con) {
		String query="select user.user_id,user.first_name,user.last_name,user.email,user.image "+ 
				"from tbl_user user "+
				"join tbl_elegible_student eligible "+
				"on user.user_id = eligible.user_id and eligible.status_id='3' "+
				"join tbl_interview_round rounds "+
				"on eligible.interview_round_id = rounds.interview_round_id "+
					"and rounds.interview_round_id = ?;";
	ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	try {
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, jrb.getInterview_round_id());
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			UserDTO userDTO = new UserDTO();
			userDTO.setUserid(rs.getInt("user_id"));
			userDTO.setFirstname(rs.getString("first_name"));
			userDTO.setLastname(rs.getString("last_name"));
			userDTO.setEmail(rs.getString("email"));
			userList.add(userDTO);
			
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}
	
	return userList;

	}

	@Override
	public ArrayList<ArrayList> getFirstRoundDetail(JobRoundBean jrb, java.sql.Connection con) {
		String query="select user.user_id,user.first_name,user.last_name,user.email,user.image,status.`status` "+ 
				"from tbl_user user "+
				"join tbl_elegible_student eligible "+
				"on user.user_id = eligible.user_id and eligible.interview_round_id =? "+
				"join tbl_status status "+
				"on status.status_id = eligible.status_id where eligible.status_id not in (?);";

	ArrayList<ArrayList> mainList = new ArrayList<ArrayList>();
	ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	ArrayList<StatusDTO> stList = new ArrayList<StatusDTO>(); 
	try {
		PreparedStatement preparedStatement = con.prepareStatement(query);
		
		preparedStatement.setInt(1, jrb.getInterview_round_id());
		preparedStatement.setInt(2,StringConstants._USER_PLACED_STATUS_ID);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			UserDTO userDTO = new UserDTO();
			StatusDTO statusDTO =new StatusDTO();
			userDTO.setUserid(rs.getInt("user_id"));
			userDTO.setFirstname(rs.getString("first_name"));
			userDTO.setLastname(rs.getString("last_name"));
			userDTO.setEmail(rs.getString("email"));
			userDTO.setImage(rs.getString("image"));
			statusDTO.setStatus(rs.getString("status"));
			stList.add(statusDTO);
			userList.add(userDTO);

		mainList.add(userList);

		mainList.add(stList);
		
	} 
	}
	catch (SQLException e) {

		e.printStackTrace();
	}
	return mainList;
	

	}

	@Override
	public String insertShortlistDetails(Integer roundID, String[] shortList, java.sql.Connection con)
			throws ClassNotFoundException {
String query ="insert into tbl_elegible_student(interview_round_id,user_id,status_id) values(?,?,?)";
		
		System.out.println("fromdao"+roundID);
		roundId = roundID + 1;
		PreparedStatement preparedStatement =null;
		
		try {
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			for(int i=0;i<shortList.length;i++){
				preparedStatement.setInt(1,roundId);
				preparedStatement.setInt(2, Integer.parseInt(shortList[i]));
				preparedStatement.setInt(3, 6);
				
				
				
			}
			int[] count =preparedStatement.executeBatch();
			for(int i=0;i<=count.length-1;i++){
                System.out.println(count);
            }
			con.commit();
			

			return "successfully Inserted";
			
		} catch (SQLException e) {
            try {
                con.rollback();
        
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
           
            e.printStackTrace();
            return null;
            
		}
		

	}
	
	@Override
	public Integer insertShortlistDetails(InterviewRoundDTO interviewRoundDTO, java.sql.Connection con) {
	String query ="insert into tbl_interview_round(round_no,job_posting_id,description,date,status_id,address_id) "+
			 	"values(?,?,?,?,?,(select address_id from tbl_client_address clientadd join tbl_job_posting job on clientadd.client_address_id= job.client_address_id "+
			 	"where job.job_posting_id =?));";
	PreparedStatement preparedStatement =null;
	System.out.println("dao page date :"+interviewRoundDTO.getDate());

	
	try {
		con.setAutoCommit(false);
		preparedStatement = con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
		
			preparedStatement.setInt(1,interviewRoundDTO.getRoundNo());
			preparedStatement.setInt(2,interviewRoundDTO.getJobPostId());
			preparedStatement.setString(3, interviewRoundDTO.getDescription());
			preparedStatement.setDate(4,interviewRoundDTO.getDate());
			preparedStatement.setInt(5, StringConstants._USER_ROUND_STATUS_ID);
			preparedStatement.setInt(6,interviewRoundDTO.getJobPostId());
			
			Integer interRoundId=null;
			int i=preparedStatement.executeUpdate();
			con.commit();
		
	if(i!=0){
				
				ResultSet rs =preparedStatement.getGeneratedKeys();
				if(rs.next()){
					interRoundId= rs.getInt(1);
					return interRoundId;
				}else{
					
					return null;
				}
			}else{
				
				return null;
			}
		
		
	} catch (SQLException e) {
        try {
            con.rollback();
    
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
       
        e.printStackTrace();
       
        return null;
	}
	
	}
	



	@Override
	public boolean insertShortlist(Integer roundID2, Integer[] userId, java.sql.Connection con) {
		String query ="insert into tbl_elegible_student(interview_round_id,user_id,status_id) values(?,?,?);";
		//Integer roundId = roundID2 + 1;
		//System.out.println(roundId);
		for(int i=0;i<userId.length;i++){
			
			System.out.println(userId[i]);
		}
		
		PreparedStatement preparedStatement =null;
		
		try {
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			for(int i=0;i<userId.length;i++){
				preparedStatement.setInt(1,roundID2);
				preparedStatement.setInt(2,userId[i]);
				preparedStatement.setInt(3, StringConstants._USER_ROUND_STATUS_ID);
				preparedStatement.addBatch();
			}
			int[] count =preparedStatement.executeBatch();
			for(int i=0;i<=count.length-1;i++){
                System.out.println(count);
            }
			con.commit();
			 	

			return true;
			
		} catch (SQLException e) {
            try {
                con.rollback();
        
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
           
            e.printStackTrace();
            return false;
            
		}
		
	}

	@Override
	public boolean UpdatUserStatus(Integer interviewRoundId, Integer[] userId, java.sql.Connection con) {
		String query = "update tbl_elegible_student set status_id = ? "+
				"where interview_round_id = ? and user_id =?;";
		for(int i=0;i<userId.length;i++){
			
			System.out.println(userId[i]);
		}
		
		PreparedStatement preparedStatement =null;
		
		try {
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			for(int i=0;i<userId.length;i++){
				preparedStatement.setInt(1, StringConstants._USER_PLACED_STATUS_ID);
				preparedStatement.setInt(2, interviewRoundId);
				preparedStatement.setInt(3,userId[i]);
				preparedStatement.addBatch();
			}
			int[] count =preparedStatement.executeBatch();
			for(int i=0;i<=count.length-1;i++){
                System.out.println(count);
            }
			con.commit();
			 	

			return true;
			
		} catch (SQLException e) {
            try {
                con.rollback();
        
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
           
            e.printStackTrace();
            return false;
            
		}

	}

	@Override
	public boolean UpdateUserTableUserStatus(Integer[] userId, java.sql.Connection con) {
		String query = "update tbl_user set status_id = ? "+
				"where user_id =?;";
		for(int i=0;i<userId.length;i++){
	
			System.out.println(userId[i]);
		}

PreparedStatement preparedStatement =null;

try {
	con.setAutoCommit(false);
	preparedStatement = con.prepareStatement(query);
	for(int i=0;i<userId.length;i++){
		preparedStatement.setInt(1, StringConstants._USER_PLACED_STATUS_ID);
		preparedStatement.setInt(2, userId[i]);
		preparedStatement.addBatch();
	}
	int[] count =preparedStatement.executeBatch();
	for(int i=0;i<=count.length-1;i++){
        System.out.println(count);
    }
	con.commit();
	 	

	return true;
	
} catch (SQLException e) {
    try {
        con.rollback();

    } catch (SQLException e1) {
        e1.printStackTrace();
    }
   
    e.printStackTrace();
    return false;
    
}

	}

	@Override
	public ArrayList<JobTypeDTO> getJobTypeDetails(java.sql.Connection con) {
		String query11 ="select * from tbl_job_type;";
		
		ArrayList<JobTypeDTO> jobtypelist = new ArrayList<JobTypeDTO>();
		 try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query11);
				
				while(rs.next()){
					JobTypeDTO jobtypedto = new JobTypeDTO();
					
					jobtypedto.setJobTypeId(rs.getInt("job_type_id"));
					jobtypedto.setJobType(rs.getString("job_type"));
					jobtypelist.add(jobtypedto);
					
				}
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
		
		return jobtypelist;

		

	}

	@Override
	public Integer getClient(Integer jobpostID, java.sql.Connection con) {
		String query="select client.client_id from tbl_client client "+
				 "join tbl_client_address clientaddress "+
				 "on client.client_id = clientaddress.client_id "+
				 "join tbl_job_posting jobposting "+
				 "on clientaddress.client_address_id = jobposting.client_address_id and jobposting.job_posting_id = ?;";
	
	try {
		PreparedStatement preparedStatement = con.prepareStatement(query);
		
		preparedStatement.setInt(1,jobpostID);
		ResultSet rs = preparedStatement.executeQuery();
		
		Integer clientId = null ;
		
		while(rs.next()){
			
			ClientDTO clientDTO = new ClientDTO();
			clientDTO.setClientId(rs.getInt("client_id"));
			clientId = rs.getInt("client_id");
		}
		return clientId;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
	

	}

	@Override
	public boolean insertPlacementDetail(PlacementDTO pldto, Integer[] userId, Integer clientId,java.sql.Connection con) {
		String query = "insert into tbl_placement(selected_date,joining_date,package_per_anum,bond_aggrement_details,job_type_id,user_id,client_id) "+
				"values(?,?,?,?,?,?,?);";

for(int i=0;i<userId.length;i++){
	
	System.out.println(userId[i]);
}

PreparedStatement preparedStatement =null;

try {
	con.setAutoCommit(false);
	preparedStatement = con.prepareStatement(query);
	for(int i=0;i<userId.length;i++){
		preparedStatement.setDate(1, pldto.getSelectedDate());
		preparedStatement.setDate(2, pldto.getJoiningDate());
		preparedStatement.setFloat(3, pldto.getPackage());
		preparedStatement.setString(4, pldto.getBond());
		preparedStatement.setInt(5, pldto.getJobType().getJobTypeId());
		preparedStatement.setInt(6,userId[i]);
		preparedStatement.setInt(7,clientId);
		
		preparedStatement.addBatch();
	}
	int[] count =preparedStatement.executeBatch();
	for(int i=0;i<=count.length-1;i++){
        System.out.println(count);
    }
	con.commit();
	 	

	return true;
	
} catch (SQLException e) {
    try {
        con.rollback();

    } catch (SQLException e1) {
        e1.printStackTrace();
    }
   
    e.printStackTrace();
    return false;
    
}




	}

	@Override
	public ArrayList<ArrayList> getPlacementDetail(JobPostBean jpb, java.sql.Connection con) {
		String QRY_PLACEMENT ="select u.first_name,u.last_name,u.email,u.image, p.bond_aggrement_details,p.package_per_anum,c.client_name from tbl_user u join tbl_placement p on u.user_id=p.user_id join tbl_client c on c.client_id=p.client_id join tbl_client_address ca on  ca.client_id=c.client_id join tbl_job_posting j on j.client_address_id=ca.client_address_id where j.job_posting_id=?";

		ArrayList<ArrayList> mainList = new ArrayList<ArrayList>();
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		ArrayList<PlacementDTO> placementList = new ArrayList<PlacementDTO>(); 
		ArrayList<ClientDTO> clientList = new ArrayList<ClientDTO>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(QRY_PLACEMENT);
			
			preparedStatement.setInt(1, jpb.getJob_Post_Id());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				UserDTO userDTO = new UserDTO();
				PlacementDTO placementDTO = new PlacementDTO();
				ClientDTO clientDTO = new ClientDTO();
				userDTO.setFirstname(rs.getString("first_name"));
				userDTO.setLastname(rs.getString("last_name"));
				userDTO.setEmail(rs.getString("email"));
				userDTO.setImage(rs.getString("image"));
				placementDTO.setBond(rs.getString("bond_aggrement_details"));
				placementDTO.setPackage(rs.getFloat("package_per_anum"));
				clientDTO.setClientName(rs.getString("client_name"));
				userList.add(userDTO);
				placementList.add(placementDTO);
				clientList.add(clientDTO);
			}
			
			mainList.add(userList);

			mainList.add(placementList);
			mainList.add(clientList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mainList;

	}

	@Override
	public Integer getRoundNo(Integer roundNo, java.sql.Connection con) {
		String query="select max(round_no) from tbl_interview_round "
				+"where job_posting_id = ?;";
		//String query="select * from tbl_interview_round;";
		Integer rNo = null;
		
		 try {
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1,roundNo);
				ResultSet rs = preparedStatement.executeQuery();
				
				
				
				while(rs.next()){
					
					rNo = rs.getInt(1);
					
				}
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
		
		return rNo;
	}

	


	
}
