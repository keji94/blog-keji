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
        <link rel="stylesheet" href="../css/font-awesome.min.css">
        <!-- Custom styles for this template -->
        <link href="../css/jquery.bxslider.css" rel="stylesheet">
        <link href="../css/style.css" rel="stylesheet">
        <link href="../css/login-register.css" rel="stylesheet" />
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/animate.min.css" rel="stylesheet">
        <link href="../css/owl.carousel.css" rel="stylesheet">
        <link href="../css/owl.transitions.css" rel="stylesheet">
        <link href="../css/prettyPhoto.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <link href="../css/styles.css" rel="stylesheet">
        <link href="../css/bootoast.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/templatemo-style.css">

        <!-- 引入JS-->
        <script type="text/javascript" src="../js/jquery-1.11.3.min.js" ></script>
        <script type="text/javascript" src="../js/bootstrap.min.js" ></script>
        <script src="../js/jquery.bxslider.js"></script>
        <script src="../js/mooz.scripts.min.js"></script>
        <script src="../js/login-register.js" type="text/javascript"></script>
        <script src="../js/bootoast.js" type="text/javascript"></script>


    </head>

    <body>

        <!--header部分DIV-->
        <%@include file="header.jsp"%>
        <!--整体div-->
        <div class="container">
            <!--图片轮播部分DIV-->
            <%@include file="picShow.jsp"%>
            <!--最新博客-->
            <%@include file="blog.jsp"%>

        </div>

    </body>

</html>
