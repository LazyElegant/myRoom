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
<div style="margin-top: 30px;padding: 30px;background-color: white;">

    <div class="mauto" style="width: 1166px;padding-bottom: 20px;margin: 0 auto;">
        <table class="order_table">
            <tbody>
            <tr class="layui-form">
                <td width="250">
                    <p>食材名</p>
                </td>
                <td class="goods_num" width="150">
                    <p>数量（千克）</p>
                </td>
                <td class="goods_money" width="350">
                    <p>详情</p>
                </td>
                <td class="goods_money" width="250">
                    <input type="text" id="FoodsName" /><input id="cx" type="submit" />
                </td>
            </tr>
            </tbody>
        </table>

        <table class="order_table">
            <tbody>
            <c:forEach items="${foodsList}" var="list">

            <tr class="layui-form">
                <td width="250">
                    <p>${list.getName()}</p>
                </td>
                <td class="goods_num" width="150">
                    <p>${list.getCount()}</p>
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
</body>
<script>
    $("#cx").click(function () {
        console.log($("#FoodsName").val());
        document.location.href =   "${request.getContextPath()}/getFoods?name="+ $("#FoodsName").val();
    })
</script>
</html>
