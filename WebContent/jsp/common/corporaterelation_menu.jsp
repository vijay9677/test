
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
	<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<div id="sidebar" class="sidebar responsive">
				<!--MAIN - MENU - START-->
				<ul class="nav nav-list">
					<li class="">
						<a href="${path}/<%= URLConstants.ADD_CLIENT_DETAILS %>" >
							<i class="menu-icon fa fa-briefcase"></i>
							<span class="menu-text">
							View Add/Edit clients 
							</span>

						</a>
			<b class="arrow"></b>
							</li>
							
					<li class="">
						<a href="${path}/<%= URLConstants.JOB_POSTING %>" >
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
							Add Job Postings</span>
						</a>
			<b class="arrow"></b>
							</li>
							
					<li class="">
						<a href="${path}/<%= URLConstants.EDIT_JOB_POSTING %>" >
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
							Edit Job Postings</span>
						</a>
			<b class="arrow"></b>
							</li>
														
							
							
							
								</ul>
					


				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

			</div>