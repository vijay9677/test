
<!DOCTYPE html>
<html lang="en">
	<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:set var="path" value="<%=application.getContextPath()%>"></c:set>
	<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="Nacre Software Services Assesment"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<title>Home - Student</title>

		
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		
		
<link rel="stylesheet"
	href="${path}/assets/css/chosen.min.css">
<link rel="stylesheet"
	href="${path}/assets/css/bootstrap-datepicker.css">
	

<link rel="stylesheet" href="${path}/assets/css/bootstrap-select.min.css"/>

  <link rel="stylesheet" href="${path}/assets/css/bootstrapValidator.min.css"/>	
  
  
   <!-- Validation script for Next Round Form -->
<script>
function nextRoundFunction()  
{  
    var roundNo= document.formtest.roundno;
    var rName = document.formtest.rdescription;  
    var vDate= document.formtest.date;

if(validation11(roundNo))
{
	
	
if(validation22(rName))  
{  
	
if(validation33(vDate))
{

return true;
}
return false;
} 
return false;
}  	
return false;  
  
}
    

    
    //validation function for Round No
    function validation11(roundNo)
    {  
        var numbers = /^[0-9]+$/; 
        var max=9;
        var min=1;
        if(roundNo.value.match(numbers))  
        {  
        if ((roundNo.value<min)||(roundNo.value>max)){
        	$("#msg1").show();

        	 document.getElementById("msg1").innerHTML="numeric value must be in between 1 to 9 only ";
        	 roundno.focus();
        	 return false;   
             
        }
          document.getElementById("msg1").innerHTML=" ";
         // roundNo.focus();       
          return true;  
        }  
        else  
        {  
        	if(roundNo.value==''){
        		document.getElementById("msg1").innerHTML="Please input the Round No ";
        		roundno.focus();  
                return false;  		
        	}
        	else{
               document.getElementById("msg1").innerHTML="Please input numeric characters only ";
            // roundNo.focus(); 
            roundno.focus();
               return false ;  
        	}
        }  
     } 
    
    
    //Validation function for Round Name
    function validation22(rName)  
    {   
     var letters = /^[A-Za-z ]+$/;  
    if(rName.value.match(letters))  
    {  
    	//alert('Input OK');
    	      document.getElementById("msg").innerHTML=" ";

    return true;  
    }  
    else  
    {  
    	if(rName.value==''){
    		document.getElementById("msg").innerHTML="Please input the Round Name ";
    		//rName.focus(); 
    		rdescription.focus();
            return false; 
    	}
    	else{
             document.getElementById("msg").innerHTML="RoundName must be in characters only ";
             //rName.focus();  
              rdescription.focus();
             return false; 
    	}
    }  
    }  
    
  //validation function for date 
    function validation33(vDate)
    {
 	   if(vDate.value==''){
    		document.getElementById("msg2").innerHTML="Please input the Date ";
    		date.focus();
            return false; 
    	}
    	else{
             document.getElementById("msg2").innerHTML=" ";
            
             return true; 
    	} 
    }

 </script>
 <style>
 
 div#user-rounds-wrapper {
    width: 115%;
}
nav.navbar.navbar-default {
    margin: -1%;
    margin-top: 0%;
}
</style>
  
  
  
  
  <!--Add Placement Form Validation script -->
<script>
    function placementFunction()  
    {  
   
    	var sDate= document.testform.date2;
    	var jDate= document.testform.date1;
        var salPack= document.testform.pack;
        var agreementBond = document.testform.bond;  
        var jobType= document.testform.jobtype;

    if(validation(sDate))
    {
   
    if(validation1(jDate))  
    {	
   
    if(validation2(salPack))
    {	
   	
    if(validation3(agreementBond))
    {	
    
    if(validation4(jobType))
    {
    	return true;
    }	
     return false;
    }
    return false;
    }
    return false;
    }
    return false;
    }
      return false; 
    }

    
     
    //validation function for Selected date 
    function validation(sDate)
    {
 	   if(sDate.value==''){
    		document.getElementById("msg3").innerHTML="Please input the Selected Date ";
    		date2.focus();
            return false; 
    	}
    	else{
             document.getElementById("msg3").innerHTML=" ";
            
             return true; 
    	} 
    }
    
    //validation function for Joining date 
    function validation1(jDate)
    {
    	
 	   if(jDate.value==''){
    		document.getElementById("msg4").innerHTML="Please input the Joining Date ";
    		date1.focus();
            return false; 
    	}
    	else{
             document.getElementById("msg4").innerHTML=" ";
            
             return true; 
    	} 
    }
    
    // validation function for Package
    function validation2(salPack)
    {
    	 var floatvalue= /^([0-9]*[.])?[0-9]([ a-zA-Z])*$/;
    	 if(salPack.value.match(floatvalue))  
         {  
          document.getElementById("msg5").innerHTML=" ";
           //pack.focus();       
           return true;  
         }  
         else  
         {  
         	if(salPack.value==''){
         		document.getElementById("msg5").innerHTML="Please input the Package Details ";
         		pack.focus(); 
                 return false;  		
         	}
         	else{
                document.getElementById("msg5").innerHTML="Please input number or float value only ";
               pack.focus(); 
                return false ;   
         	}
         }    	
    }
    
   //validation function for Bond/agreement
    function validation3(agreementBond)
    {
    	 var testValue=/^[ 0-9A-Za-z][0-9A-Za-z ]*$/;
    	 if(agreementBond.value.match(testValue))  
         {  
          document.getElementById("msg6").innerHTML=" ";
          // agreementBond.focus();       
           return true;  
         }  
         else  
         {  
         	if(agreementBond.value==''){
         		document.getElementById("msg6").innerHTML="Please input the Bond Details ";
         		bond.focus();  
                 return false;  		
         	}
         	else{
                document.getElementById("msg6").innerHTML="Please input alphanumerics only ";
               bond.focus(); 
                return false ;  
         	}
         }  
      
    }
     
    // validation function for Job Type
     function validation4(jobType)
    {
    	if(jobType.value==''){
    		document.getElementById("msg7").innerHTML="Please input the JobType ";
    		jobtype.focus();
            return false; 
    	}
    	else{
             document.getElementById("msg7").innerHTML=" ";
            
             return true; 
    	} 
    }
     
   </script> 
 
  
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/hrdepartment_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->

<!-- Placement detail Link -->
<div class='row'>
<div class='col-md-4'style="">
<a  href="<%=application.getContextPath()%>/jsp/hr/showplacements.jsp"><h3><div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Check Placement Details</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end--></h3></a>
</div>
<div class='col-md-6'>
<%

String sMsg = (String)session.getAttribute("successMsg"); 

if(sMsg!=null){
%>
   <div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Success!</strong> <%=sMsg%>.
  </div>
  <%} %>


<%

String eMsg = (String)session.getAttribute("errMsg"); 

if(eMsg!=null){
%>
   <div class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Danger!</strong> <%=eMsg%>.
  </div>
  <%} 
  
  
  
  session.removeAttribute("successMsg");

  session.removeAttribute("errMsg");
  
  %>



</div>
</div>
<div class='row'>
	<div  class='col-md-2' >
</div>
<!--SelectBox for job select  -->
	<div  class='col-md-4' style=" margin: 5px;">
		<h2>Choose Job</h2>
		<select id="jobdetail" style="width: 300px;">
			<option value="0">----- Select -----</option>
		</select>
	</div>
<!-- SelectBox for round Select -->


	<div  class='col-md-4' style=" margin: 5px;">
		<h2>Select Round</h2>
		<div id='round-choose-wrapper'>
			<select id="rounddetails" class="chosen2" style="width: 300px;">
				<option value="0">----- Select -----</option>
			</select>
		</div>
	</div>
	</div>
	<!-- Round Details -->



	<div >
		<h2>User Round Information</h2>
	</div>
	<%-- <form action="<%= application.getContextPath() %>/ShortListAction" method="post"> --%>
	<div id="user-rounds-wrapper" class="container"
		style="border: lightgray solid 1px; box-shadow: 10px 10px 10px lightgray">
	<!-- 	<nav class="navbar navbar-default" role="navigation">
		 --><div class="row bg-primary" id="head" >
			<div class="col-sm-1 primary" >
				<h3><input type="checkbox" name="applicable" id="chk" value="Option1" /></h3>
			</div>
			<div class="col-sm-3 primary" ><h4>User</h4></div>
			<div class="col-sm-3 primary" ><h4>Email</h4></div>
			<div class="col-sm-3 primary" ><h4>Image</h4></div>
			<div class="col-sm-2 primary" ><h4>Status</h4></div>
		</div>
		<!-- </nav>
		 -->
<!-- 		 <form action=""
			method="post">
 -->			<div id='rounds-content-wrapper' class='row'>
				
			<div class='col-md-9'>
			<span style="text-align: center"><h3 style="color: red">Please Select the job and round</h3></span>
			</div>

			</div>
			<!-- <div>
				<input type="submit" value="shortlist" />
			</div> -->
<!-- 		</form>
 -->	</div>
	<!-- </form> -->

	<!-- Add Model -->
	<div class="container">
		<div class="row" style="text-align: right;" >

			<!-- Trigger the modal with a button -->
			<div class="col-md-4">
				<button type="button" class="btn btn-info" data-toggle="modal" id ="btnNext"
					data-target="#myModal" style ='display: none' onclick="getCheckedCheckboxesFor('applicable'); getRoundNo();">Add Next Round</button>
				<hr />
			</div>
			<!-- Trigger the modal with a button -->
			<div class="col-md-4">
				<button type="button" class="btn btn-info" data-toggle="modal" id="btnAdd"
					data-target="#myModal1" style ='display: none' onclick="getCheckedCheckboxesFor('applicable');">Add Placement</button>
				<hr />
			</div>
		</div>
	</div>

	<!-- This Modal for Next Round Records... -->
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" >&times;</button>
					<h4 class="modal-title">Add Next Round</h4>
				</div>
				
				<div class="modal-body">
					<form name="formtest" onsubmit="return nextRoundFunction();"
						action="<%=application.getContextPath()%>/NextRoundPopupAction"
						method="post" class="form-horizontal" id="nextround" role="form">
						<div class="container">

							<p>
								<span style="color: Green; font-weight: bold">Note: </span> <span
									style="color: red; font-weight: bold"> *</span> fields are
								mandatory.
							</p>

							<div class="form-group">
								<label class="control-label col-sm-2" for="round">Round
									No: <span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="text" name="roundno" class="form-control"
										id="roundno" placeholder="Enter Round No">
										<font color="red"><div id="msg1">  </div></font>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="description">Round
									Description:</label>
								<div class="col-sm-3">
									<input type="text" name="rdescription" class="form-control"
										id="rdescription" placeholder="Enter Round Description">
										<font color="red"><div id="msg">  </div></font>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="dob">Date: <span
									style="color: red; font-weight: bold">*</span></label>
								<div class="col-sm-3">
									<input type="text"  name="date" date='date' class="form-control myclass"
										id="date" placeholder="Enter Date">
										<font color="red"><div id="msg2">  </div></font>
								</div>
							</div>
						</div>

						
						<input type="hidden" id="hiddenfield" name="values" value="" />
						<!-- #messages is where the messages are placed inside -->
    					<div class="form-group">
       						 <div class="col-md-9 col-md-offset-3">
            				<div id="messages"></div>
        				</div>
    					</div>
						
						<div class="modal-footer">
							<input type="submit" value="Submit" class="btn btn-success" >
							&nbsp;&nbsp;
							<button type="reset" class="btn btn-danger">Clear</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<!--placement model  -->
	
	
	<div class="container">
	
	</div>

	<!-- This Modal For Add Records... -->
	<!-- Modal -->
	<div id="myModal1" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" >&times;</button>
					<h4 class="modal-title">Add Placements</h4>
				</div>
				
				<div class="modal-body">
					<form name="testform" onsubmit="return placementFunction();"
						action="<%=application.getContextPath()%>/PlacementAction"
						method="post" class="form-horizontal" id="addplacement" role="form"> <!-- name="form1"  -->
						<div class="container">

							<p>
								<span style="color: Green; font-weight: bold">Note: </span> <span
									style="color: red; font-weight: bold"> *</span> fields are
								mandatory.
							</p>
							<div class="form-group">
								<label class="control-label col-sm-2" for="dob">Selected Date: <span
									style="color: red; font-weight: bold">*</span></label>
								<div class="col-sm-3">
									<input type="text" date='date' name="date2" class="form-control myclass"
										id="date2" placeholder="Enter selected Date">
										<font color="red"><div id="msg3">  </div></font>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2" for="dob">Joining Date: <span
									style="color: red; font-weight: bold">*</span></label>
								<div class="col-sm-3">
									<input type="text" date='joindate' name="date1" class="form-control myclass"
										id="date1" placeholder="Enter Joining Date">
										<font color="red"><div id="msg4">  </div></font>
								</div>
							</div>
                              <div class="form-group">
								<label class="control-label col-sm-2" for="pack">Package:
								<span style="color: red; font-weight: bold">*</span>
								</label>
								<div class="col-sm-3">
									<input type="text" name="pack" class="form-control"
										id="pack" placeholder="Enter Package">
										<font color="red"><div id="msg5">  </div></font>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="bond">Bond/Agreement:
									</label>
								<div class="col-sm-3">
									<input type="text" name="bond" class="form-control"
										id="bond" placeholder="Enter Bond detail">
										<font color="red"><div id="msg6">  </div></font>
								</div>
							</div>

							  <div class="form-group">
								<label class="control-label col-sm-2" for="description">Job Type:
									</label>
								<div class="col-sm-3" name="region" id="region">
									<select id="jobtype" name="jobtypeid"  class="form-control">
									<!-- <option value="" >--select--</option> -->
 									<!-- <option value="1001">Permanent Job</option>
									<option value="1002"> Contract Based Job</option> -->
									</select>
									<font color="red"><div id="msg7">  </div></font>
								</div>
							</div>
						</div>
						
						<input type="hidden" id="hiddenfieldplacement" name="values" value="" />
						<!-- #messages is where the messages are placed inside -->
    					<div class="form-group">
       						 <div class="col-md-9 col-md-offset-3">
            				<div id="messages2"></div>
        				</div>
    					</div>
						
						<div class="modal-footer">
							<input   type="submit" value="Submit"   class="btn btn-success" >
							&nbsp;&nbsp;
							<button type="reset" class="btn btn-danger">Clear</button>
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

<!-- This is for Rajnish Jobnoti to hr -->
<script>
var path="${path}";
</script>
<script type="text/javascript" src="${path}/assets/js/RajnishJobPostNotificationsToHr.js"></script>
<!-- This is end for Rajnish Jobnoti to hr -->

	
	
<script	src="${path}/assets/js/chosen.jquery.min.js"></script>
<script type="text/javascript"	src="${path}/assets/js/bootstrap-datepicker.js"></script>
	
<script src="${path}/assets/js/bootstrap-select.min.js"></script>



<script type="text/javascript" src="${path}/assets/js/bootstrapValidator.min.js"> </script>
<script type="text/javascript">
	  var nowDate = new Date();
	var today = new Date(nowDate.getFullYear(), nowDate.getMonth(),nowDate.getDate(),0,0,0,0);
    $("[date=date]").datepicker({format:'mm/dd/yyyy', startDate: today})
    .on('changeDate', function(selected){
        startDate = new Date(selected.date.valueOf());
        startDate.setDate(startDate.getDate(new Date(selected.date.valueOf())));
        $('[date=joindate]').datepicker('setStartDate', startDate);
    }); 
     
	

    //$("#form_datetime").datepicker();
    /* var selected;
    var joiningDate;
     $("[date=date]").on("change",function(){
        selected = $(this).val();
        alert(selected);
        joiningDate = new Date(selected);
     	alert(joiningDate);  
     	$("[date=joindate]").datepicker({format:'mm/dd/yyyy', startDate: joiningDate});
     	
    });
    	 */ 
     
    
</script> 

<script type="text/javascript">
	$("document").ready(function(){
		applyOptEvent();
		/* $('#nextround').bootstrapValidator({
	        container: '#messages',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        
	        fields: {
	        	roundno: {
	                validators: {
	                    notEmpty: {
	                        message: 'The no is required and cannot be empty'
	                    }
	                }
	            },
	            rdescription: {
	                validators: {
	                    notEmpty: {
	                        message: 'The description is required and cannot be empty'
	                    },
	                    stringLength: {
	                        max: 50,
	                        message: 'The description must be less than 50 characters long'
	                    }
	                }
	            },
	            date: {
	                validators: {
	                    notEmpty: {
	                        message: 'The date is required and cannot be empty'
	                    },
	                    
	                }
	            }
	        }
	    });
		 */
		/* $("#btnNext").hide();
		$("#btnAdd").hide(); */
		 
		/* show or hide button based on check box*/
		
		function btnHide(){
		$('input:checkbox').change(function () {
    		if ($('input[type=checkbox]:checked').length > 0) {
    			$("#btnNext").show();
				$("#btnAdd").show();
    			} else {
    				$("#btnNext").hide();
    				$("#btnAdd").hide();
    		}
		});
		}
		
		
	 	
	 
		
		/* ---validation for model 2 */
		
		$('#addplacement')
		.find('[name="jobtypeid"]')
            .selectpicker()
            .change(function(e) {
                /* Revalidate the language when it is changed */
                $('#addplacement').bootstrapValidator('revalidateField', 'jobtypeid');
            })
            .end()
		/* .bootstrapValidator({
        	container: '#messages2',
        	excluded: [':disabled'],
        	feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        
        fields: {
        	date2: {
                validators: {
                    notEmpty: {
                        message: 'Date is required and cannot be empty'
                    }
                }
            },
            date1: {
                validators: {
                	
                    notEmpty: {
                        message: 'Date is required and cannot be empty'
                    },
                    
                }
            },
            pack: {
                validators: {
                    notEmpty: {
                        message: 'The package is required and cannot be empty'
                    },
                    stringLength: {
                        max: 50,
                        message: 'The title must be less than 50 characters long'
                    }
                }
            },
            bond: {
                validators: {
                    notEmpty: {
                        message: 'The bond is required and cannot be empty'
                    },
                    stringLength: {
                        max: 500,
                        message: 'The content must be less than 500 characters long'
                    }
                }
            },
            jobtypeid: {
                validators: {
                    notEmpty: {
                        message: 'Please select your Job Type.'
                    }
                }
            }
               
        } 
		})*/
    .on('error.field.bv', function(e, data) {
    //alert("err");
    	data.bv.disableSubmitButtons(true); // disable submit buttons on errors
    }).on('status.field.bv', function(e, data) {
  //   alert("success");
    	data.bv.disableSubmitButtons(false); // enable submit buttons on valid
    }); 
	

		 
		 /*  $('#myModal').on('hidden.bs.modal', function () {
			    $(this).find("input,textarea,select").val('').end();

			});  */
			
			/* Reset the Model Forms  */
			 $(function() {
			        $('#myModal').on('hidden.bs.modal', function(){
			            $(this).find('form')[0].reset();
			            $('#myModal').bootstrapValidator('resetForm', true);

			            
			        });
			        $('#myModal1').on('hidden.bs.modal', function(){
			            $(this).find('form')[0].reset();
			            
			        });
			        
			        /* $('#myModal').on('show.bs.modal', function() {
			            $('#myModal').bootstrapValidator('resetForm', true);
			        });
			        
			        
			        $('#loginModal').on('show.bs.modal', function() {
			            $('#loginForm').bootstrapValidator('resetForm', true);
			        }); */
			    });
		
    $.ajax({
	  url : "<%=application.getContextPath()%>/JobSelectAction",
		type : "post",
		success : function(obj) {
  		/*--------- Select Job -------------*/ 
		for(var ind=0; ind<obj.length; ind++){ 
			$("#jobdetail").append("<option value='"+obj[ind].jobPostId+"'>" + obj[ind].description+ "</option>");
			} 
	
			 /*  $.each(obj, function() {
				
						  $("#jobdetail").append(
								"<option value="+this.job_post_id+">" + this.description
										+ "</option>");   
				 //alert(this.job_post_id);
										
			});  */

     		$("#jobdetail").chosen(); 
        	}
 	
		});
   		$("#rounddetails").chosen(); 
   		
		$("#jobdetail").on("change", function(){
    
		var selectJob = $(this).val();
		//alert(selectJob);
		/*------- Select Rounnd ---------*/
		  $.ajax({
			  url:"<%=application.getContextPath()%>/RoundSelectAction",
			    data: {"job_post_id": selectJob},
				type : "post",
				success : function(roundObj) {
				
					$('#round-choose-wrapper').empty();
				    
			    	$('#round-choose-wrapper').append("<select id='rounddetails' class='chosen2' style='width:300px;'><option value='0'>----- Select -----</option>" );
			    	
					$.each(roundObj, function() {
	
						
								$("#rounddetails").append(
										"<option value="+this.roundId+">" + this.description
												+ "</option>");
								
	 				  $("#rounddetails").on("change",function(){
							    	
							    	var selectRound = $(this).val();
							    	//alert(selectRound);
							    	
							    
							    $.ajax({
									url:"<%=application.getContextPath()%>/FirstRoundDetailAction",
									data : {"roundId" : selectRound},
									async:true,
									success:function(obj){
										
										/* if(obj.length>0){
											$("#btnNext").show();
											$("#btnAdd").show();
											
										} */
										
										/*-----Display User Round Details  */
							 			$("#rounds-content-wrapper").html("");	
										//$("#user-rounds-wrapper").empty();
										
										//$("#AddRow").html("");
										// var s="";
									
									var userList=	obj[0];
									var statList=	obj[1];
									
									for (var i= 0; i < userList.length; i++) {
								      var s="";
							           s+="<div id='checkbox' class='col-sm-1' ><input type='checkbox'  name='applicable' id='chk' class='myObj form-control'  value='"+userList[i].userid+"'></div>"
							           s+="<div id='username' class='col-sm-3' >"+userList[i].firstname+" "+userList[i].lastname+"</div>"; 
							           s+="<div id='useremail' class='col-sm-3' >"+userList[i].email+"</div>";
							           s+="<div id='img' class='col-md-3 '><div class='container'><span class='profile-picture'><img class='img-responsive' src='"+userList[i].image+"' width='100' height='150'></span></div></div>";
							           s+="<div id='status' class='col-sm-2' >"+statList[i].status+"</div>";
							           s="<div class='row '>"+s+"</div>";
										
							          // $("#AddRow").html(s);

							     	$("#rounds-content-wrapper").append(s);
							           //$("#user-rounds-wrapper").html(s);
									
							          }//outer for
							          
							         /*  var s2 = "<div><input type='submit' value='shortlist'/></div>";
							          $("#rounds-content-wrapper").append(s2); */
									btnHide();
								
									},//sucess
									error:function(){
										
										alert("please try later");
									}
									
								});
						}); 
								 
					});
					$("#rounddetails").chosen();
				}
		  });
    });


       
    $( "#datepicker" ).datepicker();
    
    

 
}); 
/* 
//disabling past date from datepicker
var nowDate = new Date();
var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
//initializing datepicker
$('.myclass').datepicker({format:'mm/dd/yyyy', startDate: today });     
});

 */
	
	
	function applyOptEvent(){
		
		 $.ajax({
			  url : "<%=application.getContextPath()%>/JobTypeSelectAction",
				type : "post",
				async:false,
				success : function(obj) {
		  		/*--------- Select Job Type -------------*/ 
		  		//alert(obj);
		  		$('#jobtype').empty();
				$('#jobtype').append("<option value=''>Select job type </option>");
				for(var i=0; i<obj.length; i++){ 
					$('#jobtype').append("<option value='"+obj[i].jobTypeId+"'>" + obj[i].jobType+ "</option>");
					}
				
				
		        	}
		 	
				});

	
	}
</script>

<script type="text/javascript">
$(document).ready(function(){
	$("#roundno").change(function(){
	$("#msg1").hide();
	});
	
});
	var values = new Array();
	var check ="";
	var selectedOptions;
	 function getCheckedCheckboxesFor(checkboxName) {
		 
		// Using String Object		
	    	check="";
	    			
			 	$(".myObj:checked").each(function(){
						check +=$(this).val()+",";	
					});
					//selectedOptions = check;
					document.getElementById('hiddenfield').value=check;
					document.getElementById('hiddenfieldplacement').value=check;
					//alert(check);
					
					
					return check;
		 
		 // Array Object
    		/*
    		var checkboxes=document.querySelectorAll('input[name="' + checkboxName + '"]:checked');
    		
   		 	Array.prototype.forEach.call(checkboxes, function(el) {
    	 
        	values.push(el.value);
       
    		});
    			alert(values);
    
    			return values; 
    			
    			*/
    	
			} 
		 	//alert(check);
		 	 
	 		
	 
	 
	 		console.log(check);
	 
	 		//var userList= values;
	 		//console.log(userList);
	 
	 		/* var fd = new FormData(document.getElementById("nextround"));
	 		for (var i = 0; i < userList.length; i++) {
	   		 		fd.append('userList', userList[i]);
	 			}
	  */
	  
	  function getRoundNo(){
		  
		  $.ajax({
			  url : "<%=application.getContextPath()%>/AssignRoundNoAction",
				type : "post",
				async:false,
				success : function(obj) {
					//alert(obj);
		  		/*--------- Assign Round No -------------*/ 
					$('#roundno').val(obj+1);
				
				
		        	}
		 	
				});
		  
		  
	  }
	  
</script>


</body>
</html>