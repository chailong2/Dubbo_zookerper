<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>管理员信息</title>
      <meta name="renderer" content="webkit">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
      <link rel="shortcut icon" href="/public/logo.ico" type="image/x-icon" />
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
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>管理员信息</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="to_page()" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
        <div style="margin-left: auto;margin-right: auto;width: 1000px">
            <table class="layui-table" id="emps_table">
                <thead>
                <tr>
                    <th>
                        <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
                    </th>
                    <th>管理员姓名</th>
                    <th>管理员登陆账号</th>
                    <th>管理员登陆密码</th>
                    <th>操作</th>
                </thead>
                <tbody>
                </tbody>
            </table>
            <div class="col-md-6" id="page_info_area" style="float: left;margin-left: auto;margin-right: auto"></div>
            <!-- 分页条信息 -->
            <div class="col-md-6" id="page_nav_area" style="padding-left: 220px"></div>
            <!-- 分页信息 -->
        </div>
    </div>
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel">
        <div class="modal-dialog modal-max" role="document">	<!-- class modal-max 是我自定义调整模态框大小，官方有modal-lg -->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="updateModalLabel">修改个人信息</h4>
                </div>
                <div class="modal-body">
                    <form id="personForm" class="form-horizontal fontBig" style="padding:10px 10px">
                        <div class="form-group">
                            <label for="info1">姓&nbsp;&nbsp;名:</label>
                            <input type="text" class="form-control" placeholder="工号不可修改" id="info1" >
                        </div>
                        <div class="form-group">
                            <label for="info2">账&nbsp;&nbsp;号:</label>
                            <input type="text" class="form-control" placeholder="输入姓名" id="info2"  readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label for="info3">密&nbsp;&nbsp;码:</label>
                            <input type="text" class="form-control" placeholder="输入年龄" id="info3">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary" id="personSubmit" onclick="updatainfo2(this)" data-dismiss="modal">确认修改</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(function(){
            to_page();
        });
        function build_emps_table(result){
            //构建之前都清空table表格!!!!!!!
            $("#emps_table tbody").empty();
            $.each(result,function(index,item){
                //定义变量
                var info1=$("<td><div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div></td>");
                var info2=$("<td></td>").append(item.administername);
                var info3=$("<td></td>").append(item.account);
                var info4=$("<td></td>").append(item.password);;
                var info5=$("<td class=\"td-manage\">"
                    +"<a title='编辑'  onclick='updatainfo(this)'>"
                    +"<i class='layui-icon'>&#xe642;</i>"
                    +"</a>"
                    +"<a title='删除'   onclick='member_del(this)'>"
                    +"<i class='layui-icon '>&#xe640;</i>"
                    +"</a>"
                    +"</td>");
                $("<tr></tr>").append(info1)
                    .append(info2)
                    .append(info3)
                    .append(info4)
                    .append(info5)
                    .appendTo("#emps_table tbody");
            });
        }
        function to_page(){
            $.ajax({
                url:"/admin/list",
                type:"Post",
                dataType:"json",
                success:function(result){
                    build_emps_table(result.admininfo);
                    console.log(result.admininfo)
                }
            });
        }
        function updatainfo(e) {
            for (var i=1;i<=3;i++)
            {
                var k="info"+i;
                var m=e.parentNode.parentNode.childNodes[i].firstChild.nodeValue;  //获得节点值
                document.getElementById(k).value=m;
            }
            $('#updateModal').modal('show');
        }
        function updatainfo2(e){
            var arr=new Array(9);
            for (var i=1;i<=3;i++){
                var k="info"+i;
                var info=document.getElementById(""+k).value;
                arr[i-1]=info;
            }
            $.ajax({
                url: "/admin/update",
                type: "post",
                async: false,   //同步
                dataType: "json",
                data: {"administername":arr[0],"account":arr[1],"password":arr[2]},
                success: function (result) {
                    //1.解析并显示员工数据
                    build_emps_table(result.admininfo);
                }
            })
        }
        function member_del(e) {
            var account = e.parentNode.parentNode.childNodes[2].firstChild.nodeValue;  //获得节点值;
            layer.confirm('确认要删除吗？', function (index) {
                //发异步删除数据
                $.ajax({
                    url: "/admin/delete",
                    data: "account=" + account,
                    type: "Post",
                    dataType: "json",
                    success: function (result) {
                        build_emps_table(result.admininfo);
                    }
                });
                layer.msg('已删除!', {icon: 1, time: 1000});

            })
        }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>