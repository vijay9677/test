<!-- Srinivas N -->
<%@page import="javax.swing.text.StyledEditorKit.BoldAction"%>
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
		<%-- 	
			<link rel="stylesheet"
				href="<%=application.getContextPath()%>/assets/css/jquery-ui.css" />
				 --%>
	
			
		<!-- page specific plugin styles -->
<%-- 
		<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/jquery-ui.css" />
		 --%>	
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
									 <b class="blue" >Client Details</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
	<!-- write your code here -->
	 



		

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
					<!-- 	<div class="table-header">Client Details</div> -->
							<!-- div.table-responsive -->
							<!-- div.dataTables_borderWrap -->									<div>
							<!-- div.dataTables_borderWrap -->
										<div>
											<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												
												
												<thead>
													<tr>
														
														<th>Image</th>
														<th>Name</th>
														<th>Description</th>
														<th>Level</th>
														<th>Select</th>
														
														
												
						                            </tr>
												</thead>

              <!-- This code will used for displaying client details dynamically  -->
              
                             		
  <%
  Boolean formSubmitionResult=(Boolean)session.getAttribute("result");
           System.out.println("FormsubmossionResult........"+formSubmitionResult);
  if( formSubmitionResult!=null){
	  Boolean result=formSubmitionResult;
	  if(result){%>
		<div class="row">
			<div class="col-md-12" style="text-align: center; padding-top: 5px;">
				<!-- This Div for using Success_Msg display -->
				<div class='alert alert-success fade in' style='text-align: center;'>
					<a href='#' class='close' data-dismiss='alert'>&times;</a>
					 <strong>Success!!!</strong>  JobPosting  Added Successfully..."
					</div>
				<div id='success-msg' class="success_msg" style="width: 40%;">
				</div>
			</div> 
	<% 	  
	 request.getSession().removeAttribute("result");
	  }else {%>
	  <div class="col-md-12" style="text-align: center;">
				<!-- This Div for using Alert_Msg display -->
				
				<div class='alert alert-danger fade in' style='text-align: center;'>"
					<a href='#' class='close' data-dismiss='alert'>&times;</a>"
					 <strong>Sorry</strong>  JobPosting been Not Added ..."
					</div>
				
				
				<div id="error-msg" class="alert_msg" style="width: 40%;"></div>
			</div>
		</div>
	  
	  <% 
	  request.getSession().removeAttribute("result");
	  }//elsse
  }//if
      
  RequestDispatcher rd=request.getRequestDispatcher("/getClientDetailsAction");
  if(rd==null){
	 System.out.print("rd is null in job_posting_display_client_details.jsp");
  }else{
	  rd.include(request, response);
  }
	  List<ClientDTO> clientDTOsList=(List)session.getAttribute("ClientDTO");
	 
	  /* System.out.println("Client list size"+clientDTOsList.size());
	  System.out.println(clientDTOsList);
	   */
%>
	  								<tbody>
												<!-- For loop is started  -->
												
												<% if(clientDTOsList!=null){
												for(int i=0;i<clientDTOsList.size();i++){ %>
												<tr>
														<td>
														    
													    	<img src="<%=clientDTOsList.get(i).getClientImage()%>" width="80px" height="40px" alt="Not  found">
														</td>
													
														<td><%=clientDTOsList.get(i).getClientName()%></td>
														<td><%=clientDTOsList.get(i).getClientDescription()%></td>
                                                        
                                                        <td><%=clientDTOsList.get(i).getCompanyLevel().getLevel()%></td>
														<td> <a href='<%=application.getContextPath()%>/JobPostingClientAddress?clientId=<%=clientDTOsList.get(i).getClientId()%>'>Add job posting</a>  </td>
												</tr>
	  
												<%}}%><!-- For loop is ENDED  -->
                                   </tbody>
                             </table>
						</div>
					</div>
				</div>
			</div><!-- /.col -->
		</div><!-- /.row -->
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
				$(colvis.button())
				.prependTo('.tableTools-container .btn-group')
				.attr('title', 'Show/hide columns').tooltip({container: 'body'});
				
				//and make the list, buttons and checkboxed Ace-like
				$(colvis.dom.collection)
				.addClass('dropdown-menu dropdown-light dropdown-caret dropdown-caret-right')
				.find('li').wrapInner('<a href="javascript:void(0)" />') //'A' tag is required for better styling
				.find('input[type=checkbox]').addClass('ace').next().addClass('lbl padding-8');
			
			
				
				/////////////////////////////////
				//table checkboxes
				$('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);
				
				//select/deselect all rows according to table header checkbox
				$('#dynamic-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
					var th_checked = this.checked;//checkbox inside "TH" table header
					
					$(this).closest('table').find('tbody > tr').each(function(){
						var row = this;
						if(th_checked) tableTools_obj.fnSelect(row);
						else tableTools_obj.fnDeselect(row);
					});
				});
				
				//select/deselect a row when the checkbox is checked/unchecked
				$('#dynamic-table').on('click', 'td input[type=checkbox]' , function(){
					var row = $(this).closest('tr').get(0);
					if(!this.checked) tableTools_obj.fnSelect(row);
					else tableTools_obj.fnDeselect($(this).closest('tr').get(0));
				});
				
			
				
				
					$(document).on('click', '#dynamic-table .dropdown-toggle', function(e) {
					e.stopImmediatePropagation();
					e.stopPropagation();
					e.preventDefault();
				});
				
				
				//And for the first simple table, which doesn't have TableTools or dataTables
				//select/deselect all rows according to table header checkbox
				var active_class = 'active';
				$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
					var th_checked = this.checked;//checkbox inside "TH" table header
					
					$(this).closest('table').find('tbody > tr').each(function(){
						var row = this;
						if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
						else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
					});
				});
				
				//select/deselect a row when the checkbox is checked/unchecked
				$('#simple-table').on('click', 'td input[type=checkbox]' , function(){
					var $row = $(this).closest('tr');
					if(this.checked) $row.addClass(active_class);
					else $row.removeClass(active_class);
				});
			
				
			
				/********************************/
				//add tooltip for small view action buttons in dropdown menu
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				
				//tooltip placement on right or left
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					//var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			
			});
		</script>
	</body>
</html>
