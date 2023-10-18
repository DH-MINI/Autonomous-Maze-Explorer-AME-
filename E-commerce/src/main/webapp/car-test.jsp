<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>小车探索宝藏数据</title>
    <!-- 导入Bootstrap的CSS样式 -->
    <link rel="stylesheet" href="./static/bootstrap.min.css">

    <!-- 自定义样式 -->
    <link rel="stylesheet" href="./static/custom.css">

    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!-- 头部导航栏 -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">小车探索宝藏数据</a>
        </div>
    </div>
</nav>

<!-- 主体内容 -->
<div class="container">

    <!-- 实验信息表单 -->
    <form class="form-horizontal" action="./cartestadd" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">实验时间</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" name="testDate">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">宝藏数量</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="treasureNum" placeholder="宝藏数量">
            </div>
        </div>
        <input type="hidden" name="carId" value="${carTestInfo.carId}">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </div>
    </form>

    <!-- 宝藏数据表格 -->
    <table class="table table-striped">
        <thead>
        <tr>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>持续时间</th>
            <th>宝藏类型</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${txtInfos}" var="txt">
            <tr>
                <td>${txt.startTime}</td>
                <td>${txt.endTime}</td>
                <td>${txt.duration}</td>
                <td>${txt.treasureType}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<!-- 底部版权信息 -->
<footer class="footer">
    <div class="container">
        <p class="text-muted">© 版权所有 2023 - 小车探索宝藏数据</p>
    </div>
</footer>

<!-- 加载jQuery和Bootstrap的JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
