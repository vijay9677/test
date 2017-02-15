
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

		<title>Home - System Admin</title>

 <script type="text/javascript" src="${path}/assets/js/AvoidingBackButton.js">
	    
	    </script>
			


		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<style>
		i.ace-icon.fa.fa-hand-o-right.icon-animated-hand-pointer.blue {
    margin-left: 34px;
}</style>
		
			</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<!-- JAY NOTIFICATIONS HEADER  -->
<jsp:include page="../../jsp/common/viewopportunityheader.jsp"></jsp:include>

<jsp:include page="../../jsp/common/systemadmin_menu.jsp"></jsp:include>
<!-- write your code here -->


 <div>

  <div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Welcome to System Admin Home Page</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
 <div align="center" >
 <img src='<%=StringConstants._SYSTEM_ADMIN_HOME %>' alt='System_Admin' style='width:60%; margin-top:30px'>
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
	
	</body>
</html>
