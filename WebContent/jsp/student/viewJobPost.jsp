<!DOCTYPE html>
<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<html lang="en">
	<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
	<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="Nacre Software Services Assesment"  />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<title>Home - Student</title>

		
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
	<link rel="stylesheet" href="${path}/assets/dist/css/bootstrap-select.min.css">
		<style type="text/css">
		
		#job-posting-wrapeer{
		border-color: 10px solid red;
		}
		.dat-pos{
		    position: relative;
    top: 20px;
    font-size: 14px;
		}
		.h5{
		    position: relative;
    left: 50px;
		}
		</style>
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/student_menu.jsp"></jsp:include>
<%-- 
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include> --%>
<!-- write your code here -->
 
			<div class="main-content" >
				<div class="main-content-inner">
				
			

					<div class="page-content">
					<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >View Job Posting Details</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
					
				<!-- 
								Separetor start
								<div class="hr hr2 hr-dotted"></div>
								Separetor end					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >JOB POSTINGS</b> 
									 
								</h4>
		Separetor start
								<div class="hr hr2 hr-dotted"></div>
								Separetor end -->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
						
								
<!-- write your code here -->


  <nav  >
    <div class="container " style="width:100%; text-align:center; height:100px;background-size:100%;background-image: url('<%=StringConstants._VIEW_JOBS_BACKGROUND %>'); background-repeat: no-repeat">
     <!--  <form class="navbar-form navbar-left" role="search"> -->
   <!--   <div style='width:100%;'>
    -->  <!-- 
        <div  style="width:100%; margin:auto; padding-top:12%; padding-bottom:10%;"> -->
 
  <select id="company" class="selectpicker" data-hide-disabled="true" data-live-search="true">
  
  </select>
  <select id="city" class="selectpicker" data-hide-disabled="true" data-live-search="true">
    <optgroup disabled="disabled" label="disabled">
      <option>Hidden</option>
    </optgroup>
   
  </select>
  <select id="technology" class="selectpicker" data-hide-disabled="true" data-live-search="true">
    <optgroup disabled="disabled" label="disabled">
      <option>Hidden</option>
    </optgroup>
    
  </select>
        <button class="btn btn-primary" id="findJob">Find Job</button>
     <!--    </div>
    --> <!--   </form> -->

    </div><!-- 
    </div> -->
    <!-- .contai<p>ner-fluid -->
  </nav>
<br/>
			
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
	

<div class="container" style="border:lightgray solid 1px; width:100%; box-shadow:10px 10px 10px lightgray">
<nav >
  <div class="row bg-primary" style='text-align:center;'>
     <div class="col-sm-2" style="border-right:1px lightgray solid; "><h6>COMPANY IMAGE</h6></div>
    <div class="col-sm-2 " style="border-right:1px lightgray solid; "><h6>COMPANY NAME</h6></div>
	<div class="col-sm-2 " style="border-right:1px lightgray solid; "><h6>WORKING POSITION</h6></div>
	 <div class="col-sm-2 " style="border-right:1px lightgray solid;"><h6>LOCATION</h6></div>
	 <div class="col-sm-2 " style="border-right:1px lightgray solid;"><h6>EMPLOYMENT</h6></div>
	 <div class="col-sm-2 " style="border-right:1px lightgray solid;"><h6>DATE</h6></div>
  </div>
 </nav>
<div></div>
<div id='job-posting-wrapeer'>
</div>
  <div class="row" id="AddRow">
      <div id="clientImage" class="col-sm-2" style="border-right:1px lightgray solid;"></div>
    <div id="clientName" class="col-sm-2" style="border-right:1px lightgray solid;"></div>
	<div id="position" class="col-sm-2" style="border-right:1px lightgray solid;"><a href="${path}/jsp/student/jobdescription.jsp" ></a> </div>
	 <div id="location" class="col-sm-2" style="border-right:1px lightgray solid;"></div>
	 <div id="employment" class="col-sm-2" style="border-right:1px lightgray solid;"></div>
	 <div id="date" class="col-sm-2"></div>
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
	  $.ajax({
			url:"${path}/<%=URLConstants.GET_JOB_POST_COMPANY_NAME_ACTION%>",
				success:function(companys){
				$('#company').empty();
				$('#company').append("<option value=''>Select Company</option>");
				for (var ind = 0; ind < companys.length; ind++) {
					$('#company').append("<option value='"+companys[ind].clientId+"'>"+companys[ind].clientName+"</option>");			
				}

				 $('.selectpicker').selectpicker('refresh');
			},
			error:function(){
				
				alert("please try later");
			}
			
		});
	  $.ajax({
			url:"${path}/<%=URLConstants.GET_JOB_POST_CITY_ACTION%>",
			success:function(cities){
				$('#city').empty();
				$('#city').append("<option value=''>Select City</option>");
				for (var ind = 0; ind < cities.length; ind++) {
					$('#city').append("<option value='"+cities[ind].cityId+"'>"+cities[ind].city+"</option>");			
				}

				 $('.selectpicker').selectpicker('refresh');
			},
			error:function(){
				
				alert("please try later");
			}
			
		});
	  $.ajax({
			url:"${path}/<%=URLConstants.GET_JOB_POST_TECHNOOGY_ACTION%>",
			success:function(technologies){
				$('#technology').empty();
				$('#technology').append("<option value=''>Select Technology</option>");
				for (var ind = 0; ind < technologies.length; ind++) {
					$('#technology').append("<option value='"+technologies[ind].technologyId+"'>"+technologies[ind].technology+"</option>");			
				}

				 $('.selectpicker').selectpicker('refresh');
			},
			error:function(){
				
				alert("please try later");
			}
			
		});
		 $.ajax({
			url:"${path}/<%=URLConstants.VIEW_JOB_POST_ACTION%>",
			success:function(obj){
			/* 	$('#AddRow').empty();
				$('#AddRow').append(" ");
				for (var ind = 0; ind < obj.length; ind++) {
					 }	
 */             for (var i= 0; i < obj.length; i++) {
	            // for (var j=0; j<obj[i].length; j++) { 
	           /*  var div=$("job-posting-wrapeer");
	            var divRow=$(AddRow);
	           var row=div.append(divRow); */
	           var s="";
	           s+="<div id='clientImage' class='col-sm-2' style='border-right:1px lightgray solid;'><img width=80px height=70px src='"+obj[i][1].clientImage +"'></img></div>";
	           s+="<div id='clientName' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'>"+obj[i][1].clientName+"</div>"; 
	          // s+="<div id='position' class='col-sm-2' style='border-right:1px lightgray solid;'><a href='${path}/jsp/student/jobdescription.jsp?JobpostId="+obj[i][0].jobPostId+"'>"+obj[i][0].description+"</a></div>";
	           s+="<div id='position' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'><a href='${path}/jsp/student/jobdescription.jsp?JobpostId="+obj[i][0].jobPostId+"'>"+obj[i][6].technology+" Developer</a></div>";
	           s+="<div id='location' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'>"+obj[i][2].location+","+obj[i][4].city+"</div>";
	           s+="<div id='employment' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'> Full Time</div>";
	           s+="<div id='date' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'>"+obj[i][0].postDate+"</div>"; 
	           s="<div class='row'>"+s+"</div>";
	     		$("#job-posting-wrapeer").append(s);
	     		
			/* 	 $("#clientName").append(obj[0][1].clientName);
				 $("#position").append(obj[0][0].description);
				 $("#salary").append(obj[0][0].description);
				 $("#location").append(obj[0][2].location);
				 $("#employment").append(obj[0][0].description);
				 $("#date").append(obj[0][0].postDate);
 */	             //}//inner for
	          }//outer for 
 $('.selectpicker').selectpicker('refresh');
			},//sucess
			error:function(){
				
				alert("please try later");
			}
			
		});
		 
		  $('#findJob').click(function(){
				var company= $('#company').val();
				var city= $('#city').val();
				var technology= $('#technology').val();
           // alert(company+"-"+city+"-"+technology);
					$.ajax({
						url:"${path}/<%=URLConstants.FIND_JOB_ACTION%>",
						data:{"company":company,"city":city,"technology":technology},
						async:true,
					     //context: document.body,
						success:function(obj){
							//alert(obj);
							if(obj.length>0){
							$("#job-posting-wrapeer").html("");
							
							for (var i= 0; i < obj.length; i++) {
					         var s="";
	           s+="<div id='clientImage' class='col-sm-2 ' style='border-right:1px lightgray solid;'><img width=80px height=70px src='"+obj[i][1].clientImage +"'></img></div>";
	           s+="<div id='clientName' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'>"+obj[i][1].clientName+"</div>"; 
	          // s+="<div id='position' class='col-sm-2' style='border-right:1px lightgray solid;'><a href='${path}/jsp/student/jobdescription.jsp?JobpostId="+obj[i][0].jobPostId+"'>"+obj[i][0].description+"</a></div>";
	           s+="<div id='position' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'><a href='${path}/jsp/student/jobdescription.jsp?JobpostId="+obj[i][0].jobPostId+"'>"+obj[i][6].technology+" Developer</a></div>";
	           s+="<div id='location' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'>"+obj[i][2].location+","+obj[i][4].city+"</div>";
	           s+="<div id='employment' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'> Full Time</div>";
	           s+="<div id='date' class='col-sm-2 dat-pos' style='border-right:1px lightgray solid;'>"+obj[i][0].postDate+"</div>"; 
	           s="<div class='row style='border-top:10px solid black;'>"+s+"</div>";
	     		$("#job-posting-wrapeer").append(s);
					          }//outer for 
							}else{
								$("#job-posting-wrapeer").html("NO RECORDS AVAILABLE");
							
								<%--  $.ajax({
										url:"<%=application.getContextPath()%>/ViewJobPostAction",
										success:function(obj){
										/* 	$('#AddRow').empty();
											$('#AddRow').append(" ");
											for (var ind = 0; ind < obj.length; ind++) {
												 }	
							 */             for (var i= 0; i < obj.length; i++) {
								            // for (var j=0; j<obj[i].length; j++) { 
								           /*  var div=$("job-posting-wrapeer");
								            var divRow=$(AddRow);
								           var row=div.append(divRow); */
								           var s="";
								           s+="<div id='clientImage' class='col-sm-2' style='border-right:1px lightgray solid;'><img src='"+obj[i][1].clientImage +"'></img></div>";
								           s+="<div id='clientName' class='col-sm-2' style='border-right:1px lightgray solid;'>"+obj[i][1].clientName+"</div>"; 
								          // s+="<div id='position' class='col-sm-2' style='border-right:1px lightgray solid;'><a href='<%=application.getContextPath()%>/jsp/student/jobdescription.jsp?JobpostId="+obj[i][0].jobPostId+"'>"+obj[i][0].description+"</a></div>";
								           s+="<div id='position' class='col-sm-2' style='border-right:1px lightgray solid;'><a href='<%=application.getContextPath()%>/jsp/student/jobdescription.jsp?JobpostId="+obj[i][0].jobPostId+"'>"+obj[i][6].technology+" Developer</a></div>";
								           s+="<div id='location' class='col-sm-2' style='border-right:1px lightgray solid;'>"+obj[i][2].location+","+obj[i][4].city+"</div>";
								           s+="<div id='employment' class='col-sm-2' style='border-right:1px lightgray solid;'> Full Time</div>";
								           s+="<div id='date' class='col-sm-2' style='border-right:1px lightgray solid;'>"+obj[i][0].postDate+"</div>"; 
								           s="<div class='row'>"+s+"</div>";
								     		$("#job-posting-wrapeer").append(s);
								     		
										/* 	 $("#clientName").append(obj[0][1].clientName);
											 $("#position").append(obj[0][0].description);
											 $("#salary").append(obj[0][0].description);
											 $("#location").append(obj[0][2].location);
											 $("#employment").append(obj[0][0].description);
											 $("#date").append(obj[0][0].postDate);
							 */	             //}//inner for
								          }//outer for 
							 $('.selectpicker').selectpicker('refresh');
										},//sucess
										error:function(){
											
											alert("please try later");
										}
										
									});
							 --%>
							
							}
					          //  $('.selectpicker').selectpicker('refresh');
					          
							},//sucess
						error:function(){
							
							alert("please try later");
						}
						
					});
		  
				}); 
		 
  });/* 
  $("#company").select2(); */
 


		</script>
</body>
</html>
