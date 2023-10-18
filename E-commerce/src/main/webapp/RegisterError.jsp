<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Humanist;
            background-color: white;
            background-image: url("imgs/maomao.jpg");
            background-size: cover;
        }

        div {
            font-family: Humanist;
            text-align: center;
            border: 2px solid black;
            background-color: #c7ddef;
            width: 40%;
            margin-left: 30%;
            margin-top: 20%;
            padding: 30px;
        }

        h2 {
            font-family: Humanist;
            font-size: 24px;
            color: #555;
            margin-bottom: 20px;
        }

        a {
            text-decoration: none;
            color: #4285f4;
            font-size: 18px;
        }
    </style>
</head>
<body>
<div>
    <h2>OH NO!</h2>
    Some errors have occurred<br/><br/>
    Or the username already exists. <br/><br/>
    You need to change it to continue registering. <br/><br/>
    <a href="register.jsp">Click here to return to the registration interface and register again</a><br/>
</div>
</body>
</html>
