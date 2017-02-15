<!-- 
   @author Chitranshu Gupta
 -->
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam</title>

</head>
<body>

	<jsp:include page="assesmentHeader.jsp"></jsp:include>

	<div class="container" style="background-color:#fff; text-align: center; padding:5%; ">
		<div style="text-align:center; " id="msg"></div>
		<div style="border:1px solid lightgray; box-shadow:5px 5px 5px lightgray;padding:3%;">
		
			<div style="font-size:22px;text-align:center; padding:1%;background-color: #f0f0f0;">Select Your Assessment Details</div>
	
		<hr/><br/>
		<div class="row">
		    <div class="col-sm-2" ></div>
			<div class="col-sm-3" >
			<label>Select Assessment Type: </label>
			</div>
			<div class="col-sm-5">
			       <select class="form-control" id="assessmentType" name="assessmentTypeId" onchange="setAssessmentName()" required="required">
			            <option value="0">--------------- Select -----------------</option>
			       </select>
			
			</div>
			<div class="col-sm-2" ></div>
		</div><br/>
		<form action="<%=application.getContextPath()%>/GetAssessmentDetails">
		<div class="row">
		 <div class="col-sm-2" ></div>
			<div class="col-sm-3">
			  <label>Choose Assessment Name: </label>
			  </div>
			<div class="col-sm-5">
			    <select class="form-control" name='assessmentId' id="assessmentName" disabled="disabled" required="required">
			      <option value="0">--------------- Select -----------------</option>
			    </select>
			</div>
			<div class="col-sm-2" ></div>
		</div>
		<br/><hr/>
		<div class="row">
			<input class="btn btn-primary" id="sbmBtn" type="submit" value="Submit"/>
		</div>
		 </form>
		
	</div>
	</div>
<div id="dialog"></div>

	<div class="footerPosition">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>

<jsp:include page="../common/common_js.jsp"></jsp:include>
<script type="text/javascript">
$.ajax({
	  url:"<%=application.getContextPath()%>/SelectAssessmentTypes",
		type : "post",
		success : function(Obj) {

			$.each(Obj, function() {
				
						$("#assessmentType").append(
								"<option value="+this.assesmentTypeId+">" + this.assesmentTypeName
										+ "</option>");
			});
		}
	});
	
function setAssessmentName() {
	
	$("#assessmentName").attr( "disabled", false );
	
	  var assessmentTypeSel = $("#assessmentType").val();
	  
	  $.ajax({
		  url:"<%=application.getContextPath()%>/GetAllAssessments",
		    data: {"assessmentTypeId": assessmentTypeSel},
			type : "post",
			success : function(Obj) {
				$("#assessmentName").empty();
				$("#assessmentName").append(
				           "<option value='0'>--------------- Select -----------------</option>");
				$.each(Obj, function() {
					
				       $("#assessmentName").append(
					           "<option value="+this.assesmentId+">" + this.assesment
					                    + "</option>");
				});
			},
		    Error : function(){alert("Please Choose One...")}
		});
	 
	}
	
	
	$("#sbmBtn").on("click", function(){
		 var assessmentTypeSel = $("#assessmentType").val();
		 var assessment = $("#assessmentName").val();
		 if(assessmentTypeSel != 0 && assessmentTypeSel != null)
			 {
			 if(assessment != 0  && assessment != null){
				 return true;
			 }else{
				 $("#msg").html("<div class='alert alert-danger'>Please Choose Assessment Name...</div>");
				 
				 return false;
			 }
			 
			 
			 }
		 else{
			 $("#msg").html("<div class='alert alert-danger'>Please Select Assessment Type...</div>");
			 
			 return false;
		 }
		
	});
</script>

</body>
</html>