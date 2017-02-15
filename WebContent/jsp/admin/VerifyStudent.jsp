<!-- @authors Srikanth and Krunal B35-->

<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.nacre.online_assesment.dto.CourseDTO"%>
<%@page import="com.nacre.online_assesment.vo.StudentCourseDetailsBean"%>
<%@page import="com.nacre.online_assesment.dto.CountryDTO"%>
<%@page import="com.nacre.online_assesment.dto.StreamDTO"%>
    
<%@page import="com.nacre.online_assesment.vo.StudentEducationDetailsToVerifyBean"%>
<%@page import="com.nacre.online_assesment.vo.StudentPersonalDetailsToVerifyBean"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.online_assesment.dao_i.StudentDetailsUpdationDaoi"%>

<%@page import="com.nacre.online_assesment.dto.UserDTO"%>
<%@page import="java.util.List"%>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>

<!---->
<!DOCTYPE html>
<html lang="en">
	<head>

	<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="Nacre Software Services Assesment"  />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<title>Search - Student</title>

		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>

  <link href="sticky-footer-navbar.css" rel="stylesheet">

<!--     <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 --> <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/assets/css/mycss/mystyle.css">

	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/jquery-ui.custom.min.css" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/jquery.gritter.min.css" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/select2.min.css" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/datepicker.min.css" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/bootstrap-editable.min.css" />
<style type="text/css">
.title-head{

    position: relative;
    left: 7%;
    }
</style>

</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/special_admin_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>

			<div class="main-content">
				<div class="main-content-inner">
				
			

					<div class="page-content">
					
				
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >VIEW STUDENT INFORMATION</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

		

	
 
  <!-- code to get request atribute. the atribute contains two objects
  one is studentPersonalDetailsToVerifyBean object and 
  another one is List which contains multiple objects of type studentEduDetailsToVerifyBean  one per edu_type basis
    -->
 <%
 List studentDetails = (List)request.getAttribute("studentDetailsList");
 System.out.println(studentDetails);
 if(studentDetails!=null){
	 StudentPersonalDetailsToVerifyBean personalDetails = (StudentPersonalDetailsToVerifyBean)studentDetails.get(0);
	 
	 List stuEduList = (List)studentDetails.get(1);
 %>
  
  


			<!--#INCLUDE VIRTUAL="TopNavInclude.asp" -->
			<div >
				<div class="col-md-12"> 
						
					<div class="panel panel-default panel-fade">
					
						<div class="panel-heading">
					   
							<span class="panel-title">
							
								<div class="pull-left" id="tabs">
								
								<ul class="nav nav-tabs" >
									<li id="btn1" class="active"><a href="#personal" data-toggle="tab"><i class="glyphicon glyphicon-user"></i> Personal</a></li>
									<li id="btn2"><a href="#education" data-toggle="tab"><i class="glyphicon glyphicon-list-alt"></i> Education</a></li>
									<li id="btn3"><a href="#courses" data-toggle="tab"><i class="glyphicon glyphicon-list"></i> Course</a></li>
								</ul>
									
								</div>
								<div class="clearfix"></div>

							</span>
							
						</div>
						 <div class="panel-body">
							<div class="tab-content">
						            <div class="tab-pane fade in active" id="personal">
									<h3 class='title-head'>Personal Details</h3>
								 <FORM ACTION="#" METHOD="post">
								 <div class="page-content">
						<div class="row">
								<div >
	<div id="user-profile-1" class="user-profile row">
		<div class="col-xs-12 col-sm-3 center">
		<div class="space-12"></div>
			<div>
				<span class="profile-picture">
					<img id="avatar" class="editable img-responsive" alt="Alex's Avatar" src="<%=personalDetails.getImage() %>" />
			</span>

			<div class="space-4"></div>

			<div class="width-auto label label-info label-xlg arrowed-in arrowed-in-right" >
			<div class="inline position-relative">
				<a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
					<i class="ace-icon fa fa-circle light-green"></i>
					&nbsp;
					<span class="white"><%=personalDetails.getFname()%> </span>
				</a>

			</div>
			</div>
			</div>	
		</div>
		<div class="col-xs-12 col-sm-8">
			<div class="space-12"></div>

				<div class="profile-user-info profile-user-info-striped">
					<div class="profile-info-row">
						<div class="profile-info-name"> Username </div>

						<div class="profile-info-value">
							<span class="editable" id="fname"><%=personalDetails.getFname()%></span>
							<span class="editable" id="lname"><%=personalDetails.getLname()%></span>
						</div>
					</div>
					 <div class="profile-info-row">
						<div class="profile-info-name"> Email </div>
					
						<div class="profile-info-value">
							<span class="editable" id="email"><%=personalDetails.getMail()%></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">Mobile No.</div>
					
						<div class="profile-info-value">
							<span class="editable" id="mobile_no"><%=personalDetails.getMobileNo()%></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> Gender </div>
					
						<div class="profile-info-value">
							<span class="editable" id="gender">
							<%if(personalDetails.getGender()==1){ %>
							Male
							<%}else if(personalDetails.getGender()==0){ %>
							FeMale
							<%} %>
							</span>
						</div>
					</div>
					<!-- <div class="profile-info-row">
						<div class="profile-info-name"> Nacre </div>
					
						<div class="profile-info-value">
							<span class="editable" id="email">yes</span>
						</div>
					</div> -->
				<div class="profile-info-row">
					<div class="profile-info-name"> Address </div>

					<div class="profile-info-value" id='addr-editable-wrapper'>
						<i class="fa fa-map-marker light-orange bigger-110"></i>
						<span class="editable" id="location"><%=personalDetails.getLocation()%></span>
						<span class="editable" id="pincode"><%=personalDetails.getPincode()%></span>
						<span class="editable" id="country"><%=personalDetails.getCountry()%></span>
						<label class='stae-edit-wrapper'><span class="editable" id="state"><%=personalDetails.getState()%></span>
						</label>
						<label class='city-edit-wrapper'>
						<span class="editable" id="city"><%=personalDetails.getCity()%></span>
					</label>
					</div>
				</div>
				

				<div class="profile-info-row">
					<div class="profile-info-name">Date of Birth </div>

					<div class="profile-info-value">
						<%-- <span class="editable" id="dob"><%=personalDetails.getDob()%></span> --%>
						<span><a href="#" id="dob" data-format="dd.mm.yyyy"><%=personalDetails.getDob()%></a></span>
					</div>
				</div>
		</div>
		<div class="space-20"></div>
		<div class="center"><a href="#education" data-toggle="tab">
			<button type="button" class="btn btn-sm btn-primary btn-white btn-round ">
				<span class="bigger-110" style="font-size:14px" id='button'>Save &amp; Continue..</span>
				<i class="icon-on-right ace-icon fa fa-arrow-right"></i>
			</button></a>
		</div>
	</div>
</div>
</div>
</div>
</div>
									
									
								</FORM>
								</div>
							
													
								<div class="tab-pane fade" id="education">
								<h3>Education</h3>								 
								 <FORM ACTION="#" METHOD="post">
								 <div class="page-content">
						<div class="row">
								<div >
	<div id="user-profile-1" class="user-profile row">
		<div class="col-xs-12 col-sm-9">
		
		<!-- code to disply different type edu_type details by iterating the stuEduList 
		for every iteration of for loop it displayes one edu_type details i.e Graduation or HSC or SSC.
		-->
		
		<script type="text/javascript">
		
		var sscGrade; var sscYop; var sscEdu_Id; var hscGrade; var hscYop;var hscEdu_Id; var userId;
		var gradGrade; var gradYop; var gradStreamId; var gradCol; var gradUnivId; var gradLocation; var gradPincode; var gradCityId;var gradEdu_Id;
		var pgGrade; var pgYop; var pgStreamId; var pgCol; var pgUnivId; var pgLocation;var pgPincode; var pgCityId;var pgEdu_Id;  
		var isNewPg=false; var PG=false;
		
		
		<%
	
		for(Object obj:stuEduList){
			StudentEducationDetailsToVerifyBean eduDetails = (StudentEducationDetailsToVerifyBean)obj;
			
			%>
			userId='<%=eduDetails.getUserId()%>';
		
			<%
			if(eduDetails.getEdu_type_Id()==StringConstants.SSC_EDUCATION_TYPE_ID){%> 
			sscEdu_Id='<%=eduDetails.getEdu_type_Id()%>';
			sscGrade='<%=eduDetails.getPercent_grade()%>';
			sscYop='<%=eduDetails.getYear_of_pass()%>';
			<%}
			if(eduDetails.getEdu_type_Id()==StringConstants.HSC_EDUCATION_TYPE_ID){%>
			hscEdu_Id='<%=eduDetails.getEdu_type_Id()%>';
			hscGrade='<%=eduDetails.getPercent_grade()%>';
			hscYop='<%=eduDetails.getYear_of_pass()%>';
			<%}
			if(eduDetails.getEdu_type_Id()==StringConstants.GRADUATION_EDUCATION_TYPE_ID){%>
			gradEdu_Id='<%=eduDetails.getEdu_type_Id()%>';
			gradGrade='<%=eduDetails.getPercent_grade()%>'; gradYop = '<%=eduDetails.getYear_of_pass()%>';
			gradStreamId='<%=eduDetails.getStreamId()%>'; gradCol = '<%=eduDetails.getCollege()%>';
			gradUnivId='<%=eduDetails.getUnivercityId()%>'; gradLocation = '<%=eduDetails.getLocation()%>';
			gradCityId='<%=eduDetails.getCityId()%>'; gradPincode='<%=eduDetails.getPincode()%>';
			gradCountryId='<%=eduDetails.getCountryId()%>'; gradStateId='<%=eduDetails.getStateId()%>';
			
			<%}
			if(eduDetails.getEdu_type_Id()==StringConstants.PG_EDUCATION_TYPE_ID){%>
			PG=true;
			pgEdu_Id='<%=eduDetails.getEdu_type_Id()%>';
			pgGrade='<%=eduDetails.getPercent_grade()%>'; pgYop = '<%=eduDetails.getYear_of_pass()%>';
			pgStreamId='<%=eduDetails.getStreamId()%>'; pgCol = '<%=eduDetails.getCollege()%>';
			pgUnivId='<%=eduDetails.getUnivercityId()%>'; pgLocation = '<%=eduDetails.getLocation()%>';
			pgCityId='<%=eduDetails.getCityId()%>';pgPincode='<%=eduDetails.getPincode()%>';
			PGCountryId='<%=eduDetails.getCountryId()%>'; PGStateId='<%=eduDetails.getStateId()%>';
			
			<%}
			
		}%>
		</script>
				<% String id="";
				boolean PG=false;
		for(Object obj:stuEduList){
			
			StudentEducationDetailsToVerifyBean eduDetails = (StudentEducationDetailsToVerifyBean)obj;
			if(eduDetails.getEdu_type().equals(StringConstants.HSC_EDUCATION_TYPE)||eduDetails.getEdu_type().equals(StringConstants.SSC_EDUCATION_TYPE)){
				
				if(eduDetails.getEdu_type().equals(StringConstants.HSC_EDUCATION_TYPE)){
					id="HSC";
				System.out.println("edu type in hsc"+eduDetails.getEdu_type());
				System.out.println("edu type in hsc constant "+StringConstants.HSC_EDUCATION_TYPE);
				}
				if(eduDetails.getEdu_type().equals(StringConstants.SSC_EDUCATION_TYPE)){
					id="SSC";
				}
			%>
				<div class="profile-user-info profile-user-info-striped">
				<span style="font-size:17px; color:#6688a6"><%=eduDetails.getEdu_type()%>_Info</span>
					<div class="profile-info-row">
						<div class="profile-info-name">Percentage/Grade </div>

						<div class="profile-info-value">
							<span class="editable" id="precent<%=id%>"><%=eduDetails.getPercent_grade()%></span>
						</div>
					</div>
					 <div class="profile-info-row">
						<div class="profile-info-name">Year Of Passout </div>
					
						<div class="profile-info-value">
							<span class="editable" id="year<%=id%>"><%=eduDetails.getYear_of_pass()%></span>
						</div>
					</div>
												
		</div>
		
				<% } else{
				
					if(eduDetails.getEdu_type().equals(StringConstants.GRADUATION_EDUCATION_TYPE)){
						id="grad";
					}
					if(eduDetails.getEdu_type().equals(StringConstants.PG_EDUCATION_TYPE)){
						PG=true;
						id="PG";
					}
				%>
				
				
				
								<div class="profile-user-info profile-user-info-striped">
				<span style="font-size:17px; color:#6688a6"><%=eduDetails.getEdu_type()%>_Info</span>
					<div class="profile-info-row">
						<div class="profile-info-name"> Percentage/Grade </div>

						<div class="profile-info-value">
							<span class="editable" id="precent<%=id%>"><%=eduDetails.getPercent_grade()%></span>
						</div>
					</div>
					 <div class="profile-info-row">
						<div class="profile-info-name"> Year Of Passout </div>
					
						<div class="profile-info-value">
							<span class="editable" id="year<%=id%>"><%=eduDetails.getYear_of_pass()%></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">Stream </div>
					
						<div class="profile-info-value">
							<span class="editable" id="stream<%=id%>"><%=eduDetails.getStream()%></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> CollegeName </div>
					
						<div class="profile-info-value">
							<span class="editable" id="college<%=id%>"><%=eduDetails.getCollege()%></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> University </div>
					
						<div class="profile-info-value">
							<span class="editable" id="uni<%=id%>"><%=eduDetails.getUnivercity()%></span>
						</div>
					</div>
				<div class="profile-info-row">
					<div class="profile-info-name"> Address </div>

					<div class="profile-info-value" id='addr-editable-wrapper'>
						<i class="fa fa-map-marker light-orange bigger-110"></i>
						<span class="editable" id="ed_location<%=id%>"><%=eduDetails.getLocation()%></span>
						<span class="editable" id="ed_pincode<%=id%>"><%=eduDetails.getPincode()%></span>
						<span class="editable" id="country<%=id%>"><%=eduDetails.getCountry()%></span>
						<label class='stae-edit-wrapper<%=id%>'><span class="editable" id="state<%=id%>"><%=eduDetails.getState()%></span>
						</label>
						<label class='city-edit-wrapper<%=id%>'>
						<span class="editable" id="city<%=id%>"><%=eduDetails.getCity()%></span>
					</label>
					</div>
				</div>
				
		</div>
				
				
				
			
				<%}
			}%> <!-- end of for loop -->
			
			
			
			  <div class="space-12"></div>
			<div class="profile-user-info profile-user-info-striped" id="addNewEdu">
		<!-- <div class="profile-user-info profile-user-info-striped"> -->
				<span style="font-size:17px; color:#6688a6">PG_Info</span>
				<div class="profile-info-value" >
				<span style="float:right;"  id="canclePG"><a class="primary glyphicon glyphicon-remove-circle"></a></span></div>
					<div class="profile-info-row">
						<div class="profile-info-name"> Percentage/Grade </div>
						
						<div class="profile-info-value">
							<span class="editable" id="precentPG"></span>
						</div>
						
					</div>
					 <div class="profile-info-row">
						<div class="profile-info-name"> Year Of Passout </div>
						<div class="profile-info-value">
							<span class="editable" id="yearPG"></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">Stream </div>
					
						<div class="profile-info-value">
							<span class="editable" id="streamPG"></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> CollegeName </div>
					
						<div class="profile-info-value">
							<span class="editable" id="collegePG"></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> University </div>
					
						<div class="profile-info-value">
							<span class="editable" id="uniPG"></span>
						</div>
					</div>
				<div class="profile-info-row">
					<div class="profile-info-name"> Address </div>

					<div class="profile-info-value" id='addr-editable-wrapper'>
						<i class="fa fa-map-marker light-orange bigger-110"></i>
						<span class="editable" id="ed_locationPG">enter location</span>
						<span class="editable" id="ed_pincodePG">enter pincode</span>
						<span class="editable" id="countryPG">select country</span>
						<label class='stae-edit-wrapperPG'><span class="editable" id="statePG">state</span>
						</label>
						<label class='city-edit-wrapperPG'>
						<span class="editable" id="cityPG">city</span>
					</label>
					</div>
					
				</div>
				
				
				
				
		<!-- </div> -->
			
			</div>
			<div class="center" id="validatemsg"></div>
			
			
				
		<!-- <div class="space-20"></div> -->
		<div class="center">
		
		<% if(!PG){%>
		<button type="button" class="btn btn-sm btn-primary btn-white btn-round" id='addEduButton_div'>
				<span class="bigger-110" style="font-size:14px" id='addEduButton'>ADD PG Details</span>
				
			</button>
			<% }%>
			<a href="#courses" data-toggle="tab" id='eduSaveButton'>
			<button type="button" class="btn btn-sm btn-primary btn-white btn-round">
				<span class="bigger-110" style="font-size:14px">Save&Continue..</span>
				<i class="icon-on-right ace-icon fa fa-arrow-right"></i>
			</button></a>
			
		</div>
	</div>
</div>
</div>
</div>
</div>





								 
									
								</FORM>
								</div>
								
							    <div class="tab-pane fade" id="courses">
								<h3>Courses</h3>									 
								 <FORM ACTION="#" METHOD="post">
								 <div class="page-content">
									<div class="row">
										<div>
											<div id="user-profile-1" class="user-profile row">
												<div class="col-xs-12 col-sm-8">
												<div class="space-12"></div>
											
											<%
											
											List<StudentCourseDetailsBean> courseList = (List<StudentCourseDetailsBean>)studentDetails.get(2);
											
											StudentCourseDetailsBean techBean = courseList.get(0);
											
											%>
												<script>
												var techId='<%=techBean.getTechnologyId()%>';
												</script> 
											
										<div class="profile-user-info profile-user-info-striped">
										<div class="profile-info-name"> Technology </div>
														<div class="profile-info-value">
											<span style="font-size:17px; color:#6688a6"><%=techBean.getTechnology()%> </span>
										</div>
										
												
												<div class="profile-info-row">
														<div class="profile-info-name"> Courses </div>
														<div class="profile-info-value">
											<a href="#" id="tags" data-type="select2" data-pk="1" data-title="Add or Remove courses" class="editable editable-click" data-original-title="" title="" style="background-color: rgba(0, 0, 0, 0);">
											<% for (int j = 0; j < courseList.size(); j++) { 
															 StudentCourseDetailsBean bean = courseList.get(j); %>
															 <%= bean.getCourse() %><%= j + 1 < courseList.size() ? ",":"" %>
															<%}	%>	
											</a>			
														</div>
														
												</div>
														
										<script type="text/javascript">
										
										var courses = [
									 						<% for (int j = 0; j < courseList.size(); j++) { 
															 StudentCourseDetailsBean bean = courseList.get(j); %>
															 "<%= bean.getCourse() %>"<%= j + 1 < courseList.size() ? ",":"" %>
																								 <% } %>
	               ]
										
										
										</script>
													
													
					 
												</div>
												<div class="col-lg-12 ">
												<div class="space-20"></div>
												<div class="center">
												<a href="<%=application.getContextPath() %>/<%=URLConstants.ADMIN%>"  id='reject_studentbtn' class="btn btn-sm btn-primary btn-white btn-round">
										
														 <span  class="bigger-110" >Reject </span>
														<i class="glyphicon glyphicon-remove-sign"></i>
													</a><%-- <a href="<%=application.getContextPath() %>/jsp/admin/VerificationSuccess.jsp"> --%>
													<button type="button" class="btn btn-sm btn-primary btn-white btn-round ">
														<span class="bigger-110" style="font-size:14px; text-align:right;" id='saveConfirm'>Save &amp; Confirm </span>
														<i class="icon-on-right ace-icon fa fa-arrow-right"></i>
													</button>
													<%-- <span id="wait"><img src="<%=application.getContextPath()%>/assets/img/loading.gif" width="30" height="20"></span> --%>
												</div>
													
												</div>
												</div>
											</div>
										</div>
									</div>
								</div>
									
									
								</FORM>
								</div>
						
							</div>
							
						</div> 

						
				</div>
						
			</div>

		<div id="first">
    <h1>Please Wait..</h1>
</div>

	</div>	
		
		
		
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

<div class="load"></div>
<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>
		
		
		<script src="<%=application.getContextPath()%>/assets/js/jquery-ui.custom.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/jquery.gritter.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/bootbox.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/jquery.easypiechart.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/bootstrap-datepicker.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/jquery.hotkeys.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/bootstrap-wysiwyg.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/select2.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/fuelux.spinner.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/bootstrap-editable.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/ace-editable.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/jquery.maskedinput.min.js"></script>

		
		<script type="text/javascript">
			jQuery(function($) {
			
				//editables on first profile page
				$.fn.editable.defaults.mode = 'Popup';
				$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
			    $.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>'+
			                                '<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>';    
				
				//editables 
				

				var userId = '<%=personalDetails.getUserId()%>'; var fname='<%=personalDetails.getFname()%>'; var lname='<%=personalDetails.getLname()%>';
				var email='<%=personalDetails.getMail()%>'; var mobile_no='<%=personalDetails.getMobileNo()%>'; var pincode='<%=personalDetails.getPincode()%>'
				var genderId='<%=personalDetails.getGender()%>'; var location='<%=personalDetails.getLocation()%>'; var cityId=<%=personalDetails.getCity_id()%>;
				var countryId='<%=personalDetails.getCountryId()%>'; var stateId ='<%=personalDetails.getStateId()%>';
				var dob='<%=personalDetails.getDob()%>';
				var image='<%=personalDetails.getImage()%>';

				//text editable
			    $('#fname')
				.editable({
					
					type: 'text',
					name: 'username',
					title:'Enter first name',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				    	}
						var regex = /^([a-zA-Z]{1})[a-zA-Z ]+$/; 
						if(!value.match(regex)) {
				            return 'enter correct value';
				        }
					},
					success: function(response, newValue) {
							fname = newValue;										
								}
						 
			    });
				
			    $('#lname')
				.editable({
					type: 'text',
					name: 'username',
					title:'Enter last name',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				    	}
						var regex = /^([a-zA-Z]{1})[a-zA-Z ]+$/; 
						if(!value.match(regex)) {
				            return 'enter correct name';
				        }
					},
					success: function(response, newValue) {
							lname=newValue;		
							}
					
			    });

			
				$('#email')
				.editable({
					type: 'text',
					name: 'email',
					title:'Enter emailId',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				    	}
					 var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
				        if (!value.match(expr)) {
				            return 'Enter the valid email';
				        }
				    },
					success: function(response, newValue) {
					email = newValue;										
					
				}
			    });
			    $('#mobile_no')
				.editable({
					type: 'text',
					title:'Enter mobile number',
					name: 'mobile_no',
					
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				    	}
						var regex = /^([7-9][0-9]{9})$/;
				        if(! regex.test(value)) {
				            return 'enter correct mobile number';
				    } 
				       
					},
					success: function(response, newValue) {
					mobile_no = newValue;										
					}
					
			    });
			    
			    $('#gender')
				.editable({
					type: 'select',
					name: 'gender',
					title:'select gender',
					source:[
								{ value: 1, text: 'male' },
								{ value: 0, text: 'female' }
					        ],
					        success: function(response, newValue) {
							genderId = newValue;										
							}
			    });
			    
			    $('#location')
				.editable({
					type: 'text',
					name: 'location',
					title:'Enter location',
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				        var regex = /^([a-zA-Z]{1})[a-zA-Z0-9 ]+$/; 
						if(!value.match(regex)) {
				            return 'should start with alphabet';
				        }
				    	},
					success: function(response, newValue) {
						location = newValue;										
					}
			    });
			    
			    
			    $('#pincode')
				.editable({
					type: 'text',
					name: 'pincode',
					title:'Enter pincode',
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				        var pat1=/^\d{6}$/;
				        if(!pat1.test(value)){
				        	return 'enter valid pincode';
				        }
				    	},
					success: function(response, newValue) {
						pincode = newValue;										
					}
			    });
			    
			    
			    $(document).ready(function(){
			    	
			    var cityesOfState = getcity(stateId);
			    $('#city')
				.editable({
					type: 'select2',
					name: 'uni2',
					title:'select city',
					source: cityesOfState,
					select2: {
						'width': 140
					},
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				    	},
					success: function(response, newValue) {
					cityId = newValue;										
					}
					
			    });
			    
			    var stateOfCountry = getStates(countryId);
			    
			    $('#state')
				.editable({
					type: 'select2',
					name: 'uni2',
					title:'select state',
					source: stateOfCountry,
					select2: {
						'width': 140
					},
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				    	},
					success: function(response, newValue) {
						
						var new_source = getcity(newValue);
						
						$(".city-edit-wrapper").html("<span class='editable' id='city'>select city</span>"); 
						 
						
						$('#city')
						.editable({
							type: 'select2',
							name: 'uni2',
							source: new_source,
							select2: {
								'width': 140
							},
							validate: function (value) {
						        if (value == '') {
						            return 'required field';
						        }
						    	},
							success: function(response, newValue) {
							cityId = newValue;										
							}
						
						});
						
					
					}
					
			    }); 
			    
			    });
			    
			    
			    
			    <%
			    RequestDispatcher rd = request.getRequestDispatcher("/"+URLConstants._GET_COUNTRY_JAVA_ACTION_ADMIN);
			    
			    rd.include(request,response);
			    
			   List countryList = (List)request.getAttribute("countryList");
			    
			    %>
			    $('#country')
				.editable({
					type: 'select2',
					name: 'uni2',
					title:'select country',
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				    	},
					source:  gaPrimaryOptions = [
					                             <% for(Object o:countryList){
					                            	 CountryDTO country = (CountryDTO)o;
					                             %>
					                               { value: <%=country.getCountryId()%>, text: '<%=country.getCountry()%>' },
					                               
												<%}%>
												],
												 select2: {
														'width': 100
													},
				
				  
							
					success: function(response, newValue) {
						
						var new_source = getStates(newValue);
						var state = $('#state').removeAttr('id').get(0);
						$(state).remove();//remove previous instance
						$(".stae-edit-wrapper").html('<span class="editable" id="state">Select State</span>');
						
						$('#state')
						.editable({
							type: 'select2',
							name: 'uni2',
							source: new_source,
							select2: {
								'width': 140
							},
							validate: function (value) {
						        if (value == '') {
						            return 'required field';
						        }
						    	},
							success: function(response, newValue) {
								
								var new_source = getcity(newValue);
								
								$(".city-edit-wrapper").html("<span class='editable' id='city'>select city</span>"); 
								 
								
								$('#city')
								.editable({
									type: 'select2',
									name: 'uni2',
									source: new_source,
									select2: {
										'width': 140
									},
									validate: function (value) {
								        if (value == '') {
								            return 'required field';
								        }
								    	},
									success: function(response, newValue) {
									cityId = newValue;										
									}
								
								});
								
							
							}
						
						});
						
						$(city).remove();//remove previous instance
						
					}

			    });
			      
				//custom date editable
				/* $('#dob').editable({
					
					type: 'adate',
					title:'Enter date of birth',
					date: {
						//datepicker plugin options
						    format: 'yyyy/mm/dd',
						viewformat: 'yyyy/mm/dd',
						 weekStart: 1
					
					},
					
					validate: function (value) {
						//var dateregex=new Regex(\d{4}(?:/\d{1,2}){2}\);
						var dateregex = /^([0-9]{4})\/|-([0-9]{2})\/|-([0-9]{2})$/;
						var regex=/^[^A-Za-z]+$/;
				        if (value == '') {
				            return 'required field';
				        }
				        if (!value.match(dateregex)) {
				            return 'Provide Correct formate';
				        }
				         if (!regex.test(value)){
				        	return 'alphabets not allowd';
				        } 
				        
				    	},
						success: function(response, newValue) {
						dob = newValue;	
						
						}
				}); */
			
$('#dob').editable({
					
 					type:  'date',
                    pk:    1,
                    name:  'dob',
                    title: 'Select Date of birth',
					date: {
						//datepicker plugin options
						    format: 'yyyy/mm/dd',
						viewformat: 'yyyy/mm/dd',
						 weekStart: 1
					
					},
					
					
						success: function(response, newValue) {
							var date = convert(newValue);
							dob=date;
						}
				});
				function convert(str) {
				    var date = new Date(str),
				        mnth = ("0" + (date.getMonth()+1)).slice(-2),
				        day  = ("0" + date.getDate()).slice(-2);
				    return [ date.getFullYear(), mnth, day ].join("-");
				}
				
				// *** editable avatar *** //
				try {//ie8 throws some harmless exceptions, so let's catch'em
			
					//first let's add a fake appendChild method for Image element for browsers that have a problem with this
					//because editable plugin calls appendChild, and it causes errors on IE at unpredicted points
					try {
						document.createElement('IMG').appendChild(document.createElement('B'));
					} catch(e) {
						Image.prototype.appendChild = function(el){}
					}
			
					var last_gritter
					$('#avatar').editable({
						type: 'image',
						name: 'avatar',
						value: null,
						image: {
							//specify ace file input plugin's options here
							btn_choose: 'Change Avatar',
							droppable: true,
							maxSize: 110000,//~100Kb
			
							//and a few extra ones here
							name: 'avatar',//put the field name here as well, will be used inside the custom plugin
							on_error : function(error_type) {//on_error function will be called when the selected file has a problem
								if(last_gritter) $.gritter.remove(last_gritter);
								if(error_type == 1) {//file format error
									last_gritter = $.gritter.add({
										title: 'File is not an image!',
										text: 'Please choose a jpg|gif|png image!',
										class_name: 'gritter-error gritter-center'
									});
								} else if(error_type == 2) {//file size rror
									last_gritter = $.gritter.add({
										title: 'File too big!',
										text: 'Image size should not exceed 100Kb!',
										class_name: 'gritter-error gritter-center'
									});
								}
								else {//other error
								}
							},
							on_success : function() {
								$.gritter.removeAll();
							}
						},
					    url: function(params) {
							// ***UPDATE AVATAR HERE*** //
							//for a working upload example you can replace the contents of this function with 
							//examples/profile-avatar-update.js
			
							 var deferred = new $.Deferred 
			
							var value = $('#avatar').next().find('input[type=hidden]:eq(0)').val();
							if(!value || value.length == 0) {
								deferred.resolve();
								return deferred.promise();
							}
			
			
							//dummy upload
							setTimeout(function(){
								if("FileReader" in window) {
									//for browsers that have a thumbnail of selected image
									var thumb = $('#avatar').next().find('img').data('thumb');
									if(thumb) $('#avatar').get(0).src = thumb;
								}
								
								deferred.resolve({'status':'OK'});
			
								if(last_gritter) $.gritter.remove(last_gritter);
								last_gritter = $.gritter.add({
									title: 'Your Image is Updated!',
									text: 'Successfully',
									class_name: 'gritter-info gritter-center'
								});
								
							 } , parseInt(Math.random() * 800 + 800))
			
							return deferred.promise();
							
							// ***END OF UPDATE AVATAR HERE*** //
						},
						
						success: function(response, newValue) {
							image=newValue;
						}
					});
				}catch(e) {}
				
				
				
				
				
					$('#button').click(function(){
						
						$("#btn1").removeClass();
						$("#btn2").addClass("active");
						
						
			    	var b64image = $("#avatar").attr("src");
			    			//alert("click event");
			    			$.ajax({
			    				type:"post",
							url:"<%=application.getContextPath()%>/<%=URLConstants._UPDATE_STUDENT_PERSONAL_DETAILS_ACTION_ADMIN%>",
					        data:{ "userId": userId,"fname": fname, "lname" : lname, "mail":email, "mobile":mobile_no,
					        	"gender":genderId, "location":location,"pincode":pincode, "cityId":cityId, "dob":dob,"image":b64image},
			    			error : function(){
					   				 alert("Please try later");
					   						 }
			    					});
			    });
				
				
				
				
				/////////////////////////////////////////////////
				//text editable
				
				
				
			    $('#precentHSC')
				.editable({
					type: 'text',
					name: 'precent',
					title: 'Enter percentage',
					validate: function (value) {
						if (value == '') {
					            return 'required field';
					    }
						if(value<35||value>100){
							return 'enter correct percentage';
						}
						var regex = /^[0-9a-eA-E]+$/; 
						if(!value.match(regex)) {
				            return 'enter correct value';
				        }
						
				    },
				    success: function(response, newValue) {
						hscGrade = newValue;										
						}
			    });
				
				$('#precentSSC')
				.editable({
					type: 'text',
					name: 'precent',
					title: 'Enter percentage',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
						if(value<35||value>100){
							return 'enter correct percentage';
						}
						var regex = /^[0-9a-eA-E]+$/; 
						if(!value.match(regex)) {
				            return 'enter correct value';
				        }
						 
				    },
				    success: function(response, newValue) {
						sscGrade = newValue;										
						}
			    });
				
			    $('#precentgrad')
				.editable({
					type: 'text',
					name: 'precent',
					title: 'Enter percentage',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
						if(value<35||value>100){
							return 'enter correct percentage';
						}
						var regex = /^[0-9a-eA-E]+$/; 
						if(!value.match(regex)) {
				            return 'enter correct value';
				        }
						 
				    },
				    success: function(response, newValue) {
						gradGrade = newValue;										
						}
			    });
			    
			    $('#precentPG')
				.editable({
					type: 'text',
					name: 'precent',
					title: 'Enter percentage',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
						if(value<35||value>100){
							return 'enter correct percentage';
						}
						var regex = /^[0-9a-eA-E]+$/; 
						if(!value.match(regex)) {
				            return 'enter correct value';
				        }
						 
				    },
				    success: function(response, newValue) {
						pgGrade = newValue;										
						}
			    });
			  
			    
			     <%
			    RequestDispatcher rd1 = request.getRequestDispatcher("/"+URLConstants._GET_EDUCATION_STREAMS_ACTION_ADMIN);
			    
			    rd1.include(request,response);
			    
			   List streamList = (List)request.getAttribute("streamList");
			    
			    %>

			    $('#streamgrad')
				.editable({
					type: 'select2',
					name: 'stream',
					title: 'select stream',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
					},
					source: [
								<% for(Object o:streamList){
	 								StreamDTO stream = (StreamDTO)o;
										%>
  									{ value: <%=stream.getStreamId()%>, text: '<%=stream.getStream()%>' },
  
										<%}%>
					         
					         ],
					         select2: {
									'width': 150
								},
					      	success: function(response, newValue) {
							gradStreamId = newValue;										
							}
					         
			    });
			    $('#streamPG')
				.editable({
					type: 'select2',
					name: 'stream',
					title: 'select stream',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
					},
					source: [
								<% for(Object o:streamList){
	 								StreamDTO stream = (StreamDTO)o;
										%>
									{ value: <%=stream.getStreamId()%>, text: '<%=stream.getStream()%>' },

										<%}%>
					         
					         ],
					         select2: {
									'width': 150
								},
					         
					         success: function(response, newValue) {
									pgStreamId = newValue;	
									}
	
			    });
			    
				$('#yearHSC')
				.editable({
					type: 'select2',
					name: 'year1',
					title: 'select year of pass',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
					},
					source:[<%for(int i = Calendar.getInstance().get(Calendar.YEAR);i>=1990;i--){%>
					{ value: <%=i%>, text: '<%=i%>' },
					
					<%}%>
		        ],
		        select2: {
					'width': 100
				},
					 success: function(response, newValue) {
							hscYop = newValue;										
							}
					   });
				
			    $('#yearSSC')
				.editable({
					type: 'select2',
					name: 'year2',
					title: 'select year of pass',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
					},
					source:[<%for(int i = Calendar.getInstance().get(Calendar.YEAR);i>=1990;i--){%>
					{ value: <%=i%>, text: '<%=i%>' },
					
					<%}%>
		        ],
		        select2: {
					'width': 100
				},
					 success: function(response, newValue) {
							sscYop = newValue;										
							}
			    });
			    
			    $('#yeargrad')
				.editable({
					type: 'select2',
					name: 'year3',
					title: 'select year of pass',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
					},
					source:[<%for(int i = Calendar.getInstance().get(Calendar.YEAR);i>=1990;i--){%>
							{ value: <%=i%>, text: '<%=i%>' },
							
							<%}%>
				        ],
				        select2: {
							'width': 100
						},
					 success: function(response, newValue) {
							gradYop = newValue;										
							}	
			    });
			    
			    $('#yearPG')
				.editable({
					type: 'select2',
					name: 'year3',
					title: 'select year of pass',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
					},
					source:[<%for(int i = Calendar.getInstance().get(Calendar.YEAR);i>=1990;i--){%>
					{ value: <%=i%>, text: '<%=i%>' },
					
					<%}%>
		        ],
		        select2: {
					'width': 100
				},
					 success: function(response, newValue) {
							pgYop = newValue;
							pgEdu_Id='<%=StringConstants.PG_EDUCATION_TYPE_ID%>';
							}
			    });
			    
			    $('#collegegrad')
				.editable({
					type: 'text',
					name: 'college1',
					title:'enter college name',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				    	}
						var regex = /^([a-zA-Z]{1})[a-zA-Z ]*$/;   
						if(!value.match(regex)) {
				            return 'enter correct name';
				        }
					},
				    success: function(response, newValue) {
						gradCol = newValue;										
						}
			    });
			    
			    $('#collegePG')
				.editable({
					type: 'text',
					name: 'college2',
					title:'enter college name',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				    	}
						var regex = /^([a-zA-Z]{1})[a-zA-Z ]*$/; 
						if(!value.match(regex)) {
				            return 'enter correct name';
				        }
					},
				    success: function(response, newValue) {
						pgCol = newValue;										
						}
			    });

			    
			    $( document ).ready(function() {
			    	
			    	$('#addNewEdu').hide();
					var new_source = getUNIV();
									
			    $('#unigrad')
				.editable({
					type: 'select2',
					name: 'uni1',
					title:'select univercity',
					source:new_source,
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
					},
					select2: {
						'width': 140
					},
					
					success:function(responce,newValue){
						gradUnivId = newValue;
					}
				
			    });
			    
			    $('#uniPG')
				.editable({
					type: 'select2',
					name: 'uni2',
					title:'select univercity',
					source:new_source,
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				        }
					},
					select2: {
						'width': 140
					},
					
					success:function(responce,newValue){
						pgUnivId = newValue;
						
					}
			    });
			    
			    
			});
			    
			    
			    
					  /* getUniv function to get univercityes from database throug ajax call  */
			    
			    var getUNIV = function(){
				    	
			    	var univList=[];
			    	
			    	var univobj={
			    			url:"<%=application.getContextPath()%>/<%=URLConstants._GET_UNIVERCITIES_ACTION_ADMIN%>",
			    			async : true,
			    			success:function(univercities){
			    				for(var i=0;i<univercities.length;i++){
			    					univList.push({id: univercities[i].univ_Id, text: univercities[i].univercity});
								
			    				}
			    					},
			    			
			    		error : function(){
					    alert("Please try later");
					    }
    		
			    	}
			    	
			    	$.ajax(univobj);
			    	return univList;
			    	
			    	}

			    
			    
			    
			    $('#ed_locationgrad')
				.editable({
					type: 'text',
					name: 'uni2',
					title:'enter location',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				    	}
						 var regex = /^([a-zA-Z]{1})[a-zA-Z0-9 ]+$/; 
							if(!value.match(regex)) {
					            return 'should start with alphabet';
					        }
					},
					    
					    success: function(response, newValue) {
							gradLocation = newValue;										
							}
			    });
			    $('#ed_locationPG')
				.editable({
					type: 'text',
					name: 'uni2',
					title:'enter location',
					validate: function (value) {
						if (value == '') {
				            return 'required field';
				    	}
						 var regex = /^([a-zA-Z]{1})[a-zA-Z0-9 ]+$/; 
							if(!value.match(regex)) {
					            return 'should start with alphabet';
					        }
					},
				    success: function(response, newValue) {
						pgLocation = newValue;										
						}
				    
					/* gradPincode */
			    });
			    $('#ed_pincodegrad')
				.editable({
					type: 'text',
					name: 'uni2',
					title:'enter pincode',
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				        var pat1=/^\d{6}$/;
				        if(!pat1.test(value)){
				        	return 'enter valid pincode';
				        }
				    	},
					    
					    success: function(response, newValue) {
					    	 gradPincode = newValue;										
							}
			    });
			    
			    $('#ed_pincodePG')
				.editable({
					
					type: 'text',
					name: 'uni2',
					title:'enter pincode',
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				        var pat1=/^\d{6}$/;
				        if(!pat1.test(value)){
				        	return 'enter valid pincode';
				        }
				    	},
					    
					    success: function(response, newValue) {
					    	 pgPincode = newValue;										
							}
			    });
			    $(document).ready(function(){
			    	
			    	
			    	var cityesOfStates =  getcity(gradStateId);
			    $('#citygrad')
				.editable({
					type: 'select2',
					name: 'uni2',
					title:'select city',
					source: cityesOfStates,
					select2: {
						'width': 140
					},
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				    	},
					success: function(response, newValue) {
						gradCityId = newValue;										
						}
					
			    });
			    
			  
			   
			    	var statesOfCountryGrad = getStates(gradCountryId);
			    $('#stategrad')
				.editable({
					
					type: 'select2',
					name: 'uni2',
					title:'select state',
					source: statesOfCountryGrad,
					select2: {
						'width': 140
					},
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				    	},
					success: function(response, newValue) {
						
						var new_source = getcity(newValue);
						
						$(".city-edit-wrappergrad").html("<span class='editable' id='citygrad'>select city</span>"); 
						 
						
						$('#citygrad')
						.editable({
							type: 'select2',
							name: 'uni2',
							title:'select city',
							source: new_source,
							select2: {
								'width': 140
							},
							validate: function (value) {
						        if (value == '') {
						            return 'required field';
						        }
							},
							 success: function(response, newValue) {
									gradCityId = newValue;										
									}
						
						});
						
						
					}
					
					
			    });
			    
			    if(PG==true){
			    var cityesOfStatesPG =  getcity(PGStateId);
			    $('#cityPG')
				.editable({
					type: 'select2',
					name: 'uni2',
					title:'select city',
					source: cityesOfStatesPG,
					select2: {
						'width': 140
					},
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				    	},
					success: function(response, newValue) {
						pgCityId = newValue;										
						}
			    });
			   
			    var statesOfCountryPG = getStates(PGCountryId);
			    $('#statePG')
				.editable({
					type: 'select2',
					name: 'uni2',
					title:'select state',
					source:  statesOfCountryPG,
					select2: {
						'width': 140
					},
					validate: function (value) {
				        if (value == '') {
				            return 'required field';
				        }
				    	},
					success: function(response, newValue) {
						
						var new_source = getcity(newValue);
						
						$(".city-edit-wrapperPG").html("<span class='editable' id='cityPG'>select city</span>"); 
						 
						
						$('#cityPG')
						.editable({
							type: 'select2',
							name: 'uni2',
							title:'select city',
							source: new_source,
							select2: {
								'width': 140
							},
							validate: function (value) {
						        if (value == '') {
						            return 'required field';
						        }
						    	},
							success: function(response, newValue) {
								pgCityId = newValue;
								
								}
						
						});
						
					}
					
			    });
			    }
			    
			    });
			    
			    
			    
			    
			    $('#countrygrad')
				.editable({
					type: 'select2',
					name: 'uni2',
					title:'select country',
					source:  gaPrimaryOptions = [
					                             <% for(Object o:countryList){
					                            	 CountryDTO country = (CountryDTO)o;
					                             %>
					                               { value: <%=country.getCountryId()%>, text: '<%=country.getCountry()%>' },
					                               
												<%}%>
												],
												 select2: {
														'width': 100
													},
													validate: function (value) {
												        if (value == '') {
												            return 'required field';
												        }
													},
												
												
												success: function(response, newValue) {
													country_id=newValue;
													var new_source = getStates(newValue);
													var state = $('#stategrad').removeAttr('id').get(0);
													$(state).remove();//remove previous instance
													$(".stae-edit-wrappergrad").html('<span class="editable" id="stategrad">Select State</span>');
													
													$('#stategrad')
													.editable({
														type: 'select2',
														name: 'uni2',
														title:'select state',
														source: new_source,
														select2: {
															'width': 140
														},
														validate: function (value) {
													        if (value == '') {
													            return 'required field';
													        }
														},
														success: function(response, newValue) {
															
															var new_source = getcity(newValue);
															
															$(".city-edit-wrappergrad").html("<span class='editable' id='citygrad'>select city</span>"); 
															 
															
															$('#citygrad')
															.editable({
																type: 'select2',
																name: 'uni2',
																title:'select city',
																source: new_source,
																select2: {
																	'width': 140
																},
																validate: function (value) {
															        if (value == '') {
															            return 'required field';
															        }
																},
																 success: function(response, newValue) {
																		gradCityId = newValue;										
																		}
															
															});
															
															
														}
													
													});
													
													$(city).remove();//remove previous instance
													
												}

			    });
			    
			    
			    
			    $('#countryPG')
				.editable({
					type: 'select2',
					name: 'uni2',
					title:'select country',
					source:  gaPrimaryOptions = [
					                             <% for(Object o:countryList){
					                            	 CountryDTO country = (CountryDTO)o;
					                             %>
					                               { value: <%=country.getCountryId()%>, text: '<%=country.getCountry()%>' },
					                               
												<%}%>
												],
												select2: {
													'width': 140
												},
												validate: function (value) {
											        if (value == '') {
											            return 'required field';
											        }
											    	},
												success: function(response, newValue) {
													
													var new_source = getStates(newValue);
													var state = $('#statePG').removeAttr('id').get(0);
													$(state).remove();//remove previous instance
													$(".stae-edit-wrapperPG").html('<span class="editable" id="statePG">Select State</span>');
													
													$('#statePG')
													.editable({
														type: 'select2',
														name: 'uni2',
														title:'select state',
														source: new_source,
														select2: {
															'width': 140
														},
														validate: function (value) {
													        if (value == '') {
													            return 'required field';
													        }
													    	},
														success: function(response, newValue) {
															
															var new_source = getcity(newValue);
															
															$(".city-edit-wrapperPG").html("<span class='editable' id='cityPG'>select city</span>"); 
															 
															
															$('#cityPG')
															.editable({
																type: 'select2',
																name: 'uni2',
																title:'select city',
																source: new_source,
																select2: {
																	'width': 140
																},
																validate: function (value) {
															        if (value == '') {
															            return 'required field';
															        }
															    	},
																success: function(response, newValue) {
																	pgCityId = newValue;
																	
																	}
															
															});
															
														}
													
													});
													
													$(city).remove();//remove previous instance
													
												}

			    });
			   

				/* 
				jqury function to show add pg details button with id addEduButton
			     */
			     $('#addEduButton').click(function(){
			    		
			    		isNewPg=true;
			    	//	alert(isNewPg);
			    		
			    		$('#addNewEdu').show();
			    		$('#addEduButton_div').hide();
			    	});
				$('#canclePG').on('click',function(){
					$('#addNewEdu').hide();
					$('#addEduButton_div').show();
					isNewPg=false;
					$('#validatemsg').html("");
				});

			    
			    

				$('#eduSaveButton').click(function(){
					
				 /* $("#btn2").removeClass();
					$("#btn3").addClass("active"); */
		    	 
		    			//alert("click event education");
		    			
		    			if(isNewPg==true&&(pgGrade==null || pgYop==null || pgStreamId==null || pgCol==null || pgUnivId==null || pgCityId==null || pgLocation==null ||pgPincode==null)){
		    				
		    				$('#validatemsg').html("<p style='color:red'>Plz fill required fields</p>");
		    				return false;
		    			}
		    			else{
		    				$("#btn2").removeClass();
							$("#btn3").addClass("active");
		    			<%-- //alert("<%=application.getContextPath()%>/UpdateStudentEducationDetailsAction"); --%>
		    			$.ajax({
						url:"<%=application.getContextPath()%>/<%=URLConstants._UPDATE_STUDENT_EDUCATION_DETAILS_ACTION_ADMIN%>",
				         data:{ "sscGrade": sscGrade,"sscYop": sscYop, "hscGrade" : hscGrade,"hscYop":hscYop,
				        	"gradGrade" :gradGrade, "gradYop" :gradYop, "gradStreamId" :gradStreamId,
				        	"gradCol" :gradCol, "gradUnivId" :gradUnivId, "gradLocation" :gradLocation,"gradPincode":gradPincode,
				        	"gradCityId":gradCityId,"pgGrade" :pgGrade, "pgYop" :pgYop, "pgStreamId" :pgStreamId,
				        	"pgCol" :pgCol,"pgUnivId" :pgUnivId, "pgLocation" :pgLocation,"pgPincode":pgPincode,"pgCityId":pgCityId,
				        	"userId":userId,"sscEdu_Id":sscEdu_Id,"hscEdu_Id":hscEdu_Id,"gradEdu_Id":gradEdu_Id,
				        	"pgEdu_Id":pgEdu_Id,"isNewPg":isNewPg},
		    			success: function(response){
		    				//alert("in success "+response);
		    				window.location.assign("#courses");
		    			}
		    					});
		    			
		    			return true;
		    			
		    			}
		    			
		    });
				
				
				
				
			    
			    
			    

			    
			    
 var getStates = function(newValue){
			    	
			    	var statesL=[];
			    	
			    	var obj={
			    			url:"<%=application.getContextPath()%>/GetStateAction",
			    			data:{"countryId":newValue},
			    			success:function(states){
			    				
			    				for(var i=0;i<states.length;i++){
								statesL.push({id: states[i].stateId, text: states[i].state});
								
			    				}
			    					},
			    			
			    		error : function(){
					    alert("Please try later");
					    }
    		
			    	}
			    	
			    	$.ajax(obj);
			    	return statesL;
			    	
			    	}
			     
			     
			     var getcity = function(newValue){
			    	 				    	
				    	var cityList=[];
				    	
				    	var cityobj={
				    			url:"<%=application.getContextPath()%>/GetCityAction",
				    			data:{"stateId":newValue},
				    			async : true,
				    			success:function(cityes){
				    				for(var i=0;i<cityes.length;i++){
				    					cityList.push({id: cityes[i].cityId, text: cityes[i].city});
									
				    				}
				    					},
				    			
				    		error : function(){
						    alert("Please try later");
						    }
	    		
				    	}
				    	
				    	$.ajax(cityobj);
				    	return cityList;
				    	
				    	}

				
				/////////////////////////////////////
				$(document).one('ajaxloadstart.page', function(e) {
					//in ajax mode, remove remaining elements before leaving page
					try {
						$('.editable').editable('destroy');
					} catch(e) {}
					$('[class*=select2]').remove();
				});
			/* }); */
			
			
			
			    $(document).ready(function(){
			    	
			    	
			    	$('#first').hide();
			    	//alert("ready function");
			    	var allcourses = getCourse();
			    	
			    	
			    	 $('#tags').editable({
					        inputclass: 'input-large',
					        title:'add or remove courses',
					        
					        select2: {
					            tags: allcourses,
					            tokenSeparators: [",", " "],
					           
					        },
					        validate: function (value) {
								if (value == '') {
						            return 'atleast one course required';
						    	}
					        },
					        success: function(response, newValue){
					        	courses=newValue;
				            	//alert("array"+courses);
				            }
					    }); 
			    	
			    });
			   
			    
			    
			    var getCourse = function(){
				    	
			    	var courseList=[];
			    	
			    	var ajaxobj={
			    			url:"<%=application.getContextPath()%>/<%=URLConstants._GET_COURSES_OF_TECHNOLOGY_ACTION_ADMIN%>",
			    			data:{"techId":techId},
			    			async : true,
			    			success:function(course){
			    				for(var i=0;i<course.length;i++){
			    				courseList.push({id: course[i].course,text: course[i].course});
								
			    				}
			    					},
			    			
			    		error : function(){
					    alert("Please try later");
					    }
    		
			    	}
			    	
			    	$.ajax(ajaxobj);
			    	return courseList;
			    	
			    	}
			    
			    
			    
			    

				$('#saveConfirm').click(function(){
	    			
	    			//$('#wait').show();
	    			 $("#first").show();
	    		
   					 

	    			$.ajax({
					url:"<%=application.getContextPath()%>/<%=URLConstants._UPDATE_STUDENT_COURSES_ACTION_ADMIN%>",
					
			         data:{"courses" :courses,"userId" :userId, "email" : email , "mobile_no" : mobile_no},
			         success:function(response){
			        	 $('#first').hide();
			        	
			        	// alert("ajax success function "+response);
			        	 if(response==true){
			        	 window.location.assign("<%=URLConstants._VERIFICATION_SUCCESS_MSG_JSP_ADMIN%>");
			        	 }else{
			        		 window.location.assign("<%=URLConstants._ERROR_MSG_JSP_ADMIN%>");
			        	 }
			        	
			         },
			        error:function(response){
			        	 window.location.assign("<%=URLConstants._ERROR_MSG_JSP_ADMIN%>");
			         }
	    					});
	    			
	    			
	    			
	    });
				
			});
			    
			    
		</script>


	<%} %>



<style type="text/css">
#first
{
    
    position:absolute;
    bottom:0;
    left:0;
    right:0;
    top:0;  
    opacity:0.5;
    background-color:#000;
    color:#fff;
    z-index:9999;
}

.load
{
    height:100%;
    width:100%;
    background-image:url('http://images2.layoutsparks.com/1/235919/walle-galaxy-sky-image.jpg');
} 
    .sui-button-cell
    {
        text-align: center;
    }

    .sui-checkbox
    {
        font-size: 17px !important;
        padding-bottom: 4px !important;
    }

    .deleteButton img
    {
        margin-right: 3px;
        vertical-align: bottom;
    }

    .bigicon
    {
        color: #5CB85C;
        font-size: 20px;
    }
</style>

		</body>
		
	</html>