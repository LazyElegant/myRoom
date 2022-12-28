<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath(); %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="<%=path%>/css/index.css" />
		<script src="<%=path%>/js/jquery-3.4.1.js"></script>
	</head>
	<body style="background-color: #f2f2f2;">
	<nav class="nav ">
		<div class="w ">
			<div class="navitems ">
				<ul>
					<li class="cb"><a href="/main">首页</a></li>
					<li class="sq"><a href="/toAddBill">${sessionScope.user.getState() == 0? "添加账单":""}</a></li>

					<li class="wd "><a href="/manage">${sessionScope.user.getState() == 0? "账单管理":""}</a></li>
					<li class="my "><a href="/updatePassword">${sessionScope.user.getUsername()}</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<nav class="nav ">
		<div class="w ">
			<div class="navitems ">
				<ul>
					<li class="cb"><a href="/main">首页</a></li>
					<li class="sq"><a href="/toAddBill">${sessionScope.user.getState() == 0? "添加账单":""}</a></li>

					<li class="wd "><a href="/manage">${sessionScope.user.getState() == 0? "账单管理":""}</a></li>
					<li class="my "><a href="/Analysis">${sessionScope.user.getState() == 0? "水电分析":""}</a></li>
					<li class="sd "><a href="/updatePassword">${sessionScope.user.getUsername()}</a></li>

				</ul>
			</div>
		</div>
	</nav>
		<div class="mauto" style="width: 1166px;padding-bottom: 20px;">
			<div class="clearfix">
				<ul id="left_nav" class="fl-left bgfff">
					<li class="c_menu">
						<a href="javascript:;" id="grzx" class="choosed">修改密码</a>
					</li>
					<li class="c_menu">
						<a href="/out">退出登录</a>
					</li>
				</ul>
				<div id="Model" class="fl-right">
					<div id="content2" class="thiscontent" style="background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 409px;">
						<p style="font-weight: bold;font-size: 13px;">修改密码</p>
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
</html>
