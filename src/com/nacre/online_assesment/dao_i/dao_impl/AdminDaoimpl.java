package com.nacre.online_assesment.dao_i.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.nacre.online_assesment.dao_i.AdminDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;
import com.nacre.online_assesment.dto.CourseDTO;
import com.nacre.online_assesment.dto.RoleDTO;
import com.nacre.online_assesment.dto.TechnologyDTO;
import com.nacre.online_assesment.dto.UserDTO;
import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.util.DateUtil;
import com.nacre.online_assesment.util.ErrorMessages;
import com.nacre.online_assesment.util.StringConstants;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * @author Arvind Kumar.
 * This class is provide to connect with database.
 *
 */
public class AdminDaoimpl implements AdminDaoi {
	
	/**
	 * @author Arvind Kumar.
	 * @return int type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	@Override
	public int addAdmin(UserDTO userDTO, Connection connection) 
			throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement prStatement;
		ResultSet resultSet;
		String fName=userDTO.getFirstname();
		String lName= userDTO.getLastname();
		String email= userDTO.getEmail();
		String password= userDTO.getPassword();
		String moNo= userDTO.getMobileNo();
		Integer gender= userDTO.getGender();
		String image= userDTO.getImage(); 
		java.util.Date date= userDTO.getDate();
		int count=0;
		RoleDTO role= userDTO.getRole();
		try {
			prStatement = connection.prepareStatement(SQLQueryConstants.INSERT_ADD_ADMIN_SQL_QUERY,Statement.RETURN_GENERATED_KEYS);
		prStatement.setString(1, fName);
		prStatement.setString(2, lName);
		prStatement.setString(3, email);
		prStatement.setString(4, password);
		prStatement.setString(5, moNo);
		prStatement.setInt(6, gender);
		prStatement.setString(7, image);
		prStatement.setDate(8, DateUtil.getSQLDate(date));
		prStatement.setInt(9, role.getRoleId());
		count = prStatement.executeUpdate();
		resultSet=prStatement.getGeneratedKeys();
		if (resultSet.next()) {
			resultSet.getInt(1);			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		return count;
	}

	/**
	 * @author Arvind Kumar.
	 * @return 
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws DataNotFoundException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	@Override
	public int editAdmin(UserDTO userDTO, Connection connection)
			throws DatabaseException, DataNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement prStatement;
		//ResultSet resultSet;
		System.out.println(userDTO);
		Integer userId=userDTO.getUserid();
		String fName=userDTO.getFirstname();
		String lName=userDTO.getLastname();
		String emailId=userDTO.getEmail();
		String mobileNo=userDTO.getMobileNo();
		Integer gender=userDTO.getGender();
		String image= userDTO.getImage();
		RoleDTO roleId=userDTO.getRole();
		int count=0;
		try {
			prStatement=connection.prepareStatement(SQLQueryConstants.EDIT_ADMIN_SQL_QUERY);
			prStatement.setString(1, fName);
			prStatement.setString(2, lName);
			prStatement.setString(3, emailId);
			prStatement.setString(4, mobileNo);
			prStatement.setInt(5, gender);
			prStatement.setString(6, image);
			prStatement.setInt(7, roleId.getRoleId());
			prStatement.setInt(8, userId);
			prStatement.setInt(9, StringConstants._ACTIVE_STATUS_ID);
			
			count=prStatement.executeUpdate();
			System.out.println(">> count"+count);
		} catch (SQLException sqle) {
			// TODO: handle exception
			sqle.printStackTrace();
			throw new DatabaseException(sqle.getMessage());
		}		
		return count;
	}
	
	/**
	 * @author Arvind Kumar.
	 * @return int type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	@Override
	public int deleteAdmin(UserDTO userDto, Connection connection)
			throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement prStatement;
		//ResultSet resultSet;
		Integer userId=userDto.getUserid();
		int count=0;
		try {
			prStatement=connection.prepareStatement(SQLQueryConstants.DELETE_ADMIN_SQL_QUERY);
			prStatement.setInt(1, userId);
			count=prStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	/**
	 * @author Arvind Kumar.
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	@Override
	public List<String> getAdminRecords(Connection connection,Integer uId)
			throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement prStatement;
		ResultSet resultSet;
		List getList=new ArrayList();
		
		try {
			System.out.println();
			prStatement=connection.prepareStatement(SQLQueryConstants.GET_ADMIN_RECORDS_SQL_QUERY);
			prStatement.setInt(1,uId);
			resultSet=prStatement.executeQuery();
			while (resultSet.next()) {
				Integer userId=resultSet.getInt("user_id");
				String firstName=resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
		        String mobileNo=resultSet.getString("mobile_no");
		        Integer gen=resultSet.getInt("gender");
		        String role=resultSet.getString("role");
		        
		        UserDTO userDTO=new UserDTO();
		        userDTO.setUserid(userId);
		        userDTO.setFirstname(firstName);
		        userDTO.setLastname(lastName);
		        userDTO.setEmail(email);
		        userDTO.setMobileNo(mobileNo);
		        userDTO.setGender(gen);
		        
		        RoleDTO roleDto=new RoleDTO();
				roleDto.setRole(role);
		        userDTO.setRole(roleDto);
		        
				getList.add(userDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return getList;
	}

	/**
	 * @author Arvind Kumar.
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	@Override
	public List<String> getParticularAdminRecord(Integer userId,Connection connection) 
			throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement prStatement;
		ResultSet resultSet;
		List getList=new ArrayList();
		try {
			prStatement=connection.prepareStatement(SQLQueryConstants.GET_PERTICULAR_ADMIN_RECORDS_SQL_QUERY);
			prStatement.setInt(1,userId);
			resultSet=prStatement.executeQuery();
			while (resultSet.next()) {
				Integer userid=resultSet.getInt("user_id");
				String firstName=resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
		        String mobileNo=resultSet.getString("mobile_no");
		        Integer gen=resultSet.getInt("gender");
		        String editImage=resultSet.getString("image");
		        Integer role=resultSet.getInt("role_id");

		        UserDTO userDTO=new UserDTO();
		        userDTO.setUserid(userId);
		        userDTO.setFirstname(firstName);
		        userDTO.setLastname(lastName);
		        userDTO.setEmail(email);
		        userDTO.setMobileNo(mobileNo);
		        userDTO.setGender(gen);
		        userDTO.setImage(editImage);
		        
		        RoleDTO roleDto=new RoleDTO();
				roleDto.setRoleId(role);
		        userDTO.setRole(roleDto);
		        
				getList.add(userDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return getList;
	}

	/**
	 * @author Arvind Kumar.
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	@Override
	public List<String> viewParticularAdminRecord(Integer userId, Connection connection)
			throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
        PreparedStatement prStatement;
		ResultSet resultSet;
		List viewList=new ArrayList();
		try {
			prStatement=connection.prepareStatement(SQLQueryConstants.VIEW_ADMIN_RECORDS_SQL_QUERY);
			prStatement.setInt(1,userId);
			resultSet=prStatement.executeQuery();
			while (resultSet.next()) {
				Integer userid=resultSet.getInt("user_id");
				String firstName=resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
		        String mobileNo=resultSet.getString("mobile_no");
		        String viewImage=resultSet.getString("image");
		        Date dateOfBirth=DateUtil.getSQLDate(resultSet.getDate("d_o_b"));
		        
		        RoleDTO roleDto=new RoleDTO();
				Integer roleid=resultSet.getInt("role_id");
		        String role=resultSet.getString("role");
		        
		        UserDTO userDTO=new UserDTO();
		        userDTO.setUserid(userId);
		        userDTO.setFirstname(firstName);
		        userDTO.setLastname(lastName);
		        userDTO.setEmail(email);
		        userDTO.setMobileNo(mobileNo);
		        userDTO.setImage(viewImage);
		        userDTO.setDate(dateOfBirth);
		        
		        roleDto.setRoleId(roleid);
				roleDto.setRole(role);
		        userDTO.setRole(roleDto);
		        
				viewList.add(userDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return viewList;
	}

	/**
	 * @author Arvind Kumar.
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	@Override
	public List<String> getGroupByAdminRecords(Integer roleId, Connection connection) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement prStatement;
		ResultSet resultSet;
		List groupList=new ArrayList();
		try {
			prStatement=connection.prepareStatement(SQLQueryConstants.GET_GROUP_BY_ADMIN_RECORDS_SQL_QUERY);
			prStatement.setInt(1,roleId);
			resultSet=prStatement.executeQuery();
			while (resultSet.next()) {
				Integer userId=resultSet.getInt("user_id");
				String firstName=resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
		        String mobileNo=resultSet.getString("mobile_no");
		        Integer gen=resultSet.getInt("gender");
		        String role=resultSet.getString("role");
		        
		        UserDTO userDTO=new UserDTO();
		        userDTO.setUserid(userId);
		        userDTO.setFirstname(firstName);
		        userDTO.setLastname(lastName);
		        userDTO.setEmail(email);
		        userDTO.setMobileNo(mobileNo);
		        userDTO.setGender(gen);
		        
		        RoleDTO roleDto=new RoleDTO();
				roleDto.setRole(role);
		        userDTO.setRole(roleDto);
		        
		        groupList.add(userDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return groupList;
	}

	/**
	 * @author Arvind Kumar.
	 * @return List type variable.
	 * @throws DatabaseException occurs when problem occurs while connecting with database.
	 * @throws SQlException occurs when problem occurs while connecting Query Constants.
	 */
	@Override
	public List<RoleDTO> getRoleByAdmin(Connection connection) throws DataNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		PreparedStatement prStatement;
		ResultSet resultSet;
		try{
		prStatement = connection.prepareStatement(SQLQueryConstants.GET_ROLE_BY_ADMIN);
		resultSet = prStatement.executeQuery();
		Boolean isRecordsAvailable = resultSet.next();
		if(isRecordsAvailable){
			List<RoleDTO> getRole = new ArrayList<RoleDTO>(); 
			while (isRecordsAvailable) {
				RoleDTO roleDTO = new RoleDTO();
				roleDTO.setRole(resultSet.getString(2));
				roleDTO.setRoleId(resultSet.getInt(1));
				isRecordsAvailable= resultSet.next();
				getRole.add(roleDTO);
			}
			return getRole;
		}else{
			
			throw new DataNotFoundException(ErrorMessages._ERR_CITIES_NOT_FOUND);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(ErrorMessages._ERR_DB_CON);
		}
	}

	@Override
	public List<CourseDTO> getCourseDetailsForEditAction(Connection con) throws SQLException {
   PreparedStatement ps = null;
	ResultSet rs = null;
	List<CourseDTO> list = new ArrayList<CourseDTO>();
	
		ps = con.prepareStatement(SQLQueryConstants.GET_COURSE_DETAILS);
		
		rs = ps.executeQuery();
		while(rs.next()){
           Integer courseId=rs.getInt(1);
           String courseName=rs.getString(2);
				CourseDTO dto=new CourseDTO();
				dto.setCourseId(courseId);
				dto.setCourse(courseName);

				list.add(dto);
			}
			
			System.out.println(list);
			
	

	return list;
	}
	@Override
	/**
	 * @author JAY SINGH
	 * @param userid,connection con
	 *
	 */
	public void approveStatus(Integer userId, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		String sql=SQLQueryConstants.APPROVE_REQUEST_BY_ADMIN;
		java.sql.PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,userId);
		int result=ps.executeUpdate();
		if(result==1){
			//System.out.println("Result is update");
		}
		else{
			//System.out.println("Not Update");
		}
		
	}

	@Override
	/**
	 * @author JAY SINGH
	 * @param userid,connection con
	 * 
	 */
	public void rejectRequest(Integer userId, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		String sql=SQLQueryConstants.REJECT_REQUEST_BY_ADMIN;
		java.sql.PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,userId);
		int result=ps.executeUpdate();
		if(result==1){
			//System.out.println("Result is update");
		}
		else{
//			System.out.println("Not Update");
		}	
	}








	/**
	 * @author Swapnil
	 * @param con
	 * @return list
	 * @throws SQLException
	 */
		@Override
		public List<CourseDTO> getCourse(Connection con) throws SQLException {
	   PreparedStatement ps = null;
		ResultSet rs = null;
		List<CourseDTO> list = new ArrayList<CourseDTO>();
		
			ps = con.prepareStatement(SQLQueryConstants.GET_COURSE_DETAILS);
			
			rs = ps.executeQuery();
			while(rs.next()){
	           Integer courseId=rs.getInt(1);
	           String courseName=rs.getString(2);
					CourseDTO dto=new CourseDTO();
					dto.setCourseId(courseId);
					dto.setCourse(courseName);

					list.add(dto);
				}
				
				System.out.println("hi this list for details"+list);
				
		

		return list;
	}
		/**
		 * @author Swapnil
		 * @param con,courseDto
		 * @return Integer
		 * @throws SQLException
		 */
		@Override
		public Integer addCourse(Connection con, CourseDTO courseDto) throws SQLException {
			// TODO Auto-generated method stub

			System.out.println("Start DaoImp Class");
			PreparedStatement ps = null;
			String course=courseDto.getCourse();
			System.out.println("Course in DaoImpl:::::"+course);
			int count=0;
			try {
				ps=con.prepareStatement(SQLQueryConstants.ADD_COURSE);
				ps.setString(1, course);
				ps.setString(2, course);

				count=ps.executeUpdate();
				if (count>=1) {
					System.out.println("Successfull Insert data...");
				} else {
					System.out.println("Not Successfull Insert data...");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("End DaoImp Class");
			return count;
		}
/*	@Override
	public Boolean addCourse(Connection con, CourseDTO courseDto) throws SQLException {
		// TODO Auto-generated method stub
		 PreparedStatement ps = null;
			ResultSet rs = null;
		    List<CourseDTO> list = new ArrayList<CourseDTO>();
			String query="INSERT INTO tbl_course (course) SELECT '?' As course FROM (SELECT Count(*) As  ExistsCount FROM tbl_course WHERE course = '(Select * from tbl_course)')  AS  e WHERE e.ExistsCount=0";
		    ps=con.prepareStatement(query);
		    int count=ps.executeUpdate();
		    while(rs.next()){
		    	System.out.println(rs.getString(2));
		    }
			System.out.println("asdas"+list);
				ps = con.prepareStatement(SQLQueryConstants.ADD_COURSE);
				ps.setString(1, courseDto.getCourse());
				//ps.setInt(1, courseDto.getCourseId());
				
				int rs1 = ps.executeUpdate();
				if(rs1==1){
					return true;
				}
				else
				{
					return false;
				}
			
				
	}*/
	/**
	 * @author Swapnil
	 * @param con,courseDto
	 * @return Boolean
	 * @throws SQLException
	 */

	@Override
	public Boolean editCourse(Connection con, CourseDTO courseDto) throws SQLException {
		// TODO Auto-generated method stub
		 PreparedStatement ps = null;
			//ResultSet rs = null;
			//List<CourseDTO> list = new ArrayList<CourseDTO>();
			
				ps = con.prepareStatement(SQLQueryConstants.EDIT_COURSE);
				ps.setString(1, courseDto.getCourse());
				ps.setInt(2, courseDto.getCourseId());
				
				int rs = ps.executeUpdate();
				if(rs==1){
					return true;
				}
				else
				{
					return false;
				}
				
		
	}
	/**
	 * @author Swapnil
	 * @param con
	 * @return list
	 * @throws SQLException
	 */
	@Override
	public List<TechnologyDTO> getTechnologies(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		 PreparedStatement ps = null;
			ResultSet rs = null;
			List<TechnologyDTO> list = new ArrayList<TechnologyDTO>();
			
				ps = con.prepareStatement(SQLQueryConstants.GET_technology_DETAILS);
				
				rs = ps.executeQuery();
				while(rs.next()){
		           Integer technologyId=rs.getInt(1);
		           String technologyName=rs.getString(2);
						TechnologyDTO dto=new TechnologyDTO();
						dto.setTechnologyId(technologyId);
						dto.setTechnology(technologyName);

						list.add(dto);
					}
					
					System.out.println(list);
					
			

			return list;
		}
/*	@Override
	public Boolean addTechnology(Connection con, TechnologyDTO technologyDTO) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		
			ps = con.prepareStatement(SQLQueryConstants.ADD_TECHNOLOGY);
			
			ps.setString(1,technologyDTO.getTechnology());
			//ps.setInt(1, courseDto.getCourseId());
			
			int rs = ps.executeUpdate();
			if(rs==1){
				return true;
			}
			else
			{
				return false;
			}
			
}*/
	/**
	 * @author Swapnil
	 * @param con,technologyDTO
	 * @return integer
	 * @throws SQLException
	 */
	
	@Override
	public Integer addTechnology(Connection con, TechnologyDTO technologyDTO) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Start DaoImp Class");
		PreparedStatement ps = null;
		String technology =technologyDTO.getTechnology();
		System.out.println("Course in DaoImpl:::::"+technology);
		int count=0;
		try {
			ps=con.prepareStatement(SQLQueryConstants.ADD_TECHNOLOGY);
			ps.setString(1, technology);
			ps.setString(2, technology);

			count=ps.executeUpdate();
			if (count>=1) {
				System.out.println("Successfull Insert data...");
			} else {
				System.out.println("Not Successfull Insert data...");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("End DaoImp Class");
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @author Swapnil
	 * @param con,technologyDTO
	 * @return boolean
	 * @throws SQLException
	 */
	
	
	@Override
	public Integer editTechnology(Connection con, TechnologyDTO technologyDTO) throws SQLException {
		// TODO Auto-generated method stub
		 PreparedStatement ps = null;
			
				ps = con.prepareStatement(SQLQueryConstants.EDIT_TECHNOLOGY);
				ps.setString(1, technologyDTO.getTechnology());
				ps.setInt(2, technologyDTO.getTechnologyId());
				
				int rs = ps.executeUpdate();
				if(rs==1){
					return rs;
				}
				else
				{
					return rs;
				}
		}
	

	/**
	 * @author Swapnil
	 * @param con,courseDto,technologyDTO
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public Boolean addTechnologyCourse(Connection con, CourseDTO courseDto, TechnologyDTO technologyDTO) throws SQLException {
		// TODO Auto-generated method stub
		 PreparedStatement ps = null;
			
			ps = con.prepareStatement(SQLQueryConstants.ADD_TECH_COURSE);
			
			ps.setInt(1, technologyDTO.getTechnologyId());
			ps.setInt(2, courseDto.getCourseId());
			
			int rs = ps.executeUpdate();
			System.out.println("------------------"+rs);
			if(rs==1){
				return true;
			}
			else
			{
				return false;
			}

	}
	
	/**
	 * @author Swapnil
	 * @param con,technologyId
	 * @return list
	 * @throws DatabaseException
	 */
	@Override
	public List getNotAssignCourse(Connection con, Integer technologyId) throws DatabaseException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CourseDTO> list = new ArrayList<CourseDTO>();
		
			try {
				ps = con.prepareStatement(SQLQueryConstants.GET_NOT_ASSIGNED_COURSE);
			
			ps.setInt(1, technologyId);
			rs = ps.executeQuery();
			
				while(rs.next()){
				   Integer courseId=rs.getInt(1);
				   String courseName=rs.getString(2);
						CourseDTO dto=new CourseDTO();
						dto.setCourseId(courseId);
						dto.setCourse(courseName);

						list.add(dto);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DatabaseException();
				
			}
				
				System.out.println("hi this list for details"+list);
				
		

		return list;
	}

	}
