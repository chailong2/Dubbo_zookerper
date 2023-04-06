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
    <link href="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/locales/bootstrap-datepicker.zh-CN.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <div style="width: 500px ;margin-left: auto;margin-right: auto;margin-top: 200px">
  <button type="button" class="btn btn-primary btn-lg btn-block" onclick="export_Staffinfo_Excel()">点击导出员工信息文件</button>
  <button type="button" class="btn btn-default btn-lg btn-block" onclick="export_attinfo_Excel()">点击导出员工考勤信息</button>
  <button type="button" class="btn btn-primary btn-lg btn-block" onclick="export_salaryinfo_Excel()">点击导出员工工资信息</button>
  <!-- excel文件导出 -->
  </div>
  </body>
<script>
    //导出请求
    function export_Staffinfo_Excel(){
        $.ajax({
            type: "post",
            url: "/document/export_staffinfo_Excel",
            dataType:"text",
            data:{},
            error: function(request) {
                alert("下载失败！")
                return false;
            },
            success: function(msg) {
                if(msg=='ok'){
                    window.location.href="/document/downloadExcel_d";
                }else{
                    alert("下载失败！")
                    return false;
                }
            }
        });
    }
    function export_attinfo_Excel(){
      $.ajax({
        type: "post",
        url: "/document/export_attinfo_Excel",
        dataType:"text",
        data:{},
        error: function(request) {
          alert("下载失败！")
          return false;
        },
        success: function(msg) {
          if(msg=='ok'){
            window.location.href="/document/downloadExcel_f";
          }else{
            alert("下载失败！")
            return false;
          }
        }
      });
    }
    function export_salaryinfo_Excel(){
      $.ajax({
        type: "post",
        url: "/document/export_salaryinfo_Excel",
        dataType:"text",
        data:{},
        error: function(request) {
          alert("下载失败！")
          return false;
        },
        success: function(msg) {
          if(msg=='ok'){
            window.location.href="/document/downloadExcel_g";
          }else{
            alert("下载失败！")
            return false;
          }
        }
      });
    }
</script>
</html>