/**
 * 
 */
package com.nacre.online_assesment.service_i;

import java.util.ArrayList;


import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.JobTypeDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.JobPostBean;
import com.nacre.online_assesment.form_bean.JobRoundBean;

import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.exception.DatabaseException;


/**
 * @author Vijay Kumar Reddy K
 *
 */
public interface PlacementsServicei {

	public ArrayList<JobPostingDTO> getJobPostDetail() throws DatabaseException;
	public ArrayList<InterviewRoundDTO> getRoundDetails(JobPostBean jpb) throws DatabaseException;
	public ArrayList<UserDTO> getUserDetail(JobRoundBean jrb) throws DatabaseException;
	public ArrayList<ArrayList> getFirstRoundDetail(JobRoundBean jrb) throws DatabaseException;
	public String insertShortlistDetails(Integer roundID, String[] shortList) throws ClassNotFoundException, DatabaseException;
	public Integer insertNextRound(InterviewRoundDTO interviewRoundDTO) throws DatabaseException;
	public boolean insertShortlist(Integer roundID, Integer[] userId) throws DatabaseException;
	public Integer getClient(Integer jobpostID) throws DatabaseException;
	public boolean insertPlacementDetail(PlacementDTO pldto, Integer[] userId, Integer clientId) throws DatabaseException;
	public ArrayList<ArrayList> getPlacementDetail(JobPostBean jpb) throws DatabaseException;
	public boolean UpdatUserStatus(Integer interviewRoundId, Integer[] userId) throws DatabaseException;
	public boolean UpdateUserTableUserStatus(Integer[] userId) throws DatabaseException;
	public ArrayList<JobTypeDTO> getJobTypeDetails() throws DatabaseException;
	public Integer getRoundNo(Integer roundNo) throws DatabaseException;
}
