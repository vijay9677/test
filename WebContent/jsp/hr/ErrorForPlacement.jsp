<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Error Page</title>
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel="stylesheet" href="<%=application.getContextPath()%>/assets/font-awesome/4.2.0/css/font-awesome.min.css" />
</head>
<body>
	<div class="page-content">
<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<div class="error-container">
									<div class="well">
										<h1 class="grey lighter smaller">
											<span class="blue bigger-125">
												<i class="ace-icon fa fa-random"></i>
												
											</span>
											Something Went Wrong
										</h1>

										<hr />
										<h3 class="lighter smaller" >
										 PlZZZ try Later...
											
										</h3>

										<div class="space"></div>

										<hr />
										<div class="space"></div>

										<div class="center">
											<a href="javascript:history.back()" class="btn btn-grey">
												<i class="ace-icon fa fa-arrow-left"></i>
												Go Back
											</a>

											<a href="<%=application.getContextPath()%>/jsp/hr/showplacements.jsp" class="btn btn-primary">
												<i class="glyphicon glyphicon-home"></i>
												<span  class="bigger-110"  ><strong>Go!</strong> Home Page </span>
											</a>
										</div>
									</div>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
		
</body>
</html>