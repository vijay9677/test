<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
panelStyle{
width:70%;
}
</style>
		
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">

<jsp:include page="../../jsp/common/technical_Team_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/technicalteam_menu.jsp"></jsp:include>
<%-- <jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include> --%>
<!-- write your code here -->
<div class="main-content">
	<div class="main-content-inner">
		<div  class="page-content">
							<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
							<!--Separetor end-->					
						<h4 class="pink">
							<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
								 <b class="blue" >Assessment Notification Details </b> 
						</h4>
							<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
			
						<div class="row">
						<div class="col-xs-12"></div>
	 	</div>
	</div>

		<% List<AssesmentDTO> notificationDetails=(List<AssesmentDTO>) session.getAttribute("AssesmentDetailsList"); %>
		<% int id=Integer.parseInt(request.getParameter("assesId")); %>
		<% for(AssesmentDTO assesmentNotiDetails:notificationDetails){
	if(id==assesmentNotiDetails.getAssesmentId()) {%>
	<!-- 
		<div class="container" id="panelStyle">
		 <h2>&nbsp&nbsp&nbsp</h2> -->
		<div class="panel panel-primary">
		  <div class="panel-heading">
		  <div class='row'>
		  <div class='col-md-6'>
		  ASSEMENT TYPE :<%if(assesmentNotiDetails.getAssesmentType().getAssesmentTypeName()!=null){ %>
							 <%=assesmentNotiDetails.getAssesmentType().getAssesmentTypeName()%>
							<%}else{ %>
							NA
							<%}%>
		  </div>
		  <div class='col-md-6'>
		  ASSEMENT Name :<%if(assesmentNotiDetails.getAssesment()!=null){ %>
							 <%=assesmentNotiDetails.getAssesment()%>
							<%}else{ %>
							NA
							<%}%>
		 
		  </div>
		  </div>
		  </div>
   			 
   			 <div class="panel-body">
				<div class='row'>
							<div class='col-md-4'>Total Marks</div>
							
							<div class='col-md-4'>
							<%if(assesmentNotiDetails.getTotalMarks()!=0){ %>
							<%=assesmentNotiDetails.getTotalMarks()%>
							<%}else{ %>
							NA
							<%} %>
							</div>
						</div>
						<div class='row'>
							<div class='col-md-4'>Time Duration</div>
							
							<div class="col-md-4">
							<%if(assesmentNotiDetails.getDurationInMin()!=0){ %>
							<%=assesmentNotiDetails.getDurationInMin()%>
							<%}else{ %>
							NA
							<%} %>
							</div>
						</div>
						<div class='row'>
							<div class='col-md-4'>Date</div>
							
							<div class='col-md-4'>
							<%if(assesmentNotiDetails.getDate()!=null){ %>
							<%=assesmentNotiDetails.getDate()%>
							<%}else{ %>
							NA
							<%} %>
							</div>
						</div>
						<div class='row'>
							<div class='col-md-4'>Course</div>
	
							<div class='col-md-4'>
							<%if(assesmentNotiDetails.getCourse().getCourse()!=null){ %>
							<%=assesmentNotiDetails.getCourse().getCourse()%>
							<%}else{ %>
							NA
							<%} %>
							</div>
						</div>
	<div class='row'>
							<div class='col-md-4'>level</div>

							<div class='col-md-4'>
							<%if(assesmentNotiDetails.getLevel().getLevel()!=null){ %>
							<%=assesmentNotiDetails.getLevel().getLevel()%>
							<%}else{ %>
							NA
							<%} %>
							</div>
						</div>
					
						
					
				
			</div>
			<div class="panel-footer bg-primary">
		
		<div class='row'>
		
		
		<div class='col-md-12'>
		<a href="<%=application.getContextPath()%>/jsp/technical_team/upload_assessment_paper.jsp?assessId=<%=id %>">
									<input type="submit"  class="button btn btn-primary btn-lg" value="UPLOAD PAPER">
							</a>
		
		</div>
		
		</div>
			
			</div>
		</div>
	</div>
	
	

	<% }
	}%>
	</div>
		<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

<script type="text/javascript">
var path = '<%=application.getContextPath()%>';
</script>
 
 						<script src ="<%=application.getContextPath()%>/<%=URLConstants._GET_ASSESSMENT_DETAILS_NOTI%>">
						</script>
</body>
</html>