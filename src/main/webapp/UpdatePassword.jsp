<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Password</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="https://cdn.lineicons.com/2.0/LineIcons.css" rel="stylesheet">
<style type="text/css">
html,body { height: 100%; }

body{
	display: -ms-flexbox;
	display: -webkit-box;
	display: flex;
	-ms-flex-align: center;
	-ms-flex-pack: center;
	-webkit-box-align: center;
	align-items: center;
	-webkit-box-pack: center;
	justify-content: center;
	background-color: #f5f5f5;
}

form{
	padding-top: 10px;
	font-size: 13px;
	margin-top: 30px;
}

.card-title{ font-weight:300; }

.btn{
	font-size: 13px;
}

.login-form{ 
	width:320px;
	margin:20px;
}

.sign-up{
	text-align:center;
	padding:20px 0 0;
}

span{
	font-size:14px;
}

.submit-btn{
	margin-top:20px;
}
</style>
</head>

<body>
<form action="UpdatePasswordController" method="post">
<div class="card login-form">
	<div class="card-body">
		<h3 class="card-title text-center">Change password</h3>
		
		<!--Password must contain one lowercase letter, one number, and be at least 5 characters long.-->
		
		<div class="card-text">
			<form>
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
 You should check in on some of those fields below.
  <a class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </a>
</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Your new password</label>
					<input type="password" class="form-control form-control-sm" name="password">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Repeat password</label>
					<input type="password" class="form-control form-control-sm" name="password">
				</div>
				<a href="Login.jsp">
				<button type="submit" class="btn btn-primary btn-block submit-btn">Confirm</button></a>
			</form>
		</div>
	</div>
</div>
</form>
</body>
</html>