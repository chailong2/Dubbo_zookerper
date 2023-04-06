<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>考勤信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/public/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/public/css/font.css">
    <link rel="stylesheet" href="/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/locales/bootstrap-datepicker.zh-CN.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/public/lib/layui/css/layui.css" charset="utf-8"></script>
    <script type="text/javascript" src="/public/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <script src="/clockpicker/dist/jquery-clockpicker.min.js"></script>
    <link href="/clockpicker/dist/jquery-clockpicker.min.css" rel="stylesheet">
    <![endif]-->
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>员工列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="to_page(1)" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div style="margin-left: auto;margin-right: auto;width: 1000px">
    <table class="table table-hover" id="emps_table">
        <caption>每月工资记录</caption>
        <thead>
        <tr>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>员工职务</th>
            <th>工资总额</th>
            <th>年份</th>
            <th>月份</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

    <script type="text/javascript">
        //1.页面加载完成后，直接发送一个ajax请求，要求分页数据
        $(function(){
            to_page(1);
        });
        function build_emps_table(result){
            //构建之前都清空table表格!!!!!!!
            $("#emps_table tbody").empty();
            $.each(result,function(index,item){
                //定义变量
                var empNameTD=$("<td></td>").append(item.staffInformation.staffId);
                var emaage=$("<td></td>").append(item.staffInformation.staffname);
                var emasex=$("<td></td>").append(item.staffInformation.duty);
                var empsex1=$("<td></td>").append(item.salarynum);
                var empsetx2=$("<td></td>").append(item.salaryyear);
                var empsetx3=$("<td></td>").append(item.salarymouth);
                $("<tr></tr>")
                    .append(empNameTD)
                    .append(emaage)
                    .append(emasex)
                    .append(empsex1)
                    .append(empsetx2)
                    .append(empsetx3)
                    .appendTo("#emps_table tbody");
            });
        }
        function to_page(date){
            $.ajax({
                url:"/salary/fixsalaryinfo",
                type:"Post",
                dataType:"json",
                success:function(result){
                    build_emps_table(result.Salaryinfo);
                }
            });
        }
        function  updateattinfo(e)
        {
            var info1=e.parentNode.parentNode.parentNode.parentNode.parentNode.childNodes[0].firstChild.nodeValue;
            var info2=e.firstChild.nodeValue;
            var info3=e.parentNode.parentNode.parentNode.parentNode.parentNode.childNodes[5].firstChild.nodeValue;
            var info4=e.parentNode.parentNode.parentNode.parentNode.parentNode.childNodes[6].firstChild.nodeValue;
            $.ajax({
                url:"/salary/updatesalaryinfo",
                data:{"info1":info1,"info2":info2,"info3":info3,"info4":info4},
                type:"post",
                dataType:"json",
                success:function(result){
                    to_page(1);
                }
            });
        }
    </script>
    <style type="text/css">
        input{
            border:none;
            width:100px;
            height:30px;
            box-radius:25%;
            outline:medium;
            text-align:center;
        }
    </style>
</div>
</body>
</html>