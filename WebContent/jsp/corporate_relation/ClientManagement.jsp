<!--  Saurabh Suman & Sonali Chavan  B-35-->

<%-- <%@page import="com.nacre.online_assesment.dto.LevelDTO"%> --%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>


<!DOCTYPE html>
<html lang="en">
	<head>

	<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="Nacre Software Services Assesment"  />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<title>Client Management</title>

 <script type="text/javascript" src="${path}/assets/js/AvoidingBackButton.js">
	    
	    </script>
			
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/corporate_relation_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/corporaterelation_menu.jsp"></jsp:include>
			<div class="main-content">
				<div class="main-content-inner">
				
			

					<div class="page-content">
					
				
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Client Details</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
<!-- write your code here -->

<script src="${path}/js/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#hide").click(function(){
        $("p").hide();
    });
  
});
</script>











<div class='row' >
<div style='bgcolor:green'>
<span style='color:green'>

<%if(request.getAttribute("msg")!=null){ %>

<p class="alert alert-success" style="Text-align:Left; width:30%;"><%=request.getAttribute("msg")%><button type="button" class="close" id="hide" data-dismiss="modal">&times;</button>
</p>
<%} %>
</span>
</div> 
			

<div class="container-fluid">
	<div class="container">
	<div class="row" style="text-align: right;">
	
	<!-- <div class="container">
		<div class="row"> -->
			<div class="col-md-8" style="text-align: center; padding-top: 5px;">
				<!-- This Div for using Success_Msg display -->
				<div id='success-msg' class="success_msg" style="width:100%;">
				</div>
			</div>
			<!-- <div class="row"> -->
			<div class="col-md-8" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->
				<div id="error-msg" class="alert_msg" style="width: 40%;"></div>
			</div>
	<!-- 	</div>
	</div> -->

			<!-- Trigger the modal with a button -->
			<div class="col-md-10">
			
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#addNewClientDetails" onclick='addNewClients()'>Add Client</button>
				<hr />
			</div>
		</div>
	</div>
	<div 
		style="border: lightgray 1px solid; box-shadow: 5px 5px 5px lightgray; width:98%; text-align: center;">
		<div class="row" style="background-color: #848482; color: #fff; border: lightgray 1px solid; box-shadow: 5px 5px 5px lightgray; text-align: center;">
			<h4>
				<div class="col-md-2">
					<label>Client Name</label>
				</div>
				<div class="col-md-3">
					<label>Company Level</label>
				</div>
				<div class="col-md-3">
					<label>Company Description</label>
				</div>
				<div class="col-md-2">
					<label>Contact Details</label>
				</div>
				<div class="col-md-2">
					<label>Activity</label>
				</div>
			</h4>
		</div>
		<div class="row" id="row-container"
			style="background-color: #E5E4E2; padding:2%; height: auto; text-align: center;">
		</div>
		

	</div>


	
	<!-- ***********************************************************************************-->
    <!--                            This Modal For Add Client                               -->
	<!-- ********************************************************************************** -->
	
	
	<div id="addNewClientDetails" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content" style="background-color:#E5E4E2;">
				<div class="modal-header" style="background-color: #848482; color: #fff;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add Client Details</h4>
				</div>
				<div id="msgDiv"></div>
				<div id="addressDiv"></div>
				
				<div id="hidediv" class="modal-body" style="background-color: #E5E4E2;">
					<div class="container">
						<form action="<%=request.getContextPath()%>/AddClientManagementAction"
							  method="post" enctype="multipart/form-data"
							  class="form-horizontal" name="clientDetails" id="Add_form" >

               
							<div class="form-group">
							
								<label class="control-label col-sm-2" for="ClientName">Client
									Name:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="ClientName"  onblur="checkDuplicacy()"
										name="ClientName" placeholder="Enter Client Name" required="required">
								<input type='hidden' id='hideen' value=''name='clientId'>
										
								<span id="cv"></span>
								</div>
							</div>
							
							
						     <div class="form-group">
								<label class="control-label col-sm-2" for="s">Client
									Image:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="file" class="form-control" id="avatar" name="img"
										 placeholder="Enter image" required="required">
										 <img src="" class="img-rounded"  width="150" height="auto" id="img-previe-ADD">
										
									   <input type="hidden" value='' name="img"  id='img-hid'>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="control-label col-sm-2" for="Description">Description:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="description_add"
										name="Description" placeholder="Enter Description" required="required">
									<span id="description_add_msg"></span>
								</div>
							
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="Company_Level_Id">Company
									Level:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<select class="form-control" id="Company_Level"
										name="Company_Level_Id" required="required">
								</select>
	                               <span id="Company_Level_msg"></span>
								</div>
							
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2" for="contact_person_name">Contact
									Person Name:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control"
										id="contact_person_name" name="contact_person_name"
										placeholder="Enter Contact Person Name" required="required">
								<span id="contact_person_name_msg"></span>
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2"
									for="contact_person_mobile_no">Contact Person Mobile
									No:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control"
										id="contact_person_mobile_no" name="contact_person_mobile_no"
										placeholder="Enter Contact person Mobile no" required="required">
								<span id="contact_person_mobile_no_msg"></span>
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="contact_person_mail">Contact
									Person Mail:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control"
										id="contact_person_mail" name="contact_person_mail"
										placeholder="Ex: nacre_services2016@gmail.com" required="required">
								<span id="contact_person_mail_msg"></span>
								</div>
								
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4">Enter Client
									Address Details:</label>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="country">Country:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									
									<select class="form-control" id="country" name="country"
										onchange="setCountryId()" placeholder="Enter Country" required="required">
										<option value="">Select Country</option>
										</select>
									<span id="country_msg"></span>
								
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="state">State:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<select class="form-control" id="state" name="state"
										onchange="setStateId()" placeholder="Select State" required="required"></select>
								<span id="state_msg"></span>
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="city">City:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<select class="form-control" id="city" name="cityId"
										onchange="setCityId()" placeholder="Select City" required="required"></select>
								<span id="city_msg"></span>
								</div>
								
							</div>
							
						<div class="form-group">
								<label class="control-label col-sm-2" for="location">Location
									:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="location"
										name="location" placeholder="Enter location" required="required">
								<span id="location_msg"></span>
								</div>
							
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="pincode">Pincode
									:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="pincode"
										name="pincode" placeholder="Enter pincode" required="required">
								<span id="pincode_msg"></span>
								</div>
								
								
							</div>
							
							<div class="form-group" style='margin-left:17%;'>
							
									<button type="submit" class="btn btn-success" >Submit</button>&nbsp;&nbsp;
									<button type="reset" id='addformreset' class="btn btn-danger">Clear</button>
								
								</div>
								</form>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ***********************************************************************************-->
    <!--                            End Modal For Add Client                                -->
	<!-- ********************************************************************************** -->




	<!-- ***********************************************************************************-->
    <!--                            This Modal For View Client                              -->
	<!-- ********************************************************************************** -->
	 
	 <div id="myViewModal" class="modal fade" role="dialog">

		<div class="modal-dialog" style="float: left:5px;">

			<!-- Modal content-->
			<div class="modal-content">

				<div class="modal-header"
					style="background-color: #438EB9; color: #fff; width: 725px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Client Details</h4>
				</div>
				<div class="modal-body"
					style="background-color: #E5E4E2; float: left; width: 725px;">
					<div class="container">
						<div class="col-md-7">

							<FORM ACTION="#" METHOD="post" class="form-horizontal">
								
									<div class="row">
										<div>
											<div id="user-profile-1" class="user-profile row">
												<div class="col-xs-4 col-sm-3 center"
													style="top: 20px; float: left:400px">
													<div class="space-6"></div>
													<div style="margin:auto;">
														<span class="profile-picture" id="image" style="width:auto;"> 
														</span>

														<div class="space-8"></div>

														<div
															class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
															<div class="inline position-relative">
																<a href="#" class="user-title-label dropdown-toggle"
																	data-toggle="dropdown"> <i
																	class="ace-icon fa fa-circle light-green"></i> &nbsp; <span
																	class="white"></span>
																</a>

															</div>
														</div>
													</div>
												</div>
												<div class="col-xs-8 col-sm-8">
												<div class="row">
												<div class="col-sm-2"></div>
												<div class="col-sm-10">
													<div class='row'>
                                                     <div class="col-sm-12" style='background-color:#848482; color:#fff; border:1px solid lightgray; box-shadow:5px 5px 5px lightgray;'>
													  <label><strong>Client Name:</strong></label>
												
														<span class="editable" id="CLientName"></span>
													<br/>
														<label><strong>Description:</strong></label>
													
																<span class="editable" id="desc"></span>
													<br/>
															<label><strong>Company Level:</strong></label>
															
																<span class="editable" id="company_level_id"></span>
																<br/>
															</div>
															</div>
															<br/>
												<div class='row' id="viewAddress">
														
													</div>
													</div>
												</div>
												</div>	
												</div>
											</div>
										</div>
									
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>



<!-- ------------Model for Add More Address=------------------- -->


<!-- Modal -->
<div id="addMoreModel" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content" style="background-color:#E5E4E2;">
				<div class="modal-header" style="background-color: #848482; color: #fff;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add More Address</h4>
				</div>
			<div id='addfailermsg'></div>
					<div class="container">
						<form method='post' enctype="multipart/form-data"
							  class="form-horizontal" name="clientDetails" id="AddMoreAddrs_form" >
<br/>
          
							<div class="form-group">
								<label class="control-label col-sm-2" for="contact_person_name">Contact
									Person Name:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
								<input type='hidden' id='hidden' value='' name='clientId'>
						
									<input type="text" class="form-control"
										id="more_contact_person_name" name="contact_person_name"
										placeholder="Enter Contact Person Name" required="required">
								<span id="more_contact_person_name_msg"></span>
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2"
									for="contact_person_mobile_no">Contact Person Mobile
									No:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control"
										id="more_contact_person_mobile_no" name="contact_person_mobile_no"
										placeholder="Enter Contact person Mobile no" required="required">
								<span id="more_contact_person_mobile_no_msg"></span>
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="contact_person_mail">Contact
									Person Mail:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control"
										id="more_contact_person_mail" name="contact_person_mail"
										placeholder="EX: nacre_services2016@gmail.com" required="required">
								<span id="more_contact_person_mail_msg"></span>
								</div>
							
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4">Enter Client
									Address Details:</label>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="country">Country:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									
									<select class="form-control" id="country1" name="country"
										onchange="setCountryId1()" placeholder="Enter Country" required="required">
										<option value="">Select Country</option>
										</select>
									
								
								<span id="country_msg"></span>
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="state">State:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<select class="form-control" id="state1" name="state"
										onchange="setStateId1()" placeholder="Select State" required="required"></select>
								<span id="state_msg"></span>
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="city">City:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<select class="form-control" id="city1" name="cityId"
										onchange="setCityId1()" placeholder="Select City" required="required"></select>
								<span id="city_msg"></span>
								</div>
							
							</div>
							
						<div class="form-group">
								<label class="control-label col-sm-2" for="location">Location
									:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="more_location1"
										name="location" placeholder="Enter location" required="required">
								<span id="more_location_msg"></span>
								</div>
								
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="pincode">Pincode
									:<span style="color:red;">*</span></b></label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="more_pincode"
										name="pincode" placeholder="Enter pincode" required="required">
										<span id="more_pincode_msg"></span>
								</div>
								
								
							</div>
							<div class="form-group" style='margin-left:15%;'>
							
									<button type="button" onclick="AddMoreAddrsFunction()" class="btn btn-success" >Submit</button>&nbsp;&nbsp;
									<button type="reset" class="btn btn-danger">Clear</button>
								
								</div>
								</form>
								</div>
								</div>
								</div>
								</div>
								

	<!-- ***********************************************************************************-->
     <!--                            This Modal For Edit Client                             -->
     <!--*********************************************************************************** -->
	
	
	
<!-- Modal -->
<div id="myEditModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content" style='background-color:#E5E4E2;'>
      <div class="modal-header" style='background-color:#438EB9; color:#fff;'>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Client Details</h4>
      </div>
      <div class="modal-body">
      
      <div id='editsuccessmsg'></div>
      
         <form action="EditClientDetailsAction" id="Edit_Client_form" method="post" enctype="multipart/form-data">
				<input type='hidden' id='hid' value=''name='clientId'>
				<div class='row' >
					<div class='col-sm-3'>
						<br/>
									<span id="img-preview"><img class="img-rounded"  width="150" height="100"></span>
									
									<input type="hidden" value='' name="imgforedit" id='img-hid'>
									<input type="file" class="form-control" onchange='imgageEncoded()' style='width:151px; '>
									
				    </div>
				   <div class='col-sm-9'>
				      <div class='row'>
				      <div class='col-sm-1'></div>
				      <div class='col-sm-3'>
                             <label>Client Name: </label>
                       </div>
                       <div class='col-sm-5'>
							<input type="text" class="form-control" id="Client_name" name="ClientName">
						<div class=''>
								<span id="Client_name_msg"></span>
						</div>
						</div>	
						
				     </div><br/>
						 <div class='row'>
				      <div class='col-sm-1'></div>
				      <div class='col-sm-3'>			
								<label>Description: </label>
						 </div>
                       <div class='col-sm-5'>
									<input type="text" class="form-control" id="description"
										name="Description">
										<div class=''>		
								<span id="description_msg"></span><br/>
								</div>
							</div>	
						
				     </div><br/>
						 <div class='row'>
				      <div class='col-sm-1'></div>
				      <div class='col-sm-3'>   
							   <label>Company Level: </label>
							    </div>
                       <div class='col-sm-5'>
									<select class="form-control" id="Level_Id"
										name="Company_Level_Id" 
										required>
																			
									</select>
									<div class=''>	
								<span id="Level_Id_msg"></span><br/>
								</div>
						
								</div>	
								</div>
					 </div>
				</div>
				<div class='row'>
					
					<div class='col-sm-12' style='text-align:center;'>
				      <input id='clientDetailsUpdate' onclick="myEditFunction()" type='button' value='Update' class='btn btn-primary'>
				     
				    </div>
				</div>
		</form>
	
		</div>
		<form action=''>
		<div style='width:100%;'>
		<div style='padding:1%; border:1px lightgray solid; width:97%; margin:auto; box-shadow:5px 5px 5px lightgray;'>
		     <div class='row' style='padding:1%;'>
		     <div class='col-sm-6' style='text-align:left;'>
					  <input type='button' value='Add More Address' id='addMoreNewAddress' data-toggle='modal' data-target='#addMoreModel' class='btn-primary' id=''>
					</div>
					<div class='col-sm-6' style='text-align:right;'>
					  <input type='button' value='Edit Address' class='btn-primary' id='showAllAddress1'>&nbsp;&nbsp;
					<input type='button'  value='Close' class='btn-primary' id='adsClose' style='display:none;'>
					</div>
				</div>	
					 <div class='row' id='addAllAddress' style='padding:1%;'>
		    
		              </div>
					
				</div>
				
				<br/>
		
		  </div>
		</form>
		
      </div>
     
    </div>

  </div>

	
	<!-- ***********************************************************************************-->
     <!--                            This Modal For Edit Client Address                             -->
     <!--*********************************************************************************** -->
	
	
	
<!-- Modal -->
<div id="myEditAddresModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style='background-color:#438EB9; color:#fff;'>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Client Address Details</h4>
      </div>
      <div class="modal-body" style="background-color: #E5E4E2;">
        <form action="EditClientContactDetailsAction" id='editAdsDetails-form' method="post" enctype="multipart/form-data">
        <div id='adsfailermsg'></div>
        <input type='hidden' value='' name='addressId' id='adsid'>
		   <div class='row'>
			   <div class='col-sm-1'></div>
			   <div class='col-sm-3'>
					Contact Person Name:
				</div>
				 <div class='col-sm-6'>
										<input type="text" class="form-control"
											id="contact_person" name="contact_person_name">
				<div class=''>				
									<span id="contact_person_msg"></span><br/><br/>
				   </div>
				</div>
					
			</div>
			
			 <div class='row'>
			   <div class='col-sm-1'></div>
			   <div class='col-sm-3'>
							Contact Person Mobile No:
					</div>
				 <div class='col-sm-6'>
									<input type="text" class="form-control"
										id="person_mobile_no" name="contact_person_mobile_no">
					<div class=''>		
								<span id="person_mobile_no_msg"></span><br/><br/>
						</div>
						</div>
					
			</div>
			
			 <div class='row'>
			   <div class='col-sm-1'></div>
			   <div class='col-sm-3'>	
							Contact Person Mail:
					</div>
				 <div class='col-sm-6'>			
									<input type="text" class="form-control"
										id="person_mail" name="contact_person_mail" placeholder="Ex: nacre_services2016@gmail.com">
					
					<div class=''>			
								<span id="person_mail_msg"></span><br/><br/>
						</div>
					
						</div>
								</div>
			
			 <div class='row'>
			   <div class='col-sm-1'></div>
			   <div class='col-sm-3'>	
								
								Country:
					</div>
				 <div class='col-sm-6'>				
									<select class="form-control" id="countryId" name="country"
										 placeholder="Select Country"></select>
					<div class=''>				
								<span id="countryId_msg"></span><br/><br/>
						</div>
					
					</div>
								</div>
			
			 <div class='row'>
			   <div class='col-sm-1'></div>
			   <div class='col-sm-3'>	
								
								State:
						</div>
				 <div class='col-sm-6'>				
									<select class="form-control" id="stateId" name="state"
										 placeholder="Select State"></select>
				<div class=''>				
								<span id="stateId_msg"></span><br/><br/>
						</div>
					</div>
					
			</div>
			
			 <div class='row'>
			   <div class='col-sm-1'></div>
			   <div class='col-sm-3'>	
									
								City:
						</div>
				 <div class='col-sm-6'>			
									<select class="form-control" id="cityId" name="cityId"
										 placeholder="Select City"></select>
					<div class=''>			
								<span id="cityId_msg"></span><br/><br/>
						</div>
					
						</div>
								</div>
			
			 <div class='row'>
			   <div class='col-sm-1'></div>
			   <div class='col-sm-3'>	
								Location:
									</div>
				 <div class='col-sm-6'>		
									<input type="text" class="form-control" id="locationId"
										name="location" placeholder="Enter location">
					<div class=''>				
								<span id="locationId_msg"></span><br/><br/>
								</div>
					
					</div>
								</div>
			
			 <div class='row'>
			   <div class='col-sm-1'></div>
			   <div class='col-sm-3'>	
							Pincode:
								</div>
				 <div class='col-sm-6'>		
									<input type="text" class="form-control" id="pincodeId"
										name="pincode" placeholder="Enter pincode">
						<div class=''>		
								<span id="pincodeId_msg"></span><br/><br/>
						</div>
						</div>
					
			</div>
			<hr/>
			 <div style='text-align:center'>
			   <input type='button' id='updateAddress' onclick='myEditAdsFunction()' value='Update' class='btn btn-primary'>
			   <input type='reset'  value='Reset' class='btn btn-danger'>
			 </div>
						
				<div style='box-shadow:5px 5px 5px lightgray; height:30px;'>
				</div>
				
				</form>
			</div>			
					</div>
					
      </div>
     
    </div>


	
		
 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

	<!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

  
  <!-- ***********************************************************************************-->
  <!--                            Start Jquery Add Client form Validation                 -->
  <!--*********************************************************************************** -->
  
  
  <script type="text/javascript">
 
   // When the browser is ready...
 
 $('document').ready(function(){
	
 
	// Setup form validation on the client name
	 $("#ClientName").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z]/);
		if(reg.test(val)){
			$("#cv").html("This is Valid");

			$('#cv').css("color","green");
		}
		else{
			$('#cv').html("This is invalid");
			$('#cv').css("color","red");
			
		}
		
	 });
	
	// Setup form validation on the client description
	 $("#description_add").on("blur",function(){
		var val= $(this).val();
		 var reg = new RegExp(/^[a-z A-Z 0-9]/);
		if(reg.test(val)){
			$("#description_add_msg").html("This is Valid");

			$('#description_add_msg').css("color","green");
		}
		else{
			$('#description_add_msg').html("This is invalid");
			$('#description_add_msg').css("color","red");
			
		}
		
	 });
	 

	
	//validation for level
		$("#Company_Level").on('blur',function(){
			 var valueLevel = $(this).val();
			 var reg = new RegExp(/^[-1]/);
			 if(valueLevel==-1){
				
				 $('#Company_Level_msg').html("This is Invalid");
				 $('#Company_Level_msg').html("Select atleast one level ");
				 $('#Company_Level_msg').css("color","red");
			 }
			 else{
				 $('#Company_Level_msg').html("This is valid");
				 $('#Company_Level_msg').css("color","green");
			 }
	 	 });
	// Setup form validation on the contact person name
	 $("#contact_person_name").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z]/);
		if(reg.test(val)){
			$("#contact_person_name_msg").html("This is Valid");
			

			$('#contact_person_name_msg').css("color","green");
		}
		else{
			$('#contact_person_name_msg').html("This is invalid");
			$('#contact_person_name_msg').html("Name must contain characters only");
			$('#contact_person_name_msg').css("color","red");
			
		}
		
	 });
	
	/// mobile no validation
		$("#contact_person_mobile_no").on('blur',function(){
			
				var val = $(this).val();
				 var reg = new RegExp(/^[0]?[789]{1}\d{9}$/);
				if(!reg.test(val)){
				$('#contact_person_mobile_no_msg').html("This is Invalid");
				$('#contact_person_mobile_no_msg').html("Mobile no must be start with 7 or 8 or 9 and It should be 10 digit");
				$('#contact_person_mobile_no_msg').css("color","red");
			 }
			 else{	
				 $('#contact_person_mobile_no_msg').html("This is valid");
				 $('#contact_person_mobile_no_msg').css("color","green");
			 }
	 	 });
	// gmail validation	
	
	    $("#contact_person_mail").on('blur',function(){
			
				var val = $(this).val();
				 var reg = new RegExp(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
				if(!reg.test(val)){
					 $('#contact_person_mail_msg').html("This is Invalid");
					 //$('#contact_person_mail_msg').html("Eg: <b>nacre_software2016@gmail.com</b>");
				 $('#contact_person_mail_msg').css("color","red");
			 }
			 else{	
				 $('#contact_person_mail_msg').html("This is valid");
				 $('#contact_person_mail_msg').css("color","green");
			 }
	 	 });
	
	//validation for country
			$("#country").on('blur',function(){
			
				var countryValLEvel = $(this).val();
				 var reg = new RegExp(/^[-1]/);
				if(countryValLEvel== -1){
					 $('#country_msg').html("This is Invalid");
					 $('#country_msg').html("Select atleast one country");
				 $('#country_msg').css("color","red");
			 }
			 else{	
				 $('#country_msg').html("This is valid");
				 $('#country_msg').css("color","green");
			 }
	 	 });
	
			//validation for state
			$("#state").on('blur',function(){
			
				var stateValLEvel = $(this).val();
				 var reg = new RegExp(/^[-1]/);
				if(stateValLEvel== -1){
					 $('#state_msg').html("This is Invalid");
					 $('#state_msg').html("Select atleast one state");
				 $('#state_msg').css("color","red");
			 }
			 else{	
				 $('#state_msg').html("This is valid");
				 $('#state_msg').css("color","green");
			 }
	 	 });
			
			//validation for city
			$("#city").on('blur',function(){
			
				var cityValLEvel = $(this).val();
				 var reg = new RegExp(/^[-1]/);
				if(cityValLEvel== -1){
					 $('#city_msg').html("This is Invalid");
					 $('#city_msg').html("select atleast one city");
				 $('#city_msg').css("color","red");
			 }
			 else{	
				 $('#city_msg').html("This is valid");
				 $('#city_msg').css("color","green");
			 }
	 	 });
			
			// Setup form validation on location
			 $("#location").on('blur',function(){
				 var val = $(this).val();
				 var reg = new RegExp(/^[a-z A-Z 0-9]/);
				 if(reg.test(val)){
					 $('#location_msg').html("This is valid");
					 $('#location_msg').css("color","green");
				 }
				 else{
					 $('#location_msg').html("This is Invalid");
					 $('#location_msg').css("color","red");
				 }
		 	 });
			
			/* //picode validation ^[1-9][0-9]{5}$
			
		$("#pincode").on('blur',function(){
			
				var val = $(this).val();
				 var reg = new RegExp(/^[1-9][0-9]{5}$/);
				if(!reg.test(val)){
					 $('#pincode_msg').html("This is Invalid");
					 $('#pincode_msg').html("Pincode must contain 6 digit only ");
				 $('#pincode_msg').css("color","red");
			 }
			 else{	
				 $('#pincode_msg').html("This is valid");
				 $('#pincode_msg').css("color","green");
			 }
	 	 }); */
			
		// Pincode validation 
			 $("#pincode").on('blur',function(){
					
					var val = $(this).val();
					
					 var reg = new RegExp(/^[1-9][0-9]{5}$/);
					 if(val==''){
						 $('#pincode_msg').html("This is Invalid");
					 }
					 else if(!reg.test(val)){
						 $('#pincode_msg').html("Pincode must contain 6 digits");
					 $('#pincode_msg').css("color","red");
				 }
				 else{	
					 $('#pincode_msg').html("This is valid");
					 $('#pincode_msg').css("color","green");
				 }
		 	 });

 });
	
  </script>
  <!-- ******End*** Jquery Add Client form Validation ******-->
  
  
  <!-- ***********************************************************************************-->
  <!--                            Start Jquery Add More Contact Details Validation                -->
  <!--*********************************************************************************** -->
  
  
  <script type="text/javascript">
 
   // When the browser is ready...
 
 $('document').ready(function(){
	
 

	// Setup form validation on the contact person name
	 $("#more_contact_person_name").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z]/);
		if(reg.test(val)){
			$("#more_contact_person_name_msg").html("This is Valid");

			$('#more_contact_person_name_msg').css("color","green");
		}
		else{
			$('#more_contact_person_name_msg').html("This is invalid");
			$('#more_contact_person_name_msg').html("Name must contain characters only");
			$('#more_contact_person_name_msg').css("color","red");
			
		}
		
	 });
	
	/// mobile no validation
		$("#more_contact_person_mobile_no").on('blur',function(){
			
				var val = $(this).val();
				 var reg = new RegExp(/^[0]?[789]{1}\d{9}$/);
				if(!reg.test(val)){
					 $('#more_contact_person_mobile_no_msg').html("This is Invalid");
					 $('#more_contact_person_mobile_no_msg').html("Mobile no must be start with 7 or 8 or 9 and It should be 10 digit");
				 $('#more_contact_person_mobile_no_msg').css("color","red");
			 }
			 else{	
				 $('#more_contact_person_mobile_no_msg').html("This is valid");
				 $('#more_contact_person_mobile_no_msg').css("color","green");
			 }
	 	 });
	// gmail validation	
	
	    $("#more_contact_person_mail").on('blur',function(){
			
				var val = $(this).val();
				 var reg = new RegExp(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
				if(!reg.test(val)){
					 $('#more_contact_person_mail_msg').html("This is Invalid");
				 $('#more_contact_person_mail_msg').css("color","red");
			 }
			 else{	
				 $('#more_contact_person_mail_msg').html("This is valid");
				 $('#more_contact_person_mail_msg').css("color","green");
			 }
	 	 });
	
	//validation for country
			$("#country").on('blur',function(){
			
				var countryValLEvel = $(this).val();
				 var reg = new RegExp(/^[-1]/);
				if(countryValLEvel== -1){
					 $('#country_msg').html("This is Invalid");
					// $('#country_msg').html("Select atleast one country");
				 $('#country_msg').css("color","red");
			 }
			 else{	
				 $('#country_msg').html("This is valid");
				 $('#country_msg').css("color","green");
			 }
	 	 });
	
			//validation for state
			$("#state").on('blur',function(){
			
				var stateValLEvel = $(this).val();
				 var reg = new RegExp(/^[-1]/);
				if(stateValLEvel== -1){
					 $('#state_msg').html("This is Invalid");
					// $('#state_msg').html("Select atleast one state");
				 $('#state_msg').css("color","red");
			 }
			 else{	
				 $('#state_msg').html("This is valid");
				 $('#state_msg').css("color","green");
			 }
	 	 });
			
			//validation for city
			$("#city").on('blur',function(){
			
				var cityValLEvel = $(this).val();
				 var reg = new RegExp(/^[-1]/);
				if(cityValLEvel== -1){
					 $('#city_msg').html("This is Invalid");
					 $('#city_msg').html("Select atleast one city");
				 $('#city_msg').css("color","red");
			 }
			 else{	
				 $('#city_msg').html("This is valid");
				 $('#city_msg').css("color","green");
			 }
	 	 });
			
			// Setup form validation on location
			 $("#more_location1").on('blur',function(){
				 var val = $(this).val();
				 var reg = new RegExp(/^[a-z A-Z 0-9]/);
				 if(reg.test(val)){
					 $('#more_location_msg').html("This is valid");
					 $('#more_location_msg').css("color","green");
				 }
				 else{
					 $('#more_location_msg').html("This is Invalid");
					 $('#more_location_msg').css("color","red");
				 }
		 	 });
			
		// Pincode validation 
		 $("#more_pincode").on('blur',function(){
				
				var val = $(this).val();
				
				 var reg = new RegExp(/^[1-9][0-9]{5}$/);
				 if(val==''){
					 $('#more_pincode_msg').html("This is Invalid");
				 }
				 else if(!reg.test(val)){
					 $('#more_pincode_msg').html("Pincode must contain 6 digits");
				 $('#more_pincode_msg').css("color","red");
			 }
			 else{	
				 $('#more_pincode_msg').html("This is valid");
				 $('#more_pincode_msg').css("color","green");
			 }
	 	 });
	
 });
	
  </script>
  <!-- ******End*** Jquery Add More Contact Details Validation ******-->



  <!-- ***********************************************************************************-->
  <!--                        Start Jquery Edit Client form Validation                    -->
  <!--*********************************************************************************** -->
  
 <script type="text/javascript">
   // When the browser is ready...
 
   
   
 $('document').ready(function(){
	
 
	// Setup form validation on the client name
	 $("#Client_name").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z]/);
		if(reg.test(val)){
			$("#Client_name_msg").html("This is Valid");

			$('#Client_name_msg').css("color","green");
		}
		else{
			$('#Client_name_msg').html("This is invalid");
			$('#Client_name_msg').css("color","red");
			
		}
		
	 });
	
	// Setup form validation on the client description
	 $("#description").on("blur",function(){
		var val= $(this).val();
		 var reg = new RegExp(/^[a-z A-Z 0-9]/);
		if(reg.test(val)){
			$("#description_msg").html("This is Valid");

			$('#description_msg').css("color","green");
		}
		else{
			$('#description_msg').html("This is invalid");
			$('#description_msg').css("color","red");
			
		}
		
	 });
	 

	
	//validation for level
		$("#Level_Id").on('blur',function(){
			 var valueLevel = $(this).val();
			 var reg = new RegExp(/^[-1]/);
			 if(valueLevel==-1){
				
				 $('#Level_Id_msg').html("This is Invalid");
				 $('#Level_Id_msg').html("Select atleast one level");
				 $('#Level_Id_msg').css("color","red");
			 }
			 else{
				 $('#Level_Id_msg').html("This is valid");
				 $('#Level_Id_msg').css("color","green");
			 }
	 	 });
	// Setup form validation on the contact person name
	 $("#contact_person").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z]/);
		if(reg.test(val)){
			$("#contact_person_msg").html("This is Valid");

			$('#contact_person_msg').css("color","green");
		}
		else{
			$('#contact_person_msg').html("This is invalid");
			$('#contact_person_msg').html("Name must contain characters only");
			$('#contact_person_msg').css("color","red");
			
		}
		
	 });
	
	/// mobile no validation
		$("#person_mobile_no").on('blur',function(){
			
				var val = $(this).val();
				// var reg = new RegExp(/^[0]?[789]\d{9}$/);
				 var reg = new RegExp(/^[0]?[789]{1}\d{9}$/);
				if(!reg.test(val)){
					 $('#person_mobile_no_msg').html("This is Invalid");
					 $('#person_mobile_no_msg').html("Mobile no must be start with 7 or 8 or 9 and It should be 10 digit");
				 $('#person_mobile_no_msg').css("color","red");
			 }
			 else{	
				 $('#person_mobile_no_msg').html("This is valid");
				 $('#person_mobile_no_msg').css("color","green");
			 }
	 	 });
		// gmail validation	
		
	    $("#person_mail").on('blur',function(){
			
				var val = $(this).val();
				 var reg = new RegExp(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
				if(!reg.test(val)){
					 $('#person_mail_msg').html("This is Invalid");
				 $('#person_mail_msg').css("color","red");
			 }
			 else{	
				 $('#person_mail_msg').html("This is valid");
				 $('#person_mail_msg').css("color","green");
			 }
	 	 });
		
	//validation for country
			$("#countryId").on('blur',function(){
			
				var countryValLEvel = $(this).val();
				 var reg = new RegExp(/^[-1]/);
				if(countryValLEvel== -1){
					 $('#countryId_msg').html("This is Invalid");
					 $('#countryId_msg').html("Select atleast one country");
				 $('#countryId_msg').css("color","red");
			 }
			 else{	
				 $('#countryId_msg').html("This is valid");
				 $('#countryId_msg').css("color","green");
			 }
	 	 });
	
			//validation for state
			$("#stateId").on('blur',function(){
			
				var stateValLEvel = $(this).val();
				 var reg = new RegExp(/^[-1]/);
				if(stateValLEvel== -1){
					 $('#stateId_msg').html("This is Invalid");
					 $('#stateId_msg').html("Select atleast one state");
				 $('#stateId_msg').css("color","red");
			 }
			 else{	
				 $('#stateId_msg').html("This is valid");
				 $('#stateId_msg').css("color","green");
			 }
	 	 });
			
			//validation for city
			$("#cityId").on('blur',function(){
			
				var cityValLEvel = $(this).val();
				 var reg = new RegExp(/^[-1]/);
				if(cityValLEvel== -1){
					 $('#cityId_msg').html("This is Invalid");
					 $('#cityId_msg').html("Select atleast one city");
				 $('#cityId_msg').css("color","red");
			 }
			 else{	
				 $('#cityId_msg').html("This is valid");
				 $('#cityId_msg').css("color","green");
			 }
	 	 });
			
					
			
			// Setup form validation on location
			 $("#locationId").on('blur',function(){
				 var val = $(this).val();
				 var reg = new RegExp(/^[a-z A-Z 0-9]/);
				 if(reg.test(val)){
					 $('#locationId_msg').html("This is valid");
					 $('#locationId_msg').css("color","green");
				 }
				 else{
					 $('#locationId_msg').html("This is Invalid");
					 $('#locationId_msg').css("color","red");
				 }
		 	 });
			// Pincode validation 
			 $("#pincodeId").on('blur',function(){
					
					var val = $(this).val();
					
					 var reg = new RegExp(/^[1-9][0-9]{5}$/);
					 if(val==''){
						 $('#pincodeId_msg').html("This is Invalid");
					 }
					 else if(!reg.test(val)){
						 $('#pincodeId_msg').html("Pincode must contain 6 digits");
					 $('#pincodeId_msg').css("color","red");
				 }
				 else{	
					 $('#pincodeId_msg').html("This is valid");
					 $('#pincodeId_msg').css("color","green");
				 }
		 	 });
	
 });
   
	
  </script>
  
  <!-- ******End*** Jquery Edit Client form Validation ******-->
 
 

  <!-- ***********************************************************************************-->
  <!--                            Ajax call for Add Client Details                        -->
  <!--*********************************************************************************** -->
 <script>
  function addNewClients(){
  
  $('#hidediv').show();
  $('#addressDiv').hide();
  $('#msgDiv').html('');
  $('#addformreset').trigger('click');
  }
  
  </script>
  	<script>
  	  
  	function checkDuplicacy(){
		var client=$("#ClientName").val();
		 var clientName=client.trim();
		if(clientName!=''){
		$.ajax({
			   url:"<%=application.getContextPath()%>/CheckDuplicateClientAction",
			   data:{"clientName":clientName},
			   success:function(data){
						
						
						$('#hidden').val(data[1][0].clientId); 
						
						
						
						if(data[0]!=0){
						
							$('#hidediv').hide();
							 $('#addressDiv').show();

							//var clientId=$("#hideen").html(data[1][ind].ClientId);

							$('#addressDiv').empty();
							$('#msgDiv').html("<div class='alert alert-danger'><h4 style='text-align:center;'>This client is already exist.</h4></div>");
							for(var ind=0; ind<data[1].length; ind++){
							$('#addressDiv').append("<div style='width:100%'>"+
								"<div style='width:60%; margin:auto;padding:1%;background:#fff; border:1px solid #848482; border-radius:15px; box-shadow:5px 5px 5px lightgray;'>"+
								"<h5 style='color:#438EB9;'>"+data[1][ind].ClientName+": "+data[1][ind].Location+", "+data[1][ind].City+", "+data[1][ind].Country+" - "+data[1][0].Pincode+"</h5>"+
								" <strong>Contact Person Name: </strong> "+data[1][ind].ContactPresonName+",<br/>"+
								"<strong>Email ID: </strong> "+data[1][ind].ContactPresonNameEmail+",<br/>"+
								"<strong>Mob: </strong>"+data[1][ind].ContactPresonMobileNO+" <br/></div><br/>");
							}
							$('#addressDiv').append("<center><input type='button' class='btn btn-info btn-lg' id='addMoreNewAddres' data-toggle='modal' data-target='#addMoreModel' value='Add More Address'/></center><hr/>");
						}
						
						
				},//sucess
			  error:function(){
											
						alert("please try later");
				}		
			});
		}
	}



</script>
 
	

<script>
	$('document').ready(function(){

		$.ajax({
		   url:"<%=application.getContextPath()%>/GetCompanyLevelAction",
		   success:function(level){
				
					$('#Company_Level').empty();
		    		$('#Company_Level').append("<option value='-1'>Select Level</option>");
					for (var ind = 0; ind < level.length; ind++) {
						$('#Company_Level').append("<option value='"+level[ind].levelId+"'>"+level[ind].level+"</option>");			
					} 
			},//sucess
		  error:function(){
										
					alert("please try later");
		}		
		});
							 
							 
	$.ajax({
		 url:"<%=application.getContextPath()%>/GetCountryAction",
	     success:function(countries){
		  		$('#country').empty();
				$('#country').append("<option value='-1'>Select Country</option>");
				for (var ind = 0; ind < countries.length; ind++) {
		     		$('#country').append("<option   value='"+countries[ind].countryId+"'>"+countries[ind].country+"</option>");			
				}
		  },
		 error:function(){
				alert("please try later");
		  }
									
	});
						
    $('#country').change(function(){
		var cId= $('#country').val();
						
	$.ajax({
	    url:"<%=application.getContextPath()%>/GetStateAction",
		data:{"countryId":cId},
		success:function(states){
		    $('#state').empty();
			$('#state').append("<option value='-1'>Select State</option>");
			for (var ind = 0; ind < states.length; ind++) {
				$('#state').append("<option   value='"+states[ind].stateId+"'>"+states[ind].state+"</option>");			
			}
											
		},
		error:function(){
											
			alert("please try later");
		}
										
	});
 });
			
	$('#state').change(function(){
		var sId=	$('#state').val();
	  $.ajax({
		 url:"<%=application.getContextPath()%>/GetCityAction",
		 data:{"stateId":sId},
		 success:function(cities){
		  	$('#city').empty();
			$('#city').append("<option value='-1'>Select city</option>");
			for (var ind = 0; ind < cities.length; ind++) {
				$('#city').append("<option   value='"+cities[ind].cityId+"'>"+cities[ind].city+"</option>");			
			}
							
		},
		error:function(){
												
			alert("please try later");
		}
											
   });
}); 
	
	
	$.ajax({
		 url:"<%=application.getContextPath()%>/GetCountryAction",
	     success:function(countries){
		  		$('#country1').empty();
				$('#country1').append("<option value='-1'>Select Country</option>");
				for (var ind = 0; ind < countries.length; ind++) {
		     		$('#country1').append("<option   value='"+countries[ind].countryId+"'>"+countries[ind].country+"</option>");			
				}
		  },
		 error:function(){
				alert("please try later");
		  }
									
	});
						
   $('#country1').change(function(){
		var cId= $('#country1').val();
						
	$.ajax({
	    url:"<%=application.getContextPath()%>/GetStateAction",
		data:{"countryId":cId},
		success:function(states){
		    $('#state1').empty();
			$('#state1').append("<option value='-1'>Select State</option>");
			for (var ind = 0; ind < states.length; ind++) {
				$('#state1').append("<option   value='"+states[ind].stateId+"'>"+states[ind].state+"</option>");			
			}
											
		},
		error:function(){
											
			alert("please try later");
		}
										
	});
});
			
	$('#state1').change(function(){
		var sId=	$('#state1').val();
	  $.ajax({
		 url:"<%=application.getContextPath()%>/GetCityAction",
		 data:{"stateId":sId},
		 success:function(cities){
		  	$('#city1').empty();
			$('#city1').append("<option value='-1'>Select city</option>");
			for (var ind = 0; ind < cities.length; ind++) {
				$('#city1').append("<option   value='"+cities[ind].cityId+"'>"+cities[ind].city+"</option>");			
			}
							
		},
		error:function(){
												
			alert("please try later");
		}
											
  });
}); 

	
	
});
	</script>
	
<!-- ************************************************************************************** -->
<!--                    Modal for view Client at the time of loading                        -->		
<!-- ************************************************************************************** -->	
	
<script>
var cId="";
  //$('document').ready(function(){
	viewonload();  
	  function viewonload(){
	 $.ajax({
			url:"<%=application.getContextPath()%>/ViewClientsDetailsAction",
			success:function(obj){
				
                    	$("#row-container").empty();
                    	if(obj==''){
                        	$("#row-container").html("<span style='color:red'><strong>RECORDS ARE NOT AVAILABLE</strong></span>");
                        	}
            for (var i= 0; i < obj.length; i++) {
	           var s="<div class='row' style='background-color: #E5E4E2; padding: 5px; height: auto; text-align: center;'>";	        		  	
	               s+="<div class='col-md-2' id='cname'><label>"+obj[i][0].clientName+"</label></div>"
	               s+="<div class='col-md-3'><label>"+obj[i][1].level+"</label></div>"
	               s+="<div class='col-md-3'><label>"+obj[i][0].clientDescription+"</label></div>"
	               s+=" <div class='col-md-2'> <input class='btn btn-primary' type='button' cId='"+obj[i][0].clientId+"'   name='view' data-toggle='modal' data-target='#myViewModal' value='View'></div>"
	               s+=" <div class='col-md-2'><input class='btn btn-primary' type='button'  cIdEdit='"+obj[i][0].clientId+"'  name='edit'data-toggle='modal' data-target='#myEditModal' value='Edit'></div>"
	  	           s+="</div>"
	               $("#row-container").append(s);
            }//outer for 
            
   
      /* ***************************************************************************************/
     /*             Modal for view details of client when view button is clicked              */
     /* ***************************************************************************************/
     
			$("input[cId]").on("click",function(){
			
				var clientId= $(this).attr("cId");
					
					 $.ajax({
							url:"<%=application.getContextPath()%>/ViewClientAction",
							data :{"clientId" : clientId},
							success:function(obj){
								
								if(obj[0][0].clientImage!=""){
									$("#image").html("<img class='img-rounded' style='width:140px; height:100px; ' src='"+obj[0][0].clientImage+"'/>");
								}
								else{
									$("#image").html("<img alt='No Image Found'/>");
								}
								$("#CLientName").html(obj[0][0].clientName);
					            $("#desc").html(obj[0][0].clientDescription);
								$("#company_level_id").html(obj[0][3].level);
								
								$("#viewAddress").empty();
								for(var ind=0; ind<obj.length; ind++){
									var count=ind+1;
									$("#viewAddress").append("<div class='col-sm-12' style='border:1px solid #848482;''>"+
									"<h5 style='background-color:#848482;color:#fff;padding:5px;'>"+
									"<strong>Address"+count+": </strong></h5>"+
									" <strong>Contact Person Name: </strong>"+obj[ind][1].contactPresonName+", <br/>"+
									"<strong>Email: </strong>"+obj[ind][1].contactPresonNameEmail +", <br/>"+
									"<strong>Mob: </strong>"+obj[ind][1].contactPresonMobileNO +", <br/>"+
									"<strong>Location: </strong>"+obj[ind][2].location+", "+obj[ind][4].city+", "+obj[ind][5].state+", "+
									obj[ind][6].country+" - "+obj[ind][2].pincode+"</div><br/><br/>");
								
								}
								
							},//sucess
							error:function(){
								
								alert("please try later");
							}
							
						});
			
				
			});
            
/* ***************************************************************************************/
/*             Modal for edit details of client when edit button is clicked              */
 /* ***************************************************************************************/
		     
            
			$("input[cIdEdit]").on("click",function(){
				
				$("#editsuccessmsg").html("");
				$("#showAllAddress1").show();
				$("#adsClose").hide();
				$('#addAllAddress').hide();
				
					var clientId= $(this).attr("cIdEdit");
						
						cId=clientId;
						$("#hid").val(clientId);
						$('#hidden').val(clientId); 
						 $.ajax({
								url:"<%=application.getContextPath()%>/ViewClientAction",
								data :{"clientId" : clientId},
								success:function(obj){
									$("#img-preview").empty();
									
								if(obj[0][0].clientImage!=""){
									
									$("input[name=imgforedit]").val(obj[0][0].clientImage);
									
									//alert($("input[name=imgforedit]").val());
									
									$("#img-preview").html("<img  style='width:150px; height:100px; ' src='"+obj[0][0].clientImage+"'/>");
								}
								else{
									$("#img-preview").html("<img alt='No Image Found'/>");
								}
								
									$("#Client_name").val(obj[0][0].clientName);
									
									$("#description").val(obj[0][0].clientDescription);
								    $("#Level_Id").val(obj[0][3].levelId);
								  	
								},//sucess
								error:function(){
									
									alert("please try later");
								}
								
							});
						 
								
				});
				

				
			
			//$('.selectpicker').selectpicker('refresh');
			
			},//sucess
			error:function(){
				
				alert("please try later");
			}
			
		}); 
	  }
	 
	 $("#Edit_Client_form input[type=file]").change(function(){ 
		 readImage($("#Edit_Client_form input[type=file]").eq(0)).done(function(base64Data){ 
			 //alert(base64Data); 
			 var img=new Image();
			
			 $("#img-preview").html( "<img  style='width:150px; height:100px;' src='"+base64Data+"'/>"); 
		
		 });
	});
	 
	 $("#Add_form input[type=file]").change(function(){ 
		 readImage($("#Add_form input[type=file]").eq(0)).done(function(base64Data){ 
			 //alert(base64Data);
			  
		 $("#img-previe-ADD").attr("src",base64Data);
		 
		 
		 });
	});
		//});
	
	
	</script>
	
	<script>
  	$("#adsClose").on("click",function(){
  		
		$("#adsClose").hide();
		$("#showAllAddress1").show();
		$('#addAllAddress').hide();
  	});
  	
  	
	$("#showAllAddress1").on("click",function(){
		
		$("#showAllAddress1").hide();
		$("#adsClose").show();
		$('#addAllAddress').show();
		var client=$("#Client_name").val();
		
		var clientName=client.trim();
		if(clientName!=''){
		$.ajax({
			   url:"<%=application.getContextPath()%>/CheckDuplicateClientAction",
			   data:{"clientName":clientName},
			   success:function(data){
						
						$('#hidden').val(data[1][0].clientId); 
						
						if(data[0]!=0){
						
							$('#hidediv').hide();
							$('#addAllAddress').empty();
							
							for(var ind=0; ind<data[1].length; ind++){
								
								var count=ind+1;
						$('#addAllAddress').append("<div class='row' style='padding:3%;'><div class='col-sm-12'><div class='row' style='background-color:#848482; color:#fff; padding:2px;'><input type='hidden' value='"+data[1][ind].addressId+"'>"
						+"<div class='col-sm-10'>Address"+count+"</div><div class='col-sm-2'><input class='btn-primary' type='button'  adsIdEdit='"+data[1][ind].addressId+"' name='adsEdit' data-toggle='modal' data-target='#myEditAddresModal'  value='edit'></div></div>"+
						"<div class='row'><div class='col-sm-12'><strong>"+data[1][ind].ClientName+": "+data[1][ind].Location+", "+data[1][ind].City+", "+data[1][ind].State+", "+data[1][ind].Country+" - "+data[1][0].Pincode+"</strong></div></div>"
						+"<div class='row'><div class='col-sm-12'> <strong>Contact Person Name: </strong> "+data[1][ind].ContactPresonName+",<br/>"
						+"<strong>Email ID: </strong> "+data[1][ind].ContactPresonNameEmail+",<br/>"
						+"<strong>Mob: </strong>"+data[1][ind].ContactPresonMobileNO+" </div></div><div></div></div><br/>");
								}
							//$('#addAllAddress').append("<center><input type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#addMoreModel' value='Add More Address'/></center><hr/>");
						}
						
						applyEditAddressEvent();
						
				},//sucess
			  error:function(){
											
						alert("please try later");
				}		
			});
		}
		});

	</script>
  
	
	
	<!-- --------------------------------------------------------------------- -->
	<!-- --------------View Address for Edit Address Details------------------ -->
	<!-- --------------------------------------------------------------------- -->
	
	
	<script>
	function applyEditAddressEvent(){
	$("input[adsIdEdit]").on("click",function(){
		
			var addressId= $(this).attr("adsIdEdit");
			
			$('#adsid').val(addressId);
				
			$('#adsfailermsg').html('');	
				 $.ajax({
						url:"<%=application.getContextPath()%>/ViewClientContactAddress",
						data :{"addressId" : addressId},
						success:function(address){
							
							 $("#contact_person").val(address.ContactPresonName);
							    $("#person_mobile_no").val(address.ContactPresonMobileNO);
								$("#person_mail").val(address.ContactPresonNameEmail);
								$("#locationId").val(address.Location);
								$("#pincodeId").val(address.Pincode);
								
								
								$.ajax({
									url:"<%=application.getContextPath()%>/GetCountryAction",
									success:function(countries){
										$('#countryId').empty();
										$('#countryId').append("<option value=''>Select Country</option>");
										for (var ind = 0; ind < countries.length; ind++) {
																					
											if(address.countryId==countries[ind].countryId){
												
											$('#countryId').append("<option   value='"+countries[ind].countryId+"' selected>"+countries[ind].country+"</option>");			
										      }else{
												$('#countryId').append("<option   value='"+countries[ind].countryId+"'>"+countries[ind].country+"</option>");	
												}
											}
									},
									error:function(){
										
										alert("please try later");
									}
										
								});	
										var cId= address.countryId;
										
										$.ajax({
											url:"<%=application.getContextPath()%>/GetStateAction",
											data:{"countryId":cId},
											success:function(states){
												$('#stateId').empty();
												$('#stateId').append("<option value=''>Select State</option>");
												for (var ind = 0; ind < states.length; ind++) {
													if(address.stateId==states[ind].stateId){
													$('#stateId').append("<option   value='"+states[ind].stateId+"' selected>"+states[ind].state+"</option>");	
													}else{
														
														$('#stateId').append("<option   value='"+states[ind].stateId+"'>"+states[ind].state+"</option>");
													}
												}
												
											},
											error:function(){
												
												alert("please try later");
											}
											
										});
								
									
									 
								
										var sId=	address.stateId;
											$.ajax({
												url:"<%=application.getContextPath()%>/GetCityAction",
												data:{"stateId":sId},
												success:function(cities){
													$('#cityId').empty();
													$('#cityId').append("<option value=''>Select city</option>");
													for (var ind = 0; ind < cities.length; ind++) {
														if(address.cityId==cities[ind].cityId){
														$('#cityId').append("<option   value='"+cities[ind].cityId+"' selected>"+cities[ind].city+"</option>");			
														}else{
															$('#cityId').append("<option   value='"+cities[ind].cityId+"'>"+cities[ind].city+"</option>");	
														}
													}
													
												},
												error:function(){
													
													alert("please try later");
												}
												
											});
							
								
								$("#stateId").val(address.stateId);
								$("#cityId").val(address.cityId);

						},//success
						error:function(){
							
							alert("please try later");
						}
						
					});
	});
	}
	
	 $('#countryId').change(function(){
			var cId= $('#countryId').val();
				
				$.ajax({
					url:"<%=application.getContextPath()%>/GetStateAction",
					data:{"countryId":cId},
					success:function(states){
						$('#stateId').empty();
						$('#stateId').append("<option value='-1'>Select State</option>");
						for (var ind = 0; ind < states.length; ind++) {
							$('#stateId').append("<option   value='"+states[ind].stateId+"'>"+states[ind].state+"</option>");			
						}
						
					},
					error:function(){
						
						alert("please try later");
					}
					
				});
			});
			
			 
			/**
			*/
			$('#stateId').change(function(){
				var sId=	$('#stateId').val();
					$.ajax({
						url:"<%=application.getContextPath()%>/GetCityAction",
						data:{"stateId":sId},
						success:function(cities){
							$('#cityId').empty();
							$('#cityId').append("<option value='-1'>Select city</option>");
							for (var ind = 0; ind < cities.length; ind++) {
								$('#cityId').append("<option   value='"+cities[ind].cityId+"'>"+cities[ind].city+"</option>");			
							}
							
						},
						error:function(){
							
							alert("please try later");
						}
						
					});
				}); 

	
	</script>
	
	
	<script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/ImageBase64Util.js"></script>
	
	<script>
	function imgageEncoded(){
		

		 readImage($("#Edit_Client_form input[type=file]").eq(0)).done(function(base64Data){ 
			 
		 $("input[name=imgforedit]").val(base64Data);
		 });
		 
	}
	
	</script>
	
<script>
	 function myEditFunction(){
			
				 //alert($("#Edit_Client_form input[type=file]").val())		;		
				 
				  if($('#Client_name').val()!='' && $('#description').val()!='' &&  
						 $('#Level_Id').val()!=-1 &&($('#Client_name_msg').html()=="This is Valid" || $('#description_msg').html()=="This is Valid" ||  
								 $('#Level_Id_msg').html()=="This is valid") || $("#Edit_Client_form input[type=file]").val()!='') {
				 var editData=$("#Edit_Client_form").serialize();
				 $.ajax({
						type : "POST",
						url:"<%=application.getContextPath()%>/EditClientDetailsAction",
						data :editData,
						success:function(msg){
							
							
						$("#editsuccessmsg")
						.html(
								 "<div class='alert alert-success fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+ " <strong>Success!!!" + msg 
										+ "</div>"); 
						$('#Client_name_msg').html('');
						$('#description_msg').html(''); 
						 $('#Level_Id_msg').html('');
						viewonload();
						},//sucess
						error:function(){
							
							alert("please try later");
						}
						
					});
				  }
				 else{
					
					  if($('#Client_name').val()=='')
						  {
		
						  $("#editsuccessmsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Enter Client Name "
											+ "</div>"); 
						  }
						  
					  else if($('#description').val()=='')  
					  {
						
						  $("#editsuccessmsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Enter Client Description "
											+ "</div>"); 
						  }
						  
					  else if($('#Level_Id').val()==-1) 
				      {
						  
						  $("#editsuccessmsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Select Level "
											+ "</div>"); 
						  }
						else {
						  
						  $("#editsuccessmsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> There is no updation...So plz update atleast one field "
											+ "</div>"); 
					  }
					  
				  } 
				
				 viewonload();
		} 
	</script>
	
	<script>
	 function myEditAdsFunction(){
				
		var pin= $('#pincodeId').val();
				 if($('#contact_person').val()!='' &&
						 $('#person_mobile_no').val()!='' && $('#person_mail').val()!='' && 
						 $('#countryId').val()!='' && $('#stateId').val()!=''
						 && $('#cityId').val()!='' 
						 && $('#locationId').val()!=''
						 && $('#pincodeId').val()!='' && 
							 $('#contact_person_msg').html()!="This is Invalid" && 
							 $('#person_mobile_no_msg').html()!="This is Invalid" && 
							 $('#person_mail_msg').html()!="This is Invalid" &&
							 $('#coubtryId_msg').html()!="This is Invalid" &&
							 $('#stateId_msg').html()!="This is Invalid" && 
							 $('#cityId_msg').html()!="This is Invalid" &&
							 $('#pincodeId_msg').html()!="Pincode must contain 6 digits" &&
							 $('#locationId_msg').html()!="This is Invalid"){
				 var editData=$("#editAdsDetails-form").serialize();
				 $.ajax({
						type : "POST",
						url:"<%=application.getContextPath()%>/EditClientContactDetailsAction",
						data :editData,
						success:function(msg){
						
						$("#editsuccessmsg")
						.html(
								 "<div class='alert alert-success fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+ " <strong>" + msg 
										+ "</div>"); 
						
						$('#myEditAddresModal').hide();
						
						$( "#showAllAddress1" ).trigger( "click" );		
						
						
						},//sucess
						error:function(){
							
							alert("please try later");
						}
						
					});
				 }else{
					 if($('#contact_person').val()==''){
						 
						 $("#adsfailermsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Enter Contact Person Name "
											+ "</div>");
					 }
						 
					 else if($('#person_mobile_no').val()==''){
						 
						 $("#adsfailermsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Enter Contact Person Mobile No. "
											+ "</div>");
					 }
					
					 else if($('#person_mail').val()==''){
						 
						 $("#adsfailermsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Enter Contact Person Mail ID "
											+ "</div>");
					 }
					
					 else if($('#countryId').val()==''){
						 
						 $("#adsfailermsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Select Country "
											+ "</div>");
					 }
					
					 else if($('#stateId').val()==''){
						 
						 $("#adsfailermsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Select State "
											+ "</div>");
					 }
                     else if($('#cityId').val()==''){
						 
						 $("#adsfailermsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Select City "
											+ "</div>");
					 }
					

					 else if($('#locationId').val()==''){
						 
						 $("#adsfailermsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Enter location "
											+ "</div>");
					 }
								
					 else if($('#pincodeId').val()=='' ||  $('#pincodeId_msg').html()=='Pincode must contain 6 digits'){
						 
						 if($('#pincodeId_msg').html()=='Pincode must contain 6 digits'){
							 $("#adsfailermsg")
								.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
												+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
												+ " <strong> Please Enter Correct Pincode "
												+ "</div>"); 
						 }
						 else{
						 $("#adsfailermsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Enter Pincode "
											+ "</div>");
						 }
					 }
				 }
				
		} 
	</script>
	
	<script>
	
	$('#addMoreNewAddress').on('click', function(){
		
		$('#more_contact_person_name').val('');
		$('#more_contact_person_mobile_no').val('');
		$('#more_contact_person_mail').val('');
		$('#country1').val(-1);
		$('#state1').val(-1)
		$('#city1').val(-1);
		$('#more_location1').val('');
		$('#more_pincode').val('');
		
		
		 $('#more_contact_person_name_msg').html('');
		 $('#more_contact_person_mobile_no_msg').html('');
		 $('#more_contact_person_mail_msg').html('');
		 $('#more_location_msg').html('');
		 $('#more_pincode_msg').html('');
		 $('#addfailermsg').empty();
		$('#myEditModal').hide();
		
	});
	

	
	</script>
	
	
	<script>
	 function AddMoreAddrsFunction(){
	
   if($('#more_contact_person_name').val()!='' &&
	$('#more_contact_person_mobile_no').val()!='' &&
	$('#more_contact_person_mail').val()!='' &&
	$('#more_location1').val()!='' &&
	$('#more_pincode').val()!=''&&
		   $('#more_contact_person_name_msg').html()!="Name must contain characters only"&&$('#more_contact_person_mobile_no_msg').html()!="Mobile no must be start with 7 or 8 or 9 and It should be 10 digit"&&$('#more_contact_person_mail_msg').html()!="This is Invalid"&&$('#more_location_msg').html()!="This is Invalid"&&$('#country1').val()!=-1 && $('#state1').val()!=-1 && $('#city1').val()!=-1 && $('#more_pincode_msg').html()!="This is Invalid")
     { 
	 var addAdrressData=$("#AddMoreAddrs_form").serialize();
	 
	 $.ajax({
			
			url:" <%=application.getContextPath()%>/AddMoreClientAddressAction",
			type : "POST",
			data :addAdrressData,
			success:function(successMsg){
			
			//location.reload();
			
			var client=$("#ClientName").val();
			
			var clientName=client.trim();
			if(clientName!=''){
			$.ajax({
				   url:"<%=application.getContextPath()%>/CheckDuplicateClientAction",
				   data:{"clientName":clientName},
				   success:function(data){
							
							$('#hidden').val(data[1][0].clientId); 
														
							if(data[0]!=0){
							
								$('#addressDiv').empty();
								for(var ind=0; ind<data[1].length; ind++){
									$('#addressDiv').append("<div style='width:100%'><div style='width:60%; margin:auto;padding:1%;background:#fff; border:1px solid #848482; border-radius:15px; box-shadow:5px 5px 5px lightgray;'><h5 style='color:#438EB9;'>"
									+data[1][ind].ClientName+": "+data[1][ind].Location+", "+data[1][ind].City+","+ 
									data[1][ind].State+","+data[1][ind].Country+","+data[1][0].Pincode+"</h5>"+ 
									"<strong>Contact Person Name: </strong> "+data[1][ind].ContactPresonName+",<br/>"+
									"<strong>Email ID: </strong> "+data[1][ind].ContactPresonNameEmail+",<br/>"+
									"<strong>Mob: </strong>"+data[1][ind].ContactPresonMobileNO+" <br/></div><br/>");
									}
								$('#addressDiv').append("<center><input type='button' class='btn btn-info btn-lg' data-toggle='modal' data-target='#addMoreModel' value='Add More Address'/></center><hr/>");
							}
							
							$('#more_contact_person_name').val('');
							$('#more_contact_person_mobile_no').val('');
							$('#more_contact_person_mail').val('');
							$('#country1').val(-1);
							$('#state1').val(-1)
							$('#city1').val(-1);
							$('#more_location1').val('');
							$('#more_pincode').val('');
							
							
							 $('#more_contact_person_name_msg').html('');
							 $('#more_contact_person_mobile_no_msg').html('');
							 $('#more_contact_person_mail_msg').html('');
							 $('#more_location_msg').html('');
							 $('#more_pincode_msg').html('');
							 
							 $("#addfailermsg").html('');
							
					},//sucess
				  error:function(){
												
							alert("please try later");
					}		
				});
			}
			
	     if(successMsg=="Record is inserted successfully...")
			{
	    	 $('#success-msg').empty();
			$('#msgDiv').html("<div class='alert alert-success'style='text-align:center;'>Address Inserted Successfully...</div>");
			$("#success-msg")
			.html(
					 "<div class='alert alert-success fade in' style='text-align: center;'>"
							+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
							+ " <strong>Success!!! Address Inserted Successfully... " 
							+ "</div>"); 
			/* $('#success-msg').html("<div class='alert alert-success'style='text-align:center;'>Address Inserted Successfully...</div>"); */
			}else{
				$('#success-msg').empty();
				$('#success-msg').html("<div class='alert alert-danger'style='text-align:center;'>Address not Inserted....This Mob No. or Email Id already exist...<button onclick='addmoreadspopup()' data-toggle='modal' data-target='#addMoreModel'>Try Again</button>"+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"+"</div>");
				$('#msgDiv').html("<div class='alert alert-danger'style='text-align:center;'>Address not Inserted....This Mob No. or Email Id already exist...</div>");
			}
	    
			$("#addMoreModel").hide();
			// $('#addressDiv').show();
			$("#AddMoreAddrs_form").reset();
			},//success
			error:function(){
				
				$('#msgDiv').html("<div class='alert alert-danger'><h4 style='text-align:center;'>Failed...Please try again...</h4></div>");
			}
			
		});
	  }
	else{
		
	if($('#more_contact_person_name_msg').html()=="Name must contain characters only" || $('#more_contact_person_name').val()=="" )
		{
		$("#addfailermsg")
		.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
						+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
						+ " <strong> Please Fill Contact Person Name"
						+ "</div>");
		}
	else if($('#more_contact_person_mobile_no_msg').html()=="Mobile no must be start with 7 or 8 or 9 and It should be 10 digit" || $('#more_contact_person_mobile_no').val()=="")
		{
		$("#addfailermsg")
		.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
						+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
						+ " <strong> Please Fill Contact Person Mobile No. "
						+ "</div>");
		}
	else if($('#more_contact_person_mail_msg').html()=="This is Invalid" || $('#more_contact_person_mail').val()==""){
		$("#addfailermsg")
		.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
						+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
						+ " <strong> Please Fill Contact Person Mail ID. "
						+ "</div>");
	}
	else if($('#country1').val()==-1){
					 
					 $("#addfailermsg")
						.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+ " <strong> Please Select Country "
										+ "</div>");
				 }
				
				 else if($('#state1').val()==-1){
					 
					 $("#addfailermsg")
						.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+ " <strong> Please Select State "
										+ "</div>");
				 }
                 else if($('#city1').val()==-1){
					 
					 $("#addfailermsg")
						.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+ " <strong> Please Select City "
										+ "</div>");
				 }
                 else if($('#more_location_msg').html()=="This is Invalid" || $('#more_location1').val()==""){
             		
             		$("#addfailermsg")
             		.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
             						+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
             						+ " <strong> Please Fill Contact Person Location "
             						+ "</div>");
             	}
                 else if($('#more_pincode').val()=='' ||  $('#more_pincode_msg').html()!="Pincode must contain 6 digits"){
					 
                	if($('#more_pincode_msg').html()!="Pincode must contain 6 digits"){
						 $("#addfailermsg")
							.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong> Please Enter Correct Pincode "
											+ "</div>"); 
					 }
					 else{
					 $("#addfailermsg")
						.html("<div class='alert alert-danger fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+ " <strong> Please Enter Pincode "
										+ "</div>");
					 }
				 }
				
			 }//else 
	 }
	</script>
	<script>
	function addmoreadspopup(){
		$('#more_contact_person_name').val('');
		$('#more_contact_person_mobile_no').val('');
		$('#more_contact_person_mail').val('');
		$('#country1').val(-1);
		$('#state1').val(-1)
		$('#city1').val(-1);
		$('#more_location1').val('');
		$('#more_pincode').val('');
		
		$('#addfailermsg').empty();
		 $('#more_contact_person_name_msg').html('');
		 $('#more_contact_person_mobile_no_msg').html('');
		 $('#more_contact_person_mail_msg').html('');
		 $('#more_location_msg').html('');
		 $('#more_pincode_msg').html('');
		$('#myEditModal').hide();
		
	}
	
	</script>

	
	
  <!-- ***********************************************************************************-->
  <!--                            Ajax call for Edit Client Details                       -->
  <!--*********************************************************************************** -->
	<script>
	$('document').ready(function(){

							 $.ajax({
									url:"<%=application.getContextPath()%>/GetCompanyLevelAction",
									success:function(level){
									
										$('#Level_Id').empty();
										 $('#Level_Id').append("<option value='-1'>Select Level</option>");
										for (var ind = 0; ind < level.length; ind++) {
											$('#Level_Id').append("<option value='"+level[ind].levelId+"'>"+level[ind].level+"</option>");			
										} 
									},//success
									error:function(){
										
										alert("please try later");
									}		
								});
							 
							
									});
</script>

</html>