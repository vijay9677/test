


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
	<link href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="Stylesheet"
        type="text/css" />
   	
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/viewopportunityheader.jsp"></jsp:include>

<jsp:include page="../../jsp/common/systemadmin_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->



<!-- /* /For Edit Functionlty */ -->
<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
								<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									<b class="blue" >Add Course Info</b>
								</h4>




	<div class="container">
		<div class="row">
			<div class="col-md-12" style="text-align: center; padding-top: 5px;">
				<!-- This Div for using Success_Msg display -->
				<div id='success-msg' class="success_msg" style="width: 40%;">
				
				</div>
			</div>
			<!-- <div class="row"> -->
			<div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->
				<div id="error-msg" class="alert_msg" style="width: 40%;"></div>
			</div>
		</div>
	</div>




	<div class="container">
		<div class="row" style="text-align: left;">

			<!-- Trigger the modal with a button -->
			<div class="col-md-12">
				<button type="button" id="addCourse" onclick=addCourse() class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Course</button>
				<button type="button" class="btn btn-info" data-toggle="modal" onclick="refereshPage()" data-target="#addTechCourse">Assign Course to Technology</button>
				<hr />
			</div>
		</div>
	</div>

	<div class="table-responsive"
		style="border: lightgray 1px solid; box-shadow: 5px 5px 5px lightgray; width: 100%;">
		<table class="table tbl tbl-responsive" id="table" >
				<thead>
					<tr class='bg-primary'>
						<th class='bg-primary'>S.No</th>
						<th class='bg-primary'>Course Name</th>
						
						<th class='bg-primary'>Activity</th>
					</tr>
				</thead>
				<tbody id="data">
					
					
				</tbody>
			</table>
	</div>



	<!--                                      This Modal For Add Records... 
	 ________________________________________________________________________________________________________________________________
	  -->
	
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					
					<h4 class="modal-title">Add Courses</h4>
				</div>
				
				<div class="modal-body">


					<div class="container">




						<form class="form-horizontal" id="form_Submit"
							enctype="multipart/form-data" method="get"
							action="<%=application.getContextPath()%>/AddCourseAction">

							<p>
								<span style="color: Green; font-weight: bold">Note: </span> <span
									style="color: red; font-weight: bold"> *</span> fields are
								mandatory.
							</p>
							<!-- <div class="form-group">
								<label class="control-label col-sm-2" for="course_Name">Technology Name
									: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="Technology_Name" name="Technology_Name"
										class="form-control" id="Technology_Name"
										placeholder="Enter course Name">
								</div>
								<span id="Technology_Name_msg"></span>
							</div> -->
 
					
                            <div class="form-group">
								<label class="control-label col-sm-2" for="course_Name">Course Name
									: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="course_Name" name="course_Name"
										class="form-control" id="course_Name"
										placeholder="Enter course Name" required>
								</div>
								<span id="course_Name_msg"></span>
							</div>
 

							</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="submitButton" class="btn btn-success"
						data-dismiss="modal">Submit</button>
					&nbsp;&nbsp;
					<button type="reset" class="btn btn-danger" data-dismiss="modal">Cancle</button>
					
				</div>
			
				</div>
			</div>
		</div>
	</div>
<!-- ------------------------------- Assigned Technology_Courses--------------------- -->

<!-- Trigger the modal with a button -->

<!-- Modal -->
<div id="addTechCourse" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
      	
        <button type="button" class="close center-block" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Select Assaigned Course To Technology</h4>
      </div>
      
      <div class="modal-body">
      	<form class="form-horizontal" id="form_select_Submit"
							enctype="multipart/form-data" method="get">
       Technology Name: <span style="color: red; font-weight: bold">*</span>
				<select class="form-control" name="techName" id="techName" onchange='selectCourses()' >       
				       <option value="-1" >Select Any Technology</option>
				    <!-- <option value="1">Java</option>
				    <option value="2">.Net</option>
				    <option value="3">PHP</option> -->
				</select>
				<span id="course_select_msg"></span>
				
      Course Name: <span style="color: red; font-weight: bold">*</span>
				<select class="form-control" name="courseName" id="courseName"> 
				 <option value="-1" >Select Any Course</option>
				   <!--  <option value="1">SQL</option>      
				    <option value="2">HTML</option>
				    <option value="3">JavaScript</option>
				    <option value="4">JDBC</option>      
				    <option value="5">SERVLET</option> -->
				</select>
					<span id="tech_select_msg"></span>
          
     
          
</form>
      </div>
      <div class="modal-footer">
        <button type="button" onclick=mySelect() class="btn btn-success" id="assaignok" data-dismiss="modal">ok</button>
      </div>
    </div>

  </div>
</div>





<!--                              This Modal For Edit Records...Modal        
	________________________________________________________________________________________________________________
	                                       -->
	
	<div id="myEditModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			Modal content
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit Record</h4>
				</div>
				<div class="modal-body">


					<div class="container">
						<form class="form-horizontal" id="editassgn" role="form" action="<%=application.getContextPath()%>/EditCourse" method="get">
							
							
							<div class="form-group">
								<label class="control-label col-sm-2" for="course_edit_Id">Course
									Id : <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="course_edit_Id" name="course_edit_Id"
										class="form-control" id="course_edit_Id"
										placeholder="Enter course Id" readonly="readonly">
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-sm-2" for="course_edit_Name">Course Name
									: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="course_edit_Name" name="course_edit_Name"
										class="form-control" id="course_edit_Name"
										placeholder="Enter course Name">
								</div>
								<span id="course_edit_Name_msg"></span>
							</div>
							<!-- hi one div rem -->
					</div>
					
					<!-- fotter -->
					 <div class="modal-footer">
					<button type="button" onclick='getUpdate();' id="updateSubmit" class="btn btn-success"
						data-dismiss="modal">update</button>
					&nbsp;&nbsp;
					<button type="reset" id="resetbutton" class="btn btn-danger" data-dismiss="modal">Cancle</button>
					
					</div> 
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	







<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>

        <!-- ----java script validation---> 
                                                        
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  
   <script type="text/javascript">
 // When the browser is ready...
 
 $('document').ready(function(){
	
 
	// Setup form validation on the course name
	 $("#course_Name").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z]/);
		if(reg.test(val)){
			$("#course_Name_msg").html("This is valid");

			$('#course_Name_msg').css("color","green");
		}
		else{
			$('#course_Name_msg').html("This is invalid");
			$('#course_Name_msg').css("color","red");
			
		}
		
	 });
 });
 /////this is for select tech and select course validation
 //validation for course
	 $("#courseName").on('blur',function(){
		 var vale = $(this).val();
		 var reg = new RegExp(/^[-1]/);
		 if(vale==-1){
			
			 $('#course_select_msg').html("This is Invalid");
			 $('#course_select_msg').css("color","red");
		 }
		 else{
			 $('#course_select_msg').html("This is valid");
			 $('#course_select_msg').css("color","green");
		 }
 	 });
	 $("#techName").on('blur',function(){
		 var vale = $(this).val();
		 var reg = new RegExp(/^[-1]/);
		 if(vale==-1){
			
			 $('#tech_select_msg').html("This is Invalid");
			 $('#tech_select_msg').css("color","red");
		 }
		 else{
			 $('#tech_select_msg').html("This is valid");
			 $('#tech_select_msg').css("color","green");
		 }
 	 });
		
  </script>
  <!-- ******************************** </jQuery ADD Course Form Validation code ------------------------------->
  
    
  
   <script type="text/javascript">
 // When the browser is ready...
 $('document').ready(function(){
	
 
	// Setup form validation on the assesment name
	 $("#course_edit_Name").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z]/);
		if(reg.test(val)){
			$("#course_edit_Name_msg").html("This is valid");

			$('#course_edit_Name_msg').css("color","green");
		}
		else{
			$('#course_edit_Name_msg').html("This is invalid");
			$('#course_edit_Name_msg').css("color","red");
			
		}
		
	 });
 }
	);

 </script>
	
	 <script>
 /* -----------for course_tech_assign---------- */
function mySelect(){
	
//var fsSelect=$("#form_select_Submit").serialize();
//	alert(" technology");
	
	var technologyaName=$("#techName").val();
	var courseName=$("#courseName").val();
	
//	alert("TechnologyId:"+technologyaName+"  "+"CourseId:"+courseName);
	
	$.ajax({
		url:"<%=application.getContextPath()%>/Technology_Course_AddAction",
		type:"post",
		data:{"techName":technologyaName,"courseName":courseName},
		success:function(obj){
//			alert("Hii....");
		
			
			
						$("#techName option:selected").removeAttr("selected");
			$("#techName option:eq(0)").prop("selected", true);
			$("#courseName option:selected").removeAttr("selected");
			$("#courseName option:eq(0)").prop("selected", true);
			
			
			$("#success-msg").html("<div class='alert alert-success fade in' style='text-align: center;'>"
					+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
					+ " <strong>Success!!!</strong>  Course has been Selected Successfully..."
					+ "</div>");
			//alert("Data Successfully Inserted...");
		},
		error: function(){
			
//			alert("Error");
		}
	});
	
}
</script>
 
 
                           <!-- ----------for adding course------- -->
<script>
	
	function addCourse()
	{
	
		$('#course_Name_msg').empty();
	   
	   
	    //Empty the Courses Form
	    $('#course_Name').val("");
	    $("#success-msg").empty();
	   
	 }
	
</script>

<script>
function selectCourses(){
	 //alert("========================technology changed");
	 var technologyId=$("#techName").val();
	$.ajax({
       type: "POST",
       url: "<%=application.getContextPath()%>/GetNotAssignCourseAction",
       data:{"technologyId":technologyId},
       success: function(courses)
       
       {
       	
 //      alert(courses);

		$("#courseName").empty();

		$("#courseName").html('<option value="-1">Select Any Technology</option>');
       	$.each(courses, function() {
				
				$("#courseName").append(
						"<option value="+this.courseId+">" + this.course
								+ "</option>");
	});
      
       },error:function(){
//   	alert("err");
   }
   });
	
	}

</script>


<script>
/* must apply only after HTML has loaded */
$(document).ready(function () {

	//ajax Technology
	$.ajax({
        type: "POST",
        url: "<%=application.getContextPath()%>/GetTechnologyAction",
        success: function(courses)
        
        {
        	
 //       alert(courses);
        
        	$.each(courses, function() {
				
				$("#techName").append(
						"<option value="+this.technologyId+">" + this.technology
								+ "</option>");
	});
       
        },error:function(){
//    	alert("err");
    }
    });
	
	myLoad();
	
	 
	
	$("#submitButton").on('click', function() { 
		
    	
    var formdata=$("#form_Submit").serialize();
//    $("#submitButton").click(function(){
	
	 if($('#course_Name_msg').html()=="This is invalid"  || $('#technology_Name').val()==''){
//		 alert("Please fill all the currect deatils");
		 $("#error-msg")
			.html(
					"<div class='alert alert-danger fade in' style='text-align: center;'>"
					+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
					+ "<strong>Sorry!!!</strong> Please Fill correct details..."
					+ "</div>");

	 }
	 else if($('#course_Name').val()==""  ){
//			 alert("Please fill all the field ");
		
		 }
	 
		 else{
			

      $.ajax({
              url: "<%=application.getContextPath()%>/AddCourseAction",
													
						data :formdata,
						type : "post",
						success : function(data) {
//							alert(" success");	
							
						/* $('#contact_dialog .modal-header .modal-title').html("Result");
						$('#contact_dialog .modal-body').html(data); */
						/* $("#submitButton").remove(); */
						/* alert("Your Records has been Saved Successfully...");
						$("#success-msg")
						.html(
						"<div class='alert alert-success fade in' style='text-align: center;'>"
						+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
						+ " <strong>Success!!!</strong>  Course has been Added Successfully..."
						+ "</div>"); */
		
						$("#success-msg").html(
								"<div class='alert alert-info'>"
								+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"+data+"</div>"
								
								);
	myLoad();
				},//sucess
				 error : function(jqXHR,
				  status, error) {
				  console.log(status
					+ ": "
					+ error);

				$("error-msg")
				.html(
				"<div class='alert alert-danger fade in' style='text-align: center;'>"
				+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
				+ "<strong>Sorry!!!</strong> Course has not been Added Successfully..."
				+ "</div>");
					}//error
				});//error
			}
		});
        
    
	});
					
function myLoad(){

	var sn=1;
	var courseID=0;
	$.ajax({
        type: "POST",
        url: "<%=application.getContextPath()%>/GetCourseAction",
        success: function(object)
        {
        	
        	if(object==''){$("#data").html("No Course Available In Table");}
        	else{
        	
        	$("#data").empty();
        	var	s="";
        	 for (var i= 0; i < object.length; i++) {
        		 console.log(object[i]);
        s+="<tr  class='success' style='background-color: lightgray; padding: 5px; height: auto;'>" 
        	
        s+="	<td >"+sn+"</td>"
      //  s+="	<td >"+object[i].courseId+"</td>"
        s+="	<td >"+object[i].course+"</td>"
      
        s+="    <td>  <input class='btn btn-primary edit' id='editbutton' onclick='getData(this);' courseID="+object[i].courseId+" type='button' name='edit' data-toggle='modal' data-target='#myEditModal' value='Edit'>&nbsp;&nbsp;</td>"
      
       /*  s+="    <td>  <input class='btn btn-primary edit' id='editbutton' onclick='getData(this);' type='button' name='edit' data-toggle='modal' data-target='#myEditModal' value='Edit'>&nbsp;&nbsp; <input class='btn btn-danger' type='button'  onclick='deleteData(this);' data-toggle='modal'  assesmentId="+object[i].assessmentId+" data-target='#myDeleteModal' value='Delete' /></td>"
          */ 
        s+="</tr>"
      
       sn++;
        	 }
        	 
        	 $("#data").append(s);
        	 }//
        },error:function(){
//        	alert("err");
        }
       
    });
	
}


</script>
<!-- /* For Edit Functionlty */ -->
<script>
function getData(curr){
	
	var courseId=$(curr).attr("courseId");
//	alert(courseId);
	/* alert(assmentType+"-"+courseName+"-"+level); */
 /*    This is for removeing all msg */

 $('#course_edit_Name_msg').empty();
 $("#success-msg").empty();
 
		
	
 /*    This is for removeing sucess-msg */
 
var count=0;
	$(curr).parent().parent().children().each(function(){
	
	
    if(count==0){
    	
      $('#course_edit_Id').val(courseId);
       }
	  if(count==1){
	  $('#course_edit_Name').val($(this).html());
	  }
	 
 count++;

	});	

	}
	 
</script> 
<script >
function getUpdate(){
	 if($('#course_edit_Name_msg').html()=="This is invalid" ){
//		 alert("Please fill all the currect deatils");
		 
	 }
	 else{
	//alert("you are updating records");
	var fsUpdatedata=$("#editassgn").serialize();
	//twitter bootstrap script
   // alert(fsUpdatedata);
		$.ajax({
			type : "get",
			data: fsUpdatedata,
			url : "<%=application.getContextPath()%>/EditCourseAction",
			success : function(data) {

				//alert(data);
				$(
						'#contact_dialog .modal-header .modal-title')
						.html(
								"Result");
				$(
						'#contact_dialog .modal-body')
						.html(data);
				/* $("#updateSubmit")
						.remove(); */
				//alert("Your Records has been Updated Successfully...");
				$("#success-msg")
						.html(
								"<div class='alert alert-success fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+ " <strong>Success!!!</strong>  Course has been Updated Successfully..."
										+ "</div>");
				
				
				 myLoad();
				
			},
			error : function(jqXHR,
					status, error) {
				console.log(status
						+ ": "
						+ error);

				$("error-msg")
						.html(
								"<div class='alert alert-danger fade in' style='text-align: center;'>"
										+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
										+ "<strong>Sorry!!!</strong>  Course has not been Updated Successfully..."
										+ "</div>");
			}
		
		
		});
	 
		
	 }//else
	
}//function


</script>

	

</body>
</html>