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
		<style>
			.submit{

				width: 80px;
				margin-top: 0px;
			}
			.ify li {
				font-size: 19px;
				margin: 15px 15px 25px;
			}
			.ify {
				width: 520px;
			}
			.ify li button {
				float: right;
				line-height: 5px;
				margin-left: 15px;
				padding: 13px;
			}
		</style>
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
						<button type="submit" class="deleteList"> 批量删除 </button>
						<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
							<ul class="ify">
								<c:forEach items="${expressList}" var="list">
									<li id="${list.getId()}"><input name="express" class="cd" type="checkbox" value="${list.getId()}" />快递单号：<a href="#">${list.getNumbers()}</a>
										<c:if test="${list.getStatus() == 1}">
											<button type="submit" class="submit update"> 收货 </button>
										</c:if>
										<button type="submit" class="submit detele"> 删除 </button>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script>
		$(".detele").click(function (){
			if(confirm("确定删除该快递?")){
				var  id = $(this).parent().attr('id');
				document.location.href =   "http://localhost:8080/deleteExpress?id=" + id;
			}
		})
		$(".update").click(function () {
			var  id = $(this).parent().attr('id');
			document.location.href = "http://localhost:8080/updateExpress?id=" + id;
		})
		$(".deleteList").click(function () {
			var ids = "";
			$(".cd:checked").each(function () {
				ids += "," + $(this).val();
			});
			ids = ids.substring(1);
			if (ids!==""){
				if(confirm("确定删除这些快递?")){
					document.location.href = "http://localhost:8080/deleteExpressList?ids=" + ids;
				}
			}else {
				alert("请选择要删除的快递");
			}
		})
	</script>
	<script>
		$("#cx").click(function () {
			console.log($("#numbers").val());
			document.location.href =   "${request.getContextPath()}/getExpress?id="+ $("#numbers").val();
		})
	</script>
</html>
