<!DOCTYPE html>
<%@page import="java.util.Calendar"%>
<%@page import="com.nacre.online_assesment.db_util.DbUtil"%>
<%@page import="com.nacre.online_assesment.util.DateUtil"%>
<%@page import="com.nacre.online_assesment.form_bean.PersonalDetailsBean"%>
<%@page import="com.nacre.online_assesment.form_bean.EducationlDetilasBean"%>
<%@page import="org.apache.poi.ss.util.SSCellRange"%>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>PERSONAL-REGISTRATION-PAGE</title>

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
	href="<%=application.getContextPath() %>/assets/css/jquery-ui.min.css"/>
<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assets/css/jquery.validate.min.js"/>
<!-- <script src="../jQuery/jquery.js"></script>
<script src="../jQuery/jquery-ui.js"></script>
 -->
<link rel="stylesheet" href="<%=application.getContextPath() %>/assets/css/formValidation.css">
<script type="text/javascript">
var countryId=0;
var stateId=0;
var cityId=0;

</script>
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
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">Registration</span>
							</h1>
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
											Personal Details
										</h4>
										<div class="hero-unit">
											<div class="space-6"></div>
<%-- <%
Object o =session.getAttribute("personalDetailsBean");
if(o==null){
%> --%> 
											<form  id='reg-form'
												name="form" method="post"
												action="<%=application.getContextPath() %>/StudentRegistrationAction"
												 enctype="multipart/form-data">
												
													<fieldset>
													<input type="hidden" name="identity" value="1">
													<div class="form-group">
															<label class="block clearfix"> <span
																class="block input-icon input-icon-right"><b>FirstName:<span style="color:red;">*</span><span id="fname-msg"></span></b><input
																	type="text" class="form-control"
																	placeholder="EX-SUNIL KUMAR" name="fname" id="fname"/> <i
																	class="ace-icon fa fa-user"></i>
															</span>
															
															</label>
														</div>
	<div class="form-group">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>LastName:<span style="color:red;">*</span><span id="lname-msg"></b><input
																type="text" class="form-control" placeholder="EX-Maharana"
																name="lname" id="lname"/> <i class="ace-icon fa fa-user"></i>
														</span>
							
														</label> 
														</div>
														<span style="color: red;" id="lerrors"> </span> 
														
 														<%
														String emailStatus=request.getParameter("emailStatus");
														String msg=request.getParameter("msg");
														if(emailStatus!=null && msg!=null)
														{
														%>
														<%="<b style='color:red;'>"+emailStatus+"</b>"%>
														<br>
														
														<%="<b style='color:red;'>"+msg+"</b>" %>
														<%
														}
														%>
														<div class="form-group">
														<label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>Email-Id:<span style="color:red;">*</span><span id="email-msg"></span></b><input
																type="email" class="form-control" placeholder="Ex-nacre2016@gmail.com"
												required="required"		name="email" id="email"/> <i class="ace-icon fa fa-envelope"></i>
														</span>
														</label> 
														</div>
														<div class="form-group">
														<span style="color: red;" id="emailerrors"></span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Password:<span style="color:red;">*</span><span id="password-msg"></span></b> <input
																type="password" class="form-control" required="required"
																placeholder="Ex-12abc45" name="pwd" id="pwd"/> <i
																class="ace-icon fa fa-lock"></i>
														</span>
														</label> 
														</div>
														<div class="form-group">
														<span style="color: red;" id="perrors"></span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Re-type Password:<span style="color:red;">*</span><span id="repassword-msg"></span></b> <input
																type="password" class="form-control" required="required"
																placeholder="Ex-12abc45" name="repwd" /> <i
																class="ace-icon fa fa-lock"></i>
														</span>
														</label>
														</div>
														<div class="form-group">
														<span style="color: red;" id="rerrors"> </span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Mobile No:<span style="color:red;">*</span><span id="mobile-msg"></span></b> 
															<input
																type="text" class="form-control"
																placeholder="Ex-7735211178" name="mobileno"required="required"
																id="mobileno" /> <i class="ace-icon fa fa-phone"></i>
														</span>
														</label> 
														</div>
														<span style="color: red;" id="moberrors"> </span>
														<div class="form-group">
														 <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>Date of birth:<span style="color:red;">*</span></b><input
																class='form-control' type='text' id='datepicker' placeholder="07/30/1994" required="required"
																name="dob"> <i class="ace-icon fa fa-calender"></i>
														</span>
														</label>
														
														</div>
														<div class="form-group">
														 <label class="block clearfix" >  <b>Gender:<span style="color:red;">*</span></b>
															<b>Male</b><input
																type="radio" name='gender' value='1' checked="checked">
																<b>Female</b><input type="radio" name='gender'  value='0' required="required">
														
														</label> 
														
														</div>
														<div class="form-group">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right "> <b>Image:<span style="color:red;">*</span></b><input
																type="file" name='image' name="Image" class="form-control" required="required">
														</span>
														</label> 
														
														</div>
														<div class="form-group">
														<label class="block clearfix" style='color: blue'>
															<span class="block input-icon input-icon-right"><b>Enter
																Your Address Details: </b></span>
														</label>
														</div>
														<div class="form-group">
														 <label class="block clearfix"> <span
															class="block input-icon input-icon-right">
																<b>Country:<span style="color:red;">*</span></b><select name="country" id='country'
															class='form-control'	required="required">
                                                              
															</select>
														</span>
														</label> 
														</div>
														<div class="form-group">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right">
																<b>State:<span style="color:red;">*</span></b><select name="state" id='state'
															class='form-control'	required="required">
                                                             
															</select>
														</span>
														</label>
														</div>
														<div class="form-group">
                                                           <label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>City:<span style="color:red;">*</span></b><select
															class='form-control'	name="city" id='city' required="required">
                                                                     
											                  </select>
														</span>
														</label>

														</div>			
														<div class="form-group">											
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Location:<span style="color:red;">*</span></b><input type="text"
														class='form-control'	placeholder="Eg-Plot No-1/3/A,Hyd" name="location"
															required="required"> 
														</span>
														</label>
														</div>
														<div class="form-group">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"><b> PinCode:<span style="color:red;">*</span></b><input type="text" placeholder="Eg-754006"
														class='form-control'	name="pin" required="required">
														</span>
														</label>
														</div>
													</fieldset>
												

												<div class="space"></div>

												<div class="clearfix">
													<div>
														
															<button type="submit" class="width-25 pull-right btn btn-sm btn-primary">
															<span id="submit">Next</span>

															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>

													<button type="reset"
														class="width-25 pull-left btn btn-sm btn-primary">
														<i class="ace-icon fa fa-refresh"></i> <span
															>Reset</span>
													</button>
												</div>
												
											</form>
<%--  <%
 }else{
	
	PersonalDetailsBean pb= (PersonalDetailsBean)o;

	System.out.print("jspBean : "+pb);
	%>

<script type="text/javascript">
countryId="<%=pb.getCountry()%>";
cityId="<%=pb.getCity()%>";
stateId="<%=pb.getState()%>";
</script>
											<form  id='reg-form'
												name="form" method="post"
												action="<%=application.getContextPath() %>/StudentRegistrationAction"
												 enctype="multipart/form-data">
												
													<fieldset>
													<input type="hidden" name="identity" value="1">
													
															<label class="block clearfix"> <span
																class="block input-icon input-icon-right"><b>FirstName:<span style="color:red;">*</span></b><input
																	type="text" class="form-control"
																	placeholder="EX-SUNIL KUMAR" name="fname" value="<%=pb.getFirstname()%>" /> <i
																	class="ace-icon fa fa-user"></i>
															</span>
															</label>
														

														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>LastName:<span style="color:red;">*</span></b><input
																type="text" class="form-control" placeholder="EX-Maharana"
																name="lname" value="<%=pb.getLastname()%>" /> <i class="ace-icon fa fa-user"></i>
														</span>
														</label> <span style="color: red;" id="lerrors"> </span> 
														
														<%
														String emailStatus=request.getParameter("emailStatus");
														String msg=request.getParameter("msg");
														if(emailStatus!=null && msg!=null)
														{
														%>
														<%="<b style='color:red;'>"+emailStatus+"</b>"%>
														<br>
														
														<%="<b style='color:red;'>"+msg+"</b>" %>
														
														<%} %>
														<label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>Email-Id:<span style="color:red;">*</span></b><input
																type="email" class="form-control" placeholder="Ex-nacre2016@gmail.com"
												              value="<%=pb.getEmail()%>" name="email" /> <i class="ace-icon fa fa-envelope"></i>
														</span>
														</label> <span style="color: red;" id="emailerrors"></span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Password:<span style="color:red;">*</span></b> <input
																type="password" class="form-control"  value="<%=pb.getPassword()%>"
																placeholder="Ex-12abc45" name="pwd" /> <i
																class="ace-icon fa fa-lock"></i>
														</span>
														</label> <span style="color: red;" id="perrors"></span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Re-type Password:<span style="color:red;">*</span></b> <input
																type="password" class="form-control"
																placeholder="Ex-12abc45" name="repwd"  value="<%=pb.getPassword()%>"/> <i
																class="ace-icon fa fa-lock"></i>
														</span>
														</label><span style="color: red;" id="rerrors"> </span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Mobile No:<span style="color:red;">*</span></b> <input
																type="text" class="form-control" value="<%=pb.getMobileNo()%>"
																placeholder="Ex-7735211178" name="mobileno"
																id="mobileno" /> <i class="ace-icon fa fa-phone"></i>
														</span>
														</label> <span style="color: red;" id="moberrors"> </span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>Date of birth:<span style="color:red;">*</span></b><input
																class='form-control' type='text' id='datepicker' placeholder="07/30/1994"
														<%=DateUtil.SqlDateToString(pb.getDob(),"MM/dd/yyyy") %>		name="dob"> <i class="ace-icon fa fa-calender"></i>
														</span>
														</label> <label class="block clearfix" >  <b>Gender:<span style="color:red;">*</span></b>
															<b>Male</b>
															<%if(pb.getGender()==1){ %>
														
															<input
																type="radio" name='gender' value='1' checked="checked">
																<%}
															else{%>
															<input
																type="radio" name='gender' value='1' >
															
															<%} 
															if(pb.getGender()==0){ %>
															<input
																type="radio" name='gender' value='0' checked="checked" >
																<%}else{ %>
																<b>Female</b><input type="radio" name='gender'  value='0'>
														<%} %>
														</label> <label class="block clearfix"> <span
															class="block input-icon input-icon-right "> <b>Image:<span style="color:red;">*</span></b><input
																type="file" name='image' name="Image" class="form-control">
														</span>
														</label> <label class="block clearfix" style='color: blue'>
															<span class="block input-icon input-icon-right"><b>Enter
																Your Address Details: </b></span>
														</label> <label class="block clearfix"> <span
															class="block input-icon input-icon-right">
																<b>Country:<span style="color:red;">*</span></b>
																<select name="country" id='country'
															class='form-control'	required="required">
<option disable selected>--Select Country--</option>
															</select>
														</span>
														</label> <label class="block clearfix"> <span
															class="block input-icon input-icon-right">
																<b>State:<span style="color:red;">*</span></b><select name="state" id='state'
															class='form-control'	required="required">
                                                     <option disable selected>--Select State--</option>
															</select>
														</span>
														</label>
                                                           <label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>City:<span style="color:red;">*</span></b><select
															class='form-control'	name="city" id='city' required="required">
                                                                     <option disable selected>--Select City--</option>
											                  </select>
														</span>
														</label>
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Location:<span style="color:red;">*</span></b><input type="text"
														class='form-control'	placeholder="Eg-Plot No-1/3/A,Hyd" name="location"
													value='<%=pb.getLocation() %>'		required="required"> 
														</span>
														</label>
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"><b> PinCode:<span style="color:red;">*</span></b><input type="text" placeholder="Eg-754006"
														class='form-control'	name="pin" required="required"value="<%=pb.getPin()%>" >
														</span>
														</label>
													</fieldset>
												

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
												
											</form>
<%} %>
 --%>
										</div>
									</div>
									<!-- .widget-main -->

								</div>
								<!-- .widget-body -->
							</div>
							<!-- login-box -->

						</div>
						<!-- /.position-relative -->


					

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
	<script type="text/javascript"
		src="<%=application.getContextPath() %>/assets/js/jquery.validate.min.js"></script>

	
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
	<!-- inline scripts related to this page -->
	
    <script type="text/javascript" src="<%=application.getContextPath() %>/assets/js/formValidation.js"></script>
    
    <script type="text/javascript" src="<%=application.getContextPath() %>/assets/js/framework/bootstrap.js"></script>
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

		/** Date Picker*/
<%
Calendar cal=Calendar.getInstance();
	int year=cal.get(Calendar.YEAR);
	request.setAttribute("year", year);
%>
var year='<%=year%>';
var minYear=year-19;

		$(function() {
			$("#datepicker").datepicker({
				changeMonth: true,
	            changeYear: true,
	            showButtonPanel: true,
	            yearRange: '1980:'+minYear,
	            onSelect: function () {
	                $('#datepicker').text(this.value);
	            } 
	        });
			
		});
		
		
		// country ajax call
		$('document').ready(function(){		
				var obj={
					url:"<%=application.getContextPath() %>/GetCountryAction",
					
					success:function(country){
					
						$("#country").empty();
						$("#country").append("<option value=''>--Select Country--</option>");
						for (var ind = 0; ind < country.length; ind++) {
							//if(countryId!=0 && countryId==country[ind].countryId){
							//$("#country").append("<option selected value='"+country[ind].countryId+"'>"+country[ind].country+"</option>");
							//}
							//else{
								$("#country").append("<option value='"+country[ind].countryId+"'>"+country[ind].country+"</option>");	
							//}
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
							//if(sityId!=0 && sityId== state[ind].stateId){
							//$("#state").append("<option selected value='"+state[ind].stateId+"'>"+state[ind].state+"</option>");
							//}else{
								$("#state").append("<option  value='"+state[ind].stateId+"'>"+state[ind].state+"</option>");
									
							//}
							
						
							
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
							//if(cityId!=0 && cityId==city[ind].cityId){
							//$("#city").append("<option selected value='"+city[ind].cityId+"'>"+city[ind].city+"</option>");
							//}
							//else{
								$("#city").append("<option value='"+city[ind].cityId+"'>"+city[ind].city+"</option>");
							//}
						
							
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
			
			
			$('#reg-form')
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
			                },  regexp: {
			                    regexp: /^[a-zA-Z0-9][a-zA-Z0-9._]{3,}[@]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,}([.]{1}[a-zA-Z0-9]{2,}){0,}$/,
			                    message: 'EMAIL FORMAT IS INVALID'
			                }
			                /* ,
			                emailAddress: {
			                    message: 'The input is not a valid email address'
			                } */
			            }
			        },
			        pwd: {
			            validators: {
			                notEmpty: {
			                    message: 'The password is required and can\'t be empty'
			                },
			                stringLength: {
			                    min: 8,
			                    max: 30,
			                    message: 'The Last Name must be more than 7 and less than 30 characters long'
			                }
			            }
			          
			        },
			       repwd:{
			    	   validators: {
			    		   identical: {
			                    field: 'pwd',
			                    message: 'The password and its confirm are not the same'
			                },stringLength: {
			                    min: 8,
			                    max: 30,
			                    message: 'The Last Name must be more than 2 and less than 30 characters long'
			                }
	                    }
                    },
                    mobileno:{
                    	 validators: {
                             phone: {
                                 country: 'IN',
                                 message: 'The value is not valid %s phone number'
                             },
			                regexp: {
			                    regexp:/^[7-9][0-9]{9}$/,
			                    message: 'The MOBILE NO SHOULD START WIT 7 OR 8 OR 9'
			                },stringLength: {
			                    min: 10,
			                    max: 10,
			                    message: 'PLEASE ENTER 10 DIGITS MOBILE NO'
			                }
                         }
                    },
                    pin: {
                        validators: {
                            regexp: {
                                regexp: /^\d{6}$/,
                                message: 'The IN zipcode must contain 6 digits'
                            }
                        }
                    }
			       
			    }
			});

</script>			
</body>
</html>
