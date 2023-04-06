<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,user-scalable=no,minimal-ui">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/asset-favico.ico">
    <title>申请职位</title>
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
        <span class="center">修改个人信息</span>
        <span class="f-right"><i class="icon-more"></i></span>
    </div>
    <!-- 页面内容 -->
    <div class="contentBox" style="background: #f2f2f2">

        <div style="background: #f2f2f2;margin-left: auto;margin-right: auto;width: 500px;margin-top: 100px">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="info1" class="col-sm-2 control-label">申请账号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info1" readonly="readonly" value="<%=session.getAttribute("tou")%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info2" class="col-sm-2 control-label">申请姓名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info2">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info3" class="col-sm-2 control-label">申请性别</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="info3">
                            <option>男</option>
                            <option>女</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="info4" class="col-sm-2 control-label">申请年龄</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info4">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info5" class="col-sm-2 control-label">学历背景</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info5">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info6" class="col-sm-2 control-label">身份证号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info6">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info7" class="col-sm-2 control-label">个人地址</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info7">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info8" class="col-sm-2 control-label">联系电话</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info8">
                    </div>
                </div>
                <button type="button" id="myButton1" data-loading-text="修改"
                        class="btn btn-primary"style="width: 300px;margin-left: 100px" onclick="applyinfo()">
                        提交
                </button>
            </form>
        </div>
    </div>
    <div class="top-header" style="margin-top: 100px">
        <span class="center">华信科技公司</span>
    </div>
</div>
<!-- 页面 css js -->
<script src="../plugins/vue/vue.js"></script>
<script src="../plugins/vue/axios-0.18.0.js"></script>
<!--<script src="../js/page-health-order.js"></script>-->
<script>
    function applyinfo(){
        var arr=new Array(8);
        for (var i=1;i<9;i++){
            var k="info"+i;
            var info=document.getElementById(""+k).value;
            arr[i-1]=info;
        }
        $.ajax({
            url: "/tourist/applyinfo",
            type: "post",
            async: false,   //同步
            dataType: "json",
            data: {"account":arr[0],"applyname":arr[1],"applysex":arr[2],"applyage":arr[3]
                ,"applyeducation":arr[4],"applyidcard":arr[5],"applyaddress":arr[6]
                ,"applyphonenumber":arr[7],"applystatue":"待审核"},
            success: function (result) {
                alert(result);
            }
        })
    }
</script>
</body>