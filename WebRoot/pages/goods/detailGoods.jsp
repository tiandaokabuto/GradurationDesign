<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>台山二作坊</title>


<!-- ZUI 标准版压缩后的 CSS 文件 -->
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/zui/1.8.1/css/zui.min.css">
<!-- ZUI Javascript 依赖 jQuery -->
<script
	src="//cdnjs.cloudflare.com/ajax/libs/zui/1.8.1/lib/jquery/jquery.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.8.1/js/zui.min.js"></script>

<link rel="stylesheet" href='<c:url value="/css/index.css"></c:url>' />
<script type="text/javascript"
	src='<c:url value="/js/materialize.min.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/js/index.bundle.js"></c:url>'></script>
<link rel="stylesheet"
	href='<c:url value="/css/materialize-icon.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/css/detail.css"></c:url>' />
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
				<a href="<c:url value="/homeGoods.action"/>" class="logo"> <em
					class="em1">台山</em> <em class="em2">二作坊</em> <em class="em3">Taishan.Market</em>
				</a>
				<div class="nav-wrapper search-bar">
					<form method="post"
						action='<c:url value="/searchGoods.action"></c:url>'>
						<div class="input-field">
							<input id="search" name="str" placeholder="搜点什么吧233..."
								style="height: 40px;" /> <label for="search" class="active">
								<i class="iconfont"></i>
							</label> <input type="submit" value="搜索">

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
								<a href="<c:url value="/pages/goods/pubGoods.jsp"></c:url>">我要发布</a>
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


	<!--显示商品详情-->
	<div ng-controller="detailBoxController"
		class="detail-box stark-components z-depth-1 row ng-scope">
		<div class="col s12 path">
			<a href="<c:url value="/categoryGoods.action"/>">${catelog.name}</a>
			<em>></em> <a>${goodsExtend.gname}</a>
		</div>
		<c:set value="${goodsExtend.imgList }" var="imgList"></c:set>
		<div class="col s6">
			<div class="slider" style="height: 440px;">
				<div id="myNiceCarousel" class="carousel slide" data-ride="carousel"
					style="height: 400px;width: 400px">
					<!-- 轮播项目 -->
					<div class="carousel-inner">
						<div class="item active">
							<img alt="First slide" src="/pic/${imgList[0].imgurl }"
								style="height: 400px;width: 400px">
						</div>

						<c:if test="${!empty imgList[1] }">
							<div class="item">
								<img alt="Second slide" src="/pic/${imgList[1].imgurl }"
									style="height: 400px;width: 400px">
							</div>
						</c:if>

						<c:if test="${!empty imgList[2] }">
							<div class="item">
								<img alt="Third slide" src="/pic/${imgList[2].imgurl }"
									style="height: 400px;width: 400px">
							</div>
						</c:if>
					</div>
					<!-- 项目切换按钮 -->
					<a class="left carousel-control" href="#myNiceCarousel"
						data-slide="prev"> <span class="icon icon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#myNiceCarousel"
						data-slide="next"> <span class="icon icon-chevron-right"></span>
					</a>
				</div>
			</div>
		</div>


		<div class="col s6">
			<h1 class="item-name">${goodsExtend.gname}</h1>
			<h2 class="item-price">${goodsExtend.newprice}</h2>

			<div class="item-public-info">
				<p>
					<i class="iconfont"></i> <em class="item-location">${goodsExtend.salereason }</em>
				</p>
			</div>
			<div class="publisher-info-title">
				<em>相关信息</em>
				<hr>
			</div>
			<c:if test="${empty user}">
				<div class="item-contact">
					<p class="not-login">
						<a href="<c:url value='/pages/user/login.jsp'/>">登录</a> <em>或</em>
						<a href="<c:url value='/pages/user/regist.jsp'/>">注册</a> <em>后查看联系信息</em>
					</p>
				</div>
			</c:if>
			<c:if test="${!empty user}">
				<div class="item-contact">
				
					<div>
						<div class="base-blue z-depth-1 attr">
							<i class="icon icon-check"></i>
						</div>
						<div class="value">商品成色：${goodsExtend.gcondition}</div>
					</div>
					<div>
						<div class="base-blue z-depth-1 attr">
							<i class="icon icon-check"></i>
						</div>
						<div class="value">商品来源：${goodsExtend.buyway}</div>
					</div>
					<div>
						<div class="base-blue z-depth-1 attr">
							<i class="icon icon-check"></i>
						</div>
						<div class="value">
							购买时间：<fmt:formatDate value="${goodsExtend.buytime}"
					pattern="yyyy-MM-dd HH:mm:ss" />
						</div>
					</div>
				
				
					<div>
						<div class="base-blue z-depth-1 attr">
							<i class="iconfont"></i>
						</div>
						<div class="value">
							卖家：<a  data-toggle="popover" title="联系方式" data-content="手机号:${saler.phone}<br>微信:${saler.wechat}<br>QQ:${saler.qq}" data-html="true">${saler.username}</a>
						</div>
					</div>
				</div>
			</c:if>

			<a class="btn btn-primary"
				href='<c:url value="/addCart.action?gid=${goodsExtend.gid }&uid=${user.uid }"></c:url>'>
			<i	class="icon icon-shopping-cart"></i>添加购物车</a>

			<h1 class="item-pub-time">
				发布于
				<fmt:formatDate value="${goodsExtend.starttime}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</h1>
		</div>
	</div>
	<div class="detail-box stark-components z-depth-1 row">
		<h1 class="title">商品详情</h1>
		<hr class="hr1" />
		<hr class="hr2" />
		<p class="section">${goodsExtend.gdescription}</p>
		<p class="section"></p>
		<p class="section"></p>
	</div>
	
</body>

<script type="text/javascript">
// 你需要手动进行初始化
$('[data-toggle="popover"]').popover();
</script>
</html>