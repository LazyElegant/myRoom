<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath(); %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>水电分析</title>
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
				<td  width="150">
					<p>费用类型</p>
				</td>
				<td  width="150">
					<p>金额</p>
				</td>
				<td width="150">
					<p>数量</p>
				</td>
				<td width="150">
					<p>月份</p>
				</td>
				<td  width="250">
					<input type="text" id="BalanceName" /><input id="cx" type="submit" value="用户名搜索" /><input id="ss" type="submit" value="月份搜索" />
				</td>
			</tr>
			</tbody>
		</table>

		<table class="order_table">
			<tbody>
			<c:forEach items="${BillList}" var="list">

				<tr class="layui-form">
					<td width="200">
						<p>${list.getId()}</p>
					</td>
					<td width="250">
						<p>${list.getUserName()}</p>
					</td>
					<td  width="150">
						<p>${list.getType()}</p>
					</td>
					<td  width="150">
						<p>${list.getMoney()}</p>
					</td>
					<c:if test="${list.getType() == '电费'}">

						<td width="150">
							<p>${list.getMoney()*2}度</p>
						</td>
					</c:if>
					<c:if test="${list.getType() == '水费'}">

						<td width="150">
							<p>${list.getMoney()/2}吨</p>
						</td>
					</c:if>
					<td width="150">
						<p>${list.getMonth()}</p>
					</td>

					<td  width="250">
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<table class="order_table">
			<tbody>

			<tr class="layui-form">
				<td  width="700">
					<p></p>
				</td>
				<td width="150">
					<p>用水总计:${water/2}吨</p>
				</td>
				<td width="150">
					<p>水费总计:${water}</p>
				</td>
				<td width="150">
					<p>用电总计:${dian*2}度</p>
				</td>
				<td width="150">
					<p>电费总计:${dian}</p>
				</td>
			</tr>
			</tbody>
		</table>
	</div>


</div>
</body>
<script>
	$("#cx").click(function () {
		document.location.href =   "${request.getContextPath()}/AnalysisName?name="+ $("#BalanceName").val();
	})
	$("#ss").click(function () {
		document.location.href =   "${request.getContextPath()}/AnalysisMonth?name="+ $("#BalanceName").val();
	})
</script>
</html>
