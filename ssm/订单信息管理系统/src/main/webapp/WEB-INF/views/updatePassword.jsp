<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/index.css" />
		<script src="../js/jquery-3.4.1.js"></script>
	</head>
	<body style="background-color: #f2f2f2;">
	<nav class="nav ">
		<div class="w ">
			<div class="navitems ">
				<ul>
					<li class="cb"><a href="/index">首页</a></li>
					<li class="sq"><a href="/toAddOrder">新增订单</a></li>

					<li class="wd "><a href="/manage">订单管理</a></li>
					<li class="my "><a href="/updatePassword">${sessionScope.user.getName()}</a></li>
					<li class="my "><a href="/out">退出登录</a></li>

				</ul>
			</div>
		</div>
	</nav>
		<div class="mauto" style="width: 1166px;padding-bottom: 20px;">
			<div class="clearfix">
				<div id="Model">
					<div id="content2" class="thiscontent" style="background-color: #fff;padding: 20px;padding-bottom:0;min-height: 409px;">
						<form action="/updatepaw" method="post" style="width: 600px;height: 200px;margin: 40px 40px;font-size: 18px;">
							<p style="color: red;text-align: center">${msg}</p>
							原密码: <br><input class="oldPassword" name="oldPassword" type="password" style="width: 300px;font-size: 18px;padding: 2px;margin: 2px;"><br>
							新密码: <br><input name="newPassword" id="newPassword" type="password" style="width: 300px;font-size: 18px;padding: 2px;margin: 2px;"><br>

							确认密码: <span id="confirmPasswordTip" style="color:red;font-size: 12px;"></span><br><input onchange="checkConfirmPassword()" id="cleckPassword" name="cleckPassword" type="password" style="width: 300px;font-size: 18px;padding: 2px;margin: 2px;"><br>
							<button style="margin: 40px 120px;" type="submit">提交</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>

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
				<a href="#">寻求帮助吗?</a>
			</div>
		</div>
	</div>
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
