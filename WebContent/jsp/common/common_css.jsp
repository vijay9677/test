	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${path}/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path}/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="${path}/assets/fonts/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${path}/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="${path}/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${path}/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->


		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="${path}/assets/js/html5shiv.min.js"></script>
		<script src="${path}/assets/js/respond.min.js"></script>
		<![endif]-->