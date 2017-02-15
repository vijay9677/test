


		
<%-- 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Example of Bootstrap 3 Success Alert Message</title>
<link rel="stylesheet" href="<%=application.getContextPath() %>/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/bootstrap-theme.min.css">
<style type="text/css">
	.bs-example{
		margin: 20px;
	}
	.center, .align-center {
    text-align: center!important;
}
</style>
</head>
<body>
 --%>
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

  <link href="sticky-footer-navbar.css" rel="stylesheet">

<!--     <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 --><%--  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/assets/css/mycss/mystyle.css">
		
	 --%>		</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/special_admin_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>

			<div class="main-content">
				<div class="main-content-inner">
				
			

					<div class="page-content">
					
				
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >VIEW STUDENT INFORMATION</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->



<!-- write your code here -->
 <div class="bs-example col-lg-8">
    <div class="alert alert-success fade in">
    
                     <a href=''#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>
      	<p>Verification succesfully completed..</p>
        
        <strong>Success!</strong> Your authentication details message has been sent successfully.
       
     
    </div>
    
</div>
<div class="center col-md-6">
<a href="<%=application.getContextPath() %>/jsp/admin/SearchStudent.jsp">
<button type="button" class="btn btn-sm btn-primary btn-white btn-round">
<span  class="bigger-110"  id='reject_studentbtn'><strong>Go!</strong> Home Page </span>
<i class="glyphicon glyphicon-home"></i>
</button></a>
</div>
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</body>
</html>                                		