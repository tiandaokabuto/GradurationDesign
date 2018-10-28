<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>admin</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="admincss/css/zui.css">
<link rel="stylesheet" type="text/css"
	href="admincss/css/theme/zui-theme-green.css">
<link rel="stylesheet" type="text/css" href="admincss/css/style.css">
<script type="text/javascript" src="admincss/lib/jquery/jquery.js"></script>
<script type="text/javascript" src="admincss/js/zui.js"></script>
<link href="dist/lib/datatable/zui.datatable.min.css" rel="stylesheet">
<script src="dist/lib/datatable/zui.datatable.min.js"></script>
</head>

<body>
	<div class="main">
		<header class="header">
		<div class="header-left">
			<div class="sidebar-toggle">
				<i class="icon icon-bars"></i>
			</div>
			<div class="logo">
				<span class="text-primary">同城二作坊</span>
			</div>
		</div>
		<div class="header-user">
			<div class="item dropdown">
				<span class="badge label label-dot label-danger"></span> <i
					class="icon icon-comments"></i>
			</div>
			<div class="item dropdown">
				<span class="badge label label-dot label-warning"></span> <i
					class="icon icon-bell-alt"></i>
			</div>
			<div class="item dropdown">
				<span data-toggle="dropdown"> <i class="icon icon-user"></i>
					<span>${adminuser.adminusername }</span> <span class="caret"></span>
				</span>
				<!-- <ul class="dropdown-menu pull-right">
					<li><a href="">修改头像</a></li>
					<li><a href="">修改资料</a></li>
					<li class="divider"></li>
					<li><a href="">注销</a></li>
				</ul> -->
			</div>
		</div>
		</header>
		<aside class="sidebar">
		<div class="sidebar-menu">
			<div class="item">
				<a href="<c:url value="/findAllGoods.action"/>"> <i class="icon icon-dashboard"></i> <span>主页</span>
				</a>
			</div>
			<div class="item">
				<a> <i class="icon icon-bell-alt"></i> <span>消息中心</span>
				</a>
			</div>
			<div class="item vertical ">
				<a> <i class="icon icon-server"></i> <span>商品管理</span> <span
					class="arrow"></span>
				</a>
				<div class="vertical-menu">
					<a href="<c:url value="/findAllGoods.action"/>">查看商品</a>
				</div>
			</div>
			<div class="item vertical" >
				<a> <i class="icon icon-user"></i> <span>用户管理</span> <span
					class="arrow"></span>
				</a>
				<div class="vertical-menu">
					<a href="<c:url value="/findAllUser.action"/>">查看用户</a>  
				</div>
			</div>
			<div class="item vertical  open active">
				<a> <i class="icon icon-shopping-cart"></i> <span>订单管理</span> <span
					class="arrow"></span>
				</a>
				<div class="vertical-menu">
					<a href="<c:url value="/findAllOrders.action"/>"  class="active">查看订单</a>
				</div>
			</div>
		</div>
		</aside>
		<div class="main-content">
			<div class="wrapper">
				
					<div class="panel-heading">
						<h5>订单管理</h5>
					</div>

						<form action="" method="post" name="aaa">
							<!-- <div class="search">
								搜索名称： <input type="text" class="text" name="topic"
									placeholder="搜索名称" style="width:150px;"> 
								
								<button type="submit" value="查询"
									class="btn btn-primary-outline btn-xs">
									<i class="icon-search"></i>&nbsp;查询
								</button>
							</div> -->
						 
						<table class="table datatable">
							<thead>
								<tr>
									<th>订单ID</th>
									<th>关联用户ID</th>
									<th>创建时间</th>
									<th>总价</th>
									<th>状态</th>
									<th>地址</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${ordersList }" var="order">					
								<tr>
									<td>${order.oid }</td>
									<td>${order.uid }</td>
									<td>${order.otime }</td>
									<td>${order.total }</td>
									<td>${order.state }</td>
									<td>${order.address }</td>
									<td class="text-center">
									 <i><a type="button"
											class="btn btn-sm btn-success" href="<c:url value="/adminUpdateOrder.action?oid=${order.oid }"/>"
											>编辑</a></i> 
									<i><a type="button"
											class="btn btn-sm btn-success" href="<c:url value="/adminfindItemsByOid.action?oid=${order.oid }"/>"
											>查看条目</a></i>  
									</td>	

								</tr>
								
							</c:forEach>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	<script type="text/javascript" src="admincss/js/admin.js"></script>
	<script type="text/javascript">
	$('[data-toggle="popover"]').popover();
	</script>
</body>
</html>
