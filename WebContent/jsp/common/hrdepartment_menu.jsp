	<%@page import="com.nacre.online_assesment.util.URLConstants"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:set var="path" value="<%=application.getContextPath()%>" ></c:set>
<div id="sidebar" class="sidebar responsive">
				<!--MAIN - MENU - START-->
				<ul class="nav nav-list">
					<li class="">
						<a href="${path}/<%=URLConstants.ADMIN_DIRECT_SEND_JOB_OPPERTUNITY%>">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
							Share New  Job Postings				
							</span>

						</a>
			<b class="arrow"></b>
							</li>
							<li class="">
						<a href="${path}/<%=URLConstants.ROUND_INFO%>">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
							Round Info			
							</span>

						</a>
			<b class="arrow"></b>
							</li>
						</ul>


				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

			</div>