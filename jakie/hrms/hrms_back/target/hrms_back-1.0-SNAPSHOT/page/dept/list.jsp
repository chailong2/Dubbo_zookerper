<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--图标样式-->
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
            $('.tree li.parent_li > span').on('click', function (e) {
                var children = $(this).parent('li.parent_li').find(' > ul > li');
                if (children.is(":visible")) {
                    children.hide('fast');
                    $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
                } else {
                    children.show('fast');
                    $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
                }
                e.stopPropagation();
            });
        });
    </script>
</head>
<body>
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel">
    <div class="modal-dialog modal-max" role="document">	<!-- class modal-max 是我自定义调整模态框大小，官方有modal-lg -->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="updateModalLabel">修改个人信息</h4>
            </div>
            <div class="modal-body" id="contenx">

            </div>
            <div class="modal-footer" id="config">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" id="personSubmit" onclick="updatainfo2(this)" data-dismiss="modal">确认修改</button>
            </div>
        </div>
    </div>
</div>
<div class="tree well" style="width: 1000px;margin-left: auto;margin-right: auto">
    <ul>
        <li>
            <span><i class="icon-folder-open"></i>华信科技公司</span> <a onclick="infoshow(1,this)">查看简介</a>
            <ul id="tree">

            </ul>
        </li>
    </ul>
</div>
<style>
    .tree {
        min-height:20px;
        padding:19px;
        margin-bottom:20px;
        background-color:#fbfbfb;
        border:1px solid #999;
        -webkit-border-radius:4px;
        -moz-border-radius:4px;
        border-radius:4px;
        -webkit-box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05);
        -moz-box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05);
        box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05)
    }
    .tree li {
        list-style-type:none;
        margin:0;
        padding:10px 5px 0 5px;
        position:relative
    }
    .tree li::before, .tree li::after {
        content:'';
        left:-20px;
        position:absolute;
        right:auto
    }
    .tree li::before {
        border-left:1px solid #999;
        bottom:50px;
        height:100%;
        top:0;
        width:1px
    }
    .tree li::after {
        border-top:1px solid #999;
        height:20px;
        top:25px;
        width:25px
    }
    .tree li span {
        -moz-border-radius:5px;
        -webkit-border-radius:5px;
        border:1px solid #999;
        border-radius:5px;
        display:inline-block;
        padding:3px 8px;
        text-decoration:none
    }
    .tree li.parent_li>span {
        cursor:pointer
    }
    .tree>ul>li::before, .tree>ul>li::after {
        border:0
    }
    .tree li:last-child::before {
        height:30px
    }
    .tree li.parent_li>span:hover, .tree li.parent_li>span:hover+ul li span {
        background:#eee;
        border:1px solid #94a0b4;
        color:#000
    }
</style>
<script type="text/javascript">
    $(function(){
        to_page();
    });
    function build_emps_table(result){
        //构建之前都清空table表格!!!!!!!
        $("#tree").empty();
        console.log(result);
        $.each(result,function(index,item){
            var midinfo1="";
            var midinfo2="";
            if(item.header!=null)
            {
                midinfo2+="<li>\n" +
                    "  <span><i class=\"icon-leaf\"></i><a style='display: none;height: 0px'>"+item.header.staffId+"</a><p style='margin-bottom: 0px'>"+item.header.staffname+"</p></span>\n" +
                    "  <a onclick='staffchange(this)'>员工调动</a>\n" +
                    "  \n" +
                    "  </li>\n" ;
            }
            if(item.staffInformationList!=null)
            {
                 $.each(item.staffInformationList,function(index,items){
                     midinfo1+="<li>\n" +
                     "  <span><i class=\"icon-leaf\"></i><a style='display: none;height: 0px'>"+items.staffId+"</a><p style='margin-bottom: 0px'>"+items.staffname+"</p></span>\n" +
                     "  <a onclick='staffchange(this)'>员工调度</a>\n" +
                " </li>\n"
            })
            }
            var info1=$(" <li>\n" +
                "                    <span><i class=\"icon-minus-sign\"></i>"+item.department.detname+"</span>\n" +
                "  <a onclick='addstaff(this)'>添加员工</a>\n" +
                "                    <ul>\n" +
                "                        <li>\n" +
                "                            <span><i class=\"icon-minus-sign\"></i>部门负责人</span>\n" +
                "                            <ul> \n" +
                midinfo2+
                "                            </ul>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <span><i class=\"icon-minus-sign\"></i>部门员工</span>\n" +
                "                            <ul>\n" +
                midinfo1+
                "                            </ul>\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                </li>");
            info1.appendTo("#tree");
        });
    }
    function to_page(){
        $.ajax({
            url:"/department/list",
            type:"Post",
            dataType:"json",
            success:function(result){
                console.log(result);
                build_emps_table(result.pageInfo);
            }
        });
    }
    function infoshow(item,e){
       if(item==1)
       {
           var title=document.getElementById("updateModalLabel");
           title.firstChild.nodeValue="公司介绍";
           var b="<p>华信科技公司是一个优秀的科技公司，致力于计算机系统的开发！</p>"
           var c="<p>联系电话:<u>112-03-123</u></p>"
           $('#contenx').empty();
           $('#contenx').append(b).append(c);
           $('#config').empty();
           var d="<button type=\"submit\" class=\"btn btn-primary\" id=\"personSubmit\" data-dismiss=\"modal\">确认</button>"
           $('#config').append(d);
           $('#updateModal').modal('show');
       }
        if(item=="行政部")
        {
            var title=document.getElementById("updateModalLabel");
            title.firstChild.nodeValue="行政部介绍";
            var b="<p>行政部主要负责，公式日常运作与办公监督！</p>"
            var c="<p>联系电话:<u>112-03-128</u></p>"
            $('#contenx').empty();
            $('#contenx').append(b).append(c);
            $('#config').empty();
            var d="<button type=\"submit\" class=\"btn btn-primary\" id=\"personSubmit\" data-dismiss=\"modal\">确认</button>"
            $('#config').append(d);
            $('#updateModal').modal('show');
        }
    }
    function staffchange2(e)
    {
        var info1=document.getElementById("sid").firstChild.nodeValue;  //staffid
        var info2=document.getElementById("in4").value; //部门
        var info3=document.getElementById("in5").value;//职位
        $.ajax({
            url:"/department/updatedeinfo",
            data:{"info1":info1,"info2":info2,"info3":info3},
            type:"post",
            dataType:"json",
            success:function(result){
                build_emps_table(result.pageInfo);
            }
        });
    }
    function staffchange(e)
    {
        var a=e.previousElementSibling.getElementsByTagName("a").item(0).firstChild.nodeValue;
        var title=document.getElementById("updateModalLabel");
        title.firstChild.nodeValue="人员调整";
        var c="<a id='sid' style='display: none'>"+a+"</a>";
        var f="<p id='sid' '>对工号为"+a+"的员工进行调整</p>";
        var b=" <form id=\"info\">\n" +
            "        <div class=\"form-group\">\n" +
            "        <label for=\"in4\">要调整的部门</label>\n" +
            "        <select class=\"form-control\" id=\"in4\">\n" +
            "        <option>行政部</option>\n" +
            "        <option>开发部</option>\n" +
            "        <option>财务部</option>\n" +
            "        <option>销售部</option>\n" +
            "        </select>\n" +
            "        </div>\n" +
            "        <div class=\"form-group\">\n" +
            "        <label for=\"in5\">要调整的职位</label>\n" +
            "        <select class=\"form-control\" id=\"in5\">\n" +
            "        <option>部门负责人</option>\n" +
            "        <option>员工</option>\n" +
            "        </select>\n" +
            "        </div>\n" +
            "        </form>"
        $('#contenx').empty();
        $('#contenx').append(c).append(f).append(b);
        $('#config').empty();
        var d="<button type=\"submit\" class=\"btn btn-primary\" onclick='staffchange2(this)' id=\"personSubmit\" data-dismiss=\"modal\">确认</button>";
        var e="<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>";
        $('#config').append(e).append(d);
        $('#updateModal').modal('show');
    }
    function addstaff2(result,item){
        var title=document.getElementById("updateModalLabel");
        title.firstChild.nodeValue=item;

        $('#contenx').empty();
        $('#config').empty();
        var bodymy="";
        $.each(result,function(index,item){
            bodymy+=  "<option>"+item.staffId+"</option>\n"
        });
        var empIdTD=$(" <div class=\"form-group\">\n" +
            "              <label for=\"ak\">选择待添加员工的工号</label>\n" +
            "              <select class=\"form-control\" id=\"ak\">\n" +
            bodymy+
            "              </select>\n" +
            "          </div>")
        var d="<button type=\"submit\" class=\"btn btn-primary\" onclick='addstaff3()' id=\"personSubmit\" data-dismiss=\"modal\">确认</button>";
        var e="<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>";
        $('#contenx').append(empIdTD)
        $('#config').append(d).append(e);
        $('#updateModal').modal('show');
    }
    function addstaff(e)
    {
        var b=e.previousElementSibling.childNodes[1].nodeValue;
        $.ajax({
            url:"/department/deaddstaff",
            type:"post",
            dataType:"json",
            success:function(result){
                if(result.stafflist=="无空闲员工")
                {
                    alert("无空闲员工！")
                }
                else {
                    addstaff2(result.stafflist,b);
                }
            }
        });
    }
    function addstaff3()
    {
        var title=document.getElementById("updateModalLabel");
        var department=title.firstChild.nodeValue;
        var id=document.getElementById("ak").value;
        $.ajax({
            url:"/department/addnewemploy",
            data:"id="+id+"&department="+department,
            type:"post",
            dataType:"json",
            success:function(result){
                to_page();
            }
        });
    }
</script>
</body>
</html>