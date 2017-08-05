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

                $("#menuID").append("<li><a href='"+n.category_url+"'>"+n.name+"</a></li>");
            });
        },"json");
    });
</script>

<div class="row" style="padding-top: 5px">
    <nav class="navbar navbar-default" >
        <div class="container-fluid" >
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header" >
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#" style="color: #0f0f0f">首页</a>
            </div>

            <!-- Collect the nav links, forms, and otbackstagetent for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="menuID" class="nav navbar-nav" style="color: #0f0f0f">

                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="请输入关键字...">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>

            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>