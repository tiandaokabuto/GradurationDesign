<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人设置</title>
<link rel="stylesheet"
	href='<c:url value="/css/font-awesome.min.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/css/emoji.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/css/userhome.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/css/user.css"></c:url>' />
</head>
<body>
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
					<span class="name">${user.username}</span> <span class="school">台城xxxx</span>
					<span class="name">${user.description }</span>
				</div>
				<div class="home_nav">
					<ul>
						<a href="">
							<li class="notice">
								<div></div> <span>我的消息</span> <strong></strong>
						</li>
						</a>
						<a href='<c:url value="/pages/user/password.jsp"></c:url>'>
							<li class="fri">
								<div></div> <span>修改密码</span> <strong></strong>
						</li>
						</a>
						<a href='<c:url value="/pages/user/basic.jsp"></c:url>'>
							<li class="set">
								<div></div> <span>个人设置</span> <strong></strong>
						</li>
						</a>
						<a href='<c:url value="/pages/goods/pubGoods.jsp"></c:url>'>
							<li class="store">
								<div></div> <span>发布物品</span> <strong></strong>
						</li>
						</a>
						<a href='<c:url value="/allGoods.action"></c:url>'>
							<li class="second">
								<div></div> <span>我的物品</span> <strong></strong>
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
			<form action='<c:url value="/updatePassword.action"></c:url>'>
				<div id="user_content">
					<div class="basic">
						<h1>修改密码</h1>
						<hr />
						<div class="changeinfo">
							<span>原始密码:</span> <input class="in_info" type="text"
								name="password" /> <span>(*必填)</span> 
						</div>
						<hr />
						<div class="changeinfo">
							<span>新密码:</span> <input class="in_info" type="text"
								name="firstPassword" /> <span>(*必填)</span>
						</div>
						<hr />
						<div class="changeinfo">
							<span>重新输入:</span> <input class="in_info" type="text"
								name="secondPassword" /> <span>(*必填)</span>
						</div>
						<hr />
<div><p>${msg }</p></div>
<div><c:if test="${errors!=null }">
				<c:forEach items="${errors }" var="error">
			${error.defaultMessage }
				</c:forEach>
			</c:if></div>
						<input type="submit" class="setting-save" value="保存修改信息" />
						
					</div>
					</div>
			</form>

			
			
		</div>
</body>
</html>