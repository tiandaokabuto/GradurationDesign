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
			<div class="item vertical open active" >
				<a> <i class="icon icon-user"></i> <span>用户管理</span> <span
					class="arrow"></span>
				</a>
				<div class="vertical-menu">
					<a href="<c:url value="/findAllUser.action"/>" class="active">查看用户</a>  
				</div>
			</div>
			<div class="item vertical">
				<a> <i class="icon icon-shopping-cart"></i> <span>订单管理</span> <span
					class="arrow"></span>
				</a>
				<div class="vertical-menu">
					<a href="<c:url value="/findAllOrders.action"/>">查看订单</a>
				</div>
			</div>
		</div>
		</aside>
		<div class="main-content">
			<div class="wrapper"> 
		<form action="<c:url value="/adminUpdateUserSubmit.action"/>">
		id:<input type="text" class="form-control" placeholder="id" value="${user.uid }" name="uid"><br>
		用户名:<input type="text" class="form-control" placeholder="用户名" value="${user.username }" name="username"><br>
		密码:<input type="text" class="form-control" placeholder="密码" value="${user.password }" name="password"><br>
		email:<input type="text" class="form-control" placeholder="email" value="${user.email }" name="email"><br>
		QQ:<input type="text" class="form-control" placeholder="QQ" value="${user.qq }" name="qq"><br>
		微信:<input type="text" class="form-control" placeholder="微信" value="${user.wechat }" name="wechat"><br>
		个人描述:<input type="text" class="form-control" placeholder="个人描述" value="${user.description }" name="description"><br>
		激活状态:<input type="text" class="form-control" placeholder="激活状态" value="${user.sta }" name="sta"><br>
		激活码:<input type="text" class="form-control" placeholder="激活码" value="${user.code }" name="code"><br>
		使用状态:<input type="text" class="form-control" placeholder="使用状态" value="${user.usestate }" name="usestate"><br>
						<input type="submit"  class="btn btn-primary"></a>
			</form>					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="admincss/js/admin.js"></script>
	<script type="text/javascript">

		function updateUser() {
			
			document.userForm.action = "<c:url value='/updateUser.action'/>";
			document.userForm.submit();
			alert("编辑用户");
		}
		function deleteUser() {
		
			document.userForm.action = "<c:url value='/deleteUser.action'/>";
			document.userForm.submit();
			alert("删除用户");
		}
	</script>
</body>
</html>
