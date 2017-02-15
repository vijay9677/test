


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

		<title>Home - Admin</title>

 <script type="text/javascript" src="${path}/assets/js/AvoidingBackButton.js">
	    
	    </script>
			
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<style>
		.image {
    margin-bottom: auto;
    margin-left:210px;
    margin-right:100px;
    margin-top: 5%;
    width:690px
}
</style>
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/special_admin_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
<div>
<!--  <h1 style="font-size:300%;font-family: cursive;">Technical Team</h1>
 --> 
 <div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Welcome to Admin Home Page</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<div align="center" >
 <img src="<%=application.getContextPath()%>/images/Change-WordPress-Admin-Username.png"  class='image'>
 </div>	
 



<!-- Rakesh Messages -->
	 <h3><% String message5 = (String)session.getAttribute("pwd_msg");
														if(message5!=null)
														{					
														%>
										<label class='label label-danger' style="color:red"><%=message5 %></label>
										<%
										
														session.removeAttribute("pwd_msg");
														} %> 
														</h3>
	
<!-- Rakesh Messages -->


	
	


<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>

<script type="text/javascript" src="${path}/assets/js/gajananNotificationsJobpost.js"></script>
</body>
</html>
