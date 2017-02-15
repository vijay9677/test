<!-- @author Rakesh kumar
this page displys the home page of student with the changepassword and logout functionality -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<center>
<center>

<hr><marquee><h1><span>Student Home page</span></h1></marquee><hr>
<div style="text-align: center;">
		<span
			style="border: 2px green solid; border-radius: 5px; background-color: green; width: 350px; height: auto; padding: 2px;">
			<a style="text-decoration: none; color: #fff;"href="<%=application.getContextPath() %>/jsp/ChangePassword.jsp"  method="post"  >click here to change password</a></span>
	</div>
	<center>
	<a href="<%=application.getContextPath() %>/LogoutAction">
	<span style="color:red">
	Logout
	</span>
	</a>
	</center>

</center>
</body>
</html>