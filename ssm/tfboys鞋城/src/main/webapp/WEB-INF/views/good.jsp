<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="../css/index.css" />
		<script src="../js/jquery-3.4.1.js"></script>
	</head>
	<body onscroll="myOnscroll()">
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
				<div class="menu">
					<div class="menu-container">
						<div class="container">
							<a href="/index/" class="logo"><img src="../img/logo.JPEG"></a>
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
				</div>

				<div class="index-banner">
					<div class="carousel_item is_active" style="background:url(../img/img_3.jpeg);background-size: 100% 100%;">
					</div>

				</div>
				<div style="background-color: rgba(0, 0, 0, 0.1);">
					<div class="combo-header container">
						<h2>${goods.getName()}</h2>
					</div>
				</div>
				<div class="container desc-wrap">
					<div class="desc-right-wrap" style="float:left">
						<div class="flex-wrap price-wrap">
							<div class="combo-price">
								<div class="original-price"><i>¥</i> <em>${goods.getOriginal()}</em></div>
								<div class="price-box"><i>¥</i> <em>${goods.getCurrent()}</em> <span>/套</span></div>
							</div>
						</div>

						<div class="item-wrap">
							<ul class="select-box">
								<li class="on">${goods.getName()}</li>
							</ul>
						</div>
						<div class="item-wrap">
							<span class="item-label">购买数量：</span>
							<input type="text" id="number" class="el-input_inner">
						</div>
						<div class="item-wrap">
							<span class="item-label">尺码：</span>
							<select class="shoeSize"  id="size" style="display: block;margin: auto;width: 60px;" name="size">
								<option value="35">35</option>
								<option value="36">36</option>
								<option value="37">37</option>
								<option value="38">38</option>
								<option value="39">39</option>
								<option value="40">40</option>
								<option value="41">41</option>
								<option value="42">42</option>
								<option value="43">43</option>
								<option value="44">44</option>
								<option value="45">45</option>
								<option value="46">46</option>
							</select>
						</div>
						<div class="item-wrap">
						
							<div style="display: inline-block; vertical-align: top;">${goods.getContent()}
							</div>
						</div>
						<button disabled="disabled" type="button" class=" buy-btn">
							<span onclick="insert(${goods.getId()})">立即代购</span>
						</button>
					</div>

					<div class="o-sldie-container" style="width:500px;">
						<div class="only-slide" style="height: 300px;">
							<div class="o-slide-wapper">
								<div class="o-slide-item" style="background-image:url(${goods.getImgUrl()});">

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
		<div class="slide-nav">
			<a href="/toShopping" class="shopping" id="shopping">
				<svg style="width: 28px;height: 28px;" t="1639364825101" class="icon" viewBox="0 0 1024 1024"
					version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2277" width="200" height="200">
					<path
						d="M352.456912 832.032253c-35.434907 0-63.989249 28.554342-63.989249 63.989249 0 35.434907 28.554342 63.989249 63.989249 63.989249s63.989249-28.554342 63.989249-63.989249C416.446162 860.586595 387.891819 832.032253 352.456912 832.032253L352.456912 832.032253z"
						p-id="2278"></path>
					<path
						d="M800.55367 832.032253c-35.434907 0-63.989249 28.554342-63.989249 63.989249 0 35.434907 28.554342 63.989249 63.989249 63.989249s63.989249-28.554342 63.989249-63.989249C864.54292 860.586595 835.816563 832.032253 800.55367 832.032253L800.55367 832.032253z"
						p-id="2279"></path>
					<path
						d="M864.026877 800.037628 344.200235 800.037628c-46.099782 0-86.695112-36.466991-92.199563-83.082815l-54.356459-382.043339L166.853687 156.360826c-1.892155-15.653284-16.169326-28.382328-29.930455-28.382328L95.983874 127.978498c-17.717453 0-31.994625-14.277171-31.994625-31.994625s14.277171-31.994625 31.994625-31.994625l40.767344 0c46.615824 0 87.727196 36.466991 93.403662 83.082815l30.790526 177.86259L315.473879 708.698135c1.720141 14.793214 15.309256 27.350244 28.726356 27.350244l519.826642 0c17.717453 0 31.994625 14.277171 31.994625 31.994625S881.744331 800.037628 864.026877 800.037628z"
						p-id="2280"></path>
					<path
						d="M384.279523 672.05913c-16.685369 0-30.618512-12.729044-31.82261-29.586427-1.376113-17.545439 11.868974-33.026709 29.586427-34.230808l434.163615-31.994625c15.997312-0.172014 29.414413-12.55703 31.134554-26.834201l50.400134-288.295649c1.204099-10.664875-1.720141-22.533848-8.084663-29.758441-4.128339-4.644381-9.288762-7.052579-15.309256-7.052579L319.946246 224.3064c-17.717453 0-31.994625-14.277171-31.994625-31.994625S302.400806 159.973123 319.946246 159.973123l554.05745 0c24.426004 0 46.959852 10.148833 63.301193 28.554342 18.749538 21.157736 27.178229 50.744163 23.565933 81.706703l-50.400134 288.467663c-5.504452 44.895683-45.927768 81.362674-92.027549 81.362674l-431.755417 31.82261C385.82765 671.887116 384.967579 672.05913 384.279523 672.05913z"
						p-id="2281"></path>
				</svg>
				<p>购物车</p>
			</a>
			<div class="online-consulting">
				<a href="/">
					<svg style="width: 28px;height: 28px;" t="1639365107098" class="icon" viewBox="0 0 1024 1024"
						version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3443" width="200" height="200">
						<path
							d="M517.119 954.878c244.589 0 442.879-198.289 442.879-442.879 0-244.594-198.289-442.879-442.879-442.879C272.524 69.12 74.24 267.404 74.24 511.999 74.24 756.588 272.524 954.878 517.119 954.878L517.119 954.878zM517.119 891.608c-209.654 0-379.612-169.955-379.612-379.609s169.957-379.612 379.612-379.612 379.609 169.957 379.609 379.612S726.773 891.608 517.119 891.608L517.119 891.608zM523.949 243.992c-54.662 0-97.177 16.705-127.547 50.112-30.367 31.885-44.795 74.402-44.795 127.547l59.98 0c0-37.202 8.35-66.052 25.055-87.31 18.222-25.055 46.312-37.202 84.272-37.202 31.885 0 56.945 8.352 74.405 26.572 16.705 16.702 25.81 40.24 25.81 70.607 0 21.26-7.59 41-22.775 59.98-4.55 6.072-13.665 15.185-25.81 27.33-41 36.445-66.055 65.295-76.685 88.075-9.11 18.98-13.665 40.995-13.665 66.05l0 17.465 60.735 0 0-17.465c0-20.5 4.56-38.725 14.43-55.425 7.59-13.665 18.98-27.335 35.68-41.755 33.405-29.612 53.91-49.352 61.5-58.462 18.98-25.055 28.85-54.665 28.85-88.83 0-45.552-14.425-81.235-42.515-107.05C611.258 256.902 572.544 243.992 523.949 243.992L523.949 243.992zM512.564 706.363c-12.907 0-23.535 3.795-32.647 12.905-9.11 8.345-12.905 18.98-12.905 31.885s3.795 23.54 12.905 32.65c9.112 8.345 19.74 12.905 32.647 12.905 12.91 0 23.535-4.56 32.645-12.905 9.11-8.355 13.665-18.985 13.665-32.65 0-12.905-4.555-23.54-12.905-31.885C536.859 710.158 525.474 706.363 512.564 706.363L512.564 706.363z"
							p-id="3444"></path>
					</svg>
					<p>在线咨询</p>
				</a>
			</div>
			<a class="back-top" id="g_backtop" style="display: none;">
				<svg style="width: 28px;height: 28px;" t="1639365234693" class="icon" viewBox="0 0 1024 1024"
					version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4238" width="200" height="200">
					<path d="M30.332842 0.346901l963.333292 0 0 74.102718-963.333292 0 0-74.102718Z" p-id="4239"></path>
					<path
						d="M564.392254 162.53684 512 110.143563 459.606723 162.53684 459.606723 162.53684 119.017674 503.125889 171.409928 555.519166 474.948129 251.980965 474.948129 1023.653099 549.050848 1023.653099 549.050848 251.980965 852.589049 555.519166 904.982326 503.125889 564.392254 162.53684Z"
						p-id="4240"></path>
				</svg>
				<p>返回顶部</p>
			</a>
		</div>
	</body>
	<script>
		function myOnscroll() {


			if (document.documentElement.scrollTop < 250) {

				document.getElementById('g_backtop').style.display = 'none';
			} else {
				document.getElementById('g_backtop').style.display = 'block';
			}

			console.log(document.documentElement.scrollTop);
		}
		g_backtop.onclick = function() {
			timer = requestAnimationFrame(function fn() {
				var oTop = document.body.scrollTop || document.documentElement.scrollTop;
				if (oTop > 0) {
					document.body.scrollTop = document.documentElement.scrollTop = oTop - 100;
					timer = requestAnimationFrame(fn);
				} else {
					cancelAnimationFrame(timer);
				}
			});
		}
		function insert(id){
			if (${sessionScope.user==null}){
				window.location.href="${request.getContextPath()}/toLogin"
			}
			if(confirm('确定要预定吗')==true){
				$.ajax({
					url:"${request.getContextPath()}/shop?id=" + id+"&number="+$("#number").val() + "&size="+$("#size").val(), // 请求路径
					type:"GET" , //请求方式
					dataType:"json"//设置接受到的响应数据的格式 text 普通的文本字符串
				});
			}
		}
	</script>
</html>
