
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>COURSE-REGISTRATION-PAGE</title>

<meta name="description" content="User Registration page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/ace.min.css" />


<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/ace-rtl.min.css" />




<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/jquery-ui.min.css">
<style type="text/css">

body { 
    background-image: url("<%=application.getContextPath()%>/images/bg.jpg");
   background-repeat:no-repeat;
    background-attachment: fixed;
    background-position: center;
     background-size: 100%; 
}	 
</style>
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">Registration Form</span>
								
							</h1>
							<h4 class="blue" id="id-company-text">&copy;Nacre Software
								Services</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> Please Enter
											Technology Information
										</h4>

										<div class="space-6"></div>

										<form action="<%=application.getContextPath() %>/StudentRegistrationAction" method="post">
											<fieldset>
												<input type="hidden" name="identity" value="5">
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <b>Technology:<span style="color:red;">*</span></b><select
														class='form-control' name="technology" id='technology'
														required="required">

													</select>
												</span></label>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <div id='courses'></div>
												</span></label>
													<div class="space-24"></div>

														<div class="clearfix">
													<div>
														
															<button type="submit" class="width-25 pull-right btn btn-sm btn-primary">
															<span >Register</span>
														</button>
													</div>

													<button type="reset"
														class="width-25 pull-left btn btn-sm btn-primary">
														<i class="ace-icon fa fa-refresh"></i> <span
															>Reset</span>
													</button>
												</div>
												
												
												
												
												<div class="space"></div>
												<div class="clearfix">
													<div>
															<button onclick="goBack()" class="width-25 pull-left btn btn-sm btn-primary">
															<i class="ace-icon fa fa-arrow-left"></i>
															<span >Back</span>

															
														</button>
													</div>

										
												</div>
											</fieldset>
										</form>

									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="navbar-fixed-top align-right">
						<br /> &nbsp; <a id="btn-login-dark" href="#">Dark</a> &nbsp; <span
							class="blue">/</span> &nbsp; <a id="btn-login-blur" href="#">Blur</a>
						&nbsp; <span class="blue">/</span> &nbsp; <a id="btn-login-light"
							href="#">Light</a> &nbsp; &nbsp; &nbsp;
					</div>
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.main-content -->

	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script
		src="<%=application.getContextPath()%>/assets/js/jquery.2.1.1.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="../assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document.write("<script src='../assets/js/jquery.min.js'>"
						+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='../assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript"
		src="<%=application.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			$(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			});
		});

		//you don't need this, just used for changing background
		jQuery(function($) {
			$('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');

				e.preventDefault();
			});

		});
		// technology ajax call
		$('document').ready(function(){
				
						
				var obj={
					url:"<%=application.getContextPath()%>/GetTechnologyAction",
					
					success:function(technology){
						$("#technology").empty();
						$("#technology").append("<option value=''>---Select Technology---</option>");
						for (var ind = 0; ind < technology.length; ind++) {
							$("#technology").append("<option value='"+technology[ind].technologyId+"'>"+technology[ind].technology+"</option>");
								
						}
						//alert(technology);
						
					},
					error:function(){
						alert("please try later")
						
					}
					
					};
						
						$.ajax(obj);
						
						
						
					});
		//courses ajax call
		$('document').ready(function(){
		 $("#technology").change(function(){
				var uid=$(this).val();
				//alert(uid);
		var obj={
			url:"<%=application.getContextPath()%>/GetCoursesActionSunil.ajax",
													data : {
														"technologyId" : uid
													},
													success : function(courses) {
														$("#courses").empty();
														$("#courses")
																.append(
																		"<br><br>"
																				+ "<b>Choose Your Courses:</b>"
																				+ "<br>");
														for (var ind = 0; ind < courses.length; ind++) {
															/*  $("#courses").append("<option value='"+courses[ind].courseId+"'>"+courses[ind].course+"</option>");*/
															/*   $("#courses").append("<div class='checkbox'><label><input type='checkbox' value="+courses[ind].courseId">" +courses[ind].course+"</label></div>");  */
															$("#courses")
																	.append(
																			"<input type='checkbox' name='courses'  value='"+courses[ind].courseId+"'>"
																					+ courses[ind].course
																					+ "<br>");
														}
														//alert(courses);

													},
													error : function() {
														alert("please try later")

													}
												};

												$.ajax(obj);

											});

						});
		//at least one checkbox text validation
		$(document).ready(function() {
			$('#checkBtn').click(function() {
				checked = $("input[type=checkbox]:checked").length;

				if (!checked) {
					alert("You must check at least one checkbox.");
					// $('#courses').html("You must check at least one checkbox.");
					return false;
				}

			});
		});
		//for go back
		function goBack() {
    window.history.back();
}
	</script>
</body>
</html>
