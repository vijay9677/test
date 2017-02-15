<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="com.nacre.online_assesment.form_bean.ShowJobDetailsBean" %>
<%@page import="com.nacre.online_assesment.dto.AssesmentDTO"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath() %>"></c:set>
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
		
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/aside_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->


<%  
	ShowJobDetailsBean bean=(ShowJobDetailsBean)request.getAttribute("bean");
	
%>



<div align="center" class="div1">

	<span style="color:#008CBA;  font-size:30px; font-weight: bold; font-family: Times New Roman; ">Job Details</span>
	<br>
<img src= "<%=bean.getImages() %>"width="100" height="100">
<br>
<br>
 <table  >
     
   		<tr>
   			<th>Company Name:</th>
   			<td><%= bean.getClientName()%></td>
   		</tr>
		
     	
		<tr>
   			<th>Company Description:</th>
   			<td><%= bean.getCompanyDescription() %></td>
   		</tr>
		
		<tr>
   			<th>Job Description:</th>
   			<td><%= bean.getJobDescription() %></td>
   		</tr>
   		
   		<tr>
   			<th>Technology:</th>
   			<td><%= bean.getTechnology() %></td>
   		</tr>
   		
   		<tr>
   			<th>vacancy:</th>
   			<td><%= bean.getVacancies() %></td>
   		</tr>
   		
   		<tr>
   			<th>Posted On:</th>
			<td><%= bean.getPostDate() %></td>
		</tr>	
   		
   		
   		<tr>
   			<th>Start Date:</th>
			<td><%= bean.getAssStartDate() %></td>
		</tr>	
   		
   		<tr>
   			<th>End Date:</th>
			<td><%= bean.getAssEndDate() %></td>
		</tr>	
   		
   		
   		
   		<tr>
   			<th>Address:</th>
   			<td><%= bean.getLocation()%>,<%= bean.getCity() %>,<%= bean.getState() %></td>
   		</tr>	
   		
   		
		
		<tr>
   			<th>Contact Details:</th>
			<td><%= bean.getClientEmail() %></td>
		</tr>	
		
		<tr>
   			<th></th>
			<td><%= bean.getClientMobNO() %></td>
		</tr>	
   		
   		
</table>
		
			</div>	
	

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
										
										$("#mainNotificationCount").html(jobNotification.length);
										$("#notificationCount").html(jobNotification.length);
										for (var ind = 0; ind < jobNotification.length; ind++) {
											$("#notificationDetails").append(
													"<li>" +
													"<a href='${path}/JobPostingNotificationDetailAction?jobPostingID="+jobNotification[ind].jobPostId+"'  class='clearfix'>"+ 
													"<img src='"+jobNotification[ind].images+"' class='msg-photo' />" +
													"<span class='msg-body'>" + 
													"<span class='msg-title'>" +	
															"<span class='blue'>"
																	+ ' Description: ' +jobNotification[ind].jobDescription +' Expected Date:  ' + jobNotification[ind].expectedDate  + ' Assesment Start Date:  '+jobNotification[ind].assStartDate +'Assesment End Date :' + jobNotification[ind].assEndDate+ 'Posted Date :' + jobNotification[ind].postDate + 'No Of Vacancies :' + jobNotification[ind].vacancies +  
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
						</script>
</body>
</html>