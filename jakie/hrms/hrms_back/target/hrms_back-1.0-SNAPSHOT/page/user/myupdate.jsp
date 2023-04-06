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
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
  <div style="width: 500px;margin-left: auto;margin-right: auto">
      <form id="info">
          <div class="form-group">
              <label for="info1">姓名</label>
              <input type="text" class="form-control" id="info1"  value="<%=session.getAttribute("adminname")%>">
          </div>
          <div class="form-group">
              <label for="info2">账号</label>
              <input type="text" class="form-control" id="info2" value="<%=session.getAttribute("adminacount")%>" readonly="readonly">
          </div>
          <div class="form-group">
              <label for="info3">密码</label>
              <input type="text" class="form-control" id="info3" value="<%=session.getAttribute("adminpassword")%>">
          </div>
          <button type="button" id="myStateButton" data-complete-text="finished!" class="btn btn-primary"
                  onclick="sumbit()">
              提交信息
          </button>
      </form>
  </div>
    <script>
        function sumbit(){
            var administername=document.getElementById("info1").value;
            var account=document.getElementById("info2").value;
            var password=document.getElementById("info3").value;
            $.ajax({
                url: "/gologin/adminupdate",
                type: "post",
                async: false,   //同步
                dataType: "json",
                data: {"administername":administername,"account":account,"password":password},
                success: function (result) {
                    alert("修改成功！")
                }
            })
        }

    </script>
    
  </body>

</html>