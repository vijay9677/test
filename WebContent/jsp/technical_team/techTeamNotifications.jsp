<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.List"%>
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
								 <b class="blue" >Assesment Notifications </b> 
						</h4>
							<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
			
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
</div></div> 

 
	<div class="container" style="border:lightgray 1px solid; box-shadow:5px 5px 5px lightgray;">
 	<div class="row" id="assessmentNoti" >
	</div>
	</div>


<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script>
$(document).ready(function(){
							var notiCountCall={
									url:"<%=application.getContextPath()%>/<%=URLConstants._GET_ASSESSMENT_DETAILS_TO_TECH_TEAM%>",
									success : function(assesmentNotification){
										/* $("#assesmentCount").html(assesmentNotification.length); */
										if(assesmentNotification.length==0){
											$("#assessmentNoti").append(
													"<h2><center>NO NOTIFICATIONS ARE AVAILABLE</center></h2>");
										}
										for (var ind = 0; ind < assesmentNotification.length; ind++) {
											if(assesmentNotification[ind].course.course=="core Java" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
											{
											var img="<img src='/OnlineAssesmentB35/assets/images/nacre/cj1.png' width='80px' height='80px' class='msg-photo' alt='java assessment' />";
											}
										
										else if(assesmentNotification[ind].course.course=="Adv Java" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='/OnlineAssesmentB35/assets/images/nacre/ajava.png' width='80px' height='80px' class='msg-photo' alt='java assessment' />";
												}
										
										else if((assesmentNotification[ind].course.course=="c#"||assesmentNotification[ind].course.course=="asp.net") && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='/OnlineAssesmentB35/assets/images/nacre/c1.png' width='80px' height='80px' class='msg-photo' alt='java assessment' />";
												}
										
										else if(assesmentNotification[ind].course.course=="Sql" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='/OnlineAssesmentB35/assets/images/nacre/sql.png' width='80px' height='80px' class='msg-photo' alt='java assessment' />";
												}
										
										else if(assesmentNotification[ind].course.course=="Html" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='/OnlineAssesmentB35/assets/images/nacre/php.png' width='80px' height='80px' class='msg-photo' alt='java assessment' />";
												}
										
										else if(assesmentNotification[ind].course.course=="CSS" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='/OnlineAssesmentB35/assets/images/nacre/php.png' class='msg-photo' width='80px' height='80px' alt='java assessment' />";
												}
										
										else 
										{
											var img="<img src='/OnlineAssesmentB35/assets/images/nacre/nacre.png' class='msg-photo' width='80px' height='80px'alt='java assessment' />";
												}
											var assessmentId, assessmentName,durationTime,date,course,assesmentType,level,totalMarks;
											if(assesmentNotification[ind].assesmentId == 0){
												 assessmentId= "NA";
												}else{
													assessmentId= assesmentNotification[ind].assesmentId;
												}
											
											if(assesmentNotification[ind].assesment== null){
												assessmentName = "NA";
												}else{
													assessmentName=assesmentNotification[ind].assesment;
												}
											
											if(assesmentNotification[ind].date==null){
												date = "NA";
												}else{
													date=assesmentNotification[ind].date;
												}
											if(assesmentNotification[ind].course.course==null){
												course= "NA";
												}else{
													course=assesmentNotification[ind].course.course;
												}
											if(assesmentNotification[ind].totalMarks==0){
												totalMarks= "NA";
												}else{
													totalMarks=assesmentNotification[ind].totalMarks;
												}
											if(assesmentNotification[ind].durationInMin==0){
												durationTime= "NA";
												}else{
													durationTime=assesmentNotification[ind].durationInMin;
												}
											if(assesmentNotification[ind].level.level== null){
												level= "NA";
												}else{
													level=assesmentNotification[ind].level.level;
												}
											
											$("#assessmentNoti").append(

													"<div class='row'>" +
														"<a href='<%=application.getContextPath()%>/jsp/technical_team/techTeamNotiDetails.jsp?assesId="+ assesmentNotification[ind].assesmentId+"' class='clearfix' style='text-decoration:none; color:#000;'>"+ 
															"<div class='col-sm-1'>"+img+"</div>" +
															"<div class='col-sm-1'></div><div class='col-sm-10'><br/><br/><span class='msg-body'>" + 
															"<span class='msg-title'> " + 
															"<span class='blue' >"
																	+ assessmentId + ':' +
																	assessmentName + 
																"</span>:" 
															+'TotalMarks : '+ totalMarks + ',  '+ 
															'Duration - time : '+ durationTime +',  ' +
															'Date of test : '+date+ ',  ' +
															'On : '+course+ ',  '+ 
															'Level of paper : '+level +
															"</span> </span></div>" +
														"</a></div><hr/>");
										}

									},
									error : function(){}
							}
							$.ajax(notiCountCall);
						});
						</script>
</body>
</html>