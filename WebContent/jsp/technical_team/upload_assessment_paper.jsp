<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.online_assesment.dto.AssesmentDTO"%>
<%@page import="com.nacre.online_assesment.util.URLConstants"%>

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
		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="../../assets/css/dropzone.min.css" />
	</head>
<body class="no-skin">
<div class="main-container" id="main-container">

<jsp:include page="../../jsp/common/technical_Team_header.jsp"></jsp:include>

<jsp:include page="../../jsp/common/technicalteam_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
<div>
 <form action="<%=application.getContextPath()%>/<%=URLConstants.ASSESSMENT_PAPER_UPLOAD_ACTION_URL%>" class="dropzone" id="dropzone" enctype="multipart/form-data" method="post">
	<div class="fallback" id="div">
	  <input name="file" type="file" id="file" onblur='upload()'/>  
    </div>
</form>
     <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
     </a>
</div>
<div align="center" id='msg' ><span> </span></div>
<div align="center" id='proceedLink'>
<a href="<%=application.getContextPath()%>/jsp/technical_team/QuestionEdit.jsp" onclick="removeData()" ><h3> Proceed </h3></a></div>
<!-- /.main-container -->
</div>

<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
</div><!-- /.main-container -->
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
<%if(request.getParameter("assessId")!=null){Integer assmentId=Integer.parseInt(request.getParameter("assessId"));
session.setAttribute("assmentId", assmentId);
%>
<%}%>

<script type="text/javascript">
var path = '<%=application.getContextPath()%>';
</script>
 
 						<script src ="${path}/assets/js/MounikaAssmentNotiTechTeam.js">
						</script>

<!-- page specific plugin scripts -->
    <script src="../../assets/js/dropzonemax.js"></script>
    <script type="text/javascript">
    </script>
<!-- inline scripts related to this page -->
<script type="text/javascript">

var setTime=0;
jQuery(function($){
	try {
	    Dropzone.autoDiscover = false;
		var myDropzone = new Dropzone("#dropzone" , 
			{
			    paramName: "file", // The name that will be used to transfer the file
			    maxFilesize: 0.5, // MB
				addRemoveLinks : true,
				removedfile: function(file) 
				{
					$("#msg").hide();
			    	$('#proceedLink').hide();
			    	return stopSendingData(file);
			    	

				},
				dictDefaultMessage :
				'<span class="bigger-150 bolder"><i class="ace-icon fa fa-caret-right red"></i> Drop files</span> to upload \
				<span class="smaller-80 grey">(or click)</span> <br /> \
				<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>',
				dictResponseError: 'Error while uploading file!',
				allowedPreviewTypes:['.xlsx'],
				//change the previewTemplate to use Bootstrap progress bars
				previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>"
			  });
		/* myDropzone.on('addedfile', function(file)
		  {
			var allowedFiles = [".xlsx",".xlsm"];
	        var fileUpload = $("#fileUpload");
	        var lblError = $("#lblError");
	        var error;
	        var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:\@])+(" + allowedFiles.join('|') + ")$");
	        if (!regex.test(fileUpload.val().toLowerCase())) {
	            lblError.html("Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.");
	            alert("Please upload files having extensions: only.");
	            return false;
	        }
	        lblError.html('');
	        return true;  
     
	      });		 */  
	     
	 myDropzone.on("success", function(file,responseText)
		{
		 $('#proceedLink').show();	
		 $("#msg").show();
		 //setTimeout(function() { $("#msg").hide(); }, 2000);
		 $('#msg').children().html('<b style="color:green">Sheet successfully uploaded click proceed link or wait 8 sec it automatically redirect <br/> if you want to change file click remove and reupload <b>');
	     window.localStorage.removeItem("questionArray");
	     send();
	     console.log(file);
		 var fileonserver = responseText; 
		 file.name = fileonserver; 
		});
	 myDropzone.on("error", function(file,responseText)
	 {
		 $("#msg").show();
		 $('.dz-error-message').empty();
		// $('.dz-filename').children().html('Please upload files with .xlsx extensions only');
		 $('#msg').children().html('<b style="color:red">Please upload files with .xlsx extensions only remove file and reupload<b>');
		 //alert("not in correct format");
		 //setTimeout(function(){reload();} ,1800);
	 });

	
			   $(document).one('ajaxloadstart.page', function(e) 
			    {
				  
					try 
					{
						
						myDropzone.destroy();
					} 
					catch(e) 
					{
						  alert('please select file with extension .doc,.docx,.pdf only!');

					}
			    });
			
			 } 
	        catch(e) 
	        {
			  alert('please select file with extension .doc,.docx,.pdf only!');
			}
			
			});
       $(document).ready(function()
		{
    	   $('#proceedLink').hide();
		});
       function reload()
       {
  	     location.reload();

       }
       function send()
       {
    	   setTime=setTimeout(function(){window.top.location="<%=application.getContextPath()%>/<%=URLConstants.EDIT_ASSESMENT_PAPER%>"} ,8000);
 
       }
       function stopSendingData(file)
       {
    	   if(setTime!=0){
    	  // alert("hai");
    	   clearTimeout(setTime);}
    	   var _ref; // Remove file on clicking the 'Remove file' button
		   return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;
			
       }
      
		</script>
    </body>
</html>
