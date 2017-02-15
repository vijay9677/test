<!-- Srinivas N -->
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.nacre.online_assesment.dto.TechnologyDTO"%>
<%@page import="org.apache.poi.ss.formula.ptg.TblPtg"%>
<%@page import="com.nacre.online_assesment.vo.ClientAddressDetailVo"%>
<%@page import="com.nacre.online_assesment.dto.ClientDTO"%>
<%@page import="java.util.List"%>


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
		<!-- page specific plugin styles -->

		<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/jquery-ui.css" />

		<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/bootstrap-editable.min.css" />
<!-- page specific plugin styles -->

<link rel="stylesheet" href="assets/css/daterangepicker.min.css" />
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/colorpicker.min.css" />


		
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/corporate_relation_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/corporaterelation_menu.jsp"></jsp:include>			<div class="main-content">
				<div class="main-content-inner">
				
			

					<div class="page-content">
					
				
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >Add Job Posting</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
<!-- write your code here -->
 
<%-- <!-- text fonts -->
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />


<!-- ace settings handler -->
<script src="assets/js/ace-extra.min.js"></script>


 --%>

	



<!-- ----------------------------for success msg box----------------------- -->
<div>
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
		<form method="post" id='target' action="<%=application.getContextPath()%>/addJobPostingAction">
							
			<%
							
				/* RequestDispatcher rd = request.getRequestDispatcher("/JobPostingClientAddress");
				rd.include(request, response); */
				List<ClientAddressDetailVo> clientvalue = (List<ClientAddressDetailVo>) session.getAttribute("ClientAddressDetailVo");

								/* System.out.print("clientvalue in jsp--" + clientvalue); */
				if (clientvalue != null) {
			%>
								
								
			<div class="row">
					<div class="col-md-4">
						<label>Select Location:</label><label style="color: red">*</label>
						<select required="required" id="address" name="addId" class='form-control'>

								<option value=''>Select Location</option>
									<%
										for (int i = 0; i < clientvalue.size(); i++) {
									%>

								<option value="<%=clientvalue.get(i).getAddress_id()%>"
										><%=clientvalue.get(i).getLocation()%></option>

											<%
												}
											%>
							</select>
						</div>

					<div class="col-md-2">
							<label>City:</label><br>
							<label id='city' class='bg-primary' style='color:white'></label>
					</div>
					
					<div class="col-md-2">
							<label>State:</label><br><label id='state' class='bg-primary' style='color:white'></label>
					</div>
									
					<div class="col-md-2">
						  <label>Country:</label><br><label id='country' class='bg-primary' style='color:white'></label>
					</div>
									
					<div class="col-md-2">
							<label>pin code:</label><br><label id='pincode' class='bg-primary' style='color:white'></label>
					</div>
									<%
										}//if cv null
										DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

										Date today = new Date();
										  String strDate = formatter .format(today );
										//Date todayWithZeroTime = formatter.parse(formatter.format(today));
									%>
					</div><!-- //row -->
								
				<div class="row">
						<div class="col-md-4">
							<label>Description:</label><label style="color: red">*</label><span id='description'></span>
							<input	class='form-control  text-input'	id='id1' type="text" name="description" required/>
						</div>
				</div><!-- row -->
								
				<div class="row">
					<div class="col-md-4">
						<label>Expected Date:</label><label style="color: red">*</label>
						<input  class='form-control' id="expectedDate" readonly value='<%=strDate%>' type="text" id='id2' name="Expected_Date" required/></div>
						<div class="col-md-4"><label>PREVIEW : </label><br><input type="text" id="alternate" size="30" readonly></div>
				</div><!-- row -->
								
				<div class="row">
						<div class="col-md-4">
							 <label for="from">Assessment Start Date:</label><label style="color: red">*</label> 
							 <input  class='form-control' type="text" readonly id="from" value='<%=strDate%>' id='id3' name="assessmentStartDate" required />
						</div>
						<div class="col-md-4">
							 <label style="color: red">*</label><label for="to">Assessment End Date:</label> 
							 <input  class='form-control' type="text" id="to" value='<%=strDate%>' readonly name="assessmentEndDate" required>
						</div>
				</div><!-- row -->
								
			   <div class="row">
					 <div class="col-md-4">
							<label>No of vacancies:</label><label style="color: red">*</label>
							<input type="text" name="noOfVacancies"	class="form-control numeric-only "  id='id4' required /><label>Enter Numeric values Only</label>
										

										<%
										    
											RequestDispatcher rdtech1 = request
													.getRequestDispatcher("/JobPostingTechnology");
											rdtech1.include(request, response);
											List<TechnologyDTO> technologyDTOslist = (List<TechnologyDTO>) request
													.getAttribute("technologyDTOslist");

											if (technologyDTOslist != null) {
										%>
										</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<label>Select Technology:</label><label style="color: red">*</label>
												<select name="technologyId"  class='form-control' id='id5' required>
													<option value=''>Select One</option>
													<%
														for (int i = 0; i < technologyDTOslist.size(); i++) {
													%>

													<option
														value="<%=technologyDTOslist.get(i).getTechnologyId()%>"><%=technologyDTOslist.get(i).getTechnology()%>
													</option>


													<%
														}//for
														}//if
													%>
												</select>
											</div>
										
										</div>
										
									</div>
								</div>
									<div class="row">
			<div class="col-md-12" style="text-align: center; padding-top: 5px;">
				<!-- This Div for using Success_Msg display -->
				<div id='success-msg1' class="success_msg" style="width: 40%;">
				</div>
			</div>
								<div class='row'>
								
								
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button id='other' onclick='userMesege()' class="btn btn-info" type="submit">
										<i  class="ace-icon fa fa-check bigger-110"></i> Submit
									</button>

									&nbsp; &nbsp; &nbsp;
									<button onclick='resetBtn()' class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> Reset
									</button>
								</div>
							</div>
								
								</div>
								<div id="first">
    <h1>Please Wait..</h1>
</div>
<div  class=”load”></div>
								
								</form>
								<!-- Row and For select location  -->
							</div>
							<!-- Container -->


							
					</div>
					<!-- /.row -->
	<!-- 			</div>
				/.page-content
			</div>
	</div>
	
	 -->
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
	
	<!-- /.main-content -->
	
<style type="text/css">
#first
{
    
    position:absolute;
    bottom:0;
    left:0;
    right:0;
    top:0;  
    opacity:0.5;
    background-color:#000;
    color:#fff;
    z-index:9999;
}

.load
{
    height:100%;
    width:100%;
    /* background-image:url('http://images2.layoutsparks.com/1/235919/walle-galaxy-sky-image.jpg'); */
    background-image:url('<%=application.getContextPath()%>/assets/img/srinivasBackGround.jpg');
}
</style>
	
			<script
			src="<%=application.getContextPath()%>/assets/js/jquery-ui.min.js"></script>


<script type="text/javascript">

$(document).ready(function(){
	$('#first').hide();
		
		});
				
		
		</script>
		<script>
$(function() {
	$("#address").on("change",function(){
		//alert("Wel-Come to the  jQuery..!");
		var aId = $(this).val();
		
			
			$("#city").empty();
			$("#state").empty();
			$("#country").empty();
			$("#pincode").empty();
			//if aId is null
			if(aId!=''){
		var obj={
			url:"<%=application.getContextPath()%>/GettingLocationCurespondingAddres",
											data : {
												"aId" : aId
											},
											success : function(details) {

												$("#city").append(details.city);
												$("#state").append(
														details.state);
												$("#country").append(
														details.country);
												$("#pincode").append(
														details.pincode);

											},
											error : function() {
												//write Error Code
												alert("Please try later");
											}
										};
									}//if
									$.ajax(obj);

								});
			});
			$(function() {
				$("#datepicker").datepicker({
					showOn : "button",
					buttonImage : "images/calendar.gif",
					buttonImageOnly : true,
					buttonText : "Select date"
				});
			});

			//for Expected date  posted 
			//https://jqueryui.com/datepicker/#min-max   look 
			$(function() {
				$("#expectedDate").datepicker({
					altField : "#alternate",
					altFormat : "DD, d MM, yy",
					minDate : -0,
					maxDate : "+3M +10D",
					required :true,
				});
			});
     
			
			//for from and to date
			//https://jqueryui.com/datepicker/#date-range

			$(function() {
				var dateFormat = "mm/dd/yy", from = $("#from").datepicker({
					defaultDate : "+1w",
					changeMonth : true,

				}).on("change", function() {
					to.datepicker("option", "minDate", getDate(this));
				}), to = $("#to").datepicker({
					defaultDate : "+1w",
					changeMonth : true
				}).on("change", function() {
					from.datepicker("option", "maxDate", getDate(this));
				});

				function getDate(element) {
					var date;
					try {
						date = $.datepicker
								.parseDate(dateFormat, element.value);
					} catch (error) {
						date = null;
					}

					return date;
				}
			});

			//validation using jquery plugins no of vacancies 
			$(document).on('keyup', '.numeric-only', function(event) {
				var v = this.value;

				if ($.isNumeric(v) === false) {
					//chop off the last char entered

					this.value = this.value.slice(0, -1);

				}
			});
			 //for printing plz wait message after pressing the submit button
		    function resetBtn(){
		    
				 $("#city").empty();
				$("#state").empty();
				$("#country").empty();
				$("#pincode").empty();
			 
				 
			 }
			 function userMesege() {
				// var description=$('.text-input').val();
				
				 if($('#id1').val()!="" && $('#id2').val()!="" && $('#id3').val()!="" && $('#to').val()!="" && $('#id4').val()!="" && $('#id5').val()!="")
			     {
					 
				    $("#first").show();
				    
				 }
				
		    	  
		      }
			
		</script>
	
</body>
</html>