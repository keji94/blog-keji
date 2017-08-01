<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- 根据设备宽度，调整缩放比例 -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>博客首页</title>
        <!-- 引入BootStrap的CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css" />
        <link rel="stylesheet" href="../css/bootstrap-theme.min.css" />
        <!-- 引入JS-->
        <script type="text/javascript" src="../js/jquery-1.11.3.min.js" ></script>
        <script type="text/javascript" src="../js/bootstrap.min.js" ></script>
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
            <div class="row">
                <!-- 图片的小点儿 -->
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    </ol>

                    <!-- 图片-->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="../images/001.jpg" >
                            <div class="carousel-caption">

                            </div>
                        </div>
                        <div class="item">
                            <img src="../images/002.jpg">
                            <div class="carousel-caption">

                            </div>
                        </div>
                        <div class="item">
                            <img src="../images/003.jpg">
                            <div class="carousel-caption">
                            </div>
                        </div>
                        <div class="item">
                            <img src="../images/004.jpg">
                            <div class="carousel-caption">
                            </div>
                        </div>
                    </div>

                    <!-- 图片左右选择 -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>

        </div>



    </body>

</html>
