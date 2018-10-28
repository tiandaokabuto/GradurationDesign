<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" href='<c:url value="/css/font-awesome.min.css"></c:url>' />
    <link rel="stylesheet" href='<c:url value="/css/emoji.css"></c:url>' />
    <link rel="stylesheet" href='<c:url value="/css/userhome.css"></c:url>' />
    <link rel="stylesheet" href='<c:url value="/css/user.css"></c:url>' />
</head>
<body>

<div id="cover" style="min-height: 639px;">
        <!--
            作者：hlk_1135@outlook.com
            时间：2017-05-10
            描述：左侧个人中心栏
        -->
        <div id="user_nav">
            <div class="user_info">
                <div class="head_img">
                    <img src="<%=basePath%>img/photo.jpg">
                </div>
                <div class="big_headimg">
                    <img src="">
                </div>
                <span class="name">${user.username}</span>
                <span class="school">台城</span>
                <span class="name">${user.email }</span>
            </div>
            <div class="home_nav">
                <ul>
                    <a href="">
                        <li class="notice">
                            <div></div>
                            <span>我的消息</span>
                            <strong></strong>
                        </li>
                    </a>
                    <a href='<c:url value="/pages/user/password.jsp"></c:url>'>
                        <li class="fri">
                            <div></div>
                            <span>修改密码</span>
                            <strong></strong>
                        </li>
                    </a>
                    <a href='<c:url value="/pages/user/basic.jsp"></c:url>'>
                        <li class="set">
                            <div></div>
                            <span>个人设置</span>
                            <strong></strong>
                        </li>
                    </a>
                    <a href='<c:url value="/pages/goods/pubGoods.jsp"></c:url>'>
                        <li class="store">
                            <div></div>
                            <span>发布物品</span>
                            <strong></strong>
                        </li>
                    </a>
                    <a href='<c:url value="/allGoods.action"></c:url>'>
                        <li class="second">
                            <div></div>
                            <span>我的物品</span>
                            <strong></strong>
                        </li>
                    </a>
                </ul>
            </div>
        </div>
        <!--
            作者：hlk_1135@outlook.com
            时间：2017-05-10
            描述：右侧内容区域
        -->
        <div id="user_content">
            <div class="share">
                <div class="publish">
                    <div class="pub_content">
                        
                    </div>
                   
                </div>
                <!--
                    作者：hlk_1135@outlook.com
                    时间：2017-05-11
                    描述：闲置商品展示
                -->
                <div class="share_content">
                    <div class="no_share">
                        <span>没有任何内容，去逛逛其它的吧！</span>
                    </div>
                </div>
            </div>
            <!--
                作者：hlk_1135@outlook.com
                时间：2017-05-10
                描述：最右侧，可能认识的人
            -->
            <div class="recommend">
                <div class="title">
                    <span class="text">可能认识的人</span>
                    <span class="change">换一组</span>
                    <span class="underline"></span>
                </div>
                <ul>
                    <li>
                        <a href="" class="head_img">
                            <img src="<%=basePath%>img/photo1.jpg">
                        </a>
                        <span>Brudce</span>
                        <div class="fa fa-plus-square"></div>
                    </li>
                    <li>
                        <a href="" class="head_img">
                            <img src="<%=basePath%>img/photo2.jpg">
                        </a>
                        <span>Graham</span>
                        <div class="fa fa-plus-square"></div>
                    </li>
                    <li>
                        <a href="" class="head_img">
                            <img src="<%=basePath%>img/photo3.jpg">
                        </a>
                        <span>lalala</span>
                        <div class="fa fa-plus-square"></div>
                    </li>
                    <li>
                        <a href="" class="head_img">
                            <img src="<%=basePath%>img/photo4.jpg">
                        </a>
                        <span>Danger-XFH</span>
                        <div class="fa fa-plus-square"></div>
                    </li>
                    <li>
                        <a href="" class="head_img">
                            <img src="<%=basePath%>img/photo5.jpg">
                        </a>
                        <span>Keithw</span>
                        <div class="fa fa-plus-square"></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>