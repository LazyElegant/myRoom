<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>分类管理</title>
		<link rel="stylesheet" href="../css/index.css" />
		<link rel="stylesheet" href="../css/layui.css" />
		<script src="../js/jquery-3.4.1.js"></script>
		<style>
			button[type=submit]:hover {
				background: #181616;
				color: #fff;
				cursor: pointer;
			}
			button[type=submit] {
				background: #FC5A5A;
				color: #fff;
				padding: 16px 25px;
				font-size: 12px;
				font-weight: 700;
				line-height: 1em;
				text-align: center;
				text-transform: uppercase;
				-webkit-transition: all .3s ease-out;
				-moz-transition: all .3s ease-out;
				transition: all .3s ease-out;
				border: 0;
				overflow: hidden;
			}
			.ify li {
				font-size: 19px;
				margin: 15px 15px 25px;
			}
			.ify {
				width: 320px;
			}
			.ify li button {
				float: right;
				line-height: 5px;
				margin-left: 15px;
				padding: 13px;
			}
		</style>
	</head>
	<body>
		<div>			
			<!-- 页头 -->
			<div class="container header">
				<div class="m_right">
					<div class="top-links">
						<a href="#">主题鞋城官网</a>
					</div>
					<div class="top-links">
						<a href="#">联系我们</a>
					</div>
					<c:choose>
						<c:when test="${sessionScope.user != null}">
							<a href="/personal">${sessionScope.user.getUsername()}</a>
							<a href="/outLogin">退出登录</a>
							<c:if test="${sessionScope.user.getStatus() == 1}">
								<a href="/shelves">后台管理</a>
							</c:if>
						</c:when>
						<c:otherwise>
							<a href="/toLogin">登录</a>
							<a href="/toRegistered">注册</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
			<div class="content-bgimg">
				<!-- 导航条 -->
				<div class="menu" style="position: relative;top: 0px;">
					<div class="menu-container">
						<div class="container">
							<a href="/" class="logo"><img src="img/logo.JPEG"></a>
							<ul class="el-menu">
								<c:forEach items="${sessionScope.Classify}" var="classify">

									<a href="/listByClass?id=${classify.getId()}&page=1">
										<li class="el-menu-item" value="${classify.getId()}" >${classify.getName()}</li>
									</a>
								</c:forEach>
							</ul>
							<div class="nav-phone">客服电话 0573-88731088</div>
						</div>
					</div>
					<div class="title-desc-container bread-crumbs">
						<div class="container">
							<a href="/index/" class="nuxt-link-active">首页</a>
							<svg style="width: 10px;height: 10px;" t="1639369195722" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1866" width="200" height="200"><path d="M761.6 489.6l-432-435.2c-9.6-9.6-25.6-9.6-35.2 0-9.6 9.6-9.6 25.6 0 35.2l416 416-416 425.6c-9.6 9.6-9.6 25.6 0 35.2s25.6 9.6 35.2 0l432-441.6C771.2 515.2 771.2 499.2 761.6 489.6z" p-id="1867" fill="#ffffff"></path></svg>
							<span class="current">分类管理</span>
						</div>
					</div>
				</div>
			</div>
			<div id="content" style="background-color: #f2f2f2;">
				<div class="mauto" style="width: 1166px;padding-bottom: 20px;">
					<div class="clearfix">
						<ul id="left_nav" class="fl-left bgfff">
							<li class="p_menu">
								<img src="../img/person_icon2.png" alt="">
								后台管理
							</li>
							<li class="c_menu">
								<a href="/shelves" id="grzx">上架商品</a>
							</li>
							<li class="c_menu">
								<a href="javascript:;" class="choosed">分类管理</a>
							</li>
							<li class="c_menu">
								<a href="/manage" >商品管理</a>
							</li>
							<li class="c_menu">
								<a href="/adminOrder">订单管理</a>
							</li>
						</ul>
						<div id="Model" class="fl-right">
							<div id="content2" class="thiscontent" style="background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 409px;">
								<p style="font-weight: bold;font-size: 13px;">分类管理</p>
								<button type="submit" id="addfix">添加类别</button>
								<ul class="ify">
									<c:forEach items="${classifyList}" var="list">
										<li id="${list.getId()}"><a href="#">${list.getName()}</a><button type="submit" class="update"> 修改 </button><button type="submit" class="detele"> 删除 </button></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
				<div id="footer">
						<div class="container">
							<h3 class="text-center">联系我们</h3>
				            <div class="row">
				                <div class="col-md-4">
				                    <h3><bold>Address</bold></h3>
				                    <h5>福建省厦门市集美区xxx号</h5>
				                </div>
				                <div class="col-md-4">
				                    <h3><bold>Send Us A Message:</bold></h3>
				                    <h5>xxx@qq.com</h5>
				                </div>
				                <div class="col-md-4">
				                    <h3><bold>QQ：</bold></h3>
				                    <h5>xxxxxxxxxxxx</h5>
				                </div>
							</div>
						</div>
						<div class="contact">
							<div class="container">
								<a href="templates/contact.html">寻求帮助吗?</a>
							</div>
						</div>
					</div>
			</div>
			
			
			
			
		</div>
		
	</body>
	
	<script>
		$("#addfix").click(function (){
			var  tn = prompt("输入新的类别");
			if(tn !== null) {
				document.location.href = "http://localhost:8080/addClassify?name=" + tn;
			}
		})
		$(".detele").click(function (){
			if(confirm("确定删除该分类?")){
				var  id = $(this).parent().attr('id');
				document.location.href =   "http://localhost:8080/deleteClasses?id=" + id;
			}
		})
		$(".update").click(function () {
			var  tn = prompt("输入新的类别名");
			if(tn !== null){
				var  id = $(this).parent().attr('id');
				document.location.href = "http://localhost:8080/updateClasses?id=" + id + "&name=" + tn;
			}
		})
		</script>
</html>
