<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
        <title>注册页面</title>
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
    <div class="app" id="app" style="background: #f2f2f2;height: 800px">
        <!-- 页面头部 -->
        <div class="top-header">
            <span class="f-left"><i class="icon-back" onclick="history.go(-1)"></i></span>
            <span class="center">人力资源管理系统</span>
            <span class="f-right"><i class="icon-more"></i></span>
        </div>
        <!-- 页面内容 -->
        <div class="contentBox" style="background: #f2f2f2;margin-top: 100px">
            <div class="login" style="margin-left: auto;margin-right: auto;width: 300px" style="background: #f2f2f2">
                <form id="info" style="background: #f2f2f2">
                    <div class="form-group">
                        <label for="info1">账户</label>
                        <input type="text" class="form-control" id="info1" placeholder="账号" required="required">
                    </div>
                    <div class="form-group">
                        <label for="info2">密码</label>
                        <input type="password" class="form-control" id="info2" placeholder="密码">
                    </div>
                    <div class="form-group">
                        <label for="info3">注册类型</label>
                        <select class="form-control" id="info3" name="songhuo">
                            <option>游客</option>
                            <option>内部员工</option>
                        </select>
                    </div>
                    <div class="form-group" id="info6" style="display: none">
                        <label for="info4">员工工号</label>
                        <input type="text" class="form-control" id="info4" placeholder="请输入员工工号">
                    </div>
                    <button type="button" id="myButton1" data-loading-text="注册"
                            class="btn btn-primary"style="width: 300px" onclick="login()">
                        注册
                    </button>
                </form>
            </div>
        </div>
    </div>
    </body>
    <script>
        $("select[name='songhuo']").change(function (){
            var bb=document.getElementById("info3").value;
            if(bb=="内部员工")
            {
                document.getElementById("info6").setAttribute("style","display: block");
            }
            else{
                document.getElementById("info6").setAttribute("style","display: none");
            }
        });

        function login(){
              var info1=document.getElementById("info1").value;
              var info2=document.getElementById("info2").value;
              if(info1==""||info2=="")
              {
                  alert("信息输入不能为空！")
                  return ;
              }
              var info3=document.getElementById("info3").value;
              if(info3=="游客")
              {
                  $.ajax({
                      url:"/register/touristregister",
                      data:{"account":info1,"password":info2},
                      type:"post",
                      dataType:"json",
                      success:function(result){
                          if(result=="success")
                          {
                              $("#info").empty();
                              var infochange="<button type=\"button\" id=\"myButton1\" data-loading-text=\"注册\"\n" +
                                  "                            class=\"btn btn-primary\"style=\"width: 300px\" onclick=\"login2()\">\n" +
                                  "                        前去登陆\n" +
                                  "                    </button>";
                              $
                              $("#info").append(infochange);
                          }
                          else {
                              alert(result);
                          }
                      }
                  });
              }
              else{
                  var info4=document.getElementById("info4").value;
                  if(info4=="")
                  {
                      alert("信息不能为空");
                      return ;
                  }
                  $.ajax({
                      url:"/register/staffregister",
                      data:{"account":info1,"password":info2,"staffid":info4},
                      type:"post",
                      dataType:"json",
                      success:function(result){
                          if(result=="success")
                          {
                              $("#info").empty();
                              var infochange="<button type=\"button\" id=\"myButton1\" data-loading-text=\"注册\"\n" +
                                  "                            class=\"btn btn-primary\"style=\"width: 300px\" onclick=\"login2()\">\n" +
                                  "                        前去登陆\n" +
                                  "                    </button>";
                              $
                              $("#info").append(infochange);
                          }
                          else {
                              alert(result);
                          }
                      }
                  });

            }
        }
        function login2()
        {
            window.location.href='http://localhost:8085/pages/index.jsp';
        }
    </script>
</html>