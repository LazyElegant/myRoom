<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>student</title>
    <link rel="stylesheet" href="../css/index.css">
</head>
<body>
<form style="margin: 100px 500px" method="post" action="/addStudent" >
    姓名：<br> <input name="name" type="text"><br>
    年龄：<br> <input name="age" type="text"><br>
    学号：<br> <input name="number" type="text"><br>
    性别：<br>
    <select style="width: 100px" class="module" name="sex">
        <option value="男" selected="selected">男</option>
        <option value="女" >女</option>
    </select>
    <br>
    <input type="submit">

</form>

</body>
</html>
