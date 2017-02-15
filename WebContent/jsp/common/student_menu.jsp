	<%@page import="com.nacre.online_assesment.util.URLConstants"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
	
<div id="sidebar" class="sidebar responsive">
				<!--MAIN - MENU - START-->
				<ul class="nav nav-list">
					<li class="">
						<a href="${path}/<%=URLConstants.BOOK_A_SLOT %>" >
							<i class="menu-icon fa fa-clock-o " style="color:Green;"></i>
							<span class="menu-text">
								Book a Slot
							</span>

						</a>
			<b class="arrow"></b>
			</li>
			
								<li class="">
						<a href="${path}/<%=URLConstants.GIVE_FEEDBACK %>" >
							<i class="menu-icon fa fa-pencil" aria-hidden="true" style="color:Green;"></i>
							<span class="menu-text">
								Give Feedback
							</span>

						</a>
			<b class="arrow"></b>
			</li>
			
								<li class="">
						<a href= "${path}/<%=URLConstants.TAKE_ASSESMENT%>">
							<i class="menu-icon fa fa-pencil-square-o  " style="color:Green;"></i>
							<span class="menu-text">
						Take Assessment
							</span>

						</a>
			<b class="arrow"></b>
			</li>
								<li class="">
						<a href="${path}/<%=URLConstants.GET_SCORE %>" >
							<i class="menu-icon fa fa-graduation-cap  " style="color:Green;"></i>
							<span class="menu-text">
				Get Scores
							</span>

						</a>
			<b class="arrow"></b>
			</li>
			
			<li class="">
			 <a href="${path}/<%=URLConstants.VIEW_JOBPOSTING_STUDENT %>" > 
						<i class="menu-icon fa fa-graduation-cap  " style="color:Green;"></i>
							<span class="menu-text">
	View Job Posting
							</span>

						</a>
			<b class="arrow"></b>
			</li>
			
								
			
<br/>


				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

			</div>