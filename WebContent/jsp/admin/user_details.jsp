<!-- jay singh -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!-- -------------------- -->
<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<!--  jay singh -->

<%@page import="com.nacre.online_assesment.dto.JobPostingDTO"%>
<%@page import="com.nacre.online_assesment.dto.ClientDTO"%>
<%@page import="com.nacre.online_assesment.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

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
		
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<!-- JAY NOTIFICATIONS HEADER  -->
<jsp:include page="../../jsp/common/viewopportunityheader.jsp"></jsp:include>

<jsp:include page="../../jsp/common/systemadmin_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
				<!-- PAGE CONTENT BEGINS -->
						
								

 <%
 List job = (List)request.getAttribute("jobOpp");
 
    List userList=  (List)job.get(0);
      List jobList=  (List)job.get(1);
      List  clientList=  (List)job.get(2);
     UserDTO user = (UserDTO) userList.get(0);
     ClientDTO client =(ClientDTO) clientList.get(0);
     JobPostingDTO jobPost =(JobPostingDTO) jobList.get(0);
 %>
 
 <div class="container">
 <div class="row">
 
 <div class="col-sm-8" align="right">
     <img id="avatar"  alt="Alex's Avatar" src="<%=client.getClientImage()%>" width="50px" height="auto">
  </div>
 </div>
 <div class="row">
  <div class="col-sm-2"></div>
 <div class="col-sm-2">
 
	<img width="150" alt="toy" src="<%=user.getImage()%>">
 </div>
 <div class="col-sm-6" style="padding:2%;">
	                	<label>	Firstname : <%=user.getFirstname() %> </label><br/>
						<label>	Lastname :<%=user.getLastname() %> </label><br/>
						<label>	Clientname :<%=client.getClientName()%> </label><br/>
						<label>	Description :<%=jobPost.getDescription()%> </label><br/>
						<label>	PostDate :<%=jobPost.getPostDate()%> </label>
</div>
	 <div class="col-sm-2"></div>
				
	</div>
	<div style="text-align:center">
	<input value="Approve" type="button" id="approveId" onclick=myApprove() 
	class="btn btn-sm btn-primary btn-white btn-round" data-toggle="modal" data-target="#myModal">
				&nbsp;&nbsp;
	<input value="Reject" type="button" onclick="myReject()" 
	class="btn btn-sm btn-primary btn-white btn-round" data-toggle="modal" data-target="#myModa">
	</div>	
</div>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">STATUS</h4>
      </div>
      <div class="modal-body">
        <p>Approved Sucessfully</p>
      </div>
      <div class="modal-footer">
        <button type="button" onclick="successApprove()" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

<div id="myModa" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">STATUS</h4>
      </div>
      <div class="modal-body">
        <p>Reject Sucessfully</p>
      </div>
      <div class="modal-footer">
        <button onclick="successReject()" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
		
		
	</div>
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
function successApprove(){
	   
    window.location.href="${path}/<%=URLConstants.STUDENT_REQUESTS_URL%>";
}

function successReject(){
   
    window.location.href="${path}/<%=URLConstants.STUDENT_REQUESTS_URL%>";  
}

var myId = "<%=request.getParameter("user_id")%>"

function myApprove(){

			$.ajax({
				type: "POST",
				url:"${path}/RequestApprovedByAdmin",
				data:{'apply_Student_Id':myId},
				success:function(obj){	
					 	 
					  $("#span").html("<center><i><h3 style='color:green'>Approved  Successfully</h3></i></center>"); 
					 
				},//sucess
				error:function(){
				  alert("please try later");
				}
				
			});
		 }
	  
function myReject(){
	
			$.ajax({
				type: "POST",
				url:"${path}/RequestRejectByAdmin",
				data:{'apply_Student_Id':myId},
				success:function(obj){	
					 	 
					  $("#span").html("<center><i><h3 style='color:green'>Approved  Successfully</h3></i></center>"); 
		          
				},//sucess
				error:function(){
				  alert("please try later");
				}
				
			});
		  }
	  </script>
</body>
</html>
