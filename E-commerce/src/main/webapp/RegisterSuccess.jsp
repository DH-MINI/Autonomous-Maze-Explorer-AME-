<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration successful!</title>
    <style>
        body {
            font-family: Humanist;
            background-color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url("imgs/login.jpg");
            background-size: cover;
        }

        .container {
            text-align: center;
            border: 2px solid black;
            background-color: #c7ddef;
            width: 40%;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
        }

        h2 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #555;
        }

        p {
            font-size: 18px;
            margin-bottom: 20px;
            color: #666;
        }

        a {
            color: #fff;
            text-decoration: none;
            background-color: #4285f4;
            padding: 12px 24px;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #357ae8;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Congratulations!</h2>
    <p>You have successfully registered.</p>
    <a href="login.jsp">Click here to return to the login screen</a>
</div>
</body>
</html>
