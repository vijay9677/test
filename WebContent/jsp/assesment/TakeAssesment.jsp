<!-- 
   @author Chitranshu Gupta
 -->

<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam</title>

</head>
<body style="background:#b3b1b0; background-image: url('<%=StringConstants._ASSESSMENT_BACK%>');">

	<jsp:include page="assesmentHeader.jsp"></jsp:include>
	
	<br /><br/><br/>
	<div class="container"  >
	
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div style="text-align: center;">
					
					<div
						style="border: 1px solid lightgray; background-color:#fff;  border-radius: 15px;">

						<div style="font-size: 18px; text-align: center; margin: 0px; padding: 4px; background-color: #438eb9; color: #fff; border: 1px solid lightgray; border-radius: 15px 15px 0px 0px;"">Select
							Your Assessment Details
						</div>
						<div class='row' style="padding: 15px;">
						<div class='col-sm-2'><a href='<%=application.getContextPath() %>/jsp/student/student_home.jsp' 
						class='btn btn-primary'><span class='glyphicon glyphicon-home'></span>&nbsp; Go To Home</a>
								</div>
								</div>
						<div style="text-align: center;" id="msg"></div>
						
						<div class="row" style="padding: 5px;">
							<div class="col-sm-2"></div>
							<div class="col-sm-4">
								<label>Select Assessment Type: </label>
							</div>
							<div class="col-sm-4">
								<select class="form-control" id="assessmentType"
									name="assessmentTypeId" onchange="setAssessmentName()"
									required="required">
									<option value="0">-------- Select ----------</option>
								</select>

							</div>
							<div class="col-sm-2"></div>
						</div>
						<br />
						<form
							action="<%=application.getContextPath()%>/GetAssessmentDetailschange">
							<div class="row" style="padding: 5px;">
								<div class="col-sm-2"></div>
								<div class="col-sm-4">
									<label>Choose Assessment Name: </label>
								</div>
								<div class="col-sm-4">
									<select class="form-control" name='assessmentId'
										id="assessmentName" disabled="disabled" required="required">
										<option value="0">-------- Select ----------</option>
									</select>
								</div>
								<div class="col-sm-2"></div>
							</div>
							<hr />
							<div class="row">
							<button class="btn btn-primary" id="sbmBtn" type="submit">
							Submit<!-- &nbsp; <span class='glyphicon glyphicon-circle-arrow-right'></span> --></button>
							</div>
						</form>
						<br />
					</div>
				</div>
			</div>
			<div class="col-sm-2"></div>
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
				
						$("#assessmentType").append("<option value="+this.assesmentTypeId+">" + this.assesmentTypeName + "</option>");
			});
		}
	});
	
function setAssessmentName() {
	
	$("#assessmentName").attr( "disabled", false );
	
	  var assessmentTypeSel = $("#assessmentType").val();
	  
	  $.ajax({
		  url:"<%=application.getContextPath()%>/GetAllAssessments",
						data : {
							"assessmentTypeId" : assessmentTypeSel
						},
						type : "post",
						success : function(Obj) {
							$("#assessmentName").empty();
							$("#assessmentName").append("<option value='0'>-------- Select ----------</option>");
							
							$.each(Obj, function() {

									$("#assessmentName").append("<option value="+this.assesmentId+">"+ this.assesment + "</option>");
							});
						},
						Error : function() {
							alert("Please Choose One...")
						}
					});

		}

		$("#sbmBtn").on("click", function() {
							var assessmentTypeSel = $("#assessmentType").val();
							var assessment = $("#assessmentName").val();
							
							if (assessmentTypeSel != 0 && assessmentTypeSel != null) {
								
								if (assessment != 0 && assessment != null) {
									return true;
								} 
								else {
									$("#msg").html("<div class='alert alert-danger' style='padding:1%;'>Please Choose Assessment Name...</div>");
									return false;
								}

							} else {
								$("#msg").html("<div class='alert alert-danger' style='padding:1%;'>Please Select Assessment Type...</div>");
								return false;
							}

						});
	</script>

</body>
</html>