<%@page import="bean.AddTaskBean"%>
<%@page import="java.util.ArrayList" isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Task</title>
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
	<%AddTaskBean task = (AddTaskBean)request.getAttribute("task");	%>

<form method="post" action="UpdateTaskFromController" class="form-horizontal">
<input type="text" hidden="" value="${task.taskId }" name="taskid">
<fieldset>

<!-- Form Name -->
<legend>Edit Task</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">Edit Task Name</label>  
  <div class="col-md-4">
  <input type="text" name="taskname" placeholder="Task NAME" class="form-control input-md" value="${task.taskname}">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Edit Task description</label>  
  <div class="col-md-4">
  <input type="text" name="description" placeholder="Task Description" class="form-control input-md" value="${task.description}" >
  </div>
</div>
    
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" >Edit Task Priority</label>  
  <div class="col-md-4" >
  <select class="form-control input-md" name="priority" value="${task.priority}">
  <option>Low</option>
  <option>Medium</option>
  <option>High</option>
  </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">Edit Status</label>  
  <div class="col-md-4">
   <select class="form-control input-md" name="status" value="${task.status}">
  <option>Pending</option>
  <option>Done</option>
  </select>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label">Edit Date</label>  
  <div class="col-md-4">
  <input type="date" name="date" class="form-control input-md" value="${task.date}">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-primary">Submit</button>
    ${msg}

    <a href="ToDoList.jsp" button type="submit" class="btn btn-primary ">Back To TODOLIST</a>
  </div>
  </div>
</fieldset>
</form>
</body>
</html>
