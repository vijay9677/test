package com.nacre.online_assesment.dao_i;

import java.sql.Connection;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dto.InterviewRoundDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.exception.DatabaseException;


import com.nacre.online_assesment.dto.JobPostingDTO;
import com.nacre.online_assesment.dto.JobTypeDTO;
import com.nacre.online_assesment.dto.PlacementDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.form_bean.JobPostBean;
import com.nacre.online_assesment.form_bean.JobRoundBean;


public interface PlacementsDaoi {
	public ArrayList<JobPostingDTO> getJobPostDetail(Connection con);
	public ArrayList<InterviewRoundDTO> getRoundDetails(JobPostBean jpb,Connection con);
	public ArrayList<UserDTO> getUserDetail(JobRoundBean jrb, Connection con);
	public ArrayList<ArrayList> getFirstRoundDetail(JobRoundBean jrb,Connection con);
	public String insertShortlistDetails(Integer roundID, String[] shortList, Connection con) throws ClassNotFoundException;
	public Integer insertShortlistDetails(InterviewRoundDTO interviewRoundDTO, Connection con);
	public boolean insertShortlist(Integer roundID2, Integer[] userId, Connection con);
	public Integer getClient(Integer jobpostID, Connection con);
	public boolean insertPlacementDetail(PlacementDTO pldto, Integer[] userId, Integer clientId, Connection con);
	public ArrayList<ArrayList> getPlacementDetail(JobPostBean jpb, Connection con);
	public boolean UpdatUserStatus(Integer interviewRoundId, Integer[] userId, Connection con);
	public boolean UpdateUserTableUserStatus(Integer[] userId, Connection con);
	public ArrayList<JobTypeDTO> getJobTypeDetails(Connection con);
	public Integer getRoundNo(Integer roundNo, Connection con);

	}
