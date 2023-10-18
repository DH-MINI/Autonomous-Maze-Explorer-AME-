<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录失败</title>
    <style>
        body {
            font-family: Humanist;
            background-color: white;
            background-image: url("imgs/maomao.jpg");
            background-size: cover;
        }
        .error {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .error-box {
            text-align: center;
            border: 2px solid black;
            background-color: #c7ddef;
            width: 40%;
            padding: 20px;
        }
        .link {
            display: inline-block;
            margin-top: 20px;
        }
        .link a {
            color: #333;
            text-decoration: none;
        }
        .link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="error">
    <div class="error-box">
        <p>您输入的用户名或密码有误，请重新输入！</p>
        <div class="link">
            <a href="login.jsp">返回登录页面</a>
        </div>
    </div>
</div>
</body>
</html>
