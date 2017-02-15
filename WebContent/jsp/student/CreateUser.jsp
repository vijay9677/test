<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<center><h3>Create User Form Page</h3></center>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Assessment B35</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="container">
		<form class="form-horizontal" role="form">
		
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="userId">User_Id:</label>
				<div class="col-sm-10">
					<input type="userId" class="form-control" id="userId"
						placeholder="Enter User_Id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="fname">First Name:</label>
				<div class="col-sm-10">
					<input type="fname" class="form-control" id="fname"
						placeholder="Enter First Name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lname">Last Name:</label>
				<div class="col-sm-10">
					<input type="lname" class="form-control" id="lname"
						placeholder="Enter Last Name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"
						placeholder="Enter email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter password">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="mno">Mobile No:</label>
				<div class="col-sm-10">
					<input type="mno" class="form-control" id="mno"
						placeholder="Enter Mobile Number">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender:</label>
				<div class="col-sm-10">
					<input type="gender" class="form-control" id="gender"
						placeholder="Enter Gender">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="image">Image:</label>
				<div class="col-sm-10">
					<input type="file" class="form-control" id="image"
						placeholder="Enter image">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="dob">Date Of Birth:</label>
				<div class="col-sm-10">
					<input type="dob" class="form-control" id="dob"
						placeholder="Enter Date_Of_Birth">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="isNacre">Is_Nacre:</label>
				<div class="col-sm-10">
					<input type="isNacre" class="form-control" id="isNacre"
						placeholder="Enter Is_Nacre">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="roleId">Role_Id:</label>
				<div class="col-sm-10">
					<input type="roleId" class="form-control" id="roleId"
						placeholder="Enter Role_Id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="addressId">Address_Id:</label>
				<div class="col-sm-10">
					<input type="addressId" class="form-control" id="addressId"
						placeholder="Enter Address_Id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="statusId">Status_Id:</label>
				<div class="col-sm-10">
					<input type="statusId" class="form-control" id="statusId"
						placeholder="Enter Status_Id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Batch_Id:</label>
				<div class="col-sm-10">
					<input type="batchId" class="form-control" id="batchId"
						placeholder="Enter Batch_Id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Technology_Id:</label>
				<div class="col-sm-10">
					<input type="techId" class="form-control" id="techId"
						placeholder="Enter Technology_Id">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Submit</button>&nbsp;&nbsp;
					<button type="reset" class="btn btn-danger">Clear</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>