<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>首页</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/index.css" />
    <script src="../js/jquery-3.4.1.js"></script>
</head>
<body style="background-color: #f2f2f2;">
<nav class="nav ">
    <div class="w ">
        <div class="navitems ">
            <ul>
                <li class="cb"><a href="/index">首页</a></li>
                <li class="sq"><a href="/toAddOrder">新增订单</a></li>

                <li class="wd "><a href="/manage">订单管理</a></li>
                <li class="my "><a href="/updatePassword">${sessionScope.user.getName()}</a></li>
                <li class="my "><a href="/out">退出登录</a></li>

            </ul>
        </div>
    </div>
</nav>
<div style="margin-top: 30px;padding: 30px;background-color: white;min-height: 400px">

    <div class="mauto" style="width: 1166px;padding-bottom: 20px;margin: 0 auto;">
        <table class="order_table">
            <tbody>
            <tr class="layui-form">
                <td width="250">
                    <p>物品</p>
                </td>
                <td class="goods_num" width="150">
                    <p>数量</p>
                </td>
                <td class="goods_num" width="150">
                    <p>总额</p>
                </td>
                <td class="goods_money" width="350">
                    <p>详情</p>
                </td>
                <td class="goods_money" width="250">
                    <input type="text" id="OrderName" /><input id="cx" type="submit" />
                </td>
            </tr>
            <c:forEach items="${orderList}" var="list">

                <tr class="layui-form">
                    <td width="250">
                        <p>${list.getName()}</p>
                    </td>
                    <td class="goods_num" width="150">
                        <p>${list.getCount()}</p>
                    </td>
                    <td class="goods_money" width="350">
                        <p>${list.getAmount()}</p>
                    </td>
                    <td class="goods_money" width="350">
                        <p>${list.getContent()}</p>
                    </td>
                    <td class="goods_money" width="250">
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
    $("#cx").click(function () {
        console.log($("#OrderName").val());
        document.location.href =   "${request.getContextPath()}/getOrder?name="+ $("#OrderName").val();
    })
</script>
</html>
