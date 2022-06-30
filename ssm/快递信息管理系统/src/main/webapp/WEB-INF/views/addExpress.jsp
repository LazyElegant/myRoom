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
			<a href="/updatePassword">${sessionScope.user.getName()}</a>
		</p>
	</nav>
		<div class="mauto" style="width: 1366px;padding-bottom: 20px;">
			<div class="clearfix">
				<div id="Model">
					<div id="content2" class="thiscontent" style="background-color: #fff;padding: 20px;padding-bottom:0;min-height: 409px;">
						<div style="margin-bottom:20px;min-height: 400px;">
							<form method="post" action="/insertExpress">

								<h3>物品</h3>
								<input name="thing" class="form-control" type="text" id="btn">
								<h3>重量（千克）</h3>
								<input name="weight" class="form-control" type="text">
								<h3>快递单号</h3>
								<input name="numbers" class="form-control" type="text">
								<h3>寄件人</h3>
								<input name="senderName" class="form-control" type="text">
								<h3>寄件人电话</h3>
								<input name="senderPhone" class="form-control" type="text">
								<h3>寄件人地址</h3>
								<input name="senderAddress" class="form-control" type="text">
								<h3>收件人</h3>
								<input name="addresseeName" class="form-control" type="text">
								<h3>收件人电话</h3>
								<input name="addresseePhone" class="form-control" type="text">
								<h3>收件人地址</h3>
								<input name="addresseeAddress" class="form-control" type="text">
								<br>
								<input type="submit" class="submit" value="添加" >
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script>
		$("#cx").click(function () {
			console.log($("#numbers").val());
			document.location.href =   "${request.getContextPath()}/getExpress?id="+ $("#numbers").val();
		})
	</script>
</html>
