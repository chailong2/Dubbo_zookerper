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
    <title>修改个人信息</title>
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
                    <label for="info1" class="col-sm-2 control-label">员工工号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info1" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info2" class="col-sm-2 control-label">员工姓名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info2">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info3" class="col-sm-2 control-label">员工年龄</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info3">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info4" class="col-sm-2 control-label">员工性别</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="info4">
                            <option>男</option>
                            <option>女</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="info5" class="col-sm-2 control-label">学历背景</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info5">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info6" class="col-sm-2 control-label">员工职位</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="info6">
                            <option>部门负责人</option>
                            <option>员工</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="info7" class="col-sm-2 control-label">身份证号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info7">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info8" class="col-sm-2 control-label">员工地址</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info8">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info9" class="col-sm-2 control-label">联系电话</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="info9">
                    </div>
                </div>
                <button type="button" id="myButton1" data-loading-text="修改"
                        class="btn btn-primary"style="width: 300px;margin-left: 100px" onclick="fix()">
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
    $(function(){

       to_page();
    });
    function to_page(){
        var staffid='<%=session.getAttribute("staff")%>';
        $.ajax({
            url:"/self/selfinfo",
            data:"staffid="+staffid,
            type:"Post",
            dataType:"json",
            success:function(result){
                document.getElementById("info1").setAttribute("value",result.staffId);
                document.getElementById("info2").setAttribute("value",result.staffname);
                document.getElementById("info3").setAttribute("value",result.staffage);
                document.getElementById("info4").setAttribute("value",result.staffsex);
                document.getElementById("info5").setAttribute("value",result.educationBackground);
                document.getElementById("info6").setAttribute("value",result.duty);
                document.getElementById("info7").setAttribute("value",result.idcard);
                document.getElementById("info8").setAttribute("value",result.address);
                document.getElementById("info9").setAttribute("value",result.phonenumber);
            }
        });
    }
    function fix(){
        var arr=new Array(9);
        for (var i=1;i<=9;i++){
            var k="info"+i;
            var info=document.getElementById(""+k).value;
            arr[i-1]=info;
        }
        $.ajax({
            url: "/self/selfinfoupdate",
            type: "post",
            async: false,   //同步
            dataType: "json",
            data: {"staffId":arr[0],"staffname":arr[1],"staffage":arr[2],"staffsex":arr[3]
                ,"educationBackground":arr[4],"duty":arr[5],"idcard":arr[6],"address":arr[7]
                ,"phonenumber":arr[8]},
            success: function (result) {
                alert("修改成功")
                document.getElementById("info1").setAttribute("value",result.staffId);
                document.getElementById("info2").setAttribute("value",result.staffname);
                document.getElementById("info3").setAttribute("value",result.staffage);
                document.getElementById("info4").setAttribute("value",result.staffsex);
                document.getElementById("info5").setAttribute("value",result.educationBackground);
                document.getElementById("info6").setAttribute("value",result.duty);
                document.getElementById("info7").setAttribute("value",result.idcard);
                document.getElementById("info8").setAttribute("value",result.address);
                document.getElementById("info9").setAttribute("value",result.phonenumber);
            }
        })

    }
</script>
</body>