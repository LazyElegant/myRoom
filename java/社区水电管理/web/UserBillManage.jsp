<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath(); %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>账单管理</title>
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
				<li class="sq"><a href="/BillManage">账单管理</a></li>

				<li class="wd "><a href="/moneyManage">钱包管理</a></li>
				<li class="my "><a href="/updatePassword">${sessionScope.user.getUsername()}</a></li>

			</ul>
		</div>
	</div>
</nav>
<div style="margin-top: 30px;padding: 30px;background-color: white;">

	<div class="mauto" style="width: 1166px;padding-bottom: 20px;margin: 0 auto;">
		<table class="order_table">
			<tbody>
			<tr class="layui-form">
				<td  width="250">
					<p>费用类型</p>
				</td>
				<td  width="250">
					<p>金额</p>
				</td>
				<td width="250">
					<p>月份</p>
				</td>
				<td  width="250">
					操作
				</td>
			</tr>
			</tbody>
		</table>

		<table class="order_table">
			<tbody>
			<c:forEach items="${BillList}" var="list">

				<tr class="layui-form">

					<td  width="250">
						<p>${list.getType()}</p>
					</td>
					<td  width="250">
						<p>${list.getMoney()}</p>
					</td>
					<td width="250">
						<p>${list.getMonth()}</p>
					</td>
					<td  width="250">
						<button type="submit" id="${list.getId()}"  value="${list.getMoney()}" title="${list.getType()}" onclick="zf(this)" class="update"> 支付 </button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>


</div>
</body>
<script>
	function zf(zf){
		if(zf.title=== "电费"){
			if(Number(zf.value) > ${electric}){
				alert("余额不足！！")
			}else {
				document.location.href ="${request.getContextPath()}/zf?id="+ zf.id +"&money=" +zf.value +"&type=" +zf.title;
			}
		}

		if(zf.title=== "水费"){
			if(Number(zf.value) > ${water}){
				alert("余额不足！！")
			}else {
				document.location.href ="${request.getContextPath()}/zf?id="+ zf.id +"&money=" +zf.value+"&type=" +zf.title;
			}
		}
	}
</script>
</html>
