<%--
  Created by IntelliJ IDEA.
  User: wb-ny291824
  Date: 2017/8/4
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
    $(function () {
        $.post("/backstage/listPic",{},function(data){
            $(data.rows).each(function(i,row){
                if(i === 0){
                    $("#picBox").append(
                        "<div class='item active'> <img src="+row.pictureResource+ "><div class='carousel-caption'></div> </div>");
                    $("#carousel-indicators").append(
                        "<li data-target='#carousel-example-generic' data-slide-to="+i+" class='active'></li>");

                }else {
                    $("#picBox").append(
                        "<div class='item'> <img src="+row.pictureResource+ "><div class='carousel-caption'></div> </div>");
                    $("#carousel-indicators").append(
                        "<li data-target='#carousel-example-generic' data-slide-to="+i+" ></li>");
                }
            });
        },"json");
    });

</script>
<div class="row" >
    <!-- 图片的小点儿 -->
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators" id="carousel-indicators">

        </ol>

        <!-- 图片-->
        <div class="carousel-inner" role="listbox" id="picBox">

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
