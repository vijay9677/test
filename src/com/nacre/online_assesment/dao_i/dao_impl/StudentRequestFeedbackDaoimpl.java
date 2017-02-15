/**
 * 
 */
package com.nacre.online_assesment.dao_i.dao_impl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.nacre.online_assesment.dao_i.StudentRequestFeedbackDaoi;
import com.nacre.online_assesment.db_util.SQLQueryConstants;

import com.nacre.online_assesment.dto.ClientDTO;

import com.nacre.online_assesment.dto.FeedbackTypeDTO;

import com.nacre.online_assesment.exception.DataNotFoundException;
import com.nacre.online_assesment.exception.DatabaseException;
import com.nacre.online_assesment.form_bean.ClientAddressBean;
import com.nacre.online_assesment.util.DateUtil;
import com.nacre.online_assesment.vo.GetCompanyFeebacksVo;
import com.nacre.online_assesment.vo.GetOrganisationFeedbacksVo;
import com.nacre.online_assesment.vo.ViewAllFeedbacksVo;
import com.sun.mail.iap.Response;


/**
 * StudentRequestFeedbackDaoimpl.java
 * @author Amarendar Guthuru
 * @since 30-08-2016
 *
 */
public class StudentRequestFeedbackDaoimpl implements StudentRequestFeedbackDaoi {
	

	@Override
	public List<FeedbackTypeDTO> getFeedbackType(Connection con) throws SQLException, DataNotFoundException {
		
      PreparedStatement ps=null;
      ps=con.prepareStatement(SQLQueryConstants.GET_FEEDBACK_TYPE);
      ResultSet rs=ps.executeQuery();
		List<FeedbackTypeDTO> listfeedbacktype=new ArrayList<FeedbackTypeDTO>();
		if(rs!=null){
		Boolean b=false;
		while(rs.next()){
			b=true;
			FeedbackTypeDTO feedbackTypeDTO=new FeedbackTypeDTO();
			feedbackTypeDTO.setFeedbackTypeId(rs.getInt(1));
			feedbackTypeDTO.setFeedbackType(rs.getString(2));
			listfeedbacktype.add(feedbackTypeDTO);
			
			
		}
		if(!b){
			throw new DataNotFoundException("no feedback found");
		}
			
			
			
		}
		return listfeedbacktype;
	}

	public List<ClientDTO> getCompany(Connection con) throws SQLException, DataNotFoundException {
		
		PreparedStatement ps=null;
		ps=con.prepareStatement(SQLQueryConstants.GET_COMPANY_NAMES);
		ResultSet rs=ps.executeQuery();
		List<ClientDTO> listcompany=new ArrayList<ClientDTO>();
        if(rs!=null){
        	Boolean b=false;
        	while(rs.next()){
        		b=true;
        		ClientDTO clientDTO=new ClientDTO();
        		clientDTO.setClientId(rs.getInt(1));
        		clientDTO.setClientName(rs.getString(2));
        		listcompany.add(clientDTO);
        		
        	}
        	if(!b){
        		throw new DataNotFoundException("no company found");
        		
        	}
        	
        	
        }		
        
		
		
		
		
		
		// TODO Auto-generated method stub
		return listcompany;
	}


	@Override
	public List<ClientAddressBean> getCompanyAddress(Connection con, Integer clientId) throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<ClientAddressBean> list=new ArrayList<ClientAddressBean>();
		PreparedStatement ps=null;
		ps=con.prepareStatement(SQLQueryConstants.GET_CLIENT_ADDRESS_ON_CLIENT_NAME);
	    ps.setInt(1, clientId);
	    
		ResultSet rs=ps.executeQuery();
		
		if(rs!=null){
			
			while(rs.next()){
				
				ClientAddressBean addressBean=new ClientAddressBean();
				addressBean.setCityid(rs.getInt(1));
				addressBean.setCity(rs.getString(2));
				list.add(addressBean);
				
				
					}
			
	
		}
		return list;
		
		
	}

	@Override
	public List<ClientAddressBean> getClientLocality(Connection con, Integer cityId,Integer clientId) throws SQLException {
		List<ClientAddressBean> list=new ArrayList<ClientAddressBean>();
		PreparedStatement ps=null;
		ps=con.prepareStatement(SQLQueryConstants.GET_CLIENT_LOCATION_ON_CITY_NAME);
	    ps.setInt(1, clientId);
	    ps.setInt(2,cityId );
	    ClientAddressBean addressBean=null;
		ResultSet rs=ps.executeQuery();
		
		if(rs!=null){
			
			while(rs.next()){
				
				addressBean=new ClientAddressBean();
				addressBean.setLocation(rs.getString(1));
				addressBean.setAddressId(rs.getInt(2));
		
				//addressBean.setAddressId(rs.getString(2));
				list.add(addressBean);
				
				
					}
	
		}
		return list;
	}

	@Override
	public int getClientAddressId(Connection con, Integer clientid, Integer addressid) throws SQLException, DataNotFoundException, DatabaseException {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ps=con.prepareStatement(SQLQueryConstants.GET_CLIENTADDRESSID_ON_CLIENTID_AND_ADDRESSID);
		ps.setInt(1, clientid);
	    ps.setInt(2, addressid);
	    Integer client_address_id=null;
	    ResultSet rs=ps.executeQuery();
	    
	    if(rs!=null){
	    	
	    	if(rs.next()){
	    		
	    		client_address_id=rs.getInt(1);
	    	}
	    	else{
	    		throw new DataNotFoundException("Address Id is not found");
	    	}
	    	
	    	
	    }else{
	    	throw new DatabaseException("RESULT SET NOT AVAILABLE");
	    	
	    }
	    
		
		return client_address_id;
	}

	@Override
	public int saveFeedBackTable(Connection con, String message, Integer feedbacktypeid, Integer userid,
			Integer clientaddreesid) throws SQLException {
		PreparedStatement ps=null;
		ps=con.prepareStatement(SQLQueryConstants.SAVE_FEEDBACK);
		ps.setString(1, message);
	    ps.setInt(2, feedbacktypeid);
	    ps.setInt(3, userid);
	    ps.setInt(4, clientaddreesid);
	    int result=ps.executeUpdate();
	    return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @throws SQLException 
	 * @ Amarendar guthuru
	 */

		@Override
		public List<ViewAllFeedbacksVo> getAllFeedbacks(Connection con)
				throws DatabaseException, SQLException {

	        PreparedStatement ps=con.prepareStatement(SQLQueryConstants.GET_ALL_FEEDBACKS);
		    ResultSet rs=ps.executeQuery();
		    List<ViewAllFeedbacksVo> list=new ArrayList<ViewAllFeedbacksVo>();
		    if(rs!=null){
		    while(rs.next()){
		    	
		  ViewAllFeedbacksVo allFeedbacksVo=new ViewAllFeedbacksVo();
		   allFeedbacksVo.setClientId(rs.getString(1));
		   allFeedbacksVo.setClientName(rs.getString(2));
		   allFeedbacksVo.setImage(rs.getString(3));
		   allFeedbacksVo.setCityId(rs.getString(4));
		   allFeedbacksVo.setCity(rs.getString(5));
		   allFeedbacksVo.setFeebbackId( rs.getString(6));
		   allFeedbacksVo.setFeedbackTypeId( rs.getString(7));
		   allFeedbacksVo.setFeedbackMsg(rs.getString(8));
		   //Converting sql date into simple date format DD-MM-YYYY
		  
		   java.sql.Date d=rs.getDate(9);
		   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   String s=sdf.format(d);
		   allFeedbacksVo.setDate(s);
		   allFeedbacksVo.setUserId(rs.getString(10));
		   allFeedbacksVo.setFirstName( rs.getString(11));
		   allFeedbacksVo.setLastName(rs.getString(12));
		   allFeedbacksVo.setEmail( rs.getString(13));
		   allFeedbacksVo.setBatchId( rs.getString(14));
		  
		  //if batch no is not assigned to the student. I am assigning  that value as the N/A
		   if(rs.getString(15).equals("")){
			   String batchNo="N/A";
			   allFeedbacksVo.setBatch(batchNo);
		   }
		   else{
			   allFeedbacksVo.setBatch(rs.getString(15));
		   }
		   
		   allFeedbacksVo.setTechnologyId(rs.getString(16));
		   allFeedbacksVo.setTechnology( rs.getString(17));
		   allFeedbacksVo.setClientAddressId( rs.getString(18));
		   allFeedbacksVo.setAddressId( rs.getString(19));
		   allFeedbacksVo.setLocation(rs.getString(20));
		   //Adding All the records to the list
		   list.add(allFeedbacksVo);
		   
		    
		    }
			
			
		    }
			
			
			
		
			return list;
		}

	@Override
	public List<GetOrganisationFeedbacksVo> getAllOrganisationFeedbacks(Connection con,Integer organisationId) throws SQLException {
		// TODO Auto-generated method stub
		
		
		List<GetOrganisationFeedbacksVo> list=new ArrayList<GetOrganisationFeedbacksVo>();
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.FILTER_ORAGANISATION_FEEDBACKS);
		
		ps.setInt(1, organisationId);
		ResultSet rs=ps.executeQuery();
		
		
		if(rs!=null){
			while(rs.next()){
				GetOrganisationFeedbacksVo getOrganisationFeedbacksVo=new GetOrganisationFeedbacksVo();
			
				getOrganisationFeedbacksVo.setClientId(rs.getString(1));
				getOrganisationFeedbacksVo.setClientName(rs.getString(2));
				getOrganisationFeedbacksVo.setImage(rs.getString(3));
				getOrganisationFeedbacksVo.setCityId(rs.getString(4));
				getOrganisationFeedbacksVo.setCity(rs.getString(5));
				getOrganisationFeedbacksVo.setFeebbackId( rs.getString(6));
				getOrganisationFeedbacksVo.setFeedbackTypeId( rs.getString(7));
				getOrganisationFeedbacksVo.setFeedbackMsg(rs.getString(8));
				//getOrganisationFeedbacksVo.setDate(rs.getString(9));
				 java.sql.Date d=rs.getDate(9);
				   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				   String s=sdf.format(d);
				getOrganisationFeedbacksVo.setDate(s);
				getOrganisationFeedbacksVo.setUserId(rs.getString(10));
				getOrganisationFeedbacksVo.setFirstName( rs.getString(11));
				getOrganisationFeedbacksVo.setLastName(rs.getString(12));
				getOrganisationFeedbacksVo.setEmail( rs.getString(13));
				getOrganisationFeedbacksVo.setBatchId( rs.getString(14));
				 //if batch no is not assigned to the student. I am assigning  that value as the N/A
				   if(rs.getString(15).equals("")){
					   String batchNo="N/A";
					   getOrganisationFeedbacksVo.setBatch(batchNo);
				   }
				   else{
					   getOrganisationFeedbacksVo.setBatch(rs.getString(15));
				   }
				
				getOrganisationFeedbacksVo.setTechnologyId(rs.getString(16));
				getOrganisationFeedbacksVo.setTechnology( rs.getString(17));
				getOrganisationFeedbacksVo.setClientAddressId( rs.getString(18));
				getOrganisationFeedbacksVo.setAddressId( rs.getString(19));
				getOrganisationFeedbacksVo.setLocation(rs.getString(20));
				
				list.add(getOrganisationFeedbacksVo);
				
			}
			
			
			
		}
		
		return list;
	}

	@Override
	public List<GetCompanyFeebacksVo> getAllCompanyFeedbacks(Connection con, Integer feedbackTypeId,Integer clientId,Integer addressId) throws SQLException {
		// TODO Auto-generated method stub
		List<GetCompanyFeebacksVo> list=new ArrayList<GetCompanyFeebacksVo>();
		PreparedStatement ps=null;
				
				if(feedbackTypeId!=0 && clientId!=0 && addressId!=0){
				ps=con.prepareStatement(SQLQueryConstants.FILTER_COMPANIES_FEEDBACKS);
		ps.setInt(1, feedbackTypeId);
		ps.setInt(2, clientId);
		ps.setInt(3, addressId);
				}else if(feedbackTypeId!=0 && clientId!=0){
					ps=con.prepareStatement(SQLQueryConstants.FILTER_COMPANIES_FEEDBACKS_CLIENT);
					ps.setInt(1, feedbackTypeId);
					ps.setInt(2, clientId);
								
				}else if(feedbackTypeId!=0){
					ps=con.prepareStatement(SQLQueryConstants.FILTER_COMPANIES_FEEDBACKS_TYPE);
					ps.setInt(1, feedbackTypeId);
					
				}else{
					ps=con.prepareStatement(SQLQueryConstants.FILTER_COMPANIES_FEEDBACKS_ALL_TYPE);
				//	ps.setInt(1, feedbackTypeId);
					
				}
		ResultSet rs=ps.executeQuery();
		
		if(rs!=null){
			while(rs.next()){
			 GetCompanyFeebacksVo companyFeebacksVo=new GetCompanyFeebacksVo();
			 companyFeebacksVo.setClientId(rs.getString(1));
			 companyFeebacksVo.setClientName(rs.getString(2));
			 companyFeebacksVo.setImage(rs.getString(3));
			 companyFeebacksVo.setCityId(rs.getString(4));
			 companyFeebacksVo.setCity(rs.getString(5));
			 companyFeebacksVo.setFeebbackId( rs.getString(6));
			 companyFeebacksVo.setFeedbackTypeId( rs.getString(7));
			 companyFeebacksVo.setFeedbackMsg(rs.getString(8));
			
			 java.sql.Date d=rs.getDate(9);
			   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			   String s=sdf.format(d);
			 companyFeebacksVo.setDate(s);
			 companyFeebacksVo.setUserId(rs.getString(10));
			 companyFeebacksVo.setFirstName( rs.getString(11));
			 companyFeebacksVo.setLastName(rs.getString(12));
			 companyFeebacksVo.setEmail( rs.getString(13));
			 companyFeebacksVo.setBatchId( rs.getString(14));
			//if batch no is not assigned to the student. I am assigning  that value as the N/A
			   if(rs.getString(15).equals("")){
				   String batchNo="N/A";
				   companyFeebacksVo.setBatch(batchNo);
			   }
			   else{
				   companyFeebacksVo.setBatch(rs.getString(15));
			   }
			
			 companyFeebacksVo.setTechnologyId(rs.getString(16));
			 companyFeebacksVo.setTechnology( rs.getString(17));
			 companyFeebacksVo.setClientAddressId( rs.getString(18));
			 companyFeebacksVo.setAddressId( rs.getString(19));
			 companyFeebacksVo.setLocation(rs.getString(20));
			 //adding all company details to list
			 list.add(companyFeebacksVo);
			 
				
				
				
			}
			
			
		}
		
		
		
		return list;
	}
		
	
	
	
	
}
