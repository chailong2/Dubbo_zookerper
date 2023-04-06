<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,user-scalable=no,minimal-ui">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/asset-favico.ico">
    <title>申请结果</title>
    <link rel="stylesheet" href="../css/page-health-login.css" />
    <link rel="stylesheet" href="../plugins/elementui/index.css" />
    <script src="../plugins/healthmobile.js"></script>
    <script src="../plugins/vue/vue.js"></script>
    <script src="../plugins/vue/axios-0.18.0.js"></script>
    <script src="../plugins/elementui/index.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body data-spy="scroll" data-target="#myNavbar" data-offset="150">
<div class="app" id="app" style="background: #f2f2f2">
    <!-- 页面头部 -->
    <div class="top-header">
        <span class="f-left"><i class="icon-back" onclick="history.go(-1)"></i></span>
        <span class="center">申请结果查询</span>
        <span class="f-right"><i class="icon-more"></i></span>
    </div>
    <!-- 页面内容 -->
    <div class="contentBox" style="background: #f2f2f2">

        <div style="background: #f2f2f2;margin-left: auto;margin-right: auto;width: 500px;margin-top: 100px">
            <table class="table table-striped">
                <tr><td id="info1"></td></tr>
                <tr><td id="info2"></td></tr>
                <tr><td id="info3"></td></tr>
                <tr><td id="info4"></td></tr>
                <tr><td id="info5"></td></tr>
                <tr><td id="info7"></td></tr>
                <tr><td id="info8"></td></tr>
                <tr><td id="info9"></td></tr>
                <tr><td id="info11"></td></tr>
            </table>
        </div>
    </div>
    <div class="top-header" style="margin-top: 305px">
        <span class="center">华信科技公司</span>
    </div>
</div>
<!-- 页面 css js -->
<script src="../plugins/vue/vue.js"></script>
<script src="../plugins/vue/axios-0.18.0.js"></script>
<!--<script src="../js/page-health-order.js"></script>-->
<script>
    $(function(){

       to_page();
    });
    function to_page(){
        var account='<%=session.getAttribute("tou")%>';
        $.ajax({
            url:"/tourist/applyconse",
            data:"account="+account,
            type:"Post",
            dataType:"json",
            success:function(result){
                var info1="申请人账号："+result.account;
                $("#info1").append(info1);
                var info2="申请人姓名："+result.applyname;
                $("#info2").append(info2);
                var info3="申请人性别："+result.applysex;
                $("#info3").append(info3);
                var info4="申请人年龄："+result.applyage;
                $("#info4").append(info4);
                var info5="申请人学历背景："+result.applyeducation;
                $("#info5").append(info5);
                var info7="身份证号："+result.applyidcard;
                $("#info7").append(info7);
                var info8="个人地址："+result.applyaddress;
                $("#info8").append(info8);
                var info9="联系电话："+result.applyphonenumber;
                $("#info9").append(info9);
                var info11="申请结果："+result.applystatue;
                $("#info11").append(info11);
            }
        });
    }
</script>
</body>