
<!-- @author RAKESH -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="com.nacre.online_assesment.util.StringConstants"%>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<!-- bootstrap & fontawesome -->
<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="Nacre Software Services Assesment"  />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<title>Change Password</title>
		<jsp:include page="../jsp/common/common_css.jsp"></jsp:include>
<style type="text/css">
div#login-box {
    box-shadow: 1px 2px 4px 2px rgba(26, 28, 35, 0.5);
}
</style>
</head>
	<body class="no skin">
	<div class="main-container" id="main-container">
	<%

if(StringConstants._STUDENT_ROLE_ID==(Integer)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID))
{
%>
<jsp:include page="./common/student_header.jsp"></jsp:include>
<jsp:include page="./common/student_menu.jsp"></jsp:include>
<% 
}
else if(StringConstants._ADMIN_ROLE_ID==(Integer)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID))
	{%>
	<jsp:include page="./common/special_admin_header.jsp"></jsp:include>
	<jsp:include page="./common/admin_menu.jsp"></jsp:include>
	
	<% }
	else if(StringConstants. _HR_ROLE_ID==(Integer)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID))
	{%>
	<jsp:include page="./common/hr_header.jsp"></jsp:include>
	<jsp:include page="./common/hrdepartment_menu.jsp"></jsp:include>
	<%} 
	else if(StringConstants._CORPORATE_ROLE_ID ==(Integer)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID))
	{%>
	<jsp:include page="./common/corporate_relation_header.jsp"></jsp:include>
	<jsp:include page="./common/corporaterelation_menu.jsp"></jsp:include>
	<%}
	else if(StringConstants. _TECHINICAL_ROLE_ID==(Integer)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID))
	{%>
	<jsp:include page="./common/technical_Team_header.jsp"></jsp:include>
	<jsp:include page="./common/technicalteam_menu.jsp"></jsp:include>
	<%} 
	else if(StringConstants._SYSTEM_ROLE_ID==(Integer)session.getAttribute(StringConstants._SESSION_USER_ROLE_ID))
	{%>
	<jsp:include page=".//common/viewopportunityheader.jsp"></jsp:include>
	<jsp:include page="./common/systemadmin_menu.jsp"></jsp:include>
	<%}%>





<div class="main-content">
				<div class="main-content-inner">
				
			

					<div class="page-content">
					
				
								<!--Separetor start-->
								<!--Separetor end-->					
									<h4>
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Change Password</b> 
									 
								</h4>
		<!--Separetor start-->
		<!--Separetor end-->
								

						<div class="row">
						<div class="col-xs-3"></div>
	<div class="col-xs-6">
								<!-- PAGE CONTENT BEGINS -->

									<!--
									 @author Rakesh kumar
									 this tag is created to display the error msg when the user enters the wrong password in the changepassword 
									 page
									 -->						
	<div>									<% String message3 = (String)session.getAttribute("changepwd-message3");
											if(message3!=null)
														{					
														%>
														<center>
									<h3><span style="color:red"><%=message3 %></span><h3>
									</center>
									<%
										
														session.removeAttribute("changepwd-message3");
														} %>
								<!-- <h4 class="blue" id="id-company-text"></h4> -->
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Please Enter Your Password Information
											</h4>

											<div class="space-6"></div>

											<form id="changepwdform" action="<%=application.getContextPath()%>/ChangePasswordAction" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
																										
		<input name='oldpwd' id='oldpwd'  type="password" class="form-control" placeholder="Enter Old Password" /><span class='status'></span>
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
		<input id='newpwd' name='newpwd'  type="password" class="form-control" placeholder="Enter New Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
		<input id='confirmpwd' name='confirmpwd' type="password" class="form-control" placeholder="Confirm Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<!--  <label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> Remember Me</span>
														</label>	-->

														<!--  <button type="button" class="width-35 pull-right btn btn-sm btn-primary">	-->
															
															<span class="bigger-110" ><input type="submit" value='submit' class="width-35 pull-right btn btn-sm btn-primary"></span>
														<!--  </button>		-->
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>
</div>
</div>
							</div><!-- /.position-relative -->

<!-- 						</div>
					</div>/.col
				</div>/.row
			</div>/.main-content
		</div>/.main-container

 --><jsp:include page="./common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="./common/footer.jsp"></jsp:include>

<jsp:include page="./common/common_js.jsp"></jsp:include>	


	

		<script src="${path }/assets/js/jquery.validate.min.js"></script>
<script src="${path }/assets/js/additional-methods.min.js"></script>	
<script>


/* 
 
 @author Rakesh kumar
 The below code is given to check whether the old password field is blank or not
 & it also checks whether the new password matches to the confirm password or not
 
 */
	
$(document).ready(function($){
	$("#changepwdform").validate({
		rules:{
			oldpwd:'required',
			newpwd: 
			   {
			   required:true,
			   minlength:8,
			   maxlength:15
			   },
			confirmpwd:
				{
				required:true,
				equalTo:'#newpwd'
				}
			},
		messages:{
			oldpwd:"plz enter old password",
			newpwd:""+"("+"minimum 8-15 characters"+")",
			confirmpwd:"plz enter the same password"
			}
		});
});		

</script>

<!-- 
<script src="jquery.js" type="text/javascript"></script> -->
	<script type="text/javascript">
	/*
	
	@author Rakesh kumar
	The below code checks whether the old password is available or not in the database, if not available 
	it display a error image
	
	*/
          $(document).ready(function(){
              $("#oldpwd").change(function(){
                  var uname = $(this).val();
                  //alert(uname);
                  if(uname.length >= 3){
                      $(".status").html("<img src='<%=application.getContextPath()%>/images/loading.gif'><font > Checking availability...</font>");
                       $.ajax({
                          type: "POST",
                          url: "<%=application.getContextPath()%>/Availability",
                          data: {"password": uname},
                          success: function(msg){

                              $(".status").ajaxComplete(function(event, request, settings){
                                   

                              });

                              $(".status").html(msg);
                          },
                          error:function(){
                        	  alert("err");
                          }
                      }); 
                  }
                  else{
                       
                      $(".status").html("<font color=red>Username should be <b>3</b> character long.</font>");
                  }
                  
              });
          });
        </script>
		
		</body>
</html>