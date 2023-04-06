/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-09-21 09:05:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page.dept;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("    <!--图标样式-->\n");
      out.write("    <script type=\"text/javascript\" src=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("    <link href=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        $(function(){\n");
      out.write("            $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');\n");
      out.write("            $('.tree li.parent_li > span').on('click', function (e) {\n");
      out.write("                var children = $(this).parent('li.parent_li').find(' > ul > li');\n");
      out.write("                if (children.is(\":visible\")) {\n");
      out.write("                    children.hide('fast');\n");
      out.write("                    $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');\n");
      out.write("                } else {\n");
      out.write("                    children.show('fast');\n");
      out.write("                    $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');\n");
      out.write("                }\n");
      out.write("                e.stopPropagation();\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"modal fade\" id=\"updateModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"updateModalLabel\">\n");
      out.write("    <div class=\"modal-dialog modal-max\" role=\"document\">\t<!-- class modal-max 是我自定义调整模态框大小，官方有modal-lg -->\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                <h4 class=\"modal-title\" id=\"updateModalLabel\">修改个人信息</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\" id=\"contenx\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\" id=\"config\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\" id=\"personSubmit\" onclick=\"updatainfo2(this)\" data-dismiss=\"modal\">确认修改</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"tree well\" style=\"width: 1000px;margin-left: auto;margin-right: auto\">\n");
      out.write("    <ul>\n");
      out.write("        <li>\n");
      out.write("            <span><i class=\"icon-folder-open\"></i>华信科技公司</span> <a onclick=\"infoshow(1,this)\">查看简介</a>\n");
      out.write("            <ul id=\"tree\">\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("<style>\n");
      out.write("    .tree {\n");
      out.write("        min-height:20px;\n");
      out.write("        padding:19px;\n");
      out.write("        margin-bottom:20px;\n");
      out.write("        background-color:#fbfbfb;\n");
      out.write("        border:1px solid #999;\n");
      out.write("        -webkit-border-radius:4px;\n");
      out.write("        -moz-border-radius:4px;\n");
      out.write("        border-radius:4px;\n");
      out.write("        -webkit-box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05);\n");
      out.write("        -moz-box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05);\n");
      out.write("        box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05)\n");
      out.write("    }\n");
      out.write("    .tree li {\n");
      out.write("        list-style-type:none;\n");
      out.write("        margin:0;\n");
      out.write("        padding:10px 5px 0 5px;\n");
      out.write("        position:relative\n");
      out.write("    }\n");
      out.write("    .tree li::before, .tree li::after {\n");
      out.write("        content:'';\n");
      out.write("        left:-20px;\n");
      out.write("        position:absolute;\n");
      out.write("        right:auto\n");
      out.write("    }\n");
      out.write("    .tree li::before {\n");
      out.write("        border-left:1px solid #999;\n");
      out.write("        bottom:50px;\n");
      out.write("        height:100%;\n");
      out.write("        top:0;\n");
      out.write("        width:1px\n");
      out.write("    }\n");
      out.write("    .tree li::after {\n");
      out.write("        border-top:1px solid #999;\n");
      out.write("        height:20px;\n");
      out.write("        top:25px;\n");
      out.write("        width:25px\n");
      out.write("    }\n");
      out.write("    .tree li span {\n");
      out.write("        -moz-border-radius:5px;\n");
      out.write("        -webkit-border-radius:5px;\n");
      out.write("        border:1px solid #999;\n");
      out.write("        border-radius:5px;\n");
      out.write("        display:inline-block;\n");
      out.write("        padding:3px 8px;\n");
      out.write("        text-decoration:none\n");
      out.write("    }\n");
      out.write("    .tree li.parent_li>span {\n");
      out.write("        cursor:pointer\n");
      out.write("    }\n");
      out.write("    .tree>ul>li::before, .tree>ul>li::after {\n");
      out.write("        border:0\n");
      out.write("    }\n");
      out.write("    .tree li:last-child::before {\n");
      out.write("        height:30px\n");
      out.write("    }\n");
      out.write("    .tree li.parent_li>span:hover, .tree li.parent_li>span:hover+ul li span {\n");
      out.write("        background:#eee;\n");
      out.write("        border:1px solid #94a0b4;\n");
      out.write("        color:#000\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(function(){\n");
      out.write("        to_page();\n");
      out.write("    });\n");
      out.write("    function build_emps_table(result){\n");
      out.write("        //构建之前都清空table表格!!!!!!!\n");
      out.write("        $(\"#tree\").empty();\n");
      out.write("        console.log(result);\n");
      out.write("        $.each(result,function(index,item){\n");
      out.write("            var midinfo1=\"\";\n");
      out.write("            var midinfo2=\"\";\n");
      out.write("            if(item.header!=null)\n");
      out.write("            {\n");
      out.write("                midinfo2+=\"<li>\\n\" +\n");
      out.write("                    \"  <span><i class=\\\"icon-leaf\\\"></i><a style='display: none;height: 0px'>\"+item.header.staffId+\"</a><p style='margin-bottom: 0px'>\"+item.header.staffname+\"</p></span>\\n\" +\n");
      out.write("                    \"  <a onclick='staffchange(this)'>员工调动</a>\\n\" +\n");
      out.write("                    \"  \\n\" +\n");
      out.write("                    \"  </li>\\n\" ;\n");
      out.write("            }\n");
      out.write("            if(item.staffInformationList!=null)\n");
      out.write("            {\n");
      out.write("                 $.each(item.staffInformationList,function(index,items){\n");
      out.write("                     midinfo1+=\"<li>\\n\" +\n");
      out.write("                     \"  <span><i class=\\\"icon-leaf\\\"></i><a style='display: none;height: 0px'>\"+items.staffId+\"</a><p style='margin-bottom: 0px'>\"+items.staffname+\"</p></span>\\n\" +\n");
      out.write("                     \"  <a onclick='staffchange(this)'>员工调度</a>\\n\" +\n");
      out.write("                \" </li>\\n\"\n");
      out.write("            })\n");
      out.write("            }\n");
      out.write("            var info1=$(\" <li>\\n\" +\n");
      out.write("                \"                    <span><i class=\\\"icon-minus-sign\\\"></i>\"+item.department.detname+\"</span>\\n\" +\n");
      out.write("                \"  <a onclick='addstaff(this)'>添加员工</a>\\n\" +\n");
      out.write("                \"                    <ul>\\n\" +\n");
      out.write("                \"                        <li>\\n\" +\n");
      out.write("                \"                            <span><i class=\\\"icon-minus-sign\\\"></i>部门负责人</span>\\n\" +\n");
      out.write("                \"                            <ul> \\n\" +\n");
      out.write("                midinfo2+\n");
      out.write("                \"                            </ul>\\n\" +\n");
      out.write("                \"                        </li>\\n\" +\n");
      out.write("                \"                        <li>\\n\" +\n");
      out.write("                \"                            <span><i class=\\\"icon-minus-sign\\\"></i>部门员工</span>\\n\" +\n");
      out.write("                \"                            <ul>\\n\" +\n");
      out.write("                midinfo1+\n");
      out.write("                \"                            </ul>\\n\" +\n");
      out.write("                \"                        </li>\\n\" +\n");
      out.write("                \"                    </ul>\\n\" +\n");
      out.write("                \"                </li>\");\n");
      out.write("            info1.appendTo(\"#tree\");\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("    function to_page(){\n");
      out.write("        $.ajax({\n");
      out.write("            url:\"/department/list\",\n");
      out.write("            type:\"Post\",\n");
      out.write("            dataType:\"json\",\n");
      out.write("            success:function(result){\n");
      out.write("                console.log(result);\n");
      out.write("                build_emps_table(result.pageInfo);\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("    function infoshow(item,e){\n");
      out.write("       if(item==1)\n");
      out.write("       {\n");
      out.write("           var title=document.getElementById(\"updateModalLabel\");\n");
      out.write("           title.firstChild.nodeValue=\"公司介绍\";\n");
      out.write("           var b=\"<p>华信科技公司是一个优秀的科技公司，致力于计算机系统的开发！</p>\"\n");
      out.write("           var c=\"<p>联系电话:<u>112-03-123</u></p>\"\n");
      out.write("           $('#contenx').empty();\n");
      out.write("           $('#contenx').append(b).append(c);\n");
      out.write("           $('#config').empty();\n");
      out.write("           var d=\"<button type=\\\"submit\\\" class=\\\"btn btn-primary\\\" id=\\\"personSubmit\\\" data-dismiss=\\\"modal\\\">确认</button>\"\n");
      out.write("           $('#config').append(d);\n");
      out.write("           $('#updateModal').modal('show');\n");
      out.write("       }\n");
      out.write("        if(item==\"行政部\")\n");
      out.write("        {\n");
      out.write("            var title=document.getElementById(\"updateModalLabel\");\n");
      out.write("            title.firstChild.nodeValue=\"行政部介绍\";\n");
      out.write("            var b=\"<p>行政部主要负责，公式日常运作与办公监督！</p>\"\n");
      out.write("            var c=\"<p>联系电话:<u>112-03-128</u></p>\"\n");
      out.write("            $('#contenx').empty();\n");
      out.write("            $('#contenx').append(b).append(c);\n");
      out.write("            $('#config').empty();\n");
      out.write("            var d=\"<button type=\\\"submit\\\" class=\\\"btn btn-primary\\\" id=\\\"personSubmit\\\" data-dismiss=\\\"modal\\\">确认</button>\"\n");
      out.write("            $('#config').append(d);\n");
      out.write("            $('#updateModal').modal('show');\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    function staffchange2(e)\n");
      out.write("    {\n");
      out.write("        var info1=document.getElementById(\"sid\").firstChild.nodeValue;  //staffid\n");
      out.write("        var info2=document.getElementById(\"in4\").value; //部门\n");
      out.write("        var info3=document.getElementById(\"in5\").value;//职位\n");
      out.write("        $.ajax({\n");
      out.write("            url:\"/department/updatedeinfo\",\n");
      out.write("            data:{\"info1\":info1,\"info2\":info2,\"info3\":info3},\n");
      out.write("            type:\"post\",\n");
      out.write("            dataType:\"json\",\n");
      out.write("            success:function(result){\n");
      out.write("                build_emps_table(result.pageInfo);\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("    function staffchange(e)\n");
      out.write("    {\n");
      out.write("        var a=e.previousElementSibling.getElementsByTagName(\"a\").item(0).firstChild.nodeValue;\n");
      out.write("        var title=document.getElementById(\"updateModalLabel\");\n");
      out.write("        title.firstChild.nodeValue=\"人员调整\";\n");
      out.write("        var c=\"<a id='sid' style='display: none'>\"+a+\"</a>\";\n");
      out.write("        var f=\"<p id='sid' '>对工号为\"+a+\"的员工进行调整</p>\";\n");
      out.write("        var b=\" <form id=\\\"info\\\">\\n\" +\n");
      out.write("            \"        <div class=\\\"form-group\\\">\\n\" +\n");
      out.write("            \"        <label for=\\\"in4\\\">要调整的部门</label>\\n\" +\n");
      out.write("            \"        <select class=\\\"form-control\\\" id=\\\"in4\\\">\\n\" +\n");
      out.write("            \"        <option>行政部</option>\\n\" +\n");
      out.write("            \"        <option>开发部</option>\\n\" +\n");
      out.write("            \"        <option>财务部</option>\\n\" +\n");
      out.write("            \"        <option>销售部</option>\\n\" +\n");
      out.write("            \"        </select>\\n\" +\n");
      out.write("            \"        </div>\\n\" +\n");
      out.write("            \"        <div class=\\\"form-group\\\">\\n\" +\n");
      out.write("            \"        <label for=\\\"in5\\\">要调整的职位</label>\\n\" +\n");
      out.write("            \"        <select class=\\\"form-control\\\" id=\\\"in5\\\">\\n\" +\n");
      out.write("            \"        <option>部门负责人</option>\\n\" +\n");
      out.write("            \"        <option>员工</option>\\n\" +\n");
      out.write("            \"        </select>\\n\" +\n");
      out.write("            \"        </div>\\n\" +\n");
      out.write("            \"        </form>\"\n");
      out.write("        $('#contenx').empty();\n");
      out.write("        $('#contenx').append(c).append(f).append(b);\n");
      out.write("        $('#config').empty();\n");
      out.write("        var d=\"<button type=\\\"submit\\\" class=\\\"btn btn-primary\\\" onclick='staffchange2(this)' id=\\\"personSubmit\\\" data-dismiss=\\\"modal\\\">确认</button>\";\n");
      out.write("        var e=\"<button type=\\\"button\\\" class=\\\"btn btn-default\\\" data-dismiss=\\\"modal\\\">取消</button>\";\n");
      out.write("        $('#config').append(e).append(d);\n");
      out.write("        $('#updateModal').modal('show');\n");
      out.write("    }\n");
      out.write("    function addstaff2(result,item){\n");
      out.write("        var title=document.getElementById(\"updateModalLabel\");\n");
      out.write("        title.firstChild.nodeValue=item;\n");
      out.write("\n");
      out.write("        $('#contenx').empty();\n");
      out.write("        $('#config').empty();\n");
      out.write("        var bodymy=\"\";\n");
      out.write("        $.each(result,function(index,item){\n");
      out.write("            bodymy+=  \"<option>\"+item.staffId+\"</option>\\n\"\n");
      out.write("        });\n");
      out.write("        var empIdTD=$(\" <div class=\\\"form-group\\\">\\n\" +\n");
      out.write("            \"              <label for=\\\"ak\\\">选择待添加员工的工号</label>\\n\" +\n");
      out.write("            \"              <select class=\\\"form-control\\\" id=\\\"ak\\\">\\n\" +\n");
      out.write("            bodymy+\n");
      out.write("            \"              </select>\\n\" +\n");
      out.write("            \"          </div>\")\n");
      out.write("        var d=\"<button type=\\\"submit\\\" class=\\\"btn btn-primary\\\" onclick='addstaff3()' id=\\\"personSubmit\\\" data-dismiss=\\\"modal\\\">确认</button>\";\n");
      out.write("        var e=\"<button type=\\\"button\\\" class=\\\"btn btn-default\\\" data-dismiss=\\\"modal\\\">取消</button>\";\n");
      out.write("        $('#contenx').append(empIdTD)\n");
      out.write("        $('#config').append(d).append(e);\n");
      out.write("        $('#updateModal').modal('show');\n");
      out.write("    }\n");
      out.write("    function addstaff(e)\n");
      out.write("    {\n");
      out.write("        var b=e.previousElementSibling.childNodes[1].nodeValue;\n");
      out.write("        $.ajax({\n");
      out.write("            url:\"/department/deaddstaff\",\n");
      out.write("            type:\"post\",\n");
      out.write("            dataType:\"json\",\n");
      out.write("            success:function(result){\n");
      out.write("                if(result.stafflist==\"无空闲员工\")\n");
      out.write("                {\n");
      out.write("                    alert(\"无空闲员工！\")\n");
      out.write("                }\n");
      out.write("                else {\n");
      out.write("                    addstaff2(result.stafflist,b);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("    function addstaff3()\n");
      out.write("    {\n");
      out.write("        var title=document.getElementById(\"updateModalLabel\");\n");
      out.write("        var department=title.firstChild.nodeValue;\n");
      out.write("        var id=document.getElementById(\"ak\").value;\n");
      out.write("        $.ajax({\n");
      out.write("            url:\"/department/addnewemploy\",\n");
      out.write("            data:\"id=\"+id+\"&department=\"+department,\n");
      out.write("            type:\"post\",\n");
      out.write("            dataType:\"json\",\n");
      out.write("            success:function(result){\n");
      out.write("                to_page();\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
