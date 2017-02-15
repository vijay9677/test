<style>
.nav-list>li>a {
    height: 60px !important;
}

</style>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
	<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<div id="sidebar" class="sidebar responsive">
				<!--MAIN - MENU - START-->
				<ul class="nav nav-list">
					<li class="">
						<a href="${path}<%=URLConstants.DELETE_ASS_PAPER_URL%>" >
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
							Delete Assment Paper
							</span>

						</a>
			</li>			
			<b class="arrow"></b>
			 
			
			
</ul>
             
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

			</div>