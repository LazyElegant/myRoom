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
                <li class="sq"><a href="/toAddGoods">上架商品</a></li>

                <li class="wd "><a href="/manage">商品管理</a></li>
                <li class="my "><a href="/updatePassword">个人中心</a></li>

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
                    <p>商品名</p>
                </td>
                <td class="goods_num" width="150">
                    <p>金额</p>
                </td>
                <td class="goods_money" width="350">
                    <p>详情</p>
                </td>
                <td class="goods_money" width="250">
                    <input type="text" id="GoodsName" /><input id="cx" type="submit" />
                </td>
            </tr>
            </tbody>
        </table>

        <table class="order_table">
            <tbody>
            <c:forEach items="${goodsList}" var="list">

            <tr class="layui-form">
                <td width="250">
                    <p>${list.getName()}</p>
                </td>
                <td class="goods_num" width="150">
                    <p>${list.getPrice()}</p>
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
        console.log($("#GoodsName").val());
        document.location.href =   "${request.getContextPath()}/getGoods?name="+ $("#GoodsName").val();
    })
</script>
</html>
