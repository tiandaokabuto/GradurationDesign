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
    <meta charset="utf-8" />
    <title>台山二作坊</title>
    <link rel="stylesheet" href='<c:url value="/css/index.css"></c:url>' />
    <script type="text/javascript" src='<c:url value="/js/jquery.js"></c:url>' ></script>
    <script type="text/javascript" src='<c:url value="/js/materialize.min.js"></c:url>' ></script>
    <script type="text/javascript" src='<c:url value="/js/index.bundle.js"></c:url>' ></script>
    <link rel="stylesheet" href='<c:url value="/css/materialize-icon.css"></c:url>' />
    <script>
 
    </script>
<body ng-view="ng-view">
<!--
    作者：hlk_1135@outlook.com
    时间：2017-05-05
    描述：顶部
-->
<div ng-controller="headerController"
		class="header stark-components navbar-fixed ng-scope">
		<nav class="white nav1">
			<div class="nav-wrapper">
				<a href="<c:url value="/homeGoods.action"></c:url>" class="logo"> <em class="em1">台山</em> <em class="em2">二作坊</em>
					<em class="em3">Taishan.Market</em>
				</a>
				<div class="nav-wrapper search-bar">
					<form method="post"
						action='<c:url value="/searchGoods.action"></c:url>'>
						<div class="input-field">
							<input id="search" name="str" placeholder="搜点什么吧233..."
								style="height: 40px;" /> 
							<label for="search" class="active">
								<i class="iconfont"></i>
							</label>
							<input type="submit" value="搜索">
						</div>
					</form>
				</div>
				<ul class="right">
					<c:if test="${empty user}">
						<li class="publish-btn">
							<button ng-click="showLogin()" data-position="bottom"
								data-delay="50" data-tooltip="需要先登录哦！"
								class="red lighten-1 waves-effect waves-light btn"
								data-tooltip-id="510d3084-e666-f82f-3655-5eae4304a83a">我要发布</button>
						</li>
					</c:if>
					<c:if test="${!empty user}">
						<li class="publish-btn">
							<button data-position="bottom"
								class="red lighten-1 waves-effect waves-light btn">
								<a href="'<c:url value="/pages/goods/pubGoods.jsp"></c:url>'">我要发布</a>
							</button>
						</li>
						<li><a href="<c:url value="/allGoods.action"/>">我发布的商品</a></li>
						<li><a>${user.username}</a></li>
						<li class="notification"><i ng-click="showNotificationBox()"
							class="iconfont"></i>
							<div ng-show="notification.tagIsShow"
								class="notification-amount red lighten-1 ng-binding ng-hide">0
							</div></li>
						<li class="changemore"><a class="changeMoreVertShow()"> <i
								class="iconfont"></i>
						</a>
							<div class="more-vert">
								<ul class="dropdown-content">
									<li><a href='<c:url value="/allGoods.action"></c:url>'>个人中心</a></li>
									<li><a>消息</a></li>
									<li><a href='<c:url value="/mybuyorders.action"></c:url>'>我的购买订单</a></li>
									<li><a href='<c:url value="/mysaleorders.action"></c:url>'>我的出售订单</a></li>									<li><a href='<c:url value="/pages/cart/cart.jsp"></c:url>'>购物车</a></li>
									<li><a href="<c:url value="/logout.action"/>">退出登录</a></li>
								</ul>
							</div></li>
					</c:if>
					<c:if test="${empty user}">
						<li><a href="<c:url value='/pages/user/login.jsp'/>">登录</a></li>
						<li><a href="<c:url value='/pages/user/regist.jsp'/>">注册</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
<!--
    作者：hlk_1135@outlook.com
    时间：2017-05-05
    描述：左侧导航条
-->
<div 
		class="sidebar stark-components ng-scope">
		<li ><a href="<c:url value=""/>" class="index">
				<img src="<c:url value="/img/index.png"/>"> <em>最新发布</em>
		</a></li>
		<li ><a href="<c:url value="/categoryGoods.action?cid=1"/>"
			class="digital"> <img src="<c:url value="/img/digital.png"/>" /> <em>闲置数码</em>
		</a></li>
		<li ><a href="<c:url value="/categoryGoods.action?cid=2"/>" class="ride">
				<img src="<c:url value="/img/ride.png"/>" /> <em>同城代步</em>
		</a></li>
		<li ><a href="<c:url value="/categoryGoods.action?cid=3"/>" class="commodity"> 
			<img src="<c:url value="/img/commodity.png"/>" /> <em>电器日用</em>
		</a></li>
		<li ><a href="<c:url value="/categoryGoods.action?cid=4"/>" class="book">
				<img src="<c:url value="/img/book.png"/>" /> <em>图书教材</em>
		</a></li>
		<li ><a href="<c:url value="/categoryGoods.action?cid=5"/>"
			class="makeup"> <img src="<c:url value="/img/makeup.png"/>" /> <em>闲置衣物</em>
		</a></li>
		<li ><a href="<c:url value="/categoryGoods.action?cid=6"/>" class="sport">
				<img src="<c:url value="/img/sport.png"/>" /> <em>运动棋牌</em>
		</a></li>
		<li ><a href="<c:url value="/categoryGoods.action?cid=7"/>"
			class="smallthing"> <img src="<c:url value="/img/smallthing.png"/>" /> <em>服饰物件</em>
		</a></li>
		<div class="info">
			<a href="" target="_blank">关于我</a><em>-</em> <a href="">联系我们</a>
			<p>©2018 WJJ</p>
		</div>
	</div>
<!--
    作者：hlk_1135@outlook.com
    时间：2017-05-05
    描述：右侧显示部分
-->
<div class="main-content">
    <!--
        作者：hlk_1135@outlook.com
        时间：2017-05-05
        描述：最新发布
    -->
    <div class="index-title">
        <a href="">${category.cname}</a>
        <hr class="hr1">
        <hr class="hr2">
    </div>
    <div class="waterfoo stark-components row">
        <div class="item-wrapper normal">
            <c:forEach var="goodsExtend" items="${goodsExtendList}">
            <c:set value="${goodsExtend.imgList }" var="img"></c:set>
                <div class="card col">
                    <a href="<c:url value="/detailGoods.action?gid=${goodsExtend.gid }"/>">
                        <div class="card-image">
                            <img src="/pic/${img[0].imgurl}" />
                        </div>
                        <div class="card-content item-price"><c:out value="${goodsExtend.newprice}"></c:out></div>
                        <div class="card-content item-name">
                            <p><c:out value="${goodsExtend.gname}"></c:out></p>
                        </div>
                        <div class="card-content item-location">
                            <p>台山</p>
                            <p><c:out value="${goodsExtend.starttime}"></c:out></p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>