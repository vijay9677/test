
<!---------------- @author vijayKumar P----------------------->
<!--@Description: this jsp using for retriving jobdetails and filtering students by their criteria  -->

<%@page errorPage="adminErrorPage.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page
	import="com.nacre.online_assesment.form_bean.ViewJobNotificationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>


<!DOCTYPE html>
<html lang="en">
<head>

<link rel="icon" href="assets/images/nacre/nacre.png"
	type="image/x-icon">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />

<meta name="description" content="Nacre Software Services Assesment" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<title>retrieving job and send notification to students</title>

<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>

<style type="text/css">
#studentsCount {
	display: none;
}

select#per {
	height: 40px;
}

.rowwd {
	
	position: relative;
	left: 280px;
	width:80%;
}

#uniqueId {

	position: absolute;
	bottom: 0;
	left: 0;
	right: 0;
	top: 0px;
	opacity: 0.5;
	background-color: #000;
	color: #fff;
	z-index: 9999;
}

.uniqueLoad {
	height: 100%;
	width: 100%;
	background-image:
		url('http://images2.layoutsparks.com/1/235919/walle-galaxy-sky-image.jpg');
}
</style>


<script lang="JavaScript">
	function toggle(source){
		checkboxes = document.getElementById('checkId');
		for (var checkbox in checkboxes)
		checkbox.checked = source.checked;
	}

</script>

</head>
<body class="no-skin">
	<div class="main-container" id="main-container">
		<!-- JAY NOTIFICATIONS HEADER  -->

<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/hrdepartment_menu.jsp"></jsp:include>		<%-- <jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include> --%>
		<!-- write your code here -->

		<!--------------------------------------------write your code here ----------------------------------->



		<!------------retrieving job notification printing job notification on the browser-------->

	<%
	//ViewJobNotificationBean viewJobNotificationBean=(ViewJobNotificationBean)session.getAttribute("jobdetails");
		ViewJobNotificationBean viewJobNotificationBean = (ViewJobNotificationBean) request.getAttribute("jobdetails");
	    
		
		HttpSession session2=request.getSession();
		session2.setAttribute("jobDetailsBean", viewJobNotificationBean);
	
	%>
	<% if (request.getAttribute("jobdetails") != null) {%>
		<!-- <div class="container" style="border:1px lightgray solid; box-shadow:5px 5px 5px lightgray;"> -->
					<div style='margin:auto; height:100px;'>
						<div class="col-sm-1">
							<img src="<%=viewJobNotificationBean.getClientLogo() %>"
							 class="img-rounded" alt="Company Logo" width="100" height="100">
						</div>
						<div class="col-sm-8">
						<div class='row'>
							Company Name:
							<%=viewJobNotificationBean.getCompanyName()%>
							CompanyLocation :
							<%=viewJobNotificationBean.getLocation()%>
							city name :
							<%=viewJobNotificationBean.getCity()%>
							Country name :
							<%=viewJobNotificationBean.getCountry()%>
							pincode :
							<%=viewJobNotificationBean.getPincode()%>
							Contact person name :
							<%=viewJobNotificationBean.getContatPersonName()%>
							Contact person mobile number :
							<%=viewJobNotificationBean.getContactPersonMobileNo()%>
							<%=viewJobNotificationBean.getContactPersonEmail()%>
							CompanyDescription :
							<%=viewJobNotificationBean.getCompanyDescription()%>
							Job description :
							<%=viewJobNotificationBean.getJobDescription()%>
							Assessment expected date :
							<%=viewJobNotificationBean.getExpecteddate()%>
							Assessment start date :
							<%=viewJobNotificationBean.getAssesmentStartDate()%>
							Assessment End Date :
							<%=viewJobNotificationBean.getAssesmentEndDate()%>
							Job Posted date :
							<%=viewJobNotificationBean.getPostedDate()%>
							noof vacancies :
							<%=viewJobNotificationBean.getNoofvacancies()%>
							Technology :
							<%=viewJobNotificationBean.getTechnology()%>
							<%
 	}
%>
</div>
						</div>
					</div>
		
		<!---------------selecting students------------------------  -->
		<br/>
<div class="row rowwd" style=" margin-top:0px; padding-top:0px; position: relative;">
<div class='col-sm-10'>
<div class='row'>
<div class='col-sm-2'>
  <div class="dropdown">
	<button  class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
	  select year <span class="caret"></span>
    </button>
  
    <ul class="dropdown-menu">
		<%for (int i = 1999; i <= Calendar.getInstance().get(Calendar.YEAR); i++) {%>
		     <li class="checkbox">
			     <label style="margin-left: 20px">
			       <input type="checkbox" class="check" name="yop" value="<%=i%>"><%=i %>
			     </label>
	         </li>
		<%}%>
    </ul>
  </div>
  </div>
  
  <div class='col-sm-4'>
    <!-- ------------------------------------------------------------------------ -->
    <!------------------selecting percentage using selector dropdown------------  -->
    <!-- ------------------------------------------------------------------------ -->

	<select name="percentage" class='form-control btn btn-primary' id="per">
	     <option disabled="disabled" selected value=0>Select percentage or grade</option>
		 <option value="80">A</option>
		 <option value="70">B</option>
		 <option value="60">C</option>
		 <option value="50">D</option>
		 <option value="40">E</option>
		<% for (int i =35; i <= 100; i++) {%>
			<option value="<%=i%>"><%=i%></option>
		<%}%>
	</select>
  
  </div>
  
</div>

 
	
<!-- -------------------------------------------------------------------------------------------- -->										
<!------displaying student details on the browser which are filtered data which header type  ------->
<!-- -------------------------------------------------------------------------------------------- -->

	  <h3>Selecting Students <a href='address.com' style="text-align: right"></a> </h3>
									
	  <div style="height:200px;width:1000px;overflow:auto;">
	  
	  <table class="table table-striped" >
			<thead>
				  <tr>
					<th><input type="checkbox" id="select_all" /></th>
					<th>EmailID</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>YOP</th>
					<th>Percentage</th>
				  </tr>
			</thead>
	        <tbody id="studentEmails">
	
			</tbody>
	   </table>
	</div>
			
			<br/>		
	   <div style="text-align: center;">
           <div class="alert alert-danger" id='studentsCount'>
		     <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
		     <strong>Danger!</strong> This alert box could indicate a dangerous or potentially negative action.
		   </div>
			
			<input class="btn btn-primary" type="button" value="Send Notification" onclick="model()"> 
			<a href="<%= application.getContextPath() %>/jsp/admin/shareJobOpportunities.jsp">
				<input class="btn btn-danger" type="button" value="Cancel">
			</a> <br />
	   </div>
									
		   <%
			  if(request.getAttribute("message")!=null)
			  {
			  String str=(String)request.getAttribute("message");
		   %>
			 <span style="color: green;"><label><%=str %></label></span>
		   <%}%>

	
						

		<!-- -------------------------------------------model  popup dialog box------------------------------->


		<div id="dialog" style="display: none; text-align: center;">
			<div id='msgDiv' class='' align="center"></div>
			<div class='row'>
				<div class='col-md-4'>
					<label class='primary'> FirstRound Description </label>
				</div>
				<div class='col-md-6'>

					<input type="text" id="ename" onblur="myFunction()"
						class="en form-control" name="examName" />
				</div>
			</div>
			<div class='row'>

				<div class='col-md-4'>
					<label class='primary'> Round Date:</label>
				</div>

				<div class='col-md-6'>
					<input type="text" class="date form-control dnamedate" disabled="disabled"
						name="date" id="datepicker" />
				</div>
			</div>

			<div class='row'>
				<div class='col-md-12'>
					<input type="submit" class="form-control btn btn-primary"
						onclick="return desAndDate()" value="Submit" id="sendNotification" />
				</div>
			</div>
		</div>

	</div>


	

	<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

	</div>
		<div id="uniqueId">Please Wait..................</div>
		<div class="uniqueLoad"></div>
	<!-- /.main-container -->
	<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

	<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

	<!-- JAY NOTIFICATIONS HEADER  Script-->

	<script type="text/javascript">

var path ="${path}";
</script>
	<script type="text/javascript"
		src="${path}/assets/js/jaySingStudentRequestsNotifications.js"></script>

	<!-- JAY NOTIFICATIONS HEADER END  -->
	<!-- Vijay Noti  -->
	<%-- <script type="text/javascript"
		src="${path}/assets/js/VijayNotiJobPosting.js"></script>

 --%>


<script type="text/javascript" src="${path}/assets/js/RajnishJobPostNotificationsToHr.js"></script>
	<!--  ----------------------------------------ajax call for all student details---------------------->

	<!-- -------------------------------------------storing email and userid in arraylist-------------- -->

	<script>
function desAndDate(){
	//alert("yfyud7iydyuduy6dyujduy");
	var des=$('#ename').val();
	var date=$('#datepicker').val();
	 if(des=="" || date=="" )
	 {
			 if(des=="")
				 {
				 $("#msgDiv").html("<div class='alert alert-danger' style='color:red'>Please Enter exam description</div>");
				    return false;
				 }
			 if(date=="")
			 {
				 $("#msgDiv").html("<div class='alert alert-danger' style='color:red'>Please enter exam date</div>")
				    return false;
				 }
			
	 }
	
	 else if(des!="" && date!=""){
		 $("#uniqueId").show(); 
		 return true;
	}
	
}

</script>


	<script>

 function model(){

		var selVal=$(".checkbox:checked");
	 var noofstudents=0;
		var numberOfChecked = $('input:checkbox:checked').length;

		var selectedUserValues="";
		selVal.each(function(){
			
			selectedUserValues+=$(this).val()+",";
			noofstudents++;
			//$("#dialog").hide();
		});

	 
	 if(noofstudents<=0){
		 $('#studentsCount').show();
	 
	 }else{

		 $('#studentsCount').hide();
	 $( function() {
		    $( "#dialog" ).dialog();
		  } );
	 }
	 }
	 
	
	
	 
	 
  $(document).ready(function(){
	  $("#uniqueId").hide(); 
	  var emailList={
			  url:"<%=application.getContextPath()%>/retriveAction",
			  success:function(studentDetails){
				 
				  $('#studentEmails').html();
				  for(var ind=0;ind<studentDetails.length;ind++){
					  
					  $('#studentEmails').append(
							  "<tr><td><input type='checkbox' class='checkbox' value="+studentDetails[ind].userNo+"></td>"+
							    "<td>" +studentDetails[ind].emailId+"</td>"+
							    "<td>" +studentDetails[ind].firstName+"</td>"+
							    "<td>" +studentDetails[ind].lastNmae+"</td>"+
							    "<td>" +studentDetails[ind].yop+"</td>"+
							    "<td>" +studentDetails[ind].percetage+"</td>"+
							   "</tr>" );
				 	 }
			  },
			  error:function(){
				  "no mails"
			  }
	  }
	  $.ajax(emailList);
	
  });
 
</script>
<!-------------------ajax call for round description and round date-------------------------------->
<Script>
$(document).ready(function(){
	  var dateAndDescription={
			  url:"<%=application.getContextPath()%>/getDateAndRoundDescriptionInAjaxCallAction",
			  success:function(dateAndDesc){
				 
				  $('#dialog').html();
				 
				  for(var ind=0; ind<dateAndDesc.length;ind++){ 
					  $("#ename").val(dateAndDesc[0]);
					  $(".dnamedate").val(dateAndDesc[1]);
				  }
			  },
			  error:function(){
				  alert(" error wrong data");
			  }
	  }
	  $.ajax(dateAndDescription);
	
});




</Script> 
	<!----------------------------------------ajax call for year of passed outs-------------------------------------->

	<script>
  
  function myFilter(per,yop){
	  
	  if(per!=null && yop!=""){
		 
		  getPerYop(per, yop);
	  }
	  else if(yop!=""){
		  
		  getOnlyYears(yop);
	  }else{
		 
		  getOnlyPercent(per);
	  }
	  
  }
  
 
  function getOnlyYears(year1){
 
		  
	  var obj ={
			  "year":year1
	  };
  
	  var emailList={
			  url:"<%=application.getContextPath()%>/selectingYearOrPercetageAction",
			  data:obj,
				  type:"get",
			  success:function(studentDetails){
				  //document.getElementById('studentEmails').innerHTML = "";
				  $('#studentEmails').html("");
				  
				  for(var ind=0;ind<studentDetails.length;ind++){
					  /* 
					  if(year1 == studentDetails[ind].yop){ */
						  
						  
					  $('#studentEmails').append(
							  
							  
							  "<tr><td><input type='checkbox' class='checkbox' value="+studentDetails[ind].userNo+"></td>"+
							    "<td>" +studentDetails[ind].emailId+"</td>"+
							    "<td>" +studentDetails[ind].firstName+"</td>"+
							    "<td>" +studentDetails[ind].lastNmae+"</td>"+
							    "<td>" +studentDetails[ind].yop+"</td>"+
							    "<td>" +studentDetails[ind].percetage+"</td>"+
							   "</tr>" 
							   );
					  //	} 
				 	 }
			  },
			  error:function(){
				  "no mails"
			  }
	  }
	  
	  $.ajax(emailList);
	  
  }  
  
  function getPerYop(per,year1){


	  var obj ={"percentage":per,"year":year1};
	
	  var emailList={
			  url:"<%=application.getContextPath()%>/selectingYearOrPercetageAction",
			  data:obj,
			  success:function(studentDetails){
				 // document.getElementById('studentEmails').innerHTML = "";
				  $('#studentEmails').html("");
				  for(var ind=0;ind<studentDetails.length;ind++){
					  
					 // if(year1 == studentDetails[ind].yop && per <= studentDetails[ind].percetage){
						  
						  //$(studentEmails).html("");
						  
						  
						  
					  $('#studentEmails').append(
							  "<tr><td><input type='checkbox' class='checkbox' value="+studentDetails[ind].userNo+"></td>"+
							    "<td>" +studentDetails[ind].emailId+"</td>"+
							    "<td>" +studentDetails[ind].firstName+"</td>"+
							    "<td>" +studentDetails[ind].lastNmae+"</td>"+
							    "<td>" +studentDetails[ind].yop+"</td>"+
							    "<td>" +studentDetails[ind].percetage+"</td>"+
							   "</tr>" 
							   );
					  	} 
				 	 //}
			  },
			  error:function(){
				  "no mails"
			  }
	  }
	  
	  $.ajax(emailList);
	  
  }
  
  function getOnlyPercent(per1){

	  var emailList={
			 
			  url:"<%=application.getContextPath()%>/selectingYearOrPercetageAction",
			    data:{ 
				  "percentage":per1
				  }, 
			  success:function(studentDetails){
				//  document.getElementById('studentEmails').innerHTML = "";
				
				  $('#studentEmails').html("");
				  for(var ind=0;ind<studentDetails.length;ind++){
					  
					  if(per1 <= studentDetails[ind].percetage){
						 
						  //$(studentEmails).html("");
					  $('#studentEmails').append(
							  
							  "<tr><td><input type='checkbox' class='checkbox' value="+studentDetails[ind].userNo+"></td>"+
							    "<td>" +studentDetails[ind].emailId+"</td>"+
							    "<td>" +studentDetails[ind].firstName+"</td>"+
							    "<td>" +studentDetails[ind].lastNmae+"</td>"+
							    "<td>" +studentDetails[ind].yop+"</td>"+
							    "<td>" +studentDetails[ind].percetage+"</td>"+
							   "</tr>" 
							   );
					  	} 
				 	 }
			  },
			  error:function(){
				alert("% error");
				  
				 }
	  }
	  
	  $.ajax(emailList);

	}
  
  function  getSelectedYears(){
	  
	  var year1="";
		$(".check:checked").each(function(){
			debugger;
			year1 +=$(this).val()+",";
			
		});
		return year1;
	
  }
  
$(document).ready(function(){
	
	
	
	$('.check').change(function(){
		
		 var  per=$('#per').val();
		 var year1="";//$('#year').val();
		year1 = getSelectedYears();
	myFilter(per,year1);
		  
	});
	  
	  });
 
</script>

	<!----------------------------------------------ajax call for percentage------------------------------------------->


	<script>
  $(document).ready(function(){
	  $('#per').change(function(){
		  //var per=$('#per').val();
		  var per=$('#per').val();
		  var percen=0;
		  var year1=getSelectedYears();
			 
		  
		  myFilter(per,year1);
			  
	    });
	
  });
  
   
  /* <!-- -------------------------select All checkBoxes script----------------------------------- --> */
  $(document).ready(function(){
	var usernoList="";  
    $('#select_all').on('click',function(){
       debugger;
       x();
    	if(this.checked){
            $('.checkbox').each(function(){
            	var userno=$(this).val();
            	
                this.checked = true;
            });
        }else{
             $('.checkbox').each(function(){
                this.checked = false;
            });
        }
    });
    
  });
 
</script>
	<script type="text/javascript">
function x(){
	
    $('.checkbox').on('click',function(){
    	
    	if(this.checked){
    		
    	}
    	 
        if($('.checkbox:checked').length == $('.checkbox').length){
            $('#select_all').attr('checked',true);
        }else{
            $('#select_all').attr('checked',false);
        }
    });
  }
function myFunction() {
	if($(".en").val()!=""){
	  $("#datepicker").attr("disabled", false);
	}
} 

$("#sendNotification").click(function(){

	$("#msgDiv").html("");
	var dateval=$("#datepicker").val();
	var exam=$("#ename").val();
	var selectedUserValues="";
	var selectedEmails="";
	
	 if(exam=="" || dateval=="" )
	 {
			 if(exam=="")
				 {
				 $("#msgDiv").html("<div class='alert alert-danger' style='color:red'>Please Enter exam description</div>");
				    return false;
				 }
			 if(dateval=="")
			 {
				 $("#msgDiv").html("<div class='alert alert-danger' style='color:red'>Please enter exam date</div>")
				    return false;
				 }
			
	 }
	
	
	var selVal=$(".checkbox:checked");
	var noofstudents=0;
	var numberOfChecked = $('input:checkbox:checked').length;
	
	selVal.each(function(){
		
		selectedUserValues+=$(this).val()+",";
		noofstudents++;
		//$("#dialog").hide();
	});
	//alert("selected students    "+noofstudents);
	
//});
	if(selectedUserValues!=""){
	    $.ajax({
	        	url:"<%=application.getContextPath()%>/adminSendingnNotificationToSelectedStudents",
											data : {
												"selectedUserId" : selectedUserValues,
												"dateval" : dateval,
												"exam" : exam
											},
											type : "post",
											success : function(obj) {
												debugger;
												alert("" + obj);
												$("#dialog").dialog('close');

												window.location.reload(true);
											},
											error : function() {

												alert("failed");
											}

										});

							} else {

								alert("Please select atleast one checkbox");
							}

							$(".date").val("");
							$(".en").val("");

						});
	</script>


	<script src="${path}/assets/js/jquery-ui.min.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker({
				dateFormat : 'yy-mm-dd'
			}).val();
		});
	</script>
	<!-- date picker -->
	</div>
</body>
</html>
