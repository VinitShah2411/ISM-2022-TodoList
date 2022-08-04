<%@page import="bean.AddTaskBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@page import="bean.AddTaskBean"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Task</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
	

<body>

<%
		ArrayList<AddTaskBean> tasks = (ArrayList<AddTaskBean>) request.getAttribute("tasks");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center">List Tasks</h2>

				<table class="display" id="task">
					<thead class="thead-light">
						<tr>
							<th>taskname</th>
							<th>description</th>
							<th>status</th>
							<th>priority</th>
							<th>Date</th>
							<th>Action</th>
							<th>Action</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<%
							for (AddTaskBean t : tasks) {
						%>
						<tr>
							<td><%=t.getTaskname()%></td>
							<td><%=t.getDescription()%></td>
							<td><%=t.getStatus()%></td>
							<td><%=t.getPriority()%></td>
							<td><%=t.getDate()%></td>							
							<td>
							<a href="TaskStatusController?taskId=<%=t.getTaskId()%>">Done</a>	
							</td>						
							<td>
							<a href="DeleteTaskController?taskId=<%=t.getTaskId()%>">Delete</a>
							</td>
							<td>
							<a href="UpdateTaskController?taskId=<%=t.getTaskId()%>">Edit</a>	
							</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
	 <a href="ToDoList.jsp" button type="submit" class="btn btn-primary ">Back To TODOLIST</a>
			</div>
		</div>
	</div>
	
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#task').DataTable();
		});
	</script>
   
    <div class="container-fluid">
  <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
</div>
</body>
</html>