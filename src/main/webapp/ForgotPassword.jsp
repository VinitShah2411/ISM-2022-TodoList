<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="https://cdn.lineicons.com/2.0/LineIcons.css" rel="stylesheet">
<style type="text/css">
html, body.auth_class {
  background: #f9f4ff;
}
.login-container {
  margin-top: 10%;
  border: 0px solid #CCD1D1;
  border-radius: 12px;
  box-shadow: 0 0px 28px 0 rgb(0 0 0 / 8%);
  max-width: 50%;
  background: #FFF;
  z-index: 1;
  position: relative;
}
img.triangleA {
  position: absolute;
  margin-left: -16px;
  width: 60px;
  border-radius: 12px 0px 0px 0px;
}
img.triangleB {
  position: absolute;
  right: 0px;
  bottom: 0px;
  width: 360px;
  z-index: 0;
}
.welcome_auth {
  align-items: center;
  display: flex;
  justify-content: center;
}
.auth_welcome a {
  font-weight: 400;
}
.auth_welcome {
  font-weight: 100;
  font-size: 1.5em;
  background: -webkit-linear-gradient( 45deg, #07dd97, #beffe7);
  background-size: 100%;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-color: black;
  max-width: 170px;
}
a.auth_branding_in img {
  width: 60px;
  height: 60px;
  border-radius: 1000px;
}

.login-form {
  background: #fbfbfb;
  border-radius: 0px 12px 12px 0px;
  align-items: center;
  display: flex;
  justify-content: center;
}
.login_form_in {
  padding: 4em 1em;
}
.login-form h1 {
  font-size: 1.2em;
  max-width: 600px;
  margin: 0 auto;
  color: #969696;
  line-height: 1.5em;
  padding: 1.2em 0px .8em;
}
.lni {
  display: inline-block;
  font: normal normal normal 1em/1 'LineIcons';
  speak: none;
  text-transform: none;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.google_signup {
  margin-top: .8em;
}
.google_signup a {
  background: #DB4437;
  color: #FFF;
  display: block;
  text-align: center;
  padding: 12px 4px;
  border-radius: 5px;
}
.btn-primary {
  color: #fff;
  background-color: #5d00ff;
  border-color: #5d00ff;
}
.btn-primary:hover {
  color: #fff;
  background-color: #2900b7;
  border-color: #2900b7;
}
.google_signup a {
  background: #DB4437;
  color: #FFF;
  display: block;
  text-align: center;
  padding: 12px 4px;
  border-radius: 5px;
}
.google_signup a:hover {
  background: #d81505;
  color: #FFF;
}
.other_auth_links a:nth-child(2) {
  float: right;
}
a {
  text-decoration: none;
  color: #afafaf;
}
a:hover {
  text-decoration: none;
  color: #616161;
}    
.alert-success {
  background-color: rgb(190 255 231 / 33%);
  color: #07dd97;
  font-size: .9em;
} 
</style>
</head>
<body>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous">
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous">
        </script>
    </head>


    <body class="auth_class">
	<form  action="ForgotPasswordController" method="post">
        <div class="container login-container">
            <img class="triangleA" src="https://res.cloudinary.com/procraftstudio/image/upload/v1613965232/triangleA_lwqhnl.png" alt='Onestop triangle'>
          <div class="row">
            <div class="col-md-6 welcome_auth">
                <div class="auth_welcome">
                    Please Enter Answer To Reset Your Password <span><!-- <a href="UpdatePassword.jsp"></a></span -->>
                </div>
            </div>         
            <div class="col-md-6 login-form">
                <div class="login_form_in">
                  
                  <h1 class="auth_title text-left">Password Reset</h1>
                  <!-- <form> -->
                     <div class="alert alert-success bg-soft-primary border-0" role="alert">
                        Enter your Registered Email
                    </div>                    
                    <div class="form-group">
                      <input type="text" class="form-control" name="email" placeholder="Email">
                    </div>
                    <div class="alert alert-success bg-soft-primary border-0" role="alert">
                        Enter your Registered Mobile Number 
                    </div>                    
                    <div class="form-group">
                      <input type="text" class="form-control" name="mnumber" placeholder="Mobile Number">
                      
                    </div>
                    <div class="form-group">
                      <a href="UpdatePassword.jsp">
                      <button value="RESET" type="submit"class="btn btn-primary btn-lg btn-block" >Submit</button></a>
                    </div>
                    <center><span class="text-danger">${errorMsg}</span></center>
                    <div class="form-group other_auth_links">
                        <a href="Login.jsp">Login</a>
                        <a href="Signup.jsp">Register</a>
                    </div>
                </div>
            </div>       
          </div>
        </div>
        <img class="triangleB" src="https://res.cloudinary.com/procraftstudio/image/upload/v1613965232/triangleB_isffjy.png" alt='Onestop triangle'>
    </form>
    </body>
</html>

