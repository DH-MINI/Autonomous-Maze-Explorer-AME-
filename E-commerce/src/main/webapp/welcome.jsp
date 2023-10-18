<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Humanist;
            background-color: white;
            background-image: url("imgs/maomao.jpg");
            background-size: cover;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 40px;
            text-align: center;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 48px;
            margin: 0 0 40px;
            color: #555;
        }

        p {
            font-size: 24px;
            margin: 0 0 20px;
            color: #666;
        }

        a {
            color: #fff;
            font-weight: bold;
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
    <h1>Welcome <%= session.getAttribute("username") %>!</h1>
    <p>Do you want to <a href="#">insert or query data</a>?</p>
</div>
</body>
</html>
