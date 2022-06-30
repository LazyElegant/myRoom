<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="../css/index.css" />
	</head>
	<body style="background-color: #f2f2f2;">
		<nav class="nav ">
		        <div class="w ">
		            <div class="navitems ">
		                <ul>
		                    <li class="cb"><a href="/index">首页</a></li>
		                    <li class="sq"><a href="/toAddGoods">上架商品</a></li>
		                    
		                    <li class="wd "><a href="/manage">商品管理</a></li>
		                    <li class="my "><a href="/updatePassword">个人中心</a></li>
		
		                </ul>
		            </div>
		        </div>
		    </nav>
		<div class="mauto" style="width: 1166px;padding-bottom: 20px;">
			<div class="clearfix">
				<ul id="left_nav" class="fl-left bgfff">
					<li class="c_menu">
						<a href="javascript:;" id="grzx" class="choosed">上架商品</a>
					</li>
					<li class="c_menu">
						<a href="/manage">商品管理</a>
					</li>
				</ul>
				<div id="Model" class="fl-right">
					<div id="content2" class="thiscontent" style="background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 409px;">
						<p style="font-weight: bold;font-size: 13px;">上架商品</p>
						<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
						<form method="post" action="/insertGoods">
							
							<h3>商品名</h3>
							<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="name" class="form-control" type="text" id="btn">
							<h3>商品价格</h3>
							<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="price" class="form-control" type="text">
							<h3>商品详情</h3>
							<textarea name="content" style="width: 800px;height: 300px;resize:none;font-size: 18px;padding: 10px;"></textarea>
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
