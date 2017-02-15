<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.online_assesment.dto.AssesmentDTO"%>
<%@ page import="com.nacre.online_assesment.form_bean.ShowJobDetailsBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />

<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<title>Job Notification</title>


<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />


<script
	src="<%=application.getContextPath()%>/assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> 
				
				<span class="icon-bar"></span>

				<span class="icon-bar"></span> 
				
				<span class="icon-bar"></span>
			</button>

			<div class="navbar-header pull-left">
				<a href="index.html" class="navbar-brand"> 
				<small> 
				<img src="<%=application.getContextPath() %>/assets/images/nacre/nacre.png" title="NACRE SOFTWARE SEEVICES"  width='30px' class='img-rounded'>
							Nacre Software Services
				</small>
				</a>
			</div>

			<div class="navbar-buttons navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
<!-- rajnish notification for Jobposting to hr -->
					<li class="purple">
						<a href="#" data-toggle="dropdown" class="dropdown-toggle" > 
						<i class="ace-icon fa fa-bell icon-animated-bell"></i> 
	 					<span class="badge badge-success" id="mainNotificationCount"></span>
						</a>

						<ul
							class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header">
								 <i class="ace-icon fa fa-bell icon-animated-bell"></i>
							<span id="notificationCount"></span>
								Notification
							</li>

							<li class="dropdown-content">
								<ul class="dropdown-menu dropdown-navbar" id="notificationDetails">
								</ul>
							<li class="dropdown-footer"><a href="<%=application.getContextPath()%>/jsp/corporate_relation/SeeallNotification.jsp"> See all
											notifications <i class="ace-icon fa fa-arrow-right"></i>
									</a>
							</li>
						</ul>		
						</li>
						<!-- Notifications LI -->
						
					</ul>
				</div>
			</div>
</div>
<%  
	ShowJobDetailsBean bean=(ShowJobDetailsBean)request.getAttribute("bean");
	
%>
							<script
								src="<%=application.getContextPath()%>/assets/js/jquery.2.1.1.min.js"></script>

							<script type="text/javascript">
								window.jQuery
										|| document
												.write("<script src='assets/js/jquery.min.js'>"
														+ "<"+"/script>");
							</script>

							<script type="text/javascript">
								if ('ontouchstart' in document.documentElement)
									
									document
											.write("<script src='<%=application.getContextPath() %>/assets/js/jquery.mobile.custom.min.js'>"
													+ "<"+"/script>");
							</script>
							<script
								src="<%=application.getContextPath()%>/assets/js/bootstrap.min.js"></script>
							<script
								src="<%=application.getContextPath()%>/assets/js/jquery-ui.custom.min.js"></script>
							<script
								src="<%=application.getContextPath()%>/assets/js/jquery.ui.touch-punch.min.js"></script>
							<script
								src="<%=application.getContextPath()%>/assets/js/jquery.easypiechart.min.js"></script>
							<script
								src="<%=application.getContextPath()%>/assets/js/jquery.sparkline.min.js"></script>
							<script
								src="<%=application.getContextPath()%>/assets/js/jquery.flot.min.js"></script>
							<script
								src="<%=application.getContextPath()%>/assets/js/jquery.flot.pie.min.js"></script>
							<script
								src="<%=application.getContextPath()%>/assets/js/jquery.flot.resize.min.js"></script>

							<!-- ace scripts -->
							<script
								src="<%=application.getContextPath()%>/assets/js/ace-elements.min.js"></script>
							<script
								src="<%=application.getContextPath()%>/assets/js/ace.min.js"></script>
						<script>
						
	
						$(document).ready(function(){
							var notiCountCall={
									url:"<%=application.getContextPath()%>/JobPostingNotificatonActionRajnish",
									
									success : function(jobNotification){
										
										$("#mainNotificationCount").html(jobNotification.length);
										$("#notificationCount").html(jobNotification.length);
										for (var ind = 0; ind < jobNotification.length; ind++) {
											$("#notificationDetails").append(
													"<li>" +
													"<a href='<%=application.getContextPath()%>/JobPostingNotificationDetailAction?jobPostingID="+jobNotification[ind].jobPostId+"'  class='clearfix'>"+
													"<img src='"+jobNotification[ind].images+"' class='msg-photo' />" +
													"<span class='msg-body'>" + 
													"<span class='msg-title'>" +
																"<span class='blue'>"
																 
                                                             
                                                                + ' Description: ' +jobNotification[ind].jobDescription +' Expected Date:  ' + jobNotification[ind].expectedDate  + ' Assesment Start Date:  '+jobNotification[ind].assStartDate +'Assesment End Date :' + jobNotification[ind].assEndDate+ 'Posted Date :' + jobNotification[ind].postDate + 'No Of Vacancies :' + jobNotification[ind].vacancies +  
																"</span>" 
															        +"</span> </span>" +"</a></li>");
											
											
										}
										
									},
									
									error : function(){}
							}
							$.ajax(notiCountCall);
						});
						</script>
						
</body>
</html>