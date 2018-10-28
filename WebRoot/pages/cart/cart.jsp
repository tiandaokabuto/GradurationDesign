<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	src='<c:url value="/js/jquery.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/js/materialize.min.js"></c:url>'></script>
<script type="text/javascript"
	src='<c:url value="/js/index.bundle.js"></c:url>'></script>
<link rel="stylesheet"
	href='<c:url value="/css/materialize-icon.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/css/detail.css"></c:url>'/>  
  </head>
  
  <body>
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
						</label> 

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
								<li><a href='<c:url value="/myorders.action"></c:url>'>我的订单</a></li>
								<li><a href='<c:url value="/pages/cart/cart.jsp"></c:url>'>购物车</a></li>
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
  
<div class="detail-box stark-components z-depth-1 row">
		<h1 class="title">商品详情</h1>
		<hr class="hr1" />
		<hr class="hr2" />
<p class="section">
<table class="table table-striped">
  <thead>
    <tr>
      <th>商品图片</th>
      <th>商品名称</th>
      <th>商品价格</th>
      <th>商品数量</th>
      <th>小计</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${sessionScope.cart.cartItems }" var="cartItem">
	<tr>
		<td><div><img src="/pic/${cartItem.goodsExtend.imgList[0].imgurl }" style="height: 100px;width: 100px"/></div></td>
		<td>${cartItem.goodsExtend.gname }</td>
		<td>${cartItem.goodsExtend.newprice }</td>
		<td>${cartItem.count }</td>
		<td>${cartItem.subtotal }</td>
		<td><a href='<c:url value="/deleteCartItem.action?gid=${cartItem.goodsExtend.gid }"></c:url>'>删除</a></td>
	</tr>
</c:forEach>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			合计：${sessionScope.cart.total }元
		</td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a id="buy" href="<c:url value='/addOrders.action'/>">购买</a>
			<a href='<c:url value="/clearCart.action"></c:url>'>清空购物车</a>
		</td>
	</tr>
  </tbody>
</table>	
</div>
</body>

</html>