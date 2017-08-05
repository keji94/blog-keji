<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- 根据设备宽度，调整缩放比例 -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="favicon.ico">
        <title>博客首页</title>
        <!-- 引入BootStrap的CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css" />
        <link rel="stylesheet" href="../css/bootstrap-theme.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!-- Custom styles for this template -->
        <link href="../css/jquery.bxslider.css" rel="stylesheet">
        <link href="../css/style.css" rel="stylesheet">

        <!-- 引入JS-->
        <script type="text/javascript" src="../js/jquery-1.11.3.min.js" ></script>
        <script type="text/javascript" src="../js/bootstrap.min.js" ></script>
        <script src="../js/jquery.bxslider.js"></script>
        <script src="../js/mooz.scripts.min.js"></script>


    </head>

    <body>
        <!--整体div-->
        <div class="container">
            <!--Logon部分DIV-->
            <div class="row">
                <div class="col-md-4" style="margin-left: -16px">
                    <img src="../images/keji.jpg" class="img-responsive" >
                </div>
                <div class="col-md-8" style="text-align: right">
                    <div style="margin-top: 10px">
                        <a href="">登录</a>
                        <a href="">注册</a>
                    </div>
                </div>
            </div>

            <!--导航条部分DIV-->
            <%@include file="menu.jsp"%>
            <!--图片轮播部分DIV-->
            <%@include file="picShow.jsp"%>
            <!--最新博客-->
            <%@include file="blog.jsp"%>

        </div>


    </body>

</html>
