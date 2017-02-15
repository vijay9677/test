<%@page import="com.nacre.online_assesment.util.URLConstants"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
		<style type="text/css">
	/* 	div#sidebar {
    width: 20%;
} */
		</style>
<div id="sidebar" class="sidebar responsive">
				<!--MAIN - MENU - START-->
				<ul class="nav nav-list">
								

			
								<li class="">
						<a href="${path}/<%=URLConstants.ADD_EDIT_DELETE_ADMIN %>" >
							<i class="menu-icon fa fa-pencil" aria-hidden="true" style="color:Green;"></i>
							<span class="menu-text">
								Add/Edit/Delete Admin
							</span>
						</a>
			<b class="arrow"></b>
			</li>
			<li class="">
						<a href="${path}/<%=URLConstants.ADD_EDIT_DELETE_TECHNOLOGIES %>" >
							<i class="menu-icon fa fa-pencil-square-o  " style="color:Green;"></i>
							<span class="menu-text">
						Add Edit Technologies
							</span>

						</a>
			<b class="arrow"></b>
			</li>
			
								<li class="">
						<a href="${path}/<%=URLConstants.ADD_EDIT_DELETE_COURSES %>" >
							<i class="menu-icon fa fa-pencil-square-o  " style="color:Green;"></i>
							<span class="menu-text">
						Add Edit Courses
							</span>

						</a>
			<b class="arrow"></b>
			</li>
			
											
								<li class="">
						<a href="${path}/<%=URLConstants.VIEW_FEEDBACK %>" >
							<i class="menu-icon fa fa-graduation-cap  " style="color:Green;"></i>
							<span class="menu-text">
			 View Feedback
							</span>
				

						</a>
			<b class="arrow"></b>
			</li>
			
			<li class="">
						<a href="${path}/<%=URLConstants.ADD_ASSESMENT_DETAILS%>" >
							<i class="menu-icon fa fa-graduation-cap  " style="color:Green;"></i>
							<span class="menu-text">
			Add Assesment Details
							</span>

						</a>
			<b class="arrow"></b>
			</li>
			
			
			

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

			</div>