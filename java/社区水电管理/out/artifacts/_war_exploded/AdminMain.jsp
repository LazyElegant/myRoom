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
<div style="margin-top: 30px;padding: 30px;background-color: white;">

	<div class="mauto" style="width: 1166px;padding-bottom: 20px;margin: 0 auto;">
		<table class="order_table">
			<tbody>
			<tr class="layui-form">
				<td width="250">
					<p>用户编号</p>
				</td>
				<td width="250">
					<p>用户名</p>
				</td>
				<td class="goods_num" width="150">
					<p>水费余额</p>
				</td>
				<td class="goods_num" width="150">
					<p>电费余额</p>
				</td>
				<td class="goods_money" width="450">
					<input type="text" id="BalanceName" /><input id="cx" type="submit" value="用户名搜索" />
				</td>
			</tr>
			</tbody>
		</table>

		<table class="order_table">
			<tbody>
			<c:forEach items="${BalanceList}" var="list">

				<tr class="layui-form">
					<td width="250">
						<p>${list.getUserId()}</p>
					</td>
					<td class="goods_num" width="250">
						<p>${list.getUsername()}</p>
					</td>
					<td class="goods_money" width="150">
						<p>${list.getWaterBalance()}</p>
					</td>
					<td class="goods_money" width="150">
						<p>${list.getElectricBalance()}</p>
					</td>
					<td class="goods_money" width="450">
						<input class="sc" id="${list.getUserId()}" type="submit" value="删除">
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>


</div>
</body>
<script>
	$("#cx").click(function () {
		document.location.href =   "${request.getContextPath()}/getBalance?name="+ $("#BalanceName").val();
	})

	$(".sc").click(function () {
		var r =confirm("您确定删除该账户吗？")
		if(r){
			document.location.href =   "${request.getContextPath()}/deleteUser?id="+ this.id;
		}

	})

</script>
</html>
