<!--
     @author  PRAVEEN GUGGILLA  Batch 35 
-->
 <%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@page errorPage="error.jsp" %>
<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<%@page import="com.nacre.online_assesment.form_bean.StudentCoursesBean"%>
<%@page import="com.nacre.online_assesment.form_bean.StudentEducationBean"%>
<%@page import="com.nacre.online_assesment.form_bean.PersonalDetailsBean"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.online_assesment.dao_i.StudentDetailsUpdationDaoi"%>
<%@page import="com.nacre.online_assesment.dto.CountryDTO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
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

		<title>Home - Student</title>
			
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
    
		<!-- page specific plugin styles -->
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/jquery-ui.custom.min.css" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/jquery.gritter.min.css" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/select2.min.css" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/datepicker.min.css" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/bootstrap-editable.min.css" />
		<!-- text fonts -->
	<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/fonts/fonts.googleapis.com.css" />
</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/student_menu.jsp"></jsp:include>
<div class="main-content">
				<div class="main-content-inner">

					<div class="page-content">
					
				
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Edit Profile</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
						
								
<!-- write your code here -->
 
 <div class='row' id='msg-wrapper'>
  </div>

<div class='row' ></div>
		<div class=row>
   <!-- retrieving student profile from action it has personal details and educational details -->
    
 <% RequestDispatcher rdis=request.getRequestDispatcher("/"+URLConstants.PERSONAL_DETAILS_ACTION);
 
            rdis.include(request,response);
 
            List studentDetails = (List)request.getAttribute("studentDetails");
            
            PersonalDetailsBean personalDetails=null;
            List stuEduList=null;
            List coursesList=null;
            
     try{   
            if(studentDetails!=null){
	  
            personalDetails = (PersonalDetailsBean)studentDetails.get(0);
 
            stuEduList = (List)studentDetails.get(1);
 
            coursesList =(List)studentDetails.get(2);
            }
            
        } catch(NullPointerException e){
        	response.sendRedirect(request.getContextPath()+"/jsp/student/student_home.jsp");
         }
     
         catch(Exception e){
        	
 		    response.sendRedirect(request.getContextPath()+"/jsp/student/student_home.jsp");
         }
            StudentEducationBean eduDetails=null;

            int gradYop=0;
            
            //retrieving current year
            Calendar now = Calendar.getInstance();
            int currentYear = now.get(Calendar.YEAR);
            String yearInString = String.valueOf(currentYear);
 %>
			<!--#INCLUDE VIRTUAL="TopNavInclude.asp" -->
			<div class="row">
				<div class="col-md-12"> 
						
					<div class="panel panel-default panel-fade">
					
						<div class="panel-heading">
					   
					   
							<span class="panel-title">
								<div class="pull-left">
								
								<ul class="nav nav-tabs">
									<li class="active" id="btn1"><a href="#personal" data-toggle="tab"><i class="glyphicon glyphicon-user"></i> Personal Profile</a></li>
									 <li id="btn2"><a href="#education" data-toggle="tab"><i class="glyphicon glyphicon-list-alt"></i> Education Details</a></li>
  								</ul>
									
								</div>
								<div class="clearfix"></div>

							</span>
							
						</div>
						
						 <div class="panel-body text-center">
							<div class="tab-content">
						            <div class="tab-pane fade in active" id="personal">
						            
								<i class="ace-icon fa fa-edit bigger-140 pull-left" style="color:#333CFF"> Click on the profile fields to add/edit them</i>
								
									<h3>Personal Details</h3>

    <!-- ====these labels are used for displaying  success message  or error message regarding post.graduation details===  -->
              
              <%String successmsg = request.getParameter("successmsg");
                        if(successmsg!=null){
               %>
              <div class='successmsg' id="scss" style="color:#64FE2E"><h4><%=successmsg%></h4></div>
              <%} %>
              
              <%String msg2 = request.getParameter("errormsg");
              if(msg2!=null){
              %>
              <div class='errmsg' id="err" style="color:red"><h4><%=msg2%></h4></div>
             <%} %>
             
		<!-- ================starting of personal details form================ -->
							
  <FORM method="get" name="form" id="form" >
								 
								 <div class="page-content">
						              <div class="row">
								         <div>
								
	<div id="user-profile-1" class="user-profile row">
		
		<div class="col-xs-12 col-sm-3 center">
		 
		<div class="space-12"></div>
				
			<div>
				<span class="profile-picture">
					<img width="206px" height="100px" class="img-thumbnail" alt="profile photo" src="<%=personalDetails.getImage() %>" />
			</span>
			<div class="space-4"></div>
	                     
			<div class="width-auto label label-info label-xlg owed-in owed-in-right">
			<div class="inline position-relative">
				<a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
					<i class="ace-icon fa fa-circle light-green"></i>
					&nbsp;
					<span class="white"><%=personalDetails.getFname()%></span>
				</a>

			</div>
			</div>
			</div>	
		
		</div>
	
		<div class="col-xs-12 col-sm-8">
			<div class="space-12"></div>
			
    <!--for displaying the success message and hiding the message after 10 seconds -->            
              <script type="text/javascript">
				window.setInterval(function() {
				    $('#scss').hide();
				}, 10000);
				//this code is used for changingthe url
				var stateObject = {};
				var title = "Redirecting";
				var  newUrl = "./EditProfile.jsp";
				history.pushState(stateObject,title,newUrl);
				 </script>
				 
    <!--for displaying the error message and hiding the message after 10 seconds -->            
			<script type="text/javascript">
				window.setInterval(function() {
				    $('#err').hide();
				}, 10000);
				
				//this code is used for changingthe url
				 var stateObject = {};
				var title = "Redirecting";
				var  newUrl = "./EditProfile.jsp";
				history.pushState(stateObject,title,newUrl); 
				
				</script>
                 
				<div class="profile-user-info profile-user-info-striped">
					<div class="profile-info-row">
						<div class="profile-info-name"> Firstname </div>

						<div class="profile-info-value">
 							<span class="editable" id="firstname"><%=personalDetails.getFname()%></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> Lastname </div>

						<div class="profile-info-value">
							<span class="editable" id="lastname"><%=personalDetails.getLname()%></span>
						</div>
					</div>
					 <div class="profile-info-row">
						<div class="profile-info-name"> Email </div>
					
						<div class="profile-info-value">
							<span id="email"><%=personalDetails.getMail()%></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">Mobile No.</div>
					
						<div class="profile-info-value">
							<span class="editable" id="mobile_no" data-title="Enter mobile no"><%=personalDetails.getMobile()%></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> Gender </div>
					
						<div class="profile-info-value">
							<span class="editable"><%=personalDetails.getGender()%></span>
						</div>
					</div>
					
				<div class="profile-info-row">
					<div class="profile-info-name"> Date of Birth </div>

					<div class="profile-info-value">
						<span id="dob"><%=personalDetails.getDob()%></span>
						<div class="space-6"></div><div class="space-6"></div>
					</div>
				</div>
				
				<div class="profile-info-row">
					<div class="profile-info-name"> Address </div>

					<div class="profile-info-value">
						<i class="fa fa-map-marker light-orange bigger-110"></i>
						<span class="editable" id="country" data-title="select country"><%=personalDetails.getCountry()%></span>
						<span class="editable" id="state" data-title="select state"><%=personalDetails.getState()%></span>   ,  
						<lable id='cty-wrapper'>
						<span class="editable" id="city" data-title="select city"><%=personalDetails.getCity()%></span>
						</lable>  ,     
						   <span class="editable" id="location" data-title="Enter location"><%=personalDetails.getLocation()%></span>
						
						<span class="editable" id="pincode" data-title="Enter pincode"><%=personalDetails.getPincode()%></span>
						<div class="space-6"></div>
					</div>
				</div>
				
				<div class="profile-info-row">
						<div class="profile-info-name"> Technology </div>
						
								<span id="tech"><%=personalDetails.getTechnology()%></span><div class="space-6"></div>
				</div>
			
				<div class="profile-info-row">
						<div class="profile-info-name"> Courses </div>
					      <div class="profile-info-value">
		<a href="#" id="tags" data-type="select2" data-pk="1" data-title="Enter courses" class="editable editable-click" data-original-title="" title="" style="background-color: rgba(0, 0, 0, 0);">
						
						<% //for(Object obj:coursesList)
						for(int l=0;l<coursesList.size();l++){
				
				        StudentCoursesBean scb=(StudentCoursesBean)coursesList.get(l);
				       %>
						   <%=scb.getCourses()%><%= l+ 1 < coursesList.size() ? ",":"" %>	
						   
					<% } %>		
					</a>
					</div>   
			</div>
				
	   </div>
		<div class="space-20"></div>
		 <div class="center">
			<button type="button" class="bigger-110 width-35 btn btn-sm btn-primary" name="submit" value="save" id="button"><b>Save</b></button>
	   
	    <span  style='padding:10px'></span>
	    
	    <a href="#education" class="active" data-toggle="tab">
			<button type="button" class="bigger-110 width-35 btn btn-sm btn-primary ">
				<span class="bigger-110" style="font-size:10px" id='next'>Next</span>
				<i class="icon-on-right ace-icon fa fa-arrow-right"></i>
			</button></a>
			
		</div> 
	     
	  </div>
   </div>
  </div>
 </div>
</div>

				   </FORM>
				   
			<!-- ending personal details form -->
		         
		          </div>
		          
		 <!-- educational details form -->
													
				<div class="tab-pane fade" id="education">
				<h3>Education Details</h3>								 
 <FORM ACTION="#" METHOD="post">
			<div class="page-content">
				<div class="row">
					<div >
	                 <div id="user-profile-1" class="user-profile row">
		               <div class="col-xs-12 col-sm-9">
		
		<!-- retrieving educational details----- -->
		
		 <%
		 
		     boolean PG=false;

		     for(Object obj:stuEduList){
			
			    //StudentEducationBean 
			    eduDetails = (StudentEducationBean)obj;
			
			/** the following code is used to seperate ssc,intermedaite details to get only stream and year of passout */
			
			
			if(eduDetails.getEdu_type().equals(StringConstants.EDUCATION_TYPE_PG)){
				PG=true;
			}
  
	//check  this field =======================
			
			if(eduDetails.getEdu_type().equals(StringConstants.EDUCATION_TYPE_DEGREE)){
				
				gradYop=eduDetails.getYear_of_pass().getYear()+1900;
			}
			
			  if(eduDetails.getEdu_type().equals(StringConstants.EDUCATION_TYPE_SSC) || eduDetails.getEdu_type().equals(StringConstants.EDUCATION_TYPE_INTER)){
			
			%>
			
			<!-- displyas only stream and year of passed outs  -->
			
			<div class="profile-user-info profile-user-info-striped">	
				<span style="font-size:17px; color:#6688a6"><%=eduDetails.getEdu_type()%>_Details</span>
					<div class="profile-info-row">
						<div class="profile-info-name"> Percentage/Grade </div>

						<div class="profile-info-value">
							<span class="editable"><%=eduDetails.getPercent_grade()%></span>
						</div>
					</div>
					 <div class="profile-info-row">
						<div class="profile-info-name"> Year Of Passout </div>
					
						<div class="profile-info-value">
							<span class="editable"><%=eduDetails.getYear_of_pass().getYear()+1900%></span>
						</div>
					</div>
				<% } else{ %>
				
				<!-- displyas all the details of graduation and post-garduation  -->
				
				<div class="profile-user-info profile-user-info-striped">
				
				<span style="font-size:17px; color:#6688a6"><%=eduDetails.getEdu_type()%>_Details</span>
					
					<div class="profile-info-row">
						<div class="profile-info-name"> College Name </div>
					
						<div class="profile-info-value">
							<span class="editable"><%=eduDetails.getCollege()%></span>
						</div>
					</div>
					
					<div class="profile-info-row">
						<div class="profile-info-name"> University </div>
					
						<div class="profile-info-value">
							<span class="editable"><%=eduDetails.getUnivercity()%></span>
						</div>
					</div>
					
					<div class="profile-info-row">
						<div class="profile-info-name"> Stream </div>    
					
						<div class="profile-info-value">
							<span class="editable"><%=eduDetails.getStream()%></span>
						</div>
					</div>
					
					 <div class="profile-info-row">
						<div class="profile-info-name"> Year Of Passout </div>
					
						<div class="profile-info-value">
							<span class="editable"><%=eduDetails.getYear_of_pass().getYear()+1900 %></span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> Percentage/Grade </div>

						<div class="profile-info-value">
							<span class="editable"><%=eduDetails.getPercent_grade()%></span>
						</div>
					</div>
					
				<div class="profile-info-row">
					<div class="profile-info-name"> Address </div>

					<div class="profile-info-value">
						<i class="fa fa-map-marker light-orange bigger-110"></i>
						<span class="editable" id="location"><%=eduDetails.getLocation()%></span>
						<span class="editable" id="city"><%=eduDetails.getCity()%></span>
						<span class="editable" id="state"><%=eduDetails.getState()%></span>
						<span class="editable" id="country"><%=eduDetails.getCountry()%></span>
					</div>
				</div>
				<% } %>
		</div>
		<%} %>
		    
		
		<!-- checking condition whether the student is eligible for post graduation -->
		   
		         <%if((!PG)&&(gradYop+2)<=currentYear){ %>
	         <button type="button" class="bigger-5 width-30 btn btn-sm btn-primary" data-toggle="modal" data-target="#post"><b>Add Post Graduation</b></button>
	             <%} %>
	 </div>
</div>
</div>
</div>
</div>
</div>
								 
						<!-- ----------==============button for adding post grad details============--------- -->
									
					 </FORM>
					 
					 <!-- ---------=============end of main form================----------- -->
								</div>
				          </div>
					
					<!-- =============end of educational details form=============== -->
						
			        </div>
			        
				<!--  ==============post graduation details form=============== -->	
						 							
<div id="post" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
                     <h1>
					<i class="ace-icon fa fa-user"> <span style='color:#333CFF'><b>post graduation details</b>
		                   </span></i>
					</h1>
       </div> 
      <div class="modal-body">

<div class="container">

	<form action="<%=application.getContextPath()%>/<%=URLConstants.UPDATE_STUDENT_POST_GRADUATION_DETAILS_ACTION %>" id="pgform"  method="post" >
		
		<div class="form-group">
				<h5><b>Note</b>:<span style="color:red">*</span>means required fields</h5>
			</div>
			<br><br>
		<div class="form-group">
				<label class="control-label col-sm-2"><b>University</b>: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<select id="univpg" name="univpg" class="required">
	            <option value='0'>-----------------Select University--------------</option>
	          </select><p style="color: red;" id="uni"> </p>
				</div><br>
			</div><div class="space-6"></div>
			<br>
			
         <div class="form-group">
				<label class="control-label col-sm-2" name="collegepg" ><b>College Name</b>: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<input type="fname" name="collegepg" class="form-control" 
						placeholder="Enter college Name" id="collegepg"><p style="color: red;" id="col"></p>
				</div>
			</div><div class="space-6"></div>
	<br><br><br>
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="fname" class="required"><b>Stream</b>: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<select id="stream" name="streampg">
	                          <option value='0'>-------------------Select Stream----------------</option>
	          </select><p style="color: red;" id="strem"> </p>
				</div>
			</div><div class="space-6"></div>
			<br><br>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="fname" id="yoppg" class="required"><b>Year of passedout</b>: <span style="color:red;font-weight:bold">*</span></label>
 				<div class="col-sm-3">
 					
					<select name="yoppg">
                              <option value="" disabled="disabled">---------Select Year of Passedout----------</option>
                                    
                                    <%  for(int i=gradYop+2;i<=currentYear;i++){%>
                                    
	                                <option id="yop" ><%=i%></option><%}%>
	                   </select><br>
 				</div><br>
 			</div>
 <br>
       <div class="form-group">
				<label class="control-label col-sm-2" for="mno"><b>Percentage</b>: <span style="color:red;font-weight:bold">*(must betwen 35-100 or A-E)</span></label>
				<div class="col-sm-3">
					<input type="mno" name="percentagepg" class="form-control" id="percentagepg"
						placeholder="e.g. 65.50 or A">
						<p style="color: red;" id="per"></p>
				</div>
			</div>
   			<br>
   			<br>
   			<br>
			<% RequestDispatcher rd3=request.getRequestDispatcher("/"+URLConstants.GET_COUNTRY_DETAILS_ACTION);
	         rd3.include(request,response);
	         List<CountryDTO> list=(List<CountryDTO>)request.getAttribute("countryList");
	        %>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="mno"><b>Country</b>: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<select id="countrypg" name="countryId" class="required">
	                        <option value="0">-------------------Select Country---------------</option>
	            <% for(CountryDTO d:list){%>
	           <option value="<%=d.getCountryId()%>"><%=d.getCountry() %></option><%}%>
	           
	          </select><p style="color: red;" id="cnt"> </p>          
				</div><br>
			</div>
			<br>
			<br>
			<div class="form-group">
				<label class="control-label col-sm-2" for="mno"><b>State</b>: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<select id="statepg" name="statepg" class="required">
	            <option value='0'>---------------------Select  State-----------------</option>
	          </select><p id="st" style="color:red"></p>
				</div><br>
			</div>
			<br><br>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="mno"><b>City</b>: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<select id="citypg" name="citypg">
	            <option value='0' id="citypg">----------------------Select City------------------</option>
	          </select><p id="ct" style="color:red"></p>
				</div><br>
			</div>
			<br><br>
			<div class="form-group">
				<label class="control-label col-sm-2" for="mno"><b>Location</b>: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<input type="text" name="locationpg" class="form-control" id="locationpg"
						placeholder="e.g. Ameerpet">
						<p style="color: red;" id="msg"> </p>
				</div><br>
			</div> 
			<div class="space-6"></div><br>
			
			<div class="space-6"></div><br>
			
			<div class='row'>

			<div class='col-md-4'>		
					
			  <button type="reset" class="width-10 pull-left btn btn-md-4 btn-primary"  style="float:left;">
								<i class="ace-icon fa fa-refresh pull-right"></i> <span
															class="bigger-30"><b>Reset</b></span>
													 </button>			
									
									</div>
									
			<div class='col-md-4'>	
						
							<span  style='padding:10px'></span>
	                                        
				<button type="submit"class="width-45 pull-left btn btn-md-2 btn-primary"  style="float:right;" id="btn">
							<i class="ace-icon  pull-right"></i> 
								<span class="bigger-50"><b>Submit</b></span>
													 </button>
													  
				</div>	</div>	 <!--  </div> -->
		</form><!-- end of p.g details action--- -->
	   
	    </div>
      </div>
      
    </div>

  </div>
</div> 

<!--  -------------for post.grad form------------------ -->
                              </div>
						  </div> 
					</div>
 				</div>
   </div>

<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>

<script type="text/javascript" src="${path}/assets/js/gajananNotificationsJobpost.js"></script>
				

		<!-- page specific plugin scripts -->

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

		
		
	<!-- inline scripts related to this page -->
	
<script type="text/javascript">
		
		
			jQuery(function($) {
			
				//editables on first profile page
				$.fn.editable.defaults.mode = 'Popup';
				$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
			    $.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>'+
			                                '<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>';    
				
			                               
			         //===================  retrieving universities =============
			     
 			             
			        	 $(document).ready(function(){
			        	
			    	  	var newCourses = getCourses();
			        	 	 $('#tags').editable({
			        	 		 inputclass: 'input-large',
			        	 	   select2: {
			                 tags: newCourses,
			                        },
			                        validate: function(value) {
			    						
			   						 if($.trim(value) == '') {
			   					         return 'This field is required';
			   					        }
			                        },
			        
			        success: function(response, newValue){
		            	courses=newValue;
		            	//alert("courses=="+courses);
		          	   
		            	$.ajax({	 
							  method:"POST",
							 
							  url:"<%=application.getContextPath()%>/<%=URLConstants.UPDATE_STUDENT_COURSES_ACTION %>",
				    		 
							  data:{"courses":courses},
						   });
		            	
		                 }
			          });
			      });
			         
			        	 	  var getCourses = function(){
			   			    	
			   			    	var coursesL=[];
			   			    	
			   			  	var obj={
		   			    			url:"<%=application.getContextPath()%>/<%=URLConstants.GET_COURSES_ACTION %>",
		   			    			//data:{"userId":newValue},
		   			    			success:function(course){
		   			    				//alert("responce "+course);
		   			    				for(var i=0;i<course.length;i++){
		   			    					coursesL.push({id: course[i].course, text: course[i].course});
		   								
		   			    				}
		   			    					},
		   			    			
		   			    		error : function(){
		   					    alert("Please try later");
		   					    }
		   			    	}
			   			    	$.ajax(obj);
			   			    	return coursesL;
			   			    	}; 
		
	      $('document').ready(function(){
	    	  
	    	  
		  var obj={
					url:"<%=application.getContextPath() %>/<%=URLConstants.GET_UNIVERSITIES_ACTION%>",
			
			success:function(univpg){
				$("#univpg").append();
			
				for (var ind = 0; ind < univpg.length; ind++) {
					$("#univpg").append("<option value='"+univpg[ind].universityId+"'>"+univpg[ind].universityName+"</option>");
				}
				 
				//alert(univpg);
			},
			error:function(){
				alert("please try later form universities..");
				
			}
			};
				
				$.ajax(obj); 
			});
	// retrieving streams
	  $('document').ready(function(){
		var obj={
			url:"<%=application.getContextPath()%>/<%=URLConstants.GET_STREAM_ACTION%>",
			
			success:function(stream){
				$("#stream").append();
		    	var out=$("#stream").val();

				//alert("streams from jsp===="+out);
				  
				for (var ind = 0; ind < stream.length; ind++) {
					$("#stream").append("<option value='"+stream[ind].streamId+"'>"+stream[ind].stream+"</option>");
				}
				
			},
			error:function(){
				alert("please try later from streamsss");
			}
			};
				
				$.ajax(obj);
			});
	
	
	
			  //retrieving states by using country id for post grad form--
			$( function() {
			    $( "#countrypg").change(function(){
			    	var out=$(this).val();
			    	var da ={"countryId":out};
			    	//alert("from states alert"+da);
			    	var obj ={
			    			url:"<%=application.getContextPath()%>/<%=URLConstants.GET_STATE_ACTION%>",
			    			success:function(resData){
			    				//alert("states form jsp==="+resData);
			    				$("#statepg").empty();
								$("#statepg").append("<option value='0'>---------------------Select State-----------------</option>");
								
								if(resData.length<=0){
								$("#statepg").append("<option value=''>----------------States are not available----------</option>");

				    				}
								
								for ( var ind = 0; ind < resData.length; ind++) {
			    					$("#statepg").append("<option value='"+resData[ind].stateId+"'>"+resData[ind].state+"</option>");
								}
			    			},
			    			error:function(){
			    				alert("states are not available");
			    			},
			    			data:da
			    	};
			    	
			    	$.ajax(obj);
			    });
			  });
			  
			 //retrieving cities by using state id 
			  
			$( function() {
			    $( "#statepg").change(function(){
			    	var out=$(this).val();
			    	var da ={"stateId":out};
			    	//alert("from city alert"+da);
			    	var obj ={
			    			url:"<%=application.getContextPath()%>/<%=URLConstants.GET_CITY_ACTION%>",
			    			success:function(resData){
			    				
			    				$("#citypg").empty();
								$("#citypg").append("<option value='0'>----------------------Select City------------------</option>");

			    				if(resData.length<=0){
								$("#citypg").append("<option value=''>-----------------Cities are not available----------</option>");

			    				}
			    				for ( var ind = 0; ind < resData.length; ind++) {
			    					$("#citypg").append("<option value='"+resData[ind].cityId+"'>"+resData[ind].city+"</option>");
								}
			    			},
			    			error:function(){
			    			},
			    		data:da
			    	 };
			    	$.ajax(obj);
			    });
			  });
	  
	  
		// end of ajax call for post grad form===================	     
	  
	  
           //declaring global variable===============	                                
			                               
			                        		var mobileno='<%=personalDetails.getMobile()%>';
			                        		var location='<%=personalDetails.getLocation()%>';
			                        		var technology='<%=personalDetails.getTechnology()%>';
			                        		var pincode='<%=personalDetails.getPincode()%>';
			                        		var cityid='<%=personalDetails.getCityId()%>';
			                        		var email='<%=personalDetails.getMail()%>';
			                        		var countryId='<%=personalDetails.getCountryId()%>';
			                        		var stateId='<%=personalDetails.getStateId()%>';
			                        		
				
				//================text editable first form====================
			    
		//alert("before changing city id=="+cityid);
				
				$('#email')
				.editable({ 
					type: 'text',
					email:true,
					required:true,
					name: 'email',
					title:'Enter emailId',
					validate: function (value) {
						 if (value == '') {
				            return 'required field';
				    	} 
				        var emailReg = new RegExp(/^[a-zA-Z]([\w-\.]+)@((?:[\w]+\.)+)([a-zA-Z]{2,4})/i);
				        var valid = emailReg.test(value);
				    	if(!valid) {
				            return 'Enter the valid email';
				        }
				    },
					success: function(response, newValue) {
					email = newValue;										
					
				}
			    });
			    
			    $('#mobile_no')
				.editable({
					type: 'number',
					name: 'mobile_no',
						validate: function(value) {
				            if ($.isNumeric(value) == '') {
				                return 'Only numbers are allowed';
				            }
				            var regexp = new RegExp("^[7-9][0-9]{9}$");
                              if (!regexp.test(value)) {
                            return 'This field is not valid';
                           }
						},
						success: function(response, newValue) {
							mobileno = newValue;
					    }
			    });
			    
				
				//     --------------ajax call to get country,state,city----------------
			
			    $('#location')
				.editable({
					type: 'text',
					name: 'location',
					validate: function(value) {
				        if($.trim(value) == '') {
				         return 'This field is required';
				        }
				        if($.isNumeric(value)) {
					         return 'numerics are not allowed';
					      }
				         var regexp = new RegExp("^[a-zA-Z^0-9]+(?:(?:\\s+|-|.)[a-zA-Z]+)*$");
                              if (!regexp.test(value)) {
                            return 'This field is not valid';
                           }
					},
				
					success: function(response, newValue) {
					location = newValue;
			    }
					
			    });
				
				
	//now--------------------------------------			
				
  $(document).ready(function(){
	  
	  //alert("stateId=="+stateId);
	  
			  var cityesOfStates =  getcity(stateId);
			    $('#city')
				.editable({
					type: 'select2',
					name: 'uni2',
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
						cityid = newValue;										
						},
						
						error : function(){
						    alert("not available");
						    }
					
			    });
			   
			  var statesOfCountry = getStates(countryId);
			// alert("countryId=="+countryId);
			    $('#state')
				.editable({
					
					type: 'select2',
					name: 'uni2',
					source: statesOfCountry,
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
						//alert(newValue);
						$("#cty-wrapper").html("<span class='editable' id='city'>select city</span>"); 
						 
						
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
									cityid = newValue;										
									}
						
						});
					},
					
					error : function(){
					    alert("not available");
					    }
			    });
			  });
				
		//-----------------------------------		
				
			    $('#country')
				.editable({
					type: 'select2',
					name: 'countr',
					source:  gaPrimaryOptions = [
                                   <% for(Object o:list){
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
				
						 var city = $('#city').removeAttr('id').get(0);
						$(city).remove();
						 
						var state = $('#state').removeAttr('id').get(0);
						$(state).clone().attr('id', 'state').text('Select state').editable({
							type: 'select2',
							value : null,
							//onblur:'ignore',
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
	
								var city = $('#city').removeAttr('id').get(0);
								$(city).remove();//remove previous instance
								$("#cty-wrapper").html("<span id='city' class='editable'>select city</span>");
										
                        		 $('#city').editable({
	                              	
                        			type: 'select2',
									value : null,
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
										cityid = newValue;
								    },
								    error : function(){
									    alert("Please try later");
									    },
    								 
								 });
							}
							
						}).insertAfter(state);//insert it after previous instance
						$(state).remove();//remove previous instance
					}
			    });
			    
			     var getStates = function(newValue){
			    	
			    	var statesL=[];
			    	
			    	var obj={
			    			url:"<%= application.getContextPath()%>/<%=URLConstants.GET_STATE_ACTION%>",
			    			data:{"countryId":newValue},

							validate: function (value) {
						        if (value == '') {
						            return 'required field';
						        }
							},
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
			    	 //alert("inside function"+newValue);
				    	
				    	var cityList=[];
				    	
				    	var cityobj={
				    			url:"<%=application.getContextPath()%>/<%=URLConstants.GET_CITY_ACTION%>",
				    			data:{"stateId":newValue},
				    			async : true,

								validate: function (value) {
							        if (value == '') {
							            return 'required field';
							        }
								},
				    			success:function(cityes){
				    				//alert(cityes);
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
			     
				$('#pincode')
				.editable({
					type: 'text',
					name: 'pincode',
					 validate: function(value) {
						
						 if($.trim(value) == '') {
					         return 'This field is required';
					        }
			            if (!$.isNumeric(value)) {
			                return 'only numeric values are allowed';
			            }
			            var regexp = new RegExp("^[1-9][0-9]{5}$");
                          if (!regexp.test(value)) {
                        return 'pincode is not valid';
                       }
					},
				
					success: function(response, newValue) {
						pincode = newValue;
				    }
			    });
				
				
				// -------------- ajax call for sending details of student ----------------
				
				 $('#button').click(function(){
					 
					// var img=$("#avatar").attr("src");
					 
					 //alert(location+" "+pincode+" "+technology+" "+"after changing city id =="+cityid);
					// alert(img);
					 
					 $.ajax({	
						
						 url:"<%=application.getContextPath()%>/<%=URLConstants.UPDATE_STUDENT_DETAILS_ACTION%>",
						
						 type:"POST",
			    		 
						 data:{"mobileno":mobileno,"location":location,"pincode":pincode,"technology":technology,"cityid":cityid,"email":email},
						 
						    success:function(data){
							   // alert("success : "+data.successMsg);
							    if(data.successMsg!=undefined){
							    	
							    	
							    	$("#msg-wrapper").html('<div class="alert alert-success">'+
							    			'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
						        		   ' <strong>Success!</strong> '+data.successMsg+
							        		'  </div>');
							    	 
							    	
							    }else if (data.fMsg!=undefined){
							    	$("#msg-wrapper").html('<div class="alert alert-danger">'+
							    			'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
						        		   ' <strong>Success!</strong> '+data.fMsg+
							        		'  </div>');
							    	 
							    	
							    }else{
							    	
							    	  window.location.assign("<%=application.getContextPath()%>/<%=URLConstants.EDIT_PROFILE%>?errormsg=<h4 style='color:red'>sorry, please re-enter your data</h4>");
									     	
							    }
							  }, 
						   
						   error : function(){
							    alert("not updated ");
							    }
					 });
					 
				 });
				
			    // *** editable avatar *** //
			    
				try {//ie8 throws some harmless exceptions, so let's catch'em
			
					//first let's add a fake appendChild method for Image element for browsers that have a problem with this
					//because editable plugin calls appendChild, and it causes errors on IE at unpredicted points
					try {
						document.createElement('IMG').appendChild(document.createElement('B'));
					} catch(e) {
						Image.prototype.appendChild = function(el){}
					}
			
					var last_gritter=null;
					$('#avatar').editable({
						type: 'image',
						name: 'avatar',
						value: null,
						image: {
							//specify ace file input plugin's options here
							btn_choose: 'Change pic',
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
								} else if(error_type == 2) {//file size error
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
			
							var deferred = new $.Deferred;
			
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
									title: 'Updated!',
									text: 'Uploading Successfully.',
									class_name: 'gritter-info gritter-center'
								});
								
							 } , parseInt(Math.random() * 800 + 800))
			
							return deferred.promise();
							
							// ***END OF UPDATE AVATAR HERE*** //
						},
						
						success: function(response, newValue) {
						}
					});
				}catch(e) {}
				
				
				$('[data-toggle="buttons"] .btn').on('click', function(e){
					var target = $(this).find('input[type=radio]');
					var which = parseInt(target.val());
					$('.user-profile').parent().addClass('hide');
					$('#user-profile-'+which).parent().removeClass('hide');
				});
				
				$(document).one('ajaxloadstart.page', function(e) {
					//in ajax mode, remove remaining elements before leaving page
					try {
						$('.editable').editable('destroy');
					} catch(e) {}
					$('[class*=select2]').remove();
				});
			});
			
			
		// ------------------validations for post gradustion form-------------------	
			
$(document).ready(function () {
	
	
	$("#post").on('hidden.bs.modal',function(){
		
		$(this).find('form')[0].reset();
	});
	
	  $("#btn").click(function () {
		  //alert("submit click");
		  
		  var loc=$("#locationpg").val();
		  var perc =  $("#percentagepg").val();
		  var college = $('#collegepg').val();

		  
		  var country = $('#countrypg').val();
		  var states=$('#statepg').val();
		  var city = $('#citypg').val();
		  
		  var stream=$('#stream').val();
		  var univ=$('#univpg').val();

		 
		  var regexpLoc = new RegExp('^[a-zA-Z^0-9]+(?:(?:\\s+|-|.)[a-zA-Z]+)*(.)*$');

		  var p=new RegExp('^[0-9a-eA-E]+(?:\\.\\d{0,2})?$');
		  
		  var clikedForm = $(this); // Select Form
		  
		     // validatin stream----------
		   if (univ == '0') {
	          error = 1;
	          document.getElementById("uni").innerHTML="select university";
		      return false;
	      }else{
		        document.getElementById("uni").innerHTML="";
		        
		  }
		    
		 //--------validating college---------------
	      
		 if (college==''){
	        document.getElementById("col").innerHTML="please fill this field";
	        return false;
	        
	      }  else if(!regexpLoc.test(college)){
		        document.getElementById("col").innerHTML="please check this field";
		        return false;
		        
		  }else if($.isNumeric(college)){
		        document.getElementById("col").innerHTML="numbers are not allowed";
		        return false;
		  }else{
		        document.getElementById("col").innerHTML=" ";

		  } 
		  
		 // validatin stream----------
		   if (stream == '0') {
	          error = 1;
	          document.getElementById("strem").innerHTML="select stream";
		      return false;
	      }else{
		        document.getElementById("strem").innerHTML="";
		        
		  }
		 
		     
		     //--------validating percentage---------------
	       
	           if (perc== ''){
	        	   document.getElementById("per").innerHTML="percentage cannot be empty";
	        	   return false;
	           }
	        	   
	           else if(!p.test(perc)){
	        	   document.getElementById("per").innerHTML="please enter numbers or A-E";
	               return false;
	        	   }
	        	   
	           else if(perc<35 || perc>100){
		        	   document.getElementById("per").innerHTML="percentage must between 35-100 or A-E";
		        	   return false;
	           }else{
			        document.getElementById("per").innerHTML="";
			        
	 		  } 

			     
		  	     //--------validating select boxes---------------
	  	  	 
	  	  	 if (country == '0') {
	            error = 1;
	            document.getElementById("cnt").innerHTML="select country";
	  	        return false;
	           }else{
	  		        document.getElementById("cnt").innerHTML="";
	  		  } 
	  	  	if (states == '0') {
	            error = 1;
	            document.getElementById("st").innerHTML="select state";
	  	        return false;
	           }else{
	  		        document.getElementById("st").innerHTML="";
	  		  }
		  	     
	  	  	  if (city == '0') {
	  	          error = 1;
	  	          document.getElementById("ct").innerHTML="select city";
	  		        return false;
	  	      }else{
	  		        document.getElementById("ct").innerHTML="";
	  		  }
		  
	     //--------validating location---------------
	       
	     if (loc == ''){
	        document.getElementById("msg").innerHTML="please fill this field";
	                return false;
	       }
	        else if((!regexpLoc.test(loc))){
		        document.getElementById("msg").innerHTML="please check this field";
		        return false;
		  }
	        else if($.isNumeric(loc)){
		        document.getElementById("msg").innerHTML="numbers are not allowed";
		        return false;
		  }else{
		        document.getElementById("msg").innerHTML=" ";
 
		  }
	 });
}); 

		
//next button		
$(document).ready(function () {
	$('#next').click(function(){
		//alert("button");
		$("#btn1").removeClass();
		$("#btn2").addClass("active");	
	});
});

		
 		
		
		
	</script>

		</body>
		
	</html>