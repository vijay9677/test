<%@page import="com.nacre.online_assesment.util.StringConstants"%>
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

		<title>Home - Student</title>

 <script type="text/javascript" src="${path}/assets/js/AvoidingBackButton.js">
	    
	    </script>
			


		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<style>
		.div1{
		
		align:center;
		width: 700px;
		height: 150px;
		 
		
		padding: 10px;
        
      margin:0px 200px;
        border:1px solid Grey;
        background-color: white;
		
			
		}
		
		div.div1:hover{
		background-color:silver;
		border-style:solid ;
		border-width: 0px 0px 4px 0px; 
		border-color:#0099cc;
		
		}
		
		</style>
		
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/student_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->

                <!--       See All Notifications Start          -->

<div  class="container" id="allNotifications"></div>


                <!--         See All Notifications End          -->



<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>

<script type="text/javascript" src="${path}/assets/js/gajananNotificationsJobpost.js"></script>

<script type="text/javascript" src="${path}/assets/js/ManishStudentNotifications.js"></script>
							
							
			
						<script>
						$(document).ready(function(){
							var notiCountCall={
									url:"<%=application.getContextPath()%>/getJobDetailsToShowNotification",
									
									success : function(jobNotification){
										
										$("#mainNotificationCount").html(jobNotification.length);
							//			$("#notificationCount").html(jobNotification.length);
										for (var ind = 0; ind < jobNotification.length; ind++) {
						/* 					$("#notificationDetails").append(
													"<li class=''>" +
														"<a href='${path}/ShowJobDetailsAction?jobPostingID="+jobNotification[ind].jobPostingID+"'  class='clearfix'>"+ 
															"<img src='"+jobNotification[ind].companyLogo+"' class='msg-photo' />" +
															"<span class='msg-body'>" + 
															"<span class='msg-title'>" + 
																"<span class='blue'>"
																	+ 
																	jobNotification[ind].jobDescription + 
																"</span>" 
															        +
															"</span> </span>" +
														"</a></li>");
						
						 */					
											$("#allNotifications").append(
													"<br>"+
													"<a href='${path}/jsp/student/jobdescription.jsp?JobpostId="+jobNotification[ind].jobPostingID+"'  class='clearfix'>"+ 
														
													"<div class='div1'>" +
															
															"<span class='msg-body'>" + 
															"<span class='msg-title'>" + 
																"<span class='blue ' style='font-size:20px;'>"
																	+ 
																	jobNotification[ind].jobDescription +"<br>"+
																	
																"</span>" 
															       +
															"</span></span>" +
														"<span>"+ jobNotification[ind].companyName +"</span><br><br>"+
														
														"<span class=' glyphicon glyphicon-map-marker'> "+ jobNotification[ind].city+"</span><br><br>"+
														"<span style='color:grey;'>Keyskills:</span>"+jobNotification[ind].technology+"</div></a>");
														
														
											
											
										}
										
									},
									
									error : function(){}
							}
							$.ajax(notiCountCall);
						});
						</script>
</body>
</html>