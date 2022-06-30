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
			button[type=submit]:hover {
				background: #181616;
				color: #fff;
				cursor: pointer;
			}
			button[type=submit] {
				background: #FC5A5A;
				color: #fff;
				padding: 16px 25px;
				font-size: 12px;
				font-weight: 700;
				line-height: 1em;
				text-align: center;
				text-transform: uppercase;
				-webkit-transition: all .3s ease-out;
				-moz-transition: all .3s ease-out;
				transition: all .3s ease-out;
				border: 0;
				overflow: hidden;
			}
			.ify li {
				font-size: 19px;
				margin: 15px 15px 25px;
			}
			.ify {
				width: 320px;
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
		<nav class="nav ">
		        <div class="w ">
		            <div class="navitems ">
		                <ul>
		                    <li class="cb"><a href="/index">首页</a></li>
		                    <li class="sq"><a href="/toAddFoods">添加食材</a></li>
		                    
		                    <li class="wd "><a href="/manage">食材管理</a></li>
		                    <li class="my "><a href="/updatePassword">${sessionScope.user.getName()}</a></li>
		
		                </ul>
		            </div>
		        </div>
		    </nav>
		<div class="mauto" style="width: 1166px;padding-bottom: 20px;">
			<div class="clearfix">
				<ul id="left_nav" class="fl-left bgfff">
					<li class="c_menu">
						<a href="/toAddFoods" id="grzx">添加食材</a>
					</li>
					<li class="c_menu">
						<a href="/manage" class="choosed">食材管理</a>
					</li>
				</ul>
				<div id="Model" class="fl-right">
					<div id="content2" class="thiscontent" style="background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 409px;">
						<p style="font-weight: bold;font-size: 13px;">食材管理</p><button type="submit" class="deleteList"> 批量删除 </button>
						<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
							<ul class="ify">
								<c:forEach items="${foodsList}" var="list">
									<li id="${list.getId()}"><input name="foods" class="cd" type="checkbox" value="${list.getId()}" /><a href="#">${list.getName()}</a><button type="submit" class="update"> 修改 </button><button type="submit" class="detele"> 删除 </button></li>
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
			if(confirm("确定删除该食材?")){
				var  id = $(this).parent().attr('id');
				document.location.href =   "http://localhost:8080/deleteFoods?id=" + id;
			}
		})
		$(".update").click(function () {
			var  id = $(this).parent().attr('id');
			document.location.href = "http://localhost:8080/toUpdateFoods?id=" + id;
		})
		$(".deleteList").click(function () {
			var ids = "";
			$(".cd:checked").each(function () {
				ids += "," + $(this).val();
			});
			ids = ids.substring(1);
			if (ids!==""){
				if(confirm("确定删除这些食材?")){
					document.location.href = "http://localhost:8080/deleteFoodsList?ids=" + ids;
				}
			}else {
				alert("请选择要删除的食材");
			}
		})
	</script>
</html>
