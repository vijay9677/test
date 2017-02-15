
<!-- ---------------@Author: VijayKumar P -------------------------------------------->
<!------------------@Dscription: this jsp using for see allnotification by Admin-------->
 
<%@page errorPage="adminErrorPage.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.online_assesment.dto.AssesmentDTO"%>
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

		<title>See All notifications</title>



		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<style type="text/css">

div.div1 {
    height: 100px;
margin-left: 172px;

margin-top: 10px;
}
div.div1:hover{
background-color: #def5f3;
}
</style>		
			</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<!-- JAY NOTIFICATIONS HEADER  -->

<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/hrdepartment_menu.jsp"></jsp:include><%-- <jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include> --%>
<!-- write your code here -->


<div class='container'>
<div id="allNotifications">



</div>
</div>
</div>

	
	<!------------------------------------Ajax call for getting notification------------ -->
	
	
							
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
	
	
						<script>
						$(document).ready(function(){
							var notiCountCall={
									url:"<%=application.getContextPath()%>/getJobDetailsToShowNotificationstudentAction",
									
									success : function(jobNotification){
										
						/* 				$("#mainNotificationCount").html(jobNotification.length);
										$("#notificationCount").html(jobNotification.length);
						 */				for (var ind = 0; ind < jobNotification.length; ind++) {
						
											$("#allNotifications").append(
													"<div class='div1'>" +
														"<a href='<%=application.getContextPath()%>/viewAndForwardingJobOpportunitiesAction?jobPostingID="+jobNotification[ind].jobPostingID+"'  class='clearfix'>"+ 
															"<img src='"+jobNotification[ind].companyLogo+"' class='msg-photo' width='100px'height='100px' />" +
															"<span class='msg-body'>" + 
															"<span class='msg-title'>" + 
																"<span class='blue'>"
																	+ jobNotification[ind].jobPostingID + ':   ' +
																	jobNotification[ind].jobDescription + '   '+
																	' \n openings in  '+jobNotification[ind].companyName+
																"</span>" 
															        +
															"</span> </span>" +
														"</a><div>");
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