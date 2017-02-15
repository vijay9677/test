	<!-- jay singh -->
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!-- -------------------- -->
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
<!-- JAY NOTIFICATIONS HEADER  -->
<jsp:include page="../../jsp/common/viewopportunityheader.jsp"></jsp:include>

<jsp:include page="../../jsp/common/systemadmin_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<%-- <jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include> --%>
<!-- write your code here -->

<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

<!-- JAY NOTIFICATIONS HEADER  Script-->

<script type="text/javascript">

var path ="${path}";
</script>
<script type="text/javascript" src="${path}/assets/js/jaySingStudentRequestsNotifications.js"></script>
	
	<!-- JAY NOTIFICATIONS HEADER END  -->
	
	</body>
</html>
