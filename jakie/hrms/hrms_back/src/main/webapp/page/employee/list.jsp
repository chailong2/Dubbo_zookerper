<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>员工列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/public/logo.ico" type="image/x-icon" /  >
    <link rel="stylesheet" href="/public/css/font.css">
    <link rel="stylesheet" href="/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/public/js/xadmin.js"></script>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
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
    <div class="x-body">
      <div class="layui-row" style="" align="center">
        <form class="layui-form layui-col-md12 x-so" method="get">
          <!-- <input class="layui-input" placeholder="开始日" name="start" id="start">
          <input class="layui-input" placeholder="截止日" name="end" id="end"> -->
          <input type="text" name="content" style="width:50%;"  placeholder="请输入查找员工的ID" autocomplete="off" class="layui-input">
          <button class="layui-btn" type="button" lay-filter="sreach" onclick="findstaffbyid(this)"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <%-- <xblock>
 <!--        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button> -->
        <button class="layui-btn" onclick="x_admin_show('添加用户','${ctx}/dept/add')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：88 条</span>
      </xblock> --%>
     
      
      <table class="layui-table" id="emps_table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
         <th>工号</th>
         <th>姓名</th>
         <th>年龄</th>
         <th>性别</th>
         <th>学历</th>
         <th>职位</th>
         <th>身份证号码</th>
         <th>地址</th>
         <th>联系电话</th>
         <th>操作</th>
        </thead>
        <tbody>
        </tbody>
      </table>
        <div class="col-md-6" id="page_info_area" style="float: left;margin-left: auto;margin-right: auto"></div>
            <!-- 分页条信息 -->
        <div class="col-md-6" id="page_nav_area" style="padding-left: 220px"></div>
        <!-- 分页信息 -->

        <script type="text/javascript">
            var totalRecord,currentPage;
            //1.页面加载完成后，直接发送一个ajax请求，要求分页数据
            $(function(){
                to_page(1);
            });
            function build_emps_table(result){
                //构建之前都清空table表格!!!!!!!
                $("#emps_table tbody").empty();
                $.each(result,function(index,item){
                    //定义变量
                    var checkBoxTD=$("<td><div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div></td>");
                    var empIdTD=$("<td></td>").append(item.staffId);
                    var empNameTD=$("<td></td>").append(item.staffname);

                    var emaage=$("<td></td>").append(item.staffage);
                    var emasex=$("<td></td>").append(item.staffsex);
                    var emabackgroud=$("<td></td>").append(item.educationBackground);
                    var emaduty=$("<td></td>").append(item.duty);
                    var emaIdcard=$("<td></td>").append(item.idcard);
                    var emaadress=$("<td></td>").append(item.address);
                    var emaphonenumber=$("<td></td>").append(item.phonenumber);
                    var delBtn=$("<td class=\"td-manage\">"
                    +"<a title='编辑'  onclick='updatainfo(this)'>"
                        +"<i class='layui-icon'>&#xe642;</i>"
                    +"</a>"
                    +"<a title='删除'   onclick='member_del(this)'>"
                        +"<i class='layui-icon '>&#xe640;</i>"
                     +"</a>"
                        +"</td>");
                    $("<tr></tr>").append(checkBoxTD)
                        .append(empIdTD)
                        .append(empNameTD)
                        .append(emaage)
                        .append(emasex)
                        .append(emabackgroud)
                        .append(emaduty)
                        .append(emaIdcard)
                        .append(emaadress)
                        .append(emaphonenumber)
                        .append(delBtn)
                        .appendTo("#emps_table tbody");
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
                $.each(result.pageInfo.totalPagelist,function(index,item){
                    var numLi=$("<li></li>").append($("<a></a>").append(item));
                    //判断
                    if(result.pageInfo.currentPage==item){
                        numLi.addClass("active");
                    }
                    numLi.click(function(){
                        to_page(item);
                    });
                    ul.append(numLi);
                });
                ul.append(nexPageLi).append(lastPageLi);
                var nav=$("<nav></nav>").append(ul);  //把ul加入到nav中去
                $("#page_nav_area").append(nav);
                //nav.appendTo("#page_nav_area");
            }

            function to_page(pn){
                $.ajax({
                    url:"/employee/list",
                    data:"pn="+pn,
                    type:"Post",
                    dataType:"json",
                    success:function(result){
                        //1.解析并显示员工数据
                        build_emps_table(result.pageInfo.staffInformations);
                        // 2.解析并显示分页信息
                        build_page_info(result);
                        // 3.解析显示分页条数据
                        build_page_nav(result);

                    }
                });
            }
        </script>
    </div>
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });
        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>

<%--  弹窗的实现--%>
    <!-- Modal -->
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
                <label for="info1">工&nbsp;&nbsp;号:</label>
                <input type="text" class="form-control" placeholder="工号不可修改" id="info1"  readonly="readonly">
              </div>
              <div class="form-group">
                <label for="info2">姓&nbsp;&nbsp;名:</label>
                <input type="text" class="form-control" placeholder="输入姓名" id="info2">
              </div>
              <div class="form-group">
                <label for="info3">年&nbsp;&nbsp;龄:</label>
                <input type="text" class="form-control" placeholder="输入年龄" id="info3">
              </div>
              <div class="form-group">
                <label for="info4">性&nbsp;&nbsp;别:</label>
                <input type="text" class="form-control" placeholder="输入性别" id="info4">
              </div>
              <div class="form-group">
                <label for="info5"> 学&nbsp;&nbsp;历:</label>
                <input type="text" class="form-control" placeholder="输入学历" id="info5">
              </div>
              <div class="form-group">
                <label for="info6">职&nbsp;&nbsp;位:</label>
                <input type="text" class="form-control" placeholder="输入职位" id="info6">
              </div>
              <div class="form-group">
                <label for="info7">身份证号:</label>
                <input type="text" class="form-control" placeholder="输入身份证号" id="info7">
              </div>
              <div class="form-group">
                <label for="info8">地&nbsp;&nbsp;址:</label>
                <input type="text" class="form-control" placeholder="输入地址" id="info8">
              </div>
              <div class="form-group">
                <label for="info9">联系电话:</label>
                <input type="text" class="form-control" placeholder="输入联系电话" id="info9">
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
      <%--      通过弹窗修改员工信息--%>
      function updatainfo(e) {
        for (var i=1;i<=9;i++)
        {
          var k="info"+i;
          var m=e.parentNode.parentNode.childNodes[i].firstChild.nodeValue;  //获得节点值
          document.getElementById(""+k).value=m;
        }
        $('#updateModal').modal('show');
      }
      function updatainfo2(e){
        var arr=new Array(9);
        for (var i=1;i<=9;i++){
            var k="info"+i;
            var info=document.getElementById(""+k).value;
            arr[i-1]=info;
        }
        $.ajax({
          url: "/employee/update",
          type: "post",
          async: false,   //同步
          dataType: "json",
          data: {"staffId":arr[0],"staffname":arr[1],"staffage":arr[2],"staffsex":arr[3]
            ,"educationBackground":arr[4],"duty":arr[5],"idcard":arr[6],"address":arr[7]
            ,"phonenumber":arr[8]},
          success: function (result) {
            //1.解析并显示员工数据
            build_emps_table(result.pageInfo.staffInformations);
            // 2.解析并显示分页信息
            build_page_info(result);
            // 3.解析显示分页条数据
            build_page_nav(result);
            }
          })
         }
      /*用户-删除*/
      function member_del(e){

          var staffid=e.parentNode.parentNode.childNodes[1].firstChild.nodeValue;  //获得节点值;
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $.ajax({
                  url:"/employee/delete",
                  data:"staffid="+staffid,
                  type:"Post",
                  dataType:"json",
                  success:function(result){
                    $("#emps_table tbody").empty();
                    to_page(1)

                  }
              });
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }
      function findstaffbyid(e){
          var staffid=e.previousElementSibling.value;  //获得节点值;
              $.ajax({
                  url:"/employee/findstaffbyid",
                  data:"staffid="+staffid,
                  type:"get",
                  dataType:"json",
                  success:function(result){
                      //1.解析并显示员工数据
                      build_emps_table(result.pageInfo.staffInformations);
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