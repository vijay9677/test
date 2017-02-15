/**
 * 
 */
package com.nacre.online_assesment.service_i.service_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.online_assesment.dao_i.CommonDaoi;
import com.nacre.online_assesment.dao_i.dao_impl.CommonDaoimpl;
import com.nacre.online_assesment.db_util.DbUtil;
import com.nacre.online_assesment.dto.CityDTO;
import com.nacre.online_assesment.dto.ClientDTO;
import com.nacre.online_assesment.dto.CountryDTO;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.LevelDTO;
import com.nacre.online_assesment.dto.StateDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.service_i.CommonServicei;

/**
 * @author Vijay Kumar Reddy K
 *
 */
public class CommonServiceimpl implements CommonServicei {

	/* (non-Javadoc)
	 * @see com.nacre.online_assesment.service_i.CommonServicei#getCountry()
	 */
	@Override
	public List<CountryDTO> getCountry() throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		CommonDaoi commonDaoi = new CommonDaoimpl();
		 List<CountryDTO> countryDTOs = commonDaoi.getCountryList(con);
		DbUtil.closeConnection(con);
		return countryDTOs;
	}

	@Override
	public List<StateDTO> getState(Integer countryId) throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		CommonDaoi commonDaoi = new CommonDaoimpl();

		 List<StateDTO> stateDTOs = commonDaoi.getStateList(con, countryId);
		 DbUtil.closeConnection(con);
		return stateDTOs;
		}

	@Override
	public List<CityDTO> getCity(Integer stateId) throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		CommonDaoi commonDaoi = new CommonDaoimpl();

		 List<CityDTO> cityDTOs = commonDaoi.getCityList(con, stateId);
		DbUtil.closeConnection(con);
		return cityDTOs;
		}

	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains CityDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	@Override
	public List<CityDTO> getJobPostcity() throws DatabaseException,
			DataNotFoundException {
		Connection con = DbUtil.getConnection();
		CommonDaoi commonDaoi = new CommonDaoimpl();

		 List<CityDTO> cityDTOs = commonDaoi.getJobPostcity(con);
		DbUtil.closeConnection(con);
		return cityDTOs;
	}

	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains ClientDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	@Override
	public List<ClientDTO> getJobPostCompany() throws DatabaseException,
			DataNotFoundException {
		Connection con = DbUtil.getConnection();
		CommonDaoi commonDaoi = new CommonDaoimpl();

		 List<ClientDTO> clientDTOs = commonDaoi.getJobPostCompany(con);
		DbUtil.closeConnection(con);
		return clientDTOs;
	}
	/**
	 * @author Sagar Suryawanshi b 35
	 * @return java.util.List Contains TechnologyDTO Objects
	 * @throws DatabaseException occurs when you are getting problem to connect to database
	 * @throws SQLException occurs if no countries are available
	 */
	@Override
	public List<TechnologyDTO> getJobPostTechnology() throws DatabaseException,
			DataNotFoundException {
		Connection con = DbUtil.getConnection();
		CommonDaoi commonDaoi = new CommonDaoimpl();

		 List<TechnologyDTO> technologyDTOs = commonDaoi.getJobPostTechnology(con);
		DbUtil.closeConnection(con);
		return technologyDTOs;
	}
	/**
	 * @author Saurabh Suman
	 * @return java.util.List Contains LevelDTO Objects
	 * @throws DatabaseException occurs when problem occurs while connecting with database
	 * @throws DataNotFoundException occurs when Levels are not available
	 */
	@Override
	public List<LevelDTO> getLevel() throws DatabaseException, DataNotFoundException {
		Connection con = DbUtil.getConnection();
		CommonDaoi commonDaoi = new CommonDaoimpl();
		 List<LevelDTO> levelDTOs = commonDaoi.getLevelList(con);
		DbUtil.closeConnection(con);
		return levelDTOs;
		
	}

	@Override
	/**
	 * @author sunil
	 */
	public List<CourseDTO> getCourse(Integer technologyId) throws DatabaseException, DataNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		CommonDaoi commonDaoi = new CommonDaoimpl();
		List<CourseDTO> coursesDTOs = commonDaoi.getCourse(technologyId,con);
		DbUtil.closeConnection(con);
		return coursesDTOs;
	}
	
	
}
