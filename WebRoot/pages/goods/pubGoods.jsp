<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>发布商品</title>
<link rel="stylesheet"
	href='<c:url value="/css/font-awesome.min.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/css/userhome.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/css/user.css"></c:url>' />
<script type="text/javascript"
	src='<c:url value="/js/jquery-3.1.1.min.js"></c:url>'></script>
<!-- bootstrap -->
<link rel="stylesheet"
	href='<c:url value="/css/bootstrap.min.css"></c:url>'>
<script type="text/javascript"
	src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
<!-- 图片上传即使预览插件 -->
<link rel="stylesheet"
	href='<c:url value="/css/fileinput.min.css"></c:url>'>
<script type="text/javascript"
	src='<c:url value="/js/fileinput.min.js"></c:url>'></script>	
<script type="text/javascript" src='<c:url value="/js/zh.js"></c:url>'></script>
<style>
.container {
	padding-top: 10px
}
</style>
</head>
<script type="text/javascript">

function validate_required(field,alerttxt)
{
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false}
  else {return true}
  }
}

function validate_form(thisform)
{
with (thisform)
  {
  	if (validate_required(gname,"物品名不能为空!")==false)
    {gname.focus();return false}
    if (validate_required(newprice,"售价不能为空!")==false)
    {newprice.focus();return false}
    if (validate_required(gcondition,"成色不能为空!")==false)
    {gcondition.focus();return false}
  }
}
</script>

<body>
	<div class="pre-2" id="big_img">
		<img
			src="http://findfun.oss-cn-shanghai.aliyuncs.com/images/head_loading.gif"
			class="jcrop-preview jcrop_preview_s">
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
	            描述：发布物品
        -->
			<div id="user_content">
				<div class="basic">
					<form action="<c:url value="/uploadGoods.action"/>" onsubmit="return validate_form(this)" method="post" 
						enctype="multipart/form-data">
						
						<h1>发布物品</h1>
						<hr />
						<div class="changeinfo">
							<span>物品名：</span> <input class="in_info" type="text" name="gname"
								placeholder="请输入物品名" /> <span>(*必填)</span>
						</div>
						<div class="changeinfo">
							<span>出售价格：</span> <input class="in_info" type="text"
								name="newprice" placeholder="请输入出售价格" /> <span>(*必填)</span>
						</div>
						<div class="changeinfo">
							<span>原价：</span> <input class="in_info" type="text"
								name="oldprice" placeholder="请输入商品原价" /> <span id="checkphone">(*选填,请如实填写)</span>
						</div>
						
						<div class="changeinfo">
							<span>来源：</span> <input class="in_info" type="text"
								name="buyway" placeholder="商品来源" /> <span id="checkphone"></span>
						</div>
						
						<div class="changeinfo">
							<span>地点：</span> 
<select class="in_info" name="salereason">
  <option value="台城">台城</option>
  <option value="大江">大江</option>
  <option value="水步">水步</option>
  <option value="四九">四九</option>
  <option value="都斛">都斛</option>
  <option value="赤溪">赤溪</option>
  <option value="冲蒌">冲蒌</option>
  <option value="斗山">斗山</option>
  <option value="广海">广海</option>
  <option value="川岛">川岛</option>
  <option value="端芬">端芬</option>
  <option value="海宴">海宴</option>
  <option value="汶村">汶村</option>
  <option value="三合">三合</option>
  <option value="北陡">北陡</option>
  <option value="深井">深井</option>
  <option value="白沙">白沙</option>
</select><span>(*必填)</span>							 
						</div>
						
						
						<div class="changeinfo">
							<span>成色：</span> <input class="in_info" type="text"
								name="gcondition" placeholder="商品成色" /> <span>(*必填)</span>
						</div>
						
						<div class="changeinfo">
							<span>物品类别：</span> <select class="in_info" name="cid">
								<option value="1">闲置数码</option>
								<option value="2">同城代步</option>
								<option value="3">电器日用</option>
								<option value="4">图书教材</option>
								<option value="5">闲置衣物</option>
								<option value="6">运动棋牌</option>
								<option value="7">饰品物件</option>
							</select>
						</div>
						<div class="changeinfo" id="dir">
							<span>商品描述：</span>
							<div class="sha">
								<div class="publ">
									<div class="pub_con">
										<div class="text_pu">
											<input type="text" name="gdescription" placeholder="商品描述"
												class="emoji-wysiwyg-editor" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<br />
						<hr />
						<div class="changeinfo">
							<span>商品图片：</span>
							<div class="container">
                            <div class="row">
                                <div class="col-sm-6 col-sm-offset-1">
                                    <div class="form-group">
                                        <div class="col-sm-10">
                                            <input type="file" name="myfiles" data-ref="myfile" class="col-sm-10 myfile" value="" multiple="multiple"/>
                                            <input type="hidden" name="myfiles" value="">
                                        </div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<input type="submit" class="setting-save" value="发布物品"
							style="margin-top: 20px;background-color: blue;" />
					</form>
			
				</div>
			</div>
		</div>
	</div>
	<script>
    $(".myfile").fileinput({
        	uploadUrl:"<c:url value="/uploadFile.action" />",//上传的地址
			uploadAsync : true, //默认异步上传
			showUpload : false, //是否显示上传按钮,跟随文本框的那个
			showRemove : false, //显示移除按钮,跟随文本框的那个
			showCaption : true,//是否显示标题,就是那个文本框
			showPreview : true, //是否显示预览,不写默认为true
			dropZoneEnabled : true,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
			maxFileCount : 3, //表示允许同时上传的最大文件个数
			enctype : 'multipart/form-data',
			validateInitialCount : true,
			previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
			msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
			allowedFileTypes : [ 'image' ],//配置允许文件上传的类型
			allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
			allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ],//控制被预览的所有mime类型
			language : 'zh'
		})
		
	</script>
</body>
</html>