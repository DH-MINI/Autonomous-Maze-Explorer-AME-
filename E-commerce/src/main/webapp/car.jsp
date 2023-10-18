
<!--CORE 标签库-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="./static/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <script src="https://www.runoob.com/try/bootstrap/twitter-bootstrap-v2/docs/assets/js/jquery.js"></script>
    <script src="https://www.runoob.com/try/bootstrap/twitter-bootstrap-v2/js/bootstrap-modal.js"></script>
</head>
<style>
    body{
        font-family: Humanist;
        background-color: white;
        background-image: url("imgs/white.jpg");
        background-position: center;
		background-size: cover;
    }
</style>
<body>
<div class="container">

    <form class="form-inline" action="./caradd" method="post">
        <div class="form-group">
            <label for="exampleInputName2">小车名称：</label>
            <input type="text" class="form-control" id="exampleInputName2" name="carName" placeholder="小车名称">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">小车图片</label>
            <input type="text" class="form-control" id="exampleInputEmail2" name="carImg" placeholder="图片地址链接">
        </div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>

<h2 class="sub-header">小车信息列表</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>小车名称</th>
            <th>小车图片</th>
            <th>实验数据</th>
<%--            <th>操作</th>--%>
        </tr>
        </thead>
       
        <tbody>
        <c:forEach items="${carInfoList}" var="car">
        <tr>
            <td>${car.carId}</td>
            <td>${car.carName}</td>
            <td><img src="${car.carImg}" height="50px" width="50px"></td>
            <td><a  href="./cartxt?carId=${car.carId}" class="btn btn-primary">查看数据</a> </td>
<%--            <td><button class="btn btn-danger">删除</button></td>--%>
        </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</div>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>
