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
<nav class="top ">
    <input type="text" class="search" id="numbers" placeholder="输入订单号查询"/><input id="cx" type="submit" />
    <p class="item">
        <a href="/index">首页</a>
    </p>
    <img class="logo" src="../img/login_logo_v5.png">

    <p class="item">
        <a href="/toAddExpress">添加快递</a>
    </p>
    <p class="item">
        <a href="/manage">快递管理</a>
    </p>
    <p class="item">
        <a href="/updatePassword">${sessionScope.user.getName()}</a>
    </p>
</nav>
<div style="margin-top: 30px;padding: 30px;background-color: white;">

    <div class="mauto" style="width: 1466px;padding-bottom: 20px;margin: 0 auto;">
        <table class="order_table">
            <tbody>
            <tr class="layui-form">
                <td width="250">
                    <p>快递单号</p>
                </td>
                <td width="150">
                    <p>物品</p>
                </td>
                <td width="150">
                    <p>重量（千克）</p>
                </td>
                <td width="150">
                    <p>寄件人</p>
                </td>
                <td width="250">
                    <p>寄件人电话</p>
                </td>
                <td width="250">
                    <p>寄件人地址</p>
                </td>
                <td width="150">
                    <p>收件人</p>
                </td>
                <td width="250">
                    <p>收件人电话</p>
                </td>
                <td width="250">
                    <p>收件人地址</p>
                </td>
                <td width="150">
                    <p>状态</p>
                </td>
            </tr>
            </tbody>
        </table>

        <table class="order_table">
            <tbody>
            <c:forEach items="${expressList}" var="list">

            <tr class="layui-form">
                <td width="250">
                    <p>${list.getNumbers()}</p>
                </td>
                <td width="150">
                    <p>${list.getThing()}</p>
                </td>
                <td width="150">
                    <p>${list.getWeight()}</p>
                </td>
                <td width="150">
                    <p>${list.getSenderName()}</p>
                </td>
                <td width="250">
                    <p>${list.getSenderPhone()}</p>
                </td>
                <td width="250">
                    <p>${list.getSenderAddress()}</p>
                </td>
                <td width="150">
                    <p>${list.getAddresseeName()}</p>
                </td>
                <td width="250">
                    <p>${list.getAddresseePhone()}</p>
                </td>
                <td width="250">
                    <p>${list.getAddresseeAddress()}</p>
                </td>
                <td width="150">
                    <c:if test="${list.getStatus() == 1}">
                        <p> 待收货 </p>
                    </c:if>
                    <c:if test="${list.getStatus() == 2}">
                        <p> 已收货 </p>
                    </c:if>
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
        console.log($("#numbers").val());
        document.location.href =   "${request.getContextPath()}/getExpress?id="+ $("#numbers").val();
    })
</script>
</html>
