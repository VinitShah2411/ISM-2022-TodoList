<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
legend {
	background-color: powderblue;
	text-align: center;
}
</style>
</head>
<body>
<form method="post" action="AddTaskController" class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Task</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">Task Name</label>  
  <div class="col-md-4">
  <input type="text" name="taskname" placeholder="Task NAME" class="form-control input-md" >
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Task description</label>  
  <div class="col-md-4">
  <input type="text" name="description" placeholder="Task Description" class="form-control input-md" >
  </div>
</div>
    
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" >Task Priority</label>  
  <div class="col-md-4" >
  <select class="form-control input-md" name="priority">
  <option>Low</option>
  <option>Medium</option>
  <option>High</option>
  </select>
<!--   <input type="select" name="priority" class="form-control input-md"> -->
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">Status</label>  
  <div class="col-md-4">
   <select class="form-control input-md" name="status">
  <option>Pending</option>
  <!-- <option>Done</option> -->
  </select>
  <!-- <input type="text" name="price" placeholder="Price" class="form-control input-md"> -->
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label">Date</label>  
  <div class="col-md-4">
  <input type="date" name="date" placeholder="PRODUCT ID" class="form-control input-md">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-primary">Submit</button>
    ${msg}

    <a href="ToDoList.jsp" button type="submit" class="btn btn-primary ">Back To TODOLIST</a>
  <!--   <a href="Logout.jsp" button type="submit" class="btn btn-danger form-control">Logout</a>
     -->
  </div>
  </div>
</fieldset>
</form>
</body>
</html>   
 