<!-- 
   @author Chitranshu Gupta
 -->

<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<%@page
	import="com.nacre.online_assesment.form_bean.AssessmentDetailsBean"%>
<%@page import="com.nacre.online_assesment.dto.AssesmentDTO"%>
<%
   AssessmentDetailsBean assessment = (AssessmentDetailsBean)session.getAttribute("assessment");
%>

<body class="no-skin">
	<jsp:include page="assesmentHeader.jsp"></jsp:include>
	<div class="main-container" id="main-container">
		<div class="container">
			<br>
			<div class="row">
				<div class="col-sm-6">
					<span
						style="background-color: #fafafa; color: #438eb9; padding: 5px; font-size: 14px;">
						<%=assessment.getAssessmentName() %>
					</span>
				</div>
				<div class="col-sm-6" align="right">
					<span
						style="background-color: #fafafa; color: #438eb9; padding: 5px; font-size: 14px;">Remaining
						Time: <span id="time"></span> minutes
					</span> &nbsp; <input type="button" value=" Finish " id="btnFinish"
						class="btn btn-success" title="Test Finish" /> &nbsp;&nbsp;
				</div>

			</div>
			<span><input type="hidden" id="assessmentQuesId"></span>
			<hr />
			<div class="row"
				style="border: 1px lightgray solid; box-shadow: 10px 10px 10px lightgray;">

				<div class="col-sm-5">
					<h4>Question:</h4>
					<hr />
					<h5>
						Q<span id="quesNo"></span><span>. </span><span id="ques"></span>
					</h5>
				</div>
				<div class="col-sm-5" style="border-left: 1px lightgray solid;">
					<h4>Answers:</h4>
					<hr />
					<form role="form">
						<div id="ans"></div>
					</form>
					<ul class="pager">
						<li><a href="#" id="previous">Previous</a></li>
						<li><a href="#" id="next">Next</a></li>
					</ul>
				</div>
				<div class="col-sm-2" style="border-left: 1px lightgray solid;">
					<ul class="pagination">
						<%
			int noOfQues= assessment.getAssessmentTotalQuestions();
			int i;
			for(i=1; i<=noOfQues; i++)
			{
				if(i<10)
				{%>
						<li><a href="#" id='btn<%=i%>'
							class="qnum"
							for='<%=i%>'>0<%=i%></a></li>
						<% }
				else{
			     %>
						<li><a href="#" class="qnum"
							style="background-color: #438eb9; color: fff;" for='<%=i%>'><%=i%></a></li>
						<%} 
				}%>
					</ul>
				</div>
			</div>
		</div>
		<br />
		<br />
	</div>
	<div class="container">
	<div class="row">
	   <div class="col-sm-10"></div>
		<div class="col-sm-2">
		
		 <span style="background-color: #fafafa; color: #438eb9; padding:5px;" >
		     <label style="background-color:#337ab7; margin:auto; width:10px; height:10px;" ></label> &nbsp; 
		     <label>Attempting</label>
		 </span>
		 <br/>
		 <span style="background-color: #fafafa; color: #438eb9; padding:5px;" >
		     <label style="background-color:#4caf50; margin:auto;  width:10px; height:10px;" ></label> &nbsp; 
		     <label>Attempted</label>
		 </span>
		 <br/>
		  <span style="background-color: #fafafa;  color: #438eb9; padding:5px;" >
		     <label style="background-color:#d9534f; margin:auto; width:10px; height:10px;" ></label> &nbsp; 
		     <label>Not Attempted</label>
		 </span>
		 <br/>
		 
		
		</div>
	  </div>
	</div>
	<!-- /.main-container -->

</body>

  <div class="footerPosition">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
   <jsp:include page="../common/common_js.jsp"></jsp:include>
<script type="text/javascript">

var remainTime =0 ;
var userId = <%=request.getSession().getAttribute(StringConstants._SESSION_USER_ID)%>;
var remainingTime = "<%=assessment.getAssessmentDuration()%>:00";
var assessmentId= <%=assessment.getAssessmentId()%>	
var noOfQuestions= <%=assessment.getAssessmentTotalQuestions()%>

	var tempInd=1;
	var check ="";
	var selectedOptions;
	var assessmentQuesId;
	var userId;
	var remainingTime;
	var assessmentId;
	var noOfQues;
	var no;
	var detailSet;
	
	
	function currentDetails(){		
			$(".selectedOptions:checked").each(function(){
				check +=$(this).val()+",";	
			});
			selectedOptions = check;
			assessmentQuesId = $("#assessmentQuesId").val();
			
			
			userId = <%=request.getSession().getAttribute(StringConstants._SESSION_USER_ID)%>;
			remainingTime = $("#time").html();
			assessmentId= <%=assessment.getAssessmentId()%>;
			noOfQues= <%=assessment.getAssessmentTotalQuestions()%>
			no = $("#quesNo").html();		
	}
	
function checkSelectedQuestion(b){
	if(b){
		tempInd=1;
	}

	currentDetails();

	detailSet={"selectedOptions": selectedOptions, "assessmentQuesId":assessmentQuesId, "userId":userId, "remainingTime":remainingTime,"assessmentId":assessmentId, "key": no, "itr":"next"};
	
				if(no < noOfQues){
					  $.ajax({
						  url:"<%=application.getContextPath()%>/GetQuestions",
						    data: detailSet,
							type : "post",
							async:true,
							success : function(quesObj) {
								
								 if(quesObj[4]=="attempted"){
									 window.location.href = '<%=application.getContextPath()%>/jsp/assesment/finishPage.jsp';
									    //alert("You have already attempted this exam..."+quesObj[4]);	   
									   }
								
								$("#quesNo").empty();
								$("#ques").empty();
								$("#assessmentQuesId").empty();
								$("#ans").empty();
							
								remainTime=parseFloat(quesObj[1]);
								
									$("#quesNo").append(quesObj[0].key);
								    $("#ques").append(quesObj[0].value[1]);
								    $("#assessmentQuesId").val(quesObj[0].value[0]);
								    assessmentQuesId=$("#assessmentQuesId").val();
								    
								    var arr=[];
								    var count=0;
								    
											    
								    for(var ind=0; ind < quesObj[2].length; ind++)
						    		{
						    	       if(assessmentQuesId==quesObj[2][ind].assessmentQuestionId)
								    	{
								         arr[count]=quesObj[2][ind].selectedOption;
						                 count++;
								    	}	
						    		}
								    
								    var i=0;
								    for(var ind = 2; ind < quesObj[0].value.length; ind++)
							    	{	
								       if(arr[i]==quesObj[0].value[ind][1] || arr[i+1]==quesObj[0].value[ind][1] || arr[i+2]==quesObj[0].value[ind][1] || arr[i+3]==quesObj[0].value[ind][1])
					  				     {
					  				      $("#ans").append("<div class='checkbox'><label><input type='checkbox' checked class='selectedOptions' value="+quesObj[0].value[ind][1]+">" +quesObj[0].value[ind][2]+"</label></div>");
									    	
					  				     }else{
					  					      
					  					  $("#ans").append("<div class='checkbox'><label><input type='checkbox'  class='selectedOptions' value="+quesObj[0].value[ind][1]+">" +quesObj[0].value[ind][2]+"</label></div>");
					  				    
					  				      } 
							    	}

								   
								    var keyVal=no;
								   
								    var s="#btn"+(++keyVal);
								    $(s).css("background-color", "#337ab7");
								    $(s).css("color", "#fff"); 
								    
								       if(selectedOptions!=""){
										    var s="#btn"+(--keyVal);
										    $(s).css("background-color", "#4caf50");
										    $(s).css("color", "#fff"); 
								    	}
								       else {
								    	
									    	var s="#btn"+(--keyVal);
										    $(s).css("background-color", "#d9534f");
										    $(s).css("color", "#fff");
								        }
										if(tempInd<=noOfQuestions){
											checkSelectedQuestion();
											tempInd++;
									    }
							},
							error:function(){
								
							}
					});
					 
				  }
				 check ="";
  }
	
detailSet={"assessmentQuesId":"","userId":userId, "remainingTime":remainingTime,"assessmentId":assessmentId};

if(noOfQuestions>0){
	
$.ajax({
	  url:"<%=application.getContextPath()%>/GetQuestions",
		type : "post",
		async:true,
		data : detailSet,
		success : function(quesObj) {
			

			 if(quesObj[4]=="attempted"){
				 window.location.href = '<%=application.getContextPath()%>/jsp/assesment/finishPage.jsp';
				    //alert("You have already attempted this exam..."+quesObj[4]);	   
				   } 
			
			
			$("#quesNo").empty();
			$("#ques").empty();
			$("#assessmentQuesId").empty();
			$("#ans").empty();
		
			remainTime=parseFloat(quesObj[1]);
			mytime();
			//console.log(remainTime);
				$("#quesNo").append(quesObj[0].key);
				$("#assessmentQuesId").val(quesObj[0].value[0]);
				assessmentQuesId= $("#assessmentQuesId").val();
		
			    $("#ques").append(quesObj[0].value[1]);
			    
			    var arr=[];
			    var count=0;
			    
						    
			    for(var ind=0; ind < quesObj[2].length; ind++)
	    		{
			    	if(assessmentQuesId==quesObj[2][ind].assessmentQuestionId)
			    	{
			    	   arr[count]=quesObj[2][ind].selectedOption;
	                   count++;
			    	}
	    		}
			    
			    var i=0;
			    for(var ind = 2; ind < quesObj[0].value.length; ind++)
		    	{
			    	 if(arr[i]==quesObj[0].value[ind][1] || arr[i+1]==quesObj[0].value[ind][1] || arr[i+2]==quesObj[0].value[ind][1] || arr[i+3]==quesObj[0].value[ind][1])
  				     {
			    	    $("#ans").append("<div class='checkbox'><label><input type='checkbox' checked class='selectedOptions' value="+quesObj[0].value[ind][1]+">" +quesObj[0].value[ind][2]+"</label></div>");
				    	
  				     }
			    	 else{
  					 
  					    $("#ans").append("<div class='checkbox'><label><input type='checkbox'  class='selectedOptions' value="+quesObj[0].value[ind][1]+">" +quesObj[0].value[ind][2]+"</label></div>");
  				    			            
			    	 }  
		    	}

			    $("#btn1").css("background-color", "#337ab7");
			    $("#btn1").css("color", "#fff");
			   
			   if(quesObj[3]==true){
			    checkSelectedQuestion(true);	   
			   }
		}
  });
}
else{
     alert("There is no question for this assessment ");
}


$(document).ready(function(){

	/*------------------------------------This code for Next button ---------------------------------------*/
	
	$("#next").click(function(){
		
		currentDetails();
 
		detailSet={"selectedOptions": selectedOptions, "assessmentQuesId":assessmentQuesId, "userId":userId, "remainingTime":remainingTime,"assessmentId":assessmentId, "key": no, "itr":"next"};
		
					if(no < noOfQues){
						  $.ajax({
							  url:"<%=application.getContextPath()%>/GetQuestions",
							    data: detailSet,
								type : "post",
								async:true,
								success : function(quesObj) {
									

									 if(quesObj[4]=="attempted"){
										 window.location.href = '<%=application.getContextPath()%>/jsp/assesment/finishPage.jsp';  
										 // alert("You have already attempted this exam..."+quesObj[4]);	   
										   }
									
									$("#quesNo").empty();
									$("#ques").empty();
									$("#assessmentQuesId").empty();
									$("#ans").empty();
								
									remainTime=parseFloat(quesObj[1]);
									//mytime();
									
										$("#quesNo").append(quesObj[0].key);
									    $("#ques").append(quesObj[0].value[1]);
									    $("#assessmentQuesId").val(quesObj[0].value[0]);
									    assessmentQuesId=$("#assessmentQuesId").val();
									    
									    var arr=[];
									    var count=0;
									    
												    
									    for(var ind=0; ind < quesObj[2].length; ind++)
							    		{								    	
									    	if(assessmentQuesId==quesObj[2][ind].assessmentQuestionId)
									    	{
							                  arr[count]=quesObj[2][ind].selectedOption;
							                  count++;
									    	}
							    		}
									    
									    var i=0;
									    for(var ind = 2; ind < quesObj[0].value.length; ind++)
								    	{
									    	if(arr[i]==quesObj[0].value[ind][1] || arr[i+1]==quesObj[0].value[ind][1] || arr[i+2]==quesObj[0].value[ind][1] || arr[i+3]==quesObj[0].value[ind][1])
						  				    {
						  				      $("#ans").append("<div class='checkbox'><label><input type='checkbox' checked class='selectedOptions' value="+quesObj[0].value[ind][1]+">" +quesObj[0].value[ind][2]+"</label></div>");
										    }
									    	else{
						  					  $("#ans").append("<div class='checkbox'><label><input type='checkbox'  class='selectedOptions' value="+quesObj[0].value[ind][1]+">" +quesObj[0].value[ind][2]+"</label></div>");
						  				    
									    	}   
								    	}
								   
									    var keyVal=no;
									   
									    var s="#btn"+(++keyVal);
									    $(s).css("background-color", "#337ab7");
									    $(s).css("color", "#fff"); 
									    
									    if(selectedOptions!="")
									    	{
											    var s="#btn"+(--keyVal);
											    $(s).css("background-color", "#4caf50");
											    $(s).css("color", "#fff"); 
									    	}
									    else {
									    	
										    	var s="#btn"+(--keyVal);
											    $(s).css("background-color", "#d9534f");
											    $(s).css("color", "#fff");
									    }
								}
						});
						 
					  }
					 check ="";
		});
   
	/*---------------------------------------This code for previous button------------------------------------*/	
	
	$("#previous").on("click",function() {
		currentDetails();
		detailSet={"selectedOptions": selectedOptions, "assessmentQuesId":assessmentQuesId, "userId":userId, "remainingTime":remainingTime,"assessmentId":assessmentId, "key": no, "itr":"pre"};
		 
					if(no > 1){
						  $.ajax({
							  url:"<%=application.getContextPath()%>/GetQuestions",
							    data: detailSet,
								type : "post",
								success : function(quesObj) {
									

									 if(quesObj[4]=="attempted"){
										    
										 window.location.href = '<%=application.getContextPath()%>/jsp/assesment/finishPage.jsp';
										 //alert("You have already attempted this exam..."+quesObj[4]);	   
										   }
									
									
									$("#quesNo").empty();
									$("#ques").empty();
									$("#assessmentQuesId").empty();
									$("#ans").empty();
									//alert(quesObj[1]);
									remainTime=parseFloat(quesObj[1]);
									//mytime();
									
										$("#quesNo").append(quesObj[0].key);
										$("#assessmentQuesId").val(quesObj[0].value[0]);
									    $("#ques").append(quesObj[0].value[1]);
									    assessmentQuesId=$("#assessmentQuesId").val();
									    
									    var arr=[];
									    var count=0;
									    		    
									    for(var ind=0; ind < quesObj[2].length; ind++)
							    		{									    	
									        if(assessmentQuesId==quesObj[2][ind].assessmentQuestionId)
									    	{
							                  arr[count]=quesObj[2][ind].selectedOption;
							                  count++;
									    	}
							    		}
									    
									    var i=0;
									    for(var ind = 2; ind < quesObj[0].value.length; ind++)
								    	{
									    	if(arr[i]==quesObj[0].value[ind][1] || arr[i+1]==quesObj[0].value[ind][1] || arr[i+2]==quesObj[0].value[ind][1] || arr[i+3]==quesObj[0].value[ind][1])
						  				    {  
									    	  $("#ans").append("<div class='checkbox'><label><input type='checkbox' checked class='selectedOptions' value="+quesObj[0].value[ind][1]+">" +quesObj[0].value[ind][2]+"</label></div>");
										    
						  				    }
									    	else{
						  					  $("#ans").append("<div class='checkbox'><label><input type='checkbox'  class='selectedOptions' value="+quesObj[0].value[ind][1]+">" +quesObj[0].value[ind][2]+"</label></div>");        
									    		}
								    	}

									    var keyVal=no;
									    var s="#btn"+(--keyVal);
									    $(s).css("background-color", "#337ab7");
									    $(s).css("color", "#fff");
									    
									    if(selectedOptions!="")
								    	{
										    var s="#btn"+(++keyVal);
										    $(s).css("background-color", "#4caf50");
										    $(s).css("color", "#fff"); 
								    	}
									    else {
											var s="#btn"+(++keyVal);
										    $(s).css("background-color", "#d9534f");
										    $(s).css("color", "#fff"); 
										  }
									}
								});
						}
					check ="";
			});

	/*-------------------------------This code for absolute buttons-----------------------------------------------*/
	
	$(".qnum").on("click",function() {
		
	var btnNo = $(this).attr("for");
		 //alert(no); 
		 currentDetails();
		 detailSet={"selectedOptions": selectedOptions, "assessmentQuesId":assessmentQuesId, "userId":userId, "remainingTime":remainingTime,"assessmentId":assessmentId, "key": btnNo, "itr":"absolute"};
		 
					  $.ajax({
						  url:"<%=application.getContextPath()%>/GetQuestions",
						    data: detailSet,
							type : "post",
							success : function(quesObj) {
								$("#quesNo").empty();
								$("#ques").empty();
								$("#assessmentQuesId").empty();
								$("#ans").empty();
								
								remainTime=parseFloat(quesObj[1]);
								//mytime();
								
									$("#quesNo").append(btnNo);
									$("#assessmentQuesId").val(quesObj[0][0]);
								    $("#ques").append(quesObj[0][1]);
								    assessmentQuesId=$("#assessmentQuesId").val();
								    
								    var arr=[];
								    var count=0;
								    
											    
								    for(var ind=0; ind < quesObj[2].length; ind++)
						    		{
								    									    	
								    	if(assessmentQuesId==quesObj[2][ind].assessmentQuestionId)
								    	{
						                  arr[count]=quesObj[2][ind].selectedOption;
						                     
						                  count++;
								    	}
								    	
						    		}
								    
								    var i=0;
								    for(var ind = 2; ind < quesObj[0].length; ind++)
							    	{
								    	if(arr[i]==quesObj[0][ind][1] || arr[i+1]==quesObj[0][ind][1] || arr[i+2]==quesObj[0][ind][1] || arr[i+3]==quesObj[0][ind][1])
					  				    {
					  				       $("#ans").append("<div class='checkbox'><label><input type='checkbox' checked class='selectedOptions' value="+quesObj[0][ind][1]+">" +quesObj[0][ind][2]+"</label></div>");
									    }
								    	else{
					  					   $("#ans").append("<div class='checkbox'><label><input type='checkbox'  class='selectedOptions' value="+quesObj[0][ind][1]+">" +quesObj[0][ind][2]+"</label></div>");
					  				     
								    	}  
							    	}
								   
								    	if(selectedOptions!="")
								    		{
										    var s="#btn"+(no);
										    $(s).css("background-color", "#4caf50");
										    $(s).css("color", "#fff");  
										   
								    		}
								    	else{
								    
										    var s="#btn"+(no);
										    $(s).css("background-color", "#d9534f");
										    $(s).css("color", "#fff"); 
										    
										    }
								    
								    
								    var keyVal=btnNo;
								    var s="#btn"+(keyVal);
								    $(s).css("background-color", "#337ab7");
								    $(s).css("color", "#fff");
							}
						});
					  check ="";
});
	
/*----------------------------------This code for finish button--------------------------*/	
	$("#btnFinish").on("click",function() {
		
		currentDetails();
				
		detailSet={"selectedOptions": selectedOptions, "assessmentQuesId":assessmentQuesId, "userId":userId ,"assessmentId":assessmentId};
		
						  $.ajax({
							  url:"<%=application.getContextPath()%>/CalculatingScore",
								type : "post",
								data : detailSet,
								success : function(quesObj) {
									
									//alert("Thank you for giving this test");
									window.location.href = '<%=application.getContextPath()%>/jsp/assesment/finishPage.jsp';
									
								},
							  error: function(){}
							});		 
	    });
	});
	
/*-----------------------------------This Code for time Counter ---------------------------------*/
	function startTimer(duration, display) {
		    var timer = duration, minutes, seconds;
		    setInterval(function () {
		        minutes = parseInt(timer / 60, 10);
		        seconds = parseInt(timer % 60, 10);
		
		        minutes = minutes < 10 ? "0" + minutes : minutes;
		        seconds = seconds < 10 ? "0" + seconds : seconds;
		
		        display.textContent = minutes + ":" + seconds;
		
		        if (--timer <= 0) {
		        	$("#btnFinish").trigger( "click" );
		        }
		    }, 1000);
	}
	
	
	function mytime(){
		
		console.log(remainTime);
	    
		    var Minutes = 60 * remainTime,
		    display = document.querySelector('#time');
		    startTimer(Minutes, display);
		
	}
	
/*----------------------------------------------------------------------------------------*/
</script>

<!-- ------------------------This code for disabling copy and paste event------------------------------ -->
<script>
//disable mouse drag select start
document.onselectstart = new Function('return false');

function dMDown(e) { return false; }

function dOClick() { return true; }

document.onmousedown = dMDown;

document.onclick = dOClick;

$("#document").attr("unselectable", "on"); 

//disable mouse drag select end
//disable right click - context menu

document.oncontextmenu = new Function("return false");

//disable CTRL+A/CTRL+C through key board start
//use this function
function disableSelectCopy(e) {
// current pressed key
    var pressedKey = String.fromCharCode(e.keyCode).toLowerCase();
    if (e.ctrlKey && (pressedKey == "c" || pressedKey == "x" || pressedKey == "v" || pressedKey == "a")) {

        return false;
    }
}

document.onkeydown = disableSelectCopy;

</script> 

</html>