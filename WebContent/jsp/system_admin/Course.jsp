<!DOCTYPE html>
<html lang="en">
<head>
<center><h3>Courses<hr/></h3></center>
  <title>Online Assessment B35</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<div class="row" style="text-align:right;">

<!-- Trigger the modal with a button -->
  <div class="col-md-12"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Course</button>
<hr/></div>
</div>

<div class="table-responsive">
<table class="table">
<table class="table table-bordered">
<thead>
      <tr>
        <th>COURSE_ID</th>
        <th>COURSE</th>
        <th>ACTIVITY</th>
      </tr>
    </thead>
    <tbody>
      <tr class="success">
        <td>01</td>
        <td>CORE-JAVA</td>
        <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
        <input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr>
      <tr class="success">
        <td>02</td>
        <td>JDBC</td>
        <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
        <input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr>
      <tr class="success">
        <td>03</td>
        <td>SERVLET</td>
        <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
        <input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr>
      <tr class="danger">
       <td>04</td>
       <td>JSP</td>
       <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
       <input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr> 
      <tr class="danger">
      <td>05</td>
      <td>Hibernate</td>
      <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
      <input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr>
      <tr class="danger">
      <td>06</td>
      <td>Spring</td>
      <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
      <input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr>
     <tr class="info">
      <td>07</td>
      <td>C#</td>
      <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
      <input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr>
      <tr class="info">
      <td>08</td>
      <td>APO</td>
      <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
      <input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr>
      <tr class="info">
      <td>09</td>
      <td>ASP</td>
      <td><input class="btn btn-primary" type="button" name="edit" data-toggle="modal" data-target="#myEditModal" value="Edit">&nbsp;&nbsp;
      <input class="btn btn-danger" type="button" data-toggle="modal" data-target="#myDeleteModal" value="Delete"/></td>
      </tr>
    </tbody>
  </table>
</div>



<!-- This Modal For Add Record... -->
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Course Records</h4>
      </div>
      <div class="modal-body">
        

<div class="container">
		<form class="form-horizontal" role="form">
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="courseId">Course_Id:</label>
				<div class="col-sm-3">
					<input type="courseId" class="form-control" id="courseId"
						placeholder="Enter Course_Id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="courseName">Course Name:</label>
				<div class="col-sm-3">
					<input type="courseName" class="form-control" id="courseName"
						placeholder="Enter Course Name">
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



<!-- This Modal For Edit Record... -->
<!-- Modal -->
<div id="myEditModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Course Records</h4>
      </div>
      <div class="modal-body">
        

<div class="container">
		<form class="form-horizontal" role="form">
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="courseId">Course_Id:</label>
				<div class="col-sm-3">
					<input type="courseId" class="form-control" id="courseId">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="courseName">Course Name:</label>
				<div class="col-sm-3">
					<input type="courseName" class="form-control" id="courseName">
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



</body>
</html>
      