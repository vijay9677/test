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

import com.nacre.online_assesment.dao_i.CommonDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.CityDTO;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.dto.StateDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.ErrorMessages;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class CommonDaoimpl implements CommonDaoi {

	
	/* (non-Javadoc)
	 * @see com.nacre.online_assesment.dao_i.CommonDaoi#getCountryList(java.sql.Connection)
	 */
	@Override
	public List<CountryDTO> getCountryList(Connection con) throws DataNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_COUNTRY);
			
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		
		
		if(isRecordsAvailable){
			List<CountryDTO> countryDTOs = new ArrayList<CountryDTO>(); 
			
			while (isRecordsAvailable) {
				
				CountryDTO countryDTO = new CountryDTO();
				countryDTO.setCountry(rs.getString(2));
				countryDTO.setCountryId( rs.getInt(1));
				
				isRecordsAvailable= rs.next();
				countryDTOs.add(countryDTO);
				
			}
			
			

			return countryDTOs;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_COUNTRIES_NOT_FOUND);
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
		
		
	}

	@Override
	public List<StateDTO> getStateList(Connection con, Integer countryId)
			throws DataNotFoundException, DatabaseException {
		try{
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_STATE);
			ps.setInt(1, countryId);
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		if(isRecordsAvailable){
			List<StateDTO> stateDTOs = new ArrayList<StateDTO>(); 
			while (isRecordsAvailable) {
				StateDTO stateDTO = new StateDTO();
				stateDTO.setState(rs.getString(2));
				stateDTO.setStateId( rs.getInt(1));
				isRecordsAvailable= rs.next();
				stateDTOs.add(stateDTO);
			}
			return stateDTOs;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_STATES_NOT_FOUND);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
	}

	@Override
	public List<CityDTO> getCityList(Connection con, Integer stateId) throws DataNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_CITY);
			ps.setInt(1, stateId);
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		if(isRecordsAvailable){
			List<CityDTO> cityDTOs = new ArrayList<CityDTO>(); 
			while (isRecordsAvailable) {
				CityDTO cityDTO = new CityDTO();
				cityDTO.setCity(rs.getString(2));
				cityDTO.setCityId(rs.getInt(1));
				isRecordsAvailable= rs.next();
				cityDTOs.add(cityDTO);
			}
			return cityDTOs;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_CITIES_NOT_FOUND);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
	}

	/**
	 * @author sagar Suryawanshi b 35
	 * @return List of City Objects
	 * @throws DatabaseException 
	 * @throws SQLException 
	 */
	@Override
	public List<CityDTO> getJobPostcity(Connection con)
			throws DataNotFoundException, DatabaseException {
		try{
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_JOB_POST_CITY);
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		if(isRecordsAvailable){
			List<CityDTO> cityDTOs = new ArrayList<CityDTO>(); 
			while (isRecordsAvailable) {
				CityDTO cityDTO = new CityDTO();
				cityDTO.setCity(rs.getString(2));
				cityDTO.setCityId(rs.getInt(1));
				isRecordsAvailable= rs.next();
				cityDTOs.add(cityDTO);
			}
			return cityDTOs;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_CITIES_NOT_FOUND);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
	}
	
	/**
	 * @author sagar Suryawanshi b 35
	 * @return List of Client Objects
	 * @throws DatabaseException 
	 * @throws SQLException 
	 */
	@Override
	public List<ClientDTO> getJobPostCompany(Connection con)
			throws DataNotFoundException, DatabaseException {
		try{
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_JOB_POST_COMPANY);
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		if(isRecordsAvailable){
			List<ClientDTO> list = new ArrayList<ClientDTO>(); 
			while (isRecordsAvailable) {
				ClientDTO clientDTO = new ClientDTO();
				clientDTO.setClientName(rs.getString(2));
				clientDTO.setClientId(rs.getInt(1));
				isRecordsAvailable= rs.next();
				list.add(clientDTO);
			}
			return list;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_CITIES_NOT_FOUND);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
	}

	/**
	 * @author sagar Suryawanshi b 35
	 * @return List of Technology Objects
	 * @throws DatabaseException 
	 * @throws SQLException 
	 */
	@Override
	public List<TechnologyDTO> getJobPostTechnology(Connection con)
			throws DataNotFoundException, DatabaseException {
		try{
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_JOB_POST_Technology);
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		if(isRecordsAvailable){
			List<TechnologyDTO> list = new ArrayList<TechnologyDTO>(); 
			while (isRecordsAvailable) {
				TechnologyDTO technologyDTO = new TechnologyDTO();
				technologyDTO.setTechnology(rs.getString(2));
				technologyDTO.setTechnologyId(rs.getInt(1));
				isRecordsAvailable= rs.next();
				list.add(technologyDTO);
			}
			return list;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_CITIES_NOT_FOUND);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
	}
	/**
	 * @author Saurabh Suman
	 * @return List of level Objects
	 * @throws DatabaseException 
	 * @throws SQLException 
	 */

	@Override
	public List<LevelDTO> getLevelList(Connection con) throws DataNotFoundException, DatabaseException {
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_LEVEL);
			
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		
		
		if(isRecordsAvailable){
			List<LevelDTO> levelDTOs = new ArrayList<LevelDTO>(); 
			
			while (isRecordsAvailable) {
				
				LevelDTO levelDTO = new LevelDTO();
				levelDTO.setLevel(rs.getString(2));
				levelDTO.setLevelId( rs.getInt(1));
				
				isRecordsAvailable= rs.next();
				levelDTOs.add(levelDTO);
				
			}
			
			

			return levelDTOs;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_LEVEL_NOT_FOUND);
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
		
		
	}


	@Override
	/**
	 * @author sunil
	 */
	public List<CourseDTO> getCourse(Integer technologyId,Connection con) throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_COURSE);
			ps.setInt(1,technologyId);
			
		ResultSet rs = 	ps.executeQuery();
		Boolean isRecordsAvailable = rs.next();
		
		
		if(isRecordsAvailable){
			List<CourseDTO> CourseDTOs = new ArrayList<CourseDTO>(); 
			
			while (isRecordsAvailable) {
				
				CourseDTO courseDTO=new CourseDTO();
				courseDTO.setCourseId(rs.getInt(1));
				courseDTO.setCourse(rs.getString(2));
				
				isRecordsAvailable= rs.next();
				CourseDTOs.add(courseDTO);
				
			}
			
			

			return CourseDTOs;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_COUNTRIES_NOT_FOUND);
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
	}
	
	
}
