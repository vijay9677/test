	
			<!--	------- @author Rohit Kumar Singh batch 35 ------	-->

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
  
  <link href="${path}/assets/css/jquery-ui.min.css" rel="Stylesheet" type="text/css" />
		
			</head>

<body class="no-skin">
<div class="main-container" >
<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/student_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->


<div class="main-container" id="main-container">
<%-- <jsp:include page="../../jsp/common/admin_header.jsp"></jsp:include> --%>

<%-- <jsp:include page="../../jsp/common/aside_menu.jsp"></jsp:include> --%>
<%-- <jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include> --%>


<!-- 	------------------------------------------------------------------------------------------------ -->
 <!--  <h2>Vertical (basic) form</h2> -->
 <form action="${path}/bookSlotsAction" method="post">
    <div class="form-group">
    <div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Book a Slot</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
    <div class="row" style="width:100%;padding:10%;background-image: url('<%=StringConstants._SLOT_BOOKING_BACKGROUND%>');">
    	  <div class="col-sm-4" style='text-align:right;'>
     		<label style='color:#fff;'> Select Assessment Type &nbsp;:</label> 
     	  </div>
       <div class="col-sm-3">
		<select id="assessment_type_name" class="chosen-select form-control dpdw" data-live-search="true" name="asstypename" style="width: 100%;height: auto;">
		
		</select>

		</div>

		<span class='label label-default' id='assTypeId_sel'></span>
		 
		
		<!-- <label style="color:red">*</label>	-->
	</div><br><br>
    <br/>
    <div class="form-group" id="tbl_table">
      <table id="displayAssmentNames" class="table table-hover table-striped" style='width:100%;margin:auto; display:none;'>
	 
	  <thead id="tbl_heads">
	 
	  <tr class='bg-primary'>
	  	<th  style='text-align:center;'>AssessmentName</th>
	  	<th  style='text-align:center;'>BookSlot(s)</th>
	  </tr>
	  </thead>
	  
	  <tbody id='assesment-data'>
	  
	  
	  </tbody>
	  
	 </table>
    </div>
    </div>
  </form>
 
</div>



<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>

<script type="text/javascript" src="${path}/assets/js/gajananNotificationsJobpost.js"></script>
<script type="text/javascript" src="${path}/assets/js/ManishStudentNotifications.js"></script>

 
     <script type="text/javascript" src="${path }/assets/js/jquery-ui.min.js"></script>
 <script type="text/javascript">
 
<%--  var sessTime="<%=request.getAttribute("timeSlot")%>";  --%>

    /*	****************************************************************************************************** */
    
 //  var userId=1;


 
/* ********* to access all the assessment type name(s) from database table 'tbl_assessment_type'  ********* */

$('document').ready(function(){
		
	$('#tbl_table').hide();
	
			$.ajax({
				url :"<%=application.getContextPath()%>/GetAssesmentTypeAction",
			 success:function(assmentType){
			 	$('#assessment_type_name').empty();
			 	$('#assessment_type_name').append("<option label='---Select Assessment Type---' value=-1></option>");
			 	for(var assment=0;assment<assmentType.length;assment++){
			 		$('#assessment_type_name').append("<option value='"+assmentType[assment].assesmentTypeId +"'>"
			 		+assmentType[assment].assesmentTypeName+"</option>");			 	
			 	   }//for		
			 
			 },	//success fun()
			 error:function name() {
			 	alert("plz try later");
				}//error fun()
			});	//ajax
			
			});		//ready fun()
			
			
/* ***** to access all the assessment name(s) from database table tbl_assessment on basis of assessmentTypeName ****** */		
 
$('document').ready(function(){
	
		PopulateItemsTable();
	
			
	});
	
	 
	
	/***************************************************************************************************************/
		
	function PopulateItemsTable(){
		
		
	  $('#assessment_type_name').change(function(){
			
		  if($('#assessment_type_name').val()==-1)
			  {
			  $("#displayAssmentNames").hide();
			  }else{
		      $("#displayAssmentNames").show();
			  }
		  
		$('#tbl_table').show();
		
		  
		var txt="";
		
		var id=$(this).val();
	//	alert(id);
		
		var assmentId=0;
		var obj = {"assesmentTypeId":id};
	//	alert(obj['assesmentTypeId']);
	
		/* ****************************** Ajax Call for getting AssessmentNames **************************** */
		
		 $.ajax({
			type:"GET",
			url:"<%=application.getContextPath()%>/GetAssesmentNameAction",
			data:obj,
			async:false,
			contentType:"application/json",
			dataType:"json",
			success:function(assmentNames){
		//		console.log("=========>"+JSON.stringify(assmentNames));
					
			$('#assesment-data').empty();
			
			$('#assesment-data').html("");
			
					var len=assmentNames.length;
										
						for (var assName = 0; assName <len; assName++) {
							
							if(assmentNames[assName].assesment){
								assmentId=assmentNames[assName].assesmentId;
								assessmentName=assmentNames[assName].assesment;
								courseId=assmentNames[assName].course.courseId;
					//			console.log("-------crsId "+JSON.stringify(courseId));
							
					/* ************************ Ajax Call to retrieve NoOfAttempts  ***********************  */
					
								$.ajax({
									url:'<%=application.getContextPath()%>/GetNoOfAttempts',
									data:{'assId':assmentId},
									contentType:"application/json",
									dataType:"json",
									async:false,
									success:function(allAttempts){
										
						//				alert(allAttempts);
						//				console.log("=========>"+allAttempts);
																				
										var lenth=allAttempts.length;
						//				alert("length is ... "+lenth);
																		
												if(allAttempts[0]*1 < allAttempts[1]*1){
											txt="<td><a href='<%=application.getContextPath()%>/jsp/student/timeSlot.jsp?assID="+assmentNames[assName].assesmentId+"'>BOOK SLOT</a></td></tr>";
												}else{
												txt="<td><label class='lbl lbl-info'>YOU FINISHED WITH ALL LIMITED ATTEMPTS</label></td></tr>";
												}
											if(courseId==1 && assmentId!=null){
											txt="<tr><td><img class='img-thumbnail'height= '200px' width='200px'src='<%=application.getContextPath()%>/assets/img/corejava.jpg'>"+assessmentName+"</td>"+txt;
																		
											}
											else if(courseId==2 && assmentId!=null){
												txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/advjava.jpg'>"+assessmentName+"</td>"+txt;
												}
											else if(courseId==3 && assmentId!=null){
												txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/cnet.jpg' class='img-thumbnail'height= '200px' width='200px'>"+assessmentName+"</td>"+txt;
												
												}
				 							 else if(courseId==4 && assmentId!=null){
				 								txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/aspnet.jpg' class='img-thumbnail'height= '200px' width='200px'>"+assessmentName+"</td>"+txt;
				 								} 
											 else if(courseId==5 && assmentId!=null){
												txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/oracle.jpg' class='img-thumbnail'height= '200px' width='200px'/>&nbsp;"+assessmentName+"</td>"+txt;
												
												}
											 else if(courseId==6 && assmentId!=null){
												txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/mysql.jpg'/>&nbsp;"+assessmentName+"</td>"+txt;
												}
											 else if(courseId==7 && assmentId!=null){
													txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/mssqlserver.jpg'/>&nbsp;"+assessmentName+"</td>"+txt;
													}
											 else if(courseId==8 && assmentId!=null){
													txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/html5.jpg'/>&nbsp;"+assessmentName+"</td>"+txt;
													}
											 else if(courseId==9 && assmentId!=null){
													txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/CSS.jpg'/>&nbsp;"+assessmentName+"</td>"+txt;
													}
											 else if(courseId==10 && assmentId!=null){
													txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/js.jpg'/>&nbsp;"+assessmentName+"</td>"+txt;
													}
											 else if(courseId==11 && assmentId!=null){
													txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/jquery.gif'/>&nbsp;"+assessmentName+"</td>"+txt;
													}
											 else if(courseId==12 && assmentId!=null){
													txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/angularjs.jpg'/>&nbsp;"+assessmentName+"</td>"+txt;
													}
											 else if(courseId==13 && assmentId!=null){
													txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/android.jpg'/>&nbsp;"+assessmentName+"</td>"+txt;
													}
											 else if(courseId==14 && assmentId!=null){
													txt="<tr><td>"+"<img class='img-thumbnail'height= '200px' width='200px' src='<%=application.getContextPath()%>/assets/img/aptitude.jpg'/>&nbsp;"+assessmentName+"</td>"+txt;
													}
																					
											$('#assesment-data').append(txt);
											
											
									//	}//for
																				
									}, //success
									error:function(){
										alert("PLEASE TRY LATER");
									}//error
														
							    });//ajx
								
								
							
							}//if
							else{
								
								assessmentName='';
						//		alert("hiiiiiiiiiiii");
															
							}//else
								
														
						}//for
								
			},//success fun()
			error:function(){

				$('#assesment-data').html("No Records found");
				
			}//error fun()
			
		});	//ajax-1
			
		});	//change()
			
	}//populateItemTable()
	

 </script>
 
   
   <script type="text/javascript">
   
   		/****************************************  jquery validations *********************************/
   							
 // When the browser is ready...
 $('document').ready(function(){
	
	 //validation for level
		$("#assessment_type_name").on('blur',function(){
			 var valueLevel = $(this).val();
			 var reg = new RegExp(/^[-1]/);
			 if(valueLevel==-1){
				
				 $('#tbl_table').hide();
				 $('#assTypeId_sel').html("PLEASE SELECT ANY ONE");
				 $('#assTypeId_sel').css("color","red");
				 
			 }
			 else{
			//	 $('#assTypeId_sel').html("This is valid");
			//	 $('#assTypeId_sel').css("color","green");
			 }
	 	 });
 });
 
 </script>

 
 </body>
	
</html>