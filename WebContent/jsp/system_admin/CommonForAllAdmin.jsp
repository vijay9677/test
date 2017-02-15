<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<meta name="description" content="Nacre Software Services Assesment"  />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<title>Home - Admin</title>
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/validationEngine.jquery.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/datepicker.min.css">
</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/aside_menu.jsp"></jsp:include>

			
			<!-- Main-Containts-Start-Here -->
			<div class="main-content">
				<div class="main-content-inner">
				
			

					<div class="page-content">
					
				
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b id="heading" class="blue" ></b>
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->


<!-- write your code here -->
<!--
							/***************************************************************/
							/**This Div is use for Display Records on current home page...**/
							/***************************************************************/
-->
<div class="container">
		<div class="row">
			<!-- Trigger the modal with a button -->
				<div class="col-md-6" style="text-align: left;">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
						Choose Any One... <span class="caret"></span>
					</button>
					<ul id="selectorList" class="dropdown-menu">
					</ul>
				</div>
			</div>
		</div>
	<div id="table-response" class="table-responsive"
		style="border: lightgray 1px solid; box-shadow: 5px 5px 5px lightgray; ">
			<table class="table table-bordered" style="text-align: center; ">
				<thead>
					<tr class='bg-primary'>
						<th class='bg-primary' style="text-align: center;">S.No</th>
						<th class='bg-primary'style="text-align: center;">User_ID</th>
						<th class='bg-primary'style="text-align: center;">Name</th>
						<th class='bg-primary'style="text-align: center;">Email_Id</th>
						<th class='bg-primary'style="text-align: center;">Mobile No</th>
						<th class='bg-primary'style="text-align: center;">Gender</th>
						<th class='bg-primary'style="text-align: center;">Department</th>
					</tr>
				</thead>
				<tbody id="bodyData">
					<tr class="success" id="usertable"
						style="background-color: lightgray; ">
					</tr>
				</tbody>
			</table>
	</div>
<!--
							/***************************************************************/
							/**This Script Tag is use for Show Group Bise Admin Records...**/
							/***************************************************************/
-->
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script
	src="<%=application.getContextPath()%>/assets/js/bootstrap-datepicker.min.js"></script>
<script
	src="<%=application.getContextPath()%>/assets/js/jquery.validationEngine.js"></script>
<script
	src="<%=application.getContextPath()%>/assets/js/jquery.validationEngine-en.js"></script>
<script
	src="<%=application.getContextPath()%>/assets/js/jquery.bootpag.min.js"></script>
<script>
$('document').ready(function(){
	var roleID;
    var roleID= "<%=request.getParameter("roleId")%>"
    $.ajax({
		url:"<%=application.getContextPath()%>/GetGroupByAdminDataAction",
		data : {"RoleId" : roleID},
		success : function(obj) {
			$("#heading").html(obj[0].role.role);
			$("#bodyData").empty();
			for (var i = 0; i < obj.length; i++) {
				var store = "<tr>";
				store += "<td>" + (i + 1) + "</td>"
				store += "<td id='User_Id'>"+ obj[i].userid + "</td>"
				store += "<td id='Admin_Name'>"+ obj[i].firstname + " "+ obj[i].lastname + "</td>"
				store += "<td id='Email_Id'>"+ obj[i].email + "</td>"
				store += "<td id='Mobile_No'>"+ obj[i].mobileNo + "</td>"
				if (obj[i].gender == 0) {
					store += "<td id='Gender'>Male</td>"
				} else {
					store += "<td id='Gender'>Female</td>"
				}
				store += "<td id='Role_Id'>"+ obj[i].role.role+ "</td>"
				store += "<br/> <br/>"
				store += "</tr>";
				$("#bodyData").append(store);
			}//outer for 
		}
	});
});
</script>
<script>
$('document').ready(function(){
	  $.ajax({
			url:"<%=application.getContextPath()%>/GetRoleByAdminAction",
				success:function(role){
					$('#selectorList').empty();
					//$('#selector').append("<li value=''>Select role...</li>");
				for (var ind = 0; ind < role.length; ind++) {
					$('#selectorList').append(	"<li value='"+role[ind].roleId+"' class='admin_role'><a href='<%=application.getContextPath()%>/jsp/system_admin/CommonForAllAdmin.jsp?roleId="+role[ind].roleId+"'</a>"+role[ind].role+"</li>");
					//$('#selector').append("<option value='"+role[ind].roleId+"'>"+role[ind].role+"</option>");			
					//$('#selector').append("<li value='"+role[ind].roleId+"'>"+role[ind].role+"</li>");
				}
			},
			error:function(){
				alert("please try later");
			}
		})
});
</script>
</body>
</html>