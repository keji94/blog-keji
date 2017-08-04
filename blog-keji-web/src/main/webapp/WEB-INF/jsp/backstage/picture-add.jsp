<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="pictureAddForm" class="itemForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>图片名称:</td>
                <td><input class="easyui-textbox" type="text" name="pictureName" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>图片路径:</td>
                <td><input class="easyui-textbox" type="text" name="pictureSource" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>排序数值:</td>
                <td><input class="easyui-textbox" type="text" name="pictureSortOrder"  style="width: 280px;"></input>
                </td>
            </tr>
            <tr>
                <td>文章ID:</td>
                <td><input class="easyui-textbox" type="text" name="articleId" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="pictureAddEditor.submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="pictureAddEditor.clearForm()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var pictureAddEditor  = {
        submitForm : function (){
            if(!$('#pictureAddForm').form('validate')){
                $.messager.alert('提示','表单还未填写完成!');
                return ;
            }

            $.post("/backstage/picSave",$("#pictureAddForm").serialize(), function(data){
                if(data.status == 200){
                    $.messager.alert('提示','新增内容成功!');
                    $("#pictureList").datagrid("reload");
                    TT.closeCurrentWindow();
                }else {
                    $.messager.alert('提示',data.data);
//                    TT.closeCurrentWindow();
                }
            });
        },
        clearForm : function(){
            $('#pictureAddForm').form('reset');
            pictureAddEditor.html('');
        }
    };
</script>
