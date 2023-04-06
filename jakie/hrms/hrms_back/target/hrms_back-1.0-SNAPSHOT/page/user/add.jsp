<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/public/css/font.css">
    <link rel="stylesheet" href="/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/public/js/xadmin.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
  <div style="width: 500px; margin-left: auto; margin-right: auto">
      <form id="info">
          <div class="form-group">
              <label for="info1">姓名</label>
              <input type="text" class="form-control" id="info1">
          </div>
          <div class="form-group">
              <label for="info2">账号</label>
              <input type="text" class="form-control" id="info2">
          </div>
          <div class="form-group">
              <label for="info3">密码</label>
              <input type="text" class="form-control" id="info3">
          </div>
          <button type="button" id="myStateButton" data-complete-text="finished!" class="btn btn-primary"
                  onclick="sumbit()">
              提交信息
          </button>
      </form>
  </div>
  </body>
<script>
    function sumbit(){
        for (var i=1;i<=3;i++){
            var k="info"+i;
            var info=document.getElementById(""+k).value;
            if(info==null||info=="")
            {
                alert("存在信息为空，请重新填写！");
                return;
            }
        }
        var arr=new Array(3);
        arr[0]=1;
        for (var i=1;i<=3;i++){
            var k="info"+i;
            var info=document.getElementById(""+k).value;
            arr[i-1]=info;
        }
        $.ajax({
            url: "/admin/addnewadmin",
            type: "post",
            async: false,   //同步
            dataType: "json",
            data: {"administername":arr[0],"account":arr[1],"password":arr[2]},
            success: function (result) {
                if(result=="true"){
                    alert("添加成功!")
                    for (var i=1;i<=3;i++) {
                        var k = "info" + i;
                        document.getElementById("" + k).value = "";
                     }
                }
                else {
                    alert("账号重复请重新输入!")
                }
            }
        })

    }
</script>
</html>