<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>登录</title>
	<link rel="stylesheet" href="../css/index.css" />
	<script src="../js/jquery-3.4.1.js"></script>
</head>
<body>
<div>
	<div class="content-bgimg">
		<!-- 导航条 -->
		<div class="menu">
			<div class="menu-container">
				<div class="container">
					<a href="/index" class="logo"><img style="width: 100%;" src="../img/0546fa01d6c53f51d35380222b8c9eee.jpeg"></a>
					<ul class="el-menu">
						<a href="/index"><li class="el-menu-item">首页</li></a>
						<a href="/toLogin"><li class="el-menu-item">登录</li></a>
						<a href="/toRegistered"><li class="el-menu-item">注册</li></a>
					</ul>
				</div>
			</div>
		</div>

		<!-- 轮播图 -->
		<div class="index-banner">
			<div class="carousel_item is_active" style="background:url(../img/9777e857d6df2802.jpg)  no-repeat center center;background-size: 100%;"></div>
		</div>
	</div>
</div>

<div id="Model">
	<form style="text-align: center" action="/registered" method="post">
		<p style="color: red;text-align: center" id="passwordTip"></p>
		<h3>注册</h3>
		<div class="form-ctrl">
			<input class="form-control"  type="text" placeholder="用户名" name="name" id="name" >
		</div>
		<div class="form-ctrl">
			<input class="form-control" onchange="checkPassword()" type="password" placeholder="请输入密码" name="password" id="user_password"  >
		</div>
		<div class="form-ctrl">
			<input class="form-control" onchange="checkConfirmPassword()" type="password" placeholder="确认密码" name="cr_password" id="confirm_password" >
		</div>
		<input type="submit" class="submit" value="提交">
	</form>
</div>

</body>
<script>
	function checkPassword(){
		let password = document.getElementById("user_password").value;
		if (password.length<6 || password.length>18){
			document.getElementById("passwordTip").innerHTML="密码位数为6-18之间";
		}else{
			document.getElementById("passwordTip").innerHTML="";
		}
	}
	function checkConfirmPassword(){
		let password = document.getElementById("user_password").value;
		let confirmPassword = document.getElementById("confirm_password").value;
		if (password !== confirmPassword) {
			document.getElementById("passwordTip").innerHTML="密码不一致";
		}else{
			document.getElementById("passwordTip").innerHTML="";
		}
	}
</script>
</html>