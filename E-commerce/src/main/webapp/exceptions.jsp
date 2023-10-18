
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    div{
        text-align: center;
        border: black 2px solid;
        background-color: white;
        width: 40%;
        margin-left: 30%;
        background-image: url("imgs/maomao.jpg");
        background-size: cover;
    }
    body{
        font-family: Humanist;
        background-color: white;
    }
</style>
<body>
<div>
<h5>错误：</h5>
<p>${msg==null?"请先登录！":msg}</p>
</div>
</body>
</html>
