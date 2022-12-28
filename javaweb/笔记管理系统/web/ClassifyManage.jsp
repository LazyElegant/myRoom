<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath(); %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>分类管理</title>
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
				<li class="sq"><a id="addClassify" href="#">添加分类</a></li>
				<li class="wd "><a href="/ClassifyManage">分类管理</a></li>
				<li class="my "><a href="/toAddNote">添加笔记</a></li>
				<li class="sd "><a href="/updatePassword">${sessionScope.user.getUsername()}</a></li>
				<li class="out"><a href="/out">退出登录</a></li>
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
					<p>分类名</p>
				</td>
				<td  width="250">
					<p>操作</p>
				</td>
			</tr>
			</tbody>
		</table>

		<table class="order_table">
			<tbody>
			<c:forEach items="${ClassifyList}" var="list">

				<tr class="layui-form">

					<td width="250">
						<p>${list.getName()}</p>
					</td>

					<td  id="${list.getId()}" width="250">
						<input style="width: 100px" class="delete submit" type="submit" value="删除">
						<input style="width: 100px"  class="update submit" type="submit" value="修改">
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
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
<script>
	$(".delete").click(function () {
		var r =confirm("您确定删除该分类吗？")
		if(r){
			document.location.href =   "${request.getContextPath()}/deleteClassify?id="+$(this).parent()[0].id;
		}
	})
	$(".update").click(function () {

		var res = prompt('请输入新的类型名');
		if (res!= null){
			document.location.href =   "${request.getContextPath()}/updateClassify?name="+ res + "&id="+$(this).parent()[0].id;
		}
	})
	$("#addClassify").click(function (){

		var res = prompt('请输入类型名');
		if (res!= null){
			document.location.href =   "${request.getContextPath()}/addClassify?name="+ res;
		}
	})
</script>
</html>
