<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.online_assesment.vo.AssessmentNotification"%>
<!DOCTYPE html>
<html lang="en">
<head>

<link rel="icon" href="assets/images/nacre/nacre.png"
	type="image/x-icon">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />

<meta name="description" content="Nacre Software Services Assesment" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<title>Home - Student</title>


<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<style type="text/css">
table{
/* 	border-collapse:collapse; */
	/* align:right; */
	cellpadding="2";
	cellpadding="2";
}

th{
	width:60%;
	height:60%;
	padding:5px;
	}
 td	{
	text-align:center;
} 
</style>
</head>

<body class="no-skin">
	<div class="main-container" id="main-container">

		<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>

		<jsp:include page="../../jsp/common/student_menu.jsp"></jsp:include>
		<div class="main-content">
			<div class="main-content-inner">



				<div class="page-content">


					<!--Separetor start-->
					<div class="hr hr2 hr-dotted"></div>
					<!--Separetor end-->
					<h4 class="pink">
						<i
							class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
						<b class="blue">Assessment details</b>

					</h4>
					<!--Separetor start-->
					<div class="hr hr2 hr-dotted"></div>
					<!--Separetor end-->
					
					
					


					<div class="row">
						<div class="col-xs-12">
							
							<% List<AssessmentNotification> notificationDetails=(List<AssessmentNotification>) session.getAttribute("assesmentnotifications"); %>
							<% int id=Integer.parseInt(request.getParameter("assesId")); %>
							<% for(AssessmentNotification assesmentNotiDetails: notificationDetails){ %>
							<% if(id==assesmentNotiDetails.getAssessment_id()) { %>
							<div>
								<div class="panel panel-success" style="width:50%" >
									<div class="panel-heading">Assessment Name:<%=assesmentNotiDetails.getAssessment_name()%></div>
									<div class="panel-body" width:60%;>
									
									
										<table >
										
											<%-- <tr>
												<th>Assesment Name</th>
												<td>:</td>
												<td></td>
												<td><%=assesmentNotiDetails.getAssessment_name()%></td>
											</tr> --%>
											
											<tr>
												<th>Assessment type</th>
												<td>:</td>
												<td>&nbsp&nbsp</td>
												<td><%=assesmentNotiDetails.getAssessment_type_name() %>
												</td>
											</tr>
											
											<tr>
												<th>Course</th>
												<td>:</td>
												<td>&nbsp&nbsp</td>
												<td><%=assesmentNotiDetails.getCourse()%></td>
											</tr>
											
											<tr>
												<th>Total marks</th>
												<td>:</td>
												<td>&nbsp&nbsp</td>
												<td><%=assesmentNotiDetails.getTotal_marks() %></td>
											</tr>

											<tr>
												<th>Duration (minute)</th>
												<td>:</td>
												<td>&nbsp&nbsp</td>
												<td><%=assesmentNotiDetails.getDuration_in_min() %></td>
											</tr>
											
											<tr>
												<th>Date</th>
												<td>:</td>
												<td>&nbsp&nbsp</td>
												<td><%=assesmentNotiDetails.getDate()%></td>
											</tr>
											
											
											</center>
											</div>
											<div>
										</table>
									</div>
								</div>
							</div>
							<table>
								<tr>

									<td align="center"><a
										href="<%=application.getContextPath()%>/jsp/student/timeSlot.jsp?assID=<%=id %>">
											<input type="submit" class="btn btn-success" value="Book the slot">
											
									</a></td>
									<td>&nbsp&nbsp</td>
									<td>&nbsp&nbsp</td>
									<%-- <td align="left"><a
										href="<%=application.getContextPath()%>/jsp/student/CheckNotification.jsp">
											<input type="submit" class="btn btn-danger" value="Cancel"> --%>
											
									</a></td>
								</tr>
							</table>
						</div>
						<%}
		 } %>

					</div>

					<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

				</div>
				<!-- /.main-container -->
				<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

				<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

				
				<script>
				//var userId=1;
						$(document).ready(function(){
							var obj ={
									url:"<%=application.getContextPath()%>/StudentNotificationAction",
								//	data:{"userId":userId},
									success:function(data){
									
										$('#count-noti').html(data.length);
										$('#main-count-noti').html(data.length);
										for(var assess=0; assess<data.length; assess++){
											if(data[assess].course=="Core java" && data[assess].assessment_type_name=="Course wise assessment" )
											{
										var img="<img src='<%=application.getContextPath()%>/assets/images/nacre/cj1.png' class='msg-photo' alt='java assessment' />";
											}
										
										else if(data[assess].course=="Advance java" && data[assess].assessment_type_name=="Course wise assessment" )
										{
											var img="<img src='<%=application.getContextPath()%>/assets/images/nacre/ajava.png' class='msg-photo' alt='Advance java assessment' />";
												}
										
										else if(data[assess].course=="c#" && data[assess].assessment_type_name=="Course wise assessment" )
										{
											var img="<img src='<%=application.getContextPath()%>/assets/images/nacre/c1.png' class='msg-photo' alt='c# assessment' />";
												}
										
										else if(data[assess].course=="sql" && data[assess].assessment_type_name=="Course wise assessment" )
										{
											var img="<img src='<%=application.getContextPath()%>/assets/images/nacre/sql.png' class='msg-photo' alt='sql assessment' />";
												}
										
										else if(data[assess].course=="Html" && data[assess].assessment_type_name=="Course wise assessment" )
										{
											var img="<img src='<%=application.getContextPath()%>/assets/images/nacre/php.png' class='msg-photo' alt='Html assessment' />";
												}
										
										else if(data[assess].course=="CSS" && data[assess].assessment_type_name=="Course wise assessment" )
										{
											var img="<img src='<%=application.getContextPath()%>/assets/images/nacre/php.png' class='msg-photo' alt='CSS assessment' />";
												}
										
										else 
										{
											var img="<img src='<%=application.getContextPath()%>/assets/images/nacre/nacre.png' class='msg-photo' alt='company assessment' />";
												}
											$("#asd").append(
															"<li>" +
																
															"<a href='<%=application.getContextPath()%>/jsp/student/timeSlot.jsp?assID="+data[assess].assessment_id+"' class='clearfix' style='text-decoration:none; color:#000;'>"+ 
																	"<div>"+img+"</div>" +
																	" <span class='msg-body'>" + 
																	"<span class='msg-title'>" + 
																		"<span class='blue'>"
																			+ /* data[assess].assessment_id + ': ' + */
																			data[assess].assessment_name + 
																		"</span>"+
																	'Assessment type:='+data[assess].assessment_type_name+'; '+
																	'Course:= '+data[assess].course+ '; '+
																	'Date of test:= '+data[assess].date+ '; ' +
																	'Total Marks:= '+ data[assess].total_marks+ '; '+ 
																	'Duration (Minute):= '+ data[assess].duration_in_min +';' +
																	
																	 
																	
																	"</span> </span>" +
																"</a></li>");
												}
									},
									error:function(){}
							}
							
							$.ajax(obj);
							
						});
						
						</script>
</body>
</html>