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

<title>My JSP 'index.jsp' starting page</title>

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
</head>
<script type="text/javascript">
	$('#contextMenuExample2').on('click', function(e) {
		$.zui.ContextMenu.show([ {
			label : '新建项目',
			onClick : function() {
				alert('你点击了新建项目');
			}
		}, {
			type : 'divider'
		}, {
			label : '复制',
		}, {
			label : '剪切',
		}, {
			label : '粘贴',
		} ], {
			event : e
		}, function() {
			console.log('上下文菜单已显示。');
		});
	});
</script>
<body>
	<button id="contextMenuExample2" type="button" class="btn btn-primary">点击按钮弹出上下文菜单</button>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr>
	<ul class="pager" data-ride="pager" data-page="2" data-rec-total="89"></ul>

	${msg }
	<table>
		<tr>
			<td><a href="<c:url value="/pages/user/login.jsp"/>">登录</a></td>
			<td><a href="<c:url value="/pages/user/regist.jsp"/>">注册</a></td>
			<td><a href="<c:url value="/homeGoods.jsp"/>">主页</a></td>
			<td><a href="<c:url value="/pages/admin/admin.jsp"/>">后台</a></td>
		</tr>

	</table>
	<i class="icon icon-plus-sign"></i>
	<br>
	<div class="switch">
		<input type="checkbox"> <label>夜间模式</label>
	</div>
	<br>

	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button"
			id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="true">
			Dropdown <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
			<li><a href="#">Action</a></li>
			<li><a href="#">Another action</a></li>
			<li><a href="#">Something else here</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Separated link</a></li>
		</ul>
	</div>
	<br>







</body>



</html>
