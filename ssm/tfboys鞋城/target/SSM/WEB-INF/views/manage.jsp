<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>商品管理</title>
		<link rel="stylesheet" href="../css/index.css" />
		<link rel="stylesheet" href="../css/layui.css" />
		<script src="../js/jquery-3.4.1.js"></script>
		<style>
			h1, h2, h3, h4, h5, h6 {
			    font-family: "Microsoft YaHei",Arial,Helvetica,serif;
			    font-weight: 700;
			    line-height: 2em;
			    -webkit-font-smoothing: antialiased;
			    font-smoothing: antialiased;
			}
			article .post-meta {
			    padding-left: 0;
			}
			article {
			    text-align: left !important;
				margin:15px 0;
			}
			article .post-meta li {
			    margin-right: 5px;
			}
			ul.post-meta li {
			    display: inline-block;
			    margin-right: 6px;
			    color: #ccc;
			    font-size: 10px;
			    text-transform: uppercase;
			}
			.styled {
			    border-radius: 5px;
			    box-shadow: #c4c1c1 1px 1px 5px 5px;
			    overflow: hidden;
			}
			.big-posts .big-item article figure, .big-posts .big-item article header.entry-header {
			    float: left;
			    width: 250px;
			    margin-right: 20px;
			}
			
			.posts-loop figure.post-image {
			    display: block;
			    position: relative;
			    overflow: hidden;
			    min-height: 20px;
			    max-height: 100%;
			}
			figure.animated-overlay figcaption:hover {
				display: block;
				opacity: 1;
				filter: alpha(opacity=0);
				text-align: center;
				z-index: 1;
			}
			header.entry-header {
				
				float: left;
				width: 250px;
				margin-right: 20px;
			    position: relative;
			    padding: 10px;
			    margin-bottom: 5px;
			    text-align: center;
			}
			figure img {
			    width: 100%;
			    border-radius: 5px 5px 0 0;
			}
			figure.animated-overlay figcaption, figure.animated-overlay>a {
			    height: 100%;
			    width: 100%;
			    position: absolute;
			    top: 0;
			    left: 0;
			}
			figure.post-image {
			    display: block;
			    position: relative;
			    overflow: hidden;
				margin-left: 20px;
			    min-height: 20px;
			    max-height: 100%;
			}
			.entry-content {
			    margin-left: 300px;
			    margin-top: 5px;
			}
			h3.entry-title {
			    position: relative;
				margin-top: 30px;
			    max-height: 3em;
			    overflow: hidden;
			}
			h3.entry-title a {
			    overflow: hidden;
			    text-overflow: ellipsis;
			    white-space: nowrap;
			    width: 100%;
			}
			.entry-content h3.entry-title {
			    margin: 15px 0px;
			    font-size: 18px;
			}
			figure.animated-overlay figcaption {
			    display: block;
			    opacity: 0;
			    filter: alpha(opacity=0);
			    text-align: center;
			    z-index: 10;
			    background-image: url(../img/crease.svg);
			    background-size: cover;
			    background-position: center center;
			    -webkit-backface-visibility: hidden;
			    -moz-backface-visibility: hidden;
			    backface-visibility: hidden;
			    -webkit-transition: -webkit-transform .3s, opacity .3s;
			    -moz-transition: -moz-transform .3s, opacity .3s;
			    transition: transform .3s, opacity .3s;
			    border-radius: 5px 5px 0 0;
			    background-color: rgba(0, 0, 0, .4);
			}
			.post-excerpt {
			    position: relative;
			    font-size: 12px;
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
							<a href="/index/" class="logo"><img src="../img/logo.JPEG"></a>
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
							<span class="current">商品管理</span>
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
								<a href="/classifyManage">分类管理</a>
							</li>
							<li class="c_menu">
								<a href="javascript:;"  class="choosed">商品管理</a>
							</li>
							<li class="c_menu">
								<a href="/adminOrder">订单管理</a>
							</li>
						</ul>
						<div id="Model" class="fl-right">
							<div id="content2" class="thiscontent" style="background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 409px;">
								<p style="font-weight: bold;font-size: 13px;">商品管理</p>
								<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
									<c:forEach items="${goodsList}" var="list">

										<article class="styled">
											<header class="entry-header">
												<a href="/goods?id=${list.getId()}">
													<figure style="width: 250px;height:138px;" class="post-image animated-overlay overlay-alt">
														<img width="100%" height="100%" class="lazyload" src="${list.getImgUrl()}" alt="">
														<figcaption>
														</figcaption>
													</figure>
												</a>
											</header>
											<div class="entry-content">
												<div class="post-heading">
													<h3 class="entry-title"><a href="/goods?id=${list.getId()}" rel="bookmark">${list.getName()}</a></h3>
													<ul id="${list.getId()}" class="post-meta entry-meta">
														<li>卖家:${list.getSeller()}</li>
														<li class="author">分类：<span>${list.getClassify()}</span></li>
														<li ><a href="/toUpdateGoods?id=${list.getId()}" class="update">修改</a></li>
														<li ><a href="#" class="delete">删除</a></li>
													</ul>
												</div>
												<div class="post-excerpt">
													<p class="note">${list.getContent()}</p>
												</div>
											</div>
										</article>
									</c:forEach>
								</div>
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
		$('.delete').click(function(e){
			if(confirm('确定要删除吗')==true){
				$.ajax({
					url:"${request.getContextPath()}/deleteGoods?id="+e.currentTarget.parentNode.parentNode.id , // 请求路径
					type:"GET" , //请求方式
					//请求成功之后的回调
					success:function (data) {
						//data后台返回的json数据，已经帮你转换成JSON对象
						if (data > 0) {
							location.reload(true);
						}else {
							alert("出错啦...")
						}
						//操作DOM ,把返回的数据解析出来，展示到页面上

					},//响应成功后的回调函数
					//表示如果请求响应出现错误，会执行的回调函数
					error:function () {
						alert("出错啦...")
					},
					dataType:"json"//设置接受到的响应数据的格式 text 普通的文本字符串
				});
			}
		})
	</script>
</html>
