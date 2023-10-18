<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--<meta charset="ISO-8859-1">--%>
<%--<title>hi~</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form method="post" action="./login"> --%>
<%--	username : <input type="text" name="username"/><br/>--%>
<%--	password : <input type="text" name="password"/><br/>--%>
<%--	<input type="SUBMIT" name="submit" value="Submit"> --%>
<%--</form>--%>
<%--<a href="register.jsp">I don't have an account, I need to register one!!!</a>--%>
<%--</body>--%>
<%--</html>--%>
<html lang="zh-CN"><head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="https://v3.bootcss.com/favicon.ico">
	<link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/signin/">

	<title>Signin Template for Bootstrap</title>

	<!-- Bootstrap core CSS -->
	<link href="https://v3.bootcss.com/dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<link href="https://v3.bootcss.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="https://v3.bootcss.com/examples/signin/signin.css" rel="stylesheet">

	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	<!--[if lt IE 9]><script src="https://v3.bootcss.com/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	<script src="https://v3.bootcss.com/assets/js/ie-emulation-modes-warning.js"></script>

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>

<style>
	body{
		background-image: url("imgs/maomao.jpg");
		background-color: white;
		background-position: center;
		background-size: cover;
		font-family: Humanist;
	}
	form{
		font-family: Humanist;
		border: black solid 2px;
		background-color: rgba(199, 221, 239, 0.5);
	}
	a{
		text-decoration: none;
	}
	button{
		background-color: white;
	}
</style>

<body>

<div class="container">
	<form class="form-signin" action="./login" method="post">
		<h2 class="form-signin-heading">Please sign in</h2>
		<label for="username" class="sr-only">Email address</label>
		<br>
		<input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
		<label for="inputPassword" class="sr-only">Password</label>
		<br>
		<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">
		<div class="checkbox">
			<label>
				<input type="checkbox" value="remember-me" style="color: black"> Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		<a href="./register.jsp">Create a account！</a>
	</form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="https://v3.bootcss.com/assets/js/ie10-viewport-bug-workaround.js"></script>


</body></html>
