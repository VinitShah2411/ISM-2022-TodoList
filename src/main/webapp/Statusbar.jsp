<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#status {
	height: 50px;
}
</style>
</head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<body>
	<div class="content-body">
		<div class="container-fluid">

			<div class="row">
				<h2>Prority Graph</h2>
				<canvas id="myChart" style="width: 100%; max-width: 600px"></canvas>
			</div>


			<!-- row -->
			<div class="row">
				<h2>Status Bar</h2>
				<div class="progress" id="status">

					<div class="progress-bar progress-bar-success" role="progressbar"
						style="width: ${pending}%"><h3>Pending Task</h3></div>
					<div class="progress-bar progress-bar-danger" role="progressbar"
						style="width: ${done}%; "><h3> Done Task</h3></div>

				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Pending Tasks</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="example" class="display" style="min-width: 845px">
									<thead>
										<tr>
											<!-- <th>Task Id</th> -->
											<th>Task Name</th>
											<th>Task Description</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="it" items="${task }">
											<c:if test="${it.status =='pending'}">
												<tr>
													<%-- <td>${it.taskid }</td> --%>
													<td>${it.taskName}</td>
													<td>${it.taskDescription }</td>
													<td>${it.status}</td>
													<td>${it.prority}</td>
													<td>${it.startDate}</td>
													<td>${it.endDate}</td>
													<td><a href="TaskDoneController?taskId=${it.taskid }"
														class="badge badge-success"> Done </a> <a
														href="DeleteTaskController?taskId=${it.taskid }"
														class="badge badge-danger"> delete </a> <a
														href="UpdateTaskController?taskId=${it.taskid }"
														class="badge badge-rounded badge-primary">Update</a></td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<!-- <th>Task Id</th> -->
											<th>Task Name</th>
											<th>Task Description</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th>Action</th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>



			<!-- row -->


			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Done tasks</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="example4" class="display" style="min-width: 845px">
									<thead>
										<tr>
											<th>Task Id</th>
											<th>Task Name</th>
											<th>Task Description</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Start Date</th>
											<th>End Date</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach var="it" items="${task }">
											<c:if test="${it.status == 'done'}">
												<tr>
													<td>${it.taskid }</td>
													<td>${it.taskName}</td>
													<td>${it.taskDescription }</td>
													<td>${it.status}</td>
													<td>${it.prority}</td>
													<td>${it.startDate}</td>
													<td>${it.endDate}</td>

												</tr>
											</c:if>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th>Task Id</th>
											<th>Task Name</th>
											<th>Task Description</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Start Date</th>
											<th>End Date</th>

										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script>
var xValues = ["High", "Medium", "Low"];
var yValues = [${HP}, ${MP}, ${LP}];
var barColors = [
  "#b91d47",
  "#00aba9",
  "#2b5797",
  "#e8c3b9",
  "#1e7145"
];

new Chart("myChart", {
  type: "pie",
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColors,
      data: yValues
    }]
  },
  options: {
    title: {
      display: true,
      text: "World Wide Wine Production 2018"
    }
  }
});
</script>
</body>
</html>