<!-- jay singh -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!-- -------------------- -->
<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<!--  jay singh -->


	<!-- jay singh -->
	
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
		<style type="text/css">
		
		.myitem{
		margin:10px !important; 
		height:50px;
		}
		</style>
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<!-- JAY NOTIFICATIONS HEADER  -->
<jsp:include page="../../jsp/common/viewopportunityheader.jsp"></jsp:include>
<jsp:include page="../../jsp/common/systemadmin_menu.jsp"></jsp:include>


				<div class="main-content">
				<div class="main-content-inner">
				
			

					<div class="page-content">
					
				
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >All notification</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
						
				<!-- PAGE CONTENT BEGINS -->
						
								

								
	
	
	<div class="row"id="allNotifications"  style="padding-top:0px;">
	</div> 
            
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
<script>
$(document).ready(function(){
	var notiCountCall={
			url:"<%=application.getContextPath()%>/JobPostingNotificationAction",
			success : function(data){
					var pd=data[0];
				    var jp=data[1];
					$('#count-noti').html(pd.length);
					$('#main-count-noti').html(pd.length);
					$("#asd").empty();
	for (var assess = 0; assess < data[0].length; assess++) {
																
			$("#allNotifications").append(
						"<div class='row myitem'><div class='col-md-12'><a href='"+"<%=application.getContextPath()%>"+
						"/ApplyRequestOpportunityPostingAction?user_id="+pd[assess].userid+"' class='clearfix'>"+															
					    "<img src='"+pd[assess].image+"' class='msg-photo' alt='java assessment' />" +
						"<span class='msg-title'>" + "<span class='blue'>"
							+ pd[assess].firstname+ ' ' +
							pd[assess].lastname+ ':'+
						" <span style='color:darkolivegreen;font-weight:bold; font-size: 10px;'>" +
							jp[assess].description+' '+
						"</span></span></span> </span>" +
						"</a></div>	</div>"+
								"<div class='hr hr2 hr-dotted'></div>"
						);
											
			}
										
			},
			error : function(){}
		}
			
	$.ajax(notiCountCall);
		});
</script>								
</body>
</html>