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
    <![endif]-->
</head>

<body>
<script>
    // 选择时间事件
    $(function () {
        var today = new Date();
        var todayStr = today.getFullYear() + '/' + (today.getMonth()+1)
            + '/' + today.getDate();
        var option = {
            'format': 'yyyy/mm/dd',
            'autoclose': true,
            'startDate': '2018/7/10',
            'endDate': todayStr,
            'language': 'zh-CN',
            'todayBtn': 'linked', // 显示一个选择今日的按钮
            'todayHighlight': true, // 当前日期是否高亮
            'showButtonPanel': false, // 是否展示按钮
            'clearBtn': true

            // 'startDate': '-3d'
        };
        $('input[name="content"]').datepicker(option);
    });
</script>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>考勤信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="to_page(1)" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
    <div class="layui-row" style="" align="center">
        <form class="layui-form layui-col-md12 x-so" method="get">
            <!-- <input class="layui-input" placeholder="开始日" name="start" id="start">
            <input class="layui-input" placeholder="截止日" name="end" id="end"> -->
            <input readonly type="text" name="content" style="width:50%;"  placeholder="按照日期查询" autocomplete="off" class="layui-input">
            <button class="layui-btn" type="button" lay-filter="sreach" onclick="findstaffbydate(this)"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <%-- <xblock>
<!--        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button> -->
      <button class="layui-btn" onclick="x_admin_show('添加用户','${ctx}/dept/add')"><i class="layui-icon"></i>添加</button>
      <span class="x-right" style="line-height:40px">共有数据：88 条</span>
    </xblock> --%>

<div style="margin-left: auto;margin-right: auto;width: 1000px">
    <table class="layui-table" id="emps_table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>考勤编号</th>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>员工职位</th>
            <th>考勤信息</th>
            <th>时间</th>
        </thead>
        <tbody>
        </tbody>
    </table>
    <div class="col-md-6" id="page_info_area" style="float: left;margin-left: auto;margin-right: auto"></div>
    <!-- 分页条信息 -->
    <div class="col-md-6" id="page_nav_area" style="padding-left: 220px"></div>
    <!-- 分页信息 -->
</div>


    <script type="text/javascript">
        var totalRecord,currentPage;
        //1.页面加载完成后，直接发送一个ajax请求，要求分页数据
        $(function(){
            to_page(1);
        });
        function build_emps_table(result){
            //构建之前都清空table表格!!!!!!!
            $("#emps_table tbody").empty();
            var pre;
            $.each(result,function(index,item){
                //定义变量
                if(item.staffInformation.staffId==undefined)
                    item=pre;
                var checkBoxTD=$("<td><div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div></td>");
                var empIdTD=$("<td></td>").append(item.attendanceId);
                var empNameTD=$("<td></td>").append(item.staffInformation.staffId);
                var emaage=$("<td></td>").append(item.staffInformation.staffname);
                var emasex=$("<td></td>").append(item.staffInformation.duty);
                var emabackgroud=$("<td></td>").append(item.attendancetype);
                var emaduty=$("<td></td>").append(item.attendancetime);
                $("<tr></tr>").append(checkBoxTD)
                    .append(empIdTD)
                    .append(empNameTD)
                    .append(emaage)
                    .append(emasex)
                    .append(emabackgroud)
                    .append(emaduty)
                    .appendTo("#emps_table tbody");
                pre=item;
            });
        }
        //
        function build_page_info(result){
            $("#page_info_area").empty();
            $("#page_info_area").append("当前"+result.pageInfo.currentPage+"页,总"+result.pageInfo.totalPage+"页,总"+result.pageInfo.count+"条记录");

            totalRecord=result.pageInfo.count;
            currentPage=result.pageInfo.currentPage;
        }
        function build_page_nav(result){
            $("#page_nav_area").empty();
            var ul=$("<ul></ul>").addClass("pagination");

            var firsPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
            var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
            if(result.pageInfo.hasPreviousPage==false){
                firsPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            }else{
                firsPageLi.click(function(){
                    to_page(1);
                });
                prePageLi.click(function(){
                    to_page(result.pageInfo.currentPage-1);
                });
            }

            var nexPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
            var lastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
            if(result.pageInfo.hasNextPage==false){
                nexPageLi.addClass("disabled");
                lastPageLi.addClass("disabled");
            }else{
                nexPageLi.click(function(){
                    to_page(result.pageInfo.currentPage+1);
                });
                lastPageLi.click(function(){
                    to_page(result.pageInfo.totalPage);
                });
            }

            ul.append(firsPageLi).append(prePageLi);
            ul.append(nexPageLi).append(lastPageLi);
            var nav=$("<nav></nav>").append(ul);  //把ul加入到nav中去
            $("#page_nav_area").append(nav);
            //nav.appendTo("#page_nav_area");
        }

        function to_page(pn){
            $.ajax({
                url:"/atendance/list",
                data:"pn="+pn,
                type:"Get",
                dataType:"json",
                success:function(result){
                    //1.解析并显示员工数据
                    console.log(result)
                    build_emps_table(result.pageInfo.attendences);
                    // 2.解析并显示分页信息
                    build_page_info(result);
                    // 3.解析显示分页条数据
                    build_page_nav(result);

                }
            });
        }
    </script>
</div>

<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>

<script>
    function findstaffbydate(e){
        var attdate=e.previousElementSibling.value;  //获得节点值;
        $.ajax({
            url:"/atendance/findstaffbydate",
            data:"attdate="+attdate,
            type:"get",
            dataType:"json",
            success:function(result){
                //1.解析并显示员工数据
                build_emps_table(result.pageInfo.attendences);
                // 2.解析并显示分页信息
                build_page_info(result);
                // 3.解析显示分页条数据
                build_page_nav(result);

            }
        });
    }
</script>
</body>
</html>