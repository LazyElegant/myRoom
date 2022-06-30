<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改密码</title>
		<link rel="stylesheet" href="../css/index.css" />
		<link rel="stylesheet" href="../css/layui.css" />
		<script src="../js/jquery-3.4.1.js"></script>
		<style>
			button {
			    background: #FC5A5A;
			    color: #fff;
			    padding: 16px 25px;
				cursor:pointer;
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
			button:hover{
				background:#000000;
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
							<a href="/personal?${sessionScope.user.getId()}">${sessionScope.user.getUsername()}</a>
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
								<a href="/personal" id="grzx" >个人中心</a>
							</li>
							<li class="c_menu">
								<a href="/updatePassword" class="choosed">修改密码</a>
							</li>
							<li class="c_menu">
								<a href="/address">地址管理</a>
							</li>
							<li class="c_menu">
								<a href="/toShopping" >我的购物车</a>
							</li>
							<li class="c_menu">
								<a href="/orderMapper" id="ddgl">订单管理</a>
							</li>
						</ul>
						<div id="Model" class="fl-right">
							<div id="content2" class="thiscontent" style="background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 209px;">
								<p style="font-weight: bold;font-size: 13px;">修改密码</p>
								<form action="/updatepaw" method="post" style="width: 600px;height: 200px;margin: 40px 40px;font-size: 18px;">
									<p style="color: red;text-align: center">${msg}</p>
									原密码: <br /><input class="oldPassword" name="oldPassword" type="password" style="width: 300px;font-size: 18px;padding: 2px;margin: 2px;" /><br />
									新密码: <br /><input name="newPassword" id="newPassword" type="password" style="width: 300px;font-size: 18px;padding: 2px;margin: 2px;" /><br />

									确认密码: <span id="confirmPasswordTip" style="color:red;font-size: 12px;"></span><br /><input onchange="checkConfirmPassword()" id="cleckPassword" name="confirm" type="password" style="width: 300px;font-size: 18px;padding: 2px;margin: 2px;" /><br />
									<button style="margin: 40px 120px;" type="submit">提交</button>
								</form>
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

	function checkConfirmPassword(){
		let password = document.getElementById("newPassword").value;
		let confirmPassword = document.getElementById("cleckPassword").value;
		if (password !== confirmPassword) {
			document.getElementById("confirmPasswordTip").innerHTML="密码不一致";
		}else{
			document.getElementById("confirmPasswordTip").innerHTML="";
		}
	}


	$(function () {
		var tt= ${tt};
		if (tt===123) {
			alert("更新成功！！")
		}
	})
</script>
</html>
<br />