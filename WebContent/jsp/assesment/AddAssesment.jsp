

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>


<!DOCTYPE html>
<html lang="en">
	<head>
  <link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/validationEngine.jquery.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/datepicker.min.css">
<link rel="stylesheet" 
	href="<%=application.getContextPath()%>/assets/fonts/fonts.googleapis.com.css" />
<link rel="stylesheet" 
	href="<%=application.getContextPath() %>/assets/css/formValidation.css">
	<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="Nacre Software Services Assesment"  />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<title>Home - Student</title>

			


		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<link href="<%=application.getContextPath()%>/assets/css/bootstrap-timepicker.min.css"> 

<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/bootstrap-datetimepicker.min.css">
 <link href="<%=application.getContextPath()%>/assets/css/jquery-ui.css" rel="Stylesheet"
type="text/css" />
  		</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<!-- JAY NOTIFICATIONS HEADER  -->
<jsp:include page="../../jsp/common/viewopportunityheader.jsp"></jsp:include>

<jsp:include page="../../jsp/common/systemadmin_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->

<!--  ..................................................ADD/EDIT/DELETE ASSESSMENT TABLE...........................................................
____________________________________________________________________________________________________________________________________________________
  -->
  
  
	<div class="container">
	
	<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >View Assesment Details</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
		<div class="row">
			<div class="col-md-12" style="text-align: center; padding-top: 5px;">
				<!-- This Div for using Success_Msg display -->
				<div id='success-msg' class="success_msg" style="width: 40%;">
				</div>
			</div>
			<!-- <div class="row"> -->
			<div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->
				<div id="error-msg" class="alert_msg" style="width: 40%;"></div>
			</div>
		</div>
	</div>




	<div class="container">
		<div class="row" style="text-align: right;">

			<!-- Trigger the modal with a button -->
			<div class="col-md-10">
				<button type="button" id="addAssessment" onclick=addAssesment() class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Assesment</button>
				<hr />
			</div>
		</div>
	</div>

	<div class="container"
		style="border: lightgray 1px solid; box-shadow: 5px 5px 5px lightgray; width: 100%; margin-left: 0%;">
		
		<div class='row' id='records'></div>
		<!-- <div class="panel panel-primary">
			    <div class="panel-heading">Panel Heading</div>
			    <div class="panel-body">Panel Content</div>
        </div>

		<table class="table" id="table" style="text-align: center;">
			<table class="table" style="text-align: center;">
				<thead>
					<tr style="background-color: #848482;">
						 <th>Assesment_Id</th>
						<th>Assesment_Name</th>
						<th>Total_Marks</th>
						<th>Duration_in_Min</th>
						<th>Date</th>
						<th>Description</th>
						<th>Assesment Type Name</th>
						<th>Course Name</th>
						<th>Level Name</th>
						<th>No Of Students For a Slot</th>
						<th>Start Time</th>
						<th>End Time</th>
						<th>Activity</th> 
					</tr>
				</thead>
				<tbody id="data">
					
					<td><input class="btn btn-primary" type="button" name="edit"
							data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
							<input class="btn btn-danger" type="button" data-toggle="modal"
							data-target="#myDeleteModal" value="Delete" /></td>

				</tbody>
			</table>
		</table> -->
	</div>



	<!--                                      This Modal For Add Records... 
	 ________________________________________________________________________________________________________________________________
	  -->
	
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add Assesment</h4>
				</div>


				<div class="modal-body">


					<div class="container">




						<form class="form-horizontal" id="form_Submit"
							enctype="multipart/form-data" method="get"
							action="<%=application.getContextPath()%>/AddAssessment">

							<p>
								<span style="color: Green; font-weight: bold">Note: </span> <span
									style="color: red; font-weight: bold"> *</span> fields are
								mandatory.
							</p>
							<!-- <div class="form-group">
				<label class="control-label col-sm-2" for="userId">User_Id:</label>
				<div class="col-sm-3">
					<input type="userId" name="userId" class="form-control" id="userId"
						placeholder="Enter User_Id">
				</div>
			</div> -->

							<!-- <div class="form-group">
								<label  class="control-label col-sm-2" for="assesment_Id">Assesment
									Id : <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="assesment_Id" name="assesment_Id"
										class="form-control" id="assesment_Id"
										placeholder="Enter assesment Id" >
								</div>
							</div>
 -->

							<div class="form-group">
								<label id="assment_Name_msg" class="control-label col-sm-2" for="assesment_Name">Assesment_Name
									: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="assesment_Name" name="assesment_Name"
										class="form-control" id="assesment_Name"
										placeholder="Enter Assesment Name" required="required">
								</div>
								<span id="assmntName"></span>
							</div>
							<div class="form-group">
								<label  class="control-label col-sm-2" for="total_Marks">Total_Marks
									:<span style="color: red; font-weight: bold">*</span></label>
								<div class="col-sm-3">
									<input type="total_Marks" name="total_Marks"
										class="form-control" id="total_Marks"
										placeholder="Enter total Marks" required="required">
								</div>
								<span id="total_Marks_msg"></span>
							</div>
							<div class="form-group">
								<label  class="control-label col-sm-2" for="duration_in_Min">Duration_in_Min:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="duration_in_Min" name="Duration_in_Min"
										class="form-control" id="duration_in_Min"
										placeholder="Enter duration in min" required="required">
								</div>
								<span id="duration_in_Min_msg" ></span>
							</div>
								<div class="form-group">
								<label class="control-label col-sm-2" for="start_Time">Start
									Time :<span style="color: red; font-weight: bold">*</span></label>
								<div class="col-sm-3">
									
                          <div id="datetimepicker3" class="input-append">
                          <input data-format="hh:mm:ss"  class="form-control" type="text" name='start_Time' id="start_Time" required="required"></input>
                       <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar">  </i>
                                  </span>
                                       </div>

								</div>
								<span id="start_Time_msg"></span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="end_Time">End
									Time :<span style="color: red; font-weight: bold">*</span></label>
								<div class="col-sm-3">
									
                          <div id="datetimepicker4" class="input-append">
                          <input data-format="hh:mm:ss"  class="form-control" type="text" id="end_Time" name='end_Time' required="required"></input>
                       <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar">  </i>
                                  </span>
                                       </div>

								</div>
								<span id="end_Time_msg"></span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="descrition">Description:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="descrition" name="descrition" class="form-control"
										id="descrition" placeholder="Enter Description" required="required">
								</div>
								<span id="description_msg"></span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="assessmentType">Asessment
									Type: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<!-- <input type="roleId" name="roleId" class="form-control"
										id="roleId" placeholder="Enter Role_Id"> -->
									<select id="assessmentType" class="form-control" name="assessmentType"
										placeholder="Enter Role_Id" required="required">
										<option value="-1">Select Assessment Type</option>

									</select>
								</div>
								<span id="assessmentType_msg"></span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="course">course:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<!-- <input type="roleId" name="roleId" class="form-control"
										id="roleId" placeholder="Enter Role_Id"> -->
									<select id="course" class="form-control" name="course" placeholder="Enter course" required="required">
										<option value="-1">Select course</option>

									</select>
								</div>
								<span id="course_msg"></span>
							</div>


							<div class="form-group">
								<label  class="control-label col-sm-2" for="dob">Date : <span
									style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="text" id="dob" name="dob" class="form-control"
										id="dob" placeholder="Enter Assesment Date" required="required">
								</div>
								<span id="date_msg"> </span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="level">Level:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<!-- <input type="roleId" name="roleId" class="form-control"
										id="roleId" placeholder="Enter Role_Id"> -->
									<select id="level" class="form-control" name="Level" placeholder="Level" required="required">
										<option value="-1">Select Any level</option>

									</select>
								</div>
								<span id="level_msg"></span>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="no_of_Slot">No
									Of Students For a Slot:<span style="color: red; font-weight: bold">*</span></label>
								<div class="col-sm-3">
									<input type="no_of_Slot" name="no_of_Slot" class="form-control"
										id="no_of_Slot" placeholder="Enter No Of Students" required="required">
								</div>
								<span id="no_of_Slot_msg"></span>
							</div>

						

						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="submitButton" class="btn btn-success"
						data-dismiss="modal" onclick = 'return false;'>Submit</button>
					&nbsp;&nbsp;
					<button type="reset" class="btn btn-danger" data-dismiss="modal">Cancle</button>
					

					<!-- <input type="submit" class="btn btn-success" data-dismiss="modal"
							value="Submit">&nbsp;&nbsp; <input type="reset"
							class="btn btn-danger" data-dismiss="modal" value="clear"> -->
				</div>
				
				</div>
			</div>
		</div>
	</div>


	

	<!--                              This Modal For Edit Records...Modal        
	________________________________________________________________________________________________________________
	                                       -->
	
	<div id="myEditModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			Modal content
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit Record</h4>
				</div>
				<div class="modal-body">


					<div class="container">
						<form class="form-horizontal" id="editassgn" role="form" action="<%=application.getContextPath()%>/EditAssessment" method="get">
							
							<div class="form-group">
								<label class="control-label col-sm-2" for="assesment_edit_Id">Assesment
									Id : <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="assesment_edit_Id" name="assesment_edit_Id"
										class="form-control" id="assesment_edit_Id"
										placeholder="Enter assesment Id" readonly="readonly">
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-sm-2" for="assesment_edit_Name">Assesment_Name
									: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="assesment_edit_Name" name="assesment_edit_Name"
										class="form-control" id="assesment_edit_Name"
										placeholder="Enter Assesment Name">
								</div>
								<span id="assmnt_edit_Name_msg"></span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="total_edit_Mark">Total_Marks
									:<span style="color: red; font-weight: bold">*</span></label>
								<div class="col-sm-3">
									<input type="total_edit_Mark" name="total_edit_Mark"
										class="form-control" id="total_edit_Marks"
										placeholder="Enter total Marks">
								</div>
								<span id="total_edit_Marks_msg"></span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="duration_edit_in_Min">Duration_in_Min:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="duration_edit_in_Min" name="duration_edit_in_Min"
										class="form-control" id="duration_edit_in_Min"
										placeholder="Enter duration in min">
								</div>
							<span id="duration_edit_in_Min_msg"></span>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2" for="dob_edit">Date : <span
									style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="text" id="dob_edit" name="dob_edit" class="form-control"
										 placeholder="Enter Date">
								</div>
								<span id="dob_edit_msg"></span>
							</div>
								<div class="form-group">
								<label class="control-label col-sm-2" for="start_Time_edit">Start
									Time :
									
									<span style="color: red; font-weight: bold">*</span>
									</label>
								<div class="col-sm-3">
								
                          <div id="datetimepicker5" class="input-append">
                          <input data-format="hh:mm:ss"  class="form-control" type="text" id="start_Time_edit" name="start_Time_edit"></input>
                       <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar">  </i>
                                  </span>
                                       </div>

								</div>
								<span id="start_Time_edit_msg"></span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="end_Time_edit">End
									Time :
									
									<span style="color: red; font-weight: bold">*</span>
									</label>
										<div class="col-sm-3">
							
                          <div id="datetimepicker6" class="input-append">
                          <input data-format="hh:mm:ss" type="text"  class="form-control" id="end_Time_edit" name="end_Time_edit" ></input>
                       <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar">  </i>
                                  </span>
                                       </div>

								</div>
								<span id="end_Time_edit_msg"></span>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2" for="descrition_edit">Description:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="descrition_edit" name="descrition_edit" class="form-control"
										id="descrition_edit" placeholder="Enter Description">
								</div>
								<span id="descrition_edit_msg"></span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="assessmentType_edit">Asessment
									Type: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<!-- <input type="roleId" name="roleId" class="form-control"
										id="roleId" placeholder="Enter Role_Id"> -->
									<select id="assessmentType_edit" name="assessmentType_edit" class="form-control
										placeholder="Enter Role_Id">
										<option value="1">Select Assessment Type</option>

									</select>
								</div>
								<span id="assessmentType_edit_msg"></span>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="course_edit">course:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<!-- <input type="roleId" name="roleId" class="form-control"
										id="roleId" placeholder="Enter Role_Id"> -->
									<select id="course_edit" name="course_edit"  class="form-control placeholder="Enter course"> 
										<option value="1">Select course</option>

									</select>
								</div>
								<span id="course_edit_msg"></span>
							</div>


							
							<div class="form-group">
								<label class="control-label col-sm-2" for="level_edit">Level:
									<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<!-- <input type="roleId" name="roleId" class="form-control"
										id="roleId" placeholder="Enter Role_Id"> -->
									<select id="level_edit" name="level_edit" class="form-control placeholder="Level">
										<option value="1">Select Any level</option>

									</select>
								</div>
								<span id="level_edit_msg"></span>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="no_of_Slot_edit">
								No Of Students For a Slot:<span style="color: red; font-weight: bold">*</span>
									</label>
								<div class="col-sm-3">
									<input type="no_of_Slot_edit" name="no_of_Slot_edit" class="form-control"
										id="no_of_Slot_edit" placeholder="Enter No Of Students">
								</div>
								<span id="no_of_Slot_edit_msg"></span>
							</div>

						
					
					
					
					<!-- hi one div rem -->
					</div>
					
					<!-- fotter -->
					 <div class="modal-footer">
					<button type="button" onclick='getUpdate();' id="updateSubmit" class="btn btn-success"
						data-dismiss="modal" onclick = 'return false;'>update</button>
					&nbsp;&nbsp;
					<button type="reset" id="resetbutton" class="btn btn-danger" data-dismiss="modal">Cancle</button>
					<!-- ******************************************************************* 
						<input type="button" id="updateSubmit" class="btn btn-success" data-dismiss="modal"
							value="Update">&nbsp;&nbsp; <input type="reset"
							class="btn btn-danger" data-dismiss="modal" value="Cancel">-->
					</div> 
					</div>
					</form>
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
<script type="text/javascript" src="${path}/assets/js/jaySingStudentRequestsNotifications.js"></script>
	
	<!-- JAY NOTIFICATIONS HEADER END  -->
<!-- Vijay Noti  -->
<script type="text/javascript" src="${path}/assets/js/VijayNotiJobPosting.js"></script>
	
<script src="<%=application.getContextPath()%>/assets/js/moment.min.js"></script>
<script src="<%=application.getContextPath()%>/assets/js/daterangepicker.min.js"></script>
   
<script src="<%=application.getContextPath() %>/assets/js/bootstrap-datetimepicker.min.js"></script>
 <script src="<%=application.getContextPath()%>/assets/js/bootstrap-datepicker.min.js"></script>
<script src="<%=application.getContextPath()%>/assets/js/bootstrap-timepicker.min.js"></script>

<script src="<%=application.getContextPath()%>/assets/js/bootstrap-datetimepicker.min.js"></script>
 
    <script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
    <script type="text/javascript" 
	src="<%=application.getContextPath() %>/assets/js/formValidation.js"></script>
<script type="text/javascript" 
	src="<%=application.getContextPath() %>/assets/js/framework/bootstrap.js"></script>
<script >
	function addAssesment(){
		$("#success-msg").empty();
		$('#assmntName').empty();
	    $('#total_Marks_msg').empty();
	    $('#duration_in_Min_msg').empty();
	    $('#description_msg').empty();
	    $('#level_msg').empty();
	    $('#assessmentType_msg').empty();
	    $('#course_msg').empty();
	    $('#no_of_Slot_msg').empty();
	    $('#start_Time_msg').empty();
	    $('#end_Time_msg').empty();
	    $('#assesment_Name').val("");
	    $('#total_Marks').val("");
	    $('#duration_in_Min').val("");
	    $('#duration').val("");
	    $('#dob').val("");
	    $('#descrition').val("");
	    $('#level').val("");
	    $('#assessmentType').val("");
	    $('#course').val("");
	    $('#no_of_Slot').val("");
	    $('#start_Time').val("");
	    $('#end_Time').val("");
	    	
	  
	    // $('#form_Submit').reset();
	}
	
</script>


<script>
/* must apply only after HTML has loaded */
$(document).ready(function () {
	
	$.ajax({
        type: "POST",
        url: "<%=application.getContextPath()%>/GetLevelAction",
        success: function(level)
        {
        
        	
			$.each(level, function() {
				
						$("#level").append(
								"<option value="+this.levelId+">" + this.level
										+ "</option>");
			});
        },error:function(){
        	alert("PLEASE TRY LATER");
        }
    });
	$.ajax({
        type: "POST",
        url: "<%=application.getContextPath()%>/GetAssessmentType",
        success: function(type)
        {
        	
        
        	
        	$.each(type, function() {
				
        		
				$("#assessmentType").append(
						"<option value="+this.assesmentTypeId+">" + this.assesmentTypeName
								+ "</option>");
	});
        
        },error:function(){
        	alert("PLEASE TRY LATER");
        }
    });
	$.ajax({
        type: "POST",
        url: "<%=application.getContextPath()%>/GetCourses",
        success: function(courses)
        
        {
        	

        
        	$.each(courses, function() {
				
				$("#course").append(
						"<option value="+this.courseId+">" + this.course
								+ "</option>");
	});
       
        },error:function(){
    	alert("PLEASE TRY LATER");
    }
    });

	
	myLoad();
	
	
	//
/* ------------------------------------------------------------------- */
   /*  $("#submitButton").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");*/ 
    $("#submitButton").on('click', function(e) { 
    	debugger;
    var formdata=$("#form_Submit").serialize();
//    $("#submitButton").click(function(){
	
	 if($('#assmntName').html()=="This is invalid" || $('#total_Marks_msg').html()=="This is invalid" ||  $('#duration_in_Min_msg').html()=="This is invalid" ||  $('#description_msg').html()=="This is invalid" || $('#level_msg').html()=="This is invalid" || $('#assessmentType_msg').html()=="This is invalid" || $('#course_msg').html()=="This is invalid" || $('#no_of_Slot_msg').html()=="This is invalid" || $('#start_Time_msg').html()=="This is invalid" || $('#end_Time_msg').html()=="This is invalid"){
		 alert("Please fill all the currect deatils");
		e.preventDefault();

		$('#myModal').modal('show');
		return false;
	 }
	 else if($('#assesment_Name').val()=="" || $('#total_Marks').val()=="" || $('#duration_in_Min').val()=="" || $('#duration').val()=="" || $('#dob').val()=="" || $('#descrition').val()=="" || $('#level').val()==-1 || $('#assessmentType').val()==-1 || $('#course').val()==-1 || $('#no_of_Slot').val()=="" || $('#start_Time').val()=="" || $('#end_Time').val()=="" ){
			 alert("Please fill all the field ");
		e.preventDefault();
		$('#myModal').modal('show');
return false;
		 }
		 else{
			//alert("please Enter correct");
		 
	// });

      $.ajax({
              url: "<%=application.getContextPath()%>/AddAssessment",
													//	data : {"assesment_Id":assesment_Id},
													    data :formdata,
														type : "post",
														success : function(data) {
															$('#myModal').modal('hide');													
															$('#contact_dialog .modal-header .modal-title').html("Result");
															$('#contact_dialog .modal-body').html(data);
															/* $("#submitButton").remove(); */
															//alert("Your Records has been Saved Successfully...");
															$("#success-msg")
																	.html(
																			"<div class='alert alert-success fade in' style='text-align: center;'>"
																					+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
																					+ " <strong>Success!!!</strong> Your Records has been Saved Successfully..."
																					+ "</div>");
															myLoad();
														},//sucess
														error : function(jqXHR,
																status, error) {
															console.log(status
																	+ ": "
																	+ error);

															$("error-msg")
																	.html(
																			"<div class='alert alert-danger fade in' style='text-align: center;'>"
																					+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
																					+ "<strong>Sorry!!!</strong> Your Records has not been Saved Successfully..."
																					+ "</div>");
														}//error
													});//error
											}
										});
        
    
					});
					
function myLoad(){
	
	
	$.ajax({
        type: "POST",
        url: "<%=application.getContextPath()%>/AssesmentDetailsForEditAction",
        success: function(object)
        {
        	if(object!=''){
        	$("#data").empty();
        	var	s="";
        	$("#records").html("");
        	 for (var i= 0; i < object.length; i++) {
        		 console.log(object[i]);
        		 
        		$("#records").append("<div class='col-md-6'><div class='panel panel-primary'>"
        			    +"<div class='panel-heading'><div class='row'><div class='col-sm-6'>"+object[i].assessmentName+"</div><div class='col-sm-6' style='text-align:right;'><input class='btn btn-primary' type='button'  assessmentIdEdit='"+object[i].assessmentId+"' name='edit' data-toggle='modal' data-target='#myEditModal' value='Edit'></div></div></div>"
        			    +"<div class='panel-body'><br/><strong>Marks: </strong>"+object[i].assessmentMarks+"<br/><strong>Duration: </strong>"
        			    +object[i].assessmentDuration+"<br/><strong>Date: </strong>"+object[i].assessmentDate+"<br/><strong>Assessment Type: </strong>"+object[i].assessmentTypeName+
        			    "<br/><strong>Course Name: </strong>"+object[i].courseName+"<br/><strong>Level: </strong>"+object[i].levelName+"<br/><strong>No. of Students for a Slot: </strong>"
        			    +object[i].no_of_students_for_a_slot+"<br/><strong>Start Time: </strong>"+object[i].start_time_of_slots+"<br/><strong>End Time: </strong>"+object[i].end_time_slots+"<br/><strong>Description: </strong>"+object[i].assessmentDescription+"<br/><br/></div><br/>"
        			   +"</div></div>");
        		 
        		dataLoad();
     
        	 }
        	}else{
        		$("#records").html('No Records Found');
        	}
        	 
	
        },error:function(){
        	alert("err");
        }
    });
	
}


</script>



<script>
function dataLoad(){
$("input[assessmentIdEdit]").on("click",function(){
	
		var assessmentId= $(this).attr("assessmentIdEdit");
			//alert("==========="+assessmentId);
			$("#hid").val(assessmentId);
			var objres; 
			 $.ajax({
					url:"<%=application.getContextPath()%>/ViewAssessmentdetailsForEdit",
					data :{"assessmentId" : assessmentId},
					success:function(obj){
					objres=obj;
				//	alert(obj+"vj");
						console.log(obj);
						$('#assesment_edit_Id').val(obj.assesmentId);
						$('#assesment_edit_Name').val(obj.assesment);
						 $('#total_edit_Marks').val(obj.totalMarks);
						 $('#duration_edit_in_Min').val(obj.durationInMin);
						 $('#descrition_edit').val(obj.description);
						 $('#dob_edit').val(obj.date);
						// $('#level_edit').val(obj.level.levels);
						// $('#assessmentType_edit').val(obj.assesmentType.assesmentTypeName);
						// $('#course_edit').val(obj.course.course);
						 $('#no_of_Slot_edit').val(obj.NoOfStudentsForaSlot);
						 $('#start_Time_edit').val(obj.StartTime);
						 $('#end_Time_edit').val(obj.EndTime);

						 
						 $('#assmnt_edit_Name_msg').empty();
						 $('#total_edit_Marks_msg').empty();
						 $('#duration_edit_in_Min_msg').empty();
						 $('#descrition_edit_msg').empty();
						 $('#level_edit_msg').empty();
						 $('#assessmentType_edit_msg').empty();
						 $('#course_edit_msg').empty();
						 $('#no_of_Slot_edit_msg').empty();
						 $('#start_Time_edit_msg').empty();
						 $('#end_Time_edit_msg').empty();
								
							
						 /*    This is for removeing sucess-msg */
						 $("#success-msg").empty();
						 //	alert(obj+"vj");
						 $.ajax({
						     type: "POST",
						     url: "<%=application.getContextPath()%>/GetLevelAction",
						     success: function(levelEdit)
						     {
						     	
						     	$("#level_edit").empty();
									$.each(levelEdit, function(id,val) {
										
									debugger;
								//	alert("obj"+obj+objres);
										if(obj.level.level==val.level){
											$("#level_edit").append(
													"<option selected value="+val.levelId+">" + val.level
															+ "</option>");
										}else{
												 $("#level_edit").append(
														"<option value="+val.levelId+">" + val.level
																+ "</option>"); 
											//alert("not match");
										}
									});
						     },
						     error:function(){
						     	alert("PLEASE TRY LATER");
						     }
						 }); 
							 	$.ajax({
						     type: "POST",
						     url: "<%=application.getContextPath()%>/GetAssessmentType",
						     success: function(typeEdit)
						     {
						     	
						     	debugger;
						     	$("#assessmentType_edit").empty();
						     	$.each(typeEdit, function(id,val) {
										debugger;

										//alert("obj"+obj+objres);
						     		if(obj.assesmentType.assesmentTypeName==val.assesmentTypeName){
									
						     			$("#assessmentType_edit").append(
												"<option selected value="+val.assesmentTypeId+">" + val.assesmentTypeName
														+ "</option>");
						     		}
										else{
											
										
											$("#assessmentType_edit").append(
													"<option  value="+val.assesmentTypeId+">" + val.assesmentTypeName
															+ "</option>");
										}
							});
						     
						     },error:function(){
						     	alert("PLEASE TRY LATER");
						     }
						 });
							 	$.ajax({
						     type: "POST",
						     url: "<%=application.getContextPath()%>/GetCourses",
						     success: function(coursesEdit)
						     
						     {
						     	
						  
						     $("#course_edit").empty();

							//	alert("obj"+obj+objres);
						     	$.each(coursesEdit, function(id,val) {
						     		debugger;
						     		if(objres.course.course==val.course){
										$("#course_edit").append(
												"<option selected value="+val.courseId+">" + val.course
														+ "</option>");
										}
										else{
											$("#course_edit").append(
													"<option  value="+val.courseId+">" + val.course
															+ "</option>");
											
										}
							});
						    
						     },error:function(){
						 	alert("PLEASE TRY LATER");
						 }
						 }); 
						 
						 
					},//sucess
					error:function(){
						
						alert("please try later");
					}
					
				});
});
}
</script> 
<script >
function getUpdate(){
	 if($('#assmnt_edit_Name_msg').html()=="This is invalid" || $('#total_edit_Marks_msg').html()=="This is invalid" ||  $('#duration_edit_in_Min_msg').html()=="This is invalid" ||  $('#descrition_edit_msg').html()=="This is invalid" || $('#level_edit_msg').html()=="This is invalid" || $('#assessmentType_edit_msg').html()=="This is invalid" || $('#course_edit_msg').html()=="This is invalid" || $('#no_of_Slot_edit_msg').html()=="This is invalid" || $('#start_Time_edit_msg').html()=="This is invalid" || $('#end_Time_edit_msg').html()=="This is invalid"){
		 
		 alert("Please fill all the currect deatils");
		 $('#myEditModal').modal('show');
			return false;
	 }
	 else{
	//alert("you are updating records");
	var fsUpdatedata=$("#editassgn").serialize();
	//twitter bootstrap script
   // alert(fsUpdatedata);
		$.ajax({
			type : "get",
			data: fsUpdatedata,
			url : "<%=application.getContextPath()%>/EditAssessment",
			success : function(data) {
				 $('#myEditModal').modal('hide');
				//alert(data);
				$(
						'#contact_dialog .modal-header .modal-title')
						.html(
								"Result");
				$(
						'#contact_dialog .modal-body')
						.html(data);
				/* $("#updateSubmit")
						.remove(); */
				//alert("Your Records has been Updated Successfully...");
				$("#success-msg")
						.html(
								"<div class='alert alert-success fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+ " <strong>Success!!!</strong> Your Records has been Updated Successfully..."
										+ "</div>");
				
				
				 myLoad();
				
			},
			error : function(jqXHR,
					status, error) {
				console.log(status
						+ ": "
						+ error);

				$("error-msg")
						.html(
								"<div class='alert alert-danger fade in' style='text-align: center;'>"
										+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
										+ "<strong>Sorry!!!</strong> Your Records has not been Updated Successfully..."
										+ "</div>");
			}
		
		
		});
	 
		
	 }//else
	
}//function
</script>

<!-- For Edit Functionlty  -->


                 <!-- ******************************** jQuery ADD Assessment Form Validation code ------------------------------->
                                                        
 
  
   <script type="text/javascript">
 // When the browser is ready...
  //variable for split
 
 $('document').ready(function(){
	 //----------------------------------------------------------------
//	$("#submitButton").hide();

 
	
	 //----------------------------------------------------------------
 //valisdayion
 $(function() {
		    $('#datetimepicker3').datetimepicker({
		    	 format: 'HH:mm:ss',
		         pickDate: false,
		         pickSecond:true,
		         pick12HourFormat: false  
		      
		    });
		  });
 $(function() {
	    $('#datetimepicker4').datetimepicker({
	    	 format: 'HH:mm:ss',
	         pickDate: false,
	         pickSecond:true,
	         pick12HourFormat: false  
	      
	    })
	  });
	 
	 
	 
	// Setup form validation on the assesment name
	 $("#assesment_Name").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z]/);
		if(reg.test(val)){
			$("#assmntName").html("This is valid");

			$('#assmntName').css("color","green");
		}
		else{
			$('#assmntName').html("This is invalid");
			$('#assmntName').css("color","red");
			
		}
		
	 });
	
	// Setup form validation on the total marks
	 $("#total_Marks").on('blur',function(){
			var val = $(this).val();
			var reg = new RegExp(/^[0-9]{1,2}$/);
			if(reg.test(val)){
				$("#total_Marks_msg").html("This is valid");
				$('#total_Marks_msg').css("color","green");	
			}
			else{
				$('#total_Marks_msg').html("This is invalid");
				$('#total_Marks_msg').css("color","red");
			}
		});
	 
	// Setup form validation on the duration in mins
	 $("#duration_in_Min").on('blur',function(){
		 var val = $(this).val();
		 var reg = new RegExp(/^[0-9]/);
		 if(reg.test(val)){
			 $('#duration_in_Min_msg').html("This is valid");
			 $('#duration_in_Min_msg').css("color","green");
		 }
		 else{
			 $('#duration_in_Min_msg').html("This is invalid");
			 $('#duration_in_Min_msg').css("color","red");
		 }
 	 });
	 
	// Setup form validation on the date
	 $("#dob").datepicker({
         minDate: 0
         
     });
	  /* $("#dob").on('blur',function(){
		 var val = $(this).val();
		 var reg = new RegExp(/^[0-9]/);
		 if(reg.test(val)){
			 $('#date_msg').html("This is Valid");
			 $('#date_msg').css("color","green");
		 }
		 else{
			 $('#date_msg').html("This is invalid");
			 $('#date_msg').css("color","red");
		 }
 	 }); */
	 
	// Setup form validation on the description
	 $("#descrition").on('blur',function(){
		 var val = $(this).val();
		 var reg = new RegExp(/^[a-z A-Z 0-9]/);
		 if(reg.test(val)){
			 $('#description_msg').html("This is valid");
			 $('#description_msg').css("color","green");
		 }
		 else{
			 $('#description_msg').html("This is invalid");
			 $('#description_msg').css("color","red");
		 }
 	 });
	//validation for level
	$("#level").on('blur',function(){
		 var valueLevel = $(this).val();
		 var reg = new RegExp(/^[-1]/);
		 if(valueLevel==-1){
			
			 $('#level_msg').html("This is invalid");
			 $('#level_msg').css("color","red");
		 }
		 else{
			 $('#level_msg').html("This is valid");
			 $('#level_msg').css("color","green");
		 }
 	 });
	//validation for assesmentType
	$("#assessmentType").on('blur',function(){
		 var val = $(this).val();
		 var reg = new RegExp(/^[-1]/);
		 if(val==-1){
			
			 $('#assessmentType_msg').html("This is invalid");
			 $('#assessmentType_msg').css("color","red");
		 }
		 else{
			 $('#assessmentType_msg').html("This is valid");
			 $('#assessmentType_msg').css("color","green");
		 }
 	 });
	
	//validation for course
	 $("#course").on('blur',function(){
		 var vale = $(this).val();
		 var reg = new RegExp(/^[-1]/);
		 if(vale==-1){
			
			 $('#course_msg').html("This is invalid");
			 $('#course_msg').css("color","red");
		 }
		 else{
			 $('#course_msg').html("This is valid");
			 $('#course_msg').css("color","green");
		 }
 	 });
	//SetUp Total no of student for a slot
	$("#no_of_Slot").on('blur',function(){
			var val = $(this).val();
			var reg = new RegExp(/^[0-9]/);
			if(reg.test(val)){
				$("#no_of_Slot_msg").html("This is valid");
				$('#no_of_Slot_msg').css("color","green");	
			}
			else{
				$('#no_of_Slot_msg').html("This is invalid");
				$('#no_of_Slot_msg').css("color","red");
			}
		});
	
	 //Start_Time validation
	 $("#start_Time").on('blur',function(){
			var val = $(this).val();
			var reg = new RegExp(/^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]/);
			  
			 
			if(reg.test(val)){
				$("#start_Time_msg").html("This is valid");
				$('#start_Time_msg').css("color","green");	
			}
			else{
				$('#start_Time_msg').html("This is invalid");
				$('#start_Time_msg').css("color","red");
			}
		});
	 //end time validation
	  $("#end_Time").on('blur',function(){
			var val = $(this).val();
		
			var st = $("#start_Time").val();
			   //end_time_String=val; 
	
			  var end_time_hh=val.split(":");
			  var stArr = st.split(":")
			  
			var reg = new RegExp(/^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]/);
			if( stArr[0]*1>=end_time_hh[0]*1){
			//	alert("Assesment Start time is less than or equal End Assesment time");
				  
				$('#end_Time_msg').html("This is invalid");
				$('#end_Time_msg').css("color","red");
			}
			else if(reg.test(val)){
				$("#end_Time_msg").html("This is valid");
				$('#end_Time_msg').css("color","green");	
			}
			else{
				$('#end_Time_msg').html("This is invalid");
				$('#end_Time_msg').css("color","red");
			}
		});
	
	/*  
	   */
 });

 
    	
  </script>
  <!-- ******************************** </jQuery ADD Assessment Form Validation code ------------------------------->
  
  
    <!-- ******************************** <jQuery Edit Assessment Form Validation code ------------------------------->

   <script type="text/javascript">
 // When the browser is ready...
 $('document').ready(function(){
	
 
	 $(function() {
		    $('#datetimepicker5').datetimepicker({
		    	 format: 'HH:mm:ss',
		         pickDate: false,
		         pickSecond:true,
		         pick12HourFormat: false  
		         
		      
		    });
		  });
	 $(function() {
		    $('#datetimepicker6').datetimepicker({
		    	 format: 'HH:mm:ss',
		         pickDate: false,
		         pickSecond:true,
		         pick12HourFormat: false  
		      
		    });
		  });
	// Setup form validation on the assesment name
	 $("#assesment_edit_Name").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z]/);
		if(reg.test(val)){
			$("#assmnt_edit_Name_msg").html("This is valid");

			$('#assmnt_edit_Name_msg').css("color","green");
		}
		else{
			$('#assmnt_edit_Name_msg').html("This is invalid");
			$('#assmnt_edit_Name_msg').css("color","red");
			
		}
		
	 });
	
	// Setup form validation on the total marks
	 $("#total_edit_Marks").on('blur',function(){
			var val = $(this).val();
			var reg = new RegExp(/^[0-9]{1,2}$/);
			if(reg.test(val)){
				$("#total_edit_Marks_msg").html("This is valid");
				$('#total_edit_Marks_msg').css("color","green");	
			}
			else{
				$('#total_edit_Marks_msg').html("This is invalid");
				$('#total_edit_Marks_msg').css("color","red");
			}
		});
	 
	// Setup form validation on the duration in mins
	 $("#duration_edit_in_Min").on('blur',function(){
		 var val = $(this).val();
		 var reg = new RegExp(/^[0-9]/);
		 if(reg.test(val)){
			 $('#duration_edit_in_Min_msg').html("This is valid");
			 $('#duration_edit_in_Min_msg').css("color","green");
		 }
		 else{
			 $('#duration_edit_in_Min_msg').html("This is invalid");
			 $('#duration_edit_in_Min_msg').css("color","red");
		 }
 	 });
	 
	// Setup form validation on the date
	 $("#dob_edit").datepicker({
         minDate: 0
     });
	/*  $("#dob").on('blur',function(){
		 var val = $(this).val();
		 var reg = new RegExp(/^[0-9]/);
		 if(reg.test(val)){
			 $('#date_edit_msg').html("This is valid");
			 $('#date_msg').css("color","green");
		 }
		 else{
			 $('#date_msg').html("This is invalid");
			 $('#date_msg').css("color","red");
		 }
 	 });
	 */
	 
	 /*
	 
	 <div class='row'>
	 
	 
	 
	 </div>
	 
	 */
	 
	// Setup form validation on the description
	 $("#descrition_edit").on('blur',function(){
		 var val = $(this).val();
		 var reg = new RegExp(/^[a-z A-Z 0-9]/);
		 if(reg.test(val)){
			 $('#descrition_edit_msg').html("This is valid");
			 $('#descrition_edit_msg').css("color","green");
		 }
		 else{
			 $('#descrition_edit_msg').html("This is invalid");
			 $('#descrition_edit_msg').css("color","red");
		 }
 	 });
	//validation for level
	$("#level_edit").on('blur',function(){
		 var valueLevel = $(this).val();
		 var reg = new RegExp(/^[-1]/);
		 if(valueLevel==-1){
			
			 $('#level_edit_msg').html("This is invalid");
			 $('#level_edit_msg').css("color","red");
		 }
		 else{
			 $('#level_edit_msg').html("This is valid");
			 $('#level_edit_msg').css("color","green");
		 }
 	 });
	//validation for assesmentType
	$("#assessmentType_edit").on('blur',function(){
		 var val = $(this).val();
		 var reg = new RegExp(/^[-1]/);
		 if(val==-1){
			
			 $('#assessmentType_edit_msg').html("This is invalid");
			 $('#assessmentType_edit_msg').css("color","red");
		 }
		 else{
			 $('#assessmentType_edit_msg').html("This is valid");
			 $('#assessmentType_edit_msg').css("color","green");
		 }
 	 });
	
	//validation for course
	 $("#course_edit").on('blur',function(){
		 var vale = $(this).val();
		 var reg = new RegExp(/^[-1]/);
		 if(vale==-1){
			
			 $('#course_edit_msg').html("This is invalid");
			 $('#course_edit_msg').css("color","red");
		 }
		 else{
			 $('#course_edit_msg').html("This is valid");
			 $('#course_edit_msg').css("color","green");
		 }
 	 });
	//SetUp Total no of student for a slot
	$("#no_of_Slot_edit").on('blur',function(){
			var val = $(this).val();
			var reg = new RegExp(/^[0-9]/);
			if(reg.test(val)){
				$("#no_of_Slot_edit_msg").html("This is valid");
				$('#no_of_Slot_edit_msg').css("color","green");	
			}
			else{
				$('#no_of_Slot_edit_msg').html("This is invalid");
				$('#no_of_Slot_edit_msg').css("color","red");
			}
		});
	
	 //Start_Time validation
	 $("#start_Time_edit").on('blur',function(){
			var val = $(this).val();
			var reg = new RegExp(/^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]/);
			if(reg.test(val)){
				$("#start_Time_edit_msg").html("This is valid");
				$('#start_Time_edit_msg').css("color","green");	
			}
			else{
				$('#start_Time_edit_msg').html("This is invalid");
				$('#start_Time_edit_msg').css("color","red");
			}
		});
	 //end time validation
	  $("#end_Time_edit").on('blur',function(){
			var val = $(this).val();
			var reg = new RegExp(/^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]/);
			if(reg.test(val)){
				$("#end_Time_edit_msg").html("This is valid");
				$('#end_Time_edit_msg').css("color","green");	
			}
			else{
				$('#end_Time_edit_msg').html("This is invalid");
				$('#end_Time_edit_msg').css("color","red");
			}
		});
	 
	  $("#end_Time_edit").on('blur',function(){
			var val = $(this).val();
		
			var st = $("#start_Time_edit").val();
			   //end_time_String=val; 
	
			  var end_time_hh=val.split(":");
			  var stArr = st.split(":")
			  
			var reg = new RegExp(/^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]/);
			if( stArr[0]*1>=end_time_hh[0]*1){
				alert("Assesment start time is less than end Assesment time");
				  
				$('#end_Time_edit_msg').html("This is invalid");
				$('#end_Time_edit_msg').css("color","red");
			}
			else if(reg.test(val)){
				$("#end_Time_edit_msg").html("This is valid");
				$('#end_Time_edit_msg').css("color","green");	
			}
			else{
				$('#end_Time_edit_msg').html("This is invalid");
				$('#end_Time_edit_msg').css("color","red");
			}
		});
	
	/*  
	   */
 });

 
    	
  </script>
 
</body>
</html>