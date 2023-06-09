<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,user-scalable=no,minimal-ui">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/asset-favico.ico">
    <title>个人主页</title>
    <link rel="stylesheet" href="../css/page-health-index.css" />
    <link rel="stylesheet" href="../css/page-health-login.css" />
    <link rel="stylesheet" href="../plugins/elementui/index.css" />
    <script src="../plugins/jquery/dist/jquery.min.js"></script>
    <script src="../plugins/healthmobile.js"></script>
    <script src="../plugins/vue/vue.js"></script>
    <script src="../plugins/vue/axios-0.18.0.js"></script>
    <script src="../plugins/elementui/index.js"></script>
</head>
<body data-spy="scroll" data-target="#myNavbar" data-offset="150">
<div class="app">
    <!-- 页面头部 -->
    <div class="top-header">
        <span class="f-left" style="margin-top: 15px"><i class="icon-back" onclick="history.go(-1)"></i></span>
        <span class="center"><%=session.getAttribute("tou")%>游客你好！</span>
        <span class="f-right" style="margin-top: 15px"><i class="icon-more"></i></span>
    </div>
    <div class="carousel">
        <div class="banner-roll">
            <div class="banner-item">
                <div class="item" style="background-image: url(../img/info1.png);"><img src="../img/info1.png" alt="" style="width: 787px;height: 350px"></div>
                <div class="item" style="background-image: url(../img/info2.png);"><img src="../img/info2.png" alt="" style="width: 787px;height: 350px"></div>
                <div class="item" style="background-image: url(../img/info3.png);"><img src="../img/info3.png" alt="" style="width: 787px;height: 350px"></div>
            </div>
            <div class="indicators"></div>
        </div>
    </div>
    <!-- 页面内容 -->
    <div class="contentBox" style="background: #8c939d">
        <div class="list-column2">
            <ul class="list">
                <li class="type-item">
                    <a href="/pages/setmeal5.jsp" class="link-page">
                        <div class="type-title">
                            <h3>招聘申请</h3>
                            <p>申请职位</p>
                        </div>
                        <div class="type-icon">
                            <i class="icon-zhen">
                                <span class="path1"></span><span class="path2"></span>
                            </i>
                        </div>
                    </a>
                </li>
                <li class="type-item">
                    <a href="/pages/setmeal6.jsp" class="link-page">
                        <div class="type-title">
                            <h3>申请信息</h3>
                            <p>申请结果查询</p>
                        </div>
                        <div class="type-icon">
                            <i class="icon-plus"><span class="path1"></span><span class="path2"></span></i>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <div class="top-header" style="margin-top: 95px">
            <span class="center">华信科技有限公司</span>
        </div>
    </div>
</div>
<script>
    $(function() {
        var ht = $('.banner-item').find('img').eq(0).height()
        var tg = $('.banner-item .item');
        var num = 0;
        for (i = 0; i < tg.length; i++) {
            $('.indicators').append('<span></span>');
            $('.indicators').find('span').eq(num).addClass('active');
        }
        $(".banner-item,.banner-roll").css('height', ht)

        function roll() {
            tg.eq(num).animate({
                'opacity': '1',
                'z-index': num
            }, 2000).siblings().animate({
                'opacity': '0',
                'z-index': 0
            }, 2000);
            $('.indicators').find('span').eq(num).addClass('active').siblings().removeClass('active');
            if (num >= tg.length - 1) {
                num = 0;
            } else {
                num++;
            }
        }
        $('.indicators').find('span').click(function() {
            num = $(this).index();
            roll();
        });
        var timer = setInterval(roll, 3000);
        $('.banner-item').mouseover(function() {
            clearInterval(timer)
        });
        $('.banner-item').mouseout(function() {
            timer = setInterval(roll, 3000)
        });
    })
    $(window).resize(function() {
        var ht = $('.banner-item').find('img').eq(0).height()
        $(".banner-item,.banner-roll").css('height', ht)
    });
</script>
</body>
</html>
