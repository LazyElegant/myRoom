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
								<a href="/toAddHotel"><li class="el-menu-item">添加酒店信息</li></a>
								<a href="/manage"><li class="el-menu-item">酒店信息管理</li></a>
								<a href="/updatePassword"><li class="el-menu-item">${sessionScope.user.getName()}</li></a>
								<a href="/out"><li class="el-menu-item">退出登录</li></a>
							
						</ul>
					</div>
				</div>
			</div>

			<div class="index-banner">
				<div class="carousel_item is_active" style="background:url(../img/9777e857d6df2802.jpg)  no-repeat center center;background-size: 100%;"></div>
			</div>
		</div>

		<div class="mauto" style="width: 1366px;padding-bottom: 20px;">
			<div class="clearfix">
				<div id="Model">
					<form method="post" action="/insertHotel" style="text-align: center">

						<h3>酒店名</h3>
						<input name="name" class="form-control" type="text" id="btn">
						<h3>酒店地址</h3>
						<input name="address" class="form-control" type="text">
						<h3>酒店负责人</h3>
						<input name="principal" class="form-control" type="text">
						<h3>负责人电话</h3>
						<input name="phone" class="form-control" type="text">
						<br>
						<input type="submit" class="submit" value="添加" >
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
