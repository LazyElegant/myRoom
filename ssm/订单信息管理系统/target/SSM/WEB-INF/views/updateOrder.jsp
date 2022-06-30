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
		<style>
			h3{
				font-size: 1.17em;
			}
			input{
				margin: 20px 0px;
			}
		</style>
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
				<div id="Model" >
					<div id="content2" class="thiscontent" style="background-color: #fff;padding: 20px;padding-bottom:0;min-height: 409px;">

						<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
						<form method="post" action="/updateOrder">
							<input type="text" style="display: none" name="id" value="${order.getId()}">
							<h3>售卖品</h3>
							<input value="${order.getName()}" style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="name" class="form-control" type="text" id="btn">
							<h3>数量</h3>
							<input value="${order.getCount()}" style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="count" class="form-control" type="text">
							<h3>总额</h3>
							<input value="${order.getAmount()}" style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="amount" class="form-control" type="text">
							<h3>食材详情</h3>
							<textarea name="content" style="width: 800px;height: 300px;resize:none;font-size: 18px;padding: 10px;">${order.getContent()}</textarea>
							<br>

							<div class="form-group" style="margin-left: 250px ;">
								<input type="submit" class="submit" name="editor">
							</div>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
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
	</body>
</html>
