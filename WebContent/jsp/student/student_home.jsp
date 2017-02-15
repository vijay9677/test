


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
		div#myCarousel {
    margin-left: 10px;
    margin-top: 30px;
   
}</style>
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/student_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
<div>
<!--  <h1 style="font-size:300%;font-family: cursive;">Technical Team</h1>
 --> 
 <div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Welcome to Student Home Page</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>

<!-- ------------------Slider-------------------- -->

<div style='width:70%; margin:auto; padding:0px; height:10px'>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="<%=StringConstants._IMG1%>">
    </div>

    <div class="item">
      <img src="<%=StringConstants._IMG2%>">
    </div> 

    <div class="item">
      <img src="<%=StringConstants._IMG3%>">
    </div>

    <div class="item">
      <img src="<%=StringConstants._IMG4%>">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
<!-- ---------------End Slider-------------------- -->



<%

if(session.getAttribute("pwd_msg")!=null){ %>
 <div class="alert alert-success">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> "${pwd_msg}"
  
</div>

<%} %>



<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>

<script type="text/javascript" src="${path}/assets/js/gajananNotificationsJobpost.js"></script>

<script type="text/javascript" src="${path}/assets/js/ManishStudentNotifications.js"></script>
</body>
</html>