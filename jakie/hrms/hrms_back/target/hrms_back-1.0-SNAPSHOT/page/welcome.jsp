<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="shortcut icon" href="/public/logo.ico" type="image/x-icon" />
        <link rel="stylesheet" href="/public/css/font.css">
        <link rel="stylesheet" href="/public/css/xadmin.css">
    </head>
    <body>
    <div class="x-body layui-anim layui-anim-up">
        <%@page import="java.util.*"%>
        <%@page import="java.text.*"%>
        <%@ page import="com.chailong.pojo.Administer" %>
        <%
            String datetime=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E").format(Calendar.getInstance().getTime());
        %>
        <blockquote class="layui-elem-quote">欢迎管理员：
            <span class="x-red"><%=session.getAttribute("adminname")%></span>！当前时间:<%=datetime%></blockquote>
        <fieldset class="layui-elem-field">
            <legend>数据统计</legend>
            <div class="layui-field-box">

            </div>
        </fieldset>
        <fieldset class="layui-elem-field">
            <legend>系统通知</legend>
            <div class="layui-field-box">
                <table class="layui-table" lay-skin="line">
                    <tbody>
                        <tr>
                            <td >
                                <a class="x-a"target="_blank">华信科技有限公司于2018年正式上市！</a>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <a class="x-a" target="_blank">交流qq群:(5419492808)</a>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <a class="x-a" target="_blank">华信科技有限公司市值突破300亿</a>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <a class="x-a" target="_blank">华信科技有限公司于深圳正式成立</a>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <a class="x-a" target="_blank">华信科技联系电话123213131</a>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <a class="x-a" target="_blank">交流qq群:(5419492808)</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </fieldset>
        <blockquote class="layui-elem-quote layui-quote-nm">欢迎你的加入！</blockquote>
    </div>
        <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
    </body>
</html>