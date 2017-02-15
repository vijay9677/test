
<!----------------@Auther: Vijaykumar P  -->
<!----------------this jsp using for sending mails normally by filtering students  --------->
<!----------------And show notifications to admin------------------------------------------->
<%@page errorPage="adminErrorPage.jsp"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.online_assesment.dto.AssesmentDTO"%>

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

		<title>Sharing job opportunity</title>
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		
		<style type="text/css">
		.row {
    margin-left: 77px;
    margin-right: -12px;
}
		</style>
		
		
			</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<!-- JAY NOTIFICATIONS HEADER  -->
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/hrdepartment_menu.jsp"></jsp:include>
<%-- <jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include> --%>
<!-- write your code here -->
<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Share Job Posting Details</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->


<div class="container">
<form action="<%=application.getContextPath() %>/shareJobOpportunities" method="post">

<div class="row">
		<center><h3>Enter job opportunities</h3></center>
		<div id='msgDiv' align="center"></div>
		<div class="col-sm-2"></div>
		<div class="col-sm-2">
		   <label>Job Details:</label>
		</div>
		<div class="col-sm-6">
		<textarea  id='area' class="form-control" rows="10" cols="80" name="details"></textarea>
		</div>		
		<div class="col-sm-2"></div>
		</div>
		<br>	
		<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-1"></div>
			<div class="col-sm-2">	
			    <label>Select percentage or grade: </label>
			</div>
		
			<div class="col-sm-6">
					<select id='sper'  name="percentage" class="form-control">
						<option value="">select</option>
				        <option value='80'>A</option>
				        <option value='70'>B</option>
						<option value='60'>C</option>
						<option value='50'>D</option>
						<option value='40'>E</option>
						<%
							for (int i =35; i <= 100; i++) {
						%>
						<option value='<%=i%>'><%=i%></option>
						<%
							}
				
						%>
		            </select>
		     </div>
		     <div class="col-sm-2"></div>
		</div>
		<br>
		<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-1"></div>
			<div class="col-sm-2">	
			    <label>Select year of passed out: </label>
			 </div>
		
			<div class="col-sm-6">   
			    
			    <select id='syop' name="yop" class="form-control" >
			<option value=''>Select year</option>
			<%
				for (int i = 1999; i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
			%>
			<option value='<%=i%>'><%=i%></option>
			<%
				}
			%>
		</select>
		</div>
		<div class="col-sm-2"></div>
		</div>
		
					
		<br>
		<div class="row">
			
			
				<div class="col-sm-12" id="default-buttons" style="text-align:center;">
				
				<div class="col-sm-2"></div>
					<input type="submit" onclick='return sendNotificationValidation()' value='send notification' class="btn btn-send"/>
			</div>
			</div>
			<div class="row">
			<div class="col-sm-12" style="text-align:center">
			<%
			  if(request.getAttribute("successmsg")!=null)
			  {%>
				 <span style="color:green;"><label><%=request.getAttribute("successmsg") %></label></span> 
				  
			  <%}
			
			%></div>
			</div>
		<hr/>	

	</form>
</div>

<div id="uniqueId">
Please Wait..................
</div>
<div class="uniqueLoad"></div>
<style type="text/css">
#uniqueId
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

.uniqueLoad
{
    height:100%;
    width:100%;
    background-image:url('http://images2.layoutsparks.com/1/235919/walle-galaxy-sky-image.jpg');
}
</style>

<script>

 function sendNotificationValidation(){
	 //alert("================================");
	 var selectDetails=$("#area").val();
	 var selectPer=$("#sper").val();
	 var selectYop=$("#syop").val();
	 
	 
	 if(selectDetails=="" || selectPer=="" || selectYop=="" )
		 {
				 if(selectDetails=="")
					 {
					 $("#msgDiv").html("<div class='alert alert-danger' style='color:red'>Please Enter Details about Job</div>");
					    return false;
					 }
				 if(selectPer=="")
				 {
					 $("#msgDiv").html("<div class='alert alert-danger' style='color:red'>Please Select Percentage</div>")
					    return false;
					 }
				 if(selectYop=="")
				 {
					 $("#msgDiv").html("<div class='alert alert-danger' style='color:red'>Please Select Passing Year</div>")
					    return false;
					 }
				
		 }
	 else if(selectDetails!="" && selectPer!="" && selectYop!="" )
     {
		$("#uniqueId").show(); 
	    return true;
	    
	 }else{
		 $("#msgDiv").hide();
	 }
	 
	 
	 
 }
 
</script>






							
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

<!-- JAY NOTIFICATIONS HEADER  Script-->

<script>
var path="${path}";
</script>
<script type="text/javascript" src="${path}/assets/js/RajnishJobPostNotificationsToHr.js"></script>
	

<%-- 						<script>
						$(document).ready(function(){
							$('#uniqueId').hide();
							var notiCountCall={
									url:"<%=application.getContextPath()%>/getJobDetailsToShowNotificationstudentAction",
									
									success : function(jobNotification){
										
										$("#mainNotificationCount").html(jobNotification.length);
										$("#notificationCount").html(jobNotification.length);
										for (var ind = 0; ind < jobNotification.length; ind++) {
											
											
											$("#notificationDetails").append(
													"<li>" +
														"<a href='<%=application.getContextPath()%>/viewAndForwardingJobOpportunitiesAction?jobPostingID="+jobNotification[ind].jobPostingID+"'  class='clearfix'>"+ 
															"<img src='"+jobNotification[ind].companyLogo+"' class='msg-photo' />" +
															"<span class='msg-body'>" + 
															"<span class='msg-title'>" + 
																"<span class='blue'>"
																+ jobNotification[ind].jobPostingID + ':  ' +
																	jobNotification[ind].jobDescription + '   '+
																	' \n openings in  '+jobNotification[ind].companyName+
																	
																"</span>" 
															        +
															"</span> </span>" +
														"</a></li>");
						
										}
										
									},
									//data:{"jpID":jobNotification.jobPostingID},
									error : function(){}
							}
							$.ajax(notiCountCall);
						});
						</script> --%>
</body>
</html>