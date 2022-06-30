<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>上架商品</title>
		<link rel="stylesheet" href="../css/index.css" />
		<link rel="stylesheet" href="../css/layui.css" />
		<script src="../js/jquery-3.4.1.js"></script>
	</head>
	<style>
		h3 {
			font-family: "Microsoft YaHei",Arial,Helvetica,serif;
			font-weight: 700;
			line-height: 1.5em;
		    font-size: 20px;
			margin-bottom: 15px;
		}
		select {
			color: slategrey;
			margin-left: 20px;
			font-size: 15px;
			padding: 10px;
			width: 300px;
		}
		.form-control {
		    display: block;
		    width: 100%;
		    padding: 0.5rem 0.75rem;
		    font-size: 1rem;
		    line-height: 1.25;
		    color: #495057;
		    background-color: #fff;
		    background-image: none;
		    background-clip: padding-box;
		    border: 1px solid rgba(0,0,0,.15);
		    border-radius: 0.25rem;
		    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
		}
		.submit {
		    background: #FC5A5A;
		    color: #fff;
		    padding: 16px 25px;
			width: 250px;
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
		.submit:hover {
		    background: #181616;
		    color: #fff;
		    cursor: pointer;
		}
	</style>
	<body>
		<div>			
			<!-- 页头 -->
			<div class="container header">
				<div class="m_right">
					<div class="top-links">
						<a href="#">主题鞋城官网</a>
					</div>
					<div class="top-links">
						<a href="#">联系我们</a>
					</div>
					<c:choose>
						<c:when test="${sessionScope.user != null}">
							<a href="/personal">${sessionScope.user.getUsername()}</a>
							<a href="/outLogin">退出登录</a>
							<c:if test="${sessionScope.user.getStatus() == 1}">
								<a href="/shelves">后台管理</a>
							</c:if>
						</c:when>
						<c:otherwise>
							<a href="/toLogin">登录</a>
							<a href="/toRegistered">注册</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
			<div class="content-bgimg">
				<!-- 导航条 -->
				<div class="menu" style="position: relative;top: 0px;">
					<div class="menu-container">
						<div class="container">
							<a href="/" class="logo"><img src="img/logo.JPEG"></a>
							<ul class="el-menu">
								<c:forEach items="${sessionScope.Classify}" var="classify">

									<a href="/listByClass?id=${classify.getId()}&page=1">
										<li class="el-menu-item" value="${classify.getId()}" >${classify.getName()}</li>
									</a>
								</c:forEach>
							</ul>
							<div class="nav-phone">客服电话 0573-88731088</div>
						</div>
					</div>
					<div class="title-desc-container bread-crumbs">
						<div class="container">
							<a href="/index/" class="nuxt-link-active">首页</a>
							<svg style="width: 10px;height: 10px;" t="1639369195722" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1866" width="200" height="200"><path d="M761.6 489.6l-432-435.2c-9.6-9.6-25.6-9.6-35.2 0-9.6 9.6-9.6 25.6 0 35.2l416 416-416 425.6c-9.6 9.6-9.6 25.6 0 35.2s25.6 9.6 35.2 0l432-441.6C771.2 515.2 771.2 499.2 761.6 489.6z" p-id="1867" fill="#ffffff"></path></svg>
							<span class="current">上架商品</span>
						</div>
					</div>
				</div>
			</div>
			<div id="content" style="background-color: #f2f2f2;">
				<div class="mauto" style="width: 1166px;padding-bottom: 20px;">
					<div class="clearfix">
						<ul id="left_nav" class="fl-left bgfff">
							<li class="p_menu">
								<img src="../img/person_icon2.png" alt="">
								后台管理
							</li>
							<li class="c_menu">
								<a href="javascript:;" id="grzx" class="choosed">上架商品</a>
							</li>
							<li class="c_menu">
								<a href="/classifyManage">分类管理</a>
							</li>
							<li class="c_menu">
								<a href="/manage" >商品管理</a>
							</li>
							<li class="c_menu">
								<a href="/adminOrder">订单管理</a>
							</li>
						</ul>
						<div id="Model" class="fl-right">
							<div id="content2" class="thiscontent" style="background-color: #fff;border-top: 3px solid #8B3734;padding: 20px;padding-bottom:0;min-height: 409px;">
								<p style="font-weight: bold;font-size: 13px;">上架商品</p>
								<div id="shopcarview" style="margin-bottom:20px;min-height: 400px;">
								<form  method="post" enctype="multipart/form-data" action="/insertGoods">
									<input type="file" name="pictures" id="imageOne" accept=".png, .jpg, .jpeg" style="display:none"/>
									<svg  t="1600950043250" class="Column-img icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1534" style="margin-left: 250px;width: 250px;height:138px;" id="imageOnePreview" onclick="addImg()">
										<path d="M1004.8 192h-192c-12.8 0-19.2-6.4-19.2-19.2s6.4-19.2 19.2-19.2h192c12.8 0 19.2 6.4 19.2 19.2s-6.4 19.2-19.2 19.2z" fill="" p-id="1535"></path>
										<path d="M908.8 288c-12.8 0-19.2-6.4-19.2-19.2v-192c0-12.8 6.4-19.2 19.2-19.2s19.2 6.4 19.2 19.2v192c0 12.8-6.4 19.2-19.2 19.2zM224 512c-44.8 0-83.2-38.4-83.2-83.2s38.4-83.2 83.2-83.2 83.2 38.4 83.2 83.2S268.8 512 224 512z m0-128c-25.6 0-44.8 19.2-44.8 44.8s19.2 44.8 44.8 44.8 44.8-19.2 44.8-44.8-19.2-44.8-44.8-44.8z" fill="" p-id="1536"></path>
										<path d="M780.8 960H147.2C64 960 0 896 0 812.8v-512c0-83.2 64-147.2 147.2-147.2H704c12.8 0 19.2 6.4 19.2 19.2s-6.4 19.2-19.2 19.2H147.2C89.6 192 38.4 243.2 38.4 300.8v512c0 57.6 51.2 108.8 108.8 108.8h633.6c57.6 0 108.8-51.2 108.8-108.8V403.2c-12.8-12.8-57.6-51.2-147.2-19.2-76.8 25.6-96 89.6-115.2 160-12.8 51.2-32 96-76.8 115.2-32 12.8-83.2 6.4-147.2-25.6-115.2-57.6-294.4 121.6-300.8 121.6-6.4 6.4-19.2 6.4-25.6 0s-6.4-19.2 0-25.6c6.4-6.4 204.8-198.4 339.2-134.4 57.6 32 96 38.4 121.6 32 25.6-12.8 38.4-51.2 51.2-96 19.2-70.4 44.8-153.6 140.8-185.6 134.4-44.8 192 38.4 192 44.8l6.4 12.8v409.6c0 83.2-64 147.2-147.2 147.2z" fill="" p-id="1537"></path>
									</svg>
									<h3>商品名</h3>
									<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="name" class="form-control" type="text" id="btn"/>
									<h3>商品原价</h3>
									<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="original" class="form-control" type="text" />
									<h3>商品现价</h3>
									<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" name="current" class="form-control" type="text" />
									<h3>商品类别</h3>
									<select class="module" name="classifyId">
										<option selected="selected">-选择商品类别-</option>
										<c:forEach items="${sessionScope.Classify}" var="classify">
										<option value="${classify.getId()}" >${classify.getName()}</option>
										</c:forEach>
									</select>
									<h3>卖家</h3>
									<input style="width: 400px;height: 40px;line-height: 40px;margin-left: 15px;" class="form-control" value="${sessionScope.user.getUsername()}" type="text"  id="name" onfocus=this.blur() />
									<h3>商品详情</h3>
									<textarea name="content" style="width: 800px;height: 300px;resize:none;font-size: 18px;padding: 10px;"></textarea>
									<br />

									<div class="form-group" style="margin-left: 250px ;">
										<input type="submit" class="submit"  name="editor" >
									</div>
								</form>
								</div>
							</div>
						</div>
					</div>
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
								<a href="templates/contact.html">寻求帮助吗?</a>
							</div>
						</div>
					</div>
			</div>
			
			
			
			
		</div>
		
	</body>
	
	<script>
	
			function readURLOne(input) {
				if (input.files && input.files[0]) {
					var reader = new FileReader();
					reader.onload = function(e) {
						$('#imageOnePreview').css('background-image', 'url('+e.target.result +')');
						$('#imageOnePreview').css('background-repeat','no-repeat');
						$('#imageOnePreview').css('background-size','100% 100%');
						$('#imageOnePreview').hide();
						$('#imageOnePreview').fadeIn(650);
					}
					reader.readAsDataURL(input.files[0]);
				}
			}
			$("#imageOne").change(function() {
				readURLOne(this);
			});
			function addImg() {
				$("#imageOne").click();
			}
	
			function UpdateImg() {
				$("#image").click();
	
			}
			$("#image").change(function() {
				readURL(this);
			});
			function readURL(input) {
				if (input.files && input.files[0]) {
					var reader = new FileReader();
					reader.onload = function(e) {
						$('.Column-img').attr('src',e.target.result);
						$('.Column-img').hide();
						$('.Column-img').fadeIn(650);
					}
					reader.readAsDataURL(input.files[0]);
				}
			}
		</script>
</html>
