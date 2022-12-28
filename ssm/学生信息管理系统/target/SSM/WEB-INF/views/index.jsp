<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="../css/index.css">
</head>
<body>
<table class="order_table">
    <tbody>
    <tr class="layui-form">
        <td width="120">
            <p>id</p>
        </td>
        <td width="120">
            <p>名字</p>
        </td>
        <td width="120">
            <p>年龄</p>
        </td>
        <td class="goods_num" width="120">
            <p>学号</p>
        </td>
        <td class="goods_bag" width="120">
            <p>性别</p>
        </td>
        <td class="goods_money" width="250">
            <p>操作</p>
        </td>
    </tr>
    </tbody>
</table>
<table class="order_table">
    <tbody>
    <c:forEach items="${list}" var="list">
        <tr class="layui-form">
            <td width="120">
                <p>${list.getId()}</p>
            </td>
            <td width="120">
                <p>${list.getName()}</p>
            </td>
            <td width="120">
                <p>${list.getAge()}</p>
            </td>
            <td class="goods_num" width="120">
                <p>${list.getNumber()}</p>
            </td>
            <td class="goods_bag" width="120">
                <p>${list.getSex()}</p>
            </td>
            <td class="goods_money" width="250">
                <a href="/toUpdateStudent?id=${list.getId()}">修改</a>
                <a href="/deleteStudent?id=${list.getId()}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/toStudent" class="add">新增</a>

</body>
</html>
