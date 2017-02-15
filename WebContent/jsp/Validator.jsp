<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<%
String vUserId = (String)session.getAttribute(StringConstants._SESSION_USER_ID);
if(vUserId!=null){
String vRoleId = (String)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID);

if(vRoleId!=null){
Integer iRoleId = Integer.parseInt(vRoleId);
	if (iRoleId == StringConstants._ADMIN_ROLE_ID) {
		response.sendRedirect(request.getContextPath() + "/" + URLConstants.ADMIN_HOME_PAGE_URL);
	} else if (iRoleId == StringConstants._HR_ROLE_ID) {
		response.sendRedirect(request.getContextPath() + "/" + URLConstants.HRADMIN_HOME_PAGE_URL);
	} else if (iRoleId == StringConstants._CORPORATE_ROLE_ID) {

		response.sendRedirect(request.getContextPath() + "/" + URLConstants.CORPORATEADMIN_HOME_PAGE_URL);

	} else if (iRoleId == StringConstants._SYSTEM_ROLE_ID) {

		response.sendRedirect(request.getContextPath() + "/" + URLConstants.SYSTEMADMIN_HOME_PAGE_URL);

	} else if (iRoleId == StringConstants._TECHINICAL_ROLE_ID) {

		response.sendRedirect(request.getContextPath() + "/" + URLConstants.TECHNICALADMIN_HOME_PAGE_URL);

	} else if (iRoleId == StringConstants._STUDENT_ROLE_ID) {

		response.sendRedirect(request.getContextPath() + "/" + URLConstants.STUDENT_HOME_PAGE_URL);

	} else {

		response.sendRedirect(request.getContextPath() + "/" + URLConstants.LOGIN_PAGE_URL);
	}

}
}

%>