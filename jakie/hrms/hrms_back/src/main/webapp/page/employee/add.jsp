<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>添加员工</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/public/css/font.css">
    <link rel="stylesheet" href="/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/public/js/xadmin.js"></script>
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
              <label for="info2">姓名</label>
              <input type="text" class="form-control" id="info2" placeholder="姓名">
          </div>
          <div class="form-group">
              <label for="info3">年龄</label>
              <input type="text" class="form-control" id="info3" placeholder="年龄">
          </div>
          <div class="form-group">
              <label for="info4">性别</label>
              <select class="form-control" id="info4">
                  <option>男</option>
                  <option>女</option>
              </select>
          </div>
          <div class="form-group">
              <label for="info5">学历</label>
              <input type="text" class="form-control" id="info5" placeholder="学历">
          </div>
          <div class="form-group">
              <label for="info6">身份证号</label>
              <input type="text" class="form-control" id="info6" placeholder="身份证号">
          </div>
          <div class="form-group">
              <label for="info7">地址</label>
              <input type="text" class="form-control" id="info7" placeholder="地址">
          </div>
          <div class="form-group">
              <label for="info8">联系电话</label>
              <input type="text" class="form-control" id="info8" placeholder="联系电话">
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
        for (var i=2;i<=8;i++){
            var k="info"+i;
            var info=document.getElementById(""+k).value;
            if(info==null||info=="")
            {
                alert("存在信息为空，请重新填写！");
                return;
            }
        }
        var arr=new Array(9);
        arr[0]=1;
        for (var i=2;i<=8;i++){
            var k="info"+i;
            var info=document.getElementById(""+k).value;
            arr[i-1]=info;
        }
        $.ajax({
            url: "/employee/addnewstaff",
            type: "post",
            async: false,   //同步
            dataType: "json",
            data: {"staffname":arr[1],"staffage":arr[2],"staffsex":arr[3]
                ,"educationBackground":arr[4],"idcard":arr[5],"address":arr[6]
                ,"phonenumber":arr[7]},
            success: function () {
                alert("添加成功")
                for (var i=2;i<=8;i++){
                    var k="info"+i;
                    document.getElementById(""+k).value="";
                }
            }
        })

    }
</script>
</html>