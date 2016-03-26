<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>考试中心登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/font-awesome.min.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/ionicons.min.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/dist/css/AdminLTE.min.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/plugins/iCheck/square/blue.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/plugins/jQueryBootstrap/jquery.bootstrap.css"/>

    <script type="text/javascript" src="<%=request.getContextPath()%>/plugins/jQuery/jQuery-2.1.4.min.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/plugins/jQueryBootstrap/jquery.bootstrap.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/plugins/validation/jquery.validate.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/plugins/iCheck/icheck.min.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/script/public.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/script/login.js" ></script>

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>Admin</b>LTE</a>
    </div>
    <div class="login-box-body">
        <form class="form-vertical" action="#" id="loginForm">
            <h3 class="login-box-msg">帐号登录</h3>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="登录帐号" id="loginId" name="loginId">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="登录密码" id="pwd" name="pwd">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <label>
                        <a href="javascript:;" class="" id="forget-password">忘记密码</a>
                    </label>
                </div>
                <div class="col-xs-4">
                    <button type="button" class="btn btn-primary btn-block btn-flat" id="formSubmit">登录</button>
                </div>
            </div>
        </form>

        <form class="form-vertical" action="#" style="display: none" id="forgetForm">
            <h3 class="login-box-msg">忘记密码?</h3>
            <p>输入email邮箱重设密码</p>
            <div class="form-group has-feedback">
                <div class="controls">
                    <input type="email" class="form-control" placeholder="接收密码的email">
                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <button type="button" class="btn btn-primary btn-block btn-flat" id="back-btn">返回</button>
                </div>
                <div class="col-xs-6">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">确认</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- END LOGIN -->


</body>

</html>
