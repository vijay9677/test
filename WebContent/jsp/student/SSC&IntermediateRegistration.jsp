<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>EDUCATION-REGISTRATION-PAGE</title>

<meta name="description" content="User Registration page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & font awesome -->

<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assets/css/ace.min.css" />


<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assets/css/ace-rtl.min.css" />

<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assets/css/jquery-ui.min.css">
	
<link rel="stylesheet" href="<%=application.getContextPath() %>/assets/css/formValidation.css">
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

<body class="login-layout" style="width: 90%">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">Registration
									form </span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy;Nacre Software
								Services</h4>
						</div>

						<!-- for spaces -->

						<div class="space-6"></div>
						<div class="space-6"></div>
						<div class="space-6"></div>
						<div class="space-6"></div>
						<div class="space-6"></div>
						<div class="space-6"></div>
						<div class="space-6"></div>
						<div class="space-6"></div>
						<div class="space-6"></div>

						<div class="position-relative" style="width: 150%">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> Please Enter SSC
											And Intermediate Education Details
										</h4>

										<div class="space-6"></div>

										<form id='sscForm'
											action="<%= application.getContextPath()%>/StudentRegistrationAction"
											method="post">
											<label class="block clearfix" style='color: blue'> <span
												class="block input-icon input-icon-right"><b>Enter
														Your SCC Details: </b></span>
											</label> 
											<input type="hidden" name="identity" value="2">
											
											
														<div class="form-group">	
											<label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <b>Year
														Of Pass:<span style="color: red;">*</span>
												</b><select id="sPassing" name="sPassing" required="required"
													class='form-control'><option value=''>--SELECT YEAR--</option>
														<%
														
														System.out.println("SSC form"+session.getAttribute("dobYear"));
														int dobYear=(Integer)session.getAttribute("dobYear");
														int schoolPassStart=dobYear+14;
																Calendar cal=Calendar.getInstance();
																int year=cal.get(Calendar.YEAR);
																request.setAttribute("year", year);
																for(int i=schoolPassStart;i<=year-5;i++){
								%>
														<option value="<%=i %>"><%=i %></option>
														<% 
							}
							%>

												</select>

											</span>
											</label> 
											
											</div>
											
														<div class="form-group">	
											<label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <b>Percentage:<span
														style="color: red;">*</span><span id="per-msg"></span></b><input type="text"
													placeholder="Eg-60.45" name="schoolPercentage" percentage
													required="required" class='form-control'>

											</span>
											</label>
											</div>
											
											<div class="space-6"></div>
											
														<div class="form-group">	
											<label class="block clearfix" style='color: blue'> <span
												class="block input-icon input-icon-right"><b>Enter
														Your Intermediate Details: </b></span>
											</label> 
											
											</div>
														<div class="form-group">	
											<label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <b>Year
														Of Pass:<span style="color: red;">*</span>
												</b><select id="cPassing" name="interPassing" required="required"
													class='form-control'>
							

												</select>

											</span>
											</label></div>
											
														<div class="form-group">	
											 <label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <b>Percentage:<span
														style="color: red;">*</span></b><input type="text"
													placeholder="Eg-60.45" name="interPercentage"
													required="required" class='form-control'>

											</span>
											</label>
											</div>

											<!-- ---------Educational details-----------   -->



											<!-- ---------End of Educational details-----------   -->



											<div class="space"></div>

											<div class="clearfix">
													<div>
														
															<button type="submit" class="width-25 pull-right btn btn-sm btn-primary">
															<span >Next</span>

															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
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
															<button onclick="goBack()" class="width-25 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-arrow-left"></i>
															<span >Back</span>

															
														</button>
													</div>

										
												</div>
										</form>

									</div>
									<!-- .widget-main -->

								</div>
								<!-- .widget-body -->
							</div>
							<!-- login-box -->

						</div>
						<!-- /.position-relative -->


						<div class="navbar-fixed-top align-right">
							<br /> &nbsp; <a id="btn-login-dark" href="#">Dark</a> &nbsp; <span
								class="blue">/</span> &nbsp; <a id="btn-login-blur" href="#">Cyan</a>
							&nbsp; <span class="cyan">/</span> &nbsp; <a id="btn-login-light"
								href="#">Light</a> &nbsp; &nbsp; &nbsp;
						</div>

					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<script
		src="<%=application.getContextPath() %>/assets/js/jquery.2.1.1.min.js"></script>
	<script type="text/javascript">
			
		window.jQuery || document
							.write("<script src ='<%=application.getContextPath() %>/assets/js/jquery.min.js'>"
									+ "<"+"/script>");
		</script>

	<script type="text/javascript">
			if ('ontouchstart' in document.documentElement)
				document
						.write("<script src='<%=application.getContextPath() %>/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script type="text/javascript" src="<%=application.getContextPath() %>/assets/js/formValidation.js"></script>
    
    <script type="text/javascript" src="<%=application.getContextPath() %>/assets/js/framework/bootstrap.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
	var currentYear='<%=year%>';
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
				$('#id-text2').attr('class', 'cyan');
				$('#id-company-text').attr('class', 'cyan');

				e.preventDefault();
			});

		});
		
		//year of pass 
		$('document').ready(function(){
			 $("#sPassing").change(function(){
					var sPass=$(this).val()*1+2;
					
					$("#cPassing").empty();
					$("#cPassing").append("<option value=''>--Select Year--</option>");
					for (var ind = sPass; ind <=currentYear-3; ind++) {
						$("#cPassing").append("<option value="+ind+">"+ind+"</option>");	
					}
				
				
				});
});
		//for go back
		function goBack() {
    window.history.back();
}
		
		

		$('#sscForm')
		.formValidation({
		    message: 'This value is not valid',
		    icon: {
		        valid: 'glyphicon glyphicon-ok',
		        invalid: 'glyphicon glyphicon-remove',
		        validating: 'glyphicon glyphicon-refresh'
		    },
		    fields: {
				fname: {
		            message: 'The username is not valid',
		            validators: {
		                notEmpty: {
		                    message: 'The First Name is required and can\'t be empty'
		                },
		                stringLength: {
		                    min: 2,
		                    max: 30,
		                    message: 'The First Name must be more than 2 and less than 30 characters long'
		                },
		                /*remote: {
		                    url: 'remote.php',
		                    message: 'The username is not available'
		                },*/
		                regexp: {
		                    regexp: /^[a-zA-Z]+$/,
		                    message: 'The First Name can only consist of alphabetical'
		                }
		            }
		        },
		        lname: {
		            message: 'The username is not valid',
		            validators: {
		                notEmpty: {
		                    message: 'The Last Name Name is required and can\'t be empty'
		                },
		                stringLength: {
		                    min: 2,
		                    max: 30,
		                    message: 'The Last Name must be more than 2 and less than 30 characters long'
		                },
		                /*remote: {
		                    url: 'remote.php',
		                    message: 'The username is not available'
		                },*/
		                regexp: {
		                    regexp: /^[a-zA-Z]+$/,
		                    message: 'The Last Name can only consist of alphabetical'
		                }
		            }
		        },
		        email: {
		            validators: {
		                notEmpty: {
		                    message: 'The email address is required and can\'t be empty'
		                },
		                emailAddress: {
		                    message: 'The input is not a valid email address'
		                }
		            }
		        },
		        pwd: {
		            validators: {
		                notEmpty: {
		                    message: 'The password is required and can\'t be empty'
		                }
		            }
		        },
		       repwd:{
		    	   
		    	   
		    	   validators: {
		                callback: {
		                    message: 'Wrong answer',
		                    callback: function (value, validator, $field) {
		                        // Determine the numbers which are generated in captchaOperation
		                         
		                        alert($("[name=pwd]").val()+":"+ $("[name=pwd]").val());
		                        if($("[name=pwd]").val() == $("[name=pwd]").val())
		                	{
		                	alert ("match");
		                	//return true;
		                	}else{

		                    	alert ("no match");
		                		//return false;
		                	}
		             
		                        var items = $('#captchaOperation').html().split(' '),
		                            sum   = parseInt(items[0]) + parseInt(items[2]);
		                        return value == sum;
		                    }
		                }
		            }
		        }
		       
		    }
		});
		
		/* $('document').ready(function(){	
			$("#percentage").blur(function (e) {
				 if(+this.value >= 100){
				         $("#per-msg").html("Enter less than 100").show().fadeOut("slow");
				       $(this).val(99.00)
				     }
				  else{
				   $(this).val(parseFloat(this.value).toFixed(2));
				  }
				});
			}); */
	</script>
</body>
</html>
