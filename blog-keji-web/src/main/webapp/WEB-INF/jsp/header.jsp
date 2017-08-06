<%--
  Created by IntelliJ IDEA.
  User: wb-ny291824
  Date: 2017/8/1
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(function(){
        $.post("/content/showCategory",{},function(data){
            $(data.data).each(function(i,n){
                $("#menuID").append("<li class='scroll'><a href='"+n.category_url+"'>"+n.name+"</a></li>");
            });
        },"json");

    });
</script>

<header id="header">
    <nav id="main-menu" class="navbar navbar-default navbar-fixed-top" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><img src="../images/keji.jpg" alt="logo"></a>
            </div>

            <div class="collapse navbar-collapse navbar-right">
                <ul id="menuID" class="nav navbar-nav">
                    <li class="scroll active"><a href="#home">首页</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="scroll">
                        <form class="navbar-form navbar-right" role="search" style="padding-top: 20px">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="请输入关键字...">
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form>
                    </li>
                    <li class="scroll"><a href="#"></a></li>
                    <li class="scroll"><a class="btn big-login" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">登录</a></li>
                    <li class="scroll"><a class="btn big-register" data-toggle="modal" href="javascript:void(0)" onclick="openRegisterModal();">注册</a></li>
                </ul>
            </div>
        </div><!--/.container-->
    </nav><!--/nav-->
</header><!--/header-->

<%--登录注册页面--%>
<%@include file="login&register.jsp"%>