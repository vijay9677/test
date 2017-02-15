
<%@page import="java.util.List"%>



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

		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		
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
						<b class="blue">ALL ASSESSMENTS</b>

					</h4>
					<!--Separetor start-->
					<div class="hr hr2 hr-dotted"></div>
					<!--Separetor end-->


					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="container"
								style="border: lightgray 1px solid; box-shadow: 5px 5px 5px lightgray;">

								<div class="row" id="all-noti"></div>
							</div>

							<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

						</div>
						<!-- /.main-container -->
						<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

						<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

						<script>
						//var userId=1;
						
		$(document).ready(function(){
			//alert("ready");
			
			var obj ={
					url:"<%=application.getContextPath()%>/StudentNotificationAction",
				//	data:{"userId":userId},
					success:function(data){
						$('#count-noti').html(data.length);
						$('#main-count-noti').html(data.length);
						for(var assess=0; assess<data.length; assess++){
							if(data[assess].course=="Core java" && data[assess].assessment_type_name=="Course wise assessment" )
							{
						var img="<img src='${path}/assets/images/nacre/cj1.png' class='msg-photo' alt='java assessment' />";
							}
						
						else if(data[assess].course=="Advance java" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='${path}/assets/images/nacre/ajava.png' class='msg-photo' alt='Advance java assessment' />";
								}
						
						else if(data[assess].course=="c#" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='${path}/assets/images/nacre/c1.png' class='msg-photo' alt='c# assessment' />";
								}
						
						else if(data[assess].course=="sql" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='${path}/assets/images/nacre/sql.png' class='msg-photo' alt='sql assessment' />";
								}
						
						else if(data[assess].course=="Html" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='${path}/assets/images/nacre/php.png' class='msg-photo' alt='Html assessment' />";
								}
						
						else if(data[assess].course=="CSS" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='${path}/assets/images/nacre/php.png' class='msg-photo' alt='CSS assessment' />";
								}
						
						else 
						{
							var img="<img src='${path}/assets/images/nacre/nacre.png' class='msg-photo' alt='company assessment' />";
								}
							$("#all-noti").append(
											"<div class='row'>" +
											"<a href='<%=application.getContextPath()%>/jsp/student/ViewDetails.jsp?assesId="+data[assess].assessment_id+"' class='clearfix' style='text-decoration:none; color:#000;'>"+
													"<div class='col-sm-2'>"+img+"</div>" +
													"<div class='col-sm-1'></div><div class='col-sm-9'></br></br><br/><br/><span class='msg-body'>" + 
													"<span class='msg-title'>" + 
														"<span class='blue'>"
															+ /* data[assess].assessment_id +  ': ' + */
															data[assess].assessment_name + 
														"</span>:"+
														'Assessment type:='+data[assess].assessment_type_name+'; '+
														'Course:= '+data[assess].course+ '; '+
														'Date of test:= '+data[assess].date+ '; ' +
														'Total Marks:= '+ data[assess].total_marks+ '; '+ 
														'Duration (Minute):= '+ data[assess].duration_in_min +';' +
														
													"</span> </span></div>" +
												"</a></div><hr/>");
						}
						
					},
					error:function(){
						
						alert("PLEASE TRY LATER");
					}
			}
			
			$.ajax(obj);
			
		});
		
		</script>
</body>
</html>