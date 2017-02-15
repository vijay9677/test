
<!-- @author RAKESH -->


<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!-- @author RAKESH -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>	<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="Nacre Software Services Assesment"  />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<title>LOGIN</title>



		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${path}/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path}/assets/font-awesome/4.2.0/css/font-awesome.min.css" />
		<!-- text fonts -->
		<link rel="stylesheet" href="${path}/assets/fonts/fonts.googleapis.com.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="${path}/assets/css/ace.min.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="${path}/assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
<script src="${path}/assets/js/jquery.1.11.1.min.js"></script>
<script src="${path}/assets/js/jquery.validate.min.js"></script>
<script src="${path}/assets/js/additional-methods.min.js"></script>

 <script type="text/javascript" src="${path}/assets/js/AvoidingBackButton.js">
	    
	    </script>
<!-- @author Rakesh kumar 
The below script allows to validate the email or phone no which is given by the user to check whether 
the given email or phone no is valid or not 
 -->
 
 
<script>
function EmailOrPhone()
{
	//var NoRegexp = new RegExp(/^[0-9]{10}$/);
	var NoRegexp = new RegExp (/^[789]{1}\d{9}$/);
	var eRegex = new RegExp(/^([a-zA-z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/);
	var d = document.getElementById('username').value;
	
	if(isNaN(d))
		{
			if(eRegex.test(d))
				{
					document.getElementById('msg').innerHTML='';
				}
			else
				{
				document.getElementById('msg').innerHTML='plz enter a valid email';
				}
		}
	else
		{
			if(NoRegexp.test(d))
				{
				document.getElementById('msg').innerHTML='';
				}
			else
				{
				document.getElementById('msg').innerHTML='please enter a valid phone no';
				}
		}
		
}
	</script>		
	
	 <style type="text/css">

   img.img-rounded {
    height: 100px;
    position: relative;
    top: 75px;
    right: 120px;
}
font.red {
    height: 100px;
    position: relative;
    top: -20px;
    right: -60px;
    font-size: 40px;
}

font.white {
font-size: 28px;
    position: relative;
    top: -20px;
    right: -60px;
}

body { 
    background-image: url("<%=application.getContextPath()%>/images/bg.jpg");
   background-repeat:no-repeat;
    background-attachment: fixed;
    background-position: center;
     background-size: 100%; 
}	 
.space-6{
padding-bottom: 30px;

}

	 </style>
	<!-- @author Rakesh kumar
	The below script is created to validate the username or password
	which is given by the user
	 --> 
	<script>
	
	$(document).ready(function(){	
	$( "#loginform" ).validate({
	  rules: {
	    username:'required',
	    password:{
	    	required:true,
	    	
	    	minlength:8
	    }
		    },
		    messages:{
		    //username:'plz enter email (or) 10 digit numbers from 0 to 9',
		    password:'plz enter password'
		    }
	});
});
	</script>
		
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">

<%
String s =request.getParameter("regSucc");
if(s!= null){

%>
<div class="alert alert-success">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> <%=s%>
</div>
<%} %>
							<div class="center">
							<% String message = (String)session.getAttribute("forgotpassword_msg");
														if(message!=null)
														{					
														%>
														<div class="alert alert-success">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>CHECK YOUR MAIL !</strong> <%=message %>
</div>
										<%
										
														session.removeAttribute("forgotpassword_msg");
														} %>
								
							

							</div>

							<div class="space-6"></div>
												
							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Please Enter Your Credentials
											</h4>

											<div class="space-6"></div>
											  
											   <%
                                                   Cookie[] cookies=request.getCookies();
  												   String email = "", password = "",rememberVal="";
   												   if (cookies != null) {
         										   for (Cookie cookie : cookies) {
    										       if(cookie.getName().equals("cookuser")) {
             									   email = cookie.getValue();
           											}
           										   if(cookie.getName().equals("cookpass")){
             									   password = cookie.getValue();
           											}
           										   if(cookie.getName().equals("cookrem")){
             									    rememberVal = cookie.getValue();
           											}	
  											      }
    											}
                                                  %> 
                                                  
                                                 
											<form id='loginform' action="${path}/LoginAction"  method="post"  >
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Username" name="username" id='username' onblur='EmailOrPhone()' autocomplete="off" value="<%=email %>"/>
															<span id='msg' style="color:red"></span>
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" name="password" <%-- autocomplete="off" value="<%=password %>>" --%> />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" name="remember" class="ace" value="0" <%="1".equals(rememberVal) ? "checked=" +"checked" : ""%> />
															<span class="lbl"> Remember Me</span>
														</label>
		
														<input type="submit" class="width-35 pull-right btn btn-sm btn-primary" />
		
													</div>
													

													<div class="space-4"></div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="label label-danger">
												
												<!-- @author Rakesh kumar
												ThisScriplet Tag is taken so that whenever the user enters the wrong email and 
												wrong password this tag will display a msg that login information is invalid -->
												
																<% String msg = (String)session.getAttribute("login-msg");
														if(msg!=null)
														{					
														%>
										<label class='label label-danger' style="color:red"><%=msg %></label>
										<%
										
														session.removeAttribute("login-msg");
														} %>
												</span>
											</div>

											<div class="space-6"></div>

										
										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<%-- <div>
												<a href="<%=application.getContextPath() %>/WebContent/jsp/ForgotPassword.jsp" data-target="#forgot-box">
													<i class="ace-icon fa fa-arrow-left"></i>
													I forgot my password
												</a>
											</div> --%>
											
										 	<div>
											
											<a href="<%=application.getContextPath() %>/jsp/ForgotPassword.jsp" class='user-signup-link'>
													<i class="ace-icon fa fa-arrow-left"></i>
											
											Forgot Password
											
											</a>
										   </div> 

											<div>
												<a href="<%=application.getContextPath()%>/jsp/student/PersonalDetailsRegistration.jsp"  class="user-signup-link">
													I want to register
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->
								
								<!--
								 @author Rakesh kumar
								this tag is provided that when the user enters the wrong email in the forgot password
								then this page will display with some error msg 
								-->
								
								
							<%-- 	<% String message = (String)session.getAttribute("forgotpassword_msg");
														if(message!=null)
														{					
														%>
										<label class='label label-danger' style="color:white"><%=message %></label>
										<%
										
														session.removeAttribute("forgotpassword_msg");
														} %>
 --%>
								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="ace-icon fa fa-key"></i>
												Retrieve Password
											</h4>

											<div class="space-6"></div>
											<p>
												Enter your email and to receive instructions
											</p> 

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>

													<div class="clearfix">
														<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
															<i class="ace-icon fa fa-lightbulb-o"></i>
															<span class="bigger-110">Send Me!</span>
														</button>
													</div>
												</fieldset>
											</form> 
										</div><!-- /.widget-main -->

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												Back to login
												<i class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i>
												New User Registration
											</h4>

											<div class="space-6"></div>
											<p> Enter your details to begin: </p>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Username" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Repeat password" />
															<i class="ace-icon fa fa-retweet"></i>
														</span>
													</label>

													<label class="block">
														<input type="checkbox" class="ace" />
														<span class="lbl">
															I accept the
															<a href="#">User Agreement</a>
														</span>
													</label>

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="ace-icon fa fa-refresh"></i>
															<span class="bigger-110">Reset</span>
														</button>

														<button type="button" class="width-65 pull-right btn btn-sm btn-success">
															<span class="bigger-110">Register</span>

															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="ace-icon fa fa-arrow-left"></i>
												Back to login
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.signup-box -->
							</div><!-- /.position-relative -->

							<!-- <div class="navbar-fixed-top align-right">
								<br />
								&nbsp;
								<a id="btn-login-dark" href="#">Dark</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-blur" href="#">Blur</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-light" href="#">Light</a>
								&nbsp; &nbsp; &nbsp;
							</div> -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="assets/js/jquery.2.1.1.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
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
		</script>
		<jsp:include page="../jsp/common/footer.jsp"></jsp:include>
		
	</body>
</html>
