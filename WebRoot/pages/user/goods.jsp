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
    	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   <link rel="stylesheet" href='<c:url value="/css/font-awesome.min.css"></c:url>' />
    <link rel="stylesheet" href='<c:url value="/css/emoji.css"></c:url>' />
    <link rel="stylesheet" href='<c:url value="/css/userhome.css"></c:url>' />
    <link rel="stylesheet" href='<c:url value="/css/user.css"></c:url>' />

</head>
<body>
<div class="pre-2" id="big_img">
    <img src="http://findfun.oss-cn-shanghai.aliyuncs.com/images/head_loading.gif" class="jcrop-preview jcrop_preview_s">
</div>
<div id="cover" style="min-height: 639px;">
    <div id="user_area">
        <div id="home_header">
            
            <a href='<c:url value="/homeGoods.action"></c:url>'>
                <div class="home"></div>
            </a>
        </div>
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
                <span class="name">${user.description }</span>
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
                <!--
                    作者：hlk_1135@outlook.com
                    时间：2017-05-11
                    描述：闲置商品展示
                -->
                <div class="share_content">
					<h1 style="text-align:center">我的物品</h1>
                    <c:if test="${empty goodsExtendList}">
                        <div class="no_share">
                            <span>没有任何内容，去逛逛其它的吧！</span>
                        </div>
                    </c:if>
                    <c:if test="${!empty goodsExtendList}">
                        <c:forEach var="goodsExtend" items="${goodsExtendList}">
                        <c:if test="${goodsExtend.state==1 }">
                            <div class="story">
                                <a href="" class="head_img">
                                     <img src="/pic/${goodsExtend.imgList[0].imgurl }">
                                </a>
                                <span class="name">${goodsExtend.gname}</span>
                                <span class="text" style="overflow: hidden; outline: none;">${goodsExtend.gdescription}</span>
                                <div class="box">
                                    <div class="box_content">
                                        <div class="left_shadow"></div>
                                        <div class="left" index="1" style="display: none;"><</div>
                                        <div class="right_shadow"></div>
                                        <div class="left" index="3" style="display: none;">></div>
                                         <img src="/pic/${goodsExtend.imgList[0].imgurl}" index="2">
                                         <span class="com" style="display: none;left: 396.733px;"></span>
                                    </div>
                                    <div class="interact">
                                        <span class="glyphicon glyphicon-cog"><a href="<c:url value="/editGoods.action?gid=${goodsExtend.gid }"/>">编辑</a></span>
                                       <%-- 	<span class="fa fa-share"><a href="">擦亮</a></span>
                                        <span class="fa fa-commenting"><a>${items.goods.commetNum}0</a></span>
                                        <span class="time">${items.goods.startTime}</span> --%>
                                        <span class="fa fa-trash"><a href="<c:url value="/deleteGoods.action?gid=${goodsExtend.gid }"/>">删除</a></span> 
                                        <c:if test="${goodsExtend.salestate==0 }">
                                        	<span class="glyphicon glyphicon-check">已出售</span> 
                                        </c:if>
                                        <c:if test="${goodsExtend.uploadstate==0 }">
                                        	<span class="glyphicon glyphicon-upload">待审核</span> 
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>