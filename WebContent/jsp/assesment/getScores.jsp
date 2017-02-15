<!doctype html>
<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<html>
<body class="no-skin">
	<jsp:include page="assesmentHeader.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
<div class="col-sm-2" id='homebtn' style='padding:0px;'><br/>
<a href='<%=application.getContextPath()%>/jsp/student/student_home.jsp' 
class='btn btn-primary' style='border-radius:0px 15px 15px 0px;'><span class='glyphicon glyphicon-home'></span>&nbsp; Go To Home</a>
</div>
 <div class="col-sm-8">
	<div 
		style="padding: 3%;  border: 1px lightgray solid; background-color: #fff; box-shadow: 10px 10px 10px lightgray;">
		<form>
		<div style="width:100%;text-align:center;">
			<span style="font-size:24px; margin:auto; padding:5px; width:auto;background-color: #438eb9; color:#fff;">Exam Scores Details</span>
			</div>
			<hr />
			<div class="row">
					<div class="col-sm-4"  style="border-right:1px lightgray solid; text-align:center;">
					  <img  id="pic" class="img-rounded" alt="pic" width="135" height="140">
					</div>  
				<div class="col-sm-8">
				<div class="row">
					<div class="col-sm-5" ><br/>
						<label id="name"><strong>Name :  </strong></label><br> 
						<label id="tech"><strong>Technology :  </strong></label>
					</div>
					<div class="col-sm-7" ><br/>
						<label id="mobile"> <strong>Mobile No. : </strong> </label> <br/>
						<label id="email"> <strong>E-mail : </strong> </label>
					</div>
					</div>
					<hr />
				<div class="row">
					<div class="col-sm-10" style="padding:2%;"><br/>
										<label id="assessmentScore"> </label><br> 
					</div>
				</div>
			</div>
			</div>
			
			<hr/>
			<div style="text-align:center;" id="printbtn">
			<button type="button" class="btn btn-primary" onclick="printResult()"><span class='glyphicon glyphicon-print'></span>&nbsp; Print </button>
			</div>
			<hr/>
		</form>
	</div>
	</div>
<div class="col-sm-2"></div>
</div>	
</div>
<div id="footerdiv">
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
	<jsp:include page="../common/common_js.jsp"></jsp:include>
	
	<script type="text/javascript">
	
	var userId= <%=request.getSession().getAttribute(StringConstants._SESSION_USER_ID)%>;
	
	//alert(userId);
		$.ajax({
		  url:"<%=application.getContextPath()%>/GetScoreAction",
		    data: {"userId" : userId},
			type : "post",
			success : function(resultObj) {
				
				/* var image = new Image();
				image.src = resultObj[0].Image; */
				if(resultObj.length>0){
				$("#pic").attr("src", resultObj[0].Image);		
				$("#name").append(resultObj[0].firstName+" "+resultObj[0].lastName);
				$("#tech").append(resultObj[0].technology);
				$("#mobile").append(resultObj[0].mobileNo);
				$("#email").append(resultObj[0].email);
				if(resultObj[0].marks!=''){
				 	for(var ind=0; ind<resultObj.length; ind++)
			    	{
				    	//var assessmentNo=ind+1; 
				    	if(ind==(resultObj.length-1))
				    		{
				    		
				    		$("#assessmentScore").append("<span style='color: #436494;'><strong>"+resultObj[ind].assessmentName + " ("+resultObj[ind].course+") - Marks : </strong><strong style='color: #436494;'>"  + resultObj[ind].marks+"<strong> / </strong>"+ resultObj[ind].totalMarks +"</span><strong style='color:red;'> (Current) </strong><br/>");
				    		}
				    	else{
				    	$("#assessmentScore").append("<strong>"+resultObj[ind].assessmentName + " ("+resultObj[ind].course+") - Marks : </strong><strong style='color: #436494;'>"  + resultObj[ind].marks+"</strong><strong> / </strong>"+ resultObj[ind].totalMarks +"<br/>");
			    	}
			    	}
				}
				else{
					$("#assessmentScore").empty();
					$("#assessmentScore").html("<div  style='text-align:center;'><strong>No Record Founds</strong></div>");
				}
				
			}else{
				$("#assessmentScore").empty();
				$("#assessmentScore").html("<div class='alert alert-danger' style='text-align:center;'><strong>YOU DID NOT ATTEMPTED ANY EXAMS</strong></div>");
			
			}
			}
			
			});
		
		
		function printResult(){
			
			$("#printbtn").hide();
			$("#homebtn").hide();
			$("#footerdiv").hide();
			
			print();
			
			$("#printbtn").show();
			$("#homebtn").show();
			$("#footerdiv").show();
			
		}
	</script>
</body>
</html>