
<!-- @author KRISHNA PRAKASH -->

<%@page import="com.nacre.online_assesment.dto.LevelDTO"%>
<%@page import="com.nacre.online_assesment.form_bean.OptionsFromBean"%>
<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.nacre.online_assesment.form_bean.QuestionsFormBean"%>
<%@page import="com.nacre.online_assesment.form_bean.AssessmentPaperFormBean"%>
<%@ page import="java.util.*" %>
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
		<title>Technical-Team</title>
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
         <script type="text/javascript" src="${path}/assets/js/AvoidingBackButton.js">		
        </script>

	    
	</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/technical_Team_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/technicalteam_menu.jsp"></jsp:include>
<%-- <jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
 --%>
 
 			<div class="main-content">
				<div class="main-content-inner">
				<div class="page-content">
				     <!--Separetor start-->
							<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
						<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
						<b class="blue" >Edit Assessment Paper</b> 			 
						</h4>
		                        <!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->								
	<div class="row">
	<div class="col-xs-12">
<!-- PAGE CONTENT BEGINS -->
 <!-- Edit Assessment paper -->
		<!-- page specific plugin styles -->
        <script src='<%=application.getContextPath()%>/assets/js-classes/Question.js'></script>
        <script src='<%=application.getContextPath()%>/assets/js-classes/QuestionOption.js'></script>
        <script>
  
</script>
        <script >
        /*creating global object */        
        var questionsArr = [];
        </script>
        
						<div class="row" id='tab-wrapper'><!-- 
									<div class="col-xs-12"> -->
										<table id="simple-table" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th class="center">
													<span> Q.No</span>
													</th>
													<th class="center hidden-480">question</th>
													<th class="center hidden-480">options</th>
													<th class="center ">Level</th>
													<th class="center hidden-480">Operations</th>
												</tr>
											</thead>
											<tbody id="tdata">
                                  <% 
								  if(session.getAttribute("assessmentPaper")!=null){%>
                                   <% List list=(List) session.getAttribute("assessmentPaper");
                                      /* Integer assID=(Integer)session.getAttribute("assessmentId"); */
                                      int size=list.size();
                                          Iterator li= list.iterator();
                                          int rowCount=1; 
                                          %>
                                      <%while(li.hasNext()){%>
                                     <%AssessmentPaperFormBean afb=(AssessmentPaperFormBean)li.next();%>
									<tr id="row<%=rowCount-1%>">
										<td class="center" >
											<label class="pos-rel">
													<b class="lbl" id="sno<%=rowCount%>"><%=rowCount %></b>
											</label>
										</td>
          <td class="left" id='questParentTd<%=rowCount-1%>'>
                <!--  -->
					  <script>

					          var que = new Question();
					          
                              
					          que.question="<%=afb.getQuestionsFormBean().getQuestion()%>";
					         <%--  var qcid="#"+"questi"+<%=rowCount-1%>;
					          //alert(qcid);
					          $(qcid).append(que.question+"hai"); --%>
					          que.questionInd='<%=rowCount%>';
					          que.options=[];
					          </script>	
					          			
							<%if(afb.getQuestionsFormBean().getQuestion()!=null){%>
							         
									<%if(afb.getQuestionsFormBean().getIsDuplicate()==false){ %>
										<!-- 	questions -->
										<script>
										 var id1= "questi"+<%=rowCount-1%>;
									     que.noQue=false;
										</script>
											<b class="question" id='questi<%=rowCount-1%>'><%=afb.getQuestionsFormBean().getQuestion() %></b>
											   <%}else{ %>
											
										<script>
										que.isDuplicate=true;
										que.noQue=false;
										</script>
												 <b style="color: red" id='questi<%=rowCount-1%>' ><%=afb.getQuestionsFormBean().getQuestion()%></b>
										       <%}
									}else{ %>
										<b style="color: red" id='questi<%=rowCount-1%>'><%="You have'nt entered any question" %></b>
									<script>   
									           que.question="<%="You have'nt entered any question"%>"; 
									           que.noQue=true;
									</script>	
								<%} %>
		    </td>
			<td id='optTblPar<%=rowCount-1%>'>
			<!-- reading options and answers -->
	             <table class='table table-hover' id='optTbl<%=rowCount-1%>' style='border:3px lightgray solid'>
	                 <%List<OptionsFromBean> optList=(List<OptionsFromBean>)afb.getOptionsFormBean();
							Iterator<OptionsFromBean> optionIterator=optList.iterator();
								int answerCount=0;  
								 int optionsCount=0;
								   %>
									<script>
									var totalOptCount=0*1;
									</script>
									<!--while start-->
							        <%while(optionIterator.hasNext())
									     { 
							        	    
									       OptionsFromBean options=(OptionsFromBean)optionIterator.next();%>
                                                         
                                                               <script>
		                                                        
                                                               totalOptCount=totalOptCount+1;
																		var opt = new QuestionOption();
																		//debugger;
																		    opt.option="<%=options.getOption()%>";
																		    
																		   // $('#value').append(opt.option);
																</script>                     
                                                                           <%  int noAnswerCount=0;
                                                                             if(options.getIsAnswer()&&!options.getIsDuplicate())
                                                                                {

       				                                                                  answerCount=answerCount+1;
                                                                                   %> 
																		              <script>
																		                   opt.isAnswer=true;
																		              </script>
																		              <!-- option is answer -->
													                                        <tr class='success' width:100>
													                                          <td id='opt<%=optionsCount%>'>        
				                                                                                 <b><%=options.getOption()%></b></td>
				                                                                                </tr >
				                                                                                   <% }else if(options.getIsDuplicate()){%>
				                                                                                      <tr class='warning'>
				                                                                                      
																							<script>opt.isDuplicate=true;

																							/* que.options[rowCount-1].isDuplicate=true;
																							alert(que.options[rowCount-1].isDuplicate) */




																							</script>
				                                                                                      <!-- option duplicate -->
				                                                                                         <td id='opt<%=optionsCount%>'>
				                                                                                            <b id='value'><%=options.getOption()%></b></td></tr>
				                                                                                                   <%}else if(options.getOption()!=null){%>
				                                                                                            <tr>
				                                                                                                 <!-- option -->
				                                                                                                 <td id='opt<%=optionsCount%>'>
				                                                                                                     <%=options.getOption()%>
				                                                                                                  </td>
				                                                                                              </tr>
				                                                                                                 <%optionsCount=optionsCount+1;} else{%>
				                                                                                              <tr >
				                                                                                           <td >
				                                                                                       you have'nt given any options
				                                             				                         </td>
				                                             				                    </tr>
				                                                                              <%}%>
                                                                                       
							                                                         <script>  
							                                                         que.options.push(opt);
							                                                         </script>
																					 
													                          <%;}%>
													                          <script>
													                          que.optCount=totalOptCount;
													                          </script>
													                          <%if(answerCount==0){%>
																			  <!--while end-->
													                   <tr class='danger'>
													                     <td>YOU DID NOT PROVIDED ANY ANSWER</td>
													                     <script>
													                     que.answerExists=1;
													                     </script>
													               </tr>
													            <%}if(optionsCount==0){ %>
																
										            <tr class='danger'>
													                     <td>YOU DID NOT PROVIDED ANY OPTIONS</td>
													               </tr>
													            <%}%>   
											    	        </table>
													    </td>
													<!-- completed reading of options -->
										<!--Reading Level -->
											<td>
											   <%if(afb.getQuestionsFormBean().getLevel()!=null){ %>
												<b><%=afb.getQuestionsFormBean().getLevel() %></b>
												<script type="text/javascript">
												que.level="<%=afb.getQuestionsFormBean().getLevel() %>";
												</script>
													  <%}else{ %>
												<b><%="simple" %></b>
												<%}%>
											</td>
										<!-- end of level read -->
											<td>
												<div class="hidden-sm hidden-xs btn-group">
  	                                                <input class="btn btn-primary" type="button" name="edit" onclick='editQuestion(this)'ind="<%=rowCount%>" data-toggle="modal" data-target="#myEditModal"value="Edit">&nbsp;&nbsp;
  	                                                <input class="btn btn-danger" type="button" onclick='deleteRow(this); showButton();' ind="<%=rowCount-1%>"  data-toggle="modal"  value="Delete"/>
 
														</div>

														
													</td>
												</tr>
									           <script>	
								                 questionsArr.push(que);
								                 var entires=questionsArr.length*1;

							                   </script>
							                  
								  <%rowCount++;}}else{ %> 
											
                                            <!-- end of questions-->
                                           <div align='center' style='color:red'><h2>Sheet Is Not Uploaded</h2></div>
											<script>
											window.location.assign("<%=application.getContextPath()%>/jsp/technical_team/upload_assessment_paper.jsp")   
											</script>	
										<%}%>			</tbody>
												
												</table>
												<br>
						                       <div align="center">
						                       <table>
						                        <tr>
						                         <td style='width:60px'>
						                           <button id='cancleBtn'class='btn btn-danger' onclick="cancelFun()">Cancel</button>
						                         </td>
						                         
						                         <td>
						                         <button id='saveBut'class='btn btn-primary' onclick="save()">Save</button>
						                         </td>
						                        </tr>
						                       </table>
						                       </div>
												
											<!-- </div> -->

										</div><!-- /.modal-content -->
									</div><!-- /.modal-dialog -->
					

<!-- This Modal For Delete Record... -->
  <!-- Modal -->
  <div class="modal fade" id="myDeleteModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <h4 class="modal-title">Delete Record</h4>
       </div>
        <div class="modal-body">
          <p>Are You Sure... Do You Want to Delete This Records</p>
        </div>
        <div class="modal-footer">
       		<button type="button" class="btn btn-danger" data-dismiss="modal">Ok</button>
        	<button type="button" class="btn btn-success" data-dismiss="modal">Cancel</button>       
        </div>
      </div>
      
    </div>
  </div>
 <!--  model delete end -->
<!-- This Modal For Edit Records... -->
<!-- Modal -->
<div id="myEditModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content" >
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Records</h4>
      </div>
      <div class="modal-body" style='background-color:#f8f8f8'>
        
<!-- Edit container -->
<div class="container" >
		
			<div class="row">
			<div class="col-sm-12">
			<table>
			 <tr>
			 <td>
				<label class="control-label col-sm-2" id="question" >Question:</label></td>
				<td>
				<textarea class="form-control custom-control" rows="3" cols="50" style="resize:none" id="ques" class="question"></textarea>
				</td>
				</table>
			</div>
			</div>
		<!-- <table>
			<tr>
			   <td>
			<div id="div2" style="width:150px;height:100px"></div>
			  </td>
			  <td>
			  <div id="div3"></div>
			  </td>
			</tr>
			
		</table> -->
		<div class="row">
		<div class="col-sm-1"></div>
		<div class='center' style='width:50%'>
		<h4 class="center">OptionDetails</h4>
			 <div id="formOpt" class="question" style='align:center'></div>
	    </div>
	     </div>
	     <div class="row"><br/>
	     <div class="col-sm-6" style="text-align:center;">
	     <button id='optAddButton' class="btn btn-primary" onclick='addRow()'> Add</button>	
<!-- 	 <button id='optRemoveButton' class="btn btn-primary" onclick='removeRow()'> remove</button>
 -->	     
		</div>
		
	</div>
		</div>
		<form class="form-horizontal" role="form">
			
		</form>
				
				
<%-- <div class="container">
     <form class="form-horizontal" role="form">
		        <div>
				      <div class="form-group">
				           <label class="control-label col-sm-2" for="userId">Level:</label>
                             <%
	                            RequestDispatcher rd = request.getRequestDispatcher("/GetLevelAction");
	                             rd.include(request, response);
	                             %>
	                             <select>
		                             <%
	                                 List<LevelDTO> level=null;
	                                   if(request.getAttribute("questionLevel")!=null)
	                                       {
	                                        level =(List<LevelDTO>)request.getAttribute("questionLevel");
	                                          for(Object s :level)
	                                              {
	                                               LevelDTO obj=(LevelDTO)s;
			                                              %>
	                                       <option value="<%=obj.getLevelId()%>"><%=obj.getLevel() %><%} }%>
	                                    </option>
	                             </select>
		                  </div>
		         </div>
		</form>
	</div>	 --%>
</div>
</div>
      <div class="modal-footer" >
        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="updateQuestion(this)">Update</button>&nbsp;&nbsp;
        <button type="reset" class="btn btn-danger" data-dismiss="modal">Cancel</button>
      </div>
    </div>

  </div>
</div> <!-- model edit ent -->
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div>
		<!-- dialog box div -->
	    <div id="dialog" ></div>
</div>
</div>
</div>
<!-- /.main-container -->
	<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>


<script type="text/javascript">
var path = '<%=application.getContextPath()%>';
</script>
 
 						<script src ="${path}/assets/js/MounikaAssmentNotiTechTeam.js">
						</script>
		<!-- page specific plugin scripts -->
		<script src="../../assets/js/jquery.dataTables.min.js"></script>
		<script src="../../assets/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="../../assets/js/dataTables.tableTools.min.js"></script>
		<script src="../../assets/js/dataTables.colVis.min.js"></script>
        <script src="../../assets/js/jquery-ui.min.js"></script>
		<!-- inline scripts related to this page -->
        <!-- dialog box link-->
<script >
var editRow="";
/* function to display content in multiple pages based up on user selected number*/

$(document).ready(function()
{
	$('#saveBut').hide();
    $('#simple-table').dataTable({
	 "iDisplayLength": 3,
	 "pageLength": 3,
	 "aLengthMenu": [[3,5, 10, 50, -1], [3,5, 10, 50, "All"]],
	     "aoColumnDefs": [
	                      { 'bSortable': false, 'aTargets': [0,1,2,4] },
                         ]
    
     
      });	

    /* function trigger on change of select option*/
     $('[aria-controls=simple-table]').on('change', function (e) {
        var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
       showButton() ;
    });
     
});

/* function to show and hide savebutton on delete action in table*/
 function showButton() 
 {
	//alert("show but......");
	var noRecPerPage=$('select[name=simple-table_length]').val()*1;
	var howManyPagesRequired=((entires-1)/noRecPerPage);
	var roundedPagesRequired=Math.round(howManyPagesRequired);
	var table = $('#simple-table').DataTable();
	var info = table.page.info(); 
	if(Math.round(howManyPagesRequired)>howManyPagesRequired)
	{
    	
    	roundedPagesRequired=Math.round(howManyPagesRequired);
    }
    else
    {
    	roundedPagesRequired=Math.round(howManyPagesRequired)+1;
    	
    }
	if(info.page+1==roundedPagesRequired)
	{
		
      	 $('#saveBut').show();

	}
	 else if(info.pages==1)
	{
     	 $('#saveBut').show();

	} 
	 else
	 {
     	 $('#saveBut').hide();

	 } 
   
	//only when navigation buttton is clicked
    var eventFired = function ( type ) 
    {
    	table = $('#simple-table').DataTable();
    	var info = table.page.info(); 
    	var curr=info.page+1;
    	
    	if(Math.round(howManyPagesRequired)>howManyPagesRequired)
    	{
        	//alert("function");
        	roundedPagesRequired=Math.round(howManyPagesRequired);
        }
        else
        {
        	roundedPagesRequired=Math.round(howManyPagesRequired)+1;
        	//alert("else"+Math.round(howManyPagesRequired));
        }
    	if(info.page+1==roundedPagesRequired)
    	{
    		//alert("fun");
          	 $('#saveBut').show();

    	}
    	else
    	{
         	 $('#saveBut').hide();

    	}
       
    }
    
 
    $('#simple-table')
         .on( 'order.dt',  function () { eventFired( 'Order' ); } )
        .on( 'search.dt', function () { eventFired( 'Search' ); } ) 
        .on( 'page.dt',   function () { eventFired( 'Page' ); } )
        .DataTable();
}
/* on docment ready show and hide save button*/
 $(document).ready(function() 
  {
	var noRecPerPage=$('select[name=simple-table_length]').val()*1;
    var eventFired = function ( type ) 
    {
    	var table = $('#simple-table').DataTable();
    	var info = table.page.info();  
        //current page
        //alert(info.page+1);
        //last page
        //alert(info.pages);
        if(info.page+1==info.pages)
        {
       	 $('#saveBut').show();
        }
        else
        {
        	$('#saveBut').hide();
        }
       
    }
    
 
    $('#simple-table')
        /* .on( 'order.dt',  function () { eventFired( 'Order' ); } )
        .on( 'search.dt', function () { eventFired( 'Search' ); } ) */
        .on( 'page.dt',   function () { eventFired( 'Page' ); } )
        .DataTable();
});

$(document).ready(function() 
{
     $('#datatable').dataTable();
     $("[data-toggle=tooltip]").tooltip();
     $('[data-toggle="buttons"] .btn').on('click', function(e)
        {
    		var target = $(this).find('input[type=radio]');
    		var which = parseInt(target.val());
    		$('.question').parent().addClass('hide');
    		$('#question-'+which).parent().removeClass('hide');
    	});
    
});


</script>

<script type="text/javascript">
<%-- /* ajax to get level of questions */
$(document).ready(function() {
	 
		 $.ajax({      
				url: "<%=application.getContextPath()%>/GetLevelAction",
			    type: "post",
				success:function(Obj){
					alert("Hi")
				}
				});
	        alert('started');
	    }); --%>
	    
/* function to append existing data in popup box*/	
 function editQuestion(curr)
	{
	    //alert('in edit function');
		var tr =$(curr).parent().parent().parent();
		var count=0;
		var queAtIndex=$(curr).attr("ind")*1-1;
		editRow = queAtIndex;
		var que = questionsArr[queAtIndex];
		console.log(que.options);
        var optCount=que.options.length;
        if(que.question!='null')
        {
		$('#ques').val(que.question);
		}else
		{
			$('#ques').val("You have'nt entered any question");
		}
		$('#ques').attr("ind",queAtIndex);
		$('#formOpt').empty();
		//checking duplicates
		if(optCount==0&&count<=4)
		{
			for(var i=count;i<2;i++)
			{
				$("#formOpt").append("<div class='dynamic-opt'><input type='checkbox'value='' name='check'ind='"+queAtIndex+"'>&nbsp;&nbsp;<input type='text'  style='width:60%' ind='"+queAtIndex+"' name='option' value='no option'><input type='button' class='btn btn-sm btn-warning'value='remove' id='options"+i+"'> </div>");
			}	
		}
		
	else
		{
		
		var butId=0;	
		for(var i=count;i<=que.options.length;i++)
		{
			
			if(optCount>count)
			{
			count++;
			var an=que.options[i].isAnswer;
			if(an)
		    {
			$("#formOpt").append("<div  id='chek"+butId+"'class='dynamic-opt'><input type='checkbox' checked ind='"+queAtIndex+"'value='"+que.options[i].option+"' name='check' >&nbsp;&nbsp;<input type='text' style='width:60%' name='option'ind='"+queAtIndex+"' value='"+que.options[i].option+"'><input type='button' class='btn btn-sm btn-warning'value='remove' id='options"+i+"' onclick='removeRow(this)'> </div>");
			que.answerExists=0;
			}

			else if(an==false)
			{
				$("#formOpt").append("<div id='chek"+butId+"' class='dynamic-opt'><input  type='checkbox'ind='"+queAtIndex+"' value='"+que.options[i].option+"' name='check' >&nbsp;&nbsp;<input type='text' style='width:60%' name='option'ind='"+queAtIndex+"' value='"+que.options[i].option+"'><input type='button' class='btn btn-sm btn-warning'value='remove' id='options"+i+"' onclick='removeRow(this)'> </div>");
			}
			}
			
			butId++;
			//atleast 4 options
			/* else{
				for(var i=count;i<4;i++)
				{
					$("#formOpt").append("<input type='checkbox' name='check'ind='"+queAtIndex+"' >&nbsp;&nbsp;<input type='text'style='width:60%' ind='"+queAtIndex+"' name='option' value='no option'><br/>");
				}	
		
			} */
			
		}
		
		
		}
		
		

	}   
/** to read data on edit click*/
$('document').ready(function()
{

		
});
/* updating data in global array after editing*/
 function updateQuestion(curr)
  {
	//alert('in update function');
	var chkInd=0;
	var index=0;
	var ansCount=0*1;
	var optCount=0*1;
	var que;
	var queDupCount=0;
	var answerExists;
	var queAtIndex;
	var que1=$('#ques').val();
	queAtIndex=$('#ques').attr("ind")*1;
	que=questionsArr[queAtIndex];
	alert(que1+"in up");
	if(que1=="You have'nt entered any question")
	{
		que.noQue=true;
	}
	else{
		que.noQue=false;

	}
	/* duplicate checking of questions*/ 
	 for(var i=0;i<questionsArr.length;i++)
	    {
	    	for (var j = i+1; j < questionsArr.length; j++)
	        {
	            if( ($.trim(questionsArr[i].question.toLowerCase())==$.trim(questionsArr[j].question.toLowerCase())) && (i != j) )
	            {
	                alert("Duplicate Element is : "+questionsArr[j].question);
	    			que.isDuplicate=true;

	            }
	            /*  else
	            {
	    			que.isDuplicate=false;

	            }  */
	        }	
	    }  
	if(!que.noQue)
	{
		que.noQue=false;
		//updating question
		que.question=que1;
		//que.isDuplicate=queDup;
		que.questionInd=queAtIndex+1;
		//empty options object
		que.options=[];
		que.answerExists=0;
		var dupCount=0;
		for(var i=0;i<questionsArr.length;i++)
		{
		
			if(queAtIndex!= i)
			{	
			if($.trim(que1.toLowerCase())==$.trim(questionsArr[i].question.toLowerCase()))
			{
				que.isDuplicate=true;
				queDupCount++;
				//alert(queDupCount+"count")
				//alert(i+" match ind");
				break;
			}
			 
			else{
				que.isDuplicate=false;
			    }
			}
		}
		
	}
	else
	{
		que.question=que1;
		que.noQue=true;
		que.questionInd=queAtIndex+1;
		que.options=[];
		que.answerExists=0;
		alert(que.question+"else");

	}
	
	//itterating  options	
	  $('input[name=option]').each(function()
	  {
		if($(this).val()!='no option'&&$(this).val()!="")
		{
	   //creating  questionoptions object
		var optObj = new QuestionOption();
		var op=$(this).val();
		optObj.option=op;
		if($("input[name=check]").eq(optCount)[0].checked||$("input[name=check]").eq(optCount)[0].checked =="checked")
		{	
		 optObj.isAnswer=true;	
		 ansCount++;
		 que.answerExists=0;		 
		}
		else
		{
		optObj.isAnswer=false;
	
		}	
         que.options.push(optObj);     
         optCount++;	
         chkInd++;
		}
	   });
 //checking options duplicates	
 
 for(var i=0;i<que.options.length;i++)
   {
   	for(var j=i+1;j<que.options.length;j++)
   	{
   		if( ($.trim(que.options[i].option.toLowerCase())==$.trim(que.options[j].option.toLowerCase())) && (i != j) )
           {
            //alert("Duplicate Element is : "+questionsArr[j].question);
   			que.options[i].isDuplicate=true;

           }
   		
          /*  else
           {
           	que.options[i].isDuplicate=false;
           }  */
   		
   	 }
     //alert(que.options[i].isDuplicate);
     }

	
	  que.optCount=optCount;
	  console.log(que);
	  displayInTable(que,queAtIndex,ansCount);
	  localStorage.setItem("questionArray",JSON.stringify(questionsArr));
	
}

/* function to updation of data in table after edit*/
 function displayInTable(que,queAtIndex,ansCount,row)
 {
	alert(que.noQue);
	  //alert('in display table function')
	  var opDupCount=0;
	  $("#questi"+queAtIndex).remove(); 
	  /* if(questionsArr[i].question!='null')
	  { */
	  if(que.isDuplicate==true||que.noQue)
	  {
	  $("#questParentTd"+queAtIndex).html("<b style='color:red' id='questi"+queAtIndex+"'>"+que.question+"</b>");
	  }
	  else
	  {
		  $("#questParentTd"+queAtIndex).html("<b id='questi"+queAtIndex+"'>"+que.question+"</b>");
  
	  }
	 /*  }
	  else
	  {
		  $("#questParentTd"+queAtIndex).html("<b style='color:red' id='questi"+queAtIndex+"'>You haven't provide any question</b>");

	  } */
      var i=$("#optTbl"+queAtIndex).empty();
	  alert("#optTbl"+queAtIndex);
	  var row = $("#optTbl"+queAtIndex);
      var v =  "<table class='table table-hover' id='#optTbl"+queAtIndex+"' >";
  for(var i=0 ; i<que.options.length; i++)
    {
      if(que.options[i].isAnswer&&!que.options[i].isDuplicate)
      { 
	  v+="<tr><td class='success'>"+que.options[i].option+"</td></tr>";
      questionsArr[queAtIndex].answerExists=0;
      }
      else if(que.options[i].isAnswer&&que.options[i].isDuplicate)
      {
    	  v+="<tr><td class='danger'>"+que.options[i].option+"</td></tr>";	
    	$('#dialog').empty();
  		$('#dialog').append("<center><h4 style='color:red'>Please Edit Duplicate Options</h4></center><br/>");
  		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
  	    $( "#dialog" ).dialog({});

      }
      
      else
      {
    	  if(que.options[i].isDuplicate)
    	  {
    	  v+="<tr><td class='danger'>"+que.options[i].option+"</td></tr>";	
    	  opDupCount++;
    	  }
    	  else
    	  {
        	  v+="<tr><td >"+que.options[i].option+"</td></tr>";	
 
    	  }
      }
    }
  if(que.optCount==0)
  {
	  v+="<tr class='danger'><td >No options</td></tr>"

  }
  if(ansCount==0&&que.optCount>=2)
  {
	 //alert(questionsArr[i].answerExists);
	  v+="<tr class='danger'><td >No Answer</td></tr>"
      questionsArr[queAtIndex].answerExists=1;
	    $('#dialog').empty();
		$('#dialog').append("<center><h4 style='color:red'>please make sure that every question has atleast 1 answer</h4></center><br/>");
		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
	    $( "#dialog" ).dialog({});
			    	  
  }
  if(que.isDuplicate)
  {
	    $('#dialog').empty();
		$('#dialog').append("<center><h4 style='color:red'>please delete or edit duplicate question which are in red color</h4></center><br/>");
		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
	    $( "#dialog" ).dialog({}); 
	 
  }
  if(que.noQue)
  {
	  $('#dialog').empty();
	  $('#dialog').append("<center><h4 style='color:red'>please provide question or delete the row</h4></center><br/>");
	  $('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
  }
  if(que.optCount<2&&!que.noQue)
  {
	    $('#dialog').empty();
		$('#dialog').append("<center><h4 style='color:red'>please provide atleast 2 options for each question</h4></center><br/>");
		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
	    $( "#dialog" ).dialog({}); 
	  
  }
  if(ansCount==que.optCount&&ansCount!=0&&que.optCount>=2)
  {
	    $('#dialog').empty();
		$('#dialog').append("<center><h4 style='color:red'>Not allowed to select all option as answers</h4></center><br/>");
		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
	    $( "#dialog" ).dialog({}); 
	  
  }
  if(opDupCount!=0&&!que.isDuplicate)
  {
	    $('#dialog').empty();
		$('#dialog').append("<center><h4 style='color:red'>Please Edit Duplicate Options</h4></center><br/>");
		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
	    $( "#dialog" ).dialog({}); 
  }
  //else if(que.isDuplicate)opt dup and answer
	v+="</table>";
	row.html("");
	row.append(v);
			   
}
 
/* delete specified row*/
 
 function deleteRow(curr)
 {
	 var queAtIndex=$(curr).attr("ind")*1;
		var newInd=0;
		var opcount=0;
	    questionsArr[queAtIndex].options=[];
		var remove=questionsArr[queAtIndex];
	    questionsArr.splice( $.inArray(remove,questionsArr) ,1 );
	    //var queAfterDelete=questionsArr;
	    debugger;
  
<%--     $.ajax({
        type: 'POST',
        url: '<%=application.getContextPath()%>/DeleteAction',
        dataType: 'json',
        data:newArr,    
        success: function () 
        {    
            alert("data is farworded");    
        },
        error: function () 
        {
            alert("failure");
        }
    });
 --%> 
/*alert(queAtIndex+1);*/ 
 var parIndex=queAtIndex; 
  //debugger;
  var table = $("<table id='simple-table' class='table table-striped table-bordered table-hover dataTable no-footer' role='grid' aria-describedby='simple-table_info'>");
  var thead =$("<thead>");

  var tr =$("<tr>");

  var th =$("<th>");
  th.html("Q.No");
  tr.append(th);
  
  th =$("<th>");
  th.html("Question");
  tr.append(th);
  
  
  th =$("<th>");
  th.html("Options");
  tr.append(th);
  
  th =$("<th>");
  th.html("Level");
  tr.append(th);
  
  th =$("<th>");
  th.html("Operations");
  tr.append(th);
  
  thead.append(tr);
  table.append(thead);
  var tbody =$("<tbody>");
/* tr = $("<tr>");
var td=$("<td>");
td.html()l */
debugger;

var questionsArr2=[];
var queId=1;
debugger;
for(var i=0;i<questionsArr.length;i++)
{
   var queObj=new Question();
   var que=questionsArr[i];
   for (var j = i+1; j < questionsArr.length; j++)
   {
       if( ($.trim(questionsArr[i].question.toLowerCase())==$.trim(questionsArr[j].question.toLowerCase())) && (i != j) )
       {
          // alert("Duplicate Element is : "+questionsArr[j].question);
          
		   queObj.isDuplicate=true;
		   debugger;
       }
       
   }
   if(questionsArr[i].question!="You have'nt entered any question")
	{
		que.noQue=false;
	}
   queObj.questionInd=queId;
   queObj.question=que.question;
   queObj.level=que.level;
   queObj.options=que.options;
   queObj.optCount=que.optCount;
   queObj.answerExists=que.answerExists;
   queObj.noQue=que.noQue;
   debugger;

   queId++;
   questionsArr2.push(queObj);
} 
questionsArr=questionsArr2;
/* for(var i=0;i<questionsArr.length;i++)
{
	alert(questionsArr[i].question+''+questionsArr[i].isDuplicate);
}   */
for(var i =0 ; i < questionsArr.length ; i++)
{
	var ansCount=0;
	var optCount=0;
	tr = $("<tr  id='row"+i+"'>");
	var td=$("<td>");
	td.html(i+1);
	var newQuestIndex=i+1;
	tr.append(td);
	
	
	if(!questionsArr[i].noQue)
	{
		alert(questionsArr[i].question+'');

		if(questionsArr[i].isDuplicate==true)
		{
		     td=$("<td  id='questParentTd"+i+"' >");
			 td.html("<b style='color:red'>"+questionsArr[i].question+"</b>");
		
		}
		else if(questionsArr[i].question=='null')
		{
			td=$("<td  id='questParentTd"+i+"' >");
			 td.html("<b style='color:red'>You have'nt entered any question</b>");
		}
		else
		{
			td=	$("<td id='questParentTd"+i+"' >");
			td.html("<b >"+questionsArr[i].question+"</b>");
						
		}
	}
	else
	{
		 td=$("<td  id='questParentTd"+i+"' >");
		 td.html("<b style='color:red'>"+questionsArr[i].question+"</b>");
	}
		tr.append(td);
		var op = questionsArr[i].options;
	
		td="";
		if(op.length<=0)
		{
			td =$("<td class='danger' id='opt"+i+"'>");
			td.html("PLEASE PROVIDE OPTIONS");
		}
		
		else
		{
			td=$("<td id='opt"+i+"'>");
		}

		var opBody=$("<tbody>")  ;
		
		for(var j=0 ; j< op.length ; j++)
		{
	        var trow="";
	          if(op[j].isAnswer==true)
	          {
	        	  
	        	  ansCount++;
                      if(op[j].isDuplicate)
                           {

 	        	         trow= $("<tr  class='warning'>");
                    
                           }
                         else
                            {
	        	              trow= $("<tr  class='success'>");
                            }   
                      que.answerExists=0;
	          }
	          
	          else{
	                if(op[j].isDuplicate)
	                {

	  	        	  trow= $("<tr  class='warning'>");
	                     
	                }
	                else
	                {
	 	        	  trow= $("<tr  >");
	                }                                               
	                }	
                         var otd= $("<td id='opt"+j+"'>");
                         otd.html(op[j].option);
                         trow.append(otd);
		                 opBody.append(trow);
		                 optCount++;
		                
	    }
		  if(ansCount==0&&optCount!=0)
		  {
			    td =$("<td id='optTbl"+i+"'>");
				td.html("PLEASE PROVIDE ATLEAST ONE ANSWER");
                questionsArr[i].answerExists=1;
				
		  }
		  if(optCount==0)
		    {
				td =$("<td id='optTbl"+i+"'>");
					td.html("YOU DID NOT PROVIDE ANY OPTIONS");
	                questionsArr[i].answerExists=1;

					
			} 
		 
		var opTab="";			
		if(op.length>0)
		{
			opTab=	$("<table class='danger table table-hover' id='optTbl"+i+"' style='border:3px lightgray solid'>");
			
		opTab.append(opBody);
		td.append(opTab);
	    tr.append(td);
		}
		
		else
		{
			opTab=	$("<table class='table table-hover' id='optTbl"+i+"' style='border:3px lightgray solid'>");
			
			tr.append(td);		
		}
		td=$("<td>");
		td.html(questionsArr[i].level);
		var o=i+1;
		tr.append(td);
		td=$("<td>");
		var div = $("<div class='hidden-sm hidden-xs btn-group'>")
		var ip = $("<input class='btn btn-primary' type='button' name='edit' onclick='editQuestion(this)' ind='"+o+"' data-toggle='modal' data-target='#myEditModal' value='Edit'>");		
	    div.append(ip);
		ip=$('<input class="btn btn-danger" type="button" onclick="deleteRow(this);showButton();" ind="'+i+'" data-toggle="modal" value="Delete">');
        div.append(ip);
		td.append(div);
		tr.append(td);
		tbody.append(tr);
  }  
 
  table.append(tbody);  
  $("#simple-table_wrapper").html("");
  $("#simple-table_wrapper").append(table);
   
  $('#simple-table').dataTable({
		 "iDisplayLength": 3,
		 "pageLength": 5,
		 "aLengthMenu": [[3,5, 10, 50, -1], [3,5, 10, 50, "All"]],
		     "aoColumnDefs": [
		                      { 'bSortable': false, 'aTargets': [0,1,2,4] },
	                         ]
		
	      });
  
  /* function trigger on change of select option*/
  $('[aria-controls=simple-table]').on('change', function (e) {
     var optionSelected = $("option:selected", this);
     var valueSelected = this.value;
    showButton() ;
 });

	localStorage.setItem("questionArray",JSON.stringify(questionsArr));
	
}
/* hide dilog box */
 function btnhide()
 {
	 jQuery('#dialog').dialog('close');
	 	  
  }
 
 
//sending json object to server
$.ajaxSetup
({
    jsonp: null,
    jsonpCallback: null
});
/* function to send assessment paper data to server*/ 
function save()
{
   var duplicate=0;
   var ansDoesNotExist=0;
   var isOpt=true;
   var noQuestion=false;
   var ansOptCountIsEq=false;
   var optDup=false;

for(var i=0;i<questionsArr.length;i++)
{
  var ansCount=0;
  var que=questionsArr[i];
  
  if(que.isDuplicate)
  {
	  
	  duplicate++;
  }
 
  if(que.answerExists==1)
  {
	 
	  ansDoesNotExist++;
  }
  if(que.optCount<2)
  {
	  isOpt=false;
  }
  if(que.noQue==true)
  {
	  noQuestion=true;
  }
  for(var j=0;j<que.options.length;j++)
  {
	  if(que.options[j].isAnswer==true)
	  {
		 ansCount++; 
	  }
	  if(que.options[j].isDuplicate)
	  {
		  optDup=true;
	  }
  }
  if(ansCount==que.optCount)
  {
	  ansOptCountIsEq=true;
  }
}
if(noQuestion!=true){
if(duplicate==0)
{
	if(isOpt==true){
	if(!ansOptCountIsEq){
	if(!optDup){
	if(ansDoesNotExist==0){
    var myData= {"questJsonObj":JSON.stringify(questionsArr)};
     $.ajax({
        type: 'POST',
        url: '<%=application.getContextPath()%><%=URLConstants.EDIT_QUESTION_PAPER_ACTION_URL%>',
        dataType: 'json',
        data:myData,    
        success: function (data) 
        {    if(data.success!=undefined){
            
            $('#dialog').html("'<center>"+data.success+"</center>'");
    		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide();home();' value='OK'></center>");
    	    $( "#dialog" ).dialog({ }); 	   
    	    alert(data.success);
    	    window.localStorage.removeItem("questionArray");
    	    setTimeout(function(){window.top.location="<%=application.getContextPath()%>/jsp/technical_team/TechnicalAdminHomePage.jsp"} , 3000);
           // window.location.assign("<%=application.getContextPath()%>/jsp/technical_team/upload_assessment_paper.jsp");
        }
        else if(data.fail!=undefined)
        {
        	$('#dialog').empty();
    		$('#dialog').append("<center><h4 style='color:red'>"+data.fail+"</h4></center><br/>");
    		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
    		$( "#dialog" ).dialog({});
             
             	
        }
        else
        {
        	$('#dialog').empty();
    		$('#dialog').append("<center><h4 style='color:red'>"+data.error+"</h4></center><br/>");
    		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
    		$( "#dialog" ).dialog({ });
            alert(data.error);    
            
        }
        },
        error: function () 
        {
        	$('#dialog').empty();
    		$('#dialog').append("<center><h4 style='color:red'>Saving of data is failed</h4></center><br/>");
    		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
    		$( "#dialog" ).dialog({ });
            alert("failure");
        }
    });
}
	else{
		$('#dialog').empty();
		$('#dialog').append("<center><h4 style='color:red'>Please make sure that every question has atleast 1 answer</h4></center><br/>");
		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
		$( "#dialog" ).dialog({ });   
	    }//com
	}else{
		$('#dialog').empty();
		$('#dialog').append("<center><h4 style='color:red'>Please edit or delete duplicate options</h4></center><br/>");
		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
		$( "#dialog" ).dialog({ }); 
	}
 }
	else{
	     $('#dialog').empty();
	     $('#dialog').append("<center><h4 style='color:red'>Not allowed to select all option as answers</h4></center><br/>");
	     $('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
         $( "#dialog" ).dialog({});
        }
 }//
	else{
		$('#dialog').empty();
		$('#dialog').append("<center><h4 style='color:red'>Please provide atleast 2 options for each question</h4></center><br/>");
		$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
	    $( "#dialog" ).dialog({});			   
	    }	
}//dup if close
    else{
	    $('#dialog').empty();
	    $('#dialog').append("<center><h4 style='color:red'>Please delete or edit duplicate questions which are in red colour</h4></center><br/>");
	    $('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
        $( "#dialog" ).dialog({});
		}
}
else{
	$('#dialog').empty();
	$('#dialog').append("<center><h4 style='color:red'>Question should not be empty</h4></center><br/>");
	$('#dialog').append("<center><input class='btn btn-primary' type='button' onclick='btnhide()' value='OK'></center>");
    $( "#dialog" ).dialog({});		    
    }
}
/* function to add row */
function addRow() 
{
	
    var formOptions = $('#formOpt');
    formOptions.append("<div  class='dynamic-opt'><input type='checkbox'value='' name='check'>&nbsp;&nbsp;<input type='text'style='width:60%' name='option' value='no option'><input type='button' class='btn btn-sm btn-warning' value='remove' class='rem' onclick='removeRow()'></div>")
    
}
/* function to remove row */
function removeRow(curr)
{
	var i2=$(curr).parent();
	i2.remove();    
}
/* function to store and get data in local storage */
$(document).ready(function()
{
	debugger;
	if(localStorage.getItem("questionArray")==undefined)	
	{
		localStorage.setItem("questionArray",JSON.stringify(questionsArr));
		
	}else 
	{
		$(document).ready(function()
		{
		  showButton();
		  $('#simple-table').dataTable({
				 "iDisplayLength": 3,
				 "pageLength": 5,
				 "aLengthMenu": [[3,5, 10, 50, -1], [3,5, 10, 50, "All"]],
				     "aoColumnDefs": [
				                      { 'bSortable': false, 'aTargets': [0,1,2,4] },
			                         ]
				
			      });
		  });
		  
		  /* function trigger on change of select option*/
		  $('[aria-controls=simple-table]').on('change', function (e) 
		  {
		     var optionSelected = $("option:selected", this);
		     var valueSelected = this.value;
		     showButton();
		  });
		questionsArr= JSON.parse(localStorage.getItem("questionArray"));
		refreshQuestions();
	}
	
    
});
/* refreshing page data */
function refreshQuestions(){
    if(questionsArr.length!=0){
	var newInd=0;
	questionsArr= JSON.parse(localStorage.getItem("questionArray"));
	var que=questionsArr[newInd];
	if(que.question!=null)
	{
    for(var i=0;i<questionsArr.length;i++)
    {
    	for (var j = i+1; j < questionsArr.length; j++)
        {
    		
            if( ($.trim(questionsArr[i].question.toLowerCase())==$.trim(questionsArr[j].question.toLowerCase())) && (i != j) )
            {
    			que.isDuplicate=true;

            }
            else
            {
    			que.isDuplicate=false;

            }
            
        }
    	
    	newInd++;
    	
    } 
	}
  var table = $("<table id='simple-table' class='table table-striped table-bordered table-hover dataTable no-footer' role='grid' aria-describedby='simple-table_info'>");
  var thead =$("<thead>");

  var tr =$("<tr>");

  var th =$("<th>");
  th.html("Q.No");
  tr.append(th);
  
  th =$("<th>");
  th.html("Question");
  tr.append(th);
  
  
  th =$("<th>");
  th.html("Options");
  tr.append(th);
  
  th =$("<th>");
  th.html("Level");
  tr.append(th);
  
  th =$("<th>");
  th.html("Operations");
  tr.append(th);
  
  thead.append(tr);
  table.append(thead);
  var tbody =$("<tbody>");  
for(var i =0 ; i < questionsArr.length ; i++)
{
	var ansCount=0;
	tr = $("<tr  id='row"+i+"'>");
	var td=$("<td>");
	td.html(i+1);
	var newQuestIndex=i+1;
	tr.append(td);
	
	   if(questionsArr[i].question!='null')
	   {
		if(questionsArr[i].isDuplicate)
		{
		     td=$("<td  id='questParentTd"+i+"' >");
		     
			 td.html("<b style='color:red'>"+questionsArr[i].question+"</b>");
		
		}
		else
		{
			td=	$("<td id='questParentTd"+i+"' >");
			td.html("<b >"+questionsArr[i].question+"</b>");
						
		}
	  }else{
		  td=$("<td  id='questParentTd"+i+"' >");
		     
			 td.html("<b style='color:red'>You have'nt entered any question</b>");
	  }
		tr.append(td);
		var op = questionsArr[i].options;
		td="";
		if(op.length<=0)
		{
			td =$("<td class='danger' id='opt"+i+"'>");
			td.html("PLEASE PROVIDE OPTIONS");
		}
		else
		{
			td=$("<td id='opt"+i+"'>");
		}
		var opBody=    $("<tbody>")  ;
		for(var j=0 ; j< op.length ; j++)
		{
	        var trow="";
	          if(op[j].isAnswer==true)
	          {
	        	  
	        	  ansCount++;
                      if(op[j].isDuplicate)
                           {

 	        	         trow= $("<tr  class='warning'>");
                    
                           }
                         else
                            {
	        	              trow= $("<tr  class='success'>");
                            }   
                      que.answerExists=0;
	          }
	          
	          else{
	               if(op[j].isDuplicate)
	                {

	  	        	  trow= $("<tr  class='warning'>");
	                     
	                }else
	                {
	 	        	  trow= $("<tr  >");
	                }                                               
	                }	
                         var otd= $("<td id='opt"+j+"'>");
                         otd.html(op[j].option);
                         trow.append(otd);
		                 opBody.append(trow);
		                
	    }
		  if(ansCount==0&&op.length!=0)
		  {
			td =$("<td id='optTbl"+i+"'>");
			td.html("PLEASE PROVIDE ATLEAST ONE ANSWER");
            questionsArr[i].answerExists=1;	
		  } 
		  if(op.length==0)
		  {
			  td =$("<td id='optTbl"+i+"'>");
			  td.html("PLEASE PROVIDE ATLEAST TWO OPTIONS");
		  }
		var opTab="";			
		if(op.length>0)
		{
		opTab=	$("<table class='danger table table-hover' id='optTbl"+i+"' style='border:3px lightgray solid'>");			
		opTab.append(opBody);
		td.append(opTab);
	    tr.append(td);
		}
		else
		{
			opTab=	$("<table class='table table-hover' id='optTbl"+i+"' style='border:3px lightgray solid'>");	
			tr.append(td);		
		}
		td=$("<td>");
		td.html(questionsArr[i].level);
		var o=i+1;
		tr.append(td);
		td=$("<td>");
		var div = $("<div class='hidden-sm hidden-xs btn-group'>")
		var ip = $("<input class='btn btn-primary' type='button' name='edit' onclick='editQuestion(this)' ind='"+o+"' data-toggle='modal' data-target='#myEditModal' value='Edit'>");		
	    div.append(ip);
		ip=$('<input class="btn btn-danger" type="button" onclick="deleteRow(this);showButton();" ind="'+i+'" data-toggle="modal" value="Delete">');
        div.append(ip);
		td.append(div);
		tr.append(td);
		tbody.append(tr);
  }  
  table.append(tbody);
  $("#simple-table_wrapper").html("");
  $("#simple-table_wrapper").append(table);
  $('#simple-table').dataTable({
		 "iDisplayLength": 3,
		 "pageLength": 5,
		 "aLengthMenu": [[3,5, 10, 50, -1], [3,5, 10, 50, "All"]],
		     "aoColumnDefs": [
		                      { 'bSortable': false, 'aTargets': [0,1,2,4] },
	                         ]
		
	      });
  /* function trigger on change of select option*/
 $('[aria-controls=simple-table]').on('change', function (e) 
 {
     var optionSelected = $("option:selected", this);
     var valueSelected = this.value;
    showButton();
 });	
  
 }else
 {
    // alert("no data in table");
     $('#simple-table').empty();
     var s="No data available";
     $('#simple-table').html("<center><div style='height:60px;width:100px;color:red'><h4>"+s+"</h4></div></center>"); 

 } 
}
function home()
{
	window.top.location="<%=application.getContextPath()%>/jsp/technical_team/TechnicalAdminHomePage.jsp";
}
function cancelFun()
{
	//session.removeAttribute("assmentId");
	window.localStorage.removeItem("questionArray");
	window.top.location="<%=application.getContextPath()%>/jsp/technical_team/TechnicalAdminHomePage.jsp";

}
window.alert = function() { /* do nothing here */ }
/* after delete select event is not rising
 */
 </script>

	</body>
</html>