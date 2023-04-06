<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>招聘审批</title>
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
          <cite>待审批列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="refresh()" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div style="margin-left: auto;margin-right: auto;width: 1100px">
<table class="table table-hover" id="emps_table">
    <caption>审批表</caption>
    <thead>
    <tr>
        <th>申请人账号</th>
        <th>申请人姓名</th>
        <th>申请人性别</th>
        <th>申请人年龄</th>
        <th>学历背景</th>
        <th>申请职位</th>
        <th>身份证号</th>
        <th>个人地址</th>
        <th>联系电话</th>
        <th>审批</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

    <script type="text/javascript">
        //1.页面加载完成后，直接发送一个ajax请求，要求分页数据
        $(function(){
            to_page();
        });
        function refresh(){
            to_page();
        }
        function build_emps_table(result){
            //构建之前都清空table表格!!!!!!!
            $("#emps_table tbody").empty();
            $.each(result,function(index,item){
                var info1=$("<td></td>").append(item.account);
                var info2=$("<td></td>").append(item.applyname);
                var info3=$("<td></td>").append(item.applysex);
                var info4=$("<td></td>").append(item.applyage);
                var info5=$("<td></td>").append(item.applyeducation);
                var info6=$("<td></td>").append(item.appplyduty);
                var info7=$("<td></td>").append(item.applyidcard);
                var info8=$("<td></td>").append(item.applyaddress);
                var info9=$("<td></td>").append(item.applyphonenumber);
                var delBtn=$("<td class=\"td-manage\">"
                    +"<a title='同意'  onclick='pass(this)'>"
                    +"<i class='layui-icon'>&#xe605;</i>"
                    +"</a>"
                    +"<a title='拒绝'   onclick='refuse(this)'>"
                    +"<i class='layui-icon '>&#x1006;</i>"
                    +"</a>"
                    +"</td>");
                var emaduty=$("<td></td>").append(item.attendancetime);
                $("<tr></tr>")
                    .append(info1)
                    .append(info2)
                    .append(info3)
                    .append(info4)
                    .append(info5)
                    .append(info6)
                    .append(info7)
                    .append(info8)
                    .append(info9)
                    .append(delBtn)
                    .appendTo("#emps_table tbody");
            });
        }
        function to_page(){
            $.ajax({
                url:"/theapply/getAllapplyinfo",
                type:"Post",
                dataType:"json",
                success:function(result){
                    //1.解析并显示员工数据
                    build_emps_table(result.applyinfo);

                }
            });
        }
       function pass(e)
       {
           var account=e.parentNode.parentNode.childNodes[0].firstChild.nodeValue;  //获得节点值;
           $.ajax({
               url:"/theapply/passapply",
               data:"account="+account,
               type:"Post",
               dataType:"json",
               success:function(result){
                   //1.解析并显示员工数据
                   build_emps_table(result.applyinfo);

               }
           });

       }
       function refuse(e)
       {
           var account=e.parentNode.parentNode.childNodes[0].firstChild.nodeValue;  //获得节点值;
           $.ajax({
               url:"/theapply/refuseapply",
               data:"account="+account,
               type:"Post",
               dataType:"json",
               success:function(result){
                   //1.解析并显示员工数据
                   build_emps_table(result.applyinfo);

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