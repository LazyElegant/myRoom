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
	<body style="background-color: #f2f2f2;">
	<nav class="top ">
		<input type="text" class="search" id="numbers" placeholder="输入订单号查询"/><input id="cx" type="submit" />
		<p class="item">
			<a href="/index">首页</a>
		</p>
		<img class="logo" src="../img/login_logo_v5.png">

		<p class="item">
			<a href="/toAddExpress">添加快递</a>
		</p>
		<p class="item">
			<a href="/manage">快递管理</a>
		</p>
		<p class="item">
			<a href="/out">退出登录</a>
		</p>
	</nav>
		<div class="mauto" style="width: 1366px;padding-bottom: 20px;">
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
	<script>
		$("#cx").click(function () {
			console.log($("#numbers").val());
			document.location.href =   "${request.getContextPath()}/getExpress?id="+ $("#numbers").val();
		})
	</script>
</html>
