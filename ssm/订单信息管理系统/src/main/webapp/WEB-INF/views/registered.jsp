<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>注册</title>

	<style>
		*,
		*:before,
		*:after{
			padding: 0;
			margin: 0;
			box-sizing: border-box;
		}
		body{
			background-color: #080710;
		}
		.background{
			width: 430px;
			height: 620px;
			position: absolute;
			transform: translate(-50%,-50%);
			left: 50%;
			top: 50%;
		}
		.background .shape{
			height: 200px;
			width: 200px;
			position: absolute;
			border-radius: 50%;
		}
		.shape:first-child{
			background: linear-gradient(
					#1845ad,
					#23a2f6
			);
			left: -80px;
			top: -80px;
		}
		.shape:last-child{
			background: linear-gradient(
					to right,
					#ff512f,
					#f09819
			);
			right: -30px;
			bottom: -80px;
		}
		form{
			height: 620px;
			width: 400px;
			background-color: rgba(255,255,255,0.13);
			position: absolute;
			transform: translate(-50%,-50%);
			top: 50%;
			left: 50%;
			border-radius: 10px;
			backdrop-filter: blur(10px);
			border: 2px solid rgba(255,255,255,0.1);
			box-shadow: 0 0 40px rgba(8,7,16,0.6);
			padding: 50px 35px;
			z-index: 10;
		}
		form *{
			font-family: 'Poppins',sans-serif;
			color: #ffffff;
			letter-spacing: 0.5px;
			outline: none;
			border: none;
		}
		form h3{
			font-size: 32px;
			font-weight: 500;
			line-height: 42px;
			text-align: center;
		}
		label{
			display: block;
			margin-top: 30px;
			font-size: 16px;
			font-weight: 500;
		}
		input{
			display: block;
			height: 50px;
			width: 100%;
			background-color: rgba(255,255,255,0.07);
			border-radius: 3px;
			padding: 0 10px;
			margin-top: 8px;
			font-size: 14px;
			font-weight: 300;
		}
		::placeholder{
			color: #e5e5e5;
		}
		button{
			margin-top: 50px;
			width: 100%;
			background-color: #ffffff;
			color: #080710;
			padding: 15px 0;
			font-size: 18px;
			font-weight: 600;
			border-radius: 5px;
			cursor: pointer;
		}
		.social{
			margin-top: 30px;
			display: flex;
		}
		.social div{
			background: red;
			width: 150px;
			border-radius: 3px;
			padding: 5px 10px 10px 5px;
			background-color: rgba(255,255,255,0.27);
			color: #eaf0fb;
			text-align: center;
		}
		.social div:hover{
			background-color: rgba(255,255,255,0.47);
		}
	</style>
</head>

<body >
<div class="background">
	<div class="shape"></div>
	<form id="item" action="/registered" method="post">
		<h3>注册表单</h3>
		<p style="color: red;text-align: center" id="passwordTip"></p>
		<label for="username">用户名</label>
		<input type="text" placeholder="username"  name="name" id="username">

		<label for="user_password">密码</label>
		<input type="password" onchange="checkPassword()" placeholder="Password" name="password" id="user_password">

		<label for="confirm_password">确认密码</label>
		<input type="password" onchange="checkConfirmPassword()" placeholder="Password" name="cr_password" id="confirm_password">
		<button type="submit"> 注册  </button>
		<div class="social">
			<div class="go"><a href="/toLogin">登录</a></div>
		</div>
	</form>
	<div class="shape"></div>
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