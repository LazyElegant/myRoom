<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改student</title>
    <link rel="stylesheet" href="../css/index.css">
</head>
<body>
<form style="margin: 100px 500px" method="post" action="/updateStudent?id=${student.getId()}" >
    姓名：<br> <input value="${student.getName()}" name="name" type="text"><br>
    年龄：<br> <input value="${student.getAge()}" name="age" type="text"><br>
    学号：<br> <input value="${student.getNumber()}" name="number" type="text"><br>
    性别：<br>
    <select style="width: 100px" class="module" name="sex">
        <option value="${student.getSex()}" selected="selected">${student.getSex()}</option>
        <option value="男" >男</option>
        <option value="女" >女</option>
    </select>
    <br>
    <input type="submit">

</form>

</body>
</html>
