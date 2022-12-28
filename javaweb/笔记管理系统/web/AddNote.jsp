<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath(); %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>添加笔记</title>
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
				<li class="sq"><a id="addClassify" href="#">添加分类</a></li>
				<li class="wd "><a href="/ClassifyManage">分类管理</a></li>
				<li class="my "><a href="/toAddNote">添加笔记</a></li>
				<li class="sd "><a href="/updatePassword">${sessionScope.user.getUsername()}</a></li>
				<li class="out"><a href="/out">退出登录</a></li>
			</ul>
		</div>
	</div>
</nav>
<div class="mauto" style="width: 1166px;padding-bottom: 20px;">
	<div class="clearfix">
		<div id="Model">
			<div id="content2" class="thiscontent" style="width: 1066px;background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 409px;">
				<p style="font-weight: bold;font-size: 13px;">添加笔记</p>
				<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
					<form method="post" action="/addNote">

						<h3>笔记标题</h3>
						<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="title" class="form-control" type="text" id="btn">
						<h3>分类</h3>
						<select class="module" name="classify">
							<c:forEach items="${ClassifyList}" var="list">
								<option  value="${list.getId()}">${list.getName()}</option>
							</c:forEach>
						</select>
						<h3>内容</h3>
						<textarea style="width: 400px;height: 160px;line-height: 40px;margin-left: 15px;" name="content" class="form-control">
						</textarea>
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
