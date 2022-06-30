<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<style>
		body {
			background: #f7fafc;
		}
		.log-head {
			margin-top: 110px;
			text-align: center;
		}
		.form-container {
			width: 360px;
			margin: 0 auto;
			font-size: 14px;
			padding: 0 20px 0;
		}

		.form-container h3 {
			margin: 16px 0;
			text-align: center;
			font-size: 20px;
			font-weight: normal;
		}
		.form-container form {
			background: #FFF;
			display: block;
			padding: 10px 20px 0;
			border: 1px solid #e7ebef;
		}
		.form-ctrl {
			position: relative;
			padding: 10px 0;
			border-bottom: 1px solid #e7ebef;
		}
		.form-ctrl input {
			width: 100%;
			background: #FFF;
			outline: none;
			border: none;
			font-size: 16px;
		}
		.btn-submit {
			padding: 0.8em 0;
			display: block;
			width: 100%;
			background: #fd7f24;
			color: #FFF;
			text-align: center;
			font-size: 16px;
			outline: none;
			border: none;
			margin-top: 10px;
			border-radius: 3px;
			cursor: pointer;
		}
		.type {
			padding: 10px;
		}
		.type a {
			padding: 0 16px;
		}

		.fr {
			float: right;
		}
		a {
			outline: none;
			text-decoration: none;
			color: #3278e6;
		}
	</style>
</head>
<body>

<div class="log-head">
	<img src="../img/login_logo_v5.png" alt="">
</div>

<div class="form-container">
	<h3 >创建你的快递100账号</h3>
	<p style="color: red;text-align: center" id="passwordTip"></p>
	<form action="/registered" method="post">
		<div class="form-ctrl">
			<input type="text" placeholder="用户名" name="name" id="name" >
		</div>
		<div class="form-ctrl">
			<input type="password"  onchange="checkPassword()" placeholder="请输入密码" name="password" id="user_password"  >
		</div>
		<div class="form-ctrl">
			<input type="password"  onchange="checkConfirmPassword()" placeholder="确认密码" name="cr_password" id="confirm_password" >
		</div>
		<input type="submit" style="display: none;" id="dl" />
	</form>
	<button class="btn-submit" id="submit" >注册</button>
	<div class="type">
		<a  class="fr" href="/toLogin">已有账号，去登录</a>
	</div>
</div>
</body>
</html>

<script>
	document.getElementById("submit").onclick = function(){
		document.getElementById("dl").click();
	}
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
</body>
</html>