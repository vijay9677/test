<!-- @author KRISHNA PRAKASH -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.nacre.online_assesment.dto.AssesmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.online_assesment.util.URLConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
        <link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<meta name="description" content="Nacre Software Services Assesment"  />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<title>Technical-Team</title>
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
	<script  src="<%=application.getContextPath()%>/assets/js/jquery-2.1.1.js"></script>
	<script  src="<%=application.getContextPath()%>/assets/js/jquery-ui.min.js"></script>
    <title>Home - Student</title>
    <jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
    <style type="text/css">
    div#sidebar 
		{
           width: 15%;
        }
		
    #selectAID
    {
    width:200px;
    height:35px;
    border-width:3px;
    border-color:silver;
    color:green;
    font-style:italic;
    font-size:larger;
    border-radius:5px 5px 5px 5px;
    }
    #btn
    {
    height:36px;
    border-width:2px;
    border-radius:15px 0px 15px 0px;
    }
    </style>
</head>
<body class="no-skin">
 <div class="main-container" id="main-container">
 
<jsp:include page="../../jsp/common/technical_Team_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/technicalteam_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- Delete Assessment Paper  (Krishna prakash)-->
 <div>
 <h1 style="font-size:200%;font-family:serif; color:green" >Delete Assessment Paper</h1>
 <div class='center' style='width: 1050px;height:500px ;background-image:url("<%=application.getContextPath()%>/images/DeleteImg.jpg")' >
 <%-- <form action="<%=application.getContextPath()%>/DeletePaperAction"> --%>
<div align="center" style='padding-top:180px;padding-bottom: auto;'>
<select name="assId" class='dropdown-toggle'  id='selectAID'>
<%RequestDispatcher rd = request.getRequestDispatcher(URLConstants.GET_ASSESSMENT_PAPER_ACTION_URL);
rd.include(request, response);%>
<%
List<AssesmentDTO> adt=null;
if(session.getAttribute("assessmentPaper")!=null){%>
<%adt=(List<AssesmentDTO>)session.getAttribute("assessmentPaper");	
   int count=0;
  for(Object s :adt)
      {
	    AssesmentDTO obj=(AssesmentDTO)s;%>
	    <option value="<%=obj.getAssesmentId()%>" style='border-radius:inherit;'><%=obj.getAssesment()%><%
	    count++;}
    if(count==0){%>
    <option value="0">.......No paper.....</option>
    
    <%}}%>
        </option>
</select>
<br><br>
  <button id='btn' class='btn btn-white btn-warning btn-bold' onclick='deletePaper()'> 
  <i class="ace-icon fa fa-trash-o bigger-120 orange"></i>Delete												
  </button>
  </div>
</div>
</div>
<!-- end code -->
         <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
       </div><!-- /.main-container --> 
        <jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
 <script type="text/javascript">
var path = '<%=application.getContextPath()%>';
</script>
<script src ="${path}/assets/js/MounikaAssmentNotiTechTeam.js">
</script>   
<script type="text/javascript">
function deletePaper()
{
	//alert("hai");
	var assemId=$('#selectAID').val();
	//alert(assemId);
    var myData= {"assId":assemId};
    if(assemId==0)
    {
    	alert("you didn't select any assessment paper");
    }
    else
    {
    if(assemId!=null)
    {
	$.ajax({
        type: 'POST',
        url: '<%=application.getContextPath()%><%=URLConstants.DELETE_ASSESSMENT_QUESTION_ACTION_URL%>',
        data:myData, 

        success: function (data) 
        {           debugger;
 
        	if(data.success!=undefined)
        	{
            	   
    	    alert(data.success);
    	    location.reload();
            }
        else if(data.fail!=undefined)
        {
            alert(data.fail);    
             	
        }
        else 
        {
            alert(data.error);    
            
        }
        },
        error: function () 
        {
            alert("failure");
        }
    });
    }
    else
    {
    	alert("you did not select any assessment paper");
    }
  }
    debugger;
}
</script>
</body>
</html>