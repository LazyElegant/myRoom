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
				<li class="sq"><a href="/getMyBillManage">账单管理</a></li>

				<li class="wd "><a href="/moneyManage">钱包管理</a></li>
				<li class="my "><a href="/updatePassword">${sessionScope.user.getUsername()}</a></li>

			</ul>
		</div>
	</div>
</nav>
<div class="mauto" style="width: 1166px;padding-bottom: 20px;text-align: center">
	<div class="clearfix">
		<div id="Model">
			<div id="content2" class="thiscontent" style="width: 1066px;background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 409px;">
				<p style="font-weight: bold;font-size: 13px;">钱包管理</p>
				<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
					<p style="text-align: center">
						<h1>水费余额：${water}</h1>
						<h1>电费余额：${electric}</h1>
					    <input type="submit" class="submit" onclick="sf()" name="editor" value="充值水费">
					<input type="submit" class="submit" onclick="df()" name="editor" value="充值电费">
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script>
	function sf(){
		var text=prompt("水费预缴费","请在这里输入金额");
		document.location.href =   "${request.getContextPath()}/sf?money="+ text;

	}
	function df(){
		var text=prompt("电费预缴费","请在这里输入金额");
		document.location.href =   "${request.getContextPath()}/df?money="+ text;

	}
</script>
</html>
