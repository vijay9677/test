<%@page import="com.nacre.online_assesment.form_bean.EducationlDetilasBean"%>
<%@page import="java.util.Calendar" %>
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
<!-- <script src="../jQuery/jquery.js"></script>
<script src="../jQuery/jquery-ui.js"></script>
 -->
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

<body class="login-layout" style="width: 89%">
	<!-- alignment adjusting -->
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

						<div class="space-6"></div>

						<div class="position-relative" style="width: 130%">
							<!-- size adjusting -->
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> Please Enter Your
											Graduation Details
										</h4>
										<div class="hero-unit">
											<div class="space-6"></div>

											<form
												action="<%= application.getContextPath()%>/StudentRegistrationAction"
												id='gdform'name="form"  method="post">
												<div>

													<!-- ---------Educational details-----------   -->
													<!-- <center style='color: blue'>
														<b>Enter Your Graduation Details</b>
													</center> -->
		<input type="hidden" name="identity" value="3">	
		
														<div class="form-group">										 
<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <b>Stream:<span style="color:red;">*</span></b><select
															id="stream" name="graduationStrem" class='form-control'
															required="reqiured">

														</select>
													</span>
													</label>
													
													</div>
													
														<div class="form-group">
													 <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <b>Year
																Of Pass:<span style="color:red;">*</span></b><select name="graduationPassing" required="required"
															class='form-control'><option disable selected>Select
																	year</option>
																<%
																Calendar cal=Calendar.getInstance();
																int year=cal.get(Calendar.YEAR);
																EducationlDetilasBean	intermediateDetailsBean	=(EducationlDetilasBean)session.getAttribute("intermediateDetailsBean");
																int interPassing=intermediateDetailsBean.getYearOfPass();
																int graduationPassing=interPassing+3;
							for(int i=graduationPassing;i<=year;i++){
								%>
																<option><%=i %></option>
																<% 
							}
							%>

														</select>

													</span>
													</label>
													</div>
													
														<div class="form-group">
													 <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <b>Percentage:<span style="color:red;">*</span></b><input
															type="text" placeholder="Eg-60.45" name="graduationPercentage"
															required="required" class='form-control'>

													</span>
													</label> 
													
													</div>
													
														<div class="form-group">
													<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <b>University:<span style="color:red;">*</span></b><select
															id="univ" name="graduationUniv" class='form-control'>

														</select>
														
														
													</span>
													</label> 
													
													</div>
													
														<div class="form-group">
															<div id="add-Univ"></div>
															
															
															<div id="college-div">
													<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <b>College:<span style="color:red;">*</span></b><select
															id="college" name="graduationCollege" class='form-control'>

														</select>
														
													</span>
													</label> 
													</div>
													
													
													<div id="add-College"></div>
													</div>
													
														<div class="form-group">
													<label class="block clearfix" style='color: blue'>
														<span class="block input-icon input-icon-right"><b>Enter
																College Address Details: </b></span>
												</label> 
												</div>
												
														<div class="form-group">
												<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <b>Country:<span style="color:red;">*</span></b><select
															name="gCountry" id="country" class='form-control'
															required="required">

														</select>
													</span>
													</label>
													</div>
													
														<div class="form-group">
													
													 <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <b>State:<span style="color:red;">*</span></b><select
															name="gState" id='state' class='form-control'
															required="required">

														</select>
													</span>
													</label> 
													
													
														<div class="form-group">
													<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <b>City:</b><select
															class='form-control' name="gCity" id='city'
															required="required">

														</select>
													</span>
													</label> 
													
													</div>
													
														<div class="form-group">
													<label class="block clearfix"> <span
														class="block input-icon input-icon-right"><b>Location:<span style="color:red;">*</span></b><input
															type="text" class='form-control'
															placeholder="Eg-Plot No-1/3/A,Hyd" name="gLocation"
															required="required"> </span>
													</label>
													</div>
													
														<div class="form-group">
													
													 <label class="block clearfix"> <span
														class="block input-icon input-icon-right"><b>
																PinCode:<span style="color:red;">*</span></b><input type="text" placeholder="Eg-754006"
															class='form-control' name="gPin" required="required">
													</span>
													</label>
													</div>
													<!-- ---------End of Educational details-----------   -->

												</div>

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
								&nbsp; <span class="cyan">/</span> &nbsp; <a
									id="btn-login-light" href="#">Light</a> &nbsp; &nbsp; &nbsp;
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
		<script
			src="<%=application.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
			
    <script type="text/javascript" src="<%=application.getContextPath() %>/assets/js/formValidation.js"></script>
    
    <script type="text/javascript" src="<%=application.getContextPath() %>/assets/js/framework/bootstrap.js"></script>
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
					$('#id-text2').attr('class', 'cyan');
					$('#id-company-text').attr('class', 'cyan');

					e.preventDefault();
				});

			});
			
			
			/**retrieving  universities */
			$('document').ready(function(){
		
				
		var obj={
			url:"<%=application.getContextPath() %>/GetUnivercitySunilAction",
			
			success:function(univ){
				$("#univ").empty();
				$("#univ").append("<option value=''>--Select University--</option>");
				for (var ind = 0; ind < univ.length; ind++) {
					$("#univ").append("<option value='"+univ[ind].universityId+"'>"+univ[ind].universityName+"</option>");
						
				}

				$("#univ").append("<option value='0'>OTHERS</option>");
				//alert(univ);
				
			},
			error:function(){
				alert("please try later");
				
			}
			};
				
				$.ajax(obj);
			});

			/**retrieving colleges */
			
		$('document').ready(function(){
		 $("#univ").change(function(){
				var uid=$(this).val();
				//alert(uid);
		var obj={
			url:"<%=application.getContextPath() %>/GetCollegeAction",
			data:{"universityId":uid},
			success:function(college){
				$("#college").empty();
				$("#college").append("<option value=''>--Select College--</option>");
				for (var ind = 0; ind < college.length; ind++) {
					$("#college").append("<option value='"+college[ind].collegeId+"'>"+college[ind].college+"</option>");
			
				}
				$("#college").append("<option value='0'>OTHERS</option>");
				//alert(college);
				
			},
			error:function(){
				alert("please try later");
				
			}
			
			};
				
				$.ajax(obj);
							
			});	
	});
		// stream ajax call	
		$('document').ready(function(){
				
						
				var obj={
					url:"<%=application.getContextPath() %>/GetStreamAction.student",
					
					success:function(stream){
						$("#stream").empty();
						$("#stream").append("<option value=''>--Select Stream--</option>");
						for (var ind = 0; ind < stream.length; ind++) {
							$("#stream").append("<option value='"+stream[ind].streamId+"'>"+stream[ind].stream+"</option>");
								
						}
						//alert(country);
						
					},
					error:function(){
						alert("please try later")
						
					}
					
					};
						
						$.ajax(obj);
						
						
						
					});
		// country ajax call
		$('document').ready(function(){
				
						
				var obj={
					url:"<%=application.getContextPath() %>/GetCountryAction",
					
					success:function(country){
						$("#country").empty();
						$("#country").append("<option value=''>--Select Country--</option>");
						for (var ind = 0; ind < country.length; ind++) {
							$("#country").append("<option value='"+country[ind].countryId+"'>"+country[ind].country+"</option>");
								
						}
						//alert(country);
						
					},
					error:function(){
						alert("please try later")
						
					}
					
					};
						
						$.ajax(obj);
						
						
						
					});
				//ajax call for state
				
				$('document').ready(function(){
				 $("#country").change(function(){
						var cid=$(this).val();
						//alert(cid);
				var obj={
					url:"<%=application.getContextPath() %>/GetStateAction",
					data:{"countryId":cid},
					success:function(state){
						$("#state").empty();
						$("#state").append("<option value=''>--Select State--</option>");
						for (var ind = 0; ind < state.length; ind++) {
							$("#state").append("<option value='"+state[ind].stateId+"'>"+state[ind].state+"</option>");
							
							
						
							
						}
						//alert(state);
						
					},
					error:function(){
						alert("please try later")
						
					}
					
					};
						
						$.ajax(obj);
									
					});	
			});
			//ajax call for city
			$('document').ready(function(){
				 $("#state").change(function(){
						var sid=$(this).val();
						//alert(sid);
				var obj={
					url:"<%=application.getContextPath() %>/GetCityAction",
					data:{"stateId":sid},
					success:function(city){
						$("#city").empty();
						$("#city").append("<option value=''>--Select city--</option>");
						for (var ind = 0; ind < city.length; ind++) {
							$("#city").append("<option value='"+city[ind].cityId+"'>"+city[ind].city+"</option>");
							
							
						
							
						}
						//alert(city);
						
					},
					error:function(){
						alert("please try later")
						
					}
					
					};
						
						$.ajax(obj);
									
					});	
			});		
		//university disable

		
//add university
$('document').ready(function(){
				 $("#univ").change(function(){
						var uid=$(this).val();
						
					if(uid==0){
						$('#college-div').hide();
							$('#add-Univ').html("<b><span style='color:green'>Enter University:</span><span style='color:red'>*</span><b><input type='text' class='form-control'required='required' name='gaddUniv'>");
							
							$('#add-College').html("<b><span style='color:green'>Enter College:</span><span style='color:red'>*</span><b><input type='text' class='form-control'required='required' name='gaddCollege'>");
					}
					else if(uid!=0){
						$('#add-Univ').empty();	
						$('#add-College').empty();
						$('#college-div').show();	
						
					}
					
					});
});
		
		//add college
	$('document').ready(function(){
				 $("#college").change(function(){
						var cid=$(this).val();
						
					if(cid==0){
						//$('#add-College').show();
							$('#add-College').html("<b><span style='color:green'>Enter College:</span><span style='color:red'>*</span><b><input type='text' class='form-control' required='required' name='gaddCollege'>");
					}
					else if(cid!=0){
						$('#add-College').empty();	
					}
					
					});
});	
//button on click event
$('document').ready(function(){
				 $("#button").click(function(){
					 $('#add-Univ').empty();	
						$('#add-College').empty();
						$('#college').empty();
						$('#college-div').show();
						
					
					
					});
});	
		
//for go back
function goBack() {
window.history.back();
}


$('#gdform')
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
</script>



</body>
</html>
