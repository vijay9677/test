 


<%@page import="com.nacre.online_assesment.util.URLConstants"%>
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

 <script type="text/javascript" src="${path}/assets/js/AvoidingBackButton.js">
	    
	    </script>
			
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>
	<link rel="stylesheet" href="${path}/assets/dist/css/bootstrap-select.min.css">

<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/bootstrap-select.css">
	
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/select2.min.css">
		
			</head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/viewopportunityheader.jsp"></jsp:include>

<jsp:include page="../../jsp/common/systemadmin_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
 

			

<title>Insert title here</title>
<style>

#table{
margin-top:10px;
width:100%;
}

</style>

								<!--Separetor end-->					
								<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									<b class="blue" >View FeedBack</b>
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
     <div class="container" >
      <div class="row">
      
      
		 <div class="col-sm-3">
		    <select id="feedbackType" onchange='selhide()' class="selectpicker" data-hide-disabled="true" data-live-search="true"
				name="feedback">
				
			</select>
			</div>
			
		
		 <div class="col-sm-3" id='companydiv'>
		    <select id="company" onchange="getLocation()"  class="selectpicker" data-hide-disabled="true" data-live-search="true">
		    
			</select>
			</div>
			
		 <div class="col-sm-3" id='locationdiv'>
		    <select id="location"  class="selectpicker" data-hide-disabled="true" data-live-search="true">
		    <option value=''>Select Location</option>
			</select>
			</div>		
		<div class="col-sm-2">
		<button type="button" onclick="getFeedback()" class="btn btn-info"> View </button>
		</div>
	  </div>
	 
	</div>
<hr/>
<div  id="table">
    <table id="Jdatatable" class="table table-responsive table-bordered">
        <thead>
            <tr>
               <th >Client Name</th>
               <th>Client Image</th> 
               <th >City</th> 
               <th>Location</th>
               <th width=200px>Feedback</th> 
               <th width=60px>Date</th>  
               <th>Email Id</th> 
               <th >Batch No</th> 
               <th>Technology</th>         
            </tr>
        </thead>
      
    </table>
</div>


<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>

<script type="text/javascript" src="${path}/assets/js/gajananNotificationsJobpost.js"></script>

<script src="<%=application.getContextPath()%>/js/jquery-ui.js"></script>
<script src="<%=application.getContextPath()%>/js/bootstrap-select.js"></script>
<script src="<%=application.getContextPath()%>/js/select2.full.js"></script>

<script type="text/javascript" src="<%=application.getContextPath() %>/assets/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath() %>/assets/js/jquery.dataTables.bootstrap.min.js"></script>

<script type="text/javascript">


$(document).ready(function () {
        //debugger;
        
        
    var dTable =    $("#Jdatatable").DataTable({
    	
            "ajax": {
                "url": "<%=application.getContextPath()%>/<%=URLConstants.GET_ALL_FEEDBACKS%>",
                "type": "GET",
                "datatype":"json"
                
                
            },
            
            "columns": [
                        { "data": "ClientName", "autoWidth": true },
                        {
                            "render": function (data, type, full, meta) {
                                return '<img class="img-rounded" alt="Cinque Terre" width="104" height="90" src="'+full.Image+'">';
                            }
                        },
                        { "data": "City", "autoWidth": true },
                        { "data": "Location", "autoWidth": true },
                        { "data": "FeedbackMsg", "autoWidth": false },
                        { "data": "Date", "autoWidth": true },
                        {"data":"Email","autoWidth":true},
                        {"data":"Batch","autoWidth":true},
                        {"data":"Technology","autoWidth":true}
            ]
        });
    
    
 
 }); 
//}
</script>


<script type="text/javascript">

$.ajax({
	url:"<%=application.getContextPath()%>/<%=URLConstants.GET_FEEDBACK%>",
	type:"post",
	success: function(data){
		
		
		 /* $("#feedbackType").append(" <option value=''>Select Feedback Type</option>"); */ 
		$("#feedbackType").append("<option value='all'>All Feedbacks</option>");

		$('#companydiv').hide();
		$('#locationdiv').hide();

		
		for(var ind=0; ind<data.length; ind++){
		$("#feedbackType").append("<option value='"+data[ind].feedbackTypeId+"'>"+data[ind].feedbackType+"</option> ");
		}
		$("#feedbackType").selectpicker('refresh');

	}
});



$.ajax({
	url:"<%=application.getContextPath()%>/<%=URLConstants.GET_COMPANY%>",
	type:"post",
	success: function(data){
		
		
		 $("#company").append(" <option value=''>Select Company</option>");
		
		
		for(var ind=0; ind<data.length; ind++){
		$("#company").append("<option value='"+data[ind].clientId+"'>"+data[ind].clientName+"</option> ");
		}
		$("#company").selectpicker('refresh');

	}
});

function getLocation(){
	
	var clientId=  $("#company").val();
	
$.ajax({
	url:"<%=application.getContextPath()%>/<%=URLConstants.GET_COMPANY_ADDRESS%>",
	type:"post",
	data:{"clientId":clientId},
	success: function(data){

		// $('#location').remove();
		 //var v ='<select id="location"  class="selectpicker" data-hide-disabled="true" data-live-search="true" tabindex="-98">';
		  
		 $("#location").empty(); 
		 
		 $("#location").append(" <option value=''>Select Location</option>");
		
		
		for(var ind=0; ind<data.length; ind++){
			$("#location").append("<option value='"+data[ind].cityid+"'>"+data[ind].city+"</option> ");
		}
		$("#location").selectpicker('refresh');
	}

});

}
</script>


<script type="text/javascript">

 function selhide(){
	
	var feedbacktype= $("#feedbackType").val();
	
	
	if(feedbacktype==1 || feedbacktype=='all'){
		
		$('#companydiv').hide();
		$('#locationdiv').hide();
	}
	else{
		
		$('#companydiv').show();
		$('#locationdiv').show();
	}
	
} 

function getFeedback(){
	
	var feedbacktype= $("#feedbackType").val();
	var clientId= $("#company").val();
	var addressId=$("#location").val();

	
	if(feedbacktype=='all'){
		
		clientId='';
		addressId='';
	}
	
	
	
	if(feedbacktype==1){
    	
    	
    	$("#Jdatatable").dataTable().fnDestroy();
    	
		var dTable =  $("#Jdatatable").DataTable({
			
			
            "ajax": {
                "url": "<%=application.getContextPath()%>/<%=URLConstants.GET_ORGANIZATON_FEEDBACKS%>",
                "type": "GET",
                "datatype":"json",
                "data":{'feedbackId':feedbacktype},
                
                
            },
           
            "columns": [
                        { "data": "ClientName", "autoWidth": true },
                        {
                            "render": function (data, type, full, meta) {
                                return '<img class="img-rounded" alt="Cinque Terre" width="104" height="90" src="'+full.Image+'">';
                            }
                        },
                        { "data": "City", "autoWidth": true },
                        { "data": "Location", "autoWidth": true },
                        { "data": "FeedbackMsg", "autoWidth": false },
                        { "data": "Date", "autoWidth": true },
                        {"data":"Email","autoWidth":true},
                        {"data":"Batch","autoWidth":true},
                        {"data":"Technology","autoWidth":true}
            ]
        });
    
	}
	else if(feedbacktype==2 || clientId>0 || (clientId>0 && addressId!='')){
		//alert("=================="+clientId);
		//alert("--------------"+addressId);
		
		
		if(clientId!=''){
			
			feedbacktype='';
		}
		
		$("#Jdatatable").dataTable().fnDestroy();

		feedbacktype= $("#feedbackType").val();
		//alert(feedbacktype);
		var dTable = $("#Jdatatable").DataTable({
			
            "ajax": {
                "url": "<%=application.getContextPath()%>/<%=URLConstants.GET_COMPANIES_FEEDBACKS %>",
                "type": "GET",
                "datatype":"json",
               "data":{'feedbackId':feedbacktype,"clientId":clientId, "addressId":addressId},
                
            },
            
            "columns": [
                        { "data": "ClientName", "autoWidth": true },
                        {
                            "render": function (data, type, full, meta) {
                                return '<img class="img-rounded" alt="Cinque Terre" width="104" height="90" src="'+full.Image+'">';
                            }
                        },
                        { "data": "City", "autoWidth": true },
                        { "data": "Location", "autoWidth": true },
                        { "data": "FeedbackMsg", "autoWidth": false },
                        { "data": "Date", "autoWidth": true },
                        {"data":"Email","autoWidth":true},
                        {"data":"Batch","autoWidth":true},
                        {"data":"Technology","autoWidth":true}
            ]
        });
    
	}
	else{
		
		$("#Jdatatable").dataTable().fnDestroy();
		var dTable =  $("#Jdatatable").DataTable({
			
            "ajax": {
                "url": "<%=application.getContextPath()%>/<%=URLConstants.GET_ALL_FEEDBACKS %>",
                "type": "GET",
                "datatype":"json"                
            },
            
            "columns": [
                        { "data": "ClientName", "autoWidth": true },
                        {
                            "render": function (data, type, full, meta) {
                                return '<img class="img-rounded" alt="Cinque Terre" width="104" height="90" src="'+full.Image+'">';
                            }
                        },
                        { "data": "City", "autoWidth": true },
                        { "data": "Location", "autoWidth": true },
                        { "data": "FeedbackMsg", "autoWidth": false },
                        { "data": "Date", "autoWidth": true },
                        {"data":"Email","autoWidth":true},
                        {"data":"Batch","autoWidth":true},
                        {"data":"Technology","autoWidth":true}
            ]
        });
    
}
	
	}

</script>

</body>
</html>