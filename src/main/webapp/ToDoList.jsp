<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">	

</head>
<body>
<section class="vh-100" style="background-color: #eee;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-lg-9 col-xl-7">
        <div class="card rounded-3">
          <div class="card-body p-4">

            <h4 class="text-center my-3 pb-3">To Do App</h4>

            <form class="row row-cols-lg-auto g-3 justify-content-center align-items-center mb-4 pb-2">

              <div class="col-12">
               <a href="AddTask.jsp" button type="submit" class="btn btn-primary form-control">Add Task</a>  <br> <br>
              </div>

              <div class="col-12">
                <a href="ListAllTaskController" button type="submit" class="btn btn-success form-control">Get All tasks</a> <br> <br>
              </div>
              
              <div class="col-12">
                <a href="LogoutController" button type="submit" class="btn btn-warning form-control">Logout</a> <br> <br>
              </div>
              
                 <div class="col-12">
                <a href="AccountDisableController" button type="submit" class="btn btn-danger form-control">Account Disable</a> 
              </div>
            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>