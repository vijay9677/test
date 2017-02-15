<!-- Srinivas N -->
<%@page import="com.nacre.online_assesment.vo.ClientAddressDetailVo"%>
<%@page import="com.nacre.online_assesment.dto.TechnologyDTO"%>
<%@page import="com.nacre.online_assesment.vo.GetClientDetailForEditingVo"%>
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
			
			<link rel="stylesheet"
				href="<%=application.getContextPath()%>/assets/css/jquery-ui.css" />
				
	
			<style type="text/css">
			div{
			 font-weight:bold;
			}
			</style>
			
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
									 <b class="blue" >Edit Job Posting</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
	<!-- write your code here -->
	 
 
 
 
 
 
 
 
 
 
 
 

	
<%
//getting JobPosting Details 
 
  Boolean formSubmitionResult=(Boolean)session.getAttribute("editJobPostResult");
  if( formSubmitionResult!=null){
	  Boolean result=formSubmitionResult;
	  if(result){%>
		<div class="row">
			<div class="col-md-12" style="text-align: center; padding-top: 5px;">
				<!-- This Div for using Success_Msg display -->
				<div class='alert alert-success fade in' style='text-align: center;'>
					<a href='#' class='close' data-dismiss='alert'>&times;</a>
					 <strong>Success!!!</strong>  update successful..."
					</div>
				<div id='success-msg' class="success_msg" style="width: 40%;">
				</div>
			</div> 
	<% 	  
	 request.getSession().removeAttribute("editJobPostResult");
	  }else {%>
	  <div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->
				
				<div class='alert alert-danger fade in' style='text-align: center;'>"
					<a href='#' class='close' data-dismiss='alert'>&times;</a>"
					 <strong>Sorry</strong>  Try Again ..."
					</div>
				
				
				<div id="error-msg" class="alert_msg" style="width: 40%;"></div>
			</div>
		</div>
	  
	  <% 
	  request.getSession().removeAttribute("editJobPostResult");
	  }//elsse
  }//if
  request.getRequestDispatcher("/getClientDetailsForEditingAction").include(request, response);
  List<GetClientDetailForEditingVo> Vo=(List<GetClientDetailForEditingVo>)session.getAttribute("getClientDetailForEditingVosList");
  System.out.print("GetClientDetailForEditingVo In Jsp:---"+Vo);


%>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						
						<div class="container" >
														
							<div>
							<!-- div.dataTables_borderWrap -->
										<div><!-- table Body div start -->
										
											<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												
												
												<thead>
													<tr>
														
														<th>Image</th>
														<th>Name</th>
														<th>Expected Date</th>
														<th>Technology</th>
														<th>No of Vacancies</th>
													<!-- 	<th>Job Posting Id</th> -->
													    <th>Activity</th>
														
						                            </tr>
												</thead>

              <!-- This code will used for displaying client details dynamically  -->
              
	  							<tbody>
												
								<!-- For loop is started  Displays Table Body-->
									<% for(int i=0;i<Vo.size();i++){ 
										 if(Vo!=null){
									%>
												
									<tr  style="height:10px;">
												<td>    
													 <img src="<%=Vo.get(i).getImage()%>" width="80px" height="40px">
												</td>
													
												<td><%=Vo.get(i).getClientName()%></td>	
												<td>
													 <label><%=Vo.get(i).getExpetedDate()%></label>
												</td>
										        <td>
                                                     <label><%=Vo.get(i).getTechnology() %></label>                                       
											    </td>		
											     <td>
                                                      <label><%=Vo.get(i).getNoOfVacancies()%></label>
                                                 </td>
                                                <%--  <td>
                                                      <label><%=Vo.get(i).getJobPostingId()%></label>
                                                 </td> --%>
                                                 <td>
												        <div class="row" style="width: 30px;height:30px; " >
	                                                        <!-- class="btn btn-primary" -->													
	                                                         <div class="col-md-2">
                                                        	       <input  class="btn btn-primary" type="button" id="editing"  jid="<%=Vo.get(i).getJobPostingId()%>" name="edit" onclick="sreeEdit(this)" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
                                                                   <%-- 	<input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete" jid="<%=Vo.get(i).getJobPostingId()%>" onclick="sreeEdit(this)"/> --%>
                                                          	</div>
                                                    	</div>
                                                </td>
										</tr>
	  
												<%
									}//if
						}//for
				%><!-- For loop is ENDED  -->
         </tbody>
</table>
						</div><!-- table Body div  end-->
					</div>
				</div>
			</div><!-- /.col -->
		</div><!-- /.row -->
		<!-- This Modal For Edit Records... -->
<!-- Modal -->
<div id="myEditModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color:#F8F8FF">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" id="sss" >Edit Job Posting</h4>
      </div>
      <div class="modal-body">
        

<div class="container" >
<!-- Update Form Content started Heare -->
		<form id='target'  class="form-horizontal" role="form" action='<%=application.getContextPath()%>/EditJobPostingAction'>
		
			
			<div id="clientName"></div>
			<div id="image"></div>
			<div id="locationId"></div>
			<div id="city"></div>
			<div id="state"></div>
			<div id="country"></div>
			<div id="pinCode"></div>
			<div id="description"></div>
			<div id="expDateId"></div>
			<div id="vacanciesId"></div>
			<div id="technology"></div>
			<div id="startAndEndDate"></div>
			<div id='jobPostingIdHiddenField'></div>
			
		
		</form>
	</div>

      </div>
      <div class="modal-footer" style="background-color:#DCDCDC	">
        <button type="button" id='other' class="btn btn-success" data-dismiss="modal">Update</button>&nbsp;&nbsp;
        <button type="reset" class="btn btn-danger" data-dismiss="modal">Cancel</button>
      </div>
    </div>

  </div>
</div>
</div>
</div>

<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>


		<!-- page specific plugin scripts -->
		<script src="<%=application.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/dataTables.tableTools.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/dataTables.colVis.min.js"></script>



		<script src="<%=application.getContextPath()%>/assets/js/bootstrap-editable.min.js"></script>
		<script src="<%=application.getContextPath()%>/assets/js/ace-editable.min.js"></script>


			<script	src="<%=application.getContextPath()%>/assets/js/jquery-ui.min.js"></script>

			
			
			<script type="text/javascript">
		
		
		//Assessment start and end date
	 function stAndEdDate(){
			/*  alert("stAndEdDate()"); */
							$(function stAndEdDate() {
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

		 }//end
						
	
		</script>
		
		
<script type="text/javascript">
//validation using jquery plugins no of vacancies 
$(document).on('keyup', '.numeric-only', function(event) {
	var v = this.value;

	if ($.isNumeric(v) === false) {
		//chop off the last char entered

		this.value = this.value.slice(0, -1);

	}
});

var cId='';
var technologyId;
function sreeEdit(btn){
	
	var jId = $(btn).attr("jid");
		
		$("#clientName").empty();
		$("#locationId").empty();
		$("#city").empty();
		$("#state").empty();
		$("#country").empty();
		$("#pinCode").empty();
		$("#description").empty();
		$("#expDateId").empty();
		$("#vacanciesId").empty();
		$("#technology").empty();
		 $("#image").empty();
		 $("jobPostingIdHiddenField").empty();
		 
		 $("#startAndEndDate").empty();
		
	var obj={
		url:"<%=application.getContextPath()%>/EditJobPostingForAjaxAction",
		data : {"jobPostingId" : jId},
    	success : function(details) {
    		cId=details.clientId;
    		technologyId=details.clientTechnologyId;
    		var addrId =details.clientAddressId;
    		
       		addr1(addrId);
    		technology(technologyId);
    		
    		$("#jobPostingIdHiddenField").append(
    		 "<input type='hidden' name='jobPostingId' value="+details.jobPostingId+">"		
    		);
			$("#clientName").append( 														
				"<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>Name:</label><div class='col-sm-3'><div><input type='text' readonly value="+details.clientName+" /></div></div></div>"					
				);
                                             //image
                                             
                                              $("#image").append(
													
													"<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'></label><div class='col-sm-6'><img src='"+details.image+"'  style='position:fixed; right:40px; border-color:#ff0000;  width:100px; height:80px; top:70px; border:none;'></div></div>"
											
											);
											//city
                                           $("#city").append(
                                        		   "<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>City:</label><div class='col-sm-3'><div><input type='text' readonly value="+details.city+"> </div></div></div>"
													
											
											);
                                             //state
                                           $("#state").append(
                                        		   "<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>State:</label><div class='col-sm-3'><div><input type='text' readonly value="+details.state+"> </div></div></div>"
													
											
											);
                                             //Country
                                           $("#country").append(
                                        		   "<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>Country:</label><div class='col-sm-3'><div><input type='text' readonly value="+details.country+"> </div></div></div>"
													
											
											);
                                             //pincode
                                           $("#pinCode").append(
                                        		   "<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>Pin Code:</label><div class='col-sm-3'><div><input type='text' readonly value="+details.pinCode+"> </div></div></div>"
													
											
											);
                                             
                                         //Description
                                           $("#description").append(
													
													"<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>Description:</label><div class='col-sm-3'><input type='text' name='description' value='"+details.descripition+"' class='form-control' id='fname'></div></div>"
											
											);
                                        
                                         //ExpetedDate 
                                           $("#expDateId").append(
                                        		 
													"<div class='form-group'><label class='control-label col-sm-2' for='fname'>Expected Date:</label><div class='col-sm-3'><input type='text' id='expectedDate11' onclick='' name='Expected_Date' value='"+details.expetedDate+"' class='form-control' readonly></div></div>"
											
											);
                                         
                                         //No of vacancies
                                           $("#vacanciesId").append(
													
													"<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>No Of Vacancies:</label><div class='col-sm-3'><input type='text' name='noOfVacancies' value='"+details.noOfVacancies+"' class='form-control numeric-only' id='fname'></div></div>"
											
											);
                                         
											$("#startAndEndDate").append(
                                           "<div class='row'><div class='col-sm-2'><label for='from'>Assessment Start Date:</label> <input type='text' id='from' name='assessmentStartDate' readonly onclick='' value='"+details.assessmentStartDate+"'></div><div class='col-sm-2'><label for='to'>Assessment End Date:</label> <input type='text' readonly value='"+details.assessmentEndDare+"' id='to' name='assessmentEndDate'></div></div>"
                                             );
											
											
											expDateFun();
											stAndEdDate();
										},
										error : function() {
											//write Error Code
											alert("Please try later");
										}
									};
								
								$.ajax(obj);
}
		

</script>
		<script>
	
	
		//for printing paticulor client locations
	function addr1(addrId){ 
	
		var obje={
			url:"<%=application.getContextPath()%>/GetLocationNamesOfClientAjaxAction",
			data:{"clientId":cId},
			success:function(add){
				$("#locationId").empty();
				
		var str ="<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name1'>Location</label><div class='col-sm-3'><select id='address22' name='addId' > ";
		/* alert("addrTd for location"+addrId); */		
		for ( var ind = 0; ind < add.length; ind++) {
							if(addrId==add[ind].address_id){
						str+=	"<option selected value='"+add[ind].address_id+"'>"+add[ind].location+"</option>";
				 }else{
						str+=	"<option  value='"+add[ind].address_id+"'>"+add[ind].location+"</option>";
						  }
					
			}
				str+="</select></div></div>";
				
				$('#locationId').append(str);
				addr();
			},
			
			error:function(){
				
				alert("Please try later");
			}
		};
	$.ajax(obje);
	
	}//addr1
	
	
	//It will print city state pincode country Dynamically
function addr(){
		
		$("#address22").on("change",function (){
			var aIdd=$("#address22").val();
			/* alert("Address Id -"+aIdd); */
			//this will disply city state country pincode based on address id
				
				$("#city").empty();
				$("#state").empty();
				$("#country").empty();
				$("#pinCode").empty();
				
				
			var obj={
				url:"<%=application.getContextPath()%>/GetStateCouPinCodeAjaxAction",
												data : {
													"aId" : aIdd
												},
												success : function(details) {

													  //city
	                                                   $("#city").append(
	                                                		   "<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>City:</label><div class='col-sm-3'><div><input type='text' value='"+details.city+"' readonly> </div></div></div>"
																
														
														);
	                                                     //state
	                                                   $("#state").append(
	                                                		   "<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>State:</label><div class='col-sm-3'><div><input type='text' value='"+details.state+"' readonly></div></div></div>"
																
														
														);
	                                                     //Country
	                                                   $("#country").append(
	                                                		   "<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>Country:</label><div class='col-sm-3'><div><input type='text' value='"+details.country+"' readonly></div></div></div>"
																
														
														);
	                                                     //pincode
	                                                   $("#pinCode").append(
	                                                		   "<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name11'>Pin Code:</label><div class='col-sm-3'><div><input type='text' value='"+details.pincode+"' readonly> </div></div></div>"
																
														
														);

												},
												error : function() {
													//write Error Code
													alert("Please try later");
												}
											};
										
										$.ajax(obj);

									});
	}
	
	//Technology
function technology(technologyId){

	
	 $("#technology").empty();
		
	var obj={
			url:"<%=application.getContextPath()%>/EditJobpostingTechnologyAjaxAction",
		
		success : function(tech) {
           
			var str ="<div class='form-group'><label class='control-label col-sm-2' for='fname' id='name1'>Technology</label><div class='col-sm-3'><select  name='technologyId' > ";
			for ( var ind = 0; ind < tech.length; ind++) {
					
			 if(technologyId==tech[ind].technologyId ){
					str+=	"<option selected value='"+tech[ind].technologyId+"'>"+tech[ind].technology+"</option>";
			 }else{
					str+=	"<option  value='"+tech[ind].technologyId+"'>"+tech[ind].technology+"</option>";
					  }
			
		}
			str+="</select></div></div>";
			
			$('#technology').append(str);
		},
			
			
                                        
										
										error : function() {
											//write Error Code
											alert("Please try later");
										}
									};
								
								$.ajax(obj);

	}//technology
	
	
	

	
					function expDateFun(e){
						$('#expectedDate11').empty();
							$("#expectedDate11").datepicker({
								
								 changeMonth: true,
							      changeYear: true,
								altFormat : "DD, d MM, yy",
								minDate : -0,
								maxDate : "+3M +10D"
							});
						
					}
 							
						//form submition through jquery form submition
$( "#other" ).click(function() {
	
  /* alert("Form Submition"); */
  $( "#target" ).submit();
  $("#success-msg").html(
			"<div class='alert alert-success fade in' style='text-align: center;'>"
					+ "<a href='#' class='close' data-dismiss='alert'>&times;</a>"
					+ " <strong>Success!!!</strong>  Course has been Added Successfully..."
					+ "</div>");
});
	<%-- //Delete job posting
function s(){
	
	$("#address").on("click",function(){
		alert("Wel-Come to the  jQuery..!");
		var jobId= $(this).val();
		alert("Wel-Come to the  jQuery..!"+aId);
		
			
			
			//if aId is null
			if(jobId!=''){
		var obj={
			url:"<%=application.getContextPath()%>/GetStateCouPinCodeAjaxAction",
											data : {
												"jobId" : jobId
											},
											success : function(details) {

											},
											error : function() {
												//write Error Code
												alert("Please try later");
											}
										};
									}//if
									$.ajax(obj);

								});
} --%>
		</script>



		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				//initiate dataTables plugin
				var oTable1 = 
				$('#dynamic-table')
				//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
				.dataTable(/* {
					bAutoWidth: false,
					"aoColumns": [
					  { "bSortable": false },
					  null, null,null, null, null,
					  { "bSortable": false }
					],
					"aaSorting": [],
			
					//,
					//"sScrollY": "200px",
					//"bPaginate": false,
			
					//"sScrollX": "100%",
					//"sScrollXInner": "120%",
					//"bScrollCollapse": true,
					//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
					//you may want to wrap the table inside a "div.dataTables_borderWrap" element
			
					//"iDisplayLength": 50
			    }*/ );
				//oTable1.fnAdjustColumnSizing();
			
			
				//TableTools settings
				TableTools.classes.container = "btn-group btn-overlap";
				TableTools.classes.print = {
					"body": "DTTT_Print",
					"info": "tableTools-alert gritter-item-wrapper gritter-info gritter-center white",
					"message": "tableTools-print-navbar"
				}
			
				//initiate TableTools extension
				var tableTools_obj = new $.fn.dataTable.TableTools( oTable1, {
					"sSwfPath": "assets/swf/copy_csv_xls_pdf.swf",
					
					"sRowSelector": "td:not(:last-child)",
					"sRowSelect": "multi",
					"fnRowSelected": function(row) {
						//check checkbox when row is selected
						try { $(row).find('input[type=checkbox]').get(0).checked = true }
						catch(e) {}
					},
					"fnRowDeselected": function(row) {
						//uncheck checkbox
						try { $(row).find('input[type=checkbox]').get(0).checked = false }
						catch(e) {}
					},
			
					"sSelectedClass": "success",
			        "aButtons": [
						{
							"sExtends": "copy",
							"sToolTip": "Copy to clipboard",
							"sButtonClass": "btn btn-white btn-primary btn-bold",
							"sButtonText": "<i class='fa fa-copy bigger-110 pink'></i>",
							"fnComplete": function() {
								this.fnInfo( '<h3 class="no-margin-top smaller">Table copied</h3>\
									<p>Copied '+(oTable1.fnSettings().fnRecordsTotal())+' row(s) to the clipboard.</p>',
									1500
								);
							}
						},
						
						{
							"sExtends": "csv",
							"sToolTip": "Export to CSV",
							"sButtonClass": "btn btn-white btn-primary  btn-bold",
							"sButtonText": "<i class='fa fa-file-excel-o bigger-110 green'></i>"
						},
						
						{
							"sExtends": "pdf",
							"sToolTip": "Export to PDF",
							"sButtonClass": "btn btn-white btn-primary  btn-bold",
							"sButtonText": "<i class='fa fa-file-pdf-o bigger-110 red'></i>"
						},
						
						{
							"sExtends": "print",
							"sToolTip": "Print view",
							"sButtonClass": "btn btn-white btn-primary  btn-bold",
							"sButtonText": "<i class='fa fa-print bigger-110 grey'></i>",
							
							"sMessage": "<div class='navbar navbar-default'><div class='navbar-header pull-left'><a class='navbar-brand' href='#'><small>Optional Navbar &amp; Text</small></a></div></div>",
							
							"sInfo": "<h3 class='no-margin-top'>Print view</h3>\
									  <p>Please use your browser's print function to\
									  print this table.\
									  <br />Press <b>escape</b> when finished.</p>",
						}
			        ]
			    } );
				//we put a container before our table and append TableTools element to it
			    $(tableTools_obj.fnContainer()).appendTo($('.tableTools-container'));
				
				//also add tooltips to table tools buttons
				//addding tooltips directly to "A" buttons results in buttons disappearing (weired! don't know why!)
				//so we add tooltips to the "DIV" child after it becomes inserted
				//flash objects inside table tools buttons are inserted with some delay (100ms) (for some reason)
				setTimeout(function() {
					$(tableTools_obj.fnContainer()).find('a.DTTT_button').each(function() {
						var div = $(this).find('> div');
						if(div.length > 0) div.tooltip({container: 'body'});
						else $(this).tooltip({container: 'body'});
					});
				}, 200);
				
				
				
				//ColVis extension
				
				//style it
				
				
				//and append it to our table tools btn-group, also add tooltip
				
				
			});
		</script>
	</body>
</html>
