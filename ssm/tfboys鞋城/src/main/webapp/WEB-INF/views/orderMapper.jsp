<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>订单管理</title>
		<link rel="stylesheet" href="../css/index.css" />
		<link rel="stylesheet" href="../css/layui.css" />
		<script src="../js/jquery-3.4.1.js"></script>
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
							<span class="current">个人中心</span>
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
								账号管理
							</li>
							<li class="c_menu">
								<a href="/personal" id="grzx">个人中心</a>
							</li>
							<li class="c_menu">
								<a href="/updatePassword">修改密码</a>
							</li>
							<li class="c_menu">
								<a href="/address">地址管理</a>
							</li>
							<li class="c_menu">
								<a href="/toShopping" >我的购物车</a>
							</li>
							<li class="c_menu">
								<a href="javascript:;" class="choosed">订单管理</a>
							</li>
						</ul>
						<div id="Model" class="fl-right">
							<div id="content2" class="thiscontent" style="background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 1009px;">
								<p style="font-weight: bold;font-size: 13px;">订单管理</p>
								<table class="order_table">
									<tbody>
									<tr class="layui-form">
										<td width="120">
											<p>商品图</p>
										</td>
										<td width="150">
											<p>商品名</p>
										</td>
										<td width="150">
											<p>地址</p>
										</td>
										<td width="120">
											<p>鞋码</p>
										</td>
										<td class="goods_num" width="70">
											<p>金额</p>
										</td>
										<td class="goods_bag" width="150">
											<p>数量</p>
										</td>
										<td class="goods_money" width="100">
											<p>状态</p>
										</td>
										<td class="goods_money" width="150">
											<p>操作</p>
										</td>
									</tr>
									</tbody>
								</table>
								<div id="shopcarview" style="margin-bottom:20px;min-height: 900px;">
									<table class="order_table " style="height: 100px;">
										<tbody>
										<c:forEach items="${orderList}" var="list">
										<form>
											<tr class="layui-form" id="${list.getId()}">

												<td width="120" class="goodsdesc" activityid="null" activitytypeid="null" goodsid="6050"> <img src="${list.getImgUrl()}" class="img_wh"> </td>
												<td width="150" class="goodsdesc" goodsid="6050">
													<p class="goods_title cut-Text3"> ${list.getName()} <span class="c8b3734"></span> </p>
												</td>
												<td width="150" class="goodsdesc" goodsid="6050">
													<p class="goods_title cut-Text3"> ${list.getAddress()} <span class="c8b3734"></span> </p>
												</td>
												<td width="120" class="goodsdesc" style="">
													<span class="c8b3734">${list.getSize()}</span>
												</td>
												<td class="goods_num" width="70">
													<p>￥${list.getMoney()}</p>
												</td>
												<td class="goods_bag" width="150">
													<span class="c8b3734">${list.getAmount()}</span>
												</td>
												<td class="goods_bag" width="100">
													<c:choose>
														<c:when test="${list.getStatus() == 0}">
															<span class="c8b3734">待发货</span>
														</c:when>
														<c:when test="${list.getStatus() == 1}">
															<span class="c8b3734">待收货</span>
														</c:when>
														<c:when test="${list.getStatus() == 2}">
															<span class="c8b3734">已收货</span>
														</c:when>
														<c:when test="${list.getStatus() == 3}">
															<span class="c8b3734">退货中</span>
														</c:when>
														<c:when test="${list.getStatus() == 4}">
															<span class="c8b3734">已退货</span>
														</c:when>
														<c:when test="${list.getStatus() == 5}">
															<span class="c8b3734">已结束</span>
														</c:when>
														<c:when test="${list.getStatus() == 6}">
															<span class="c8b3734">已退款</span>
														</c:when>
													</c:choose>
												</td>
												<td class="goods_money" width="150" >

													<c:choose>
														<c:when test="${list.getStatus() == 0}">
															<p class="c8b3734 mart-10 cursorp" onclick="refund(${list.getId()},6)">退款
															</p>
														</c:when>
														<c:when test="${list.getStatus() == 1}">
															<p class="c8b3734 mart-10 cursorp" onclick="confing(${list.getId()},2)">收货
															</p>
														</c:when>
														<c:when test="${list.getStatus() == 2}">
															<p class="c8b3734 mart-10 cursorp" onclick="refunds(${list.getId()},3)">退货
															</p>
														</c:when>
													</c:choose>
												</td>
											</tr>
											</form>
										</c:forEach>

										</tbody>
									</table>
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
		function refund(e,data) {
			if(confirm('确定要退款吗')==true){
				$.ajax({
					url:"${request.getContextPath()}/refund?id="+ e +"&status="+data, // 请求路径
					type:"GET" , //请求方式
					//请求成功之后的回调
					success:function () {
						//data后台返回的json数据，已经帮你转换成JSON对象
						location.reload(true);
						//操作DOM ,把返回的数据解析出来，展示到页面上

					},
					dataType:"json"//设置接受到的响应数据的格式 text 普通的文本字符串
				});
			}
		}
		function confing(e,data) {
			if(confirm('确定要收货吗')==true){
				$.ajax({
					url:"${request.getContextPath()}/refund?id="+ e +"&status="+data, // 请求路径
					type:"GET" , //请求方式
					//请求成功之后的回调
					success:function () {
						//data后台返回的json数据，已经帮你转换成JSON对象
						location.reload(true);
						//操作DOM ,把返回的数据解析出来，展示到页面上

					},
					dataType:"json"//设置接受到的响应数据的格式 text 普通的文本字符串
				});
			}
		}
		function refunds(e,data) {
			if(confirm('确定要退货吗')==true){
				$.ajax({
					url:"${request.getContextPath()}/refund?id="+ e +"&status="+data, // 请求路径
					type:"GET" , //请求方式
					//请求成功之后的回调
					success:function () {
						//data后台返回的json数据，已经帮你转换成JSON对象
						location.reload(true);
						//操作DOM ,把返回的数据解析出来，展示到页面上

					},
					dataType:"json"//设置接受到的响应数据的格式 text 普通的文本字符串
				});
			}
		}
	</script>

</html>
