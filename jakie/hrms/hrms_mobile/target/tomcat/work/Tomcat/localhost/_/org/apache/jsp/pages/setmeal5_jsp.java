/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-09-21 09:08:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class setmeal5_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<html lang=\"zh-CN\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,user-scalable=no,minimal-ui\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <link rel=\"icon\" href=\"../img/asset-favico.ico\">\n");
      out.write("    <title>申请职位</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/page-health-login.css\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"../plugins/elementui/index.css\" />\n");
      out.write("    <script src=\"../plugins/healthmobile.js\"></script>\n");
      out.write("    <script src=\"../plugins/vue/vue.js\"></script>\n");
      out.write("    <script src=\"../plugins/vue/axios-0.18.0.js\"></script>\n");
      out.write("    <script src=\"../plugins/elementui/index.js\"></script>\n");
      out.write("    <script src=\"https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("    <link href=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body data-spy=\"scroll\" data-target=\"#myNavbar\" data-offset=\"150\">\n");
      out.write("<div class=\"app\" id=\"app\" style=\"background: #f2f2f2\">\n");
      out.write("    <!-- 页面头部 -->\n");
      out.write("    <div class=\"top-header\">\n");
      out.write("        <span class=\"f-left\"><i class=\"icon-back\" onclick=\"history.go(-1)\"></i></span>\n");
      out.write("        <span class=\"center\">修改个人信息</span>\n");
      out.write("        <span class=\"f-right\"><i class=\"icon-more\"></i></span>\n");
      out.write("    </div>\n");
      out.write("    <!-- 页面内容 -->\n");
      out.write("    <div class=\"contentBox\" style=\"background: #f2f2f2\">\n");
      out.write("\n");
      out.write("        <div style=\"background: #f2f2f2;margin-left: auto;margin-right: auto;width: 500px;margin-top: 100px\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"info1\" class=\"col-sm-2 control-label\">申请账号</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"info1\" readonly=\"readonly\" value=\"");
      out.print(session.getAttribute("tou"));
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"info2\" class=\"col-sm-2 control-label\">申请姓名</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"info2\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"info3\" class=\"col-sm-2 control-label\">申请性别</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <select class=\"form-control\" id=\"info3\">\n");
      out.write("                            <option>男</option>\n");
      out.write("                            <option>女</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"info4\" class=\"col-sm-2 control-label\">申请年龄</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"info4\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"info5\" class=\"col-sm-2 control-label\">学历背景</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"info5\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"info6\" class=\"col-sm-2 control-label\">身份证号</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"info6\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"info7\" class=\"col-sm-2 control-label\">个人地址</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"info7\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"info8\" class=\"col-sm-2 control-label\">联系电话</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"info8\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"button\" id=\"myButton1\" data-loading-text=\"修改\"\n");
      out.write("                        class=\"btn btn-primary\"style=\"width: 300px;margin-left: 100px\" onclick=\"applyinfo()\">\n");
      out.write("                        提交\n");
      out.write("                </button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"top-header\" style=\"margin-top: 100px\">\n");
      out.write("        <span class=\"center\">华信科技公司</span>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!-- 页面 css js -->\n");
      out.write("<script src=\"../plugins/vue/vue.js\"></script>\n");
      out.write("<script src=\"../plugins/vue/axios-0.18.0.js\"></script>\n");
      out.write("<!--<script src=\"../js/page-health-order.js\"></script>-->\n");
      out.write("<script>\n");
      out.write("    function applyinfo(){\n");
      out.write("        var arr=new Array(8);\n");
      out.write("        for (var i=1;i<9;i++){\n");
      out.write("            var k=\"info\"+i;\n");
      out.write("            var info=document.getElementById(\"\"+k).value;\n");
      out.write("            arr[i-1]=info;\n");
      out.write("        }\n");
      out.write("        $.ajax({\n");
      out.write("            url: \"/tourist/applyinfo\",\n");
      out.write("            type: \"post\",\n");
      out.write("            async: false,   //同步\n");
      out.write("            dataType: \"json\",\n");
      out.write("            data: {\"account\":arr[0],\"applyname\":arr[1],\"applysex\":arr[2],\"applyage\":arr[3]\n");
      out.write("                ,\"applyeducation\":arr[4],\"applyidcard\":arr[5],\"applyaddress\":arr[6]\n");
      out.write("                ,\"applyphonenumber\":arr[7],\"applystatue\":\"待审核\"},\n");
      out.write("            success: function (result) {\n");
      out.write("                alert(result);\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</body>");
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
