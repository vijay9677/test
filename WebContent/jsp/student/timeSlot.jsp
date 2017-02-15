
				<!--	------- @author Rohit Kumar Singh batch 35 ------	-->
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
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/student_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/student_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
   
  
<div class="container" >

  <!-- <h2>Modal Example</h2> -->
  <!-- Trigger the modal with a button -->
  <br>
  <div>
  	<label id='success-msg' class='label-success'></label>
  </div>
  <div>
  	<label id='warn-msg' class='label-warning'></label>
  </div>
  
  <div id="btn btn-sel-time">
  <button type="button" id="btn1" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Click Here To Select Time</button>
  
  </div>
  
  <div>
  <button type="button" class='btn btn-primary' id="btn2"><h5> Click To View Booked Details</h5> </button>
  </div><br>
  <div id="timeSlot" align="center">
  
  <table class="table"  class="table table-hover table-striped" >
    <thead id='slotHead' >
		
	</thead>
	<tbody id='slotData'>
	</tbody>
	</table>
  
  
  </div>
  
 <!-- Link is for going on Previous  Page -->
 <a href="<%=application.getContextPath()%>/jsp/student/slotbook.jsp"><button type="button" id="btn bkother" class='btn btn-success' ><h5> Click To Book Another Slot </h5></button></a>
 <!-- Link is for going on Home  Page -->
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">

        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title" style="color: blue;">Available Time Slots :</h3>
        </div>
        
        <div class="modal-body">
        
          <p>
          	<select id="select_time" class="form-control" name="SlotSelect" style="font-size:large;">
          	
          	</select><span id='time_sel'></span>
          </p>
        </div>
        <div class="modal-footer">
          <button type="submit" id='bookSlotbtn' class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Click To Book</button>
        </div>

      </div>
      
    </div>
  </div> 

</div>

<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
     <script type="text/javascript" src="${path }/assets/js/jquery-ui.min.js"></script>

<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>

<script type="text/javascript" src="${path}/assets/js/gajananNotificationsJobpost.js"></script>


<script type="text/javascript" src="${path}/assets/js/ManishStudentNotifications.js"></script>
  <script type="text/javascript">
   
  var assesmentId="<%=request.getParameter("assID")%>";
  var alreadybkdtime;
  var bookedStatus;
  
  			/***********************************************************************************************/
  
  	   $('document').ready(function(){
								
  		 $('#btn2').hide();
  		 $('#success-msg').hide();
  		 $('#warn-msg').hide();
  		 
  	//	 $(window).load(function(){
  		
  			$.ajax({
				url:'<%=application.getContextPath()%>/GetBookedDetailsAction',
				data:{'assId':assesmentId},
				contentType:"application/json",
				dataType:"json",
				success:function(bkdSlotDetails){
					bookedStatus=bkdSlotDetails[2];
				//	alert(bookedStatus);
					
					if(bookedStatus==true){
						$('#warn-msg').show();
						$('#warn-msg').append(" YOU HAVE ALREADY BOOKED SLOT FOR THIS ASSESSMENT ");
						$('#btn1').hide();
						$('#btn2').show();
					}
				}, //success
				error:function(){
					alert("YOU HAVE NOT BOOKED ANY SLOT FOR ANY ASSESSMENT");
						
				}//error
  			});
  	 }); 
  			
  	$('document').ready(function(){
  		
  		
			$.ajax({
		        type: "POST",
		        data:{"assId":assesmentId},
		        url: "<%=application.getContextPath()%>/ValidationForBookedSlotsAction",
		        success: function(object)
		        {
		        	alreadybkdtime=object;
		        
		        }//success
		        
		        });//ajax
	
	
			/***********************************************************************************************/
		
		$.ajax({
			
			
			url :"<%=application.getContextPath()%>/GetTimeSlots",
			data:{"assId":assesmentId},
			success:function(timeSlots){
			// alert(alreadybkdtime);
		 		$('#select_time').empty();
		 		$('#select_time').append("<option label='Select Any Time' value=-1></option>");
		 		for(var slot=0;slot<timeSlots.length;slot++){
		 			if(alreadybkdtime==timeSlots[slot]){
		 				
		 			}//if
		 			else{
		 	
		 				$('#select_time').append("<option value='"+timeSlots[slot] +"'>"+timeSlots[slot] +"</option>");
		 			}//else
		 	   	}//for		
		 
		 	},	//success fun()
		 	error:function name() {
		 		alert("SORRY.... PLEASE TRY LATER");
				}//error
		 
			});	//ajax
		
		/***********************************************************************************************/
		
		$('#bookSlotbtn').on("click",function(){
			
			if($('#time_sel').html()=="This is invalid"){
				alert("Please select atleast one slot..");
			}
			else{
			
			var slotTime = $("#select_time").val();
		//	alert(slotTime);
		
		
			var obj={
					url:'<%=application.getContextPath()%>/BookSelectedSlot',
					data:{'slotTime':slotTime,"assId":assesmentId},
					success:function(data1){
					//	alert(data1);
					//	alert("YOU HAVE BOOKED SLOT SUCCESSFULLY");
						$('#btn1').hide();
						$('#btn bkother').hide();
						$('#success-msg').show();
						$('#success-msg').append("YOU HAVE BOOKED SLOT SUCCESSFULLY FOR THIS ASSESSMENT");
						<% 
							try{
								Thread.sleep(30000);
							}catch(InterruptedException e){}
							
						%>
						    var successUrl = "<%=application.getContextPath()%>/jsp/student/slotbook.jsp"; 
						    window.location.href = successUrl;
						
						
					}, //success
					error:function(){
						alert("PLEASE TRY LATER");
												
					}//error
										
			}//obj
		
			$.ajax(obj);
		
			}//else
		});	//on()
		
		/********************************************************************************************************/
		
		  $("#btn2").on("click",function(){
						
			$.ajax({
					url:'<%=application.getContextPath()%>/GetBookedDetailsAction',
					data:{'assId':assesmentId},
					contentType:"application/json",
					dataType:"json",
					success:function(bkdSlotDetails){
						$("#slotHead").empty();
						$("#slotData").empty();
						
						$("#slotHead").append("<tr><th class='bg-primary'align='center'>Assessment Name</th><th  class='bg-primary'>Booked Slot Time</th><th  class='bg-primary'>Attempt Status</th></tr>");
					
						
						$('#slotData').append("<tr><td>"+bkdSlotDetails[3]+"</td>"+"<td>"+bkdSlotDetails[0]+"</td>"+"<td>"+bkdSlotDetails[4]+"</td>");
					}, //success
					error:function(){
						alert("YOU HAVE NOT BOOKED ANY SLOT FOR ANY ASSESSMENT");
							
					}//error
										
			});//ajax
			
		//	$.ajax(obj1);
					
		});	//on()  
		
  	//	});	//load()
		
		});	//ready fun()

  
  </script>
  
  <!-- --------------------------------------------------  jquery validation ---------------------------- -->
  
   <script type="text/javascript">
 // When the browser is ready...
 $('document').ready(function(){
	//validation for level
		$("#select_time").on('blur',function(){
			 var valueLevel = $(this).val();
			 var reg = new RegExp(/^[-1]/);
			 if(valueLevel==-1){
				
				 $('#time_sel').html("Please Select One");
				 $('#time_sel').css("color","red");
			 }
			 else{
			//	 $('#time_sel').html("This is valid");
			//	 $('#time_sel').css("color","green");
			 }
	 	 });
 });
 
 </script> 				
							

</body>
</html>

