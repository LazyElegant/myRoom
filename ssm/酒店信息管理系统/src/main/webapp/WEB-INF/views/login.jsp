<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link rel="stylesheet" href="../css/index.css" />
    <script src="../js/jquery-3.4.1.js"></script>
</head>
<body>
<div>
    <div class="content-bgimg">
        <!-- 导航条 -->
        <div class="menu">
            <div class="menu-container">
                <div class="container">
                    <a href="/index" class="logo"><img style="width: 100%;" src="../img/0546fa01d6c53f51d35380222b8c9eee.jpeg"></a>
                    <ul class="el-menu">
                        <a href="/index"><li class="el-menu-item">首页</li></a>
                        <a href="/toLogin"><li class="el-menu-item">登录</li></a>
                        <a href="/toRegistered"><li class="el-menu-item">注册</li></a>
                    </ul>
                </div>
            </div>
        </div>

        <!-- 轮播图 -->
        <div class="index-banner">
            <div class="carousel_item is_active" style="background:url(../img/9777e857d6df2802.jpg)  no-repeat center center;background-size: 100%;"></div>
        </div>
    </div>
</div>

<div id="Model">
    <form style="text-align: center" action="/login" method="post">
        <h3>登录</h3>
        <p style="color: red;text-align: center">${msg}</p>
        <div class="form-ctrl">
            <input class="form-control" type="text" placeholder="用户名" name="name" >
        </div>
        <div class="form-ctrl">
            <input class="form-control" type="password" placeholder="请输入密码" name="password"  >
        </div>
        <input type="submit" class="submit" value="提交">
    </form>
</div>

</body>
</html>
