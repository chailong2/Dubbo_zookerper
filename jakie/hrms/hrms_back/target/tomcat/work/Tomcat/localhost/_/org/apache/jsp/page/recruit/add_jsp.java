/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-05-02 05:08:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page.recruit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>招聘审批</title>\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi\" />\n");
      out.write("    <link rel=\"shortcut icon\" href=\"/public/logo.ico\" type=\"image/x-icon\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"/public/css/font.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/public/css/xadmin.css\">\n");
      out.write("    <script type=\"text/javascript\" src=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("    <link href=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js\"></script>\n");
      out.write("    <script src=\"https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/locales/bootstrap-datepicker.zh-CN.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"/public/lib/layui/layui.js\" charset=\"utf-8\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"/public/lib/layui/css/layui.css\" charset=\"utf-8\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"/public/js/xadmin.js\"></script>\n");
      out.write("    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("    <script src=\"https://cdn.staticfile.org/html5shiv/r29/html5.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <script src=\"/clockpicker/dist/jquery-clockpicker.min.js\"></script>\n");
      out.write("    <link href=\"/clockpicker/dist/jquery-clockpicker.min.css\" rel=\"stylesheet\">\n");
      out.write("    <![endif]-->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"x-nav\">\n");
      out.write("      <span class=\"layui-breadcrumb\">\n");
      out.write("        <a href=\"\">首页</a>\n");
      out.write("        <a>\n");
      out.write("          <cite>待审批列表</cite></a>\n");
      out.write("      </span>\n");
      out.write("    <a class=\"layui-btn layui-btn-small\" style=\"line-height:1.6em;margin-top:3px;float:right\" onclick=\"refresh()\" title=\"刷新\">\n");
      out.write("        <i class=\"layui-icon\" style=\"line-height:30px\">ဂ</i></a>\n");
      out.write("</div>\n");
      out.write("<div style=\"margin-left: auto;margin-right: auto;width: 1100px\">\n");
      out.write("<table class=\"table table-hover\" id=\"emps_table\">\n");
      out.write("    <caption>审批表</caption>\n");
      out.write("    <thead>\n");
      out.write("    <tr>\n");
      out.write("        <th>申请人账号</th>\n");
      out.write("        <th>申请人姓名</th>\n");
      out.write("        <th>申请人性别</th>\n");
      out.write("        <th>申请人年龄</th>\n");
      out.write("        <th>学历背景</th>\n");
      out.write("        <th>申请职位</th>\n");
      out.write("        <th>身份证号</th>\n");
      out.write("        <th>个人地址</th>\n");
      out.write("        <th>联系电话</th>\n");
      out.write("        <th>审批</th>\n");
      out.write("    </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        //1.页面加载完成后，直接发送一个ajax请求，要求分页数据\n");
      out.write("        $(function(){\n");
      out.write("            to_page();\n");
      out.write("        });\n");
      out.write("        function refresh(){\n");
      out.write("            to_page();\n");
      out.write("        }\n");
      out.write("        function build_emps_table(result){\n");
      out.write("            //构建之前都清空table表格!!!!!!!\n");
      out.write("            $(\"#emps_table tbody\").empty();\n");
      out.write("            $.each(result,function(index,item){\n");
      out.write("                var info1=$(\"<td></td>\").append(item.account);\n");
      out.write("                var info2=$(\"<td></td>\").append(item.applyname);\n");
      out.write("                var info3=$(\"<td></td>\").append(item.applysex);\n");
      out.write("                var info4=$(\"<td></td>\").append(item.applyage);\n");
      out.write("                var info5=$(\"<td></td>\").append(item.applyeducation);\n");
      out.write("                var info6=$(\"<td></td>\").append(item.appplyduty);\n");
      out.write("                var info7=$(\"<td></td>\").append(item.applyidcard);\n");
      out.write("                var info8=$(\"<td></td>\").append(item.applyaddress);\n");
      out.write("                var info9=$(\"<td></td>\").append(item.applyphonenumber);\n");
      out.write("                var delBtn=$(\"<td class=\\\"td-manage\\\">\"\n");
      out.write("                    +\"<a title='同意'  onclick='pass(this)'>\"\n");
      out.write("                    +\"<i class='layui-icon'>&#xe605;</i>\"\n");
      out.write("                    +\"</a>\"\n");
      out.write("                    +\"<a title='拒绝'   onclick='refuse(this)'>\"\n");
      out.write("                    +\"<i class='layui-icon '>&#x1006;</i>\"\n");
      out.write("                    +\"</a>\"\n");
      out.write("                    +\"</td>\");\n");
      out.write("                var emaduty=$(\"<td></td>\").append(item.attendancetime);\n");
      out.write("                $(\"<tr></tr>\")\n");
      out.write("                    .append(info1)\n");
      out.write("                    .append(info2)\n");
      out.write("                    .append(info3)\n");
      out.write("                    .append(info4)\n");
      out.write("                    .append(info5)\n");
      out.write("                    .append(info6)\n");
      out.write("                    .append(info7)\n");
      out.write("                    .append(info8)\n");
      out.write("                    .append(info9)\n");
      out.write("                    .append(delBtn)\n");
      out.write("                    .appendTo(\"#emps_table tbody\");\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("        function to_page(){\n");
      out.write("            $.ajax({\n");
      out.write("                url:\"/theapply/getAllapplyinfo\",\n");
      out.write("                type:\"Post\",\n");
      out.write("                dataType:\"json\",\n");
      out.write("                success:function(result){\n");
      out.write("                    //1.解析并显示员工数据\n");
      out.write("                    build_emps_table(result.applyinfo);\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("       function pass(e)\n");
      out.write("       {\n");
      out.write("           var account=e.parentNode.parentNode.childNodes[0].firstChild.nodeValue;  //获得节点值;\n");
      out.write("           $.ajax({\n");
      out.write("               url:\"/theapply/passapply\",\n");
      out.write("               data:\"account=\"+account,\n");
      out.write("               type:\"Post\",\n");
      out.write("               dataType:\"json\",\n");
      out.write("               success:function(result){\n");
      out.write("                   //1.解析并显示员工数据\n");
      out.write("                   build_emps_table(result.applyinfo);\n");
      out.write("\n");
      out.write("               }\n");
      out.write("           });\n");
      out.write("\n");
      out.write("       }\n");
      out.write("       function refuse(e)\n");
      out.write("       {\n");
      out.write("           var account=e.parentNode.parentNode.childNodes[0].firstChild.nodeValue;  //获得节点值;\n");
      out.write("           $.ajax({\n");
      out.write("               url:\"/theapply/refuseapply\",\n");
      out.write("               data:\"account=\"+account,\n");
      out.write("               type:\"Post\",\n");
      out.write("               dataType:\"json\",\n");
      out.write("               success:function(result){\n");
      out.write("                   //1.解析并显示员工数据\n");
      out.write("                   build_emps_table(result.applyinfo);\n");
      out.write("\n");
      out.write("               }\n");
      out.write("           });\n");
      out.write("       }\n");
      out.write("    </script>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        input{\n");
      out.write("            border:none;\n");
      out.write("            width:100px;\n");
      out.write("            height:30px;\n");
      out.write("            box-radius:25%;\n");
      out.write("            outline:medium;\n");
      out.write("            text-align:center;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</div>\n");
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
