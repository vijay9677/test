<!-- @author SAGAR SURYAWANSHI b35 java or Pavan Pratap singh b35 java -->

<!-- @author SAGAR SURYAWANSHI b35 java -->

<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@page import="com.nacre.online_assesment.util.StringConstants"%>
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
		
 <link rel="stylesheet" href="${path}/assets/dist/css/bootstrap-select.css" >
		
<!-- 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"> -->
	
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/student_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>			<div class="main-content">
				<div class="main-content-inner">
				
			

					<div class="page-content">
					
				
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Job Description</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
<!-- write your code here -->

</head>
<body>
 <div class="container" style="border:lightgray solid 1px;" id="job-position">
  <div class="row" id="working-position">
    <div class="col-sm-12">
	<h3 style="color:red" id='client-heading'></h3>
	</div>
  </div>
  <div class="row" id="row">
    <div class="col-sm-12" style="padding-bottom:10px;">
	<span id='client-name'></span>
	</div>
  </div>
  </div>
  <div class="container" style="border:lightgray solid 1px; box-shadow:10px 10px 10px lightgray">
  <div class="row" >
    <div class="col-sm-6">
<div class="row" style="padding:25px;">
<!---<div class="col-sm-2"></div>-->
<div class="col-sm-10"style="padding:4px; border:1px lightgray solid; background-color:#f2f2f2; box-shadow:5px 5px 5px lightgray;" id="job-description">
<!-- <ul>
<li>
<label>Experience:</label>
<span>
 Fresher</span></li>
<li><label>Salary :</label>
<span>
Rs 1</span></li>
<li><label>Location :</label>
<span>
Hyderabad/ Secunderabad
</span>
</li>
<li><label>Job Function :</label> <span>IT/Telecom - Software,Sales/Business Development</span></li>
<li><label>Industry :</label> <span>IT-Software</span></li>
<li><label>Specialization :</label> <span>Internet/E-commerce,IT/Telecommunications</span></li>
<li>
<label>Qualification:</label><span> MCA,BE(Any Stream),PG.</span> 
</li>
</ul> -->
</div>
</div>

	</div>

	 <div class="col-sm-6" style="padding:12px;">
<section>
<label>Key Skills :</label>
<span id="technology"></span>
</section>
<section>
<label>Company Information</label>
<p><strong><u>Description:</u></strong></p>
<div style="margin-left:20px;" id="skills">
<!-- <p>&bull;&nbsp; Should be open to work in Night shifts.</p>
<p>&bull;&nbsp; Candidate with good Internet-Surfing skills would be preferred.</p>
<p>&bull;&nbsp; Candidate should possess excellent oral and written communication skills.</p>
<p>&bull;&nbsp; Any Graduate or Post Graduate (Any Specialization) (Any Year pass out) are eligible.</p>
<p>&bull;&nbsp; Candidates with backlogs/arrears in their degrees are also eligible.</p>
<p>&bull;&nbsp; Hard working and positive attitude.</p> -->

</div>
</p>
</section>
<section>
<label>Job Posted by Company:</label>
<br/>
<span id="company-name"></span>
<p> </p>
</section>
    </div>
  </div>
  
<!-- <div>



</div>
<div></div> -->
<hr>
<div class="row">
<div class="col-sm-6">
<span id="posted-date"></span> | <span id="job-id"></span></div>
<div class="col-sm-6" style="padding-bottom:10px !important;" id='apply-btn'></div>
<span id="span"></span>
<span id="spanRequest"></span>
</div>
</div>
</div>


<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include><!-- 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> -->
 <script src="${path}/assets/dist/js/bootstrap-select.js"></script>
<script type="text/javascript" src="${path}/assets/dist/js/bootstrap-select.min.js"></script>


<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>

<script type="text/javascript" src="${path}/assets/js/gajananNotificationsJobpost.js"></script>

<script type="text/javascript" src="${path}/assets/js/ManishStudentNotifications.js"></script>

  <script>
  $('document').ready(function(){
	  var i=<%=request.getParameter("JobpostId")%>
	  var uid= '<%=session.getAttribute(StringConstants._SESSION_USER_ID)%>';
	  /*
	  *
	  * Changable code when full data is loaded pls remove uid=2
	  
	  */
	 // uid=2;
	  
	 
		$.ajax({
			url:"<%=application.getContextPath()%>/<%=URLConstants.JOB_POST_DESCRIPTION%>",
			data:{"JobpostId":i},
			success:function(obj){	
				 
	           $("#client-name").html(obj[0][2].location+" ,"+obj[0][4].city);
	           $("#client-heading").html(obj[0][1].clientName);
	           $("#posted-date").html("Posted Date : "+obj[0][0].postDate);
	           $("#job-id").html("Job ID  :  "+i);
	           $("#job-description").html("Job Description :  "+obj[0][0].description);
	           $("#skills").html("<br/>"+obj[0][1].clientDescription);
	           $("#company-name").html(obj[0][1].clientName);
	           $("#technology").html(obj[0][6].technology);

			},//sucess
			error:function(){
			  alert("please try later");
			}	
		});
	
		
		/* pavan pratap singh batch-35 code start  */
		$.ajax({
			url:"<%=application.getContextPath()%>/<%=URLConstants.APPLY_FOR_OPPORTUNITY_POSTING_ACTION%>",
			data:{"JobpostId":i,'userId':uid},
			success:function(obj){	
				
			/* if else condition for checking student elegible or not	alert(obj[0]); */
				debugger;
				if(obj[0]=="<%=StringConstants.REQUEST_FOR_JOB_POST%>"){
				
	        	  $('#apply-btn').html('<a class="btn btn-primary">Request</a>');
	        	  $('#apply-btn').click(function(){
	        		  $("#apply-btn").hide();
	          		  
	            			$.ajax({
	            				type: "POST",
	            				url:"<%=application.getContextPath()%>/<%=URLConstants.REQUEST_FOR_JOB%>",
	            				data:{"JobpostId":i,'userId':uid},
	            				success:function(obj){	
	            					 	 debugger;
	            					 $("#span").html("<center><i><h3 class='bg-success'>Your Request Sucessfully Sent</h3></i></center>"); 
	       	      		          
	            				},//sucess
	            				error:function(){
	            				  alert("please try later");
	            				}
	            				
	            			});
	            		});

		        	  
	        	  
	          }/* if close*/
	          
		else if(obj[0]=="<%=StringConstants.ELEGIBLE_STUDENT_STATUS%>"){
	
			/*Getting the elegible_Student_Id  */
	    var        	  elegible_Student_Id=obj[1];
		var           elegible_Student_status_Id=obj[2];
	
	/* if else if condition for checking alredy request sent or alredy apply or not */
	
	/*obj[2]==alredy_apply' */
	if(obj[2]== "<%=StringConstants._ALREADY_APPLIED_FOR_JOB_POST_ID%>"){
		
		/*---check already apply or not ---- */
		 $("#span").html("<center><i><h3 class='bg-info'>You are alredy Apply</h3></i></center>"); 
	}/*Inner if is close */
	
	/*obj[2]==alredy_Request' */
	else if(obj[2]== "<%=StringConstants._ALREADY_REQUESTED_FOR_JOB_POST_ID%>"){
		

		/*---check already requested or not ---- */
		 $("#span").html("<center><i><h3 class='bg-info'>Your Request is pending</h3></i></center>"); 
	}/*Inner else if close*/
	

	/*--------------------------if  apply for a job 1st time--------------------------*/
	/* obj[2]=='apply' */
	     else if(obj[2]== "<%=StringConstants._ELIGIBLE_FOR_JOB_POST%>"){
	    	 $('#apply-btn').html('<a class="btn btn-primary">Apply</a>');
	    	 $('#apply-btn').click(function(){
	        		  $("#apply-btn").hide();
	        		//  alert(elegible_Student_Id);
	        		 // alert(elegible_Student_status_Id);
	        		 
	      			$.ajax({
	      				type: "POST",
	      				url:"<%=application.getContextPath()%>/<%=URLConstants.APPLY_FOR_JOB%>",
	      				data:{'elegible_Student_Id':elegible_Student_Id},
	      				success:function(obj){	
	      					 	 
	      					  $("#span").html("<center><i><h3 class='bg-success'>You are Successfully apply</h3></i></center>"); 
	      		          
	      				},//sucess
	      				error:function(){
	      				  alert("please try later");
	      				}
	      				
	      			});
	        		  
	      		});
	          }else if(obj[2]== "<%=StringConstants._APPLY_FOR_JOB_POST_ID%>")
	        	  
	        	  $("#span").html("<center><i><h3 class='bg-success'>You are Already apply</h3></i></center>"); 
      
	        	  
	          }/* Inner else if is close */
	          else{
	        	  $('#apply-btn').html('TRY AGAIN');
	 	         	  
	          }
			},//sucess
			error:function(){
			  alert("please try later");
			}
			
		});
		
		/* pavan pratap singh batch-35 code End  */
		
		  });
		
		</script>

 </body>
</html>
