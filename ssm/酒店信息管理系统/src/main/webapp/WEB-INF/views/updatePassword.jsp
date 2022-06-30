<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="../css/index.css" />
		<script src="../js/jquery-3.4.1.js"></script>
	</head>
	<body>
		<div class="content-bgimg">
			<!-- 导航条 -->
			<div class="menu">
				<div class="menu-container">
					<div class="container">
						<a href="/index" class="logo"><img style="width: 100%;" src="../img/0546fa01d6c53f51d35380222b8c9eee.jpeg"></a>
						<ul class="el-menu">
							<a href="/index"><li class="el-menu-item">首页</li></a>
							<c:if test="${sessionScope.user == null}">
								<a href="/toLogin"><li class="el-menu-item">登录</li></a>
								<a href="/toRegistered"><li class="el-menu-item">注册</li></a>
							</c:if>
							<c:if test="${sessionScope.user != null}">
								<a href="/toAddHotel"><li class="el-menu-item">添加酒店信息</li></a>
								<a href="/manage"><li class="el-menu-item">酒店信息管理</li></a>
								<a href="/updatePassword"><li class="el-menu-item">${sessionScope.user.getName()}</li></a>
								<a href="/out"><li class="el-menu-item">退出登录</li></a>
							</c:if>
						</ul>
					</div>
				</div>
			</div>

			<!-- 轮播图 -->
			<div class="index-banner">
				<div class="carousel_item is_active" style="background:url(../img/9777e857d6df2802.jpg)  no-repeat center center;background-size: 100%;"></div>
			</div>
		</div>
		<div class="mauto" style="width: 1366px;padding-bottom: 20px;">
			<div class="clearfix">
				<div id="Model">
					<form action="/updatepaw" method="post" style="text-align: center">
						<p style="color: red;text-align: center">${msg}</p>
						原密码: <br><input class="oldPassword form-control" name="oldPassword" type="password"><br>
						新密码: <br><input name="newPassword" class=" form-control" id="newPassword" type="password"><br>

						确认密码: <span id="confirmPasswordTip" style="color:red;font-size: 12px;"></span><br><input onchange="checkConfirmPassword()" class=" form-control" id="cleckPassword" name="cleckPassword" type="password"><br>
						<button class="submit" type="submit">提交</button>
					</form>
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
	</script>
</html>
