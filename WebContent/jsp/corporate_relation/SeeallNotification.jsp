
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath() %>"></c:set>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.online_assesment.dto.AssesmentDTO"%>
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
		<style type="text/css">
		div#asd div:hover {
    background-color: #b8f7f7;
}
		</style>
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/hrdepartment_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
 



<div id="asd"></div>

						<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
							
							
							
						
<!-- This is for Rajnish Jobnoti to hr -->
<script>
var path="${path}";
</script>
<script type="text/javascript" src="${path}/assets/js/RajnishJobPostNotificationsToHr.js"></script>
<!-- This is end for Rajnish Jobnoti to hr -->

							
							
													<script>
						$(document).ready(function(){
							var notiCountCall={
									url:"${path}/JobPostingNotificatonActionRajnish",
									
									success : function(jobNotification){
										
										//$("#mainNotificationCount").html(jobNotification.length);
										//$("#notificationCount").html(jobNotification.length);
										
										if(jobNotification.length==0)
										{
										$("#asd").append(
												
										"<span style='color:green' font-size:16> No new Notifications</span>"
										);
										}
									else{
									
				
										for (var ind = 0; ind < jobNotification.length; ind++) {
										
											/* $("#notificationDetails").append(
													"<li>"+ 
													"<a href='${path}/JobPostingNotificationDetailAction?jobPostingID="+jobNotification[ind].jobPostId+"'  class='clearfix'>"+ 
													"<img  src='"+jobNotification[ind].images+"' class='msg-photo' />" +
													"<span class='msg-body'>" + 
													"<span class='msg-title'>" +	
															"<span class='blue'>"
																	+ ' Description: ' +jobNotification[ind].jobDescription +' Expected Date:  ' + jobNotification[ind].expectedDate  + ' Assesment Start Date:  '+jobNotification[ind].assStartDate +'Assesment End Date :' + jobNotification[ind].assEndDate+ 'Posted Date :' + jobNotification[ind].postDate + 'No Of Vacancies :' + jobNotification[ind].vacancies +  
																"</span>" 
															        +
															"</span> </span>" +
														"</a></li>");
											
										
										 */	$("#asd").append(
													
											
													"<div class='row'>" +
													"<a href='${path}/JobPostingNotificationDetailAction?jobPostingID="+jobNotification[ind].jobPostId+"'  class='clearfix'>"+
													"<img width=100px height=100px id='imgsize' src='"+jobNotification[ind].images+"' class='msg-photo' />" +
													
													"<span class='msg-body'>" + 
													"<span class='msg-title'>" +"<span class='blue'>"
																	+ ' Description: ' +jobNotification[ind].jobDescription +' Expected Date:  ' + jobNotification[ind].expectedDate  + ' Assesment Start Date:  '+jobNotification[ind].assStartDate +'Assesment End Date :' + jobNotification[ind].assEndDate+ 'Posted Date :' + jobNotification[ind].postDate + 'No Of Vacancies :' + jobNotification[ind].vacancies +  
																"</span>" 
															        +
															"</span> </span>" +
														"</a></div>");
											
											
											}
										}
										
									},
									
									error : function(){}
							}
							$.ajax(notiCountCall);
						});
						</script>
