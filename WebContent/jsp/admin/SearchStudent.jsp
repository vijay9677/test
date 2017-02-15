

<!-- @authors  Srikanth and Krunal  B35 -->


<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@page import="com.nacre.online_assesment.dto.UserDTO"%>
<%@page import="java.util.List"%>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>

<!---->
<!DOCTYPE html>
<html lang="en">
	<head>

	<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="Nacre Software Services Assesment"  />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<title>Search - Student</title>

		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>

  <link href="sticky-footer-navbar.css" rel="stylesheet">

<!--     <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 --> <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/assets/css/mycss/mystyle.css">

 </head>

<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/special_admin_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>

			<div class="main-content">
				<div class="main-content-inner">
				
			

					<div class="page-content">
					
				
								<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->					
						<h4 class="pink">
									<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
									 <b class="blue" >VIEW STUDENT INFORMATION</b> 
									 
								</h4>
		<!--Separetor start-->
								<div class="hr hr2 hr-dotted"></div>
								<!--Separetor end-->
								

						<div class="row">
	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->



<!-- write your code here -->

    <!-- Begin page content -->
 <div class="container">
  <div class="content row">
      
        <div class="col-sm-6 col-sm-offset-3">
            <div id=""> 
                <div class="input-group stylish-input-group">
                     <input type="text" class="form-control" name="email" id="email" placeholder="Email or Mobile No">
                    <span class="input-group-addon">
                        <button type="submit">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>  
                    </span>
                </div>
            </div>
        </div>
        </div>
  <div class="content row">
  
              <div class="col-sm-6 col-sm-offset-3" id="validatemsg">
      </div>
    </div>
    <!--  <div class="page-header"><h1>Student details</h1></div> -->
    
    	<%
	RequestDispatcher rd = request.getRequestDispatcher("/"+ URLConstants._GET_UNAPROVED_STUDENTDETAILS_ACTION);
	rd.include(request, response);
	List unaprovedStudentList = (List)request.getAttribute("unaprovedList");
	%>
    <% 
    if(unaprovedStudentList.size()==0){%>
    	 <div class="col-sm-6 col-sm-offset-3"><h2 style="color: #b42626 !important;" >No students were found to verify</h2></div>
    <% }else{
    for(int i=0;i<unaprovedStudentList.size();i++){
    	UserDTO userDto = (UserDTO)unaprovedStudentList.get(i);
    %> 
    <div class="">
    <div class="row"  id='items'>
    <div class="col-md-6"  id='items'>
    <div class="bs-example bs-example-images"> 
    <img src="<%=userDto.getImage()%>" alt="..." class="img-circle">
    
    <div id='items' style="margin-left:180px;margin-top:-130px;font-size:17px;font-family: initial;">
      Name : <%=userDto.getFirstname()%> <%=userDto.getLastname() %><br>
      email : <%=userDto.getEmail() %><br>
     mobile No : <%=userDto.getMobileNo() %><br>
      <a class="btn btn-default" href="<%=application.getContextPath()%>/<%=URLConstants._GET_STUDENT_DETAILS_TO_VERIFY_ADMIN%>?user_id=<%=userDto.getUserid()%>">View details &raquo;</a>
    
    </div>
    
    </div></div>
    
    <%if(i+1<unaprovedStudentList.size()){
    	i++;
    	UserDTO userDto1 = (UserDTO)unaprovedStudentList.get(i);
    	
     %>
   
    <div class="col-md-6" id='items'>
    <div class="bs-example bs-example-images"> 
    <img src="<%=userDto1.getImage()%>" alt="..." class="img-circle">
    
    <div  id='items' style="margin-left:180px;margin-top:-130px;font-size:17px;font-family: initial;">
     	Name : <%=userDto1.getFirstname()%> <%=userDto1.getLastname() %><br>
     	 email : <%=userDto1.getEmail() %><br>
    	 mobile No : <%=userDto1.getMobileNo() %><br>
      <a  class="btn btn-default" href="<%=application.getContextPath()%>/<%=URLConstants._GET_STUDENT_DETAILS_TO_VERIFY_ADMIN%>?user_id=<%=userDto1.getUserid()%>">View details &raquo;</a>
    
    </div>
    
    </div>
    </div> </div>
    <%} %>
    </div>
    <%} }%>
  </div> 
     <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->


	


<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>

		</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>

<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<script type="text/javascript">

var path ="<%=application.getContextPath()%>";
</script>



<!-- Custom styles for this template --><%-- 
  <script type="text/javascript" src="${path}/js/script.js"></script> --%><!-- 
  <script type="text/javascript" src="jquery.validate.min.js"></script> -->
<%--   <script src="<%=application.getContextPath()%>/assets/js/jquery-2.1.1.js"></script>
 --%>    <script>
    $(document).ready(function(){
    	
    	
    	
    	
    	$('#email').on('keyup', function() {
    		var exist = false;
            var rex = new RegExp($(this).val(), 'i');
              $('.container #items').hide();

              debugger;
          if($('.container #items').filter(function() {
            	//  alert("hi");
            	  exist = true;
                  return rex.test($(this).text());
              }).show().length <=0){
        	  
        	  

              $('#validatemsg').html("<div class='alert alert-danger'>"+
                     " <strong>NO RECORDS!</strong> Matches are not found."+
                     "<a href=''#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"+
                      "</div>");
              
          }else{
        	  $('#validatemsg').html("");
          }
              
             
          });
    	
    	
    	
    	
/*     $("#searchbtn").click(function(){
  var mail = $("#email").val();
  if(mail==''){
  $("#email").css({'border-color':'red'});

      $('#validatemsg').html("<p style='color:red'>Please Enter email or Mobile number</p>");
         
  }
  else if ( mail.indexOf("@") > -1 )  {    

     if (!ValidateEmail(mail)) {
     $("#email").css({'border-color':'red'});

      $('#validatemsg').html("<p style='color:red'>Invalid email address</p>");
            
        }
        else {
         $("#email").css({'border-color':''});

        $('#validatemsg').html("<p style='color:green'>valid email address</p>");
        
        
        
        
            
        }
    }
    else{

    if (!Validatemobile(mail)) {
     $("#email").css({'border-color':'red'});

      $('#validatemsg').html("<p style='color:red'>Invalid mobile number</p>");
            
        }
        else {
         $("#email").css({'border-color':''});

        $('#validatemsg').html("<p style='color:green'>valid mobile number</p>");
            
        }
    
    }
    }); */
    
    
    
    
});
  function ValidateEmail(email) {
        var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        return expr.test(email);
    };
    
    function Validatemobile(mobile) {
        var expr = /^([0|\+[0-9]{1,5})?([7-9][0-9]{9})$/;
        return expr.test(mobile);
    };

    </script>



</body>
</html>