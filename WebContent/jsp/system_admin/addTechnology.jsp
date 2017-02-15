


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

 <script type="text/javascript" src="${path}/assets/js/AvoidingBackButton.js">
	    
	    </script>
			
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
<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
								<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									<b class="blue" >Add Technology Info</b>
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
				<button type="button" id="addtechnology" onclick=addTechnology() class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Technology</button>
				<hr />
			</div>
		</div>
	</div>

	<div class="table-responsive"
		style="border: lightgray 1px solid; box-shadow: 5px 5px 5px lightgray; width: 100%;">
		<table class="table" id="table" style="text-align: center;">
				<thead class='bg-primary'>
					<tr class='bg-primary'>
						<th class='bg-primary'>Sr.No</th>
						<th class='bg-primary'>Technology Name</th>
						
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
					<h4 class="modal-title">Add Technology</h4>
				</div>


				<div class="modal-body">


					<div class="container">




						<form class="form-horizontal" id="form_Submit"
							enctype="multipart/form-data" method="get"
							action="<%=application.getContextPath()%>/AddtechnologyAction">

							<p>
								<span style="color: Green; font-weight: bold">Note: </span> <span
									style="color: red; font-weight: bold"> *</span> fields are
								mandatory.
							</p>
					
                            <div class="form-group">
								<label class="control-label col-sm-2" for="technology_Name">Technology Name
									: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="technology_Name" name="technology_Name"
										class="form-control" id="technology_Name"
										placeholder="Enter technology Name">
								</div>
								<span id="technology_Name_msg"></span>
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
						<form class="form-horizontal" id="editassgn" role="form" action="<%=application.getContextPath()%>/EditTechnologyAction" method="get">
							
							
							<div class="form-group">
								<label class="control-label col-sm-2" for="technology_edit_Id">Technology
									Id : <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="technology_edit_Id" name="technology_edit_Id"
										class="form-control" id="technology_edit_Id"
										placeholder="Enter technology Id" readonly="readonly">
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-sm-2" for="technology_edit_Name">Technology Name
									: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="technology_edit_Name" name="technology_edit_Name"
										class="form-control" id="technology_edit_Name"
										placeholder="Enter  technology Name">
								</div>
								<span id="technology_edit_Name_msg"></span>
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
<script type="text/javascript">

                 <!-- ******************************** <jQuery ADD Technology Form Validation code ------------------------------->
   <script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>



  
   <script type="text/javascript">
 // When the browser is ready...
 $('document').ready(function(){
	
 
	// Setup form validation on the technology name
	 $("#technology_Name").on("blur",function(){
		var val= $(this).val();
		//alert(val);
		var reg = new RegExp(/^[a-zA-Z.]/);
		if(reg.test(val)){
			$('#technology_Name_msg').html("This is valid");

			$('#technology_Name_msg').css("color","green");
		}
		else{
			$('#technology_Name_msg').html("This is invalid");
			$('#technology_Name_msg').css("color","red");
			
		}
		
	 });
 });
		
  </script>
  
    <!-- ******************************** <jQuery Edit technology Form Validation code ------------------------------->
                                                        
  
   <script type="text/javascript">
 // When the browser is ready...
 $('document').ready(function(){
	
 
	// Setup form validation on the assesment name
	 $("#technology_edit_Name").on("blur",function(){
		var val= $(this).val();
		var reg = new RegExp(/^[a-z A-Z.]/);
		if(reg.test(val)){
			$("#technology_edit_Name_msg").html("This is valid");

			$('#technology_edit_Name_msg').css("color","green");
		}
		else{
			$('#technology_edit_Name_msg').html("This is invalid");
			$('#technology_edit_Name_msg').css("color","red");
			
		}
		
	 });
 }
	);

 
    	
  </script>
<!-- ******************************** </jQuery Edit technology Form Validation code ------------------------------->



<script>
	
	
	function addTechnology(){
	
		$('#technologyName').empty();
	   
	   
	    //Empty the Technology Form
	    $('#technology_Name').val("");
	    $("#success-msg").empty();
	   
	    	
	}
	
</script>


<script>
/* must apply only after HTML has loaded */
$(document).ready(function () {
	
	
	
	
	
	myLoad();
	
 
    $("#submitButton").on('click', function() { 
    	
    var formdata=$("#form_Submit").serialize();
   // alert(formdata+"form data");
//    $("#submitButton").click(function(){
	
	 if($('#technology_Name_msg').html()=="This is invalid" || $('#technology_Name').val()==''){
		 $("#error-msg")
			.html(
			"<div class='alert alert-danger fade in' style='text-align: center;'>"
			+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
			+ "<strong>Sorry!!!</strong> Please Fill correct details..."
			+ "</div>");
	 }
	  else if($('#technology_Name_msg').html()==""  ){
		  $("#error-msg")
			.html(
			"<div class='alert alert-danger fade in' style='text-align: center;'>"
			+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
			+ "<strong>Sorry!!!</strong> Please Fill details..."
			+ "</div>");
		 } 
		 else {
			 
		//	 alert(" ajax");
      $.ajax({
              url: "<%=application.getContextPath()%>/AddTechnologyAction",
					    data :formdata,
						type : "post",
						success : function(data) {
							//alert(" success");
						//	alert(data);
							if(data.sMsg!=undefined){
								$("#success-msg").html(
										"<div class='alert alert-success fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+data.sMsg
								        + "</div>");
									myLoad();					
										
							}
							else if(data.fMsg){
								$("#success-msg").html(
										"<div class='alert alert-danger fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+data.fMsg
								        + "</div>");
			
							
							}else{
								$("#success-msg").html(
										"<div class='alert alert-danger fade in' style='text-align: center;'>"
										+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
										+data.ERR
								        + "</div>");
			
												
							}
									
						
						},//sucess
					   error : function() {
						console.log(status
						+ ": "
						+ error);

				         	$("#error-msg")
								.html(
								"<div class='alert alert-danger fade in' style='text-align: center;'>"
								+ "<a href=''#' class='close' data-dismiss='alert'>&times;</a>"
								+ "<strong>Sorry!!!</strong> Your Records has not been Saved Successfully..."
								+ "</div>");
									}//error
								});//error
		 }
						});
                      
    
					});
					
function myLoad(){

	var sn=1;
	var technologyID=0;
	$.ajax({
        type: "POST",
        url: "<%=application.getContextPath()%>/GetTechnologyAction",
        success: function(object)
        {
        	if(object==''){$("#data").html("No Technology Available In Table");}
        	else{
        	$("#data").empty();
        	var	s="";
        	 for (var i= 0; i < object.length; i++) {
        		 console.log(object[i]);
        s+="<tr  class='success' style='background-color: lightgray; padding: 5px; height: auto;'>" 
        	
        s+="	<td >"+sn+"</td>"
      // s+="	<td >"+object[i].technologyId+"</td>"
        s+="	<td >"+object[i].technology+"</td>"
      
        s+="    <td>  <input class='btn btn-primary edit' id='editbutton' onclick='getData(this);'technologyID="+object[i].technologyId+" type='button' name='edit' data-toggle='modal' data-target='#myEditModal' value='Edit'>&nbsp;&nbsp;</td>"
      
       /*  s+="    <td>  <input class='btn btn-primary edit' id='editbutton' onclick='getData(this);' type='button' name='edit' data-toggle='modal' data-target='#myEditModal' value='Edit'>&nbsp;&nbsp; <input class='btn btn-danger' type='button'  onclick='deleteData(this);' data-toggle='modal'  assesmentId="+object[i].assessmentId+" data-target='#myDeleteModal' value='Delete' /></td>"
          */ 
        s+="</tr>"
      
       sn++;
        	 }
        	 $("#data").append(s);
        }
        },error:function(){
        	//alert("err");
        }
    });
	
}


</script>



<!-- /* For Edit Functionlty */ -->
<script>
function getData(curr){
	
	var technologyId=$(curr).attr("technologyId");
	
 $('#technology_edit_msg').empty();
 
		
	
 /*    This is for removeing sucess-msg */
 
var count=0;
	$(curr).parent().parent().children().each(function(){
	
	
    if(count==0){
    	
      $('#technology_edit_Id').val(technologyId);
       }
	  if(count==1){
	  $('#technology_edit_Name').val($(this).html());
	  }
	 
 count++;

	});	

	}
	 
</script> 
<script >
function getUpdate(){
	 if($('#technology_edit_Name_msg').html()=="This is invalid" ){
	//	 alert("Please fill all the currect deatils");
		 
	 }
	 else{
//	alert("you are updating records");
	var fsUpdatedata=$("#editassgn").serialize();
	
	//twitter bootstrap script
	
  //  alert(fsUpdatedata);
	
		$.ajax({
			
			type : "get",
			data: fsUpdatedata,
			url : "<%=application.getContextPath()%>/EditTechnologyAction",
			success : function(data) {
            //   alert(data);
               debugger;
			if(data.sMsg!=undefined){
			//	 alert("******");
				$("#success-msg").html(
							"<div class='alert alert-success fade in' style='text-align: center;'>"
							+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
							+data.sMsg
					        + "</div>");
						myLoad();					
							
				}
				else if(data.fMsg!=undefined){
					$("#success-msg").html(
							"<div class='alert alert-danger fade in' style='text-align: center;'>"
							+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
							+data.fMsg
					        + "</div>");
					}
 			
				
				
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
										+ "<strong>Sorry!!!</strong> Technology has not been Added Successfully..."
										+ "</div>");
			}
		
		
		});
	 
		
	 }//else
	
}//function



</script>
	 
</body>
</html>