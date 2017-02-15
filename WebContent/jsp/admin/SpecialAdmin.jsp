<!-- @author Rakesh kumar
this is the home page of specialadmin which has changepassword and Logout Functionality -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<center><h3>Special Admin<hr/></h3></center>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Assessment B35</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="row" style="text-align:right;">

<!-- Trigger the modal with a button -->
  <div class="col-md-12"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Special Admin</button>
<hr/></div>
</div>
</div>

<div class="table-responsive" style="border:lightgray 1px solid; box-shadow:5px 5px 5px lightgray; width: 84%; margin-left: 8%;">
<table class="table" style="text-align: center;">
<table class="table table-bordered" style="text-align: center;">
    <thead>
      <tr style="background-color: #848482;color:#fff;">
        <th>User_ID</th>
        <th>Name</th>
        <th>Department</th>
        <th>Mobile No</th>
        <th>Activity</th>
      </tr>
    </thead>
    <tbody>
      <tr class="success" style="background-color:lightgray; padding:5px; height:auto;">
        <td>1.</td>
        <td>Vijay</td>
        <td>Special_Admin</td>
        <td>9542683145</td>
        <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
  		<input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr>
    </tbody>
  </table>
</div>




<!-- <div class="container" style="border:lightgray 1px solid; box-shadow:5px 5px 5px lightgray; text-align:center;">
<div class="row" style="background-color: #848482;color:#fff;">
  <h4><div class="col-md-2"><label>S. No.</label></div>
  <div class="col-md-3"><label>Name</label></div>
  <div class="col-md-3"><label>Department</label></div>
  <div class="col-md-2"><label>Mobile No</label></div>
  <div class="col-md-2"><label>Activity</label></div></h4>
</div>
<div class="row" style="background-color:#E5E4E2; padding:5px; height:auto; text-align:center;">
  <div class="col-md-2"><label>1.</label></div>
  <div class="col-md-3"><label>Vijay</label></div>
  <div class="col-md-3"><label>Admin</label></div>
  <div class="col-md-2"><label>9542683145</label></div>
  <div class="col-md-2">
  	
  	<input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
  	<input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/>
  </div>
</div>
</div> -->


<!-- This Modal For Add Records... -->
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Special Admin</h4>
      </div>
      <div class="modal-body">
        


<div class="container">
		<form class="form-horizontal" role="form">
		<p> <span style="color:Green;font-weight:bold">Note: </span> <span style="color:red;font-weight:bold"> *</span> fields are mandatory.</p>
			<div class="form-group">
				<label class="control-label col-sm-2" for="userId">User_Id:</label>
				<div class="col-sm-3">
					<input type="userId" name="userId" class="form-control" id="userId"
						placeholder="Enter User_Id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="fname">First Name: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<input type="fname" name="fname" class="form-control" id="fname"
						placeholder="Enter First Name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lname">Last Name:</label>
				<div class="col-sm-3">
					<input type="lname" name="lname" class="form-control" id="lname"
						placeholder="Enter Last Name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<input type="email" name="email" class="form-control" id="email"
						placeholder="Enter email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<input type="password" name="pwd" class="form-control" id="pwd"
						placeholder="Enter password">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="mno">Mobile No: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<input type="mno" name="mno" class="form-control" id="mno"
						placeholder="Enter Mobile Number">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<input type="gender" name="gender" class="form-control" id="gender"
						placeholder="Enter Gender">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="image">Image:</label>
				<div class="col-sm-3">
					<input type="file" name="image" class="form-control" id="image"
						placeholder="Enter image">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="dob">Date Of Birth: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<input type="date" name="dob" class="form-control" id="dob"
						placeholder="Enter Date_Of_Birth">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="roleId">Role_Id: <span style="color:red;font-weight:bold">*</span></label>
				<div class="col-sm-3">
					<input type="roleId" name="roleId" class="form-control" id="roleId"
						placeholder="Enter Role_Id">
				</div>
			</div>
			
		</form>
	</div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" data-dismiss="modal">Submit</button>&nbsp;&nbsp;
        <button type="reset" class="btn btn-danger" data-dismiss="modal">Clear</button>
      </div>
    </div>

  </div>
</div>


<!-- This Modal For Edit Records... -->

<!-- Modal -->
<div id="myEditModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Record</h4>
      </div>
      <div class="modal-body">
        

<div class="container">
		<form class="form-horizontal" role="form">
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="userId">User_Id:</label>
				<div class="col-sm-3">
					<input type="userId" class="form-control" id="userId">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="fname">First Name:</label>
				<div class="col-sm-3">
					<input type="fname" class="form-control" id="fname">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lname">Last Name:</label>
				<div class="col-sm-3">
					<input type="lname" class="form-control" id="lname">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-3">
					<input type="email" class="form-control" id="email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-3">
					<input type="password" class="form-control" id="pwd">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="mno">Mobile No:</label>
				<div class="col-sm-3">
					<input type="mno" class="form-control" id="mno">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender:</label>
				<div class="col-sm-3">
					<input type="gender" class="form-control" id="gender">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="image">Image:</label>
				<div class="col-sm-3">
					<input type="file" class="form-control" id="image">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="dob">Date Of Birth:</label>
				<div class="col-sm-3">
					<input type="date" class="form-control" id="dob">
				</div>
			</div>
			
		</form>
	</div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" data-dismiss="modal">Update</button>&nbsp;&nbsp;
        <button type="reset" class="btn btn-danger" data-dismiss="modal">Cancel</button>
      </div>
    </div>

  </div>
</div>


<!-- This Modal For Delete Records... -->
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




</body>
</html>