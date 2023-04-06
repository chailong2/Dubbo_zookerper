<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>后台登录-人力资源管理系统</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/public/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/public/css/font.css">
	<link rel="stylesheet" href="/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/public/js/xadmin.js"></script>
</head>
<body class="login-bg">
    <div class="login layui-anim layui-anim-up">
        <div class="message" style="background: #761c19">人力资源管理系统-登录</div>
        <div id="darkbannerwrap"></div>
        <form method="post" class="layui-form">
            <input name="account" placeholder="用户名"   type="text" lay-verify="required" class="layui-input" id="account" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input" id="password">
            <hr class="hr15">
            <br>
            <input value="登录" lay-submit lay-filter="login" style="width:100%;background: #761c19" type="button" onclick="Administrator()">
            <hr class="hr20" >
        </form>
    </div>
</body>
<script>
    function Administrator(){
        var account=document.getElementById("account").value;
        var password=document.getElementById("password").value;
        $.ajax({
            url: "/gologin/adminlogin",
            type: "post",
            async: false,   //同步
            dataType: "json",
            data: {"account":account,"password":password},
            success: function (result) {
                if(result=="false") {
                    alert("账号或密码错误请重新输入");
                    document.getElementById("account").value="";
                    document.getElementById("password").value="";
                }
                else
                    window.location.href='http://localhost:8087/mainpage.jsp';

            }
        })
    }
</script>
</html>