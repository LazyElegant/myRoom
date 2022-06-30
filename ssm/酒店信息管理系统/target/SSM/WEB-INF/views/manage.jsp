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
	<div class="content-bgimg">
		<!-- 导航条 -->
		<div class="menu">
			<div class="menu-container">
				<div class="container">
					<a href="/index" class="logo"><img style="width: 100%;" src="../img/0546fa01d6c53f51d35380222b8c9eee.jpeg"></a>
					<ul class="el-menu">
						<a href="/index"><li class="el-menu-item">首页</li></a>
						<c:if test="${sessionScope.user == null}">
							<a href="/toLogin"><li class="el-menu-item">登录</li></a>
							<a href="/toRegistered"><li class="el-menu-item">注册</li></a>
						</c:if>
						<c:if test="${sessionScope.user != null}">
							<a href="/toAddHotel"><li class="el-menu-item">添加酒店信息</li></a>
							<a href="/manage"><li class="el-menu-item">酒店信息管理</li></a>
							<a href="/updatePassword"><li class="el-menu-item">${sessionScope.user.getName()}</li></a>
							<a href="/out"><li class="el-menu-item">退出登录</li></a>
						</c:if>
					</ul>
				</div>
			</div>
		</div>

		<div class="index-banner">
			<div class="carousel_item is_active" style="background:url(../img/9777e857d6df2802.jpg)  no-repeat center center;background-size: 100%;"></div>
		</div>
	</div>

	<div class="mauto" style="width: 1366px;padding-bottom: 20px;">
			<div class="clearfix">
				<div id="Model">
					<div id="content2" class="thiscontent" style="background-color: #fff;padding: 20px;padding-bottom:0;min-height: 409px;">
						<button type="submit" class="deleteList submit" style="width: 130px"> 批量删除 </button>
						<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
							<ul class="ify">
								<c:forEach items="${hotelList}" var="list">
									<li id="${list.getId()}"><input name="express" class="cd" type="checkbox" value="${list.getId()}" />酒店名：<a href="#">${list.getName()}</a>
										<button type="submit" class="submit update"> 修改 </button>
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
			if(confirm("确定删除该酒店?")){
				var  id = $(this).parent().attr('id');
				document.location.href =   "http://localhost:8080/deleteHotel?id=" + id;
			}
		})
		$(".update").click(function () {
			var  id = $(this).parent().attr('id');
			document.location.href = "http://localhost:8080/toUpdateHotel?id=" + id;
		})
		$(".deleteList").click(function () {
			var ids = "";
			$(".cd:checked").each(function () {
				ids += "," + $(this).val();
			});
			ids = ids.substring(1);
			if (ids!==""){
				if(confirm("确定删除这些酒店?")){
					document.location.href = "http://localhost:8080/deleteHotelList?ids=" + ids;
				}
			}else {
				alert("请选择要删除的酒店");
			}
		})
	</script>
</html>
