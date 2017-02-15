
<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!-- -------------------- -->
<style type="text/css">

 
 div#sidebar li{
height:50px;
}
 
 		</style>
	<style>
			.main-content-inner {
        width: 80%;
}
			</style>
<div id="navbar" class="navbar navbar-default">

			<div class="navbar-container" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="index.html" class="navbar-brand">
						<small>
							<img src='${path}/assets/images/nacre/nacre.png' title="NACRE SOFTWARE SEEVICES"  width='30px' class='img-rounded'>
							System Admin
						</small>
					</a>
				</div>

				
						
<!-- Jay singh -->						
							<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="

">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-tasks"></i>
								<span id='count-noti' class="badge badge-grey"></span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-check"></i>
									 Job Opportunity Notification
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar" id='asd'>
										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Software Update</span>
													<span class="pull-right">65%</span>
												</div>

												<div class="progress progress-mini">
													<div style="width:65%" class="progress-bar"></div>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Hardware Upgrade</span>
													<span class="pull-right">35%</span>
												</div>

												<div class="progress progress-mini">
													<div style="width:35%" class="progress-bar progress-bar-danger"></div>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Unit Testing</span>
													<span class="pull-right">15%</span>
												</div>

												<div class="progress progress-mini">
													<div style="width:15%" class="progress-bar progress-bar-warning"></div>
												</div>
											</a>
										</li>

										<li>
											<a href="#">
												<div class="clearfix">
													<span class="pull-left">Bug Fixes</span>
													<span class="pull-right">90%</span>
												</div>

												<div class="progress progress-mini progress-striped active">
													<div style="width:90%" class="progress-bar progress-bar-success"></div>
												</div>
											</a>
										</li>
									</ul>
								</li>

								<li class="dropdown-footer">
                                 <a href="<%=application.getContextPath()%>/jsp/admin/seeAllNotificationsByAdmin.jsp">	
                                 	See tasks with details
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>
<%-- upto --%>

						<ul
							class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header">
								 <i class="ace-icon fa fa-bell icon-animated-bell"></i>
							<span id="notificationCount"></span>
								View Job Opportunity Notifications
							</li>

							<li class="dropdown-content">
								<ul class="dropdown-menu dropdown-navbar" id="notificationDetails">
								</ul>
							<li class="dropdown-footer"><a href="<%=application.getContextPath()%>/jsp/admin/adminSeeAllNotifications.jsp"> See all
											notifications <i class="ace-icon fa fa-arrow-right"></i>
									</a>
							</li>
						</ul>		
						</li>
						<!-- vijay noti end -->

						
								<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" height="95%" width="100px" src="<%=session.getAttribute(StringConstants._SESSION_USER_IMG) %>" alt="User Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									<%=session.getAttribute(StringConstants._SESSION_USER_NAME) %>
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="${path}/<%=URLConstants._CHANGE_PWD_URL%>">
										<i class="ace-icon fa fa-cog"></i>
										Change Password
									</a>
								</li>

							
								<li class="divider"></li>

								<li>
									<a href="${path}/<%=URLConstants.LOGOUT_URL%>">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>					
											</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>


























