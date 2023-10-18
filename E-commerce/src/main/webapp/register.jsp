<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register Now</title>
	<style>
		body {
			background-color: white;
			background-image: url("imgs/black.jpg");
			font-family: Humanist;
		}

		form {
			border: 2px solid black;
			width: 40%;
			margin: 0 auto;
			padding: 30px;
			background-color: rgba(199, 221, 239, 0.5);
			font-family: Humanist;
		}

		h2 {
			font-family: Humanist;
			font-size: 24px;
			color: #555;
			margin-bottom: 20px;
		}

		input[type="text"], input[type="password"] {
			padding: 10px;
			font-size: 18px;
			border-radius: 4px;
			border: none;
			display: block;
			margin-bottom: 20px;
			width: 100%;
			font-family: Humanist;
		}

		label {
			display: inline-block;
			width: 120px;
			font-size: 18px;
			margin-bottom: 10px;
			font-family: Humanist;
		}

		input[type="submit"] {
			background-color: #4285f4;
			border: none;
			color: white;
			padding: 12px 24px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			border-radius: 4px;
			cursor: pointer;
			transition: background-color 0.3s ease;
			font-family: Humanist;
		}

		input[type="submit"]:hover {
			font-family: Humanist;
			background-color: #357ae8;
		}

		a {
			font-family: Humanist;
			color: white;
			text-decoration: none;
			display: block;
			margin-top: 20px;
			font-size: 18px;
			text-align: center;
		}
	</style>
</head>
<body>
<form method="post" action="./register">
	<h2>Register Now</h2>
	<label for="username">Username:</label>
	<input type="text" name="username" id="username" required placeholder="Enter your username">
	<label for="password">Password:</label>
	<input type="password" name="password" id="password" required placeholder="Enter your password">
	<label for="email">Email:</label>
	<input type="text" name="email" id="email" required placeholder="Enter your email">
	<label for="name">Name:</label>
	<input type="text" name="name" id="name" required placeholder="Enter your name">
	<label for="tel">Tel:</label>
	<input type="text" name="tel" id="tel" required placeholder="Enter your phone number">

	<input type="submit" value="Register Now">
</form>
<a href="login.jsp">Do you already have an account?</a>?
</body>
</html>
