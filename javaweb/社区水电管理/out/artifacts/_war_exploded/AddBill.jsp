<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath(); %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>首页</title>
	<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=path%>/css/index.css" />
	<script src="<%=path%>/js/jquery-3.4.1.js"></script>
	<script src="<%=path%>/js/month.js"></script>
	<STYLE>
		h3{
			font-size: 1.17em;
		}
		select{
			color: slategrey;
			margin-left: 20px;
			font-size: 15px;
			padding: 10px;
			width: 300px;
		}
	</STYLE>
</head>
<body style="background-color: #f2f2f2;">
<nav class="nav ">
	<div class="w ">
		<div class="navitems ">
			<ul>
				<li class="cb"><a href="/main">首页</a></li>
				<li class="sq"><a href="/toAddBill">添加账单</a></li>

				<li class="wd "><a href="/manage">账单管理</a></li>
				<li class="my "><a href="/Analysis">水电分析</a></li>
				<li class="sd "><a href="/updatePassword">${sessionScope.user.getUsername()}</a></li>

			</ul>
		</div>
	</div>
</nav>
<div class="mauto" style="width: 1166px;padding-bottom: 20px;">
	<div class="clearfix">
		<div id="Model">
			<div id="content2" class="thiscontent" style="width: 1066px;background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 409px;">
				<p style="font-weight: bold;font-size: 13px;">添加账单</p>
				<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
					<form method="post" action="/insertBill">

						<h3>用户编号</h3>
						<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="userId" class="form-control" type="text" id="btn">
						<h3>月份</h3>
						<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="mouth" onclick="setmonth(this)" class="form-control">
						<h3>费用类型</h3>
						<select class="module" name="type">
							<option  value="1" selected="selected">水费</option>
							<option  value="2" selected="selected">电费</option>
						</select>
						<h3>金额</h3>
						<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="money" type="text"  class="form-control">

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
</body>
</html>
