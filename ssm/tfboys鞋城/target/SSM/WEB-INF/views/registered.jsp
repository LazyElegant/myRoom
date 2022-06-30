<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>注册</title>

<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>

<body style="background-color: #dfd8e8;">
<div class="container">
	<div class="row">
		<aside class="col-sm-5" style="margin: auto">
			<div class="card" style="margin-top: 80px;margin-bottom:100px;padding-left:20px;padding-right:20px;">
				<article class="card-body">
					<a href="/toLogin" class="float-right btn btn-outline-primary">登录</a>
					<h4 class="card-title mb-4 mt-1">注册</h4>
					<form id="item"  action="/registered" method="post">
						<p style="color: red;text-align: center">${msg}</p>
						<div class="form-group">
							<label>id</label>
							<input name="id" class="form-control" type="text" onfocus=this.blur() value="${id}" required>
						</div>

						<div class="form-group">
							<label>用户名</label>
							<input name="username" class="form-control" type="text" id="user_name" required>
						</div>

						<div class="form-group">
							<label>密码</label>
							<span  id="passwordTip" style="color:red;font-size: 12px;"></span>
							<input name="password" onchange="checkPassword()" class="form-control" type="password" id="user_password" required>
						</div>

						<div class="form-group">
							<label>确认密码</label>
							<span  id="confirmPasswordTip" style="color:red;font-size: 12px;"></span>
							<input name="confirm_password" onchange="checkConfirmPassword()" class="form-control" type="password" id="confirm_password" required>
						</div>

						<div class="form-group">
							<label>你的邮箱</label><br/>
							<span  id="emailTip" style="color:red;font-size: 12px;"></span>
							<input name="email" onchange="checkEmail()" class="form-control" type="email" id="email" required>
						</div>

						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block"> 注册 </button>
						</div>
					</form>
				</article>
			</div>
		</aside>
	</div>
</div>
<script type='text/javascript' src='../js/jquery-3.2.1.min.js'></script>
<script type="text/javascript">
	function checkEmail(){
		let email = document.getElementById("email").value;
		if(email.substr(email.lastIndexOf("@")) === "@qq.com" || email.substr(email.lastIndexOf("@")) === "@163.com"){
			document.getElementById("emailTip").innerHTML="";
		}else{
			document.getElementById("emailTip").innerHTML="邮箱格式不正确";
		}
		if (email.substr(0,email.lastIndexOf("@")).length<5 || email.substr(0,email.lastIndexOf("@")).length>10){
			document.getElementById("emailTip").innerHTML="邮箱位数为5-10位之间";
		}
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
			document.getElementById("confirmPasswordTip").innerHTML="密码不一致";
		}else{
			document.getElementById("confirmPasswordTip").innerHTML="";
		}
	}

</script>
</body>
</html>