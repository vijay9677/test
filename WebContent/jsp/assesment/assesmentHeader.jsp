 <!-- 
   @author Chitranshu Gupta
 -->
<!DOCTYPE html>
<html lang="en">
<head>

<link rel="icon" href="assets/images/nacre/nacre.png"
	type="image/x-icon">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />

<meta name="description" content="Nacre Software Services Assesment" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<title>EXAM</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="<%=application.getContextPath()%>"></c:set>

<jsp:include page="../common/common_css.jsp"></jsp:include>

	<div class="container-fluid" style="background-color: #438eb9; padding: 8px;">
			<div class="container">
				<div class="row">
				  <div class="col-sm-12">
					<img src='${path}/assets/images/nacre/nacre.png'
						title="NACRE SOFTWARE SEEVICES" width='30px' class='img-rounded'>

						<span style="color:#FFF; font-size:16px;">Nacre Exam Portal</span>
					</div>
				</div>
			</div>
		</div>
<style type="text/css">
	@media screen and (max-width: 480px) {
		.footerPosition {
			position: relative;
		}
	}
</style>