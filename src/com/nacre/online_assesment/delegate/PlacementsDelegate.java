/**
 * 
 */
package com.nacre.online_assesment.delegate;

import java.util.ArrayList;


import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.JobTypeDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostBean;
import com.nacre.online_assesment.form_bean.JobRoundBean;
import com.nacre.online_assesment.service_i.PlacementsServicei;
import com.nacre.online_assesment.service_i.service_impl.PlacementsServiceimpl;

import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.PlacementsServicei;
import com.nacre.online_assesment.service_i.service_impl.PlacementsServiceimpl;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class PlacementsDelegate {
		
	public ArrayList<JobPostingDTO> getJobDetails() throws DatabaseException{
		PlacementsServicei jobpostdetail = new PlacementsServiceimpl();
		
		ArrayList<JobPostingDTO> joblist = jobpostdetail.getJobPostDetail();
		return joblist;
	}
	
	public ArrayList<InterviewRoundDTO> getRoundDetails(JobPostBean jpb) throws DatabaseException{
		PlacementsServicei jobRounddetail = new PlacementsServiceimpl();
		
		ArrayList<InterviewRoundDTO> roundlist = jobRounddetail.getRoundDetails(jpb);
		return roundlist;
	}
	
	public ArrayList<UserDTO> getUserDetail(JobRoundBean jrb) throws DatabaseException{
		PlacementsServicei userRounddetail = new PlacementsServiceimpl();
		
		ArrayList<UserDTO> userDetailList = userRounddetail.getUserDetail(jrb);
		return userDetailList;
	}
	
	public ArrayList<ArrayList> getFirstRoundDetail(JobRoundBean jrb) throws DatabaseException{
		PlacementsServicei userFirstRounddetail = new PlacementsServiceimpl();
		
		ArrayList<ArrayList> userFirstDetailList = userFirstRounddetail.getFirstRoundDetail(jrb);
		return userFirstDetailList;
	}

	public String insertShortlistDetails(Integer roundID, String[] shortList) throws ClassNotFoundException, DatabaseException {
		PlacementsServicei shorlisDetailService = new PlacementsServiceimpl();
		return shorlisDetailService.insertShortlistDetails(roundID,shortList);
		
	}
	
	public Integer insertNextRound(InterviewRoundDTO interviewRoundDTO) throws DatabaseException {
		
		PlacementsServicei insertRoundService = new PlacementsServiceimpl();
		return insertRoundService.insertNextRound(interviewRoundDTO);
		// TODO Auto-generated method stub
		
	}

	public boolean insertShortlist(Integer roundID, Integer[] userId) throws DatabaseException {
		// TODO Auto-generated method stub
		PlacementsServicei insertService = new PlacementsServiceimpl();
		
		return insertService.insertShortlist(roundID,userId);
	}

	public Integer getClient(Integer jobpostID) throws DatabaseException {
		// TODO Auto-generated method stub
		PlacementsServicei clientService = new PlacementsServiceimpl();
		return clientService.getClient(jobpostID);
		
	}

	public boolean insertPlacementDetail(PlacementDTO pldto, Integer[] userId, Integer clientId) throws DatabaseException {
		PlacementsServicei insertService = new PlacementsServiceimpl();
		
		return insertService.insertPlacementDetail(pldto,userId,clientId);
	}

	public ArrayList<ArrayList> getPlacementDetail(JobPostBean jpb) throws DatabaseException {
		PlacementsServicei userFirstRounddetail = new PlacementsServiceimpl();
		
		ArrayList<ArrayList> placementDetailList = userFirstRounddetail.getPlacementDetail(jpb);
		return placementDetailList;
	}

	public boolean UpdatUserStatus(Integer interviewRoundId, Integer[] userId) throws DatabaseException {
       PlacementsServicei updateStatus = new PlacementsServiceimpl();
		
		return updateStatus.UpdatUserStatus(interviewRoundId,userId);
	}

	public boolean UpdateUserTableUserStatus(Integer[] userId) throws DatabaseException {
      PlacementsServicei updateStatus = new PlacementsServiceimpl();
		
		return updateStatus.UpdateUserTableUserStatus(userId);
	}

	public ArrayList<JobTypeDTO> getJobTypeDetails() throws DatabaseException {
		  PlacementsServicei jobtypeservicei = new PlacementsServiceimpl();
			
			ArrayList<JobTypeDTO> jobtypelist = jobtypeservicei.getJobTypeDetails();
			return jobtypelist;
	}

	public Integer getRoundNo(Integer roundNo) throws DatabaseException {
		PlacementsServicei roundNoServicei = new PlacementsServiceimpl();
		
		
		return roundNoServicei.getRoundNo(roundNo);
	}

}
