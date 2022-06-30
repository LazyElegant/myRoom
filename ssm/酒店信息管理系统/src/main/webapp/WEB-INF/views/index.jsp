<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>首页</title>
    <link rel="stylesheet" href="../css/index.css" />
    <script src="../js/jquery-3.4.1.js"></script>
    <style>
        input {
            margin-top: 0px;
        }
    </style>
</head>
<body>
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

    <!-- 轮播图 -->
    <div class="index-banner">
        <div class="carousel_item is_active" style="background:url(../img/9777e857d6df2802.jpg)  no-repeat center center;background-size: 100%;"></div>
    </div>
</div>


<div style="margin-top: 30px;padding: 30px;background-color: white;">

    <div class="mauto" style="width: 1466px;padding-bottom: 20px;margin: 0 auto;">
        <table class="order_table">
            <tbody>
            <tr class="layui-form">
                <td width="300">
                    <p>酒店名</p>
                </td>
                <td width="350">
                    <p>酒店地址</p>
                </td>
                <td width="300">
                    <p>酒店负责人</p>
                </td>
                <td width="300">
                    <p>负责人电话</p>
                </td>
                <td class="goods_money" width="250">
                    <input type="text" id="HotelName" /><input id="cx" type="submit" />
                </td>
            </tr>
            </tbody>
        </table>

        <table class="order_table">
            <tbody>
            <c:forEach items="${hotelList}" var="list">

            <tr class="layui-form">
                <td width="300">
                    <p>${list.getName()}</p>
                </td>
                <td width="350">
                    <p>${list.getAddress()}</p>
                </td>
                <td width="300">
                    <p>${list.getPrincipal()}</p>
                </td>
                <td width="300">
                    <p>${list.getPhone()}</p>
                </td>
                <td width="250">
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div>
</body>
<script>
    $("#cx").click(function () {
        console.log($("#HotelName").val());
        document.location.href =   "${request.getContextPath()}/getHotel?name="+ $("#HotelName").val();
    })
</script>
</html>
