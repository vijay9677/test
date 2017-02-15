<!-- 
   @author Chitranshu Gupta
 -->

<%@page import="java.util.Properties"%>
<%@page import="com.nacre.online_assesment.util.StringConstants"%>
<%@page import="com.nacre.online_assesment.form_bean.AssessmentDetailsBean"%>
<%@page import="java.util.Date"%>
<%@page import="com.nacre.online_assesment.dto.AssesmentDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam</title>

</head>
<body>
	<jsp:include page="assesmentHeader.jsp"></jsp:include>
	<%
	java.util.ArrayList list=null;

	AssessmentDetailsBean assesmentDetails = null;
	if(request.getAttribute("assessmentDetails")!=null){
		
		list = (java.util.ArrayList) request.getAttribute("assessmentDetails");
		//out.println(list);


		for (int ind = 0; ind < list.size(); ind++) {
			
			assesmentDetails = (AssessmentDetailsBean) list.get(ind);
			//out.println(assesmentDTO);
		}

		session.setAttribute("assessment", assesmentDetails);
	}
	else{
		
		response.sendRedirect("/assessmentType.jsp");
	}
	%>
<div class="container" >
<div class='row'>
<div class='col-md-1'></div>
<div class='col-md-10' style="background-color: #fff;">
	
	    <div class='row' style="padding: 15px;padding-bottom: 0px;">
			<div class='col-sm-2'><a href='<%=application.getContextPath() %>/jsp/student/student_home.jsp' 
			class='btn btn-primary' ><span class='glyphicon glyphicon-home'></span>&nbsp; Go To Home</a>
			</div>
	        <div class='col-sm-8'>
			<h3 style="text-align: center;"><b>Instruction</b></h3>
			</div>
		  </div>
			<hr />
			<div class='row'>
			<div style="text-align:center;" id="msg"></div>
			<div class="col-sm-6">
				<br /> 
				<label><b>
				<%=assesmentDetails.getAssessmentName()%> - </b>
				<%=assesmentDetails.getAssessmentDate()%>
						
				</label>
			</div>
			<div class="col-sm-6" align="right">
				<br /><label><b>Duration:</b> <%=assesmentDetails.getAssessmentDuration()%> minutes, </label>
				 <label><b>Total Marks:</b> <%=assesmentDetails.getAssessmentTotalMarks()%></label><br/>
				 <label><b>Total Questions:</b> <%=assesmentDetails.getAssessmentTotalQuestions()%></label>
				
			</div>
			
		</div>
		<div class="row">
			<div class="col-sm-12">
			     <%=assesmentDetails.getAssessmentDesc()%>
				<br /><!-- <b>Note:</b> It has no negative marking. -->
			<%@ page import = "java.util.ResourceBundle" %>
			<%	
	
			 ResourceBundle p = ResourceBundle.getBundle("examInstructions");
			
			String instruction1 = p.getString("Instruction1");
			String instruction2 = p.getString("Instruction2");
			String instruction3 = p.getString("Instruction3");
			String instruction4 = p.getString("Instruction4");
			String moreDetails = p.getString("MoreDetails");
			String note = p.getString("Note");
			
			%>
			<br/>
		    
			<div><strong>1.</strong> <%=instruction1 %></div>
			<div><strong>2.</strong> <%=instruction2 %></div>
			<div><strong>3.</strong> <%=instruction3 %></div>
			<div><strong>4.</strong> <%=instruction4 %></div>
			<div><strong>* </strong> <%=moreDetails %></div>
			<div><strong>Note: <%=note %></strong> </div>
			<br/>
			</div>
			</div>
		<hr />
		<div class="row" style="text-align: center;">
			<button type="button" class="btn btn-primary" id="startbtn" style='border-radius:5px;'><span class='glyphicon glyphicon-edit'></span> Test Begin </button>
		</div>
		<hr />
	</div>
	</div>
</div>

   <jsp:include page="../common/common_js.jsp"></jsp:include>

	<script type="text/javascript">
	

       $("#startbtn").on("click", function(){
    	      
    	   var assessmentId = <%=assesmentDetails.getAssessmentId()%>;
		   var userId = <%=request.getSession().getAttribute(StringConstants._SESSION_USER_ID)%>;
    	   
			$.ajax({
				
				url:"<%=application.getContextPath()%>/GetExamStatus",
				data:{"assessmentId":assessmentId,"userId":userId},
				success:function(status){
					
					if(status=="attempted"){
						
						$("#msg").html("<div class='alert alert-danger'><strong>Warning!</strong> You have already attended this exam...</div>");
						//alert("You have already attended this exam...")
					}
					else{
					var winFeature = 'location=no,toolbar=no,menubar=no,resizable=no,scrollbars=yes,fullscreen=yes';
					winFeature+=', width='+screen.width;
					winFeature+=', height='+screen.height;
					window.open('<%=application.getContextPath()%>/jsp/assesment/takeAssessment.jsp','null', winFeature);
					}
					
					
				},
				error:function(){
					
					alert("Status is not available");
				}
				
			});
       });
			
	</script>

	<div class="footerPosition">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>

</body>
</html>