

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
		<!-- basic scripts -->
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){
				}
			</script>
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

		
		
		
		<!--[if !IE]> -->
		<script src="${path}/assets/js/jquery.2.1.1.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="${path}/assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->
		
		
		
		<!-- ace settings handler -->
		<script src="${path}/assets/js/ace-extra.min.js"></script>
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
		
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${path}/assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${path}/assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${path}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${path}/assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="${path}/assets/js/excanvas.min.js"></script>
		<![endif]-->

		<!-- ace scripts -->
		<script src="${path}/assets/js/ace-elements.min.js"></script>
		<script src="${path}/assets/js/ace.min.js"></script>

