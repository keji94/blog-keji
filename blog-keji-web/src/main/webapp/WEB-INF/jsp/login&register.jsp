<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/6 0006
  Time: 上午 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="modal fade login" id="loginModal">
    <div class="modal-dialog login animated">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Login with</h4>
            </div>
            <div class="modal-body">
                <div class="box">
                    <div class="content">
                        <div class="social">
                            <a class="circle github" href="/auth/github">
                                <i class="fa fa-github fa-fw"></i>
                            </a>
                            <a id="google_login" class="circle google" href="/auth/google_oauth2">
                                <i class="fa fa-google-plus fa-fw"></i>
                            </a>
                            <a id="facebook_login" class="circle facebook" href="/auth/facebook">
                                <i class="fa fa-facebook fa-fw"></i>
                            </a>
                        </div>
                        <div class="division">
                            <div class="line l"></div>
                            <span>or</span>
                            <div class="line r"></div>
                        </div>
                        <div class="error"></div>
                        <div class="form loginBox">
                            <form method="post" id="loginFrom" action="/login" accept-charset="UTF-8">
                                <input id="emailLogin" class="form-control" type="text" placeholder="邮箱" name="emailname">
                                <input id="passwordLogin" class="form-control" type="password" placeholder="密码" name="password">
                                <input class="btn btn-default btn-login" type="button" value="登录" onclick="loginAjax()">
                            </form>
                        </div>
                    </div>
                </div>
                <div class="box">
                    <div class="content registerBox" style="display:none;">
                        <div class="form">
                            <form method="post" html="{:multipart=>true}" data-remote="true" action="/user/register" accept-charset="UTF-8">
                                <input id="email" class="form-control" type="text" placeholder="邮箱" name="userName" autofocus="autofocus">
                                <input id="password" class="form-control" type="password" placeholder="密码" name="userPassword">
                                <input id="password_confirmation" class="form-control" type="password" placeholder="确认密码" name="password_confirmation">
                                <input id="nickname" class="form-control" type="text" placeholder="昵称" name="userNickname">
                                <input class="btn btn-default btn-register" type="button" value="注册" name="commit" onclick="checkResigter()">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="forgot login-footer">
                            <span>没有账号？
                                 <a href="javascript: showRegisterForm();">点我注册</a>
                            </span>
                </div>
                <div class="forgot register-footer" style="display:none">
                    <span>已经拥有账号?</span>
                    <a href="javascript: showLoginForm();">登录</a>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
