/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nacre.online_assesment.dao_i.PlacementsDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.PlacementsDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.JobTypeDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostBean;
import com.nacre.online_assesment.form_bean.JobRoundBean;


import java.io.PrintWriter;
import java.util.List;

import com.nacre.online_assesment.dao_i.PlacementsDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.PlacementsDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.exception.DatabaseException;

import com.nacre.online_assesment.service_i.PlacementsServicei;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class PlacementsServiceimpl implements PlacementsServicei {
	


	@Override
	public ArrayList<JobPostingDTO> getJobPostDetail() throws DatabaseException {
		PlacementsDaoi jobPostDao = new PlacementsDaoimpl();
		Connection con = DbUtil.getConnection();
		ArrayList<JobPostingDTO> jobPostDto = jobPostDao.getJobPostDetail(con);
		return jobPostDto;
	}

	@Override
	public ArrayList<InterviewRoundDTO> getRoundDetails(JobPostBean jpb) throws DatabaseException {
		PlacementsDaoi jobRoundDao = new PlacementsDaoimpl();
		Connection con = DbUtil.getConnection();
		ArrayList<InterviewRoundDTO> jobRoundDto = jobRoundDao.getRoundDetails(jpb,con);
		return jobRoundDto;
	}
	
	public ArrayList<UserDTO> getUserDetail(JobRoundBean jrb) throws DatabaseException{
		PlacementsDaoi userDetailDao = new PlacementsDaoimpl();
		Connection con = DbUtil.getConnection();
		ArrayList<UserDTO> userDetailDto = userDetailDao.getUserDetail(jrb,con);
		return userDetailDto;
		
	}
	public ArrayList<ArrayList> getFirstRoundDetail(JobRoundBean jrb) throws DatabaseException{
		
		PlacementsDaoi userFirstRoundDao = new PlacementsDaoimpl();
		Connection con = DbUtil.getConnection();;
		ArrayList<ArrayList> userFirstRoundDto = userFirstRoundDao.getFirstRoundDetail(jrb,con);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userFirstRoundDto;
		
	}

	

	public String insertShortlistDetails(Integer roundID, String[] shortList) throws ClassNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		PlacementsDaoi shortlistDetailDao = new PlacementsDaoimpl();
		Connection con =DbUtil.getConnection(); 
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shortlistDetailDao.insertShortlistDetails(roundID,shortList,con);
		
	}
	
	public Integer insertNextRound(InterviewRoundDTO interviewRoundDTO) throws DatabaseException {
		
		PlacementsDaoi nextRoundDetailDao = new PlacementsDaoimpl();
		Connection con =DbUtil.getConnection(); 
		/*try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return nextRoundDetailDao.insertShortlistDetails(interviewRoundDTO,con);
	}

	public boolean insertShortlist(Integer roundID, Integer[] userId) throws DatabaseException {
		PlacementsDaoi shortlistDetailDao = new PlacementsDaoimpl();
		Connection con =DbUtil.getConnection(); 
		
		return shortlistDetailDao.insertShortlist(roundID,userId,con);
	}

	@Override
	public Integer getClient(Integer jobpostID) throws DatabaseException {
		PlacementsDaoi clientDetailDao = new PlacementsDaoimpl();
		Connection con = DbUtil.getConnection();
		
		return clientDetailDao.getClient(jobpostID,con);
	}

	@Override
	public boolean insertPlacementDetail(PlacementDTO pldto, Integer[] userId, Integer clientId) throws DatabaseException {
		PlacementsDaoi shortlistDetailDao = new PlacementsDaoimpl();
		Connection con =DbUtil.getConnection(); 
		return shortlistDetailDao.insertPlacementDetail(pldto,userId,clientId,con);
	}

	@Override
	public ArrayList<ArrayList> getPlacementDetail(JobPostBean jpb) throws DatabaseException {
		PlacementsDaoi placementDao = new PlacementsDaoimpl();
		Connection con = DbUtil.getConnection();
		ArrayList<ArrayList> placmentRoundDto = placementDao.getPlacementDetail(jpb,con);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return placmentRoundDto;
	}

	@Override
	public boolean UpdatUserStatus(Integer interviewRoundId, Integer[] userId) throws DatabaseException {
		PlacementsDaoi updateStatusDao = new PlacementsDaoimpl();
		Connection con =DbUtil.getConnection(); 
		return updateStatusDao.UpdatUserStatus(interviewRoundId,userId,con);
	}

	@Override
	public boolean UpdateUserTableUserStatus(Integer[] userId) throws DatabaseException {
		PlacementsDaoi updateStatusDao = new PlacementsDaoimpl();
		Connection con =DbUtil.getConnection(); 
		return updateStatusDao.UpdateUserTableUserStatus(userId,con);
	}

	@Override
	public ArrayList<JobTypeDTO> getJobTypeDetails() throws DatabaseException {
		PlacementsDaoi jobTypeDao = new PlacementsDaoimpl();
		Connection con = DbUtil.getConnection();
		ArrayList<JobTypeDTO> jobtypeDto = jobTypeDao.getJobTypeDetails(con);
		return jobtypeDto;
	}

	@Override
	public Integer getRoundNo(Integer roundNo) throws DatabaseException {
		PlacementsDaoi roundNoDao = new PlacementsDaoimpl();
		Connection con = DbUtil.getConnection();
		return roundNoDao.getRoundNo(roundNo,con);
	}


}
