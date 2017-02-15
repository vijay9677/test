

<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@page import="com.nacre.online_assesment.util.StringConstants"%>
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

		<title>Home - Student</title>

		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>

<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/bootstrap-select.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/select2.min.css">
<style>
#companytext
{

float:left;
margin-left: 5px;
text-align: center;
}
#citytext
{

float:left;
margin-left: 5px;
text-align: center;
}
#locationtext
{

float:left;
margin-left: 5px;
text-align: center;
}
/* body {
	padding-top: 70px;
	margin-left: 30px;
}
 */
.dpdw {
	width: 200px;
}

textarea#feedbacktext {
    width: 200%;
}



</style>
		
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/student_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
 

<div>

	<form onsubmit="return checkvalidity();" action="${pageContext.request.contextPath}/SendFeedbackAction" method="post">
	

		<!-- menu feedback -->
		<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Give FeedBack</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
		
		<div class='row' style="width:100%;padding-left:2%;;padding-top:2%;padding-bottom:21%;background-image: url('<%=StringConstants._SEND_FEEDBACK_BACKGROUND%>');">
         
			<label style="float:left">
			 <select id="feedback"
			  onchange='successMsgHide()' class="selectpicker" data-hide-disabled="true" data-live-search="true"
				name="feedback">
			</select>
			<div id="feedbackvalidation" class='bg-danger' style="display:none;text-align: center">
			 <p>Please Select Your Feedback Type</p>
			 </div>
			</label> 
			
			<label id='address-wrapper' class="address">
			<div id="companytext">
			 <select id="company"
class="selectpicker" data-hide-disabled="true" data-live-search="true" name="company">
			</select>
			<p id="co" class='bg-danger' style="display:none;">please select company</p>
			</div>
			
			<div id="citytext">
			 <select id="clientAddress" class="selectpicker" data-hide-disabled="true"
				data-live-search="true" name="clientaddress">
			</select> 
			<p id="ci" class='bg-danger' style="display:none;">please select city</p>
			 </div>
			 
			 <div id="locationtext">
			<select id="clientlocation" onchange='hidemsg()' class="selectpicker" data-hide-disabled="true" 
				data-live-search="true" name="clientlocation">

			</select>
			<p id="lo" class='bg-danger' style="display:none;">please select location</p>
			</div>
			</label>

		</div>
		<br/>
		<div class='row'>
			<div class='row'>
				<div class="form-group col-sm-12">
				<!-- 	<label for="comment">FeedBack:</label> -->
					<p id="withoutdata"  class='bg-danger' style="display:none;" > Please write your feedback</p>
					<p id="lessthaneight" class='bg-danger'style="display:none;">Your feedback should be more than 8 characters</p>
					<textarea placeholder="Please Give Your Valuable Feedback..." style='width:97%;' class="form-control" rows="10" name="feedback-text" id="feedbacktext"></textarea>
					
				</div>
			</div>
			<div class='row'>
              <div class='col-md-12' style="text-align:center">
				<button class='btn btn-primary' id='submit'>Submit</button>
			</div>
			</div>
<hr/>
		</div>
		</form>



</div>
<% Integer msg=(Integer)session.getAttribute("value");
     if(msg!=null){%>
     <% if (msg == 1) { %>
                 <div class="row">
			<div class="col-md-12" style="text-align: center; padding-top: 5px;">
				<!-- This Div for using Success_Msg display -->
				<div class='alert alert-success fade in' style='text-align: center;'>
					<a href='#' class='close' data-dismiss='alert'>&times;</a>
					 <strong>Success!!!</strong> "Your feedback has been sent succesfully"<br>
					                      <p>Thanks! We appreciate that you've taken the time to write us.</p>
					</div>
				<div id='success-msg' class="success_msg" style="width: 40%;">
				</div>
			</div> 
<% } else { %>
     <div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->
				
				<div class='alert alert-danger fade in' style='text-align: center;'>"
					<a href='#' class='close' data-dismiss='alert'>&times;</a>"
					 <strong>Failure!!!</strong> Your Feedback has been Not received Please try again later ..."
					</div>
				
				
				<div id="error-msg" class="alert_msg" style="width: 40%;"></div>
			</div>
		</div>
<% } %>
     <% session.removeAttribute("value");
     }%>

<% Integer message=(Integer)session.getAttribute("value");
     if(message!=null){%>
     <% if (message == 1) { %>
                 <div class="row" id='successMsg1'>
			<div class="col-md-12" style="text-align: center; padding-top: 5px;">
				<!-- This Div for using Success_Msg display -->
				<div class='alert alert-success fade in' style='text-align: center;'>
					<a href='#' class='close' data-dismiss='alert'>&times;</a>
					 <strong>Success!!!</strong> "Your feedback has been sent succesfully"<br>
					                      <p>Thanks! We appreciate that you've taken the time to write us.</p>
					</div>
				<div id='success-msg' class="success_msg" style="width: 40%;">
				</div>
			</div> 
<% } else { %>
     <div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->
				
				<div class='alert alert-danger fade in' style='text-align: center;'>"
					<a href='#' class='close' data-dismiss='alert'>&times;</a>"
					 <strong>Failure!!!</strong> Your Feddback has been Not received Please try again later ..."
					</div>
				
				
				<div id="error-msg" class="alert_msg" style="width: 40%;"></div>
			</div>
		</div>
<% } %>
     <% session.removeAttribute("value");
     }%>




<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>

<script type="text/javascript" src="${path}/assets/js/gajananNotificationsJobpost.js"></script>
<script type="text/javascript" src="${path}/assets/js/ManishStudentNotifications.js"></script>

<script src="<%=application.getContextPath()%>/js/jquery-ui.js"></script>
<script src="<%=application.getContextPath()%>/js/bootstrap-select.js"></script>
<script src="<%=application.getContextPath()%>/js/select2.full.js"></script>

<script>

function successMsgHide(){
	
	$('#successMsg1').empty();
}

</script>

<script>

function hidemsg()
{
	$('#lo').hide();
	}
</script>

<script>
	$('document').ready(function(){
aj();
		$("#address-wrapper").hide();
		 var feedback1="<option value=0>-Select Your Feedback-</option>"
		 
		 $.ajax({	 
			url:"<%=application.getContextPath()%>/<%=URLConstants.GET_FEEDBACK%>",
			 dataType:'json',
			 success:function(data){
				 //alert("ajax"+JSON.stringify(data));
				 
				 $.each(data,function(index){
					 
					 debugger;
					 feedback1=feedback1+"<option value='"+data[index].feedbackTypeId+"'>"+data[index].feedbackType+"</option>";  
				
				 $("#feedback").html(feedback1);
				
				 });
				 
				 $('#feedback').on("change",function(){
						
				 if($(this).val()==0)
					{
						$("#address-wrapper").hide();
					}
			
				 
				 });
				 $("#feedback").selectpicker('refresh');

			},
			 error:function(){
				 
			 }
			
			 
		 });
		 
		 
		  
			$('#feedback').on("change",function(){
				
				if($(this).val()==1)
				{
					$("#address-wrapper").hide();
				}
				else{
					
					aj();
					$("#address-wrapper").show();
						

					$('#clientlocation').html("");
					$('#clientAddress').html('');
				}		
				
			});
			 
			 
	});

	
	function aj(){

			
		 $.ajax({
			 url:"<%=application.getContextPath()%>/<%=URLConstants.GET_COMPANY%>",
					dataType : 'json',
					success : function(data) {
						
						
						company1 = "<option value=''>-Select company-</option>";
						$("#feedbackvalidation").hide();
						$('#clientlocation').html("");
						$('#clientAddress').html('');
							
						
						$('#clientAddress').append("<option value=''>-Select City-</option>");
						$('#clientlocation').append("<option value=''>-Select location-</option>");
						 
						
						
						for(var index=0; index<data.length; index++) {
							

							company1 = company1
									+ "<option value='"+data[index].clientId+"'>"
									+ data[index].clientName + "</option>";
						}
						
						$("#company").html(company1);
					
						 $("#company").selectpicker('refresh');

	
	add();	
 

					},
					error : function() {

					}

				});

		
	  $(".chosen-select").select2();


		  
		

	}
	
	
	function addr(){
		
		$('#clientAddress').change(function(){
			$('#clientlocation').html("");
			$('#clientlocation').append("<option value=''>-Select location-</option>");
			
			var sId=	$('#clientAddress').val();
			var cId=	$('#company').val();
			//$('#clientlocation').html("");
			
				$.ajax({
					
					 url:"<%=application.getContextPath()%>/<%=URLConstants.GET_COMPANIES_LOCATIONS%>",					
					data:{"cityId":sId,"clientId":cId},
					success:function(cities){
						$("#ci").hide();
						$('#clientlocation').empty();
						$('#clientlocation').append("<option value=''>-Select location-</option>");
						for (var ind = 0; ind < cities.length; ind++) {
							
							$('#clientlocation').append("<option   value='"+cities[ind].addressId+"'>"+cities[ind].location+"</option>");	
							
						}
						 $("#clientlocation").selectpicker('refresh');

						
					},
					error:function(){
						
						/* alert("please select city ajax"); */
					}
					
				});
			});
		$('#clientAddress').select2('refresh');
		
	}
	
	function add(){
		
		$('#company').change(function(){
			var sId=	$('#company').val();
			var citiees=new Array();
			

			$('#clientlocation').html("");
			$('#clientAddress').html('');
			$('#clientAddress').append("<option value=''>-Select City-</option>");
			$('#clientlocation').append("<option value=''>-Select location-</option>");
			$.ajax({
					url:"<%=application.getContextPath()%>/<%=URLConstants.GET_COMPANY_ADDRESS%>",
					data:{"clientId":sId},
					success:function(cities){
						 $("#co").hide();
						$('#clientAddress').empty();
						$('#clientlocation').empty();
						$('#clientAddress').append("<option value=''>-Select City-</option>");
						$('#clientlocation').append("<option value=''>-Select location-</option>");

						for (var ind = 0; ind < cities.length; ind++) {
							if(citiees.indexOf(cities[ind].city)<0){
								
							$('#clientAddress').append("<option   value='"+cities[ind].cityid+"'>"+cities[ind].city+"</option>");	
							citiees.push(cities[ind].city);
							
							}
							
						}
						 $("#clientAddress").selectpicker('refresh');

						addr();
					},
					error:function(){
						
						/* alert("please select company ajax"); */
					}
					
				});
			});
		
		

		
	
	}
			</script>

         <script>
			
				
         function checkvalidity() {
			    	
			    	var val=true;
			        var typeoffeedback=document.getElementById('feedback').value;
			        
			        $("#feedbackvalidation").hide();
			        $("#co").hide();
			        $("#ci").hide();
			        $("#lo").hide();
			        $("#withoutdata").hide();
			        $("#lessthaneight").hide();
			        if(typeoffeedback==0){
			        	//alert("please select feedbacktype");
			        	 $("#feedbackvalidation").show();
			        	 
			        	val=false;
			        }
			        if(typeoffeedback==2){
			        var companyname = document.getElementById('company').value;
			        var clientAddressname = document.getElementById('clientAddress').value;
			        var clientlocationname = document.getElementById('clientlocation').value;

			        if (companyname.length == 0) {
			            //alert("Please select company");
			            $("#co").show();
			            
			            val=false;
			            
			        }

			        else if (clientAddressname.length == 0) {
			        	$("#ci").show();
			            //alert("Please select city");
			            val=false;
			          
			        } else if (clientlocationname.length == 0) {
			        	$("#lo").show();
			            //alert("Please select location");
			            val=false;
			        }   
			        else{
			        	
			        	
			        }
			        }
			        if(typeoffeedback!=0){
			        	if(val==true){
			        var feedbackLength=document.getElementById("feedbacktext").value.length;
			            
			        if(feedbackLength==0){
			        	 $("#withoutdata").show();
			        	//alert("please provide data");
			        	val=false;
			        }
			        else{
			        	if(feedbackLength<=8){
			        		$("#lessthaneight").show();
			        		//alert("please provide more than 8 characters");
			        		val=false;
			        	}
			        }
			        	}
			        }
			        return val;
         }
			    
			
			    
			    
		
			
			</script>
			
			
			
			

</body>

</html>