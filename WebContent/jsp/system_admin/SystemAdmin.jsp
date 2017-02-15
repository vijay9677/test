<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<title>Home - Admin</title>
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/validationEngine.jquery.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/datepicker.min.css">
<link rel="stylesheet" 
	href="<%=application.getContextPath()%>/assets/fonts/fonts.googleapis.com.css" />
<link rel="stylesheet" 
	href="<%=application.getContextPath() %>/assets/css/formValidation.css">
<style type="text/css">
 div#table-response {
    width: 120%;
} 
</style>
</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/viewopportunityheader.jsp"></jsp:include>
<jsp:include page="../../jsp/common/systemadmin_menu.jsp"></jsp:include>
		<!-- Main-Containts-Start-Here -->
								<div class="main-content">
									<div class="main-content-inner">
										<div class="page-content">			
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
								<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									<b class="blue" >Add Admin Info</b>
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
		<!--Separetor end-->
								<div class="row">
									<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->						
<!-- write your code here -->
<!--
									/***************************************************/
									/**This Div is use for Display Success or Error...**/
									/***************************************************/
-->
	<div class="container" >
		<div class="row">
			<div class="col-md-12" style="text-align: center; ">
				<!-- This Div for using Success_Msg display -->
				<center><div id='success-msg' class="success_msg" ></div></center>
			</div>
			<div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->				
				<center><div id="error-msg" class="alert_msg" ></div></center>
			</div>
			<div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Success_Msg display -->
				<center><div id='success-msg-update' class="success_msg" ></div></center>
			</div>
			<div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->				
				<center><div id="error-msg-update" class="alert_msg" ></div></center>
			</div>
			<div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Success_Msg display -->
				<center><div id='success-msg-delete' class="success_msg" ></div></center>
			</div>
			<div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->				
				<center><div id="error-msg-delete" class="alert_msg" ></div></center>
			</div>
		</div>
	</div>
<!--
							/***************************************************************/
							/**This Div is use for Display Records on current home page...**/
							/***************************************************************/
-->
	<div class="container">
		<div class="row">
			<!-- Trigger the modal with a button -->
			<!-- <div class="col-md-6" style="text-align: left;">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
						Choose Any One... <span class="caret"></span>
					</button>
					<ul id="selectorList" class="dropdown-menu">
					</ul>
				</div>
			</div> -->
			<div class="col-md-10" style="text-align: left;">
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#myModal">Add Admin</button>
			</div>
		</div>
			<hr/>
	</div>
	<div id="table-response" class="table-responsive"
		style="border: lightgray 1px solid; box-shadow: 5px 5px 5px lightgray; ">
			</div>
<!--
									/****************************************/
									/**This Model is use for ADD RECORDS...**/
									/****************************************/
-->
	<!--Start Bootstrap Modal View-->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
				<div class="modal-header bg-primary" style="border-radius:10px 10px 10px 10px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add Admin</h4>
				</div>
				<div class="hr hr2 hr-dotted"></div>
				<div class="modal-body bg-info" style="border-radius:10px 10px 0px 0px;">
					<div class="container">
						<form class="form-horizontal" id="form_Submit" name="addForm"
							enctype="multipart/form-data" method="post"
							action="<%=application.getContextPath()%>/AddAdminAction">
							<p>
								<span style="color: Green; font-weight: bold">Note: </span>
								<span style="color: red; font-weight: bold"> *</span> fields are mandatory.
							</p>
							<div class="form-group">
								<label class="control-label col-sm-2" for="fname">FirstName: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="fname" name="fname" class="form-control validate[required] text-input"
										id="fname" placeholder="Enter First Name" required="required" onkeypress="return isAlphaNumericKey(this);">
									<span id="add_fname"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="lname">LastName: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="lname" name="lname" class="form-control validate[required] text-input"
										id="lname" placeholder="Enter Last Name" required="required" onkeypress="return isAlphaNumericKey(this);">
									<span id="add_lname"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="email">Email:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="text" name="email" class="form-control validate[required,custom[email]]" id="email" 
									placeholder="Enter email" required="required">
									<span id="addemail"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="pwd">Password:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="password" name="pwd" class="form-control validate[required] text-input"
										id="pwd" placeholder="Enter password" required="required">
									<span id="addpwd"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="rpwd">ConfirmPassword:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="password" name="rpwd" class="form-control validate[required,equals[pwd]] text-input" 
										id="rpwd" placeholder="Re-Enter password" required="required">
									<span id="addrpwd"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="mno">MobileNo: 
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="mno" name="mno" class="form-control validate[required] text-input" id="mno"  required="required" 
										placeholder="Enter Mobile Number">
									<span id="addmno"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="gender">Gender:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="radio" id="gen" name="gen" value="0" required="required">Male 
									<input type="radio" id="gen" name="gen" value="1" required="required">Female
									<span id="addgen"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="image">Image: <span style="color: red; font-weight: bold">*</span></label>
								<div class="col-sm-3">
									<input type="file" name="insertImage" id="imgInsert" class="form-control">
									<input type="hidden" id="show-img" name="show_Image" class="form-control">
									<img id='img-preview' width=60px height=60px alt="ImageShow..." align="right">
									<span id="addimage"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="dob">Date Of Birth: 
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="date" name="dob" class="form-control [required]" 
										id="dob" placeholder="Enter Date_Of_Birth">
									<span id="adddob"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="roleId">Role_Id:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<select id="roleId" class="form-control validate[required]" 
											name="roleId" placeholder="Enter Role_Id">
									</select>
									<span id="addroleId"></span>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer bg-info" style="border-radius:0px 0px 10px 10px;">
					<button type="button" id="submitButton" class="btn btn-success"  
						data-dismiss="modal">Submit</button>&nbsp;&nbsp;
					<button type="reset" class="btn btn-danger" data-dismiss="modal">Clear</button>
				</div>
		</div>
	</div>
<!--
									/*****************************************/
									/**This Modal is use For EDIT RECORDS...**/
									/*****************************************/
-->
	<!--Start Bootstrap Modal View-->
	<div id="myEditModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content -->
				<div class="modal-header bg-primary" style="border-radius:10px 10px 10px 10px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">Edit Record</h3>
				</div>
				<div class="hr hr2 hr-dotted"></div>
				<div class="modal-body bg-info" style="border-radius:10px 10px 0px 0px;">
					<div class="container">
						<form id="form_update" class="form-horizontal" enctype="multipart/form-data" method="POST" role="form">
							<div class="form-group">
								<label class="control-label col-sm-2" for="userId">User_Id:</label>
								<div class="col-sm-3">
									<input type="userId" class="form-control" id="userId" name="user_Id" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="fname">First
									Name:</label>
								<div class="col-sm-3">
									<input type="fname" class="form-control validate[required]" required="required" 
									id="first_Name" name="first_Name" onkeypress="return isAlphaNumericKey(this);">
									<span id="editfname"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="lname">Last
									Name:</label>
								<div class="col-sm-3">
									<input type="lname" class="form-control validate[required]" id="last_Name" 
									name="last_Name" onkeypress="return isAlphaNumericKey(this);" required="required">
									<span id="editlname"></span>
								</div>
							</div>							
							<div class="form-group">
								<label class="control-label col-sm-2" for="email">Email:</label>
								<div class="col-sm-3">
									<input type="email" class="form-control validate[required,custom[email]]" 
									id="email_Id" name="email_Id" required="required">
									<span id="editemail"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="mob">Mobile
									No:</label>
								<div class="col-sm-3">
									<input type="mob" class="form-control validate[required] text-input" id="mob" 
									name="mobile" required="required">
									<span id="editmob"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="gender">Gender:</label>
								<div class="col-sm-3" id="genderDiv">
									<input type="radio" id="m-genderEdit" class="genderEdit" name="editGender" value='0'>Male
									<input type="radio" id="f-genderEdit" class="genderEdit" name="editGender" value='1'>Female
									<span id="editgender"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="image">Image:</label>
								<div class="col-sm-3">
									<input type="file" id="editImage" class="form-control" name='file' >
									<input type="hidden" id="ed-img" name="edit_Image" class="form-control" >
									<img id='img-pre' width=60px height=60px alt="ImageShow..." align="right">
									<span id="editimage"></span>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="roleId">Role:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<select id="role_ID" class="form-control validate[required]" name="roleId" required="required">
									</select>
									<span id="editroleId"></span>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer bg-info" style="border-radius:0px 0px 10px 10px;">
						<input type="button" id="updateButton" class="btn btn-success" data-dismiss="modal" value="Update" onclick="return myUpdateAdminData();">&nbsp;&nbsp; 
						<input type="reset"	class="btn btn-danger" data-dismiss="modal" value="Cancel">
				</div>
		</div>
	</div>
<!--
									/*******************************************/
									/**This Modal is use For DELETE RECORDS...**/
									/*******************************************/
-->
	<!--Start Bootstrap Modal View-->
	<div class="modal fade" id="myDeleteModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content -->
				<div class="modal-header bg-primary" style="border-radius:10px 10px 10px 10px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Delete Record</h4>
				</div>
				<div class="hr hr2 hr-dotted"></div>
				<div id="delete_Div" class="modal-body bg-info" style="border-radius:10px 10px 0px 0px;">
					<div class="container">
						<form id="form_delete" class="form-horizontal" method="POST">
							<p><h3>Are You Sure... Do You Want to Delete This Records</h3></p>
						</form>
					</div>
				</div>
				<div class="modal-footer bg-info" style="border-radius:0px 0px 10px 10px;">
					<input id="myDeleteAdmin" type="button" class="btn btn-success" data-dismiss="modal" value="Ok">&nbsp;&nbsp;
					<input type="reset"	class="btn btn-danger" data-dismiss="modal" value="Cancel">
				</div>
		</div>
	</div>
<!--
									/*****************************************/
									/**This Modal is use For VIEW RECORDS...**/
									/*****************************************/
-->
	<div id="myViewModal" class="modal fade" role="dialog">
		<div class="modal-dialog" >
			<!-- Modal content-->
				<div class="modal-header bg-primary" style="border-radius:10px 10px 10px 10px;">
					<button type="button" class="close danger" data-dismiss="modal" >&times;</button>
					<h3 class="modal-title">ADMIN Details</h3>
				</div>
				<div class="hr hr2 hr-dotted"></div>
				<div class="modal-body bg-info" style="border-radius:10px 10px 10px 10px; ">
					<div class="container">
						<div class="col-md-8">
							<form action="#" method="post" class="form-horizontal">
								<div class="row">
									<div class="col-xs-4 col-sm-3 center">
										<div >
											<span class="profile-picture" id="view-image"></span>
										</div>
									</div>
									<div class="col-xs-8 col-sm-8">
										<table class="table" style="text-align: center;">
											<table class="table table-bordered" style="text-align: center;">
												<thead>
													<tr>
														<div class="row" style="margin: 5px;">
															<div class="col-md-3" style="padding: 5px; height: auto; 
															background-color: #696969; color: #FFFAF0;">
																<level>
																<center>
																	<b>Name:</b>
																</center>
																</level>
															</div>
															<div class="col-md-5" id="adminName" style="padding: 5px; 
															height: auto; background-color: #A9A9A9; color: #FFFAF0;">
															</div>
														</div>
													</tr>
													<tr>
														<div class="row" style="margin: 5px;">
															<div class="col-md-3" style="padding: 5px; height: auto; 
															background-color: #696969; color: #FFFAF0;">
																<level>
																<center>
																	<b>Email_Id:</b>
																</center>
																</level>
															</div>
															<div class="col-md-5" id="adminEmail" style="padding: 5px; 
															height: auto; background-color: #A9A9A9; color: #FFFAF0;">
															</div>
														</div>
													</tr>
													<tr>
														<div class="row" style="margin: 5px;">
															<div class="col-md-3" style="padding: 5px; height: auto; 
															background-color: #696969; color: #FFFAF0;">
																<level>
																<center>
																	<b>Mobile No:</b>
																</center>
																</level>
															</div>
															<div class="col-md-5" id="adminMobile" style="padding: 5px; 
															height: auto; background-color: #A9A9A9; color: #FFFAF0;">
															</div>
														</div>
													</tr>
													<tr>
														<div class="row" style="margin: 5px;">
															<div class="col-md-3" style="padding: 5px; height: auto; 
															background-color: #696969; color: #FFFAF0;">
																<level>
																<center>
																	<b>Department:</b>
																</center>
																</level>
															</div>
															<div class="col-md-5" id="adminDept" style="padding: 5px; 
															height: auto; background-color: #A9A9A9; color: #FFFAF0;">
															</div>
														</div>
													</tr>
													<tr>
														<div class="row" style="margin: 5px;">
															<div class="col-md-3" style="padding: 5px; height: auto; 
															background-color: #696969; color: #FFFAF0;">
																<level>
																<center>
																	<b>Date Of Birth:</b>
																</center>
																</level>
															</div>
															<div class="col-md-5" id="adminDob" style="padding: 5px; 
															height: auto; background-color: #A9A9A9; color: #FFFAF0;">
															</div>
														</div>
													</tr>
												</thead>
											</table>
										</table>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<!-- JAY NOTIFICATIONS HEADER  Script-->

<script type="text/javascript">

var path ="${path}";
</script>
<script type="text/javascript" 
	src="${path}/assets/js/jaySingStudentRequestsNotifications.js"></script>
	<!-- JAY NOTIFICATIONS HEADER END  -->
<!-- Vijay Noti  -->
<script type="text/javascript" 
	src="${path}/assets/js/VijayNotiJobPosting.js"></script>
<script type="text/javascript" 
	src="${path}/assets/js/ImageBase64Util.js"></script>
<script type="text/javascript" 
	src="<%=application.getContextPath()%>/assets/js/bootstrap-datepicker.min.js"></script>
<script
	src="<%=application.getContextPath()%>/assets/js/jquery.validationEngine.js"></script>
<script
	src="<%=application.getContextPath()%>/assets/js/jquery.validationEngine-en.js"></script>
<script 
	src="<%=application.getContextPath()%>/assets/js/jquery.bootpag.min.js"></script>
<script 
	src="<%=application.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
<script 
	src="<%=application.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
<script type="text/javascript" 
	src="<%=application.getContextPath()%>/assets/js/formValidation.js"></script>
<script type="text/javascript" 
	src="<%=application.getContextPath() %>/assets/js/formValidation.js"></script>
<script type="text/javascript" 
	src="<%=application.getContextPath() %>/assets/js/framework/bootstrap.js"></script>
<script type="text/javascript">
	window.jQuery || document.write("<script src='<%=application.getContextPath()%>/assets/js/jquery.min.js'>"+"<"+"/script>");</script>
<!--
						/***************************************************************/
						/**This Div is use for Pagination Code for Show All Records...**/
						/***************************************************************/
-->
<script>
$('document').ready(function(){
	  $.ajax({
			url:"<%=application.getContextPath()%>/GetRoleByAdminAction",
				success:function(role){
					$('#selectorList').empty();
					var stdId=<%=StringConstants._STUDENT_ROLE_ID%>;
					$('#roleId').append("<option value=''>Select any role...</option>");
					for (var ind = 0; ind < role.length; ind++) {
						if(stdId!=role[ind].roleId){
							$('#selectorList').append("<li value='"+role[ind].roleId+"' class='admin_role'><a href='<%=application.getContextPath()%>/jsp/system_admin/CommonForAllAdmin.jsp?roleId="+role[ind].roleId+"'</a>"+role[ind].role+"</li>");
							$('#roleId').append("<option value='"+role[ind].roleId+"'>"+role[ind].role+"</option>");
							$('#role_ID').append("<option value='"+role[ind].roleId+"'>"+role[ind].role+"</option>");
						}
					}
			},
			error:function(){
			}
		});
});
</script>
<script type="text/javascript">
			jQuery(function($) {
			})
</script>
<script>
	jQuery(document).ready(function() {
		// binds form submission and fields to the validation engine
		jQuery("#form_Submit").validationEngine('attach');
		jQuery("#form_update").validationEngine('attach');
	});
</script>
<script>
	$(document).ready(function() {
		$("#form_Submit").validationEngine();
		$("#form_update").validationEngine();
	});
</script>
<script>
	function formSuccess() {
		alert('Success!');
	}

	function formFailure() {
		alert('Failure!');
	}
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#form_Submit").validationEngine({
			onFormSuccess : formSuccess,
			onFormFailure : formFailure
		});
		jQuery("#form_update").validationEngine({
			onFormSuccess : formSuccess,
			onFormFailure : formFailure
		});
	});

	function checkHELLO(field, rules, i, options) {
		if (field.val() != "HELLO") {
			return options.allrules.validate2fields.alertText;
		}
	}
</script>
<script>
/* must apply only after HTML has loaded */
$(document).ready(function(){
	var obj = new Object();
	$("#submitButton").click( function(){

		//This code for Add Submit Validation
		// either call do_save or embed the contents of do_save in here
 	   var myDataIsValid = validationOnAddSubmit(); // change to call validator function
 	    if (myDataIsValid) {
 	     $('#myModal').modal('hide');
 	   } else{
 	   return myDataIsValid // value depends on whether you want stopPropagation or not.
 	   }
		
		var inputElement = $("#form_Submit input[type=file]");
	 	var b64Img="";
		readImage(inputElement).done(function(base64Data){
		b64Img=base64Data;
		obj.img=b64Img;
				
		$("#form_Submit input").each(function(){
			if($(this).attr("type")!='radio'){
			obj[$(this).attr("name")]=$(this).val();
			
			}else{
				if($(this)[0].checked){
					obj[$(this).attr("name")]=$(this).val();			
					// OR
					//obj.gen=$(this).val();
				}
			}
		}); 
		obj["roleId"]=$("#form_Submit select").val();
		console.log(obj);
		$.ajax({
				url: "<%=application.getContextPath()%>/AddAdminAction",
				type : "POST",
				data : obj,  
				success : function(data) {
					$('#contact_dialog .modal-header .modal-title').html("Result");
					$('#contact_dialog .modal-body').html(data);
					$("#form_Submit")[0].reset();
					if(data=="SUCCESS"){
						$("#success-msg").html("<div class='alert alert-success fade in' style='text-align: center;'>"
												+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
												+ "<strong>Success!!!</strong> Your Records has been Saved Successfully..."
												+ "</div>");
						getAdminData();
					}
					else{
						$("#error-msg").html("<div class='alert alert-danger fade in' style='text-align: center;'>"
												+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
												+ "<strong>Sorry!!!</strong> Your Records has not been Saved Successfully..."
												+ "</div>");
						getAdminData();
						}
				},
				error : function() {
					$("#error-msg").html("<div class='alert alert-danger fade in' style='text-align: center;'>"
									+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
									+ "<strong>Sorry!!!</strong> Your Records has not been Saved Successfully..."
									+ "</div>");
				}
    	   });
		});    	
	});	
});
//Image Read in Add Admin Form
	$(document).ready(function() {
				$("#imgInsert").on('change',function(){
							debugger;
							readImage($("#form_Submit input[type=file]").eq(0)).done(function(base64Data){
												$("#show-img").val(base64Data);
												$('#img-preview').attr("src",base64Data);
									});
						});
			});
	function readImage(inputElement) {
		var deferred = $.Deferred();
		var files = inputElement.get(0).files;
		if (files && files[0]) {
			var fr = new FileReader();
			fr.onload = function(e) {
				deferred.resolve(e.target.result);
			};
			fr.readAsDataURL(files[0]);
		} else {
			deferred.resolve(undefined);
		}
		return deferred.promise();
	}
</script>
<script>
$(document).ready(function(){
		$.ajax({
			url: "<%=application.getContextPath()%>/GetAllAdminDataAction",
			type: "POST",
		    success: function (json) {
		    },
		    error: function() {
		    }
		});
	});					
</script>
<script>
									/****************************************/
									/**This Function for Show Admin Records**/
									/****************************************/
$('document').ready(function(){
	getAdminData();
});
/****************************************************************************************************************/
/* @@@@@@ Here To Update the perticular data from Edit Form when you clicked on OK Button from Edit Form @@@@@@ */
/****************************************************************************************************************/
function myUpdateAdminData(){
	//alert("Are You Sure Updating Record...");
	var editData=$("#form_update").serialize();
	var obj = new Object();
	var inputElement = $("#form_update input[type=file]");
	var b64Img="";
	obj.img=$("#img-pre").attr("src");
	//alert(obj.img);
	readImage(inputElement).done(function(base64Data){
		b64Img=base64Data;
		$("#form_update input").each(function(){
			if($(this).attr("type")!='radio'){
				obj[$(this).attr("name")]=$(this).val();
			}else{
				if($(this)[0].checked){
					obj[$(this).attr("name")]=$(this).val();
				}
			}
		});
		obj["roleId"]=$("#form_update select").val();
		debugger;
		if(b64Img!=undefined){
		obj.img=b64Img;
		}
		$.ajax({
			type : "POST",
			url: "<%=application.getContextPath()%>/EditAdminAction",
			data: obj,
			success : function(data) {
				$('#contact_dialog .modal-header .modal-title').html("Result");
				$('#contact_dialog .modal-body').html(data);
				if (data=="SUCCESS") {
					$("#success-msg-update").html("<div class='alert alert-success fade in' style='text-align: center;'>"
							+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
							+ " <strong>Success!!!</strong> Your Record has been Updated Successfully in Database..."
							+ "</div>");
					getAdminData();
				} else {
					$("#error-msg-update").html("<div class='alert alert-danger fade in' style='text-align: center;'>"
							+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
							+ "<strong>Sorry!!!</strong> Your Record has not been Updated Successfully in Database..."
							+ "</div>");
					getAdminData();
				}
			}
		});
	});
}
									/*******************************************/
									/**This Function for Get All Admin Records**/
									/*******************************************/
function getAdminData(){
	$.ajax({
		url:"<%=application.getContextPath()%>/GetAllAdminDataAction",
		success:function(obj){

			//Here start This code for Pagination code for show records...
			$("#table-response").html("");
			var table ='<table id="dynamic-table" class="table table-bordered" style="text-align: center; ">'+
				'<thead>'+
				'	<tr class="bg-primary">'+
				'		<th class="bg-primary" style="text-align: center;">S.No</th>'+
				/* '		<th class="bg-primary" style="text-align: center;">User_ID</th>'+ */
				'		<th class="bg-primary" style="text-align: center;">Name</th>'+
				'		<th class="bg-primary" style="text-align: center;">Email_Id</th>'+
				'		<th class="bg-primary" style="text-align: center;">Mobile No</th>'+
				'		<th class="bg-primary" style="text-align: center;">Gender</th>'+
				'		<th class="bg-primary" style="text-align: center;">Department</th>'+
				'		<th class="bg-primary" style="text-align: center;">Activity</th>'+
				'	</tr>'+
			'	</thead>'+
			'	<tbody id="bodyData">'+
			'		<tr class="success" id="usertable"'+
			'			style="background-color: lightgray; padding: 5px; height: auto;">'+
			'		</tr>'+
			'	</tbody>'+
			'</table>';
			$("#table-response").html(table);
			//Here End Pagination code
			
			$("#bodyData").empty();
        	if(obj==''){
        	$("#bodyData").html("<span style='color:red'><strong>'RECORDS ARE NOT AVAILABLE IN DATABASE'</strong></span>");
        	}

        	for (var i= 0; i < obj.length; i++) {
				var store="<tr>";
				store+="<td>"+(i+1)+"</td>"
				/* store+="<td id='User_Id'>"+obj[i].userid+"</td>" */
				store+="<td id='Admin_Name'>"+obj[i].firstname+" "+obj[i].lastname+"</td>"
				store+="<td id='Email_Id'>"+obj[i].email+"</td>"
				store+="<td id='Mobile_No'>"+obj[i].mobileNo+"</td>"
				if(obj[i].gender==0){
					store+="<td id='Gender'>Male</td>"
				}else{
					store+="<td id='Gender'>Female</td>"
				}
				store+="<td id='Role_Id'>"+obj[i].role.role+"</td>"
				store+="<td id='edit'><input class='btn btn-success' type='button' adminIdView='"+obj[i].userid+"'   name='view' data-toggle='modal' data-target='#myViewModal' value='View'>&nbsp;&nbsp;<input class='btn btn-primary' type='button'  adminIdEdit='"+obj[i].userid+"'  name='edit'data-toggle='modal' data-target='#myEditModal' value='Edit'>&nbsp;&nbsp;<input class='btn btn-danger' type='button' adminIdDelete='"+obj[i].userid+"' data-toggle='modal'data-target='#myDeleteModal' onclick='adminDelete(this);' value='Delete'/></td>"
				store+="<br/> <br/>"
				store+="</tr>";
				$("#bodyData").append(store);
            }//outer for
            viewAdminEvents();
			applyMyEvents();
			//this code is used to pagination
			var oTable1 = $('#dynamic-table').dataTable({
				bAutoWidth: false,
				"aaSorting": [],
		    });	
            }
		});
	}//get admin data
									/****************************************/
									/**This Function for Edit Admin Records**/
									/****************************************/
/* @@@@@@ Here To Set the perticular data in Edit Form when you clicked on Edit Button @@@@@@ */
function applyMyEvents(){
	$("input[adminIdEdit]").on("click",function(){
		$("#img-pre").attr("src",'');
			var userid= $(this).attr("adminIdEdit");
			$.ajax({
				url:"<%=application.getContextPath()%>/GetParticularDataAdminAction",
				data :{"UserId":userid},
				success:function(edit){
					$("#userId").val(edit[0].userid);
					$("#first_Name").val(edit[0].firstname);
					$("#last_Name").val(edit[0].lastname);
					$("#email_Id").val(edit[0].email);
					$("#mob").val(edit[0].mobileNo);
					if((edit[0].gender)==0){
						$("#m-genderEdit").prop("checked", true);
					}else{
						$("#f-genderEdit").prop("checked", true);
					}
					$("#img-pre").attr("src",edit[0].image);
					$("#role_ID").val(edit[0].role.roleId);
					getAdminData();
				},//sucess
				error:function(){
				}
			});
	});
	$("#editImage").change(function(){
		debugger;
		readImage($("#form_update input[type=file]").eq(0)).done(function(base64Data){
			$("#ed-img").val(base64Data);
			$('#img-pre').attr("src",base64Data);
		});
	});
}
									/****************************************/
									/**This Function for View Admin Records**/
									/****************************************/  
function viewAdminEvents(){
	$("input[adminIdView]").on("click",function(){
		var userid= $(this).attr("adminIdView");
		$.ajax({
			url:"<%=application.getContextPath()%>/ViewPerticularAdminAction",
			data :{"viewUserId" : userid},
			success:function(view){
				$("#adminName").html(view[0].firstname+" "+view[0].lastname);
				$("#view-image").html("<img class='img-thumbnail' src='"+view[0].image+"' style='width:160px; height:170px;''/>");
				$("#adminEmail").html(view[0].email);
				$("#adminMobile").html(view[0].mobileNo);
				$("#adminDept").html(view[0].role.role);
				$("#adminDob").html(view[0].date);
			},//sucess
			error:function(){
			}							
		});
	});
}
									/******************************************/
									/**This Function for Delete Admin Records**/
									/******************************************/
function adminDelete(curr){
	var userId =$(curr).attr("adminiddelete");
	var obj ={"UserId" : userId};
	$("#myDeleteAdmin").on("click",function(){
		$.ajax({
			url:"<%=application.getContextPath()%>/DeleteAdminAction",
			data :obj,
			success : function(data) {
				$('#contact_dialog .modal-header .modal-title').html("Result");
				$('#contact_dialog .modal-body').html(data);
				$("#success-msg-delete").html("<div class='alert alert-success fade in' style='text-align: center;'>"
											+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
											+ " <strong>Success!!!</strong> Your Record has been Deleted Successfully from Database..."
											+ "</div>");
				getAdminData();
			},
			error : function() {
				$("#error-msg-delete").html("<div class='alert alert-danger fade in' style='text-align: center;'>"
										+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
										+ "<strong>Sorry!!!</strong> Your Record has not been Deleted from Database..."
										+ "</div>");
				getAdminData();
			}
		});
	});
}
</script>
<!--
					/******************************************************************************/
					/**This Script Tag is use for Start a JQuery Validation for Add Admin Form...**/
					/******************************************************************************/
-->
<script type="text/javascript">
		//validation on FirstName & LastName
	 	function isAlphaNumericKey(evt){
	    	var charCode = (evt.which) ? evt.which : event.keyCode;
	    	if ((charCode>=65 && charCode <=90)||(charCode >=97 && charCode <=122)||charCode==8){
	   			return true;
	    	}else
	    	{
	   			return false;
	    	}
	    }
	 	//Validation on addMobileNumber 
	 	$("#mno").on('blur',function() {
			var val = $(this).val();
			var reg = new RegExp(/^[789]{1}\d{9}$/);
			if (!reg.test(val)) {
				$('#addmno').html("<b>This is Invalid Mobile Number.</b>");
				$('#addmno').css("color", "red");
			} else {
				$('#addmno').html("<b>This is valid.</b>");
				$('#addmno').css("color", "green");
			}
		});
	 	//Validation on addEmail_Id & editEmail_Id
		$("#email").on('blur',function() {
			var val = $(this).val();
			var reg = new RegExp(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/);
			if (!reg.test(val)) {
				$('#addemail').html("<h5>This is Invalid Email_Id.<br/>Eg:<b>'nacre_software2016@gmail.com'</b></h5>");
				$('#addemail').css("color", "red");
			} else {
				$('#addemail').html("<b>This is valid.</b>");
				$('#addemail').css("color", "green");
			}
		});
		//Validation on Password and ConfirmPassword
		$("#pwd").on('blur',function() {
			var val = $(this).val();
			var reg = new RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&_#]{8,10}/);
			if (!reg.test(val)) {
				$('#addpwd').html("<b>This is Invalid Password. The Password must be at least 8 characters Long. The Password must contain at least One Upper & Lower case letter,One Digit and One Special character like($,@,%,*,?,&,_,#).</b>");
				$('#addpwd').css("color", "red");
			} else {
				$('#addpwd').html("<b>This is valid.</b>");
				$('#addpwd').css("color", "green");
			}
		});
		$("#rpwd").on('blur',function() {
			var val = $(this).val();
			var reg = new RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&_#]{8,10}/);
			if (!reg.test(val)) {
				$('#addrpwd').html("<b>This is Invalid Password. The Password must be at least 8 characters Long. The Password must contain at least One Upper & Lower case letter,One Digit and One Special character like($,@,%,*,?,&,_,#).</b>");
				$('#addrpwd').css("color", "red");
			} else {
				var password = document.getElementById("pwd").value;
			    var confirmPassword = document.getElementById("rpwd").value;
				if (password != confirmPassword) {
					$('#addrpwd').html("<b>This is Invalid Password. Password must be same.</b>");
					$('#addrpwd').css("color", "red");
				} else {
					$('#addrpwd').html("<b>This is valid.</b>");
					$('#addrpwd').css("color", "green");
				}
			}
		});
		//Validation for Add Submit Button
		function validationOnAddSubmit(){
			if((document.getElementById("fname").value)=='' ||
				(document.getElementById("lname").value)=='' ||
				(document.getElementById("email").value)=='' ||
				(document.getElementById("pwd").value)=='' ||
				(document.getElementById("rpwd").value)=='' ||
				(document.getElementById("mno").value)=='' ||
				(document.getElementById("gen").value)=='' ||
				(document.getElementById("imgInsert").value)=='' ||
				(document.getElementById("dob").value)=='' ||
				(document.getElementById("roleId").value)=='' ||
				$('#add_fname').html()=="This is invalid" || 
				$('#add_lname').html()=="This is invalid" || 
				$('#addemail').html()=="This is Invalid" || 
				$('#addpwd').html()=="This is invalid" || 
				$('#addrpwd').html()=="This is invalid" || 
				$('#addmno').html()=="This is invalid" || 
				$('#addgen').html()=="This is invalid" || 
				$('#addimage').html()=="This is invalid" || 
				$('#adddob').html()=="This is invalid" || 
				$('#addroleId').html()=="This is invalid")
			{
				return false;
			}else{
				return true;
			}
		}
</script>
<script>
jQuery(document).ready(function(){
	jQuery("#form_Submit").validationEngine();
	$("#submitButton").click(function(){
		jQuery("#form_Submit").validationEngine('validate');
	})
});
</script>
<!--
							/*********************************************************/
							/**This Div is use for Display Admin Image & Dropdown...**/
							/*********************************************************/
-->
<!-- Form Validation for Edit Form-->
<script type="text/javascript">
$('#form_update')
.formValidation({
    message: 'This value is not valid',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	first_Name: {
            message: 'The first name is not valid',
            validators: {
                notEmpty: {
                    message: 'The First Name is required and can\'t be empty'
                },
                stringLength: {
                    min: 2,
                    max: 30,
                    message: 'The First Name must be more than 2 and less than 30 characters long'
                },
                regexp: {
                    regexp: /^[a-zA-Z]+$/,
                    message: 'The First Name can only consist of alphabetical'
                }
            }
        },
        last_Name: {
            message: 'The Last Name is not valid',
            validators: {
                notEmpty: {
                    message: 'The Last Name Name is required and can\'t be empty'
                },
                stringLength: {
                    min: 2,
                    max: 30,
                    message: 'The Last Name must be more than 2 and less than 30 characters long'
                },
                regexp: {
                    regexp: /^[a-zA-Z]+$/,
                    message: 'The Last Name can only consist of alphabetical'
                }
            }
        },
        email_Id: {
            validators: {
                notEmpty: {
                    message: 'The email address is required and can\'t be empty'
                },  regexp: {
                    regexp: /^[a-zA-Z0-9][a-zA-Z0-9._]{3,}[@]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,}([.]{1}[a-zA-Z0-9]{2,}){0,}$/,
                    message: 'EMAIL FORMAT IS INVALID'
                }
            }
        },
        mobile:{
        	 validators: {
                 phone: {
                     country: 'IN',
                     message: 'The value is not valid %s phone number'
                 },
                regexp: {
                    regexp:/^[7-9][0-9]{9}$/,
                    message: 'The MOBILE NO SHOULD START WIT 7 OR 8 OR 9'
                },
                stringLength: {
                    min: 10,
                    max: 10,
                    message: 'PLEASE ENTER 10 DIGITS MOBILE NO'
                }
             }
        },
        roleId: {
            validators: {
            	 notEmpty: {
                     message: 'Please  Select Role'
                 }
            }
        },
        editGender:{
        	validators: {
           	 notEmpty: {
                    message: 'Please  Select Gender'
                }
           }
        }
    }
}).on('success.field.fv', function(e, data) {
    $("#updateButton").show();
}).on('err.field.fv', function(e, data) {
    $("#updateButton").hide();
});
</script>
</body>
</html>