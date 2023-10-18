
<!--CORE 标签库-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>Bootstrap 101 Template</title>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  <!-- Bootstrap -->
  <link rel="stylesheet" href="./static/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
  <link rel="stylesheet" href="https://v3.bootcss.com/examples/dashboard/dashboard.css">
  <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
  <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
  <!--[if lt IE 9]>
  <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
  <![endif]-->
</head>
<style>
</style>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">主页</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
<%--        <li><a href="#">Dashboard</a></li>--%>
<%--        <li><a href="#">Settings</a></li>--%>
<%--        <li><a href="#">Profile</a></li>--%>
        <li><a href="#">欢迎${username}来到本站</a></li>
      </ul>
<%--      <form class="navbar-form navbar-right">--%>
<%--        <input type="text" class="form-control" placeholder="Search...">--%>
<%--      </form>--%>
    </div>
  </div>
</nav>
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li class="active"><a href="car" target="content">车辆管理 <span class="sr-only">(current)</span></a></li>

      </ul>
      
      <ul class="nav nav-sidebar">
        
         <li class="active"><a href="map/map.jsp" target="content">显示地图 <span class="sr-only">(current)</span></a></li>
         

      </ul>
      
      <ul class="nav nav-sidebar">

         
          <li class="active"><a href="precious/precious.jsp" target="content">宝藏图片 <span class="sr-only">(current)</span></a></li>

      </ul>

    </div>
    <div id="main_content" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="background-color: white">
      <iframe id="content" name="content" src="car" style="width: 100%; height: 100%; border: 0px ;"></iframe>
    </div>
  </div>
</div>

<script>

  $(document).ready(function() {
    // Add event listener for clicks on navigation items
    $(".nav-sidebar li").on("click", function() {
      // Remove the "active" class from all items
      $(".nav-sidebar li").removeClass("active");

      // Add the "active" class to the clicked item
      $(this).addClass("active");
    });
  });

</script>
</body>
</html>
