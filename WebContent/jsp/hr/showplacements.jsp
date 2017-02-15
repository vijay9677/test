<%@page import="com.nacre.online_assesment.dto.PlacementDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
	<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
	<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="Nacre Software Services Assesment"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<title>Home - Student</title>

		
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		
<link rel="stylesheet"
	href="${path}/assets/css/chosen.min.css">
<link rel="stylesheet"
	href="${path}/assets/css/bootstrap-datepicker.css">
	

<link rel="stylesheet" href="${path}/assets/css/bootstrap-select.min.css"/>

  <link rel="stylesheet" href="${path}/assets/css/bootstrapValidator.min.css"/>	
  
   <style>
 
 div#user-rounds-wrapper {
    width: 115%;
}
nav.navbar.navbar-default {
    margin: -1%;
    margin-top: 0%;
}
</style>

			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/hrdepartment_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->	
	<!-- Go Round detail page Link -->
<div style="">
<a  href="<%=application.getContextPath()%>/jsp/hr/rounddetails.jsp">

<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Round Details Page</b> 
									 
								</h4>
								</a>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->

</div>

<body>
<!--SelectBox for job select  -->
	<div style=" margin: 0px auto; margin-top: 30px;">
		<h2>Choose Job</h2>
		<select id="jobdetail" style="width: 300px;">
			<option value="0">----- Select -----</option>
		</select>
	</div>
	
	
	<div >
		<h2>Placement Information</h2>
	</div>
	
	<div id="user-rounds-wrapper"class= "container"
		style="border: lightgray solid 1px; box-shadow: 10px 10px 10px lightgray">
<!-- 		<nav class="navbar navbar-default" role="navigation">
 -->		<div class="row bg-primary" id="head">
			
			<div class="col-sm-2 primary" ><h4>User</h4></div>
			<div class="col-sm-2 primary" ><h4>Email</h4></div>
			<div class="col-sm-2 primary" ><h4>Image</h4></div>
			<div class="col-sm-2 primary" ><h4>bond</h4></div>
			<div class="col-sm-2 primary" ><h4>package</h4></div>
			<div class="col-sm-2 primary" ><h4>client</h4></div>
		</div><!-- 
		</nav> -->
		<div id='rounds-content-wrapper'>
				
			<div>
			<span style="text-align: center"><h3 style="color: red">Please select the job for placement details</h3></span>
			</div>

			
			</div>
	</div>
	
	

	
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

<!-- This is for Rajnish Jobnoti to hr -->
<script>
var path="${path}";
</script>
<script type="text/javascript" src="${path}/assets/js/RajnishJobPostNotificationsToHr.js"></script>
<!-- This is end for Rajnish Jobnoti to hr -->
	
<script	src="${path}/assets/js/chosen.jquery.min.js"></script>
<script type="text/javascript"	src="${path}/assets/js/bootstrap-datepicker.js"></script>
	
<script src="${path}/assets/js/bootstrap-select.min.js"></script>



<script type="text/javascript" src="${path}/assets/js/bootstrapValidator.min.js"> </script>
<script type="text/javascript">
$("document").ready(function(){
	$.ajax({
		  url : "<%=application.getContextPath()%>/JobSelectAction",
			type : "post",
			success : function(obj) {
	  		/*--------- Select Job -------------*/ 
			for(var ind=0; ind<obj.length; ind++){ 
				$("#jobdetail").append("<option value='"+obj[ind].jobPostId+"'>" + obj[ind].description+ "</option>");
				} 
		
				 /*  $.each(obj, function() {
					
							  $("#jobdetail").append(
									"<option value="+this.job_post_id+">" + this.description
											+ "</option>");   
					 //alert(this.job_post_id);
											
				});  */

	     		$("#jobdetail").chosen(); 
	        	}
	 	
			});
	
	$("#jobdetail").on("change", function(){
		
		var selectJob = $(this).val();
		//alert(selectJob);
		
		$.ajax({
			url:"<%=application.getContextPath()%>/ShowPlacementAction",
		    data: {"jobPostId": selectJob},
			type : "post",
			async:true,
			success:function(obj){
				/*-----Display placement Details  */
	 		 	$("#rounds-content-wrapper").html("");	
	 			
			
			var userList =	obj[0];
			var placementList =	obj[1];
			var clientList = obj[2];
			
			for (var i= 0; i < userList.length; i++) {
		      var s="<div class='row' id='row-div'>";
	           s+="<div id='user' class='col-sm-2'style='padding:1px' >"+userList[i].firstname+" "+userList[i].lastname+"</div>";
	           s+="<div id='email' class='col-sm-2'style='padding:1px' >"+userList[i].email+"</div>"; 
	           s+="<div id='img' class='col-sm-2 ' style='padding:1px'><img class='img-responsive img-thumbnail' src='"+userList[i].image+"' width='100' height='150'></div>";
	           s+="<div id='bond' class='col-sm-2'style='padding:1px' >"+placementList[i].bond+"</div>";
	           s+="<div id='pack' class='col-sm-2'style='padding:1px' >"+placementList[i].Package+"</div>";
	           s+="<div id='client' class='col-sm-2' style='padding:1px'>"+clientList[i].clientName+"</div>";
	           s+="</div>";
				
	          // $("#AddRow").html(s);

	     	$("#rounds-content-wrapper").append(s);
	          
	          }//outer for
	          
	         
				
				
			},
			
			
			
			
			
		});
		
		
		
	});
	    
		
	
	
});


</script>


</body>
</html>